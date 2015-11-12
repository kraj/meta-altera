DESCRIPTION = "Altera Linux kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KERNEL_REPO ?= "git://github.com/altera-opensource/linux-socfpga.git"
KERNEL_PROT ?= "https"

# Kernel CONFIG_LOCALVERSION
LINUX_VERSION_EXTENSION ?= "-altera"

# Build branch name
LINUX_VERSION_PREFIX ?= "socfpga-"
LINUX_VERSION_SUFFIX ?= ""
LINUX_VERSION ?= "4.0"

SRCREV ?= "${AUTOREV}"
SRCREV_machine ?= "${AUTOREV}"
PV = "${LINUX_VERSION}"
PV_append = "+git${SRCPV}"


KBRANCH ?= "${LINUX_VERSION_PREFIX}${LINUX_VERSION}${LINUX_VERSION_SUFFIX}"

SRC_URI = "${KERNEL_REPO};protocol=${KERNEL_PROT};branch=${KBRANCH}"

require recipes-kernel/linux/linux-yocto.inc
require linux-altera-configs.inc
