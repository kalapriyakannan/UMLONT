  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.datamodels;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IRenameTopologyModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.RenameTopologyModelProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor;

/**
 * Provides a UI-aware version of RenameTopologyDescriptor API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class UIRenameTopologyRefactoringDataModel extends RenameTopologyDescriptor {
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
	public static RenameTopologyDescriptor createUIModel() {
		IDataModel model = DataModelFactory.createDataModel(new RenameTopologyModelProvider());
		return new UIRenameTopologyRefactoringDataModel(model);
	}
	
	/**
	 * @param mdl The datamodel to wrap with this type-safe facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public  UIRenameTopologyRefactoringDataModel(IDataModel mdl) {
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
	public void bindTopology(Control control) {
		bindTopology(control, NO_CONTROLS);
	} 
	
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void  bindTopology(Control control, Control[] dependentControls) {
		 
		if(control instanceof Button) {
			synchHelper.synchCheckbox((Button)control, IRenameTopologyModelProperties.TOPOLOGY, dependentControls);
		} else if(control instanceof Combo) {
			synchHelper.synchCombo((Combo)control, IRenameTopologyModelProperties.TOPOLOGY, dependentControls);
		} else if(control instanceof Label) {
			synchHelper.synchLabel((Label)control, IRenameTopologyModelProperties.TOPOLOGY, dependentControls);
		} else if(control instanceof List) {
			synchHelper.synchList((List)control, IRenameTopologyModelProperties.TOPOLOGY, dependentControls);
		} else if(control instanceof Text) {
			synchHelper.synchText((Text)control, IRenameTopologyModelProperties.TOPOLOGY, dependentControls);
		}   
	} 
	
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void  syncTopologyWithUI(final int flags) { 
		synchHelper.synchUIWithModel(IRenameTopologyModelProperties.TOPOLOGY, flags);	
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
	public void  bindName(Control control, Control[] dependentControls) {
		 
		if(control instanceof Button) {
			synchHelper.synchCheckbox((Button)control, IRenameTopologyModelProperties.NAME, dependentControls);
		} else if(control instanceof Combo) {
			synchHelper.synchCombo((Combo)control, IRenameTopologyModelProperties.NAME, dependentControls);
		} else if(control instanceof Label) {
			synchHelper.synchLabel((Label)control, IRenameTopologyModelProperties.NAME, dependentControls);
		} else if(control instanceof List) {
			synchHelper.synchList((List)control, IRenameTopologyModelProperties.NAME, dependentControls);
		} else if(control instanceof Text) {
			synchHelper.synchText((Text)control, IRenameTopologyModelProperties.NAME, dependentControls);
		}   
	} 
	
	/**
	 * @generated (mde.utilities.datamodels)
	 */
	public void  syncNameWithUI(final int flags) { 
		synchHelper.synchUIWithModel(IRenameTopologyModelProperties.NAME, flags);	
	}
	 
}
