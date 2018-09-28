/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution.UserAuthenticationDetails;

/**
 * Filter to be used on results from a discoverer to ensure that the authentication entry returned
 * will not override other authentication entries already configured.
 */
/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
public class AuthenticationEntryNotUsed implements IDiscoveryResultFilterTest {

	/** Topology */
	private final Topology topology;

	/** Requirement trying to satisfy with a data source */
	private final Requirement requirement;

	/** expected userid */
	protected UserAuthenticationDetails user;

	/**
	 * Constructor that stores the topology and a unit's requirement for a authentication unit
	 * 
	 * @param topology
	 *           the topology
	 * @param req
	 *           a modules requirement for a datasource
	 * @param userId
	 *           the expected user id of the authentication entry
	 * @param password
	 *           the expected password of the authentication entry
	 */
	public AuthenticationEntryNotUsed(Topology topology, Requirement req,
			UserAuthenticationDetails user) {
		this.topology = topology;
		this.requirement = req;
		this.user = user;
	}

	/**
	 * Filter out any authentication units that have already been configured and are "in use"; that
	 * is, they are the target of existing DependencyLinks. In such cases, mutable attributes are, in
	 * practise, immutable.
	 * 
	 * @param units
	 *           list of unit descriptors to filter
	 * @return list of unit descriptors that have mutable attributes
	 */
	public boolean isUnitOK(Unit candidateUnit) {
		boolean candidateValid = true;

		// identify all referers to the authentication entry
		Capability cap = ValidatorUtils.getFirstCapability(candidateUnit,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		List referenceUD = TopologyDiscovererService.INSTANCE.findSources(candidateUnit, cap,
				topology);

		for (Iterator iter = referenceUD.iterator(); iter.hasNext();) {
			UnitDescriptor rUD = (UnitDescriptor) iter.next();
			Unit referer = rUD.getUnitValue();
			for (Iterator rIt = referer.getRequirements().iterator(); rIt.hasNext();) {
				Requirement req = (Requirement) rIt.next();

//						System.out.println ("   checking for use by module, requirement"); //$NON-NLS-1$
//						System.out.println ("      " + module); //$NON-NLS-1$
//						System.out.println ("      " + req); //$NON-NLS-1$

				if (req == requirement) {
					// if there is a match in this case, we want to allow
					// it; no need to check further
//							System.out.println ("   matches requirement --> we can use this datasource"); //$NON-NLS-1$
					return true; //continue;
				}

				if (!J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY
						.isSuperTypeOf(req.getDmoEType())) {
//							System.out.println ("   req not for datasource; skipping"); //$NON-NLS-1$
					// keep looking for the requirement type we need
					continue; //return true;
				}

				// check that the referer isn't using a different requirement to get to the target
				UnitDescriptor targetAuthUD = TopologyDiscovererService.INSTANCE.findTarget(referer,
						req, topology);
				if (targetAuthUD == null) {
//							System.out.println ("   target datasource UD is null; skipping"); //$NON-NLS-1$
					return true; //continue;
				}
				Unit auth = targetAuthUD.getUnitValue();
				if (auth == candidateUnit) {
					// there is already a referer depending on this
					// authentication entry; we can only use it if the user/password already
					// matches our needs (ie, we cannot assume that we
					// can change the attributes on the datasource

//							System.out.println ("   found match to datasource, capability"); //$NON-NLS-1$
//							System.out.println ("      " + ds); //$NON-NLS-1$
//							System.out.println ("      " + cap); //$NON-NLS-1$

					J2CAuthenticationDataEntry authEntry = (J2CAuthenticationDataEntry) ValidatorUtils
							.getFirstCapability(auth, J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);

					if ((null == authEntry.getUserId())
							|| !authEntry.getUserId().equals(user.getUserId())
							|| (null == authEntry.getPassword())
							|| !authEntry.getPassword().equals(user.getPassword())) {
						candidateValid = false;
					}
				}
			}
		}

		return candidateValid;
	}

}
