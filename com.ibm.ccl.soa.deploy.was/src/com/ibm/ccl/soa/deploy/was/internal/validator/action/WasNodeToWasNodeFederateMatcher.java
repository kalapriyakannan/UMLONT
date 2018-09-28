/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.UnitToUnitConstraintLinkMatcher;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;

/**
 * Link a {@link WasNodeUnit} to a deployment manager {@link WasNodeUnit} with the intent to
 * federate.
 */
public class WasNodeToWasNodeFederateMatcher extends UnitToUnitConstraintLinkMatcher {

	/**
	 * Construct a {@link WasNodeUnit} to {@link WasNodeUnit} logical link federate matcher.
	 */
	public WasNodeToWasNodeFederateMatcher() {
		super(WasPackage.Literals.WAS_NODE_UNIT, WasPackage.Literals.WAS_NODE_UNIT, true);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.UnitToUnitLogicalLinkMatcher#canBeLinkSource(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkSource(Unit unit) {
		IStatus status = super.canBeLinkTarget(unit);
		if (!status.isOK()) {
			return status;
		}
		if (!isNodeHostedOnNetworkDeploymentSystem(unit, false)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.UnitToUnitLogicalLinkMatcher#canBeLinkTarget(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public IStatus canBeLinkTarget(Unit unit) {
		IStatus status = super.canBeLinkTarget(unit);
		if (!status.isOK()) {
			return status;
		}
		if (!isDeploymentManagerNode(unit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Returns true if the unit provides a {@link WasNode} with profile type
	 * {@link WasProfileTypeEnum#DMGR}.
	 * 
	 * @param unit
	 *           a deploy unit.
	 * @return true if the unit is a deployment manager node, false otherwise.
	 */
	public static boolean isDeploymentManagerNode(Unit unit) {
		if (unit == null) {
			return false;
		}
		WasNode targetWasNode = (WasNode) ValidatorUtils.getFirstCapability(unit,
				WasPackage.Literals.WAS_NODE);
		if (targetWasNode == null) {
			return false;
		}
		return targetWasNode.getProfileType() == WasProfileTypeEnum.DMGR_LITERAL;

	}

	/**
	 * Returns true if the unit provides a {@link WasNode} which is hosted in a
	 * {@link WasSystem#getWasEdition()} == {@link WasEditionEnum#NETWORK_DEPLOYMENT}.
	 * 
	 * @param unit
	 *           a deploy unit.
	 * @return true if the unit is a deployment manager node, false otherwise.
	 */
	public static boolean isNodeHostedOnNetworkDeploymentSystem(Unit unit, boolean useDiscovery) {
		if (unit == null) {
			return false;
		}
		WasNode wasNode = (WasNode) ValidatorUtils.getFirstCapability(unit,
				WasPackage.Literals.WAS_NODE);
		if (wasNode == null) {
			return false;
		}
		WasSystem wasSystem;
		if (useDiscovery) {
			wasSystem = (WasSystem) ValidatorUtils.discoverHostCapability(unit,
					WasPackage.Literals.WAS_SYSTEM, null);
		} else {
			wasSystem = (WasSystem) ValidatorUtils.getHostCapability(unit,
					WasPackage.Literals.WAS_SYSTEM);

		}
		if (wasSystem == null) {
			return false;
		}
		return wasSystem.getWasEdition() == WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL;
	}

}
