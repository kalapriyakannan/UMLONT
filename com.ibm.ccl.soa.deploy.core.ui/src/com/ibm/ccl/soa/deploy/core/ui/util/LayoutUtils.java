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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.core.CompositeShapeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployResizableCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployShapeCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

/**
 * @author jswanke
 * 
 */
public class LayoutUtils {
	private static int SPACER = MapModeUtil.getMapMode().DPtoLP(15);

	private static int ENLARGE_SPACER = MapModeUtil.getMapMode().DPtoLP(30);
	private static int ENLARGE_SPACER2 = MapModeUtil.getMapMode().DPtoLP(5);

	private static int COLLAPSE_MAGNETIC_SPACER = MapModeUtil.getMapMode().DPtoLP(100);

	protected static final int EXPANDING = 0;
	protected static final int COLLAPSING = 1;
	protected static final int ENLARGING = 2;
	protected static final int SHRINKING = 3;
	protected static final int MOVING = 4;

	public static final int EXPAND = 0;
	public static final int COLLAPSE = 1;
	public static final int RESIZE = 2;

	protected static final int RETRY_DOWN = 1;
	protected static final int RETRY_RIGHT = 2;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////  CALLED WHEN NEW UNITS ARE ADDED TO CANVAS ////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// called when a resolution, tool palette, flyout palette, navigator adds a new unit(s) the the canvas
	// 1) arranges the units into a hosting stack
	// 2) then uses layoutViews to arrange canvas views around these new units

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// called by: ResolutionUIUtils.refreshAndHighlightTopologyDiff() to arrange then layout units
	//			 				that were added by a resolution 
	//				layout(EditPart ep, Collection<?> units, Point ptOrg) which was called after a popup toolbar has 
	//							added one or more new units externally to a container
	//				DeployDeferredLayoutCommand which is used by:
	//					AddToTopologyCommand-- to layout canvas around new diagram nodes
	//					DeployCreateElementAndViewCommand -- to layout canvas around new units dropped from palette
	//					VisualizeFromSemanticCommand -- to layout canvas around new units added by drop from navigator
	//					DragFeedbackFigure -- to arrange and layout canvas around units copied from a diagram/import container

