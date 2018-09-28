/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * create a datasource for application whose requirement for datasource is not satisfied
 * 
 * @author lidb@cn.ibm.com
 * 
 */
public class GenerateDataSourceUnitForApplicationDeployedResolutionGenerator extends
		DeployResolutionGenerator {
	private static String _server_scope = "server"; //$NON-NLS-1$
	private static String _cluster_scope = "cluster"; //$NON-NLS-1$
	private static String _node_scope = "node"; //$NON-NLS-1$
	private static String _cell_scope = "cell"; //$NON-NLS-1$

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		Unit applicationUnit = (Unit) status.getDeployObject();
		Topology top = applicationUnit.getEditTopology();

		Unit serverUnit = ValidatorUtils.getHost(applicationUnit);
		if (serverUnit == null) {
			return null;
		}

		Object[] bindings = status.getBindings();
		if (bindings != null) {
			if (bindings[1] != null && bindings[0] instanceof String) {
				String ds_jndiName = (String) bindings[0];
				if (ds_jndiName != null && ds_jndiName.length() > 0) {
					if (bindings[1] != null && bindings[1] instanceof Map) {
						//create datasource on current jdbcprovider resolution
						HashMap jdbcproviderUnitMap = (HashMap) bindings[1];
						if (!jdbcproviderUnitMap.isEmpty()) {
							IDeployResolution[] resolutions = new IDeployResolution[jdbcproviderUnitMap
									.size()];
							Iterator jdbcProUnitIt = jdbcproviderUnitMap.values().iterator();
							for (int i = 0; i < resolutions.length; i++) {
								DB2JdbcProviderUnit currentJdbcProUnit = (DB2JdbcProviderUnit) jdbcProUnitIt
										.next();
								resolutions[i] = new CreateDSUnitOnCurrentJDBCProviderUnitResolution(
										context, this, currentJdbcProUnit, ds_jndiName, top);
							}
							return resolutions;
						}

					}

					//if there are no jdbcproviders at all
					if (serverUnit instanceof WebsphereAppServerUnit) {
						WebsphereAppServerUnit wasServerUnit = (WebsphereAppServerUnit) serverUnit;
						//resolution for insert the datasourceUnit in server/node/cell scope
						WasNode nodeCap = WasUtil.getWasNodeCap(wasServerUnit, top);
						WasNodeUnit nodeUnit;
						WasCellUnit cellUnit;
						if (nodeCap != null && nodeCap.getParent() != null) {
							nodeUnit = (WasNodeUnit) nodeCap.getParent();
							WasCell cellCap = WasUtil.getWasCellCap(nodeUnit, top);
							if (cellCap != null && cellCap.getParent() != null) {
								cellUnit = (WasCellUnit) cellCap.getParent();
								return new IDeployResolution[] {
										new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
												this, _cell_scope, ds_jndiName, cellUnit, top),
										new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
												this, _node_scope, ds_jndiName, nodeUnit, top),
										new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
												this, _server_scope, ds_jndiName, wasServerUnit, top) };
							}
							return new IDeployResolution[] {
									new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
											this, _node_scope, ds_jndiName, nodeUnit, top),
									new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
											this, _server_scope, ds_jndiName, wasServerUnit, top) };
						}
						//IDeployResolution[] resolutions = {new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context, this, _server_scope, ds_jndiName, wasServerUnit)};						 
						return new IDeployResolution[] { new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(
								context, this, _server_scope, ds_jndiName, wasServerUnit, top) };
					} else if (serverUnit instanceof WasClusterUnit) {
						WasClusterUnit wasClusterUnit = (WasClusterUnit) serverUnit;
						WasCell cellCap = WasUtil.getWasCellCap(wasClusterUnit, top);
						if (cellCap != null && cellCap.getParent() != null) {
							WasCellUnit cellUnit = (WasCellUnit) cellCap.getParent();
							return new IDeployResolution[] {
									new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
											this, _cell_scope, ds_jndiName, cellUnit, top),
									new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(context,
											this, _cluster_scope, ds_jndiName, wasClusterUnit, top) };
						}
						return new IDeployResolution[] { new CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(
								context, this, _cluster_scope, ds_jndiName, wasClusterUnit, top) };

					}
				}
			}
		}

		return null;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// MK 8/23/2007: disabled resolution generation until contract aware
