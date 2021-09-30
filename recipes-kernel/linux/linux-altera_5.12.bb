LINUX_VERSION = "5.12"

SRCREV = "302a60c614ffb9aa10eab4a2adb8babc73cc8c61"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_cyclone5 = " file://lbdaf.scc "
SRC_URI_append_arria5 = " file://lbdaf.scc "
SRC_URI_append_arria10 = " file://lbdaf.scc "
