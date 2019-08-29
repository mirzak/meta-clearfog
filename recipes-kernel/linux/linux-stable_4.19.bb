inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "\
    https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
    file://defconfig \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'file://systemd.cfg', '', d)} \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI[md5sum] = "4f68af8d3775e28c1405102b5cb6b3d8"
SRC_URI[sha256sum] = "5a853d1ffc3076a8483b16fea0a66ec3accdaef2d8603a7bad6b200ce47e16ee"

S = "${WORKDIR}/linux-${PV}"

LINUX_VERSION ?= "4.19.28"
LINUX_VERSION_EXTENSION= "-stable"

# tag: v4.19.28 64291f7db5bd8150a74ad2036f1037e6a0428df2
SRCREV = "6a31767f84ad31445865f1297d49937319f775c3"

PV = "${LINUX_VERSION}"

KCONFIG_MODE="--alldefconfig"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "(^clearfog$|^clearfog-pro$)"
