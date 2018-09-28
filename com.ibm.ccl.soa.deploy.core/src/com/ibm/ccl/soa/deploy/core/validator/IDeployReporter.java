/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Logging interface for reporting validation errors.
 */
public interface IDeployReporter {

	/**
	 * Report a deploy status.
	 * <p>
	 * Deploy statutes are associated with a {@link IDeployStatus#getDeployObject()}. The behavior
	 * of this method will vary across implementations. Some may immediately post the status unto the
	 * deploy object using {@link DeployModelObject#addStatus(IStatus)}, others may queue the status
	 * for latter addition, yet others may use this interface to log statuses that will not be added
	 * to their objects.
	 * 
	 * @param status
	 *           a deploy status to be reported.
	 */
	void addStatus(IDeployStatus status);
}
