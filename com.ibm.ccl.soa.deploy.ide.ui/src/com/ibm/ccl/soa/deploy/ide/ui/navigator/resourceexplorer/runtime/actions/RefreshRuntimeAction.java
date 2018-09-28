/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;

import com.ibm.ccl.soa.deploy.ide.ui.IDEUIPlugin;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

/**
 * @since 1.0
 * 
 */
public class RefreshRuntimeAction extends Action {

	private IStructuredSelection selection;
	private StructuredViewer viewer;

	/**
	 * @param viewer
	 */
	public RefreshRuntimeAction(StructuredViewer viewer) {
		super(Messages.REFRESH_RUNTIMES_MENU_TITLE, IDEUIPlugin
				.getImageDescriptor("icons/refresh.gif")); //$NON-NLS-1$ 
		setId(ActionIds.REFRESH_RUNTIMES);
		setToolTipText(Messages.REFRESH_RUNTIMES_MENU_TOOLTIP);
		this.viewer = viewer;
	}

	/**
	 * @param selection
	 */
	public void selectionChanged(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void run() {
		if (viewer != null && selection != null) {
			viewer.refresh(selection.getFirstElement());
		}
	}

}
