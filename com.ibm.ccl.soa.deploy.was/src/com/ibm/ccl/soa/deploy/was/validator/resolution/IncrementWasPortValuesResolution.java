/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerPortNames;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasNodePortNames;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerPortNames;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class IncrementWasPortValuesResolution extends DeployResolution {

	private EAttribute _attribute = null;
	private PortConfigUnit _parentPCU = null;
	private Unit _hostUnitOfPortConfigUnit = null;

	/**
	 * Construct a resolution over the status
	 * 
	 * @param context
	 * @param generator
	 */
	public IncrementWasPortValuesResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, EAttribute attribute, Port anchorPort) {
		super(context, generator);
		_attribute = attribute;
		_parentPCU = (PortConfigUnit) anchorPort.getParent();
		// Navigation is safe at this point. The validation has navigated to the hosting
		// operating system.
		_hostUnitOfPortConfigUnit = ValidatorUtils.discoverHost(_parentPCU, context
				.getProgressMonitor());

		Object params[] = { _hostUnitOfPortConfigUnit };
		setDescription(DeployNLS
				.bind(WasDomainMessages.Resolution_increment_port_values_of_0, params));
		/// This is a specific resolution. Make it appear at or close to top of list.
		this.setPriority(this.getPriority() + 1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		Port anchorPort = (Port) status.getDeployObject();
		// Recompute in case it has changed.
		_parentPCU = (PortConfigUnit) anchorPort.getParent();

		List portList = ValidatorUtils.getCapabilities(_parentPCU, OsPackage.Literals.PORT);
		for (Iterator iter = portList.iterator(); iter.hasNext();) {
			Port port = (Port) iter.next();
			if (port.getPort() == null) {
				// TODO consider setting to default value
				continue;
			}
			try {
				assert port.eClass().getEAllAttributes().contains(_attribute);
				String portName = port.getPortName();
				int incrementBy = 1;
				// These three ports are in a block. 
				// The installer wizard increments them by three if it detects a conflict
				if (portName
						.equals(WebsphereAppServerPortNames.SAS_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL
								.getLiteral())
						|| portName
								.equals(WebsphereAppServerPortNames.CSIV2_SSL_MUTUALAUTH_LISTENER_ADDRESS_LITERAL
										.getLiteral())
						|| portName
								.equals(WebsphereAppServerPortNames.CSIV2_SSL_SERVER_AUTH_LISTENER_ADDRESS_LITERAL
										.getLiteral())) {
					incrementBy = 3;
				}
				if (_hostUnitOfPortConfigUnit instanceof WebsphereAppServerUnit) {
					if (WebsphereAppServerPortNames.get(portName) != null) {
						port.setPort(port.getPort().add(BigInteger.valueOf(incrementBy)));
					}
				} else if (_hostUnitOfPortConfigUnit instanceof WasDeploymentManagerUnit) {
					if (WasDeploymentManagerPortNames.get(portName) != null) {
						port.setPort(port.getPort().add(BigInteger.valueOf(incrementBy)));
					}
				} else if (_hostUnitOfPortConfigUnit instanceof WasNodeUnit) {
					if (WasNodePortNames.get(portName) != null) {
						port.setPort(port.getPort().add(BigInteger.valueOf(incrementBy)));
					}
				}

			} catch (Throwable e) {
				// TODO log, then what?
				e.printStackTrace();
				return new Status(IStatus.ERROR, OsDeployPlugin.PLUGIN_ID, 0,
						WasDomainMessages.Resolution_increment_port_values_resolution_exception, e);
			}
		}
		return Status.OK_STATUS;
	}
}
