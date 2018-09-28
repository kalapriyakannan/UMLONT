/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.asc.was;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * WasComponentUnitProvider is the parent class of cell , node ,nodegroup and cluster and server.It
 * mainly handles the var sub of these units.
 * 
 * @see WasCluster
 * @see WasClusterUnit
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public abstract class WasComponentUnitProvider extends WASASCProvider {

	protected void initTasks() throws ASCException {

		super.initTasks();
		List ascTask = new LinkedList();
		List ascPropList = new LinkedList();
		super.initVariableTask(ascTask, ascPropList, unit);
		if (ascTask.size() > 0) {
			for (int i = this.ascTaskName.length; i >= 0; i--) {
				ascTask.add(0, this.ascTaskName[i]);
				ascPropList.add(0, this.ascProps[i]);
			}
			ascTaskName = new String[ascTask.size()];
			ascProps = new Properties[ascPropList.size()];
			ascTaskName = (String[]) ascTask.toArray(ascTaskName);
			ascProps = (Properties[]) ascTask.toArray(ascProps);
		}
	}

	protected Properties createStartWasProps4Dmgr(WasDeploymentManagerUnit dmgrUnit)
			throws ASCException {
		Properties startWas = new Properties();
		WasNodeUnit nodeUnit = ASCUtil.getDMGRNode(dmgrUnit);
		setAscProperty(startWas, ASCConstants.WAS_PROFILE_HOME, ASCUtil.getProfileHome(nodeUnit));
		setAscProperty(startWas, ASCConstants.WAS_SERVER_NAME, ASCUtil.getServerName(dmgrUnit));
		setAscProperty(startWas, ASCConstants.WAS_SERVER_FAILONERROR, "true"); //$NON-NLS-1$
		setASCAgentProp(startWas, ASCUtil.getOSHostName(nodeUnit));
		return startWas;
	}

	public Properties createStartWasProps(WebsphereAppServerUnit serverUnit) throws ASCException {
		Properties startAppSvr = new Properties();
		WasNodeUnit nodeUnit = ASCUtil.getNode(serverUnit);
		super.setAscProperty(startAppSvr, ASCConstants.WAS_PROFILE_HOME, ASCUtil
				.getProfileHome(nodeUnit));
		super.setAscProperty(startAppSvr, ASCConstants.WAS_SERVER_NAME, ASCUtil
				.getServerName(serverUnit));
		super.setAscProperty(startAppSvr, ASCConstants.WAS_SERVER_FAILONERROR, "true"); //$NON-NLS-1$
		super.setASCAgentProp(startAppSvr);
		return startAppSvr;
	}

	protected Properties createAddNode2NodeGroupProps(WasNodeUnit nodeUnit,
			WasNodeGroupUnit nodeGroupUnit) throws ASCException {
		Properties prop = new Properties();
		WasNodeUnit dmgrUnit = ASCUtil.getNode(nodeGroupUnit);
		String dmgrProfileHome = ASCUtil.getProfileHome(dmgrUnit);
		String nodeName = ASCUtil.getNodeName(nodeUnit);
		String nodeGroupName = ASCUtil.getNodeGroupName(nodeGroupUnit);
		String host = ASCUtil.getOSHostName(dmgrUnit);
		setAscProperty(prop, ASCConstants.WAS_PROFILE_HOME, dmgrProfileHome);
		setAscProperty(prop, ASCConstants.WAS_NODE_NAME2, nodeName);
		setAscProperty(prop, ASCConstants.WAS_NODEGROUP_NAME, nodeGroupName);
		setASCAgentProp(prop, host);
		return prop;
	}
}
