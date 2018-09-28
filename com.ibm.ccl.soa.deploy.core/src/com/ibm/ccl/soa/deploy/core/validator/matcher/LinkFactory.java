/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Class containing methods to create specific types of links.
 */
public class LinkFactory {

	private static final AbstractLinkDescriptorFactory defaultLinkDescriptorFactory = new LinkDescriptorFactory();

	/**
	 * Create a dependency link.
	 * 
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetCapability
	 *           target requirement of link
	 * @return the dependency link
	 */
	public static DependencyLink createDependencyLink(Requirement sourceRequirement,
			Capability targetCapability) {
		return createDependencyLink(sourceRequirement, targetCapability, defaultLinkDescriptorFactory);
	}

	/**
	 * Create a dependency link.
	 * 
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetCapability
	 *           target requirement of link
	 * @param factory
	 *           factory to create link descriptors
	 * @return the dependency link
	 */
	public static DependencyLink createDependencyLink(Requirement sourceRequirement,
			Capability targetCapability, AbstractLinkDescriptorFactory factory) {
		return createDependencyLink(ValidatorUtils.getUnit(sourceRequirement), sourceRequirement,
				ValidatorUtils.getUnit(targetCapability), targetCapability, factory);
	}

	/**
	 * Create a dependency link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetUnit
	 *           target unit of link
	 * @param targetCapability
	 *           target requirement of link
	 * @return the dependency link
	 */
	public static DependencyLink createDependencyLink(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability) {
		return createDependencyLink(sourceUnit, sourceRequirement, targetUnit, targetCapability,
				defaultLinkDescriptorFactory);
	}

