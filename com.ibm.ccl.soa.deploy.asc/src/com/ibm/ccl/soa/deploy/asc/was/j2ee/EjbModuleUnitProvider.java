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
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;

/**
 * EarModuleUnitProvider who can generate the ear related ASC tasks. /** UnitProvider Contribution:
 * EarModuleUnitProvider It creates {@link ASCConstants#TASK_INSTALL_JAR} asc task for every
 * not-installed EarModuleUnit contained in Topology.
 * 
 * @see EjbModule
 * @see EjbModuleUnit
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-8-23
 */

public class EjbModuleUnitProvider extends J2EEASCProvider {

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.j2ee.J2EEASCProvider#createIntallProps_Base()
	 */
	protected Properties createIntallProps_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		String fileName = getFileName();
		if (fileName.indexOf(".") < 0) //$NON-NLS-1$
			fileName = fileName + ".jar"; //$NON-NLS-1$
		super.setAscProperty(props, ASCConstants.J2EE_JAR_FILE, fileName);
		super.setAscProperty(props, ASCConstants.J2EE_APPLICATION_NAME, getAppName());

		super.setASCAgentProp(props);
		return props;
	}

	protected String getTaskName() {
		return ASCConstants.TASK_INSTALL_JAR;
	}
}
