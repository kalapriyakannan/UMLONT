/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.Arrays;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * A Dialog that displays lists of Strings. Used by EMF.Edit editors for model objects, and by
 * {@link DmoSyncHelper} to handle attributes with maxOccurs>1
 * 
 * @author Ed Snible
 * @see IsManyDialogCellEditor
 * @deprecated
 */
public class ListEditorDialog extends TrayDialog {

	private List theList;
	private Button buttonAdd;
	private Button buttonDel;
	private java.util.List values;

	/**
	 * @param parentShell
	 */
	public ListEditorDialog(Shell parentShell) {
		super(parentShell);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.ListEditorDialog_LIST_EDITOR);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addBasicSection(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_ARTIFACTS_LIST_EDIT);

		return composite;
	}

	private void addBasicSection(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		theList = new List(composite, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		GridData gdList = new GridData(GridData.FILL_BOTH);
		gdList.horizontalSpan = 1;
		gdList.widthHint = 600;
		gdList.heightHint = 10 * theList.getItemHeight();
		theList.setLayoutData(gdList);
		theList.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		});

		addButtons(composite);
	}

	private void addButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);

		Label spacer = new Label(composite, SWT.NULL);
//		spacer.setText("Spacer"); //$NON-NLS-1$
		spacer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		buttonAdd = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonAdd.setText(Messages.ListEditorDialog_ADD);
//		buttonAdd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		setButtonLayoutData(buttonAdd);
		buttonAdd.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				add();
			}
		});

		buttonDel = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonDel.setText(Messages.ListEditorDialog_DELETE);
//		buttonDel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		setButtonLayoutData(buttonDel);
		buttonDel.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				del();
			}
		});
	}

	protected void del() {
		theList.remove(theList.getSelectionIndices());
	}

	protected void add() {
		InputDialog id = new InputDialog(getShell(), Messages.ListEditorDialog_NEW_ITEM,
				Messages.ListEditorDialog_ENTER_NEW_ITEM, "", null); //$NON-NLS-1$
		if (id.open() == Window.OK) {
			String newValue = id.getValue();
			theList.add(newValue);
		}
	}

	protected void enableDisableControls() {
		buttonDel.setEnabled(theList.getSelectionCount() > 0);
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		dialogChanged();

		return c;
	}

	private void initializeControls() {
		theList.setItems((String[]) values.toArray(new String[0]));
		enableDisableControls();
	}

	private void dialogChanged() {
//	    updateStatus(null);
	}

//	private void updateStatus(String message)
//	{
//	    setErrorMessage(message);
//    	getButton(IDialogConstants.OK_ID).setEnabled(message == null);
//	}

	/**
	 * @param list
	 *           the List of String, values to edit visually
	 */
	public void setList(java.util.List list) {
		values = list;
	}

	/**
	 * @return List of String, the values edited visually
	 */
	public java.util.List getList() {
		return values;
	}

	protected void okPressed() {
		values = Arrays.asList(theList.getItems());

		super.okPressed();
	}

} // end class ListEditorDialog
