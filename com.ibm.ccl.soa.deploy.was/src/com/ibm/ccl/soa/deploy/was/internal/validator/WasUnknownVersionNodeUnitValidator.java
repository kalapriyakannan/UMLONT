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
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class WasUnknownVersionNodeUnitValidator extends WasGenericNodeUnitValidator {

	public WasUnknownVersionNodeUnitValidator() {
		super();
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
			super.validateUnit(unit, context, reporter);
			return;
		}

		String wasNodeVersion = wasNodeCap.getWasVersion();
		if (wasNodeVersion == null || wasNodeVersion.length() <= 0) {
			super.validateUnit(unit, context, reporter);
			return;
		}
		if (wasNodeVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)
				|| wasNodeVersion.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			return;
		}

		super.validateUnit(unit, context, reporter);
		if (WasUtil.compare2VersionString(wasNodeVersion, WasUtil.WAS_5_MAIN_VERSION) < 0) {//we only support version 5.0 and above
			IDeployAttributeStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
					IStatus.ERROR, IWasValidatorID.WAS_CELL_WASVERSION_INVALID_001, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_WasVersion());
			reporter.addStatus(message);
		} else if (WasUtil.compare2VersionString(wasNodeVersion, WasUtil.WAS_MAIN_VERSION_MAX_BOUND) > 0) {
			IDeployAttributeStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
					IStatus.ERROR, IWasValidatorID.WAS_CELL_WASVERSION_INVALID_001, wasNodeCap,
					WasPackage.eINSTANCE.getWasNode_WasVersion());
			reporter.addStatus(message);
			//we only support version small than 7.0 currently				
		}

	}
}
