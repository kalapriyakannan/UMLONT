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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeConstraintUtils;

/**
 * Resolution to add a class loader policy constraint.
 */
public class AddWasClassloaderPolicyConstraintResolution extends DeployResolution {

	private final Unit _module;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param module
	 *           the module on which the constraint should be added
	 */
	public AddWasClassloaderPolicyConstraintResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Unit module) {
		super(context, generator, description);
		_module = module;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		List<Unit> modules = new ArrayList<Unit>();
		modules.add(_module);
		WasJ2eeConstraintUtils.addClassloaderPolicyConstraints(modules);

		return Status.OK_STATUS;
	}

}
