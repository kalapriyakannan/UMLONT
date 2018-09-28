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

import java.util.Iterator;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * @since 7.0
 * 
 */
public class GlobalDeployMenuManager extends ActionMenuManager {

	private DeployShapeNodeEditPart editPart;
	private IWorkbenchPage page;

	public GlobalDeployMenuManager(IWorkbenchPage workbenchPage) {
		super(DeployActionIds.MENU_GLOBAL_ACTIONS, new TitleAction(), true);

		page = workbenchPage;

		populateMenu();
	}

	public void dispose() {
		editPart = null;
		page = null;
	}

	private void populateMenu() {
		add(new ToggleConceptualMenuManager(page));
		add(new InstallStateMenuManager(page));
		add(new ContractMenuManager(page));
	}

	@Override
	public boolean isVisible() {
		return super.isVisible() && isEnabled();
	}

	public boolean isEnabled() {
		// var page will have to be initialized for the IHandler case.
		if (page == null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench == null) {
				return false;
			}
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			if (window == null) {
				return false;
			}
			page = window.getActivePage();
		}
		if (page == null || page.getSelection() == null) {
			return false;
		}

		ISelection selection = page.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sSel = (IStructuredSelection) selection;

			for (Iterator iterator = sSel.toList().iterator(); iterator.hasNext();) {
				Object selected = iterator.next();
				if (!(selected instanceof DeployShapeNodeEditPart)) {
					return false;
				}
			}
		}
		return super.isEnabled();
	}

	private static class TitleAction extends Action {
		/**
		 * constructor which sets name and image for this menu
		 */
		public TitleAction() {
			setText(Messages.GlobalDeployMenuManager_Global_DMO_Action_);
		}
	}

}
