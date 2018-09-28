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
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;

/**
 * Resolution to unhost a DeploymentManagerUnit from a DmgrNode
 */
public class InvalidNumberOfDeploymentManagerUnitsResolution extends DeployResolution {

	WasNodeUnit _dmgrNode;
	WasDeploymentManagerUnit _dmgrUnit;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param dmrgNode
	 *           the hostee dmgr node
	 * @param dmgrUnit
	 *           the hosted dmgr unit
	 * 
	 */
	public InvalidNumberOfDeploymentManagerUnitsResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Unit dmrgNode, Unit dmgrUnit) {
		super(context, generator, message);
		_dmgrNode = (WasNodeUnit) dmrgNode;
		_dmgrUnit = (WasDeploymentManagerUnit) dmgrUnit;
	}

	/*
	 * This resolution unhosts a given Dmgr unit from a Deployment Manager Node
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		ResolutionUtils.unhost(_dmgrNode, _dmgrUnit);
		return Status.OK_STATUS;
	}

}
