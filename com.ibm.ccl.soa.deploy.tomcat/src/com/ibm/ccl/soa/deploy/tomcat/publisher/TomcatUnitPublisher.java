/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.publisher;

import java.util.List;
import java.util.Random;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jst.server.tomcat.core.internal.TomcatConfiguration;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServer;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServerBehaviour;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;

import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.publisher.servertool.ServerToolUnitPublisher;

public class TomcatUnitPublisher extends ServerToolUnitPublisher implements ITomcatConstants {

	private Random rand = new Random();

	private TomcatServerBehaviour tomcatServerBehaviour;

	protected IStatus configureServer(IServer server, Unit[] units, Unit host) {
		if (getTomcatServer(server) != null)
			setupTomcatServerDerivedConfiguration(getTomcatServer(server));
		if (units == null)
			return null;
		TomcatServerBehaviour tomcatServerBehaviour = getTomcatServer(server);
		TomcatServer tomcatServer = (TomcatServer) tomcatServerBehaviour.getServer().loadAdapter(
				TomcatServer.class, null);
		TomcatConfiguration config = null;
		try {
			config = tomcatServerBehaviour.getTomcatConfiguration();
		} catch (CoreException e) { // TODO throw error
			e.printStackTrace();
		}

		createTomcatConfigUnits(tomcatServer, config, units);

		return null;

	}

	protected void createTomcatConfigUnits(TomcatServer tomcatServer, TomcatConfiguration config,
			Unit[] units) {
	}

	private void setupTomcatServerDerivedConfiguration(TomcatServerBehaviour tomcatServer) {
		try {

			String httpPort = getUniquePort();
			int http_port = Integer.parseInt(httpPort);
			String connectorPort = getUniquePort();
			int connector_Port = Integer.parseInt(connectorPort);
			String adminPort = getUniquePort();
			int admin_port = Integer.parseInt(adminPort);
			String AJ9_connector_port = getUniquePort();
			int aj9Port = Integer.parseInt(AJ9_connector_port);

			TomcatConfiguration config = tomcatServer.getTomcatConfiguration();
			String serverPortId = getHTTPServerPortId(config.getServerPorts());
			String connectorPortId = getConnectorPortId(config.getServerPorts());
			String adminPortId = getAdminPortId(config.getServerPorts());
			String aj9PortId = getAJ9PortId(config.getServerPorts());
			if (serverPortId != null)
				config.modifyServerPort(serverPortId, http_port);
			if (connectorPortId != null)
				config.modifyServerPort(connectorPortId, connector_Port);
			if (adminPortId != null)
				config.modifyServerPort(adminPortId, admin_port);
			if (aj9PortId != null)
				config.modifyServerPort(aj9PortId, aj9Port);
			TomcatServer tomcatServerInst = (TomcatServer) tomcatServer.getServer().loadAdapter(
					TomcatServer.class, null);
			tomcatServerInst.saveConfiguration(new NullProgressMonitor());

		} catch (CoreException e) {
			e.printStackTrace();

		}
	}

	private String getAJ9PortId(List serverPorts) {
		for (int i = 0; i < serverPorts.size(); i++) {
			ServerPort port = (ServerPort) serverPorts.get(i);
			if (port.getName().equals(AJP_13) || port.getName().equals(AJP_CONNECTOR_13))
				return port.getId();
		}
		return null;
	}

	private String getAdminPortId(List serverPorts) {
		for (int i = 0; i < serverPorts.size(); i++) {
			ServerPort port = (ServerPort) serverPorts.get(i);
			if (port.getName().equals(TOMCAT_ADMIN_PORT))
				return port.getId();
		}
		return null;
	}

	private String getConnectorPortId(List serverPorts) {
		for (int i = 0; i < serverPorts.size(); i++) {
			ServerPort port = (ServerPort) serverPorts.get(i);
			if (port.getName().equals(APACHE_CONNECTOR)
					|| port.getName().equals(TOMCAT_HTTP_CONNECTOR))
				return port.getId();
		}
		return null;
	}

	private String getHTTPServerPortId(List serverPorts) {
		for (int i = 0; i < serverPorts.size(); i++) {
			ServerPort port = (ServerPort) serverPorts.get(i);
			if (port.getName().equals(TOMCAT_PORT_NAME) || port.getName() == TOMCAT_HTTP)
				return port.getId();
		}
		return null;
	}

	protected String getServerPortId(List serverPorts) {
		for (int i = 0; i < serverPorts.size(); i++) {
			ServerPort port = (ServerPort) serverPorts.get(i);
			if (port.getName().equals(TOMCAT_PORT_NAME))
				return port.getId();
		}
		return null;
	}

	public String getEnvironment() {
		return IAnnotationConstants.ENVIRONMENT_WTP;
	}

	public TomcatServerBehaviour getTomcatServer(IServer server) {
		if (server == null)
			return null;
		if (tomcatServerBehaviour == null)
			tomcatServerBehaviour = (TomcatServerBehaviour) server.loadAdapter(
					TomcatServerBehaviour.class, null);
		return tomcatServerBehaviour;
	}

}
