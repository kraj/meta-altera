LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "0d1cf8883fc9177ed74d576dbf18e32e49b2942d"

include linux-altera.inc

KERNEL_DEVICETREE_arria10_append ?= " socfpga_arria10_socdk_nand.dtb"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

