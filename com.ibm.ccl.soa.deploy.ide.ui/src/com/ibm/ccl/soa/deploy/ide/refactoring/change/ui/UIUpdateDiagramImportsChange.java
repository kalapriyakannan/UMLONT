  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateDiagramImportsChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateDiagramImportsChangeProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange;

/**
 * Provides a UI-aware version of UpdateDiagramImportsChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange
 * @generated (mde.utilities.datamodels)
 */
public class UIUpdateDiagramImportsChange extends UpdateDiagramImportsChange {
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
	public static UpdateDiagramImportsChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new UpdateDiagramImportsChangeProvider());
    return new UIUpdateDiagramImportsChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIUpdateDiagramImportsChange(IDataModel mdl) {
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
      synchHelper.synchCheckbox((Button)control, IUpdateDiagramImportsChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateDiagramImportsChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateDiagramImportsChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateDiagramImportsChangeProperties.DIAGRAM, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateDiagramImportsChangeProperties.DIAGRAM, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDiagramWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateDiagramImportsChangeProperties.DIAGRAM, flags);	
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
      synchHelper.synchCheckbox((Button)control, IUpdateDiagramImportsChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateDiagramImportsChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateDiagramImportsChangeProperties.MODEL, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateDiagramImportsChangeProperties.MODEL, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateDiagramImportsChangeProperties.MODEL, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncModelWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateDiagramImportsChangeProperties.MODEL, flags);	
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
      synchHelper.synchCheckbox((Button)control, IUpdateDiagramImportsChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateDiagramImportsChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateDiagramImportsChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateDiagramImportsChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateDiagramImportsChangeProperties.SOURCE, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncSourceWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateDiagramImportsChangeProperties.SOURCE, flags);	
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
      synchHelper.synchCheckbox((Button)control, IUpdateDiagramImportsChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateDiagramImportsChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateDiagramImportsChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateDiagramImportsChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateDiagramImportsChangeProperties.DESTINATION, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDestinationWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateDiagramImportsChangeProperties.DESTINATION, flags);	
  }
	 
}
