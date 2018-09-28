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

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * @author jswanke
 * 
 */
public class DiagramNodeFigure extends DeployCoreFigure {

	/**
	 * constructor
	 */
	public DiagramNodeFigure() {
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = paintBackground(g);

		// fill rect
		g.setBackgroundColor(getFillColor(DeployColorConstants.diagramNodeFill));
		g.fillRectangle(r.getCopy());

		// draw inside rect
		Rectangle innerRect = r.getCopy();
		innerRect.shrink(Q, Q);
		g.setForegroundColor(ColorConstants.white);
		g.drawRectangle(innerRect);

		// draw outside rect
		g.setForegroundColor(getLineColor(DeployColorConstants.diagramNodeBorder));
		g.drawRectangle(r);

		// draw category 
		paintCategory(g, r);
	}

}
