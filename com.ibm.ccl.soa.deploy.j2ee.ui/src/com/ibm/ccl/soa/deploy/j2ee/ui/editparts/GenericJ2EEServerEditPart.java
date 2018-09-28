/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.figures.J2EEFigureFactory;
import com.ibm.ccl.soa.deploy.j2ee.ui.providers.J2EEEditPartProvider;

/**
 * EditPart for {@link GenericJ2EEServer}.
 * 
 * @see J2EEEditPartProvider
 */
public class GenericJ2EEServerEditPart extends ModuleEditPart {
	/**
	 * @param view
	 */
	public GenericJ2EEServerEditPart(View view) {
		super(view);
		setCategory(Messages.GenericJ2EEServerEditPart_0);

	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = J2EEFigureFactory.createNewServerFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
