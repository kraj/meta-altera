require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# This revision is the v2016.03 release
SRCREV = "df61a74e6845ec9bdcdd48d2aff5e9c2c6debeaa"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV = "v2016.03"
PV_append = "+git${SRCPV}"

DEPENDS += "dtc-native"

UBOOT_CONFIG ??= "cyclone5-socdk arria5-socdk de0-nano-soc sockit socrates"
UBOOT_CONFIG[cyclone5-socdk] = "socfpga_cyclone5_defconfig"
UBOOT_CONFIG[arria5-socdk] = "socfpga_arria5_defconfig"
UBOOT_CONFIG[de0-nano-soc] = "socfpga_de0_nano_soc_defconfig"
UBOOT_CONFIG[mcvevk] = "socfpga_mcvevk_defconfig"
UBOOT_CONFIG[sockit] = "socfpga_sockit_defconfig"
UBOOT_CONFIG[socrates] = "socfpga_socrates_defconfig"
UBOOT_CONFIG[sr1500] = "socfpga_sr1500_defconfig"

UBOOT_SUFFIX = "img"

SPL_BINARY_cyclone5 = "u-boot-with-spl.sfp"
SPL_BINARY_arria5 = "u-boot-with-spl.sfp"


