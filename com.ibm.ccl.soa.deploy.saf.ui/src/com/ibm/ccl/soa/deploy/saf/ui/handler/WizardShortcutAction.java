/***************************************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.saf.ui.handler;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.wizards.IWizardDescriptor;

import com.ibm.ccl.soa.deploy.internal.saf.ui.Messages;

/**
 * 
 * @since 3.2 Reused from org.eclipse.ui.navigator.
 * 
 * Written in its entirety by Michael D. Elder <mdelder@us.ibm.com>
 */
public class WizardShortcutAction extends Action implements IPluginContribution {
	private final IWizardDescriptor descriptor;

	private final IWorkbenchWindow window;

	/**
	 * 
	 * @param aWindow
	 *           The window to use for the shell and selection service.
	 * @param aDescriptor
	 *           The descriptor with information for triggering the desired wizard.
	 */
	public WizardShortcutAction(IWorkbenchWindow aWindow, IWizardDescriptor aDescriptor) {
		super(aDescriptor.getLabel());
		descriptor = aDescriptor;
		setToolTipText(descriptor.getDescription());
		setImageDescriptor(descriptor.getImageDescriptor());
		setId(ActionFactory.NEW.getId());
		window = aWindow;
	}

	/**
	 * This action has been invoked by the user
	 */
	public void run() {
		// create instance of target wizard

		IWorkbenchWizard wizard;
		try {
			wizard = descriptor.createWizard();
		} catch (CoreException e) {
			ErrorDialog.openError(window.getShell(),
					Messages.WizardShortcutAction_Problem_Opening_Wizar_, NLS.bind(
							Messages.WizardShortcutAction_Could_not_open_the_wizard_due_to_th_, e
									.getMessage()), e.getStatus());
			return;
		}

		ISelection selection = window.getSelectionService().getSelection();

		if (selection instanceof IStructuredSelection) {
			wizard.init(window.getWorkbench(), (IStructuredSelection) selection);
		} else {
			wizard.init(window.getWorkbench(), StructuredSelection.EMPTY);
		}

		Shell parent = window.getShell();
		WizardDialog dialog = new WizardDialog(parent, wizard);
		dialog.create();
		// WorkbenchHelp.setHelp(dialog.getShell(),
		// IWorkbenchHelpContextIds.NEW_WIZARD_SHORTCUT);
		dialog.open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.activities.support.IPluginContribution#getLocalId()
	 */
	public String getLocalId() {
		return descriptor.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.activities.support.IPluginContribution#getPluginId()
	 */
	public String getPluginId() {
		return descriptor.getId();
	}

}
