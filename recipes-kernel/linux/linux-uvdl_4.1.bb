# Copyright (C) 2016 Voipac
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for for imx6 TinyRex/Rex boards"
DESCRIPTION = "Linux kernel for for imx6 Rex and UVDL boards. It includes \
support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-2.0.x-imx-iris2"
LOCALVERSION = "-yocto"
SRCREV = "0409b21ac6be2140bd18d27a9514ba4b6e32e049"
KERNEL_SRC ?= "git://github.com/uvdl/linux-fslc.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"

DEFAULT_PREFERENCE = "1"              

COMPATIBLE_MACHINE = "(mx6|imx6-openrexmax|imx6-iris2-dt6c|imx6-iris2-openrexmax|imx6-iris2-r0)"
