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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * This Figure represents a SoftwareComponentFigure
 */
public class BusinessComponentFigure extends DeployCoreFigure {

	Color fgCFill;
	Color bgCFill;
	Color fgNoCFill;
	Color bgNoCFill;
	Color borderClr;
	Color concept;

	/**
	 * Constructor for SoftwareComponentFigure.
	 * 
	 * @param fgCFill
	 * @param bgCFill
	 * @param fgNoCFill
	 * @param bgNoCFill
	 * @param border
	 * @param concept
	 * @param colors
	 */

	public BusinessComponentFigure(Color fgCFill, Color bgCFill, Color fgNoCFill, Color bgNoCFill,
			Color border, Color concept) {
		this.fgCFill = fgCFill;
		this.bgCFill = bgCFill;
		this.fgNoCFill = fgNoCFill;
		this.bgNoCFill = bgNoCFill;
		borderClr = border;
		this.concept = concept;
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = paintBackground(g);

		Color border = borderClr;
		if (this.isConceptual()) {
			g.setForegroundColor(getLiteFillColor(fgCFill));
			g.setBackgroundColor(getFillColor(bgCFill));
		} else {
			g.setForegroundColor(getLiteFillColor(fgNoCFill));
			g.setBackgroundColor(getFillColor(bgNoCFill));
		}
		if (!isFaded) {
			g.fillGradient(r, true);
		}
		// inner hi-lite
		Rectangle r1 = r.getCopy();
		r1.shrink(Q, Q);
		g.setForegroundColor(ColorConstants.white);
		g.drawRectangle(r1);
		//outer border
		g.setForegroundColor(getLineColor(border));
		g.drawRectangle(r);

		// paint conceptual
		paintConceptual(g, r, 0, 0);

		// paint category
		paintTitles(g, r);
	}

}
