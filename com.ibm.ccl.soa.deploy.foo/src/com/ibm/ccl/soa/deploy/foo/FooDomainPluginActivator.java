package com.ibm.ccl.soa.deploy.foo;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FooDomainPluginActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ibm.ccl.soa.deploy.foo";

	// The shared instance
	private static FooDomainPluginActivator plugin;
	
	/**
	 * The constructor
	 */
	public FooDomainPluginActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FooDomainPluginActivator getDefault() {
		return plugin;
	}

}
