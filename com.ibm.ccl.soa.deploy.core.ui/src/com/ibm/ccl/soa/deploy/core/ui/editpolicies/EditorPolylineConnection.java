/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * 
 * A polyline with an arrow Used by LinkGraphicalNodeEditPolicy to create
 * 
 * @author tonychau
 * 
 */
public class EditorPolylineConnection extends PolylineConnectionFix {
	/** Source (Horizontal) */
	public static final Integer SOURCE = new Integer(ConnectionLocator.SOURCE);
	/** Middle: a bit-wise OR of {@link #NORTH} and {@link #EAST} */
	public static final Integer MIDDLE = new Integer(ConnectionLocator.MIDDLE);
	/** Target: a bit-wise OR of {@link #NORTH} and {@link #WEST} */
	public static final Integer TARGET = new Integer(ConnectionLocator.TARGET);

	protected static final int DEFAULT_ENDPOINT_SIZE = 1;

	protected static final int DEFAULT_LINE_WIDTH = 1;

	protected Image image;

	protected Map decorationMap;

	/**
	 * 
	 */
	public EditorPolylineConnection() {
		super();
		setLineWidth(DEFAULT_LINE_WIDTH);
		setForegroundColor(DeployColorConstants.gray);
		decorationMap = new WeakHashMap();
	}

	/**
	 * @param color
	 * @param image
	 */
	public EditorPolylineConnection(Color color, Image image) {
		this();
		setForegroundColor(color);
		if (image != null) {
			this.image = image;
			setLineWidth(image.getImageData().height);
		}
	}

	protected void outlineShape(Graphics g) {
		if (DeployColorConstants.hostingLinkColor.equals(getForegroundColor()))
			g.setLineWidth(2);
		else if (DeployColorConstants.realizationLinkInner.equals(getForegroundColor()))
			g.setLineWidth(1);
		else
			g.setLineWidth(1);
		g.setForegroundColor(getForegroundColor());
		g.drawPolyline(getPoints());

		Point p;
		if (image != null) {
			p = getPoints().getPoint(Point.SINGLETON, getPoints().size() - 1);
			p = p.getTranslated(-image.getImageData().width + 1, -image.getImageData().height / 2);
			g.drawImage(image, p);
		}
	}

	/**
	 * @param decoration
	 * @param alignment
	 */
	public void addDecoration(Image decoration, Integer alignment) {
		IFigure figure = (IFigure) decorationMap.get(alignment);
		if (figure instanceof ImageFigure && decoration.equals(((ImageFigure) figure).getImage()))
			return;

		addDecoration(new ImageFigure(decoration), alignment);
	}

	/**
	 * @param decoration
	 * @param alignment
	 */
	public void addDecoration(IFigure decoration, Integer alignment) {
		if (decoration.equals(decorationMap.get(alignment)))
			return;
		if (decorationMap.get(alignment) != null)
			removeDecoration(alignment);
		decorationMap.put(alignment, decoration);
		add(decoration, new ConnectionLocator(this, alignment.intValue()));
	}

	/**
	 * @param alignment
	 */
	public void removeDecoration(Integer alignment) {
		if (decorationMap.get(alignment) != null) {
			remove((IFigure) decorationMap.get(alignment));
			decorationMap.remove(alignment);
		}
	}
}
