LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "f460e9d5cd820666b7dfbb28349b99976410e4fb"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

