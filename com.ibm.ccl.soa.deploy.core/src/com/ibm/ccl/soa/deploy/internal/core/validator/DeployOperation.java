/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

/**
 * Abstract implementation of {@link IDeployOperation}.
 */
public abstract class DeployOperation implements IDeployOperation {
	protected String displayName;

	/**
	 * Construct a deploy operation.
	 * 
	 * @param displayName
	 *           the user friendly operation name.
	 */
	public DeployOperation(String displayName) {
		this.displayName = displayName;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.IDeployOperation#getDisplayName()
	 */
	public String getDisplayName() {
		return displayName;
	}
}
