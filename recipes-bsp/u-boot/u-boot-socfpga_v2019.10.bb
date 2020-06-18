require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "72bbbc5eeeafe69bcee85f288a112e7cfab3edff"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
