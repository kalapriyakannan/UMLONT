/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;

/**
 * Tests if a units user and password match expected values.
 */
public class MatchesUserIdPassword implements IDiscoveryResultFilterTest {

	/** Required user id */
	private final String user;

	/** Required user password */
	private final String password;

	/**
	 * Constructor that stores the topology and a units expected user id and password.
	 * 
	 * @param userId
	 *           expected user id
	 * @param userPassword
	 *           expected password
	 */
	public MatchesUserIdPassword(String userId, String userPassword) {
		this.user = userId;
		this.password = userPassword;
	}

	/**
	 * Filter out any user units that don't match the user id and password.
	 * 
	 * @param units
	 *           list of unit descriptors to filter
	 * @return list of unit descriptors that have mutable attributes
	 */
	public boolean isUnitOK(Unit unit) {
		if (null == unit)
			return false;

		if (!OsPackage.Literals.USER_UNIT.isSuperTypeOf(unit.getEObject().eClass())) {
			return false;
		}

		UserUnit userUnit = (UserUnit) unit;
		User user = (User) ValidatorUtils.getFirstCapability(userUnit, OsPackage.Literals.USER);
		if (null == user)
			return false;

		return user.getUserId().equals(this.user) && user.getUserPassword().equals(this.password);
	}

}
