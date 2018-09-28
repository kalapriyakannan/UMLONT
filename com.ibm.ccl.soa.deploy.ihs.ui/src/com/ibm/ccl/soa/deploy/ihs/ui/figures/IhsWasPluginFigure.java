/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ihs.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;

/**
 * This Figure represents a IhsWasPluginUnit.
 * 
 * @see IhsWasPluginEditPart
 * @see IhsWasPluginUnit
 */
public class IhsWasPluginFigure extends DeployCoreFigure {

	/**
	 * Constructor for IhsWasPluginFigure.
	 */

	public IhsWasPluginFigure() {
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void paintFigure(Graphics g) {
		paintDeployApplication(g);
	}
}
