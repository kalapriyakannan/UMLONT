/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * @author jswanke
 * 
 */
public class ZoomUtils {
	/**
	 * expand compartments until editpart is exposed
	 * 
	 * @param editingDomain
	 * @param editpart
	 * @return IStatus
	 */
	public static boolean expose(TransactionalEditingDomain editingDomain, GraphicalEditPart editpart) {

		// find collpased compartments above this editpart
		EditPart walker = editpart;
		List<ResizableCompartmentEditPart> collapsedList = new ArrayList<ResizableCompartmentEditPart>();
		while (walker != null) {
			if (walker instanceof DiagramEditPart) {
				break;
			} else if (walker instanceof ResizableCompartmentEditPart) {
				ResizableCompartmentEditPart compartmentEP = (ResizableCompartmentEditPart) walker;
				ResizableCompartmentFigure fig = (ResizableCompartmentFigure) compartmentEP.getFigure();
				if (fig != null && !fig.isExpanded()) {
					collapsedList.add(0, compartmentEP);
				}

			}
			walker = walker.getParent();
		}

		// if there are any, expose them now
		if (collapsedList.size() > 0) {
			FigureCanvas fc = (FigureCanvas) editpart.getViewer().getControl();
			fc.setRedraw(false);
			collapseViews(editingDomain, collapsedList, false);
			fc.setRedraw(true);
			return true;
		}
		return false;
	}

	/**
	 * @param editpart
	 * @return IStatus
	 */
	public static boolean expose(IGraphicalEditPart editpart) {
		return expose(editpart.getEditingDomain(), editpart);
	}

	/**
	 * @param editpart
	 * @return is editpart in a collpased container
	 */
	public static boolean isExposed(DeployShapeNodeEditPart editpart) {
		EditPart walker = editpart;
		while (walker != null) {
			if (walker instanceof ResizableCompartmentEditPart) {
				ResizableCompartmentEditPart compartmentEP = (ResizableCompartmentEditPart) walker;
				View view = compartmentEP.getNotationView();
				if (view != null
						&& ((Boolean) ViewUtil.getStructuralFeatureValue(view, NotationPackage.eINSTANCE
								.getDrawerStyle_Collapsed())).booleanValue()) {
					return false;
				}
			}
			walker = walker.getParent();
		}
		return true;
	}

	/**
	 * expand all compartments in this editpart
	 * 
	 * @param editingDomain
	 * @param editpart
	 * @param isExpand
	 *           whether to expand all or collpase all
	 * @return IStatus
	 */
	public static IStatus explode(TransactionalEditingDomain editingDomain,
			GraphicalEditPart editpart, boolean isExpand) {

		List<ResizableCompartmentEditPart> explodeList = new ArrayList<ResizableCompartmentEditPart>();
		explodeHelper(editpart.getChildren(), explodeList, isExpand);

		// if there are any, expose them now
		if (explodeList.size() > 0) {
			FigureCanvas fc = (FigureCanvas) editpart.getViewer().getControl();
			fc.setRedraw(false);
			IStatus status = collapseViews(editingDomain, explodeList, !isExpand);
			fc.setRedraw(true);
			return status;
		}
		return Status.OK_STATUS;
	}

	private static void explodeHelper(List children, List<ResizableCompartmentEditPart> explodeList,
			boolean isExpand) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			EditPart child = (EditPart) it.next();
			if (child instanceof ResizableCompartmentEditPart) {
				ResizableCompartmentEditPart compartmentEP = (ResizableCompartmentEditPart) child;
				ResizableCompartmentFigure fig = (ResizableCompartmentFigure) compartmentEP.getFigure();
				if (fig != null && isExpand != fig.isExpanded()
						&& (!isExpand || compartmentEP.getChildren().size() > 0)) { // dont' expand an empty compartment
					explodeList.add(0, compartmentEP);
				}
			}
			explodeHelper(child.getChildren(), explodeList, isExpand);
		}
	}

	/**
	 * this version can be called from a transaction so that it can be undone
	 * 
	 * @param editpart
	 * @param isExpand
	 */
	public static void explode(GraphicalEditPart editpart, boolean isExpand) {
		List<ResizableCompartmentEditPart> explodeList = new ArrayList<ResizableCompartmentEditPart>();
		explodeHelper(editpart.getChildren(), explodeList, isExpand);

		// if there are any, expose them now
		if (explodeList.size() > 0) {
			FigureCanvas fc = (FigureCanvas) editpart.getViewer().getControl();
			fc.setRedraw(false);
			for (Iterator it = explodeList.listIterator(); it.hasNext();) {
				GraphicalEditPart compartmentEP = (GraphicalEditPart) it.next();
				View view = (View) compartmentEP.getModel();
				if (view != null) {
					ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
							.getDrawerStyle_Collapsed(), new Boolean(!isExpand));
					compartmentEP.refresh();
				}
			}
			fc.setRedraw(true);
		}
	}

	/**
	 * deselect all the children of the editpart
	 * 
	 * @param ep
	 */
	public static void deselect(EditPart ep) {
		deselectHelper(ep.getViewer(), ep.getChildren());
	}

	private static void deselectHelper(EditPartViewer viewer, List children) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			EditPart child = (EditPart) it.next();
			viewer.deselect(child);
			deselectHelper(viewer, child.getChildren());
		}
	}

	/**
	 * if editpart lives in a container, walk up until we get a selectable parent
	 * 
	 * @param editpart
	 * @return parent or editpart
	 */
	public static GraphicalEditPart getSelectableParentEditPart(GraphicalEditPart editpart) {
		EditPart walker = editpart;
		while (walker != null) {
			if (walker.isSelectable() && !(walker instanceof ResizableCompartmentEditPart)
					&& !(walker.getParent() instanceof ListCompartmentEditPart)) {
				return (GraphicalEditPart) walker;
			}
			walker = walker.getParent();
		}
		return null;
	}

	/**
	 * @param editingDomain
	 * @param compartmentList
	 * @param isCollapsed --
	 *           true to collpase, false to expand
	 * @return IStatus
	 */
	public static IStatus collapseViews(TransactionalEditingDomain editingDomain,
			final List compartmentList, final boolean isCollapsed) {
		Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain, StringStatics.BLANK,
				options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				for (Iterator it = compartmentList.listIterator(); it.hasNext();) {
					GraphicalEditPart compartmentEP = (GraphicalEditPart) it.next();
					View view = (View) compartmentEP.getModel();
					if (view != null) {
						ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE
								.getDrawerStyle_Collapsed(), new Boolean(isCollapsed));
						compartmentEP.refresh();
					}
				}
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
		return Status.OK_STATUS;
	}

}
