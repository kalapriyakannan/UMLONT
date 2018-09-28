/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Messages;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;

/**
 * Generates resolutions or markers on an object attribute with an expected value.
 */
public class InsertNewDatabaseInstanceGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		return IDB2ProblemType.DB2_INSTANCE_UNIT_MISSING.equals(context.getDeployStatus()
				.getProblemType());
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		IDeployStatus status = context.getDeployStatus();
		Requirement req = (Requirement) status.getDeployObject();
		Unit dbUnit = (Unit) req.getParent();

		// get database system; both are in the topology, linked by hosting link
		Unit logicalHost = ValidatorUtils.getHost(dbUnit);
		assert logicalHost != null;
		DB2SystemUnit systemUnit = (DB2SystemUnit) logicalHost;

		// add existing instances as possible
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(systemUnit, systemUnit
				.getEditTopology());
		filter.setUnitTypes(new Class[] { DB2InstanceUnit.class });
		List<UnitDescriptor> matches = TopologyDiscovererService.INSTANCE.findAll(filter);
		List<IDeployResolution> resolutionsList = new ArrayList<IDeployResolution>();
		for (Iterator<UnitDescriptor> iter = matches.iterator(); iter.hasNext();) {
			UnitDescriptor candidate = iter.next();
			String description = DeployNLS.bind(Messages.Resolution_host_database_on_instance_0,
					candidate.getDisplayName());

			resolutionsList.add(new InsertNewDatabaseInstance(context, this, candidate, description));
		}

		// add installables

		// add template
		//TODO replace string with constant for template URIs
		resolutionsList.add(new InsertNewDatabaseInstance(context, this,
				"db2.DB2InstanceUnit.8", Messages.Resolution_create_database_instance)); //$NON-NLS-1$

		// create result
		IDeployResolution resolutions[] = new IDeployResolution[resolutionsList.size()];
		for (int i = 0; i < resolutionsList.size(); i++) {
			resolutions[i] = resolutionsList.get(i);
		}
		return resolutions;
	}
}
