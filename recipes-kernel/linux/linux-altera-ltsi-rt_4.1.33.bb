LINUX_VERSION = "4.1.33"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "560f4d83f793b5c0a9445a77c53f2edd0b903ade"

include linux-altera.inc

FILESEXTRAPATHS .= "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
