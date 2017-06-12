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
schema (file/URL/dir/jar)

* `destdir`
generated files will go into this directory

* `package`
specifies the target package

* `catalog`
specify catalog files to resolve external entity references support TR9401,
XCatalog, and OASIS XML Catalog format

* `classpath`
specify where to find user class files

* `extension`
allow vendor extensions — do not strictly follow the Compatibility Rules and App E.2 from the JAXB Spec

* `enableIntrospection`
enable correct generation of Boolean getters/setters to enable Bean Introspection apis

* `readonly`
generated files will be in read-only mode

* `httpProxy`
set HTTP/HTTPS proxy. Format is `[user[:password]@]proxyHost:proxyPort`

* `httpProxyFile`
works like `httpproxy` but takes the argument in a file to protect password

* `format`
	* `"xmlschema"`
	treat input as W3C XML Schema (default)

    * `"relaxng"`
	treat input as RELAX NG (experimental, unsupported)
	
	* `"relaxng-compact"`
	treat input as RELAX NG compact syntax (experimental, unsupported)
	
	* `"dtd"`
	treat input as XML DTD (experimental, unsupported)
	
	* `"wsdl"`
	treat input as WSDL and compile schemas inside it (experimental, unsupported)

* `contentForWildcard`
generates content property for types with multiple `xs:any` derived elements

* `quiet`
suppress compiler output

* `verbose`
be extra verbose

* `failonerror`
indicates whether compilation errors will fail the build; defaults to `"true"`

* `target`
behave like XJC 2.0 or 2.1 and generate code that doesn’t use any 2.2 features
	* `"2.0"`
	* `"2.1"`

* `noHeader`
suppress generation of a file header with timestamp

* `noValidate`
do not perform strict validation of the input schema(s)

* `enableIntrospection`
enable correct generation of Boolean getters/setters to enable Bean
Introspection apis

* `disableXmlSecurity`
disables XML security features when parsing XML documents

* `noPackageAnnotations`
suppress generation of package level annotations (`**/package-info.java`)

### Nested elements

* **`schema`**

Can contain arbitrary _resource collection_ elements.

```xml
<xjc>
	<fileset dir="${src.main.xsd}" includes="**/*.xsd"/>
</xjc>
```

## License

This software and documentation are released under the [zlib/png](LICENSE) license.

## Author
[Anton Shvetz](mailto:tz@sectorb.msk.ru?subject=ant-xjc)

