/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.ui;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ILinkDiscoveryDataModelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelProvider;

/**
 * Provides a UI-aware version of LinkDiscoveryDataModel API class, that can be used to bind
 * properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel
 * @generated (mde.utilities.datamodels)
 */
public class UILinkDiscoveryDataModel extends LinkDiscoveryDataModel {
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	protected static final Control[] NO_CONTROLS = new Control[0];

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	private final DataModelSynchHelper synchHelper;

	/**
	 * Create an instance of the type-safe facade.
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	public static LinkDiscoveryDataModel createUIModel() {
		IDataModel model = DataModelFactory.createDataModel(new LinkDiscoveryDataModelProvider());
		return new UILinkDiscoveryDataModel(model);
	}

	/**
	 * @param mdl
	 *           The datamodel to wrap with this type-safe facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public UILinkDiscoveryDataModel(IDataModel mdl) {
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
	public void bindIsHosting(Control control) {
		bindIsHosting(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsHosting(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, ILinkDiscoveryDataModelProperties.IS_HOSTING,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, ILinkDiscoveryDataModelProperties.IS_HOSTING,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, ILinkDiscoveryDataModelProperties.IS_HOSTING,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, ILinkDiscoveryDataModelProperties.IS_HOSTING,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, ILinkDiscoveryDataModelProperties.IS_HOSTING,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncIsHostingWithUI(final int flags) {
		synchHelper.synchUIWithModel(ILinkDiscoveryDataModelProperties.IS_HOSTING, flags);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsLogical(Control control) {
		bindIsLogical(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsLogical(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, ILinkDiscoveryDataModelProperties.IS_LOGICAL,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, ILinkDiscoveryDataModelProperties.IS_LOGICAL,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, ILinkDiscoveryDataModelProperties.IS_LOGICAL,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, ILinkDiscoveryDataModelProperties.IS_LOGICAL,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, ILinkDiscoveryDataModelProperties.IS_LOGICAL,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncIsLogicalWithUI(final int flags) {
		synchHelper.synchUIWithModel(ILinkDiscoveryDataModelProperties.IS_LOGICAL, flags);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsDependency(Control control) {
		bindIsDependency(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsDependency(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control,
					ILinkDiscoveryDataModelProperties.IS_DEPENDENCY, dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncIsDependencyWithUI(final int flags) {
		synchHelper.synchUIWithModel(ILinkDiscoveryDataModelProperties.IS_DEPENDENCY, flags);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsGroup(Control control) {
		bindIsGroup(control, NO_CONTROLS);
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void bindIsGroup(Control control, Control[] dependentControls) {

		if (control instanceof Button) {
			synchHelper.synchCheckbox((Button) control, ILinkDiscoveryDataModelProperties.IS_GROUP,
					dependentControls);
		} else if (control instanceof Combo) {
			synchHelper.synchCombo((Combo) control, ILinkDiscoveryDataModelProperties.IS_GROUP,
					dependentControls);
		} else if (control instanceof Label) {
			synchHelper.synchLabel((Label) control, ILinkDiscoveryDataModelProperties.IS_GROUP,
					dependentControls);
		} else if (control instanceof List) {
			synchHelper.synchList((List) control, ILinkDiscoveryDataModelProperties.IS_GROUP,
					dependentControls);
		} else if (control instanceof Text) {
			synchHelper.synchText((Text) control, ILinkDiscoveryDataModelProperties.IS_GROUP,
					dependentControls);
		}
	}

	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void syncIsGroupWithUI(final int flags) {
		synchHelper.synchUIWithModel(ILinkDiscoveryDataModelProperties.IS_GROUP, flags);
	}

}
