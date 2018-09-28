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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * This class is used when you have a primary and secondary PopupDialog. This class will help
 * closing the windows suring certain deactivation events. It ensures that the popup windows do not
 * close when select is made between the windows.
 * 
 * @author daberg
 * 
 */
public class PopupCloserListener implements Listener {
	protected Window primaryPopup;
	protected Window secondaryPopup;

	/**
	 * Create a new PopupCloserListener.
	 * 
	 * @param aPrimaryPopup
	 *           This is the primary popup {@link Window}.
	 * 
	 * @see #setSecondaryPopup(Window)
	 * @see #dispose()
	 */
	public PopupCloserListener(Window aPrimaryPopup) {
		assert aPrimaryPopup != null;
		primaryPopup = aPrimaryPopup;
		initializePrimaryListeners();
	}

	private void initializePrimaryListeners() {
		if (primaryPopup.getShell() != null) {
			Shell controlShell = primaryPopup.getShell();
			controlShell.addListener(SWT.Deactivate, this);
			controlShell.addListener(SWT.Move, this);
			controlShell.addListener(SWT.Resize, this);
		}
	}

	/**
	 * This method should be called when the primaryPopup is closed.
	 */
	public void dispose() {
		if (primaryPopup != null && primaryPopup.getShell() != null) {
			Shell controlShell = primaryPopup.getShell();
			controlShell.removeListener(SWT.Deactivate, this);
			controlShell.removeListener(SWT.Move, this);
			controlShell.removeListener(SWT.Resize, this);
		}
		primaryPopup = null;
		if (secondaryPopup != null && secondaryPopup.getShell() != null) {
			secondaryPopup.getShell().removeListener(SWT.Deactivate, this);
			secondaryPopup.getShell().removeListener(SWT.Dispose, this);
		}
		secondaryPopup = null;
	}

	/**
	 * Set the secondary popup window. This method should only be called once.
	 * 
	 * @param aPopup
	 *           A popup {@link Window}.
	 */
	public void setSecondaryPopup(Window aPopup) {
		assert aPopup != null;
		secondaryPopup = aPopup;
		if (secondaryPopup.getShell() != null) {
			secondaryPopup.getShell().addListener(SWT.Deactivate, this);
			secondaryPopup.getShell().addListener(SWT.Dispose, this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(final Event e) {
		switch (e.type)
		{
		case SWT.Deactivate:
			if (primaryPopup != null) {
				if (e.display == null) {
					primaryPopup.close();
				} else {
					/*
					 * We must run async because focus will not have been shifted during deactivate.
					 */
					e.display.asyncExec(new Runnable() {
						public void run() {
							handleDeactivate(e);
						}
					});
				}
			}
			break;
		case SWT.Move:
		case SWT.Resize:
			/*
			 * 2075: Force the primary shell to have focus. On secondary monitors the focus will shift
			 * to the editor shell during a move or resize. Focus normally stays on the dialog when
			 * shown on the primary monitor.
			 */
			if (primaryPopup != null) {
				primaryPopup.getShell().setFocus();
			}
			if (secondaryPopup != null && secondaryPopup.getShell() != null
					&& !secondaryPopup.getShell().isDisposed()) {
				secondaryPopup.close();
			}
			break;
		}
	}

	protected boolean isPopupShell(Shell aShell) {
		if (primaryPopup != null && primaryPopup.getShell() != null) {
			Shell shell = aShell;
			while (shell != null) {
				if (shell == primaryPopup.getShell() || secondaryPopup != null
						&& shell == secondaryPopup.getShell()) {
					return true;
				}
				shell = (Shell) shell.getParent();
			}
		}
		return false;
	}

	/**
	 * Handles the deactivation of popup windows. Subclasses can override to provide specific window
	 * closing functionality for their popups.
	 * 
	 * @param e
	 *           SWT event
	 */
	protected void handleDeactivate(final Event e) {
		//We just moved off of the detailDialog.  Make sure we haven't
		//gone back to the primary dialog or a child shell of the detailDialog.
		Shell activeShell = e.display.getActiveShell();
		if (activeShell != null) {
			if (!isPopupShell(activeShell)) {
				//We have clicked onto another shell so close.
				closePrimaryPopup();
			}
		} else {
			closePrimaryPopup();
		}
	}

	protected void closePrimaryPopup() {
		if (primaryPopup != null) {
			//Force the secondary to close to ensure any close
			//actions do take place.
			if (secondaryPopup != null) {
				secondaryPopup.close();
			}
			primaryPopup.close();
		}
	}
}
