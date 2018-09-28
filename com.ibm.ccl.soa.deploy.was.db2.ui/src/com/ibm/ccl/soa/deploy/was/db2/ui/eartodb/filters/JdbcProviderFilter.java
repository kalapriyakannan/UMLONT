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
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.JdbcProviderPreferences;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WasJdbcProviderHelper;

/**
 * Filter to be used on results from a discoverer to ensure that the JDBC provider matches the user
 * preferences.
 */
public class JdbcProviderFilter implements IDiscoveryResultFilter {

	List preferences;

	/**
	 * Constuctor.
	 * 
	 * @param preferences
	 *           list of user preferences for new JDBC providers
	 */
	public JdbcProviderFilter(List preferences) {
		this.preferences = preferences;
	}

	public List select(List units) {
		List filtered = new ArrayList();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			boolean candidateProviderValid = false;
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			JdbcProviderUnit candidateProviderUnit = (JdbcProviderUnit) ud.getUnitValue();

			// if it is a DB2 JDBC Provider we know more about it
			if (candidateProviderUnit instanceof DB2JdbcProviderUnit) {
				// check that type matches something we can use

				for (int i = 0; i < preferences.size(); i++) {
					JdbcProviderPreferences pref = (JdbcProviderPreferences) preferences.get(i);
					DB2JdbcProvider db2Provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
							candidateProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
					if (pref.getJdbcType() != null) {
						if (!db2Provider.getJdbcType().equals(pref.getJdbcType())) {
							continue;
						}
					}
					// check that if XA required then we have it
					Boolean XA = pref.isXARequired();
					if (null != XA && XA.booleanValue()) {
						if (WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
								DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL
										.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL
												.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_XA_LITERAL.toString())) {
							candidateProviderValid = true;
							break;
						}
					} else {
						if (WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
								DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
										.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL
												.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_LITERAL.toString())
								|| WasJdbcProviderHelper.INSTANCE.getProviderTypeAsString(pref).equals(
										DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL.toString())) {
							candidateProviderValid = true;
							break;
						}
					}
				}
			}
			if (candidateProviderValid) {
				filtered.add(ud);
			}
		}
		return filtered;
	}
}
