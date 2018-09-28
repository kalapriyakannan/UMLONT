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
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

public class ILLinkDescriptor extends LinkDescriptor {

	public ILLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target) {
		super(type, source, target);
	}

	public ILLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight) {
		super(type, source, target, linkWeight);
	}

	public ILLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		super(type, source, sourceRequirement, target, targetCapability);
	}

	public ILLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target,
			Capability targetCapability, int linkWeight) {
		super(type, source, sourceRequirement, target, targetCapability,
				linkWeight);
	}

	@Override
	public void postHostingLinkCreate (Unit host, Unit hostee, HostingLink link) {
		if (!host.isConceptual()) {
			ExtendedAttribute a = CoreFactory.eINSTANCE.createExtendedAttribute();
			a.setName("ImpliedHostingLinkValue");
			a.setValue("Created by Implicit Link");
			hostee.getExtendedAttributes().add(a);
		}
	}

	@Override
	public void postDependencyLinkCreate(Unit source,
			Requirement sourceRequirement, Unit target,
			Capability targetCapability, DependencyLink lnk) {
		if (!source.isConceptual()) {
			ExtendedAttribute a = CoreFactory.eINSTANCE.createExtendedAttribute();
			a.setName("ImpliedDependencyLinkValue");
			a.setValue("Created by Implicit Dependency Link");
			target.getExtendedAttributes().add(a);
		}
	}

	@Override
	public void postMemberLinkCreate(Unit group, Unit member, MemberLink lnk) {
		if (!group.isConceptual()) {
			ExtendedAttribute a = CoreFactory.eINSTANCE.createExtendedAttribute();
			a.setName("ImpliedMemberLinkValue");
			a.setValue("Created by Implicit Member Link");
			member.getExtendedAttributes().add(a);
		}
	}
}
