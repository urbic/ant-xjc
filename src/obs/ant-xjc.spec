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
Summary:		Optional XJC task for Ant
Url:			https://github.com/urbic/%{name}
Group:			Development/Tools/Building
Source:			%{name}-%{version}.tar.xz
BuildRequires:	ant
BuildRequires:	java-devel >= 1.8.0
BuildRequires:	pandoc
#Provides:		config(%%{name})
Requires:		java >= 1.8.0
Requires:		java-1_8_0-openjdk-devel >= 1.8.0
BuildRoot:		%{_tmppath}/%{name}-%{version}-build
BuildArch:		noarch
%if 0%{?fedora}
BuildRequires:	java-1.8.0-openjdk-javadoc
%endif

%description
This package contains optional XJC task for Apache Ant, a Java-based build tool.

%package javadoc
Summary:		Javadocs for %{name}
Group:			Documentation
%if 0%{?suse_version} != 1330
BuildRequires:	ant-javadoc
%endif
BuildRequires:	java-javadoc >= 1.8.0
Requires:		jpackage-utils

%description javadoc
This package contains the API documentation for %{name}.

%prep
%setup -q

%build
%{ant} build

%check
%{ant} test

%install
%{ant} install -Ddestdir=%{buildroot} -Dinstall.docdir=%{_docdir}/%{name}

%clean
%{__rm} -rf %{buildroot}

%files
%defattr(-,root,root)
%{_javadir}/ant/*.jar
%{_datadir}/ant/lib/%{name}.jar
%config %{_sysconfdir}/ant.d/*
%{_docdir}/%{name}

%files javadoc
%defattr(0644,root,root,0755)
%{_javadocdir}/%{name}

%changelog
