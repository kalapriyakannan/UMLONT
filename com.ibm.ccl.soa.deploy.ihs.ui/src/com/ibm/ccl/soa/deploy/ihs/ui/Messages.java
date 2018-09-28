/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ihs.ui.messages"; //$NON-NLS-1$

	public static String IhsUserEditPart_Ihs_User;

	public static String IhsServerEditPart_IHS_Server;

	public static String IhsSystemEditPart_IHS_System;

	public static String IhsWasAdminModuleEditPart_IHS_Was_Admin_Module;

	public static String IhsWasModuleEditPart_IHS_WAS_Module;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
