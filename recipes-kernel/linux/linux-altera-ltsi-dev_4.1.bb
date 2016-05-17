LINUX_VERSION = "4.1"
LINUX_VERSION_SUFFIX = "-ltsi"

include linux-altera.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
