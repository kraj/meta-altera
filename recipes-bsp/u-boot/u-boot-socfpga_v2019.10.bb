require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2019.10"
SRCREV = "f5efc1065709740b38c32281745c8dbc5edf7365"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
