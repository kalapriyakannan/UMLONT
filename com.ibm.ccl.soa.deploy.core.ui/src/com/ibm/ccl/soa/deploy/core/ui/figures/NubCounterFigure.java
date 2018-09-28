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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * @see InstalledResourceDecorator
 */
public class NubCounterFigure extends DeployDecoratorFigure {

	private final Label tooltipLabel = new Label();
	private String count = "0"; //$NON-NLS-1$
	private Dimension countSz;
	private final boolean isCapability;
	private static final Cursor cursor = new Cursor(null, SWT.CURSOR_HAND);
	private final Dimension _imageSize = new Dimension(0, 0);

	static private Font countFont = new Font(null, new FontData("Tahoma", 7, SWT.NORMAL));//$NON-NLS-1$

	/**
	 * @param dmo
	 * @param isCapability
	 * @param decoratorTarget
	 */
	public NubCounterFigure(DeployModelObject dmo, boolean isCapability,
			DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		this.isCapability = isCapability;
		setCount(dmo);
	}

	/**
	 * @param deployObject
	 */
	public void setCount(DeployModelObject dmo) {
		// add service/reference names to tooltip and count for figure
		int count = 0, height = 0, width = 0;
		String tooltip = ""; //$NON-NLS-1$
		if (dmo instanceof Unit) {
			if (isCapability) {
				List temp = ((Unit) dmo).getCapabilities();
				for (Iterator it = temp.iterator(); it.hasNext();) {
					Object o = it.next();
					if (o instanceof Capability) {
						count++;
					}
				}
				tooltip = NLS.bind(Messages.CLICK_TO_EDIT_CAPABILTIES, count);
				width = 17;
				height = 12;
			} else {
				List temp = ((Unit) dmo).getRequirements();
				for (Iterator it = temp.iterator(); it.hasNext();) {
					Object o = it.next();
					if (o instanceof Requirement) {
						count++;
					}
				}
				tooltip = NLS.bind(Messages.CLICK_TO_EDIT_REQUIREMENTS, count);
				width = 14;
				height = 12;
			}
			this.count = Integer.toString(count);
			countSz = (Dimension) MapModeUtil.getMapMode().DPtoLP(
					org.eclipse.draw2d.FigureUtilities.getStringExtents(this.count, countFont));
		}
		if (!tooltipLabel.getText().equals(tooltip)) {
			tooltipLabel.setText(tooltip);
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

	protected void paintFigure(Graphics g) {
		// paint icon
		Rectangle r = getBounds();
		Image img = isCapability ? DeployCoreImages.CAPABILITY_IMAGE
				: DeployCoreImages.REQUIREMENT_IMAGE;
		org.eclipse.swt.graphics.Rectangle imgRect = img.getBounds();
		g.drawImage(img, 0, 0, imgRect.width, imgRect.height, r.x, r.y, r.width, r.height);

		// paint counter text		
		g.setForegroundColor(ColorConstants.black);
		g.setFont(countFont);
		Point pt = getBounds().getCenter();
		if (pt != null) {
			pt = pt.getTranslated(-countSz.width / 2, -countSz.height / 2);
			g.drawString(count, pt);
		}
	}

	@Override
	public void handleMousePressed(MouseEvent event) {
		super.handleMousePressed(event);
		if (!getOwnerFigure().isFaded()) {
			event.consume();
		}
	}

	public IFigure getToolTip() {
		return tooltipLabel;
	}

	public Cursor getCursor() {
		return cursor;
	}
}
