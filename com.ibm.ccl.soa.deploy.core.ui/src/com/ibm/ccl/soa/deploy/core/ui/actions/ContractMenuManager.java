/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

public class ContractMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;

	public ContractMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_CONTRACT_ACTIONS, new TitleAction(), true);
		this.workbenchPage = workbenchPage;

		populateMenu();
	}

	private void populateMenu() {
		add(SetContractVisibilityAction.createSetAllPublicEditableAction(workbenchPage));
		add(SetContractVisibilityAction.createSetAllPublicAction(workbenchPage));
		add(SetContractVisibilityAction.createSetAllPrivateAction(workbenchPage));
	}

	private static class TitleAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public TitleAction() {
			setText(Messages.ContractMenuManager_Set_Contrac_);
		}
	}
}
