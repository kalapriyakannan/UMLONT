/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui;

import org.eclipse.osgi.util.NLS;

/**
 * Externalized messages
 * 
 * @since 3.2
 * 
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.internal.saf.ui.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String ccl_soa_core_component_attributeKindMissing;
	public static String ccl_soa_core_component_attributeNameMissing;
	public static String InterfaceUIHandlerDescriptor_An_instance_of_AbstractUIInterfaceHandler_is_required;
	public static String UIHandlerDescriptor_Invalid_number_of_enablement_expres_;
	public static String WizardShortcutAction_Could_not_open_the_wizard_due_to_th_;
	public static String WizardShortcutAction_Problem_Opening_Wizar_;
}
