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
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.figures.RealizationLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GeometryUtils;

/**
 * Decoration for the source and target of {@link RealizationLinkConnection}.
 * 
 * @author Ed Snible, jswanke
 */
public class RealizationLinkDecoration extends DeployPolygonDecoration {

	/**
	 * @param isSrc --
	 *           is this the source or target decoration
	 */
	public RealizationLinkDecoration(boolean isSrc) {
		super(isSrc);
		if (!isSrc) {
			setScale(MapModeUtil.getMapMode().DPtoLP(5), MapModeUtil.getMapMode().DPtoLP(5));
		}
	}

	protected void fillShape(Graphics g) {
		if (isVisible()) {
			Point pt = getStart();

			////////// Source ///////////
			if (isSource) {
				Color rgb = g.getForegroundColor();
				switch (getConnectionSide())
				{
				case GeometryUtils.TOP:
					g.setForegroundColor(DeployColorConstants.white);
					g.drawLine(pt.x - 4 * Q, pt.y - Q, pt.x + 4 * Q, pt.y - Q);
					g.drawLine(pt.x - 4 * Q, pt.y - 3 * Q, pt.x + 4 * Q, pt.y - 3 * Q);
					g.setForegroundColor(rgb);
					g.drawLine(pt.x - 4 * Q, pt.y - 2 * Q, pt.x + 4 * Q, pt.y - 2 * Q);
					g.drawLine(pt.x - 3 * Q, pt.y - 4 * Q, pt.x + 3 * Q, pt.y - 4 * Q);
					break;
				case GeometryUtils.RIGHT:
					g.setForegroundColor(DeployColorConstants.white);
					g.drawLine(pt.x + Q, pt.y - 4 * Q, pt.x + Q, pt.y + 4 * Q);
					g.drawLine(pt.x + 3 * Q, pt.y - 4 * Q, pt.x + 3 * Q, pt.y + 4 * Q);
					g.setForegroundColor(rgb);
					g.drawLine(pt.x + 2 * Q, pt.y - 4 * Q, pt.x + 2 * Q, pt.y + 4 * Q);
					g.drawLine(pt.x + 4 * Q, pt.y - 3 * Q, pt.x + 4 * Q, pt.y + 3 * Q);
					break;
				case GeometryUtils.BOTTOM:
					g.setForegroundColor(DeployColorConstants.white);
					g.drawLine(pt.x - 4 * Q, pt.y + Q, pt.x + 4 * Q, pt.y + Q);
					g.drawLine(pt.x - 4 * Q, pt.y + 3 * Q, pt.x + 4 * Q, pt.y + 3 * Q);
					g.setForegroundColor(rgb);
					g.drawLine(pt.x - 4 * Q, pt.y + 2 * Q, pt.x + 4 * Q, pt.y + 2 * Q);
					g.drawLine(pt.x - 3 * Q, pt.y + 4 * Q, pt.x + 3 * Q, pt.y + 4 * Q);
					break;
				case GeometryUtils.LEFT:
					g.setForegroundColor(DeployColorConstants.white);
					g.drawLine(pt.x - Q, pt.y - 4 * Q, pt.x - Q, pt.y + 4 * Q);
					g.drawLine(pt.x - 3 * Q, pt.y - 4 * Q, pt.x - 3 * Q, pt.y + 4 * Q);
					g.setForegroundColor(rgb);
					g.drawLine(pt.x - 2 * Q, pt.y - 4 * Q, pt.x - 2 * Q, pt.y + 4 * Q);
					g.drawLine(pt.x - 4 * Q, pt.y - 3 * Q, pt.x - 4 * Q, pt.y + 3 * Q);
					break;
				}
				////////// Target ////////////
			} else {
				ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
				Image img = sharedImages.getImage(ISharedImages.IMG_REALIZATION_TARGET_DECORATOR);
				switch (getConnectionSide())
				{
				case GeometryUtils.TOP:
					g.drawImage(img, pt.translate(-4 * Q, -9 * Q));
					break;
				case GeometryUtils.RIGHT:
					g.drawImage(img, pt.translate(2 * Q, -4 * Q));
					break;
				case GeometryUtils.BOTTOM:
					g.drawImage(img, pt.translate(-4 * Q, 2 * Q));
					break;
				case GeometryUtils.LEFT:
					g.drawImage(img, pt.translate(-9 * Q, -4 * Q));
					break;
				}
			}

		}
	}

	protected void outlineShape(Graphics g) {
		// no outline
	}

} // end class RealizationSourceDecoration
