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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
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
public class ImportListCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {
	private Map<InstanceConfiguration, List<Unit>> importCacheMap;
	private Map<InstanceConfiguration, List<Unit>> listFilteredImportCacheMap;

	/**
	 * 
	 */
	public ImportListCompartmentCanonicalEditPolicy() {
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
						null, true, getHost(), ic.getVisibleUnits());
			} else {
				List visibleUnits = getImportCacheMap().get(ic);
				if (visibleUnits != null) {
					List diagramUnits = getDiagramUnits(importDiagram, visibleUnits);
					return CanonicalUtils.filterOutContainedUnits(getDdep(), diagramUnits, null,
							diagramUnits, true, getHost(), diagramUnits);
				}
			}
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * filter the visible units based on the diagram
	 * 
	 * @param importDiagram
	 * @param visibleUnits
	 * @return diagram filtered dmos
	 * 
	 */
	static public List<DeployModelObject> getDiagramUnits(Diagram importDiagram, List visibleUnits) {
		List<DeployModelObject> list = new ArrayList<DeployModelObject>();
		for (Iterator<View> it = DiagramUtils.getAllChildViewsIncludingGroup(importDiagram)
				.iterator(); it.hasNext();) {
			View view = it.next();
			EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
					.resolveSemanticElement(view);
			// if this is another import, scan its visible list too
			if (eo instanceof Import) {
				InstanceConfiguration instanceConfig = ((Import) eo).getInstanceConfiguration();
				for (Unit unit : instanceConfig.getVisibleUnits()) {
					for (Iterator it2 = visibleUnits.iterator(); it2.hasNext();) {
						Unit u = (Unit) it2.next();
						if (u.getQualifiedName().equals(unit.getQualifiedName())) {
							if (!list.contains(unit)) {
								list.add(unit);
							}
						}
					}
				}

			} else if (eo instanceof DeployModelObject) {
				// convert dmo to proxy
				for (Iterator<Unit> it2 = visibleUnits.iterator(); it2.hasNext();) {
					Unit importDmo = it2.next();
					if (importDmo.getQualifiedName().equals(((DeployModelObject) eo).getQualifiedName())
							&& !list.contains(importDmo)) {
						list.add(importDmo);
						break;
					}
				}
			}
		}
		return list;
	}

	private Map<InstanceConfiguration, List<Unit>> getImportCacheMap() {
		if (importCacheMap == null) {
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(host());
			importCacheMap = ddep.getSemanticCacheData().getImportCacheMap();
		}
		return importCacheMap;
	}

	// create views by copying them from the source diagram
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
		return super.getCreateViewCommand(request);
	}

	protected String getFactoryHint(IAdaptable elementAdapter, String defaultHint) {
		return null;
	}

	/**
	 * refresh import tree: 1) prune the tree views with missing elements 2) do a canonical refresh
	 * to move views around
	 */
	public void refreshTree() {

		// prune the tree of missing elements
		ImportTopologyEditPart importTopologyEP = GMFUtils.getImportTopologyEP(getHost());
		pruneTreeViews(importTopologyEP);

		// do canonical refresh on tree, don't refresh inside of tree
		CanonicalUtils.refresh(importTopologyEP, false);
	}

	/**
	 * since this is a tree of views, we need to prune all views first based on semenatic element,
	 * otherwise if a lower compartment is deleted, it's canonical edit policy won't be used to
	 * delete the views higher up in the tree
	 */
	private void pruneTreeViews(ImportTopologyEditPart importTopologyEP) {
		// get all views currently in the import
		List<View> viewChildren = new ArrayList<View>();
		getViewChildrenList(getHost().getChildren(), viewChildren);
		// get all semantic elements currently in the import
		Import imprt = (Import) importTopologyEP.resolveSemanticElement();
		if (imprt == null) {
			return;
		}
		InstanceConfiguration instanceConfig = imprt.getInstanceConfiguration();
		List<Unit> semanticChildren = getImportCacheMap().get(instanceConfig);

		// determine which views no longer have a valid semantic element
		List<View> orphaned = new ArrayList<View>();
		for (Iterator<View> it = viewChildren.iterator(); it.hasNext();) {
			View viewChild = it.next();
			if (semanticChildren == null || !semanticChildren.contains(viewChild.getElement())) {
//				orphaned.add(viewChild);
				orphaned.addAll(GMFUtils.getAllDuplicateViewsFor(importTopologyEP, viewChild, false));
			}
		}

		// prune all orphaned views
		final CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
		for (Iterator<View> it = orphaned.iterator(); it.hasNext();) {
			cc.add(getDeleteViewCommand(it.next()));
		}
		if (!cc.isEmpty() && cc.canExecute()) {
			executeCommand(cc);
		}
	}

	private void getViewChildrenList(List<EditPart> children, List<View> viewChildren) {
		for (Iterator<EditPart> it = children.iterator(); it.hasNext();) {
			EditPart ep = it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dsep = (DeployShapeNodeEditPart) ep;
				viewChildren.add(((DeployShapeNodeEditPart) ep).getNotationView());
				IGraphicalEditPart compartmentEP = dsep
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (compartmentEP != null) {
					getViewChildrenList(compartmentEP.getChildren(), viewChildren);
				}
			}
		}
	}

	private int getLevelsToImportTopologyEP(EditPart ep) {
		int levels = 0;
		EditPart walker = ep;
		while (walker != null) {
			levels++;
			if (walker instanceof ImportTopologyEditPart) {
				return levels;
			} else if (walker instanceof DeployDiagramEditPart) {
				return -1;
			}
			walker = walker.getParent();
		}
		return -1;
	}

}
