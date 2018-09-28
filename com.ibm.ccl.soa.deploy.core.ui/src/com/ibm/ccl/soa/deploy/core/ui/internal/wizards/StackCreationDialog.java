package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

public class StackCreationDialog extends InputDialog {

	public StackCreationDialog(Shell parentShell, String dialogTitle, String dialogMessage,
			String initialValue, IInputValidator validator) {
		super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_DEFINE_NEW_STACK);
		return super.createDialogArea(parent);
	}

}