/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution.UserAuthenticationDetails;

/**
 * Filter to be used on results from a discoverer to ensure that the J2C Authentication Entry
 * matches user credentials
 */
public class J2CAuthenticationFilter implements IDiscoveryResultFilter {

	protected UserAuthenticationDetails user;

	/**
	 * Constuctor.
	 * 
	 * @param user
	 *           authentication details
	 */
	public J2CAuthenticationFilter(UserAuthenticationDetails user) {
		this.user = user;
	}

	public List select(List units) {
		List filtered = new ArrayList();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			boolean candidateAuthenticationValid = true;
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			WASJ2CAuthenticationUnit candidateAuthenticationUnit = (WASJ2CAuthenticationUnit) ud
					.getUnitValue();

			// check that the user/password match
			J2CAuthenticationDataEntry authEntry = (J2CAuthenticationDataEntry) ValidatorUtils
					.getFirstCapability(candidateAuthenticationUnit,
							J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
			if ((null == authEntry) || (null == authEntry.getUserId())
					|| !authEntry.getUserId().equals(user.getUserId())
					|| (null == authEntry.getPassword())
					|| !authEntry.getPassword().equals(user.getPassword())) {
				candidateAuthenticationValid = false;
			}

			if (candidateAuthenticationValid)
				filtered.add(ud);
		}

		return filtered;
	}
}
