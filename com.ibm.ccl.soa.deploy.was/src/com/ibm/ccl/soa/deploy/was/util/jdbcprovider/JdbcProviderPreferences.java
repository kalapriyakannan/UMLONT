/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * JDBC provider preferences.
 */
public class JdbcProviderPreferences {
	private JdbcTypeType type = JdbcTypeType._2_LITERAL;

	private Boolean XA = null;

	/** database type; extends capability */
	private EClass dbType;

	private String tag;

	/**
	 * Constructor
	 */
	public JdbcProviderPreferences() {
	}

	/**
	 * Constructor given explicit requirements.
	 * 
	 * @param dbType
	 *           the target database type (extending {@link Capability}
	 * @param type
	 *           JDBC type
	 * @param XARequired
	 *           flag indicating whether or not provider should be XA compliant
	 */
	public JdbcProviderPreferences(EClass dbType, JdbcTypeType type, Boolean XARequired, String tag) {
		this.dbType = dbType;
		this.type = type;
		XA = XARequired;
		this.tag = tag;
	}

	/**
	 * Constructor of preference given a DB2 JDBC driver.
	 * 
	 * @param driver
	 *           a DB2 JDBC driver
	 */
	public JdbcProviderPreferences(DB2JdbcDriver driver) {
		type = driver.getJdbcType();
		dbType = Db2Package.Literals.DB2_DATABASE;
		XA = WasJdbcProviderHelper.INSTANCE.providesXA(driver.getClassname());
		tag = driver.getDisplayName();
	}

	/**
	 * Set JDBC type desired.
	 * 
	 * @param type
	 *           JDBC type
	 */
	public void setJdbcType(JdbcTypeType type) {
		this.type = type;
	}

	/**
	 * Identify whether or not XA driver needed.
	 * 
	 * @param XARequired
	 *           flag indicating whether or not XA driver needed
	 */
	public void setXARequired(Boolean XARequired) {
		XA = XARequired;
	}

	/**
	 * Identify type of database to be accessed
	 * 
	 * @param dbType
	 *           database type (extending {@link Capability})
	 */
	public void setDbType(EClass dbType) {
		this.dbType = dbType;
	}

	/**
	 * Identify tag of provider
	 * 
	 * @param tag
	 *           tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Get JDBC type
	 * 
	 * @return JDBC type
	 */
	public JdbcTypeType getJdbcType() {
		return type;
	}

	/**
	 * Determine if XA driver needed.
	 * 
	 * @return flag
	 */
	public Boolean isXARequired() {
		return XA;
	}

	/**
	 * Retrieve the type of the database.
	 * 
	 * @return database type (extending {@link Capability})
	 */
	public EClass getDbType() {
		return dbType;
	}

	/**
	 * Retrieve the tag of the database provider
	 * 
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Utility method to create a list of database preferences given a target database unit.
	 * 
	 * @param dbUnit
	 *           target database unit
	 * @return list of preferences
	 */
	public static List<JdbcProviderPreferences> getJdbcProviderPreferences(DatabaseUnit dbUnit) {
		List<JdbcProviderPreferences> preferences = new ArrayList<JdbcProviderPreferences>();
		if (Db2Package.Literals.DB2_DATABASE_UNIT.isSuperTypeOf(dbUnit.getEObject().eClass())) {
			DB2SystemUnit systemUnit = (DB2SystemUnit) TopologyDiscovererService.INSTANCE.findHost(
					dbUnit, Db2Package.Literals.DB2_SYSTEM_UNIT, dbUnit.getTopology(),
					new NullProgressMonitor());
			List<Capability> drivers = ValidatorUtils.getCapabilities(systemUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
			for (int i = 0; i < drivers.size(); i++) {
				DB2JdbcDriver driver = (DB2JdbcDriver) drivers.get(i);
				preferences.add(new JdbcProviderPreferences(Db2Package.Literals.DB2_DATABASE, driver
						.getJdbcType(), null, driver.getDisplayName()));
			}
		} else {
			// handle other database types; currently we have modeled only a DB2
			// JDBC Driver
		}
		return preferences;
	}
}
