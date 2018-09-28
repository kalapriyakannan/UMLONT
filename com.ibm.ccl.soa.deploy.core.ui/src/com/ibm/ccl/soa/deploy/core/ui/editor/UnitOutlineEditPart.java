/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TreeEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployCoreCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Used by the outline view of {@link DeployCoreEditor}
 * 
 * @author Ed Snible
 */
class UnitOutlineEditPart extends TreeEditPart {

	private EditPart epOnDiagram;
	private View viewCore;
	private View viewList;
	private final EditPartViewer epv;

	protected UnitOutlineEditPart(EditPartViewer viewer, EditPart context, Node model) {
		super(model);

		epv = viewer;
	}

	protected List<Node> getModelChildren() {
//		System.out.println("UnitOutlineEditPart being asked about it's children"); //$NON-NLS-1$
		if (getEpOnDiagram() instanceof DeployShapeNodeEditPart) {
			// Although the code below makes the outline viewer display the correct value when
			// there are lazy Imports, we don't want to use it because it guarentees there are
			// no lazy imports!
//			// Before we call this, make sure there are no lazy edit parts
//			CanonicalUtils.refreshCollapsedCompartmentViews((IGraphicalEditPart) getEpOnDiagram());

			List<EditPart> lepMeaningfulChildren = expandCompartments(getEpOnDiagram().getChildren());
//			System.out.println(getEpOnDiagram().getClass()
//					+ " has " + lepMeaningfulChildren.size() + " children"); //$NON-NLS-1$//$NON-NLS-2$
			List<Node> retVal = editPartsToNodes(lepMeaningfulChildren);
			return retVal;
		}

		return Collections.emptyList();
	}

	// The method below adds a fake child to childless-imports.  It was an
	// attempt to guarantee all imports had a [+], and that expanding the
	// import always refreshed.  It worked, but was incomplete because it attached
	// to many listeners and didn't remove the dummy node.  However, it was useless because GMF usually
	// expands the whole tree, so one might as well use the single-line 
	// CanonicalUtils.refreshCollapsedCompartmentViews() in getModelChildren() instead.

//	@Override
//	protected void refreshChildren() {
//		super.refreshChildren();
//
//		// Imports are lazy, create a fake child if we have an Import with no children
//		if (getModel() instanceof View) {
//			View view = (View) getModel();
//			if (view.getElement() instanceof Import) {
//				List<?> c = getChildren();
//				if (c.size() == 0) {
//					// Create a child, but bypass our edit part factory and make something
//					// that won't have any model children
//					addChild(new TreeEditPart(getModel()), 0);
//
//					// Get the 
//					System.out.println("@@@ viewer=" + getViewer()); //$NON-NLS-1$
//					TreeViewer tviewer = (TreeViewer) getViewer();
//					Tree tree = (Tree) tviewer.getControl();
//					tree.addTreeListener(new TreeListener() {
//
//						public void treeCollapsed(TreeEvent e) {
//							// do nothing
//						}
//
//						public void treeExpanded(TreeEvent e) {
//							System.out.println(e);
//							if (e.item.getData() instanceof UnitOutlineEditPart) {
//								UnitOutlineEditPart uoEditPart = (UnitOutlineEditPart) e.item.getData();
//								View view = (View) uoEditPart.getModel();
//								if (view.getElement() instanceof Import) {
//									System.out.println("Expand of Import"); //$NON-NLS-1$
//									CanonicalUtils
//											.refreshCollapsedCompartmentViews((IGraphicalEditPart) uoEditPart
//													.getEpOnDiagram());
//									uoEditPart.refreshChildren();
//									// TODO Remove dummy
//								}
//							}
//						}
//					});
//				}
//			}
//		}
//	}

	private EditPart getEpOnDiagram() {
		if (epOnDiagram == null) {
//			// Get the diagram EditPart for the node
//			DeployCoreEditor dce = ResourceUtils.getActiveDeployEditDomain();
//			if (dce != null) {
//				IDiagramGraphicalViewer viewer = dce.getDiagramGraphicalViewer();
//				epOnDiagram = (EditPart) viewer.getEditPartRegistry().get(getModel());
//			}
			epOnDiagram = (EditPart) epv.getEditPartRegistry().get(getModel());
		}

		return epOnDiagram;
	}

	private List<Node> editPartsToNodes(List<EditPart> lepMeaningfulChildren) {
		List<Node> retVal = new LinkedList<Node>();

		for (EditPart ep : lepMeaningfulChildren) {
			if (ep.getModel() instanceof Node) {
				retVal.add((Node) ep.getModel());
			}
		}

		return retVal;
	}

	private List<EditPart> expandCompartments(List<EditPart> epchildren) {
		List<EditPart> retVal = new LinkedList<EditPart>();

		for (EditPart child : epchildren) {
			if (child instanceof DeployCoreCompartmentEditPart) {
				DeployCoreCompartmentEditPart dccep = (DeployCoreCompartmentEditPart) child;
				retVal.addAll(dccep.getChildren());
			} else if (child instanceof DeployListCompartmentEditPart) {
				DeployListCompartmentEditPart dlcep = (DeployListCompartmentEditPart) child;
				retVal.addAll(dlcep.getChildren());
			}
		}

		return retVal;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
//		System.out
//				.println("@@@UnitOutlineEditPart: Notification for feature " + ((EStructuralFeature) feature).getName()); //$NON-NLS-1$
		if (feature == NotationPackage.Literals.VIEW__TRANSIENT_CHILDREN
				|| feature == NotationPackage.Literals.VIEW__PERSISTED_CHILDREN) {
			refreshChildren();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	@Override
	public void activate() {
		super.activate();

		// At this point I could add another notification listener for the hosting compartment,
		// but instead I listen for model changes.
		EditPart epCore = getChild(getEpOnDiagram(), DeployCoreCompartmentEditPart.class);
		if (epCore != null) {
			viewCore = (View) epCore.getModel();
			getDiagramEventBroker().addNotificationListener(viewCore, this);
		}

		EditPart epList = getChild(getEpOnDiagram(), DeployListCompartmentEditPart.class);
		if (epList != null) {
			viewList = (View) epList.getModel();
			getDiagramEventBroker().addNotificationListener(viewList, this);
		}
	}

	@Override
	public void deactivate() {
		super.deactivate();

		if (viewCore != null) {
			getDiagramEventBroker().removeNotificationListener(viewCore, this);
		}
		if (viewList != null) {
			getDiagramEventBroker().removeNotificationListener(viewList, this);
		}
	}

	private EditPart getChild(EditPart ep, Class<? extends EditPart> clazz) {
		if (ep != null) {
			for (EditPart epChild : (List<EditPart>) ep.getChildren()) {
				if (clazz.isInstance(epChild)) {
					return epChild;
				}
			}
		}

		return null;
	}

//	private static class DummyTreeEditPart extends TreeEditPart {
//
//		public DummyTreeEditPart() {
//			super(model);
//			EObject ob;
//		}
//
//
//	}
} // end class UnitOutlineEditPart
