/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * Policy for refreshing {@link RealizationLink}s.
 * 
 * @author Ed Snible (based on HostingLinkCanonicalConnectorEditPolicy)
 * 
 * @see DeployEditPolicyRoles#REALIZATION_CANONICAL_ROLE
 */
public class RealizationLinkCanonicalConnectorEditPolicy extends
		DeployLinkCanonicalConnectorEditPolicy {

	/**
	 * @return List of {@link RealizationLink}
	 */
	protected List getSemanticConnectionsList() {
		if (getHostUnit() != null && host().isActive()) {
			// get realization links for this unit from link cache			
			UnitLinkData linkData = getLinkCacheMap().get(getHostUnit());
			if (linkData != null && linkData.hasRealizationLinks()) {
				return linkData.getRealizationLinks();
			}
		}
		return Collections.EMPTY_LIST;
	}

	protected EObject getSourceElement(EObject relationship) {
		RealizationLink realizationLink = (RealizationLink) relationship;
		return realizationLink.getSource();
	}

	protected EObject getTargetElement(EObject relationship) {
		RealizationLink realizationLink = (RealizationLink) relationship;
		return realizationLink.getTarget();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT;
	}

	protected boolean shouldDeleteView(View view) {
		if (view instanceof Edge) {
			if (DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT.equals(view.getType())) {
				return true;
			}
		}
		return false;
	}

} // end class RealizationLinkCanonicalConnectorEditPolicy

