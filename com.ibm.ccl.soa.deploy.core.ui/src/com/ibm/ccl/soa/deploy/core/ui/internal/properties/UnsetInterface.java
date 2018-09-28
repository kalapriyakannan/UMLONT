/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

public class UnsetInterface {

	private final DeployModelObject dmo;
	private boolean isReference = true;

	public UnsetInterface(DeployModelObject aDeployModelObject) {
		dmo = aDeployModelObject;
	}

	public DeployModelObject getParent() {
		return dmo;
	}

	public boolean isReference() {
		return isReference;
	}

	public void setReference(boolean isReference) {
		this.isReference = isReference;
	}
}
