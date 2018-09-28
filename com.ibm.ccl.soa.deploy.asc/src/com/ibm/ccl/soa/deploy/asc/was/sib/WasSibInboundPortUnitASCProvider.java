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
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibInboundPortUnit;

/**
 * UnitProvider Contribution: WasSibInboundPortUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_INBOUNDPORT} asc task for {@link  WasSibInboundPortUnit}
 * 
 * @see WasSibInboundPort
 * @see WasSibInboundPortUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibInboundPortUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_INBOUNDPORT };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	/**
	 * profilehome inboundportname inboundservname cell node server endpointlistenername
	 * 
	 * 
	 */

	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);

		String clusterName = getClusterNameFromListener();
		if (clusterName == null || clusterName.length() < 1)// scope is server
		{
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_SERVER);
			super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, getNodeNameofEndpointListener());
			super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME,
					getServerNameofEndpointListener());
		} else { // scope is cluster
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_CLUSTER);
			super.setAscProperty(props, ASCConstants.WAS_CLUSTER_NAME, clusterName);
		}

		super.setASCAgentProp(props);
		super.setAscProperty(props, "inboundportname", getInboundPortName()); //$NON-NLS-1$
		super.setAscProperty(props, "inboundservname", getInboundServiceName()); //$NON-NLS-1$
		super.setAscProperty(props, "endpointlistenername", getListenerName()); //$NON-NLS-1$

		return props;
	}

	private String getClusterNameFromListener() {
		Unit listenerUnit = getEndpointListenerUnit();
		if (ASCUtil.getWasScope(listenerUnit) instanceof WasClusterUnit) {
			WasClusterUnit clusterUnit = (WasClusterUnit) ASCUtil.getWasScope(listenerUnit);
			return ASCUtil.getClusterName(clusterUnit);

		}
		return null;
	}

	private String getServerNameofEndpointListener() {
		Unit listenerUnit = getEndpointListenerUnit();
		return getServerNameFromUnit(listenerUnit);
	}

	private String getNodeNameofEndpointListener() {
		Unit listenerUnit = getEndpointListenerUnit();
		WasNodeUnit nodeUnit = ASCUtil.getNode(listenerUnit);

		return ASCUtil.getNodeName(nodeUnit);
	}

	private String getListenerName() {
		Unit listenerUnit = getEndpointListenerUnit();
		return ASCUtil.getEndpointListenerName((WasEndpointListenerUnit) listenerUnit);
	}

	private Unit getEndpointListenerUnit() {
		Unit listenerUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
				.getWasEndpointListenerConfiguration(), WasPackage.eINSTANCE
				.getWasEndpointListenerUnit(), unit.getTopology());
		return listenerUnit;
	}

	private String getInboundServiceName() {
		Unit serviceUnit = TopologyDiscovererService.INSTANCE.findHost(unit, WasPackage.eINSTANCE
				.getWasSibInboundServiceUnit(), unit.getTopology());
		return ASCUtil.getAttribute(serviceUnit, "getServiceName"); //$NON-NLS-1$
	}

	private String getInboundPortName() {
		return ASCUtil.getAttribute(unit, "getPortName"); //$NON-NLS-1$
	}

}
