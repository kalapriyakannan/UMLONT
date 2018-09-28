/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

/**
 * @author jswanke
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.graphics.Color;

/**
 * @author jswanke
 * 
 */
public class NodeFigureEx extends NodeFigure {
	public final static int Q = MapModeUtil.getMapMode().DPtoLP(1);
	public final static int SHADOW = MapModeUtil.getMapMode().DPtoLP(4);
	public static final Color overlapShadow = new Color(null, 83, 86, 101);

	/*
	 * DiagramFigure maintains a list of any figures that overlap this figure here
	 */
	private final List<Rectangle> overlappedFigureRects = new ArrayList<Rectangle>();

	/*
	 * DiagramFigure sets to true if it determines that this figure overlaps another
	 */
	private boolean isOverlapped = false;

	private boolean _isFaded = false;
	private boolean _isConnectionAlwaysOnTop = false;

	/*
	 * a derived class can call this method to paint a faux shadow if this figure overlaps another
	 * figure which is lower in the Z-order
	 */
	protected Rectangle paintBackground(Graphics g) {
		Rectangle r = getBounds().getCopy();
		r.shrink(Q, Q);
		if (isOverlapped) {
			r.height -= SHADOW;
			r.width -= SHADOW;
			// paint shadow 
			boolean b = g.getXORMode();
			g.setXORMode(true);
			g.setBackgroundColor(overlapShadow);
			g.fillRectangle(r.getCopy().translate(SHADOW, SHADOW));
			g.setXORMode(b);
		}
		g.setBackgroundColor(ColorConstants.white);
		g.fillRectangle(r);
		return r;
	}

	/**
	 * @return true if overlaps another figure
	 */
	public boolean isOverlapped() {
		return isOverlapped;
	}

	/**
	 * set by DiagramFigure if this figure overlaps another figure
	 * 
	 * @param isOverlapped
	 */
	public void setOverlapped(boolean isOverlapped) {
		this.isOverlapped = isOverlapped;
	}

	/**
	 * @return list of the bounds of figures that overlap this figure
	 */
	public List<Rectangle> getOverlappedFigureRects() {
		return overlappedFigureRects;
	}

	/**
	 * @return is figure faded due to the selection of another figure
	 */
	public boolean isFaded() {
		return _isFaded;
	}

	/**
	 * @param faded --
	 *           paint this figure faded
	 */
	public void setFaded(boolean faded) {
		_isFaded = faded;
	}

	/**
	 * @return always draw connections over this figure
	 */
	public boolean isConnectionAlwaysOnTop() {
		return _isConnectionAlwaysOnTop;
	}

	/**
	 * @param isConnectionAlwaysOnTop
	 */
	public void setConnectionAlwaysOnTop(boolean isConnectionAlwaysOnTop) {
		_isConnectionAlwaysOnTop = isConnectionAlwaysOnTop;
	}
}
