/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.runtime.IStatus;

public final class Flags {

	/**
	 * Returns whether the given integer includes an indication of being a possible WireSource.
	 * 
	 * @param status -
	 *           The status from from a given {@link DeployModelObject}.
	 * @return boolean
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	public static boolean isFailedResolutionStatus(IStatus status) {
		if (status == null || status.isOK())
			return false;
		int statusCode = status.getCode();
		return (statusCode & IConstants.S_FAILED_RESOLUTION) != 0;
	}

}
