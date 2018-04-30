LINUX_VERSION = "4.9.76"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "1d046f6a4d9d2bf7b03ba279e1dedff461ee2505"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

