/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * A factory to create link descriptors of a particular type. This class is typically extended for
 * use by domain specific link matchers to create a {@link LinkDescriptor} with specialized link
 * creation logic. The core domain extends this class as {@link LinkDescriptorFactory}.
 */
public abstract class AbstractLinkDescriptorFactory {

	/**
	 * Create a link descriptor for a unit to unit link.
	 * 
	 * @param type
	 *           type of the link; cannot be DEPENDENCY
	 * @param source
	 *           the source unit
	 * @param target
	 *           the target unit
	 * @return the link descriptor
	 */
	public abstract LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target);

	/**
	 * Create a link descriptor for a unit to unit link.
	 * 
	 * @param type
	 *           type of the link; cannot be DEPENDENCY
	 * @param source
	 *           the source unit
	 * @param target
	 *           the target unit
	 * @param linkWeight
	 *           weight (priority) to be assigned to the link
	 * @return the link descriptor
	 */
	public abstract LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight);

	/**
	 * Creates a link descriptor for a capability to requirement link.
	 * 
	 * @param type
	 *           the type of the link
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @return the link descriptor
	 */
	public abstract LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability);

	/**
	 * Creates a link descriptor for a capability to requirement link.
	 * 
	 * @param type
	 *           the type of the link
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param linkWeight
	 *           weight (priority) to be assigned to the link
	 * @return the link descriptor
	 */
	public abstract LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability, int linkWeight);
}
