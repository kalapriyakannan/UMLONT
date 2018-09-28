/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Class to reject some link matches that another link matcher may find.
 */
public class LinkMatchFilter {
	/**
	 * Determine if a unit should not be a link source.
	 * 
	 * @param source
	 *           the unit to be tested
	 * @return status OK if can be a link source
	 */
	public IStatus canBeLinkSource(Unit source) {
		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

	/**
	 * Determine if a \<unit, requirement\> pair should not be a link source.
	 * 
	 * @param source
	 *           the unit to be tested
	 * @param sourceRequirement
	 *           the requirement to be tested; can be null
	 * @return status OK if can be a link source
	 */
	public IStatus canBeLinkSource(Unit source, Requirement sourceRequirement) {
		if (null == sourceRequirement) {
			return canBeLinkSource(source);
		}
		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

	/**
	 * Determine if a unit should not be a link target.
	 * 
	 * @param target
	 *           the unit to be tested
	 * @return status OK if can be a link target
	 */
	public IStatus canBeLinkTarget(Unit target) {
		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

	/**
	 * Determine if a \<unit, capability\> pair should not be a link target.
	 * 
	 * @param target
	 *           the unit to be tested
	 * @param targetCapability
	 *           the capability to be tested; can be null
	 * @return status OK if can be a link target
	 */
	public IStatus canBeLinkTarget(Unit target, Capability targetCapability) {
		if (null == targetCapability) {
			return canBeLinkTarget(target);
		}

		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

	/**
	 * Determine if a unit should not be a link endpoint (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit) {
		IStatus status = canBeLinkSource(unit);
		if (status.isOK()) {
			return status;
		}

		return canBeLinkTarget(unit);
	}

	/**
	 * Determine if a \<unit, requirement\> or \<unit, capability\> pair should not be a link
	 * endpoint (source or target).
	 * 
	 * @param unit
	 *           the unit to be tested
	 * @param reqCap
	 *           the requirement or capability to be tested
	 * @return status OK if can be a link endpoint
	 */
	public IStatus canBeLinkEndpoint(Unit unit, DeployModelObject reqCap) {
		if (null == reqCap) {
			return canBeLinkEndpoint(unit);
		}

		if (reqCap instanceof Capability) {
			return canBeLinkTarget(unit, (Capability) reqCap);
		} else if (reqCap instanceof Requirement) {
			return canBeLinkSource(unit, (Requirement) reqCap);
		} else {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
	}

	/**
	 * Determine if a link should not be directly created between and source unit and a target unit.
	 * 
	 * @param source
	 *           the source unit to be tested
	 * @param target
	 *           the target unit to be tested
	 * @return status OK if can create a link
	 */
	public IStatus canCreateLink(Unit source, Unit target) {
		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

	/**
	 * Determine if a link should not be directly created between and source unit and a target unit.
	 * 
	 * @param source
	 *           the source unit to be tested
	 * @param sourceRequirement
	 *           the source requirement to be tested
	 * @param target
	 *           the target unit to be tested
	 * @param targetCapability
	 *           the target capability to be tested
	 * @return status OK if can create a link
	 */
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		if (null == sourceRequirement && null == targetCapability) {
			return canCreateLink(source, target);
		}

		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

}
