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
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Resolution to undistribute a Was Cell hosted on a Base System
 */
public class DistributedCellIsHostedOnBaseSystemResolution extends DeployResolution {

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
	public DistributedCellIsHostedOnBaseSystemResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit wasCell) {
		super(context, generator, message);
		_cell = (WasCellUnit) wasCell;
	}

	/*
	 * This resolution sets the isDistributed Bit of a WasCell to false.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(_cell, WasPackage.Literals.WAS_CELL);
		cellCap.setIsDistributed(false);

		return Status.OK_STATUS;
	}

}
