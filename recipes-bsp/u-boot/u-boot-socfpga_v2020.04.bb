require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2020.04"
SRCREV = "2cbc36afbb31bee6e245291c51c283dbde0e3b89"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
