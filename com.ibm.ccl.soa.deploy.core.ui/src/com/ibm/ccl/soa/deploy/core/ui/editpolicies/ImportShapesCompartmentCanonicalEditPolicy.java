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
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.ArrangeUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @since 1.0
 * 
 * This canonical edit policy is installed on the DiagramEditPart ensuring that all the Unit
 * contained by the Topology is visualized on the Diagram.
 * 
 * Note: Once we move to multiple diagram paradigm, we will have to remove else all diagrams will be
 * identical in terms of their contents.
 */
public class ImportShapesCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {
	private Map<InstanceConfiguration, List<Unit>> importCacheMap;
	private Map<InstanceConfiguration, List<Unit>> shapeFilteredImportCacheMap;

	/**
	 * 
	 */
	public ImportShapesCompartmentCanonicalEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Import) {
			Import imprt = (Import) eObject;
			InstanceConfiguration ic = imprt.getInstanceConfiguration();
			// Import Topology
			ImportTopologyEditPart ep = (ImportTopologyEditPart) getHost().getParent();
			Diagram importDiagram = ep.getImportDiagram();
			if (!(importDiagram instanceof Diagram)) {
				return CanonicalUtils.filterOutContainedUnits2(getDdep(), ic.getVisibleUnits(), null,
						null, false, getHost(), ic.getVisibleUnits());
			} else {
				return getDiagramUnits(importDiagram, ic.getVisibleUnits());
			}
		}
		return Collections.EMPTY_LIST;
	}

	protected Command getCreateViewCommand(CreateRequest request) {
		Diagram diagram = GMFUtils.getDiagram(getHost());
		if (diagram != null) {
			IGraphicalEditPart ep = (IGraphicalEditPart) getHost();
			List<CreateViewRequest.ViewDescriptor> descriptorList = ((CreateViewRequest) request)
					.getViewDescriptors();
			Import imprt = (Import) resolveSemanticElement();
			InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
			List visibleList = getImportCacheMap().get(instanceConfig);
			return new ICommandProxy(new VisualizeFromNotationalCommand(ep.getEditingDomain(),
					(IGraphicalEditPart) getHost().getParent(), descriptorList, visibleList, diagram));
		}
		// else position units in nice grid
		Command cmd = super.getCreateViewCommand(request);
		return ArrangeUtils.gridLayout(cmd, request, getHost());
	}

	/**
	 * filter the visible units based on the diagram
	 * 
	 * @param importDiagram
	 * @param visibleUnits
	 * @return diagram filtered dmos
	 * 
	 */
	static public List<DeployModelObject> getDiagramUnits(Diagram importDiagram, List<?> visibleUnits) {
		List<DeployModelObject> diagramList = new ArrayList<DeployModelObject>();
		getDiagramUnitsHelper(DiagramUtils.getAllChildViewsIncludingGroup(importDiagram),
				visibleUnits, diagramList);
		return diagramList;
	}

	static private void getDiagramUnitsHelper(List<?> children, List<?> visibleUnits,
			List<DeployModelObject> diagramList) {
		for (Iterator<?> it = children.iterator(); it.hasNext();) {
			View view = (View) it.next();
			EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.resolveSemanticElement(view);
			if (eo instanceof Import) {
				View container = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
						.getChildBySemanticHint(view, DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
				if (container == null) {
					container = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
							.getChildBySemanticHint(view,
									DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
				}
				if (container != null) {
					getDiagramUnitsHelper(container.getChildren(), visibleUnits, diagramList);
				}

			} else if (eo instanceof DeployModelObject) {
				// convert dmo to proxy
				for (Iterator<?> it2 = visibleUnits.iterator(); it2.hasNext();) {
					Unit importDmo = (Unit) it2.next();
					if (importDmo.getQualifiedName().equals(((DeployModelObject) eo).getQualifiedName())) {
						diagramList.add(importDmo);
						break;
					}
				}
			}
		}
	}

	private Map<InstanceConfiguration, List<Unit>> getImportCacheMap() {
		if (importCacheMap == null) {
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(host());
			importCacheMap = ddep.getSemanticCacheData().getImportCacheMap();
		}
		return importCacheMap;
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}

}
