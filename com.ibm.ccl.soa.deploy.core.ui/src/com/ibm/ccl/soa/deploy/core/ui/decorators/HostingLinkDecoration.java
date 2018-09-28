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
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.figures.RealizationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;

/**
 * Decoration for the source and target of {@link RealizationLinkConnection}.
 * 
 * @author jswanke
 */
public class HostingLinkDecoration extends DeployPolygonDecoration {

	/**
	 * @param isSrc --
	 *           is this the source or target decoration
	 */
	public HostingLinkDecoration(boolean isSrc) {
		super(isSrc);
		if (!isSrc) {
			setTemplate(PolygonDecoration.TRIANGLE_TIP);
			setScale(MapModeUtil.getMapMode().DPtoLP(5), MapModeUtil.getMapMode().DPtoLP(5));
		}
	}

	protected void fillShape(Graphics g) {
		if (isVisible()) {
			//g.setForegroundColor(DeployColorConstants.hostingLinkColor);

			////////// Source ///////////
			if (isSource) {
				Point pt = getStart();
				g.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(5));
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
				super.fillShape(g);
			}

		}
	}

	protected void outlineShape(Graphics g) {
		// no outline
	}

} // end class RealizationSourceDecoration
