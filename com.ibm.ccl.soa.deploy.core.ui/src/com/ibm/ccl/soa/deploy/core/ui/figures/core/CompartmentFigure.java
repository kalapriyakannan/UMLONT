/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import java.util.ListIterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.DiagramFigure;

/**
 */
public class CompartmentFigure extends NodeFigure {

	/**
	 * Constructor
	 */
	public CompartmentFigure() {
		super();
	}

	/**
	 * Paints this Figure's client area. The client area is typically defined as the anything inside
	 * the Figure's {@link Border} or {@link Insets}, and by default includes the children of this
	 * Figure. On return, this method must leave the given Graphics in its initial state.
	 * 
	 * @param graphics
	 *           The Graphics used to paint
	 * @since 2.0
	 */
	protected void paintClientArea(Graphics graphics) {
		if (getChildren().isEmpty() || !isVisible()) {
			return;
		}
		Rectangle clip = getParentRectangle();
		graphics.setClip(clip);
		graphics.pushState();
		paintChildren(graphics);
		graphics.popState();
		graphics.restoreState();
	}

	/**
	 * Adds a Point figure to this figure. It is different than adding Point as a "child" because
	 * Points are not affected by the layout manager of this figure. This method also keep account of
	 * the largest Point size added so that the client area and the border are shrinked accoringly.
	 * 
	 * @param figure
	 *           The PointFigure.
	 * @param constraint
	 *           the locator to associate with this figure
	 */
	public void addCompartment(NodeFigure figure, Object constraint) {
		add(figure, constraint);
		//		//TODO: remove this unecessary call.
		//		figure.setLocator((Locator)constraint);

	}

	/**
	 * gets the handle bounds of the main figure
	 * 
	 * @return the handle bounds of the main figure
	 * @see org.eclipse.gef.handles.HandleBounds#getHandleBounds()
	 */
	public Rectangle getHandleBounds() {
		Rectangle handleRect = null;

		ListIterator listIterator = getChildren().listIterator();
		while (listIterator.hasNext()) {
			Object object = listIterator.next();
			if (object instanceof NodeFigure && ((NodeFigure) object).isVisible()) {
				if (handleRect == null) {
					handleRect = ((NodeFigure) object).getHandleBounds().getCopy();
				} else {
					handleRect.union(((NodeFigure) object).getHandleBounds().getCopy());
				}
			}
		}
		return handleRect;
	}

