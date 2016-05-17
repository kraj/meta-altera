FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

COMPATIBLE_MACHINE_10m50 = "10m50"
COMPATIBLE_MACHINE_generic-nios2 = "generic-nios2"
SRC_URI_append_nios2 = " file://defconfig "

# Force machine Tunings in kernel config
do_configure_prepend_nios2() {
    sed -i -e /CONFIG_NIOS2_HW_MUL_SUPPORT/d ${WORKDIR}/defconfig
    sed -i -e /CONFIG_NIOS2_HW_MULX_SUPPORT/d ${WORKDIR}/defconfig
    sed -i -e /CONFIG_NIOS2_HW_DIV_SUPPORT/d ${WORKDIR}/defconfig
    sed -i -e /CONFIG_NIOS2_FPU_SUPPORT/d ${WORKDIR}/defconfig
    echo "${@bb.utils.contains('TUNE_FEATURES', 'hw-mul',  'CONFIG_NIOS2_HW_MUL_SUPPORT=y', '#CONFIG_NIOS2_HW_MUL_SUPPORT is not set', d)}" >> ${WORKDIR}/defconfig
    echo "${@bb.utils.contains('TUNE_FEATURES', 'hw-mulx', 'CONFIG_NIOS2_HW_MULX_SUPPORT=y',   '#CONFIG_NIOS2_HW_MULX_SUPPORT is not set', d)}" >> ${WORKDIR}/defconfig
    echo "${@bb.utils.contains('TUNE_FEATURES', 'hw-div',  'CONFIG_NIOS2_HW_DIV_SUPPORT=y',    '#CONFIG_NIOS2_HW_DIV_SUPPORT is not set', d)}" >> ${WORKDIR}/defconfig
    echo "${@bb.utils.contains('TUNE_FEATURES', 'fpu-custom', 'CONFIG_NIOS2_FPU_SUPPORT=y',    '#CONFIG_NIOS2_FPU_SUPPORT is not set', d)}" >> ${WORKDIR}/defconfig
    echo "${@bb.utils.contains('TUNE_FEATURES', 'fpu-customdiv', 'CONFIG_NIOS2_FPU_SUPPORT=y', '#CONFIG_NIOS2_FPU_SUPPORT is not set', d)}" >> ${WORKDIR}/defconfig
}
