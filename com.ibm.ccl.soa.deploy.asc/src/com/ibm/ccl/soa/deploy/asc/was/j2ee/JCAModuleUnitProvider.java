/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.j2ee;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.j2ee.JCAModule;
import com.ibm.ccl.soa.deploy.j2ee.JCAModuleCapability;

/**
 * EarModuleUnitProvider who can generate the ear related ASC tasks. /** UnitProvider Contribution:
 * EarModuleUnitProvider It creates {@link ASCConstants#TASK_INSTALL_JAR} asc task for every
 * not-installed EarModuleUnit contained in Topology.
 * 
 * @see JCAModule
 * @see JCAModuleCapability
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-8-23
 */

public class JCAModuleUnitProvider extends J2EEASCProvider {
	/**
	 * @see com.ibm.ccl.soa.deploy.asc.j2ee.J2EEASCProvider#createIntallProps_Base()
	 */
	protected Properties createIntallProps_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		String fileName = getFileName();
		if (fileName.indexOf(".") < 0) //$NON-NLS-1$
			fileName = fileName + ".rar"; //$NON-NLS-1$
		super.setAscProperty(props, ASCConstants.J2EE_RAR_FILE, fileName);
		super.setAscProperty(props, ASCConstants.J2EE_ADAPTOR_NAME, getAdaptorName());

		super.setASCAgentProp(props);

		return props;
	}

	private String getAdaptorName() {
		// Chad said the AdaptorName is appname
		return getAppName();
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.j2ee.J2EEASCProvider#initTasks_ND()
	 */
	protected void initTasks_ND() throws ASCException {
		super.ascTaskName = new String[] { getTaskName() };
		super.ascProps = new Properties[] { createIntallProps_ND() };
	}

	// override it
	protected void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { getTaskName() };
		super.ascProps = new Properties[] { this.createIntallProps_Base() };
	}

	protected String getTaskName() {
		return ASCConstants.TASK_SET_RESOURCE_ADAPTER;
	}
}
