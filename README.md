The official OpenEmbedded/Yocto BSP layer for Altera SoCFPGA platforms 

This layer works with poky and Angstrom

Please follow the recommended setup procedures of your OE distribution.


Choosing Kernel Versions
==========================
This layer has a few providers for the kernel.  These are the linux-altera, 
linux-altera-ltsi, and linux-altera-ltsi-rt kernels.  There are also 
linux-altera-dev and linux-altera-ltsi-dev kernels which follow the current 
development versions of those kernels.

To specify a linux-altera kernel, add the following to your conf/local.conf

	PREFERRED_PROVIDER_virtual/kernel = "linux-altera"
	PREFERRED_VERSION_linux-altera = "4.3%"

or for the linux-altera-ltsi kernel	

	PREFERRED_PROVIDER_virtual/kernel = "linux-altera-ltsi"
	PREFERRED_VERSION_linux-alterai-ltsi = "3.10%"

Please note that older kernels will not compile with GCC 5+ and you will need 
to specify in your conf/local.conf to revert to older 4.9 toolchain. 


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



Send pull requests, patches, comments or questions to yvanderv@opensource.altera.com
and raj.khem@gmail.com

Maintainers: Khem Raj <raj.khem@gmail.com>
             Yves Vandervennet <yvanderv@opensource.altera.com>
