HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native dtc-native bc-native u-boot-mkimage-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

UBOOT_REPO ?= "git://github.com/altera-opensource/u-boot-socfpga.git"
UBOOT_PROT ?= "https"

UBOOT_VERSION_PREFIX ?= "socfpga_"
UBOOT_VERSION ?= "v2019.10"
UBOOT_BRANCH ?= "${UBOOT_VERSION_PREFIX}${UBOOT_VERSION}"

SRCREV ?= "${AUTOREV}"
PV_append = "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

RPROVIDES_${PN} += "u-boot"

SRC_URI = "${UBOOT_REPO};protocol=${UBOOT_PROT};branch=${UBOOT_BRANCH}"

UBOOT_CONFIG[agilex-socdk] = "socfpga_agilex_defconfig"
UBOOT_CONFIG[agilex-socdk-atf] = "socfpga_agilex_atf_defconfig"
UBOOT_CONFIG[agilex-socdk-qspi] = "socfpga_agilex_qspi_defconfig"
UBOOT_CONFIG[agilex-socdk-qspi-atf] = "socfpga_agilex_qspi_atf_defconfig"
UBOOT_CONFIG[stratix10-socdk] = "socfpga_stratix10_defconfig"
UBOOT_CONFIG[stratix10-socdk-atf] = "socfpga_stratix10_atf_defconfig"
UBOOT_CONFIG[stratix10-socdk-qspi] = "socfpga_stratix10_qspi_defconfig"
UBOOT_CONFIG[stratix10-socdk-qspi-atf] = "socfpga_stratix10_qspi_atf_defconfig"
UBOOT_CONFIG[arria10-socdk] = "socfpga_arria10_defconfig"
UBOOT_CONFIG[arria10-socdk-nand] = "socfpga_arria10_nand_defconfig"
UBOOT_CONFIG[arria10-socdk-qspi] = "socfpga_arria10_qspi_defconfig"
UBOOT_CONFIG[cyclone5-socdk] = "socfpga_cyclone5_defconfig"
UBOOT_CONFIG[de0-nano-soc] = "socfpga_de0_nano_soc_defconfig"
UBOOT_CONFIG[de10-nano-soc] = "socfpga_de10_nano_defconfig"
UBOOT_CONFIG[mcvevk] = "socfpga_mcvevk_defconfig"
UBOOT_CONFIG[sockit] = "socfpga_sockit_defconfig"
UBOOT_CONFIG[socrates] = "socfpga_socrates_defconfig"
UBOOT_CONFIG[sr1500] = "socfpga_sr1500_defconfig"
UBOOT_CONFIG[arria5-socdk] = "socfpga_arria5_defconfig"