	/**
	 * @param editParts --
	 *           list of ep's around which to layout the canvas
	 * @param ptOrg
	 */
	public static void layoutNewShapes(List<GraphicalEditPart> editParts, Point ptOrg) {
		int size = editParts.size();
		if (size == 0 || !(editParts.get(0) instanceof CompositeShapeEditPart)) {
			return;
			// in the case that a unit is added to a tree
		} else if (size == 1 && GMFUtils.isInList(editParts.get(0))) {
			ZoomUtils.expose(editParts.get(0));
			layoutNewTreeItem(editParts.get(0));
			return;
		}

		// determine the new rect size-- if more then one unit, arrange the parts into a hosting stack
		Rectangle n = null;
		View topView = null;
		Map v2eMap = ((EditPart) editParts.get(0)).getViewer().getEditPartRegistry();
		if (editParts.size() == 1) {
			topView = editParts.get(0).getNotationView();
			n = getFigureBounds(topView, v2eMap);
			// is this edit part where we want it?
			if (ptOrg != null && !ptOrg.equals(n.getTopLeft())) {
				n.setLocation(ptOrg);
				setViewBounds(editParts.get(0).getEditingDomain(), topView, n.getTopLeft(),
						getViewBounds(topView).getSize());
			}
		} else {
			n = ArrangeUtils.arrangeEditParts(editParts, ptOrg, true, true);
			topView = getTopLeftView(editParts);
		}
		if (n == null) {
			return;
		}

		// get list of the current rects on the canvas
		EditPart containerEP = editParts.get(0).getParent();
		Map<View, Rectangle> rectMap = new HashMap<View, Rectangle>();
		for (Iterator<?> it = containerEP.getChildren().iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof DeployShapeNodeEditPart && !editParts.contains(obj)) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) obj;
				rectMap.put(ep.getNotationView(), ep.getFigure().getBounds().getCopy());
			}
		}

		// first we move the old rect down/right until it doesn't overlap other figures
		// find the smallest move we can make 
		int retry = 0;
		Dimension delta = getMoveDelta(rectMap.values(), n);
		Rectangle o = n.getCopy();
		if (delta.height == -1 && delta.width != -1) {
			o.x += delta.width;
		} else if (delta.height != -1 && delta.width == -1) {
			o.y += delta.height;
		} else if (delta.height != -1 && delta.width != -1) {
			if (delta.height < delta.width) {
				retry = RETRY_RIGHT;
				o.y += delta.height;
			} else {
				retry = RETRY_DOWN;
				o.x += delta.width;
			}
		}

		// then we make the old rect shorter, narrower to fit in its spot
		for (Rectangle r : rectMap.values()) {
			Rectangle i = o.getCopy().intersect(r);
			if (!i.isEmpty()) {
				//if the new rect completely contains this canvas rect, (which can happen with big templates)
				// then calculate new width/heigth on pushing this unit down/right, 
				//  whichever chnage has the least impact
				if (o.contains(r)) {
					int nh = i.y - o.y;
					int nw = i.x - o.x;
					if (o.height - nh < o.width - nw) {
						o.height = nh;
					} else {
						o.width = nw;
					}

				} else if (r.contains(o.getTopRight())) {
					// narrower only
					o.width -= i.width;
				} else if (r.contains(o.getBottomLeft())) {
					//shorter only
					o.height -= i.height;
				} else if (i.width < i.height) {
					// narrower
					o.width -= i.width;
				} else {
					// shorter
					o.height -= i.height;
				}
			}
		}

		// if new rect and old rect are the same, no need to move it or layout views around it
		if (n.equals(o)) {
			return;
		}

		// create list of these views to ignore when laying out
		List<View> ignoreViews = new ArrayList<View>();
		for (Iterator<GraphicalEditPart> it = editParts.iterator(); it.hasNext();) {
			GraphicalEditPart ep = it.next();
			View view = ep.getNotationView();
			ignoreViews.add(view);
		}

		// now layout canvas with top/left editpart using fake size of all editparts
		DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(editParts.get(0));
		Rectangle t = getViewBounds(topView);
		setViewBounds(ddep.getEditingDomain(), topView, o.getTopLeft(), null);
		layoutViewsHelper(ddep.getEditingDomain(), topView, o.getTopLeft(), o.getSize(), n.getSize()
				.expand(500, 500), ENLARGING, ignoreViews, v2eMap);
		setViewBounds(ddep.getEditingDomain(), topView, t.getTopLeft(), null);

		// if we are retrying the move
		if (retry != 0) {
			// refresh rects with new positions
			for (Entry<View, Rectangle> entry : rectMap.entrySet()) {
				Rectangle rect = getViewBounds(entry.getKey());
				entry.getValue().setLocation(rect.getTopLeft());
			}
			Dimension newDelta = getMoveDelta(rectMap.values(), o);
			if (retry == RETRY_RIGHT && newDelta.width != -1) {
				o.x += newDelta.width;
			} else if (retry == RETRY_DOWN && newDelta.height != -1) {
				o.y += delta.height;
			}
		}

		// if old rect position is different then new rect, position all units from new rect to old rect
		// can't do this till after sibling layout, because we add a spacer to the difference to keep figs 
		//  from being next to each other
		if (!n.getTopLeft().equals(o.getTopLeft())) {
			Dimension d = o.getTopLeft().getDifference(n.getTopLeft());
			if (d.width != 0) {
				d.width += 250;
			}
			if (d.height != 0) {
				d.height += 250;
			}
			Map<View, Point> moveMap = new HashMap<View, Point>();
			for (Iterator<GraphicalEditPart> it = editParts.iterator(); it.hasNext();) {
				GraphicalEditPart ep = it.next();
				View view = ep.getNotationView();
				Rectangle r = getViewBounds(view);
				moveMap.put(view, r.getTopLeft().translate(d));
			}
			setViewsBounds(ddep.getEditingDomain(), moveMap, v2eMap, true, true);
		}
	}

	private static Dimension getMoveDelta(Collection<Rectangle> rectList, Rectangle n) {
		Dimension delta = new Dimension(-1, -1);
		for (Rectangle r : rectList) {
			Rectangle i = n.getCopy().intersect(r);
			if (!i.isEmpty()) {
				// try to make the least movement in the canvas
				// if intersecting on the top
				if (i.y == n.y && i.height < i.width) {
					if (i.height > delta.height) {
						delta.height = i.height;
					}
				}
				// if intersecting on the left, move old rect over
				if (i.x == n.x && i.height > i.width) {
					if (i.width > delta.width) {
						delta.width = i.width;
					}
				}
			}
		}
		return delta;
	}

	private static View getTopLeftView(List<GraphicalEditPart> editparts) {
		List<Entry<Point, View>> list = new ArrayList<Entry<Point, View>>(editparts.size());
		Map<Point, View> map = new HashMap<Point, View>();
		for (Iterator<GraphicalEditPart> it = editparts.iterator(); it.hasNext();) {
			View view = it.next().getNotationView();
			Rectangle r = getViewBounds(view);
			map.put(r.getTopLeft(), view);
		}
		list.addAll(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Point, View>>() {
			public int compare(Entry<Point, View> e1, Entry<Point, View> e2) {
				Point p1 = e1.getKey();
				Point p2 = e2.getKey();
				if (p1.equals(p2)) {
					return 0; // they are the same
				} else if (p1.y < p2.y) {
					return -1; // p1 is higher
				} else if (p1.y > p2.y) {
					return 1; // p2 is higher
				} else if (p1.x < p2.x) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		return list.get(0).getValue();
	}

	// called by: DeployableUnitElementUIService when adding units to canvas from popup toolbar

	/**
	 * @param ep
	 * @param units --
	 *           layout the editparts that belong to these units
	 * @param ptOrg
	 */

	public static void layoutNewShapes(EditPart ep, Collection<?> units, Point ptOrg) {
		List<GraphicalEditPart> editParts = new ArrayList<GraphicalEditPart>();
		for (Iterator<?> it = units.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof Unit) {
				editParts.addAll(GMFUtils.getEditPartsFor(ep, (Unit) o));
			}
		}
		layoutNewShapes(editParts, ptOrg);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////// CALLED WHEN NEW ITEM ADDED TO A TREE ///////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 1) resizes tree's parent view to accomodate the new item
	// 2) then calls layoutViews below to layout canvas views around new size

	// called by: 
	//		DiagramListCompartmentEditPart to change tree size after a diagram change
	// 	ImportListCompartmentEditPart to change tree size after import change
	// 	ResolutionUIUtils.exposeNewAndModifiedUnits in loop for each new added unit and all of its
	// 			duplicates -- to enlarge trees and make room for new units -- but called just before another
	// 			layout!? 
	//		LayoutUtil.layoutNewTreeItem(IGraphicalEditPart editpart, Collection<?> units)
	//

	/**
	 * @param editpart --
	 *           new editpart to layout canvas/group around
	 */
	public static void layoutNewTreeItem(IGraphicalEditPart editpart) {
		// layout of list item means an enlargement of top unit containing the item
		if (GMFUtils.isInList((GraphicalEditPart) editpart)) {
			DeployListCompartmentEditPart topListEP = GMFUtils
					.getTopList((GraphicalEditPart) editpart);
			IGraphicalEditPart topEP = (IGraphicalEditPart) topListEP.getParent();
			View topView = topEP.getNotationView();
			Rectangle bounds = getViewBounds(topView);
			Point location = bounds.getTopLeft();
			Dimension size = getListUnitSize(topListEP);
			setViewBounds(editpart.getEditingDomain(), topView, location, size);
			layoutViews(editpart.getEditingDomain(), topView, location, location, bounds.getSize(),
					size, null, false, -1);
		}
	}

	// called by: DeployableUnitElementUIService when the popup toolbar adds a new unit(s) to a container

	/**
	 * @param editpart
	 * @param units
	 */
	public static void layoutNewTreeItem(IGraphicalEditPart editpart, Collection<?> units) {
		for (Iterator<?> it = units.iterator(); it.hasNext();) {
			for (Iterator<DeployShapeNodeEditPart> it2 = GMFUtils.getEditPartsFor(editpart,
					(EObject) it.next()).iterator(); it2.hasNext();) {
				layoutNewTreeItem(it2.next());
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////  CALLED WHEN A COMPARMENT IS EXPANDED/COLLAPSED ////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 1) determines the new/old size and sets the new size, 
	// 2) then calls layoutViews below to layout canvas views around new size

	// called by: 
	//				DeployCoreCompartmentEditPart -- to set the new view bounds of a
	//						shape container and then layout canvas around that
	//				DeployListCompartmentEditPart -- to set the new view bounds of a
	//						tree container and then layout canvas around that
	/**
	 * set bounds, then enlarge any containing groups so that this view is completely in view
	 * 
	 * @param editpart
	 * @param location
	 * @param size
	 * @param innerEP --
	 *           if an inner list is expanded/collpased, the ep of the list
	 * @param isInnerCollapsed --
	 *           if inner list was collpased
	 * @return operation status
	 */
	public static IStatus setViewBoundsAndLayout(IGraphicalEditPart editpart, Point location,
			Dimension size, IGraphicalEditPart innerEP, boolean isInnerCollapsed) {
		final View view = (View) editpart.getModel();
		// if this view isn't in a container right now, nothing to layout
		if (!(view.eContainer() instanceof View)) {
			return Status.OK_STATUS;
		}
		Rectangle oldBounds = getViewBounds(view);
		TransactionalEditingDomain editingDomain = editpart.getEditingDomain();
		IStatus status = setViewBounds(editingDomain, view, location, size);
		if (status.isOK()) {
			// now layout views around new view size
			View innerView = innerEP != null ? (View) innerEP.getModel() : null;
			layoutViews(editingDomain, view, oldBounds.getTopLeft(), location, oldBounds.getSize(),
					size, innerView, isInnerCollapsed, -1);
		}
		return status;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////  CALLED WHEN ANY COMPARMENT CHANGES SIZE ////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// such as when the DeploySetBoundsCommand has been called -- or when a unit is moved into a compartment to make sure its big enough
	// 1) makes sure the compartment's parent is at least at 0,0 in its compartment (if not on the canvas)
	// 2) spreads out/sucks in surrounding views to accomidate the new size
	// 3) if in a compartment, makes sure that compartment is big enough or shrink wraps it
	//			-- which then calls the layout views around the new parent's size 

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// called by: 
	//			CopyViewCommand/MoveViewCommand -- to make sure a shape container is large 
	//						enough after units are copied into it
	//			DeploySetBoundsCommand -- to make sure a shape container is large enough after an 
	//						inner shape has been moved/resized
	//			layout(IGraphicalEditPart editpart)-- when the editpart is a tree container
	//			setViewBoundsAndLayout() -- to layout canvas around a expanded/collapsed compartment

	/**
	 * @param editingDomain
	 * @param view
	 * @param oldLocation
	 * @param newLocation
	 * @param oldSize
	 * @param newSize
	 * @param innerView --
	 *           if an inner list is expanded/collpased, the view of the list's container
	 * @param isInnerCollapsed --
	 *           if inner list was collpased
	 * @param layoutMode
	 *           force layout mode-- -1 if not forcing
	 */
	public static void layoutViews(TransactionalEditingDomain editingDomain, View view,
			Point oldLocation, Point newLocation, Dimension oldSize, Dimension newSize,
			View innerView, boolean isInnerCollapsed, int collapseMode) {

		if (ResourceUtils.getActiveDeployEditDomain() == null || oldSize == null || newSize == null
				|| oldLocation == null || newLocation == null) {
			return;
		}

		// get view to editpart map
		EditPartViewer viewer = ResourceUtils.getActiveDeployEditDomain().getDiagramEditPart()
				.getViewer();
		Map v2eMap = viewer.getEditPartRegistry();
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) ResourceUtils
				.getActiveDeployEditDomain().getDiagramEditPart();

		// determine if we want to layout this item
		IGraphicalEditPart ep = (IGraphicalEditPart) v2eMap.get(view);
		if (ep == null || ep.getFigure() == null) {
			ep = EditPartService.getInstance().createGraphicEditPart(view);
		}
		if (!(ep instanceof DeployShapeNodeEditPart)) {
			return;
		}

		// get collapse size
		Dimension collapseSize = new Dimension(-1, -1);
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			collapseSize.width = style.getCollapseWidth();
			collapseSize.height = style.getCollapseHeight();
		}

		// determine layout mode
		int layoutMode = MOVING;
		if (oldSize.equals(newSize)) {
			layoutMode = MOVING;
		} else if (collapseMode != RESIZE
				&& (collapseMode == EXPAND || oldSize.height == collapseSize.height || innerView != null
						&& !isInnerCollapsed)) {
			layoutMode = EXPANDING;
		} else if (collapseMode != RESIZE
				&& (collapseMode == COLLAPSE || newSize.height == collapseSize.height || innerView != null
						&& isInnerCollapsed)) {
			layoutMode = COLLAPSING;
		} else if (newSize.height >= oldSize.height || newSize.width >= oldSize.width) {
			layoutMode = ENLARGING;
		} else {
			layoutMode = SHRINKING;
		}

		// now either perform layout or restore a previous layout state
		switch (layoutMode)
		{
		case EXPANDING: {
			// save current view positions
			Map<View, Object> viewKeys = LayoutStates.getCompartmentViews(innerView == null ? view
					: innerView);
			Map<View, Object> mapkey = LayoutStates.refreshStates(ddep, viewKeys, null);
			mapkey.putAll(viewKeys); // make sure expanding ep's compartments are in key
			LayoutStates.saveState(ddep, mapkey, view, oldSize);

			// do layout
			layoutViewsHelper(editingDomain, view, newLocation, oldSize, newSize, layoutMode, null,
					v2eMap);
			break;
		}
		case COLLAPSING: {
			// restore previous position state (if any)
			Map<View, Object> viewKeys = LayoutStates.getCompartmentViews(innerView == null ? view
					: innerView);
			Map<View, Object> mapkey = LayoutStates.refreshStates(ddep, null, viewKeys);
			mapkey.putAll(viewKeys); // make sure collapsing ep is now in key
			if (!LayoutStates.restoreState(ddep, mapkey, v2eMap)
					&& ddep.getFigure().getChildren().size() > 15) {
				// if we couldn't restore a state, do algorithm after all
				layoutViewsHelper(editingDomain, view, newLocation, oldSize, newSize, layoutMode, null,
						v2eMap);

			}
			break;
		}
			// if moving, update any saved states
		case MOVING:
			LayoutStates.refreshStates(ddep, view, oldLocation, newLocation);
//			layoutViewsHelper(editingDomain, view, newLocation, oldSize, newSize, layoutMode, null,
//					v2eMap);
			break;

		// everything else, just do the compartment enlargement/spreading layout
		case ENLARGING:
		case SHRINKING:
			layoutViewsHelper(editingDomain, view, newLocation, oldSize, newSize, layoutMode, null,
					v2eMap);
			break;
		}

	}

	private static void layoutViewsHelper(TransactionalEditingDomain editingDomain, View view,
			Point location, Dimension oldSize, Dimension newSize, int layoutMode,
			List<View> ignoreViews, Map v2eMap) {

		// if sizes are -1,-1, get figure sizes
		if (oldSize.height == -1 || oldSize.width == -1) {
			oldSize.setSize(getCollapsedFigureBounds(view, v2eMap).getSize());
		}
		if (newSize.height == -1 || newSize.width == -1) {
			newSize.setSize(getCollapsedFigureBounds(view, v2eMap).getSize());
		}

		// if view is in a compartment, and below 0,0, move it up to 0,0 to turn off the scrollbars
		moveToZeroZero(editingDomain, view, location, newSize);

		// move the sibling views, either out to make room or in to remove extra space
		Rectangle newContentArea = layoutSiblingViews(editingDomain, view, oldSize, newSize,
				layoutMode, ignoreViews, v2eMap);

		// inflate/deflate any compartments that contain the view so that the view can be seen
		switch (layoutMode)
		{
		case EXPANDING:
		case ENLARGING:
//		case MOVING:
			inflateOuterCompartments(editingDomain, view, newContentArea, layoutMode, ignoreViews,
					v2eMap);
			break;
		case COLLAPSING:
		case SHRINKING:
			deflateOuterCompartments(editingDomain, view, newContentArea, layoutMode, ignoreViews,
					v2eMap);
			break;
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   MOVE To 0,0        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// makes sure a figure is at least at 0,0 in a compartment
	/**
	 * @param editingDomain
	 * @param view
	 * @param location
	 * @param size
	 * @return new location of view
	 */
	private static Point moveToZeroZero(TransactionalEditingDomain editingDomain, View view,
			Point location, Dimension size) {
		Point newLocation = new Point(location);
		EObject containerObj = view.eContainer();
		if (containerObj instanceof View) {
			View compartmentView = (View) containerObj;
			if (isShapeCompartmentView(compartmentView)) {
				if (compartmentView.eContainer() instanceof View) {

					// get bounds of compartment (using its parent's bounds)
					View parentView = (View) compartmentView.eContainer();
					Rectangle parentRect = getViewBounds(parentView);
					Rectangle compartmentRect = getCompartmentBounds(parentRect, compartmentView);

					// find the view's relative location within the compartment
					Rectangle viewRect = new Rectangle(location, size).translate(compartmentRect
							.getTopLeft());

					// now determine if we have to move the view to 0,0 to make it appear in compartment w/o scrollbars
					if (viewRect.x < compartmentRect.x || viewRect.y < compartmentRect.y) {
						if (viewRect.x < compartmentRect.x) {
							newLocation.x = 0;
						}
						if (viewRect.y < compartmentRect.y) {
							newLocation.y = 0;
						}
						IStatus status = setViewBounds(editingDomain, view, newLocation, null);
						if (!status.isOK()) {
							return location;
						}
					}
				}
			}
		}
		return newLocation;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   EXPAND OUTER COMPARTMENTS       /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param editingDomain
	 * @param view
	 * @param viewRect
	 * @param ignoreViews
	 * @param v2eMap
	 */
	private static void inflateOuterCompartments(TransactionalEditingDomain editingDomain,
			View view, Rectangle viewRect, int layoutMode, List<View> ignoreViews, Map v2eMap) {
		// loop up through all compartments potentially adding size to each
		EObject containerObj = view.eContainer();
		while (containerObj != null && !(containerObj instanceof Diagram)) {
			if (containerObj instanceof View) {
				View compartmentView = (View) containerObj;
				if (isShapeCompartmentView(compartmentView)) {
					if (compartmentView.eContainer() instanceof View) {

						// get bounds of compartment (using its parent's bounds)					
						View parentView = (View) compartmentView.eContainer();
						// if a member of a snap group, we don't layout
						Rectangle parentRect = getViewBounds(parentView);
						if (parentRect.width == -1 || parentRect.height == -1) {
							break; // error failsafe
						}
						Rectangle compartmentRect = getCompartmentBounds(parentRect, compartmentView);

						// find the view's relative location within the compartment
						viewRect = viewRect.translate(compartmentRect.getTopLeft());

						// now determine if the view appears in the compartment without enlarging the compartment
						if (!compartmentRect.contains(viewRect)) {
							// must enlarge compartment, start by getting a rect big enough for both compartment and view
							Rectangle bothRect = compartmentRect.getUnion(viewRect);
							Dimension parentSize = getParentSize(bothRect.getSize(), compartmentView);
							// padding
							parentSize.width += SPACER * 4;
							parentSize.height += SPACER;
							// enlarge the compartment's parent view
							IStatus status = setViewBounds(editingDomain, parentView, null, parentSize);
							if (!status.isOK()) {
								break;// error failsafe
							}
							// move the sibling views, either out to make room or in to remove extra space
							compartmentRect = layoutSiblingViews(editingDomain, parentView, parentRect
									.getSize(), parentSize, layoutMode, ignoreViews, v2eMap);
						}
						// the most recent compartment now becomes the view we have to fit in the next higher compartment
						viewRect = compartmentRect;
					}
				}
			}
			containerObj = containerObj.eContainer();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   SHRINK WRAP OUTER COMPARTMENTS       /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param editingDomain
	 * @param view
	 * @param viewRect
	 * @param ignoreViews
	 * @param v2eMap
	 */
	private static void deflateOuterCompartments(TransactionalEditingDomain editingDomain,
			View view, Rectangle viewRect, int layoutMode, List<View> ignoreViews, Map v2eMap) {
		// loop up through all compartments potentially adding size to each
		EObject containerObj = view.eContainer();
		while (containerObj != null && !(containerObj instanceof Diagram)) {
			if (containerObj instanceof View) {
				View compartmentView = (View) containerObj;
				if (isShapeCompartmentView(compartmentView)) {
					if (compartmentView.eContainer() instanceof View) {

						// get bounds of compartment (using its parent's bounds)					
						View parentView = (View) compartmentView.eContainer();
						// if a member of a snap group, we don't layout
						Rectangle parentRect = getViewBounds(parentView);
						if (parentRect.width == -1 || parentRect.height == -1) {
							break; // error failsafe
						}
						Rectangle compartmentRect = getCompartmentBounds(parentRect, compartmentView);

						// get bounds of all children of parent
						viewRect = getContentBounds(parentView, v2eMap);

						// now determine smallest size compartment can be and set it
						Dimension parentSize = getParentSize(viewRect.getSize(), compartmentView);
						// padding
						parentSize.width += SPACER * 6;
						parentSize.height += SPACER * 4;
						// shrink the view
						IStatus status = setViewBounds(editingDomain, parentView, null, parentSize);
						if (!status.isOK()) {
							break;// error failsafe
						}
						// move the sibling views, either out to make room or in to remove extra space
						compartmentRect = layoutSiblingViews(editingDomain, parentView, parentRect
								.getSize(), parentSize, layoutMode, ignoreViews, v2eMap);
						// the most recent compartment now becomes the view we have to fit in the next higher compartment
						viewRect = compartmentRect;
					}
				}
			}
			containerObj = containerObj.eContainer();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////   SPREAD OUT VIEWS        /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static Rectangle layoutSiblingViews(TransactionalEditingDomain editingDomain, View view,
			Dimension oldSize, Dimension newSize, int layoutMode, List<View> ignoreViews, Map v2eMap) {

		// if sizes are -1,-1, get figure sizes
		if (oldSize.height == -1 || oldSize.width == -1) {
			oldSize.setSize(getCollapsedFigureBounds(view, v2eMap).getSize());
		}
		if (newSize.height == -1 || newSize.width == -1) {
			newSize.setSize(getCollapsedFigureBounds(view, v2eMap).getSize());
		}
		int deltaWidth = newSize.width - oldSize.width;
		int deltaHeight = newSize.height - oldSize.height;

		// create a map of the sibiling views and their figure bounds
		// key = bounds, value = view;  omit target view
		Rectangle viewRect = null;
		Map<Rectangle, View> siblingMap = new HashMap<Rectangle, View>();
		Map<View, Rectangle> boundsMap = new HashMap<View, Rectangle>();
		View parentView = (View) view.eContainer();
		for (Iterator it = parentView.getChildren().iterator(); it.hasNext();) {
			View sibilingView = (View) it.next();
			// if a member of a snap group, we don't layout
			// if we're not ignoring this view, add it to the map
			if (view == sibilingView || ignoreViews == null || !ignoreViews.contains(sibilingView)) {
				Rectangle rect = getFigureBounds(sibilingView, v2eMap);
				boundsMap.put(sibilingView, rect);
				if (sibilingView == view) {
					viewRect = rect;
					viewRect.width = newSize.width;
					viewRect.height = newSize.height;
					boundsMap.put(view, viewRect);
				} else {
					siblingMap.put(rect, sibilingView);
				}
			}
		}

		// for expanding, move figures out away from expanding figure
		if (layoutMode == EXPANDING || layoutMode == ENLARGING) {
			// sort sibling map by distance to upper right corner of canvas
			List<Entry<Rectangle, View>> siblingViews = GMFUtils.getViewsByRectangle(siblingMap
					.entrySet());

			// push out units located to right of the view 
			int minHeight = Math.min(newSize.height, oldSize.height);
			Rectangle rightTargetArea = new Rectangle(viewRect.x, viewRect.y, 1000000, minHeight);
			Rectangle ignoreArea = new Rectangle(viewRect.x, viewRect.y, oldSize.width, 1000000);
			Map<View, Point> rightMoveMap = expandSiblingViews(view, siblingViews, rightTargetArea,
					ignoreArea, new Dimension(deltaWidth, 0), viewRect, boundsMap, ENLARGE_SPACER,
					ENLARGE_SPACER);

			// push down units located under view
			Rectangle bottomTargetArea = new Rectangle(viewRect.x, viewRect.y, 1000000, 1000000);
			Map<View, Point> bottomMoveMap = expandSiblingViews(view, siblingViews, bottomTargetArea,
					null, new Dimension(0, deltaHeight), viewRect, boundsMap, ENLARGE_SPACER,
					ENLARGE_SPACER);

			// now move the figures
			rightMoveMap.putAll(bottomMoveMap);
			if (rightMoveMap.size() > 0) {
				setViewsBounds(editingDomain, rightMoveMap, v2eMap, true, true);
			}
			// for collapsing, if we're here a restore state didn't exist, so try to remove empty space as best we can
		} else if (layoutMode == COLLAPSING || layoutMode == SHRINKING) {
			// add collapsed view to sibling map
			siblingMap.put(viewRect, view);

			// sort sibling map by distance to upper right corner of canvas
			List<Entry<Rectangle, View>> siblingViews = GMFUtils.getViewsByRectangle(siblingMap
					.entrySet());

			// target area is the area just to the right of the unit
			int maxHeight = Math.max(newSize.height, oldSize.height);
			Rectangle rightTargetArea = new Rectangle(viewRect.x, viewRect.y, oldSize.width
					+ COLLAPSE_MAGNETIC_SPACER, maxHeight);
			Map<View, Point> rightMoveMap = collapseSiblingViews(view, siblingMap, siblingViews,
					rightTargetArea, boundsMap, oldSize, new Dimension(-deltaWidth, 0), true);

			// push down units located under view
			// target area is the area just to the bottom of the unit
			Rectangle bottomTargetArea = new Rectangle(viewRect.x, viewRect.y, oldSize.width,
					oldSize.height + COLLAPSE_MAGNETIC_SPACER);
			Map<View, Point> bottomMoveMap = collapseSiblingViews(view, siblingMap, siblingViews,
					bottomTargetArea, boundsMap, oldSize, new Dimension(0, -deltaHeight), false);

			// now move the figures
			rightMoveMap.putAll(bottomMoveMap);
			if (rightMoveMap.size() > 0) {
				setViewsBounds(editingDomain, rightMoveMap, v2eMap, true, true);
			}
		}

		// return the new size of content
		Rectangle bounds = null;
		for (Iterator it = boundsMap.values().iterator(); it.hasNext();) {
			Rectangle r = (Rectangle) it.next();
			if (bounds == null) {
				bounds = r.getCopy();
			} else {
				bounds.union(r);
			}
		}
		return bounds;
	}

	// given a sibling map, affected area and delta size, move all affected siblings
	private static Map<View, Point> expandSiblingViews(View expandingView,
			List<Entry<Rectangle, View>> siblingViews, Rectangle targetArea, Rectangle ignoreArea,
			Dimension deltaSize, Rectangle viewRect, Map<View, Rectangle> boundsMap, int hspacer,
			int vspacer) {
		Map<View, Point> toBeMovedMap = new HashMap<View, Point>();
		boolean moveRight = deltaSize.width != 0;
		Rectangle firstAffectedArea = viewRect.getCopy().resize(hspacer, vspacer);

		// determine a real delta by seeing how far a unit has to move in order to move out from
		// under the orginal unit that's openned 
		int delta = 0;
		for (Iterator<Entry<Rectangle, View>> it = siblingViews.listIterator(); it.hasNext();) {
			Entry<Rectangle, View> entry = it.next();
			Rectangle siblingRect = entry.getKey();
			if (firstAffectedArea.intersects(siblingRect)
					&& (ignoreArea == null || !ignoreArea.intersects(siblingRect))) {
				int d = 0;
				if (moveRight) {
					d = firstAffectedArea.x + firstAffectedArea.width - siblingRect.x;
				} else {
					d = firstAffectedArea.y + firstAffectedArea.height - siblingRect.y;
				}
				if (d > delta) {
					delta = d;
				}
			}
		}
		// nothing overlapped, no spreading needed
		if (delta == 0) {
			return toBeMovedMap;
		}
		if (moveRight) {
			delta += hspacer;
			deltaSize.width = deltaSize.width > delta ? delta : deltaSize.width;
		} else {
			delta += vspacer;
			deltaSize.height = deltaSize.height > delta ? delta : deltaSize.height;
		}

		// now spread units away from expanding/enlarging unit
		// keep track of what areas of canvas had movement
		List<Rectangle> affectedAreaList = new ArrayList<Rectangle>();
		affectedAreaList.add(firstAffectedArea);
		boolean repeat = false;
		do {
			// loop through sibling map-- if any siblings are in affected area, add to move list
			Map<View, Rectangle> moveMap = new HashMap<View, Rectangle>();
			for (Iterator<Entry<Rectangle, View>> it = siblingViews.listIterator(); it.hasNext();) {
				Entry<Rectangle, View> entry = it.next();
				Rectangle siblingRect = entry.getKey();
				Rectangle siblingRectWithAnyAttachments = getRectWithAnyAttachments(entry.getValue(),
						siblingRect, expandingView, siblingViews);
				if (intersectsAffectedArea(siblingRectWithAnyAttachments, affectedAreaList)
						&& (moveRight && siblingRectWithAnyAttachments.x >= targetArea.x || !moveRight
								&& siblingRectWithAnyAttachments.y >= targetArea.y)) {

					// if in ignore area, ignore it
					if (ignoreArea != null && ignoreArea.intersects(siblingRectWithAnyAttachments)) {
						continue;
					}

					// move rect
					moveMap.put(entry.getValue(), siblingRect);
				}
			}

			// now loop thru move list moving siblings by deltaHeight 
			repeat = moveMap.size() > 0;
			for (Iterator it = moveMap.keySet().iterator(); it.hasNext();) {
				View siblingView = (View) it.next();
				Rectangle siblingRect = moveMap.get(siblingView);
				Rectangle movedRect = siblingRect.getTranslated(deltaSize.width, deltaSize.height);

				// move sibling by delta-- store in map for one big move later
				toBeMovedMap.put(siblingView, movedRect.getTopLeft());

				// increase targetArea by sibilingRect since it might cause other siblings to need to be moved
				targetArea = targetArea.union(movedRect);

				// update bounds map
				boundsMap.put(siblingView, movedRect);

				// update affected area list
				Rectangle affectedArea = siblingRect.getCopy();
				if (moveRight) {
					affectedArea.width += deltaSize.width + hspacer;
					affectedArea.height += ENLARGE_SPACER2; // also enlarge height so it doesn't slide up against another figure
				} else {
					affectedArea.height += deltaSize.height + vspacer;
					affectedArea.width += ENLARGE_SPACER2; // also enlarge width so it doesn't slide up against another figure
				}
				affectedAreaList.add(affectedArea);

				// remove sibling from list
				for (Iterator<Entry<Rectangle, View>> it2 = siblingViews.iterator(); it2.hasNext();) {
					Entry<Rectangle, View> entry = it2.next();
					if (siblingRect == entry.getKey()) {
						siblingViews.remove(entry);
						break;
					}
				}
			}
			// keep going until nothing moved
		} while (repeat);

		// return moves to make
		return toBeMovedMap;
	}

	// we treat views with attached views as one group of views
	private static Rectangle getRectWithAnyAttachments(View siblingView, Rectangle siblingRect,
			View expandingView, List<Entry<Rectangle, View>> siblingViews) {
		Rectangle rectWithAttachments = siblingRect.getCopy();

		List<View> neighborSnapGroupViews = ViewUtil.getAllSnapGroupViews(siblingView);
		if (!neighborSnapGroupViews.contains(expandingView)) {
			// for each snapped view
			for (Iterator<View> it = neighborSnapGroupViews.iterator(); it.hasNext();) {
				View view = it.next();
				if (view != siblingView) {
					// get its rect and union with original sibling rect
					Rectangle rect = findMatchingRect(view, siblingViews);
					if (rect != null) {
						rectWithAttachments = rectWithAttachments.union(rect);
					}
				}
			}
		}
		return rectWithAttachments;
	}

	private static Rectangle findMatchingRect(View view, List<Entry<Rectangle, View>> siblingViews) {
		for (Entry<Rectangle, View> e : siblingViews) {
			if (e.getValue() == view) {
				return e.getKey();
			}
		}
		return null;
	}

	private static boolean intersectsAffectedArea(Rectangle siblingRect,
			List<Rectangle> affectedAreaList) {
		boolean isAffected = false;
		for (Iterator it2 = affectedAreaList.iterator(); it2.hasNext() && !isAffected;) {
			Rectangle affectedArea = (Rectangle) it2.next();
			isAffected = siblingRect.intersects(affectedArea);
		}
		return isAffected;
	}

	////////////////////////////////// COLLAPSE /////////////////////////////////////////////////////////////////////
	// given a sibling map, affected area and delta size, move all affected siblings

	private static Map<View, Point> collapseSiblingViews(View collapsingView,
			Map<Rectangle, View> siblingMap, List<Entry<Rectangle, View>> siblingViews,
			Rectangle collpaseArea, Map<View, Rectangle> boundsMap, Dimension oldSize,
			Dimension deltaSize, boolean isRightMove) {
		Map<View, Point> toBeMovedMap = new HashMap<View, Point>();

		// keep track of new sibling positions
		Map<Rectangle, View> toBeMovedSiblingMap = new HashMap<Rectangle, View>();
		for (Iterator<Entry<Rectangle, View>> it = siblingMap.entrySet().iterator(); it.hasNext();) {
			Entry<Rectangle, View> e = it.next();
			toBeMovedSiblingMap.put(e.getKey().getCopy(), e.getValue());
		}

		// loop through sibling map-- if any siblings are in affected area, add to move list
		for (Iterator<Entry<Rectangle, View>> it = siblingViews.listIterator(); it.hasNext();) {
			Entry<Rectangle, View> entry = it.next();
			Rectangle siblingRect = entry.getKey();

			// if not in collapse area, ignore
			if (!siblingRect.intersects(collpaseArea)) {
				continue;
			}

			// create a target area to the right/below the unit 
			Rectangle targetArea;
			if (isRightMove) {
				targetArea = new Rectangle(siblingRect.x + siblingRect.width, siblingRect.y, 1000000,
						siblingRect.height);
			} else {
				targetArea = new Rectangle(siblingRect.x, siblingRect.y + siblingRect.height,
						siblingRect.width, 1000000);
			}

			boolean isRectFound = false;
			List<Rectangle> foundRects = new ArrayList<Rectangle>();
			do {
				// find the right-most rect in siblingMap that intersect this target area
				Rectangle neighborRect = findClosestIntersectingRect(siblingViews, targetArea,
						siblingRect, foundRects, isRightMove);
				isRectFound = neighborRect != null;

				// if any found and within our move area
				if (isRectFound) {
					foundRects.add(neighborRect);
					int space = 0;
					boolean isCollapsedView = entry.getValue() == collapsingView;
					if (isRightMove) {
						space = neighborRect.x - siblingRect.x;
						if (isCollapsedView) {
							space -= oldSize.width;
						} else {
							space -= siblingRect.width;
						}
					} else {
						space = neighborRect.y - siblingRect.y;
						if (isCollapsedView) {
							space -= oldSize.height;
						} else {
							space -= siblingRect.height;
						}
					}
					// must be in a magic magnetic area to be affected
					if (space < COLLAPSE_MAGNETIC_SPACER) {
						// see if this view is already moving
						View neighborView = siblingMap.get(neighborRect);
						if (!toBeMovedMap.containsKey(neighborView)) {

							// create a new neighbor rect that has been moved in to just max
							Set<View> neighborViewSet = new HashSet<View>();
							neighborViewSet.add(neighborView);
							List<View> neighborSnapGroupViews = ViewUtil
									.getAllSnapGroupViews(neighborView);
							if (!neighborSnapGroupViews.contains(collapsingView)) {
								neighborViewSet.addAll(neighborSnapGroupViews);
							}

							Rectangle neighborRectWithAnyAttachments = getRectWithAnyAttachments(
									neighborView, neighborRect, collapsingView, siblingViews);
							if (isRightMove) {
								neighborRectWithAnyAttachments.x -= deltaSize.width;
							} else {
								neighborRectWithAnyAttachments.y -= deltaSize.height;
							}
							// if this new neighber rect doesn't now intersect with another sibling rect, move it
							if (!insersectsSiblings(toBeMovedSiblingMap, neighborRectWithAnyAttachments,
									neighborViewSet)) {
								// for all views-- multiple if there are attached views
								for (View view : neighborViewSet) {
									Rectangle rect = findMatchingRect(view, siblingViews);
									if (rect != null) {
										Rectangle newRect = rect.getCopy();
										if (isRightMove) {
											newRect.x -= deltaSize.width;
										} else {
											newRect.y -= deltaSize.height;
										}
										// remember for moving later
										toBeMovedMap.put(view, newRect.getTopLeft());
										// update the to be moved sibiling map
										toBeMovedSiblingMap.remove(rect);
										toBeMovedSiblingMap.put(newRect, view);
										// update bounds map
										boundsMap.put(view, newRect);
										// expand collpase area to include this neighbor and its target area
										collpaseArea = collpaseArea.union(rect.getCopy().expand(
												isRightMove ? COLLAPSE_MAGNETIC_SPACER : 0,
												isRightMove ? 0 : COLLAPSE_MAGNETIC_SPACER));
									}
								}
							}
						}
					}
				}
			} while (isRectFound);
		}
		// update sibling map with new rect positions
		siblingMap.clear();
		siblingMap.putAll(toBeMovedSiblingMap);

		// return moves to make
		return toBeMovedMap;
	}

	private static Rectangle findClosestIntersectingRect(List<Entry<Rectangle, View>> siblingViews,
			Rectangle targetArea, Rectangle chkRect, List<Rectangle> foundRects, boolean isMoveRight) {
		Rectangle closestRect = null;
		for (Iterator<Entry<Rectangle, View>> it = siblingViews.listIterator(); it.hasNext();) {
			Entry<Rectangle, View> entry = it.next();
			Rectangle siblingRect = entry.getKey();
			// if rect we're checking against, ignore
			if (siblingRect == chkRect) {
				continue;
			}
			// if we've already found this rect, ignore
			if (foundRects.contains(siblingRect)) {
				continue;
			}
			if (siblingRect.intersects(targetArea)) {
				if (closestRect == null) {
					closestRect = siblingRect;
				} else {
					if (isMoveRight) {
						if (siblingRect.x < closestRect.x) {
							closestRect = siblingRect;
						}
					} else {
						if (siblingRect.y < closestRect.y) {
							closestRect = siblingRect;
						}
					}
				}
			}
		}
		return closestRect;
	}

	private static boolean insersectsSiblings(Map siblingMap, Rectangle testRect,
			Set<View> ignoreViewSet) {
		boolean intersects = false;
		for (Iterator it = siblingMap.keySet().iterator(); it.hasNext() && !intersects;) {
			Rectangle siblingRect = (Rectangle) it.next();
			View siblingView = (View) siblingMap.get(siblingRect);
			intersects = !ignoreViewSet.contains(siblingView) && siblingRect.intersects(testRect);
		}
		return intersects;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// DETERMINE SIZE OF A LIST      /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param listEP --
	 *           must be the top list editpart
	 * @return size of the list
	 */
	public static Dimension getListUnitSize(DeployListCompartmentEditPart listEP) {
		// make sure figures are up to date
		listEP.refresh();

		// get just the compartment size
		IFigure listFigure = listEP.getFigure();
		Rectangle listRect = getListUnitSizeHelper(null, new Point(0, 0), 0, listFigure.getChildren());
		if (listRect == null) {
			return null;
		}
		Dimension listSize = listRect.getSize();
		Dimension size = listSize.getCopy();

		// add the container size
		EditPart parentEP = listEP.getParent();
		size.width += DeployCoreConstants.SERVER_UNIT_MARGINS * 2
				+ DeployCoreConstants.LISTITEM_INDENT * 4;

		// calculate vertical size required by header including the category and name
		IFigure parent = ((IGraphicalEditPart) parentEP).getFigure();
		size.height += GEFUtils.getListHeaderHeight(parent) + DeployCoreConstants.SERVER_UNIT_MARGINS
				* 3 + DeployCoreConstants.SERVER_UNIT_PAD_HEIGHT;

		// override width if set in deploystyle
		View view = (View) listEP.getParent().getModel();
		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			if (style.getExpandWidth() != -1) {
				size.width = style.getExpandWidth();
			}
		}
		return size;
	}

	private static Rectangle getListUnitSizeHelper(Rectangle rect, Point trackingPt, int level,
			List children) {
		for (Iterator it = children.iterator(); it.hasNext();) {
			IFigure fig = (IFigure) it.next();
			int inc = 0;
			if (fig instanceof DeployListCompartmentFigure) {
				if (!((DeployListCompartmentFigure) fig).isExpanded()) {
					continue;
				}
			} else if (fig instanceof CompositeShapeFigure) {
				inc = 1;
				int listItemHeight = GEFUtils.getListItemHeight(fig);
				for (Iterator it2 = fig.getChildren().iterator(); it2.hasNext();) {
					IFigure child = (IFigure) it2.next();
					if (child instanceof DeployListItemFigure) {
						Rectangle r = new Rectangle(DeployCoreConstants.LISTITEM_INDENT * level,
								trackingPt.y, ((DeployListItemFigure) child).getActualWidth(),
								listItemHeight);
						if (rect == null) {
							rect = r;
						} else {
							rect = rect.union(r);
						}
						trackingPt.y += listItemHeight;
					}
				}
			}
			rect = getListUnitSizeHelper(rect, trackingPt, level + inc, fig.getChildren());
		}
		return rect;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  HELPERS       /////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param editingDomain
	 * @param view
	 * @param location
	 * @param size
	 * @return operation status
	 */
	private static IStatus setViewBounds(TransactionalEditingDomain editingDomain, final View view,
			final Point location, final Dimension size) {
		Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain, StringStatics.BLANK,
				options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				if (location != null) {
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getLocation_X(), new Integer(location.x));
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getLocation_Y(), new Integer(location.y));
				}
				if (size != null) {
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Width(), new Integer(size.width));
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
							NotationPackage.eINSTANCE.getSize_Height(), new Integer(size.height));
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

	/**
	 * @param editingDomain
	 * @param layoutMap
	 * @param v2eMap
	 * @param isLocations
	 * @return status
	 */
	public static IStatus setViewsBounds(TransactionalEditingDomain editingDomain,
			final Map layoutMap, final Map v2eMap, final boolean isLocations, boolean useOperation) {
		if (useOperation) {
			Map options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			AbstractEMFOperation operation = new AbstractEMFOperation(editingDomain,
					StringStatics.BLANK, options) {

				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
					setViewsBoundsHelper(layoutMap, v2eMap, isLocations);
					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
			}
		} else {
			setViewsBoundsHelper(layoutMap, v2eMap, isLocations);
		}
		return Status.OK_STATUS;
	}

	public static void setViewsBoundsHelper(Map layoutMap, Map v2eMap, boolean isLocations) {
		for (Iterator it = layoutMap.keySet().iterator(); it.hasNext();) {
			View view = (View) it.next();
			if (view == null) {
				continue;
			}

			// if a view isn't visible, don't set
			if (!GMFUtils.isViewVisible(view)) {
				continue;
			}

			// if a view no longer is valid (doesn't have an editpart), don't set
			GraphicalEditPart ep = (GraphicalEditPart) v2eMap.get(view);
			if (ep == null) {
				continue;
			}

			if (isLocations) {
				Point point = (Point) layoutMap.get(view);
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getLocation_X(), new Integer(point.x));
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getLocation_Y(), new Integer(point.y));
			} else {
				Rectangle rect = (Rectangle) layoutMap.get(view);
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getLocation_X(), new Integer(rect.x));
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getLocation_Y(), new Integer(rect.y));

				// don't set a collpased editpart to a size other then -1,-1
				if ((rect.width != -1 || rect.height != -1) && ep instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart editpart = (DeployShapeNodeEditPart) ep;
					List list = editpart.getExpandableCompartmentEditParts();
					boolean isExpanded = true;
					for (Iterator it2 = list.iterator(); it2.hasNext() && isExpanded;) {
						ResizableCompartmentEditPart part = (ResizableCompartmentEditPart) it2.next();
						if (part != null) {
							ResizableCompartmentFigure fig = (ResizableCompartmentFigure) part.getFigure();
							isExpanded = fig.isExpanded();
						}
					}
					if (!isExpanded) {
						DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
								.getDeployStyle());
						if (style != null) {
							rect.setSize(style.getCollapseWidth(), style.getCollapseHeight());
						}
					}
				}
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getSize_Width(), new Integer(rect.width));
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view,
						NotationPackage.eINSTANCE.getSize_Height(), new Integer(rect.height));
			}
		}

	}

	// given a view's bounds, determine the size/location of its compartment
	private static Rectangle getCompartmentBounds(Rectangle r, View view) {
		Rectangle rect = r.getCopy();
		if (view.getType() == null) {
			return rect;
		}

		// shape containers
		if (isShapeCompartmentView(view)) {
			rect.shrink(DeployCoreConstants.SHAPES_UNIT_INSET, 0);
			rect.y += DeployCoreConstants.SERVER_UNIT_HEADER;
			rect.height -= DeployCoreConstants.SERVER_UNIT_HEADER
					+ DeployCoreConstants.SHAPES_UNIT_INSET * 3;
		}
		return rect;
	}

	// given a compartment's bounds, determine the size of its parent
	private static Dimension getParentSize(Dimension d, View view) {
		Dimension dim = d.getCopy();
		if (view.getType() == null) {
			return dim;
		}

		// shape containers
		if (isShapeCompartmentView(view)) {
			dim.width += DeployCoreConstants.SHAPES_UNIT_INSET * 2;
			dim.height += DeployCoreConstants.SERVER_UNIT_HEADER
					+ DeployCoreConstants.SHAPES_UNIT_INSET * 2;
		}
		return dim;
	}

	/**
	 * @param view
	 * @return is a view a compartment view
	 */
	public static boolean isCompartmentView(View view) {
		return isShapeCompartmentView(view) || isTreeCompartmentView(view);
	}

	/**
	 * @param view
	 * @return view is a tree compartment view
	 */
	public static boolean isTreeCompartmentView(View view) {
		return view.getType() != null
				&& (view.getType().equals(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT)
						|| view.getType().equals(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT) || view
						.getType().equals(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT));

	}

	/**
	 * @param view
	 * @return view is a shape compartment view
	 */
	public static boolean isShapeCompartmentView(View view) {
		return view.getType() != null
				&& (view.getType().equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT)
						|| view.getType().equals(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT) || view
						.getType().equals(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT));

	}

	// get a compartment view
	private static View getShapeCompartmentView(View view) {
		View v = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.getChildBySemanticHint(view,
				DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (v == null) {
			v = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
		}
		if (v == null) {
			v = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
		}
		return v;
	}

	// get the union of all the bounds of the views in this view
	private static Rectangle getContentBounds(View parentView, Map v2eMap) {
		View view = getShapeCompartmentView(parentView);
		if (view == null) {
			return getViewBounds(parentView);
		}
		Rectangle rect = null;
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			View child = (View) it.next();
			Rectangle r = getFigureBounds(child, v2eMap);
			if (rect == null) {
				rect = r;
			} else {
				rect.union(r);
			}
		}
		return rect;
	}

	static Rectangle getFigureBounds(View view, Map v2eMap) {
		Rectangle rect = getViewBounds(view);
		if (rect.width == -1 || rect.height == -1) {
			return getCollapsedFigureBounds(view, v2eMap);
		}
		return rect;
	}

	// get figure bounds when view size is set to -1,-1
	// set useNewEditPart if current figure state is unknown
	private static Rectangle getCollapsedFigureBounds(View view, Map v2eMap) {
		Rectangle rect = getViewBounds(view);
		IGraphicalEditPart ep = (IGraphicalEditPart) v2eMap.get(view);
		// if there is no ep yet, create one in order to get figure
		if (ep == null || ep.getFigure() == null) {
			ep = EditPartService.getInstance().createGraphicEditPart(view);
		}
		// get the inner figure
		IFigure fig = ep.getFigure();
		if (ep instanceof CompositeShapeFigure) {
			fig = ((CompositeShapeFigure) fig).getInnerFigure();
		}
		List<IFigure> list = new ArrayList<IFigure>();
		// if this figure has compartments, turn off their preferred size 
		//  no matter what the state of the collapsed flag
		disableCompartmentPreferredSize(fig, list);
		Dimension size = fig.getPreferredSize(-1, -1);
		restoreCompartmentPreferredSize(list);

		DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
				.getDeployStyle());
		if (style != null) {
			if (style.getCollapseWidth() != -1) {
				size.width = style.getCollapseWidth();
			}
			if (style.getCollapseHeight() != -1) {
				size.height = style.getCollapseHeight();
			}
		}
		rect.width = size.width;
		rect.height = size.height;
		return rect;
	}

	private static void disableCompartmentPreferredSize(IFigure fig, List<IFigure> list) {
		List children = fig.getChildren();
		for (int i = 0; i < children.size(); i++) {
			Object o = children.get(i);
			IFigure f = null;
			if (o instanceof DeployResizableCompartmentFigure) {
				((DeployResizableCompartmentFigure) o).setDisablePreferredSize(true);
				list.add((IFigure) o);
			} else if (o instanceof DeployShapeCompartmentFigure) {
				((DeployShapeCompartmentFigure) o).setDisablePreferredSize(true);
				list.add((IFigure) o);
			}
			if (o instanceof IFigure) {
				f = (IFigure) o;
				if (f.isVisible()) {
					disableCompartmentPreferredSize(f, list);
				}
			}
		}
	}

	private static void restoreCompartmentPreferredSize(List list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object o = it.next();
			if (o instanceof DeployResizableCompartmentFigure) {
				((DeployResizableCompartmentFigure) o).setDisablePreferredSize(false);
			} else if (o instanceof DeployShapeCompartmentFigure) {
				((DeployShapeCompartmentFigure) o).setDisablePreferredSize(false);
			}
		}
	}

	/**
	 * get a view's boundaries
	 * 
	 * @param view
	 * @return boundaries
	 */
	public static Rectangle getViewBounds(View view) {
		int width = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height()))
				.intValue();
		int x = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		return new Rectangle(x, y, width, height);

	}

	/**
	 * @param v
	 * @return view name
	 */
	// for debugging
	public static String getViewName(View v) {
		DeployModelObject dmo = (DeployModelObject) v.getElement();
		String s = dmo.getDisplayName();
		if (s == null || s.length() == 0) {
			s = dmo.getName() + " " + dmo.getDescription(); //$NON-NLS-1$
		}
		return s;
	}

}
