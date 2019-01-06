require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for imx6 TinyRex/Rex boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(imx6-openrexmax|imx6-iris2-dt6c|imx6-iris2-r0)"

PROVIDES += "u-boot"

PV = "v2015.04"

SRCBRANCH = "uboot-imx-v2015.04"
SRCREV = "774cbf4de7fb17076a7ada21ed48cde0b590e246"
UBOOT_SRC ?= "git://github.com/voipac/uboot-imx.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
