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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * @since 1.0
 * 
 */
public class ConstraintLinkCanonicalConnectorEditPolicy extends
		DeployLinkCanonicalConnectorEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	protected List getSemanticConnectionsList() {
		if (getHostUnit() != null && host().isActive()) {
			// get logical links for this unit from link cache			
			UnitLinkData linkData = getLinkCacheMap().get(getHostUnit());
			if (linkData != null && linkData.hasConstraintLinks()) {
				boolean isHostInImportTopologyEditPart = GMFUtils.isImportTreeTopology(getHost());
				List constraintLinks = new ArrayList();
				for (Iterator it = linkData.getConstraintLinks().iterator(); it.hasNext();) {
					ConstraintLink link = (ConstraintLink) it.next();
					if (!GMFUtils.isHostingLink(link)) {
						constraintLinks.add(link);
					} else {
						// if this deferred hosting link isn't invisible (links shown thru containment aren't created)
						Unit host = GMFUtils.getUnit(link.getTarget());
						Unit hosted = GMFUtils.getUnit(link.getSource());
						if (!HostingLinkCanonicalConnectorEditPolicy
								.isFilterContainedLink((GraphicalEditPart) getHost(),
										isHostInImportTopologyEditPart, host, hosted)) {
							constraintLinks.add(link);
						}
					}
				}
				return constraintLinks;
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
		ConstraintLink logicalLink = (ConstraintLink) relationship;
		return logicalLink.getSource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject getTargetElement(EObject relationship) {
		ConstraintLink logicalLink = (ConstraintLink) relationship;
		return logicalLink.getTarget();
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT;
	}

	protected boolean shouldDeleteView(View view) {
		if (view instanceof Edge) {
			if (DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT.equals(view.getType())) {
				return true;
			}
		}
		return false;
	}
}
