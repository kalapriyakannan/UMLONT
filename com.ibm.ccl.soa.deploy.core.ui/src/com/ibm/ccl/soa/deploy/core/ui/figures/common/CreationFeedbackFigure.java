/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;

/**
 * @author jswanke
 * 
 */
public class CreationFeedbackFigure extends Shape {
	Image _image = null;
	Dimension _imageSize;
	Point _nameOffset = null;
	String _feedbackName = null;
	Point _feedbackPoint;
	Rectangle _feedbackBounds = null;
	Dimension _feedbackSize = null;
	int _trueWidth;

	final EditPart _host;

	Dimension _feedbackMultiSize = new Dimension();

	private CreationFeedbackTooltip _tooltip = null;

	float _pointerXOffset;
	float _pointerYOffset;

	boolean _drawInterior = true;
	private final boolean _drawName;
	boolean _isMultiElement = false;

	private Color _backgroundColor;
	private Color _foregroundColor;

	private final Font _feedbackFont = DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
			ISharedFonts.FEEDBACK_FIG_NAME);

	/**
	 * @param host
	 * @param pointerXOffset
	 * @param pointerYOffset
	 * @param image
	 * @param imageSize
	 * @param feedbackName
	 * @param drawInterior
	 * @param drawName
	 * @param isMultiElement
	 */
	public CreationFeedbackFigure(EditPart host, float pointerXOffset, float pointerYOffset,
			Image image, Dimension imageSize, String feedbackName, boolean drawInterior,
			boolean drawName, boolean isMultiElement) {
		super();
		_host = host;
		_pointerXOffset = pointerXOffset;
		_pointerYOffset = pointerYOffset;
		_image = image;
		_imageSize = imageSize;
		_feedbackName = feedbackName;
		_drawInterior = drawInterior;
		_drawName = drawName;
		_isMultiElement = isMultiElement;
		setOpaque(false);
	}

	@Override
	public void addNotify() {
		IFigure feedbackLayer = getParent();
		if (_tooltip == null) {
			_tooltip = new CreationFeedbackTooltip(_host);
			feedbackLayer.add(_tooltip);
		}
		super.addNotify();
	}

	@Override
	public void removeNotify() {
		IFigure feedbackLayer = getParent();
		if (_tooltip != null) {
			feedbackLayer.remove(_tooltip);
			_tooltip = null;
		}
		super.removeNotify();
	}

	/**
	 * @param feedbackBounds
	 * @param foregroundColor
	 * @param backgroundColor
	 */
	public void presetFeedbackParameters(Rectangle feedbackBounds, Color foregroundColor,
			Color backgroundColor) {
		_feedbackBounds = feedbackBounds;
		_foregroundColor = foregroundColor;
		_backgroundColor = backgroundColor;
	}

	/**
	 * @param nameOffset
	 * @param feedbackSize
	 * @param tip
	 * @param isIllegal
	 */
	public void setFeedbackParameters(Point nameOffset, Dimension feedbackSize, String tip,
			boolean isIllegal) {
		_nameOffset = nameOffset;

		List<String> tips = new ArrayList<String>();
		if (tip != null) {
			tips.add(tip);
		}
		_feedbackSize = feedbackSize;

		// calculate the size of the figure	
		Dimension size = feedbackSize.getCopy();
		_trueWidth = FigureUtilities.getTextExtents(_feedbackName, _feedbackFont).width
				+ (_nameOffset.x + _imageSize.width + 3) * 2;
		if (size.width < _trueWidth) {
			size.width = _trueWidth;
			if (_trueWidth > _feedbackSize.width * 3 / 2) {
				_trueWidth = _feedbackSize.width * 3 / 2 - 5;
			}
		}

		// with the size, now calculate the offset between the mouse cursor and the top/left corner of the figure
		Point point = new Point(_feedbackBounds.x, _feedbackBounds.y);
		Dimension offset = size.getCopy().getNegated().scale(_pointerXOffset, _pointerYOffset);
		point.translate(offset);

		// make sure it stays in viewer
		org.eclipse.swt.graphics.Rectangle r = _host.getViewer().getControl().getBounds();
		r.width -= 15;
		r.height -= 15;
		if (point.x + size.width + 2 > r.width) {
			point.x = r.width - size.width - 2;
		}
		if (point.y + size.height + 2 > r.height) {
			point.y = r.height - size.height - 2;
		}
		if (point.x < 0) {
			point.x = 0;
		}
		if (point.y < 0) {
			point.y = 0;
		}

		Point pt = new Point(point);
		translateToRelative(pt);

		// set the figure bounds
		_feedbackBounds = new Rectangle(pt, size);
		_tooltip.setPosition(_feedbackBounds.getTopLeft());
		_tooltip.setTooltips(tips, isIllegal ? CreationFeedbackTooltip.TYPE_ERROR
				: CreationFeedbackTooltip.TYPE_SUCCESS);

		calcMultiElementSize();

		super.setBounds(new Rectangle(pt, size));
		_feedbackPoint = point;
	}

	@Override
	public void setBounds(Rectangle rect) {
		// used to do multi element creation
		_feedbackBounds = rect;
		calcMultiElementSize();
		Rectangle r = rect.getCopy();
		r.setSize(_feedbackMultiSize.width * _feedbackSize.width * 3 / 2, _feedbackMultiSize.height
				* _feedbackSize.height * 3 / 2);
		if (r.equals(getBounds())) {
			invalidate();
			repaint();
		} else {
			super.setBounds(r);
		}
	}

	private void calcMultiElementSize() {
		Rectangle r = _feedbackBounds.getCopy();
		int maxX = r.getRight().x;
		int maxY = r.getBottom().y;
		r.setSize(_feedbackSize);
		int cols = 0;
		int rows = 0;
		do {
			cols = 0;
			do {
				r.x += _feedbackSize.width * 3 / 2;
				cols++;
			} while (r.x < maxX);
			r.x = _feedbackBounds.x;
			r.y += _feedbackSize.height * 3 / 2;
			rows++;
		} while (r.y < maxY);
		_feedbackMultiSize.width = cols;
		_feedbackMultiSize.height = rows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics g) {

		if (_drawInterior) {
			if (!_isMultiElement) {
				fillShapeHelper(g, _feedbackBounds);
			} else {
				Rectangle r = _feedbackBounds.getCopy();
				r.height = _feedbackSize.height;
				r.width = _trueWidth;
				for (int row = 0; row < _feedbackMultiSize.height; row++) {
					for (int col = 0; col < _feedbackMultiSize.width; col++) {
						fillShapeHelper(g, r);
						r.x += _feedbackSize.width * 3 / 2;
					}
					r.x = _feedbackBounds.x;
					r.y += _feedbackSize.height * 3 / 2;
				}
			}
		}
	}

	private void fillShapeHelper(Graphics g, Rectangle r) {
		if (_drawName) {
			if (_image != null) {
				org.eclipse.swt.graphics.Rectangle imgRect = _image.getBounds();
				g.drawImage(_image, 0, 0, imgRect.width, imgRect.height, r.x + _nameOffset.x, r.y
						+ _nameOffset.y, _imageSize.width, _imageSize.height);
			}
			if (_feedbackName != null && _feedbackName.length() > 0) {
				g.setFont(_feedbackFont);
				g.drawText(_feedbackName, r.x + _nameOffset.x + _imageSize.width + 3, r.y
						+ _nameOffset.y);
			}
		}
		// if image is null, we draw a feedback rect
		boolean xor = g.getXORMode();
		g.setXORMode(true);
		g.setBackgroundColor(_backgroundColor);
		g.fillRectangle(r);
		g.setXORMode(xor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	protected void outlineShape(Graphics g) {
		if (!_isMultiElement) {
			outlineShapeHelper(g, _feedbackBounds.getCopy());
		} else {
			// drag outline
			g.setLineStyle(Graphics.LINE_DASHDOT);
			g.setForegroundColor(ColorConstants.lightGray);
			g.drawRectangle(_feedbackBounds.getCopy().shrink(1, 1));

			// then drag individual elements
			Rectangle r = _feedbackBounds.getCopy();
			r.height = _feedbackSize.height;
			r.width = _trueWidth;
			for (int row = 0; row < _feedbackMultiSize.height; row++) {
				for (int col = 0; col < _feedbackMultiSize.width; col++) {
					outlineShapeHelper(g, r.getCopy());
					r.x += _feedbackSize.width * 3 / 2;
				}
				r.x = _feedbackBounds.x;
				r.y += _feedbackSize.height * 3 / 2;
			}

		}
	}

	private void outlineShapeHelper(Graphics g, Rectangle r) {
		r.shrink(1, 1);
		boolean x = g.getXORMode();
		g.setXORMode(_drawInterior);
		g.setForegroundColor(_foregroundColor);
		g.setLineStyle(Graphics.LINE_DOT);
		g.drawRectangle(r);
		g.setXORMode(x);
	}

	/**
	 * @param image
	 */
	public void setImage(Image image) {
		_image = image;
	}

	/**
	 * @return feedback point
	 */
	public Point getFeedbackPoint() {
		return _feedbackPoint;
	}

	/**
	 * @param offset --
	 *           the X offset that the mouse cursor will appear from the top/left corner of the
	 *           feedback figure
	 */
	public void setPointerXOffset(float offset) {
		_pointerXOffset = offset;
	}

	/**
	 * @param offset --
	 *           the Y offset that the mouse cursor will appear from the top/left corner of the
	 *           feedback figure
	 */
	public void setPointerYOffset(float offset) {
		_pointerYOffset = offset;
	}

	/**
	 * @return a Dimension where width==columns and height ==rows when creating multiple elements
	 */
	public Dimension getFeedbackMultiSize() {
		return _feedbackMultiSize;
	}

}
