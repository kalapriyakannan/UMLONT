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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.ui.composites.InterfaceComposite;

public class InterfaceDialog extends RequirementDetailPopupDialog {
	private InterfaceComposite interfaceComposite;

	public InterfaceDialog(Shell parent) {
		super(parent, null);
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent) {
		toolkit = new FormToolkit(Display.getCurrent());
		interfaceComposite = new InterfaceComposite(parent, SWT.NONE, toolkit);
		//	interfaceComposite.setPopupDialog(true, this.getParentShell());
		return interfaceComposite;

	}

	@Override
	public void setInput(Object obj) {
		interfaceComposite.setInput(obj);
		getShell().pack();
	}

}
