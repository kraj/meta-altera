LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "b5ef09869b73b46068b53b1bf72de2ffd4d1cd94"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

#DE0 dts name changed in later kernels
KERNEL_DEVICETREE_remove_cyclone5 = "socfpga_cyclone5_de0_nano_soc.dtb"
KERNEL_DEVICETREE_append_cyclone5 = "socfpga_cyclone5_de0_sockit.dtb"

SRC_URI_append_cyclone5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria5 = " file://config_lbdaf.cfg "
SRC_URI_append_arria10 = " file://config_lbdaf.cfg "

