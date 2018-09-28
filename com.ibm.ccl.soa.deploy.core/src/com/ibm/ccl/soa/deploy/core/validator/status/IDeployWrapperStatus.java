/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.status;

/**
 * A status that wraps another status.
 * <p>
 * Used express errors on other objects. Example: a hosting link has an error because the capability
 * of the hoster does not match a requirement expression of the hosted. In such cases, it is not
 * appropriate to directly mark the capability of the hoster. One creates a mark on the hosting link
 * which contains the mark on the capability.
 */
public interface IDeployWrapperStatus extends IDeployStatus {

	/**
	 * Identifies the deploy wrapped status.
	 */
	public static final String WRAPPED_STATUS = "deployWrappedStatus_"; //$NON-NLS-1$

	/**
	 * @return the wrapped status.
	 */
	public IDeployStatus getWrappedStatus();

	/**
	 * Sets the status that is wrapped.
	 * 
	 * @param status
	 *           the wrapped status.
	 */
	public void setWrappedStatus(IDeployStatus status);
}
