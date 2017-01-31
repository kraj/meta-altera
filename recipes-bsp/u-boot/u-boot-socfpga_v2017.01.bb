require u-boot-socfpga-common.inc
require u-boot-socfpga-env.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS =. "${THISDIR}/files/v2017.01:"

# This revision corresponds to the tag "v2017.01"
# We use the revision in order to avoid having to fetch it from the
# repo during parse 
SRCREV = "a705ebc81b7f91bbd0ef7c634284208342901149"

DEPENDS += "dtc-native"
DEPENDS += "u-boot-mkimage-native"
