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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * @author sshaw
 * @canBeSeenBy org.eclipse.gmf.runtime.diagram.ui.*
 * 
 * Figure used to represent the collapse handle in the corner of a list compartment or shape
 * compartment.
 */
public class DeployCollapseFigure extends DeployDecoratorFigure {

	private boolean useTreeEmultation = false;
	private boolean collapsed = false;
	private final Dimension _imageSize = new Dimension(MapModeUtil.getMapMode().DPtoLP(12),
			MapModeUtil.getMapMode().DPtoLP(12));

	/**
	 * @param useTreeEmulation
	 * @param decoratorTarget
	 */
	public DeployCollapseFigure(boolean useTreeEmulation, DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		useTreeEmultation = useTreeEmulation;
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return _imageSize;
	}

	protected void paintFigure(Graphics graphics) {
		Image img;

		if (useTreeEmultation) {
			if (isCollapsed()) {
				img = DeployCoreImages.IMAGE_PLUS_SIGN;
			} else {
				img = DeployCoreImages.IMAGE_MINUS_SIGN;
			}
		} else {
			if (isCollapsed()) {
				img = DeployCoreImages.IMAGE_COLLAPSED_HOSTLIST;
			} else {
				img = DeployCoreImages.IMAGE_EXPANDED_HOSTLIST;
			}
		}
		graphics.drawImage(img, getBounds().x, getBounds().y);
	}

	/**
	 * isCollapsed Utility method to determine if the IFigure is collapse or not.
	 * 
	 * @return true if collapse, false otherwise.
	 */
	public boolean isCollapsed() {
		return collapsed;
	}

	/**
	 * setCollapsed Setter method to change collapsed state of the figure. Will force update to
	 * repaint the figure to reflect the changes.
	 * 
	 * @param b
	 *           boolean true to set collapsed, false to uncollapse.
	 */
	public void setCollapsed(boolean b) {
		if (collapsed != b) {
			collapsed = b;
			revalidate();
			repaint();
		}
	}

}
