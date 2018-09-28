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
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.database.ui.Messages;
import com.ibm.ccl.soa.deploy.database.ui.figures.DatabaseFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class DatabaseModuleEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public DatabaseModuleEditPart(View view) {
		super(view);

		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}

		if (unit instanceof DatabaseUnit) {
			setCategory(Messages.Database_Unit);
		}
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DatabaseFigureFactory.createNewDatabaseUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
