LINUX_VERSION = "5.10.50"
LINUX_VERSION_SUFFIX = "-lts"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRCREV = "1807da3569b8e03a60967b5906be0eb834611c71"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "
SRC_URI:append_stratix10 = " file://jffs2.scc file://gpio_sys.scc "
SRC_URI:append_agilex = " file://jffs2.scc file://gpio_sys.scc "
