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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * @since 1.0
 * 
 */
public class HostingLinkCanonicalConnectorEditPolicy extends DeployLinkCanonicalConnectorEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	protected List getSemanticConnectionsList() {
		if (getHostUnit() != null) {
			// get hosting links for this unit from link cache-- non visible hosting links are filtered out			
			UnitLinkData linkData = getLinkCacheMap().get(getHostUnit());
			if (linkData != null && linkData.hasHostingLinks()) {
				boolean isHostInImportTopologyEditPart = GMFUtils.isImportTreeTopology(getHost());
				List hostingLinks = new ArrayList();
				for (Iterator it = linkData.getHostingLinks().iterator(); it.hasNext();) {
					HostingLink link = (HostingLink) it.next();
					// if this link isn't invisible (links shown thru containment aren't created)
					Unit host = link.getHost();
					Unit hosted = link.getHosted();
					if (!isFilterContainedLink((GraphicalEditPart) getHost(),
							isHostInImportTopologyEditPart, host, hosted)) {
						hostingLinks.add(link);
					}
				}
				return hostingLinks;
			}
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @param ep
	 * @param isHostInImportTopologyEditPart
	 * @param host
	 * @param hosted
	 * @return is this link filtered out because its relationship is shown thru containement
	 */
	static public boolean isFilterContainedLink(GraphicalEditPart ep,
			boolean isHostInImportTopologyEditPart, Unit host, Unit hosted) {
		if (host == null || hosted == null) {
			return true;
		}

		boolean isContainedUnit = ContainmentStateUtils.isContainedUnit(ep, hosted)
				&& !isHostingLinkToSiblingShape(ep, host, hosted);
		if (!PropertyUtils.isProxy(hosted)) {
			if (isContainedUnit) {
				return true;
			}
		} else if (host.isPublic()) {
			// if in a import tree, remove if host is in same tree (all hosts are contained by default in import tree)
			if (isHostInImportTopologyEditPart
					&& isAllHostedInSameImportTopologyEditPart(ep, host, hosted)) {
				// only filter is in same import topology-- links to outside of tree are not filtered
				if (PropertyUtils.isProxy(host.getTopology())) {
					return true;
				}
				// if outside of a tree, filter out if user mark it to be contained
			} else if (isContainedUnit) {
				return true;
			}
		}
		return false;
	}

	// even a contained hostee might show its hosting link if:
	// 1) it's in a shape container
	// 2) it has a hosting link to one of its siblings
	// this can happen if the hostee is connected to the shape container by a membership link or another hosting link
	static private boolean isHostingLinkToSiblingShape(GraphicalEditPart ep, Unit host, Unit hosted) {
		EditPart parent = ep.getParent();
		if (parent instanceof HybridShapesCompartmentEditPart
				|| parent instanceof DeployDiagramEditPart) {
			GraphicalEditPart parentEP = (GraphicalEditPart) parent;
			Unit policyHostUnit = (Unit) ep.resolveSemanticElement();
			for (Iterator<?> it = parentEP.getChildren().iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart siblingEP = (DeployShapeNodeEditPart) o;
					EObject eo = siblingEP.resolveSemanticElement();
					if (eo instanceof Unit) {
						Unit siblingUnit = (Unit) eo;
						// ignore myself
						if (siblingUnit != policyHostUnit) {
							if (host == siblingUnit || hosted == siblingUnit) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	// are all hosted units also in the import edit part-- if not we need to create a link to a duplicate canvas editpart
	// --if say a link should be created here, the edge can still be filtered out by the duplicate link filter or 
	//    hidden by the deployconnection if its within a import tree
	static private boolean isAllHostedInSameImportTopologyEditPart(GraphicalEditPart ep, Unit host,
			Unit hosted) {
		List<DeployShapeNodeEditPart> hostList = GMFUtils.getEditPartsFor(ep, host);
		Set<DeployShapeNodeEditPart> importSet = new HashSet<DeployShapeNodeEditPart>();
		for (DeployShapeNodeEditPart hostEP : hostList) {
			importSet.add(GMFUtils.getImportTopologyEP(hostEP));
		}
		for (Iterator<DeployShapeNodeEditPart> it = GMFUtils.getEditPartsFor(ep, hosted).iterator(); it
				.hasNext();) {
			if (!importSet.contains(GMFUtils.getImportTopologyEP(it.next()))) {
				return false;
			}
		}
		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * gets the source unit from the link object
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject getSourceElement(EObject relationship) {
		HostingLink hostingLink = (HostingLink) relationship;
		return hostingLink.getHosted();
	}

	/*
	 * gets the target unit from the link object
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	protected EObject getTargetElement(EObject relationship) {
		HostingLink hostingLink = (HostingLink) relationship;
		return hostingLink.getHost();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * when creating the hosting link view, what semantic hint should it use
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getFactoryHint()
	 */
	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return DeployCoreConstants.HOSTINGLINK_SEMANTICHINT;
	}

	/*
	 * called when cleaning up hosting link views that no longer target this unit's view
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	protected boolean shouldDeleteView(View view) {
		if (view instanceof Edge) {
			if (DeployCoreConstants.HOSTINGLINK_SEMANTICHINT.equals(view.getType())) {
				return true;
			}
		}
		return false;
	}
}
