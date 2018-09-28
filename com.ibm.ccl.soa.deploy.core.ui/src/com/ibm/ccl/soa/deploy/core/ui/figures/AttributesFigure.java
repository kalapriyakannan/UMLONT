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
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.dialogs.AttributesDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployGraphicalViewer;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @since 7.0
 * 
 */
public class AttributesFigure extends DeployDecoratorFigure {

	private static final Cursor cursor = new Cursor(null, SWT.CURSOR_HAND);
	private DeployShapeNodeEditPart ownerEP = null;
	private boolean isNonMutable;

	private static final String NEW_LINE = "\n"; //$NON-NLS-1$
	private final Label tooltipLabel = new Label() {
		public Insets getInsets() {
			return new Insets(5);
		}
	};
	private List _attributeList = null;
	private final Dimension _imageSize = new Dimension(0, 0);

	/**
	 * needed to create AttributeIcon from outside
	 */
	public AttributesFigure() {
		super(null);
	}

	/**
	 * @author jswanke
	 * 
	 */
	public static class AttributeIcon {
		private final Image image;
		private final String tooltip;

		/**
		 * @param image
		 * @param tooltip
		 */
		public AttributeIcon(Image image, String tooltip) {
			super();
			this.image = image;
			this.tooltip = tooltip;
		}

		/**
		 * @return attribute image
		 */
		public Image getImage() {
			return image;
		}

		/**
		 * @return attribute tooltip
		 */
		public String getTooltip() {
			return tooltip;
		}
	}

	/**
	 * @param attributesList
	 * @param decoratorTarget
	 */
	public AttributesFigure(List attributesList, DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		ownerEP = (DeployShapeNodeEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
		setList(attributesList);
		isNonMutable = GMFUtils.isNonMutableImport(ownerEP);
	}

	/**
	 * @param attributesList
	 */
	public void setList(List<AttributeIcon> attributesList) {
		_attributeList = attributesList;
		StringBuffer buffer = new StringBuffer();
		//Don't show Attributes message
		//buffer.append(Messages.AttributesThisFigure);
		//buffer.append(NEW_LINE);
		int width = 0, height = 0;
		for (Iterator it = _attributeList.iterator(); it.hasNext();) {
			AttributeIcon attr = (AttributeIcon) it.next();
			buffer.append("   " + attr.getTooltip()); //$NON-NLS-1$
			if (it.hasNext()) {
				buffer.append(NEW_LINE);
			}
			Rectangle rect = attr.getImage().getBounds();
			if (rect.height > height) {
				height = rect.height;
			}
			width += rect.width;
		}
		String tooltip = buffer.toString();
		if (!tooltipLabel.getText().equals(tooltip)) {
			tooltipLabel.setText(tooltip);
			setToolTip(tooltipLabel);
			_imageSize.width = MapModeUtil.getMapMode().DPtoLP(width);
			_imageSize.height = MapModeUtil.getMapMode().DPtoLP(height);
			setVisible(true);
			revalidate();
			repaint();
		}
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return _imageSize;
	}

	protected void paintFigure(Graphics graphics) {
		Point pt = getBounds().getTopLeft();
		for (Iterator it = _attributeList.iterator(); it.hasNext();) {
			AttributeIcon attr = (AttributeIcon) it.next();
			Image image = attr.getImage();
			Rectangle rect = image.getBounds();
			graphics.drawImage(image, pt);
			pt.x += MapModeUtil.getMapMode().DPtoLP(rect.width);
		}
	}

	public Cursor getCursor() {
		if (!ownerEP.isDragInProgress() && !isNonMutable) {
			return cursor;
		}
		return super.getCursor();
	}

	@Override
	public boolean handleButtonUp(int button) {
		// ignore all but left button
		if (button != 1) {
			return false;
		}

		// ignore if highlight has yet been created on figure (to avoid random clicks)
		if (getOwnerFigure() instanceof CompositeShapeFigure) {
			if (!((CompositeShapeFigure) getOwnerFigure()).isEnableDecoratorButton()) {
				return true;
			}
		}

		// kill tooltips
		setToolTip(null);
		((DeployGraphicalViewer) ownerEP.getViewer()).closeToolTip();

		if (isNonMutable) {
			return true;
		}

		// calc dialog location
		Point p = new Point(getBounds().getBottomLeft());
		translateToAbsolute(p);
		org.eclipse.swt.graphics.Point loc = p.getSWTPoint();
		final org.eclipse.swt.graphics.Point pt = Display.getCurrent().map(
				ownerEP.getViewer().getControl(), null, loc);

		// open dialog
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				AttributesDialog cd = new AttributesDialog(Display.getCurrent().getShells()[0],
						ownerEP, pt);
				cd.open();
			}
		});
		return true;
	}

}
