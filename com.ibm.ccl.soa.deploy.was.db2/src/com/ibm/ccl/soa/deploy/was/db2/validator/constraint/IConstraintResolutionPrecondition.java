/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Guard that must hold for a given implementation.
 */
public interface IConstraintResolutionPrecondition {

	/**
	 * Determine if a resolution precondition holds.
	 * 
	 * @param constraint
	 *           the constraint on which to evaluate the guard
	 * @param constraintContext
	 *           the context in which the constraint should be evaludated
	 * @param monitor
	 *           progress monitor
	 * @return OK status if guard holds
	 */
	public IStatus evaluate(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor);

}
