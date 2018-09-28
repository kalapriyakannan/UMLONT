/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * A service to compute a list of valid values from a set of {@link AttributeValueConstraint}
 * defined in the {@link ConstraintPackage}.
 * <p>
 * Generic solver defers to constraint validators implementing {@link IAttributeConstraintSolver}
 * 
 * @see ConstraintService#getValidators(org.eclipse.emf.ecore.EClass)
 */
public class AttributeConstraintSolverService {

	/**
	 * Status used to indicate an invalid parameter.
	 */
	private static final IStatus INVALID_PARAMETER_STATUS = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0, IllegalArgumentException.class.getSimpleName(), null);

	/**
	 * A non-exclusive valid value result with an error status.
	 */
	public static final AttributeValues INVALID_RESULT = new AttributeValues(null, false, null,
			Collections.singletonList(INVALID_PARAMETER_STATUS));

	/**
	 * An exclusive result with no valid values.
	 */
	public static final AttributeValues NO_VALUES_RESULT = new AttributeValues(null, true, null,
			null);
	/**
	 * 
	 * An non-exclusive result with no values.
	 */
	public static final AttributeValues OPEN_RESULT = new AttributeValues(null, false, null, null);

	/**
	 * Singleton instance of the class.
	 */
	private final static AttributeConstraintSolverService DEFAULT = new AttributeConstraintSolverService();

	/**
	 * @return the singleton instance of the class.
	 */
	public static AttributeConstraintSolverService getInstance() {
		return DEFAULT;
	}

	private AttributeConstraintSolverService() {
		// prevent instantiation
	}

	/**
	 * Returns true if the solver can solve the attribute constraints associated with the status.
	 * <p>
	 * This is a more efficient method to invoke than {@link #getValidValues(IDeployAttributeStatus)},
	 * but may return true even if no solutions exist.
	 * 
	 * @param status
	 *           a deploy status.
	 * @return true if the solver can resolve (not necessarily will have solutions).
	 */
	public boolean canSolve(IDeployStatus status) {
		if (status == null) {
			return false;
		}
		if (status instanceof IDeployAttributeValueStatus) {
			return true;
		}
		if (status.getConstraints() != null) {
			for (Constraint c : status.getConstraints()) {
				if (hasAttributeSolver(c)) {
					return true;
				}
			}
		}
		if (status.getDeployObject() != null) {
			for (Constraint c : (List<Constraint>) status.getDeployObject().getConstraints()) {
				if (hasAttributeSolver(c)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns true if the constraint has a solver.
	 * 
	 * @param constraint
	 *           a deploy constraint.
	 * @return true if a constraint validator implementing {@link IAttributeConstraintSolver} exists.
	 */
	private boolean hasAttributeSolver(Constraint constraint) {
		List<ConstraintValidator> validators = ConstraintService.INSTANCE.getValidators(constraint
				.getEObject().eClass());
		for (ConstraintValidator validator : validators) {
			if (validator instanceof IAttributeConstraintSolver
					&& validator.canValidateConstraint(constraint)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the the valid values for the attribute identified by the status object.
	 * 
	 * @param status
	 *           a status identifying a deploy object and attribute.
	 * @return the attribute values that can be assigned to the attribute of the object.
	 */
	public AttributeValues getValidValues(IDeployAttributeStatus status) {
		if (status == null) {
			return new AttributeValues();
		}

		// Merge the status and object constraints
		List<Constraint> constraints;
		if (status.getDeployObject() == null || status.getDeployObject().getConstraints().isEmpty()) {
			constraints = status.getConstraints();
		} else if (status.getConstraints() == null || status.getConstraints().isEmpty()) {
			constraints = status.getDeployObject().getConstraints();
		} else {
			constraints = new ArrayList<Constraint>(status.getDeployObject().getConstraints());
			for (Constraint c : status.getConstraints()) {
				// Check if the constraint is already included directly or indirectly via containment in another constraint
				Constraint curr = c;
				boolean contained = false;
				while (curr != null) {
					if (constraints.contains(curr)) {
						contained = true;
						break;
					}
					if (curr.getParent() instanceof Constraint) {
						curr = (Constraint) curr.getParent();
					} else {
						curr = null;
					}
				}
				if (!contained) {
					constraints.add(c);
				}
			}
		}
		if (constraints == null || constraints.isEmpty()) {
			AttributeValues result = new AttributeValues();
			if (status instanceof IDeployAttributeValueStatus) {
				if (status.getConstraints() == null || status.getConstraints().isEmpty()) {
					IDeployAttributeValueStatus vStatus = (IDeployAttributeValueStatus) status;
					result.getValidValues().add(vStatus.getAttributeExpectedValue());
				}
			}
			return result;
		}

		AttributeValues result = getValidValues(status.getDeployObject(), status.getAttributeType(),
				constraints);
		if (status instanceof IDeployAttributeValueStatus) {
			if (status.getConstraints() == null || status.getConstraints().isEmpty()) {
				IDeployAttributeValueStatus vStatus = (IDeployAttributeValueStatus) status;
				result.getValidValues().add(vStatus.getAttributeExpectedValue());
			}
		}
		return result;
	}

	/**
	 * Returns the valid values for the object's attribute based on the constraints on the object.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param attribute
	 *           a deploy attribute on the object.
	 * @return the attribute values that can be assigned to the attribute of the object.
	 */
	public AttributeValues getValidValues(DeployModelObject object, EAttribute attribute) {
		if (object == null || attribute == null) {
			return new AttributeValues();
		}
		return getValidValues(object, attribute, object.getConstraints());
	}

	/**
	 * Returns the valid values associated with the object's attribute based on the constraints
	 * supplied.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param attribute
	 *           a deploy attribute on the object.
	 * @param constraints
	 *           a list of constraints.
	 * @return the attribute values that can be assigned to the attribute of the object.
	 */
	public AttributeValues getValidValues(DeployModelObject object, EAttribute attribute,
			List<Constraint> constraints) {
		if (object == null || attribute == null || constraints == null) {
			return new AttributeValues();
		}
		if (constraints == null || constraints.isEmpty()) {
			return new AttributeValues();
		}

		if (constraints.size() == 1) {
			return getValidValues(object, attribute, constraints.get(0));
		}

		return AndConstraintValidator.getAttributeValues(constraints, object, attribute);
	}

	/**
	 * Returns the valid values associated with the object's attribute based on the constraint
	 * supplied.
	 * 
	 * @param context
	 *           a constraint context.
	 * @param attribute
	 *           the name of an attribute on the deploy object.
	 * @param constraint
	 *           a deploy constraint.
	 * @return the attribute values that can be assigned to the attribute of the object.
	 */
	public AttributeValues getValidValues(Object context, String attribute, Constraint constraint) {
		if (context == null || !(context instanceof DeployModelObject) || attribute == null) {
			return new AttributeValues();
		}
		EAttribute attr = DeployModelObjectUtil.getAttribute((DeployModelObject) context, attribute);
		if (attr == null) {
			return new AttributeValues();
		}
		return getValidValues(context, attr, constraint);
	}

	/**
	 * Returns the valid values associated with the object's attribute based on the constraint
	 * supplied.
	 * 
	 * @param context
	 *           a constraint context.
	 * @param attribute
	 *           an attribute on the deploy object.
	 * @param constraint
	 *           a deploy constraint.
	 * @return the attribute values that can be assigned to the attribute of the object.
	 */
	public AttributeValues getValidValues(final Object context, final EAttribute attribute,
			final Constraint constraint) {
		if (context == null || attribute == null || constraint == null) {
			return new AttributeValues();
		}
		List<ConstraintValidator> validators = ConstraintService.INSTANCE.getValidators(constraint
				.getEObject().eClass());
		for (ConstraintValidator validator : validators) {
			if (validator instanceof IAttributeConstraintSolver
					&& validator.canValidateConstraint(constraint)) {
				final AttributeValues[] resultRef = new AttributeValues[1];
				final IAttributeConstraintSolver solver = (IAttributeConstraintSolver) validator;
				SafeRunner.run(new ISafeRunnable() {
					public void run() throws Exception {
						try {
							resultRef[0] = solver.getAttributeValues(constraint, context, attribute);
						} catch (AssertionError e) {
							handleException(e);
						}
					}

					public void handleException(Throwable e) {
						resultRef[0] = new AttributeValues();
						resultRef[0].getStatusList().add(
								DeployCorePlugin.createErrorStatus(0, e.getLocalizedMessage(), e));
					}
				});
				return resultRef[0];
			}
		}
		return new AttributeValues();
	}
}
