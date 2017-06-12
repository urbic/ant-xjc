package coneforest.ant.xjc;

public class Xjc
	extends org.apache.tools.ant.Task
{
	@Override
	public void execute()
		throws org.apache.tools.ant.BuildException
	{
		java.util.ArrayList<String> argList=new java.util.ArrayList<String>();

		// Format
		if(format!=null)
			argList.add("-"+format);

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
		if(classpath!=null)
		{
			argList.add("-classpath");
			argList.add(classpath);
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

		try
		{
			int ret=com.sun.tools.internal.xjc.Driver.run(argList.toArray(new String[0]), System.out, System.out);
			if(ret!=0)
				throw new org.apache.tools.ant.BuildException();
		}
		catch(final org.apache.tools.ant.BuildException e)
		{
			if(failOnError)
				throw e;
			else
				System.err.println("[ERROR] "+e.getMessage());
		}
		catch(final Exception e)
		{
			if(failOnError)
				throw new org.apache.tools.ant.BuildException(e.getMessage());
			else
				System.err.println("[ERROR] "+e.getMessage());
		}
	}

	public void setDestdir(final String value)	{ destdir=value; }

	public void setSchema(final String value)	{ this.schema.add(value); }

	public void setClasspath(final String value)	{ classpath=value; }

	public void setPackage(final String value)	{ _package=value; }

	public void setTarget(final String value)	{ target=value; }

	public void setReadonly(final boolean value)	{ readOnly=value; }

	public void setVerbose(final boolean value) { verbose=value; }

	public void setQuiet(final boolean value)	{ quiet=value; }

	public void setEnableIntrospection(final boolean value)	{ enableIntrospection=value; }

	public void setContentForWildcard(final boolean value)	{ contentForWildcard=value; }

	public void setDisableXmlSecurity(final boolean value)	{ disableXmlSecurity=value; }

	public void setNoValidate(final boolean value)	{ noValidate=value; }

	public void setNoGeader(final boolean value)	{ noHeader=value; }

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

	public void setFailOnError(final boolean value)	{ failOnError=value; }

	public void setMarkGenerated(final boolean value)	{ markGenerated=value; }

	public void setCatalog(final String value)	{ catalog=value; }

	public void setHttpProxy(final String value)	{ httpProxy=value; }

	public void setHttpProxyFile(final String value)	{ httpProxyFile=value; }

	public void setEncoding(final String value)	{ encoding=value; }

	public void setRemoveOldInput(final String value)	{ removeOldInput=value; }

	// Nested elements

	public Arg createArg()
	{
		final Arg arg=new Arg();
		argList.add(arg);
		return arg;
	}

	private final java.util.ArrayList<Arg> argList
		=new java.util.ArrayList<Arg>();

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
		encoding,
		classpath;

	boolean
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

	public void addConfiguredSchema(final Schema schema)
	{
		for(org.apache.tools.ant.types.Resource item: schema)
			this.schema.add(item.toString());
	}

	public void addConfiguredBinding(final Binding binding)
	{
		for(org.apache.tools.ant.types.Resource item: binding)
			this.binding.add(item.toString());
	}

	public class Classpath
	{
		public Classpath()
		{
		}

		public void setValue(final String value)
		{
			this.value=value;
		}

		public String getValue()
		{
			return value;
		}

		private String value;
	}

	public class Arg
	{
		public Arg()
		{
		}

		public void setValue(final String value)
		{
			this.value=value;
		}

		public String getValue()
		{
			return value;
		}

		private String value;
	}

	public class Depends
	{
		public Depends()
		{
		}

		public void setValue(final String value)
		{
			this.value=value;
		}

		public String getValue()
		{
			return value;
		}

		private String value;
	}

	public class Produces
	{
		public Produces()
		{
		}

		public void setValue(final String value)
		{
			this.value=value;
		}

		public String getValue()
		{
			return value;
		}

		private String value;
	}
}
