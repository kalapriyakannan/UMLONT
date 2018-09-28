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

/**
 * Visualize content menu
 */
public class VisualizeMenuManager extends ActionMenuManager {
	private final IWorkbenchPage workbenchPage;

	/**
	 * @param workbenchPage
	 */
	public VisualizeMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_VISUALIZE, new VisualizeMenuAction(), true);
		this.workbenchPage = workbenchPage;
		populateMenu();
	}

	private void populateMenu() {
		add(VisualizeAction.createVisualizeToCurrentDiagram(workbenchPage));
		add(VisualizeAction.createVisualizeToNewDiagram(workbenchPage));
	}

	private static class VisualizeMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public VisualizeMenuAction() {
			setText(Messages.VisualizeCommand_Visualiz_);
		}
	}

}
