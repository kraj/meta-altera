LINUX_VERSION = "4.1.33"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "b84195c056ee943efa9eff2767b09dd266a451d1"

include linux-altera.inc

FILESEXTRAPATHS .= "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
