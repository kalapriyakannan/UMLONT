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

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * 
 * @see AddToGroupMenuManager
 * @see MoveToGroupMenuManager
 * @see RemoveFromGroupMenuManager
 */
public class GroupingMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;

	/**
	 * @param workbenchPage
	 */
	public GroupingMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_GROUPING, new GroupingMenuAction(), true);

		this.workbenchPage = workbenchPage;
		populateMenu();
	}

	private void populateMenu() {
		add(new AddToGroupMenuManager(workbenchPage));
		add(new MoveToGroupMenuManager(workbenchPage));
		add(new RemoveFromGroupMenuManager(workbenchPage));
	}

	private static class GroupingMenuAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public GroupingMenuAction() {
			setText(Messages.GROUP_MENU);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_GROUP_ICON));
		}
	}
}
