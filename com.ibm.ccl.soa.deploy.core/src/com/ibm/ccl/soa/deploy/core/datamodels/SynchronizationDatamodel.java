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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ISynchronizationDatamodelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.SynchronizationDatamodelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.SynchronizationDatamodelProvider;

/**
 * 	 
 * The SynchronizationDatamodel is used 
 * by the SynchronizationRefactoringWizard.
 *
 * <p>
 * The following properties are <b>required</b>. If not provided, then 
 * the model is not in a valid state, and the operation will not
 * be able to execute successfully. 
 * </p>
 * <ul>  
 * <li><b>topology</b>: 
 *     The topology that is the target 
 *     of the implementation operation.
 * </li>  
 * <li><b>components</b>: 
 *     The set of components from the associated
 *     topology that should be implemented or
 *     reflected. This field will be empty if creating an 
 *     Import Change.
 * </li>  
 * <li><b>stubs</b>: 
 *     The set of stubs from some external selection
 *     that should be imported. This field will be empty 
 *     if creating an Implementation or Reflection Change.
 * </li> 
 * </ul> 
 * 
 * @generated (mde.utilities.datamodels)
 */
public class SynchronizationDatamodel {

	private final IDataModel model;

	/**
   * Creates and returns an instance of the type-safe API datamodel.
   * 
   * @return An instance of the type-safe API datamodel. 
   * @generated (mde.utilities.datamodels)
   */
	public static SynchronizationDatamodel createModel() {
    IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
    return new SynchronizationDatamodel(model);
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
    return new SynchronizationDatamodelProvider();
  }

	/**
   * Create a type-safe facade for the given datamodel.
   * 
   * @param mdl The datamodel to provide a facade for. 
   * @generated (mde.utilities.datamodels)
   */
	public SynchronizationDatamodel(IDataModel mdl) {
    model = mdl;	
  }

	/**
   * Return the value of Topology field.
   * 
   * @return The value of Topology field.
   * @generated (mde.utilities.datamodels)
   */
	public Topology getTopology() { 
    return (Topology) model.getProperty(ISynchronizationDatamodelProperties.TOPOLOGY); 
  }

	/**
   * The topology that is the target 
   * of the implementation operation. 
   * 
   * <p><b>[Required]</b></p>
   * 
   * @param newTopology The new value for the reference.
   * @generated (mde.utilities.datamodels)
   */
	public void setTopology(Topology newTopology) {  
    model.setProperty(ISynchronizationDatamodelProperties.TOPOLOGY, newTopology);		
  }

	/**
   * Determine if the Topology property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the Topology property is valid. 
   * @see #getTopology()
   * @see #setTopology(Topology) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateTopology() { 
    return model.validateProperty(ISynchronizationDatamodelProperties.TOPOLOGY);
    
  }

	/**
   * Determine the default value of the Topology property.
   * 
   * @return The default value of the Topology property. 
   * @see #getTopology()
   * @see #setTopology(Topology) 
   * @generated (mde.utilities.datamodels)
   */
	protected Topology getDefaultTopology() {
    return (Topology) model.getDefaultProperty(ISynchronizationDatamodelProperties.TOPOLOGY);
  }

	/**
	 * Return the value of Components field.
	 * 
	 * @return The value of Components field.
	 * 
	 */
	public Unit[] getComponents() {
		//It is necessary to check for an Object[] because the DataModelSynchHelper
		//will set Object[] when synchronizing with a check-box tree viewer.
		Object[] units = (Object[]) model.getProperty(ISynchronizationDatamodelProperties.COMPONENTS);
		if (units instanceof Unit[]) {
			return (Unit[]) units;
		}
		Unit[] result = new Unit[units.length];
		System.arraycopy(units, 0, result, 0, units.length);
		return result;
	}

	/**
   * The set of components from the associated
   * topology that should be implemented or
   * reflected. This field will be empty if creating an 
   * Import Change. 
   * 
   * <p><b>[Required]</b></p>
   * 
   * @param newComponents The new value for the reference.
   * @generated (mde.utilities.datamodels)
   */
	public void setComponents(Unit[] newComponents) {  
    model.setProperty(ISynchronizationDatamodelProperties.COMPONENTS, newComponents);		
  }

	/**
   * Return the value of Stubs field.
   * 
   * @return The value of Stubs field.
   * @generated (mde.utilities.datamodels)
   */
	public TopologyUnitStub[] getStubs() { 
    return (TopologyUnitStub[]) model.getProperty(ISynchronizationDatamodelProperties.STUBS); 
  }

	/**
   * The set of stubs from some external selection
   * that should be imported. This field will be empty 
   * if creating an Implementation or Reflection Change. 
   * 
   * <p><b>[Required]</b></p>
   * 
   * @param newStubs The new value for the reference.
   * @generated (mde.utilities.datamodels)
   */
	public void setStubs(TopologyUnitStub[] newStubs) {  
    model.setProperty(ISynchronizationDatamodelProperties.STUBS, newStubs);		
  }

	/**
   * Determine if the Stubs property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the Stubs property is valid. 
   * @see #getStubs()
   * @see #setStubs(TopologyUnitStub[]) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateStubs() { 
    return model.validateProperty(ISynchronizationDatamodelProperties.STUBS);
    
  }

	/**
   * Determine the default value of the Stubs property.
   * 
   * @return The default value of the Stubs property. 
   * @see #getStubs()
   * @see #setStubs(TopologyUnitStub[]) 
   * @generated (mde.utilities.datamodels)
   */
	protected TopologyUnitStub[] getDefaultStubs() {
    return (TopologyUnitStub[]) model.getDefaultProperty(ISynchronizationDatamodelProperties.STUBS);
  }

	/**
   * Determine if the Components property meets all
   * constraints required of it. 
   * 
   * @return A status object indicating error or warning messages, 
   * 	            if any, or OK if the Components property is valid. 
   * @see #getComponents()
   * @see #setComponents(Unit[]) 
   * @generated (mde.utilities.datamodels)
   */
	public IStatus validateComponents() { 
    return model.validateProperty(ISynchronizationDatamodelProperties.COMPONENTS);
    
  }

	/**
   * Determine the default value of the Components property.
   * 
   * @return The default value of the Components property. 
   * @see #getComponents()
   * @see #setComponents(Unit[]) 
   * @generated (mde.utilities.datamodels)
   */
	protected Unit[] getDefaultComponents() {
    return (Unit[]) model.getDefaultProperty(ISynchronizationDatamodelProperties.COMPONENTS);
  }

	/**
   * Create and return an operation that is configured with the values from this datamodel.
   * 
   * @return A ready-to-run operation prepared with this model to carry out the operation. 
   * @generated (mde.utilities.datamodels)
   */
	public IDataModelOperation createConfiguredOperation() {
    SynchronizationDatamodelOperation operation = new SynchronizationDatamodelOperation(this); 
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
