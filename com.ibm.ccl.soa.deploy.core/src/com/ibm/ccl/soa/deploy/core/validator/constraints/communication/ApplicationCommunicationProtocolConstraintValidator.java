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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validator for {@link ApplicationCommunicationProtocolConstraint}. Checks that there is a
 * {@link NetworkCommunicationConstraint} that has the necessary {@link CommunicationPortConstraint}s.
 */
public class ApplicationCommunicationProtocolConstraintValidator extends
		CommunicationConstraintChildValidator {

	private static final EClass constraintLinkType = CorePackage.Literals.CONSTRAINT_LINK;
	private static final EClass dependencyLinkType = CorePackage.Literals.DEPENDENCY_LINK;

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return null != constraint
				&& ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT
						.isSuperTypeOf(constraint.getEObject().eClass());
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return Status.CANCEL_STATUS;
		}

		EClass contextType = context.getEObject().eClass();
		if (!constraintLinkType.isSuperTypeOf(contextType)
				&& !dependencyLinkType.isSuperTypeOf(contextType)) {
			return Status.CANCEL_STATUS;
		}

		// if no protocol defined; return OK
		String protocol = ((ApplicationCommunicationProtocolConstraint) constraint)
				.getApplicationLayerProtocol();
		if (protocol == null || protocol.trim().length() == 0) {
//			return Status.OK_STATUS;
			// warning: no protocol and no port configuraiton specified
			return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
					IDeployCoreValidators.ACPC_PROTOCOL_CHECK_001,
					ICoreProblemType.NO_APPLICATION_PROTOCOL_DETAILS,
					DeployCoreMessages.Validator_acpc_unspecified_application_protocol_details,
					new Object[] {}, constraint);
		}
		//Can only validate constraint on links.
		if (constraintLinkType.isSuperTypeOf(contextType)) {
			return validate(((ConstraintLink) context), protocol, context, monitor);
		}
		if (dependencyLinkType.isSuperTypeOf(contextType)) {
			return validate(((DependencyLink) context), protocol, context, monitor);
		}
		return Status.OK_STATUS;
	}

	public IStatus validateWithContext(Constraint constraint, CVC cvc, IProgressMonitor monitor) {
		if (!(cvc instanceof AccNccContext)) {
			return Status.CANCEL_STATUS;
		}

		NetworkCommunicationConstraint ncc = ((AccNccContext) cvc).getNcc();
		if (null == ncc) {
			return Status.CANCEL_STATUS;
		}

		// check that all CommunicationPortConfiguration child constraints are satisfied
		// if there are none we use the default values for the specified protocol
		// if there are none and we don't know the protocol, we indicate an error

		List<Constraint> cpcL = new ArrayList<Constraint>();
		List<Constraint> otherChildConstraints = new ArrayList<Constraint>();

		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			if (ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT.isSuperTypeOf(c.getEObject()
					.eClass())) {
				cpcL.add(c);
			} else {
				otherChildConstraints.add(c);
			}
		}

		IStatus status = null;
		if (0 < cpcL.size()) {
			for (Constraint cpc : cpcL) {
				CommunicationPortConstraintValidator cpcv = new CommunicationPortConstraintValidator();
				IStatus childStatus = cpcv.validateWithContext(cpc, cvc, monitor);
				if (childStatus.isOK()) {
					continue;
				}
				// for each error status, append to a multistatus
				status = ValidatorUtils.addStatus(status, childStatus);
			}
			if (null == status) {
				status = Status.OK_STATUS;
			}
		} else {
			String key = ((ApplicationCommunicationProtocolConstraint) constraint)
					.getApplicationLayerProtocol();
			if (null == key || 0 == key.trim().length()) {
				// warning: no protocol and no port configuraiton specified
				// already dealt with above
				return Status.OK_STATUS;
//				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
//						IDeployCoreValidators.ACPC_PROTOCOL_CHECK_001,
//						ICoreProblemType.NO_APPLICATION_PROTOCOL_DETAILS,
//						DeployCoreMessages.Validator_acpc_unspecified_application_protocol_details,
//						new Object[] {}, constraint);
			} else {
				Integer port = ApplicationCommunicationProtocolConstraintMappingService.INSTANCE
						.getPort(key);
				if (null == port) {
					// error: we have an unrecognized application protocol without any port specifications
					status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.ACPC_PORT_CHECK_001,
									ICoreProblemType.UNKNOWN_APPLICATION_PROTOCOL_WITHOUT_PORTS,
									DeployCoreMessages.Validator_acpc_unknown_protocol_requires_port_specification,
									new Object[] {}, constraint);
				} else {
					CommunicationPortConstraintValidator cpcv = new CommunicationPortConstraintValidator();
					status = cpcv.validateWithContext(constraint, port, null, cvc, monitor);
				}
			}
		}

		return status;
	}

	private IStatus validate(DependencyLink dependencyLink, String protocol,
			DeployModelObject context, IProgressMonitor monitor) {
		IStatus returnStatus = Status.OK_STATUS;
		DeployModelObject srcDmo = dependencyLink.getSource();
		DeployModelObject tgtDmo = dependencyLink.getTarget();
		if (srcDmo != null && tgtDmo != null && srcDmo instanceof Requirement
				&& tgtDmo instanceof Service) {
			Requirement req = (Requirement) srcDmo;
			Service service = (Service) tgtDmo;
			returnStatus = validateForDependencyRequirement(req, service, protocol, (Unit) service
					.getParent());
		}
		return returnStatus;
	}

	private IStatus validate(ConstraintLink constraintLink, String protocol,
			DeployModelObject context, IProgressMonitor monitor) {
		IStatus returnStatus = Status.OK_STATUS;
		DeployModelObject srcDmo = constraintLink.getSource();
		DeployModelObject tgtDmo = constraintLink.getTarget();
		if (srcDmo != null && tgtDmo != null && srcDmo instanceof Unit && tgtDmo instanceof Unit) {
			Unit sourceUnit = (Unit) srcDmo;
			Unit targetUnit = (Unit) tgtDmo;
			IStatus hostStatus = validateForHosting(sourceUnit, targetUnit, protocol);
			returnStatus = ValidatorUtils.addStatus(returnStatus, hostStatus);
			IStatus dependencyStatus = validateForDependency(sourceUnit, targetUnit, protocol);
			returnStatus = ValidatorUtils.addStatus(returnStatus, dependencyStatus);
		}
		return returnStatus;
	}

	private IStatus validateForDependency(Unit sourceUnit, Unit targetUnit, String constraintProtocol) {
		IStatus returnStatus = Status.OK_STATUS;
		List<Requirement> requirements = sourceUnit.getOnlyDependencyRequirements();
		if (requirements.isEmpty()) {
			return returnStatus;
		}
		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Object element = iter.next();
			IStatus status = null;
			if (element instanceof Requirement) {
				status = validateForDependencyRequirement((Requirement) element, constraintProtocol,
						targetUnit);
				if (status != null) {
					returnStatus = ValidatorUtils.addStatus(returnStatus, status);
				}
			}
		}
		return returnStatus;
	}

	private IStatus validateForDependencyRequirement(Requirement req, String constraintProtocol,
			Unit targetUnit) {
		DeployModelObject target = ValidatorUtils.getDependencyLinkTarget(req);
		if (!(target instanceof Service)) {
			return null;
		}
		Service service = (Service) target;
		return validateForDependencyRequirement(req, service, constraintProtocol, targetUnit);
	}

	private IStatus validateForDependencyRequirement(Requirement req, Service service,
			String constraintProtocol, Unit targetUnit) {
		Unit reqTarget = (Unit) service.getParent();
		if (reqTarget != null && reqTarget.equals(targetUnit)) {
			String tgtProtocol = service.getProtocol();
			if (!transportProtocolsMatch(constraintProtocol, tgtProtocol)) {
				return createProtocolErrorStatus(IDeployCoreValidators.COMMCONSTRAINT_002,
						DeployCoreMessages.COMMCONSTRAINT_002, service, tgtProtocol, constraintProtocol);
			}
		}
		return null;
	}

	private IStatus validateForHosting(Unit sourceUnit, Unit targetUnit, String constraintProtocol) {
		IStatus returnStatus = Status.OK_STATUS;
		List<Unit> srcHosted = collectHosted(sourceUnit);
		if (!srcHosted.isEmpty()) {
			List<Unit> tgtHosted = collectHosted(targetUnit);
			if (!tgtHosted.isEmpty()) {
				for (Iterator it = srcHosted.iterator(); it.hasNext();) {
					Unit srcUnit = (Unit) it.next();
					List<Requirement> requirements = srcUnit.getOnlyDependencyRequirements();
					if (!requirements.isEmpty()) {
						IStatus status = validateRequirementsProtocolForHostingCommConstraint(srcUnit,
								requirements, constraintProtocol, tgtHosted);
						returnStatus = ValidatorUtils.addStatus(returnStatus, status);
					}
				}
			}
		}
		return returnStatus;
	}

	private IStatus validateRequirementsProtocolForHostingCommConstraint(Unit srcUnit,
			List<Requirement> requirements, String protocol, List<Unit> tgtHosted) {
		IStatus returnStatus = Status.OK_STATUS;
		for (Iterator iter = requirements.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (element instanceof Reference) {
				String tgtProtocol = null;
				Reference reference = (Reference) element;
				DeployModelObject target = ValidatorUtils.getDependencyLinkTarget(reference);
				if (!(target instanceof Service)) {
					continue;
				}
				Service service = (Service) target;
				tgtProtocol = service.getProtocol();
				Unit hostedTarget = (Unit) service.getParent();
				if (hostedTarget != null && tgtHosted.contains(hostedTarget)) {
					if (!transportProtocolsMatch(protocol, tgtProtocol)) {
						IStatus status = createProtocolErrorStatus(
								IDeployCoreValidators.COMMCONSTRAINT_001,
								DeployCoreMessages.COMMCONSTRAINT_001, service, tgtProtocol, protocol);
						returnStatus = ValidatorUtils.addStatus(returnStatus, status);
					}
				}
			}
		}
		return returnStatus;
	}

	private IStatus createProtocolErrorStatus(String id, String messageKey, Service service,
			String targetProtocol, String constraintProtocol) {
		String protocolString = targetProtocol == null ? "" : targetProtocol; //$NON-NLS-1$
		return DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(IStatus.ERROR, id,
				ICoreProblemType.COMM_CONSTRAINT, messageKey,
				new Object[] { service.getCaptionProvider().title(service), protocolString,
						constraintProtocol }, service, CorePackage.Literals.SERVICE__PROTOCOL,
				constraintProtocol);
	}

	private boolean transportProtocolsMatch(String protocol1, String protocol2) {
		if (protocol2 == null || protocol2.length() == 0) {
			return protocol1 == null || protocol1.length() == 0;
		}
		int index1 = protocol1.lastIndexOf('/');
		int index2 = protocol2.lastIndexOf('/');
		String transport1 = index1 > -1 && index1 < protocol1.length() ? protocol1
				.substring(index1 + 1) : protocol1;
		String transport2 = index2 > -1 && index2 < protocol2.length() ? protocol2
				.substring(index2 + 1) : protocol2;
		return transport1.equalsIgnoreCase(transport2);
	}

	private List<Unit> collectHosted(Unit unit) {
		List<HostingLink> hostingLinks = unit.getHostingLinks();
		List<Unit> hosted = new ArrayList<Unit>(hostingLinks.size());
		for (Iterator iter = hostingLinks.iterator(); iter.hasNext();) {
			HostingLink hostingLink = (HostingLink) iter.next();
			Unit hostedUnit = hostingLink.getTarget();
			hosted.add(hostedUnit);
		}
		return hosted;
	}

	@Override
	public String title(Constraint constraint) {
		if (constraint == null) {
			return DeployCoreMessages.null_value;
		}
		StringBuffer buf = new StringBuffer(
				DeployCoreMessages.ApplicationCommunicationProtocolConstraintValidator_Application_Layer_Protoco_);
		String caption = constraint.getDisplayName();
		if (caption != null && caption.trim().length() != 0) {
			buf.append(' ').append('(').append(caption.trim()).append(')');
		}
		String protocol = ((ApplicationCommunicationProtocolConstraint) constraint)
				.getApplicationLayerProtocol();
		if (protocol != null && protocol.length() > 0) {
			buf.append(" = ").append(protocol); //$NON-NLS-1$
		}
		return buf.toString();
	}

}