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

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.ui.composites.InterfaceComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;

/**
 * A PopupDialog for editing Interfaces.
 * 
 * @author Ed Snible
 * @see NubEditDialog
 */
public class InterfaceEditPopupDialog extends PopupDialog {

	private final Point loc;
	private final Interface interfaceObj;
	private FormToolkit toolkit;

	//	private boolean modal;

	/**
	 * @param shell
	 * @param pos
	 * @param interfaze
	 */
	public InterfaceEditPopupDialog(Shell shell, Point pos, Interface interfaze) {
		super(shell, SWT.RESIZE, false, false, false, false, null, null);

		loc = pos;
		interfaceObj = interfaze;
	}

	/** Call PopupDialog.createContents(), then go back and re-color to avoid hideous yellow. */
	protected Control createContents(Composite parent) {
		Control composite = super.createContents(parent);

		applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
				parent);
		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
				parent);
		DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose((Composite) composite, this);

//		applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
//				composite, getForegroundColorExclusions());
//		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
//				composite, getBackgroundColorExclusions());

		return composite;
	}

//	protected void applyBackgroundColor(Color color, Control control, List exclusions) {
//		if (!exclusions.contains(control)) {
//			control.setBackground(color);
//		}
//		if (control instanceof Composite) {
//			Control[] children = ((Composite) control).getChildren();
//			for (int i = 0; i < children.length; i++) {
//				applyBackgroundColor(color, children[i], exclusions);
//			}
//		}
//	}
//
//	protected void applyForegroundColor(Color color, Control control, List exclusions) {
//		if (!exclusions.contains(control)) {
//			control.setForeground(color);
//		}
//		if (control instanceof Composite) {
//			Control[] children = ((Composite) control).getChildren();
//			for (int i = 0; i < children.length; i++) {
//				applyForegroundColor(color, children[i], exclusions);
//			}
//		}
//	}

	protected Control createDialogArea(Composite parent) {
		toolkit = new FormToolkit(Display.getDefault());
		InterfaceComposite interfaceComposite = new InterfaceComposite(parent, SWT.NONE, toolkit);
		interfaceComposite.setInput(interfaceObj);
		return interfaceComposite;
	}

//	@Override
//	public int open() {
//		this.getShell().addDisposeListener(new DisposeListener() {
//
//			public void widgetDisposed(DisposeEvent e) {
//				dispose();
//			}
//		});
//		return super.open();
//	}
//
//	private void dispose() {
//		if (uihandler != null) {
//			uihandler.aboutToBeHidden();
//		}
//	}

	protected Point getInitialLocation(Point initialSize) {
		if (loc == null) {
			return super.getInitialLocation(initialSize);
		}
		return loc;
	}

	@Override
	protected ShellListener getShellListener() {
		return new ShellAdapter() {
			public void shellClosed(ShellEvent event) {
				setReturnCode(CANCEL);
				close();
			}

		};
	}

	@Override
	public int open() {
		this.getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if (toolkit != null) {
					toolkit.dispose();
				}
			}
		});
		return super.open();
	}

//	public Interface getInterfaceObj() {
//		return interfaceObj;
//	}
//
//	public void setInterfaceObj(Interface interfaceObj) {
//		this.interfaceObj = interfaceObj;
//	}

} // end class InterfaceEditPopupDialog
