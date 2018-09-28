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
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromNotationalCommand;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
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
public class DiagramListCompartmentCanonicalEditPolicy extends DeployCanonicalEditPolicy {

	/**
	 * 
	 */
	public DiagramListCompartmentCanonicalEditPolicy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List getSemanticChildrenList() {
		EObject eObject = resolveSemanticElement();
		if (eObject instanceof Diagram) {
			EditPart parent = getHost().getParent();
			if (parent instanceof DiagramNodeEditPart) {
				DiagramNodeEditPart dnep = (DiagramNodeEditPart) parent;
				List<DeployModelObject> diagramUnits = dnep.refreshDiagramUnits();
				return CanonicalUtils.filterOutContainedUnits(GMFUtils
						.getDeployDiagramEditPart(getHost()), diagramUnits, null, diagramUnits, true,
						getHost(), null);
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
			return new ICommandProxy(new VisualizeFromNotationalCommand(ep.getEditingDomain(),
					(IGraphicalEditPart) getHost().getParent(), descriptorList, null, diagram));
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
		pruneTreeViews();

		// do canonical refresh on tree, don't refresh inside of tree
		CanonicalUtils.refresh(GMFUtils.getDiagramNodeEP(getHost()), false);
	}

	/**
	 * since this is a tree of views, we need to prune all views first based on semenatic element,
	 * otherwise if a lower compartment is deleted, it's canonical edit policy won't be used to
	 * delete the views higher up in the tree
	 */
	private void pruneTreeViews() {
		// get all views currently in the import
		List<View> viewChildren = new ArrayList<View>();
		getViewChildrenList(getHost().getChildren(), viewChildren);
		// get all semantic elements currently in the diagram
		List<EObject> semanticChildren = new ArrayList<EObject>();
		Diagram diagram = (Diagram) ((IGraphicalEditPart) getHost()).resolveSemanticElement();
		getSemanticChildrenList(DiagramUtils.getAllChildViewsIncludingGroup(diagram),
				semanticChildren);

		// determine which views no longer have a valid semantic element
		List<View> orphaned = new ArrayList<View>();
		for (Iterator<View> it = viewChildren.iterator(); it.hasNext();) {
			View viewChild = it.next();
			if (semanticChildren == null || !semanticChildren.contains(viewChild.getElement())) {
				orphaned.add(viewChild);
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

	private void getSemanticChildrenList(List<View> children, List<EObject> semanticChildren) {
		for (Iterator<View> it = children.iterator(); it.hasNext();) {
			View view = it.next();
			if (view.getElement() != null) {
				semanticChildren.add(view.getElement());
			}
			if (view.getChildren().size() > 0) {
				getSemanticChildrenList(view.getChildren(), semanticChildren);
			}
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

}
