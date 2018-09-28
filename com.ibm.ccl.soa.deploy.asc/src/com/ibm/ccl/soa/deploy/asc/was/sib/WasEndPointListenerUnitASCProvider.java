/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.sib;

import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;

/**
 * UnitProvider Contribution: WasEndPointListenerUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_ENDPOINTLISTENER} asc task for {@link WasEndPointListenerUnit}
 * 
 * @see WasEndpointListenerConfiguration
 * @see WasEndPointListenerUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasEndPointListenerUnitASCProvider extends WASSibASCProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	protected void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_ENDPOINTLISTENER };
		super.ascProps = new Properties[] { this.createProperties_Base() };

	}

	/**
	 * profilehome name(endpoint listener name) urlroot wsdlurlroot cell node server scope
	 * 
	 */
	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, getNodeName());
		super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME, getServerName());
		super.setASCAgentProp(props);
		super.setAscProperty(props, "urlroot", getUrlRoot()); //$NON-NLS-1$
		super.setAscProperty(props, "wsdlurlroot", getWsdlUrlRoot()); //$NON-NLS-1$
		super.setAscProperty(props, "name", getEndPointListenerName()); //$NON-NLS-1$
		return props;
	}

	private String getEndPointListenerName() {

		List capList = unit.getCapabilities();
		for (int i = 0; i < capList.size(); i++) {
			if (capList.get(i) instanceof WasEndpointListenerConfiguration) {
				return ((WasEndpointListenerConfiguration) capList.get(i)).getEndpointListenerName()
						.getLiteral();
			}
		}
		return null;//ASCUtil.getAttribute(unit, "getEndpointListenerName"); 
	}

	private String getWsdlUrlRoot() {
		return ASCUtil.getAttribute(unit, "getWsdlUrlRoot"); //$NON-NLS-1$""; ""; ""; "";
	}

	private String getUrlRoot() {

		return ASCUtil.getAttribute(unit, "getUrlRoot"); //$NON-NLS-1$
	}

}
