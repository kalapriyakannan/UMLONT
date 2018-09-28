/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.ui;

import org.eclipse.swt.widgets.Control;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.SynchronizationDatamodelProvider;

/**
 * Provides a UI-aware version of ImplementationDatamodel API class, that can be used to bind
 * properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.ImplementationDatamodel
 * @generated (mde.utilities.datamodels)
 */
public class UIImplementationDatamodel extends SynchronizationDatamodel {
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	protected static final Control[] NO_CONTROLS = new Control[0];

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	private DataModelSynchHelper synchHelper;

	/**
	 * Create an instance of the type-safe facade.
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	public static SynchronizationDatamodel createUIModel() {
		IDataModel model = DataModelFactory.createDataModel(new SynchronizationDatamodelProvider());
		return new UIImplementationDatamodel(model);
	}

	/**
	 * @param mdl
	 *           The datamodel to wrap with this type-safe facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public UIImplementationDatamodel(IDataModel mdl) {
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
}
