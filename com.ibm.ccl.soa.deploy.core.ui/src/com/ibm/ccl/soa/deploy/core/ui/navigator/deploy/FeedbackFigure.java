/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.graphics.Image;

/**
 * @author jswanke
 * 
 */
public class FeedbackFigure extends Shape {
	Image image = null;
	Dimension size = new Dimension();
	private static FeedbackFigure feedbackFigure = null;

	public Point setImage(Image img, int x, int y, int width, int height) {
		image = img;
		// calc where feedback rect should be positioned/sized in feedback layer
		Point point = new Point(x, y);
		Dimension size = new Dimension(width, height);
		point.translate(size.getNegated().getScaled(.75));
		if (point.x < 0)
			point.x = 0;
		if (point.y < 0)
			point.y = 0;
		Point pt = new Point(point);
		translateToRelative(pt);
		setBounds(new Rectangle(pt, size));
		return point;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics g) {
		Rectangle r = super.getBounds();
		org.eclipse.swt.graphics.Rectangle imgRect = image.getBounds();
		g.drawImage(image, 0, 0, imgRect.width, imgRect.height, r.x, r.y, r.width, r.height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	protected void outlineShape(Graphics arg0) {
	}

	/*
	 * DRAG: maintain image in feedback layer during dragging
	 */
	public static Point update(DiagramEditPart part, org.eclipse.swt.graphics.Point location,
			Image image, int width, int height) {
		if (feedbackFigure == null) {
			feedbackFigure = new FeedbackFigure();
			IFigure feedbackLayer = part.getLayer(LayerConstants.FEEDBACK_LAYER);
			feedbackLayer.add(feedbackFigure);
		}
		return feedbackFigure.setImage(image, location.x, location.y, width, height);
	}

	public static void erase(DiagramEditPart part) {
		if (feedbackFigure != null) {
			IFigure feedbackLayer = part.getLayer(LayerConstants.FEEDBACK_LAYER);
			feedbackLayer.remove(feedbackFigure);
			feedbackFigure = null;
		}
	}

}
