# **ant-xjc**

This package contains optional **XJC** task for [**Apache Ant™**](http://ant.apache.org/), a Java-based build tool.

[![License](https://img.shields.io/badge/license-zlib%2Fpng-blue.svg)](http://opensource.org/licenses/Zlib)

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
Specify catalog files to resolve external entity references. Support [TR9401](https://www.oasis-open.org/specs/a401.htm), [XCatalog](http://xml.coverpages.org/XCatalog9807.html), and [OASIS XML Catalog](https://www.oasis-open.org/committees/entity/spec-2001-08-06.html) format.

* `classpath`
Specify where to find user class files.

* `classpathref`
Specify where to find user class files as reference to a _path_ defined elsewhere.

* `encoding`
Specify character encoding for generated source files.

* `extension`
Allow vendor extensions — do not strictly follow the Compatibility Rules and App E.2 from the JAXB Spec.

* `readonly`
Generated files will be in read-only mode.

* `httpProxy`
Set HTTP/HTTPS proxy. Format is `[user[:password]@]proxyHost:proxyPort`.

* `httpProxyFile`
Works like `httpproxy` but takes the argument in a file to protect password.

* `format`
	* `"xmlschema"`
	Treat input as [W3C XML Schema](https://www.w3.org/TR/xmlschema11-1/) (default).

    * `"relaxng"`
	Treat input as [RELAX NG](http://relaxng.org/spec-20011203.html) (experimental, unsupported).

	* `"relaxng-compact"`
	Treat input as [RELAX NG compact syntax](http://relaxng.org/compact-20021121.html) (experimental, unsupported).

	* `"dtd"`
	Treat input as [XML DTD](http://www.w3.org/TR/REC-xml/#dt-doctype) (experimental, unsupported).

	* `"wsdl"`
	Treat input as [WSDL](http://www.w3.org/TR/wsdl20/) and compile schemas inside it (experimental, unsupported).

* `contentForWildcard`
generates content property for types with multiple `xs:any` derived elements.

* `quiet`
Suppress compiler output.

* `verbose`
Be extra verbose.

* `failOnError`
Indicates whether compilation errors will fail the build; defaults to `"true"`.

* `target`
Behave like XJC 2.0 or 2.1 and generate code that doesn’t use any 2.2 features. Possible values are:
	* `"2.0"`
	* `"2.1"`

* `noHeader`
Suppress generation of a file header with timestamp.

* `noValidate`
Do not perform strict validation of the input schema(s).

* `enableIntrospection`
Enable correct generation of Boolean getters/setters to enable Bean Introspection apis.

* `disableXmlSecurity`
Disables XML security features when parsing XML documents.

* `noPackageAnnotations`
Suppress generation of package level annotations (`**/package-info.java`).

* `markGenerated`
Mark the generated code as `@javax.annotation.Generated`.

### Nested elements

* **`schema`**
Specify schema. For each directory specified, all schema files in it will be compiled. This element can contain arbitrary _resource collection_ elements.
    ```xml
    <xjc destdir="${target.src.test.java}">
        <schema>
            <fileset dir="${src.main.xsd}" includes="**/*.xsd"/>
        </schema>
    </xjc>
    ```

* **`binding`**
Specify external bindings files. For each directory specified, all bindings files (`**/*.xjb`) in it will be searched. This element can contain arbitrary _resource collection_ elements.
    ```xml
    <xjc destdir="${target.src.test.java}">
        <binding>
            <fileset dir="${src.main.xsd}" includes="**/*.xjb"/>
        </binding>
    </xjc>
    ```

## License

This software and documentation are released under the [zlib/png](LICENSE) license.

## Author
[Anton Shvetz](mailto:tz@sectorb.msk.ru?subject=ant-xjc)

