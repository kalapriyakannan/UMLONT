  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change.ui;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRenameTopologyChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.RenameTopologyChangeProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange;

/**
 * Provides a UI-aware version of RenameTopologyChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameTopologyChange
 * @generated (mde.utilities.datamodels)
 */
public class UIRenameTopologyChange extends RenameTopologyChange {
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
	public static RenameTopologyChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new RenameTopologyChangeProvider());
    return new UIRenameTopologyChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIRenameTopologyChange(IDataModel mdl) {
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
	public void  bindSource(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IRenameTopologyChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IRenameTopologyChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IRenameTopologyChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IRenameTopologyChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IRenameTopologyChangeProperties.SOURCE, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncSourceWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IRenameTopologyChangeProperties.SOURCE, flags);	
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
	public void  bindDestination(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IRenameTopologyChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IRenameTopologyChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IRenameTopologyChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IRenameTopologyChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IRenameTopologyChangeProperties.DESTINATION, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDestinationWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IRenameTopologyChangeProperties.DESTINATION, flags);	
  }
	 
}
