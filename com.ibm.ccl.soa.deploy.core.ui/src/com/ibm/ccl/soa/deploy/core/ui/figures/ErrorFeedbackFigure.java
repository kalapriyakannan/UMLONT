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
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * 
 * Created on Oct 20, 2004
 * 
 * @author tonychau
 * 
 */
public class ErrorFeedbackFigure extends Figure {

	private static final String copyright = "Licensed Material - Property of IBM " + " 5724-I66 " + "(C) Copyright IBM Corporation 2005 - All Rights Reserved. " + "Note to U.S. Government Users Restricted Rights - Use, duplication or disclosure " + "restricted by GSA ADP Schedule Contract with IBM Corp.".intern(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	public static final int TYPE_SUCCESS = 0;

	public static final int TYPE_ERROR = 1;

	public static final int TYPE_SEARCH = 2;

	public static final int TYPE_CREATE = 3;

	private String fText;

	private int fType;

	private final Font fFont;

	/**
	 * @param text
	 */
	public ErrorFeedbackFigure(int type, String text) {
		super();

		fText = text;

		fType = type;

		fFont = JFaceResources.getDefaultFont();
	}

	/**
	 * @return Dimension
	 */
	public Dimension calculatePreferredSize() {

		if (fText == null) {
			fText = ""; //$NON-NLS-1$
		}

		Dimension size = FigureUtilities.getTextExtents(fText, fFont);
		size.expand(getImage().getImageData().width, 0);
		return size.expand(12, 12);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintClientArea(org.eclipse.draw2d.Graphics)
	 */
	protected void paintClientArea(Graphics g) {
		Point p = getBounds().getLeft().getTranslated(4, 0);
		g.drawImage(getImage(), p.getTranslated(0, -getImage().getImageData().height / 2));

		p = p.getTranslated(getImage().getImageData().width + 2, 0);
		Dimension textSize = FigureUtilities.getTextExtents(fText, fFont);
		g.drawText(fText, p.getTranslated(0, -textSize.height / 2));
		paintChildren(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintBorder(Graphics graphics) {
		Color background = graphics.getBackgroundColor();
		Color foreground = graphics.getForegroundColor();

		graphics.setForegroundColor(getOutlineColor());
		graphics.drawRoundRectangle(getBounds().getCropped(new Insets(0, 0, 2, 2)), 10, 10);

		graphics.setBackgroundColor(background);
		graphics.setForegroundColor(foreground);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		Color background = graphics.getBackgroundColor();
		Color foreground = graphics.getForegroundColor();

		graphics.setBackgroundColor(DeployColorConstants.gray);
		graphics.fillRoundRectangle(getBounds().getCropped(new Insets(1, 1, 0, 0)), 10, 10);

		graphics.setBackgroundColor(getFillColor());
		graphics.fillRoundRectangle(getBounds().getCropped(new Insets(0, 0, 1, 1)), 10, 10);

		graphics.setBackgroundColor(background);
		graphics.setForegroundColor(foreground);
	}

	protected Image getImage() {
		switch (fType)
		{
		case TYPE_SUCCESS:
			return DeployCoreImages.ICON_SUCCESS_CIRCLE;
		case TYPE_ERROR:
			return DeployCoreImages.ICON_ERROR_CIRCLE;
		case TYPE_SEARCH:
			return DeployCoreImages.ICON_SEARCH_CIRCLE;
		case TYPE_CREATE:
			return DeployCoreImages.ICON_CREATE_CIRCLE;

		}

		throw new IllegalArgumentException();
	}

	protected Color getFillColor() {
		return DeployColorConstants.colorBlueForFill;
	}

	protected Color getOutlineColor() {
		return DeployColorConstants.colorBlueForStroke;
	}

	public void setText(String text) {
		fText = text;
		setSize(calculatePreferredSize());
		repaint();
	}

	public void setType(int type) {
		fType = type;
		setSize(calculatePreferredSize());
		repaint();
	}
}
