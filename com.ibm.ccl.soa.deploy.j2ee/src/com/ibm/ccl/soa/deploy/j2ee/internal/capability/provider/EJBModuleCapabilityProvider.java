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
import java.util.Map;

import org.eclipse.jst.j2ee.ejb.EJBJar;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEVersionUtil;

public class EJBModuleCapabilityProvider extends J2EEModuleCapabilityProvider {

	/**
	 * Return the array of requirements for a EJB Application
	 */
	public Object[] resolveRequirements(Object anObject) {
		if (anObject instanceof EJBJar) {
			Map requirements = new HashMap();

			EJBJar ejbJar = (EJBJar) anObject;

			int ejbVersion = ejbJar.getVersionID();
			int j2eeVersion = J2EEVersionUtil.convertEJBVersionToJ2EEVersion(ejbVersion);

			String key = KEY_BASE_J2EE + j2eeVersion;
			if (!requirements.containsKey(key)) {
				Requirement j2eeContainerReq = createJ2EEContainerReq(j2eeVersion);
				requirements.put(key, j2eeContainerReq);
			}

			key = KEY_BASE_EJB + ejbVersion;
			if (!requirements.containsKey(key)) {
				Requirement ejbContainerReq = createEJBContainerReq(ejbVersion);
				requirements.put(key, ejbContainerReq);
			}

			// create J2eeSecurityRole requirements for security-role-refs
//			List ejbs = ejbJar.getEnterpriseBeans();
//			for (Iterator iter = ejbs.iterator(); iter.hasNext();) {
//				EnterpriseBean ejb = (EnterpriseBean) iter.next();
//				List refs = ejb.getSecurityRoleRefs();
//				for (Iterator iter2 = refs.iterator(); iter2.hasNext();) {
//					SecurityRoleRef ref = (SecurityRoleRef) iter2.next();
//					key = KEY_BASE_SECURITY + ref.getName();
//					requirements.put(key, createSecurityRoleRequirement(ref));
//				}
//			}

//			List ejbs = ejbJar.getEnterpriseBeans();
//			for (int i = 0; i < ejbs.size(); i++) {
//				EnterpriseBean ejb = (EnterpriseBean) ejbs.get(i);
//				if (ejb.isContainerManagedEntity()) {
//					//TODO commenting out for C5 plants issue
//					//addDefaultCMPDataSource(consumes, (ContainerManagedEntity) ejb);
//				}
//				addEjbResourceRefs(requirements, ejb, ejb.getResourceRefs());
//			}

			return toReqArray(requirements.values());
		}

		return NO_REQS;
	}

	public Object[] resolveCapabilities(Object anObject) {

//		if (anObject instanceof EJBJar) {
//			EJBJar ejbJar = (EJBJar) anObject;
//			Map capabilities = new HashMap();
//
//			String key = new String();
//			// create security role capabilities
//			AssemblyDescriptor assemblyDescriptor = ejbJar.getAssemblyDescriptor();
//			if (assemblyDescriptor != null) {
//				List securityRoles = assemblyDescriptor.getSecurityRoles();
//				for (Iterator iter = securityRoles.iterator(); iter.hasNext();) {
//					SecurityRole role = (SecurityRole) iter.next();
//					key = KEY_BASE_SECURITY + role.getRoleName();
//					capabilities.put(key, createSecurityRoleCapability(role));
//				}
//			}
//
//			return (Capability[]) capabilities.values().toArray(
//					new Capability[capabilities.values().size()]);
//		}
		return NO_CAPS;
	}

//	protected void addEjbResourceRefs(Map reqs, EnterpriseBean ejb, List resourceRefs) {
//		// TODO revisit in C5
//		for (int j = 0; j < resourceRefs.size(); j++) {
//			ResourceRef ref = (ResourceRef) resourceRefs.get(j);
//			if (!checkForSQLType(ref)) {
//				continue;
//			}
//			String jndiName = bindingsHelper.getJNDINameForRef(ejb, ref);
//			Object key = null == jndiName ? new Object() : jndiName;
//			if (!reqs.containsKey(key)) {
//				reqs.put(key, createDataSourceReq(ref, jndiName));
//			}
//		}
//	}
//	
//	private void addDefaultCMPDataSource(Map dependencyReqs, ContainerManagedEntity cmp) {
//		String jndiName = bindingsHelper.getJNDINameForDefaultDataSource(cmp);
//		Object key = null == jndiName ? new Object() : jndiName;
//		if (!dependencyReqs.containsKey(key)) {
//			dependencyReqs.put(key, createDataSourceReq(fixupName(jndiName), jndiName));
//		}
//	}

}
