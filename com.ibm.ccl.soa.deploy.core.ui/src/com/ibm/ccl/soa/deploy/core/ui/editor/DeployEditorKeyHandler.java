/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HybridShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @author jswanke NOTE: keyhandler substitutions are made in DeployCoreEditor for delete key
 * 
 */
public class DeployEditorKeyHandler extends GraphicalViewerKeyHandler {

	private final DeployCoreEditor _editor;

	/**
	 * @param editor
	 */
	public DeployEditorKeyHandler(DeployCoreEditor editor) {
		super(editor.getDiagramGraphicalViewer());
		_editor = editor;
	}

	/**
	 * Constructor
	 * 
	 * @param _editor
	 */

	public boolean keyPressed(KeyEvent e) {
		setKeyBooleans(e, true);

		// if up/down arrow keys, override default behaviour by navigating to the children of a tree
		switch (e.keyCode)
		{
		case SWT.ARROW_UP:
			if ((e.stateMask & SWT.ALT) != 0) {
				navigateOutOfCompartment(e);
				return true;
			}
			if (navigateNextSiblingOrChild(e, PositionConstants.NORTH)) {
				return true;
			}
			break;
		case SWT.ARROW_DOWN:
			if ((e.stateMask & SWT.ALT) != 0) {
				navigateIntoCompartment(e);
				return true;
			}
			if (navigateNextSiblingOrChild(e, PositionConstants.SOUTH)) {
				return true;
			}
			break;
		case SWT.CR:
			if (expandCompartment(e)) {
				return true;
			}
			break;
		}

		return super.keyPressed(e);
	}

	public boolean keyReleased(KeyEvent e) {
		setKeyBooleans(e, false);
		return super.keyReleased(e);
	}

	/**
	 * override standard handler-- include tree children in navigation list
	 * 
	 * @param event
	 * @param direction
	 * @return
	 */
	private boolean navigateNextSiblingOrChild(KeyEvent event, int direction) {
		return navigateNextSiblingOrChild(event, direction, getSiblings());
	}

	/*
	 * if this is an item in a hosting/business/import tree, include all expanded children in list
	 * else if a canvas shape or a shape in a group, just include the siblings
	 */
	private List<GraphicalEditPart> getSiblings() {
		GraphicalEditPart focusPart = (GraphicalEditPart) getViewer().getFocusEditPart();
		if (focusPart.getParent() != null) {
			IGraphicalEditPart topPart = (IGraphicalEditPart) GEFUtils.getTopEditPart(focusPart);
			// if we're in a tree, get all siblings in the tree
			if (topPart != focusPart && DeployShapeNodeEditPart.isTreeMode(topPart)) {
				List<GraphicalEditPart> list = new ArrayList<GraphicalEditPart>();
				IGraphicalEditPart ep = getCompartmentEditpart(topPart, false);
				if (ep != null) {
					getSiblingsAndChildren(ep.getChildren(), list);
				}
				return list;
			}
			return focusPart.getParent().getChildren();
		}
		List<GraphicalEditPart> list = new ArrayList<GraphicalEditPart>();
		list.add(focusPart);
		return list;
	}

