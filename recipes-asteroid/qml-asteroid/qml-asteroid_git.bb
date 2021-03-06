SUMMARY = "QML components for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins asteroid-theme-moka qtsvg-plugins ttf-opensans"

do_configure_prepend() {
    sed -i "s@examples@@" ${S}/qml-asteroid.pro

    if [ ${MACHINE_DISPLAY_ROUND} = "true" ]
    then
        export EXTRA_QMAKEVARS_PRE="DEFINES+=ROUND_SCREEN"
    fi
}

FILES_${PN} += "/usr/lib"
FILES_${PN}-dbg += "/usr/lib/examples/.debug/ /usr/lib/qml/org/asteroid/controls/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Asteroid/.debug/"
