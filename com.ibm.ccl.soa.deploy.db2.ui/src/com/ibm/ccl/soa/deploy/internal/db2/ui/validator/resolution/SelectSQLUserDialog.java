/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Dialog to select a user that can access the database.
 */
public class SelectSQLUserDialog extends Dialog {

	private Combo userIndexCombo;

	private int newValueUserIndex;

	private final String[] users;

	protected SelectSQLUserDialog(Shell parentShell, String[] users) {
		super(parentShell);
		this.users = users;
	}

	/**
	 * Get the selected index of the user.
	 * 
	 * @return the index
	 */
	public int getUserIndex() {
		return newValueUserIndex;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.Select_SQL_User_Dialog);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label labelUserid = new Label(composite, SWT.NONE);
		labelUserid.setText(Messages.SQLUserID);

		userIndexCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		userIndexCombo.setItems(users);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.RESOLUTION_PROPERTY_SET_DIALOG);

		return composite;
	}

	private void initializeControls() {
		if (userIndexCombo.getItemCount() > 0) {
			userIndexCombo.select(0);
		}
	}

	protected void okPressed() {

		newValueUserIndex = userIndexCombo.getSelectionIndex();
		super.okPressed();
	}
}
