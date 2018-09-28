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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;

/**
 * Validator for {@link CommunicationConstraintChildValidator}. Relies on a context that includes a
 * target constraint to validate against.
 */
public abstract class CommunicationConstraintChildValidator extends ConstraintValidator {

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		return Status.CANCEL_STATUS;
	}

	/**
	 * Validate method that takes a context containing the target constraint against which the
	 * validation should take place.
	 * 
	 * @param constraint
	 *           the constraint to be validated
	 * @param context
	 *           the context in which it should be validated
	 * @param monitor
	 *           a progress monitor
	 * @return status of the constraint
	 */
	public abstract IStatus validateWithContext(Constraint constraint, CVC context,
			IProgressMonitor monitor);

	/**
	 * Create a list of attribute value pairs that should be set when creating a corresponding
	 * constraint as a child of a {@link NetworkCommunicationConstraint}.
	 * 
	 * @param constraint
	 *           the source constraint
	 * @return list of attribute, value pairs
	 */
	public List<AttributeValuePair> getExpectedAttributeData(Constraint constraint) {
		return Collections.emptyList();
	}
}
