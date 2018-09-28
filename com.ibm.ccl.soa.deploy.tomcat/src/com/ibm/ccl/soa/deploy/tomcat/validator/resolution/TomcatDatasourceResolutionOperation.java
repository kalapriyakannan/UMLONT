/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.ide.validator.resolution.IDatasourceResolutionProperties;
import com.ibm.ccl.soa.deploy.ide.validator.resolution.ServerDatasourceResolutionOperation;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDatasourceUnitImpl;

/**
 * @author jeswanke
 * 
 * operation to create the topology model, then passes the result to the visualization operation to
 * create the GMF diagram
 */
public class TomcatDatasourceResolutionOperation extends ServerDatasourceResolutionOperation {

	private static final String TOMCAT_50_DATASOURCE_ID = "tomcat.TomcatDatasourceUnit.50"; //$NON-NLS-1$

	/**
	 * 
	 */
	public TomcatDatasourceResolutionOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public TomcatDatasourceResolutionOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doExecute(IProgressMonitor monitor) {

		Object[] databaseUnits = (Object[]) getDataModel().getProperty(
				IDatasourceResolutionProperties.DATABASE_UNITS);
		Unit sourceUnit = (Unit) getDataModel().getProperty(
				IDatasourceResolutionProperties.SOURCE_UNIT);
		datasourceReq = getRequirement(sourceUnit);

		Topology topology = getTopology();
		Unit[] hosts = topology.findHosts(sourceUnit);
		assert hosts.length == 1;
		Unit host = hosts[0]; // Asssuming only one host

		// Workaround for lack of enablement in the post-operation framework
		// If the source unit is not hosted on a Tomcat unit, do not do anything here.
		if (!host.eClass().getEPackage().getNsPrefix().equals(TomcatPackage.eINSTANCE.getNsPrefix()))
			return OK_STATUS;

		Unit databaseUnit = (Unit) databaseUnits[0]; // Assuming only one database unit

		TomcatDatasourceUnit datasourceUnit = createDataSourceUnit(topology);

		ResolutionUtils.hosts(null, host, datasourceUnit);

		createLinkToDatasource(sourceUnit, datasourceUnit);

		ResolutionUtils.link(null, datasourceUnit, DatabasePackage.eINSTANCE.getDatabase(),
				databaseUnit, DatabasePackage.eINSTANCE.getDatabase());

		return OK_STATUS;
	}

	private TomcatDatasourceUnitImpl createDataSourceUnit(Topology topology) {
		Unit unit = (Unit) ResolutionUtils.addFromTemplate(TOMCAT_50_DATASOURCE_ID, topology);

		if (!(unit instanceof TomcatDatasourceUnit))
			return null;

		TomcatDatasourceUnitImpl dataSource = (TomcatDatasourceUnitImpl) unit;

		Tomcat50Datasource tomcatDsCapability = (Tomcat50Datasource) CapabilityUtil
				.findCapabilityOfType(dataSource, TomcatPackage.eINSTANCE.getTomcat50Datasource());
		if (tomcatDsCapability == null) {
			// Create a status - the provider does not have the appropriate capability
			// Or leave this to validation and continue as best as possible?
		} else {
			tomcatDsCapability.setDbName(getDataModel().getStringProperty(
					IDatasourceResolutionProperties.DATABASE_NAME));
			tomcatDsCapability.setJndiName(getJndiNameFromSourceUnit());
			tomcatDsCapability.setDatasourceName(getDataModel().getStringProperty(
					IDatasourceResolutionProperties.DATASOURCE_REQUIREMENT));
			tomcatDsCapability.setUsername(getDataModel().getStringProperty(
					IDatasourceResolutionProperties.DATABASE_USERNAME));
			tomcatDsCapability.setPassword(getDataModel().getStringProperty(
					IDatasourceResolutionProperties.DATABASE_PASSWORD));
		}

		return dataSource;
	}

}
