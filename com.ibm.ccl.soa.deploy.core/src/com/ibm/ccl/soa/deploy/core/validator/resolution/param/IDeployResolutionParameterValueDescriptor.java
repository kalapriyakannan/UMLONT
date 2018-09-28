/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

/**
 * A descriptor for a possible value of a resolution parameter.
 */
public interface IDeployResolutionParameterValueDescriptor {

	/**
	 * Returns the value associated with the descriptor.
	 * 
	 * @return the value of the resolution parameter.
	 */
	public Object getValue();

	/**
	 * @return a description of the resolution parameter value.
	 */
	public String getDescription();
}
