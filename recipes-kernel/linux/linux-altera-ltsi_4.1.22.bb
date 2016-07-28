LINUX_VERSION = "4.1.22"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "9862a6691b3f0d5496f39f7b21f6c876dee1549c"

include linux-altera.inc

FILESEXTRAPATHS .= "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
