/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.j2ee;

import java.util.Iterator;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.was.WASASCProvider;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource;

/**
 * UnitProvider Contribution: WasDatasourceUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_DB2DATASOURCE_V5} for {@link DB2DatabaseUnit}
 * 
 * @see WasDatasource
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> 2006-8-17
 */
public class WasDatasourceUnitASCProvider extends WASASCProvider {

	public boolean isConditionSatisfied() {

		if (getDataSourceCap() != null && getDataSourceCap() instanceof WasV5DB2Datasource)
			return true;
		else
			return false;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	protected void initTasks_Base() throws ASCException {

		super.ascTaskName = new String[] { ASCConstants.TASK_SET_DB2DATASOURCE_V5 };
		Properties props = new Properties();
		super.setEnvProp(props);

		super.setAscProperty(props, ASCConstants.WAS_JDBCPROVIDER_NAME, getProviderName(unit));
		super.setAscProperty(props, ASCConstants.WAS_DATASOURCE_NAME, unit.getDisplayName());

		WasV5DB2Datasource dataSource = this.getDataSourceCap();
		super.setAscProperty(props, ASCConstants.WAS_DATABASE_NAME, dataSource.getDbName());
		super.setAscProperty(props, ASCConstants.WAS_JNDI_NAME, dataSource.getJndiName());
		super.setAscProperty(props, ASCConstants.WAS_DBSERVER_NAME, dataSource.getHostname());
		super.setAscProperty(props, ASCConstants.WAS_DATASOURCE_AUTHALIAS, dataSource
				.getJ2cAuthAlias());
		super.setASCAgentProp(props);
		super.ascProps = new Properties[] { props };
	}

	private String getProviderName(Unit unit) {

		Unit jdbcProvider = TopologyDiscovererService.INSTANCE.findHost(unit, unit.getTopology());
		DB2JdbcProvider cap = (DB2JdbcProvider) CapabilityUtil.findCapabilityOfType(jdbcProvider,
				WasPackage.eINSTANCE.getDB2JdbcProvider());

		return cap.getProviderName();
	}

	private WasV5DB2Datasource getDataSourceCap() {
		WasV5DB2Datasource dataSource = null;

		for (Iterator cIt = unit.getCapabilities().iterator(); cIt.hasNext();) {
			Capability cap = (Capability) cIt.next();
			if (cap instanceof WasV5DB2Datasource)
				dataSource = (WasV5DB2Datasource) cap;
		}
		return dataSource;
	}
}
