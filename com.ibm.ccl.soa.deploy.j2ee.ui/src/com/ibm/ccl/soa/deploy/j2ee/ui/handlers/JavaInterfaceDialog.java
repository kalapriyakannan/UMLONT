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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.IFileTypeInfo;
import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.JarFileEntryTypeInfo;
import com.ibm.ccl.soa.deploy.j2ee.ui.Messages;

public class JavaInterfaceDialog extends TrayDialog {

	private String displayName;
	private String description;
	private Text txtDisplayName;
	private Text txtDescription;
	private Combo theCombo;
	private Button buttonOpen;
	private Label noInterfaceError;
	private String interfaceStr;
	private Map javaNameMap;
	private boolean isOpenInterface = false;
	private boolean isNoInterfaces = false;
	private DeployModelObject nubDmo = null;
	private boolean isService = false;

	protected JavaInterfaceDialog(Shell parentShell, DeployModelObject nubDmo) {
		super(parentShell);
		this.nubDmo = nubDmo;
		isService = nubDmo != null && nubDmo instanceof Service;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(isService ? Messages.JavaService_Title : Messages.JavaInterface_Title);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		if (isService) {
			addDmoSection(composite);
		}
		addJavaInterfaceSection(composite);

		initializeControls();

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDIT_JAVA_INTERFACE);

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

	private void addJavaInterfaceSection(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group group = new Group(composite, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());
		group.setText(Messages.Interface);

		Label interfaceiLabel = new Label(group, SWT.NONE);
		interfaceiLabel.setText(Messages.JavaInterface_Label);

		theCombo = new Combo(group, SWT.SIMPLE | SWT.V_SCROLL | SWT.BORDER);
		GridData gdCombo = new GridData(GridData.FILL_BOTH);
		gdCombo.horizontalSpan = 1;
		gdCombo.widthHint = 300;
		gdCombo.heightHint = 30 * theCombo.getItemHeight();
		theCombo.setLayoutData(gdCombo);

		addButtons(group);
	}

	private void addButtons(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);

		noInterfaceError = new Label(composite, SWT.NULL);
		if (isNoInterfaces) {
			noInterfaceError.setText(Messages.NoJavaProjectsInWorkspace_Error);
		}
		noInterfaceError.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		buttonOpen = new Button(composite, SWT.PUSH | SWT.CENTER);
		buttonOpen.setText(Messages.OpenInterface_Label);
		setButtonLayoutData(buttonOpen);
		buttonOpen.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				openInterface();
			}
		});

	}

	protected void openInterface() {
		isOpenInterface = true;
		okPressed();
	}

	protected void enableDisableControls() {
		buttonOpen.setEnabled(theCombo.getText().length() > 0);
	}

	public void setInterfaceList(Object[] interfaceObjects) {
		javaNameMap = new HashMap();
		isNoInterfaces = interfaceObjects.length == 0;
		if (!isNoInterfaces) {
			addInterfaceList(interfaceObjects);
		}
	}

	private void addInterfaceList(Object[] interfaceObjects) {
		for (int i = 0; i < interfaceObjects.length; i++) {
			Object o = interfaceObjects[i];
			if (o instanceof JarFileEntryTypeInfo) {
				JarFileEntryTypeInfo jar = (JarFileEntryTypeInfo) o;
				if (jar.isInterface()) {
					javaNameMap.put(jar.getTypeName(), jar.getFullyQualifiedName());
				}
			} else if (o instanceof IFileTypeInfo) {
				IFileTypeInfo file = (IFileTypeInfo) o;
				if (file.isInterface()) {
					javaNameMap.put(file.getTypeName(), file.getFullyQualifiedName());
				}
			}
		}
	}

	private void initializeControls() {
		if (isService) {
			txtDisplayName.setText(nubDmo.getDisplayName() != null ? nubDmo.getDisplayName() : ""); //$NON-NLS-1$
			txtDescription.setText(nubDmo.getDescription() != null ? nubDmo.getDescription() : ""); //$NON-NLS-1$
		}
		String[] packages = (String[]) javaNameMap.keySet().toArray(new String[0]);
		Arrays.sort(packages, new Comparator() {

			public int compare(Object arg0, Object arg1) {
				String name1 = (String) arg0;
				String name2 = (String) arg1;
				return name1.compareToIgnoreCase(name2);
			}

		});
		theCombo.setItems(packages);
		if (interfaceStr != null) {
			theCombo.setText(interfaceStr);
		}
		enableDisableControls();
	}

	public String getInterfaceStr() {
		return interfaceStr;
	}

	public void setInterfaceStr(String interfaceStr) {
		this.interfaceStr = interfaceStr;
	}

	protected void okPressed() {
		if (isService) {
			displayName = txtDisplayName.getText().trim();
			description = txtDescription.getText().trim();
		}
		interfaceStr = theCombo.getText();
		super.okPressed();
	}

	public boolean isOpenInterface() {
		return isOpenInterface;
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
