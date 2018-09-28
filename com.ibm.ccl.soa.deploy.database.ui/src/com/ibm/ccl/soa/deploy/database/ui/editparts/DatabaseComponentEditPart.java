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
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.BusinessComponentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.BusinessComponentFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.database.ui.Messages;

/**
 * Holds a software component.
 */
public class DatabaseComponentEditPart extends BusinessComponentEditPart {

	/**
	 * @param view
	 */
	public DatabaseComponentEditPart(View view) {
		super(view);
		setCategory(Messages.DatabaseComponentEditPart_Database_Component);
	}

	protected NodeFigure createMainFigure() {
		BusinessComponentFigure f = new BusinessComponentFigure(
				DeployColorConstants.dataComponentFillc1, DeployColorConstants.dataComponentFillc2,
				DeployColorConstants.dataComponentFill1, DeployColorConstants.dataComponentFill2,
				DeployColorConstants.dataComponentBorder, DeployColorConstants.dataComponentConcept);
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}

	@Override
	public Command getCommand(Request request) {
		// TODO Auto-generated method stub
		return super.getCommand(request);
	}

}
