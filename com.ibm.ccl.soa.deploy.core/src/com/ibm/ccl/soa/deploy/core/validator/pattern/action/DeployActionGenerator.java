/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployActionStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployActionStatus;

/**
 * Action generator to create actions that can be executed based on existence of
 * {@link IDeployActionStatus} markers. All action generators should extend this abstract type: it
 * wrappers the action priority so that actions are listed after error resolutions.
 */
public abstract class DeployActionGenerator extends DeployResolutionGenerator {

	protected int ACTION_PRIORITY_OFFSET = -10000;

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployActionStatus status = (DeployActionStatus) context.getDeployStatus();
		List<DeployModelObject> parameters = status.getParameters();
		IDeployResolution[] actions = getActions(context, parameters);
		for (int i = 0; i < actions.length; i++) {
			DeployResolution action = (DeployResolution) actions[i];
			action.setPriority(action.getPriority() + ACTION_PRIORITY_OFFSET);
		}
		return actions;
	}

	/**
	 * Retrieve possible actions on a list of parameters
	 * 
	 * @param context
	 *           the deploy resolution context
	 * @param parameters
	 *           list of parameters
	 * @return array of actions
	 */
	public abstract IDeployResolution[] getActions(IDeployResolutionContext context,
			List<DeployModelObject> parameters);

}
