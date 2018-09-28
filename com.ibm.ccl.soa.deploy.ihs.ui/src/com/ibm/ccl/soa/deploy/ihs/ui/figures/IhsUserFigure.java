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
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsUserEditPart;

/**
 * This Figure represents an IhsUserUnit.
 * 
 * @see IhsUserEditPart
 * @see IhsUserUnit
 */
public class IhsUserFigure extends DeployCoreFigure {

	/**
	 * Constructor for IhsUserFigure.
	 */

	public IhsUserFigure() {
		setLayoutManager(new DelegatingLayout());
	}

	@Override
	protected void paintFigure(Graphics g) {
		paintDeployOS(g);
	}
}
