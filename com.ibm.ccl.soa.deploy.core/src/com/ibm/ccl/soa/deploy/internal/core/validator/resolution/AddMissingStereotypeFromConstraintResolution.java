/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.constraints.StereotypeConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to add missing stereotypes based on included
 */
public class AddMissingStereotypeFromConstraintResolution extends DeployResolution {

	/**
	 * Construct a resolution to add a missing stereotype
	 * 
	 * @param aContext
	 *           the validation context
	 * @param aGenerator
	 *           the resolution generator.
	 */
	public AddMissingStereotypeFromConstraintResolution(IDeployResolutionContext aContext,
			IDeployResolutionGenerator aGenerator) {
		super(aContext, aGenerator);

		setDescription(computeDescription(context));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus status = context.getDeployStatus();
		List<Constraint> constraints = status.getConstraints();
		if (constraints == null || constraints.isEmpty()) {
			return Status.OK_STATUS;
		}
		for (Constraint constraint : constraints) {
			if (constraint instanceof StereotypeConstraint) {
				addMissingStereotypes((StereotypeConstraint) constraint, status.getDeployObject());
			}
		}
		return Status.OK_STATUS;
	}

	@SuppressWarnings("unchecked")
	private void addMissingStereotypes(StereotypeConstraint constraint, DeployModelObject dmo) {
		List<Stereotype> contextStereotypes = null;
		if (dmo instanceof Unit) {
			contextStereotypes = ((Unit) dmo).getStereotypes();
		} else if (dmo instanceof Capability) {
			contextStereotypes = ((Capability) dmo).getStereotypes();
		}
		List<String> missingStereotypes = StereotypeConstraintValidator.computeMissingStereotypes(
				constraint, contextStereotypes);
		if (missingStereotypes != null) {
			for (String missingStereotype : missingStereotypes) {
				addMissingStereotypes(missingStereotype, contextStereotypes);
			}
		}
	}

	private String computeDescription(IDeployResolutionContext aContext) {
		String depMessage = null;
		DeployModelObject dmo = aContext.getDeployStatus().getDeployObject();
		if (dmo instanceof Unit) {
			depMessage = DeployCoreMessages.Resolution_add_missing_stereotype_to_unit_0;
		} else {
			depMessage = DeployCoreMessages.Resolution_add_missing_stereotype_to_capability_0;
		}
		return NLS.bind(depMessage, new Object[] { DeployModelObjectUtil.getTitle(dmo) });

	}

	private void addMissingStereotypes(String missingStereotypeKey, List<Stereotype> stereotypes) {
		Stereotype newst = CoreFactory.eINSTANCE.createStereotype();
		newst.setKeyword(missingStereotypeKey);
		newst.setRequired(true);
		stereotypes.add(newst);
	}
}