//		if (!IWASProblemType.MISSING_WAS_DATASOURCE_FOR_APPLICATION.equals(context.getDeployStatus()
//				.getProblemType())) {
//			return false;
//		}
//		return true;
		return false;
	}

	private static class CreateDSUnitOnCurrentJDBCProviderUnitResolution extends DeployResolution {
		private final DB2JdbcProviderUnit _jdbcProviderUnit;
		private final String _ds_jndiName;
		private final Topology _top;

		public CreateDSUnitOnCurrentJDBCProviderUnitResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, DB2JdbcProviderUnit jdbcProviderUnit,
				String ds_jndiName, Topology top) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_create_datasourceUnit_0_on_jdbcProviderUnit_1,
					ds_jndiName, jdbcProviderUnit));
			_jdbcProviderUnit = jdbcProviderUnit;
			_ds_jndiName = ds_jndiName;
			_top = top;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			if (_jdbcProviderUnit == null && _top == null) {
				return null;
			}

			WasDatasourceUnit dsUnit = null;
			dsUnit = (WasDatasourceUnit) ResolutionUtils.addFromTemplate(
					IWasTemplateConstants.WAS_DB2_DATASOURCE_UNIT_5, _top);
			WasDatasource datasourceCap = (WasDatasource) ValidatorUtils.getCapability(dsUnit,
					WasPackage.Literals.WAS_DATASOURCE);
			assert datasourceCap != null;
//			datasourceCap.setDbName("Resolution_created_DS_DbName"); //$NON-NLS-1$
			dsUnit.setDisplayName(WasDomainMessages.Resolution_create_datasource_description);
			datasourceCap.setJndiName(_ds_jndiName);
			ResolutionUtils.hosts(context, _jdbcProviderUnit, dsUnit);
			return Status.OK_STATUS;
		}

	}

	/**
	 * create a jdbcproviderUnit first, then create the require datasource on this unit
	 * 
	 * 
	 */
	private static class CreateGenerateAndInsertDSUnitIntoCertainScopeResolution extends
			DeployResolution {
		private final String _ds_jndiName;
		private final Unit _scopeUnit;
		private final Topology _top;

		public CreateGenerateAndInsertDSUnitIntoCertainScopeResolution(
				IDeployResolutionContext context, IDeployResolutionGenerator generator, String scope,
				String ds_jndiName, Unit scopeUnit, Topology top) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_create_datasourceUnit_0_in_scope_1, ds_jndiName, scope));
			_ds_jndiName = ds_jndiName;
			_scopeUnit = scopeUnit;
			_top = top;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			if (_ds_jndiName != null && _scopeUnit != null) {
				DB2JdbcProviderUnit jdbcUnit = null;
				jdbcUnit = (DB2JdbcProviderUnit) ResolutionUtils.addFromTemplate(
						IWasTemplateConstants.WAS_DB2_JDBC_PROVIDER_UNIT, _top);
				DB2JdbcProvider jdbcCap = (DB2JdbcProvider) ValidatorUtils.getCapability(jdbcUnit,
						WasPackage.Literals.DB2_JDBC_PROVIDER);
				assert jdbcCap != null;
				jdbcUnit.setDisplayName("Resolution_created_JDBCProvider_Unit"); //$NON-NLS-1$
				ResolutionUtils.hosts(context, _scopeUnit, jdbcUnit);

				WasDatasourceUnit dsUnit = null;
				dsUnit = (WasDatasourceUnit) ResolutionUtils.addFromTemplate(
						IWasTemplateConstants.WAS_DB2_DATASOURCE_UNIT_5, _top);
				WasDatasource datasourceCap = (WasDatasource) ValidatorUtils.getCapability(dsUnit,
						WasPackage.Literals.WAS_DATASOURCE);
				assert datasourceCap != null;
//				datasourceCap.setDbName("Resolution_created_DS_DbName"); //$NON-NLS-1$
				dsUnit.setDisplayName(WasDomainMessages.Resolution_create_jdbc_provider_description);
				datasourceCap.setJndiName(_ds_jndiName);
				ResolutionUtils.hosts(context, jdbcUnit, dsUnit);

				return Status.OK_STATUS;
			}
			return null;
		}

	}

}
