require u-boot-socfpga-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

# This revision corresponds to the tag "v2016.05"
# We use the revision in order to avoid having to fetch it from the
# repo during parse 
SRCREV = "aeaec0e682f45b9e0c62c522fafea353931f73ed"
PR = "r1"
DEPENDS += "dtc-native"
