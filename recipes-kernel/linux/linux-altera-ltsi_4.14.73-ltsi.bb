LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "3286950e98c92d8594145d8b96a06cbc9700e1d6"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

