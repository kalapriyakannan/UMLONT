/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerPortNames;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodePortNames;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerPortNames;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class IncrementWasPortValuesResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (context.getDeployStatus() instanceof IDeployAttributeStatus) {
			String problemType = context.getDeployStatus().getProblemType();
			if (problemType.equals(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID)) {
				IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
				if (status.getValidatorID() == IOsDomainValidators.PORT_CONFIG_PORT_CONFLICT_001) {
					Port port = (Port) status.getDeployObject();
					// Navigation is safe because error marker implies successful navigation
					PortConfigUnit parentPCU = (PortConfigUnit) port.getParent();
					for (Capability c : ValidatorUtils.getCapabilities(parentPCU, OsPackage.eINSTANCE
							.getPort())) {
						assert c instanceof Port;
						if (((Port) c).getPort() != null) {
							if (!DeployModelObjectUtil.isSettable(c, OsPackage.eINSTANCE.getPort_Port())) {
								return false;
							}
						}
					}

					Unit hostUnitOfPortConfigUnit = ValidatorUtils.discoverHost(parentPCU, context
							.getProgressMonitor());
					String portName = port.getPortName();
					if (hostUnitOfPortConfigUnit instanceof WebsphereAppServerUnit) {
						// Anchor resolution with wc_defaulthost (9080 default)
						if (WebsphereAppServerPortNames.get(portName) != null
								&& WebsphereAppServerPortNames.WC_DEFAULTHOST_LITERAL.getLiteral().equals(
										portName)) {
							return true;
						}
					}
					if (hostUnitOfPortConfigUnit instanceof WasNodeUnit) {
						// Anchor resolution with soap_connector_address (8880 default)
						if (WasNodePortNames.get(portName) != null
								&& WasNodePortNames.SOAP_CONNECTOR_ADDRESS_LITERAL.getLiteral().equals(
										portName)) {
							return true;
						}
					}
					if (hostUnitOfPortConfigUnit instanceof WasDeploymentManagerUnit) {
						// Anchor resolution with wc_adminhost (9060 default)
						if (WasDeploymentManagerPortNames.get(portName) != null
								&& WasDeploymentManagerPortNames.WC_ADMINHOST_LITERAL.getLiteral().equals(
										portName)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		EAttribute attributeType = status.getAttributeType();
		Port anchorPort = (Port) status.getDeployObject();

		return new IDeployResolution[] { new IncrementWasPortValuesResolution(context, this,
				attributeType, anchorPort) };
	}
}
