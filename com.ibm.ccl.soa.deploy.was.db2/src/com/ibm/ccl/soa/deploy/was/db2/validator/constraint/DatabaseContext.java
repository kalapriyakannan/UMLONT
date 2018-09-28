/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * References to the various related DB2 units from database to its hosting operating system
 */
public class DatabaseContext {

	/** database */
	public DatabaseUnit dbUnit;

	/** DB2 database instancej */
	public DB2InstanceUnit dbInstanceUnit;

	/** DB2 database system */
	public DB2SystemUnit dbSystemUnit;

	/** operating system */
	public OperatingSystemUnit dbOsUnit;

	/** instance administrator */
	public UserUnit userUnit;

	/**
	 * Constructor
	 * 
	 * @param dbUnit
	 *           database unit
	 * @param dbInstanceUnit
	 *           DB2 instance unit
	 * @param dbSystemUnit
	 *           DB2 system unit
	 * @param osSystemUnit
	 *           operating sysetem unit
	 * @param userUnit
	 *           instance administrator (user unit)
	 */
	public DatabaseContext(DatabaseUnit dbUnit, DB2InstanceUnit dbInstanceUnit,
			DB2SystemUnit dbSystemUnit, OperatingSystemUnit osSystemUnit, UserUnit userUnit) {
		this.dbUnit = dbUnit;
		this.dbInstanceUnit = dbInstanceUnit;
		this.dbSystemUnit = dbSystemUnit;
		dbOsUnit = osSystemUnit;
		this.userUnit = userUnit;
	}

	public DatabaseUnit getDatabaseUnit() {
		return dbUnit;
	}

	public DB2InstanceUnit getInstanceUnit() {
		return dbInstanceUnit;
	}

	public DB2SystemUnit getSystemUnit() {
		return dbSystemUnit;
	}

	public OperatingSystemUnit getOS() {
		return dbOsUnit;
	}

	public UserUnit getUser() {
		return userUnit;
	}

}
