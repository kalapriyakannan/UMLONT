/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class AddMemberUnitIntoGroupUnitResolution extends DeployResolution {
	private Unit _memberUnit;
	private Unit _groupUnit;

	public AddMemberUnitIntoGroupUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit memberUnit, Unit groupUnit) {
		super(context, generator, DeployNLS.bind(
				WasDomainMessages.Resolution_add_MemberUnit_0_into_GroupUnit_1, memberUnit, groupUnit));
		_memberUnit = memberUnit;
		_groupUnit = groupUnit;
	}

	/*
	 * ResolutionGenerator who calling this resolution should make sure that the member and group are
	 * mapping on both sides.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		LinkFactory.createMemberLink(_groupUnit, _memberUnit);
		return Status.OK_STATUS;
	}

}
