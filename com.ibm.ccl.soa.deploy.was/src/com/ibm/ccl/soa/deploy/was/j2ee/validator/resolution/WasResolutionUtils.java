/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.j2ee.validator.resolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Common methods used in Was Resolutions. Might consider promoting to {@link ResolutionUtils}.
 */
public class WasResolutionUtils {

	/**
	 * Execute any resolutions that apply to an object for a particular problem type
	 * 
	 * @param context
	 *           the current resolution context
	 * @param dmo
	 *           the object
	 * @param problemTypes
	 *           an array of problem types to address
	 * @param generator
	 *           the resolution generator to use to solve the problem(s)
	 * @param monitor
	 *           progress monitor
	 * @return status of executions (stops at first failure)
	 */
	public static IStatus runResolutions(IDeployResolutionContext context, DeployModelObject dmo,
			String[] problemTypes, IDeployResolutionGenerator generator, IProgressMonitor monitor) {
		List<IDeployStatus> moduleStatues = getStatus(dmo, problemTypes);
		for (int i = 0; i < moduleStatues.size(); i++) {
			IDeployStatus status = moduleStatues.get(i);
			IDeployResolutionContext earContext = ResolutionUtils.createResolutionContextProxy(status,
					context);
			IDeployResolution[] resolutions = generator.getResolutions(earContext);
			// we expect resolutions do not overlap
			for (int j = 0; j < resolutions.length; j++) {
				IStatus success = resolutions[j].resolve(monitor);
				if (!success.isOK()) {
					return success;
				}
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Get a list of statuses with one of a specified set of problem types from the statuses
	 * associated with a {@link DeployModelObject}.
	 * 
	 * @param object
	 *           the object
	 * @param problemTypes
	 *           the array of desired problem types
	 * @return list of statuses
	 */
	public static List<IDeployStatus> getStatus(DeployModelObject object, String[] problemTypes) {
		if (null == object) {
			return Collections.emptyList();
		}

		if (null == problemTypes) {
			return Collections.emptyList();
			// or allow all matches?
		}

		List<IDeployStatus> statuses = new ArrayList<IDeployStatus>();

		for (DeployStatusIterator iter = new DeployStatusIterator(object.getStatus()); iter.hasNext();) {
			IDeployStatus status = iter.next();
			for (int i = 0; i < problemTypes.length; i++) {
				String problemType = status.getProblemType();
				if (problemType != null && problemType.equals(problemTypes[i])) {
					statuses.add(status);
					break;
				}
			}
		}

		return statuses;
	}

}
