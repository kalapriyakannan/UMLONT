/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Default implementation of the deploy resolution parameter interface.
 * <p>
 * Exposes a generic typed attribute value that must be provided to the
 * resolution.
 */
public class DeployResolutionParameter implements IDeployResolutionParameter {

	protected final IDeployParameterizedResolution resolution;
	protected final Class<?> type;
	protected final String name;
	protected final String description;
	protected Object defaultValue = null;
	protected Object value = null;
	protected boolean valueSet = false;
	protected List<IDeployResolutionParameterValueDescriptor> validValues = null;
	protected List<IDeployResolutionParameterValueDescriptor> immutableValidValues = null;
	protected boolean validValueListExclusive = false;

	/**
	 * Construct a resolution parameter for a non-EMF type.
	 * 
	 * @param resolution
	 *            the resolution which is parameterized.
	 * @param type
	 *            the non-EMF type of the parameter
	 * @param name
	 *            the name of the parameter.
	 * @param description
	 *            an optional description of the parameter (may be null).
	 */
	public DeployResolutionParameter(IDeployParameterizedResolution resolution,
			Class<?> type, String name, String description) {
		assert resolution != null;
		assert type != null;
		assert name != null;
		assert name.length() > 0;

		this.resolution = resolution;
		this.type = type;
		this.name = name;
		this.description = description;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getDescription()
	 */
	public String getDescription() {
		if (description != null) {
			return description;
		}
		return name;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getResolution()
	 */
	public IDeployParameterizedResolution getResolution() {
		return resolution;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getType()
	 */
	public Class<?> getType() {
		return type;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getValue()
	 */
	public Object getValue() {
		return value;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#setValue(java.lang.Object)
	 */
	public void setValue(Object value) {
		this.valueSet = true;
		this.value = value;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#isValueSet()
	 */
	public boolean isValueSet() {
		return valueSet;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#unsetValue()
	 */
	public void unsetValue() {
		valueSet = false;
		value = getDefaultValue();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getDefaultValue()
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the parameter.
	 * <p>
	 * If the parameter is not set, then {@link #getValue()} will return the
	 * newly set default value.
	 * 
	 * @param defaultValue
	 *            the default value.
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
		if (!valueSet) {
			value = defaultValue;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#validate()
	 */
	public IStatus validate() {
		if ((value != null) && (!type.isInstance(value))) {
			String message = DeployNLS
					.bind(
							DeployCoreMessages.Resolution_0_parameter_1_value_2_not_an_instance_of_3,
							new Object[] { getResolution().getDescription(),
									getName(), getValue(), getType() });
			IStatus status = new Status(IStatus.ERROR,
					DeployCorePlugin.PLUGIN_ID, message);
			return status;
		}

		if (isValidValueListExclusive()) {
			String errorMessage = null;
			if (validValues == null) {
				if (value != null) {
					errorMessage = DeployNLS
							.bind(
									DeployCoreMessages.Resolution_0_parameter_1_can_only_be_null,
									new Object[] {
											getResolution().getDescription(),
											getName() });
				}
			} else {
				boolean found = false;
				for (IDeployResolutionParameterValueDescriptor validValueDescriptor : validValues) {
					Object validValue = validValueDescriptor.getValue();
					if (ValidatorUtils.equals(value, validValue)) {
						found = true;
						break;
					}
				}
				if (!found) {
					errorMessage = DeployNLS
							.bind(
									DeployCoreMessages.Resolution_0_parameter_1_value_2_not_valid,
									new Object[] {
											getResolution().getDescription(),
											getName(), value });
				}
			}
			if (errorMessage != null) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
						errorMessage);
			}
		}
		return Status.OK_STATUS;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#getValidValueDescriptors()
	 */
	public List<IDeployResolutionParameterValueDescriptor> getValidValueDescriptors() {
		if (immutableValidValues == null) {
			return Collections.emptyList();
		}
		return immutableValidValues;
	}

	/**
	 * Adds a possible value descriptor.
	 * 
	 * @param descriptor
	 *            a valid value descriptor.
	 */
	public void addValidValueDescriptor(
			IDeployResolutionParameterValueDescriptor descriptor) {
		if (validValues == null) {
			validValues = new ArrayList<IDeployResolutionParameterValueDescriptor>();
			immutableValidValues = Collections.unmodifiableList(validValues);
		}
		validValues.add(descriptor);
	}

	/**
	 * Creates and adds a descriptor for the valid value.
	 * <p>
	 * Uses a null value descriptor, which results in a generated descriptor
	 * based on the value.
	 * 
	 * @param value
	 *            the valid value to be added.
	 */
	public void addValidValue(Object value) {
		addValidValueDescriptor(new DeployResolutionParameterValueDescriptor(
				value));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter#isValidValueListExclusive()
	 */
	public boolean isValidValueListExclusive() {
		return validValueListExclusive;
	}

	/**
	 * Set the exclusivity of the valid value list.
	 * 
	 * @param isExclusive
	 *            true if the valid value list is exclusive, false otherwise.
	 */
	public void setValidValueListExclusive(boolean isExclusive) {
		validValueListExclusive = isExclusive;
	}
}
