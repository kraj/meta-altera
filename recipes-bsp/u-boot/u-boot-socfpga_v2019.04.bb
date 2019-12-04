require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "0c3e6f623d87899448191f2cffb761b7e7a8c5d5"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
