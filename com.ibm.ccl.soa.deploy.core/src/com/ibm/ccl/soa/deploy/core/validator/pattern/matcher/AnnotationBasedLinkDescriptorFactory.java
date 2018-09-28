/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * {@link AbstractLinkDescriptorFactory} that createsa {@link AnnotationBasedLinkDescriptor}s
 */
public class AnnotationBasedLinkDescriptorFactory extends AbstractLinkDescriptorFactory {

	// the identifier to be used in the links
	private static String linkIdentifier;

	/**
	 * Constructor for link descriptor factory.
	 * 
	 * @param identifier
	 *           identifier to be placed, as an annotation on the link
	 */

	public AnnotationBasedLinkDescriptorFactory(String identifier) {
		linkIdentifier = identifier;
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target) {
		return new AnnotationBasedLinkDescriptor(type, source, target, linkIdentifier);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight) {
		return new AnnotationBasedLinkDescriptor(type, source, target, linkWeight, linkIdentifier);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability) {

		return new AnnotationBasedLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, linkIdentifier);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability, int linkWeight) {
		return new AnnotationBasedLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, linkWeight, linkIdentifier);
	}

}
