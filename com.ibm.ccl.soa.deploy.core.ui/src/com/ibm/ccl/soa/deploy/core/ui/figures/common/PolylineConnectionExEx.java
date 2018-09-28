/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.xtools.diagram.ui.common.utils.GeometryUtils;

/**
 * @author jswanke
 * 
 */
abstract public class PolylineConnectionExEx extends PolylineConnectionEx {

	// crossing under shapes connection drawing
	protected boolean _isBringToFront = false;
	private boolean _isBackfillMode = false;
	// offscreen connection label
	protected final ConnectionNodeEditPart _connectionEP;
	private MouseListener _mouseListener;
	private final Object _lock = new Object();
	private IFigure _feedbackLayer = null;
	private ConnectionLabelFeedbackFigure _sourceFeedback = null;
	private ConnectionLabelFeedbackFigure _targetFeedback = null;
	private boolean _forceDraw = false;

	/*
	 * DiagramFigure maintains a list of any figures that overlap this figure here
	 */
	private final List<Rectangle> _overlappedFigureRects = new ArrayList<Rectangle>();

	/**
	 * @param connectionEP --
	 *           the ConnectionNodeEditPart that owns this connection figure
	 * 
	 */
	public PolylineConnectionExEx(ConnectionNodeEditPart connectionEP) {
		_connectionEP = connectionEP;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// CROSS UNDER SHAPE CONNECTION SUPPORT //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	// build list of figures that ConnectionLayerExEx must repaint in order
	// make it appear that this connection is crossing under that figure
	protected void updateConnectionLayer(PointList ptlist) {
		// if this connection is being repainted to backfill the figures with connections
		// no need to re-discover overlapped figures
		if (!_isBackfillMode) {
			_overlappedFigureRects.clear();
			if (getParent() instanceof ConnectionLayerExEx && getSourceAnchor() != null
					&& getTargetAnchor() != null) {
				ConnectionLayerExEx layer = (ConnectionLayerExEx) getParent();
				Set<IFigure> overlappedFigureSet = layer.getOverlappedFigureSet();

				// add this connection to the back fill list of my source and target figures
				// so the end points are repainted if the source/target figures are repainted
				// to cover a link
				Map<IFigure, List<PolylineConnectionExEx>> backfillFigureMap = layer
						.getBackfillFigureMap();
				IFigure srcFig = getTopFigure(getSourceAnchor().getOwner());
				IFigure tgtFig = getTopFigure(getTargetAnchor().getOwner());
				addToBackfillMap(backfillFigureMap, srcFig);
				addToBackfillMap(backfillFigureMap, tgtFig);

				DiagramFigure ddf = layer.getDiagramFigure();
				if (ddf != null && ddf.getDiagramFigureMap() != null) {
					Map<Rectangle, NodeFigureEx> ddm = ddf.getDiagramFigureMap();
					for (Iterator<Rectangle> it = ddm.keySet().iterator(); it.hasNext();) {
						Rectangle r = it.next();
						// ptlist intersect this rect, so add its figure to a set that will be repainted later
						if (ptlist.intersects(r)) {
							NodeFigureEx repaintFig = ddm.get(r);

							// if the figure that this link intersects is not the link's source or target
							// we add it to the overlappedFigureSet so that the DeployConnectionLayerEx
							// will redraw the figure after the link hasd been drawn to give the 
							// illusion that the figure covers the link
							if (repaintFig == srcFig || repaintFig == tgtFig) {
								// not overlapped-- link is terminating in this figure
							} else if (repaintFig != null && !repaintFig.isConnectionAlwaysOnTop()) {
								// otherwise just add to set so that the figure will be repainted to cover the link
								overlappedFigureSet.add(repaintFig);
								// save rect so that mouse clicks are also ignored where this figure overlaps the link 
								_overlappedFigureRects.add(r);
							}

						}
					}
				}
			}
		}
	}

	private void addToBackfillMap(Map<IFigure, List<PolylineConnectionExEx>> backfillFigureMap,
			IFigure repaintFig) {
		List<PolylineConnectionExEx> backfillList = backfillFigureMap.get(repaintFig);
		if (backfillList == null) {
			backfillList = new ArrayList<PolylineConnectionExEx>();
			backfillFigureMap.put(repaintFig, backfillList);
		}
		if (!backfillList.contains(this)) {
			backfillList.add(this);
		}
	}

	public boolean containsPoint(int x, int y) {
		if (!isHidden()) {
			if (_isBringToFront || !isOverlapped(x, y)) {
				return super.containsPoint(x, y);
			}
		}
		return false;
	}

	/**
	 * lines are still visible when they are connecting two units in a collpased container this
	 * determines if a line is actually being drawn
	 * 
	 * @return is a link being drawn
	 */
	abstract public boolean isHidden();

	// see if a figure overlaps this link at this point and therefore should be ignored
	// because the overlapping figure is drawn over the link
	private boolean isOverlapped(int x, int y) {
		for (Iterator<Rectangle> it = _overlappedFigureRects.iterator(); it.hasNext();) {
			if (it.next().contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return isBringToFront
	 */
	public boolean isBringToFront() {
		return _isBringToFront;
	}

	/**
	 * @param isBringToFront
	 */
	public void setBringToFront(boolean isBringToFront) {
		_isBringToFront = isBringToFront;
	}

	/**
	 * @param backfillMode
	 */
	public void setBackfillMode(boolean backfillMode) {
		_isBackfillMode = backfillMode;
	}

	/**
	 * @return if painting with _isBackfillMode== true, then we are just : just refilling lines on a
	 *         figure that's been redrawn to cover a line that passed completely underneath
	 */
	public boolean isBackfillMode() {
		return _isBackfillMode;
	}

	/**
	 * @return list of rects that overlap this link
	 */
	public List<Rectangle> getOverlappedFigureRects() {
		return _overlappedFigureRects;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// OFFSCREEN CONNECTION LABELS //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	protected void updateConnectionLabel(PointList ptList) {
		if (!displayConnectionLabels()) {
			return;
		}

		// only update if point list has changed
		if (_forceDraw || _sourceFeedback != null
				&& !comparePtList(ptList, _sourceFeedback.getPointList()) || _targetFeedback != null
				&& !comparePtList(ptList, _targetFeedback.getPointList())) {
			_forceDraw = false;
			updateConnectionLabel();
		}
	}

	/**
	 * draw labels on links that extend past the side of the screen
	 */
	public void updateConnectionLabel() {
		if (!displayConnectionLabels()) {
			return;
		}

		// if source or target are hidden,
		if (!(isVisible() && getSourceAnchor() != null && getTargetAnchor() != null
				&& isAnchorVisible(getSourceAnchor()) && isAnchorVisible(getTargetAnchor()))) {
			return;
		}
		EObject[] srcElement = new EObject[] { null };
		EObject[] tgtElement = new EObject[] { null };

		// find source and target intersections
		PointList ptList = getPoints();
		FigureCanvas figureCanvas = (FigureCanvas) _connectionEP.getViewer().getControl();
		Viewport vp = figureCanvas.getViewport();
		Rectangle screenRect = Rectangle.SINGLETON;
		vp.getClientArea(screenRect);
		vp.translateToParent(screenRect);
		vp.translateToAbsolute(screenRect);

		DiagramEditPart diagramEP = (DiagramEditPart) _connectionEP.getViewer().getContents();
		IFigure container = diagramEP.getContentPane();
		Rectangle portRect = screenRect.getCopy();
		container.translateToRelative(portRect);

		Point srcPoint = findIntersectionPoint(ptList, getSourceAnchor(), screenRect, portRect,
				srcElement);

		Point tgtPoint = findIntersectionPoint(ptList, getTargetAnchor(), screenRect, portRect,
				tgtElement);

		// if both none or both something, just remove any label and return
		if (srcPoint == null) {
			removeSourceConnectionLabel();
		}
		if (tgtPoint == null) {
			removeTargetConnectionLabel();
		}
		if (srcPoint == null && tgtPoint == null) {
			return;
		}
		if (srcPoint != null && tgtPoint != null) {
			removeConnectionLabels(false);
			return;
		}
		container.translateToAbsolute(portRect);
		vp.translateToRelative(portRect);
		vp.translateFromParent(portRect);
		if (srcPoint != null) {
			container.translateToAbsolute(srcPoint);
			vp.translateToRelative(srcPoint);
			vp.translateFromParent(srcPoint);
			GraphicalEditPart ep = (GraphicalEditPart) _connectionEP.getSource();
			EObject eo = ep != null ? ep.resolveSemanticElement() : srcElement[0];
			_sourceFeedback = createConnectionLabelFeedback(srcPoint, portRect, ep, eo, ptList
					.getCopy(), _sourceFeedback);
		} else if (tgtPoint != null) {
			container.translateToAbsolute(tgtPoint);
			vp.translateToRelative(tgtPoint);
			vp.translateFromParent(tgtPoint);
			GraphicalEditPart ep = (GraphicalEditPart) _connectionEP.getTarget();
			EObject eo = ep != null ? ep.resolveSemanticElement() : tgtElement[0];
			_targetFeedback = createConnectionLabelFeedback(tgtPoint, portRect, ep, eo, ptList
					.getCopy(), _targetFeedback);
		}
	}

	private Point findIntersectionPoint(PointList ptList, ConnectionAnchor anchor,
			Rectangle screenRect, Rectangle portRect, EObject[] figureElement) {

		// get anchor figure's boundary and element
		IFigure ownerFig = anchor.getOwner();
		Object o = _connectionEP.getViewer().getVisualPartMap().get(ownerFig);
		if (!(o instanceof GraphicalEditPart)) {
			return null;
		}
		figureElement[0] = ((GraphicalEditPart) o).resolveSemanticElement();

		// determine location of label on unit
		Rectangle bounds = ownerFig.getBounds().getCopy();
		ownerFig.translateToAbsolute(bounds);
		WrappingLabel nameFigure = getWrappingLabelFigure(ownerFig.getChildren());
		if (nameFigure != null) {
			bounds = nameFigure.getBounds().getCopy();
			nameFigure.translateToAbsolute(bounds);
			bounds.x += 25; // crop icon
			bounds.width -= 25;
		}

		// if 50% of label is shown, don't put up a link label
		Rectangle irect = screenRect.getCopy().intersect(bounds);
		if (bounds.width == 0 || bounds.height == 0 || irect.width * 100 / bounds.width > 95
				&& irect.height * 100 / bounds.height > 50) {
			return null;
		}

		// else find point where ptList intersects with screenRect 
		Point pt = GeometryUtils.getIntersection(ptList, portRect);
		if (pt != null) {
			return pt;
		}

		// link didn't intersect screen, but if figure is on edge of screen the name might not be visible
		//  therefore use the endpoint instead-- but only if it's along the edge of the screen and not outside the screen
		Point strtPt = ptList.getFirstPoint();
		Point lastPt = ptList.getLastPoint();
		IFigure diagramFig = GEFUtils.getDiagramFigure(ownerFig);
		if (diagramFig == null) {
			diagramFig = ownerFig;
		}
		Point figurePt = ownerFig.getBounds().getCenter();
		ownerFig.translateToAbsolute(figurePt);
		diagramFig.translateToRelative(figurePt);
		Point altPt = GeometryUtils.distanceSquared(strtPt, figurePt) < GeometryUtils
				.distanceSquared(lastPt, figurePt) ? strtPt : lastPt;
		// if alternate point is too far into screen, push it to side
		int delta = MapModeUtil.getMapMode().DPtoLP(80);
		if (portRect.getExpanded(-delta, -delta).contains(altPt)) {
			PointList ptList2 = new PointList();
			bounds = ownerFig.getBounds().getCopy();
			ownerFig.translateToAbsolute(bounds);
			bounds.translate(0, 8);
			diagramFig.translateToRelative(bounds);
			ptList2.addPoint(bounds.getTopLeft());
			ptList2.addPoint(bounds.getTopRight());
			pt = GeometryUtils.getIntersection(ptList2, portRect);
			if (pt != null) {
				return pt;
			}
		}
		return altPt;
	}

	private ConnectionLabelFeedbackFigure createConnectionLabelFeedback(Point pt,
			Rectangle portRect, GraphicalEditPart offscreenEP, EObject figureElement,
			PointList ptList, ConnectionLabelFeedbackFigure feedback) {
		// create link label feedback figure at intersection point
		if (figureElement == null) {
			return null;
		}
		String figureName = getConnectionLabelName(figureElement);
		if (feedback == null) {
			_feedbackLayer = getLayer(offscreenEP, LayerConstants.FEEDBACK_LAYER);
			_feedbackLayer.setEnabled(true);
			_feedbackLayer
					.add(feedback = new ConnectionLabelFeedbackFigure(offscreenEP, figureElement));
			feedback.addMouseListener(getMouseListener());
		}
		feedback.setFigureName(figureName);
		feedback.setPointList(ptList);

		// get initial position for feedback figure 
		Dimension labelSize = feedback.getPreferredSize();
		Point p = pt;
		p.translate(-labelSize.width / 2, -labelSize.height);
		Rectangle clipRect = portRect.getCopy();
		if (p.x + labelSize.width + 5 > clipRect.getRight().x) {
			p.x = clipRect.getRight().x - labelSize.width - 5;
		}
		if (p.x - 3 < clipRect.getLeft().x) {
			p.x = clipRect.getLeft().x + 3;
		}
		if (p.y < clipRect.getTop().y) {
			p.y = clipRect.getTop().y;
		}

		// adjust position if it overlaps with another link label
		int tries = 0;
		int delta = -labelSize.height;
		Point pSave = p.getCopy();
		ConnectionLabelFeedbackFigure intersectionFig = null;
		while ((intersectionFig = getFeedbackIntersection(p, labelSize, feedback)) != null) {
			// if a feedback rect is already there for this element, don't create feedback
			// or if there's more then two label here
			if (intersectionFig.getFigureElement() == figureElement || tries++ >= 1) {
				_feedbackLayer.remove(feedback);
				return null;
			}
			p.translate(0, delta);
			if (p.y < clipRect.getTop().y) {
				delta = -delta;
				p = pSave;
			}
		}

		feedback.setBounds(new Rectangle(p, labelSize));
		return feedback;
	}

	private ConnectionLabelFeedbackFigure getFeedbackIntersection(Point pt, Dimension size,
			IFigure ignoreFigure) {
		if (_feedbackLayer == null) {
			return null;
		}
		boolean intersects = false;
		Rectangle chkRect = new Rectangle(pt, size).resize(3, 0);
		for (Iterator<?> it = _feedbackLayer.getChildren().iterator(); it.hasNext() && !intersects;) {
			IFigure child = (IFigure) it.next();
			if (child != ignoreFigure && child instanceof ConnectionLabelFeedbackFigure) {
				if (child.getBounds().intersects(chkRect)) {
					return (ConnectionLabelFeedbackFigure) child;
				}
			}
		}
		return null;
	}

	/**
	 * remove any link label this link added to feedback layer
	 * 
	 * @param forceDraw
	 */
	public void removeConnectionLabels(boolean forceDraw) {
		_forceDraw = forceDraw;
		removeSourceConnectionLabel();
		removeTargetConnectionLabel();
	}

	private void removeSourceConnectionLabel() {
		removeConnectionLabelHelper(_sourceFeedback);
		_sourceFeedback = null;
	}

	private void removeTargetConnectionLabel() {
		removeConnectionLabelHelper(_targetFeedback);
		_targetFeedback = null;
	}

	private void removeConnectionLabelHelper(IFigure feedback) {
		if (feedback != null && _feedbackLayer != null) {
			_feedbackLayer.remove(feedback);
		}
	}

	// listen to link label
	private MouseListener getMouseListener() {
		if (_mouseListener == null) {
			synchronized (_lock) {
				if (_mouseListener == null) {
					_mouseListener = new MouseListener() {
						public void mousePressed(MouseEvent me) {
						}

						public void mouseReleased(MouseEvent me) {
						}

						public void mouseDoubleClicked(MouseEvent me) {
						}

					};
				}
			}
		}
		return _mouseListener;
	}

	/*
	 * determine if this end of link is visible
	 */
	protected boolean isAnchorVisible(ConnectionAnchor anchor) {
		if (anchor == null) {
			return false;
		}
		if (anchor instanceof XYAnchor) {
			return true;
		}
		IFigure anchorFig = anchor.getOwner();
		Rectangle anchorBounds = anchorFig.getBounds().getCopy();
		anchorFig.translateToAbsolute(anchorBounds);
		IFigure parentFigure = anchorFig.getParent();
		while (parentFigure != null) {
			if (!parentFigure.isVisible()) {
				return false;
			}
			if (parentFigure instanceof ResizableCompartmentFigure) {
				Rectangle parentClientArea = parentFigure.getClientArea().getCopy();
				parentFigure.translateToAbsolute(parentClientArea);
				if (!parentClientArea.contains(anchorBounds)) {
					return false;
				}
			}
			parentFigure = parentFigure.getParent();
		}
		return true;
	}

	private WrappingLabel getWrappingLabelFigure(List children) {
		for (Iterator<?> it = children.iterator(); it.hasNext();) {
			IFigure f = (IFigure) it.next();
			if (f instanceof WrappingLabel) {
				return (WrappingLabel) f;
			} else {
				f = getWrappingLabelFigure(f.getChildren());
				if (f != null) {
					return (WrappingLabel) f;
				}
			}
		}
		return null;
	}

	private boolean comparePtList(PointList ptList, PointList pointList) {
		if (ptList.size() != pointList.size()) {
			return false;
		}
		boolean isEqual = true;
		for (int i = 0; i < ptList.size() && isEqual; i++) {
			isEqual = ptList.getPoint(i).equals(pointList.getPoint(i));
		}
		return isEqual;
	}

	/**
	 * @return the ConnectionNodeEditPart that owns this figure
	 */
	public ConnectionNodeEditPart getConnectionEP() {
		return _connectionEP;
	}

	abstract protected String getConnectionLabelName(EObject offscreenElement);

	abstract protected boolean displayConnectionLabels();

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// HELPERS //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////

	private IFigure getTopFigure(IFigure figure) {
		IFigure walker = figure;
		while (walker != null) {
			IFigure parent = walker.getParent();
			if (parent instanceof DiagramFigure) {
				return walker;
			}
			walker = parent;
		}
		return null;
	}

	protected IFigure getLayer(EditPart ep, Object layer) {
		return LayerManager.Helper.find(ep).getLayer(layer);
	}

}
