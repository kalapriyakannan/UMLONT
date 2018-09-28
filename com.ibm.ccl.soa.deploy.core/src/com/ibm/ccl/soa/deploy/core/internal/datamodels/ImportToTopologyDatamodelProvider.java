/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.internal.datamodels;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

/**
 * Clients should not use the provider directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel}.
 * The provider is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.ImportToTopologyDatamodel
 * @generated (mde.utilities.datamodels)
 */
public class ImportToTopologyDatamodelProvider extends AbstractDataModelProvider implements
		IImportToTopologyDatamodelProperties {

	/**
	 * @return A status of OK or an error status indicating some underlying problem with the data.
	 * @see IImportToTopologyDatamodelProperties#TOPOLOGY_FILE
	 * @generated (mde.utilities.datamodels) NOT
	 */
	public IStatus validateTopologyFile() {
		// TODO Remove the @generated tag above and validate the property. 
		if (model.getProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE) instanceof IFile) {

			//IFile topologyFileProperty = (IFile)  model.getProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE);

			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	/**
   * (non-Javadoc)
   * 
   * @see IImportToTopologyDatamodelProperties#TOPOLOGY_FILE 
   * @generated (mde.utilities.datamodels)
   */
	protected IFile getDefaultTopologyFile() {  
    // TODO Return the default value of the TopologyFile property.
    return null; 
  }

	/**
   * @return 
   *		A status of OK or an error status indicating some underlying problem with the data. 
   * @see IImportToTopologyDatamodelProperties#RESOURCES 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateResources() {	
    // TODO Remove the @generated tag above and validate the property. 
    Assert.isTrue(model.getProperty(IImportToTopologyDatamodelProperties.RESOURCES) instanceof IResource[]);		
    
    //IResource[] resourcesProperty = (IResource[])  model.getProperty(IImportToTopologyDatamodelProperties.RESOURCES);
    
    return Status.OK_STATUS; 
  }

	/**
   * (non-Javadoc)
   * 
   * @see IImportToTopologyDatamodelProperties#RESOURCES 
   * @generated (mde.utilities.datamodels)
   */
	protected IResource[] getDefaultResources() {  
    // TODO Return the default value of the Resources property.
    return null; 
  }

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validate(String property) {		
    if(IImportToTopologyDatamodelProperties.RESOURCES.equals(property)) {
      return validateResources();
    } else if(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE.equals(property)) {
      return validateTopologyFile();
    } else {
      return Status.OK_STATUS;
    }
   
  }

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultProperty(String) 
   * @generated (mde.utilities.datamodels)
   */
	public Object getDefaultProperty(String property) {		
    if(IImportToTopologyDatamodelProperties.RESOURCES.equals(property)) {
      return getDefaultResources();
    } else if(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE.equals(property)) {
      return getDefaultTopologyFile();
    } else {
      return null;
    }
   
  }

	/**
   * Override this method to handle dependencies between different
   * properties. That is, if changing a name property updates the 
   * default values of other properties, this is where you respond to
   * these changes.
   * 
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#propertySet(String, Object)
   * @generated (mde.utilities.datamodels)
   */
	public boolean propertySet(String propertyName, Object propertyValue) {
    return super.propertySet(propertyName, propertyValue); 	
  }

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getPropertyNames() 
   * @generated (mde.utilities.datamodels)
   */
	public Set getPropertyNames() {
    Set propertyNames = super.getPropertyNames();
    propertyNames.add(IImportToTopologyDatamodelProperties.RESOURCES);
    propertyNames.add(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE);	
    return propertyNames;		
  }

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation() 
   * @generated (mde.utilities.datamodels)
   */
	public IDataModelOperation getDefaultOperation() {
    return new ImportToTopologyDatamodelOperation(model);
  }

}
