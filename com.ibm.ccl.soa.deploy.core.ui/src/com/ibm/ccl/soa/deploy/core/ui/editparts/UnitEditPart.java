/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigureFactory;

/**
 * Base class of a Unit.
 */
public class UnitEditPart extends TopologyEditPart {

	/**
	 * @param view
	 */
	public UnitEditPart(View view) {
		super(view);
		setCategory("Unit");//$NON-NLS-1$
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DeployCoreFigureFactory.createNewUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

}
