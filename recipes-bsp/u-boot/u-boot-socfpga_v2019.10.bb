require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "7298985146c70ca8af8d43dd963b3e8aa3900d87"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
