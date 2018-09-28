/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.ide.ui.IDEUIPlugin;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

public class DeleteRuntimeAction extends Action {

	private IStructuredSelection selection;
	private Shell shell;

	public DeleteRuntimeAction(Shell shell) {
		super(Messages.DELETE_RUNTIME_MENU_TITLE, IDEUIPlugin.getImageDescriptor("icons/delete.gif")); //$NON-NLS-1$ 
		setId(ActionIds.DELETE_RUNTIME);
		this.shell = shell;
		setToolTipText(Messages.DELETE_RUNTIME_MENU_TOOLTIP);
	}

	protected boolean shouldRemoveRuntime() {
		boolean inUse = false;
		IServer[] servers = ServerCore.getServers();
		if (servers == null)
			return false;
		for (Iterator it = selection.iterator(); it.hasNext();) {
			IRuntime runtime = (IRuntime) it.next();
			for (int i = 0; i < servers.length; i++) {
				if (runtime.equals(servers[i].getRuntime()))
					inUse = true;
			}
			if (inUse)
				break;
		}
		if (inUse) {
			if (!MessageDialog.openConfirm(shell, Messages.DIALOG_RUNTIME_TITLE,
					Messages.DIALOG_RUNTIME_IN_USE))
				return false;
		}
		return true;
	}

	public boolean isEnabled() {
		Object object = null;
		if (selection.size() > 1)
			return false;
		for (Iterator it = selection.iterator(); it.hasNext();) {
			object = it.next();
			if (!(object instanceof IRuntime))
				return false;
		}
		return true;
	}

	public void selectionChanged(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void run() {
		if (shouldRemoveRuntime()) {
			for (Iterator it = selection.iterator(); it.hasNext();) {
				IRuntime runtime = (IRuntime) it.next();
				try {
					runtime.delete();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
