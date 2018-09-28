/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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

/**
 * Dialog asking user name and password. This dialog is specific to a resolution; the
 * {@link PasswordDialog} in *.core.ui is used elsewhere.
 * 
 * @see GUIDB2AdminUseridCreationResolutionGenerator
 * @author Ed Snible
 * @author barnold
 */
public class UserPropertiesSetDialog extends TitleAreaDialog {

	private String defaultUserId = "db2admin"; //$NON-NLS-1$

	private Text editorUserid;
	private Text editorUserPassword;
	private Text editorUserPassword2;

	private String newValueUserid;
	private String newValueUserPassword;

	ModifyListener listener = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			dialogChanged();
		}
	};

	protected UserPropertiesSetDialog(Shell parentShell) {
		super(parentShell);
	}

	public String getEditorUserPassword() {
		return this.newValueUserPassword;
	}

	public String getEditorUserid() {
		return this.newValueUserid;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.CreateDB2InstanceAdminUser);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
//			GridLayout layout = new GridLayout(2, false);	
//			composite.setLayout(layout);			

		addPasswordSection(composite);

//			initializeControls();

		applyDialogFont(composite);

		// This *isn't* the property set dialog 
//			PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IDeployHelpContextIds.PROPERTY_SET_DIALOG);

		return composite;
	}

	private void addPasswordSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label labelUserid = new Label(composite, SWT.NONE);
		labelUserid.setText(Messages.DB2InstanceAdminUserID);

		editorUserid = new Text(composite, SWT.SINGLE | SWT.BORDER);
		editorUserid.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label labelUserPassword = new Label(composite, SWT.NONE);
		labelUserPassword.setText(Messages.DB2InstanceAdminPassword);

		editorUserPassword = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		editorUserPassword.setLayoutData(new GridData(GridData.FILL_BOTH));
		editorUserPassword.addModifyListener(listener);

		Label labelUserPassword2 = new Label(composite, SWT.NONE);
		labelUserPassword2.setText(Messages.UserPropertiesSetDialog_0);

		editorUserPassword2 = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		editorUserPassword2.setLayoutData(new GridData(GridData.FILL_BOTH));
		editorUserPassword2.addModifyListener(listener);
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		initializeControls();

		return c;
	}

	private void initializeControls() {
		editorUserid.setText(defaultUserId);
		editorUserid.selectAll();
		editorUserPassword.setFocus();

		setTitle(Messages.UserPropertiesSetDialog_SetPassword);
		dialogChanged();
	}

	protected void okPressed() {

		newValueUserid = editorUserid.getText();
		newValueUserPassword = editorUserPassword.getText();
		super.okPressed();
	}

	private void dialogChanged() {
		boolean matches = editorUserPassword.getText().equals(editorUserPassword2.getText());
		if (!matches) {
			updateStatus(Messages.UserPropertiesSetDialog_PasswordsDontMatch);
			return;
		}

		updateStatus(null);
	}

	public String getDefaultUserId() {
		return defaultUserId;
	}

	public void setDefaultUserId(String defaultUserId) {
		this.defaultUserId = defaultUserId;
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		getButton(IDialogConstants.OK_ID).setEnabled(message == null);
	}

} // end class UserPropertiesSetDialog
