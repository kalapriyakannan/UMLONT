/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

public class HostClusterOnCellWithNodeGroupAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WasClusterUnit _cluster;
	private final WasCellUnit _cell;
	private final WasNodeGroupUnit _nodeGroup;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 */
	public HostClusterOnCellWithNodeGroupAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		_cluster = (WasClusterUnit) _parameters.get(0);
		_cell = (WasCellUnit) _parameters.get(1);
		_nodeGroup = (WasNodeGroupUnit) _parameters.get(2);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		//host cluster on cell
		ResolutionUtils.host(_cell, _cluster);

		//associate cluster with node group
		ResolutionUtils.link(context, _cluster, WasPackage.Literals.WAS_NODE_GROUP, _nodeGroup,
				WasPackage.Literals.WAS_NODE_GROUP);

		return Status.OK_STATUS;
	}
}
