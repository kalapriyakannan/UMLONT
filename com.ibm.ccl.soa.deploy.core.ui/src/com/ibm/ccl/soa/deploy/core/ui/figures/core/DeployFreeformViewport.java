/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.FreeformFigure;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author jswanke
 * 
 */
public class DeployFreeformViewport extends FreeformViewport {

	protected void readjustScrollBars() {
		if (getContents() == null)
			return;
		if (!(getContents() instanceof FreeformFigure))
			return;
		FreeformFigure ff = (FreeformFigure) getContents();
		Rectangle clientArea = getClientArea();
		Rectangle bounds = ff.getFreeformExtent().getCopy();
		bounds.union(0, 0, clientArea.width, clientArea.height);
		ff.setFreeformBounds(clientArea);

		//getVerticalRangeModel().setAll(bounds.y, clientArea.height, bounds.bottom());
		//getHorizontalRangeModel().setAll(bounds.x, clientArea.width, bounds.right());
	}

}
