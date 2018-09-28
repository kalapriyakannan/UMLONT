/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Precondition test to determine if a server may be added to an existing cluster.
 */
public class PromoteServerToExistingClusterAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WebsphereAppServerUnit _server;
	private final WasClusterUnit _cluster;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 */
	public PromoteServerToExistingClusterAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		_server = (WebsphereAppServerUnit) _parameters.get(0);
		_cluster = (WasClusterUnit) _parameters.get(1);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		//host most things hosted on the server on the cluster
		List<Unit> hostedUnits = ValidatorUtils.discoverHosted(_server, context.getProgressMonitor());
		for (Iterator<Unit> iterator = hostedUnits.iterator(); iterator.hasNext();) {
			Unit hosted = iterator.next();
			EClass hostedType = hosted.getEObject().eClass();
			if (OsPackage.Literals.PORT_CONFIG_UNIT.isSuperTypeOf(hostedType)
					|| WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT.isSuperTypeOf(hostedType)) {
				// don't rehost these
				continue;
			}
			ResolutionUtils.unhost(_server, hosted);
			ResolutionUtils.host(_cluster, hosted);
		}

		// Add node to server to cluster
		ResolutionUtils.group(_cluster, _server);
		return Status.OK_STATUS;
	}
}
