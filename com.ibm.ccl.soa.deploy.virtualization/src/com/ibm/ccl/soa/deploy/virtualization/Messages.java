/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization;

import org.eclipse.osgi.util.NLS;

/**
 * NLS messages for the {@link VirtualizationPackage} domain.
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = VirtualizationPlugin.PLUGIN_ID + ".Messages";//$NON-NLS-1$
	
	public static String Xen_image;
	public static String Xen_domain_configuration;
	public static String Xen_server_definition;
	public static String Xen_hypervisor;
	public static String Xen_disk_definition;
	public static String Xen_interface_definition;

	public static String VMware_image;
	public static String VMware_image_snapshot_container;
	public static String VMware_domain_configuration;
	public static String VMware_snapshot_configuration;
	public static String VMware_server_definition;
	public static String VMware_hypervisor;
	public static String VMware_disk_definition;
	public static String VMware_interface_definition;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
