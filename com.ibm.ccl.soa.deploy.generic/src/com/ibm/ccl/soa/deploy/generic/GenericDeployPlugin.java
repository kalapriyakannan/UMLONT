/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.ibm.ccl.soa.deploy.generic.provider.GenericEditPlugin;
import com.ibm.ccl.soa.deploy.generic.provider.GenericEditPlugin.Implementation;

/**
 * The activator class controls the plug-in life cycle
 */
public class GenericDeployPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.ibm.ccl.soa.deploy.generic"; //$NON-NLS-1$

	// The shared instance
	private static GenericDeployPlugin plugin;

	private Implementation implementation;

	/**
	 * The constructor
	 */
	public GenericDeployPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		implementation = new GenericEditPlugin.Implementation();
		implementation.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		implementation.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static GenericDeployPlugin getDefault() {
		return plugin;
	}

}
