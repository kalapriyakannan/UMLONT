/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;

public class NodeProtocolResolutionGenerator extends DeployResolutionGenerator {
	private NodeProtocolResolution nodeResolution = null;

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		return new IDeployResolution[] { nodeResolution };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		return getNodeProtocolResolution(context).shouldResolve();
	}

	private NodeProtocolResolution getNodeProtocolResolution(IDeployResolutionContext context) {
		if (nodeResolution == null)
			nodeResolution = new NodeProtocolResolution(context, this);
		return nodeResolution;

	}

}
