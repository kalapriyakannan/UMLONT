/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jst.j2ee.application.Application;
import org.eclipse.jst.j2ee.common.SecurityRole;
import org.eclipse.jst.j2ee.common.SecurityRoleRef;
import org.eclipse.jst.j2ee.ejb.AssemblyDescriptor;
import org.eclipse.jst.j2ee.ejb.EJBJar;
import org.eclipse.jst.j2ee.ejb.EnterpriseBean;
import org.eclipse.jst.j2ee.webapplication.Servlet;
import org.eclipse.jst.j2ee.webapplication.WebApp;

import com.ibm.ccl.soa.deploy.core.Capability;

public class SecurityRoleProvider extends J2EEModuleCapabilityProvider {

	@Override
	public Object[] resolveCapabilities(Object anObject) {

		if (anObject instanceof WebApp) {
			WebApp webApp = (WebApp) anObject;
			Map capabilities = new HashMap();

			List securityRoles = webApp.getSecurityRoles();
			for (Iterator iter = securityRoles.iterator(); iter.hasNext();) {
				SecurityRole role = (SecurityRole) iter.next();
				String key = KEY_BASE_SECURITY + role.getRoleName();
				capabilities.put(key, createSecurityRoleCapability(role));
			}

			return capabilities.values().toArray(new Capability[capabilities.values().size()]);
		}

		if (anObject instanceof EJBJar) {
			EJBJar ejbJar = (EJBJar) anObject;
			Map capabilities = new HashMap();

			// create security role capabilities
			AssemblyDescriptor assemblyDescriptor = ejbJar.getAssemblyDescriptor();
			if (assemblyDescriptor != null) {
				List securityRoles = assemblyDescriptor.getSecurityRoles();
				for (Iterator iter = securityRoles.iterator(); iter.hasNext();) {
					SecurityRole role = (SecurityRole) iter.next();
					String key = KEY_BASE_SECURITY + role.getRoleName();
					capabilities.put(key, createSecurityRoleCapability(role));
				}
			}

			return capabilities.values().toArray(new Capability[capabilities.values().size()]);
		}

		if (anObject instanceof Application) {
			Application ear = (Application) anObject;
			Map capabilities = new HashMap();

			// create security role capabilities
			List securityRoles = ear.getSecurityRoles();
			for (Iterator iter = securityRoles.iterator(); iter.hasNext();) {
				SecurityRole role = (SecurityRole) iter.next();
				String key = KEY_BASE_SECURITY + role.getRoleName();
				capabilities.put(key, createSecurityRoleCapability(role));
			}

			return capabilities.values().toArray(new Capability[capabilities.values().size()]);
		}

		return NO_CAPS;
	}

	@Override
	public Object[] resolveRequirements(Object anObject) {

		if (anObject instanceof WebApp) {
			Map requirements = new HashMap();
			WebApp webApp = (WebApp) anObject;
			List servlets = webApp.getServlets();
			for (Iterator iter = servlets.iterator(); iter.hasNext();) {
				Servlet servlet = (Servlet) iter.next();
				List securityRefs = servlet.getSecurityRoleRefs();
				for (Iterator iter2 = securityRefs.iterator(); iter2.hasNext();) {
					SecurityRoleRef ref = (SecurityRoleRef) iter2.next();
					String key = KEY_BASE_SECURITY + ref.getName();
					requirements.put(key, createSecurityRoleRequirement(ref));
				}
			}

			return toReqArray(requirements.values());
		}

		if (anObject instanceof EJBJar) {
			Map requirements = new HashMap();
			EJBJar ejbJar = (EJBJar) anObject;
			List ejbs = ejbJar.getEnterpriseBeans();
			for (Iterator iter = ejbs.iterator(); iter.hasNext();) {
				EnterpriseBean ejb = (EnterpriseBean) iter.next();
				List refs = ejb.getSecurityRoleRefs();
				for (Iterator iter2 = refs.iterator(); iter2.hasNext();) {
					SecurityRoleRef ref = (SecurityRoleRef) iter2.next();
					String key = KEY_BASE_SECURITY + ref.getName();
					requirements.put(key, createSecurityRoleRequirement(ref));
				}
			}

			return toReqArray(requirements.values());
		}

		return NO_REQS;
	}

}
