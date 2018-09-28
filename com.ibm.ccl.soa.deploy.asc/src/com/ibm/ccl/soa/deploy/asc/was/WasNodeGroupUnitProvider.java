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
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;

/**
 * ASC UnitProvider Contribution: WasNodeGroupUnitProvider It creates
 * {@link ASCConstants#TASK_CREATE_NODEGROUP} asc task for {@link WasNodeGroupUnit}
 * 
 * @see WasNodeGroup
 * @see WasNodeGroupUnit
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class WasNodeGroupUnitProvider extends WasComponentUnitProvider {

	public void initTasks_Base() throws ASCException {
		ascTaskName = new String[0];
		ascProps = new Properties[0];

	}

	/*
	 * createNodeGroup profileHome=D:/IBM/WebSphere/AppServer/profiles/Dmgr02
	 * nodeGroupName=TestNodeGroup4
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	/*
	 * addNode2NodeGroup wasHome=D:/IBM/WebSphere/AppServer nodeGroupName=TestNodeGroup
	 * nodeName=likunjianNode05
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	public void initTasks_ND() throws ASCException {
		WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) unit;
		WasCellUnit cellUnit = ASCUtil.getCell(nodeGroupUnit);
		WasNodeUnit dmgrNodeUnit = ASCUtil.getCellHostNode(cellUnit);
		String dmgrProfileHome = ASCUtil.getProfileHome(dmgrNodeUnit);
		String host = ASCUtil.getOSHostName(cellUnit);
		String nodeGroupName = ASCUtil.getNodeGroupName(nodeGroupUnit);
		List installedManagedNodeList = ASCUtil.findAllInstalledManagedNode(nodeGroupUnit);
		ascTaskName = new String[installedManagedNodeList.size() + 2];
		ascProps = new Properties[installedManagedNodeList.size() + 2];
		ascTaskName[0] = ASCConstants.TASK_CREATE_NODEGROUP;
		ascProps[0] = new Properties();
		setAscProperty(ascProps[0], ASCConstants.WAS_PROFILE_HOME, dmgrProfileHome);
		setAscProperty(ascProps[0], ASCConstants.WAS_NODEGROUP_NAME, nodeGroupName);
		setASCAgentProp(ascProps[0], host);

		Iterator mIt = installedManagedNodeList.iterator();
		ascTaskName[1] = ASCConstants.TASK_ADD_NODE_TO_NODEGROUP;
		ascProps[1] = createAddNode2NodeGroupProps(dmgrNodeUnit, nodeGroupUnit);
		int i = 2;
		while (mIt.hasNext()) {
			ascTaskName[i] = ASCConstants.TASK_ADD_NODE_TO_NODEGROUP;

			WasNodeUnit nodeUnit = (WasNodeUnit) mIt.next();
			if (nodeUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
				ascProps[i] = createAddNode2NodeGroupProps(nodeUnit, nodeGroupUnit);
			}
			i++;
		}
	}

}
