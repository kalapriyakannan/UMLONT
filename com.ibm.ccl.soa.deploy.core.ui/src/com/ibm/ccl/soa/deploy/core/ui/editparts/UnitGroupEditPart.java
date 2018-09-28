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

import com.ibm.ccl.soa.deploy.core.ui.figures.UnitGroupFigure;

/**
 * Controls the interactions between the figure and its underlying view
 */
public class UnitGroupEditPart extends TopologyEditPart {

	/**
	 * Constructor - Create an EditPart for a given model object (View)
	 * 
	 * @param shapeView
	 *           model object that represents the associated figure
	 */
	public UnitGroupEditPart(View shapeView) {
		super(shapeView);
		setCategory("Group");//$NON-NLS-1$
	}

	/**
	 * @return Figure representing the unit collection.
	 */
	protected NodeFigure createMainFigure() {
		UnitGroupFigure f = new UnitGroupFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

}
