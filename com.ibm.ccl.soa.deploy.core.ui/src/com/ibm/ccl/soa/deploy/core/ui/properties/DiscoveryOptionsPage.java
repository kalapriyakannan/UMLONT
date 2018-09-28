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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.datamodels.ui.UILinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ILinkDiscoveryDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * @author Ed Snible
 * @see NewLinkWizard
 */
public class DiscoveryOptionsPage extends DataModelWizardPage {

	private static final String PAGE_NAME = "DiscoveryTypeSelect"; //$NON-NLS-1$

	private UILinkDiscoveryDataModel uiLinkDataModel = null;

	private Button buttonHosting;
	private Button buttonDependency;
	private Button buttonGroup;
//	private Button buttonLogical;
	protected Composite parentComposite;

	/**
	 * @param model
	 */
	public DiscoveryOptionsPage(IDataModel model) {
		super(model, PAGE_NAME);
		uiLinkDataModel = new UILinkDiscoveryDataModel(model);
		setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_TITLE);
		setDescription(Messages.DiscoveryOptionsPage_User_defines_link_relationship_used_);

	}

	public Composite createTopLevelComposite(Composite parent) {
		parentComposite = parent;

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group group = new Group(composite, SWT.NONE);
		group.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_SELECT_OPTION_SELECTION);
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		group.setLayout(new GridLayout());

		buttonHosting = new Button(group, SWT.RADIO);
		buttonHosting.setText("Hosting links"); //$NON-NLS-1$
		uiLinkDataModel.bindIsHosting(buttonHosting);

		buttonDependency = new Button(group, SWT.RADIO);
		buttonDependency.setText("Dependency links"); //$NON-NLS-1$
		uiLinkDataModel.bindIsDependency(buttonDependency);

		buttonGroup = new Button(group, SWT.RADIO);
		buttonGroup.setText("Containers"); //$NON-NLS-1$
		uiLinkDataModel.bindIsGroup(buttonGroup);

//		buttonLogical = new Button(group, SWT.RADIO);
//		buttonLogical.setText("Logical links"); //$NON-NLS-1$
//		uiLinkDataModel.bindIsLogical(buttonLogical);

		return composite;

	}

	protected String[] getValidationPropertyNames() {
		String[] propertyNames = new String[] {
				ILinkDiscoveryDataModelProperties.IS_HOSTING,
				ILinkDiscoveryDataModelProperties.UNIT,
//				ILinkDiscoveryDataModelProperties.IS_LOGICAL,
				ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
				ILinkDiscoveryDataModelProperties.IS_GROUP,
				ILinkDiscoveryDataModelProperties.REQUIREMENT };
		return propertyNames;
	}

}
