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

import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Resolves {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE} or
 * {@link ICoreProblemType#LINK_TARGET_UNCONTAINED} or
 * {@link ICoreProblemType#LINK_TARGET_UNDEFINED} or
 * {@link ICoreProblemType#HOSTING_LINK_TARGET_UNDEFINED} or
 * {@link ICoreProblemType#MEMBER_LINK_TARGET_UNDEFINED} or
 * {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_UNDEFINED} or
 * {@link ICoreProblemType#LINK_TARGET_UNCONTAINED}
 */
public class DeleteCorruptedLinkResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[] {};
		}

		return new IDeployResolution[] { new DeleteCorruptedLinkResolution(context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		String pt = context.getDeployStatus().getProblemType();
		//  Easier to check here than in enablement
		if (!(ICoreProblemType.LINK_TARGET_UNRESOLVABLE.equals(pt)
				|| ICoreProblemType.LINK_TARGET_UNDEFINED.equals(pt)
				|| ICoreProblemType.HOSTING_LINK_TARGET_UNDEFINED.equals(pt)
				|| ICoreProblemType.MEMBER_LINK_TARGET_UNDEFINED.equals(pt)
				|| ICoreProblemType.DEPENDENCY_LINK_TARGET_UNDEFINED.equals(pt) || ICoreProblemType.LINK_TARGET_UNCONTAINED
				.equals(pt))) {
			return false;
		}
		// if not DeployLink (sanity check)
		if (!(context.getDeployStatus().getDeployObject() instanceof DeployLink)) {
			return false;
		}
		DeployLink link = (DeployLink) context.getDeployStatus().getDeployObject();
		// if container not a DMO (sanity check)
		if (link.eContainer() == null || !(link.eContainer() instanceof DeployModelObject)) {
			return false;
		}
		EObject parent = link.eContainer();
		// Is proxied? This is the important test!
		if (((DeployModelObject) parent).getTopology() != ((DeployModelObject) parent)
				.getEditTopology()) {
			return false;
		}

		return true;
	}
}
