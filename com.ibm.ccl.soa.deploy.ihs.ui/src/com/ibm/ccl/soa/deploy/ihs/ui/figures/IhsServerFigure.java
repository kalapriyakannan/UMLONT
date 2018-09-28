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
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsServerEditPart;

/**
 * This Figure represents a IhsServerUnit.
 * 
 * @see IhsServerEditPart
 * @see IhsServerUnit
 */
public class IhsServerFigure extends DeployCoreFigure {

	/**
	 * Constructor for IhsServerFigure.
	 */

	public IhsServerFigure() {
		setLayoutManager(new DelegatingLayout());
	}

	@Override
	protected void paintFigure(Graphics g) {
		paintDeployServer(g);
	}
}
