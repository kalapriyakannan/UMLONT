/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.figures.DB2FigureFactory;

/**
 * EditPart for {@link DB2AdminServerUnit}.
 * 
 * TODO Consider getting rid of class and just use DB2ModuleEditPart. (Do we need our own edit
 * policies?)
 * 
 * @author Ed Snible <snible@us.ibm.com>
 */
public class DB2AdminServerUnitEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public DB2AdminServerUnitEditPart(View view) {
		super(view);
		// determine figure category description
		setCategory(DB2EditPartMessages.DB2_Admin_Server);

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DB2FigureFactory.createNewDB2UnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
