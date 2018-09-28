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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * @author jswanke
 * 
 */
public class UnitGroupFigure extends DeployCoreFigure {

	private static final int ARC8 = MapModeUtil.getMapMode().DPtoLP(8);

	/**
	 * constructor
	 */
	public UnitGroupFigure() {
	}

	/**
	 * Draw a generic group.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = paintBackground(g);

		// create group background
		if (!isFaded) {
			g.setBackgroundColor(getFillColor(DeployColorConstants.grpFillColor));
			g.fillRoundRectangle(r, ARC8, ARC8);
		}
		g.setForegroundColor(getLineColor(DeployColorConstants.grpFillColor));
		g.drawRoundRectangle(r, ARC8, ARC8);

		// paint conceptual
		paintConceptual(g, r, ARC8, ARC8);
		paintTitles(g, r);
	}

}
