/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.internal.capability.provider;

import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider.ServerRuntimeCapabilityProvider;
import com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider.ServerRuntimeUtils;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;

public class TomcatRuntimeCapabilityProvider extends ServerRuntimeCapabilityProvider {
	//TODO eventually move this class to a tomcat.ide plugin

	public static final String TOMCAT_SERVER_REQ_NAME = "tomcatServer"; //$NON-NLS-1$

	public Object[] resolveRequirements(Object anObject) {
		if (anObject instanceof IRuntime) {
			IRuntime runtime = (IRuntime) anObject;
			String runtimeVersion = ServerRuntimeUtils.getVersionString(runtime);
			if (runtimeVersion != null) {
				Requirement[] reqs = new Requirement[1];
				reqs[0] = createServerRequirement(runtimeVersion, TomcatPackage.Literals.TOMCAT_SERVER,
						TomcatPackage.Literals.TOMCAT_SERVER__TOMCAT_VERSION, TOMCAT_SERVER_REQ_NAME);
				return reqs;
			}
		}
		return NO_REQS;
	}

}
