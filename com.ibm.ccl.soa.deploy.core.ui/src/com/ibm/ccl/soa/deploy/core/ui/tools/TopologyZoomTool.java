/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Cursor;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;

/**
 * @author jswanke NOTE: turned off standard zoom tool with this in plugin.xml: <predefinedEntry
 *         id="standardGroup/zoomTool" remove="true"/>
 * 
 */
public class TopologyZoomTool extends MarqueeSelectionTool {

	// zoom modes
	static private final int ZOOM_IN_MODE = 1;
	static private final int ZOOM_OUT_MODE = 2;
	static private final int ZOOM_PAN_MODE = 3;
	static private final int ZOOM_OUT_ALL_MODE = 4;

	// selection modes (target area that's being zoomed)
	static private final int SELECT_CANVAS = 1;
	static private final int SELECT_RECTANGLE = 2;

	// scroll modes (how to scroll viewport after the zoom)
	static private final int SCROLL_RECTANGLE = 1; //scroll viewport to upper/left corner of a rectangle
	static private final int SCROLL_EDITPART_CENTER = 2; //scroll to center of newly expanded ep that was under zoom click
	static private final int SCROLL_EDITPART_OFFSET = 3; //scroll to offset from nearest upper/left ep figure

	static final Cursor zoom_pan_cursor = Cursors.HAND;

	private int zoomMode = 1;
	private boolean isPointZoom = false;

	private int selectionMode = SELECT_RECTANGLE;
	private int scrollMode = SCROLL_RECTANGLE;
	private final boolean isZoomInDefault;

	/**
	 * Creates a new TopologyZoomTool.
	 * 
	 * @param isZoomInDefault
	 */
	public TopologyZoomTool(boolean isZoomInDefault) {
		this.isZoomInDefault = isZoomInDefault;
		setZoomMode(isZoomInDefault ? ZOOM_IN_MODE : ZOOM_OUT_MODE);
		setUnloadWhenFinished(false);
	}

