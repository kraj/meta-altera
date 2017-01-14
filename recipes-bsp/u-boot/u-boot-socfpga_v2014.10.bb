require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc
PR="r1"
# This revision corresponds to the SoCEDS 16.1 release
SRCREV = "ab2181dd766157a74b309d12e0b61c4f3cdc8564"

UBOOT_BRANCH ?= "socfpga_${PV}_arria10_bringup"
UBOOT_REPO ?= "git://github.com/altera-opensource/u-boot-socfpga.git"
UBOOT_PROT ?= "https"

SRC_URI = "\
	${UBOOT_REPO};protocol=${UBOOT_PROT};branch=${UBOOT_BRANCH} \
	file://fix-build-error-under-gcc6.patch \
	"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

DEPENDS += "dtc-native"

UBOOT_BINARY = "u-boot-dtb.bin"

