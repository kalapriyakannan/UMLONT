/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class Was6DmgrNodeUnitValidator extends WasGenericNodeUnitValidator {

	public Was6DmgrNodeUnitValidator() {
		super();
		//this covers only the version 6 dmgr Node case!
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNodeGroupUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			return;
		}
		if (!WasProfileTypeEnum.DMGR_LITERAL.equals(wasNodeCap.getProfileType())) {
			return;
		}

		String wasNodeVersion = wasNodeCap.getWasVersion();
		if (wasNodeVersion == null) {
			return;
		}
		if (wasNodeVersion.length() <= 0 || !wasNodeVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			return;
		}

		//validate for a valide number of hosted Deployment Manager units
		if (ValidatorUtils.getHosted(unit, WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT).size() > 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createMoreThanOneDeploymentManagerUnit(unit);
			reporter.addStatus(message);
		}

		super.validateUnit(unit, context, reporter);
		//wasNode.isManaged == false
		if (wasNodeCap.isIsManaged()) {
			IDeployAttributeValueStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
					IStatus.ERROR, IWasValidatorID.VALIDAT_WAS_DMGRNODE_ISMANAGED_FALSE, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.FALSE);
			reporter.addStatus(message);
		}

		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}
		WasCell wasCellCap = WasUtil.getWasCellCap((WasNodeUnit) unit, top);
		if (wasCellCap == null) {
			return;
		}

		//node && nodeGroup
		List reqL = unit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWasNodeGroupUnit())) {
				List groupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
						.get(i), top);
				if (!(groupList.size() > 0)) {
					IDeployStatus message = DeployWasMessageFactory
							.createMissingGroupingNodeGroupStatus((WasNodeUnit) unit,
									(WasCellUnit) wasCellCap.getParent());
					reporter.addStatus(message);
				}
			}
		}

	}
}
