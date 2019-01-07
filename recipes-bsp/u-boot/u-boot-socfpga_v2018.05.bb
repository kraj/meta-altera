require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2018.05:"

SRCREV = "890e79f2b1c26c5ba1a86d179706348aec7feef7"

SRC_URI_append = "\
    "

# Some versions of u-boot use .bin and others use .img.
# By default we use .sfp as this is what is generated
# for Cyclone V by the U-Boot.
UBOOT_SUFFIX = "sfp"
UBOOT_BINARY = "u-boot-with-spl.${UBOOT_SUFFIX}"

UBOOT_MAKE_TARGET ?= "all"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