	/**
	 * Removes a Point from this figure. This method also sets the new valid max padding from the
	 * sides if the existing are equal to this Points dimension.
	 * 
	 * @param figure
	 *           The PointFigure.
	 */
	public void removeCompartment(NodeFigure figure) {
		remove(figure);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#containsPoint(int, int) We need to override this for smooth
	 *      painting of Point items.
	 */
	public boolean containsPoint(int x, int y) {
		for (int i = getChildren().size(); i > 0;) {
			i--;
			IFigure fig = (IFigure) getChildren().get(i);
			if (fig.containsPoint(x, y)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a descendant of this Figure such that the Figure returned contains the point (x, y),
	 * and is accepted by the given TreeSearch. Returns <code>null</code> if none found.
	 * 
	 * @param x
	 *           The X coordinate
	 * @param y
	 *           The Y coordinate
	 * @param search
	 *           the TreeSearch
	 * @return The descendant Figure at (x,y)
	 */
	protected IFigure findDescendantAtExcluding(int x, int y, TreeSearch search) {
		Point pt = new Point(x, y);
		this.translateFromParent(pt);

		IFigure fig;
		for (int i = getChildren().size(); i > 0;) {
			i--;
			fig = (IFigure) getChildren().get(i);
			if (fig.isVisible()) {
				fig = fig.findFigureAt(pt.x, pt.y, search);
				if (fig != null) {
					return fig;
				}
			}
		}
		//No descendants were found
		return null;
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		if (search.prune(this)) {
			return null;
		}
		IFigure child = findDescendantAtExcluding(x, y, search);
		if (child != null) {
			return child;
		}
		return null;
	}

	/**
	 * Returns the deepest descendant for which {@link #isMouseEventTarget()} returns
	 * <code>true</code> or <code>null</code> if none found. The Parameters <i>x</i> and <i>y</i>
	 * are absolute locations. Any Graphics transformations applied by this Figure to its children
	 * during {@link #paintChildren(Graphics)} (thus causing the children to appear transformed to
	 * the user) should be applied inversely to the points <i>x</i> and <i>y</i> when called on the
	 * children.
	 * 
	 * @param x
	 *           The X coordinate
	 * @param y
	 *           The Y coordinate
	 * @return The deepest descendant for which isMouseEventTarget() returns true
	 */
	public IFigure findMouseEventTargetAt(int x, int y) {
		IFigure f = findMouseEventTargetInDescendantsAt(x, y);
		if (f != null) {
			return f;
		}
		if (isMouseEventTarget()) {
			return this;
		}
		return null;
	}

	/**
	 * Searches this Figure's children for the deepest descendant for which
	 * {@link #isMouseEventTarget()} returns <code>true</code> and returns that descendant or
	 * <code>null</code> if none found.
	 * 
	 * @see #findMouseEventTargetAt(int, int)
	 * @param x
	 *           The X coordinate
	 * @param y
	 *           The Y coordiante
	 * @return The deepest descendant for which isMouseEventTarget() returns true
	 */
	protected IFigure findMouseEventTargetInDescendantsAt(int x, int y) {
		Point pt = new Point(x, y);
		this.translateFromParent(pt);

		IFigure fig;
		for (int i = getChildren().size(); i > 0;) {
			i--;
			fig = (IFigure) getChildren().get(i);
			if (fig.isVisible() && fig.isEnabled()) {
				if (fig.containsPoint(pt.x, pt.y)) {
					fig = fig.findMouseEventTargetAt(pt.x, pt.y);
					return fig;
				}
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#intersects(Rectangle)
	 */
	public boolean intersects(Rectangle rect) {
		Rectangle rectangle = getParentRectangle();
		return rectangle.intersects(rect);
	}

	/**
	 * Return the area of the parent viewport if there is one, otherwise, return the client area of
	 * the parent.
	 */
	private Rectangle getParentRectangle() {
		if (getParent() != null && getParent().getParent() != null) {
			Rectangle rect = getParent().getParent().getClientArea().getCopy();

			IFigure port = getViewport();
			if (port != null) {
				Rectangle portRect = port.getClientArea().getCopy();
				if (portRect.height != 0 && portRect.width != 0) {
					rect = portRect;
				}
			}
			return rect;
		}
		return new Rectangle(0, 0, 0, 0);
	}

	private IFigure getMainFigure(CompartmentFigure gf) {
		CompositeShapeFigure gpf = (CompositeShapeFigure) gf.getParent();
		return gpf.getInnerFigure();
	}

	/**
	 * Helper to retrieve the viewport that this item sits on.
	 * 
	 * @return the view port
	 */
	private IFigure getViewport() {
		//
		// Start searching for viewport to clip on from the main figure.
		//
		IFigure fig = getMainFigure(this);
		while (fig != null) {
			if (fig instanceof Viewport || fig instanceof ScalableFreeformLayeredPane) {
				return fig;
			}
			fig = fig.getParent();
			if (fig instanceof CompartmentFigure) {
				fig = getMainFigure((CompartmentFigure) fig);
			}
		}
		return null;
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#erase()
	 */
	public void erase() {
		if (getChildren().isEmpty()) {
			super.erase();
		} else {
			if (getParent() == null || !isVisible()) {
				return;
			}
			repaint();
		}
	}

	/**
	 * Refresh adornments
	 */
	public void repaint() {
		try {
			if (getChildren().isEmpty()) {
				super.repaint();
			} else {
				if (getParent() == null || !isVisible()) {
					return;
				}
				Rectangle rectBounds = getParentRectangle();
				IFigure grandParent = getParent().getParent();
				if (grandParent != null && !(grandParent instanceof DiagramFigure)) {
					grandParent.repaint(rectBounds);
				}
			}
		} catch (RuntimeException e) {
			DeployCorePlugin.log(IStatus.WARNING, 0, e.getMessage(), e);
		}
	}

}
