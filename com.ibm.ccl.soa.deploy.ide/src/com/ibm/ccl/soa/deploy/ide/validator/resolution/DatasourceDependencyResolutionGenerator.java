/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

public class DatasourceDependencyResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {

		IDeployResolution[] resolutions = EMPTY_RESOLUTION_ARRAY;
		if (hasResolutions(context)) {

			DeployModelObject dmo = context.getDeployStatus().getDeployObject();
			if (dmo instanceof Requirement) {
				Requirement req = (Requirement) dmo;
				Unit unit = (Unit) req.getParent();
				resolutions = new IDeployResolution[1];
				resolutions[0] = new DatasourceDependencyResolution(context, this, unit);

			}
		}
		return resolutions;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// TODO more query of the context?  Check requirement type, etc.  Or is the property tester enough?
		if (!(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(context.getDeployStatus()
				.getProblemType())))
			return false;
		return true;

	}

}