	/**
	 * Create a dependency link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetUnit
	 *           target unit of link
	 * @param targetCapability
	 *           target requirement of link
	 * @param factory
	 *           factory to create link descriptors
	 * @return the dependency link
	 */
	public static DependencyLink createDependencyLink(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability,
			AbstractLinkDescriptorFactory factory) {
		assert null != sourceUnit;
		assert null != sourceRequirement;
		assert null != targetUnit;
		assert null != targetCapability;

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit,
				sourceRequirement, targetUnit, targetCapability);
		return (DependencyLink) d.create();
	}

	/**
	 * Create a hosting link.
	 * 
	 * @param host
	 *           the host
	 * @param hostee
	 *           the unit to be hosted
	 * @return the hosting link
	 */
	public static HostingLink createHostingLink(Unit host, Unit hostee) {
		return createHostingLink(host, hostee, defaultLinkDescriptorFactory);
	}

	/**
	 * Create a hosting link.
	 * 
	 * @param host
	 *           the host
	 * @param hostee
	 *           the unit to be hosted
	 * @param factory
	 *           factory to create link descriptors
	 * @return the hosting link
	 */
	public static HostingLink createHostingLink(Unit host, Unit hostee,
			AbstractLinkDescriptorFactory factory) {
		assert null != host;
		assert null != hostee;

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.HOSTING, host, hostee);
		return (HostingLink) d.create();
	}

	/**
	 * Create a member link.
	 * 
	 * @param group
	 *           the group
	 * @param member
	 *           the member unit
	 * @return the member link
	 */
	public static MemberLink createMemberLink(Unit group, Unit member) {
		return createMemberLink(group, member, defaultLinkDescriptorFactory);
	}

	/**
	 * Create a member link.
	 * 
	 * @param group
	 *           the group
	 * @param member
	 *           the member unit
	 * @param factory
	 *           factory to create link descriptors
	 * @return the member link
	 */
	public static MemberLink createMemberLink(Unit group, Unit member,
			AbstractLinkDescriptorFactory factory) {
		assert null != group;
		assert null != member;

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.MEMBER, group, member);
		return (MemberLink) d.create();
	}

	/**
	 * Create a constraint link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetUnit
	 *           target unit of link
	 * @param targetCapability
	 *           target requirement of link
	 * 
	 * @return the constraint link
	 */
	public static ConstraintLink createConstraintLink(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability) {
		return createConstraintLink(sourceUnit, sourceRequirement, targetUnit, targetCapability,
				defaultLinkDescriptorFactory);
	}

	/**
	 * Create a logical link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param sourceRequirement
	 *           source requirement of link
	 * @param targetUnit
	 *           target unit of link
	 * @param targetCapability
	 *           target requirement of link
	 * @param factory
	 *           factory to create link descriptors
	 * 
	 * @return the logical link
	 */
	public static ConstraintLink createConstraintLink(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability,
			AbstractLinkDescriptorFactory factory) {
		assert null != sourceUnit;
		assert null != sourceRequirement;
		assert null != targetUnit;
		assert null != targetCapability;

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
				sourceRequirement, targetUnit, targetCapability);
		return (ConstraintLink) d.create();
	}

	/**
	 * Create a logical link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param targetUnit
	 *           target unit of link
	 * 
	 * @return the logical link
	 */
	public static ConstraintLink createConstraintLink(Unit sourceUnit, Unit targetUnit) {
		return createConstraintLink(sourceUnit, targetUnit, defaultLinkDescriptorFactory);
	}

	/**
	 * Create a logical link.
	 * 
	 * @param sourceUnit
	 *           source unit of link
	 * @param targetUnit
	 *           target unit of link
	 * @param factory
	 *           factory to create link descriptors
	 * 
	 * @return the logical link
	 */
	public static ConstraintLink createConstraintLink(Unit sourceUnit, Unit targetUnit,
			AbstractLinkDescriptorFactory factory) {
		assert null != sourceUnit;
		assert null != targetUnit;

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit, targetUnit);
		return (ConstraintLink) d.create();
	}

	/**
	 * Create a realization link from a conceptual {@link Unit}, {@link Capability}, or
	 * {@link Requirement} to a target. The source must be a conceptual {@link Unit} or must be
	 * contained in one.
	 * <p>
	 * The link is created in the context ({@link Topology}) of the source.
	 * 
	 * @param source
	 *           the source {@link Unit}, {@link Capability}, or {@link Requirement}
	 * @param target
	 *           the target {@link Unit}, {@link Capability}, or {@link Requirement}
	 * @return the realization link
	 */
	public static RealizationLink createRealizationLink(DeployModelObject source,
			DeployModelObject target) {
		return createRealizationLink(source, target, defaultLinkDescriptorFactory);
	}

	/**
	 * Create a realization link from a conceptual {@link Unit}, {@link Capability}, or
	 * {@link Requirement} to a target. The source must be a conceptual {@link Unit} or must be
	 * contained in one.
	 * <p>
	 * The link is created in the context ({@link Topology}) of the source.
	 * 
	 * @param source
	 *           the source {@link Unit}, {@link Capability}, or {@link Requirement}
	 * @param target
	 *           the target {@link Unit}, {@link Capability}, or {@link Requirement}
	 * @param factory
	 *           factory to create link descriptors
	 * @return the realization link
	 */
	public static RealizationLink createRealizationLink(DeployModelObject source,
			DeployModelObject target, AbstractLinkDescriptorFactory factory) {
		assert null != source;
		assert null != target;

		// check that source and targets are of the same type;
		// check that the source is conceptual
		if (CorePackage.Literals.UNIT.isSuperTypeOf(source.getEObject().eClass())) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(target.getEObject().eClass());
			assert ((Unit) source).isConceptual();
		}
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(source.getEObject().eClass())) {
			assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(target.getEObject().eClass());
			assert ((Unit) source.getParent()).isConceptual();
		}
		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(source.getEObject().eClass())) {
			assert CorePackage.Literals.REQUIREMENT.isSuperTypeOf(target.getEObject().eClass());
			assert ((Unit) source.getParent()).isConceptual();
		}

		LinkDescriptor d = factory.createLinkDescriptor(LinkType.REALIZATION, source, target); //, context);
		return (RealizationLink) d.create();
	}

}
