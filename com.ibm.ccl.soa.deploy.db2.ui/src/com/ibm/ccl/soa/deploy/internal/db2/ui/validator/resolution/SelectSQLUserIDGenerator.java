/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.database.SQLUser;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class SelectSQLUserIDGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (context.getDeployStatus() instanceof IDeployAttributeStatus) {
			String validatorID = context.getDeployStatus().getValidatorID();
			if (validatorID == null) {
				return false;
			}
			if ((context.getDeployStatus() != null)
					&& (context.getDeployStatus().getDeployObject() instanceof SQLUser)
					&& (validatorID.equals(IDB2ValidatorID.SQL_MODULE_USER_NOT_FOUND_ON_OS_001))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		return new IDeployResolution[] { new SelectSQLUserID(context, this) };
	}
}
