LINUX_VERSION = "4.14.130"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "cae629555019eb0d3f63d9e8e639a982e994e80f"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append:cyclone5 = " file://lbdaf.scc \
	file://0001-Rename-de0_sockit-devicetree-to-de0_nano_soc.patch"
SRC_URI:append:arria5 = " file://lbdaf.scc "
SRC_URI:append:arria10 = " file://lbdaf.scc "

