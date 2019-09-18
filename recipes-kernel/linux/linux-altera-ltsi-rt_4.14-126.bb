LINUX_VERSION = "4.14.126"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "12c13b097fcd474176c9b99a2efbeadbaf5fc9db"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

