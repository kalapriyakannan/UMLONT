/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change.ui;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRefactoringDataModelChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange;

/**
 * Provides a UI-aware version of DeployRefactoringChange API class, that can be used to bind
 * properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChange
 * @generated (mde.utilities.datamodels)
 */
public abstract class UIRefactoringDataModelChange extends DeployRefactoringChange {
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	protected static final Control[] NO_CONTROLS = new Control[0];

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	private final DataModelSynchHelper synchHelper;

	/**
	 * @param mdl
	 *           The datamodel to wrap with this type-safe facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public UIRefactoringDataModelChange(IDataModel mdl) {
		super(mdl);
		synchHelper = new DataModelSynchHelper(mdl);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void dispose() {
		synchHelper.dispose();
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void synchAllUIWithModel() {
		synchHelper.synchAllUIWithModel();
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindName(Control control) {
		bindName(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindName(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, IRefactoringDataModelChangeProperties.NAME,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, IRefactoringDataModelChangeProperties.NAME,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, IRefactoringDataModelChangeProperties.NAME,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, IRefactoringDataModelChangeProperties.NAME,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, IRefactoringDataModelChangeProperties.NAME,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncNameWithUI(final int flags) {
		synchHelper.synchUIWithModel(IRefactoringDataModelChangeProperties.NAME, flags);
	}

}