	/*
	 * dig down getting all expanded hosting lists (only hosting lists are below the top tree)
	 */
	private void getSiblingsAndChildren(List<GraphicalEditPart> children,
			List<GraphicalEditPart> list) {
		for (Iterator<GraphicalEditPart> it = children.iterator(); it.hasNext();) {
			EditPart ep = it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart child = (DeployShapeNodeEditPart) ep;
				list.add(child);
				IGraphicalEditPart hostListEP = child
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (hostListEP != null
						&& ((ResizableCompartmentFigure) hostListEP.getFigure()).isExpanded()) {
					getSiblingsAndChildren(hostListEP.getChildren(), list);
				}
			}
		}
	}

	private boolean navigateNextSiblingOrChild(KeyEvent event, int direction, List list) {
		GraphicalEditPart epStart = getFocusEditPart();
		IFigure figure = epStart.getFigure();
		Point pStart = getTreeNavigationPoint(figure);
		figure.translateToAbsolute(pStart);
		EditPart next = findSiblingOrChild(list, pStart, direction, epStart);
		if (next == null) {
			return false;
		}
		navigateTo(next, event);
		return true;
	}

	private GraphicalEditPart findSiblingOrChild(List siblings, Point pStart, int direction,
			EditPart exclude) {
		GraphicalEditPart epCurrent;
		GraphicalEditPart epFinal = null;
		IFigure figure;
		Point pCurrent;
		int distance = Integer.MAX_VALUE;

		boolean inShapeContainer = exclude.getParent() instanceof DiagramEditPart
				|| exclude.getParent() instanceof HybridShapesCompartmentEditPart;
		Iterator iter = siblings.iterator();
		while (iter.hasNext()) {
			epCurrent = (GraphicalEditPart) iter.next();
			if (epCurrent == exclude || !epCurrent.isSelectable()) {
				continue;
			}
			figure = epCurrent.getFigure();
			pCurrent = getTreeNavigationPoint(figure);
			figure.translateToAbsolute(pCurrent);
			if (inShapeContainer) {
				if (pStart.getPosition(pCurrent) != direction) {
					continue;
				}
			} else {
				if (getPosition(pStart, pCurrent) != direction) {
					continue;
				}
			}

			int d = getDistanceOrthogonal(pStart, pCurrent);
			if (d < distance) {
				distance = d;
				epFinal = epCurrent;
			}
		}
		return epFinal;
	}

	// in a tree we only care about up or down
	private int getPosition(Point p1, Point p2) {
		int dy = p2.y - p1.y;
		if (dy < 0) {
			return PositionConstants.NORTH;
		}
		return PositionConstants.SOUTH;
	}

	private int getDistanceOrthogonal(Point pt1, Point pt2) {
		return Math.abs(pt2.y - pt1.y);
	}

	// the center of a tree figure actually includes its children
	// so just measure from top
	private Point getTreeNavigationPoint(IFigure figure) {
		return figure.getBounds().getTop();
	}

	/**
	 * if on an expandable compartment that's collapsed, expand the compartment and vice versa
	 * 
	 * @param e
	 * @return
	 */
	private boolean expandCompartment(KeyEvent e) {
		GraphicalEditPart focusEP = getFocusEditPart();
		final IGraphicalEditPart ep = getCompartmentEditpart((IGraphicalEditPart) focusEP, true);
		if (ep != null) {
			BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
				public void run() {
					boolean isExpanded = ((ResizableCompartmentFigure) ep.getFigure()).isExpanded();
					ChangePropertyValueRequest expandReq = new ChangePropertyValueRequest(
							DiagramUIMessages.PropertyDescriptorFactory_CollapseCompartment,
							Properties.ID_COLLAPSED, new Boolean(isExpanded));
					Command cmd = ep.getCommand(expandReq);
					if (cmd != null && cmd.canExecute()) {
						cmd.execute();
					}
				}
			});
			return true;
		}
		return false;
	}

	private IGraphicalEditPart getCompartmentEditpart(IGraphicalEditPart parentEP,
			boolean includeGroup) {
		if (parentEP == null) {
			return null;
		}
		IGraphicalEditPart ep = null;
		if (includeGroup) {
			ep = parentEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		}
		if (ep == null) {
			ep = parentEP.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		}
		if (ep == null) {
			ep = parentEP.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
		}
		if (ep == null) {
			ep = parentEP.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
		}
		return ep;
	}

	private void navigateOutOfCompartment(KeyEvent event) {
		// walkup to next DeployShapeNodeEditPart
		EditPart walker = getFocusEditPart();
		while (walker != null) {
			walker = walker.getParent();
			if (walker instanceof DeployShapeNodeEditPart) {
				break;
			}
		}
		if (getFocusEditPart() == null || getFocusEditPart() == getViewer().getContents()
				|| getFocusEditPart().getParent() == getViewer().getContents()) {
			return;
		}
		navigateTo(walker, event);
	}

	private void navigateIntoCompartment(KeyEvent event) {
		GraphicalEditPart focus = getFocusEditPart();
		IGraphicalEditPart compartmentEP = getCompartmentEditpart((IGraphicalEditPart) focus, true);
		List childList = compartmentEP.getChildren();
		Point tl = focus.getFigure().getBounds().getTopLeft();

		int minimum = Integer.MAX_VALUE;
		GraphicalEditPart closestPart = null;

		for (int i = 0; i < childList.size(); i++) {
			GraphicalEditPart ged = (GraphicalEditPart) childList.get(i);
			if (!ged.isSelectable()) {
				continue;
			}
			Rectangle childBounds = ged.getFigure().getBounds();

			int current = childBounds.x - tl.x + childBounds.y - tl.y;
			if (current < minimum) {
				minimum = current;
				closestPart = ged;
			}
		}
		if (closestPart != null) {
			navigateTo(closestPart, event);
		}
	}

	private void setKeyBooleans(KeyEvent e, boolean b) {
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) _editor.getDiagramEditPart();
		if (ddep != null) {
			if (e.keyCode == SWT.CTRL) {
				ddep.setControlKey(b);
			} else if (e.keyCode == SWT.SHIFT) {
				ddep.setShiftKey(b);
			} else if (e.keyCode == SWT.ALT) {
				ddep.setAltKey(b);
			}
		}
	}

}
