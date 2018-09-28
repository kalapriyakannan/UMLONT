/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class Was5DmgrNodeUnitValidator extends WasGenericNodeUnitValidator {

	public Was5DmgrNodeUnitValidator() {
		super();
		//this covers only the version 5 dmgr Node case!		
		//		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasDeploymentManagerUnit(), RequirementLinkTypes.MEMBER_LITERAL, 1, 1);		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		//Core Unit validation
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			return;
		}
		if (!wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
			return;
		}

		String wasNodeVersion = wasNodeCap.getWasVersion();
		if (wasNodeVersion == null) {
			return;
		}
		if (wasNodeVersion.length() <= 0 || !wasNodeVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			return;
		}

		super.validateUnit(unit, context, reporter);

		//wasNode.isManaged == false
		if (wasNodeCap.isIsManaged()) {
			IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					IWasValidatorID.VALIDAT_WAS_DMGRNODE_ISMANAGED_FALSE, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_IsManaged(), Boolean.FALSE);
			reporter.addStatus(message);
		}

		//validate for a valide number of hosted Deployment Manager units
		if (ValidatorUtils.getHosted(unit, WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT).size() > 1) {
			IDeployStatus message = DeployWasMessageFactory
					.createMoreThanOneDeploymentManagerUnit(unit);
			reporter.addStatus(message);
		}
	}
}
