  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.CreateImportChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateImportChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange;

/**
 * Provides a UI-aware version of CreateImportChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateImportChange
 * @generated (mde.utilities.datamodels)
 */
public class UICreateImportChange extends CreateImportChange {
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
	public static CreateImportChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new CreateImportChangeProvider());
    return new UICreateImportChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UICreateImportChange(IDataModel mdl) {
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
	public void bindImports(Control control) {
    bindImports(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindImports(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateImportChangeProperties.IMPORTS, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateImportChangeProperties.IMPORTS, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateImportChangeProperties.IMPORTS, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateImportChangeProperties.IMPORTS, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateImportChangeProperties.IMPORTS, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncImportsWithUI(final int flags) { 
    synchHelper.synchUIWithModel(ICreateImportChangeProperties.IMPORTS, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindImported(Control control) {
    bindImported(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindImported(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateImportChangeProperties.IMPORTED, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateImportChangeProperties.IMPORTED, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateImportChangeProperties.IMPORTED, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateImportChangeProperties.IMPORTED, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateImportChangeProperties.IMPORTED, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncImportedWithUI(final int flags) { 
    synchHelper.synchUIWithModel(ICreateImportChangeProperties.IMPORTED, flags);	
  }
	 
}
