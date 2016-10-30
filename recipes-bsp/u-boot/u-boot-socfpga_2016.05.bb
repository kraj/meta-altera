require u-boot-common_${PV}.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

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
