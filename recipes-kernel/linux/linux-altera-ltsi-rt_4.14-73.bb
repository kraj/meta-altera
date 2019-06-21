LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "2dbe6128e4d31b106a209981283e7286e1f0eefe"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

#DE0 dts name changed in later kernels
KERNEL_DEVICETREE_remove_cyclone5 = "socfpga_cyclone5_de0_nano_soc.dtb"
KERNEL_DEVICETREE_append_cyclone5 = "socfpga_cyclone5_de0_sockit.dtb"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

