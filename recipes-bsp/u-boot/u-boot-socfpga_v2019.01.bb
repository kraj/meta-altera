require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

FILESEXTRAPATHS =. "${THISDIR}/files/v2019.01:"

SRCREV = "d3689267f92c5956e09cc7d1baa4700141662bff"

SRC_URI_append = "\
    "

DEPENDS += "dtc-native bc-native bison-native u-boot-mkimage-native"
