Format: 1.0
Version: @obs.package.version@-0
Source: @obs.package.name@
Binary: @obs.package.name@
Maintainer: Anton Shvetz <tz@sectorb.msk.ru>
Architecture: all
Build-Depends: debhelper (>= 9),
	openjdk-8-jdk-headless,
	openjdk-8-doc,
	ant,
	ant-doc,
	pandoc,
Package-List: 
	ant-xjc deb java optional
	ant-xjc-doc deb doc optional
Debtransform-Tar: @obs.package.name@-@obs.package.version@.tar.xz
Files:
	00000000000000000000000000000000 0 @obs.package.name@_@obs.package.version@.orig.tar.xz
	00000000000000000000000000000000 0 @obs.package.name@_@obs.package.version@-0.diff.tar.xz
