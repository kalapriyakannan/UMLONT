  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IUpdateLinkChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.UpdateLinkChangeProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange;

/**
 * Provides a UI-aware version of UpdateLinkChange API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateLinkChange
 * @generated (mde.utilities.datamodels)
 */
public class UIUpdateLinkChange extends UpdateLinkChange {
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
	public static UpdateLinkChange createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new UpdateLinkChangeProvider());
    return new UIUpdateLinkChange(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIUpdateLinkChange(IDataModel mdl) {
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
	public void bindLink(Control control) {
    bindLink(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindLink(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IUpdateLinkChangeProperties.LINK, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateLinkChangeProperties.LINK, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateLinkChangeProperties.LINK, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateLinkChangeProperties.LINK, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateLinkChangeProperties.LINK, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncLinkWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateLinkChangeProperties.LINK, flags);	
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
      synchHelper.synchCheckbox((Button)control, IUpdateLinkChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateLinkChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateLinkChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateLinkChangeProperties.SOURCE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateLinkChangeProperties.SOURCE, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncSourceWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateLinkChangeProperties.SOURCE, flags);	
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
      synchHelper.synchCheckbox((Button)control, IUpdateLinkChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateLinkChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateLinkChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateLinkChangeProperties.DESTINATION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateLinkChangeProperties.DESTINATION, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDestinationWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateLinkChangeProperties.DESTINATION, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindEndpoint(Control control) {
    bindEndpoint(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindEndpoint(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IUpdateLinkChangeProperties.ENDPOINT, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IUpdateLinkChangeProperties.ENDPOINT, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IUpdateLinkChangeProperties.ENDPOINT, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IUpdateLinkChangeProperties.ENDPOINT, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IUpdateLinkChangeProperties.ENDPOINT, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncEndpointWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IUpdateLinkChangeProperties.ENDPOINT, flags);	
  }
	 
}
