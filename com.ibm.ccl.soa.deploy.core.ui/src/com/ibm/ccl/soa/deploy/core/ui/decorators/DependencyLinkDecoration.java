/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;

import com.ibm.ccl.soa.deploy.core.ui.figures.RealizationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;

/**
 * Decoration for the source and target of {@link RealizationLinkConnection}.
 * 
 * @author jswanke
 */
public class DependencyLinkDecoration extends DeployPolygonDecoration {

	/**
	 * @param isSrc --
	 *           is this the source or target decoration
	 */
	public DependencyLinkDecoration(boolean isSrc) {
		super(isSrc);
	}

	protected void fillShape(Graphics g) {
		if (isVisible()) {
			Point pt = getStart();

			////////// Source ///////////
			if (isSource) {
				g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(3));
				//	g.setForegroundColor(DeployColorConstants.dependencyLinkColor);
				switch (getConnectionSide())
				{
				case GeometryUtils.TOP:
					pt.translate(0, -Q);
					g.drawLine(pt, pt.getTranslated(0, -3 * Q));
					break;
				case GeometryUtils.RIGHT:
					pt.translate(Q, 0);
					g.drawLine(pt, pt.getTranslated(3 * Q, 0));
					break;
				case GeometryUtils.BOTTOM:
					pt.translate(0, 3 * Q);
					g.drawLine(pt, pt.getTranslated(0, -3 * Q));
					break;
				case GeometryUtils.LEFT:
					pt.translate(-2 * Q, 0);
					g.drawLine(pt, pt.getTranslated(-3 * Q, 0));
					break;
				}
				////////// Target ////////////
			} else {
				Color rgb = g.getForegroundColor();
				g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(
						rgb.equals(DeployColorConstants.selectedOuter)
								|| rgb.equals(DeployColorConstants.associatedOuter) ? 3 : 1));

				switch (getConnectionSide())
				{
				case GeometryUtils.TOP:
					g.drawLine(pt, pt.getTranslated(-3 * Q, -4 * Q));
					g.drawLine(pt, pt.getTranslated(3 * Q, -4 * Q));
					break;
				case GeometryUtils.RIGHT:
					g.drawLine(pt, pt.getTranslated(4 * Q, -3 * Q));
					g.drawLine(pt, pt.getTranslated(4 * Q, 3 * Q));
					break;
				case GeometryUtils.BOTTOM:
					g.drawLine(pt, pt.getTranslated(-3 * Q, 4 * Q));
					g.drawLine(pt, pt.getTranslated(3 * Q, 4 * Q));
					break;
				case GeometryUtils.LEFT:
					g.drawLine(pt, pt.getTranslated(-4 * Q, -3 * Q));
					g.drawLine(pt, pt.getTranslated(-4 * Q, 3 * Q));
					break;
				}

			}
		}
	}

	protected void outlineShape(Graphics g) {
		// no outline
	}

} // end class RealizationSourceDecoration
