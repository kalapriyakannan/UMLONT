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
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.TaskModel;
import org.eclipse.wst.server.ui.internal.ServerUIPlugin;
import org.eclipse.wst.server.ui.internal.wizard.TaskWizard;
import org.eclipse.wst.server.ui.internal.wizard.WizardTaskUtil;
import org.eclipse.wst.server.ui.wizard.WizardFragment;

import com.ibm.ccl.soa.deploy.ide.ui.IDEUIPlugin;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

public class EditRuntimeAction extends Action {

	private IStructuredSelection selection;
	private Shell shell;

	public EditRuntimeAction(Shell shell) {
		super(Messages.EDIT_RUNTIME_MENU_TITLE, IDEUIPlugin
				.getImageDescriptor("icons/wiz_modify_modules.gif")); //$NON-NLS-1$ 
		setId(ActionIds.EDIT_RUNTIME);
		this.shell = shell;
		setToolTipText(Messages.EDIT_RUNTIME_MENU_TOOLTIP);
	}

	public void selectionChanged(IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean isEnabled() {
		if (selection.size() == 1 && selection.getFirstElement() instanceof IRuntime)
			return true;
		return false;
	}

	public void run() {
		IRuntime runtime = (IRuntime) selection.getFirstElement();
		if (runtime != null) {
			IRuntimeWorkingCopy runtimeWorkingCopy = runtime.createWorkingCopy();
			if (runtimeWorkingCopy == null)
				return;
			if (showWizard(runtimeWorkingCopy) != Window.CANCEL) {
				try {
					runtimeWorkingCopy.save(false, null);
				} catch (Exception ex) {
					// ignore
				}
			}
		}
	}

	protected int showWizard(final IRuntimeWorkingCopy runtimeWorkingCopy) {
		String title = null;
		WizardFragment fragment = null;
		TaskModel taskModel = new TaskModel();
		title = Messages.WIZ_EDIT_RUNTIME_WIZARD_TITLE;
		final WizardFragment fragment2 = ServerUIPlugin.getWizardFragment(runtimeWorkingCopy
				.getRuntimeType().getId());
		if (fragment2 == null) {
			return Window.CANCEL;
		}
		taskModel.putObject(TaskModel.TASK_RUNTIME, runtimeWorkingCopy);
		fragment = new WizardFragment() {
			protected void createChildFragments(List list) {
				list.add(fragment2);
				list.add(WizardTaskUtil.SaveRuntimeFragment);
			}
		};

		TaskWizard wizard = new TaskWizard(title, fragment, taskModel);
		wizard.setForcePreviousAndNextButtons(true);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		return dialog.open();
	}

}
