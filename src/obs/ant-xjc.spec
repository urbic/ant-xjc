#
# spec file for package @obs.package.name@
#
# Copyright (c) 2014 SUSE LINUX Products GmbH, Nuernberg, Germany.
#
# All modifications and additions to the file contributed by third parties
# remain the property of their copyright owners, unless otherwise agreed
# upon. The license for this file, and modifications and additions to the
# file, is the same license as for the pristine package itself (unless the
# license for the pristine package is not an Open Source License, in which
# case the license is the MIT License). An "Open Source License" is a
# license that conforms to the Open Source Definition (Version 1.9)
# published by the Open Source Initiative.

# Please submit bugfixes or comments via http://bugs.opensuse.org/
#

Name:           @obs.package.name@
Version:		@obs.package.version@
Release:		0
License:		Zlib
Summary:		Optional xjc task for ant
Url:			https://github.com/urbic/%{name}
Group:			Development/Tools/Building
Source:			%{name}-%{version}.tar.xz
BuildRequires:	ant
BuildRequires:	java-devel >= 1.8.0
BuildRequires:	java-1_8_0-openjdk-devel >= 1.8.0
BuildRequires:	java-javadoc >= 1.8.0
BuildRequires:	pandoc
BuildRequires:	texlive-collection-luatex
BuildRequires:	texlive-collection-latex
BuildRequires:	texlive-fancyvrb
BuildRequires:	liberation-fonts
BuildRequires:	texlive-euenc
Provides:		config(ant-%{name})
Requires:		java >= 1.8.0
Requires:		java-1_8_0-openjdk-devel >= 1.8.0
BuildRoot:		%{_tmppath}/%{name}-%{version}-build
BuildArch:		noarch

%description
Apache Ant is a Java-based build tool.

This package contains optional xjc task for Apache Ant.

%prep
%setup -q

%build
LANG=ru_RU.UTF-8 \
	%{ant} build

%check
LANG=ru_RU.UTF-8 \
	%{ant} test

%install
%{__install} -d %{buildroot}%{_javadir}/ant
%{__install} -d %{buildroot}%{_docdir}/%{name}
%{__install} -m 644 target/lib/%{name}-%{version}.jar %{buildroot}%{_javadir}/ant
%{__cp} -P target/lib/%{name}.jar %{buildroot}%{_javadir}/ant
%{__install} -m 644 target/doc/{README,LICENSE,AUTHORS} %{buildroot}%{_docdir}/%{name}
%{__install} -d %{buildroot}%{_datadir}/ant/lib
%{__ln_s} ../../java/ant/%{name}.jar %{buildroot}%{_datadir}/ant/lib/%{name}.jar
%{__install} -d %{buildroot}%{_sysconfdir}/ant.d
echo "%{name} ant/%{name}" > %{buildroot}%{_sysconfdir}/ant.d/%{name}
%{__install} -d %{buildroot}%{_docdir}/%{name}
%{__install} -m 644 target/doc/%{name}.pdf %{buildroot}%{_docdir}/%{name}

%clean
%{__rm} -rf %{buildroot}

%files
%defattr(-,root,root)
%{_javadir}/ant/*.jar
%{_datadir}/ant/lib/%{name}.jar
%config %{_sysconfdir}/ant.d/*
%{_docdir}/%{name}

%changelog
