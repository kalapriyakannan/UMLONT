package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Provides a post-processing hook for structural validators that perform graph-summation operations
 * over the Topology.
 * 
 */
public class StructuralDomainValidator extends DomainValidator implements InternalDomainValidator {

	@Override
	protected DomainMatcher createDomainMatcher() {
		// domain matcher should not be supported by this validator
		return null;
	}

	@Override
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		// report no statuses; we only get called as a post-process hook for Structural Validators

	}

	@Override
	public String getGroupID() {
		return IConstants.DEFAULT_VALIDATOR_GROUP_ID;
	}

	public void filterStatusList(IDeployValidationContext context,
			List<IDeployStatus> proposedStatuses) {

		// look for constraint validators that implement InternalConstraintValidator 
		// collect available types of constraints
		Set<EClass> availableConstraints = new HashSet<EClass>();
		for (IDeployStatus status : proposedStatuses) {
			if (status.getConstraints() != null && !status.getConstraints().isEmpty()) {
				for (Constraint c : status.getConstraints()) {
					availableConstraints.add(c.eClass());
				}
			}

		}

		for (EClass constraintType : availableConstraints) {
			List<ConstraintValidator> validators = ConstraintService.INSTANCE
					.getValidators(constraintType);
			for (ConstraintValidator validator : validators) {
				if (validator instanceof InternalConstraintValidator) {
					((InternalConstraintValidator) validator).postProcess(proposedStatuses);
				}
			}
		}

	}

}
