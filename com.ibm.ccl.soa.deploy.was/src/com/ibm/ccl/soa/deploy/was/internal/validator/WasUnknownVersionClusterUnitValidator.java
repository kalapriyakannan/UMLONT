/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

public class WasUnknownVersionClusterUnitValidator extends WasGenericClusterUnitValidator {

	public WasUnknownVersionClusterUnitValidator() {
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
		WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(unit,
				WasPackage.eINSTANCE.getWasCluster());
		if (wasClusterCap == null) {
			super.validateUnit(unit, context, reporter);
			return;
		}

		String wasClusterVersion = wasClusterCap.getWasVersion();
		if (wasClusterVersion == null || wasClusterVersion.length() <= 0) {
			super.validateUnit(unit, context, reporter);
			return;
		}

		if (WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_MAIN_VERSION_MAX_BOUND) >= 0
				|| WasUtil.compare2VersionString(wasClusterVersion, WasUtil.WAS_5_MAIN_VERSION) <= 0) {
			super.validateUnit(unit, context, reporter);
		}
	}
}
