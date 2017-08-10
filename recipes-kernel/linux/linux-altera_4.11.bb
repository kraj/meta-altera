LINUX_VERSION = "4.11"

SRCREV = "d0851166caa4ba9f6e2923ffa37f476ebb99e9a0"

include linux-altera.inc

KERNEL_DEVICETREE_arria10_append ?= " socfpga_arria10_socdk_nand.dtb"
KERNEL_DEVICETREE_cyclone5_append ?= " \
	socfpga_cyclone5_mcvevk.dtb socfpga_cyclone5_sodia.dtb \
	socfpga_cyclone5_trcom.dtb socfpga_cyclone5_vining_fpga.dtb \
	"
