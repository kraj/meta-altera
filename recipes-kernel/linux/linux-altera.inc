PR = "r1"

KERNEL_REPO ?= "git://git.rocketboards.org/linux-socfpga.git"
KERNEL_PROT ?= "http"
KERNEL_DEFCONFIG ?= "socfpga_defconfig"
KERNEL_TAG ?= "${AUTOREV}"

SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KERNEL_BRANCH}"

SRCREV_pn-${PN} = "${KERNEL_TAG}"

inherit kernel
SECTION = "kernel"
DESCRIPTION = "Altera Linux kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

S = "${WORKDIR}/git"

MACHINE_DEFCONFIG = "${KERNEL_DEFCONFIG}"

do_configure() {
	export INITRAMFS_IMAGE_FILE="${INITRAMFS_IMAGE}-${MACHINE}.cpio"

	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	export CROSS_COMPILE="${TARGET_PREFIX}"
	export ARCH=${ARCH}
	
	oe_runmake ${MACHINE_DEFCONFIG} CONFIG_BLK_DEV_INITRD=y
	
	cp .config .config.ori

	grep CONFIG_BLK_DEV_INITRD .config || echo "CONFIG_BLK_DEV_INITRD=y" >> .config
	grep CONFIG_INITRAMFS_SOURCE .config || echo "CONFIG_INITRAMFS_SOURCE=\"\"" >> .config
	grep CONFIG_INITRAMFS_ROOT_UID .config || echo "CONFIG_INITRAMFS_ROOT_UID=0" >> .config
	grep CONFIG_INITRAMFS_ROOT_GID .config || echo "CONFIG_INITRAMFS_ROOT_GID=0" >> .config
	grep CONFIG_INITRAMFS_COMPRESSION_NONE .config || echo "CONFIG_INITRAMFS_COMPRESSION_NONE=y" >> .config

	if [ ! -z ${INITRAMFS_IMAGE} ] && [ -e ${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE_FILE} ]; then
		cp ${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE_FILE} .
		echo "Found valid initramfs ${INITRAMFS_IMAGE_FILE}"
		sed -i "s|^.*CONFIG_BLK_DEV_INITRD[ =].*$|CONFIG_BLK_DEV_INITRD=y|g" .config
		sed -i "s|^.*CONFIG_INITRAMFS_SOURCE[ =].*$|CONFIG_INITRAMFS_SOURCE=\"${INITRAMFS_IMAGE_FILE}\"|g" .config
		sed -i "s|^.*CONFIG_INITRAMFS_ROOT_UID[ =].*$|CONFIG_INITRAMFS_ROOT_UID=0|g" .config
		sed -i "s|^.*CONFIG_INITRAMFS_ROOT_GID[ =].*$|CONFIG_INITRAMFS_ROOT_GID=0|g" .config
		sed -i "s|^.*CONFIG_INITRAMFS_COMPRESSION_NONE[ =].*$|CONFIG_INITRAMFS_COMPRESSION_NONE=y|g" .config
		oe_runmake oldconfig
	else
		rm -f *.cpio
		echo "Initramfs disabled or can't find valid initramfs ${INITRAMFS_IMAGE_FILE}"
		sed -i "s|^CONFIG_BLK_DEV_INITRD=.*$|# CONFIG_BLK_DEV_INITRD is not set|g" .config
		sed -i "s|^CONFIG_INITRAMFS_SOURCE=\".*\"$|# CONFIG_INITRAMFS_SOURCE is not set|g" .config
		sed -i "s|^CONFIG_INITRAMFS_ROOT_UID=.*$|# CONFIG_INITRAMFS_ROOT_UID is not set|g" .config
		sed -i "s|^CONFIG_INITRAMFS_ROOT_GID=.*$|# CONFIG_INITRAMFS_ROOT_GID is not set|g" .config
		sed -i "s|^CONFIG_INITRAMFS_COMPRESSION_NONE=.*$|# CONFIG_INITRAMFS_COMPRESSION_NONE is not set|g" .config
		oe_runmake oldconfig
	fi	
}

kernel_do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
        oe_runmake __headers CC="${KERNEL_CC}" LD="${KERNEL_LD}"
        oe_runmake ${KERNEL_IMAGETYPE_FOR_MAKE} ${KERNEL_ALT_IMAGETYPE} CC="${KERNEL_CC}" LD="${KERNEL_LD}" LOADADDR=0x8000
        if test "${KERNEL_IMAGETYPE_FOR_MAKE}.gz" = "${KERNEL_IMAGETYPE}"; then
                gzip -9c < "${KERNEL_IMAGETYPE_FOR_MAKE}" > "${KERNEL_OUTPUT}"
        fi
}

do_compile_dtb() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	sync
        oe_runmake ARCH=${ARCH} CROSS_COMPILE="${TARGET_PREFIX}" dtbs ||
	        oe_runmake ARCH=${ARCH} CROSS_COMPILE="${TARGET_PREFIX}" dtbs
}

addtask compile_dtb after do_compile before do_build

KERNEL_DEVICETREE ?= "socfpga_vt socfpga_cyclone5 socfpga_arria5"

do_deploy_dtb() {
    install -d ${DEPLOY_DIR_IMAGE}
    cd ${DEPLOY_DIR_IMAGE}
    if test -n "${KERNEL_DEVICETREE}"; then
        for DTB_FILE in ${KERNEL_DEVICETREE}; do
	    DTB_SYMLINK_NAME="${DTB_FILE}.dtb"
	    DEVICE_TREE_OUTPUT="${S}/arch/${ARCH}/boot/${DTB_SUBDIR}${DTB_FILE}.dtb"
            DTB_NAME="${DTB_FILE}-${DATETIME}.dtb"
            if [ ! -f ${DEVICE_TREE_OUTPUT} ]; then
                echo "Warning: ${DEVICE_TREE_OUTPUT} is not available!"
                continue
            fi
            install -m 0644 ${DEVICE_TREE_OUTPUT} ${DTB_NAME}
            rm -f ${DTB_SYMLINK_NAME}
            ln -sf ${DTB_NAME} ${DTB_SYMLINK_NAME}
       done
    fi
}

addtask deploy_dtb after do_compile_dtb before do_build

VMLINUX_NAME ?= "vmlinux-${PV}-${PR}-${MACHINE}-${DATETIME}"

kernel_do_deploy_append() {
	install -m 0644 ${S}/vmlinux ${DEPLOYDIR}/${VMLINUX_NAME}
	cd ${DEPLOYDIR} &&
		rm -f vmlinux &&
		ln -sf ${VMLINUX_NAME} vmlinux
}

