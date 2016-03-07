LINUX_VERSION = "4.3"

SRCREV = "5938523338cab45f68bc89e033e50d0a68d1772f"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5_socdk.dtb socfpga_cyclone5_sockit.dtb socfpga_cyclone5_socrates.dtb socfpga_cyclone5_de0_sockit.dtb"

include linux-altera.inc
