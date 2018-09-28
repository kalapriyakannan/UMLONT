  
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

import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.MoveUnitsModelProvider;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor;

/**
 * Provides a UI-aware version of MoveUnitsRefactoringDescriptor API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class UIMoveUnitsRefactoringDataModel extends MoveUnitsRefactoringDescriptor {
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
	public static MoveUnitsRefactoringDescriptor createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new MoveUnitsModelProvider());
    return new UIMoveUnitsRefactoringDataModel(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIMoveUnitsRefactoringDataModel(IDataModel mdl) {
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
	public void bindUseExistingTopology(Control control) {
    bindUseExistingTopology(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindUseExistingTopology(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncUseExistingTopologyWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveUnitsModelProperties.USE_EXISTING_TOPOLOGY, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindPreserveLinks(Control control) {
    bindPreserveLinks(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindPreserveLinks(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IMoveUnitsModelProperties.PRESERVE_LINKS, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveUnitsModelProperties.PRESERVE_LINKS, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveUnitsModelProperties.PRESERVE_LINKS, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveUnitsModelProperties.PRESERVE_LINKS, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveUnitsModelProperties.PRESERVE_LINKS, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncPreserveLinksWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveUnitsModelProperties.PRESERVE_LINKS, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindExistingTopologyFile(Control control) {
    bindExistingTopologyFile(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindExistingTopologyFile(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncExistingTopologyFileWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveUnitsModelProperties.EXISTING_TOPOLOGY_FILE, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindPreserveLinksRestricted(Control control) {
    bindPreserveLinksRestricted(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindPreserveLinksRestricted(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncPreserveLinksRestrictedWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IMoveUnitsModelProperties.PRESERVE_LINKS_RESTRICTED, flags);	
  }
	 
}
