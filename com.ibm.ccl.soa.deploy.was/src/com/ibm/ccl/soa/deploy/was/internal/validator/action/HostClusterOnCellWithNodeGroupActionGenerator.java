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

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.DeployActionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class HostClusterOnCellWithNodeGroupActionGenerator extends DeployActionGenerator {

	public IDeployResolution[] getActions(IDeployResolutionContext context,
			List<DeployModelObject> parameters) {
		WasCellUnit cell = (WasCellUnit) parameters.get(1);
		WasNodeGroupUnit nodeGroup = (WasNodeGroupUnit) parameters.get(2);
		String message = DeployNLS.bind(
				WasDomainMessages.Action_Host_Cluster_On_Cell_With_Node_Group_0, cell
						.getCaptionProvider().title(cell), nodeGroup.getCaptionProvider()
						.title(nodeGroup));
		DeployResolution action = new HostClusterOnCellWithNodeGroupAction(context, this, message,
				parameters);
		return new IDeployResolution[] { action };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		return true;
	}

}
