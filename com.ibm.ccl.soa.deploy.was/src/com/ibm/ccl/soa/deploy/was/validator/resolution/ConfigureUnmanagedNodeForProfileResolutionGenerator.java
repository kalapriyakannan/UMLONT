/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.validator.resolution;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Configure a NONE profile type WAS node's profireName, profileType and cel membership.
 */
public class ConfigureUnmanagedNodeForProfileResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		return new IDeployResolution[] { new ConfigureUnmanagedNodeForProfileResolution(context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

//	     <enablement>
//        <instanceof value="com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus"/>
//        <test
//              property="com.ibm.ccl.soa.deploy.core.problemType"
//              value="com.ibm.ccl.soa.deploy.core.objectAttributeUndefined"/>
//        <test
//              property="com.ibm.ccl.soa.deploy.core.attributeName"
//              value="com.ibm.ccl.soa.deploy.was.WasNode#profileName"/>
//     </enablement>

		if (!(status instanceof IDeployAttributeStatus)) {
			return false;
		}

		IDeployAttributeStatus aStatus = (IDeployAttributeStatus) status;

		if (!ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED.equals(status.getProblemType())) {
			return false;
		}

		if (!WasPackage.Literals.WAS_NODE__PROFILE_NAME.getName().equals(aStatus.getAttributeName())) {
			return false;
		}

		// check that resolution will have permissions to make necessary changes
		// (a) nothing - resolve() method not implemented!

		return true;
	}
}