	protected void performTopologyZoom() {

		EditPartViewer viewer = getCurrentViewer();
		DiagramRootEditPart rootEditPart = null;
		if (viewer.getRootEditPart() instanceof DiagramRootEditPart) {
			rootEditPart = (DiagramRootEditPart) viewer.getRootEditPart();
		}
		ZoomManager zm = rootEditPart.getZoomManager();
		boolean magnificationZoom = zm.getZoom() != 1.0;
		boolean detailZoom = !magnificationZoom;
		Rectangle zoomRect = new Rectangle(getStartLocation(), getLocation());
		IGraphicalEditPart ddep = GMFUtils.getDeployDiagramEditPart(rootEditPart);
		if (ddep == null) {
			return;
		}
		TransactionalEditingDomain editingDomain = ddep.getEditingDomain();

		///////////////////////////////////COMPARTMENT ZOOM ////////////////////////////////////////////////////////////////////
		if (detailZoom) {
			///////////////// determine modes ///////////////////////
			selectionMode = SELECT_RECTANGLE;
			scrollMode = SCROLL_RECTANGLE;
			Map selections = new HashMap();
			if (isPointZoom) {
				selectionMode = SELECT_CANVAS;
				scrollMode = SCROLL_EDITPART_OFFSET;
				GraphicalEditPart ep = (GraphicalEditPart) getCurrentViewer().findObjectAtExcluding(
						getLocation(), Collections.EMPTY_LIST, new EditPartViewer.Conditional() {
							public boolean evaluate(EditPart editpart) {
								return editpart.isSelectable();
							}
						});
				if (ep != null && !(ep instanceof DeployDiagramEditPart)) {
					selections.put(ZoomUtils.getSelectableParentEditPart(ep), null);
					scrollMode = SCROLL_EDITPART_CENTER;
				}
			}

			///////////////// get affected editparts ///////////////////////
			List compartmentList = new ArrayList();
			GraphicalEditPart[] selectedEP = new GraphicalEditPart[] { null };
			getCompartmentEditParts(getCurrentViewer(), zoomMode, compartmentList,
					selectionMode == SELECT_RECTANGLE ? zoomRect : null,
					scrollMode == SCROLL_EDITPART_OFFSET ? isPointZoom : false, getLocation(),
					selectedEP);
			if (scrollMode == SCROLL_EDITPART_OFFSET) {
				selections.put(selectedEP[0], null);
			}
			boolean isSomethingZoomable = compartmentList.size() > 0;
			magnificationZoom = !isSomethingZoomable;
			// if only some were selected, select now
			if (isSomethingZoomable && selectionMode == SELECT_RECTANGLE) {
				for (Iterator it = compartmentList.iterator(); it.hasNext();) {
					selections.put(ZoomUtils.getSelectableParentEditPart((GraphicalEditPart) it.next()),
							null);
				}
			}

			/////////////////// do the zoom //////////////////////////////
			FigureCanvas fc = (FigureCanvas) viewer.getControl();
			fc.setRedraw(false);
			if (isSomethingZoomable) {
				// collapse/expand compartments

				ZoomUtils.collapseViews(editingDomain, compartmentList, zoomMode == ZOOM_OUT_MODE);

				// scroll figurecanvas
				GraphicalEditPart selectedEditPart = null;
				if (selections.size() == 1) {
					selectedEditPart = (GraphicalEditPart) selections.keySet().toArray()[0];
				}
				scrollCanvas(viewer, scrollMode, zoomRect, selectedEditPart);
			}

			//////////////// do the selection /////////////////////////////
			// filter selections of invisible editparts
			Object[] eps = selections.keySet().toArray();
			for (int i = 0; i < eps.length; i++) {
				GraphicalEditPart ep = (GraphicalEditPart) eps[i];
				if (!GMFUtils.isFigureVisible(ep.getFigure())) {
					selections.remove(ep);
				}
			}

			// if something to select, select it
			if (selections.size() > 0 && scrollMode != SCROLL_EDITPART_OFFSET) {
				viewer.setSelection(new StructuredSelection(selections.keySet().toArray()));
			} else {
				// else deselect all
				viewer.deselectAll();
			}
			fc.setRedraw(true);
			IFigure diagramFig = ddep.getFigure();
			diagramFig.invalidateTree();
			diagramFig.revalidate();
			diagramFig.repaint();
		}

		//////////////////////////////// MAGNIFICATION ZOOM ///////////////////////////////////////////////////////////////////////
		// magnification zoom
		if (false) {//magnificationZoom) {
			if (isPointZoom) {
				if (getZoomMode() == ZOOM_OUT_MODE) {
					rootEditPart.zoomOut(getLocation());
				} else if (getZoomMode() == ZOOM_IN_MODE) {
					rootEditPart.zoomIn(getLocation());
				}
			} else {
				rootEditPart.zoomTo(zoomRect);
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// HELPERS /////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * find candidate compartment editparts based on search criterion
	 * 
	 * @param viewer
	 * @param zoomMode
	 * @param compartmentList --
	 *           the affected editparts
	 * @param zoomRect
	 * @param isFindNearest
	 * @param mousePt
	 * @param selectedEditPart
	 */
	static private void getCompartmentEditParts(EditPartViewer viewer, int zoomMode,
			List compartmentList, Rectangle zoomRect, boolean isFindNearest, Point mousePt,
			GraphicalEditPart[] selectedEditPart) {
		selectedEditPart[0] = null;
		double[] lastLen = new double[] { 100000000 };
		getCompartmentEditPartsHelper(viewer.getRootEditPart().getChildren(), zoomMode,
				compartmentList, zoomRect, isFindNearest, mousePt, selectedEditPart, lastLen, false);
	}

	static private boolean getCompartmentEditPartsHelper(List children, int zoomMode,
			List compartmentList, Rectangle zoomRect, boolean isFindNearest, Point mousePt,
			GraphicalEditPart[] selectedEditPart, double[] lastLen, boolean ignoreSelectable) {

		boolean useParentCompartment = true;
		for (int i = 0; i < children.size(); i++) {
			GraphicalEditPart child = (GraphicalEditPart) children.get(i);
			IFigure figure = child.getFigure();

			// always dig deeper on list items 
			if (!ignoreSelectable && !child.isSelectable()) {
				continue;
			}

			// get bounds
			Rectangle rect = figure.getBounds().getCopy();
			figure.translateToAbsolute(rect);

			// if not in zoomrect area, ignore
			if (zoomRect != null && !(child instanceof DeployDiagramEditPart)
					&& !(figure instanceof DeployListItemFigure) && !zoomRect.contains(rect)) {
				continue;
			}

			// if we're looking for a selectable editpart near mouse click, calc now
			if (isFindNearest && !(child instanceof DeployDiagramEditPart)
					&& !(child.getParent() instanceof DeployListCompartmentEditPart)) {
				Ray ray = new Ray(mousePt, rect.getCenter());
				double len = ray.length();
				if (len < lastLen[0]) {
					lastLen[0] = len;
					selectedEditPart[0] = child;
				}
			}

			// get compartments from editpart
			if (child instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) child;
				for (Iterator it = ep.getExpandableCompartmentEditParts().iterator(); it.hasNext();) {
					IGraphicalEditPart compartmentEP = (IGraphicalEditPart) it.next();
					ResizableCompartmentFigure compartmentFig = (ResizableCompartmentFigure) compartmentEP
							.getFigure();

					// if zooming in and we find a collapsed compartment, save it and stop digging deeper
					switch (zoomMode)
					{
					case ZOOM_IN_MODE: {
						boolean isCollapsed = !compartmentFig.isExpanded();
						if (isCollapsed) {
							compartmentList.add(compartmentEP);
						}
						// only expand the next level deep of compartment, unless its a list in which case expand all
						boolean isList = compartmentEP instanceof DeployListCompartmentEditPart;
						if (!isCollapsed || isList) {
							// if expanded, dig into compartment
							getCompartmentEditPartsHelper(compartmentEP.getChildren(), zoomMode,
									compartmentList, zoomRect, isFindNearest, mousePt, selectedEditPart,
									lastLen, isList);
						}
						break;
					}
						// if zooming out, save expanded compartments and dig deeper, but once we hit a collpased
						// compartment or reach bottom, save parent exanded compartment
					case ZOOM_OUT_MODE: {
						// if expanded, dig deeper to see if there's a collapsed compartment underneath
						if (compartmentFig.isExpanded()) {
							useParentCompartment = false;
							if (getCompartmentEditPartsHelper(compartmentEP.getChildren(), zoomMode,
									compartmentList, zoomRect, isFindNearest, mousePt, selectedEditPart,
									lastLen, false)) {
								compartmentList.add(compartmentEP);
								// collpase all lists
							} else if (compartmentEP instanceof DeployListCompartmentEditPart) {
								compartmentList.add(compartmentEP);
							}
						}
						break;
					}
						// if total zoom out, add all expanded compartmnet editparts in 
						// the order in which they should be collpased
					case ZOOM_OUT_ALL_MODE: {
						if (compartmentFig.isExpanded()) {
							compartmentList.add(0, compartmentEP);
							getCompartmentEditPartsHelper(compartmentEP.getChildren(), zoomMode,
									compartmentList, zoomRect, isFindNearest, mousePt, selectedEditPart,
									lastLen, false);
						}
					}
					}
				}
			}
			getCompartmentEditPartsHelper(child.getChildren(), zoomMode, compartmentList, zoomRect,
					isFindNearest, mousePt, selectedEditPart, lastLen, false);
		}
		return useParentCompartment;
	}

	///////////////////////////////////////////////////////////////////////////////////		
	static private void scrollCanvas(EditPartViewer viewer, int scrollMode, Rectangle zoomRect,
			GraphicalEditPart selectedEditPart) {
		// scroll to start location
		if (viewer.getControl() instanceof FigureCanvas) {
			// update viewport
			FigureCanvas fc = (FigureCanvas) viewer.getControl();
			Viewport port = fc.getViewport();
			port.validate();

			Point pt = new Point(0, 0);
			Point canvasOffset = new Point(port.getHorizontalRangeModel().getValue(), port
					.getVerticalRangeModel().getValue());
			org.eclipse.swt.graphics.Rectangle screenRect = viewer.getControl().getBounds();

			switch (scrollMode)
			{
			//	scroll viewport to upper/left corner of a rectangle
			case SCROLL_RECTANGLE: {
				if (zoomRect != null) {
					pt = zoomRect.getTopLeft();
					pt.x -= (screenRect.width - zoomRect.width) / 2 - zoomRect.width / 2;
					pt.y -= (screenRect.height - zoomRect.height) / 2 - zoomRect.height / 2;
					pt = pt.translate(canvasOffset);
				}
				break;
			}
				//	scroll to center of newly expanded ep that was under zoom click
				//	scroll to offset from nearest upper/left ep figure
			case SCROLL_EDITPART_CENTER:
			case SCROLL_EDITPART_OFFSET: {
				if (selectedEditPart != null) {
					IFigure figure = selectedEditPart.getFigure();
					Rectangle rect = figure.getBounds().getCopy();
					figure.translateToAbsolute(rect);
					pt = rect.getTopLeft();
					pt.x -= (screenRect.width - rect.width) / 2 - rect.width / 2;
					pt.y -= (screenRect.height - rect.height) / 2 - rect.height / 2;
					pt = pt.translate(canvasOffset);
				}
				break;
			}
			}
			port.setViewLocation(pt);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////		

	protected boolean handleButtonUp(int button) {
		if (stateTransition(STATE_DRAG_IN_PROGRESS, STATE_TERMINAL)) {
			this.handleInvalidInput();
		}
		handleFinished();
		performTopologyZoom();
		return true;
	}

	protected boolean handleButtonDown(int button) {
		isPointZoom = true;
		return super.handleButtonDown(button);
	}

	protected boolean handleDragInProgress() {
		isPointZoom = false;
		return super.handleDragInProgress();
	}

	protected Cursor getDefaultCursor() {
		if (getCurrentViewer() instanceof GraphicalViewer) {
			if (getZoomMode() == ZOOM_IN_MODE) {
				return DeployCoreImages.ZOOM_TOOL_PLUS_CURSOR;
			} else if (getZoomMode() == ZOOM_OUT_MODE) {
				return DeployCoreImages.ZOOM_TOOL_MINUS_CURSOR;
			} else if (getZoomMode() == ZOOM_PAN_MODE) {
				return zoom_pan_cursor;
			}
		}
		return Cursors.NO;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#getCommandName()
	 */
	protected String getCommandName() {
		return REQ_SELECTION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#handleViewerEntered()
	 */
	protected boolean handleViewerEntered() {
		boolean handled = super.handleViewerEntered();
		if (getCurrentViewer() != null) {
			getCurrentViewer().getControl().forceFocus();
			handled = true;
		}

		return handled;
	}

	/**
	 * Handles high-level processing of a key down event. KeyEvents are forwarded to the current
	 * viewer's {@link KeyHandler}, via {@link KeyHandler#keyPressed(KeyEvent)}.
	 * 
	 * @see AbstractTool#handleKeyDown(KeyEvent)
	 */
	protected boolean handleKeyDown(KeyEvent e) {
		if (super.handleKeyDown(e)) {
			return true;
		}
		if (getCurrentViewer().getKeyHandler() != null
				&& getCurrentViewer().getKeyHandler().keyPressed(e)) {
			return true;
		}
		if (e.keyCode == SWT.SHIFT) {
			setZoomMode(isZoomInDefault ? ZOOM_OUT_MODE : ZOOM_IN_MODE);
		}
		if (e.keyCode == SWT.ALT) {
			setZoomMode(ZOOM_PAN_MODE);
		}
		return false;
	}

	/**
	 * Handles high-level processing of a key down event. KeyEvents are forwarded to the current
	 * viewer's {@link KeyHandler}, via {@link KeyHandler#keyPressed(KeyEvent)}.
	 * 
	 * @see AbstractTool#handleKeyDown(KeyEvent)
	 */
	protected boolean handleKeyUp(KeyEvent e) {
		if (super.handleKeyUp(e)) {
			return true;
		}
		if (e.keyCode == SWT.SHIFT || e.keyCode == SWT.ALT) {
			setZoomMode(isZoomInDefault ? ZOOM_IN_MODE : ZOOM_OUT_MODE);
		}
		return false;
	}

	/**
	 * @see org.eclipse.gef.Tool#setViewer(org.eclipse.gef.EditPartViewer)
	 */
	public void setViewer(EditPartViewer viewer) {
		if (viewer == getCurrentViewer()) {
			return;
		}
		super.setViewer(viewer);
	}

	private int getZoomMode() {
		return zoomMode;
	}

	private void setZoomMode(int zoommode) {
		zoomMode = zoommode;
		setCursor(getDefaultCursor());
	}

}
