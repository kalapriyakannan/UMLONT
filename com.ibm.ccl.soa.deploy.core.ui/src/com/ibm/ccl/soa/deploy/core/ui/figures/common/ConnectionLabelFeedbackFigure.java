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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;

/**
 * @author jswanke
 * 
 */
public class ConnectionLabelFeedbackFigure extends Figure {
	private final GraphicalEditPart _offscreenEditPart;
	private final EObject _figureElement;
	private String _connectionLabel;
	private Dimension _labelSize;
	private final Font _connectionLabelFont = DeployCoreUIPlugin.getDefault().getSharedFonts()
			.getFont(ISharedFonts.CONNECTION_LABEL_NAME);
	private PointList _ptList;
	private static final Cursor _cursor = new Cursor(null, SWT.CURSOR_HAND);
	private static final Color _connectionlabelcolor = new Color(null, 0, 0, 238);

	/**
	 * @param offscreenEditPart
	 * @param figureElement
	 */
	public ConnectionLabelFeedbackFigure(GraphicalEditPart offscreenEditPart, EObject figureElement) {
		_offscreenEditPart = offscreenEditPart;
		_figureElement = figureElement;
	}

	/**
	 * @param connectionLabel
	 */
	public void setFigureName(String connectionLabel) {
		_connectionLabel = connectionLabel;
		_labelSize = FigureUtilities.getTextExtents(connectionLabel, _connectionLabelFont).expand(2,
				2);
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return _labelSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Color fgd = g.getForegroundColor();
		Font font = g.getFont();
		Point pt = getBounds().getTopLeft();

		// draw a custom white background of the text itself
		g.setFont(_connectionLabelFont);
		g.setForegroundColor(ColorConstants.white);
		g.drawText(_connectionLabel, pt);
		g.drawText(_connectionLabel, pt.getTranslated(2, 2));
		g.drawText(_connectionLabel, pt.getTranslated(2, 0));
		g.drawText(_connectionLabel, pt.getTranslated(0, 2));

		// draw label
		g.setForegroundColor(_connectionlabelcolor);
		g.drawText(_connectionLabel, pt.getTranslated(1, 1));

		g.setFont(font);
		g.setForegroundColor(fgd);
	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		super.handleMousePressed(event);
		if (_offscreenEditPart != null) {
			EditPartViewer viewer = _offscreenEditPart.getViewer();
			// scroll screen to reveal part
			viewer.reveal(_offscreenEditPart);
			// select it
			viewer.select(_offscreenEditPart);
			event.consume();
		}
	}

	public Cursor getCursor() {
		return _cursor;
	}

	/**
	 * @return element this figure displays name for
	 */
	public EObject getFigureElement() {
		return _figureElement;
	}

	/**
	 * @param ptList
	 */
	public void setPointList(PointList ptList) {
		_ptList = ptList;
	}

	/**
	 * @return point list which helped to position this figure
	 */
	public PointList getPointList() {
		return _ptList;
	}

}
