require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.04"
SRCREV = "83e929c739beecff17529a0cf0fdd5c74fbe3c72"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
