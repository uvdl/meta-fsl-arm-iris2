# meta-fsl-arm-iris2
Freescale Yocto Project Community BSP

# Getting the BSP

To get the BSP you need to have `repo` installed and use it as:

## Install the `repo` utility:
    mkdir -p ~/workdir/bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo  > ~/workdir/bin/repo
    chmod a+x ~/workdir/bin/repo
    PATH=${PATH}:~/workdir/bin

## Download the BSP Yocto Project Environment
    mkdir -pv ~/workdir/imx6/yocto/fsl-release-bsp
    cd ~/workdir/imx6/yocto/fsl-release-bsp
    repo init -u git://git.freescale.com/imx/fsl-arm-yocto-bsp.git -b imx-4.1-krogoth

## Add iris2 support
    mkdir -pv .repo/local_manifests/
    cat > .repo/local_manifests/imx6-iris2.xml << EOF
    <?xml version="1.0" encoding="UTF-8"?>
    <manifest>

      <remote fetch="git://github.com/uvdl" name="uvdl"/>

      <project remote="uvdl" revision="master" name="meta-fsl-arm-iris2" path="sources/meta-fsl-arm-iris2">
        <copyfile src="iris2-setup.sh" dest="iris2-setup.sh"/>
      </project>
    </manifest>
    EOF

## Sync repositories
    repo sync

## Add iris2 meta layer into BSP
    source iris2-setup.sh

# Building images
    cd ~/workdir/imx6/yocto/fsl-release-bsp

## Supported machines <machine name>
    imx6-openrexmax
    imx6-iris2-dt6c
    imx6-iris2-r0

## Supported distros <distro name>
	fsl-imx-x11
	fsl-imx-wayland
	fsl-imx-xwayland
	fsl-imx-fb

## Setup and Build Console image
    MACHINE=<machine name> source setup-environment <build dir>
    MACHINE=<machine name> bitbake core-image-base

## Setup and Build Toolchain
    MACHINE=<machine name> bitbake core-image-base -c populate_sdk

## Setup and Build FSL GUI image
    DISTRO=<distro name> MACHINE=<machine name> source fsl-setup-release.sh -b build-x11
    DISTRO=<distro name> MACHINE=<machine name> bitbake fsl-image-gui

# Acknowledgement
This repository was developed with the following references.  Thanks to the contributors:
 * [meta-fsl-arm-voipac](https://github.com/voipac/meta-fsl-arm-voipac)
