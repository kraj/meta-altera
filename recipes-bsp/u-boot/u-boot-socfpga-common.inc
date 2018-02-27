HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV_append = "+git${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master"

S = "${WORKDIR}/git"

do_compile_append_stratix10() {
    if [ -n "${UBOOT_CONFIG}" ]
    then
        unset i j k
        for config in ${UBOOT_MACHINE}; do
            i=$(expr $i + 1);
            for type in ${UBOOT_CONFIG}; do
                j=$(expr $j + 1);
                if [ $j -eq $i ]
                then
	            ${OBJCOPY} -I binary -O ihex --change-addresses 0xffe00000 ${B}/${config}/${SPL_BINARY} ${B}/${config}/${SPL_BINARY}.ihex
                fi
            done
            unset  j
        done
        unset  i
    else
	${OBJCOPY} -I binary -O ihex --change-addresses 0xffe00000 ${B}/${SPL_BINARY} ${B}/${SPL_BINARY}.ihex
    fi

}

do_deploy_append_stratix10() {
     if [ -n "${SPL_BINARY}" ]
     then
         if [ -n "${UBOOT_CONFIG}" ]
         then
             for config in ${UBOOT_MACHINE}; do
                 i=$(expr $i + 1);
                 for type in ${UBOOT_CONFIG}; do
                     j=$(expr $j + 1);
                     if [ $j -eq $i ]
                     then
                         install -m 644 ${B}/${config}/${SPL_BINARY}.ihex ${DEPLOYDIR}/${SPL_IMAGE}.ihex-${type}-${PV}-${PR}
                         rm -f ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${MACHINE}-${type}
                         ln -sf ${SPL_IMAGE}.ihex-${type}-${PV}-${PR} ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${type}
                         ln -sf ${SPL_IMAGE}.ihex-${type}-${PV}-${PR} ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex
                         ln -sf ${SPL_IMAGE}.ihex-${type}-${PV}-${PR} ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${MACHINE}-${type}
                         ln -sf ${SPL_IMAGE}.ihex-${type}-${PV}-${PR} ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${MACHINE}
                     fi
                 done
                 unset  j
             done
             unset  i
         else
             install -m 644 ${B}/${SPL_BINARY}.ihex ${DEPLOYDIR}/${SPL_IMAGE}.ihex
             rm -f ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${MACHINE}
             ln -sf ${SPL_IMAGE}.ihex ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex
             ln -sf ${SPL_IMAGE}.ihex ${DEPLOYDIR}/${SPL_BINARYNAME}.ihex-${MACHINE}
         fi
     fi
}

RPROVIDES_${PN} += "u-boot" 
