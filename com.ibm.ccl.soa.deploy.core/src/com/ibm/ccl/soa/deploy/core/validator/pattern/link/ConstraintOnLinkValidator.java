/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Validator for {@link Constraint} on a {@link ConstraintLink}.
 */
public abstract class ConstraintOnLinkValidator extends ConstraintValidator {

	private final EClass _constraintType;
	private final EClass[] _validSourceTypes;
	private final boolean _sourceIsRequirement;
	private final EClass[] _validTargetTypes;

	private final static EClass dependencyLinkType = CorePackage.Literals.DEPENDENCY_LINK;
	private final static EClass constraintLinkType = CorePackage.Literals.CONSTRAINT_LINK;
	private final static EClass memberLinkType = CorePackage.Literals.MEMBER_LINK;
	private final static EClass hostingLinkType = CorePackage.Literals.HOSTING_LINK;

	/**
	 * Pattern for validating a constraint on a constraint link. Checks the context of the link (the
	 * link is of the type expected and the endpoints of the link are the expected types), determines
	 * if the constraint holds, and, if not, determines if it is possible to make changes to the
	 * model to satisfy the constraint.
	 * 
	 * @param constraintType
	 * @param validSourceTypes
	 * @param sourceIsRequirement
	 * @param validTargetTypes
	 */
	public ConstraintOnLinkValidator(EClass constraintType, EClass[] validSourceTypes,
			boolean sourceIsRequirement, EClass[] validTargetTypes) {
		_constraintType = constraintType;
		_validSourceTypes = validSourceTypes;
		_sourceIsRequirement = sourceIsRequirement;
		_validTargetTypes = validTargetTypes;
	}

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return Collections.emptyList();
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return _constraintType.isSuperTypeOf(constraint.getEObject().eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		// validate constraint context
		IStatus contextStatus = validateConstraintContext(constraint, context, monitor);
		if (!contextStatus.isOK()) {
			return contextStatus;
		}

		// actually validate the constraint
		IStatus implementationStatus = validateConstraint(constraint, context, monitor);
		if (implementationStatus.isOK()) {
			return implementationStatus;
		}

		// this is where we would check the preconditions for any resolution to execute
		// in this case, there are none

		IStatus preconditionStatus = validateImplementationPreconditions(constraint, context, monitor);
		if (!preconditionStatus.isOK()) {
			return preconditionStatus;
		}

		// Summary: 
		//    context is valid
		//    implementation is not valid
		//    preconditions hold
		// Action: 
		//    set status that resolution will recognize
		return createCanSatisfyStatus(constraint, context);
	}

