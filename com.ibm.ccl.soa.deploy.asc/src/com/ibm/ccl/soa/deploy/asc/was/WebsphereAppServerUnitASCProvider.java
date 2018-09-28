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
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasSubstitutionVariableUnitASCProvider It creates
 * {@link ASCConstants#TASK_START_APP_SERVER} asc task for {@link WebsphereAppServerUnit} in WAS
 * Base domain, or creates {@link ASCConstants#TASK_CREATE_APPSVR} and
 * 
 * @link ASCConstants#TASK_START_APP_SERVER} asc tasks for {@link WebsphereAppServerUnit} which is
 *       not a member of Cluster in WAS ND domain, or creates
 *       {@link ASCConstants#TASK_CREATE_CLUSTER_MEMBER} and
 * @link ASCConstants#TASK_START_APP_SERVER} asc tasks for {@link WebsphereAppServerUnit} which is a
 *       member of Cluster in WAS ND domain,
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class WebsphereAppServerUnitASCProvider extends WasComponentUnitProvider {
	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	public void initTasks_Base() throws ASCException {
		// stand alone appsvr.
		// server has been create when create profile. and server has been
		// started after create profile.
		WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) unit;
		List busList = ASCUtil.getSIBusGroup(serverUnit);
		ascTaskName = new String[busList.size()];
		ascProps = new Properties[busList.size()];
		createSibusMember(busList, 0, serverUnit);
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_ND()
	 */
	public void initTasks_ND() throws ASCException {
		WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) unit;
		WasClusterUnit clusterUnit = ASCUtil.getCluster(serverUnit);
		WasNodeUnit nodeUnit = ASCUtil.getNode(serverUnit);
		WasNodeUnit wasNodeUnit = ASCUtil.getNode(ASCUtil.getCell(serverUnit));
		List busList = ASCUtil.getSIBusGroup(serverUnit);

		int i = 0;
		if (clusterUnit == null) {
			ascTaskName = new String[2 + busList.size()];
			ascProps = new Properties[2 + busList.size()];
			ascTaskName[0] = ASCConstants.TASK_CREATE_APPSVR;
			ascTaskName[1] = ASCConstants.TASK_START_WAS;
			ascProps[0] = initCreateAppSvrTask(serverUnit);
			ascProps[1] = createStartWasProps(serverUnit);
			i = 2;

		} else if (!wasNodeUnit.equals(nodeUnit) && ASCUtil.isManaged(nodeUnit)) {
			ascTaskName = new String[2 + busList.size()];
			ascProps = new Properties[2 + busList.size()];
			// managed node.
			ascTaskName[0] = ASCConstants.TASK_CREATE_CLUSTER_MEMBER;
			ascTaskName[1] = ASCConstants.TASK_START_WAS;
			ascProps[0] = initCreateClusterMemberTask(serverUnit, clusterUnit);
			ascProps[1] = createStartWasProps(serverUnit);
			i = 2;

		} else {
			// unmanaged node or stand alone appsvr.
			// server has been create when create profile. and server has been
			// started after create profile.
			ascTaskName = new String[busList.size()];
			ascProps = new Properties[busList.size()];
			i = 0;
		}
		createSibusMember(busList, i, serverUnit);
		// super.setASCAgentProp(ascProps[0],ASCUtil.getOSHostName(dmgrUnit));
		// super.setASCAgentProp(ascProps[1],ASCUtil.getOSHostName(dmgrUnit));
	}

	/*
	 * profileHome=D:/IBM/WebSphere/AppServer/profiles/Dmgr02 serverName=server3
	 * nodeName=likunjianNode04
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	public Properties initCreateAppSvrTask(WebsphereAppServerUnit serverUnit) throws ASCException {
		Properties createAppSvr = new Properties();
		WasNodeUnit nodeUnit = ASCUtil.getNode(serverUnit);
		WasCellUnit cellUnit = ASCUtil.getCell(nodeUnit);
		WasNodeUnit dmgrNodeUnit = ASCUtil.getCellHostNode(cellUnit);
		setAscProperty(createAppSvr, ASCConstants.WAS_PROFILE_HOME, ASCUtil
				.getProfileHome(dmgrNodeUnit));
		setAscProperty(createAppSvr, ASCConstants.WAS_SERVER_NAME, ASCUtil.getServerName(serverUnit));
		setAscProperty(createAppSvr, ASCConstants.WAS_NODE_NAME2, ASCUtil.getNodeName(nodeUnit));
		setASCAgentProp(createAppSvr, ASCUtil.getOSHostName(dmgrNodeUnit));
		return createAppSvr;
	}

	/*
	 * profileHome=D:/IBM/WebSphere/AppServer/profiles/Dmgr01 serverName=clusterserver4
	 * clusterName=TestCluster nodeName=likunjianNode02
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	public Properties initCreateClusterMemberTask(WebsphereAppServerUnit serverUnit,
			WasClusterUnit clusterUnit) throws ASCException {
		Properties createClusterMember = new Properties();
		WasNodeUnit nodeUnit = ASCUtil.getNode(serverUnit);
		WasCellUnit cellUnit = ASCUtil.getCell(nodeUnit);
		WasNodeUnit dmgrNodeUnit = ASCUtil.getCellHostNode(cellUnit);
		setAscProperty(createClusterMember, ASCConstants.WAS_PROFILE_HOME, ASCUtil
				.getProfileHome(dmgrNodeUnit));
		setAscProperty(createClusterMember, ASCConstants.WAS_SERVER_NAME2, ASCUtil
				.getServerName(serverUnit));
		setAscProperty(createClusterMember, ASCConstants.WAS_CLUSTER_NAME2, ASCUtil
				.getClusterName(clusterUnit));
		setAscProperty(createClusterMember, ASCConstants.WAS_NODE_NAME2, ASCUtil
				.getNodeName(nodeUnit));
		setASCAgentProp(createClusterMember, ASCUtil.getOSHostName(dmgrNodeUnit));
		return createClusterMember;
	}

	private void createSibusMember(List busList, int index, WebsphereAppServerUnit serverUnit)
			throws ASCException {
		Iterator bIt = busList.iterator();
		int i = index;
		while (bIt.hasNext()) {
			WasSIBusUnit busUnit = (WasSIBusUnit) bIt.next();
			ascTaskName[i] = ASCConstants.TASK_ADD_APPSERVER_TOSIBU;
			ascProps[i] = createAddServer2BusProps_Base(serverUnit, busUnit);
			i++;
		}
	}

}
