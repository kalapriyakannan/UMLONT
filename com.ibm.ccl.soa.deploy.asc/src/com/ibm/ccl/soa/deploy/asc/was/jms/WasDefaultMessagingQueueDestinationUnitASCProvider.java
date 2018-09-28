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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestination;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;

/**
 * UnitProvider Contribution: WasDefaultMessagingQueueDestinationUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_DMQD} asc task for
 * {@link WasDefaultMessagingQueueDestinationUnit}
 * 
 * @see WasDefaultMessagingQueueDestination
 * @see WasDefaultMessagingQueueDestinationUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasDefaultMessagingQueueDestinationUnitASCProvider extends WASJMSASCProvider {
	protected String getTaskName() {
		return ASCConstants.TASK_CREATE_DMQD;
	}

	/**
	 * task0.queuename=myqueueDestinationServer
	 * task0.queuejndiname=java:comp/env/jms/myMessagingQueueDestination02 task0.busname=myBus0
	 * task0.sibqueuename=myBusQueue0 ND will add cluster
	 */

	protected Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);

		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromDFMDest(unit)); //$NON-NLS-1$
		super.setAscProperty(props, "queuename", getQueueName()); //$NON-NLS-1$
		super.setAscProperty(props, "queuejndiname", getJNDIName()); //$NON-NLS-1$
		//sibqueuename
		WasSibDestination dest = getWasSibDestination();
		super.setAscProperty(props, "sibqueuename", dest.getDestinationName()); //$NON-NLS-1$

		return props;
	}

	private WasSibDestination getWasSibDestination() {
		Unit destUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
				.getWasSibDestination(), WasPackage.eINSTANCE.getWasSibDestinationUnit(), unit
				.getTopology());
		WasSibDestination dest = (WasSibDestination) ValidatorUtils.getCapability(destUnit,
				WasPackage.eINSTANCE.getWasSibDestination());

		return dest;
	}

	private String getQueueName() {
		return getAttribute("getDestinationName"); //$NON-NLS-1$;
	}

}
