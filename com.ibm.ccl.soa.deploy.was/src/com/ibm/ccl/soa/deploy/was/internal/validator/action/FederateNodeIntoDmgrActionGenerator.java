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
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

public class FederateNodeIntoDmgrActionGenerator extends DeployActionGenerator {

	public IDeployResolution[] getActions(IDeployResolutionContext context,
			List<DeployModelObject> parameters) {
		WasNodeUnit dmgrNode = (WasNodeUnit) parameters.get(1);
		String message = DeployNLS.bind(WasDomainMessages.Action_Federate_Node_To_Cell_0, dmgrNode
				.getCaptionProvider().title(dmgrNode));
		DeployResolution action = new FederateNodeIntoDmgrAction(context, this, message, parameters);
		return new IDeployResolution[] { action };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		return true;
	}

}
