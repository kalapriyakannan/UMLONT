/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2ValidatorUtils;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;
import com.ibm.ccl.soa.deploy.db2.internal.validator.util.UseridPasswordHostnameUser;

/**
 * Generates a special case resolution linking a user on the same hosting stack with a db2 instance,
 * and propagating values from the user and the operating system.
 */
public class UseridPasswordHostnameResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!IDB2ProblemType.INSTANCE_MISSING_LINK_TO_INSTANCE_ADMIN_USER.equals(context
				.getDeployStatus().getProblemType())) {
			return false;
		}

		return true;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		if (context.getDeployStatus() == null || context.getDeployStatus().getDeployObject() == null
				|| !(context.getDeployStatus().getDeployObject() instanceof Unit)) {
			return new IDeployResolution[0];
		}
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		List<UseridPasswordHostnameUser> names = DB2ValidatorUtils
				.useridPasswordHostnameFixesAvailable(unit);
		IDeployResolution[] idr = new IDeployResolution[names.size()];
		int i = 0;
		for (UseridPasswordHostnameUser uphu : names) {
			idr[i++] = new UseridPasswordHostnameResolution(context, this, unit, uphu);
		}

		return idr;
	}
}
