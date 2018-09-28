/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.unitprovider;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;

public class IDEServerUnitProvider extends IDEUnitProvider implements IAnnotationConstants {

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {

		TopologyUnitStub[] stubs = null;
		if (anInputObject instanceof IRuntime) {
			IRuntime runtime = (IRuntime) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			annotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
					runtime.getRuntimeType().getId());
			annotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtime.getId());
			stubs[0] = new TopologyUnitStub(runtime.getName(), null, annotation, runtime);
		} else if (anInputObject instanceof Annotation) {
			stubs = new TopologyUnitStub[1];
			Annotation annotation = (Annotation) anInputObject;
			String runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
			stubs[0] = new TopologyUnitStub(runtimeId, null, annotation, null);
		}
		return stubs;
	}

	/**
	 * @Override
	 */
	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object resolveUnderlyingResource(Unit unit, IProgressMonitor aMonitor) {

		Annotation annotation = unit.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation == null)
			return null;
		String runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
		IRuntime runtime = getRuntime(runtimeId);
		if (runtime != null) {
			IServer server = getExistingServer(runtime);
			if (server != null)
				return server.getId();
		}
		return super.resolveUnderlyingResource(unit, aMonitor);
	}

	private IRuntime getRuntime(String runtimeId) {
		IRuntime[] runtimes = ServerCore.getRuntimes();
		for (int i = 0; i < runtimes.length; i++) {
			IRuntime runtime = runtimes[i];
			String name = runtime.getId();
			if (name.equals(runtimeId)) {
				return runtime;
			}

		}
		return null;
	}

	private IServer getExistingServer(IRuntime currentRuntime) {
		IServer[] servers = ServerCore.getServers();
		for (int i = 0; i < servers.length; i++) {
			IServer server = servers[i];
			IRuntime runtime = server.getRuntime();
			if (runtime == currentRuntime) {
				return server;
			}
		}
		return null;
	}

}
