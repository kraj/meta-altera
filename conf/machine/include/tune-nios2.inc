#@TYPE: Machine configuration
#@NAME: nios2

DEFAULTTUNE ?= "nios2"

TUNE_ARCH = "nios2el"

# Multiply opcodes
TUNEVALID[hw-mul] = "Enable Nios2 Hardware Multiply"
TUNEVALID[hw-mulx] = "Enable Nios2 Extended Hardware Multiply"

# Establish which Multiply output result size to use
NIOS2CCARGSMUL = "${@bb.utils.contains("TUNE_FEATURES", "hw-mul", "-mhw-mul", "" ,d)}"
NIOS2CCARGSMUL += "${@bb.utils.contains("TUNE_FEATURES", "hw-mulx", "-mhw-mulx", "" ,d)}"

NIOS2PKGMUL_BASIC = "${@bb.utils.contains("TUNE_FEATURES", "hw-mul", "-mul", "" ,d)}"
NIOS2PKGMUL = "${@bb.utils.contains("TUNE_FEATURES", "hw-mulx", "-mulx", "${NIOS2PKGMUL_BASIC}" ,d)}"

# Divide opcodes
TUNEVALID[hw-div] = "Enable Nios2 hardware divider."
NIOS2CCARGSDIV = "${@bb.utils.contains("TUNE_FEATURES", "hw-div", "-mhw-div", "" ,d)}"
NIOS2PKGDIV = "${@bb.utils.contains("TUNE_FEATURES", "hw-div", "-div", "" ,d)}"

# FPU support
TARGET_FPU = "fpu-other"
TUNEVALID[fpu-soft] = "Use Nios2 software FPU"
TUNEVALID[fpu-custom] = "Enable Nios2 hardware FPU"
TUNEVALID[fpu-customdiv] = "Enable Nios2 hardware FPU with divider"

# Establish which fpu is configured in TUNE_FEATURES. Soft is the default for gcc.
NIOS2CCARGSFPU_BASIC = "${@bb.utils.contains("TUNE_FEATURES", "fpu-custom", "-mcustom-fpu-cfg=60-1", "", d)}"
NIOS2CCARGSFPU = "${@bb.utils.contains("TUNE_FEATURES", "fpu-customdiv", "-mcustom-fpu-cfg=60-2", "${NIOS2CCARGSFPU_BASIC}", d)}"

NIOS2PKGFPU_BASIC = "${@bb.utils.contains("TUNE_FEATURES", "fpu-custom", "-fpu", "", d)}"
NIOS2PKGFPU = "${@bb.utils.contains("TUNE_FEATURES", "fpu-customdiv", "-fpudiv", "${NIOS2PKGFPU_BASIC}", d)}"

TUNECONFLICTS[fpu-custom] = "fpu-soft fpu-customdiv"
TUNECONFLICTS[fpu-customdiv] = "fpu-soft fpu-custom"

# Architecture configuration
AVAILTUNES += "nios2"
TUNEVALID[nios2] = "nios2"
TUNE_FEATURES_tune-nios2 += "nios2"

TUNE_CCARGS += "-mel ${NIOS2CCARGSDIV} ${NIOS2CCARGSFPU} ${NIOS2CCARGSMUL}"
TUNE_PKGARCH = "nios2${NIOS2PKGMUL}${NIOS2PKGDIV}${NIOS2PKGFPU}"
PACKAGE_EXTRA_ARCHS_tune-nios2 = "${TUNE_PKGARCH}"
