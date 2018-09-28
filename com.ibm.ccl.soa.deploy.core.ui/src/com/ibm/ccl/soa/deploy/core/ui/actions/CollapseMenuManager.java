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

import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.common.ui.util.IPartSelector;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * The collapse menu manager. It contains all collapse-related actions
 */
public class CollapseMenuManager extends ActionMenuManager {

	/**
	 * The collapse menu action containing the UI for the collapse menu manager
	 */
	private static class CollapseMenuAction extends Action {
		public CollapseMenuAction() {
			setText(Messages.CollapseAction_Collapse_Al_);
			setToolTipText(Messages.CollapseAction_Collapse_Al_);
			ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
			setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL_DISABLED));
			setHoverImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_COLLAPSE_ALL));
		}
	}

	/**
	 * Creates a new instance of the collapse menu manager
	 */
	public CollapseMenuManager() {
		super(DeployActionIds.MENU_COLLAPSE, new CollapseMenuAction(), true);
	}

	/**
	 * Creates a new instance of the collapse menu manager
	 * 
	 * @param action
	 *           default action associated with this menu manager (should not be null)
	 */
	public CollapseMenuManager(IAction action) {
		super(DeployActionIds.MENU_COLLAPSE, action, true);

		// If the action is null then use the original menu action
		if (action == null) {
			action = new CollapseMenuAction();
		}

		((AbstractActionHandler) getDefaultAction()).setPartSelector(new IPartSelector() {
			public boolean selects(IWorkbenchPart p) {
				return p instanceof IDiagramWorkbenchPart;
			}
		});
	}
}
