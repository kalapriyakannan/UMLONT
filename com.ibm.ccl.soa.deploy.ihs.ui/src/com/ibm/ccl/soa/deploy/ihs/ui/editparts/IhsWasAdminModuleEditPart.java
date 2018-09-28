/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.ui.editparts;

//import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.Messages;
import com.ibm.ccl.soa.deploy.ihs.ui.figures.IhsWasAdminModuleFigure;

/**
 * EditPart linking IhsWasAdminModuleUnit with IhsWasAdminModuleFigure.
 * 
 * @see IhsWasAdminModuleFigure
 * @see IhsWasAdminModuleUnit
 */
public class IhsWasAdminModuleEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public IhsWasAdminModuleEditPart(View view) {
		super(view);

		setCategory(Messages.IhsWasAdminModuleEditPart_IHS_Was_Admin_Module);
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = new IhsWasAdminModuleFigure();
//		f.setLayoutManager(new DelegatingLayout());
//		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
//		setCategory(unit.getDisplayName());
		return f;
	}
}
