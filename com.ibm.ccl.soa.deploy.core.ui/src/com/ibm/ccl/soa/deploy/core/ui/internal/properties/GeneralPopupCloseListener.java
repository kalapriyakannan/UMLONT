/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

public class GeneralPopupCloseListener extends PopupCloserListener {

	public GeneralPopupCloseListener(Window primaryPopup) {
		super(primaryPopup);
	}

	@Override
	protected void handleDeactivate(Event e) {
		//We just moved off of the detailDialog.  Make sure we haven't
		//gone back to the primary dialog or a child shell of the detailDialog.
		Shell activeShell = e.display.getActiveShell();
		if (activeShell != null) {
			if (!isPopupShell(activeShell)) {
				//We have clicked onto another shell so close.
				closePrimaryPopup();
			} else if (secondaryPopup != null
					&& !isRelativeShell(secondaryPopup.getShell(), activeShell)
					&& secondaryPopup.getShell() != null && !secondaryPopup.getShell().isDisposed()) {
				secondaryPopup.close();
			}
		} else {
			closePrimaryPopup();
		}
	}

	private boolean isRelativeShell(Shell parent, Shell current) {
		if (current == null || parent == null) {
			return false;
		}
		Shell shell = current;
		while (shell != null) {
			if (shell == parent) {
				return true;
			}
			shell = (Shell) shell.getParent();
		}
		return false;
	}

	@Override
	public void handleEvent(Event e) {
		switch (e.type)
		{
		case SWT.Dispose:
			//Force focus back to the primary window if secondary window gets disposed
			if (secondaryPopup != null && primaryPopup != null
					&& !primaryPopup.getShell().isDisposed()) {
				primaryPopup.getShell().setFocus();
			}
			break;
		default:
			super.handleEvent(e);
		}
	}
}
