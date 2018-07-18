DESCRIPTION = "Altera Linux kernel"
LICENSE = "GPLv2"

KERNEL_REPO ?= "git://github.com/altera-opensource/linux-socfpga.git"
KERNEL_PROT ?= "https"

# Kernel CONFIG_LOCALVERSION
LINUX_VERSION_EXTENSION ?= "-altera"

# Build branch name
LINUX_VERSION_PREFIX ?= "socfpga-"
LINUX_VERSION_SUFFIX ?= ""
LINUX_VERSION ?= "4.0"

SRCREV ?= "${AUTOREV}"
SRCREV_machine ?= "${AUTOREV}"
PV = "${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"
PV_append = "+git${SRCPV}"


KBRANCH ?= "${LINUX_VERSION_PREFIX}${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KBRANCH}"

# Default kernel devicetrees
KERNEL_DEVICETREE_cyclone5 ?= "socfpga_cyclone5_socdk.dtb socfpga_cyclone5_sockit.dtb socfpga_cyclone5_socrates.dtb socfpga_cyclone5_de0_sockit.dtb"
KERNEL_DEVICETREE_arria5 ?= "socfpga_arria5_socdk.dtb"
KERNEL_DEVICETREE_arria10 ?= "socfpga_arria10_socdk_sdmmc.dtb socfpga_arria10_socdk_qspi.dtb socfpga_arria10_swvp.dtb"
KERNEL_DEVICETREE_stratix10swvp ?= "altera/stratix10_swvp.dtb"
KERNEL_DEVICETREE_10m50 ?= "10m50_devboard.dtb"

require recipes-kernel/linux/linux-yocto.inc
require linux-altera-configs.inc
