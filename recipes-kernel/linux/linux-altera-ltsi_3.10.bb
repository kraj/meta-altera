LINUX_VERSION = "3.10"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "22e8856f546423a4f45613c9fb0428ff9e395c7e"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5.dtb"
KERNEL_DEVICETREE_arria5 ?= "socfpga_arria5.dtb"

include linux-altera.inc
