LINUX_VERSION = "4.1.22"
LINUX_VERSION_SUFFIX = "-ltsi"

SRCREV = "48a39aeb13e390b8c9b7076d49d73aa26b3de41c"

include linux-altera.inc

FILESEXTRAPATHS .= "${FILE_DIRNAME}/linux-altera-ltsi:"

SRC_URI += "\
           file://0001-compiler-gcc-integrate-the-various-compiler-gcc-345-.patch \
           file://0001-compiler-gcc-disable-ftracer-for-__noclone-functions.patch \
"
