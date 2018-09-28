/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.IResolutionAttributeDataModelProperties;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.ResolutionAttributeDataModelOperation;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.ResolutionAttributeDataModelProvider;

/**
 * 	 
 * Nested datamodel used to handle attribute operations
 *
 * <p>
 * The following properties are <b>required</b>. If not provided, then 
 * the model is not in a valid state, and the operation will not
 * be able to execute successfully. 
 * </p>
 * <ul>  
 * <li><b>deployModelObject</b>: 
 *     The DeployModelObject property.
 * </li>  
 * <li><b>attribute</b>: 
 *     The Attribute property.
 * </li>  
 * <li><b>attributeName</b>: 
 *     The AttributeName property.
 * </li> 
 * </ul> 
 * 
 * <p>
 * The following <b>nested models</b> are used by this datamodel. Nested
 * datamodels are used to supplement the information collected by
 * an enclosing datamodel 	or to execute nested operations directly. 
 * The type-safe facade provides generates type-safe facades for 
 * each of the nested datamodels, and provides the appropriate 
 * accessors and mutators. 
 * </p>
 * <p>
 * Accessors (methods that begin with "get") will first check the 
 * facaded datamodel for an instance of the nested datamodel, and
 * if found, wrap it in a type-safe facade. Otherwise, the 
 * appropriate datamodel will be created, wrapped, and returned. 
 * </p>
 * <p>
 * Clients are not required to supply their own instances of nested 
 * models (as they are created when accessors ("get") methods are
 * called, but may access the  {@link #getUnderlyingDataModel() underlying datamodel} 
 * directly if they require advanced customization. 
 *</p>
 *<ul> 
 * <li><b>resolutionDataModel</b> (Type: {@link com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel} ) :  
 *     DataModel sets up core arguments for part of a unit of work initated from a resolution
 * </li> 
* </ul> 
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionAttributeDataModel {

	private final IDataModel model;	
	private ResolutionDataModel resolutionDataModel;
	
	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel. 
	 * @generated (mde.utilities.datamodels)
	 */
	public static ResolutionAttributeDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new ResolutionAttributeDataModel(model);
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
		return new ResolutionAttributeDataModelProvider();
	}
	
	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl The datamodel to provide a facade for. 
	 * @generated (mde.utilities.datamodels)
	 */
	public ResolutionAttributeDataModel(IDataModel mdl) {
		model = mdl;	
	}
	/**
	 * The AttributeName property.
	 *
	 * <p><b>[Required]</b></p>
	 * 
	 * @param newAttributeName The new value of the AttributeName property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setAttributeName(String newAttributeName) {
		model.setProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME, newAttributeName);
	}	
	
	/**
	 * The AttributeName property.
	 * 
	 * @return The value of the AttributeName property. 
	 * @generated (mde.utilities.datamodels)
	 */	
	public String getAttributeName() {
		return (String) model.getProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
	}
	
	/**
	 * Determine if the AttributeName property meets all
	 * constraints required of it. 
	 * 
	 * @return A status object indicating error or warning messages, 
	 * 	            if any, or OK if the AttributeName property is valid. 
	 * @see #getAttributeName()
	 * @see #setAttributeName(String) 
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateAttributeName() {
		return model.validateProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
	}	
	
	/**
	 * Determine the default value of the AttributeName property.
	 * 
	 * @return The default value of the AttributeName property. 
	 * @see #getAttributeName()
	 * @see #setAttributeName(String) 
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultAttributeName() {
		return(String) model.getDefaultProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE_NAME);
	} 	 
	
    /**
	 * Return the value of DeployModelObject field.
	 * 
	 * @return The value of DeployModelObject field.
	 * @generated (mde.utilities.datamodels)
	 */	 
	public DeployModelObject getDeployModelObject() { 
		return (DeployModelObject) model.getProperty(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT); 
	}
	
	/**
	 * The DeployModelObject property. 
	 * 
	 * <p><b>[Required]</b></p>
	 * 
	 * @param newDeployModelObject The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDeployModelObject(DeployModelObject newDeployModelObject) {  
		model.setProperty(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT, newDeployModelObject);		
	}	
	 		
	/**
	 * Determine if the DeployModelObject property meets all
	 * constraints required of it. 
	 * 
	 * @return A status object indicating error or warning messages, 
	 * 	            if any, or OK if the DeployModelObject property is valid. 
	 * @see #getDeployModelObject()
	 * @see #setDeployModelObject(DeployModelObject) 
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDeployModelObject() { 
		return model.validateProperty(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT);
		
	}	
	 
	/**
	 * Determine the default value of the DeployModelObject property.
	 * 
	 * @return The default value of the DeployModelObject property. 
	 * @see #getDeployModelObject()
	 * @see #setDeployModelObject(DeployModelObject) 
	 * @generated (mde.utilities.datamodels)
	 */
	protected DeployModelObject getDefaultDeployModelObject() {
		return (DeployModelObject) model.getDefaultProperty(IResolutionAttributeDataModelProperties.DEPLOY_MODEL_OBJECT);
	}
	
    /**
	 * Return the value of Attribute field.
	 * 
	 * @return The value of Attribute field.
	 * @generated (mde.utilities.datamodels)
	 */	 
	public EAttribute getAttribute() { 
		return (EAttribute) model.getProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE); 
	}
	
	/**
	 * The Attribute property. 
	 * 
	 * <p><b>[Required]</b></p>
	 * 
	 * @param newAttribute The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setAttribute(EAttribute newAttribute) {  
		model.setProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE, newAttribute);		
	}	
	 		
	/**
	 * Determine if the Attribute property meets all
	 * constraints required of it. 
	 * 
	 * @return A status object indicating error or warning messages, 
	 * 	            if any, or OK if the Attribute property is valid. 
	 * @see #getAttribute()
	 * @see #setAttribute(EAttribute) 
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateAttribute() { 
		return model.validateProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE);
		
	}	
	 
	/**
	 * Determine the default value of the Attribute property.
	 * 
	 * @return The default value of the Attribute property. 
	 * @see #getAttribute()
	 * @see #setAttribute(EAttribute) 
	 * @generated (mde.utilities.datamodels)
	 */
	protected EAttribute getDefaultAttribute() {
		return (EAttribute) model.getDefaultProperty(IResolutionAttributeDataModelProperties.ATTRIBUTE);
	}
	
	/**
	 * DataModel sets up core arguments for part of a unit of work initated from a resolution 
	 * 
	 * <p>Return the type-safe model for the nested  ResolutionDataModel data model.</p>
	 * 
	 * <p><b>[Required]</b></p>
	 * 
	 * @return The type-safe model for the nested ResolutionDataModel data model. 
	 * @generated (mde.utilities.datamodels)
	 */	 
	public ResolutionDataModel getResolutionDataModel() { 
		if(resolutionDataModel == null) {
			if(model.isNestedModel(IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL)) { 
				IDataModel nestedModel = model.getNestedModel(IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL); 
				resolutionDataModel = new ResolutionDataModel(nestedModel);
			} else {
				resolutionDataModel = ResolutionDataModel.createModel();
				model.addNestedModel(IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL, resolutionDataModel.getUnderlyingDataModel()); 
			}
		} 
		return resolutionDataModel;
		
	}
	 		
	/**
	 * Determine if the ResolutionDataModel property meets all
	 * constraints required of it. 
	 * 
	 * @return A status object indicating error or warning messages, 
	 * 	            if any, or OK if the ResolutionDataModel property is valid. 
	 * @see #getResolutionDataModel()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateResolutionDataModel() { 
		return getResolutionDataModel().validate();
		
	}	
	 
	/**
	 * Determine the default value of the ResolutionDataModel property.
	 * 
	 * @return The default value of the ResolutionDataModel property. 
	 * @see #getResolutionDataModel()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	protected ResolutionDataModel getDefaultResolutionDataModel() {
		return (ResolutionDataModel) model.getDefaultProperty(IResolutionAttributeDataModelProperties.RESOLUTION_DATA_MODEL);
	}
		
	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation. 
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		ResolutionAttributeDataModelOperation operation = new ResolutionAttributeDataModelOperation(this); 
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
