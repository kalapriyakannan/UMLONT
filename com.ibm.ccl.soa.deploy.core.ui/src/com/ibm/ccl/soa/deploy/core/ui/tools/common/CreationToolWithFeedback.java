/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.tools.common;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AutoexposeHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editparts.ViewportAutoexposeHelper;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedColors;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.CreationFeedbackFigure;
import com.ibm.xtools.diagram.ui.common.utils.DiagramUtils;

/**
 * @since 7.0
 * 
 * @author jswanke
 */
abstract public class CreationToolWithFeedback extends CreationTool {

	// where is pointer placed on the shape feedback figure
	static private float POINTERSHAPEOFFSET = 0.0f;
	private IFigure _feedbackLayer = null;

	// for the shape feedback figure
	private CreationFeedbackFigure _shapeFeedbackFigure = null;
	private org.eclipse.draw2d.geometry.Point _shapeFeedbackPt = null;
	private org.eclipse.draw2d.geometry.Point _savedShapeFeedbackPt = null;
	// allow derived creation tool to offset view creation
	protected org.eclipse.draw2d.geometry.Point adjusjtFeedbackPt = new org.eclipse.draw2d.geometry.Point(
			0, 0);

	// for the lasso feedback figure
	private boolean _isCreatingShape = false;
	private IFigure _lassoOrMultiFigureFeedback;
	static protected Rectangle _lassoBounds = null;
	private boolean _isDragging = false;
	private Point _startPortLocation;
	private Viewport _port;

	// for multiple element creation
	private boolean _isMultiElementCreation = false;
	private static Dimension _multiElementSize;

	private final Color bgShapeContainer = DeployCoreUIPlugin.getDefault().getSharedColors()
			.getColor(ISharedColors.GHOST_FILL_COLOR);
	private final Color bgDiagram = ColorConstants.black;
	private final Color fgShapeContainer = ColorConstants.black;
	private final Color fgDiagram = ColorConstants.white;

	/**
	 * @param arg0
	 */
	public CreationToolWithFeedback(IElementType arg0) {
		super(arg0);
		setCursors();
	}

	/**
	 */
	public CreationToolWithFeedback() {
		super();
		setCursors();
	}

	private void setCursors() {
		setDefaultCursor(SharedCursors.getCursor(SharedCursors.ADDSHAPE));
		setDisabledCursor(SharedCursors.getCursor(SharedCursors.ADDSHAPE));
	}

	@Override
	public void deactivate() {
		if (_feedbackLayer != null && _shapeFeedbackFigure != null) {
			_feedbackLayer.remove(_shapeFeedbackFigure);
			_shapeFeedbackFigure = null;
		}
		super.deactivate();
	}

	@Override
	protected boolean handleMove() {
		if (!_isDragging) {
			boolean bRet = super.handleMove();
			updateShapeFeedbackFigure();
			return bRet;
		}
		return true;
	}

	@Override
	protected boolean handleDragStarted() {
		if (isLassoAllowed()) {
			_isDragging = true;

			// save shapeFeedbackPt in case user backs mouse up and we need to restore the shape feedback figure
			_savedShapeFeedbackPt = _shapeFeedbackPt;

			// get starting port view location
			_port = null;
			_startPortLocation = null;
			EditPart ep = getTargetEditPart();
			if (ep instanceof GraphicalEditPart) {
				FigureCanvas fc = (FigureCanvas) ((GraphicalEditPart) ep).getViewer().getControl();
				_port = fc.getViewport();
				_startPortLocation = _port.getViewLocation();
			}
		}
		return super.handleDragStarted();
	}

	@Override
	protected Point getStartLocation() {
		Point p = super.getStartLocation();
		// adjust for starting port location in case port has scrolled
		if (_isCreatingShape && _port != null && _startPortLocation != null) {
			p.translate(_startPortLocation.getDifference(_port.getViewLocation()));
		}
		return p;
	}

