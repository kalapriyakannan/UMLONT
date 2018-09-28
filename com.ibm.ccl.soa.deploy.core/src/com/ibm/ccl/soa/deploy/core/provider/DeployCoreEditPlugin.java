/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Dynamictype edit plugin. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public final class DeployCoreEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final DeployCoreEditPlugin INSTANCE = new DeployCoreEditPlugin();

	/**
	 * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeployCoreEditPlugin() {
		super(new ResourceLocator[] {});
	}

	public Object getImage(String key) {
		try {
			return super.getImage(key);
		} catch (Exception e) {
			return super.getImage("full/obj16/NotFoundImage"); //$NON-NLS-1$
		}
	}

//	public String getString(String key) {
//		String res = super.getString(key);
//		return res;
//		
//	}

	/**
	 * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
