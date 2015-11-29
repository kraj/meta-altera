TUNEVALID[hw-div] = "Enable Nios2 hardware divider."
NIOS2CCARGSDIV = "${@bb.utils.contains("TUNE_FEATURES", "hw-div", "-mhw-div", "" ,d)}"
NIOS2PKGDIV = "${@bb.utils.contains("TUNE_FEATURES", "hw-div", "-div", "" ,d)}"

