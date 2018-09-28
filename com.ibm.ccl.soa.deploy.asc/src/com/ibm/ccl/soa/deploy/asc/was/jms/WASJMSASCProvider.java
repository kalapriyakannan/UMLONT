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

import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.asc.was.WASASCProvider;

/**
 * The abstract father of the JMS provider.
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public abstract class WASJMSASCProvider extends WASASCProvider {

	protected void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { getTaskName() };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	protected abstract String getTaskName();

	protected abstract Properties createProperties_Base() throws ASCException;

	protected String getJNDIName() {
		return ASCUtil.getAttribute(unit, "getJndiName"); //$NON-NLS-1$
	}

	protected String getAttribute(String methodName) {
		return ASCUtil.getAttribute(unit, methodName);
	}

}
