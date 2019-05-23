require conf/machine/include/arm/arch-armv8.inc

KERNEL_PROVIDER ?= "linux-altera"
PREFERRED_PROVIDER_virtual/kernel ?= "${KERNEL_PROVIDER}"
KERNEL_IMAGETYPE = "Image"
MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-socfpga"

SPL_BINARY = "spl/u-boot-spl-dtb.hex"
UBOOT_SUFFIX = "img"
UBOOT_BINARY = "u-boot-dtb.img"
UBOOT_IMAGE = "u-boot-dtb-${MACHINE}-${PV}-${PR}.${UBOOT_SUFFIX}"

IMAGE_FSTYPES ?= "cpio ext3 tar.gz"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot virtual/bootloader:do_deploy virtual/kernel:do_deploy"
