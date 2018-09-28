/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasSubstitutionVariableUnitASCProvider It creates
 * {@link ASCConstants#TASK_INSTALL_WAS_V6} for {@link WasSystemUnit}
 * 
 * @see WasSystem
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class WasSystemUnitASCProvider extends WASASCProvider {

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	public void initTasks_Base() throws ASCException {
		ascTaskName = new String[] { ASCConstants.TASK_INSTALL_WAS_V6 };
		Properties installWASV6 = new Properties();
		ascProps = new Properties[] { installWASV6 };

		WasNodeUnit nodeUnit = ASCUtil.getFirstWasNodeUnitofWasBase((WasSystemUnit) unit);

		WasSystem systemCap = (WasSystem) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasSystem());
		WasCellUnit cellUnit = ASCUtil.getCell(nodeUnit);
		super.setAscProperty(installWASV6, ASCConstants.WAS_CELL_NAME, ASCUtil.getCellName(cellUnit));
		super.setAscProperty(installWASV6, ASCConstants.WAS_NODE_NAME, ASCUtil.getNodeName(nodeUnit));
		super.setAscProperty(installWASV6, ASCConstants.OS_HOSTNAME, ASCUtil.getOSHostName(unit));
		super.setAscProperty(installWASV6, ASCConstants.WAS_HOME, ASCUtil.matchASCSpliter(systemCap
				.getWasHome()));
		super.setAscProperty(installWASV6, ASCConstants.WAS_INSTALL_DIR, ASCUtil
				.matchASCSpliter(systemCap.getInstallerDir()));

		WebsphereAppServerUnit serverUnit = ASCUtil.getDefaultServer(nodeUnit);
		String serverName = ASCUtil.getServerName(serverUnit);

		super.setAscProperty(installWASV6, ASCConstants.WAS_SERVER_NAME2, serverName);
		PortConsumer portConsumer = ASCUtil.getPortConsumber(serverUnit);
		setServerPortProp(portConsumer, installWASV6);
		super.setASCAgentProp(installWASV6);

	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_ND()
	 */
	/*
	 * cell=cell1 node=node1 hostName=likunjian wasHome=E:/IBM/WebSphere installerDir=E:/work/WAS ND
	 * 6.0
	 * agent=com.ibm.asc.ca.ChangeAgent:${basedir}/tmp/agent::logVerbosity=debug:consoleVerbosity=debug
	 */
	public void initTasks_ND() throws ASCException {
		ascTaskName = new String[] { ASCConstants.TASK_INSTALL_ND_6 };
		Properties props = new Properties();
		ascProps = new Properties[] { props };

		WasSystem systemCap = (WasSystem) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasSystem());
		super.setAscProperty(props, ASCConstants.OS_HOSTNAME, ASCUtil.getOSHostName(unit));
		super.setAscProperty(props, ASCConstants.WAS_HOME, ASCUtil.matchASCSpliter(systemCap
				.getWasHome()));
		super.setAscProperty(props, ASCConstants.WAS_INSTALL_DIR, ASCUtil.matchASCSpliter(systemCap
				.getInstallerDir()));
		super.setASCAgentProp(props);
	}
}
