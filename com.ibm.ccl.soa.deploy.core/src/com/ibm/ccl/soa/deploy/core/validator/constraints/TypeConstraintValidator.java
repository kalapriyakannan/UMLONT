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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator to validate 'TypeConstraint' constraint type.
 */
public class TypeConstraintValidator extends ConstraintValidator {

	/**
	 * 
	 * @see #validateForPotentialMatch(Constraint, DeployModelObject)
	 */
	public IStatus validateForPotentialMatch(Constraint constraint, DeployModelObject context) {
		IStatus superStatus = super.validateForPotentialMatch(constraint, context);
		if (!superStatus.isOK()) {
			return superStatus;
		}
		return innerValidate(constraint, context, null, true);
	}

	/**
	 * 
	 * @see #validate(Constraint, DeployModelObject, IProgressMonitor)
	 */
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		return innerValidate(constraint, context, null, false);
	}

	private IStatus innerValidate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor, boolean validateForPotentialMatch) {

		TypeConstraint typeConstraint = (TypeConstraint) constraint;
		if (context == null) {
			return ConstraintUtil.createNullContextStatus(typeConstraint);
		}
		EClass type = typeConstraint.getDmoEType();

		List<IStatus> statusList = null;
		// If type constraint is the context-switching case
		if (type != null && context instanceof Unit
				&& CorePackage.eINSTANCE.getCapability().isSuperTypeOf(type)
				&& ConstraintUtil.getNonConstraintParent(typeConstraint) != null
				&& ConstraintUtil.getNonConstraintParent(typeConstraint) instanceof Requirement) {
			statusList = validateUnitHasCapabilityConstraint(typeConstraint, context, monitor, type,
					validateForPotentialMatch);
		} else {
			DeployModelObject nonConstraintParent = ConstraintUtil.getNonConstraintParent(typeConstraint);
			if (type != null
					&& nonConstraintParent != null
					&& nonConstraintParent instanceof Requirement
					&& ((Requirement) nonConstraintParent).getLinkType() == RequirementLinkTypes.HOSTING_LITERAL
					&& CorePackage.eINSTANCE.getUnit().isSuperTypeOf(type)
					&& context instanceof Capability) {
				// This is a Hosting Type Constraint for a Unit type, but the context is a Capability:
				// should validate in parent Unit
				DeployModelObject unitContext = context.getParent();
				statusList = validatePureTypeConstraint(typeConstraint, unitContext, monitor, type,
						validateForPotentialMatch);
			} else {
				// Else pure type constraint
				statusList = validatePureTypeConstraint(typeConstraint, context, monitor, type,
						validateForPotentialMatch);
			}
		}

		// Assemble and return status or multiStatus
		IStatus result;
		if (statusList.size() > 0) {
			if (statusList.size() == 1) {
				result = statusList.get(0);
			} else {
				String message = DeployNLS.bind(DeployCoreMessages.Constraints_not_satisfied,
						typeConstraint);
				result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, statusList
						.toArray(new IStatus[statusList.size()]), message, null);
			}
		} else {
			result = DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}
		return result;
	}

	// The pure type constraint case
	private List<IStatus> validatePureTypeConstraint(TypeConstraint typeConstraint,
			DeployModelObject context, IProgressMonitor monitor, EClass type,
			boolean validateForPotentialMatch) {
		List<IStatus> statusList = new ArrayList<IStatus>();

		// Put status on first non-constraint parent
		DeployModelObject dmoForStatus = ConstraintUtil.getNonConstraintParent(typeConstraint);
		if (dmoForStatus == null) {
			dmoForStatus = context; // error?
		}
		if (type != null && !type.isSuperTypeOf(context.eClass())) {
			statusList.add(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					getClass().getName(), ICoreProblemType.CONSTRAINT_UNSATISFIED,
					DeployCoreMessages.Object_0_type_1_violates_type_constraint_2, new Object[] {
							context, context.eClass().getName(), typeConstraint.getDmoEType().getName() },
					dmoForStatus));
			// Do not validate child constraints if types do not match.
			return statusList;
		}

		// Implied AND
		for (Constraint c : (List<Constraint>) typeConstraint.getConstraints()) {
			// Validate child constraints
			IStatus status;
			if (validateForPotentialMatch) {
				status = ConstraintService.INSTANCE.validateForPotentialMatch(c, context);
			} else {
				status = ConstraintService.INSTANCE.validate(c, context, monitor);
			}
			if (!status.isOK()) {
				addStatusToList(statusList, status);
			}
		}
		return statusList;
	}

	// The unit-has-capability case
	private List<IStatus> validateUnitHasCapabilityConstraint(TypeConstraint typeConstraint,
			DeployModelObject context, IProgressMonitor monitor, EClass type,
			boolean validateForPotentialMatch) {
		List<IStatus> statusList = new ArrayList<IStatus>();
		Set<Capability> matchingCapsSet = new HashSet<Capability>();
		for (Capability cap : (List<Capability>) ((Unit) context).getCapabilities()) {
			if (type == null || type.isSuperTypeOf(cap.eClass())) {
				matchingCapsSet.add(cap);
			}
		}
		// No matching capability
		if (matchingCapsSet.size() == 0) {
			// Put status on first non-constraint parent
			DeployModelObject dmoForStatus = ConstraintUtil.getNonConstraintParent(typeConstraint);
			if (dmoForStatus == null) {
				dmoForStatus = context; // error?
			}
			statusList.add(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					getClass().getName(), ICoreProblemType.CONSTRAINT_UNSATISFIED,
					DeployCoreMessages.Target_unit_0_is_missing_capability_1, new Object[] { context,
							type.getName() }, dmoForStatus));
		} else {
			// Implied AND
			for (Capability cap : matchingCapsSet) {
				// Validate child constraints
				for (Constraint c : (List<Constraint>) typeConstraint.getConstraints()) {
					IStatus status;
					if (validateForPotentialMatch) {
						status = ConstraintService.INSTANCE.validateForPotentialMatch(c, cap);
					} else {
						status = ConstraintService.INSTANCE.validate(c, cap, monitor);
					}
					if (!status.isOK()) {
						addStatusToList(statusList, status);
					}
				}
			}
		}
		return statusList;
	}

	protected void addStatusToList(List<IStatus> statusList, IStatus status) {
		if (status.isMultiStatus()) {
			for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
				IDeployStatus cur = iter.next();
				statusList.add(cur);
			}
		} else {
			statusList.add(status);
		}
	}

	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		// return new FilterList(potentialConstraints, new IObjectFilter() {
		//	public boolean accept(Object value) {
		// so far, don't want to restrict potential child constraints
		//		return true;
		//	}
		//});

		return potentialConstraints;
	}

	public boolean canValidateConstraint(Constraint constraint) {
		// we test for strict instance rather than instanceof so we 
		// don't overlap with validators that subclass TypeConstraint
		return ConstraintPackage.Literals.TYPE_CONSTRAINT == constraint.getEObject().eClass();
	}

	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return getContextForChildConstraints_DefaultImpl(constraint);
	}

	@Override
	public String title(Constraint constraint) {
		TypeConstraint tc = (TypeConstraint) constraint;
		StringBuffer sb = new StringBuffer(super.title(constraint));
		// Usually in the UI we use PropertyUtils.get
		sb.append(NLS.bind(DeployCoreMessages.TypeConstraintValidator_dmoType_0_, getDisplayEType(tc
				.getDmoEType(), "*"))); //$NON-NLS-1$
		return sb.toString();
	}

}
