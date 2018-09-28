package com.ibm.ccl.soa.deploy.analysis.internal.validator.constraints;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

public class DailyLoadConstraintValidator extends ConstraintValidator {

	public DailyLoadConstraintValidator() {
		super();
	}
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}
	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return AnalysisPackage.Literals.DAILY_LOAD_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!AnalysisPackage.Literals.DAILY_LOAD_CONSTRAINT.isSuperTypeOf(constraint
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
		DailyLoadConstraint ac = (DailyLoadConstraint) constraint;		
		return AnalysisMessages.bind(AnalysisMessages.DAILY_LOAD_CONSTRAINT, computeCaptionTitle(ac),String.valueOf(ac.getDailyLoad().doubleValue()));
	}
}
