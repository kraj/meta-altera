inherit image_types

# Create an sdcard image suitable for the atlas board
# This is copied from the raspberrypi and freescale sdcard classes

# Disk layout
#    0                      -> 8*1024                           - reserverd
#    8*1024                 -> 32*1024                          - 
#    32*1024                -> 1024*1024                        - 
#    1024*1024              -> BOOT_SPACE                       - bootloader and kernel in Part 3
#    BOOT_SPACE*1024        -> FAT_SPACE



# This image depends on the rootfs image
IMAGE_TYPEDEP_socfpga-sdimg = "${SDIMG_ROOTFS_TYPE}"

# Boot partition volume id
BOOTDD_VOLUME_ID ?= "${MACHINE}"

# Boot partition size [in KiB] -> size 2M for A10
BOOT_SPACE ?= "2048"

# Fat partition size
FAT_SPACE ?= "102400"

# uBoot ENV offset
SDIMG_UBOOT_ENV_OFFSET ?= "512"
ENV_BASE_NAME ??= "${UBOOT_CONFIG}" 

# Boot partition begin at sector 1024
# This is required as for c5/a5 mainline uboot hard codes the location
# of the uboot image in the sdcard to 0xa00 sector
IMAGE_ROOTFS_ALIGNMENT = "1024"

# ROOTFS_SIZE_MOD ?= "524288"
ROOTFS_SIZE_MOD ?= "16384"

# Use an uncompressed ext3 by default as rootfs
SDIMG_ROOTFS_TYPE = "ext3"
SDIMG_ROOTFS = "${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.${SDIMG_ROOTFS_TYPE}"


IMAGE_DEPENDS_socfpga-sdimg += " \
			parted-native \
			mtools-native \
			dosfstools-native \
			virtual/kernel \
			virtual/bootloader \
			"
			
rootfs[depends] += "virtual/kernel:do_deploy"

# SD card image name
SDIMG = "${IMGDEPLOYDIR}/${IMAGE_NAME}.rootfs.socfpga-sdimg"

IMAGEDATESTAMP = "${@time.strftime('%Y.%m.%d',time.gmtime())}"

# After uboot v2016.05 the boot partition number was changed from 3 to 1 so as a
# result we need 2 different functions for creating the boot partitions just to
# change the partition creation order

SOCFPGA_SDIMG_PARTITION_COMMAND ?= "generate_sdcard_partitions"

generate_sdcard_partitions () {

	# Create partition table
	parted -s ${SDIMG} mklabel msdos
	# P1: Fat partition
	parted -s ${SDIMG} unit KiB mkpart primary fat32 $(expr  ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED}) $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} \+ ${FAT_SPACE_ALIGNED})
	# set fat partition as bootable for distroboot
	parted -s ${SDIMG} set 1 boot on
	# P2: Linux FS partition
	parted -s ${SDIMG} unit KiB mkpart primary $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} \+ ${FAT_SPACE_ALIGNED}) $(expr ${IMAGE_ROOTFS_ALIGNMENT} \+ ${BOOT_SPACE_ALIGNED} \+ ${FAT_SPACE_ALIGNED} \+ ${ROOTFS_SIZE_ALIGNED})
	# P3: A2 partition for bootloader
	parted -s ${SDIMG} unit KiB mkpart primary ${IMAGE_ROOTFS_ALIGNMENT} $(expr ${BOOT_SPACE_ALIGNED} \+ ${IMAGE_ROOTFS_ALIGNMENT})

	# set part 3 to type a2 for spl / uboot image
	# 446 to partition table, 16 bytes per entry, 4 byte offset to partition type
	echo -ne "\xa2" | dd of=${SDIMG} bs=1 count=1 seek=$(expr 446 + 16 + 16 + 4) conv=notrunc && sync && sync
	
	# Create a vfat image with boot files
	FAT_BLOCKS=$(LC_ALL=C parted -s ${SDIMG} unit b print | awk '/ 1 / { print substr($4, 1, length($4 -1)) / 512 /2 }')
	rm -f ${WORKDIR}/fat.img
	mkfs.vfat -n "${BOOTDD_VOLUME_ID}" -S 512 -C ${WORKDIR}/fat.img $FAT_BLOCKS
	
}

