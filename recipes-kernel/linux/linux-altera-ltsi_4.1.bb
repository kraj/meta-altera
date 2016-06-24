LINUX_VERSION = "4.1"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "43492a7a9649e30826e4c79a9308ab2850259c26"

include linux-altera.inc

FILESEXTRAPATHS := "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
