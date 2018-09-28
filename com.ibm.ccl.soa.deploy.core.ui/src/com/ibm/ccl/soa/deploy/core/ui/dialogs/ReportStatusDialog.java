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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author jswanke
 * 
 */
public class ReportStatusDialog extends MessageDialog {
	protected List statusList;

	/**
	 * @param parentShell
	 * @param title
	 * @param dialogMessage
	 * @param status
	 */
	public ReportStatusDialog(Shell parentShell, String title, String dialogMessage, IStatus status) {
		super(parentShell, title, null, dialogMessage,
				status.getSeverity() == IStatus.ERROR ? MessageDialog.ERROR
						: status.getSeverity() == IStatus.WARNING ? MessageDialog.WARNING
								: MessageDialog.INFORMATION, new String[] { IDialogConstants.OK_LABEL }, 0);
		if (status == null) {
			throw new IllegalArgumentException("Must have at least one status"); //$NON-NLS-1$
		}

		statusList = new ArrayList();
		if (!status.isMultiStatus()) {
			statusList.add(status.getMessage());
		} else {
			IStatus[] children = status.getChildren();
			for (int i = 0; i < children.length; i++) {
				statusList.add(children[i].getMessage());
			}
		}
	}

	protected Control createCustomArea(Composite parent) {
		int size = statusList.size();
		StringBuffer buff = new StringBuffer();
		String nl = System.getProperty("line.separator"); //$NON-NLS-1$
		for (int i = 0; i < size; i++) {
			buff.append((String) statusList.get(i));
			if (i + 1 < size) {
				buff.append(nl);
				buff.append(nl);
			}
		}
		Text status = new Text(parent, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		status.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		status.setEditable(false);
		GridData gd = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true);
		gd.widthHint = 450;
		gd.heightHint = 100;
		status.setLayoutData(gd);
		status.setText(buff.toString());
		return status;
	}
}
