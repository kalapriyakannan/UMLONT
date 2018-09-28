/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Resolution to remove the hosting link between two units.
 */
public class UnhostUnitResolution extends DeployResolution {

	private final Unit _host;
	private final Unit _hostee;

	/**
	 * Constructor that provides a default description.
	 * 
	 * @param context
	 * @param generator
	 * @param host
	 *           the host
	 * @param hostee
	 *           the hostee
	 */
	public UnhostUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit host, Unit hostee) {
		super(context, generator, DeployNLS.bind(WasDomainMessages.Unhost_0_from_1, hostee, host));
		_host = host;
		_hostee = hostee;
	}

	/**
	 * Constructor that allows for a specific description
	 * 
	 * @param context
	 * @param generator
	 * @param description
	 * @param host
	 *           the host
	 * @param hostee
	 *           the hostee
	 */
	public UnhostUnitResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Unit host, Unit hostee) {
		super(context, generator, DeployNLS.bind(description, host, hostee));
		_host = host;
		_hostee = hostee;
	}

	public IStatus resolve(IProgressMonitor monitor) {
		if (_host == null || _hostee == null) {
			return Status.CANCEL_STATUS;
		}

		ResolutionUtils.unhost(_host, _hostee);
		return Status.OK_STATUS;
	}

}
