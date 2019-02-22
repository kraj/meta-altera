require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2018.05:"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRCREV = "890e79f2b1c26c5ba1a86d179706348aec7feef7"

SRC_URI_append = "\
    "

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
