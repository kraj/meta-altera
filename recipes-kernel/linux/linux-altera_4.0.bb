LINUX_VERSION = "4.0"

SRCREV = "5d36469775e2b77a33e778d1b606edfc5ed13bd4"

# There is no de0 devicetree in this kernel version
KERNEL_DEVICETREE_remove_cyclone5 = "socfpga_cyclone5_de0_sockit.dtb"

include linux-altera.inc
