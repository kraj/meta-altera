LINUX_VERSION = "5.4.104"
LINUX_VERSION_SUFFIX = "-lts"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRCREV = "93eaed6ae8b138694b4cd2312b0f26e2009ddb7a"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append_cyclone5 = " file://lbdaf.scc "
SRC_URI:append_arria5 = " file://lbdaf.scc "
SRC_URI:append_arria10 = " file://lbdaf.scc "
SRC_URI:append_stratix10 = " file://jffs2.scc file://gpio_sys.scc "
SRC_URI:append_agilex = " file://jffs2.scc file://gpio_sys.scc "
