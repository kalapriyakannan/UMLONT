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
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * The diagram prefs menu manager. It contains all diagram prefs actions
 */
public class FilterPreferenceMenuManager extends ActionMenuManager {

	private static class FilterPreferenceMenuAction extends Action {
		/**
		 * 
		 */
		public FilterPreferenceMenuAction() {
			setText(Messages.DiagramPreferenceMenuManager_Diagram_Preference_);
			setToolTipText(Messages.DiagramPreferenceMenuManager_Diagram_Preference_);
			ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
			setHoverImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES));
		}
	}

	/**
	 * Creates a new instance of the collapse menu manager
	 */
	public FilterPreferenceMenuManager() {
		super(DeployActionIds.MENU_FILTER_PREFERENCE, new FilterPreferenceMenuAction(), true);

	}

	/**
	 * Creates a new instance of the collapse menu manager
	 */
	public FilterPreferenceMenuManager(IWorkbenchPage page) {
		super(DeployActionIds.MENU_FILTER_PREFERENCE, new FilterPreferenceMenuAction(), true);

		add(FilterPreferenceAction.createAllDetailsAction(page));
		add(new Separator("FilterDetailGroup")); //$NON-NLS-1$ 
		add(FilterPreferenceAction.createAttributesAction(page, true));
		add(FilterPreferenceAction.createContractAction(page, true));
		add(FilterPreferenceAction.createNubsAction(page, true));
		add(FilterPreferenceAction.createTypeNamesAction(page, true));
	}

	/**
	 * Creates a new instance of the collapse menu manager
	 * 
	 * @param action
	 *           default action associated with this menu manager (should not be null)
	 */
	public FilterPreferenceMenuManager(IAction action) {
		super(DeployActionIds.MENU_FILTER_PREFERENCE, action, true);

		// If the action is null then use the original menu action
		if (action == null) {
			action = new FilterPreferenceMenuAction();
		}

		((AbstractActionHandler) getDefaultAction()).setPartSelector(new IPartSelector() {
			public boolean selects(IWorkbenchPart p) {
				return p instanceof IDiagramWorkbenchPart;
			}
		});
	}
}
