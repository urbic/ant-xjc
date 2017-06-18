package coneforest.ant.xjc;

/**
 *	The XJC task.
 */
public class XjcTask
	extends org.apache.tools.ant.Task
{
	/**
	 *	Executes the task.
	 *
	 *	@throws org.apache.tools.ant.BuildException if there is an execution
	 *	problem.
	 */
	@Override
	public void execute()
		throws org.apache.tools.ant.BuildException
	{
		java.util.ArrayList<String> argList=new java.util.ArrayList<String>();

		// Format
		if(format!=null)
			if(format.equals("xmlschema"));
			else if(format.equals("relaxng")
					|| format.equals("relaxng-compact")
					|| format.equals("dtd")
					|| format.equals("wsdl"))
				argList.add("-"+format);
			else
				throw new org.apache.tools.ant.BuildException("improper format: "+format);

		// Readonly
		if(readOnly)
			argList.add("-readOnly");

		// Verbose
		if(verbose)
			argList.add("-verbose");

		// Extension
		if(extension)
			argList.add("-extension");

		// Quiet
		if(quiet)
			argList.add("-quiet");

		// No validate
		if(noValidate)
			argList.add("-nv");

		// Enable introspection
		if(enableIntrospection)
			argList.add("-enableIntrospection");

		// Enable introspection
		if(disableXmlSecurity)
			argList.add("-disableXmlSecurity");

		// No package annotations
		if(noPackageAnnotations)
			argList.add("-npa");

		// No package annotations
		if(noHeader)
			argList.add("-no-header");

		// Content for wildcard
		if(contentForWildcard)
			argList.add("-contentForWildcard");

		// Mark generated
		if(markGenerated)
			argList.add("-mark-generated");

		// Package
		if(_package!=null)
		{
			argList.add("-p");
			argList.add(_package);
		}

		// Catalog
		if(catalog!=null)
		{
			argList.add("-catalog");
			argList.add(catalog);
		}

		// Class path
		if(!classpath.toString().isEmpty())
		{
			argList.add("-classpath");
			argList.add(classpath.toString());
		}

		// Encoding
		if(encoding!=null)
		{
			argList.add("-encoding");
			argList.add(encoding);
		}

		// HTTP proxy
		if(httpProxy!=null)
		{
			argList.add("-httpproxy");
			argList.add(httpProxy);
		}

		// HTTP proxy file
		if(httpProxy!=null)
		{
			argList.add("-httpproxyfile");
			argList.add(httpProxyFile);
		}

		// Output directory
		if(destdir!=null)
		{
			argList.add("-d");
			argList.add(destdir);
		}

		// Target
		if(target!=null)
		{
			argList.add("-target");
			argList.add(target);
		}

		// Binding
		for(String item: binding)
		{
			argList.add("-b");
			argList.add(item);
		}

		// Schema
		argList.addAll(schema);

		log("[DEBUG] Arguments: "+String.join(" | ", argList), org.apache.tools.ant.Project.MSG_DEBUG);

		try
		{
			int ret=com.sun.tools.internal.xjc.Driver.run(argList.toArray(new String[0]), System.out, System.out);
			if(ret!=0)
				throw new org.apache.tools.ant.BuildException("XJC returned: "+ret);
		}
		catch(final org.apache.tools.ant.BuildException e)
		{
			if(failOnError)
				throw e;
			else
				log("[ERROR] "+e.getMessage(), org.apache.tools.ant.Project.MSG_ERR);
		}
		catch(final Exception e)
		{
			if(failOnError)
				throw new org.apache.tools.ant.BuildException(e.getMessage());
			else
				log("[ERROR] "+e.getMessage(), org.apache.tools.ant.Project.MSG_ERR);
		}
	}

	/**
	 *	Specifies the directory where the generated files will go.
	 *
	 *	@param value the name of the directory.
	 */
	public void setDestdir(final String value)	{ destdir=value; }

	public void setSchema(final String value)	{ this.schema.add(value); }

	/**
	 *	Specifies where to find user class files.
	 *
	 *	@param path the classpath.
	 */
	public void setClasspath(final org.apache.tools.ant.types.Path path)
	{
		classpath.append(path);
	}

	/**
	 *	Specifies where to find user class files as reference to a path.
	 *
	 *	@param ref the reference.
	 */
	public void setClasspathRef(final org.apache.tools.ant.types.Reference ref)
	{
		classpath.setProject(getProject());
		classpath.setRefid(ref);
	}

	/**
	 *	Specifies the target package.
	 *
	 *	@param value the name of the target package.
	 */
	public void setPackage(final String value)	{ _package=value; }

	/**
	 *	Specifies whether XJC will behave like XJC 2.0 or 2.1 and generate code
	 *	that doesn’t use any 2.2 features. Possible values are {@code "2.0"} or
	 *	{@code "2.1"}.
	 *
	 *	@param value the target version.
	 */
	public void setTarget(final String value)	{ target=value; }

	/**
	 *	Specifies whether generated files will be in read-only mode.
	 *
	 *	@param value a Boolean value.
	 */
	public void setReadonly(final boolean value)	{ readOnly=value; }

	/**
	 *	Specifies whether the XJC output will be extra verbose.
	 *
	 *	@param value a Boolean value.
	 */
	public void setVerbose(final boolean value) { verbose=value; }

	/**
	 *	Specifies whether the XJC output will be supressed.
	 *
	 *	@param value a Boolean value.
	 */
	public void setQuiet(final boolean value)	{ quiet=value; }

	/**
	 *	Specifies whether correct generation of Boolean getters/setters
	 *	to enable Bean Introspection apis will be enabled.
	 *
	 *	@param value a Boolean value.
	 */
	public void setEnableIntrospection(final boolean value)	{ enableIntrospection=value; }

	/**
	 *	Specifies whether generate content property for types with multiple
	 *	{@code xs:any} derived elements.
	 *
	 *	@param value a Boolean value.
	 */
	public void setContentForWildcard(final boolean value)	{ contentForWildcard=value; }

	/**
	 *	Specifies whether the XML security features when parsing XML documents
	 *	will be disabled.
	 *
	 *	@param value a Boolean value.
	 */
	public void setDisableXmlSecurity(final boolean value)	{ disableXmlSecurity=value; }

	/**
	 *	Specifies whether strict validation of the input schema(s) will be
	 *	supressed.
	 *
	 *	@param value a Boolean value.
	 */
	public void setNoValidate(final boolean value)	{ noValidate=value; }

	/**
	 *	Specifies whether the generation of a file header with timestamp will
	 *	be supressed.
	 *
	 *	@param value a Boolean value.
	 */
	public void setNoHeader(final boolean value)	{ noHeader=value; }

	/**
	 *	Specifies the format of the schema. Possible values are {@code
	 *	"xmlschema"}, {@code "relaxng"}, {@code "relaxng-compact"}, {@code
	 *	"dtd"}, {@code "wsdl"}.
	 *
	 *	@param value the name of the format.
	 */
	public void setFormat(final String value)
	{
		if(value.equals("xmlschema")
				|| value.equals("relaxng")
				|| value.equals("relaxng-compact")
				|| value.equals("dtd")
				|| value.equals("wsdl"))
			format=value;
		else
			; // TODO
	}

	public void setExtension(final boolean value)	{ extension=value; }

	/**
	 *	Specifies whether compilation errors will fail the build.
	 *
	 *	@param value a Boolean value.
	 */
	public void setFailOnError(final boolean value)	{ failOnError=value; }

	/**
	 *	Specifies whether the generated code will be marked as
	 *	{@code @}{@link javax.annotation.Generated}.
	 *
	 *	@param value a Boolean value.
	 */
	public void setMarkGenerated(final boolean value)	{ markGenerated=value; }

	/**
	 *	Specifies catalog files to resolve external entity references. Support
	 *	TR9401, XCatalog, and OASIS XML Catalog format.
	 *
	 *	@param value the name of the catalog file.
	 */
	public void setCatalog(final String value)	{ catalog=value; }

	/**
	 *	Specifies HTTP/HTTPS proxy. Format is {@code
	 *	[user[:password]@]proxyHost:proxyPort}.
	 *
	 *	@param value the HTTP/HTTPS proxy.
	 */
	public void setHttpProxy(final String value)	{ httpProxy=value; }

	/**
	 *	Specifies HTTP/HTTPS proxy in a file to protect password.
	 *
	 *	@param value the HTTP/HTTPS proxy.
	 *	@see #setHttpProxy(String)
	 */
	public void setHttpProxyFile(final String value)	{ httpProxyFile=value; }

	/**
	 *	Specifies character encoding for generated source files.
	 *
	 *	@param value the character encoding.
	 */
	public void setEncoding(final String value)	{ encoding=value; }

	public void setRemoveOldInput(final String value)	{ removeOldInput=value; }

	// Nested elements

	private java.util.ArrayList<String> schema=new java.util.ArrayList<String>();
	private java.util.ArrayList<String> binding=new java.util.ArrayList<String>();

	private String
		destdir,
		_package,
		target,
		stackSize,
		catalog,
		removeOldInput,
		format,
		httpProxy,
		httpProxyFile,
		encoding;

	private org.apache.tools.ant.types.Path classpath
		=new org.apache.tools.ant.types.Path(getProject());

	private boolean
		extension,
		readOnly,
		verbose,
		quiet,
		noValidate,
		noPackageAnnotations,
		noHeader,
		contentForWildcard,
		enableIntrospection,
		disableXmlSecurity,
		markGenerated,
		failOnError;

	public static class Schema
		implements org.apache.tools.ant.types.ResourceCollection
	{
		public Schema()
		{
		}

		public boolean isFilesystemOnly()
		{
			return false;
		}

		public int size()
		{
			return resources.size();
		}

		public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator()
		{
			return resources.iterator();
		}

		public void addConfiguredFileSet(final org.apache.tools.ant.types.FileSet fileSet)
		{
			for(org.apache.tools.ant.types.Resource item: fileSet)
				resources.add(item);
		}

		public void addConfiguredDirSet(final org.apache.tools.ant.types.DirSet dirSet)
		{
			for(org.apache.tools.ant.types.Resource item: dirSet)
				resources.add(item);
		}

		private java.util.ArrayList<org.apache.tools.ant.types.Resource> resources
			=new java.util.ArrayList<org.apache.tools.ant.types.Resource>();
	}

	public static class Binding
		implements org.apache.tools.ant.types.ResourceCollection
	{
		public Binding()
		{
		}

		public boolean isFilesystemOnly()
		{
			return false;
		}

		public int size()
		{
			return resources.size();
		}

		public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator()
		{
			return resources.iterator();
		}

		public void addConfiguredFileSet(final org.apache.tools.ant.types.FileSet fileSet)
		{
			for(org.apache.tools.ant.types.Resource item: fileSet)
				resources.add(item);
		}

		private java.util.ArrayList<org.apache.tools.ant.types.Resource> resources
			=new java.util.ArrayList<org.apache.tools.ant.types.Resource>();
	}

	/**
	 *	Add the nested {@code schema} element.
	 *
	 *	@param schema the schema element.
	 */
	public void addConfiguredSchema(final Schema schema)
	{
		for(org.apache.tools.ant.types.Resource item: schema)
			this.schema.add(item.toString());
	}

	/**
	 *	Add the nested {@code binding} element.
	 *
	 *	@param binding the binding element.
	 */
	public void addConfiguredBinding(final Binding binding)
	{
		for(org.apache.tools.ant.types.Resource item: binding)
			this.binding.add(item.toString());
	}

}
