require conf/machine/include/tune-cortexa9.inc

MACHINEOVERRIDES =. "clearfog:"

KERNEL_IMAGETYPE = "zImage"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-stable"

# Depending on which boot medium is selected the U-boot binary will change name
#
#    u-boot-spl-mmc.kwb
#    u-boot-spl-nand.kwb"
#    u-boot-spl-sata.kwb"
#    u-boot-spl-sdhc.kwb"
#    u-boot-spl-spi.kwb
#
# Update this variable to change boot location, it will update
# MVEBU_SPL_BOOT_DEVICE_XXX
UBOOT_BINARY ?= "u-boot-spl-sdhc.kwb"
UBOOT_MACHINE = "clearfog_defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-solidrun-a38x"
PREFERRED_PROVIDER_u-boot-fw-utils ?= "u-boot-solidrun-a38x-fw-utils"
PREFERRED_RPROVIDER_u-boot-fw-utils ?= "u-boot-solidrun-a38x-fw-utils"
PREFERRED_PROVIDER_u-boot-tools-native ?= "u-boot-solidrun-a38x-tools-native"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
    kernel-image \
    kernel-devicetree \
"

MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

SERIAL_CONSOLE = "115200 ttyS0"

MACHINE_FEATURES = "ext2 ext3 ipsec nfs pci smbfs usbgadget usbhost vfat"

WKS_FILE = "clearfog.wks"
WKS_FILE_DEPENDS = "virtual/bootloader clearfog-u-boot-scr"
