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

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * @since 1.0 ** this CanonicalConnectorEditPolicy only fills in links for capabilities to
 *        requirements ** dependencies links between Services and References must be done by another
 *        policy
 * 
 */
public class DependencyLinkCanonicalConnectorEditPolicy extends
		DeployLinkCanonicalConnectorEditPolicy {

	/**
	 * 
	 */
	public DependencyLinkCanonicalConnectorEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	protected List getSemanticConnectionsList() {
		if (getHostUnit() != null && host().isActive()) {
			// get dependency links for this unit from link cache			
			UnitLinkData linkData = getLinkCacheMap().get(getHostUnit());
			if (linkData != null && linkData.hasDependencyLinks()) {
				return linkData.getDependencyLinks();
			}
		}
		return Collections.EMPTY_LIST;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject getSourceElement(EObject relationship) {
		DependencyLink dependencyLink = (DependencyLink) relationship;
		return dependencyLink.getSource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject getTargetElement(EObject relationship) {
		DependencyLink dependencyLink = (DependencyLink) relationship;
		return dependencyLink.getTarget();
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT;
	}

	protected boolean shouldDeleteView(View view) {
		if (view instanceof Edge) {
			if (DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT.equals(view.getType())) {
				return true;
			}
		}
		return false;
	}
}
