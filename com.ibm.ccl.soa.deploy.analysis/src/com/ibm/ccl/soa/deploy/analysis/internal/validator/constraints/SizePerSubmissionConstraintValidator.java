package com.ibm.ccl.soa.deploy.analysis.internal.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

public class SizePerSubmissionConstraintValidator extends ConstraintValidator {

	public SizePerSubmissionConstraintValidator() {
		// TODO Auto-generated constructor stub
	}


	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}
	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return AnalysisPackage.Literals.SIZE_PER_SUBMISSION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!AnalysisPackage.Literals.SIZE_PER_SUBMISSION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			// we don't know how to validate this constraint
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}
	
	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	public String title(Constraint constraint) {
		SizePerSubmissionConstraint ac = (SizePerSubmissionConstraint) constraint;
		return AnalysisMessages.bind(AnalysisMessages.SIZE_PER_SUBMISSION_CONSTRAINT, computeCaptionTitle(ac),String.valueOf(ac.getBytes().doubleValue()));
	}



}