	@Override
	protected boolean handleDrag() {
		// allow viewport to scroll when user drags mouse past edge of viewport
		if (isLassoAllowed()) {
			Object o = this.getTargetEditPart().getRoot().getAdapter(AutoexposeHelper.class);
			if (o instanceof ViewportAutoexposeHelper) {
				setAutoexposeHelper((AutoexposeHelper) o);
			}
		}
		return super.handleDrag();
	}

	@Override
	protected void showTargetFeedback() {
		if (isLassoAllowed()) {
			Request request = getTargetRequest();
			if (REQ_CREATE.equals(request.getType())) {
				CreateRequest createReq = (CreateRequest) request;
				if (createReq.getSize() != null) {
					Point p = new Point(createReq.getLocation().getCopy());
					IFigure dragFeedback = getDragFeedbackFigure();
					dragFeedback.translateToRelative(p);
					Dimension size = createReq.getSize().getCopy();
					dragFeedback.translateToRelative(size);
					Rectangle r = new Rectangle(p, size);
					dragFeedback.setBounds(r);

					// set cursors to drag cursor
					if (Math.abs(size.width) > 16 || Math.abs(size.height) > 16) {
						_shapeFeedbackFigure.setVisible(false);
						dragFeedback.setVisible(true);
						setDefaultCursor(SharedCursors.getCursor(SharedCursors.SHAPE));
						setDisabledCursor(SharedCursors.getCursor(SharedCursors.SHAPE_NOT));
						if (_isMultiElementCreation) {
							_lassoBounds = null;
							_multiElementSize = ((CreationFeedbackFigure) dragFeedback)
									.getFeedbackMultiSize();

						} else {
							_lassoBounds = r.getCopy();
							dragFeedback.translateToAbsolute(_lassoBounds);
							if (getCurrentViewer().getContents() instanceof DiagramEditPart) {
								((DiagramEditPart) getCurrentViewer().getContents()).getFigure()
										.translateToRelative(_lassoBounds);
							}
							_multiElementSize = null;
						}
						_shapeFeedbackPt = null;
						_isCreatingShape = true;
					} else {
						_shapeFeedbackFigure.setVisible(true);
						dragFeedback.setVisible(false);
						setCursors();
						_lassoBounds = null;
						_shapeFeedbackPt = _savedShapeFeedbackPt;
						_isCreatingShape = false;
					}
				}
			}
		}
	}

	private IFigure getDragFeedbackFigure() {
		if (_lassoOrMultiFigureFeedback == null) {
			if (getCurrentInput().isAltKeyDown() && isMultiElementCreationAllowed()) {
				createMultiFigureFeedback();
			} else {
				_lassoOrMultiFigureFeedback = new RectangleFigure();
				_lassoOrMultiFigureFeedback.setBackgroundColor(ColorConstants.black);
				((Shape) _lassoOrMultiFigureFeedback).setFillXOR(true);
				((Shape) _lassoOrMultiFigureFeedback).setOutlineXOR(true);
				((Shape) _lassoOrMultiFigureFeedback).setLineStyle(Graphics.LINE_DASHDOT);
				_lassoOrMultiFigureFeedback.setForegroundColor(ColorConstants.white);
				addFeedback(_lassoOrMultiFigureFeedback);
			}

		}
		return _lassoOrMultiFigureFeedback;
	}

	@Override
	protected boolean handleKeyDown(KeyEvent e) {
		if (e.keyCode == SWT.ALT && isMultiElementCreationAllowed() && !_isMultiElementCreation) {
			if (_lassoOrMultiFigureFeedback != null) {
				removeFeedback(_lassoOrMultiFigureFeedback);
				_lassoOrMultiFigureFeedback = null;
			}
			createMultiFigureFeedback();
		}
		return super.handleKeyDown(e);
	}

