require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "34638cc921269665e43340a50552302bd358f793"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
