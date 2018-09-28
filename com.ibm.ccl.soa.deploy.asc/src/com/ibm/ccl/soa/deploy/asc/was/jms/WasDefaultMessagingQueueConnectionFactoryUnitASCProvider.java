/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was.jms;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryUnit;

/**
 * UnitProvider Contribution: WasDefaultMessagingQueueConnectionFactoryUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_DMCF} asc task for
 * {@link WasDefaultMessagingQueueConnectionFactoryUnit}
 * 
 * @see WasDefaultMessagingQueueConnectionFactoryConfiguration
 * @see WasDefaultMessagingQueueConnectionFactoryUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasDefaultMessagingQueueConnectionFactoryUnitASCProvider extends
		WasDefaultMessagingConnectionFactoryUnitASCProvider {

	// most same as  WasDefaultMessagingConnectionFactoryUnitASCProvider
	protected String getConnectionFactoryType() {
		return "Queue"; //$NON-NLS-1$
	}
}
