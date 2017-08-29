require u-boot-socfpga-common.inc
require u-boot-socfpga-env.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2017.07:"

# This revision corresponds to the tag "v2017.07"
# We use the revision in order to avoid having to fetch it from the
# repo during parse 
SRCREV = "d85ca029f257b53a96da6c2fb421e78a003a9943"

SRC_URI_append = "\
	file://de0-nano-soc.env \
	file://cyclone5-socdk.env \
	"

DEPENDS += "dtc-native bc-native u-boot-mkimage-native"
