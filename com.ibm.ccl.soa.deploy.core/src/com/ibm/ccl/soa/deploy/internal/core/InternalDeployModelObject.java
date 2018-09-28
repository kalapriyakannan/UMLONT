/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * This interface is only intended to be used by the model elements directly and not clients.
 */
public interface InternalDeployModelObject extends DeployModelObject {

	/**
	 * Returns the cached value of the resolved path for the current object.
	 * 
	 * @return The cached value of the resolved path for the current object.
	 */
	String getResolvedPath();

	/**
	 * Return the real container parent.
	 * 
	 * @return the real container parent
	 */
	InternalDeployModelObject getContaintmentParent();

	void releaseResolvedPath();

	DeployModelObject resolve(String path, InternalScopeService service);

} // DeployModelObject
