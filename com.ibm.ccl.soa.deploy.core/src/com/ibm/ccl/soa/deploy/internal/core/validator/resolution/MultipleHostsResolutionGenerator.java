/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

/**
 * Resolves {@link ICoreProblemType#UNIT_MULTIPLE_HOSTS}
 * 
 */
public class MultipleHostsResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		Unit[] hosts = unit.getTopology().findHosts(unit);
		if ((hosts == null) || (hosts.length < 1)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		List resolutions = new LinkedList();
		for (int i = 0; i < hosts.length; i++) {
			Unit host = hosts[i];
			for (Iterator iter = host.getHostingLinks().iterator(); iter.hasNext();) {
				HostingLink link = (HostingLink) iter.next();
				if (link.getTarget() == unit) {
					resolutions.add(new DeleteHostingLinkResolution(context, link, host, this));
				}
			}
		}

		return (IDeployResolution[]) resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!ICoreProblemType.UNIT_MULTIPLE_HOSTS.equals(context.getDeployStatus().getProblemType())) {
			return false;
		}
		if (!(context.getDeployStatus().getDeployObject() instanceof Unit)) {
			return false;
		}
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		if (unit.getTopology() == null) {
			return false;
		}
		return unit.getInitInstallState() != InstallState.INSTALLED_LITERAL;
	}
}
