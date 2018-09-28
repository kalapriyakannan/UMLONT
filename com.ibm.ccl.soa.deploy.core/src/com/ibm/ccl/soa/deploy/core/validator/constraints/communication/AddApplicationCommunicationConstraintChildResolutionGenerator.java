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
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generates resolutions to add child constraints on an {@link ApplicationCommunicationConstraint}
 */
public class AddApplicationCommunicationConstraintChildResolutionGenerator extends
		DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus s = context.getDeployStatus();

		if (null == s) {
			return false;
		}

		if (!(s instanceof IApplicationCommunicationConstraintChildDeployStatus)) {
			return false;
		}

		IApplicationCommunicationConstraintChildDeployStatus status = (IApplicationCommunicationConstraintChildDeployStatus) s;

		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}

		// check that target parent constraint is well defined
		Constraint target = status.getTargetNcc();
		if (null == target) {
			return false;
		}

		// check that resolution will be able to do what it needs to do:
		// (a) add communication port constraint to network communication constraint
		if (!target.isPublic()) {
			return false;
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

		IApplicationCommunicationConstraintChildDeployStatus status = (IApplicationCommunicationConstraintChildDeployStatus) context
				.getDeployStatus();
		Constraint target = status.getTargetNcc();
		EClass type = status.getConstraintType();
		String displayName = status.getDisplayName();
		List<AttributeValuePair> attributeData = status.getAttributeData();

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>();
		for (Constraint c : ConstraintUtil.getConstraints(target,
				ConstraintPackage.Literals.COMMUNICATION_CHILD_CONSTRAINT)) {
			if (type.isSuperTypeOf(c.getEObject().eClass())) {
				resolutions.add(new ModifyApplicationCommunicationConstraintChildResolution(context,
						this, type, displayName, attributeData, target));
			}
		}

		resolutions.add(new AddApplicationCommunicationConstraintChildResolution(context, this, type,
				displayName, attributeData, target));

		return resolutions.toArray(new IDeployResolution[resolutions.size()]);

//		return new IDeployResolution[] { new AddApplicationCommunicationConstraintChildResolution(
//				context, this, type, displayName, attributeData, target) };
	}

	private static Constraint setConstraintDetails(Constraint constraint, String displayName,
			List<AttributeValuePair> attributeData) {
//		constraint.setDisplayName(displayName);
		for (AttributeValuePair av : attributeData) {
			if (null != av.getValue()) {
				constraint.eSet(av.getAttribute(), av.getValue());
			} else {
				constraint.eUnset(av.getAttribute());
			}
		}
		return constraint;
	}

	/**
	 * Resolves a missing {@link CommunicationPortConstraint} by adding a new one.
	 */
	public class AddApplicationCommunicationConstraintChildResolution extends DeployResolution {

		private final EClass _type;
		private final String _displayName;
		private final List<AttributeValuePair> _attributeData;
		private Constraint _target = null;
		private Constraint _constraint = null;

		/**
		 * Construct a resolution over the status
		 * 
		 * @param context
		 * @param generator
		 * @param type
		 * @param target
		 */
		public AddApplicationCommunicationConstraintChildResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, EClass type, String displayName,
				List<AttributeValuePair> attributeData, Constraint target) {
			super(context, generator);

			_type = type;
			_displayName = displayName;
			_attributeData = attributeData;
			_target = target;

			_constraint = (Constraint) ConstraintFactory.eINSTANCE.create(_type);
			_constraint = setConstraintDetails(_constraint, _displayName, _attributeData);

			String title = ConstraintService.INSTANCE.title(_constraint);
			String _description = NLS.bind(DeployCoreMessages.Resolution_AddCommunicationConstraint_0,
					new Object[] { title });
			setDescription(_description);
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
		 *      org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus resolve(IProgressMonitor monitor) {

//			// create child constraint
//			Constraint constraint = (Constraint) ConstraintFactory.eINSTANCE.create(_type);
//			constraint.setDisplayName(_displayName);
//			for (AttributeValuePair av : _attributeData) {
//				constraint.eSet(av.getAttribute(), av.getValue());
//			}
//
			// add as child constraint to target
			_target.getConstraints().add(_constraint);
			UnitUtil.assignUniqueName(_constraint);

			return Status.OK_STATUS;
		}
	}

	/**
	 * Resolves a missing {@link CommunicationPortConstraint} by modifying an existing one.
	 */
	public class ModifyApplicationCommunicationConstraintChildResolution extends DeployResolution {

		private final EClass _type;
		private final String _displayName;
		private final List<AttributeValuePair> _attributeData;
		private Constraint _target = null;
		private Constraint _constraint = null;

		/**
		 * Construct a resolution over the status
		 * 
		 * @param context
		 * @param generator
		 * @param type
		 * @param target
		 */
		public ModifyApplicationCommunicationConstraintChildResolution(
				IDeployResolutionContext context, IDeployResolutionGenerator generator, EClass type,
				String displayName, List<AttributeValuePair> attributeData, Constraint target) {
			super(context, generator);

//			Constraint constraint = (Constraint) context.getDeployStatus().getDeployObject();
			_type = type;
			_displayName = displayName;
			_attributeData = attributeData;
			_target = target;

			String oldTitle = null;
			Constraint dummyConstraint = null;
			for (Constraint c : ConstraintUtil.getConstraints(_target,
					ConstraintPackage.Literals.COMMUNICATION_CHILD_CONSTRAINT)) {
				if (_type.isSuperTypeOf(c.getEObject().eClass())) {
					_constraint = c;
					oldTitle = ConstraintService.INSTANCE.title(_constraint);
//					_constraint = setConstraintDetails(c, _displayName, _attributeData);					
					dummyConstraint = (Constraint) ConstraintFactory.eINSTANCE.create(_type);
					dummyConstraint = setConstraintDetails(dummyConstraint, _displayName, _attributeData);
				}
			}

			if (null != dummyConstraint) {
				String newTitle = ConstraintService.INSTANCE.title(dummyConstraint);
				String _description = NLS.bind(
						DeployCoreMessages.Resolution_ModifyCommunicationConstraint_0_1, new Object[] {
								oldTitle, newTitle });
				setDescription(_description);
			}
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
		 *      org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus resolve(IProgressMonitor monitor) {

			// update the child constraint
			_constraint = setConstraintDetails(_constraint, _displayName, _attributeData);

			return Status.OK_STATUS;
		}
	}

}
