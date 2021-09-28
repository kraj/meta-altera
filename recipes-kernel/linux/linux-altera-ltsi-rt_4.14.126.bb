LINUX_VERSION = "4.14.126"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "652711a08dbe255d0aa3c2dd7231d6c6bfc61817"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "

