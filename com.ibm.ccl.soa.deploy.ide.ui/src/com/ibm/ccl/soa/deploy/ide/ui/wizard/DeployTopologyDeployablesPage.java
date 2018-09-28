/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.ide.ui.operation.RCTCreateTopologyExtensionProperties;
import com.ibm.ccl.soa.deploy.ide.ui.provider.DeployableContentProvider;

public class DeployTopologyDeployablesPage extends DataModelWizardPage {
	private static final int SIZING_TEXT_FIELD_WIDTH = 350;
	private CheckboxTableViewer selectedUnitsList;

	public DeployTopologyDeployablesPage(IDataModel model, String pageName) {
		super(model, pageName);
		setDefaultDescription();
	}

	public DeployTopologyDeployablesPage(IDataModel model, String pageName, String title) {
		super(model, pageName);
		setTitle(title);
		setDefaultDescription();
	}

	public DeployTopologyDeployablesPage(IDataModel model, String pageName, String title,
			ImageDescriptor titleImage) {
		super(model, pageName, title, titleImage);
		setDefaultDescription();
	}

	private void setDefaultDescription() {
		setDescription(com.ibm.ccl.soa.deploy.ide.ui.Messages.TOPOLOGY_CREATION_WIZARD_DEPLOYABLE_PAGE_DESC);
		setTitle(com.ibm.ccl.soa.deploy.ide.ui.Messages.TOPOLOGY_CREATION_WIZARD_DEPLOYABLE_PAGE_TITLE);
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { RCTCreateTopologyExtensionProperties.DEPLOYABLE_SELECTED_ITEMS };
	}

	protected Composite createTopLevelComposite(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(top, getInfopopID());
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(top, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		createControlGroups(composite);

		//TODO NM: the change even is not getting fired by calling setAllChecked method, until then commenting this. 
		// createAdditionalButtonControls(top);

		return top;
	}

	protected void createControlGroups(Composite parent) {
		createDeployableComposite(parent);

	}

	private void createDeployableComposite(Composite parent) {

//		Label spacer = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
//		GridData data = getCommonGridData();
//		data.horizontalSpan = 2;
//		spacer.setLayoutData(data);

		Group deployableComposite = new Group(parent, SWT.NONE);
		deployableComposite.setText(Messages.RCTDeployTopologyCreationWizardPage2_Deployables_);
		deployableComposite.setLayoutData(getCommonGridData());
		deployableComposite.setLayout(new GridLayout());

		Table table = new Table(deployableComposite, SWT.CHECK | SWT.BORDER);
		table.setLayoutData(getCommonGridData());
		table.setLayout(new GridLayout());
		selectedUnitsList = new CheckboxTableViewer(table);
		selectedUnitsList.setContentProvider(getDeployableContentProvider());
		selectedUnitsList.setLabelProvider(getDeployableLabelProvider());
		selectedUnitsList.setInput(getDataModel());

		synchHelper.synchCheckBoxTableViewer(selectedUnitsList,
				RCTCreateTopologyExtensionProperties.DEPLOYABLE_SELECTED_ITEMS, null);

	}

	private void createAdditionalButtonControls(Composite top) {
		/** Add "Select All" and "Deselect All" buttons */
		Composite btnComposite = new Composite(top, SWT.NONE);
		btnComposite.setLayout(new GridLayout(2, false));

		Button selAllBtn = new Button(btnComposite, SWT.PUSH);
		selAllBtn.setText(Messages.TOPOLOGY_BTN_SELECT_ALL_TXT);
		selAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectedUnitsList.setAllChecked(true);
			}
		});

		Button deselAllBtn = new Button(btnComposite, SWT.PUSH);
		deselAllBtn.setText(Messages.TOPOLOGY_BTN_DESELECT_ALL_TXT);
		deselAllBtn.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectedUnitsList.setAllChecked(false);
			}
		});
	}

	private IBaseLabelProvider getDeployableLabelProvider() {
		return new WorkbenchLabelProvider();
	}

	private IStructuredContentProvider getDeployableContentProvider() {
		return new DeployableContentProvider();
	}

	private GridData getCommonGridData() {
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		return data;

	}

}
