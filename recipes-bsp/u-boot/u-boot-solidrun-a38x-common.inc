HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "ab15b2d5b6ee50c106628dc0aa5943747a5dd772"
SRCBRANCH = "v2018.01-solidrun-a38x"

FILESEXTRAPATHS_prepend := "${THISDIR}/patches:"

SRC_URI = "git://github.com/SolidRun/u-boot.git;branch=${SRCBRANCH}"
SRC_URI_append = " file://0005-fw_env_main.c-Fix-incorrect-size-for-malloc-ed-strin.patch"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(clearfog)"
