/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * The parameter bound to a parameterized deploy resolution instance.
 * <p>
 * The parameter is bound to a parameterized deploy resolution.
 * 
 * @see IDeployParameterizedResolution
 * @see IDeployParameterizedResolution#getParameters()
 */
public interface IDeployResolutionParameter {

	/**
	 * @return the resolution to which this parameter is bound.
	 * 
	 * @see IDeployParameterizedResolution#getParameters()
	 */
	public IDeployParameterizedResolution getResolution();

	/**
	 * Returns the name of the paramater.
	 * <p>
	 * A {@link IDeployParameterizedResolution} should assign unique parameter
	 * names.
	 * 
	 * @return the name of the parameter.
	 */
	public String getName();

	/**
	 * Returns a description of the parameter.
	 * 
	 * @return a string description of the resolution parameter.
	 */
	public String getDescription();

	/**
	 * @return the current value of the parameter.
	 */
	public Object getValue();

	/**
	 * @return true if the value has been set, false if its unset.
	 * 
	 * @see #unsetValue()
	 */
	public boolean isValueSet();

	/**
	 * Unsets the value.
	 * <p>
	 * Sets the value to the default, and changes the unset value flag.
	 * 
	 * @see #isValueSet()
	 * @see #getDefaultValue()
	 */
	public void unsetValue();

	/**
	 * @return the default value of the parameter.
	 */
	public Object getDefaultValue();

	/**
	 * Sets the value of the resolution parameter.
	 * 
	 * @param object
	 *            the resolution parameter.
	 */
	public void setValue(Object object);

	/**
	 * @return the Java type of the parameter.
	 */
	public Class<?> getType();

	/**
	 * Validates the value of the parameter.
	 * <p>
	 * The parameter is bound to a resolution ({@link #getResolution()}) which
	 * is bound to a status {@link IDeployResolution#getDeployStatus()}) which
	 * is bound to an object ({@link IDeployStatus#getDeployObject()})
	 * contained in a topology ({@link DeployModelObject#getTopology()}).
	 * <p>
	 * The value is validated in the context of the resolution object, and
	 * topology.
	 * 
	 * @return the status of validating the proposed value (never null).
	 */
	public IStatus validate();

	/**
	 * Returns a list of valid value descritors for the parameter.
	 * <p>
	 * The list contains the values and their descriptions. The list may not be
	 * exclusive (use {@link #isValidValueListExclusive()}) to determine if
	 * other values are permitted.
	 * 
	 * @return a list of valid values and their descriptions (never null).
	 */
	public List<IDeployResolutionParameterValueDescriptor> getValidValueDescriptors();

	/**
	 * Check if other values in addition to the ones return by
	 * {@link #getValidValueDescriptors()} are allowed.
	 * 
	 * @return true if users can set to additional values, false if only the
	 *         valid values are valid choices.
	 */
	public boolean isValidValueListExclusive();
}
