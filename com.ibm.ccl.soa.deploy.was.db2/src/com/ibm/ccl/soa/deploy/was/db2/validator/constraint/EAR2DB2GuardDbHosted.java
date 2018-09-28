/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;

/**
 * Check that target unit is hosted on an OS.
 * <p>
 * The guard is not evaluatable if the input module is not defined.
 * <p>
 * A {@link IStatus#WARNING} is returned if:
 * <ul>
 * <li>At some point an element of the hosting stack is defined as
 * {@link InstallState#INSTALLED_LITERAL} and no further information is available.</li>
 * <li>The unit at the bottom of the hosting stack is public; ie, it can be set if the current
 * topology were imported into another topology.</li>
 * </ul>
 * <p>
 * Otherwise, a {@link IStatus#ERROR} is returned if the hosting operating system cannot be
 * identified.
 */
public class EAR2DB2GuardDbHosted implements IConstraintResolutionPrecondition {

	public IStatus evaluate(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor) {
		Unit targetUnit = EarToDbUtil.getDatabaseUnitFromConstraint(constraint, constraintContext,
				monitor);

		if (null == targetUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		IStatus status = DatasourceSatisfactionConstraintGuardUtils.createOsStatus(targetUnit,
				IWasDb2ProblemType.EAR2DBLL_DB_NOT_HOSTED, Messages.Validator_Ear2DbLL_DB_Not_Hosted,
				constraint, constraintContext, monitor);

		return status;
	}

}
