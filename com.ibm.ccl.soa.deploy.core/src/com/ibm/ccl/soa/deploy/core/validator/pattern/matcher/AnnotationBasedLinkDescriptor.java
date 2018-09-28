/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * {@link LinkDescriptor} that creates a Constraint link with a given annotation on it.
 */
public class AnnotationBasedLinkDescriptor extends LinkDescriptor {

	private final String linkIdentifier;

	/**
	 * Constructor for link between units.
	 * 
	 * @param type
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link
	 * @param target
	 *           target unit of link
	 * @param identifier
	 *           identifier to be placed, as an annotation on the link
	 */
	public AnnotationBasedLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, String identifier) {
		super(type, source, target);
		factory = new AnnotationBasedLinkDescriptorFactory(identifier);
		linkIdentifier = identifier;
	}

	/**
	 * Constructor for link between units.
	 * 
	 * @param type
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link
	 * @param target
	 *           target unit of link
	 * @param linkWeight
	 *           weight (priority) to be assigned to the link
	 * @param identifier
	 *           identifier to be placed, as an annotation on the link
	 */
	public AnnotationBasedLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight, String identifier) {
		super(type, source, target, linkWeight);
		factory = new AnnotationBasedLinkDescriptorFactory(identifier);
		linkIdentifier = identifier;
	}

	/**
	 * Constructor for link between a requirement and a capability.
	 * 
	 * @param type
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link (contains sourceRequirment)
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param target
	 *           target unit of link (contains targetCapability)
	 * @param targetCapability
	 *           target capability of link
	 * @param identifier
	 *           identifier to be placed, as an annotation on the link
	 */
	public AnnotationBasedLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, String identifier) {
		super(type, source, sourceRequirement, target, targetCapability);
		factory = new AnnotationBasedLinkDescriptorFactory(identifier);
		linkIdentifier = identifier;
	}

	/**
	 * Constructor for link between a requirement and a capability.
	 * 
	 * @param type
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link (contains sourceRequirment)
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param target
	 *           target unit of link (contains targetCapability)
	 * @param targetCapability
	 *           target capability of link
	 * @param linkWeight
	 *           weight (priority) to be assigned to the link
	 * @param identifier
	 *           identifier to be placed, as an annotation on the link
	 */
	public AnnotationBasedLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, int linkWeight, String identifier) {
		super(type, source, sourceRequirement, target, targetCapability, linkWeight);
		factory = new AnnotationBasedLinkDescriptorFactory(identifier);
		linkIdentifier = identifier;
	}

	protected ConstraintLink createConstraintLink() {
		ConstraintLink link = super.createConstraintLink();

		Annotation linkAnnotation = CoreFactory.eINSTANCE.createAnnotation();
		linkAnnotation.setContext(linkIdentifier);
		link.getAnnotations().add(linkAnnotation);

		return link;
	}

}
