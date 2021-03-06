SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://git.merproject.org/mer-core/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://git.merproject.org/mer-core/lipstick.git;protocol=https \
    file://0001-Disables-tests-tools-and-doc-and-fixes-build.patch"
SRCREV = "d393a948d2d7d179dbe5dedf3ae68543e655507a"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtsensors qtdeclarative qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt statefs-qt mce usb-moded-qt5 systemd wayland qt5-qpa-hwcomposer-plugin qmsystem nemo-keepalive qttools-native"
RDEPENDS_${PN} += "qt5-qpa-hwcomposer-plugin ${PN}-locale"
# qt5-qpa-hwcomposer-plugin isn't detected to be needed at runtime by OpenEmbedded

inherit qmake5

do_install_append() {
    install -d ${D}/usr/share/icons/hicolor/86x86/apps/
}

FILES_${PN} += "/usr/lib/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qml/org/nemomobile/lipstick/qmldir /usr/share/icons/hicolor/86x86/apps/"
FILES_${PN}-dev += "/usr/lib/liblipstick-qt5.prl"
FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/lipstick/.debug"
FILES_${PN}-locale += "/usr/share/translations"

INSANE_SKIP_${PN} += "dev-deps"
