  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.CreateDiagramChangeProvider;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.ICreateDiagramChangeProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange;

/**
 * Provides a UI-aware version of CreateDiagramChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateDiagramChange
 * @generated (mde.utilities.datamodels)
 */
public class UICreateDiagramChange extends CreateDiagramChange {
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
	public static CreateDiagramChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new CreateDiagramChangeProvider());
    return new UICreateDiagramChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UICreateDiagramChange(IDataModel mdl) {
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
	public void bindDiagram(Control control) {
    bindDiagram(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindDiagram(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateDiagramChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateDiagramChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateDiagramChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateDiagramChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateDiagramChangeProperties.DIAGRAM, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDiagramWithUI(final int flags) { 
    synchHelper.synchUIWithModel(ICreateDiagramChangeProperties.DIAGRAM, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindModel(Control control) {
    bindModel(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindModel(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateDiagramChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateDiagramChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateDiagramChangeProperties.MODEL, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateDiagramChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateDiagramChangeProperties.MODEL, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncModelWithUI(final int flags) { 
    synchHelper.synchUIWithModel(ICreateDiagramChangeProperties.MODEL, flags);	
  }
	 
}
