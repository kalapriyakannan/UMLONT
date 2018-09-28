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

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.Messages;
import com.ibm.ccl.soa.deploy.ihs.ui.figures.IhsServerFigure;

/**
 * EditPart linking IhsServerUnit with IhsServerFigure.
 * 
 * @see IhsServerFigure
 * @see IhsServerUnit
 */
public class IhsServerEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public IhsServerEditPart(View view) {
		super(view);

		setCategory(Messages.IhsServerEditPart_IHS_Server);
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = new IhsServerFigure();
//		f.setLayoutManager(new DelegatingLayout());
//		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
//		setCategory(unit.getDisplayName());
		return f;
	}
}
