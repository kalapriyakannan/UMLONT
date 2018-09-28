/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterValueDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.IResolutionDataModelProperties;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.ResolutionDataModelOperation;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.ResolutionDataModelProvider;

/**
 * 
 * DataModel sets up core arguments for part of a unit of work initated from a resolution
 * 
 * <p>
 * The following properties are <b>required</b>. If not provided, then the model is not in a valid
 * state, and the operation will not be able to execute successfully.
 * </p>
 * <ul>
 * <li><b>resolution</b>: parent resolution adding children datamodels </li>
 * <li><b>validValues</b>: The ValidValues property. </li>
 * <li><b>immutableValidValues</b>: The ImmutableValidValues property. </li>
 * <li><b>type</b>: type of data </li>
 * <li><b>value</b>: The Value property. </li>
 * <li><b>defaultValue</b>: The DefaultValue property. </li>
 * <li><b>name</b>: idenitifier </li>
 * <li><b>description</b>: The Description property. </li>
 * <li><b>valueSet</b>: The ValueSet property. </li>
 * <li><b>validValueListExclusive</b>: The ValidValueListExclusive property. </li>
 * </ul>
 * 
 * @generated (mde.utilities.datamodels)
 */
public class ResolutionDataModel {

	private final IDataModel model;

	/**
	 * Creates and returns an instance of the type-safe API datamodel.
	 * 
	 * @return An instance of the type-safe API datamodel.
	 * @generated (mde.utilities.datamodels)
	 */
	public static ResolutionDataModel createModel() {
		IDataModel model = DataModelFactory.createDataModel(createDatamodelProvider());
		return new ResolutionDataModel(model);
	}

	/**
	 * Creates and returns an instance of the underlying provider for this facade.
	 * 
	 * <p>
	 * A provider implements the actual logic of a data model. All validation logic, calculation of
	 * default values, and management of property dependencies is handled by the provider.
	 * </p>
	 * 
	 * @return An instance of the underlying provider for this facade.
	 * @generated (mde.utilities.datamodels)
	 */
	public static IDataModelProvider createDatamodelProvider() {
		return new ResolutionDataModelProvider();
	}

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public ResolutionDataModel(IDataModel mdl) {
		model = mdl;
	}

	/**
	 * idenitifier
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newName
	 *           The new value of the Name property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setName(String newName) {
		model.setProperty(IResolutionDataModelProperties.NAME, newName);
	}

	/**
	 * idenitifier
	 * 
	 * @return The value of the Name property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getName() {
		return (String) model.getProperty(IResolutionDataModelProperties.NAME);
	}

	/**
	 * Determine if the Name property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Name
	 *         property is valid.
	 * @see #getName()
	 * @see #setName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateName() {
		return model.validateProperty(IResolutionDataModelProperties.NAME);
	}

	/**
	 * Determine the default value of the Name property.
	 * 
	 * @return The default value of the Name property.
	 * @see #getName()
	 * @see #setName(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultName() {
		return (String) model.getDefaultProperty(IResolutionDataModelProperties.NAME);
	}

	/**
	 * The Description property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDescription
	 *           The new value of the Description property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDescription(String newDescription) {
		model.setProperty(IResolutionDataModelProperties.DESCRIPTION, newDescription);
	}

	/**
	 * The Description property.
	 * 
	 * @return The value of the Description property.
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDescription() {
		return (String) model.getProperty(IResolutionDataModelProperties.DESCRIPTION);
	}

	/**
	 * Determine if the Description property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Description
	 *         property is valid.
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDescription() {
		return model.validateProperty(IResolutionDataModelProperties.DESCRIPTION);
	}

	/**
	 * Determine the default value of the Description property.
	 * 
	 * @return The default value of the Description property.
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated (mde.utilities.datamodels)
	 */
	public String getDefaultDescription() {
		return (String) model.getDefaultProperty(IResolutionDataModelProperties.DESCRIPTION);
	}

	/**
	 * The ValueSet property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newValueSet
	 *           The new value of the ValueSet property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setValueSet(boolean newValueSet) {
		model.setProperty(IResolutionDataModelProperties.VALUE_SET, newValueSet);
	}

	/**
	 * The ValueSet property.
	 * 
	 * @return The value of the ValueSet property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getValueSet() {
		return (Boolean) model.getProperty(IResolutionDataModelProperties.VALUE_SET);
	}

	/**
	 * Null-safe check for the boolean {@link #getValueSet()}.
	 * 
	 * @return the primitive value of the Boolean stored, or false if null.
	 */
	public boolean isValueSet() {
		Boolean value = getValueSet();
		if (value == null) {
			return false;
		}
		return value.booleanValue();
	}

