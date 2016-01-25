LINUX_VERSION = "3.10"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "60a76aa2263ad809131c39181cc2c97c2949ecad"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5.dtb"
KERNEL_DEVICETREE_arria5 ?= "socfpga_arria5.dtb"

include linux-altera.inc
