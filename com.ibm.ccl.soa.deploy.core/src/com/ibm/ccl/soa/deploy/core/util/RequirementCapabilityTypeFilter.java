/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;

/**
 * Filters requirements with a matching capability type.
 */
public class RequirementCapabilityTypeFilter implements IObjectFilter<Requirement> {

	protected final EClass dmoType;

	/**
	 * Construct a filter for {@link Requirement} instances whose {@link Requirement#getDmoEType()}
	 * is a super type of the parameter <code>capabilityType</code>.
	 * 
	 * @param capabilityType
	 *           the capability type of the requirement (null, or a subtype of {@link Capability}).
	 */
	public RequirementCapabilityTypeFilter(EClass dmoType) {
		if (dmoType != null && !CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(dmoType)) {
			throw new IllegalArgumentException(dmoType.getName());
		}
		this.dmoType = dmoType;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.IObjectFilter#accept(java.lang.Object)
	 */
	public boolean accept(Requirement value) {
		if (!(value instanceof Requirement)) {
			return false;
		}
		Requirement req = value;
		if (dmoType == null) {
			return req.getDmoEType() == null;
		}
		if (req.getDmoEType() == null) {
			return false;
		}
		return dmoType.isSuperTypeOf(req.getDmoEType());
	}
}
