/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConstraintLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DependencyLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HostingLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.NameCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.RealizationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.SnapEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyConnectionEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnresolvedProxyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * Deploy tool Edit Part provider
 */
public class DeployCoreEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private final Map<String, Class> nodeHintMap = new HashMap<String, Class>();
	{
		nodeHintMap.put(DeployCoreConstants.DEPLOY_NAME, NameCompartmentEditPart.class);
		nodeHintMap.put(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT,
				UnresolvedProxyEditPart.class);

		nodeHintMap.put(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT,
				HybridListCompartmentEditPart.class);
		nodeHintMap.put(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT,
				HybridShapesCompartmentEditPart.class);

		nodeHintMap
				.put(DeployCoreConstants.IMPORTTOPOLOGY_SEMANTICHINT, ImportTopologyEditPart.class);
		nodeHintMap.put(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT,
				ImportListCompartmentEditPart.class);
		nodeHintMap.put(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT,
				ImportShapesCompartmentEditPart.class);

		nodeHintMap.put(DeployCoreConstants.DIAGRAMNODEVIEW_SEMANTICHINT, DiagramNodeEditPart.class);
		nodeHintMap.put(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT,
				DiagramListCompartmentEditPart.class);
		nodeHintMap.put(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT,
				DiagramShapesCompartmentEditPart.class);

		nodeHintMap.put(DeployCoreConstants.SNAPROW_SEMANTICHINT, SnapEditPart.class);
		nodeHintMap.put(DeployCoreConstants.SNAPGROUP_SEMANTICHINT, SnapEditPart.class);
	}

	private final Map<String, Class> edgeHintMap = new HashMap<String, Class>();
	{
		edgeHintMap
				.put(DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT, DependencyLinkEditPart.class);
		edgeHintMap.put(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT, HostingLinkEditPart.class);
		edgeHintMap.put(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT,
				RealizationLinkEditPart.class);
		edgeHintMap
				.put(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT, ConstraintLinkEditPart.class);
		edgeHintMap.put(DeployCoreConstants.UNRESOLVEDPROXY_SEMANTICHINT,
				UnresolvedProxyConnectionEditPart.class);
		edgeHintMap.put(DeployCoreConstants.CONSOLIDATIONLINK_SEMANTICHINT,
				ConsolidationLinkEditPart.class);
	}

	/**
	 * Gets a diagram's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class getDiagramEditPartClass(View view) {
		if (view.getType().equals(DeployCoreConstants.DEPLOY_CORE)) {
			return DeployDiagramEditPart.class;
		}
		return null;
	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class getNodeEditPartClass(View view) {
		String semanticHint = view.getType();
		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = nodeHintMap.get(semanticHint);
		} else {
			EClass eClass = getReferencedElementEClass(view);
			if (eClass == CorePackage.eINSTANCE.getUnit()) {
				EObject eObject = ViewUtil.resolveSemanticElement(view);
				Unit unit = (Unit) eObject;
				if (unit != null && unit.isGroup()) {
					clazz = UnitGroupEditPart.class;
				} else {
					// should never get here-- extension domains always override editpart provider
					clazz = UnitEditPart.class;
				}
			} /*
			 * else if (eClass == CorePackage.eINSTANCE.getSoftwareComponent()) { clazz =
			 * SoftwareComponentEditPart.class; }
			 */else if (eClass == CorePackage.eINSTANCE.getImport()) {
				clazz = ImportTopologyEditPart.class;
			}
		}
		return clazz;
	}

	/**
	 * Set the editpart class to the editpart mapped to the supplied view's semantic hint.
	 * 
	 * @see com.ibm.xtools.diagram.ui.services.editpart.AbstractEditPartProvider#setConnectorEditPartClass(com.ibm.xtools.diagram.ui.internal.view.IConnectorView)
	 */
	protected Class getEdgeEditPartClass(View view) {
		String semanticHint = view.getType();
		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = edgeHintMap.get(semanticHint);
		}

		return clazz;
	}
}
