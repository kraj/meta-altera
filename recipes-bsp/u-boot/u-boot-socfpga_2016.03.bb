require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# This revision is the v2016.03 release
SRCREV = "df61a74e6845ec9bdcdd48d2aff5e9c2c6debeaa"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV = "2016.03"
PV_append = "+git${SRCPV}"

DEPENDS += "dtc-native"



