/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.uml.internal.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.uml.UMLDomainMessages;

/**
 * Resolution to add missing stereotype to a bound UML element
 */
public class AddMissingUmlStereotypeResolution extends DeployResolution {

	/**
	 * Construct a resolution to add a missing stereotype to a UML element
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 */
	public AddMissingUmlStereotypeResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);

		setDescription(computeDescription(context));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {

		DeployModelObject dmo = context.getDeployStatus().getDeployObject();
		if (dmo instanceof Unit) {
			Unit unit = (Unit) dmo;

			addMissingStereotypes(unit);
		}

		return Status.OK_STATUS;
	}

	private static String computeDescription(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		String message = null;

		DeployModelObject dmo = status.getDeployObject();
		if (dmo instanceof Unit) {
			Unit unit = (Unit) dmo;
			// TODO UML-specific message
			message = NLS.bind(UMLDomainMessages.Resolution_add_missing_uml_stereotype_to_0,
					new Object[] { unit.getDisplayName() });

		}

		return message;

	}

	private void addMissingStereotypes(Unit unit) {

		IDeployStatus status = context.getDeployStatus();
		// Extract binding info out of message bindings
		Object[] bindings = status.getBindings();
		if (bindings != null && bindings.length != 2) {
			return;
		}
		if (!(bindings[0] instanceof String) || !(bindings[1] instanceof String)) {
			return;
		}
		String keyword = (String) bindings[0];
		String profile = (String) bindings[1];
		Stereotype newst = CoreFactory.eINSTANCE.createStereotype();
		newst.setKeyword(keyword);
		newst.setProfile(profile);
		newst.setRequired(true);
		unit.getStereotypes().add(newst);

	}
}
