HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV_append = "+git${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master"

S = "${WORKDIR}/git"

RPROVIDES_${PN} += "u-boot" 
