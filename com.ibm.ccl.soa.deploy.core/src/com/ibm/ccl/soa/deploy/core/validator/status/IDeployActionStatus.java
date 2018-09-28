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

import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Status associated with the attribute of a deploy model object.
 */
public interface IDeployActionStatus extends IDeployStatus {

	/**
	 * @return the name of the deploy model object attribute associated with this status.
	 */
	public List<DeployModelObject> getParameters();
}
