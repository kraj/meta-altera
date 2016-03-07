LINUX_VERSION = "4.2"

SRCREV = "be211eb308a6383da2042863ac070bc6e7d0add2"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5_socdk.dtb socfpga_cyclone5_sockit.dtb socfpga_cyclone5_socrates.dtb socfpga_cyclone5_de0_sockit.dtb"

include linux-altera.inc
