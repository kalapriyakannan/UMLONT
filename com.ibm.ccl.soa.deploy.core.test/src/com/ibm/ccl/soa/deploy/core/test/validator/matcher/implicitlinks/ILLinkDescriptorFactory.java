/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.matcher.implicitlinks;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

public class ILLinkDescriptorFactory extends AbstractLinkDescriptorFactory {

	@Override
	public LinkDescriptor createLinkDescriptor(LinkType type,
			DeployModelObject source, DeployModelObject target) {
		return new ILLinkDescriptor (type, source, target);
	}

	@Override
	public LinkDescriptor createLinkDescriptor(LinkType type,
			DeployModelObject source, DeployModelObject target, int linkWeight) {
		return new ILLinkDescriptor (type, source, target, linkWeight);
	}

	@Override
	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		return new ILLinkDescriptor (type, source, sourceRequirement, target, targetCapability);
	}

	@Override
	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target,
			Capability targetCapability, int linkWeight) {
		return new ILLinkDescriptor (type, source, sourceRequirement, target, targetCapability, linkWeight);
	}

}
