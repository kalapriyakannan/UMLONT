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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to set the publish intent on hosted units.
 */
public class DoNotPublishHostedUnitsResolution extends DeployResolution {

	/**
	 * Construct a resolution to set the publish intent on hosted units.
	 * 
	 * @param context
	 * @param generator
	 */
	public DoNotPublishHostedUnitsResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, DeployCoreMessages.Resolution_do_not_publish_all_hosted_units);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		setPublishIntentRecursive(unit, unit.getTopology(), unit.getPublishIntent());
		return Status.OK_STATUS;
	}

	/**
	 * Recursively sets the publish intent of the unit and all its hosted units.
	 * 
	 * @param unit
	 *           the unit whose publish intent should be set.
	 * @param topology
	 *           the topology used for discovery.
	 * @param intent
	 *           the desired publish intent.
	 */
	public static void setPublishIntentRecursive(Unit unit, Topology topology, PublishIntent intent) {
		if (unit == null) {
			return;
		}
		if ((topology.equals(unit.getTopology())) && (unit.getPublishIntent() != intent)) {
			unit.setPublishIntent(intent);
		}
		List hosted = TopologyDiscovererService.INSTANCE.findHosted(unit, unit.getTopology());
		if ((hosted != null) && (hosted.size() > 0)) {
			for (Iterator iter = hosted.iterator(); iter.hasNext();) {
				UnitDescriptor descriptor = (UnitDescriptor) iter.next();
				setPublishIntentRecursive(descriptor.getUnitValue(), topology, intent);
			}

		}
	}
}
