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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;

/**
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see DiscoverLinksAction
 * @deprecated
 */
public class DiscoverLinksActionGroup extends ActionGroup {
	private final String TOPOLOGY_FILE_EXTENSION = "topology"; //$NON-NLS-1$
	private final IWorkbenchPartSite viewSite;
	private IStructuredSelection selection;

	public DiscoverLinksActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void fillContextMenu(IMenuManager menu) {
		if (!isSingleSelected()) {
			return;
		}

		Object object = selection.getFirstElement();

		if (object instanceof IFile) {
			if (TOPOLOGY_FILE_EXTENSION.equalsIgnoreCase(((IFile) object).getFileExtension())) {
				addDiscoverLinksMenu(menu);
			}
		}
	}

	/**
	 * @return Returns true if only one object is selected in the navigator otherwise returns false
	 */
	private boolean isSingleSelected() {
		if (selection == null) {
			return false;
		}
		if (selection.size() > 1) {
			return false;
		}
		return true;
	}

	private void addDiscoverLinksMenu(IMenuManager menu) {
		menu.insertBefore(ICommonMenuConstants.GROUP_ADDITIONS, new Separator(
				DeployActionIds.DISCOVER_LINKS_ACTION_GROUP));
		DiscoverLinksAction discoverLinksAction = new DiscoverLinksAction(viewSite.getPage());
		menu.appendToGroup(DeployActionIds.DISCOVER_LINKS_ACTION_GROUP, discoverLinksAction);

	}
}