IMAGE_CMD_socfpga-sdimg () {

	# Align partitions
	BOOT_SPACE_ALIGNED=$(expr ${BOOT_SPACE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1)
	BOOT_SPACE_ALIGNED=$(expr ${BOOT_SPACE_ALIGNED} - ${BOOT_SPACE_ALIGNED} % ${IMAGE_ROOTFS_ALIGNMENT})
	FAT_SPACE_ALIGNED=$(expr ${FAT_SPACE} + ${IMAGE_ROOTFS_ALIGNMENT} - 1)  
	FAT_SPACE_ALIGNED=$(expr ${FAT_SPACE_ALIGNED} - ${FAT_SPACE_ALIGNED} % ${IMAGE_ROOTFS_ALIGNMENT})
	
	ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE} \+ ${ROOTFS_SIZE_MOD})
	ROOTFS_SIZE_ALIGNED=$(expr ${ROOTFS_SIZE_ALIGNED} \- ${ROOTFS_SIZE_ALIGNED} \% ${ROOTFS_SIZE_MOD})
	
	SDIMG_SIZE=$(expr ${IMAGE_ROOTFS_ALIGNMENT} + ${BOOT_SPACE_ALIGNED} + ${FAT_SPACE_ALIGNED} + ${ROOTFS_SIZE_ALIGNED} + ${IMAGE_ROOTFS_ALIGNMENT})
	
	# Initialize sdcard image file
	dd if=/dev/zero of=${SDIMG} bs=1 count=0 seek=$(expr 1024 \* ${SDIMG_SIZE}) && sync && sync
	
	# Create partition table
	${SOCFPGA_SDIMG_PARTITION_COMMAND}

	# Copy kernel image
	mcopy -i ${WORKDIR}/fat.img -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin ::/${KERNEL_IMAGETYPE}
	
	# Copy boot scripts
	if [ -e "${DEPLOY_DIR_IMAGE}/${MACHINE}.scr" ]
	then
		mcopy -i ${WORKDIR}/fat.img -s ${DEPLOY_DIR_IMAGE}/${MACHINE}.scr ::/u-boot.scr
	fi
	
	# Copy device tree file
	if test -n "${KERNEL_DEVICETREE}"; then
		for DTS_FILE in ${KERNEL_DEVICETREE}; do
			DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`
			if [ -e "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb" ]; then
				kernel_bin="`readlink ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin`"
				kernel_bin_for_dtb="`readlink ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb | sed "s,$DTS_BASE_NAME,${MACHINE},g;s,\.dtb$,.bin,g"`"
				if [ $kernel_bin = $kernel_bin_for_dtb ]; then
					mcopy -i ${WORKDIR}/fat.img -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTS_BASE_NAME}.dtb ::/${DTS_BASE_NAME}.dtb
				fi
			fi
		done
	fi

	# copy extlinux stuff
	if [ "${UBOOT_EXTLINUX}" = "1" ]
	then
		if [ -e "${DEPLOY_DIR_IMAGE}/extlinux.conf" ]
		then
			rm -Rf ${WORKDIR}/extlinux
			mkdir ${WORKDIR}/extlinux
			cp ${DEPLOY_DIR_IMAGE}/extlinux.conf ${WORKDIR}/extlinux/
			mcopy -i ${WORKDIR}/fat.img -s ${WORKDIR}/extlinux ::/
		fi
		
	fi

	# copy any files listed as extra files
	if test -n "${SOCFPGA_SDIMG_EXTRA_FILES}"; then 
		for EXTRA_FILE in ${SOCFPGA_SDIMG_EXTRA_FILES}; do
			if [ -e "${DEPLOY_DIR_IMAGE}/${EXTRA_FILE}" ]; then
				mcopy -i ${WORKDIR}/fat.img -s ${DEPLOY_DIR_IMAGE}/${EXTRA_FILE} ::/${EXTRA_FILE}
			fi
		done
	fi

	# Add stamp file
	echo "${IMAGE_NAME}-${IMAGEDATESTAMP}" > ${WORKDIR}/image-version-info
	mcopy -i ${WORKDIR}/fat.img -v ${WORKDIR}//image-version-info ::

	# Burn Partitions
	dd if=${WORKDIR}/fat.img of=${SDIMG} conv=notrunc seek=1 bs=$(expr 1024 \* ${BOOT_SPACE_ALIGNED} \+ ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
	# If SDIMG_ROOTFS_TYPE is a .xz file use xzcat
	if echo "${SDIMG_ROOTFS_TYPE}" | egrep -q "*\.xz"
	then
		xzcat ${SDIMG_ROOTFS} | dd of=${SDIMG} conv=notrunc seek=1 bs=$(expr 1024 \* ${BOOT_SPACE_ALIGNED} + 1024 \* ${FAT_SPACE_ALIGNED} \+ ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
	else
		dd if=${SDIMG_ROOTFS} of=${SDIMG} conv=notrunc seek=1 bs=$(expr 1024 \* ${BOOT_SPACE_ALIGNED} + 1024 \* ${FAT_SPACE_ALIGNED} \+ ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
	fi

	if [ -e "${DEPLOY_DIR_IMAGE}/${SPL_BINARY}-${UBOOT_CONFIG}" ]
	then
            dd if=${DEPLOY_DIR_IMAGE}/${SPL_BINARY}-${UBOOT_CONFIG} of=${SDIMG} conv=notrunc seek=1 bs=$(expr ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
	elif [ -e "${DEPLOY_DIR_IMAGE}/${SPL_BINARY}" ]
	then
            dd if=${DEPLOY_DIR_IMAGE}/${SPL_BINARY} of=${SDIMG} conv=notrunc seek=1 bs=$(expr ${IMAGE_ROOTFS_ALIGNMENT} \* 1024) && sync && sync
	else
            bbfatal "${SPL_BINARY} does not exist."
	fi
	
	if [ -e "${DEPLOY_DIR_IMAGE}/u-boot-env-${ENV_BASE_NAME}.bin" ]; then 
		dd if=${DEPLOY_DIR_IMAGE}/u-boot-env-${ENV_BASE_NAME}.bin of=${SDIMG} conv=notrunc bs=1 seek=${SDIMG_UBOOT_ENV_OFFSET} && sync && sync
	fi
	
}
