  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IMoveResourceChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.MoveResourceChangeProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveResourceChange;

/**
 * Provides a UI-aware version of MoveResourceChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveResourceChange
 * @generated (mde.utilities.datamodels)
 */
public class UIMoveResourceChange extends MoveResourceChange {
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
	public static MoveResourceChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new MoveResourceChangeProvider());
    return new UIMoveResourceChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIMoveResourceChange(IDataModel mdl) {
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
      synchHelper.synchCheckbox((Button)control, IMoveResourceChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveResourceChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveResourceChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveResourceChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveResourceChangeProperties.SOURCE, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncSourceWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveResourceChangeProperties.SOURCE, flags);	
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
      synchHelper.synchCheckbox((Button)control, IMoveResourceChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveResourceChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveResourceChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveResourceChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveResourceChangeProperties.DESTINATION, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDestinationWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveResourceChangeProperties.DESTINATION, flags);	
  }
	 
}
