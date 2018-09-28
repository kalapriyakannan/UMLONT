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
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

public class NamespaceActionProvider extends CommonActionProvider {
	private boolean isInitialized;
	private IWorkbenchPartSite viewSite = null;
	private NamespaceActionGroup namespaceActionGroup;
	private IStructuredSelection selection;

	public void init(ICommonActionExtensionSite aConfig) {
		ICommonViewerWorkbenchSite workbenchSite = null;
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite)
			workbenchSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
		if (workbenchSite != null) {
			isInitialized = true;
			viewSite = workbenchSite.getSite();
			namespaceActionGroup = new NamespaceActionGroup(viewSite);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#dispose()
	 */
	public void dispose() {
		if (isInitialized) {
			namespaceActionGroup.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#setActionContext(org.eclipse.ui.actions.ActionContext)
	 */
	public void setContext(ActionContext aContext) {
		super.setContext(aContext);
		if (isInitialized) {
			if (aContext.getSelection() instanceof IStructuredSelection) {
				selection = (IStructuredSelection) aContext.getSelection();
				namespaceActionGroup.setSelection(selection);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager aMenu) {
		if (isInitialized) {
			namespaceActionGroup.fillContextMenu(aMenu);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars theActionBars) {
		if (isInitialized) {
			namespaceActionGroup.fillActionBars(theActionBars);
		}
	}

}
