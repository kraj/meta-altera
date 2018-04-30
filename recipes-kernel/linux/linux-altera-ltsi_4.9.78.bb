LINUX_VERSION = "4.9.78"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "23147125756d1ebddfdda416bce5b75b9d01f18d"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

