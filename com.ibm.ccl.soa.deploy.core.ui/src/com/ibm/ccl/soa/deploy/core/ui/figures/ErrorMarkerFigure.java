/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployToolTipHelper;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;

/**
 * The actual error marker figure drawn on the decorator, and the source of the error tooltip.
 * 
 * @see ErrorMarkerDecorator
 * @see DeployToolTipHelper
 */
public class ErrorMarkerFigure extends DeployDecoratorFigure {

	/**
	 * error marker on a shape
	 */
	public static final int SHAPE = 0;

	private static final String NEW_LINE = "\n"; //$NON-NLS-1$
	private static final String DOT_DOT_DOT = "..."; //$NON-NLS-1$

	private String _toolTip;
	private Image _image;
	private Dimension _imageSize = new Dimension(0, 0);
	private static final Cursor cursor = new Cursor(null, SWT.CURSOR_HAND);
	private Label tooltipLabel; // = new Label(){

	/**
	 * @param status
	 * @param decoratorTarget
	 */
	public ErrorMarkerFigure(IStatus status, DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		setStatus(status, ErrorMarkerFigureFactory.getFigureImage(status));
	}

	/**
	 * @param status
	 * @param image
	 * @param decoratorTarget
	 */
	public ErrorMarkerFigure(IStatus status, Image image, DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		setStatus(status, image);
	}

	/**
	 * @param status
	 * @param image
	 */
	public void setStatus(IStatus status, Image image) {
		// don't update unless the error has changed
		String tip = getMessage(status);
		if (_toolTip == null || !tip.equals(_toolTip) || !image.equals(_image)) {
			_toolTip = tip;
			_image = image;
			_imageSize.width = _image.getBounds().width;
			_imageSize.height = _image.getBounds().height;
			_imageSize = (Dimension) MapModeUtil.getMapMode().DPtoLP(_imageSize);
			setVisible(true);
			revalidate();
			repaint();
		}
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (!visible) {
			_toolTip = null;
		}
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return _imageSize;
	}

	protected void paintFigure(Graphics graphics) {
		graphics.drawImage(_image, this.getBounds().x, this.getBounds().y);
	}

	public IFigure getToolTip() {
		if (tooltipLabel == null) {
			tooltipLabel = new Label() {
				// pad the error message 
				public Insets getInsets() {
					return new Insets(5);
				}
			};
		}
		tooltipLabel.setText(_toolTip);
		return tooltipLabel;
	}

	private String getMessage(IStatus status) {
		if (!status.isMultiStatus()) {
			return status.getMessage();
		}
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus curr = (IStatus) iter.next();
			if (!curr.isMultiStatus()) {
				if (count == 5) {
					// show first 5 messages
					buffer.append(NEW_LINE);
					buffer.append(DOT_DOT_DOT);
					break;
				}
				if (count != 0) {
					buffer.append(NEW_LINE);
				}
				count++;
				buffer.append(curr.getMessage());
			}
		}
		return buffer.toString();
	}

	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public void validate() {
		super.validate();
		if (this.getOwnerConnection() != null
				&& this.getOwnerConnection() instanceof DeployLinkConnection) {
			((DeployLinkConnection) this.getOwnerConnection()).handleOverlap(this.getBounds());
		}
	}

}
