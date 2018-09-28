/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.TaskModel;
import org.eclipse.wst.server.ui.internal.wizard.TaskWizard;
import org.eclipse.wst.server.ui.internal.wizard.WizardTaskUtil;
import org.eclipse.wst.server.ui.internal.wizard.fragment.NewRuntimeWizardFragment;
import org.eclipse.wst.server.ui.wizard.WizardFragment;

import com.ibm.ccl.soa.deploy.ide.ui.IDEUIPlugin;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

public class NewRuntimeAction extends Action {

	private final Shell shell;

	public NewRuntimeAction(Shell shell) {
		super(Messages.NEW_RUNTIME_MENU_TITLE, IDEUIPlugin
				.getImageDescriptor("icons/wiz_new_server.gif")); //$NON-NLS-1$ 
		setId(ActionIds.NEW_RUNTIME);
		this.shell = shell;
		setToolTipText(Messages.NEW_RUNTIME_MENU_TOOLTIP);
	}

	public void selectionChanged(IStructuredSelection selection) {
	}

	public boolean isEnabled() {
		return true;
	}

	public void run() {
		showWizard(null);
	}

	protected int showWizard(final IRuntimeWorkingCopy runtimeWorkingCopy) {
		String title = null;
		WizardFragment fragment = null;
		TaskModel taskModel = new TaskModel();
		if (runtimeWorkingCopy == null) {
			title = Messages.WIZ_NEW_RUNTIME_WIZARD_TITLE;
			fragment = new WizardFragment() {
				protected void createChildFragments(List list) {
					list.add(new NewRuntimeWizardFragment());
					list.add(WizardTaskUtil.SaveRuntimeFragment);
				}
			};
		}
		TaskWizard wizard = new TaskWizard(title, fragment, taskModel);
		wizard.setForcePreviousAndNextButtons(true);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		return dialog.open();
	}

}
