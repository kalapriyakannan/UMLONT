/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import org.eclipse.osgi.util.NLS;

public class NodeProtocolResolution extends DeployResolution {
	private CommunicationCapability capability = null;

	private String applicationProtocolType = null;

	private String conceptualNodeProtocolType = null;

	private Requirement requirement = null;

	private RequirementExpression requirementExpression = null;

	private boolean shouldResolve = true;

	private final static String PROTOCAL_TYPE_ATTR = "applicationLayerProtocol"; //$NON-NLS-1$

	public NodeProtocolResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		loadDataFromContext();

	}

	private void loadDataFromContext() {
		IDeployStatus status = context.getDeployStatus();
		if (status == null) {
			reportProblem("Status associated with marker missing from context"); //$NON-NLS-1$
			return;
		}
		DeployModelObject dmo = status.getDeployObject();
		if (dmo == null) {
			reportProblem("Deployment Object missing from status"); //$NON-NLS-1$
			return;
		}
		Object obj = status.getBindings()[0];
		if (obj == null || !(obj instanceof CommunicationCapability)) {
			reportProblem("Communication Capability missing from Status"); //$NON-NLS-1$
			return;
		}
		capability = (CommunicationCapability) obj;
		conceptualNodeProtocolType = capability.getApplicationLayerProtocol();
		Object protocol = status.getBindings()[1];
		if (protocol == null || !(protocol instanceof String)) {
			reportProblem("Protocol type from application relationship missing");//$NON-NLS-1$
			return;
		}
		applicationProtocolType = (String) protocol;
		Object requirementObj = status.getBindings()[2];
		if (requirementObj == null || !(requirementObj instanceof Requirement)) {
			reportProblem("Requirment missing from Status");//$NON-NLS-1$
			return;
		}
		requirement = (Requirement) requirementObj;
		Object expression = requirement.getExpressions().get(0);
		if (expression == null) {
			reportProblem("Missing a requirement expression");//$NON-NLS-1$
			return;
		}
		requirementExpression = (RequirementExpression) expression;

	}

	private void reportProblem(String errorMessage) {
		shouldResolve = false;
		DeployCorePlugin.log(IStatus.ERROR, 0, errorMessage, null);

	}

	public String getDescription() {
		String message = NLS.bind(
				Messages.NodeProtocolResolution_Change_communication_protocol_betwe_,
				conceptualNodeProtocolType);
		String description = message + applicationProtocolType;
		return description;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		if (shouldResolve) {
			capability.setApplicationLayerProtocol(applicationProtocolType);
			requirementExpression.setValue(applicationProtocolType);
		}
		return Status.CANCEL_STATUS;
	}

	public boolean shouldResolve() {
		return shouldResolve;
	}

}
