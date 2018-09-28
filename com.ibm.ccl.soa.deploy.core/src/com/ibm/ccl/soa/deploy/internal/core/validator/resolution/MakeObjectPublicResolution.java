/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;

/**
 * Resolution to make a unit public
 */
public class MakeObjectPublicResolution extends DeployResolution {

	private final DeployModelObject _object;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param object
	 *           the object to be made public
	 */
	public MakeObjectPublicResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, DeployModelObject object) {
		super(context, generator, description);
		_object = object;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		_object.getTopology().getConfigurationContract().export(_object, false);
		return Status.OK_STATUS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_object == null ? 0 : _object.hashCode());
		return result;
	}

	// implement hashCode() and equals() so that duplicate resolutions can be 
	// filtered out

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final MakeObjectPublicResolution other = (MakeObjectPublicResolution) obj;
		if (_object == null) {
			if (other._object != null) {
				return false;
			}
		} else if (!_object.equals(other._object)) {
			return false;
		}
		return true;
	}

}
