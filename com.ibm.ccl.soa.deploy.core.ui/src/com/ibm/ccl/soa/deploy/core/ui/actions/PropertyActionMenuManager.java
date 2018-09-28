package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Menu manager for property context actions
 * 
 * @since 7.0
 * 
 */
public class PropertyActionMenuManager extends ActionMenuManager {

	private final IWorkbenchPage workbenchPage;

	/**
	 * @param workbenchPage
	 */
	public PropertyActionMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_PROPERTY_ACTIONS, new TitleAction(), true);
		this.workbenchPage = workbenchPage;
		populateMenu();
	}

	private void populateMenu() {
		add(new ActionContributionItem(new OpenGeneralPropertyFlyout(workbenchPage)));
		add(new ActionContributionItem(new OpenRequirementsFlyout(workbenchPage)));
		add(new ActionContributionItem(new OpenCapabilitiesFlyout(workbenchPage)));
	}

	private static class TitleAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public TitleAction() {
			setText(Messages.PropertyActionMenuManager_Propertie_);
		}
	}

}
