/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator for {@link CommunicationPortConstraintValidator}. Relies on a context that includes a
 * target constraint to validate against.
 */
public class CommunicationPortConstraintValidator extends CommunicationConstraintChildValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return null != constraint
				&& ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT.isSuperTypeOf(constraint
						.getEObject().eClass());
	}

	public IStatus validateWithContext(Constraint constraint, CVC context, IProgressMonitor monitor) {

		if (!canValidateConstraint(constraint)) {
			return Status.CANCEL_STATUS;
		}

		if (null == context) {
			return Status.CANCEL_STATUS;
		}

		CommunicationPortConstraint cpc = (CommunicationPortConstraint) constraint;
		int requiredPort = cpc.getPort();
		boolean isTarget = cpc.isIsTarget();

		IStatus status = validateWithContext(constraint, new Integer(requiredPort), new Boolean(
				isTarget), context, monitor);

		NetworkCommunicationConstraint ncc = ((AccNccContext) context).getNcc();

		if (null == status) {
			// error: cannot find matching port constraint
//			return new CommunicationPortConstraintDeployStatus(IStatus.ERROR,
//					IOsDomainValidators.CPC_PORT_CHECK_001, IOsProblemType.EXPECTED_PORT_NOT_REQUIRED,
//					OsDomainMessages.Validator_cpc_expected_port_not_required, new Object[] {}, ncc,
//					requiredPort, ncc);
			return new ApplicationCommunicationConstraintChildDeplyStatus(IStatus.ERROR,
					IDeployCoreValidators.CPC_PORT_CHECK_001,
					ICoreProblemType.EXPECTED_PORT_NOT_REQUIRED,
					DeployCoreMessages.Validator_cpc_expected_port_not_required, new Object[] {},
					constraint, ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT, (new Integer(
							requiredPort)).toString(), getExpectedAttributeData(constraint), ncc);

		}

		return status;
	}

	// TODO: fix this method; it is not ideal
	public IStatus validateWithContext(Constraint constraint, Integer port, Boolean isTarget,
			CVC context, IProgressMonitor monitor) {

		if (null == port) {
			return Status.CANCEL_STATUS;
		}

		boolean isTarg;
		if (null == isTarget) {
			isTarg = true;
		} else {
			isTarg = isTarget.booleanValue();
		}

		int requiredPort = port.intValue();

		// TODO impelment
		// if context is ACC
		//    extract NCC from CVC
		//    search NCC for a CPC that matches this.port
		//    if find return success; if none return failure (no status created)
		// else context is NCC
		//    return sucess for now
		if (null == context) {
			return Status.CANCEL_STATUS;
		}

		if (ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT.isSuperTypeOf(context
				.getContext().getEObject().eClass())) {
			if (!(context instanceof AccNccContext)) {
				return Status.CANCEL_STATUS;
			}

			NetworkCommunicationConstraint ncc = ((AccNccContext) context).getNcc();

			for (Constraint c : (List<Constraint>) ncc.getConstraints()) {
				if (ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT.isSuperTypeOf(c
						.getEObject().eClass())) {
					CommunicationPortConstraint cpc = (CommunicationPortConstraint) c;
					if (requiredPort == cpc.getPort() && isTarg == cpc.isIsTarget()) {
						return Status.OK_STATUS;
					}
				}
			}
			// error: cannot find matching port constraint
//			return new CommunicationPortConstraintDeployStatus(IStatus.ERROR,
//					IOsDomainValidators.CPC_PORT_CHECK_001, IOsProblemType.EXPECTED_PORT_NOT_REQUIRED,
//					OsDomainMessages.Validator_cpc_expected_port_not_required, new Object[] {}, ncc,
//					requiredPort, ncc);
			return new ApplicationCommunicationConstraintChildDeplyStatus(IStatus.ERROR,
					IDeployCoreValidators.CPC_PORT_CHECK_001,
					ICoreProblemType.EXPECTED_PORT_NOT_REQUIRED,
					DeployCoreMessages.Validator_cpc_expected_port_not_required, new Object[] {},
					constraint, ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT, (new Integer(
							requiredPort)).toString(), getPortAsExpectedAttributeData(requiredPort,
							isTarget), ncc);
		} else {
			// context is NetworkCommunicationConstraint
			return Status.OK_STATUS;
		}
	}

	@Override
	public String title(Constraint constraint) {
		if (constraint == null) {
			return DeployCoreMessages.null_value;
		}
		String typeName = computeTypeName(constraint);
		String caption = constraint.getDisplayName();
		if (caption == null) {
			caption = constraint.eGet(ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__PORT)
					.toString();
		}
		if (caption != null && !caption.trim().equals("")) { //$NON-NLS-1$
			//Type(caption)
			StringBuffer buf = new StringBuffer(typeName);
			buf.append(' ').append('(').append(caption.trim()).append(')');
			return buf.toString();
		}
		return typeName;
	}

	@Override
	public List<AttributeValuePair> getExpectedAttributeData(Constraint constraint) {
		CommunicationPortConstraint cpc = (CommunicationPortConstraint) constraint;
		int requiredPort = cpc.getPort();
		boolean isTarget = cpc.isIsTarget();

		return Arrays.asList(new AttributeValuePair[] {
				new AttributeValuePair(ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__PORT,
						requiredPort),
				new AttributeValuePair(
						ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET, isTarget) });
	}

	private List<AttributeValuePair> getPortAsExpectedAttributeData(Integer requiredPort,
			Boolean isTarget) {
		return Arrays.asList(new AttributeValuePair[] {
				new AttributeValuePair(ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__PORT,
						requiredPort),
				new AttributeValuePair(
						ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET, isTarget) });
	}

}
