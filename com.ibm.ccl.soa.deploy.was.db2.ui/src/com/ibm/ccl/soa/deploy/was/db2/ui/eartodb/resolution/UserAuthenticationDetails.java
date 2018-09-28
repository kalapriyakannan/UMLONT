/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution;

import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Details for OS based authentication (user/password).
 */
public class UserAuthenticationDetails {
	protected String userId;
	protected String password;

	/**
	 * Constructor.
	 * 
	 * @param userId
	 *           user id
	 * @param password
	 *           password
	 */
	public UserAuthenticationDetails(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	/**
	 * Constructor.
	 * 
	 * @param user
	 *           OS user capability
	 */
	public UserAuthenticationDetails(User user) {
		this.userId = user.getUserId();
		this.password = user.getUserPassword();
	}

	/**
	 * Constructor.
	 * 
	 * @param userUnit
	 *           OS user unit
	 */
	public UserAuthenticationDetails(UserUnit userUnit) {
		User user = (User) ValidatorUtils.getFirstCapability(userUnit, OsPackage.Literals.USER);
		this.userId = user.getUserId();
		this.password = user.getUserPassword();
	}

	/**
	 * Constructor.
	 * 
	 * @param j2c
	 *           J2C authentication data entry
	 */
	public UserAuthenticationDetails(J2CAuthenticationDataEntry j2c) {
		this.userId = j2c.getUserId();
		this.password = j2c.getPassword();
	}

	/**
	 * Constructor.
	 * 
	 * @param j2cUnit
	 *           J2C authentication data entry
	 */
	public UserAuthenticationDetails(J2CAuthenticationUnit j2cUnit) {
		J2CAuthenticationDataEntry j2c = (J2CAuthenticationDataEntry) ValidatorUtils
				.getFirstCapability(j2cUnit, J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		this.userId = j2c.getUserId();
		this.password = j2c.getPassword();
	}

	/**
	 * Retrieve the user id
	 * 
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Retrieve the password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
