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

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Status associated with the source of the expected value of a deploy model object attribute.
 */
public interface IDeployAttributeValueSourceStatus extends IDeployAttributeValueStatus {

	/**
	 * @return the name of the attribute on the source object which is the source of the expected
	 *         value.
	 */
	public String getAttributeExpectedValueSourceAttributeName();

	/**
	 * @return the type of the attribute on the source object which is the source of the expected
	 *         value.
	 * 
	 * @see #getAttributeType()
	 */
	public EAttribute getAttributeExpectedValueSourceAttributeType();

	/**
	 * Sets the name of the attribute on the source object which is the source of the expected value.
	 * 
	 * @param name
	 *           an attribute name.
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setAttributeExpectedValueSourceAttributeName(String name);

	/**
	 * Sets the attribute on the source object which is the source of the expected value.
	 * 
	 * @param name
	 *           an attribute on the source object.
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setAttributeExpectedValueSourceAttributeName(EAttribute attribute);

	/**
	 * @param topology
	 *           used to lookup the source object.
	 * @return the type of the attribute on the source object containing the expected value.
	 */
	public EAttribute getAttributeExpectedValueSourceAttributeType(Topology topology);

	/**
	 * @return the object ID of the expected value source object.
	 * @deprecated use {@link #getAttributeExpectedValueSourceObject()}
	 */
	public String getAttributeExpectedValueSourceObjectID();

	/**
	 * @param topology
	 *           used to lookup the source object ID.
	 * @return the object that is the source of the expected value.
	 */
	public DeployModelObject getAttributeExpectedValueSourceObject();

	/**
	 * @param topology
	 *           used to lookup the source object ID.
	 * @return the object that is the source of the expected value.
	 * @deprecated use {@link #getAttributeExpectedValueSourceObject()}
	 */
	public DeployModelObject getAttributeExpectedValueSourceObject(Topology topology);

	/**
	 * Sets the object ID of the expected value source object.
	 * 
	 * @param object
	 *           the source object.
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setAttributeExpectedValueSourceObject(DeployModelObject object);

	/**
	 * @return the type of the source object of the expected value.
	 */
	public String getAttributeExpectedValueSourceObjectType();
}
