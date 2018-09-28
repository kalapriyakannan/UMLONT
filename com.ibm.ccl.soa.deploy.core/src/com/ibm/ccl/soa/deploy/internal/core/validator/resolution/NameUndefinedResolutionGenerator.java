/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;

/**
 * Generates resolutions for {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED} on
 * {@link CorePackage#getDeployModelObject_Name()}.
 */
public class NameUndefinedResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		return new IDeployResolution[] { new NameNotUniqueResolution(context, this) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus() instanceof IDeployAttributeStatus)) {
			return false;
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		if (!ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED.equals(status.getProblemType())) {
			return false;
		}
		return CorePackage.eINSTANCE.getDeployModelObject_Name() == status.getAttributeType();
	}
}
