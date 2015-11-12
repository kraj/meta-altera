
FILESEXTRAPATHS_prepend := "${THISDIR}/config:"
SRC_URI_append += " \
		file://socfpga-base;type=kmeta;destsuffix=socfpga-base \
		"
