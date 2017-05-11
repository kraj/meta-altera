LINUX_VERSION = "4.10"

SRCREV = "f092d4a902fabdeb9be3f679770a3f6d5f5d7792"

include linux-altera.inc

KERNEL_DEVICETREE_arria10_append ?= " socfpga_arria10_socdk_nand.dtb"
KERNEL_DEVICETREE_cyclone5_append ?= " \
	socfpga_cyclone5_mcvevk.dtb socfpga_cyclone5_sodia.dtb \
	socfpga_cyclone5_trcom.dtb socfpga_cyclone5_vining_fpga.dtb \
	"
