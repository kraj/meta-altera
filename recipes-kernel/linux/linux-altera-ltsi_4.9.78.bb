LINUX_VERSION = "4.9.78"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "57047883442e58369cde6c8f8f710f7c91fcbfbe"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

