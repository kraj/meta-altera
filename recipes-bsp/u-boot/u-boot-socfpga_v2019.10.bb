require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "5f855b33715cade5b5aa6657f0f9cd7f7a5e0bb6"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
