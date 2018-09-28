/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import org.eclipse.emf.common.util.Enumerator;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Default implementation of a resolution parameter value descriptor.
 * <p>
 * Stores the description and the value.
 */
public class DeployResolutionParameterValueDescriptor implements
		IDeployResolutionParameterValueDescriptor {

	protected String description;
	protected Object value;

	/**
	 * Construct a parameter value with the default descriptor.
	 * 
	 * @param value
	 *            the parameter value (may be null).
	 */
	public DeployResolutionParameterValueDescriptor(Object value) {
		this(value, null);
	}

	/**
	 * Construct a parameter value with the specified descriptor.
	 * <p>
	 * If the description is null, then {@link #getDescription()} will generate
	 * one for the object value.
	 * 
	 * @param value
	 *            the parameter value (may be null).
	 * @param description
	 *            the parameter value description (may be null).
	 */
	public DeployResolutionParameterValueDescriptor(Object value,
			String description) {
		this.value = value;
		this.description = description;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterValueDescriptor#getValue()
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Returns a description of the object value.
	 * <p>
	 * If the object value description has not been set by the user, then the
	 * method will generate one.
	 * 
	 * @return a description of the parameter value (never null).
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterValueDescriptor#getDescription()
	 */
	public String getDescription() {
		if (description != null) {
			return description;
		}
		if (value != null) {
			if (value instanceof DeployModelObject) {
				return DeployNLS.getName((DeployModelObject) value);
			} else if (value instanceof Enumerator) {
				return DeployNLS.getName((Enumerator) value);
			}
			return value.toString();
		}
		return DeployCoreMessages.null_value;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getDescription();
	}
}
