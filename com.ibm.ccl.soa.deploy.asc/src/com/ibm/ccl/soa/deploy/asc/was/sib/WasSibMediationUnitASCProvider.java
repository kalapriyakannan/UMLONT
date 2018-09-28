/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.sib;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasSibMediation;
import com.ibm.ccl.soa.deploy.was.WasSibMediationUnit;

/**
 * UnitProvider Contribution: WasSibMediationUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_SIBMEDIATION} asc task for {@link WasSibMediationUnit}
 * 
 * @see WasSibMediation
 * @see WasSibMediationUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibMediationUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_SIBMEDIATION };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);
		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromHoster(unit)); //$NON-NLS-1$
		super.setAscProperty(props, "mediationname", getMediationName()); //$NON-NLS-1$
		super.setAscProperty(props, "handlerlistname", getHandlerListName()); //$NON-NLS-1$

		return props;
	}

	private String getHandlerListName() {
		return ASCUtil.getAttribute(unit, "getHandlerListName"); //$NON-NLS-1$
	}

	private String getMediationName() {
		return ASCUtil.getAttribute(unit, "getMediationName"); //$NON-NLS-1$ "";
	}

}
