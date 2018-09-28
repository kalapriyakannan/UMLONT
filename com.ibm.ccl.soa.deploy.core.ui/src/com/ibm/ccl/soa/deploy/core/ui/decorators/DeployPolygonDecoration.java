/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;

/**
 * A decoration whose visibility and rotation can be turned off.
 * 
 * @since 1.0
 */
public class DeployPolygonDecoration extends PolygonDecoration {
	private boolean isVisible = true;
	protected boolean isSource = false;
	static final protected int Q = MapModeUtil.getMapMode().DPtoLP(1);

	private static final PointList BLANK_TIP = new PointList();
	static {
		BLANK_TIP.addPoint(0, 0);
		BLANK_TIP.addPoint(0, 2);
		BLANK_TIP.addPoint(2, 2);
		BLANK_TIP.addPoint(2, -2);
		BLANK_TIP.addPoint(-2, -2);
		BLANK_TIP.addPoint(-2, 2);
	}

	public DeployPolygonDecoration(boolean isSrc) {
		isSource = isSrc;
		// we don't draw this template-- we just create an area big enough to draw our own
		setTemplate(BLANK_TIP);
		setScale(MapModeUtil.getMapMode().DPtoLP(3), MapModeUtil.getMapMode().DPtoLP(3));
		setLineStyle(Graphics.LINE_SOLID);
		setLineWidth(1);
	}

	@Override
	public Point getEnd() {
		return getPoints().getLastPoint();
	}

	@Override
	public Point getStart() {
		return getPoints().getFirstPoint();
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public void setRotation(double angle) {
		switch (getConnectionSide())
		{
		case GeometryUtils.TOP:
			angle = Math.PI / 2;
			break;
		case GeometryUtils.RIGHT:
			angle = Math.PI;
			break;
		case GeometryUtils.BOTTOM:
			angle = -Math.PI / 2;
			break;
		case GeometryUtils.LEFT:
			angle = 0.0d;
			break;
		}
		super.setRotation(angle);
	}

	protected int getConnectionSide() {
		if (getParent() instanceof DeployLinkConnection) {
			DeployLinkConnection conn = (DeployLinkConnection) getParent();
			ConnectionAnchor anchor = isSource ? conn.getSourceAnchor() : conn.getTargetAnchor();
			if (anchor != null && !(anchor instanceof XYAnchor)) {
				Point pt = getStart();
				Rectangle rect = anchor.getOwner().getBounds().getCopy();
				anchor.getOwner().translateToAbsolute(rect);
				this.translateToRelative(rect);
				return GeometryUtils.getClosestSide(rect, pt);
			}
		}
		return GeometryUtils.LEFT;
	}

	// unless decorator has been placed at end of link, give it 0,0 size
	// otherwise when it's added to connection layer it will invalidate most of display
	public Rectangle getBounds() {
		if (bounds == null) {
			bounds = super.getBounds();
			if (bounds.x <= 0 && bounds.y <= 0) {
				bounds.setSize(0, 0);
			}
		}
		return bounds;
	}
}
