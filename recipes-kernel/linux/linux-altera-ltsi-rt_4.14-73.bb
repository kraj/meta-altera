LINUX_VERSION = "4.14.73"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "d28435f2010b6fa334bd6abe709f7cd890ccc22c"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

#DE0 dts name changed in later kernels
KERNEL_DEVICETREE_remove_cyclone5 = "socfpga_cyclone5_de0_nano_soc.dtb"
KERNEL_DEVICETREE_append_cyclone5 = "socfpga_cyclone5_de0_sockit.dtb"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

