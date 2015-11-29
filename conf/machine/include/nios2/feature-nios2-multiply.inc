TUNEVALID[hw-mul] = "Enable Nios2 Hardware Multiply"
TUNEVALID[hw-mulx] = "Enable Nios2 Extended Hardware Multiply"

# Establish which Multiply output result size to use
NIOS2CCARGSMUL = "${@bb.utils.contains("TUNE_FEATURES", "hw-mul", "-mhw-mul", "" ,d)}"
NIOS2CCARGSMUL += "${@bb.utils.contains("TUNE_FEATURES", "hw-mulx", "-mhw-mulx", "" ,d)}"

NIOS2PKGMUL_BASIC = "${@bb.utils.contains("TUNE_FEATURES", "hw-mul", "-mul", "" ,d)}"
NIOS2PKGMUL = "${@bb.utils.contains("TUNE_FEATURES", "hw-mulx", "-mulx", "${NIOS2PKGMUL_BASIC}" ,d)}"

