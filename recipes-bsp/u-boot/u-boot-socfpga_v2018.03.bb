require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2018.03:"

SRCREV = "f95ab1fb6e37f0601f397091bb011edf7a98b890"

SRC_URI_append = "\
	"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
