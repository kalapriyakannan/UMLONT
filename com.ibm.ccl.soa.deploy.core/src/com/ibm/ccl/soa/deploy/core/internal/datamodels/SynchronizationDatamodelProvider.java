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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Clients should not use the provider directly, but instead should refer 
 * to the type-safe API class {@link com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel}.
 * The provider is required by the Smart Datamodels Framework (SDF). 
 * 
 * @see com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel
 * @generated (mde.utilities.datamodels)
 */
public class SynchronizationDatamodelProvider extends AbstractDataModelProvider implements
		ISynchronizationDatamodelProperties {

	private static final Unit[] NO_COMPONENTS = new Unit[0];
	private static final TopologyUnitStub[] NO_STUBS = new TopologyUnitStub[0];

	/**
   * @return 
   *		A status of OK or an error status indicating some underlying problem with the data. 
   * @see ISynchronizationDatamodelProperties#TOPOLOGY 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopology() {	
    // TODO Remove the @generated tag above and validate the property. 
    Assert.isTrue(model.getProperty(ISynchronizationDatamodelProperties.TOPOLOGY) instanceof Topology);		
    
    //Topology topologyProperty = (Topology)  model.getProperty(ISynchronizationDatamodelProperties.TOPOLOGY);
    
    return Status.OK_STATUS; 
  }

	/**
	 * (non-Javadoc)
	 * 
	 * @see IImplementationDatamodelProperties#TOPOLOGY
	 */
	protected Topology getDefaultTopology() {
		// TODO Return the default value of the Topology property.
		return null;
	}

	/**
   * @return 
   *		A status of OK or an error status indicating some underlying problem with the data. 
   * @see ISynchronizationDatamodelProperties#COMPONENTS 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateComponents() {	
    // TODO Remove the @generated tag above and validate the property. 
    Assert.isTrue(model.getProperty(ISynchronizationDatamodelProperties.COMPONENTS) instanceof Unit[]);		
    
    //Unit[] componentsProperty = (Unit[])  model.getProperty(ISynchronizationDatamodelProperties.COMPONENTS);
    
    return Status.OK_STATUS; 
  }

	/**
	 * (non-Javadoc)
	 * 
	 * @see IImplementationDatamodelProperties#COMPONENTS
	 * 
	 * @generated (mde.utilities.datamodels) NOT
	 */
	protected Unit[] getDefaultComponents() {
		return NO_COMPONENTS;
	}

	/**
   * @return 
   *		A status of OK or an error status indicating some underlying problem with the data. 
   * @see ISynchronizationDatamodelProperties#STUBS 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateStubs() {	
    // TODO Remove the @generated tag above and validate the property. 
    Assert.isTrue(model.getProperty(ISynchronizationDatamodelProperties.STUBS) instanceof TopologyUnitStub[]);		
    
    //TopologyUnitStub[] stubsProperty = (TopologyUnitStub[])  model.getProperty(ISynchronizationDatamodelProperties.STUBS);
    
    return Status.OK_STATUS; 
  }

	/**
	 * (non-Javadoc)
	 * 
	 * @see ISynchronizationDatamodelProperties#STUBS
	 * @generated (mde.utilities.datamodels) NOT
	 */
	protected TopologyUnitStub[] getDefaultStubs() {
		return NO_STUBS;
	}

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#validate(String) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validate(String property) {		
    if(ISynchronizationDatamodelProperties.COMPONENTS.equals(property)) {
      return validateComponents();
    } else if(ISynchronizationDatamodelProperties.TOPOLOGY.equals(property)) {
      return validateTopology();
    } else if(ISynchronizationDatamodelProperties.STUBS.equals(property)) {
      return validateStubs();
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
    if(ISynchronizationDatamodelProperties.COMPONENTS.equals(property)) {
      return getDefaultComponents();
    } else if(ISynchronizationDatamodelProperties.TOPOLOGY.equals(property)) {
      return getDefaultTopology();
    } else if(ISynchronizationDatamodelProperties.STUBS.equals(property)) {
      return getDefaultStubs();
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
    propertyNames.add(ISynchronizationDatamodelProperties.COMPONENTS);
    propertyNames.add(ISynchronizationDatamodelProperties.TOPOLOGY);
    propertyNames.add(ISynchronizationDatamodelProperties.STUBS);	
    return propertyNames;		
  }

	/**
   * (non-Javadoc)
   * 
   * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider#getDefaultOperation() 
   * @generated (mde.utilities.datamodels)
   */
	public IDataModelOperation getDefaultOperation() {
    return new SynchronizationDatamodelOperation(model);
  }

}
