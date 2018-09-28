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

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.datamodels.ui.UIImplementationDatamodel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ISynchronizationDatamodelProperties;

public class SynchronizationRefactoringWizard extends RefactoringWizard {

	private static final String SELECTION_PAGE = "SelectionPage"; //$NON-NLS-1$

	private final UIImplementationDatamodel datamodel;

	public SynchronizationRefactoringWizard(Refactoring refactoring,
			SynchronizationDatamodel datamodel) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE);
		this.datamodel = new UIImplementationDatamodel(datamodel.getUnderlyingDataModel());

	}

	protected void addUserInputPages() {
		SelectTargetsWizardPage selectPage = new SelectTargetsWizardPage(SELECTION_PAGE, this);
		setDefaultPageTitle(selectPage.getTitle());
		addPage(selectPage);

	}

	protected final UIImplementationDatamodel getDatamodel() {
		return datamodel;
	}

	@Override
	public boolean canFinish() {

		IDataModel model = getDatamodel().getUnderlyingDataModel();
		Object value = model.getProperty(ISynchronizationDatamodelProperties.COMPONENTS);
		if (value instanceof Object[]) {
			Object[] selected = (Object[]) value;
			if (selected != null && selected.length > 0) {
				return super.canFinish();
			}
		}
		return false;
	}
}
