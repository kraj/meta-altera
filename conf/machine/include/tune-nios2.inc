#@TYPE: Machine configuration
#@NAME: nios2

DEFAULTTUNE ?= "nios2"

TUNE_ARCH = "nios2el"

require conf/machine/include/nios2/feature-nios2-multiply.inc
require conf/machine/include/nios2/feature-nios2-divide.inc
require conf/machine/include/nios2/feature-nios2-fpu.inc

AVAILTUNES += "nios2"
TUNEVALID[nios2] = "nios2"
TUNE_FEATURES_tune-nios2 += "nios2"

TUNE_CCARGS += "-mel ${NIOS2CCARGSDIV} ${NIOS2CCARGSFPU} ${NIOS2CCARGSMUL}"
TUNE_PKGARCH = "nios2${NIOS2PKGMUL}${NIOS2PKGDIV}${NIOS2PKGFPU}"
PACKAGE_EXTRA_ARCHS_tune-nios2 = "${TUNE_PKGARCH}"

CSL_TARGET_SYS_nios2 = "nios2-linux-gnu"
