/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.synchronization;

import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;

import com.ibm.ccl.soa.deploy.core.internal.datamodels.ISynchronizationDatamodelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

public class SelectTargetsWizardPage extends UserInputWizardPage {

	private Composite container;
	private final SynchronizationRefactoringWizard wizard;
	private final IDataModelListener listener = new IDataModelListener() {

		public void propertyChanged(DataModelEvent event) {
			if (ISynchronizationDatamodelProperties.COMPONENTS.equals(event.getPropertyName())) {
				if (wizard != null) {
					wizard.getContainer().updateButtons();
				}
			}
		}

	};

	public SelectTargetsWizardPage(String name, SynchronizationRefactoringWizard wizard) {
		super(name);
		setTitle(Messages.SynchronizationRefactoringWizard_Select_Components_to_Synchronize);
		this.wizard = wizard;
	}

	public void createControl(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.SYNC_MODEL_TO_WORKSPACE);

		container = new SelectComponentsComposite(wizard, parent, SWT.NONE);
		GridData data = new GridData(GridData.CENTER | GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL
				| GridData.GRAB_VERTICAL);
		data.widthHint = 50;
		data.heightHint = 100;
		container.setLayoutData(data);

		setControl(container);

		IDataModel model = wizard.getDatamodel().getUnderlyingDataModel();
		model.addListener(listener);

	}

	@Override
	public void dispose() {
		IDataModel model = wizard.getDatamodel().getUnderlyingDataModel();
		model.removeListener(listener);
		super.dispose();

	}

	@Override
	public boolean canFlipToNextPage() {
		IDataModel model = wizard.getDatamodel().getUnderlyingDataModel();
		Object value = model.getProperty(ISynchronizationDatamodelProperties.COMPONENTS);
		if (value instanceof Object[]) {
			Object[] selected = (Object[]) value;
			if (selected != null && selected.length > 0) {
				return super.canFlipToNextPage();
			}
		}
		return false;
	}

	protected boolean performFinish() {

		return super.performFinish();
	}
}
