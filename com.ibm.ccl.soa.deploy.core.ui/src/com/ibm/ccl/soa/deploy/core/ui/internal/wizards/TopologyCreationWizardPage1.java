/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.wizards.TopologyCreationWizard;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage;

/**
 * 
 * The first page for the {@link TopologyCreationWizard}. This page captures the essentials for
 * creating a new {@link Topology}.
 * 
 */
public class TopologyCreationWizardPage1 extends DecoratingDataModelWizardPage {
	private final CreateTopologyDataModel dataModel;

	/**
	 * 
	 * @param model -
	 *           An instance of a {@link CreateTopologyDataModel} from the wizard.
	 * @param pageName -
	 *           The name of this page to uniquely identify it.
	 */
	public TopologyCreationWizardPage1(CreateTopologyDataModel model, String pageName) {
		super(model.getUnderlyingDataModel(), pageName);
		dataModel = model;
		setDescription(Messages.DEPLOYMENTMODEL_PAGE1_DESCRIPTION);
		setTitle(Messages.DEPLOYMENTMODEL_PAGE1_TITLE);
	}

	protected Composite createTopLevelComposite(Composite parent) {
		return new CreateTopologyComposite2(parent, SWT.NONE, synchHelper, dataModel);
	}

	protected String[] getValidationPropertyNames() {
		return new String[] { ICreateTopologyDataModelProperties.TOPOLOGY_NAME,
				ICreateTopologyDataModelProperties.SOURCE_PATH,
				ICreateTopologyDataModelProperties.NAMESPACE_PATH,
				ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC,
				ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION,
				IAddToPaletteDataModelProperties.ADD_TO_PALETTE,
				IAddToPaletteDataModelProperties.DATAMODEL };
	}

	protected void intializeDecorationFields() {
		CreateTopologyComposite2 composite = (CreateTopologyComposite2) getControl();
		registerDecoratedField(composite.getNameField(),
				ICreateTopologyDataModelProperties.TOPOLOGY_NAME);
		registerDecoratedField(composite.getSourceFolderField(),
				ICreateTopologyDataModelProperties.SOURCE_PATH);
		registerDecoratedField(composite.getNamespaceField(),
				ICreateTopologyDataModelProperties.NAMESPACE_PATH);
	}

	@Override
	protected void enter() {
		super.enter();
		//Set focus on the name field.
		CreateTopologyComposite2 composite = (CreateTopologyComposite2) getControl();
		if (composite != null) {
			DecoratedField nameField = composite.getNameField();
			if (nameField != null && nameField.getControl() != null) {
				nameField.getControl().setFocus();
			}
		}
	}

	@Override
	public boolean canFlipToNextPage() {
		IDataModel aModel = dataModel.getUnderlyingDataModel().getNestedModel(
				IAddToPaletteDataModelProperties.DATAMODEL);
		AddToPaletteDataModel addDataModel = new AddToPaletteDataModel(aModel);
		return addDataModel.getAddToPalette();
	}

}
