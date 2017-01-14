require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc
PR="r1"

SRCREV = "95ab599e1ad7840e08be0aa567eea3fca357572f"

UBOOT_BRANCH ?= "socfpga_${PV}"
UBOOT_REPO ?= "git://github.com/altera-opensource/u-boot-socfpga.git"
UBOOT_PROT ?= "https"

SRC_URI = "\
	${UBOOT_REPO};protocol=${UBOOT_PROT};branch=${UBOOT_BRANCH} \
	file://fix-build-error-under-gcc6.patch \
	"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=176c127db28f1a9e8d88f682a2a34963"

DEPENDS += "dtc-native"

UBOOT_CONFIG[cyclone5-socdk] = "socfpga_cyclone5_config"

SPL_BINARY_cyclone5 = "spl/u-boot-spl.bin"                                    
SPL_BINARY_arria5 = "spl/u-boot-spl.bin"
