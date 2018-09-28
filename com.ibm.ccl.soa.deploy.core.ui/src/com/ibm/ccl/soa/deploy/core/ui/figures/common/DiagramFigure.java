/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;


/**
 * @author jswanke based on the diagram figure created by DiagramEditPart by jcorchis
 * 
 */
public class DiagramFigure extends BorderItemsAwareFreeFormLayer {

	/*
	 * maintain map of diagram figures stored by their bounds
	 */
	Map<Rectangle, NodeFigureEx> _diagramFigureMap = new HashMap<Rectangle, NodeFigureEx>();

	@Override
	public boolean containsPoint(int x, int y) {
		return getBounds().contains(x, y);
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		if (!isEnabled()) {
			return null;
		}
		if (!containsPoint(x, y)) {
			return null;
		}
		if (search.prune(this)) {
			return null;
		}
		IFigure child = findDescendantAtExcluding(x, y, search);
		if (child != null) {
			return child;
		}
		if (search.accept(this)) {
			return this;
		}
		return null;
	}

	@Override
	public void validate() {
		super.validate();

		// after diagram is laid out, update overlap shadows
		updateOverlappedFigures();

		// also hide decorations that are overlapped
		updateOverlappedFigureRects();
	}

	/*
	 * scan all figures to maintain a list in each figure of other figures which overlap it -- used
	 * when painting decorations, etc on that figure since decorations are painted in a top layer and
	 * don't know anything about what's covering its owner figure
	 */
	private void updateOverlappedFigureRects() {
		updateOverlappedFigureRectsHelper(this, new HashMap<Rectangle, IFigure>());
	}

	private void updateOverlappedFigureRectsHelper(IFigure parent,
			Map<Rectangle, IFigure> prevNodeFigureMap) {
		for (Iterator<?> it = parent.getChildren().iterator(); it.hasNext();) {
			Object o = it.next();

			// if this is a NodeFigureEx figure, reset its stored overlap bounds			
			if (o instanceof NodeFigureEx) {
				NodeFigureEx nodeFigure = (NodeFigureEx) o;
				if (!nodeFigure.isVisible()) {
					continue;
				}
				nodeFigure.getOverlappedFigureRects().clear();

				// now loop through all previous figures to see if this figure intersects it
				Rectangle bounds = nodeFigure.getBounds().getCopy();
				parent.translateToAbsolute(bounds);
				for (Rectangle previousBounds : prevNodeFigureMap.keySet()) {

					// yes, it overlaps, add this rect to that figure's list of rects which overlap it
					if (bounds.intersects(previousBounds)) {
						IFigure previousNodeFigure = prevNodeFigureMap.get(previousBounds);
						// ignore if this intersection is actually with a parent figure
						if (!isParentOf(previousNodeFigure, nodeFigure)) {
							((NodeFigureEx) previousNodeFigure).getOverlappedFigureRects().add(bounds);
						}
					}
				}
				// build record of what's going on in diagram
				prevNodeFigureMap.put(bounds, nodeFigure);

				// else if a compartment figure, continue only if expanded
			} else if (o instanceof ResizableCompartmentFigure) {
				ResizableCompartmentFigure compartmentFigure = (ResizableCompartmentFigure) o;
				if (!compartmentFigure.isVisible()) {
					continue;
				}
				// if not expanded, it's children don't count
				if (!compartmentFigure.isExpanded()) {
					continue;
				}
			}

			// drill down
			if (o instanceof IFigure) {
				IFigure f = (IFigure) o;
				if (f.isVisible() && f.getChildren().size() > 0) {
					updateOverlappedFigureRectsHelper(f, prevNodeFigureMap);
				}
			}
		}
	}

	/*
	 * children are not considered to be overlapping their parent
	 */
	private boolean isParentOf(IFigure parent, IFigure child) {
		IFigure walker = child;
		while (walker != null) {
			walker = walker.getParent();
			if (walker == parent) {
				return true;
			}
		}
		return false;
	}

	/*
	 * scans other children of diagram for figures overlapping each other and updates the figure
	 * overlap flags also maintain a map for routing/line overlapping
	 */
	private void updateOverlappedFigures() {
		_diagramFigureMap.clear();

		List<Rectangle> prevRects = new ArrayList<Rectangle>();
		for (Iterator<?> it = getChildren().iterator(); it.hasNext();) {
			IFigure f = (IFigure) it.next();
			if (f instanceof NodeFigureEx) {
				NodeFigureEx figure = (NodeFigureEx) f;
				_diagramFigureMap.put(f.getBounds(), figure);
				boolean isOverlapped = false;
				Rectangle r = figure.getBounds();
				for (Iterator<Rectangle> itPrev = prevRects.iterator(); itPrev.hasNext()
						&& !isOverlapped;) {
					Rectangle overlapRect = r.getIntersection(itPrev.next());
					isOverlapped = overlapRect.width > 32 && overlapRect.height > 32;
				}
				figure.setOverlapped(isOverlapped);
				prevRects.add(r);
			}
		}
	}

	/**
	 * also used by PolylineConnectionExEx to determine if a connection is crossing a figure
	 * 
	 * @return a map of rectangles to figures in the canvas
	 */
	public Map<Rectangle, NodeFigureEx> getDiagramFigureMap() {
		return _diagramFigureMap;
	}

}
