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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.LineSeg;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployManhattanConnectionRouter;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.DiagramFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.PolylineConnectionExEx;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ColorUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SnapUtils;

/**
 * @since 1.0
 * 
 */
abstract public class DeployLinkConnection extends PolylineConnectionExEx {

	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
	protected static final int FULL_JOG_LENGTH = MapModeUtil.getMapMode().DPtoLP(8);
	protected static final Font linkLabelFont = DeployCoreUIPlugin.getDefault().getSharedFonts()
			.getFont(ISharedFonts.LINK_NAME);
	private static final double slopeThreshold = 0.2;

	// is this link consolidated into a consolidation link?
	private boolean _isConsolidated = false;

	// has this link been redefined as a border line
	protected boolean _isBorderLine = false;
	// private static final int _borderLineThickness = 5;
	private static final int _borderLineThickness = MapModeUtil.getMapMode().DPtoLP(5);
	private static final int _borderLineDash[] = new int[] { 9, 3 };

	// is this link visible (ignore consolidation)
	private boolean _isVisibleIgnoringConsolidation = false;

	private Label tooltipLabel = null;
	private final int _jogLength;
	private boolean _isFaded = false;
	private final List<Rectangle> _captionBounds = new ArrayList<Rectangle>(); // actual caption bounds
	private final Hashtable<String, Rectangle> _captions = new Hashtable<String, Rectangle>(); // caption Strings + proposed bounds after layout 
	private PointList _oldPoints;

	private static final int linkLabelContrastThreshold = 280;
	private static final Hashtable<Color, Color> linkLabelColors = new Hashtable<Color, Color>();

	/**
	 * @param connectionEP
	 * @param jogLength
	 */
	public DeployLinkConnection(DeployConnectionNodeEditPart connectionEP, int jogLength) {
		super(connectionEP);
		_jogLength = jogLength;
	}

	// no special cursor
	static private final Cursor NO_COMMAND_SPECIAL_CURSOR = new Cursor(Display.getDefault(),
			SWT.CURSOR_ARROW);

	public Cursor getCursor() {
		return NO_COMMAND_SPECIAL_CURSOR;
	}

	public void layout() {
		// route points here so the captions will be set at the correct locations
		if (getSourceAnchor() != null && getTargetAnchor() != null) {
			getConnectionRouter().route(this);
		}

		if (bounds == null) {
			bounds = super.getBounds(); //new Rectangle(0,0,0,0);
		}

		_captions.clear();
		layoutCaptions();

		// note: call super.layout() after captions have been laid out because super.layout()
		// repaints the area returned by getBounds(), which will now include captions.
		super.layout();
	}

	/**
	 * Refresh the editpart's figure foreground colour.
	 */
	protected void refreshForegroundColor() {
	}

	@Override
	public void setForegroundColor(Color fg) {
		if (!getForegroundColor().getRGB().equals(fg.getRGB())) {
			super.setForegroundColor(fg);
		}
	}

	@Override
	public void setPoints(PointList points) {
		if (_oldPoints == null || !pointsEqual(_oldPoints, points)) {
			_oldPoints = points.getCopy();
			super.setPoints(points);
		}
	}

