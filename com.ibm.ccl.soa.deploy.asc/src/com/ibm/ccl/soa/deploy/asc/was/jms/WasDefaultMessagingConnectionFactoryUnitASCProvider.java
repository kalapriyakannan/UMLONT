/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.jms;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryUnit;

/**
 * UnitProvider Contribution: WasDefaultMessagingConnectionFactoryUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_DMCF} asc task for
 * {@link WasDefaultMessagingConnectionFactoryUnit}
 * 
 * @see WasDefaultMessagingConnectionFactoryConfiguration
 * @see WasDefaultMessagingConnectionFactoryUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasDefaultMessagingConnectionFactoryUnitASCProvider extends WASJMSASCProvider {

	/**
	 * profilehome connectionfactoryname connectionfactoryjndiname busname connectionfactorytype (not
	 * needed ) server node cell scope ::ND has cluster
	 */

	protected Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);
		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromDependency(unit)); //$NON-NLS-1$
		super.setAscProperty(props, "connectionfactoryname", getConnectionFactoryName()); //$NON-NLS-1$
		super.setAscProperty(props, "connectionfactoryjndiname", getJNDIName()); //$NON-NLS-1$
		super.setAscProperty(props, "connectionfactorytype", getConnectionFactoryType()); //$NON-NLS-1$
		return props;
	}

	// no type
	protected String getConnectionFactoryType() {
		return "All"; //$NON-NLS-1$
	}

	private String getConnectionFactoryName() {
		return getAttribute("getFactoryName"); //$NON-NLS-1$
	}

	protected String getTaskName() {
		return ASCConstants.TASK_CREATE_DMCF;
	}

}
