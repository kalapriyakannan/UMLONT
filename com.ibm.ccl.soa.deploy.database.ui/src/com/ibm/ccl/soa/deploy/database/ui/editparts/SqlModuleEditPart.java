/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.database.ui.figures.DatabaseFigureFactory;
import com.ibm.ccl.soa.deploy.database.ui.Messages;

/**
 * Represents an SQLModule.
 * 
 * @see com.ibm.ccl.soa.deploy.database.SQLModule
 */
public class SqlModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public SqlModuleEditPart(View view) {
		super(view);
		setCategory(Messages.SqlModuleEditPart_SQL_DDL_File);

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DatabaseFigureFactory.createNewSqlUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
