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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * common move member out of group resolution
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class CreateMoveInvalidMemberOutOfGroupResolution extends DeployResolution {

	private final Unit _memberUnit;
	private final Unit _groupUnit;

	public CreateMoveInvalidMemberOutOfGroupResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit memberUnit, Unit groupUnit) {
		super(context, generator, DeployNLS.bind(
				WasDomainMessages.Resolution_move_Invalid_MemberUnit_0_Outof_GroupUnit_1, memberUnit,
				groupUnit));
		_memberUnit = memberUnit;
		_groupUnit = groupUnit;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		if (_memberUnit == null || _groupUnit == null) {
			return Status.CANCEL_STATUS;
		}

		WasUtil.departFromGroup(_memberUnit, _groupUnit);
		return Status.OK_STATUS;
	}

}
