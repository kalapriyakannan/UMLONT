/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher.servertool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jst.server.generic.core.internal.CorePlugin;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.internal.servertype.definition.impl.PropertyImpl;
import org.eclipse.jst.server.generic.internal.servertype.definition.impl.ServerRuntimeImpl;
import org.eclipse.jst.server.generic.servertype.definition.ServerRuntime;
import org.eclipse.wst.server.core.IServer;

import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Unit;

public class GenericServerToolUnitPublisher extends ServerToolUnitPublisher implements
		IGenericConstants {

	protected IStatus configureServer(IServer server, Unit[] units, Unit host) {
		return null;
	}

	public String getEnvironment() {
		return IAnnotationConstants.ENVIRONMENT_WTP;
	}

	public void setupGenericServerConfiguration(GenericServerRuntime runtime, IServer server) {

		GenericServer genericServer = (GenericServer) server.loadAdapter(GenericServer.class, null);
		Map map = runtime.getServerInstanceProperties();
		ServerRuntime serverRuntime = (ServerRuntimeImpl) CorePlugin.getDefault()
				.getServerTypeDefinitionManager().getServerRuntimeDefinition(
						runtime.getRuntime().getRuntimeType().getId(), map);
		Map propertyMap = new HashMap();
		List properties = serverRuntime.getProperty();
		for (int i = 0; i < properties.size(); i++) {
			PropertyImpl prop = (PropertyImpl) properties.get(i);
			String propId = prop.getId();
			if (propId.equals(GENERIC_SERVER_CONFIG))
				propertyMap.put(prop.getId(), GENERIC_SERVER_CONFIG_VALUE);
			else if (propId.equals(GENERIC_SERVER_PROTOCOLS)
					|| propId.equals(GENERIC_SERVER_PROTOCOLS) || propId.equals(GENERIC_SERVER_MAPPERS))
				propertyMap.put(prop.getId(), prop.getDefault());
		}
		if (genericServer.getServerWorkingCopy() != null)
			genericServer.setServerInstanceProperties(propertyMap);
		try {
			getServerWC().save(true, new NullProgressMonitor());
			genericServer.saveConfiguration(new NullProgressMonitor());

		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

}
