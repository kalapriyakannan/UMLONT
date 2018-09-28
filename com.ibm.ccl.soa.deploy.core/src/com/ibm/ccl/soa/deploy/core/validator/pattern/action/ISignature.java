/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Definition of an action signature.
 */
public interface ISignature {

	/**
	 * Determine whether or not the list of parameters provided satisfies the types defined by the
	 * signature
	 * 
	 * @param parameters
	 *           list of parameters
	 * @return true if the parameters satisfy the instance
	 */
	public boolean isValidInstance(List<DeployModelObject> parameters);

	/**
	 * @return the number of arguments or parameters identified by the signature
	 */
	public int getNumberParameters();

	/**
	 * Retrieve a parameter type
	 * 
	 * @param index
	 *           the index of the parameter type desired
	 * @return the parameter type
	 */
	public EClass get(int index);

}
