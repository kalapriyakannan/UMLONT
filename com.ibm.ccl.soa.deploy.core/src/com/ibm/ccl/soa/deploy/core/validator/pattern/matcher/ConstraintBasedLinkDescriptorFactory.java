/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CustomConstraintFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * ConstraintBasedLinkDescriptorFactory creates {@link ConstraintBasedLinkDescriptor}s.
 * 
 */
public class ConstraintBasedLinkDescriptorFactory extends AbstractLinkDescriptorFactory {

	/**
	 * Factory to create constraint.
	 */
	private CustomConstraintFactory constraintFactory;

	/**
	 * EClass to create
	 */
	private EClass constraintEClass;

	/**
	 * Public constructor with factory.
	 * 
	 * @param factory
	 *           factory
	 */
	public ConstraintBasedLinkDescriptorFactory(CustomConstraintFactory factory) {
		constraintFactory = factory;
	}

	/**
	 * Public constructor with EClass.
	 * 
	 * @param eclass
	 *           EClass of the constraint
	 */
	public ConstraintBasedLinkDescriptorFactory(EClass eclass) {
		constraintEClass = eclass;
	}

	/**
	 * Public constructor with factory and EClass.
	 * 
	 * @param factory
	 *           factory
	 * @param eclass
	 *           EClass of the constraint
	 */
	public ConstraintBasedLinkDescriptorFactory(CustomConstraintFactory factory, EClass eclass) {
		constraintFactory = factory;
		constraintEClass = eclass;
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target) {
		return new ConstraintBasedLinkDescriptor(type, source, target, constraintFactory,
				constraintEClass);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight) {
		return new ConstraintBasedLinkDescriptor(type, source, target, linkWeight, constraintFactory,
				constraintEClass);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability) {

		return new ConstraintBasedLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, constraintFactory, constraintEClass);
	}

	public LinkDescriptor createLinkDescriptor(LinkType type, Unit source,
			Requirement sourceRequirement, Unit target, Capability targetCapability, int linkWeight) {
		return new ConstraintBasedLinkDescriptor(type, source, sourceRequirement, target,
				targetCapability, linkWeight, constraintFactory, constraintEClass);
	}
}
