/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

/**
 * Status result of a deploy marker resolution.
 */
public interface IDeployResolutionStatus extends IStatus {

	/**
	 * Returns a list of deploy model objects created during marker resolution.
	 * 
	 * @return List<DeployModelObject>
	 */
	public List getCreatedObjects();

	/**
	 * Returns a list of deploy model objects destroyed during marker resolution.
	 * 
	 * @return List<DeployModelObject>
	 */
	public List getDestroyedObjects();
}
