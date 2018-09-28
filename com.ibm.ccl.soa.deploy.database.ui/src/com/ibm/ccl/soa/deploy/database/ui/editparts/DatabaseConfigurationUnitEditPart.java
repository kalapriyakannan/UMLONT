/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.ui.editparts;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.database.ui.figures.DatabaseFigureFactory;

/**
 * Holds a logiocal node, which is a container capable of holding deployable units.
 */
public class DatabaseConfigurationUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public DatabaseConfigurationUnitEditPart(View view) {
		super(view);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = DatabaseFigureFactory.createNewDatabaseUnitFigure();
		FlowLayout layout = new FlowLayout();
		f.setLayoutManager(layout);
		return f;
	}
}
