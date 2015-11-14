LINUX_VERSION = "3.10"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "bcf9c6441ec6e785ec1c829b4650a582b5e7559e"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5.dtb"
KERNEL_DEVICETREE_arria5 ?= "socfpga_arria5.dtb"

include linux-altera.inc
