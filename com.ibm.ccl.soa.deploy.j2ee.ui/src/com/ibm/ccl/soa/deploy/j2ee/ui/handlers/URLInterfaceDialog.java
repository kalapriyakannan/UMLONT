/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.ui.handlers;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;

public class URLInterfaceDialog extends TrayDialog {

	private String displayName;
	private String description;
	private Text txtDisplayName;
	private Text txtDescription;
	private List theParamList;
	private Button buttonAdd;
	private Button buttonDel;
	private java.util.List paramList;
	private boolean isOpenServlet = false;
	private DeployModelObject nubDmo = null;
	private boolean isService = false;

	protected URLInterfaceDialog(Shell parentShell, DeployModelObject nubDmo) {
		super(parentShell);
		this.nubDmo = nubDmo;
		isService = nubDmo != null && nubDmo instanceof Service;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(isService ? Messages.URLService_Title : Messages.URLInterface_Title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		if (isService) {
			addDmoSection(composite);
		}
		addInterfaceSection(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDIT_URL_INTERFACE);

		return composite;
	}

	private void addDmoSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());
		group.setText(Messages.Service);

		Label promptName = new Label(group, SWT.NONE);
		promptName.setText(Messages.DisplayName);
		txtDisplayName = new Text(group, SWT.BORDER);
		txtDisplayName.setLayoutData(gd);

		Label promptDesc = new Label(group, SWT.NONE);
		promptDesc.setText(Messages.Description);
		txtDescription = new Text(group, SWT.BORDER);
		txtDescription.setLayoutData(gd);
	}

	private void addInterfaceSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());
		group.setText(Messages.Interface);

		Label parameterLabel = new Label(group, SWT.NONE);
		parameterLabel.setText(Messages.ParamInterface_Label);

		theParamList = new List(group, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		GridData gdList = new GridData(GridData.FILL_BOTH);
		gdList.horizontalSpan = 1;
		gdList.widthHint = 300;
		gdList.heightHint = 10 * theParamList.getItemHeight();
		theParamList.setLayoutData(gdList);
		theParamList.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		});

		addButtons(group);
	}

	private void addButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);

		buttonAdd = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonAdd.setText(Messages.InterfaceDialog_ADD);
		setButtonLayoutData(buttonAdd);
		buttonAdd.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				add();
			}
		});

		buttonDel = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonDel.setText(Messages.InterfaceDialog_DELETE);
		setButtonLayoutData(buttonDel);
		buttonDel.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				delete();
			}
		});

	}

	protected void add() {
		InputDialog id = new InputDialog(getShell(), Messages.Add_Parameter_Title,
				Messages.Add_Parameter_Label, "", null); //$NON-NLS-1$
		if (id.open() == Window.OK) {
			String newValue = id.getValue();
			theParamList.add(newValue);
		}
	}

	protected void delete() {
		theParamList.remove(theParamList.getSelectionIndices());
	}

	protected void openServlet() {
		isOpenServlet = true;
		okPressed();
	}

	protected void enableDisableControls() {
		buttonDel.setEnabled(theParamList.getSelectionCount() > 0);
	}

	public void setParamList(java.util.List list) {
		paramList = list;
	}

	public java.util.List getParamList() {
		return paramList;
	}

	private void initializeControls() {
		if (isService) {
			txtDisplayName.setText(nubDmo.getDisplayName() != null ? nubDmo.getDisplayName() : ""); //$NON-NLS-1$
			txtDescription.setText(nubDmo.getDescription() != null ? nubDmo.getDescription() : ""); //$NON-NLS-1$
		}
		theParamList.setItems((String[]) paramList.toArray(new String[0]));
		enableDisableControls();
	}

	protected void okPressed() {
		if (isService) {
			displayName = txtDisplayName.getText().trim();
			description = txtDescription.getText().trim();
		}
		paramList = Arrays.asList(theParamList.getItems());
		super.okPressed();
	}

	public boolean isOpenServlet() {
		return isOpenServlet;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDescription() {
		return description;
	}

	public boolean isService() {
		return isService;
	}

}
