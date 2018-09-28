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
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPort;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundPortUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * UnitProvider Contribution: WasSibOutboundPortUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_OUTBOUNDPORT} asc task for {@link WasSibOutboundPortUnit}
 * 
 * @see WasSibOutboundPort
 * @see WasSibOutboundPortUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibOutboundPortUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_OUTBOUNDPORT };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	/**
	 * profilehome outboundportname outboundservname destinationname node server cell
	 * 
	 */

	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();
		// need no scope
		super.setEnvProp(props);
		super.setAscProperty(props, ASCConstants.WAS_NODE_NAME, getNodeNameofDest());
		super.setAscProperty(props, ASCConstants.WAS_SERVER_NAME, getServerNameOfDest());
		if (getClusterName4Sib() != null) {//scope is cluster
			super.setAscProperty(props, ASCConstants.WAS_CLUSTER_NAME, getClusterName4Sib());
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_CLUSTER);
		} else {//scope is server 
			super.setAscProperty(props, ASCConstants.WAS_SCOPE, ASCConstants.WAS_SCOPE_SERVER);
		}

		super.setASCAgentProp(props);
		super.setAscProperty(props, "outboundportname", getOutboundPortName()); //$NON-NLS-1$
		super.setAscProperty(props, "outboundservname", getOutboundServiceName()); //$NON-NLS-1$
		super.setAscProperty(props, "destinationname", getDestinationName()); //$NON-NLS-1$

		return props;
	}

	private String getClusterName4Sib() {
		Unit destUnit = getDestUnit();
		WasClusterUnit clusterUnit = ASCUtil
				.getLinkedClusterUnit4SibDest((WasSibDestinationUnit) destUnit);
		return ASCUtil.getClusterName(clusterUnit);

	}

	private String getServerNameOfDest() {
		Unit destUnit = getDestUnit();
		WebsphereAppServerUnit wasUnit = ASCUtil
				.getLinkedWasServerUnit4SibDest((WasSibDestinationUnit) destUnit);
		return getServerNameFromUnit(wasUnit);
	}

	private String getNodeNameofDest() {
		Unit destUnit = getDestUnit();
		WebsphereAppServerUnit wasUnit = ASCUtil
				.getLinkedWasServerUnit4SibDest((WasSibDestinationUnit) destUnit);

		return ASCUtil.getNodeName(ASCUtil.getNode(wasUnit));
	}

	// dependency link
	private String getOutboundServiceName() {
		Unit serviceUnit = TopologyDiscovererService.INSTANCE.findHost(unit, WasPackage.eINSTANCE
				.getWasSibOutboundServiceUnit(), unit.getTopology());
		return ASCUtil.getAttribute(serviceUnit, "getServiceName"); //$NON-NLS-1$

	}

	private String getDestinationName() {
		Unit destUnit = getDestUnit();
		WasSibDestination dest = (WasSibDestination) ValidatorUtils.getCapability(destUnit,
				WasPackage.eINSTANCE.getWasSibDestination());
		return dest.getDestinationName();

	}

	private Unit getDestUnit() {
		Unit destUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
				.getWasSibDestination(), WasPackage.eINSTANCE.getWasSibDestinationUnit(), unit
				.getTopology());
		return destUnit;
	}

	private String getOutboundPortName() {
		return ASCUtil.getAttribute(unit, "getPortName"); //$NON-NLS-1$
	}

}
