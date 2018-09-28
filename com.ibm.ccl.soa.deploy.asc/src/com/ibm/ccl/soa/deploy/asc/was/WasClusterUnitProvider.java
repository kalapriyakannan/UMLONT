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
import java.util.Vector;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasClusterUnitProvider It creates
 * {@link ASCConstants#TASK_CREATE_CLUSTER} and {@link ASCConstants#TASK_START_CLUSTER} asc tasks
 * for {@link WasClusterUnit}.
 * 
 * @see WasCluster
 * @see WasClusterUnit
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */

public class WasClusterUnitProvider extends WasComponentUnitProvider {

	/**
	 * No tasks for WAS Cluster in WAS Base, so do nothing here.
	 */
	public void initTasks_Base() throws ASCException {
		ascTaskName = new String[0];
		ascProps = new Properties[0];

	}

	protected void initTasks_ND() throws ASCException {
		WasClusterUnit clusterUnit = (WasClusterUnit) unit;
		List busList = ASCUtil.getSIBusGroup(clusterUnit);
		if (busList == null)
			busList = new Vector();
		ascTaskName = new String[2 + busList.size()];
		ascTaskName[0] = ASCConstants.TASK_CREATE_CLUSTER;
		ascTaskName[1] = ASCConstants.TASK_START_CLUSTER;

		ascProps = new Properties[2 + busList.size()];
		ascProps[1] = createStartClusterProps();
		Properties createCluster = new Properties();
		ascProps[0] = createCluster;
		WasNodeUnit nodeUnit = ASCUtil.getNode(clusterUnit);
		String profileHome = ASCUtil.getProfileHome(nodeUnit);
		setAscProperty(createCluster, ASCConstants.WAS_PROFILE_HOME, profileHome);
		String clusterName = ASCUtil.getClusterName(clusterUnit);
		setAscProperty(createCluster, ASCConstants.WAS_CLUSTER_NAME2, clusterName);
		WebsphereAppServerUnit serverUnit = ASCUtil.getExistingServer(clusterUnit);
		String useExistingserver = ASCConstants.FALSE;
		String serverName = null;
		String nodeName = ASCUtil.getNodeName(nodeUnit);
		if (serverUnit != null) {
			useExistingserver = ASCConstants.TRUE;
			serverName = ASCUtil.getServerName(serverUnit);
			nodeName = ASCUtil.getNodeName(ASCUtil.getNode(serverUnit));

		}
		setAscProperty(createCluster, ASCConstants.WAS_USE_EXISTING_SERVER, useExistingserver);
		setAscProperty(createCluster, ASCConstants.WAS_SERVER_NAME2, serverName);
		setAscProperty(createCluster, ASCConstants.WAS_NODE_NAME2, nodeName);
		setASCAgentProp(createCluster);
		Iterator bIt = busList.iterator();
		int i = 2;
		while (bIt.hasNext()) {
			WasSIBusUnit busUnit = (WasSIBusUnit) bIt.next();
			ascTaskName[i] = ASCConstants.TASK_ADD_CLUSTER_TOSIBU;
			ascProps[i] = createAddCluster2BusProps(clusterUnit, busUnit);
			i++;
		}
	}

	private Properties createStartClusterProps() throws ASCException {
		Properties props = new Properties();
		setASCAgentProp(props);
		setEnvProp(props);
		super.setAscProperty(props, "clusterName", ASCUtil.getClusterName((WasClusterUnit) unit)); //$NON-NLS-1$

		return props;
	}

}
