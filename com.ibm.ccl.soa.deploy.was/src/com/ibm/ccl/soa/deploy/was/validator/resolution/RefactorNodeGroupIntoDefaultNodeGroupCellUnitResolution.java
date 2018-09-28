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

import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class RefactorNodeGroupIntoDefaultNodeGroupCellUnitResolution extends DeployResolution {
	private final WasNodeGroupUnit _nodeGroup;

	public RefactorNodeGroupIntoDefaultNodeGroupCellUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, WasCellUnit cellUnit, WasNodeGroupUnit nodeGroup) {
		super(
				context,
				generator,
				DeployNLS
						.bind(
								WasDomainMessages.Resolution_refactor_NodeGroup_Into_Default_Was_NodeGroup_Unit_for_CellUnit,
								cellUnit, nodeGroup));
		_nodeGroup = nodeGroup;

	}

	public IStatus resolve(IProgressMonitor monitor) {
		WasNodeGroup nodeGroupCap = (WasNodeGroup) ValidatorUtils.getCapability(_nodeGroup,
				WasPackage.Literals.WAS_NODE_GROUP);
		nodeGroupCap.setIsDefaultType(true);
		return Status.OK_STATUS;
	}
}
