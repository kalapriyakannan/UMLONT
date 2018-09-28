/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;

/**
 * Dialog for editing caption and setting the value of key properties at the same time.
 * 
 * @author Ed Snible
 */
public class PasswordDialog extends TitleAreaDialog {

	private final String fldname;
	private Text txtPassword;
	private Text txtConfirm;
	private String value;

	/**
	 * @param parentShell
	 * @param fldname
	 */
	public PasswordDialog(Shell parentShell, String fldname) {
		super(parentShell);
		this.fldname = fldname;
		value = ""; //$NON-NLS-1$
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.PasswordDialog_Set_Passwor_);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addPasswordSection(composite);

		//		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.TOPOLOGY_SET_PASSWORD_DIALOG);

		return composite;
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		initializeControls();

		return c;
	}

	private void initializeControls() {
		setTitle(Messages.PasswordDialog_Set_Passwor_);
		dialogChanged();
	}

	private void dialogChanged() {
		boolean matches = txtPassword.getText().equals(txtConfirm.getText());
		if (!matches) {
			updateStatus(Messages.PasswordDialog_The_passwords_do_not_matc_);
			return;
		}

		updateStatus(null);
	}

	private void addPasswordSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		ModifyListener listener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		};

		Label prompt1 = new Label(composite, SWT.NONE);
		prompt1.setText(DeployNLS.bind(
				com.ibm.ccl.soa.deploy.core.ui.properties.Messages.CatchallCapabilityUIHandler3_0_,
				fldname));

		txtPassword = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtPassword.addModifyListener(listener);

		Label prompt2 = new Label(composite, SWT.NONE);
		prompt2.setText(NLS.bind(Messages.PasswordDialog_Confirm_0_, fldname));

		txtConfirm = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtConfirm.setLayoutData(new GridData(GridData.FILL_BOTH));
		txtConfirm.addModifyListener(listener);
	}

	protected void okPressed() {
		value = txtPassword.getText();

		super.okPressed();
	}

	/**
	 * @return the new password
	 */
	public String getValue() {
		return value;
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		getButton(IDialogConstants.OK_ID).setEnabled(message == null);
	}

} // end class PasswordDialog
