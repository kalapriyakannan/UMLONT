/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.ConstraintLinkMatcher;

/**
 * A generic matcher for unit-to-unit logical links based on unit type.
 */
public class UnitToUnitConstraintLinkMatcher extends ConstraintLinkMatcher {

	protected EClass sourceType;

	protected EClass targetType;

	protected boolean singleton;

	/**
	 * Construct a logical link matcher between the two units.
	 * 
	 * @param sourceType
	 *           the type of the link source, a subtype of {@link Unit}.
	 * @param targetType
	 *           the type of the link targeta subtype of {@link Unit}
	 * @param singleton
	 *           true if only one instance of this link can be created.
	 */
	public UnitToUnitConstraintLinkMatcher(EClass sourceType, EClass targetType, boolean singleton) {
		assert sourceType != null;
		assert CorePackage.eINSTANCE.getUnit().isSuperTypeOf(sourceType);
		assert targetType != null;
		assert CorePackage.eINSTANCE.getUnit().isSuperTypeOf(targetType);
		this.sourceType = sourceType;
		this.targetType = targetType;
		this.singleton = singleton;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canBeLinkSource(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkSource(Unit unit) {
		if (sourceType.isInstance(unit)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher#canBeLinkTarget(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkTarget(Unit unit) {
		if (targetType.isInstance(unit)) {
			return DeployMatcherStatus.MATCH_FOUND;
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canCreateLink(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canCreateLink(Unit unit1, Unit unit2) {
		if (!canBeLinkSource(unit1).isOK() || !canBeLinkTarget(unit2).isOK()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (singleton && linkExists(unit1, unit2)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Set getPossibleLinks(Unit source, Unit target) {
		if (!canCreateLink(source, target).isOK()) {
			return Collections.EMPTY_SET;
		}
		Set set = new HashSet(1);
		LinkDescriptor link = new LinkDescriptor(LinkType.CONSTRAINT, source, target);
		set.add(link);
		return set;
	}

	/*
	 * TODO remove once matcher properly delegates.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#canCreateLink(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		return canCreateLink(source, target);
	}

	/*
	 * TODO remove once matcher properly delegates
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.LogicalLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public Set getPossibleLinks(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		return getPossibleLinks(source, target);
	}

	/*
	 * TODO remove when infinite recursion has been fixed in LogicalLinkMatcher
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher#canBeLinkSource(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Requirement)
	 */
	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		if (requirement == null) {
			return canBeLinkSource(unit);
		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/*
	 * TODO remove when infinite recursion has been fixed in LogicalLinkMatcher
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher#canBeLinkTarget(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public IStatus canBeLinkTarget(Unit unit, Capability capability) {
		if (capability == null) {
			return canBeLinkTarget(unit);

		}
		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	/**
	 * Check if a logical link exists for the source unit.
	 * 
	 * @param source
	 *           the source unit for the link.
	 * @param target
	 *           the target of the link.
	 * @return true if the link exists.
	 */
	protected boolean linkExists(Unit source, Unit target) {
		if (source == null || target == null) {
			return false;
		}
		for (Iterator iter = source.getConstraintLinks().iterator(); iter.hasNext();) {
			ConstraintLink link = (ConstraintLink) iter.next();
			if (source.equals(link.getSource()) && target.equals(link.getTarget())) {
				return true;
			}
		}
		return false;
	}
}
