LINUX_VERSION = "5.4.124"
LINUX_VERSION_SUFFIX = "-lts"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRCREV = "d68144779f2b613cbd1eb892b6e06aeffff54009"

include linux-altera.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/config:"

SRC_URI:append:cyclone5 = " file://lbdaf.scc "
SRC_URI:append:arria5 = " file://lbdaf.scc "
SRC_URI:append:arria10 = " file://lbdaf.scc "
SRC_URI:append:stratix10 = " file://jffs2.scc file://gpio_sys.scc "
SRC_URI:append:agilex = " file://jffs2.scc file://gpio_sys.scc "
