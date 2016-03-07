LINUX_VERSION = "4.1"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "1224831d560bf5c1a215220548163d8663a30ecb"

KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5_socdk.dtb socfpga_cyclone5_sockit.dtb socfpga_cyclone5_socrates.dtb socfpga_cyclone5_de0_sockit.dtb"

include linux-altera.inc
