/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;

/**
 * @since 1.0
 * 
 */
public class DeployConnectorAnchor extends AbstractConnectionAnchor {

	public static final int LEFT_TERMINAL = 1;

	public static final int RIGHT_TERMINAL = 2;

	public static final int TOP_TERMINAL = 3;

	public static final int BOTTOM_TERMINAL = 4;

	public static final int CENTER_TERMINAL = 5;

	public static final int LEFT_OR_RIGHT_TERMINAL_SOURCE = 6;

	public static final int LEFT_OR_RIGHT_TERMINAL_TARGET = 7;

	public static final int LEFT_OR_RIGHT_SOURCE = 8;

	public static final int LEFT_OR_RIGHT_TARGET = 9;

	public static final int LEFT_OR_RIGHT_OR_TOP_SOURCE = 10;

	public static final int LEFT_OR_RIGHT_OR_TOP_TARGET = 11;

	public static final int LEFT_OR_RIGHT_OR_BOTTOM_SOURCE = 12;

	public static final int LEFT_OR_RIGHT_OR_BOTTOM_TARGET = 13;

	public static final int RIGHT_BOTTOM4_TERMINAL = 14;

	public static final int LEFT_BOTTOM8_TERMINAL = 15;

	public static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	protected ConnectionEditPart connectionEP;

	protected NodeEditPart nodeEP;

	protected int anchorType;

	private boolean isInList = false;

	private boolean _isLeftTreeAnchor = false;

	private boolean _isRightTreeAnchor = false;

	/**
	 * 
	 * @param nodeEP
	 * @param anchorType
	 */
	public DeployConnectorAnchor(NodeEditPart nodeEP, int anchorType) {
		super(nodeEP.getFigure());

		this.nodeEP = nodeEP;

		this.anchorType = anchorType;

		IFigure fig = nodeEP.getFigure();
		isInList = fig instanceof CompositeShapeFigure
				&& ((CompositeShapeFigure) fig).getInnerFigure() instanceof DeployListItemFigure;
	}

	/**
	 * 
	 * @param nodeEP
	 * @param connectionEP
	 * @param anchorType
	 */
	public DeployConnectorAnchor(NodeEditPart nodeEP, ConnectionEditPart connectionEP, int anchorType) {
		this(nodeEP, anchorType);

		this.connectionEP = connectionEP;
	}

