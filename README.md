# **ant-xjc**

This package contains optional **xjc** task for **Apache Ant**.

[Apache Ant™](http://ant.apache.org/) is a Java-based build tool.

## Description

### Usage

```xml
…
<taskdef
	resource="coneforest/ant/xjc/antlib.xml"
	classpathref="classpath.main"
	/>
<xjc
	verbose="yes"
	schema="${src.main.xsd}/myschema.xsd"
	destdir="${target.src.main.java}"
	/>
…
```

### Attributes

* `schema`
Schema (file/URL/dir/jar).

* `destdir`
Generated files will go into this directory.

* `package`
Specifies the target package.

* `catalog`
Specify catalog files to resolve external entity references support TR9401,
XCatalog, and OASIS XML Catalog format.

* `classpath`
Specify where to find user class files.

* `extension`
Allow vendor extensions — do not strictly follow the Compatibility Rules and App E.2 from the JAXB Spec.

* `enableIntrospection`
Enable correct generation of Boolean getters/setters to enable Bean Introspection apis.

* `readonly`
Generated files will be in read-only mode.

* `httpProxy`
Set HTTP/HTTPS proxy. Format is `[user[:password]@]proxyHost:proxyPort`.

* `httpProxyFile`
Works like `httpproxy` but takes the argument in a file to protect password.

* `format`
	* `"xmlschema"`
	Treat input as W3C XML Schema (default).

    * `"relaxng"`
	Treat input as RELAX NG (experimental, unsupported).
	
	* `"relaxng-compact"`
	Treat input as RELAX NG compact syntax (experimental, unsupported).
	
	* `"dtd"`
	Treat input as XML DTD (experimental, unsupported).
	
	* `"wsdl"`
	Treat input as WSDL and compile schemas inside it (experimental, unsupported).

* `contentForWildcard`
generates content property for types with multiple `xs:any` derived elements.

* `quiet`
Suppress compiler output.

* `verbose`
Be extra verbose.

* `failonerror`
Indicates whether compilation errors will fail the build; defaults to `"true"`.

* `target`
Behave like XJC 2.0 or 2.1 and generate code that doesn’t use any 2.2 features.
Possible values are:
	* `"2.0"`
	* `"2.1"`

* `noHeader`
Suppress generation of a file header with timestamp.

* `noValidate`
Do not perform strict validation of the input schema(s).

* `enableIntrospection`
Enable correct generation of Boolean getters/setters to enable Bean
Introspection apis.

* `disableXmlSecurity`
Disables XML security features when parsing XML documents.

* `noPackageAnnotations`
Suppress generation of package level annotations (`**/package-info.java`).

### Nested elements

* **`schema`**
Can contain arbitrary _resource collection_ elements.

```xml
<xjc destdir="${target.src.test.java}">
	<fileset dir="${src.main.xsd}" includes="**/*.xsd"/>
</xjc>
```

* **`binding`**
Specify external bindings files. If a directory is given, `**/*.xjb` is searched.

## License

This software and documentation are released under the [zlib/png](LICENSE) license.

## Author
[Anton Shvetz](mailto:tz@sectorb.msk.ru?subject=ant-xjc)