	/**
	 * Determine if the ValueSet property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the ValueSet
	 *         property is valid.
	 * @see #getValueSet()
	 * @see #setValueSet(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateValueSet() {
		return model.validateProperty(IResolutionDataModelProperties.VALUE_SET);
	}

	/**
	 * Determine the default value of the ValueSet property.
	 * 
	 * @return The default value of the ValueSet property.
	 * @see #getValueSet()
	 * @see #setValueSet(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean getDefaultValueSet() {
		return (Boolean) model.getDefaultProperty(IResolutionDataModelProperties.VALUE_SET);
	}

	/**
	 * The ValidValueListExclusive property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newValidValueListExclusive
	 *           The new value of the ValidValueListExclusive property.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setValidValueListExclusive(boolean newValidValueListExclusive) {
		model.setProperty(IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE,
				newValidValueListExclusive);
	}

	/**
	 * The ValidValueListExclusive property.
	 * 
	 * @return The value of the ValidValueListExclusive property.
	 * @generated (mde.utilities.datamodels)
	 */
	public Boolean getValidValueListExclusive() {
		return (Boolean) model.getProperty(IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE);
	}

	/**
	 * Null-safe check for the boolean {@link #getValidValueListExclusive()}.
	 * 
	 * @return the primitive value of the Boolean stored, or false if null.
	 */
	public boolean isValidValueListExclusive() {
		Boolean value = getValidValueListExclusive();
		if (value == null) {
			return false;
		}
		return value.booleanValue();
	}

	/**
	 * Determine if the ValidValueListExclusive property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         ValidValueListExclusive property is valid.
	 * @see #getValidValueListExclusive()
	 * @see #setValidValueListExclusive(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateValidValueListExclusive() {
		return model.validateProperty(IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE);
	}

	/**
	 * Determine the default value of the ValidValueListExclusive property.
	 * 
	 * @return The default value of the ValidValueListExclusive property.
	 * @see #getValidValueListExclusive()
	 * @see #setValidValueListExclusive(boolean)
	 * @generated (mde.utilities.datamodels)
	 */
	public boolean getDefaultValidValueListExclusive() {
		return (Boolean) model
				.getDefaultProperty(IResolutionDataModelProperties.VALID_VALUE_LIST_EXCLUSIVE);
	}

	/**
	 * Return the value of Resolution field.
	 * 
	 * @return The value of Resolution field.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDeployParameterizedResolution getResolution() {
		return (IDeployParameterizedResolution) model
				.getProperty(IResolutionDataModelProperties.RESOLUTION);
	}

	/**
	 * parent resolution adding children datamodels
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newResolution
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setResolution(IDeployParameterizedResolution newResolution) {
		model.setProperty(IResolutionDataModelProperties.RESOLUTION, newResolution);
	}

	/**
	 * Determine if the Resolution property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Resolution
	 *         property is valid.
	 * @see #getResolution()
	 * @see #setResolution(IDeployParameterizedResolution)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateResolution() {
		return model.validateProperty(IResolutionDataModelProperties.RESOLUTION);

	}

	/**
	 * Determine the default value of the Resolution property.
	 * 
	 * @return The default value of the Resolution property.
	 * @see #getResolution()
	 * @see #setResolution(IDeployParameterizedResolution)
	 * @generated (mde.utilities.datamodels)
	 */
	protected IDeployParameterizedResolution getDefaultResolution() {
		return (IDeployParameterizedResolution) model
				.getDefaultProperty(IResolutionDataModelProperties.RESOLUTION);
	}

	/**
	 * Return the value of ValidValues field.
	 * 
	 * @return The value of ValidValues field.
	 */
	public List<IDeployResolutionParameterValueDescriptor> getValidValues() {
		return (List<IDeployResolutionParameterValueDescriptor>) model
				.getProperty(IResolutionDataModelProperties.VALID_VALUES);
	}

