LINUX_VERSION = "5.4"
LINUX_VERSION_SUFFIX = "-lts"
# This is required so we ignore minor number changes
KERNEL_VERSION_SANITY_SKIP = "1"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRCREV = "d2466b12e55dda297f3b1a4787b5ea3160994ee9"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "

