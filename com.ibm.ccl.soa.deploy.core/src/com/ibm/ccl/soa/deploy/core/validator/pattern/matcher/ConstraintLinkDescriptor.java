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
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * {@link LinkDescriptor} that adds a {@link Constraint} when creating a link of type
 * {@link LinkType#CONSTRAINT}.
 */
public class ConstraintLinkDescriptor extends LinkDescriptor {

	protected final static String CONSTRAINT_PREFIX = "constraint"; //$NON-NLS-1$
	protected final Constraint _constraint;

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
	 * @param constraint
	 *           constraint to be placed on the link
	 */
	public ConstraintLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, Constraint constraint) {
		super(type, source, target);
//		factory = new ConstraintLinkDescriptorFactory(constraint);
		_constraint = constraint;
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
	 * @param constraint
	 *           constraint to be placed on the link
	 */
	public ConstraintLinkDescriptor(LinkType type, DeployModelObject source,
			DeployModelObject target, int linkWeight, Constraint constraint) {
		super(type, source, target, linkWeight);
//		factory = new ConstraintLinkDescriptorFactory(constraint);
		_constraint = constraint;
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
	 * @param constraint
	 *           constraint to be placed on the link
	 */
	public ConstraintLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, Constraint constraint) {
		super(type, source, sourceRequirement, target, targetCapability);
//		factory = new ConstraintLinkDescriptorFactory(constraint);
		_constraint = constraint;
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
	 * @param constraint
	 *           constraint to be placed on the link
	 */
	public ConstraintLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability, int linkWeight, Constraint constraint) {
		super(type, source, sourceRequirement, target, targetCapability, linkWeight);
//		factory = new ConstraintLinkDescriptorFactory(constraint);
		_constraint = constraint;
	}

	protected ConstraintLink createConstraintLink() {
		ConstraintLink link = super.createConstraintLink();

		_constraint.setName(UnitUtil.generateUniqueName(link, CONSTRAINT_PREFIX));
		link.getConstraints().add(_constraint);

		return link;
	}

}
