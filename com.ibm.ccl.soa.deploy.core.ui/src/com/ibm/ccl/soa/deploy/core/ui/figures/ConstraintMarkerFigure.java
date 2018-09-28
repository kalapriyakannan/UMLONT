/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;

/**
 * @see ErrorMarkerDecorator
 */
public class ConstraintMarkerFigure extends Figure {

	private static final Cursor cursor = new Cursor(null, SWT.CURSOR_HAND);
	private Label tooltipLabel = new Label();
	private static Image logicalImg = DeployCoreUIPlugin.getImageDescriptor(
			"icons/obj16/logical_obj.gif").createImage(); //$NON-NLS-1$

	/**
	 * @param status
	 * @param smallFigure
	 */
	public ConstraintMarkerFigure() {
		tooltipLabel.setText("This is a Constraint Link"); //$NON-NLS-1$
		Rectangle rect = logicalImg.getBounds();
		int width = MapModeUtil.getMapMode().DPtoLP(rect.width);
		int height = MapModeUtil.getMapMode().DPtoLP(rect.height);
		setSize(new Dimension(width, height));
		setMaximumSize(new Dimension(rect.width, rect.height));
	}

	protected void paintFigure(Graphics graphics) {
		graphics.drawImage(logicalImg, this.getBounds().x, this.getBounds().y);
	}

	public IFigure getToolTip() {
		return tooltipLabel;
	}

	public Cursor getCursor() {
		return cursor;
	}
}
