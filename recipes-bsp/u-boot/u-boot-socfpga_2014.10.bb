UBOOT_SUFFIX ?= "img"
UBOOT_RAW_BINARY ?= "u-boot-dtb.bin"
UBOOT_DTB ?= "u-boot.dtb"

require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

S = "${WORKDIR}/git"

# SPL (Second Program Loader) to be loaded over UART
SPL_UART_BINARY ?= ""
SPL_UART_IMAGE ?= "${SPL_UART_BINARY}-${MACHINE}-${PV}-${PR}"
SPL_UART_SYMLINK ?= "${SPL_UART_BINARY}-${MACHINE}"

do_deploy_append () {
    install ${S}/${UBOOT_RAW_BINARY} ${DEPLOYDIR}/${UBOOT_RAW_BINARY}
    install ${S}/${UBOOT_DTB} ${DEPLOYDIR}/${UBOOT_DTB}
}

# DEPEND on dtc-native for mainline u-boot because the mainline u-boot depends
# on some of the latest syntax constructs for an appended in dtb used for
# items like secure boot/image signing.
DEPENDS += "dtc-native"

DESCRIPTION = "Mainline u-boot bootloader"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PV = "v2014.10"

UBOOT_BRANCH ?= "socfpga_${PV}_arria10_bringup"
UBOOT_REPO ?= "git://github.com/altera-opensource/u-boot-socfpga.git"
UBOOT_PROT ?= "https"

SRC_URI = "${UBOOT_REPO};protocol=${UBOOT_PROT};branch=${UBOOT_BRANCH}"

SRCREV = "${AUTOREV}"

