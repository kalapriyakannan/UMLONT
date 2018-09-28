/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Creates links that have a constraint on them.
 */
public class ConstraintLinkDescriptorFactory extends AbstractLinkDescriptorFactory {

	protected final IConstraintFactory _factory;

	/**
	 * Constructor for constraint based link descriptor factory.
	 * 
	 * @param constraintFactory
	 *           factory to create constraint to be placed on the link
	 */

	public ConstraintLinkDescriptorFactory(IConstraintFactory constraintFactory) {
		_factory = constraintFactory;
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target) {
		return new ConstraintLinkDescriptor(type, source, target, _factory.createConstraint());
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight) {
		return new ConstraintLinkDescriptor(type, source, target, linkWeight, _factory
				.createConstraint());
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability) {

		return new ConstraintLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, _factory.createConstraint());
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability, int linkWeight) {
		return new ConstraintLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, linkWeight, _factory.createConstraint());
	}

}
