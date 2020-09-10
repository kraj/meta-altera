DESCRIPTION = "ARM Trusted Firmware"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=189505435dbcdcc8caa63c46fe93fa89"

PROVIDES += "arm-trusted-firmware"

DEPENDS += "u-boot-tools"

inherit deploy

PACKAGE_ARCH = "${MACHINE_ARCH}"

ATF_PROT ?= "https"
ATF_BRANCH ?= "socfpga_v2.3"
ATF_REPO ?= "git://github.com/altera-opensource/arm-trusted-firmware.git"

SRC_URI = "${ATF_REPO};protocol=${ATF_PROT};branch=${ATF_BRANCH}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(agilex|stratix10)"
ATFPLAT = "${MACHINE}"

# Let the Makefile handle setting up the CFLAGS and LDFLAGS as it is a standalone application
EXTRA_OEMAKE = 'CROSS_COMPILE="${TARGET_PREFIX}" PLAT="${ATFPLAT}" DEPRECATED=1 HANDLE_EA_EL3_FIRST=1'
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"
PARALLEL_MAKE = ""

ALLOW_EMPTY_${PN} = "1"

do_configure[noexec] = "1"

do_compile() {
	oe_runmake -C ${S} bl31
}

do_deploy() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${S}/build/${ATFPLAT}/release/bl31.bin ${DEPLOYDIR}/bl31.bin-${MACHINE}-${PV}-${PR}
	ln -sf bl31.bin-${MACHINE}-${PV}-${PR} ${DEPLOYDIR}/bl31.bin
}

addtask deploy after do_compile
