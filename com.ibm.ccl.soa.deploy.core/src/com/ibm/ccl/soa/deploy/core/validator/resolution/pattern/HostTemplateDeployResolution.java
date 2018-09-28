/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A resolution to host a template unit in the marked object's unit.
 */
public class HostTemplateDeployResolution extends DeployResolution {
	protected final String template;

	/**
	 * Construct a resolution to load a template and host it on the unit of the status context.
	 * 
	 * @param context
	 *           the resolution context containing the status object.
	 * @param generator
	 *           the resolution generator.
	 * @param template
	 *           the template ID.
	 * @param templateDescription
	 *           a description of the template (e.g. "Windows User").
	 */
	public HostTemplateDeployResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String template, String templateDescription) {
		super(context, generator);
		this.description = DeployNLS.bind(DeployCoreMessages.Resolution_host_new_0_on_1,
				new Object[] { templateDescription, context.getDeployStatus().getDeployObject() });
		this.template = template;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		DeployModelObject object = context.getDeployStatus().getDeployObject();
		Unit hostUnit = ValidatorUtils.getUnit(object);
		if (hostUnit == null) {
			return Status.CANCEL_STATUS;
		}
		return ResolutionUtils.hostTemplateUnit(hostUnit, template);
	}
}
