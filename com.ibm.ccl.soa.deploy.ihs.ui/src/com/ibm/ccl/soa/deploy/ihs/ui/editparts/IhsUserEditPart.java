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
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.Messages;
import com.ibm.ccl.soa.deploy.ihs.ui.figures.IhsUserFigure;

/**
 * EditPart linking IhsUserUnit with IhsUserFigure.
 * 
 * @see IhsUserFigure
 * @see IhsUserUnit
 */
public class IhsUserEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public IhsUserEditPart(View view) {
		super(view);

		setCategory(Messages.IhsUserEditPart_Ihs_User);
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = new IhsUserFigure();
//		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
