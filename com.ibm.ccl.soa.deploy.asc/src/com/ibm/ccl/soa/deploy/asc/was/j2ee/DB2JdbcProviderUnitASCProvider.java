/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.j2ee;

import java.util.HashMap;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.exception.ASCExceptionMsg;
import com.ibm.ccl.soa.deploy.asc.was.WASASCProvider;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.util.JavaCapabilityUtils;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * UnitProvider Contribution: DB2JdbcProviderUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_DB2JDBCPROVIDER} asc task for {@link DB2JdbcProviderUnit}
 * 
 * @see DB2JdbcProvider
 * @see DB2JdbcProviderUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class DB2JdbcProviderUnitASCProvider extends WASASCProvider {
	private static HashMap poolProvider;
	private static HashMap xaProvider;
	{
		poolProvider = new HashMap();
		poolProvider.put(DB2JdbcProviderType.DB2_FOR_ZOS_LOCAL_JDBC_PROVIDER_RRS_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_RRS);
		poolProvider.put(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_LEGACY);
		poolProvider.put(DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_UNIVERSAL);
		poolProvider.put(DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_NATIVE);
		poolProvider.put(DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_TOOLBOX);
		xaProvider = new HashMap();
		xaProvider.put(DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_LEGACY);
		xaProvider.put(DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_UNIVERSAL);
		xaProvider.put(DB2JdbcProviderType.DB2UDB_FOR_ISERIES_NATIVE_XA_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_NATIVE);
		xaProvider.put(DB2JdbcProviderType.DB2UDB_FOR_ISERIES_TOOLBOX_LITERAL,
				ASCConstants.WAS_JDBCPROVIDER_TOOLBOX);

	}

	protected void initTasks_Base() throws ASCException {
		ascTaskName = new String[] { ASCConstants.TASK_SET_DB2JDBCPROVIDER };
		Properties setProvider = new Properties();
		ascProps = new Properties[] { setProvider };
		setEnvProp(setProvider);
		DB2JdbcProvider provider = (DB2JdbcProvider) CapabilityUtil.findCapabilityOfType(unit,
				WasPackage.eINSTANCE.getDB2JdbcProvider());

		super.setAscProperty(setProvider, ASCConstants.DESCRIPTION, provider.getDescription());
		super.setAscProperty(setProvider, ASCConstants.WAS_JDBCPROVIDER_NAME, JavaCapabilityUtils
				.getProviderName((JdbcProviderUnit) unit));
		String providerType = (String) poolProvider.get(provider.getTemplate());
		if (providerType != null) {
			super.setAscProperty(setProvider, ASCConstants.WAS_JDBCPROVIDER_TYPE, providerType);
			super.setAscProperty(setProvider, ASCConstants.WAS_JDBCPROVIDER_IMPLEMENTATION_TYPE,
					"Pool"); //$NON-NLS-1$
		} else {
			providerType = (String) xaProvider.get(provider.getTemplate());
			if (providerType != null) {
				super.setAscProperty(setProvider, ASCConstants.WAS_JDBCPROVIDER_TYPE, providerType);
				super.setAscProperty(setProvider, ASCConstants.WAS_JDBCPROVIDER_IMPLEMENTATION_TYPE,
						"XA"); //$NON-NLS-1$
			} else {
				throw new ASCException(ASCExceptionMsg.bind(
						ASCExceptionMsg.NO_SUPPORTE_PROPERTY_SETTING, providerType), new Exception());
			}
		}

		super.setASCAgentProp(setProvider);
	}

}
