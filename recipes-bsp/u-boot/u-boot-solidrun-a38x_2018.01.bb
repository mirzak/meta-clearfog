require u-boot-solidrun-a38x-common.inc
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"
RPROVIDES_${PN} += "u-boot"

DEPENDS += "bc-native"

do_configure_prepend() {
    if [ "${UBOOT_BINARY}" = "u-boot-spl-sdhc.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_SDHC=y" >> \
            ${S}/configs/clearfog_defconfig
    elif [ "${UBOOT_BINARY}" = "u-boot-spl-spi.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_SPI=y" >> \
            ${S}/configs/clearfog_defconfig
    elif [ "${UBOOT_BINARY}" = "u-boot-spl-nand.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_NAND=y" >> \
            ${S}/configs/clearfog_defconfig
    elif [ "${UBOOT_BINARY}" = "u-boot-spl-sata.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_SATA=y" >> \
            ${S}/configs/clearfog_defconfig
    elif [ "${UBOOT_BINARY}" = "u-boot-spl-mmc.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_MMC=y" >> \
            ${S}/configs/clearfog_defconfig
    elif [ "${UBOOT_BINARY}" = "u-boot-spl-uart.kwb" ]; then
        echo "CONFIG_MVEBU_SPL_BOOT_DEVICE_UART=y" >> \
            ${S}/configs/clearfog_defconfig
    else
        bbfatal "Unknown boot configuration: ${UBOOT_BINARY}"
    fi
}
