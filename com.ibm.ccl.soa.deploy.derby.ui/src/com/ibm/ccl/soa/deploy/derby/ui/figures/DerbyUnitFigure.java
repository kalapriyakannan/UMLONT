/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.derby.ui.figures;

import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;

/**
 * This Figure represents a Rounded Rectangle Figure
 */
public class DerbyUnitFigure extends DeployCoreFigure {

	/**
	 * Constructor for LtmNodeFigure.
	 */

	public DerbyUnitFigure() {
	}

	/**
	 * Draw the state object.
	 * 
	 * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics g) {
		paintDeployDatabase(g);
	}
}
