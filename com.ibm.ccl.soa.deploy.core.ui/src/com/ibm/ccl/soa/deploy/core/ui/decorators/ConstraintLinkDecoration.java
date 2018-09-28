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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

import com.ibm.ccl.soa.deploy.core.ui.figures.RealizationLinkConnection;

/**
 * Decoration for the source and target of {@link RealizationLinkConnection}.
 * 
 * @author jswanke
 */
public class ConstraintLinkDecoration extends DeployPolygonDecoration {
	private static final PointList LOGICAL_TIP = new PointList();
	private static final PointList SQUARE_TIP = new PointList();
	static {
		SQUARE_TIP.addPoint(-1, 1);
		SQUARE_TIP.addPoint(1, 1);
		SQUARE_TIP.addPoint(1, -1);
		SQUARE_TIP.addPoint(-1, -1);
	}
	static {
		LOGICAL_TIP.addPoint(0, 0);
		LOGICAL_TIP.addPoint(-1, 1);
		LOGICAL_TIP.addPoint(-2, 1);
		LOGICAL_TIP.addPoint(-2, -1);
		LOGICAL_TIP.addPoint(-1, -1);
	}

	/**
	 * @param isSrc --
	 *           is this the source or target decoration
	 */
	public ConstraintLinkDecoration(boolean isSrc) {
		super(isSrc);
		setBackgroundColor(ColorConstants.white);
		if (isSrc) {
			setTemplate(SQUARE_TIP);
		} else {
			setTemplate(LOGICAL_TIP);
		}
		setScale(MapModeUtil.getMapMode().DPtoLP(3), MapModeUtil.getMapMode().DPtoLP(3));
	}

	protected void fillShape(Graphics g) {
		if (isVisible()) {
			//g.setForegroundColor(DeployColorConstants.logicalLinkColor);
			super.fillShape(g);
		}
	}

} // end class RealizationSourceDecoration
