/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import java.util.List;

import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;

/**
 * A deploy status resolution that is parameterized.
 */
public interface IDeployParameterizedResolution extends IDeployResolution {

	/**
	 * Returns the parameters of the resolution.
	 * <p>
	 * The resolution parameters are bound to the current resolution.
	 * 
	 * @return a list of resolution parameters (never null).
	 */
	public List<IDataModel> getParameters();
}
