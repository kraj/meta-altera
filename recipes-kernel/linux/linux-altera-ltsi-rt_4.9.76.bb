LINUX_VERSION = "4.9.76"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "a1be37b8d058805f7bbda42655727552c1e36c43"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

