require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# This revision is the v2016.05 release
SRCREV = "aeaec0e682f45b9e0c62c522fafea353931f73ed"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV = "2016.05"
PV_append = "+git${SRCPV}"

DEPENDS += "dtc-native"

do_install_append_10m50 () {
    if [ "x${UBOOT_CONFIG}" != "x" ]
    then
        for config in ${UBOOT_MACHINE}; do
            install -d ${D}/boot
            install ${B}/${config}/${UBOOT_DTB_BINARY} ${D}/boot/${UBOOT_DTB_BINARY}
            install ${B}/${config}/${UBOOT_NODTB_BINARY} ${D}/boot/${UBOOT_NODTB_BINARY}
        done
    else
        install -d ${D}/boot
        install ${B}/${config}/${UBOOT_DTB_BINARY} ${D}/boot/${UBOOT_DTB_BINARY}
        install ${B}/${config}/${UBOOT_NODTB_BINARY} ${D}/boot/${UBOOT_NODTB_BINARY}
    fi
}

do_deploy_append_10m50 () {
    install ${D}/boot/${UBOOT_DTB_BINARY} ${DEPLOYDIR}/${UBOOT_DTB_BINARY}
    install ${D}/boot/${UBOOT_NODTB_BINARY} ${DEPLOYDIR}/${UBOOT_NODTB_BINARY}
}
