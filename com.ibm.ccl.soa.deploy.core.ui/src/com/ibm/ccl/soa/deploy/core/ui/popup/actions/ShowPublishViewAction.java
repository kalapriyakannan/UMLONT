/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;

/**
 * 
 * Show Publish Problems View
 * 
 * @since 1.0
 * @author Ella Feng
 * 
 */

public class ShowPublishViewAction implements IObjectActionDelegate {

	private ISelection selection;

	/**
	 * Constructor for Action1.
	 */
	public ShowPublishViewAction() {
		super();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
					DeployCorePerspectiveFactory.ID_PUBLISH_PROBLEM);

		} catch (PartInitException e) {
			//MessageDialog.openError(getShell(), PublishMessages.getString("CreateTopologyView.1"), PublishMessages.getString("CreateTopologyView.0")); //$NON-NLS-1$ //$NON-NLS-2$
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);

			//e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

}
