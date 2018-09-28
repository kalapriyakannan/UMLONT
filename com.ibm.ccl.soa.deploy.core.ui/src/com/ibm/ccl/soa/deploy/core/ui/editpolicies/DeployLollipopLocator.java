/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployLollipopFigure.LollyType;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * This locator is used to locate all the handles around the shape the closest distance to the mouse
 * location. It spaces the handles a certain distance apart. Call setEastWestSouth(true) to indicate
 * that the connection handle can only be located on the east, west, or south side of the reference
 * figure.
 */
public class DeployLollipopLocator implements Locator {

	/** the parent figure */
	private IFigure _hostFigure = null;

	/* is it within a list */
	private boolean isListFigure = false;

	final private EditPartViewer _viewer;

	/**
	 * Constructor for ConnectionHandleLocator.
	 * 
	 * @param viewer
	 * @param hostFigure
	 * 
	 */
	public DeployLollipopLocator(EditPartViewer viewer, IFigure hostFigure) {
		if (hostFigure instanceof ResizableCompartmentFigure) {
			_hostFigure = hostFigure.getParent();
		} else {
			_hostFigure = hostFigure;
		}
		if (hostFigure instanceof CompositeShapeFigure) {
			CompositeShapeFigure f = (CompositeShapeFigure) hostFigure;
			isListFigure = f.getInnerFigure() instanceof DeployListItemFigure;
		}
		_viewer = viewer;
	}

	/**
	 * Locates the handle on the appropriate edge of the parent figure depending the lollypop type.
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	public void relocate(IFigure figure) {
		DeployLollipopFigure lollypopFigure = (DeployLollipopFigure) figure;
		Rectangle hostFigureBounds = _hostFigure.getBounds().getCopy();
		_hostFigure.translateToAbsolute(hostFigureBounds);
		lollypopFigure.translateToRelative(hostFigureBounds);

		// if on edge of screen, shrink the host figure bounds so that the pop is drawn recessed into the figure
		FigureCanvas figureCanvas = (FigureCanvas) _viewer.getControl();
		Viewport vp = figureCanvas.getViewport();
		Point screenOffset = new Point(vp.getHorizontalRangeModel().getValue(), vp
				.getVerticalRangeModel().getValue());
		Rectangle portRect = vp.getBounds().getCopy().translate(screenOffset);
		if (hostFigureBounds.right() + 20 > portRect.right()) {
			hostFigureBounds.shrink(20, 0);
		}
		if (hostFigureBounds.bottom() + 20 > portRect.bottom()) {
			hostFigureBounds.shrink(0, 20);
		}

		int lollyWidth = lollypopFigure.getBounds().width;
		int lollyWeight = lollypopFigure.getBounds().height;
		int halfWidth = hostFigureBounds.width / 2;
		int halfHeight = hostFigureBounds.height / 2;
		int figHeight = hostFigureBounds.height;
		int right = hostFigureBounds.getRight().x;
		if (isListFigure) {
			figHeight = GEFUtils.getListItemDPHeight(_hostFigure);
			halfHeight = figHeight / 2;
		}

		// hosting lolly
		LollyType lollyType = lollypopFigure.getLollyType();
		if (lollyType == LollyType.HOSTING) {
			lollypopFigure.setLocation(new Point(hostFigureBounds.x + halfWidth - lollyWidth / 2,
					hostFigureBounds.y + figHeight));
			// realization lolly
		} else if (lollyType == LollyType.REALIZATION) {
			lollypopFigure.setLocation(new Point(hostFigureBounds.x + halfWidth + halfWidth / 2
					- lollyWidth / 2, hostFigureBounds.y + figHeight));
			// constraint lolly
		} else if (lollyType == LollyType.CONSTRAINT) {
			lollypopFigure.setLocation(new Point(hostFigureBounds.right(), hostFigureBounds.y
					+ figHeight));
			// dependency lolly
		} else if (lollyType == LollyType.DEPENDENCY) {
			lollypopFigure.setLocation(new Point(right, hostFigureBounds.y + halfHeight - lollyWeight
					/ 2));
		}
		// NOTE: do not set the size until the location has been set--otherwise the whole screen will refresh!!!!
		lollypopFigure.setSize(lollypopFigure.getImageSize());
	}
}
