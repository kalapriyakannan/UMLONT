/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * Filters deploy model object models by EClass type.
 */
public class TypeObjectFilter implements IObjectFilter {

	protected final EClass type;

	/**
	 * Filter deploy model objects by type.
	 * 
	 * @param type
	 *           the deploy model object type.
	 * 
	 * @see DeployModelObject
	 */
	public TypeObjectFilter(EClass type) {
		assert type != null;
		this.type = type;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.ObjectFilter#checkFilterAccept(java.lang.Object)
	 */
	public boolean accept(Object value) {
		if (value == null) {
			return false;
		}

		if (!(value instanceof DeployModelObject)) {
			return false;
		}

		return type.isSuperTypeOf(((DeployModelObject) value).getEObject().eClass());

	}
}
