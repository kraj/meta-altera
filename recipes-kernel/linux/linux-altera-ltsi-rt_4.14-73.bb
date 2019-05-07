LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "161bfaffb6fca6b1d0476956b2e31620645f6f08"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

