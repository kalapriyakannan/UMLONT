/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

public class ToolTipFigure extends Label {

	Image bgImage = null;
	Dimension minSize = null;

	public ToolTipFigure(String string) {
		super(string);
	}

	public Image getBgImage() {
		return bgImage;
	}

	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	public void setMinimumSize(Dimension minSize) {
		this.minSize = minSize;
	}

	// make sure tool tip isn't too small
	public Dimension getPreferredSize(int arg0, int arg1) {
		Dimension d = getTextSize();
		if (minSize != null) {
			if (d.width < minSize.width)
				d.width = minSize.width;
			if (d.height < minSize.height)
				d.height = minSize.height;
		}
		return d;
	}

	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Rectangle bounds = getBounds();
		graphics.setBackgroundColor(DeployColorConstants.tooltipColor);
		graphics.fillRectangle(getBounds());
		graphics.translate(bounds.x, bounds.y);
//		org.eclipse.swt.graphics.Rectangle	imgRect = bgImage.getBounds();
//		graphics.drawImage(bgImage, 0, 0, imgRect.width, imgRect.height, 
//				0,0, bounds.width, bounds.height );
		graphics.drawText(getSubStringText(), getTextLocation());
		graphics.translate(-bounds.x, -bounds.y);
	}

}
