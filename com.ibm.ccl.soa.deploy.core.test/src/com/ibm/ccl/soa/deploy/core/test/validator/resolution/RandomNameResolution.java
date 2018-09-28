/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Sets the marked unit name to a random value.
 */
public class RandomNameResolution extends DeployResolution {

	/**
	 * The magic bad name defined in the test resolution generator declaration
	 * in plugin.xml
	 */
	public static final String MAGIC_BAD_NAME = "com.ibm.ccl.soa.deploy.core.test.validator.resolution.RandomNameResolutionGenerator";

	/**
	 * Construct a random name resolution generator.
	 */
	public RandomNameResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		setDescription("Change \""
				+ context.getDeployStatus().getDeployObject().getName()
				+ "\" name to random value");
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
	 */
	public boolean hasResolutions(IDeployStatus status) {
		return true;
	}

	/*
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		getDeployStatus().getDeployObject().setName(
				"Random" + System.currentTimeMillis());
		return Status.OK_STATUS;
	}
}
