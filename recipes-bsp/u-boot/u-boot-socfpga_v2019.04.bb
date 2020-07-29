require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "6296fdb7da9e205bc34416f38631715fb6d74e71"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
