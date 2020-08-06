The official OpenEmbedded/Yocto BSP layer for Altera SoCFPGA platforms 

This layer works with poky and Angstrom

Please follow the recommended setup procedures of your OE distribution.

Supported u-boot and linux kernels
===
It is important to understand the support and release of u-boot-socfpga
and linux-socfpga in the github.com/altera-opensource repositories.  Only
currently supported and maintained releases/branches are available in the
repository. As such, supported kernel and u-boot releases are updated regularly
in currently supported meta-altera branches.  Kernel and u-boot releases
which are no longer supported are removed.

Supported branches
==================
Only branches listed appropriately in https://wiki.yoctoproject.org/wiki/Stable_branch_maintenance are maintained.

Choosing Kernel Versions
==========================
This layer has a few providers for the kernel.  These are the linux-altera, 
linux-altera-lts, linux-altera-ltsi, and linux-altera-ltsi-rt kernels.  There are also
linux-altera-dev and linux-altera-ltsi-dev kernels which follow the current 
development versions of those kernels.

To specify a linux-altera kernel, add the following to your conf/local.conf

	PREFERRED_PROVIDER_virtual/kernel = "linux-altera"
	PREFERRED_VERSION_linux-altera = "4.3%"

or for the linux-altera-lts kernel

	PREFERRED_PROVIDER_virtual/kernel = "linux-altera-lts"
	PREFERRED_VERSION_linux-altera = "5.4%"

or for the linux-altera-ltsi kernel	

	PREFERRED_PROVIDER_virtual/kernel = "linux-altera-ltsi"
	PREFERRED_VERSION_linux-alterai-ltsi = "3.10%"

Please note that older kernels will not compile with GCC 5+ and you will need 
to specify in your conf/local.conf to revert to older 4.9 toolchain. 

Specifying Devicetrees and U-Boot Configurations
==================================================
All of the supported machines select default uboot configurations and devicetrees.  These
selections can be overridden in the local.conf or by defining your own machine in your
own layer.

An example of the is the DE0-Nano-SoC board, which is a supported configuration in the Cyclone5
machine definition.

	UBOOT_CONFIG = "de0-nano-soc"
	UBOOT_EXTLINUX_FDT_default = "../socfpga_cyclone5_de0_nano_soc.dtb"

The above overrides the uboot configuration, "de0-nano-soc" is a target in u-boot, and configures
distroboot to indicate the de0-nano-soc devicetree.  Please keep in mind that not all targets are
using distroboot in u-boot and may require u-boot environment changes.

Choosing Toolchain Versions
=============================
The default Toolchain for ARM in Angstrom is the linaro toolchain.  To specify
the use of this toolchain in Yocto add the following to conf/local.conf

	GCCVERSION = "linaro-5.2"
	SDKGCCVERSION = "linaro-5.2"
	DEFAULTTUNE = "cortexa9hf-neon"

To use older kernels not supported by GCC 5+ you will need to use the 4.9 toolchain.

For Yocto:

	GCCVERSION = "linaro-4.9"
	SDKGCCVERSION = "linaro-4.9"
	DEFAULTTUNE = "cortexa9hf-neon"

For Angstrom:

	ANGSTROM_GCC_VERSION_arm = "linaro-4.9%"



Submit patches via github pull requests, Use github issues to report problems or to send comments

Maintainer(s): Khem Raj <raj.khem@gmail.com>
