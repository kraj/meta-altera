require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "bc38a09daa09e73b075006d8006caa84bb2fe0fe"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
