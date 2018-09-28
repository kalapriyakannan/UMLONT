/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf;

import org.eclipse.osgi.util.NLS;

/**
 * 
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String ccl_soa_core_component_attributeNameMissing;
	public static String ccl_soa_core_component_attributeIconInvalid;
	public static String ccl_soa_core_component_attributeKindMissing;
	public static String InterfaceHandlerDescriptor_Invalid_number_of_enablement_expres_;
	public static String InterfaceHandlerDescriptor_The_0_extension_defined_by_1_do_;
	public static String InterfaceHandlerDescriptor_An_instance_of_0_for_the_1_attr_;

}
