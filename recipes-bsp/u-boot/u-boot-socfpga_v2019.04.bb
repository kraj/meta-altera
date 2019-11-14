require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "8c4cd804d6d77fbc4d7201d19755b6e89d43ae65"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