	/**
	 * Validate the constraint context on the link.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the link
	 * @param monitor
	 *           a progress monitor
	 * @return status
	 */
	protected IStatus validateConstraintContext(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		// validate constraint context
		if (null == context) {
			ConstraintUtil.createNullContextStatus(constraint);
		}
		if (!constraintLinkType.isSuperTypeOf(context.getEObject().eClass())
				&& !dependencyLinkType.isSuperTypeOf(context.getEObject().eClass())) {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		if (constraintLinkType.isSuperTypeOf(context.getEObject().eClass())) {
			ConstraintLink link = (ConstraintLink) context;
			if (!linkEndpointsValid(link.getSource(), _validSourceTypes, _sourceIsRequirement, link
					.getTarget(), _validTargetTypes)) {
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}
		} else if (dependencyLinkType.isSuperTypeOf(context.getEObject().eClass())) {
			DependencyLink link = (DependencyLink) context;
			if (!linkEndpointsValid(link.getSource(), _validSourceTypes, _sourceIsRequirement, link
					.getTarget(), _validTargetTypes)) {
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}
		} else {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Validate that the constraint holds.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint link containing the constraint
	 * @param monitor
	 *           a progress monitor
	 * @return status {@link IStatus#isOK()} if constraint holds
	 */
	protected abstract IStatus validateConstraint(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor);

	/**
	 * Determine if we know what to do (and we can do it) to make a constraint be satisfied.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint link containing the constraint
	 * @param monitor
	 *           a progress monitor
	 * @return status {@link IStatus#isOK()} if we know what to do and how to do it
	 */
	protected IStatus validateImplementationPreconditions(Constraint constraint,
			DeployModelObject context, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}

	/**
	 * Create a {@link IDeployStatus} that indicates that the {@link Constraint} can be satisfied.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint context (link)
	 * @return the status
	 */
	protected abstract IDeployStatus createCanSatisfyStatus(Constraint constraint,
			DeployModelObject context);

	/**
	 * Determine if the endpoints of a {@link DeployLink} are valid (for a constraint on the link).
	 * 
	 * @param linkSrcObj
	 *           the source endpoint
	 * @param srcType
	 *           the expected type of the source endpoint
	 * @param isRequirement
	 *           flag indicating that the endpoint is a {@link Requirement} and that the type refers
	 *           to the value of {@link Requirement#getDmoEType()}
	 * @param linkTargetObj
	 *           the target endpoint
	 * @param targetTypes
	 *           an array of acceptable target endpoint types
	 * @return true if the endpoints are of the expected types
	 */
	private boolean linkEndpointsValid(DeployModelObject linkSrcObj, EClass[] srcTypes,
			boolean isRequirement, DeployModelObject linkTargetObj, EClass[] targetTypes) {
		if (!linkEndpointValid(linkSrcObj, srcTypes, isRequirement)) {
			return false;
		}
		return linkEndpointValid(linkTargetObj, targetTypes, isRequirement);
	}

	/**
	 * Determine if the endpoint of a {@link DeployLink} is valid (for a constraint on the link).
	 * 
	 * @param endpoint
	 *           the link endpoint
	 * @param types
	 *           expected types of the link endpoint
	 * @param isRequirement
	 *           flag indicating that the endpoint is a {@link Requirement} and that the type refers
	 *           to the value of {@link Requirement#getDmoEType()}
	 * @return true if the endpoint is of the expected type
	 */
	private boolean linkEndpointValid(DeployModelObject endpoint, EClass[] types,
			boolean isRequirement) {
		if (null == endpoint) {
			return false;
		}

		EClass epType = endpoint.getEObject().eClass();
		if (isRequirement) {
			if (!CorePackage.Literals.REQUIREMENT.isSuperTypeOf(epType)) {
				return false;
			}
			Requirement req = (Requirement) endpoint;
			epType = req.getDmoEType();
		}

		for (int i = 0; i < types.length; i++) {
			if (types[i].isSuperTypeOf(epType)) {
				return true;
			}
		}
		return false;
	}

	public static final DeployModelObject getSource(DeployModelObject context) {
		DeployModelObject source = null;
		EClass contextType = context.getEObject().eClass();
		if (dependencyLinkType.isSuperTypeOf(contextType)) {
			source = ((DependencyLink) context).getSource();
		} else if (constraintLinkType.isSuperTypeOf(contextType)) {
			source = ((ConstraintLink) context).getSource();
		} else if (memberLinkType.isSuperTypeOf(contextType)) {
			source = ((MemberLink) context).getSource();
		} else if (hostingLinkType.isSuperTypeOf(contextType)) {
			source = ((HostingLink) context).getSource();
		}

		return source;
	}

	public static final DeployModelObject getTarget(DeployModelObject context) {
		DeployModelObject source = null;
		EClass contextType = context.getEObject().eClass();
		if (dependencyLinkType.isSuperTypeOf(contextType)) {
			source = ((DependencyLink) context).getTarget();
		} else if (constraintLinkType.isSuperTypeOf(contextType)) {
			source = ((ConstraintLink) context).getTarget();
		} else if (memberLinkType.isSuperTypeOf(contextType)) {
			source = ((MemberLink) context).getTarget();
		} else if (hostingLinkType.isSuperTypeOf(contextType)) {
			source = ((HostingLink) context).getTarget();
		}

		return source;
	}

}
