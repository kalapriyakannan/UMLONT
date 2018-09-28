/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to add missing stereotypes to realization targets.
 */
public class AddMissingStereotypeResolution extends DeployResolution {

	private DeployModelObject sourceDmo;
	private DeployModelObject targetDmo;

	/**
	 * Construct a resolution to add a missing stereotype
	 * 
	 * @param context
	 *           the validation context
	 * @param generator
	 *           the resolution generator.
	 */
	public AddMissingStereotypeResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);

		// We should have stored source and target DMOs in the bindings
		Object[] bindings = context.getDeployStatus().getBindings();
		if (bindings.length == 3) {
			if (bindings[1] instanceof DeployModelObject) {
				sourceDmo = (DeployModelObject) bindings[1];
			}
			if (bindings[2] instanceof DeployModelObject) {
				targetDmo = (DeployModelObject) bindings[2];
			}
		}

		setDescription(computeDescription(context));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {

		// TODO this only works for units
		/*
		 * DeployModelObject dmo = context.getDeployStatus().getDeployObject(); if (dmo instanceof
		 * RealizationLink) { RealizationLink link = (RealizationLink) dmo; DeployModelObject
		 * dmoSource = link.getSource(); DeployModelObject dmoTarget = link.getTarget();
		 * 
		 * addMissingStereotypes(dmoSource, dmoTarget); }
		 */

		if (sourceDmo != null && targetDmo != null) {
			addMissingStereotypes(sourceDmo, targetDmo);
		}

		return Status.OK_STATUS;
	}

	private String computeDescription(IDeployResolutionContext context) {
		String depMessage = null;

		if (targetDmo instanceof Unit) {
			depMessage = DeployCoreMessages.Resolution_add_missing_stereotype_to_unit_0;
		} else {
			depMessage = DeployCoreMessages.Resolution_add_missing_stereotype_to_capability_0;
		}
		return NLS.bind(depMessage, new Object[] { targetDmo.getDisplayName() });

	}

	private void addMissingStereotypes(DeployModelObject cdmo, DeployModelObject tdmo) {

		// TODO differentiate between unit, cap

		List<Stereotype> cSts = null;
		List<Stereotype> tSts = null;
		List<Stereotype> newSts = new ArrayList();
		if (cdmo instanceof Unit && tdmo instanceof Unit) {
			cSts = ((Unit) cdmo).getStereotypes();
			tSts = ((Unit) tdmo).getStereotypes();
		} else if (cdmo instanceof Capability && tdmo instanceof Capability) {
			cSts = ((Capability) cdmo).getStereotypes();
			tSts = ((Capability) tdmo).getStereotypes();
		} else {
			return; // should not get here
		}

		List<String> targetStereotypes = new ArrayList<String>();
		if (tSts != null) {
			Iterator<Stereotype> it = tSts.iterator();
			while (it.hasNext()) {
				Stereotype targetSt = it.next();
				String target_keyword = targetSt.getKeyword();
				targetStereotypes.add(target_keyword);
			}
		}

		Iterator<Stereotype> it2 = cSts.iterator();
		while (it2.hasNext()) {
			Stereotype sourceSt = it2.next();
			if (sourceSt.isRequired()) {
				String source_keyword = sourceSt.getKeyword();
				if (!targetStereotypes.contains(source_keyword)) {
					Stereotype newst = CoreFactory.eINSTANCE.createStereotype();
					newst.setKeyword(source_keyword);
					newst.setProfile(sourceSt.getProfile());
					newst.setRequired(sourceSt.isRequired());
					newSts.add(newst);
				}
			}
		}

		if (tdmo instanceof Unit) {
			Unit unit = (Unit) tdmo;
			unit.getStereotypes().addAll(newSts);
		} else if (tdmo instanceof Capability) {
			Capability cap = (Capability) tdmo;
			cap.getStereotypes().addAll(newSts);
		}

	}
}
