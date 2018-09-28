/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.UnifiedDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution.UserAuthenticationDetails;

/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
public class J2CAuthenticationUserFilter extends UnifiedDiscoveryResultFilter implements
		IDiscoveryResultFilter {

	/**
	 * Constructor that stores the topology and a module's requirement for a datasource
	 * 
	 * @param topology
	 *           the topology
	 * @param req
	 *           a referers requirement for an authentication entry
	 * @param user
	 *           the expected user id and password
	 */
	public J2CAuthenticationUserFilter(Topology topology, Requirement req,
			UserAuthenticationDetails user) {
		super(
				new IDiscoveryResultFilterTest[] { new AuthenticationEntryNotUsed(topology, req, user) });
	}

}
