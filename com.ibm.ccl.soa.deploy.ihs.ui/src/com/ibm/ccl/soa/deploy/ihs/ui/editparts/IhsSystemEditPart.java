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
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.Messages;
import com.ibm.ccl.soa.deploy.ihs.ui.figures.IhsSystemFigure;

/**
 * EditPart linking IhsSystemUnit with IhsSystemFigure.
 * 
 * @see IhsSystemFigure
 * @see IhsSystemUnit
 */
public class IhsSystemEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public IhsSystemEditPart(View view) {
		super(view);

		setCategory(Messages.IhsSystemEditPart_IHS_System);
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = new IhsSystemFigure();
//		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
