/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

public class ExpectedLifespanConstraintValidator extends ConstraintValidator {
	
	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return AnalysisPackage.Literals.EXPECTED_LIFESPAN_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		if (!AnalysisPackage.Literals.EXPECTED_LIFESPAN_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			// we don't know how to validate this constraint
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

/*		// we know that it is a AvailabilityConstraint
		ExpectedLifespanConstraint ec = (ExpectedLifespanConstraint) constraint;

		DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
				IAnalysisDomainValidators.DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT, ICoreProblemType.HOSTING_LINK_TARGET_UNDEFINED,
				AnalysisMessages.DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT, new Object[] {
				availabilityConstraint.getName()}, availabilityConstraint);*/

		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

	public String title(Constraint constraint) {
		ExpectedLifespanConstraint c = (ExpectedLifespanConstraint) constraint;		
		return AnalysisMessages.bind(AnalysisMessages.EXPECTED_LIFESPAN_TITLE, new String[]{computeCaptionTitle(c), c.getState().getLiteral()
				, String.valueOf(c.getDuration())});
	}

}
