/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.ConstraintLinkUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.ConstraintLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Identifies whether or not a logical hosting link can be established between a host and a hostee.
 */
public class ConstraintHostingLinkMatcher extends ConstraintLinkMatcher {

	protected EClass[] hostTypes;

	protected EClass[] hosteeTypes;

	protected boolean singleton = true;

	protected AbstractLinkDescriptorFactory linkDescriptorFactory = new LinkDescriptorFactory();

	/**
	 * Construct a logical hosting link matcher between the two units.
	 * 
	 * @param hostTypes
	 *           array of types of the link source, a subtype of {@link Unit}.
	 * @param hosteeTypes
	 *           array of types of the link target, a subtype of {@link Unit}
	 * @param singleton
	 *           flag indicating whether or not there can be multiple logical links
	 */
	public ConstraintHostingLinkMatcher(EClass[] hostTypes, EClass[] hosteeTypes, boolean singleton) {
		assert hostTypes.length > 0;
		for (int i = 0; i < hostTypes.length; i++) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(hostTypes[i]);
		}
		assert hosteeTypes.length > 0;
		for (int i = 0; i < hosteeTypes.length; i++) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(hosteeTypes[i]);
		}

		this.hostTypes = hostTypes;
		this.hosteeTypes = hosteeTypes;
		this.singleton = singleton;
	}

	/**
	 * Set the {@link AbstractLinkDescriptorFactory} that should be used to create
	 * {@link LinkDescriptor}s.
	 * 
	 * @param factory
	 *           the link descriptor factory
	 */
	public void setLinkDescritptorFactory(AbstractLinkDescriptorFactory factory) {
		linkDescriptorFactory = factory;
	}

	public IStatus canBeLinkTarget(Unit hosteeUnit, Capability capability) {
		if (capability != null) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return canBeLinkTarget(hosteeUnit);
	}

	public IStatus canBeLinkTarget(Unit hosteeUnit) {
		if (!isHosteeUnitTypeAcceptable(hosteeUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// can't create link if already hosted
		if (null != ValidatorUtils.getHost(hosteeUnit)) {
			return DeployMatcherStatus.LINK_ALREADY_PRESENT;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	public IStatus canCreateLink(Unit hostUnit, Requirement req, Unit hosteeUnit, Capability cap) {

		if (null != req) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (null != cap) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return canCreateLink(hostUnit, hosteeUnit);
	}

	public IStatus canCreateLink(Unit hostUnit, Unit hosteeUnit) {
		if (!isHostUnitTypeAcceptable(hostUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		IStatus hosteeStatus = canBeLinkTarget(hosteeUnit);
		if (!hosteeStatus.isOK()) {
			return hosteeStatus;
		}

		// or if there is already a logical hosting link
		for (Iterator lIt = hosteeUnit.getConstraintLinks().iterator(); lIt.hasNext();) {
			ConstraintLink link = (ConstraintLink) lIt.next();
			Unit targetUnit = ConstraintLinkUtils.getLogicalLinkTargetedUnit(link);
			if (isHostUnitTypeAcceptable(targetUnit)) {
				return DeployMatcherStatus.LINK_ALREADY_PRESENT;
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	public Set getPossibleLinks(Unit hostUnit, Requirement req, Unit hosteeUnit, Capability cap) {

		if (req != null || cap != null) {
			return new HashSet();
		}

		return getPossibleLinks(hostUnit, hosteeUnit);
	}

	public Set getPossibleLinks(Unit hostUnit, Unit hosteeUnit) {
		Set links = new HashSet();

		if (canCreateLink(hostUnit, hosteeUnit).isOK()) {
			links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, hosteeUnit,
					hostUnit));
		}

		return links;
	}

	protected boolean isHostUnitTypeAcceptable(Unit hostUnit) {
		if (null == hostUnit) {
			return false;
		}

		for (int i = 0; i < hostTypes.length; i++) {
			if (hostTypes[i].isSuperTypeOf(hostUnit.getEObject().eClass())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isHosteeUnitTypeAcceptable(Unit hosteeUnit) {
		if (null == hosteeUnit) {
			return false;
		}

		for (int i = 0; i < hosteeTypes.length; i++) {
			if (hosteeTypes[i].isSuperTypeOf(hosteeUnit.getEObject().eClass())) {
				return true;
			}
		}
		return false;
	}

	// assumes that if sourceRequirement is desired it is set; we do not search
	// for it
	protected boolean alreadyHosted(Unit hostUnit, Unit hosteeUnit) {

		// look for existing logical link
		List logicalLinks = hostUnit.getConstraintLinks();
		for (int i = 0; i < logicalLinks.size(); i++) {
			ConstraintLink link = (ConstraintLink) logicalLinks.get(i);
			assert hostUnit == ConstraintLinkUtils.getLogicalLinkSourceUnit(link);
			if (hosteeUnit == ConstraintLinkUtils.getLogicalLinkSourceRequirement(link)) {
				// link already exists
				return true;
			}
		}
		return false;
	}

}
