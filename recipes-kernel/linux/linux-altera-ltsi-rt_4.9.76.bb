LINUX_VERSION = "4.9.76"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "b72a6bc15141146d5f3aa95fbcbde96e00b6e77c"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