	private void createMultiFigureFeedback() {
		_isMultiElementCreation = true;
		Image image = IconService.getInstance().getIcon(getElementType(),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
		String name = getElementType().getDisplayName();
		CreationFeedbackFigure fig = new CreationFeedbackFigure(getTargetEditPart(),
				POINTERSHAPEOFFSET, POINTERSHAPEOFFSET, image, new Dimension(16, 16), name, true, true,
				true);
		addFeedback(fig);

		// preset transitory feedback figure parameters
		Rectangle feedbackBounds = new Rectangle(0, 0, 125, 18);
		feedbackBounds.setLocation(getLocation());
		boolean isTargetShapeContainer = getTargetEditPart() instanceof ShapeCompartmentEditPart;
		Color foregroundColor = isTargetShapeContainer ? fgShapeContainer : fgDiagram;
		Color backgroundColor = isTargetShapeContainer ? bgShapeContainer : bgDiagram;
		fig.presetFeedbackParameters(feedbackBounds, foregroundColor, backgroundColor);

		// allow derived tool class to override feedback figure defaults
		setFeedbackParameters(fig);
		_lassoOrMultiFigureFeedback = fig;
		_lassoOrMultiFigureFeedback.setVisible(true);
	}

	@Override
	protected void eraseTargetFeedback() {
		super.eraseTargetFeedback();
		if (_lassoOrMultiFigureFeedback != null) {
			removeFeedback(_lassoOrMultiFigureFeedback);
			_lassoOrMultiFigureFeedback = null;
		}
	}

	@Override
	protected void handleFinished() {
		_lassoBounds = null;
		_multiElementSize = null;
		_isDragging = false;
		super.handleFinished();
	}

	// ensure that feedback and command is created one last time
	// in case editor is really busy, etc and the last move was a while ago
	@Override
	protected boolean handleButtonDown(int button) {
		handleMove();
		return super.handleButtonDown(button);
	}

	/*
	 * make sure shape is created where feedback shape was
	 */
	@Override
	protected Request getTargetRequest() {
		// 1) feedback figure sets itself back off of cursor point when it's position is set
		// 2) returns that new offset point to feedbackPt
		// 3) here we override the creation position to where feedback figure was
		// 4) if mouse was on a group area we also need to bump the creation down past the group header area
		Request request = super.getTargetRequest();
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest req = (CreateViewAndElementRequest) request;
			if (_shapeFeedbackPt != null) {
				req.setLocation(_shapeFeedbackPt);
			}
		}
		return request;

	}

