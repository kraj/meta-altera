LINUX_VERSION = "4.14.130"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "cae629555019eb0d3f63d9e8e639a982e994e80f"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

