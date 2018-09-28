/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.UnifiedDiscoveryResultFilter;

/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
public class UserFilter extends UnifiedDiscoveryResultFilter implements IDiscoveryResultFilter {

	/**
	 * Constructor that stores the requirements for a user.
	 * 
	 * @param userId
	 *           the expected user
	 * @param userPassword
	 *           the expected password
	 */
	public UserFilter(String userId, String userPassword) {
		super(new IDiscoveryResultFilterTest[] { new MatchesUserIdPassword(userId, userPassword) });
	}

}
