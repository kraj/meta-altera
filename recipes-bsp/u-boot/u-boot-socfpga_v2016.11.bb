require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# This revision corresponds to the tag "v2016.11"
# We use the revision in order to avoid having to fetch it from the
# repo during parse 
SRCREV = "29e0cfb4f77f7aa369136302cee14a91e22dca71"

DEPENDS += "dtc-native"
