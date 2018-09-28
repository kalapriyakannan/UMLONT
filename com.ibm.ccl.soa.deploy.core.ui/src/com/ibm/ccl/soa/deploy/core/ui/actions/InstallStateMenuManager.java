/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;

public class InstallStateMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;

	public InstallStateMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_INSTALL_STATE_ACTIONS, new TitleAction(), true);
		this.workbenchPage = workbenchPage;

		populateMenu();
	}

	private void populateMenu() {
		// uninstalled > installed
		add(SetInstallStateAction.createSetAllUninstalledInstalledAction(workbenchPage));
		// installed > uninstalled
		add(SetInstallStateAction.createSetAllInstalledUninstalledAction(workbenchPage));
		// installed > installed
		add(SetInstallStateAction.createSetAllInstalledAction(workbenchPage));
		// uninstalled > uninstalled
		add(SetInstallStateAction.createSetAllUnistalledAction(workbenchPage));
		// unknown > unknown
		add(SetInstallStateAction.createSetAllUnknownAction(workbenchPage));
		// unknown > installed
		add(SetInstallStateAction.createSetAllUnknownInstalledAction(workbenchPage));
		// unknown > uninstalled
		add(SetInstallStateAction.createSetAllUnknownUninstalledAction(workbenchPage));
		// installed > unknown
		add(SetInstallStateAction.createSetAllInstalledUnknownAction(workbenchPage));
		// uninstalled > unknown
		add(SetInstallStateAction.createSetAllUninstalledUnknownAction(workbenchPage));
	}

	private static class TitleAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public TitleAction() {
			setText(Messages.InstallStateMenuManager_Set_Install_Stat_);
		}
	}
}
