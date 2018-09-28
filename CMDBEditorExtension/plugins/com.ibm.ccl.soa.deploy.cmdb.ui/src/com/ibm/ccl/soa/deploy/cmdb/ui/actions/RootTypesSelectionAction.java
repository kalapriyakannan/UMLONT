/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

import com.ibm.ccl.soa.deploy.cmdb.ui.CmdbUIPlugin;
import com.ibm.ccl.soa.deploy.cmdb.ui.provider.CmdbRoot;

/**
 * @author barnold
 * 
 */
public class RootTypesSelectionAction extends Action implements IViewActionDelegate {

	ISelection selection = null;
	
	/**
	 * Preferences key for root types to use in CCMDB explorer
	 */
	public static final String ccmdbExplorerRootTypes  = "ccmdbExplorerRootTypes"; //$NON-NLS-1$
	/**
	 * 	Preferences key for root types to display in root type selection dialog in CCMDB explorer
	 */
	public static final String ccmdbExplorerCheckableRootTypes  = "ccmdbExplorerCheckableRootTypes"; //$NON-NLS-1$
	
	@Override
	public boolean isEnabled() {
		if (selection == null) {
			return false;
		} else {
			return validateSelection();
		}
	}

	private boolean validateSelection() {
		IStructuredSelection selections = (IStructuredSelection) selection;
		Object element = selections.getFirstElement();
		return selections.size() == 1 && element instanceof CmdbRoot;
	}

	public void init(IViewPart view) {
		// TODO anything here?
	}

	public void run(IAction action) {
		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		RootTypesSelectionDialog d = new RootTypesSelectionDialog(parentShell);

		if (d.open() == Window.OK) {
			IPreferenceStore ips = CmdbUIPlugin.getDefault().getPreferenceStore();
			String cts = d.getCheckedTypeStrings();
			
			ips.setDefault(RootTypesSelectionAction.ccmdbExplorerRootTypes, RootTypesSelectionDialog.getCheckedTypesDefault());
			ips.setValue(RootTypesSelectionAction.ccmdbExplorerRootTypes, cts);
			// We should be using DeployCorePerspectiveFactory.ID_PROJECT_NAV
			// instead, but
			// DeployCorePerspectiveFactory's package isn't exported!
//			String id = "com.ibm.ccl.soa.deploy.core.ui.navigator.views.CommonServerNavigator"; //$NON-NLS-1$
			String id = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$
			IViewPart ivp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(id);
			if (ivp instanceof CommonNavigator) {
				CommonNavigator cn = (CommonNavigator) ivp;
				cn.getCommonViewer().refresh();
			}
		}
	}

	public void selectionChanged(IAction action, ISelection aSelection) {
		selection = aSelection;
		action.setEnabled(isEnabled());

	}

	/**
	 * 
	 */
	public void dispose() {
		// TODO anything here?
	}

}

