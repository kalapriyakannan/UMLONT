/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.ui.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ModuleEditPart;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.ui.Messages;
import com.ibm.ccl.soa.deploy.waswebplugin.ui.figures.IhsWasPluginFigure;

/**
 * EditPart linking IhsWasPluginUnit with IhsWasPluginFigure.
 * 
 * @see IhsWasPluginFigure
 * @see IhsWasPluginUnit
 */
public class IhsWasPluginEditPart extends ModuleEditPart {

	/**
	 * @param view
	 */
	public IhsWasPluginEditPart(View view) {
		super(view);

		setCategory(Messages.IhsWasPluginEditPart_IHS_WAS_Plugin);
	}

	protected NodeFigure createMainFigure() {
		NodeFigure f = new IhsWasPluginFigure();
		return f;
	}
}
