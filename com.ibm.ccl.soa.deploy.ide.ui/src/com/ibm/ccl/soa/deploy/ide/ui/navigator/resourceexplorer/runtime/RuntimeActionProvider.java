/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime;

import java.util.Iterator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.wst.server.core.IRuntime;

import com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions.DeleteRuntimeAction;
import com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions.EditRuntimeAction;
import com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions.NewRuntimeAction;
import com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions.RefreshRuntimeAction;

/**
 * navigatorContent &lt;actionProvider&gt;; registered in plugin.xml.
 * 
 * @since 1.0
 */
public class RuntimeActionProvider extends CommonActionProvider {
	private DeleteRuntimeAction deleteRuntimeAction;
	private EditRuntimeAction editRuntimeAction;
	private NewRuntimeAction newRuntimeAction;
	private RefreshRuntimeAction refreshRuntimeAction;
	IStructuredSelection selection;

	public void init(ICommonActionExtensionSite aConfig) {
		Shell shell = aConfig.getViewSite().getShell();
		deleteRuntimeAction = new DeleteRuntimeAction(shell);
		editRuntimeAction = new EditRuntimeAction(shell);
		newRuntimeAction = new NewRuntimeAction(shell);
		refreshRuntimeAction = new RefreshRuntimeAction(aConfig.getStructuredViewer());

	}

	public void dispose() {
	}

	/**
	 * @param aContext
	 */
	public void setContext(ActionContext aContext) {
		super.setContext(aContext);
		if (aContext.getSelection() instanceof IStructuredSelection) {
			selection = (IStructuredSelection) aContext.getSelection();
			deleteRuntimeAction.selectionChanged(selection);
			editRuntimeAction.selectionChanged(selection);
			newRuntimeAction.selectionChanged(selection);
			refreshRuntimeAction.selectionChanged(selection);
		}
	}

	private boolean isRuntimeSelected() {
		if (selection == null)
			return false;
		Object object = null;
		for (Iterator it = selection.iterator(); it.hasNext();) {
			object = it.next();
			if (!(object instanceof IRuntime))
				return false;
		}
		return true;

	}

	public void fillContextMenu(IMenuManager aMenu) {
		boolean bDeleteAdded = false;

		if (isApplicationRootNodeSelected()) {
			aMenu.add(refreshRuntimeAction);
			aMenu.add(new Separator());
			aMenu.add(newRuntimeAction);
		}

		if (isRuntimeSelected()) {
			bDeleteAdded = true;
			aMenu.add(deleteRuntimeAction);
		}

		if (isRuntimeSelected()) {
			if (bDeleteAdded)
				aMenu.add(new Separator());
			aMenu.add(editRuntimeAction);
		}
	}

	private boolean isApplicationRootNodeSelected() {
		if (isSingleSelected() && selection.getFirstElement() instanceof ApplicationServerNode)
			return true;
		return false;
	}

	private boolean isSingleSelected() {
		if (selection == null)
			return false;
		if (selection.size() > 1)
			return false;
		return true;
	}

	public void fillActionBars(IActionBars theActionBars) {

	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

}
