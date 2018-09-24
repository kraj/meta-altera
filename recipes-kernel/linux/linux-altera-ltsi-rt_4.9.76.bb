LINUX_VERSION = "4.9.76"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "99b7c8bb809c9c2ae2a2a2a022a5c29ba7619af4"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

