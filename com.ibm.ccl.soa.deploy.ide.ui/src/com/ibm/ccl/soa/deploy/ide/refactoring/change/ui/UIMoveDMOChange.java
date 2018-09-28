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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveDMOChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange;

/**
 * Provides a UI-aware version of MoveDMOChange API class, that can be used to bind properties to
 * controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveDMOChange
 * @generated (mde.utilities.datamodels)
 */
public abstract class UIMoveDMOChange extends MoveDMOChange {
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
	public UIMoveDMOChange(IDataModel mdl) {
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
	public void bindSource(Control control) {
		bindSource(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindSource(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, IMoveDMOChangeProperties.SOURCE,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper
					.synchCombo((Combo) control, IMoveDMOChangeProperties.SOURCE, dependentControls);
		} else if (control instanceof Label) {
			synchHelper
					.synchLabel((Label) control, IMoveDMOChangeProperties.SOURCE, dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, IMoveDMOChangeProperties.SOURCE, dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, IMoveDMOChangeProperties.SOURCE, dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncSourceWithUI(final int flags) {
		synchHelper.synchUIWithModel(IMoveDMOChangeProperties.SOURCE, flags);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindDestination(Control control) {
		bindDestination(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindDestination(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, IMoveDMOChangeProperties.DESTINATION,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, IMoveDMOChangeProperties.DESTINATION,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, IMoveDMOChangeProperties.DESTINATION,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, IMoveDMOChangeProperties.DESTINATION,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, IMoveDMOChangeProperties.DESTINATION,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncDestinationWithUI(final int flags) {
		synchHelper.synchUIWithModel(IMoveDMOChangeProperties.DESTINATION, flags);
	}

}
