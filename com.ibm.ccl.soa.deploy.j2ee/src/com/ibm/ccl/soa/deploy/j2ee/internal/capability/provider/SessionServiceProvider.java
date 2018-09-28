/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jst.j2ee.client.ApplicationClient;
import org.eclipse.jst.j2ee.common.EjbRef;
import org.eclipse.jst.j2ee.common.EjbRefType;
import org.eclipse.jst.j2ee.ejb.EJBJar;
import org.eclipse.jst.j2ee.ejb.EnterpriseBean;
import org.eclipse.jst.j2ee.ejb.Session;
import org.eclipse.jst.j2ee.internal.common.J2EEVersionUtil;
import org.eclipse.jst.j2ee.webapplication.WebApp;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.SessionService;
import com.ibm.ccl.soa.deploy.j2ee.Vicinity;

public class SessionServiceProvider extends EnterpriseBeanProvider {

	public Object[] resolveCapabilities(Object anObject) {
		if (anObject instanceof EJBJar) {

			List services = new ArrayList();
			EJBJar jar = (EJBJar) anObject;
			List ssbeans = jar.getSessionBeans();

			SessionService service;

			for (Iterator iter = ssbeans.iterator(); iter.hasNext();) {

				Session session = (Session) iter.next();
				service = J2eeFactory.eINSTANCE.createSessionService();

				service.setName(session.getName());
				service.setEjbName(session.getName());
				service.setDisplayName(session.getDisplayName() != null ? session.getDisplayName()
						: session.getName());
				service.setDescription(session.getDescription());
				service.setVersion(J2EEVersionUtil.convertVersionIntToString(session.getVersionID()));
				service.setProtocol("RMI"); //$NON-NLS-1$

				JavaInterface javaInterface = J2eeFactory.eINSTANCE.createJavaInterface();
				JavaInterface homeInterface = J2eeFactory.eINSTANCE.createJavaInterface();

				if (session.hasLocalClient()) { // Local EJB	
					service.setVicinity(Vicinity.LOCAL_LITERAL);
					javaInterface.setInterface(session.getLocalInterfaceName());
					homeInterface.setInterface(session.getLocalHomeInterfaceName());

				} else { // Remote EJB
					service.setVicinity(Vicinity.REMOTE_LITERAL);
					javaInterface.setInterface(session.getRemoteInterfaceName());
					homeInterface.setInterface(session.getHomeInterfaceName());
				}

				service.setInterface(javaInterface);
				service.setHomeInterface(homeInterface);

				services.add(service);
			}

			if (services.size() == 0)
				return NO_CAPS;

			return (Capability[]) services.toArray(new Capability[services.size()]);
		}

		return NO_CAPS;
	}

	public Object[] resolveRequirements(Object anObject) {

		if (anObject instanceof EJBJar) {

			Map requirements = new HashMap();
			EJBJar ejbJar = (EJBJar) anObject;
			List ejbs = ejbJar.getEnterpriseBeans();
			/*
			 * TODO Fix post M4. Note the test for duplicate references across EJBs is done just by
			 * looking at the name. This is not a reliable test and will need to be updated to look at
			 * the interfaces as well.
			 */
			for (int i = 0; i < ejbs.size(); i++) {
				EnterpriseBean ejb = (EnterpriseBean) ejbs.get(i);
				addEjbRefs(requirements, ejb.getEjbLocalRefs());
				addEjbRefs(requirements, ejb.getEjbRefs());
			}

			return toReqArray(requirements.values());
		} else if (anObject instanceof WebApp) {
			Map requirements = new HashMap();
			WebApp webApp = (WebApp) anObject;
			addEjbRefs(requirements, webApp.getEjbRefs());
			addEjbRefs(requirements, webApp.getEjbLocalRefs());

			return toReqArray(requirements.values());
		} else if (anObject instanceof ApplicationClient) {
			Map requirements = new HashMap();
			ApplicationClient client = (ApplicationClient) anObject;
			addEjbRefs(requirements, client.getEjbReferences());

			return toReqArray(requirements.values());
		}

		return NO_REQS;
	}

	private void addEjbRefs(Map requirements, List refs) {
		if (!refs.isEmpty()) {
			for (Iterator it = refs.iterator(); it.hasNext();) {
				EjbRef ref = (EjbRef) it.next();
				if (ref.getType() == EjbRefType.SESSION_LITERAL) {
					String name = ref.getName();
					if (!requirements.containsKey(name)) {
						requirements.put(name, createEjbReference(ref));
					}
				}
			}
		}
	}
}
