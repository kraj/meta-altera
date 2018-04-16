LINUX_VERSION = "4.9.78"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "33ecb3dca9f3d71fe6028725b77a452598610024"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

