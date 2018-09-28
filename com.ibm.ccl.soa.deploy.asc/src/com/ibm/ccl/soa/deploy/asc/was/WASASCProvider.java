/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.UnitASCProvider;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * WASASCProvider is the super class of all was domain unit providers.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public abstract class WASASCProvider extends UnitASCProvider {

	/**
	 * when installing an applocation and setting a configuration on was, profileName,
	 * cellName,nodeName,serverName,and scope is the mandatory attribute.
	 * 
	 * @param prop:
	 *           set profileName, set cellName set nodeName set serverName set scope
	 */
	protected void setEnvProp(Properties prop) throws ASCException {
		String scope = getScope();
		super.setAscProperty(prop, ASCConstants.WAS_SCOPE, scope);
		super.setAscProperty(prop, ASCConstants.WAS_PROFILE_HOME, ASCUtil
				.matchASCSpliter(getProfileHome()));

		if (ASCConstants.WAS_SCOPE_CELL.equals(scope)) {
			super.setAscProperty(prop, ASCConstants.WAS_CELL_NAME, getCellName());
			super.setAscProperty(prop, ASCConstants.WAS_CLUSTER_NAME, null);
			super.setAscProperty(prop, ASCConstants.WAS_NODE_NAME, null);
			super.setAscProperty(prop, ASCConstants.WAS_SERVER_NAME, null);

		} else if (ASCConstants.WAS_SCOPE_NODE.equals(scope)) {
			super.setAscProperty(prop, ASCConstants.WAS_CELL_NAME, getCellName());
			super.setAscProperty(prop, ASCConstants.WAS_NODE_NAME, getNodeName());
			super.setAscProperty(prop, ASCConstants.WAS_CLUSTER_NAME, null);
			super.setAscProperty(prop, ASCConstants.WAS_SERVER_NAME, null);

		} else if (ASCConstants.WAS_SCOPE_SERVER.equals(scope)) {
			super.setAscProperty(prop, ASCConstants.WAS_CELL_NAME, getCellName());
			super.setAscProperty(prop, ASCConstants.WAS_NODE_NAME, getNodeName());
			super.setAscProperty(prop, ASCConstants.WAS_SERVER_NAME, getServerName());
			super.setAscProperty(prop, ASCConstants.WAS_CLUSTER_NAME, null);
		} else if (ASCConstants.WAS_SCOPE_CLUSTER.equals(scope)) {
			super.setAscProperty(prop, ASCConstants.WAS_CELL_NAME, getCellName());

			super.setAscProperty(prop, ASCConstants.WAS_CLUSTER_NAME, getClusterName());
			super.setAscProperty(prop, ASCConstants.WAS_NODE_NAME, null);
			super.setAscProperty(prop, ASCConstants.WAS_SERVER_NAME, null);
		}
	}

	/**
	 * init the ASC tasks in WAS Base domain
	 */
	protected abstract void initTasks_Base() throws ASCException;

	/**
	 * init the ASC tasks in WAS ND domain
	 * 
	 * @param
	 * @return
	 */

	protected void initTasks_ND() throws ASCException {
		initTasks_Base();
		for (int i = 0; i < super.ascProps.length; i++)
			addCluster2Props(super.ascProps[i]);
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.UnitASCProvider#initTasks()
	 */
	protected void initTasks() throws ASCException {

		if (ASCUtil.isWASBase6(unit)) {
			setPackage(ASCConstants.PACKAGE_NAME_WAS_6);
			initTasks_Base();

		} else if (ASCUtil.isWASND6(unit)) {
			setPackage(ASCConstants.PACKAGE_NAME_WAS_ND6);
			initTasks_ND();
		} else
			throw new ASCException("WAS Version not supported for unit " + unit.getName()); //$NON-NLS-1$
	}

	/**
	 * set the package property of this unit's ASC task
	 * 
	 * @param pkg
	 * @return profileLocation of unit
	 */
	private void setPackage(String pkg) {
		super.ascPackageName = pkg;
	}

	/**
	 * get the unit's profile home
	 * 
	 * @param
	 * @return profileLocation of unit
	 */
	protected String getProfileHome() {
		WasNodeUnit nodeUnit = ASCUtil.getNode(unit);
		return ASCUtil.getProfileHome(nodeUnit);
	}

	/**
	 * get the cell name this unit.
	 * 
	 * @param
	 * @return the cell name if the unit is in a server/node/cell scope.Otherwise it will return
	 *         null;
	 */
	protected String getCellName() {

		WasCellUnit cellUnit = ASCUtil.getCell(unit);
		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cellUnit, WasPackage.eINSTANCE
				.getWasCell());
		if (cellCap != null)
			return cellCap.getCellName();
		return null;
	}

	/**
	 * get the node name this unit.
	 * 
	 * @param
	 * @return the node name if the unit is in a server scope or node scope.Otherwise it will return
	 *         null;
	 */
	protected String getNodeName() {
		WasNodeUnit nodeUnit = ASCUtil.getNode(unit);
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap != null)
			return nodeCap.getNodeName();
		return null;
	}

	/**
	 * get the server name this unit.
	 * 
	 * @param
	 * @return the servername if the unit is in a server scope.Otherwise it will return null;
	 */
	protected String getServerName() {
		Unit scope = ASCUtil.getWasScope(unit);
		if (scope instanceof WebsphereAppServerUnit) {
			WasServer svrCap = (WasServer) ValidatorUtils.getCapability(scope, WasPackage.eINSTANCE
					.getWasServer());
			return svrCap.getServerName();
		}
		return null;
	}

	protected String getServerNameFromUnit(Unit aUnit) {
		Unit scope = ASCUtil.getWasScope(aUnit);
		if (scope instanceof WebsphereAppServerUnit) {
			WasServer svrCap = (WasServer) ValidatorUtils.getCapability(scope, WasPackage.eINSTANCE
					.getWasServer());
			return svrCap.getServerName();
		}
		return null;
	}

	/**
	 * get the Scope of this unit.
	 * 
	 * @param
	 * @return the scope(server/node/cell)
	 */
	protected String getScope() throws ASCException {
		Unit hoster = ASCUtil.getWasScope(unit);
//		if (hoster == null) {
//			UnitASCBuilder.INSTANCE.markDirtyWithHostee(unit);
//			// TODO please pay attention here
//			throw new ASCException(NLS.bind(ASCExceptionMsg.HOST_NOT_FOUND,
//					unit.getName()), new Exception());
//		}
		/**
		 * If unit host on a configuration unit.
		 */
		while (hoster.isConfigurationUnit()) {
			hoster = ValidatorUtils.getHost(hoster);
		}

		if (hoster instanceof WasCellUnit) {
			return ASCConstants.WAS_SCOPE_CELL;
		} else if (hoster instanceof WasNodeUnit) {
			return ASCConstants.WAS_SCOPE_NODE;
		} else if (hoster instanceof WebsphereAppServerUnit) {
			return ASCConstants.WAS_SCOPE_SERVER;
		} else if (hoster instanceof WasClusterUnit) {
			return ASCConstants.WAS_SCOPE_CLUSTER;
		} else
			return ASCConstants.WAS_SCOPE_CELL;
	}

	protected void setPortProp(PortConfigUnit portConfigUnit, Properties prop) throws ASCException {
		List portList = portConfigUnit.getCapabilities();
		for (Iterator portIndex = portList.iterator(); portIndex.hasNext();) {
			Capability cap = (Capability) portIndex.next();
			if (cap instanceof Port) {
				String wasPortName = ((Port) cap).getPortName();
				String ascPortName = (String) ASCConstants.WAS_PORTMAP.get(wasPortName);

				if (ascPortName == null)
					continue;
				super.setAscProperty(prop, ascPortName, ((Port) cap).getPort().toString());

			}
		}
	}

	/**
	 * Get the Default Server from a node.
	 * 
	 * @param nodeUnit :
	 *           the Node from which to get the default server
	 * @return The WasServer Capability .
	 */
	protected WasServer getDefaultServer(WasNodeUnit nodeUnit) {
		List list = WasUtil.getWasAppSvrCapMemberList((WasNodeUnit) nodeUnit);
		return list.size() > 0 ? ((WasServer) list.get(0)) : null;

	}

	/**
	 * Get the Cluster name.
	 * 
	 * @param
	 * @return The cluster name if the unit is in cluster.Otherwise will return null.
	 */
	protected String getClusterName() {

		Unit scope = WasUtil.getWasScope(unit);
		if (scope instanceof WasClusterUnit)
			return ASCUtil.getClusterName((WasClusterUnit) WasUtil.getWasScope(unit));

		return null;
	}

	/**
	 * Whether the provider's unit is in a cluster.
	 * 
	 * @param
	 * @return true is the unit is in a cluster
	 */
	protected boolean isInCluster() {
		Unit scope = WasUtil.getWasScope(unit);
		return (scope instanceof WasClusterUnit);
	}

	protected void addCluster2Props(Properties props) throws ASCException {
		if (isInCluster())
			super.setAscProperty(props, ASCConstants.WAS_CLUSTER_NAME, getClusterName());
	}

	public void setServerPortProp(PortConsumer portConsumer, Properties prop) throws ASCException {
		if (portConsumer != null) {
			Unit portConsumerUnit = (Unit) portConsumer.getParent();
			PortConfigUnit portConfigUnit = ASCUtil.getServerPortConfig(portConsumerUnit);
			List portList = portConfigUnit.getCapabilities();
			for (Iterator portIndex = portList.iterator(); portIndex.hasNext();) {
				Capability cap = (Capability) portIndex.next();
				if (cap instanceof Port) {
					String wasPortName = ((Port) cap).getPortName();
					String ascPortName = (String) ASCConstants.WAS_PORTMAP.get(wasPortName);

					if (ascPortName == null)
						continue;
					super.setAscProperty(prop, ascPortName, ((Port) cap).getPort().toString());

				}
			}

		} else {
			// maybe no server, then set all port to null.
			for (Iterator ascIt = ASCConstants.WAS_PORTMAP.values().iterator(); ascIt.hasNext();) {
				String ascPortName = (String) ascIt.next();
				setAscProperty(prop, ascPortName, null);
			}
		}
	}

	/*
	 * nodeProfileName=D:/IBM/WebSphere/AppServer/profiles/Dmgr02
	 * profileHome=D:/IBM/WebSphere/AppServer/profiles/AppSrv05 dMgrHostName=localhost
	 * nodeGroupName=TestNodeGroup dmgrSoapConnectorPort=8881
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	protected Properties initFederateNode(WasNodeUnit nodeUnit, WasCellUnit cellUnit)
			throws ASCException {
		Properties federateNode = new Properties();
		WasNodeUnit dmgrNodeUnit = ASCUtil.getCellHostNode(cellUnit);
		WasDeploymentManagerUnit dmgrUnit = (WasDeploymentManagerUnit) ((MemberLink) dmgrNodeUnit
				.getMemberLinks().get(0)).getTarget();
		PortConfigUnit portConfigUnit = ASCUtil.getServerPortConfig(dmgrUnit);
		if (portConfigUnit != null) {
			//
			super.setAscProperty(federateNode, ASCConstants.ASC_SOAP_CONNECTOR_ADDRESS,
					getSOAPConnectorPort(portConfigUnit));
		}
		setAscProperty(federateNode, ASCConstants.ASC_DMGR_HOSTNAME, ASCUtil.getOSHostName(unit));
		setAscProperty(federateNode, ASCConstants.WAS_PROFILE_HOME, ASCUtil.getProfileHome(nodeUnit));
		setAscProperty(federateNode, ASCConstants.WAS_NODE_PROFILE_NAME, ASCUtil
				.getProfileName(nodeUnit));
		setASCAgentProp(federateNode, ASCUtil.getOSHostName(nodeUnit));
		return federateNode;
	}

	/*
	 * profileHome=D:/IBM/WebSphere/AppServer/profiles/AppSrv11 profileName=AppSrv11
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	protected Properties createStartNodeProps(WasNodeUnit nodeUnit) throws ASCException {
		Properties startNode = new Properties();
		setAscProperty(startNode, ASCConstants.WAS_PROFILE_HOME, ASCUtil.getProfileHome(nodeUnit));
		setAscProperty(startNode, ASCConstants.WAS_PROFILE_NAME, ASCUtil.getProfileName(nodeUnit));
		setASCAgentProp(startNode, ASCUtil.getOSHostName(nodeUnit));
		return startNode;
	}

	private String getSOAPConnectorPort(PortConfigUnit portConfigUnit) {
		List portList = portConfigUnit.getCapabilities();
		for (Iterator portIndex = portList.iterator(); portIndex.hasNext();) {
			Capability cap = (Capability) portIndex.next();
			if (cap instanceof Port) {

				String wasPortName = ((Port) cap).getPortName();
				if (wasPortName.equals(ASCConstants.SOAP_CONNECTOR_ADDRESS)) {
					return ((Port) cap).getPort().toString();
				}

			}
		}
		return null;
	}

	protected void initVariableTask(List task, List props, Unit unit) throws ASCException {
		WasSubstitutionVariable varCap = ASCUtil.getSubVariable(unit);

		if (varCap != null) {
			Iterator it = varCap.getExtendedAttributes().iterator();
			while (it.hasNext()) {
				ExtendedAttribute attr = (ExtendedAttribute) it.next();
				task.add(ASCConstants.TASK_SET_VAR_SUB);
				props.add(createSetVarProperties(unit, attr));
			}
		}
	}

	protected Properties createSetVarProperties(Unit unit, ExtendedAttribute attr)
			throws ASCException {
		Properties prop = new Properties();
		setAscProperty(prop, ASCConstants.WAS_VAR_NAME, attr.getName());
		setAscProperty(prop, ASCConstants.WAS_VAR_VALUE, attr.getValue().toString());
		setEnvProp(prop);
		setASCAgentProp(prop, ASCUtil.getOSHostName(ASCUtil.getDMGRNode(unit)));
		return prop;
	}

	/**
	 * task0.busName=TestBus task0.cell=likunjianCell01 task0.node=likunjianNode02
	 * task0.server=appserver1
	 */
	protected Properties createAddServer2BusProps_Base(WebsphereAppServerUnit serverUnit,
			WasSIBusUnit busUnit) throws ASCException {
		Properties props = new Properties();

		String profileHome = ASCUtil.getProfileHome(ASCUtil.getNode(busUnit));
		setAscProperty(props, ASCConstants.WAS_PROFILE_HOME, profileHome);
		String cellName = ASCUtil.getCellName(ASCUtil.getCell(busUnit));
		setAscProperty(props, ASCConstants.WAS_CELL_NAME, cellName);
		String nodeName = ASCUtil.getNodeName(ASCUtil.getNode(serverUnit));
		setAscProperty(props, ASCConstants.WAS_NODE_NAME, nodeName);
		String serverName = ASCUtil.getServerName(serverUnit);
		setAscProperty(props, ASCConstants.WAS_SERVER_NAME, serverName);
		String busName = ASCUtil.getBusName(busUnit);
		setAscProperty(props, ASCConstants.WAS_SIBUS_NAME, busName);
		setASCAgentProp(props, ASCUtil.getOSHostName(busUnit));
		setAscProperty(props,// TODO as an optional requirement of server or
				// cluster,not supported by model
				"datasourceJndiName", ASCUtil.getDataSourceJndi4MEDB(serverUnit)); //$NON-NLS-1$

		return props;
	}

	/************************************************************************************************
	 * task0.wasHome=D:/IBM/WebSphere/AppServer task0.busName=DefaultBus task0.cluster=TestCluster
	 * task0.datasourceJndiName="Cloudscape JDBC Provider (XA)"
	 */
	protected Properties createAddCluster2BusProps(WasClusterUnit clusterUnit, WasSIBusUnit busUnit)
			throws ASCException {
		Properties props = new Properties();
		String profileHome = ASCUtil.getProfileHome(ASCUtil.getNode(busUnit));
		setAscProperty(props, ASCConstants.WAS_PROFILE_HOME, profileHome);
		String cellName = ASCUtil.getCellName(ASCUtil.getCell(busUnit));
		setAscProperty(props, ASCConstants.WAS_CELL_NAME, cellName);

		String clusterName = ASCUtil.getClusterName(clusterUnit);
		setAscProperty(props, ASCConstants.WAS_CLUSTER_NAME, clusterName);
		String busName = ASCUtil.getBusName(busUnit);
		setAscProperty(props, ASCConstants.WAS_SIBUS_NAME, busName);
		setAscProperty(props,// TODO as an optional requirement of server or
				// cluster,not supported by model
				"datasourceJndiName", ASCUtil.getDataSourceJndi4MEDB(clusterUnit)); //$NON-NLS-1$
		setASCAgentProp(props, ASCUtil.getOSHostName(busUnit));

		return props;
	}
}
