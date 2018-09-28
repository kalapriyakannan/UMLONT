package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.AddToPaletteDataModelProvider;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage.IDecoratingWizard;

/**
 * @since 7.0
 * 
 */
public class AddToPaletteDataModelWizard extends DataModelWizard implements IExecutableExtension,
		IDecoratingWizard {

	private final AddToPaletteDataModel dataModel;

	public AddToPaletteDataModelWizard(AddToPaletteDataModel dataModel) {
		this.dataModel = dataModel;
		setDataModel(dataModel.getUnderlyingDataModel());
		setWindowTitle(Messages.BankUnitAction_Add_to_Palett_);
	}

	@Override
	protected IDataModelProvider getDefaultProvider() {
		AddToPaletteDataModelProvider provider = new AddToPaletteDataModelProvider();
		provider.setDataModel(dataModel.getUnderlyingDataModel());
		return provider;
	}

	@Override
	protected void doAddPages() {
		addPage(new AddToPaletteWizardPage(dataModel,
				Messages.TopologyCreationWizardPage2_Add_Topology_to_Palett_));
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	public boolean isExecuting() {
		return super.isExecuting();
	}

}
