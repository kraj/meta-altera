LINUX_VERSION = "4.19"

SRCREV = "e3b47dd63c0f7f7404bb6a368c1d671e0d199745"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_DEVICETREE_arria10_append ?= " socfpga_arria10_socdk_nand.dtb"
KERNEL_DEVICETREE_cyclone5_append ?= " \
	socfpga_cyclone5_mcvevk.dtb socfpga_cyclone5_sodia.dtb \
	socfpga_cyclone5_trcom.dtb socfpga_cyclone5_vining_fpga.dtb \
	"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

