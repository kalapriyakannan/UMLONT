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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generates resolutions to delete communication constraints.
 */
public class DeleteApplicationCommunicationConstraintResolutionGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (null == status) {
			return false;
		}

		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}

		if (!ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC.equals(status.getProblemType())
				&& !ICoreProblemType.CANNOT_MATCH_ACC_CHILD_TO_NCC_CHILD
						.equals(status.getProblemType())) {
			return false;
		}

		// check that resolution will be able to do what it needs to do:
		// (a) remove constraint from a link; must be in edit topology
		if (obj.getTopology() != obj.getEditTopology()) {
			return false;
		}

		// (b) remove constraint link if there are no more constraints
		DeployModelObject parentLink = ConstraintUtil.getExpectedContext((Constraint) obj);
		if (CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(parentLink.getEObject().eClass())) {
			if (1 == parentLink.getConstraints().size()) {
				if (parentLink.getTopology() != parentLink.getEditTopology()) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		IDeployStatus status = context.getDeployStatus();
		DeployModelObject constraint = status.getDeployObject();
		DeployModelObject parentLink = ConstraintUtil.getExpectedContext((Constraint) constraint);
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(parentLink.getEObject().eClass())) {
			parentLink = null;
		}

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		while (CorePackage.Literals.CONSTRAINT.isSuperTypeOf(constraint.getEObject().eClass())) {
			resolutions.add(new DeleteApplicationCommunicationConstraintResolution(context, this,
					(Constraint) constraint, (ConstraintLink) parentLink));
			constraint = constraint.getParent();
		}

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/**
	 * Resolves an unmatched {@link ApplicationCommunicationConstraint} or
	 * {@link CommunicationChildConstraint} by deleting the unmatched constraint.
	 */
	public class DeleteApplicationCommunicationConstraintResolution extends DeployResolution {

		private final Constraint _constraint;
		private ConstraintLink _constraintLink = null;

		/**
		 * Construct a resolution over the status
		 * 
		 * @param context
		 * @param generator
		 */
		public DeleteApplicationCommunicationConstraintResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Constraint constraint, ConstraintLink link) {
			super(context, generator);
//			_constraint = (Constraint) context.getDeployStatus().getDeployObject();
//			DeployModelObject cContext = ConstraintUtil.getExpectedContext(_constraint);
//			if (CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(cContext.getEObject().eClass())) {
//				_constraintLink = (ConstraintLink) cContext;
//			}
			_constraint = constraint;
			_constraintLink = link;
			setDescription(NLS.bind(
					DeployCoreMessages.Resolution_DeleteApplicationCommunicationConstraint_0,
					new Object[] { ConstraintService.INSTANCE.title(_constraint) }));
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
		 *      org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus resolve(IProgressMonitor monitor) {

			// delete the constraint
			EcoreUtil.delete(_constraint);

			// delete ConstraintLink if it isn't used for anything else
			if (null != _constraintLink && 0 == _constraintLink.getConstraints().size()) {
				EcoreUtil.delete(_constraintLink);
			}

			return Status.OK_STATUS;
		}
	}

}
