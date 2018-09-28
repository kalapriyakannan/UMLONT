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

import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.wizards.TopologyCreationWizard;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage;

/**
 * 
 * The first page for the {@link TopologyCreationWizard}. This page captures the essentials for
 * creating a new {@link Topology}.
 * 
 */
public class AddToPaletteWizardPage extends DecoratingDataModelWizardPage {
	private final AddToPaletteDataModel addtoPaletteDataModel;
	private CreateTopologyDataModel creationDataModel;
	private final String TEMPLATE = Messages.TopologyCreationWizardPage2_Template_;

	/**
	 * 
	 * @param model -
	 *           An instance of a {@link AddToPaletteDataModel} from the wizard.
	 * @param pageName -
	 *           The name of this page to uniquely identify it.
	 */

	public AddToPaletteWizardPage(CreateTopologyDataModel model, String pageName) {
		super(model.getUnderlyingDataModel().getNestedModel(
				IAddToPaletteDataModelProperties.DATAMODEL), pageName);
		IDataModel aModel = model.getUnderlyingDataModel().getNestedModel(
				IAddToPaletteDataModelProperties.DATAMODEL);
		addtoPaletteDataModel = new AddToPaletteDataModel(aModel);
		creationDataModel = model;
		setDescription(Messages.TopologyCreationWizardPage2_Please_describe_the_platte_entry_by_);
		setTitle(Messages.TopologyCreationWizardPage2_Add_Topology_to_Palett_);
	}

	/**
	 * 
	 * @param model -
	 *           An instance of a {@link AddToPaletteDataModel} from the wizard.
	 * @param pageName -
	 *           The name of this page to uniquely identify it.
	 */

	public AddToPaletteWizardPage(AddToPaletteDataModel model, String pageName) {
		super(model.getUnderlyingDataModel(), pageName);
		addtoPaletteDataModel = model;
		setDescription(Messages.TopologyCreationWizardPage2_Please_describe_the_platte_entry_by_);
		setTitle(Messages.TopologyCreationWizardPage2_Add_Topology_to_Palett_);
	}

	private void transferDataModelInformation() {
		addtoPaletteDataModel.setLabel(creationDataModel.getTopologyName()
				+ IAddToPaletteDataModelProperties.UNDERSCORE
				+ IAddToPaletteDataModelProperties.PALATTE_ENTRY);
		addtoPaletteDataModel.setDescription(getDescription(creationDataModel
				.getDefaultTopologyDescription()));
		String projectName = getProjectName();
		addtoPaletteDataModel.setProjectName(projectName);

	}

	private String getDescription(String stringProperty) {
		return TEMPLATE + " " + stringProperty; //$NON-NLS-1$
	}

	protected Composite createTopLevelComposite(Composite parent) {
		if (addtoPaletteDataModel.getUnderlyingDataModel().isPropertySet(
				IAddToPaletteDataModelProperties.TOPOLOGY)) {
			addtoPaletteDataModel.setLabel(addtoPaletteDataModel.getTopology().getName()
					+ IAddToPaletteDataModelProperties.UNDERSCORE
					+ IAddToPaletteDataModelProperties.PALATTE_ENTRY);
			addtoPaletteDataModel.setLabel(addtoPaletteDataModel.getDefaultLabel());
		}
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_ADD_TO_PALETTE_WIZARD);
		return new CreateAddtoPaletteComposite(parent, SWT.NONE, synchHelper, addtoPaletteDataModel);

	}

	protected String[] getValidationPropertyNames() {
		return new String[] { IAddToPaletteDataModelProperties.LABEL,
				IAddToPaletteDataModelProperties.ICON, IAddToPaletteDataModelProperties.DRAWER,
				IAddToPaletteDataModelProperties.ADD_TO_PALETTE,
				IAddToPaletteDataModelProperties.STACK, IAddToPaletteDataModelProperties.DESCRIPTION,
				IAddToPaletteDataModelProperties.DATAMODEL };
	}

	@Override
	protected void intializeDecorationFields() {
	}

	@Override
	protected void enter() {

		if (creationDataModel != null) {
			transferDataModelInformation();
		}

		super.enter();
	}

	private String getProjectName() {
		String projectName = creationDataModel.getSourcePath();
		int x = projectName.indexOf("/"); //$NON-NLS-1$
		if (x < 0) {
			return ""; //$NON-NLS-1$
		}
		projectName = projectName.substring(0, x);
		return ProjectUtilities.getProject(projectName).getName();
	}

}
