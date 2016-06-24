LINUX_VERSION = "4.1.22"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

include linux-altera.inc

FILESEXTRAPATHS := "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