	/**
	 * The ValidValues property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newValidValues
	 *           The new value for the reference.
	 */
	public void setValidValues(List<IDeployResolutionParameterValueDescriptor> newValidValues) {
		model.setProperty(IResolutionDataModelProperties.VALID_VALUES, newValidValues);
	}

	/**
	 * Determine if the ValidValues property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the ValidValues
	 *         property is valid.
	 * @see #getValidValues()
	 * @see #setValidValues(List&lt;IDeployResolutionParameterValueDescriptor&gt;)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateValidValues() {
		return model.validateProperty(IResolutionDataModelProperties.VALID_VALUES);

	}

	/**
	 * Determine the default value of the ValidValues property.
	 * 
	 * @return The default value of the ValidValues property.
	 * @see #getValidValues()
	 * @see #setValidValues(List&lt;IDeployResolutionParameterValueDescriptor&gt;)
	 */
	protected List<IDeployResolutionParameterValueDescriptor> getDefaultValidValues() {
		return (List<IDeployResolutionParameterValueDescriptor>) model
				.getDefaultProperty(IResolutionDataModelProperties.VALID_VALUES);
	}

	/**
	 * Return the value of Type field.
	 * 
	 * @return The value of Type field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Class getType() {
		return (Class) model.getProperty(IResolutionDataModelProperties.TYPE);
	}

	/**
	 * type of data
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newType
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setType(Class newType) {
		model.setProperty(IResolutionDataModelProperties.TYPE, newType);
	}

	/**
	 * Determine if the Type property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Type
	 *         property is valid.
	 * @see #getType()
	 * @see #setType(Class)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateType() {
		return model.validateProperty(IResolutionDataModelProperties.TYPE);

	}

	/**
	 * Determine the default value of the Type property.
	 * 
	 * @return The default value of the Type property.
	 * @see #getType()
	 * @see #setType(Class)
	 * @generated (mde.utilities.datamodels)
	 */
	protected Class getDefaultType() {
		return (Class) model.getDefaultProperty(IResolutionDataModelProperties.TYPE);
	}

	/**
	 * Return the value of Value field.
	 * 
	 * @return The value of Value field.
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getValue() {
		return model.getProperty(IResolutionDataModelProperties.VALUE);
	}

	/**
	 * The Value property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newValue
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setValue(Object newValue) {
		model.setProperty(IResolutionDataModelProperties.VALUE, newValue);
	}

	/**
	 * Determine if the Value property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the Value
	 *         property is valid.
	 * @see #getValue()
	 * @see #setValue(Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateValue() {
		return model.validateProperty(IResolutionDataModelProperties.VALUE);

	}

	/**
	 * Determine the default value of the Value property.
	 * 
	 * @return The default value of the Value property.
	 * @see #getValue()
	 * @see #setValue(Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultValue() {
		return model.getDefaultProperty(IResolutionDataModelProperties.VALUE);
	}

	/**
	 * The DefaultValue property.
	 * 
	 * <p>
	 * <b>[Required]</b>
	 * </p>
	 * 
	 * @param newDefaultValue
	 *           The new value for the reference.
	 * @generated (mde.utilities.datamodels)
	 */
	public void setDefaultValue(Object newDefaultValue) {
		model.setProperty(IResolutionDataModelProperties.DEFAULT_VALUE, newDefaultValue);
	}

	/**
	 * Determine if the DefaultValue property meets all constraints required of it.
	 * 
	 * @return A status object indicating error or warning messages, if any, or OK if the
	 *         DefaultValue property is valid.
	 * @see #getDefaultValue()
	 * @see #setDefaultValue(Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public IStatus validateDefaultValue() {
		return model.validateProperty(IResolutionDataModelProperties.DEFAULT_VALUE);

	}

	/**
	 * Determine the default value of the DefaultValue property.
	 * 
	 * @return The default value of the DefaultValue property.
	 * @see #getDefaultValue()
	 * @see #setDefaultValue(Object)
	 * @generated (mde.utilities.datamodels)
	 */
	public Object getDefaultDefaultValue() {
		return model.getDefaultProperty(IResolutionDataModelProperties.DEFAULT_VALUE);
	}

	/**
	 * Create and return an operation that is configured with the values from this datamodel.
	 * 
	 * @return A ready-to-run operation prepared with this model to carry out the operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public IDataModelOperation createConfiguredOperation() {
		ResolutionDataModelOperation operation = new ResolutionDataModelOperation(this);
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
