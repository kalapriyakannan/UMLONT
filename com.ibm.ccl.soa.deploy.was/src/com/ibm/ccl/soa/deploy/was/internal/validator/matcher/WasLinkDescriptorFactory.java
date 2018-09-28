/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Factory to create was link descriptors.
 */
public class WasLinkDescriptorFactory extends AbstractLinkDescriptorFactory {

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target) {
		return new WasLinkDescriptor(type, source, target);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight) {
		return new WasLinkDescriptor(type, source, target, linkWeight);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability) {
		return new WasLinkDescriptor(type, source, sourceRequirement, target, targetCapability);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability, int linkWeight) {
		return new WasLinkDescriptor(type, source, sourceRequirement, target, targetCapability,
				linkWeight);
	}

}
