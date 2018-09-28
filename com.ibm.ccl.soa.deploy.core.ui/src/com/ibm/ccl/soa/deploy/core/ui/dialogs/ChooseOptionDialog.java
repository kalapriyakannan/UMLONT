/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author jswanke
 * 
 */
public class ChooseOptionDialog extends MessageDialog {
	protected int radio;
	protected String[] options;
	/**
	 * CANCEL
	 */
	public static int EXIT = -1;

	/**
	 * @param parentShell
	 * @param title
	 * @param dialogMessage
	 * @param options
	 */
	public ChooseOptionDialog(Shell parentShell, String title, String dialogMessage, String[] options) {
		super(parentShell, title, null, dialogMessage, MessageDialog.QUESTION, new String[] {
				IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
		this.options = options;
		if (options == null) {
			throw new IllegalArgumentException("Must have at least one option"); //$NON-NLS-1$
		}
	}

	protected Control createDialogArea(Composite parent) {
		// create message area 
		createMessageArea(parent);
		createCustomArea(parent);
		return parent;
	}

	protected Control createCustomArea(Composite parent) {
		int size = options.length;
		for (int i = 0; i < size; i++) {
			new Label(parent, SWT.NONE);

			Button radioB = new Button(parent, SWT.RADIO);
			radioB.setText(options[i]);
			final int x = i;
			radioB.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					radio = x;
				}
			});
			if (i == 0) {
				radioB.setSelection(true);
				radio = 0;
			}
		}

		return new Label(parent, SWT.NONE);
	}

	protected void buttonPressed(int buttonId) {
		if (buttonId == 0) {
			setReturnCode(radio);
		} else {
			setReturnCode(EXIT);
		}
		close();
	}
}
