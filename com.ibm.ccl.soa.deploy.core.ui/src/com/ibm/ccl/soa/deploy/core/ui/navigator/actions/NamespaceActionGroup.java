/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;

public class NamespaceActionGroup extends ActionGroup {

	private final IWorkbenchPartSite viewSite;
	//private DeleteResourceAction deleteTopologyAction;
	private IStructuredSelection selection;

	/**
	 * @param viewSite
	 */

	public NamespaceActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
		//		deleteTopologyAction = new DeleteResourceAction(PlatformUI.getWorkbench()
		//				.getActiveWorkbenchWindow().getShell());
		//		deleteTopologyAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		//				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager menu) {
		if (isSingleSelected()) {
			//			deleteTopologyAction.selectionChanged(getSelection());
			//			if (deleteTopologyAction.isEnabled() && !(selection.getFirstElement() instanceof IFile)) {
			//				menu.insertAfter(ICommonMenuConstants.GROUP_EDIT, deleteTopologyAction);
			//			}
		}
	}

	private IStructuredSelection getSelection() {
		return selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars theActionBars) {
		if (isSingleSelected()) {
			//			deleteTopologyAction.selectionChanged(selection);
			//			if (deleteTopologyAction.isEnabled() && !(selection.getFirstElement() instanceof IFile)) {
			//				theActionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, deleteTopologyAction);
			//			}
		}
	}

}
