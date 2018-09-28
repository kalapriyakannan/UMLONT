/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Status associated with an expected value of a deploy model object attribute.
 */
public interface IDeployAttributeValueStatus extends IDeployAttributeStatus {

	/**
	 * Deserializes the expected value of the attribute.
	 * 
	 * @param type
	 *           the EMF attribute data type used to deserialize the value.
	 * @param topology
	 *           the topology used to resolve the object ID.
	 * @return the expected value of the attribute.
	 * @deprecated use {@link getAttributeExpectedValue()}
	 */
	public Object getAttributeExpectedValue(EDataType type, Topology topology);

	/**
	 * @return the expected value of the attribute.
	 */
	public Object getAttributeExpectedValue();

	/**
	 * Sets the expected value of the attribute.
	 * <p>
	 * The method will serialize the value when needed.
	 * 
	 * @param value
	 *           the attribute expected value.
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setAttributeExpectedValue(Object value);
}
