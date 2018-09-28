package com.ibm.ccl.soa.deploy.uml.internal.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCommunicationStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;

/**
 * Creates a constraint link with a communication constraint between two units
 * 
 */
public class CreateCommunicationConstraintResolution extends DeployResolution implements
		IDeployResolution {
	private final EClass communicationConstraintType;

	/**
	 * Adds a new {@link NetworkCommunicationConstraint} between two {@link Unit}s.
	 * 
	 * @param aContext
	 *           An {@link IDeployResolutionContext}.
	 * @param aGenerator
	 *           An {@link IDeployResolutionGenerator}.
	 */
	public CreateCommunicationConstraintResolution(IDeployResolutionContext aContext,
			IDeployResolutionGenerator aGenerator) {
		super(aContext, aGenerator, computeDescription(aContext));
		communicationConstraintType = ConstraintPackage.Literals.NETWORK_COMMUNICATION_CONSTRAINT;
	}

	/**
	 * Adds a new communication constraint between two {@link Unit}s based on the passed
	 * aCommunicaitonConstraintType.
	 * 
	 * @param aContext
	 *           An {@link IDeployResolutionContext}.
	 * @param aGenerator
	 *           An {@link IDeployResolutionGenerator}.
	 * @param aCommunicationConstraintType
	 *           An {@link EClass} representing the communication type constraint.
	 * 
	 * @see ConstraintPackage.Literals#NETWORK_COMMUNICATION_CONSTRAINT
	 * @see ConstraintPackage.Literals#APPLICATION_COMMUNICATION_CONSTRAINT
	 */
	public CreateCommunicationConstraintResolution(IDeployResolutionContext aContext,
			IDeployResolutionGenerator aGenerator, EClass aCommunicationConstraintType) {
		super(aContext, aGenerator, computeDescription(aContext));
		communicationConstraintType = aCommunicationConstraintType;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject dmo = status.getDeployObject();

		if (dmo == null) {
			return Status.CANCEL_STATUS;
		}
		if (!(dmo instanceof Unit)) {
			return Status.CANCEL_STATUS;
		}

		Unit srcunit = (Unit) dmo;

		if (status instanceof IDeployCommunicationStatus) {
			DeployModelObject targetDmo = ((IDeployCommunicationStatus) status).getTargetDmo();

			if (targetDmo instanceof Unit) {
				createCommunicationConstraintLink(srcunit, (Unit) targetDmo);
			}

			return Status.OK_STATUS;
		}

		return Status.OK_STATUS;
	}

	private void createCommunicationConstraintLink(Unit sourceUnit, Unit targetUnit) {
		// TODO

//		CommunicationConstraint constraint = ConstraintFactory.eINSTANCE
//				.createCommunicationConstraint();
//
//		constraint.setName(getUniqueName(sourceUnit, "Communication Constraint")); //$NON-NLS-1$
//
//		ConstraintLink link = CoreFactory.eINSTANCE.createConstraintLink();
//		String sourceName = null;
//		String targetName = null;
//
//		link.setSource(sourceUnit);
//		sourceName = sourceUnit.getName();
//		link.setTarget(targetUnit);
//		targetName = targetUnit.getName();
//
//		link.setName(getUniqueName(sourceUnit, sourceName + "ConstraintTo" + targetName)); //$NON-NLS-1$
//
//		link.getConstraints().add(constraint);
//		sourceUnit.getConstraintLinks().add(link);

		// MK: 12/21/2007 replaced above code with this
		// [CommunicationConstraint --> ApplicationCommunicationConstraint]

		Constraint constraint = null;
		String problemType = context.getDeployStatus().getProblemType();
		if (ICoreProblemType.MISSING_APP_COMM.equals(problemType)) {
			constraint = ConstraintFactory.eINSTANCE.createApplicationCommunicationConstraint();
		} else if (ICoreProblemType.MISSING_NET_COMM.equals(problemType)) {
			constraint = ConstraintFactory.eINSTANCE.createNetworkCommunicationConstraint();
		}
		constraint.setName("Communication"); //$NON-NLS-1$
		// should we check for an existing constraint link? 
		ConstraintLink link = LinkFactory.createConstraintLink(sourceUnit, targetUnit);
		link.getConstraints().add(constraint);
		constraint.setName(UnitUtil.assignUniqueName(constraint));
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof CreateCommunicationConstraintResolution)) {
			return false;
		}
		return context.getDeployStatus().getDeployObject() == ((CreateCommunicationConstraintResolution) obj)
				.getDeployStatus().getDeployObject();
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return context.getDeployStatus().getDeployObject().hashCode();
	}

	private String getUniqueName(DeployModelObject container, String name) {
		String newName = name;
		int uniqifier = 0;
		while (null != container.resolve(newName)) {
			newName += uniqifier++;
		}

		return newName;
	}

	private static String computeDescription(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		String message = NLS.bind(UMLDomainMessages.Create_Communication_constraint, new Object[] {});
		if (status instanceof IDeployCommunicationStatus) {
			DeployModelObject dmo = status.getDeployObject();
			DeployModelObject targetDmo = null;
			targetDmo = ((IDeployCommunicationStatus) status).getTargetDmo();
			if (dmo != null && targetDmo != null) {
				message = NLS.bind(UMLDomainMessages.Create_Communication_constraint_from_0_to_1,
						new Object[] { dmo.getDisplayName(), targetDmo.getDisplayName() });
			}
		}

		return message;

	}
}
