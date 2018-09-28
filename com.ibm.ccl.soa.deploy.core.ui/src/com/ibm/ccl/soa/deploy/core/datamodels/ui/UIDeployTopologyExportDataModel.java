  
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

import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DeployTopologyExportDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IDeployTopologyExportDataModelProperties;

/**
 * Provides a UI-aware version of DeployTopologyExportDataModel API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel
 * @generated (mde.utilities.datamodels)
 */
public class UIDeployTopologyExportDataModel extends DeployTopologyExportDataModel {

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
	public static DeployTopologyExportDataModel createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new DeployTopologyExportDataModelProvider());
    return new UIDeployTopologyExportDataModel(model);
  }

	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public UIDeployTopologyExportDataModel(IDataModel mdl) {
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
	public void bindArchiveDestination(Control control) {
    bindArchiveDestination(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindArchiveDestination(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncArchiveDestinationWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindOverwriteExisting(Control control) {
    bindOverwriteExisting(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindOverwriteExisting(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncOverwriteExistingWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindExportSourceFiles(Control control) {
    bindExportSourceFiles(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindExportSourceFiles(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncExportSourceFilesWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindExportWithError(Control control) {
    bindExportWithError(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindExportWithError(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncExportWithErrorWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyHasError(Control control) {
    bindTopologyHasError(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyHasError(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncTopologyHasErrorWithUI(int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.TOPOLOGY_HAS_ERROR, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
  public void bindExportModules(Control control) {
    bindExportModules(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindExportModules(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.EXPORT_MODULES, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.EXPORT_MODULES, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.EXPORT_MODULES, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.EXPORT_MODULES, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.EXPORT_MODULES, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncExportModulesWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.EXPORT_MODULES, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
	public void bindImportedTopologyInUse(Control control) {
    bindImportedTopologyInUse(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindImportedTopologyInUse(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncImportedTopologyInUseWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.IMPORTED_TOPOLOGY_IN_USE, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindCreateLocationBinding(Control control) {
    bindCreateLocationBinding(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindCreateLocationBinding(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncCreateLocationBindingWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindExportProjectName(Control control) {
    bindExportProjectName(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindExportProjectName(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncExportProjectNameWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.EXPORT_PROJECT_NAME, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindCreateExportProject(Control control) {
    bindCreateExportProject(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindCreateExportProject(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncCreateExportProjectWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, flags);	
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void bindExportDiagramResourceIfPresent(Control control) {
    bindExportDiagramResourceIfPresent(control, NO_CONTROLS);
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  bindExportDiagramResourceIfPresent(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, dependentControls);
    }   
  }

  /**
   * @generated (mde.utilities.datamodels)
   */
  public void  syncExportDiagramResourceIfPresentWithUI(final int flags) { 
    synchHelper.synchUIWithModel(IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, flags);	
  }

}
