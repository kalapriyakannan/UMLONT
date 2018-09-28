  
/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
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

import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.AddToPaletteDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;

/**
 * Provides a UI-aware version of AddToPaletteDataModel API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel
 * @generated (mde.utilities.datamodels)
 */
public class UIAddToPaletteDataModel extends AddToPaletteDataModel {
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
	public static AddToPaletteDataModel createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new AddToPaletteDataModelProvider());
    return new UIAddToPaletteDataModel(model);
  }
	
	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public  UIAddToPaletteDataModel(IDataModel mdl) {
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
	public void bindLabel(Control control) {
    bindLabel(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindLabel(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.LABEL, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.LABEL, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.LABEL, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.LABEL, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.LABEL, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncLabelWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.LABEL, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDescription(Control control) {
    bindDescription(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindDescription(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.DESCRIPTION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.DESCRIPTION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.DESCRIPTION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.DESCRIPTION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.DESCRIPTION, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDescriptionWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.DESCRIPTION, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindStack(Control control) {
    bindStack(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindStack(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.STACK, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.STACK, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.STACK, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.STACK, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.STACK, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncStackWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.STACK, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDrawer(Control control) {
    bindDrawer(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindDrawer(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.DRAWER, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.DRAWER, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.DRAWER, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.DRAWER, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.DRAWER, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncDrawerWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.DRAWER, flags);	
  }
	 
	 
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindIcon(Control control) {
    bindIcon(control, NO_CONTROLS);
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  bindIcon(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.ICON, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.ICON, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.ICON, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.ICON, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.ICON, dependentControls);
    }   
  } 
	
	/**
   * @generated (mde.utilities.datamodels)
   */
	public void  syncIconWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.ICON, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindAddToPalette(Control control) {
    bindAddToPalette(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindAddToPalette(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.ADD_TO_PALETTE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.ADD_TO_PALETTE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.ADD_TO_PALETTE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.ADD_TO_PALETTE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.ADD_TO_PALETTE, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncAddToPaletteWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.ADD_TO_PALETTE, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindProjectName(Control control) {
    bindProjectName(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindProjectName(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.PROJECT_NAME, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.PROJECT_NAME, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.PROJECT_NAME, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.PROJECT_NAME, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.PROJECT_NAME, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncProjectNameWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.PROJECT_NAME, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindTopologyVUri(Control control) {
    bindTopologyVUri(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindTopologyVUri(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncTopologyVUriWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.TOPOLOGY_V_URI, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindCaptureVisuals(Control control) {
    bindCaptureVisuals(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindCaptureVisuals(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.CAPTURE_VISUALS, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncCaptureVisualsWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.CAPTURE_VISUALS, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindEnableCaptureVisuals(Control control) {
    bindEnableCaptureVisuals(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindEnableCaptureVisuals(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncEnableCaptureVisualsWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IAddToPaletteDataModelProperties.ENABLE_CAPTURE_VISUALS, flags);	
  }
	 
}
