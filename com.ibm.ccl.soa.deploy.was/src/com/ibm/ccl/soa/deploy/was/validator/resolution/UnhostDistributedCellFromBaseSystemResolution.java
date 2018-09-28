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
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;

/**
 * Resolution to undistribute a Was Cell hosted on a Base System
 */
public class UnhostDistributedCellFromBaseSystemResolution extends DeployResolution {

	WasCellUnit _cell;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param wasCell
	 *           the distributed WasCell
	 */
	public UnhostDistributedCellFromBaseSystemResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit wasCell) {
		super(context, generator, message);
		_cell = (WasCellUnit) wasCell;
	}

	/*
	 * Plan unhosts a distributed cell from an underlying Base System
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {

		WasNodeUnit cellHost = (WasNodeUnit) ValidatorUtils.getHost(_cell);
		ResolutionUtils.unhost(cellHost);

		return Status.OK_STATUS;
	}

}
