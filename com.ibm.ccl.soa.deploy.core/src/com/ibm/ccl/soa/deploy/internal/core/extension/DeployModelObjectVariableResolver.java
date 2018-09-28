/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.expressions.IVariableResolver;
import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * 
 */
public class DeployModelObjectVariableResolver implements IVariableResolver {

	private static final String UNIT = "com.ibm.ccl.soa.deploy.DeployModelObject.unit"; //$NON-NLS-1$

	/**
	 * DeployModelObject for which the properties will be resolved.
	 */
	private final DeployModelObject dmo;

	/**
	 * Public constructor.
	 * 
	 * @param object
	 *           DeployModelObject
	 */
	public DeployModelObjectVariableResolver(DeployModelObject object) {
		dmo = object;
	}

	public Object resolve(String name, Object[] args) throws CoreException {
		if (dmo == null) {
			return null;
		}
		if (UNIT.equals(name)) {
			return ValidatorUtils.getUnit(dmo);
		}
		return null;
	}
}
