LINUX_VERSION = "4.1.22"
LINUX_VERSION_SUFFIX = "-ltsi-rt"

SRCREV = "0e938a8fafccb73ad70781ed62abda2b554eafb4"

include linux-altera.inc

FILESEXTRAPATHS := "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
