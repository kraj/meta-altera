LINUX_VERSION = "4.1"

SRCREV = "6de99ee01c82b4b1d407f1393fe7d5413b5855cf"

# There is no de0 devicetree in this kernel version
KERNEL_DEVICETREE_remove_cyclone5 = "socfpga_cyclone5_de0_sockit.dtb"

include linux-altera.inc
