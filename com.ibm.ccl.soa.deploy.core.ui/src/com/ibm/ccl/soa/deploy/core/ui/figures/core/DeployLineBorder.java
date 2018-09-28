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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @author jswanke
 * 
 */
public class DeployLineBorder extends LineBorder {
	protected static Rectangle r = new Rectangle();
	private final Color outerClr;
	private final Color innerClr;
	private final IFigure owner;
	private boolean isInList = false;
	private boolean isConceptual = false;

	/**
	 * @param outerClr
	 * @param innerClr
	 * @param width
	 * @param owner
	 */
	public DeployLineBorder(Color innerClr, Color outerClr, int width, IFigure owner) {
		super(outerClr, width);
		this.outerClr = outerClr;
		this.innerClr = innerClr;
		this.owner = owner;
		if (owner instanceof CompositeShapeFigure) {
			IFigure fig = ((CompositeShapeFigure) owner).getInnerFigure();
			if (fig instanceof DeployListItemFigure) {
				isInList = true;
				isConceptual = ((DeployListItemFigure) fig).isConceptual();
			} else if (fig instanceof DeployCoreFigure) {
				isConceptual = ((DeployCoreFigure) fig).isConceptual();
			}
		}
	}

	public void paint(IFigure figure, Graphics g, Insets insets) {
		r.setBounds(getPaintRectangle(figure, insets));
		r.resize(-1, -1);

		// clip based on any containing containers
		g.setClip(GMFUtils.getClipRectangle(owner));

		// use dashed line if conceptual
		if (isConceptual) {
			g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] { 6, 2 });
		}

		// draw one or 2 pixel wide highlight
		if (getWidth() == 1) {
			g.setLineWidth(1);
			g.setForegroundColor(outerClr);
			paintHighlites(g, r, false);
		} else {
			// paint outer color
			g.setLineWidth(2);
			g.setForegroundColor(outerClr);
			paintHighlites(g, r, false);

			// paint inner color
			r.shrink(1, 1);
			g.setLineWidth(1);
			g.setForegroundColor(innerClr);
			paintHighlites(g, r, true);
		}
	}

	private void paintHighlites(Graphics g, Rectangle r, boolean isInner) {
		if (isInList) {
			// top 
			g.drawLine(r.x, r.y, r.x + r.width, r.y);

			// bottom
			int itemHeight = GEFUtils.getListItemDPHeight(owner);
			if (isInner) {
				itemHeight -= 2;
			}
			g.drawLine(r.x, r.y + itemHeight, r.x + r.width, r.y + itemHeight);
			// right side
			g.drawLine(r.x, r.y, r.x, r.y + itemHeight);
			// left side
			g.drawLine(r.x + r.width, r.y, r.x + r.width, r.y + itemHeight);
		} else {
			g.drawRectangle(r);
		}
	}
}
