/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Interface for communication-related status messages.
 */
public interface IDeployCommunicationStatus extends IDeployStatus {

	/**
	 * @return the target object.
	 */
	public DeployModelObject getTargetDmo();
}
