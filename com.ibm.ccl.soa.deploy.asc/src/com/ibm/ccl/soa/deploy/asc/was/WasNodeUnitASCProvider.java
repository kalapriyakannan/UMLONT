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
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasNodeUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_PROFILE} asc task for WasNodeUnit
 * 
 * @see WasNode
 * @author <a href="mailto:fenglin@cn.ibm.com">Lin Feng</a>
 * 
 */

public class WasNodeUnitASCProvider extends WasComponentUnitProvider {

	private Properties initCreateProfileTask(WasNodeUnit nodeUnit) throws ASCException {
		Properties createProfile = new Properties();
		super.setAscProperty(createProfile, ASCConstants.OS_HOSTNAME, ASCUtil.getOSHostName(unit));
		String profileName = ASCUtil.getProfileName(nodeUnit);
		super.setAscProperty(createProfile, ASCConstants.WAS_PROFILE_NAME, profileName);
		String profileHome = ASCUtil.getProfileHome(nodeUnit);
		super.setAscProperty(createProfile, ASCConstants.WAS_PROFILE_HOME, profileHome);
		String wasHome = ASCUtil.getWasHome(nodeUnit);
		super.setAscProperty(createProfile, ASCConstants.WAS_HOME, wasHome);

		super.setAscProperty(createProfile, ASCConstants.WAS_CELL_NAME2, getCellName());
		super.setAscProperty(createProfile, ASCConstants.WAS_NODE_NAME2, getNodeName());
		super.setASCAgentProp(createProfile);
		return createProfile;
	}

	protected void initTasks_Base() throws ASCException {
		WasNodeUnit nodeUnit = (WasNodeUnit) unit;
		WebsphereAppServerUnit serverUnit = ASCUtil.getDefaultServer(nodeUnit);
		ascTaskName = new String[] { ASCConstants.TASK_CREATE_PROFILE,
				ASCConstants.TASK_START_APP_SERVER };
		ascProps = new Properties[] { initCreateProfileTask(nodeUnit),
				createStartWasProps(serverUnit) };
		String serverName = ASCUtil.getServerName(serverUnit);
		setAscProperty(ascProps[0], ASCConstants.WAS_SERVER_NAME2, serverName);
		PortConsumer portConsumer = ASCUtil.getPortConsumber(serverUnit);
		setServerPortProp(portConsumer, ascProps[0]);
	}

	protected void initTasks_ND() throws ASCException {
		WasNodeUnit nodeUnit = (WasNodeUnit) unit;
		// set profile type
		WasProfileTypeEnum profileType = ASCUtil.getProfileType(nodeUnit);
		//initCreateProfileTask(nodeUnit);
		if (WasProfileTypeEnum.DEFAULT_LITERAL.equals(profileType)) {

			WasCellUnit cellUnit = ASCUtil.getCell(nodeUnit);
			boolean createDefaultProfile = nodeUnit.equals(ASCUtil.getNode(cellUnit));
			createDefaultProfile = createDefaultProfile || !ASCUtil.isManaged(nodeUnit);
			if (createDefaultProfile) {
				WebsphereAppServerUnit serverUnit = ASCUtil.getDefaultServer(nodeUnit);
				ascTaskName = new String[] { ASCConstants.TASK_CREATE_PROFILE,
						ASCConstants.TASK_START_WAS };
				ascProps = new Properties[] { initCreateProfileTask(nodeUnit),
						createStartWasProps(serverUnit) };
				String serverName = ASCUtil.getServerName(serverUnit);
				setAscProperty(ascProps[0], ASCConstants.WAS_SERVER_NAME2, serverName);
				PortConsumer portConsumer = ASCUtil.getPortConsumber(serverUnit);
				setServerPortProp(portConsumer, ascProps[0]);
				setAscProperty(ascProps[0], ASCConstants.PROFILE_TYPE,
						ASCConstants.PROFILE_TYPE_DEFAULT);
			} else {
				initManagedNodeTask(nodeUnit);
			}

		} else if (WasProfileTypeEnum.DMGR_LITERAL.equals(profileType)) {
			WasDeploymentManagerUnit dmgrUnit = ASCUtil.getDMGR(nodeUnit);
			ascTaskName = new String[] { ASCConstants.TASK_CREATE_PROFILE, ASCConstants.TASK_START_WAS };
			ascProps = new Properties[] { initCreateProfileTask(nodeUnit),
					createStartWasProps4Dmgr(dmgrUnit) };
			String serverName = ASCUtil.getServerName(dmgrUnit);
			setAscProperty(ascProps[0], ASCConstants.WAS_SERVER_NAME2, serverName);
			PortConsumer portConsumer = ASCUtil.getPortConsumber(dmgrUnit);
			setServerPortProp(portConsumer, ascProps[0]);
			setAscProperty(ascProps[0], ASCConstants.PROFILE_TYPE, ASCConstants.PROFILE_TYPE_DMGR);
		} else {
			initManagedNodeTask(nodeUnit);
		}

	}

	private void initManagedNodeTask(WasNodeUnit nodeUnit) throws ASCException {
		WasCellUnit cellUnit = ASCUtil.getCell(nodeUnit);
		List nodeGroupList = ASCUtil.getNodeGroup(nodeUnit);
		ascTaskName = new String[3 + nodeGroupList.size()];
		ascProps = new Properties[3 + nodeGroupList.size()];
		ascTaskName[0] = ASCConstants.TASK_CREATE_PROFILE;
		ascProps[0] = initCreateProfileTask(nodeUnit);
		setAscProperty(ascProps[0], ASCConstants.WAS_SERVER_NAME2, null);
		setAscProperty(ascProps[0], ASCConstants.PROFILE_TYPE, ASCConstants.PROFILE_TYPE_MANAGED);
		ascTaskName[1] = ASCConstants.TASK_FEDERATE_NODE;
		ascProps[1] = this.initFederateNode(nodeUnit, cellUnit);
		ascTaskName[2] = ASCConstants.TASK_START_NODE;
		ascProps[2] = this.createStartNodeProps(nodeUnit);
		Iterator groupIt = nodeGroupList.iterator();
		int i = 3;
		while (groupIt.hasNext()) {
			WasNodeGroupUnit nodeGroupUnit = (WasNodeGroupUnit) groupIt.next();
			ascTaskName[i] = ASCConstants.TASK_ADD_NODE_TO_NODEGROUP;
			ascProps[i] = this.createAddNode2NodeGroupProps(nodeUnit, nodeGroupUnit);
			i++;
		}
	}
}