	private boolean pointsEqual(PointList points, PointList points2) {
		if (points.size() == points2.size()) {
			for (int i = 0; i < points.size(); i++) {
				if (!points.getPoint(i).equals(points2.getPoint(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// TOOLTIP //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////

	abstract protected String getToolTipMessage(DeployModelObject linkDmo, DeployModelObject srcDmo,
			String srcDup, DeployModelObject tgtDmo, String tgtDup);

	public IFigure getToolTip() {
		if (tooltipLabel == null) {
			tooltipLabel = new Label() {
				public Insets getInsets() {
					return new Insets(5);
				}
			};
		}
		tooltipLabel.setText(createToolTip());
		return tooltipLabel;
	}

	/**
	 * @return a tooltip for this link
	 */
	private String createToolTip() {
		// determine what links the mouse is hovering over
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor == null) {
			return ""; //$NON-NLS-1$
		}
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) editor.getDiagramEditPart();
		IFigure connectionLayer = getLayer(ddep, LayerConstants.CONNECTION_LAYER);

		// find all figures at this spot in the connectionlayer
		List<IFigure> figures = new ArrayList<IFigure>();
		figures.add(this);

		// get cursor location and find other links at this location
		Control control = Display.getDefault().getCursorControl();
		if (control == null) {
			return ""; //$NON-NLS-1$
		}
		Point pt = new Point(control.toControl(Display.getDefault().getCursorLocation()));
		connectionLayer.translateToRelative(pt);

		int safety = 0;
		// with abbreviated links, the exclude part of this call doesn't always work
		IFigure fig;
		while ((fig = connectionLayer.findFigureAtExcluding(pt.x, pt.y, figures)) != null
				&& fig != this && safety < 5) {
			if (figures.contains(fig)) {
				safety++;
			} else {
				figures.add(fig);
			}
		}

		// if one or more links is selected in this batch, we only show the tool tips for the selected links
		boolean isAnyLinkSelected = false;
		for (Iterator<?> it = figures.iterator(); it.hasNext();) {
			fig = (IFigure) it.next();
			if (fig instanceof DeployLinkConnection && ((DeployLinkConnection) fig)._isBringToFront) {
				isAnyLinkSelected = true;
				break;
			}
		}

		// loop through links creating a tip for each link 
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		for (Iterator it = figures.iterator(); it.hasNext(); count++) {
			fig = (IFigure) it.next();
			if (fig instanceof DeployLinkConnection) {
				DeployLinkConnection linkFig = (DeployLinkConnection) fig;
				// ignore if one or more links is selected but this one isn't
				if (isAnyLinkSelected && !linkFig._isBringToFront) {
					count--;
					continue;
				}
				if (count != 0) {
					buffer.append("\n"); //$NON-NLS-1$
				}
				buffer.append(getToolTip((DeployConnectionNodeEditPart) linkFig.getConnectionEP()));
				if (connectionLayer.getChildren().size() > 10000) {
					buffer.append(connectionLayer.getChildren().size());
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * @param linkEP
	 * @return tooltip
	 */
	static public String getToolTip(DeployConnectionNodeEditPart linkEP) {
		DeployLinkConnection linkFig = (DeployLinkConnection) linkEP.getFigure();
		GraphicalEditPart srcEP = (GraphicalEditPart) linkEP.getSource();
		GraphicalEditPart tgtEP = (GraphicalEditPart) linkEP.getTarget();
		if (srcEP != null && tgtEP != null) {
			DeployModelObject linkDmo = (DeployModelObject) linkEP.resolveSemanticElement();
			EObject srcEO = srcEP.resolveSemanticElement();
			EObject tgtEO = tgtEP.resolveSemanticElement();
			DeployModelObject srcDmo = srcEO instanceof DeployModelObject ? (DeployModelObject) srcEO
					: null;
			DeployModelObject tgtDmo = tgtEO instanceof DeployModelObject ? (DeployModelObject) tgtEO
					: null;
			return linkFig.getToolTipMessage(linkDmo, srcDmo, getDupIndex(srcEP), tgtDmo,
					getDupIndex(tgtEP));
		}
		return null;
	}

	static protected String getDupIndex(GraphicalEditPart ep) {
		String dup = ""; //$NON-NLS-1$
		if (ep instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart dep = (DeployShapeNodeEditPart) ep;
			CompositeShapeFigure csf = (CompositeShapeFigure) dep.getFigure();
			if (csf.getInnerFigure() instanceof DeployCoreFigure) {
				dup = ((DeployCoreFigure) csf.getInnerFigure()).getDuplicateIndex();
			} else if (csf.getInnerFigure() instanceof DeployListItemFigure) {
				dup = ((DeployListItemFigure) csf.getInnerFigure()).getDuplicateIndex();
			}
			if (dup == null) {
				dup = "";//$NON-NLS-1$
			}
		}
		return dup;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// LINK LABELS //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	protected boolean displayConnectionLabels() {
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		return store == null || !store.getBoolean(IDeployPreferences.DEPLOY_DISABLE_LINK_LABELS);
	}

	protected String getConnectionLabelName(EObject offscreenElement) {
		if (offscreenElement instanceof DeployModelObject) {
			return PropertyUtils.getDmoName((DeployModelObject) offscreenElement);
		}
		return Messages.UNKNOWN_LABEL;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// GET POINT LIST/HIDE ENDPOINTS ///////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////

	protected void clipParentClientArea(Graphics g) {
		// if we leave loop with a valid clipRect
		Rectangle clipRect = getParentClientArea();
		if (clipRect != null) {
			g.clipRect(clipRect);
			if (getSourceDecoration() != null) {
				IFigure fig = getSourceDecoration();
				fig.setVisible(clipRect.contains(fig.getBounds()));
			}
			if (getTargetDecoration() != null) {
				IFigure fig = getTargetDecoration();
				fig.setVisible(clipRect.contains(fig.getBounds()));
			}
		}
	}

	/**
	 * lines are still visible when they are connecting two units in a collpased container this
	 * determines if a line is actually being drawn
	 * 
	 * @return is a link being drawn
	 */
	public boolean isHidden() {
		return false;
	}

	/**
	 * @return clip rect of parent compartment
	 */
	public Rectangle getParentClientArea() {
		// if both anchors are in the same container
		ConnectionAnchor srcAnc = getSourceAnchor();
		ConnectionAnchor tgtAnc = getTargetAnchor();
		if (srcAnc == null || tgtAnc == null || srcAnc instanceof XYAnchor
				|| tgtAnc instanceof XYAnchor) {
			return null;
		}
		IFigure srcFig = srcAnc.getOwner();
		IFigure tgtFig = tgtAnc.getOwner();
		if (GEFUtils.getTopFigure(srcFig) != GEFUtils.getTopFigure(tgtFig)) {
			return null;
		}

		// get first parent figure between the src and tgt
		IFigure commonParentFigure = srcFig.getParent();
		IFigure walker = srcFig.getParent();
		List<IFigure> list = new ArrayList<IFigure>();
		while (walker != null) {
			list.add(walker);
			walker = walker.getParent();
		}
		walker = tgtFig.getParent();
		while (walker != null) {
			if (list.contains(walker)) {
				commonParentFigure = walker;
				break;
			}
			walker = walker.getParent();
		}

		// calculate a clipRect that it will appear in
		Rectangle clipRect = commonParentFigure.getBounds().getCopy();
		commonParentFigure.translateToAbsolute(clipRect);
		while (commonParentFigure != null) {
			if (!commonParentFigure.isVisible()) {
				clipRect.setSize(0, 0);
				return clipRect;
			}
			if (commonParentFigure instanceof ResizableCompartmentFigure) {
				Rectangle parentClientArea = commonParentFigure.getClientArea().getCopy();
				commonParentFigure.translateToAbsolute(parentClientArea);
				parentClientArea = clipRect.intersect(parentClientArea);
			} else if (commonParentFigure instanceof DiagramFigure) {
				commonParentFigure.translateToRelative(clipRect);
				return clipRect;
			}
			commonParentFigure = commonParentFigure.getParent();
		}
		return null;
	}

	// jog the ends of a full line away from the figure
	public PointList getPoints() {
		PointList ptList = super.getPoints();
		if (getSourceAnchor() != null && getSourceAnchor().getOwner() != null
				&& getTargetAnchor() != null && getTargetAnchor().getOwner() != null) {
			ptList = PointListUtilities.copyPoints(ptList);

			// jog the start
			Point pt1 = ptList.getFirstPoint();
			Point pt2 = pt1.getCopy();
			Rectangle rect = getSourceAnchor().getOwner().getBounds().getCopy();
			getSourceAnchor().getOwner().translateToAbsolute(rect);
			translateToRelative(rect);
			jogEndPoints(rect, pt1, pt2, jogMultiplier(getSourceAnchor(), _jogLength));
			ptList.setPoint(pt1, 0);
			ptList.insertPoint(pt2, 1);

			// jog the end
			pt1 = ptList.getLastPoint();
			pt2 = pt1.getCopy();
			rect = getTargetAnchor().getOwner().getBounds().getCopy();
			getTargetAnchor().getOwner().translateToAbsolute(rect);
			translateToRelative(rect);
			jogEndPoints(rect, pt1, pt2, jogMultiplier(getTargetAnchor(), _jogLength));
			ptList.setPoint(pt1, ptList.size() - 1);
			ptList.insertPoint(pt2, ptList.size() - 1);
		}
		return ptList;
	}

	private int jogMultiplier(ConnectionAnchor connectionAnchor, int jogLength) {
		int jog = jogLength;
		if (connectionAnchor instanceof DeployConnectorAnchor) {
			DeployConnectorAnchor anchor = (DeployConnectorAnchor) connectionAnchor;
			if (anchor.isRightTreeAnchor()) {
				jog *= 3;
			} else if (anchor.isLeftTreeAnchor()) {
				jog *= 3;
				int jogs = MapModeUtil.getMapMode(this).DPtoLP(12);
				IFigure walker = connectionAnchor.getOwner();
				while (!(walker instanceof DiagramFigure)) {
					if (walker instanceof DeployListCompartmentFigure) {
						jog += jogs;
					}
					walker = walker.getParent();
				}
			}
		}
		return jog;
	}

	private void jogEndPoints(Rectangle rect, Point pt1, Point pt2, int jogLength) {

		// no need to jog if using manhattan router
		if (!(getConnectionRouter() instanceof DeployManhattanConnectionRouter)) {
			// else jog the end points to make the endpoint decoration easier to see
			switch (GeometryUtils.getClosestSide(rect, pt1))
			{
			case GeometryUtils.LEFT:
				pt1.x -= Q;
				pt2.x = pt1.x - jogLength;
				break;
			case GeometryUtils.RIGHT:
				pt1.x += Q;
				pt2.x = pt1.x + jogLength;
				break;
			case GeometryUtils.TOP:
				pt1.y -= Q;
				pt2.y = pt1.y - jogLength;
				break;
			case GeometryUtils.BOTTOM:
				pt1.y += Q;
				pt2.y = pt1.y + jogLength;
				break;
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// VISIBILITY HELPERS //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * determine if this end of link is visible
	 */
	protected boolean isAnchorInParent(ConnectionAnchor anchor, ConnectionAnchor anchorParent) {
		if (anchor == null || anchorParent == null) {
			return false;
		}
		IFigure anchorFig = anchor.getOwner();
		IFigure anchorParentFig = anchorParent.getOwner();

		IFigure walker = anchorFig;
		while (walker != null) {
			walker = walker.getParent();
			if (walker == anchorParentFig) {
				return true;
			}
		}
		return false;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// GETTERS/SETTERS //////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @param isFaded
	 */
	public void setFaded(boolean isFaded) {
		_isFaded = isFaded;
	}

	/**
	 * @return is in consolidation link
	 */
	public boolean isConsolidated() {
		return _isConsolidated;
	}

	/**
	 * @param isConsolidated
	 */
	public void setConsolidated(boolean isConsolidated) {
		_isConsolidated = isConsolidated;
		super.setVisible(!isConsolidated);
	}

	/**
	 * @return would be visible--not factoring in if it was consolidated
	 */
	public boolean isVisibleIgnoringConsolidation() {
		return _isVisibleIgnoringConsolidation;
	}

	@Override
	public void setVisible(boolean visible) {
		// remember whether this link would be visible if it weren't consolidated
		_isVisibleIgnoringConsolidation = visible;
		super.setVisible(visible && !_isConsolidated);
	}

	/**
	 * Populate _captions, a Hashtable of text strings and bounds for caption labels
	 */
	protected void layoutCaptions() {

		if (_connectionEP == null) {
			return;
		}
		DeployModelObject linkDmo = (DeployModelObject) _connectionEP.resolveSemanticElement();
		if (linkDmo == null || linkDmo instanceof Unit) {
			return;
		}

		if (!doPaintCaption(linkDmo)) {
			return;
		}

		//Only set if display name is set. We don't want to display
		//the name.
		String caption = linkDmo != null ? linkDmo.getDisplayName() : null;
		if (caption == null || caption.length() == 0) {
			return;
		}

		PointList ptList = getPoints();
		Rectangle bnds = getMidpointBounds(caption, ptList);

		if (bnds != null) {
			_captions.put(caption, bnds);
		}
	}

	protected Rectangle getMidpointBounds(String caption, PointList ptList) {
		if (ptList == null || ptList.size() < 2) {
			return null;
		}

		Point pt = ptList.getMidpoint();
		return getBoundsAtPoint(caption, pt, ptList);
	}

	/**
	 * Returns the bounds of the label at the given point. If ptList is not null, it will adjust the
	 * label above the ptList if the label intersects with a nearly flat section of the pointList
	 * (i.e., a part of the pointList goes through the label)
	 * 
	 * @param label
	 * @param pt
	 * @param ptList
	 * @return
	 */
	protected Rectangle getBoundsAtPoint(String label, Point pt, PointList ptList) {
		Dimension dim = getLabelDimension(label, linkLabelFont);

		pt.x -= dim.width / 2;
		pt.y -= dim.height / 2;

		if (ptList != null) {
			nudgePointAboveFlatSlopedLine(pt, dim, ptList);
		}

		Rectangle bnds = new Rectangle(pt, dim);
		return bnds;
	}

	protected void paintCaptions(PointList ptList, Graphics g) {
		_captionBounds.clear();

		Iterator<Entry<String, Rectangle>> iter = _captions.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Rectangle> caption = iter.next();
			String captionText = caption.getKey();
			if (captionText.length() > 0) {
				Rectangle bnds = caption.getValue();
				drawCaptionAtPoint(captionText, bnds.getTopLeft(), ptList, g);
			}
		}
	}

	protected void addToCaptionBounds(Rectangle bnds) {
		_captionBounds.add(bnds);
	}

	protected Rectangle drawCaptionAtPoint(String caption, Point pt, PointList ptList, Graphics g) {
		if (caption == null || caption.length() == 0 || ptList == null || ptList.size() < 2) {
			return null;
		}
		Dimension dim = getLabelDimension(caption, linkLabelFont);
		g.setFont(linkLabelFont);

		Rectangle captionBounds = new Rectangle(pt, dim);

		Color col = getLegibleLabelColor(g.getForegroundColor());

		// draw a custom white background of the text itself so the text will stand out
		g.setForegroundColor(ColorConstants.white);
		int offset = MapModeUtil.getMapMode(this).DPtoLP(2);
		g.drawText(caption, pt);
		g.drawText(caption, pt.getTranslated(offset, offset));
		g.drawText(caption, pt.getTranslated(offset, 0));
		g.drawText(caption, pt.getTranslated(0, offset));

		if (col != null) {
			g.setForegroundColor(col);
		} else {
			g.setForegroundColor(ColorConstants.black);
		}
		g.drawText(caption, pt);

		addToCaptionBounds(captionBounds);

		return captionBounds;
	}

	protected Dimension getLabelDimension(String caption, Font labelFont) {
		Dimension dim = FigureUtilities.getTextExtents(caption, labelFont);
		translateToRelative(dim);
		double zoom = getZoom();
		if (zoom != 1.0) {
			dim.height *= zoom;
			dim.width *= zoom;
		}
		return dim;
	}

	private void nudgePointAboveFlatSlopedLine(Point pt, Dimension dim, PointList ptList) {
		// if the slope of the link, or a part of the link that is within the label area,
		// is flat or almost flat, it might obscure the label. In that case, draw the label 
		// above the link, instead of at its midpoint
		PointList points = GeometryUtils.getPointsWithinRectangle(ptList, new Rectangle(pt, dim));
		boolean flatSlope = false;
		for (int i = 0; i < points.size() - 1 && flatSlope == false; i++) {
			LineSeg lineSeg = new LineSeg(points.getPoint(i), points.getPoint(i + 1));
			if (Math.abs(lineSeg.slope()) < slopeThreshold) {
				flatSlope = true;
			}
		}

		if (flatSlope) {
			pt.y -= dim.height / 2;
		}
	}

	public Rectangle getBounds() {
		Rectangle bnds = super.getBounds();
		Rectangle captionBounds = null;
		if (getCaptionBounds() != null) {
			for (Rectangle rect : getCaptionBounds()) {
				if (captionBounds == null) {
					captionBounds = rect.getCopy();
				} else {
					captionBounds = captionBounds.union(rect);
				}
			}
		}
		if (bnds != null && captionBounds != null && !bnds.contains(captionBounds)) {
			bnds = bnds.union(captionBounds);
		}
		return bnds;
	}

	private Color getLegibleLabelColor(Color foregroundColor) {
		Color col = DeployColorConstants.dependencyLinkColor;
		if (foregroundColor != null) {
			Color baseBG = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
			int bgVal = baseBG.getRed() + baseBG.getGreen() + baseBG.getBlue(); // background rgb = 255,255,255
			col = foregroundColor;
			int fgVal = foregroundColor.getRed() + foregroundColor.getBlue()
					+ foregroundColor.getGreen();
			if (bgVal - fgVal < linkLabelContrastThreshold) {
				col = linkLabelColors.get(foregroundColor);
				if (col == null) {
					float f = (float) (bgVal - linkLabelContrastThreshold) / (float) fgVal;
					col = ColorUtils.getShade(foregroundColor, f, Display.getCurrent());
					linkLabelColors.put(foregroundColor, col);
				}
			}
		}
		return col;
	}

	// return whether or not to paint the caption
	protected boolean doPaintCaption(DeployModelObject dmo) {
		// TODO Look at topology filter for this type; If unspecified look at global preference setting
		// This is a temporary filtering mechanism: 
		// only a caption which was explicitly set in the displayName field will be drawn on the diagram.
		if (dmo == null || dmo.getDisplayName() == null || dmo.getDisplayName().length() == 0) {
			return false;
		}
		return true;
	}

	protected double getZoom() {
		double zoom = 1.0;
		RootEditPart rootEditPart = _connectionEP.isActive() ? _connectionEP.getRoot() : null;
		if (rootEditPart instanceof DiagramRootEditPart) {
			ZoomManager zm = ((DiagramRootEditPart) rootEditPart).getZoomManager();
			zoom = zm.getZoom();
		}
		return zoom;
	}

	public boolean isFaded() {
		return _isFaded;
	}

	protected boolean doBorderLineLink() {
		return anEndIsInRectangularSnapGroup(false);
	}

	protected boolean anEndIsInRectangularSnapGroup(boolean checkContainers) {
		if (_connectionEP != null) {
			GraphicalEditPart srcEP = (GraphicalEditPart) _connectionEP.getSource();
			if (srcEP != null) {
				if (SnapUtils.isInRectangularSnapGroup(srcEP)) {
					return true;
				}
				if (checkContainers && SnapUtils.containerIsInRectangularSnapGroup(srcEP)) {
					return true;
				}
			}
			GraphicalEditPart targetEP = (GraphicalEditPart) _connectionEP.getTarget();
			if (targetEP != null) {
				if (SnapUtils.isInRectangularSnapGroup(targetEP)) {
					return true;
				}
				if (checkContainers && SnapUtils.containerIsInRectangularSnapGroup(targetEP)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return returns a PointList for the points along the border between the source and target, or
	 *         null if the source and target don't share a border Null might be returned if the
	 *         source and target do not share a border or if they do not meet the criteria for having
	 *         the link displayed along the border.
	 */
	protected PointList getBorderLinePointList() {
		GraphicalEditPart srcEP = (GraphicalEditPart) _connectionEP.getSource();
		GraphicalEditPart tgtEP = (GraphicalEditPart) _connectionEP.getTarget();
		if (srcEP != null && tgtEP != null && srcEP instanceof DeployShapeNodeEditPart
				&& tgtEP instanceof DeployShapeNodeEditPart) {
			Rectangle srcRect = SnapUtils.getEditPartBounds((DeployShapeNodeEditPart) srcEP);
			Rectangle tgtRect = SnapUtils.getEditPartBounds((DeployShapeNodeEditPart) tgtEP);
			if (srcRect != null && tgtRect != null) {
				srcRect = srcRect.getCopy();
				tgtRect = tgtRect.getCopy();
				srcRect.expand(1, 1);
				tgtRect.expand(1, 1);
				Rectangle intersection = srcRect.getIntersection(tgtRect);
				if (!intersection.isEmpty()) {
					Point center = intersection.getCenter();
					Point pt1 = new Point(center);
					Point pt2 = new Point(center);
					if (intersection.height > intersection.width) {
						pt1.y = intersection.y;
						pt2.y = intersection.bottom();
					} else {
						pt1.x = intersection.x;
						pt2.x = intersection.right();
					}
					int points[] = { pt1.x, pt1.y, pt2.x, pt2.y };
					PointList ptList = new PointList(points);
					return ptList;
				}
			}
		}
		return null;
	}

	protected Color getBorderLineColor(Graphics g) {
		Color borderLineColor = DeployColorConstants.borderLineColor;
		if (g != null && g.getForegroundColor() != DeployColorConstants.dependencyLinkColor
				&& g.getForegroundColor() != DeployColorConstants.associatedOuter) {
			// If the default color is too light to see, use the borderLineColor constant
			// (Dark green was chosen because it's not being used for any other purpose
			// Light gray is too light, and other shades of gray are difficult to distinguish
			// from the color of Consolidated links)
			borderLineColor = g.getForegroundColor();
		}
		return borderLineColor;
	}

	protected void setBorderLineProperties(Graphics g) {
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(_borderLineDash);
		g.setForegroundColor(getBorderLineColor(g));
		g.setLineWidth(_borderLineThickness);
	}

	/**
	 * @return returns caption bounds
	 */
	protected List<Rectangle> getCaptionBounds() {
		return _captionBounds;
	}

	/**
	 * @param bnds
	 */

	@Override
	public boolean containsPoint(int x, int y) {
		if (super.containsPoint(x, y)) {
			return true;
		}
		if (!isHidden()) {
			if (_isBringToFront || !overlapped(x, y)) {
				if (getCaptionBounds() != null) {
					for (Rectangle bnds : getCaptionBounds()) {
						if (bnds.contains(x, y)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// see if a figure overlaps this link at this point and therefore should be ignored
	// because the overlapping figure is drawn over the link
	private boolean overlapped(int x, int y) {
		for (Iterator<Rectangle> it = getOverlappedFigureRects().iterator(); it.hasNext();) {
			if (it.next().contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Handle an overlap in the area of the given rectangle. This method should be called after
	 * layout() and before outlineShape().
	 * 
	 * @param rect
	 */
	public void handleOverlap(Rectangle rect) {
		if (rect == null) {
			return;
		}
		if (_captions == null) {
			return;
		}
		Iterator<Rectangle> iter = _captions.values().iterator();
		while (iter.hasNext()) {
			Rectangle bnds = iter.next();
			if (bnds.intersects(rect)) {
				bnds.y = rect.y - bnds.height;
			}
		}
	}

	protected Hashtable<String, Rectangle> getCaptions() {
		return _captions;
	}

}
