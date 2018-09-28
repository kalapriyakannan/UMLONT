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
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestinationUnit;

/**
 * UnitProvider Contribution: WasDefaultMessagingTopicDestinationUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_DMCF} asc task for
 * {@link WasDefaultMessagingTopicDestinationUnit}
 * 
 * @see WasDefaultMessagingTopicDestination
 * @see WasDefaultMessagingTopicDestinationUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasDefaultMessagingTopicDestinationUnitASCProvider extends WASJMSASCProvider {

	protected String getTaskName() {
		return ASCConstants.TASK_CREATE_DMTD;
	}

	/**
	 * task0.topicname=myMessagingTopicDestinationLocalServer
	 * task0.topicjndiname=java:comp/env/jms/myTopicDestinationLocalCell03 task0.busname=myBus0
	 * task0.topicspacename=Default.Topic.Space
	 */

	protected Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);

//		WasSibDestinationUnit dest = getWasSibDestination();

		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromDFMDest(unit)); //$NON-NLS-1$

		super.setAscProperty(props, "topicname", getTopicName()); //$NON-NLS-1$
		super.setAscProperty(props, "topicjndiname", getJNDIName()); //$NON-NLS-1$
		super.setAscProperty(props, "topicspacename", getTopicSpace()); //$NON-NLS-1$
		return props;
	}

	private String getTopicSpace() {
		return getAttribute("getDestinationName"); //$NON-NLS-1$;

	}

	private String getTopicName() {
		return getAttribute("getTopicName"); //$NON-NLS-1$;
	}

}
