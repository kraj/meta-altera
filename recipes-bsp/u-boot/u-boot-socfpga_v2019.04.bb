require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "b36ff5c2ecb55c64a08a2dc4e5cbd24e8bf2982c"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
