package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;

public class UpdateConstraintValidator extends ConstraintValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;
	}

}
