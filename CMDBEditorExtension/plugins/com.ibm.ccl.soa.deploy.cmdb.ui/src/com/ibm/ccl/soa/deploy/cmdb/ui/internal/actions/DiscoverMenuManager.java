/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.cmdb.ui.internal.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.cmdb.ui.Messages;

/**
 * The discovery parent menu.
 */
public class DiscoverMenuManager extends ActionMenuManager {
	private final IWorkbenchPage workbenchPage;

	/**
	 * @param page
	 */
	public DiscoverMenuManager(IWorkbenchPage page) {
		super(CmdbActionIds.DEPLOY_DISCOVER, new DiscoverMenuAction(), true);
		this.workbenchPage = page;
		populateMenu();
	}

	private static class DiscoverMenuAction extends Action {
		public DiscoverMenuAction() {
			setId(CmdbActionIds.DEPLOY_DISCOVER);
			setText(Messages.Discover);
			// setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(ISharedImages.IMG_GROUP_ICON));
		}
	}

	private void populateMenu() {
		add(new DiscoverHostsAction(workbenchPage));
		add(new DiscoverHostedAction(workbenchPage));
		add(new DiscoverGroupsAction(workbenchPage));
		add(new DiscoverMembersAction(workbenchPage));
		add(new DiscoverDependencyTargetsAction(workbenchPage));
		add(new DiscoverDependencySourcesAction(workbenchPage));
	}
}