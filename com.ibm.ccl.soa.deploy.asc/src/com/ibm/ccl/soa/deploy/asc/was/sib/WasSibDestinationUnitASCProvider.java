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
import java.util.Vector;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibMediationUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasSibDestinationUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_SIBDESTINATION} and {@link ASCConstants#TASK_MEDIATE_SIBDESTINATION}
 * asc task for {@link WasSibDestinationUnit}
 * 
 * @see WasSibDestination
 * @see WasSibDestinationUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibDestinationUnitASCProvider extends WASSibASCProvider {

	/**
	 * Whether the pre-request is satisfied. Subclass maybe need special condition to triger the
	 * export.Port and Webservice destination will not be exported.
	 * 
	 * @return true if the unit can be exported as ASC tasks
	 */
	public boolean isConditionSatisfied() {
		List caps = unit.getCapabilities();
		for (int i = 0; i < caps.size(); i++) {
			if (caps.get(i) instanceof WasSibDestination) {
				String type = ((WasSibDestination) caps.get(i)).getType().getLiteral();
				if (type.equalsIgnoreCase(WasSibDestinationTypeEnum.PORT_LITERAL.getLiteral())
						|| type.equalsIgnoreCase(WasSibDestinationTypeEnum.WEB_SERVICE_LITERAL
								.getLiteral()))
					return false;
			}
		}

		return true;
	}

	public void initTasks_Base() throws ASCException {

		Vector mediations = new Vector();
		WasSibMediationUnit mediationUnit = getMediationUnit();
		// at most only one mediation
		if (mediationUnit != null)
			mediations.add(mediationUnit);
		String[] taskNames = new String[mediations.size() + 1];
		Properties[] ascPropsArray = new Properties[mediations.size() + 1];

		taskNames[0] = ASCConstants.TASK_SET_SIBDESTINATION;
		ascPropsArray[0] = this.createProperties_Base();
		// WasSibMediationUnit
		for (int i = 0; i < mediations.size(); i++) {
			taskNames[i + 1] = ASCConstants.TASK_MEDIATE_SIBDESTINATION;
			ascPropsArray[i + 1] = this.createMediateProps_Base((WasSibMediationUnit) mediations
					.get(i));
		}
		super.ascTaskName = taskNames;
		super.ascProps = ascPropsArray;

	}

	private WasSibMediationUnit getMediationUnit() {

		return (WasSibMediationUnit) TopologyDiscovererService.INSTANCE.findTarget(unit,
				WasPackage.eINSTANCE.getWasSibMediation(), unit.getTopology());
	}

	private Properties createMediateProps_Base(WasSibMediationUnit medUnit) throws ASCException {

		Properties props = new Properties();
		super.setEnvProp(props);
		super.setASCAgentProp(props);

		super.setAscProperty(props, "busname", getBusName()); //$NON-NLS-1$
		super.setAscProperty(props, "destinationname", getDestinationName()); //$NON-NLS-1$
		String mediationName = ASCUtil.getAttribute(medUnit, "getMediationName");//$NON-NLS-1$
		super.setAscProperty(props, "mediationName", mediationName); //$NON-NLS-1$ 

		super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, getNodeName());
		super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME, getServerName());

		return props;
	}

	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();
		// need no scope
		super.setEnvProp(props);

		if (getClusterName4Sib() != null) {// scope is cluster
			super.setAscProperty(props, ASCConstants.WAS_CLUSTER_NAME, getClusterName4Sib());
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_CLUSTER);
		} else {// scope is server
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_SERVER);
			super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, getNodeName4Sib());
			super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME, getServerName4Sib());
		}

		super.setASCAgentProp(props);

		super.setAscProperty(props, "busname", getBusName()); //$NON-NLS-1$
		super.setAscProperty(props, "destinationname", getDestinationName()); //$NON-NLS-1$
		super.setAscProperty(props, "destinationtype", getDestinationType()); //$NON-NLS-1$
		super.setAscProperty(props, "targetname", getTargetName()); //$NON-NLS-1$
		super.setAscProperty(props, "foreignbus", getForeignBusName()); //$NON-NLS-1$

		return props;
	}

	private String getBusName() {
		String busName = ASCUtil.getSiBusNameFromSibDestination((WasSibDestinationUnit) unit);
		return busName;
	}

	private String getClusterName4Sib() {

		WasClusterUnit clusterUnit = ASCUtil
				.getLinkedClusterUnit4SibDest((WasSibDestinationUnit) unit);
		return ASCUtil.getClusterName(clusterUnit);

	}

	private String getServerName4Sib() {

		WebsphereAppServerUnit serverUnit = ASCUtil
				.getLinkedWasServerUnit4SibDest((WasSibDestinationUnit) unit);
		;
		return getServerNameFromUnit(serverUnit);
	}

	private String getNodeName4Sib() {
		WebsphereAppServerUnit serverUnit = ASCUtil
				.getLinkedWasServerUnit4SibDest((WasSibDestinationUnit) unit);
		return ASCUtil.getNodeName(ASCUtil.getNode(serverUnit));
	}

	// currently foregin bus not supported
	private String getForeignBusName() {
		// currently foregin bus not supported
		return "ForeignBusName"; //$NON-NLS-1$
	}

	private String getTargetName() {
		// currently foregin bus not supported
		return "TargetName"; //$NON-NLS-1$
	}

	private String getDestinationType() {
		List dests = ValidatorUtils
				.getCapabilities(unit, WasPackage.eINSTANCE.getWasSibDestination());
		return ((WasSibDestination) dests.get(0)).getType().getLiteral();
	}

	private String getDestinationName() {
		return ASCUtil.getAttribute(unit, "getDestinationName"); //$NON-NLS-1$""; "";
	}
}
