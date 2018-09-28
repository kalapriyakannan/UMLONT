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
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * UnitProvider Contribution: WasJMSActivationSpecificationUnitASCProvider It creates
 * {@link ASCConstants#TASK_CREATE_DMAS} asc task for {@link WasJMSActivationSpecificationUnit}
 * 
 * @see WasJMSActivationSpecification
 * @see WasJMSActivationSpecificationUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasJMSActivationSpecificationUnitASCProvider extends WASJMSASCProvider {
	protected String getTaskName() {
		return ASCConstants.TASK_CREATE_DMAS;
	}

	/**
	 * task0.activationspecificationname=myspecificationLocalServer
	 * task0.activationspecificationjndiname=java:comp/env/jms/myMessagingActivationSpecification00
	 * 
	 * task0.destinationjndiname=java:comp/env/jms/myMessagingQueueDestination02
	 * task0.destinationtype=Queue
	 */
	protected Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);
		super.setASCAgentProp(props);
		Unit dfmDest = getDFMSibDestination();
		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromDFMDest(dfmDest)); //$NON-NLS-1$

		super.setAscProperty(props, "activationspecificationname", getASName()); //$NON-NLS-1$
		super.setAscProperty(props, "activationspecificationjndiname", getJNDIName()); //$NON-NLS-1$

		super.setAscProperty(props, "destinationtype", getDestinationType()); //$NON-NLS-1$
		super.setAscProperty(props, "destinationjndiname", getDestinationJndiName()); //$NON-NLS-1$
		return props;
	}

	private String getASName() {
		// getSpecificationName
		return getAttribute("getSpecificationName"); //$NON-NLS-1$;

	}

	private String getDestinationJndiName() {
		Unit destinationUnit = TopologyDiscovererService.INSTANCE.findTarget(unit,
				WasPackage.eINSTANCE.getWasDefaultMessagingQueueDestination(), WasPackage.eINSTANCE
						.getWasDefaultMessagingQueueDestinationUnit(), unit.getTopology());
		if (destinationUnit == null)
			destinationUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
					.getWasDefaultMessagingTopicDestination(), WasPackage.eINSTANCE
					.getWasDefaultMessagingTopicDestinationUnit(), unit.getTopology());

		return ASCUtil.getAttribute(destinationUnit, "getJndiName"); //$NON-NLS-1$
	}

	// should get from dependency
	private String getDestinationType() {

		Unit destinationUnit = TopologyDiscovererService.INSTANCE.findTarget(unit,
				WasPackage.eINSTANCE.getWasDefaultMessagingQueueDestination(), WasPackage.eINSTANCE
						.getWasDefaultMessagingQueueDestinationUnit(), unit.getTopology());
		if (destinationUnit == null)
			return "Queue"; //$NON-NLS-1$
		else
			return "Topic"; //$NON-NLS-1$
	}

	private Unit getDFMSibDestination() {

		Unit destUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
				.getWasDefaultMessagingTopicDestination(), unit.getTopology());
		if (destUnit == null)
			destUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
					.getWasDefaultMessagingQueueDestination(), unit.getTopology());

		return destUnit;
	}
}
