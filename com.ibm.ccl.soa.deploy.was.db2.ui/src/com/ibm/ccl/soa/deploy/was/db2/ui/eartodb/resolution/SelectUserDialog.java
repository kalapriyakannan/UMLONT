/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.was.db2.ui.internal.Messages;

/**
 * Dialog to select a user that can access the database.
 */
public class SelectUserDialog extends TitleAreaDialog {

	private Label promptSelectUser;
	private Combo userIndexCombo;
	private Combo driverIndexCombo;

	private Label promptUser;
	private Text txtUser;
	private Label promptPassword;
	private Text txtPassword;
	private Label promptConfirm;
	private Text txtConfirm;

	private int newValueUserIndex;

	private String newValueUserName;
	private String newValuePassword;
	private String newValuePasswordConfirm;

	private final String[] users;

	protected SelectUserDialog(Shell parentShell, String[] users) {
		super(parentShell);
		String[] userList = new String[users.length + 1];
		for (int i = 0; i < users.length; i++) {
			userList[i] = users[i];
		}
		userList[users.length] = Messages.SelectUserDialog_EnterUser;
		this.users = userList;
	}

	/**
	 * Get the selected index of the user.
	 * 
	 * @return the index
	 */
	public int getUserIndex() {
		return newValueUserIndex;
	}

	/**
	 * Get the desired user name.
	 * 
	 * @return user name
	 */
	public String getUserName() {
		return newValueUserName;
	}

	/**
	 * Get the desiered password.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return newValuePassword;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.Select_User_Dialog);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		addDialogLayout(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.RESOLUTION_PROPERTY_SET_DIALOG);

		//updateStatus("Pick or fill in"); //$NON-NLS-1$
		return composite;
	}

	private void addDialogLayout(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		ModifyListener listener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		};

		// add list of users only if there is more than one to pick from
		if (users.length > 2) { // <enter user> is an entry
			promptSelectUser = new Label(composite, SWT.NONE);
			promptSelectUser.setText(Messages.DB2UserID);

			userIndexCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
			userIndexCombo.setItems(users);
			userIndexCombo.addModifyListener(listener);
		}

		promptUser = new Label(composite, SWT.NONE);
		promptUser.setText(Messages.SelectUserDialog_Username);

		txtUser = new Text(composite, SWT.BORDER);
		txtUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtUser.addModifyListener(listener);

		promptPassword = new Label(composite, SWT.NONE);
		promptPassword.setText(Messages.SelectUserDialog_UserPassword);

		txtPassword = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtPassword.addModifyListener(listener);

		promptConfirm = new Label(composite, SWT.NONE);
		promptConfirm.setText(Messages.SelectUserDialog_ConfirmUserPassword);

		txtConfirm = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtConfirm.setLayoutData(new GridData(GridData.FILL_BOTH));
		txtConfirm.addModifyListener(listener);
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);
		dialogChanged(); // initialize the state messgae
		return c;
	}

	private void dialogChanged() {
		// if user selects from combo box, disable other controls
		if (null != userIndexCombo && 0 <= userIndexCombo.getSelectionIndex()
				&& userIndexCombo.getSelectionIndex() < users.length - 1) {
			promptUser.setEnabled(false);
			txtUser.setEnabled(false);
			promptPassword.setEnabled(false);
			txtPassword.setEnabled(false);
			promptConfirm.setEnabled(false);
			txtConfirm.setEnabled(false);
		} else {
			promptUser.setEnabled(true);
			txtUser.setEnabled(true);
			promptPassword.setEnabled(true);
			txtPassword.setEnabled(true);
			promptConfirm.setEnabled(true);
			txtConfirm.setEnabled(true);
		}

		// if user enters user/password in text box, disable other controls
		if (0 < txtUser.getText().trim().length() || 0 < txtPassword.getText().trim().length()
				|| 0 < txtConfirm.getText().trim().length()) {
			promptSelectUser.setEnabled(false);
			userIndexCombo.setEnabled(false);
		} else {
			promptSelectUser.setEnabled(true);
			userIndexCombo.setEnabled(true);
		}

		// status message is password/confirm don't match
		boolean matches = txtPassword.getText().equals(txtConfirm.getText());
		if (!matches) {
			updateStatus(Messages.SelectUserDialog_PasswordMismatch);
			return;
		}

		// must have an item selected in dialog box
		// or user and password specified
		if (null != userIndexCombo) {
			if (0 > userIndexCombo.getSelectionIndex()) {
				if (0 == txtUser.getText().trim().length()
						&& 0 == txtPassword.getText().trim().length()
						&& 0 == txtConfirm.getText().trim().length()) {
					// nothing is selected and nothing entered
					updateStatus(Messages.SelectUserDialog_SelectionInstruction);
					return;
				}
				if (0 == txtUser.getText().trim().length()
						|| 0 == txtPassword.getText().trim().length()
						|| 0 == txtConfirm.getText().trim().length()) {
					// nothing selected and something entered; but not enough
					updateStatus(Messages.SelectUserDialog_SelectionInstruction2);
					return;
				}
			}
			if (0 <= userIndexCombo.getSelectionIndex()
					&& userIndexCombo.getSelectionIndex() < users.length - 1) {
				// item selected in list
				// don't do anything
			}
			if (userIndexCombo.getSelectionIndex() == users.length - 1
					&& (0 == txtUser.getText().trim().length()
							|| 0 == txtPassword.getText().trim().length() || 0 == txtConfirm.getText()
							.trim().length())) {
				// must enter user or password or both
				updateStatus(Messages.SelectUserDialog_SelectionInstruction2);
				return;
			}
		}

		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		getButton(IDialogConstants.OK_ID).setEnabled(message == null);
	}

	private void initializeControls() {
//		if (null != userIndexCombo) {
		//if (userIndexCombo.getItemCount() > 0) {
		//userIndexCombo.select(0);
		// Ed does not recommend setting focus with a Combo
		// userIndexCombo.setFocus();
		//}
//		}
	}

	protected void okPressed() {

		newValueUserIndex = null != userIndexCombo ? userIndexCombo.getSelectionIndex() : -1;
		newValueUserName = txtUser.getText();
		newValuePassword = txtPassword.getText();
		super.okPressed();
	}
}
