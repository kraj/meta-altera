require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2018.05:"

SRCREV = "890e79f2b1c26c5ba1a86d179706348aec7feef7"

SRC_URI_append = "\
    "

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
