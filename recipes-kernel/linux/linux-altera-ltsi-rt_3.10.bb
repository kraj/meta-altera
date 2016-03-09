LINUX_VERSION = "3.10"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "5d6c0ba8572262c29ea3d97fe6d1d5b58650b6e5"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5.dtb"
KERNEL_DEVICETREE_arria5 ?= "socfpga_arria5.dtb"

include linux-altera.inc
