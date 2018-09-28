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
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolves problems with the {@link DeployModelObject#getName()} by creating a unique name.
 * 
 * @see UnitUtil#generateUniqueName(DeployModelObject, String)
 */
public class NameNotUniqueResolution extends DeployResolution {

	/**
	 * Construct a unique name resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public NameNotUniqueResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployCoreMessages.Resolution_assign_unique_name);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus status = context.getDeployStatus();
		DeployModelObject object = status.getDeployObject();
		if (object == null) {
			return Status.CANCEL_STATUS;
		}

		Topology top = object.getTopology();
		if (top == null) {
			return Status.CANCEL_STATUS;
		}
		if (!(object.eContainer() instanceof DeployModelObject)) {
			return Status.CANCEL_STATUS;
		}
		String prefix = object.getName() != null ? object.getName() : object.eClass().getName();
		String name = UnitUtil.generateUniqueName((DeployModelObject) object.eContainer(), prefix);
		object.setName(name);
		return Status.OK_STATUS;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof NameNotUniqueResolution)) {
			return false;
		}
		return context.getDeployStatus().getDeployObject() == ((NameNotUniqueResolution) obj)
				.getDeployStatus().getDeployObject();
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return context.getDeployStatus().getDeployObject().hashCode();
	}
}
