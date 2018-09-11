LINUX_VERSION = "4.9.78"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "e681fba61a85fa13e546bba277083c49c091e361"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

