/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.DecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @author jswanke
 * 
 */
public class DeployDecoratorFigure extends DecoratorFigure {

	/**
	 * @param decoratorTarget
	 */
	public DeployDecoratorFigure(DecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#handleMousePressed(org.eclipse.draw2d.MouseEvent)
	 */
	public void handleMousePressed(MouseEvent event) {
		if (isDecorationVisible()) {
			super.handleMousePressed(event);
			if (getOwnerFigure() != null && !getOwnerFigure().isFaded() && event.button == 1) {
				event.consume();
			}
		}
	}

	public void paint(Graphics g) {
		if (isDecorationVisible()) {
			// fade decoration based on whether the owner figure/link is also faded
			int alpha = 255;
			if (getOwnerFigure() != null) {
				alpha = getOwnerFigure().isFaded() ? DeployCoreConstants.SELECTION_FADE : 255;
			} else if (getOwnerConnection() != null) {
				alpha = ((DeployLinkConnection) getOwnerConnection()).isFaded() ? DeployCoreConstants.SELECTION_FADE
						: 255;
			}
			if (alpha != 255) {
				g.setAlpha(alpha);
			}
			super.paint(g);
		}
	}

	/**
	 * called by tracker which steals mouse button up when clicking on a decorator
	 * 
	 * @param button
	 */
	public boolean handleButtonUp(int button) {
		return false;
	}

	protected boolean isDecorationVisible() {
		if (getOwnerConnection() instanceof DeployLinkConnection) {
			DeployLinkConnection link = (DeployLinkConnection) getOwnerConnection();
			Rectangle clipRect = link.getParentClientArea();
			if (clipRect != null) {
				Rectangle rect = this.getBounds();
				if (!clipRect.contains(rect)) {
					return false;
				}
			}
		}
		return super.isDecorationVisible();
	}

}
