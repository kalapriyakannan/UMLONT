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

public class ToggleConceptualMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;

	public ToggleConceptualMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_TOGGLE_CONCEPTUAL, new TitleAction(), true);

		this.workbenchPage = workbenchPage;

		populateMenu();
	}

	private void populateMenu() {
		add(ToggleConceptualAction.createSetAllConceptual(workbenchPage));
		add(ToggleConceptualAction.createSetAllNonConceptual(workbenchPage));
	}

	private static class TitleAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public TitleAction() {
			setText(Messages.ToggleConceptualMenuManager_Set_Conceptua_);
		}
	}
}
