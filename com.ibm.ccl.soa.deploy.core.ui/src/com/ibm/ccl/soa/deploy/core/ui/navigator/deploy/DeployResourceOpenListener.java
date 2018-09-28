/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;

public class DeployResourceOpenListener implements IOpenListener {
	// private DeployOpenPlanAction action;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IOpenListener#open(org.eclipse.jface.viewers.OpenEvent)
	 */

	public void open(OpenEvent anEvent) {
		ISelection selection = anEvent.getSelection();
		if (selection instanceof IStructuredSelection) {
			//    if (getAction().updateSelection((IStructuredSelection)selection))
			//    	action.run();
		}
	}

	/**
	 * @return
	 */
	/*
	 * private DeployOpenPlanAction getAction() { if (action == null) action = new
	 * DeployOpenPlanAction(); return action; }
	 */
}
