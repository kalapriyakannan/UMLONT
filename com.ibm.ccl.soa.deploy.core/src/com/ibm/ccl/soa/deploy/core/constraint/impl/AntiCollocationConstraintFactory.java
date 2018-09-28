/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.CustomConstraintFactory;

/**
 * Constraint factory for anti-collocation constraint instance.
 */
public class AntiCollocationConstraintFactory extends CustomConstraintFactory {

	public Constraint createConstraint(DeployModelObject parentDMO) {
		CollocationConstraint cc = ConstraintFactory.eINSTANCE.createCollocationConstraint();
		cc.setType(CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);
		cc.setCapabilityEType(CorePackage.eINSTANCE.getCapability());
		return cc;
	}
}
