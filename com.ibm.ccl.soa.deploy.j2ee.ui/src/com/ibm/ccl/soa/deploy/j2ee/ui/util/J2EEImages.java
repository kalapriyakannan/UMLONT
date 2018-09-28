/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.util;

import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.j2ee.ui.J2EEUIDeployPlugin;

public class J2EEImages {
	// images
	public static final Image MODULE__IMAGE = createImage("icons/images/module.gif"); //$NON-NLS-1$
	public static final Image SERVER__IMAGE = createImage("icons/images/server.gif"); //$NON-NLS-1$

	private static Image createImage(String path) {
		return J2EEUIDeployPlugin.getImageDescriptor(path).createImage();
	}
}
