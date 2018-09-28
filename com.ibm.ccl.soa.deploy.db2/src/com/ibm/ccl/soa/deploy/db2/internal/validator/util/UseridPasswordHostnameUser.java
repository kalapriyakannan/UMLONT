/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.util;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.os.User;

public class UseridPasswordHostnameUser {
	private String _userid;
	private String _password;
	private String _hostname;
	private User _user;
	private UnitDescriptor _userUD;
	private Requirement _userReq;
	private UnitDescriptor _operatingSystemUD;

	public UseridPasswordHostnameUser(String userid, String password, String hostname, User user,
			UnitDescriptor userUD, Requirement userReq, UnitDescriptor operatingSystemUD) {
		_userid = userid;
		_password = password;
		_hostname = hostname;
		_user = user;
		_userUD = userUD;
		_userReq = userReq;
		_operatingSystemUD = operatingSystemUD;
	}

	public String getHostname() {
		return _hostname;
	}

	public void setHostname(String hostname) {
		this._hostname = hostname;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	public User getUser() {
		return _user;
	}

	public void setUser(User user) {
		this._user = user;
	}

	public String getUserid() {
		return _userid;
	}

	public void setUserid(String userid) {
		this._userid = userid;
	}

	public UnitDescriptor getUserUD() {
		return _userUD;
	}

	public void setUserUD(UnitDescriptor userUD) {
		_userUD = userUD;
	}

	public Requirement getUserReq() {
		return _userReq;
	}

	public void setUserReq(Requirement req) {
		_userReq = req;
	}

	public UnitDescriptor getOperatingSystemUD() {
		return _operatingSystemUD;
	}

	public void setOperatingSystemUD(UnitDescriptor operatingSystemUD) {
		_operatingSystemUD = operatingSystemUD;
	}
}
