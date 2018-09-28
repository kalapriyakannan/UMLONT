/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * jswanke
 */
public class CreationFeedbackTooltip extends Figure {
	public static final int TYPE_SUCCESS = 0;

	public static final int TYPE_ERROR = 1;

	private final Font _font;
	private List<String> _toolTips = null;
	private final Dimension _tipSize = new Dimension(0, 0);
	private int lineHeight;
	private int _type;

	private final EditPart _host;

	/**
	 * @param host
	 */
	public CreationFeedbackTooltip(EditPart host) {
		super();
		_font = JFaceResources.getDefaultFont();
		_host = host;
		setVisible(false);
	}

	/**
	 * @param toolTips
	 * @param type
	 */
	public void setTooltips(List<String> toolTips, int type) {
		_toolTips = toolTips;
		_type = type;

		boolean isVisible = _toolTips.size() > 0;
		setVisible(isVisible);

		lineHeight = 0;
		_tipSize.height = _tipSize.width = 0;
		if (isVisible) {
			for (String tip : _toolTips) {
				Dimension size = FigureUtilities.getTextExtents(tip, _font);
				if (size.width > _tipSize.width) {
					_tipSize.width = size.width;
				}
				lineHeight = size.height + 2;
				_tipSize.height += lineHeight;
			}
			setPosition(getLocation());
			setSize(calculatePreferredSize());
		}
		repaint();
	}

	/**
	 * @param p
	 */
	public void setPosition(Point p) {
		IFigure figure = LayerManager.Helper.find(_host).getLayer(LayerConstants.SCALABLE_LAYERS);
		PrecisionPoint d = new PrecisionPoint(0, 0);
		figure.translateToRelative(d);
		Dimension siz = calculatePreferredSize();
		Rectangle r = _host.getViewer().getControl().getBounds();
		r.width += d.x - 15;
		r.height += d.y - 15;

		p.translate(0, -(siz.height / 2) - 2);
		if (p.x + siz.width > r.width) {
			p.x = r.width - siz.width - 2;
		}
		if (p.y + siz.height > r.height) {
			p.y = r.height - siz.height - 2;
		}
		if (p.x < r.x) {
			p.x = r.x + 2;
		}
		if (p.y < r.y) {
			p.y = r.y + 2;
		}
		setLocation(p);
	}

	/**
	 * @return Dimension
	 */
	public Dimension calculatePreferredSize() {
		Dimension size = _tipSize.getCopy();
		size.expand(getImage().getImageData().width, 0);
		return size.expand(12, 12);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintClientArea(org.eclipse.draw2d.Graphics)
	 */
	protected void paintClientArea(Graphics g) {
		Image image = getImage();
		Point p = getBounds().getLeft().getTranslated(4, -image.getImageData().height / 2);
		g.drawImage(image, p);

		p = getBounds().getTopLeft().getTranslated(image.getImageData().width + 6, 6);
		for (String tip : _toolTips) {
			g.drawText(tip, p);
			p.translate(0, lineHeight);
		}
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

		graphics.setForegroundColor(DeployColorConstants.colorBlueForStroke);
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

		graphics.setBackgroundColor(DeployColorConstants.colorBlueForFill);
		graphics.fillRoundRectangle(getBounds().getCropped(new Insets(0, 0, 1, 1)), 10, 10);

		graphics.setBackgroundColor(background);
		graphics.setForegroundColor(foreground);
	}

	protected Image getImage() {
		if (_type == TYPE_ERROR) {
			return DeployCoreImages.ICON_ERROR_CIRCLE;
		}
		return DeployCoreImages.ICON_SUCCESS_CIRCLE;
	}

}
