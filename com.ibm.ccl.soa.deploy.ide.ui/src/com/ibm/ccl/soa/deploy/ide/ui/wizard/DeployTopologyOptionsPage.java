/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.wizard;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.ITopologyCreationSchemeConstants;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationSchemeService;
import com.ibm.ccl.soa.deploy.ide.ui.operation.RCTCreateTopologyExtensionProperties;
import com.ibm.ccl.soa.deploy.ide.ui.provider.DeployableContentProvider;

public class DeployTopologyOptionsPage extends DataModelWizardPage {
	private static final int SIZING_TEXT_FIELD_WIDTH = 350;
	protected Button discoverHostCheckbox;
	protected Button discoverDependenciesCheckbox;
	protected CCombo schemeComboButton;
	private Label schemeDescriptionLabel;

	public DeployTopologyOptionsPage(IDataModel model, String pageName) {
		super(model, pageName);
		setDefaultDescription();
	}

	public DeployTopologyOptionsPage(IDataModel model, String pageName, String title) {
		super(model, pageName);
		setTitle(title);
		setDefaultDescription();
	}

	public DeployTopologyOptionsPage(IDataModel model, String pageName, String title,
			ImageDescriptor titleImage) {
		super(model, pageName, title, titleImage);
		setDefaultDescription();
	}

	private void setDefaultDescription() {
		setDescription(com.ibm.ccl.soa.deploy.ide.ui.Messages.TOPOLOGY_CREATION_WIZARD_OPTIONS_PAGE_DESC);
		setTitle(com.ibm.ccl.soa.deploy.ide.ui.Messages.TOPOLOGY_CREATION_WIZARD_OPTIONS_PAGE_TITLE);
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { RCTCreateTopologyExtensionProperties.TOPOLOGY_CREATION_SCHEME,
				ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER,
				ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER };
	}

	protected Composite createTopLevelComposite(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(top, getInfopopID());
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		/*
		 * Composite composite = new Composite(top, SWT.NONE); GridLayout layout = new GridLayout(2,
		 * false); composite.setLayout(layout); composite.setLayoutData(new
		 * GridData(GridData.FILL_BOTH));
		 */
		createControlGroups(top);
		return top;
	}

	protected void createControlGroups(Composite parent) {
		createVisualizationGroup(parent);
		createSpacer(parent);
		createDiscoveryOptionsGroup(parent);
	}

	private void createSpacer(Composite parent) {
		Label spacer = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		spacer.setLayoutData(data);
	}

	private void createVisualizationGroup(Composite top) {
		Label schemeComboLabel = new Label(top, SWT.NONE);
		schemeComboLabel
				.setText(Messages.RCTDeployTopologyCreationWizardPage1_Topology_Creation_Scheme);

		Composite parent = new Composite(top, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));

		schemeComboButton = new CCombo(parent, SWT.DROP_DOWN | SWT.BORDER);
		schemeComboButton.setEditable(false);

		schemeDescriptionLabel = new Label(parent, SWT.NONE);
		schemeDescriptionLabel.setText(""); //$NON-NLS-1$

		schemeComboButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getDataModel().setProperty(
						RCTCreateTopologyExtensionProperties.TOPOLOGY_CREATION_SCHEME,
						schemeComboButton.getText());
				schemeDescriptionLabel.setText(TopologyCreationSchemeService.INSTANCE.findScheme(
						schemeComboButton.getText()).getDescription());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		fillSchemeCombo(schemeComboButton);

//NO API for CCombo: synchHelper.synchCombo(schemeComboButton, RCTCreateTopologyExtensionProperties.TOPOLOGY_CREATION_SCHEME, null);
	}

	private void fillSchemeCombo(CCombo schemeComboButton) {
		schemeComboButton.removeAll();
		Collection schemeList = TopologyCreationSchemeService.INSTANCE
				.getTopologyCreationSchemesList();
		for (Iterator iter = schemeList.iterator(); iter.hasNext();) {
			TopologyCreationScheme scheme = (TopologyCreationScheme) iter.next();
			schemeComboButton.add(scheme.getName());
		}
		if (schemeList.size() > 0) {
			schemeComboButton
					.setText(ITopologyCreationSchemeConstants.SIMPLE_TOPOLOGY_CREATION_SCHEME);
			schemeDescriptionLabel.setText(TopologyCreationSchemeService.INSTANCE.findScheme(
					ITopologyCreationSchemeConstants.SIMPLE_TOPOLOGY_CREATION_SCHEME).getDescription());
		}
	}

	protected void createDiscoveryOptionsGroup(Composite parent) {
		Label discoveryLabel = new Label(parent, SWT.NONE);
		discoveryLabel
				.setText(Messages.RCTDeployTopologyCreationWizardPage1_Topology_Discovery_Options);

		Composite optionsGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		optionsGroup.setLayout(layout);
		optionsGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		// discover host
		createDiscoverHostCheckbox(optionsGroup);

		// discover dependencies
		//TODO NM:Enable in M2 createDiscoverDependenciesCheckbox(optionsGroup);

	}

	protected void createDiscoverHostCheckbox(Composite optionsGroup) {
		// Overwrite checkbox
		discoverHostCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		discoverHostCheckbox.setText(com.ibm.ccl.soa.deploy.ide.ui.Messages.DISCOVER_HOST_LABEL);
		discoverHostCheckbox.setEnabled(true);
		synchHelper.synchCheckbox(discoverHostCheckbox,
				ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER, null);
	}

	protected void createDiscoverDependenciesCheckbox(Composite optionsGroup) {
		// Overwrite checkbox
		discoverDependenciesCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		discoverDependenciesCheckbox
				.setText(com.ibm.ccl.soa.deploy.ide.ui.Messages.DISCOVER_DEPENDENCIES_LABEL);
		discoverDependenciesCheckbox.setEnabled(false);
		synchHelper.synchCheckbox(discoverDependenciesCheckbox,
				ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER, null);
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
