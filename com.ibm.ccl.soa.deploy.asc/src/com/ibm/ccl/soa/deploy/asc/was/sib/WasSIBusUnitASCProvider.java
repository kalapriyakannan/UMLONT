/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.sib;

import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasSIBus;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasSIBusUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_SIBUS} and {@link ASCConstants#TASK_ADD_APPSERVER_TOSIBU} and
 * {@link ASCConstants#TASK_ADD_CLUSTER_TOSIBU} asc task for {@link WasSIBusUnit}
 * 
 * @see WasSIBus
 * @see WasSIBusUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSIBusUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		List serverUnits = ASCUtil.findAllInstalledAppSvr((WasSIBusUnit) unit);
		super.ascTaskName = new String[serverUnits.size() + 1];
		super.ascTaskName[0] = ASCConstants.TASK_CREATE_SIBUS;
		for (int i = 1; i < super.ascTaskName.length; i++)
			super.ascTaskName[i] = ASCConstants.TASK_ADD_APPSERVER_TOSIBU;

		super.ascProps = new Properties[serverUnits.size() + 1];
		super.ascProps[0] = createSIBUSProps_Base();
		for (int i = 1; i < super.ascProps.length; i++)
			super.ascProps[i] = createAddServer2BusProps_Base((WebsphereAppServerUnit) serverUnits
					.get(i - 1), (WasSIBusUnit) unit);

	}

	public void initTasks_ND() throws ASCException {
		List serverUnits = ASCUtil.findAllInstalledAppSvr((WasSIBusUnit) unit);
		List clusterUnits = ASCUtil.findAllInstalledCluster((WasSIBusUnit) unit);
		int taskNumbers = serverUnits.size() + 1 + clusterUnits.size();
		super.ascTaskName = new String[taskNumbers];
		super.ascTaskName[0] = ASCConstants.TASK_CREATE_SIBUS;

		for (int i = 1; i < serverUnits.size() + 1; i++)
			super.ascTaskName[i] = ASCConstants.TASK_ADD_APPSERVER_TOSIBU;

		for (int i = serverUnits.size() + 1; i < ascTaskName.length; i++)
			super.ascTaskName[i] = ASCConstants.TASK_ADD_CLUSTER_TOSIBU;
		super.ascProps = new Properties[taskNumbers];
		//super.ascProps = new Properties[serverUnits.size() + 1];
		super.ascProps[0] = createSIBUSProps_Base();
		for (int i = 1; i < serverUnits.size() + 1; i++)
			super.ascProps[i] = createAddServer2BusProps_Base((WebsphereAppServerUnit) serverUnits
					.get(i - 1), (WasSIBusUnit) unit);
		for (int i = serverUnits.size() + 1; i < ascTaskName.length; i++)
			super.ascProps[i] = createAddCluster2BusProps((WasClusterUnit) clusterUnits.get(i - 1
					- serverUnits.size()), (WasSIBusUnit) unit);
	}

	/**
	 * busName
	 */
	// TODO
	private Properties createSIBUSProps_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);
		super.setAscProperty(props, "busname", getSibusName()); //$NON-NLS-1$

		return props;
	}

	private String getSibusName() {
		return ASCUtil.getAttribute(unit, "getBusName"); //$NON-NLS-1$;
	}

	/**
	 * task0.busName=TestBus task0.cell=likunjianCell01 task0.node=likunjianNode02
	 * task0.server=appserver1
	 */
	// private Properties createAddServerProps_Base(WebsphereAppServerUnit unit)
	// throws ASCException{
	// Properties props = new Properties();
	//
	// super.setEnvProp(props);
	// super.setASCAgentProp(props);
	// super.setAscProperty(props, "busname", getSibusName()); //$NON-NLS-1$
	//		
	// super.setAscProperty(props, "cell", getCellName()); //$NON-NLS-1$
	//		
	// super.setAscProperty(props, "node",
	// WasUtil.getWasNodeCap(unit).getNodeName()); //$NON-NLS-1$
	//		
	//		
	// WasServer svrCap = (WasServer) ValidatorUtils.getCapability(unit,
	// WasPackage.eINSTANCE.getWasServer());
	//		
	// super.setAscProperty(props, "server", svrCap.getServerName());
	// //$NON-NLS-1$
	// return props;
	// }
	/************************************************************************************************
	 * task0.wasHome=D:/IBM/WebSphere/AppServer task0.busName=DefaultBus task0.cluster=TestCluster
	 * task0.datasourceJndiName="Cloudscape JDBC Provider (XA)"
	 */
	// private Properties createAddClusterProps_Base(WasClusterUnit unit) throws
	// ASCException {
	// Properties props = new Properties();
	//
	// super.setEnvProp(props);
	// super.setASCAgentProp(props);
	// super.setAscProperty(props, "busname", getSibusName()); //$NON-NLS-1$
	//		
	// super.setAscProperty(props, "wasHome",
	// ASCUtil.getWasHome(ASCUtil.getCell(unit))); //$NON-NLS-1$
	//		
	// WasCluster clsusterCap = (WasCluster) ValidatorUtils.getCapability(unit,
	// WasPackage.eINSTANCE.getWasCluster());
	//		
	// super.setAscProperty(props, "cluster", clsusterCap.getClusterName());
	// //$NON-NLS-1$
	//	
	// super.setAscProperty(props, "datasourceJndiName",
	// getDatasourceJndiName()); //$NON-NLS-1$
	//		
	// WasServer svrCap = (WasServer) ValidatorUtils.getCapability(unit,
	// WasPackage.eINSTANCE.getWasServer());
	//		
	// super.setAscProperty(props, "server", svrCap.getServerName());
	// //$NON-NLS-1$
	// return props;
	// }
	//	
	// //form dependency link
	// private String getDatasourceJndiName() {
	// WasDatasource dataSource = (WasSibDestination) ValidatorUtils
	// .getRequirements(unit, WasPackage.eINSTANCE
	// .getWasDatasource());
	// // TODO Auto-generated method stub
	// return ""; //$NON-NLS-1$
	// }
	// // from menmber link
	// private WebsphereAppServerUnit[] findInstalledServerFromBus() {
	// // List servers= ASCUtil.getMembers(unit,
	// WasPackage.eINSTANCE.getWebsphereAppServerUnit());
	//		
	// // TODO Auto-generated method stub
	// return new WebsphereAppServerUnit[0];
	// }
	// // from menmber link
	// private WasClusterUnit[] findInstalledClusterFromBus() {
	// // TODO Auto-generated method stub
	// return new WasClusterUnit[0];
	// }
}
