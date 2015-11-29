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
