/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.internal.datamodels.IImportToTopologyDatamodelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ImportToTopologyDatamodelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ImportToTopologyDatamodelProvider;

/**
 * 	 
 * Provides a type-specific implementation of the ImportToTopologyDatamodel model.
 *
 * <p>
 * The following properties are <b>required</b>. If not provided, then 
 * the model is not in a valid state, and the operation will not
 * be able to execute successfully. 
 * </p>
 * <ul>  
 * <li><b>topologyFile</b>: 
 *     The Topology File that will contain the imported unit. The
 *     Topology File must exist and must contain a valid Topology.
 * </li>  
 * <li><b>resources</b>: 
 *     The Resources property.
 * </li> 
 * </ul> 
 * 
 * @generated (mde.utilities.datamodels)
 */
public class ImportToTopologyDatamodel {

	private final IDataModel model;	
	/**
   * Creates and returns an instance of the type-safe API datamodel.
   * 
   * @return An instance of the type-safe API datamodel. 
   * @generated (mde.utilities.datamodels)
   */
	public static ImportToTopologyDatamodel createModel() {
    IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
    return new ImportToTopologyDatamodel(model);
  }

	/**
   * Creates and returns an instance of the underlying provider for this facade.
   *
   * <p>
   * A provider implements the actual logic of a data model. All validation logic, 
   * calculation of default values, and management of property dependencies
   * is handled by the provider.
   * </p>
   * @return An instance of the underlying provider for this facade.
   * @generated (mde.utilities.datamodels)
   */
	public static IDataModelProvider createDatamodelProvider() {
    return new ImportToTopologyDatamodelProvider();
  }
	
	/**
   * Create a type-safe facade for the given datamodel.
   * 
   * @param mdl The datamodel to provide a facade for. 
   * @generated (mde.utilities.datamodels)
   */
	public ImportToTopologyDatamodel(IDataModel mdl) {
    model = mdl;	
  }
    /**
   * Return the value of TopologyFile field.
   * 
   * @return The value of TopologyFile field.
   * @generated (mde.utilities.datamodels)
   */	 
	public IFile getTopologyFile() { 
    return (IFile) model.getProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE); 
  }
	
	/**
   * The Topology File that will contain the imported unit. The
   * Topology File must exist and must contain a valid Topology. 
   * 
   * <p><b>[Required]</b></p>
   * 
   * @param newTopologyFile The new value for the reference.
   * @generated (mde.utilities.datamodels)
   */
	public void setTopologyFile(IFile newTopologyFile) {  
    model.setProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE, newTopologyFile);		
  }	
	 		
	/**
   * Determine if the TopologyFile property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the TopologyFile property is valid. 
   * @see #getTopologyFile()
   * @see #setTopologyFile(IFile) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopologyFile() { 
    return model.validateProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE);
    
  }	
	 
	/**
   * Determine the default value of the TopologyFile property.
   * 
   * @return The default value of the TopologyFile property. 
   * @see #getTopologyFile()
   * @see #setTopologyFile(IFile) 
   * @generated (mde.utilities.datamodels)
   */
	protected IFile getDefaultTopologyFile() {
    return (IFile) model.getDefaultProperty(IImportToTopologyDatamodelProperties.TOPOLOGY_FILE);
  }
	
    /**
   * Return the value of Resources field.
   * 
   * @return The value of Resources field.
   * @generated (mde.utilities.datamodels)
   */	 
	public IResource[] getResources() { 
    return (IResource[]) model.getProperty(IImportToTopologyDatamodelProperties.RESOURCES); 
  }
	
	/**
   * The Resources property. 
   * 
   * <p><b>[Required]</b></p>
   * 
   * @param newResources The new value for the reference.
   * @generated (mde.utilities.datamodels)
   */
	public void setResources(IResource[] newResources) {  
    model.setProperty(IImportToTopologyDatamodelProperties.RESOURCES, newResources);		
  }	
	 		
	/**
   * Determine if the Resources property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the Resources property is valid. 
   * @see #getResources()
   * @see #setResources(IResource[]) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateResources() { 
    return model.validateProperty(IImportToTopologyDatamodelProperties.RESOURCES);
    
  }	
	 
	/**
   * Determine the default value of the Resources property.
   * 
   * @return The default value of the Resources property. 
   * @see #getResources()
   * @see #setResources(IResource[]) 
   * @generated (mde.utilities.datamodels)
   */
	protected IResource[] getDefaultResources() {
    return (IResource[]) model.getDefaultProperty(IImportToTopologyDatamodelProperties.RESOURCES);
  }
		
	/**
   * Create and return an operation that is configured with the values from this datamodel.
   * 
   * @return A ready-to-run operation prepared with this model to carry out the operation. 
   * @generated (mde.utilities.datamodels)
   */
	public IDataModelOperation createConfiguredOperation() {
    ImportToTopologyDatamodelOperation operation = new ImportToTopologyDatamodelOperation(this); 
    return operation;		
  }
	
	/**
	 * The underlying datamodel that backs this facade.
	 *
	 * @return The underlying datamodel that backs this facade.
	 */
	public final IDataModel getUnderlyingDataModel() {
		return model;
	}

	/**
   * Validates all properties associated with this type-safe data model. 
   *
   * @return The collective status of all properties associated with the underlying datamodel. 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validate() {	
    return model.validate(false);
  }	
}
