package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateNamespaceDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage;

public class NamespaceCreationWizardPage1 extends DecoratingDataModelWizardPage {

	private final CreateNamespaceDataModel dataModel;

	/**
	 * 
	 * @param model -
	 *           An instance of a {@link CreateNamespaceDataModel} from the wizard.
	 * @param pageName -
	 *           The name of this page to uniquely identify it.
	 */
	public NamespaceCreationWizardPage1(CreateNamespaceDataModel model, String pageName) {
		super(model.getUnderlyingDataModel(), pageName);
		dataModel = model;
		setDescription(Messages.NamespaceCreationWizardPage1_Select_a_source_folder_and_a_name_f_);
		setTitle(Messages.NamespaceCreationWizard_Namespac_);
	}

	protected Composite createTopLevelComposite(Composite parent) {
		return new CreateNamespaceComposite(parent, SWT.NONE, synchHelper, dataModel);
	}

	@Override
	protected String[] getValidationPropertyNames() {
		return new String[] { ICreateNamespaceDataModelProperties.SOURCE_PATH,
				ICreateNamespaceDataModelProperties.NAMESPACE_PATH };
	}

	@Override
	protected void intializeDecorationFields() {
		CreateNamespaceComposite composite = (CreateNamespaceComposite) getControl();
		registerDecoratedField(composite.getSourceFolderField(),
				ICreateNamespaceDataModelProperties.SOURCE_PATH);
		registerDecoratedField(composite.getNamespaceField(),
				ICreateNamespaceDataModelProperties.NAMESPACE_PATH);
	}

	@Override
	protected void enter() {
		super.enter();
		//Set focus on the namespace field.
		CreateNamespaceComposite composite = (CreateNamespaceComposite) getControl();
		if (composite != null) {
			DecoratedField namespaceField = composite.getNamespaceField();
			if (namespaceField != null && namespaceField.getControl() != null) {
				namespaceField.getControl().setFocus();
			}
		}
	}
}
