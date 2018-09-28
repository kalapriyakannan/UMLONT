/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;

/**
 * Default validation for network communication constraints
 */
public class NetworkCommunicationConstraintValidator extends ConstraintValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return null != constraint
				&& ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT.isSuperTypeOf(constraint
						.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		// TODO Add appropriate logic
		return Status.OK_STATUS;
	}

}
