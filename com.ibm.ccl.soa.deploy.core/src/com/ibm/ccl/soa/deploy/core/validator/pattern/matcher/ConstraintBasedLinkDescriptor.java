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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CustomConstraintFactory;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Link descriptor that would create constraint links with a constraint on them.
 */
public class ConstraintBasedLinkDescriptor extends LinkDescriptor {

	/**
	 * Factory to create constraint.
	 */
	private final CustomConstraintFactory constraintFactory;

	/**
	 * EClass to create
	 */
	private final EClass constraintEClass;

	/**
	 * Constructor for link descriptor. Either factory or EClass are supposed to be non null.
	 * 
	 * @param lType
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link
	 * @param target
	 *           target unit of link
	 * @param cFactory
	 *           constraint factory
	 * @param eclass
	 *           constraint EClass
	 */
	public ConstraintBasedLinkDescriptor(LinkType lType, DeployModelObject source,
			DeployModelObject target, CustomConstraintFactory cFactory, EClass eclass) {
		super(lType, source, target);
		factory = new ConstraintBasedLinkDescriptorFactory(cFactory, eclass);
		constraintFactory = cFactory;
		constraintEClass = eclass;
	}

	/**
	 * Constructor for link descriptor. Either factory or EClass are supposed to be non null.
	 * 
	 * @param lType
	 *           type of link, one of {@link LinkType#DEPENDENCY}, {@link LinkType#HOSTING},
	 *           {@link LinkType#MEMBER}, or {@link LinkType#CONSTRAINT}
	 * @param source
	 *           source unit of link
	 * @param target
	 *           target unit of link
	 * @param cFactory
	 *           constraint factory
	 * @param eclass
	 *           constraint EClass
	 * @param lWeight
	 *           weight (priority) to be assigned to the link
	 */
	public ConstraintBasedLinkDescriptor(LinkType lType, DeployModelObject source,
			DeployModelObject target, int lWeight, CustomConstraintFactory cFactory, EClass eclass) {
		super(lType, source, target, lWeight);
		factory = new ConstraintBasedLinkDescriptorFactory(cFactory, eclass);
		constraintFactory = cFactory;
		constraintEClass = eclass;
	}

	/**
	 * Constructor for link descriptor. Either factory or EClass are supposed to be non null.
	 * 
	 * @param lType
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
	 * @param cFactory
	 *           constraint factory
	 * @param eclass
	 *           constraint EClass
	 */
	public ConstraintBasedLinkDescriptor(LinkType lType, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, CustomConstraintFactory cFactory, EClass eclass) {
		super(lType, source, sourceRequirement, target, targetCapability);
		factory = new ConstraintBasedLinkDescriptorFactory(cFactory, eclass);
		constraintFactory = cFactory;
		constraintEClass = eclass;
	}

	/**
	 * Constructor for link descriptor. Either factory or EClass are supposed to be non null.
	 * 
	 * @param lType
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
	 * @param lWeight
	 *           weight (priority) to be assigned to the link
	 * @param cFactory
	 *           constraint factory
	 * @param eclass
	 *           constraint EClass
	 */
	public ConstraintBasedLinkDescriptor(LinkType lType, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, int lWeight, CustomConstraintFactory cFactory,
			EClass eclass) {
		super(lType, source, sourceRequirement, target, targetCapability, lWeight);
		factory = new ConstraintBasedLinkDescriptorFactory(cFactory, eclass);
		constraintFactory = cFactory;
		constraintEClass = eclass;
	}

	protected ConstraintLink createConstraintLink() {
		ConstraintLink cLink = super.createConstraintLink();
		Constraint c = null;
		if (constraintFactory != null) {
			c = constraintFactory.createConstraint(cLink);
		}

		if (c == null || !(c instanceof Constraint)) {
			if (constraintEClass != null) {
				EObject obj = EcoreUtil.create(constraintEClass);
				if (obj != null && obj instanceof Constraint) {
					c = (Constraint) obj;
					c.setName(UnitUtil.generateUniqueName(cLink, "c")); //$NON-NLS-1$
				}
			}
		}

		if (c != null && c instanceof Constraint) {
			cLink.getConstraints().add(c);
		}
		return cLink;
	}
}
