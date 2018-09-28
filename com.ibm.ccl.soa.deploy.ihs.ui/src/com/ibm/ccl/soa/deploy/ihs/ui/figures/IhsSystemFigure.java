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

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Graphics;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsSystemEditPart;

/**
 * This Figure represents a IhsSystemUnit.
 * 
 * @see IhsSystemEditPart
 * @see IhsSystemUnit
 */
public class IhsSystemFigure extends DeployCoreFigure {

	/**
	 * Constructor for IhsSystemFigure.
	 */

	public IhsSystemFigure() {
		setLayoutManager(new DelegatingLayout());
	}

	@Override
	protected void paintFigure(Graphics g) {
		paintDeployApplication(g);
	}
}