	private void updateShapeFeedbackFigure() {
		// initialize shape feedback figure
		if (_shapeFeedbackFigure == null) {
			Image image = IconService.getInstance().getIcon(getElementType(),
					IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
			String name = getElementType().getDisplayName();
			_shapeFeedbackFigure = new CreationFeedbackFigure(getTargetEditPart(), POINTERSHAPEOFFSET,
					POINTERSHAPEOFFSET, image, new Dimension(16, 16), name, true, true, false);
			addFeedback(_shapeFeedbackFigure);
			_feedbackLayer = getLayer(LayerConstants.FEEDBACK_LAYER);
		}

		// preset transitory feedback figure parameters
		Rectangle feedbackBounds = new Rectangle(0, 0, 125, 18);
		feedbackBounds.setLocation(getLocation());
		boolean isTargetShapeContainer = getTargetEditPart() instanceof ShapeCompartmentEditPart;
		Color foregroundColor = isTargetShapeContainer ? fgShapeContainer : fgDiagram;
		Color backgroundColor = isTargetShapeContainer ? bgShapeContainer : bgDiagram;
		_shapeFeedbackFigure.presetFeedbackParameters(feedbackBounds, foregroundColor,
				backgroundColor);

		// allow derived tool class to override feedback figure defaults
		setFeedbackParameters(_shapeFeedbackFigure);
		_shapeFeedbackPt = _shapeFeedbackFigure.getFeedbackPoint();
	}

	protected IFigure getLayer(Object key) {
		LayerManager lm = (LayerManager) getCurrentViewer().getEditPartRegistry()
				.get(LayerManager.ID);
		if (lm == null) {
			return null;
		}
		return lm.getLayer(key);
	}

	/**
	 * @return _lassoBounds
	 */
	public static Rectangle getLassoBounds() {
		return _lassoBounds;
	}

	/**
	 * @return width=number of columns, height == number of rows to create when doing a mulitple
	 *         element creation
	 */
	public static Dimension getMultiElementSize() {
		return _multiElementSize;
	}

	/**
	 * get any lassoed views
	 * 
	 * @param diagramEP
	 *           the DiagramEditPart
	 * @param cls
	 *           the class of the EditPart which is eligible for lassoing-- must be an instance of
	 *           GraphicalEditPart
	 * @return list of lassoed views
	 */
	static public List<View> getLassoedViews(DiagramEditPart diagramEP, Class<?> cls) {
		List<View> list = new ArrayList<View>();

		// fill list with overlapped units
		ListIterator<?> children = DiagramUtils.getAllChildrenIncludingGroup(diagramEP)
				.listIterator();
		while (children.hasNext()) {
			EditPart child = (EditPart) children.next();
			if (child instanceof GraphicalEditPart && cls.isInstance(child)) {
				GraphicalEditPart childEP = (GraphicalEditPart) child;
				IFigure figure = childEP.getFigure();
				Rectangle bounds = figure.getBounds().getCopy();
				if (_lassoBounds.contains(bounds)) {
					list.add(childEP.getNotationView());
				}
			}
		}
		return list;
	}

	/*
	 * allow a derived creation tool to tailor the feedback figure for the target it's on
	 */
	abstract protected void setFeedbackParameters(CreationFeedbackFigure feedbackFigure);

	/*
	 * does this element allow the creation tool to lasso current diagram elements or presize the
	 * created element view
	 */
	abstract protected boolean isLassoAllowed();

	/*
	 * does this element allow the creation tool to create multiple elements in a grid if the user
	 * presses the ALT key whilst dragging the mouse
	 */
	abstract protected boolean isMultiElementCreationAllowed();

	public static void dispose() {
		SharedCursors.dispose();
	}

	/**
	 * Cursors shared with subclasses.
	 */
	protected static class SharedCursors {

		public static final int SHAPE = 0;
		public static final int SHAPE_NOT = 1;
		public static final int ADDSHAPE = 2;

		private final static Cursor[] cursors = new Cursor[3];

		/**
		 * Gets one of the shared cursors
		 * 
		 * @param code
		 *           one of {{@link #SHAPE}, {{@link #SHAPE_NOT} or { {@link #ADDSHAPE}
		 * @return the cursor
		 */
		public static Cursor getCursor(int code) {

			if (cursors[code] == null) {
				switch (code)
				{

				case SHAPE:
					cursors[SHAPE] = new Cursor(Display.getDefault(),
							DiagramUIPluginImages.DESC_SHAPECURSOR_SOURCE.getImageData(),
							DiagramUIPluginImages.DESC_SHAPECURSOR_MASK.getImageData(), 7, 7);
					break;

				case SHAPE_NOT:
					cursors[SHAPE_NOT] = new Cursor(Display.getDefault(),
							DiagramUIPluginImages.DESC_NOSHAPECURSOR_SOURCE.getImageData(),
							DiagramUIPluginImages.DESC_NOSHAPECURSOR_MASK.getImageData(), 7, 7);
					break;

				case ADDSHAPE:
					cursors[ADDSHAPE] = new Cursor(Display.getDefault(),
							DiagramUICommonPluginImages.DESC_ADDSHAPECURSOR_SOURCE.getImageData(),
							DiagramUICommonPluginImages.DESC_ADDSHAPECURSOR_MASK.getImageData(), 7, 7);
					break;
				}
			}
			return cursors[code];
		}

		/**
		 * Disposes of each shared cursor.
		 */
		public static void dispose() {
			for (int i = 0; i < cursors.length; i++) {
				if (cursors[i] != null) {
					cursors[i].dispose();
					cursors[i] = null;
				}
			}
		}
	}
}
