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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibDestination;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundServiceUnit;

/**
 * UnitProvider Contribution: WasSibOutboundServiceUnitASCProvider It creates
 * {@link ASCConstants#TASK_SET_OUTBOUNDSERVICE} asc task for {@link WasSibOutboundServiceUnit}
 * 
 * @see WasSibOutboundService
 * @see WasSibOutboundServiceUnit
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong (John) </a> Created on 2006-9-26
 */
public class WasSibOutboundServiceUnitASCProvider extends WASSibASCProvider {

	public void initTasks_Base() throws ASCException {
		super.ascTaskName = new String[] { ASCConstants.TASK_SET_OUTBOUNDSERVICE };
		super.ascProps = new Properties[] { this.createProperties_Base() };
	}

	/**
	 * profilehome busname outboundservname outboundservdestname outboundservurlout
	 * outboundwsdlservname outboundwsdlservnamespace cell node server
	 */

	private Properties createProperties_Base() throws ASCException {
		Properties props = new Properties();

		super.setEnvProp(props);

		super.setASCAgentProp(props);
		super.setAscProperty(props, "busname", ASCUtil.getSiBusNameFromHoster(unit)); //$NON-NLS-1$

		super.setAscProperty(props, "outboundservurl", getOutboundServiceWsdlUrl()); //$NON-NLS-1$
		super.setAscProperty(props, "outboundservname", getOutboundServericeName()); //$NON-NLS-1$
		super.setAscProperty(props, "outboundwsdlservnamespace", getOutboundWsdlServiceNameSpace()); //$NON-NLS-1$

		super.setAscProperty(props, "outboundservdestname", getOutboundServDestName()); //$NON-NLS-1$
		super.setAscProperty(props, "outboundwsdlservname", getOutboundWsdlServiceName()); //$NON-NLS-1$
		//TODO: no use here 
		super.setAscProperty(props, "uddireference", "uddireference"); //$NON-NLS-1$ //$NON-NLS-2$
		return props;
	}

	private String getOutboundServiceWsdlUrl() {
		return ASCUtil.getAttribute(unit, "getWsdlLocation"); //$NON-NLS-1$
	}

	// from dependency
	private String getOutboundServDestName() {

		Unit destUnit = TopologyDiscovererService.INSTANCE.findTarget(unit, WasPackage.eINSTANCE
				.getWasSibDestination(), WasPackage.eINSTANCE.getWasSibDestinationUnit(), unit
				.getTopology());
		WasSibDestination dest = (WasSibDestination) ValidatorUtils.getCapability(destUnit,
				WasPackage.eINSTANCE.getWasSibDestination());

		return dest.getDestinationName();
	}

	private String getOutboundServericeName() {
		return ASCUtil.getAttribute(unit, "getServiceName"); //$NON-NLS-1$;
	}

	private String getOutboundWsdlServiceName() {
		return "outboundwsdlservname"; //$NON-NLS-1$

	}

	private String getOutboundWsdlServiceNameSpace() {
		return ASCUtil.getAttribute(unit, "getWsdlServiceNamespace"); //$NON-NLS-1$
	}

}
