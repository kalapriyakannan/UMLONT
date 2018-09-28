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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class AddNetworkCommunicationConstraintResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (null == status) {
			return false;
		}

		if (!(status instanceof IDeployCommunicationConstraintStatus)) {
			return false;
		}

		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}

		if (!ConstraintPackage.Literals.APPLICATION_COMMUNICATION_CONSTRAINT.isSuperTypeOf(obj
				.getEObject().eClass())) {
			return false;
		}

		if (!ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC.equals(status.getProblemType())) {
			return false;
		}

		StatusMap statusMap = ((IDeployCommunicationConstraintStatus) status).getStatusMap();
		if (null != statusMap && 0 != statusMap.keySet().size()) {
			return false;
		}

		// check that resolution will be able to do what it needs to do:
		// (a) create constraint link between hosting OS
		// (b) create NetworkCommunicationConstraint
		// (c) put constraint on link
		// (d) add appropriate child constraints
		// can do all in edit topology

		return true;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		IDeployCommunicationConstraintStatus status = (IDeployCommunicationConstraintStatus) context
				.getDeployStatus();
		ApplicationCommunicationConstraint constraint = (ApplicationCommunicationConstraint) status
				.getDeployObject();
		DeployModelObject parentLink = ConstraintUtil.getExpectedContext(constraint);
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(parentLink.getEObject().eClass())) {
			parentLink = null;
		}
		IDeployCommunicationConstraintStatus cStatus = status;

		return new IDeployResolution[] { new AddNetworkCommunicationConstraintResolution(context,
				this, constraint, cStatus.getSource(), cStatus.getTarget(), cStatus
						.getTypeDescription()) };
	}

	/**
	 * Resolves an attribute expected value by overwritting the attribute value.
	 */
	public class AddNetworkCommunicationConstraintResolution extends DeployResolution {

		private final ApplicationCommunicationConstraint _sourceConstraint;
		private final Unit _targetLinkSource;
		private final Unit _targetLinkTarget;
		private final StatusMap _statusMap;

		/**
		 * Construct a resolution over the status
		 * 
		 * @param context
		 * @param generator
		 * @param acc
		 * @param targetLinkSource
		 * @param targetLinkTarget
		 */
		public AddNetworkCommunicationConstraintResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, ApplicationCommunicationConstraint acc,
				Unit targetLinkSource, Unit targetLinkTarget, String types) {
			super(context, generator);
			_sourceConstraint = acc;
			_targetLinkSource = targetLinkSource;
			_targetLinkTarget = targetLinkTarget;
			_statusMap = ((IDeployCommunicationConstraintStatus) context.getDeployStatus())
					.getStatusMap();
			setDescription(NLS.bind(
					DeployCoreMessages.Resolution_AddNetworkCommunicationConstraint_Between_0,
					new Object[] { types }));
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
		 *      org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus resolve(IProgressMonitor monitor) {

			// do the following:
			// (a) create constraint link between hosting OS
			// (b) create NetworkCommunicationConstraint & set direction
			// (c) put constraint on link
			// (d) create appropriate child constraints

			// (a) create constraint link between hosting OS
			ConstraintLink link = LinkFactory.createConstraintLink(_targetLinkSource,
					_targetLinkTarget);

			// (b) create NetworkCommunicationConstraint & set direction
			NetworkCommunicationConstraint ncc = ConstraintFactory.eINSTANCE
					.createNetworkCommunicationConstraint();
			ncc.setName(_targetLinkSource.getName()
					+ "To" + _targetLinkTarget.getName() + "NetworkConnectionConstraint"); //$NON-NLS-1$//$NON-NLS-2$
			ncc.setRespectLinkDirection(_sourceConstraint.isRespectLinkDirection());

			// (c) put constraint on link
			link.getConstraints().add(ncc);

			// (d) create appropriate child constraints
			// TODO figure this out (currently let another resolution (AddToNetworkCommunicationConstraint) do the work

			// for each child of the ACC create corresponding child
			for (Constraint childConstraint : (List<Constraint>) _sourceConstraint.getConstraints()) {
				EClass childConstraintType = childConstraint.getEObject().eClass();
				List<Constraint> constraintsToProcess = new ArrayList<Constraint>();
				constraintsToProcess.add(childConstraint);
				if (ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT
						.isSuperTypeOf(childConstraintType)) {
					// do some special processing: get the child port constraints
					constraintsToProcess = childConstraint.getConstraints();
				}

				for (Constraint constraintToProcess : constraintsToProcess) {
					List<ConstraintValidator> validators = ConstraintService.INSTANCE
							.getValidators(constraintToProcess.getEObject().eClass());
					List<AttributeValuePair> aData = null;
					for (ConstraintValidator validator : validators) {
						if (validator instanceof CommunicationConstraintChildValidator) {
							aData = ((CommunicationConstraintChildValidator) validator)
									.getExpectedAttributeData(constraintToProcess);
						}
					}
					if (null != aData && aData.size() > 0) {
						createChildConstraint(constraintToProcess.getEObject().eClass(),
								ConstraintService.INSTANCE.title(constraintToProcess), aData, ncc);
					}
				}
			}

			return Status.OK_STATUS;
		}

		private Constraint createChildConstraint(EClass type, String displayName,
				List<AttributeValuePair> aData, Constraint target) {
			// create child constraint
			Constraint constraint = (Constraint) ConstraintFactory.eINSTANCE.create(type);
			constraint.setDisplayName(displayName);
			for (AttributeValuePair av : aData) {
				constraint.eSet(av.getAttribute(), av.getValue());
			}

			// add as child constraint to target
			target.getConstraints().add(constraint);
			UnitUtil.assignUniqueName(constraint);

			return constraint;
		}
	}
}
