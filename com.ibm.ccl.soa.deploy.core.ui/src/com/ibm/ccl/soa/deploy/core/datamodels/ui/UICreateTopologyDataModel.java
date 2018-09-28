  
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

import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;

/**
 * Provides a UI-aware version of CreateTopologyDataModel API class, that can
 * be used to bind properties to controls on a wizard.
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel
 * @generated (mde.utilities.datamodels)
 */
public class UICreateTopologyDataModel extends CreateTopologyDataModel {
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
	public static CreateTopologyDataModel createUIModel() {
    IDataModel model = DataModelFactory.createDataModel(new CreateTopologyDataModelProvider());
    return new UICreateTopologyDataModel(model);
  }

	/**
   * @param mdl The datamodel to wrap with this type-safe facade.
   * @generated (mde.utilities.datamodels)
   */
	public UICreateTopologyDataModel(IDataModel mdl) {
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
	public void bindContractType(Control control) {
    bindContractType(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindContractType(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.CONTRACT_TYPE, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.CONTRACT_TYPE, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.CONTRACT_TYPE, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.CONTRACT_TYPE, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.CONTRACT_TYPE, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncContractTypeWithUI(final int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.CONTRACT_TYPE, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyName(Control control) {
    bindTopologyName(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyName(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.TOPOLOGY_NAME, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.TOPOLOGY_NAME, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.TOPOLOGY_NAME, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.TOPOLOGY_NAME, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.TOPOLOGY_NAME, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncTopologyNameWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.TOPOLOGY_NAME, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyDescription(Control control) {
    bindTopologyDescription(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindTopologyDescription(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncTopologyDescriptionWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.TOPOLOGY_DESCRIPTION, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDecoratorSemantic(Control control) {
    bindDecoratorSemantic(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDecoratorSemantic(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncDecoratorSemanticWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDecoratorSemanticDescription(Control control) {
    bindDecoratorSemanticDescription(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindDecoratorSemanticDescription(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncDecoratorSemanticDescriptionWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.DECORATOR_SEMANTIC_DESCRIPTION, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindSourcePath(Control control) {
    bindSourcePath(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindSourcePath(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.SOURCE_PATH, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.SOURCE_PATH, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.SOURCE_PATH, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.SOURCE_PATH, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.SOURCE_PATH, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncSourcePathWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.SOURCE_PATH, flags);	
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindNamespacePath(Control control) {
    bindNamespacePath(control, NO_CONTROLS);
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void bindNamespacePath(Control control, Control[] dependentControls) {
     
    if(control instanceof Button) {
      synchHelper.synchCheckbox((Button)control, ICreateTopologyDataModelProperties.NAMESPACE_PATH, dependentControls);
    } else if(control instanceof Combo) {
      synchHelper.synchCombo((Combo)control, ICreateTopologyDataModelProperties.NAMESPACE_PATH, dependentControls);
    } else if(control instanceof Label) {
      synchHelper.synchLabel((Label)control, ICreateTopologyDataModelProperties.NAMESPACE_PATH, dependentControls);
    } else if(control instanceof List) {
      synchHelper.synchList((List)control, ICreateTopologyDataModelProperties.NAMESPACE_PATH, dependentControls);
    } else if(control instanceof Text) {
      synchHelper.synchText((Text)control, ICreateTopologyDataModelProperties.NAMESPACE_PATH, dependentControls);
    }   
  }

	/**
   * @generated (mde.utilities.datamodels)
   */
	public void syncNamespacePathWithUI(int flags) { 
    synchHelper.synchUIWithModel(ICreateTopologyDataModelProperties.NAMESPACE_PATH, flags);	
  }

}
