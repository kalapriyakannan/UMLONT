/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;

public abstract class ServerRuntimeCapabilityProvider extends J2EEModuleCapabilityProvider {

	//TODO eventually move this class to a j2ee.ide plugin

	public Object[] resolveCapabilities(Object anObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] resolveRequirements(Object anObject) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Requirement createServerRequirement(String version, EClass eClass,
			EAttribute eAttribute, String name) {
		Requirement req = CoreFactory.eINSTANCE.createRequirement();
		req.setDmoEType(eClass);
		req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
//		req.getExpressions().add(Equals.createExpression(eAttribute, version));
		req.getConstraints().add(createVersionConstraint(eAttribute, version));
		req.setName(name + "_" + version.replace('.', '_')); //$NON-NLS-1$

		return req;
	}

}
