HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

PV_append = "+git${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master"

S = "${WORKDIR}/git"

RPROVIDES_${PN} += "u-boot" 
