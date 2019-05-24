LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "131204456ebb790580e8f18d615ace53bcb9caa3"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

