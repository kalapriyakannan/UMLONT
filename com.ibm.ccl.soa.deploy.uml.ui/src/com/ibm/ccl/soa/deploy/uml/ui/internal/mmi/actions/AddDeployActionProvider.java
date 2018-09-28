/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * DeployActionProvider contributes the Deployment specific actions to the Deployment Navigator
 * 
 */
public class AddDeployActionProvider extends CommonActionProvider {
	private IStructuredSelection selection;
	private AddToDiagramActionGroup addToDiagramActionGroup;
	private boolean isInitialized;
	private IWorkbenchPartSite viewSite = null;
	private ICommonActionExtensionSite aConfig;

	public void init(ICommonActionExtensionSite aConfig) {
		ICommonViewerWorkbenchSite workbenchSite = null;
		this.aConfig = aConfig;
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			workbenchSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
		}
		if (workbenchSite != null) {
			isInitialized = true;
			viewSite = workbenchSite.getSite();
			addToDiagramActionGroup = new AddToDiagramActionGroup(viewSite);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#dispose()
	 */
	public void dispose() {
		if (isInitialized) {

			addToDiagramActionGroup.dispose();

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#setActionContext(org.eclipse.ui.actions.ActionContext)
	 */
	/**
	 * @param aContext
	 */
	public void setContext(ActionContext aContext) {
		super.setContext(aContext);
		if (isInitialized) {
			if (aContext.getSelection() instanceof IStructuredSelection) {
				selection = (IStructuredSelection) aContext.getSelection();
				addToDiagramActionGroup.setSelection(selection);

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

			addToDiagramActionGroup.fillContextMenu(aMenu);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars theActionBars) {
		if (isInitialized) {
			// register an action on the theActionBars for ICommonActionConstants.OPEN
//			theActionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, )

			addToDiagramActionGroup.fillActionBars(theActionBars);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento aMemento) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento aMemento) {
	}

}
