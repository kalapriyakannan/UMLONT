/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.j2ee;

import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.was.WASASCProvider;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.util.J2EECapabilityUtils;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * J2EEASCProvider is the super class of all j2ee domain unit providers.
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-8-23
 */
public abstract class J2EEASCProvider extends WASASCProvider {

	protected abstract String getTaskName();

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	protected void initTasks_Base() throws ASCException {
		// please notes there are 2 tasks
		super.ascTaskName = new String[] { getTaskName(), ASCConstants.TASK_START_APPLICATION };
		super.ascProps = new Properties[] { this.createIntallProps_Base(), createStartAPPProps_Base() };
	}

	protected Properties createStartAppProps(WebsphereAppServerUnit serverUnit) throws ASCException {
		Properties props = createStartAPPProps_Base();

		WasServer svrCap = (WasServer) ValidatorUtils.getCapability(serverUnit, WasPackage.eINSTANCE
				.getWasServer());
		String serverName = svrCap.getServerName();

		super.setAscProperty(props, ASCConstants.WAS_SCOPE, "Server"); //$NON-NLS-1$
		super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME, serverName);
		super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, ASCUtil
				.getNodeName((WasNodeUnit) ASCUtil.getNode(serverUnit)));

		return props;
	}

	/**
	 * create the properties for startAPP task without Cluster
	 * 
	 * @param
	 * @return the properties for startAPP task without Cluster
	 */
	protected Properties createStartAPPProps_Base() throws ASCException {
		Properties props = new Properties();
		super.setEnvProp(props);

		super.setAscProperty(props, ASCConstants.J2EE_APPLICATION_NAME, getAppName());

		super.setASCAgentProp(props);
		return props;
	}

	/**
	 * create the properties for install task with Cluster
	 * 
	 * @param
	 * @return the properties for install task with Cluster
	 */
	protected Properties createIntallProps_ND() throws ASCException {
		Properties props = createIntallProps_Base();
		addCluster2Props(props);
		return props;
	}

	/**
	 * create the properties for install task without Cluster
	 * 
	 * @param
	 * @return the properties for install task without Cluster
	 */
	protected abstract Properties createIntallProps_Base() throws ASCException;

	protected List getServerFromCluster() {
		WasClusterUnit clusterUnit = (WasClusterUnit) WasUtil.getWasScope(unit);
		return ASCUtil.getserverFromCluster(clusterUnit);

	}

	protected void initTasks_ND() throws ASCException {

		if (false == isInCluster()) {
			initTasks_Base();
		} else {
			//WebsphereAppServerUnit
			List servers = this.getServerFromCluster();

			if (servers != null)
				super.ascTaskName = new String[servers.size() + 1];
			super.ascTaskName[0] = getTaskName();

			for (int i = 1; i < servers.size() + 1; i++)
				super.ascTaskName[i] = ASCConstants.TASK_START_APPLICATION;

			super.ascProps = new Properties[servers.size() + 1];
			super.ascProps[0] = createIntallProps_ND();
			for (int i = 1; i < servers.size() + 1; i++)
				super.ascProps[i] = createStartAppProps((WebsphereAppServerUnit) servers.get(i - 1));
		}
	}

	/**
	 * get asc tasks file name property of this unit
	 * 
	 * @param
	 * @return file name property
	 */
	protected String getFileName() {
		String fileName = "";//$NON-NLS-1$
		List list = unit.getArtifacts(); // returns a list of artifacts
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof FileArtifact) {
				List uris = ((FileArtifact) list.get(i)).getFileURIs();
				if (uris.size() > 0)
					fileName = (String) uris.get(i);
			}
		}
		fileName = ASCUtil.matchASCSpliter(fileName);
		fileName = "${basedir}/" + fileName.substring(fileName.lastIndexOf("/") + 1);//$NON-NLS-1$ //$NON-NLS-2$

		return fileName;
	}

	protected String getAppName() {
		return J2EECapabilityUtils.getModuleName(unit);
	}
}
