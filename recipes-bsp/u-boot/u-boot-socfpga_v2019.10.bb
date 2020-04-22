require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "e151fde377cd74153ea8ea94ea34254f9673899c"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
