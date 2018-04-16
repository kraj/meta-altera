SOC_FAMILY = "socfpga"

require conf/machine/include/tune-cortexa9.inc

# this variable specifies the kernel to be built: linux-altera or linux-altera-ltsi
# this affects the PREFERRED_PROVIDER of virtual/kernel
# it can be overriden from the environment, using BB_ENV_EXTRAWHITE
KERNEL_PROVIDER ?= "linux-altera-ltsi"
PREFERRED_PROVIDER_virtual/kernel ?= "${KERNEL_PROVIDER}"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-socfpga"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

SERIAL_CONSOLE = "115200 ttyS0"

KERNEL_IMAGETYPE = "zImage"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules"
MACHINE_FEATURES = "kernel26"

# file system images required
IMAGE_FSTYPES ?= "cpio ext3 tar.gz"

# u-boot setup
UBOOT_SUFFIX = "img"

# AV and CV uBoot + SPL mkpimage type binary
SPL_BINARY_cyclone5 = "u-boot-with-spl.sfp"
SPL_BINARY_arria5 = "u-boot-with-spl.sfp"

# Set extlinux.conf up
UBOOT_EXTLINUX ??= "0"
UBOOT_EXTLINUX_ROOT ?= "root=/dev/mmcblk0p2"
UBOOT_EXTLINUX_LABELS ?= "default"
UBOOT_EXTLINUX_CONSOLE ?= "earlycon"
UBOOT_EXTLINUX_MENU_DESCRIPTION_default ?= "Linux Default"
UBOOT_EXTLINUX_KERNEL_IMAGE_default ?= "../${KERNEL_IMAGETYPE}"
UBOOT_EXTLINUX_FDTDIR_default ??= "../"
UBOOT_EXTLINUX_KERNEL_ARGS_default ??= "rootwait rw"

# Add default variables for wic creation of sdcard image
IMAGE_BOOT_FILES ?= " \
	${KERNEL_DEVICETREE} \
	${KERNEL_IMAGETYPE} \
	"

WKS_FILE ?= "sdimage-cyclone5-arria5.wks"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot virtual/bootloader:do_deploy virtual/kernel:do_deploy"


