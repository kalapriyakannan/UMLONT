/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ScopeService;

/**
 * A Scoping service to locate referenced units and return proxies to the referenced types.
 * 
 * @since 1.0
 * 
 */
public interface IScopeService {

	/**
	 * Identifies adapters of the IScopeService type.
	 */
	Class ADAPTER_TYPE = IScopeService.class;

	/**
	 * Returns a proxy reference to the given URI.
	 * 
	 * @param uri
	 *           The URI to resolve using the local imports
	 * @return A proxy to the Unit that resolves to the given URI.
	 */
	DeployModelObject resolve(String uri);

	/**
	 * The assistant can help locate a scope service attached to a Topology.
	 * 
	 * @since 1.0
	 * 
	 */
	class Locator {

		/**
		 * Find the scope service attached to a Topology. May return <b>null</b> if not yet
		 * installed.
		 * 
		 * @param dmo
		 * @return The scope service attached to the Topology or <b>null</b> if otherwise.
		 */
		public static IScopeService findScopeService(DeployModelObject dmo) {

			if (dmo != null) {

				if (Proxy.isProxyClass(dmo.getClass())) {
					InvocationHandler handler = Proxy.getInvocationHandler(dmo);
					if (handler != null && handler instanceof IProxyConfiguration) {
						dmo = ((IProxyConfiguration) handler).getImported();
					}
				}
				Resource resource = dmo.getEObject().eResource();
				if (resource != null) {
					return (IScopeService) EcoreUtil.getAdapter(resource.eAdapters(),
							IScopeService.ADAPTER_TYPE);
				}
			}
			return null;
		}

		/**
		 * Install or find the scope service attached to a Topology Resource
		 * 
		 * @param resource
		 *           The resource to install the scope service for.
		 * @return The scope service that was found or installed on the given Topology
		 */
		public static IScopeService install(Resource resource) {
			IScopeService adapter = null;
			if (resource != null) {
				adapter = (IScopeService) EcoreUtil.getAdapter(resource.eAdapters(),
						IScopeService.ADAPTER_TYPE);
				if (adapter == null) {
					adapter = new ScopeService();
					// the type of the adapter variable reference 
					// does not implement Adapter, but the actual 
					// assignment (new ScopeService()) does.
					resource.eAdapters().add((Adapter) adapter);
				}
			}
			return adapter;
		}

		/**
		 * Install or find the scope service attached to a Topology Resource
		 * 
		 * @param dmo
		 * @return The scope service that was found or installed on the given Topology
		 */
		public static IScopeService install(DeployModelObject dmo) {
			Resource resource = dmo.getEObject().eResource();
			if (resource != null) {
				return install(resource);
			}
			return null;
		}
	}

}
