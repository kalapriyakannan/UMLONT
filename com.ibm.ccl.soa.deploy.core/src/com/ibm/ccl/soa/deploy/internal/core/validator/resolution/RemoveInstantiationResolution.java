/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Removes the instantiation of an import object.
 * <p>
 * All ovverrides on the imported objects are removed.
 * 
 * @see ResolutionUtils#removeInstantiation(com.ibm.ccl.soa.deploy.core.DeployModelObject)
 */
public class RemoveInstantiationResolution extends DeployResolution {

	/**
	 * Construct a resolution to remove the instantation of a property in an import object.
	 * 
	 * @param context
	 *           the resolution context.
	 * @param generator
	 *           the generator which instantiated this resolution.
	 */
	public RemoveInstantiationResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployNLS.bind(
				DeployCoreMessages.Resolution_unset_all_overrides_of_imported_object_0, context
						.getDeployStatus().getDeployObject()));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		boolean result = ResolutionUtils.removeInstantiation(getDeployStatus().getDeployObject());
		if (result) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}
}
