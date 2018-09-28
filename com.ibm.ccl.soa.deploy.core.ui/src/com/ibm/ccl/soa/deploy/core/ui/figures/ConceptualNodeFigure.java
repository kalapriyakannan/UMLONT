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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @author jswanke
 * 
 */
public class ConceptualNodeFigure extends DeployCoreFigure {

	private static final Dimension SIZE = new Dimension(DeployCoreConstants.NODE_UNIT_WIDTH,
			DeployCoreConstants.NODE_UNIT_HEIGHT);

	/**
	 * constructor
	 */
	public ConceptualNodeFigure() {
	}

	protected Dimension getMinimalSize() {
		return SIZE;
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = paintBackground(g);

		if (!isFaded) {
			g.setBackgroundColor(getFillColor(DeployColorConstants.nodeComponentFill));
			g.fillRectangle(r);
		}
		Rectangle r1 = r.getCopy();
		r1.shrink(Q, Q);
		g.setForegroundColor(ColorConstants.white);
		g.drawRectangle(r1);
		g.setForegroundColor(getLineColor(DeployColorConstants.nodeComponentBorder1));
		g.drawRectangle(r);

		// paint conceptual
		paintConceptual(g, r, 0, 0);
		paintTitles(g, r);
	}

}
