/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Class to filter (limit) {@link MemberLink} matches in the WAS domain.
 */
public class WasMemberLinkMatcherFilter extends LinkMatchFilter {

	@Override
	public IStatus canCreateLink(Unit source, Unit target) {

		if (source instanceof WasCellUnit) {
			WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(source, WasPackage.eINSTANCE
					.getWasCell());
			if (wasCellCap != null) {
				boolean isDistributed = wasCellCap.isIsDistributed();
				//don t allow more than one Dmgr in a cell and no dmgr in a standalone cell
				if (target instanceof WasNodeUnit
						&& (isDistributed && WasUtil.getDeploymentManager((WasCellUnit) source) != null || !isDistributed)) {
					WasNode wasNodeCap = (WasNode) ValidatorUtils.getFirstCapability(target,
							WasPackage.eINSTANCE.getWasNode());
					if (wasNodeCap.getProfileType().getLiteral().equals(
							WasProfileTypeEnum.DMGR_LITERAL.getLiteral())) {
						return DeployMatcherStatus.MEMBER_LINK_NOT_POSSIBLE;
					}
				}

				if (!wasCellCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
					if (target instanceof WasNodeGroupUnit) {
						return DeployMatcherStatus.MEMBER_LINK_NOT_POSSIBLE;
					}
				}

			}
		}

		//Was 6 App Server can not be member of a was 5 cluster
		if (source instanceof WasClusterUnit) {
			WasCluster clusterCap = (WasCluster) ValidatorUtils.getCapability(source,
					WasPackage.eINSTANCE.getWasCluster());
			if (clusterCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				if (target instanceof WebsphereAppServerUnit) {
					WasServer serverCap = (WasServer) ValidatorUtils.getCapability(target,
							WasPackage.eINSTANCE.getWasServer());
					if (serverCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
						return DeployMatcherStatus.MEMBER_LINK_NOT_POSSIBLE;
					}
				}
			}
		}
		return DeployMatcherStatus.MATCH_NOT_REJECTED;

	}

}
