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

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;


/**
 * @author jswanke
 * 
 */
public class DecoratorFigure extends Figure {

	private PolylineConnectionExEx _ownerConnection = null;
	private NodeFigureEx _ownerFigure = null;

	/**
	 * @param decoratorTarget
	 */
	public DecoratorFigure(DecoratorTarget decoratorTarget) {
		super();

		// add this decoration figure to the owner figure's decoration child list 
		if (decoratorTarget != null) {
			GraphicalEditPart editpart = (GraphicalEditPart) decoratorTarget
					.getAdapter(GraphicalEditPart.class);
			IFigure fig = editpart.getFigure();
			if (fig instanceof NodeFigureEx) {
				_ownerFigure = (NodeFigureEx) fig;
			} else if (fig instanceof PolylineConnectionExEx) {
				_ownerConnection = (PolylineConnectionExEx) fig;
			} else {
				// walk up till we find a NodeFigureEx
				IFigure walker = fig;
				while (walker != null && !(walker instanceof DiagramFigure)) {
					walker = walker.getParent();
					if (walker instanceof NodeFigureEx) {
						_ownerFigure = (NodeFigureEx) walker;
						break;
					}
				}
			}
		}
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		if (isDecorationVisible()) {
			return super.findFigureAt(x, y, search);
		}
		return null;
	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		if (isDecorationVisible()) {
			super.handleMousePressed(event);
		}
	}

	@Override
	public void paint(Graphics g) {
		if (isDecorationVisible()) {
			super.paint(g);
		}
	}

	/**
	 * get list of overlapped figure bounds from the owner figure which have been placed there by
	 * DiagramFigure and see if this decoration figure intersects with any of them; if it does,
	 * returns false so that this decoration does not paint and is not visible to the mouse
	 * 
	 * @return isVisible
	 */
	protected boolean isDecorationVisible() {

		/////////////////////////////////////////
		//////////// DECORATOR ON A CONNECTION /////////////////////
		/////////////////////////////////////////
		if (_ownerConnection instanceof PolylineConnectionExEx) {

			// is the owner connection visible (don't show decorator)
			if (_ownerConnection.isHidden()) {
				return false;
			}

			// is the owner connection selected (always show decorator)
			if (_ownerConnection.isBringToFront()) {
				return true;
			}

			// else if figure(s) overlap the owner connection where this decotator is, hide the decorator
			if (getParent() != null) {
				Rectangle r = getBounds().getCopy();
				// if overlaps by more then 25% of decorator, hide it
				int rPartialArea = r.width * r.height / 4;
				List<Rectangle> list = _ownerConnection.getOverlappedFigureRects();
				for (Rectangle or : list) {
					Rectangle d = r.getIntersection(or);
					if (d.width * d.height > rPartialArea) {
						return false;
					}

				}
			}
			return true;
		}

		/////////////////////////////////////////
		//////////// DECORATOR ON A FIGURE /////////////////////
		/////////////////////////////////////////
		if (_ownerFigure != null) {
			List<Rectangle> list = _ownerFigure.getOverlappedFigureRects();
			if (list != null && list.size() > 0 && getParent() != null) {
				Rectangle r = getBounds().getCopy();
				getParent().translateToAbsolute(r);
				// if overlaps by more then 25% of decorator, hide it
				int rPartialArea = r.width * r.height / 2;
				for (int i = 0; i < list.size(); i++) {
					Rectangle d = r.getIntersection(list.get(i));
					if (d.width * d.height > rPartialArea) {
						return false;
					}
				}
			}
		}

		return true;
	}

	protected NodeFigureEx getOwnerFigure() {
		return _ownerFigure;
	}

	protected PolylineConnectionExEx getOwnerConnection() {
		return _ownerConnection;
	}

}
