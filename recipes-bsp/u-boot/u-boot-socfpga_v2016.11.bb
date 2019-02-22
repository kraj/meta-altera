require u-boot-socfpga-common.inc
require u-boot-socfpga-env.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2016.11:"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

# This revision corresponds to the tag "v2016.11"
# We use the revision in order to avoid having to fetch it from the
# repo during parse 
SRCREV = "29e0cfb4f77f7aa369136302cee14a91e22dca71"

PR = "r1"

SRC_URI_append = "\
	file://de0-nano-soc.env \
	file://cyclone5-socdk.env \
	"

DEPENDS += "dtc-native bc-native"
DEPENDS += "u-boot-mkimage-native"