	public void ancestorMoved(IFigure figure) {
		if (connectionEP != null && connectionEP.getTarget() != null) {
			GraphicalEditPart editpart = (GraphicalEditPart) connectionEP.getTarget();
			List connections = editpart.getTargetConnections();

			for (int i = 0; i < connections.size(); i++) {
				Connection conn = (Connection) ((ConnectionEditPart) connections.get(i)).getFigure();
				if (conn.getTargetAnchor() instanceof DeployConnectorAnchor) {
					((DeployConnectorAnchor) conn.getTargetAnchor()).fireAnchorMoved();
				} else if (conn.getTargetAnchor() instanceof DeploySlidableAnchor) {
					((DeploySlidableAnchor) conn.getTargetAnchor()).ancestorMoved(conn);
				}
			}
			return;
		}
		super.ancestorMoved(figure);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#getLocation(org.eclipse.draw2d.geometry.Point)
	 */
	public Point getLocation(Point reference) {
		Point p = null;
		Rectangle r = getOwner().getBounds().getCopy();
		if (connectionEP != null && DeployConnectionNodeEditPart.isInnerSnapLink(connectionEP)) {
			r.shrink(200, 250);
		}
		_isLeftTreeAnchor = _isRightTreeAnchor = false;
		if (anchorType == LEFT_TERMINAL) {
			p = r.getLeft();
		} else if (anchorType == RIGHT_TERMINAL) {
			p = r.getRight();
		} else if (anchorType == RIGHT_BOTTOM4_TERMINAL) {
			p = r.getBottomLeft();
			int c = r.width / 2;
			p.x += c + c / 2;
			if (isInList) {
				p.y = r.getTop().y + +GEFUtils.getListItemHeight(getOwner());
			}
		} else if (anchorType == LEFT_BOTTOM8_TERMINAL) {
			p = r.getBottomRight();
			if (isInList) {
				p.y = r.getTop().y + +GEFUtils.getListItemHeight(getOwner());
			}
		} else if (anchorType == TOP_TERMINAL) {
			p = r.getTop();
		} else if (anchorType == BOTTOM_TERMINAL) {
			p = r.getBottom();
			p.y += MapModeUtil.getMapMode().DPtoLP(3);
			if (isInList) {
				p.y = r.getTop().y + +GEFUtils.getListItemHeight(getOwner());
			}
		} else if (anchorType == CENTER_TERMINAL) {
			p = r.getCenter();
			if (isInList) {
				p.y = r.getTop().y + +GEFUtils.getListItemHeight(getOwner()) / 2;
			} else {
				p.y = r.getTop().y + DeployCoreConstants.SERVER_UNIT_HEIGHT / 2;
			}
		} else if (anchorType == LEFT_OR_RIGHT_TERMINAL_SOURCE) {
			Point p1 = r.getTopLeft();
			Point p2 = r.getTopRight();
			getOwner().translateToAbsolute(p1);
			getOwner().translateToAbsolute(p2);
			if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
					reference, p2)) {
				_isLeftTreeAnchor = true;
				p = r.getTopLeft();
			} else {
				_isRightTreeAnchor = true;
				p = r.getTopRight();
			}
			p.y += 12 * Q;
		} else if (anchorType == LEFT_OR_RIGHT_TERMINAL_TARGET) {
			Point p1 = r.getTopLeft();
			Point p2 = r.getTopRight();
			getOwner().translateToAbsolute(p1);
			getOwner().translateToAbsolute(p2);
			if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
					reference, p2)) {
				_isLeftTreeAnchor = true;
				p = r.getTopLeft();
			} else {
				p = r.getTopRight();
				_isRightTreeAnchor = true;
			}
			p.y += 6 * Q;
		} else if (anchorType == LEFT_OR_RIGHT_SOURCE) {
			Point p1 = r.getTopLeft();
			Point p2 = r.getTopRight();
			getOwner().translateToAbsolute(p1);
			getOwner().translateToAbsolute(p2);
			if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
					reference, p2)) {
				p = r.getTopLeft();
			} else {
				p = r.getTopRight();
			}
			p.y += r.height * 2 / 3;
		} else if (anchorType == LEFT_OR_RIGHT_TARGET) {
			Point p1 = r.getTopLeft();
			Point p2 = r.getTopRight();
			getOwner().translateToAbsolute(p1);
			getOwner().translateToAbsolute(p2);
			if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
					reference, p2)) {
				p = r.getTopLeft();
			} else {
				p = r.getTopRight();
			}
			p.y += r.height / 3;
		} else if (anchorType == LEFT_OR_RIGHT_OR_TOP_TARGET) {
			Point p3 = r.getTop();
			getOwner().translateToAbsolute(p3);
			if (reference.y + 20 < p3.y) {
				p = r.getTopLeft();
				p.x += r.width / 3;
			} else {
				Point p1 = r.getTopLeft();
				Point p2 = r.getTopRight();
				getOwner().translateToAbsolute(p1);
				getOwner().translateToAbsolute(p2);
				if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
						reference, p2)) {
					p = r.getTopLeft();
					p.y += r.height / 3;
				} else {
					p = r.getTopRight();
					p.y += r.height / 3;
				}
			}
		} else if (anchorType == LEFT_OR_RIGHT_OR_TOP_SOURCE) {
			Point p3 = r.getTop();
			getOwner().translateToAbsolute(p3);
			if (reference.y + 20 < p3.y) {
				p = r.getTopLeft();
				p.x += r.width * 2 / 3;
			} else {
				Point p1 = r.getTopLeft();
				Point p2 = r.getTopRight();
				getOwner().translateToAbsolute(p1);
				getOwner().translateToAbsolute(p2);
				if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
						reference, p2)) {
					p = r.getTopLeft();
					p.y += r.height * 2 / 3;
				} else {
					p = r.getTopRight();
					p.y += r.height * 2 / 3;
				}
			}
		} else if (anchorType == LEFT_OR_RIGHT_OR_BOTTOM_TARGET) {
			Point p3 = r.getBottom();
			getOwner().translateToAbsolute(p3);
			if (p3.y < reference.y) {
				p = r.getBottomLeft();
				p.x += r.width / 3;
			} else {
				Point p1 = r.getTopLeft();
				Point p2 = r.getTopRight();
				getOwner().translateToAbsolute(p1);
				getOwner().translateToAbsolute(p2);
				if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
						reference, p2)) {
					p = r.getTopLeft();
					p.y += r.height / 3;
				} else {
					p = r.getTopRight();
					p.y += r.height / 3;
				}
			}
		} else if (anchorType == LEFT_OR_RIGHT_OR_BOTTOM_SOURCE) {
			Point p3 = r.getBottom();
			getOwner().translateToAbsolute(p3);
			if (p3.y < reference.y) {
				p = r.getBottomLeft();
				p.x += r.width * 2 / 3;
			} else {
				Point p1 = r.getTopLeft();
				Point p2 = r.getTopRight();
				getOwner().translateToAbsolute(p1);
				getOwner().translateToAbsolute(p2);
				if (GeometryUtils.distanceSquared(reference, p1) < GeometryUtils.distanceSquared(
						reference, p2)) {
					p = r.getTopLeft();
					p.y += r.height * 2 / 3;
				} else {
					p = r.getTopRight();
					p.y += r.height * 2 / 3;
				}
			}
		}

		if (p != null) {
			p = new PrecisionPoint(p);
			getOwner().translateToAbsolute(p);
		}
		return p;
	}

	/**
	 * @return node
	 */
	public IFigure getNodeOwner() {
		IFigure node = getOwner();
		while (node != null && !(node instanceof IFeedbackFigure)) {
			node = node.getParent();
		}
		return node;
	}

	/**
	 * @return get type of anchor
	 */
	public int getAnchorType() {
		return anchorType;
	}

	/**
	 * @param anchor
	 * @return is this a fixed anchor
	 */
	public static boolean isFixedAnchor(ConnectionAnchor anchor) {
		if (anchor instanceof DeployConnectorAnchor) {
			DeployConnectorAnchor da = (DeployConnectorAnchor) anchor;
			if (da.getAnchorType() == BOTTOM_TERMINAL || da.getAnchorType() == TOP_TERMINAL) {
				return true;
			}
		}
		return false;
	}

	public boolean isLeftTreeAnchor() {
		return _isLeftTreeAnchor;
	}

	public boolean isRightTreeAnchor() {
		return _isRightTreeAnchor;
	}

}
