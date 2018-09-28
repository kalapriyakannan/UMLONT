/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;

/**
 * Methods that should only be called from the internal model.
 * 
 * @since 1.0
 * 
 */
public interface InternalScopeService extends IScopeService {

	/**
	 * A special path segment to indicate the path refers to a proxy.
	 */
	String PROXY = "$proxy"; //$NON-NLS-1$

	/**
	 * Resolve a read-only, isolated instance of the Topology to use for import resolutions.
	 * 
	 * @param imported
	 *           An import contained in a referencing Topology.
	 * @return A read-only, isolated instance of the Topology that is being referenced, or
	 *         <b>null</b> if the imported Topology cannot be resolved.
	 */
	Topology resolve(Import imported);

	/**
	 * Resolve a read-only, isolated instance of the Topology to use for import resolutions.
	 * 
	 * @param namespace
	 *           An referenced namespace
	 * @param name
	 *           An referenced Topology name
	 * @return A read-only, isolated instance of the Topology that is being referenced, or
	 *         <b>null</b> if the imported Topology cannot be resolved.
	 */
	Topology resolve(String namespace, String name);

	/**
	 * Resolve a read-only, isolated instance of the Topology to use for import resolutions.
	 * 
	 * @param listener
	 *           A listener to be notified in the resource for the underlying referenced Topology is
	 *           loaded and then subsequently reloaded.
	 */
	void listen(Listener listener);

	/**
	 * Resolve a read-only, isolated instance of the Topology to use for import resolutions.
	 * 
	 * @param listener
	 *           A listener that no longer needs to be notified in the resource for the underlying
	 *           referenced Topology is loaded and then subsequently reloaded.
	 */
	void remove(Listener listener);

	/**
	 * Resolve a proxy to an isolated, read-only DeployModelObject in a referenced Topology.
	 * 
	 * @param path
	 *           The URI including a named Topology or fully-qualified namespace and Topology along
	 *           with a relative path to a referenced DeployModelObject.
	 * @return A proxy to the referenced object
	 */
	DeployModelObject resolve(String path);

	/**
	 * Resolve a proxy to an isolated, read-only DeployModelObject in a referenced Topology.
	 * 
	 * @param path
	 *           The URI including a named Topology or fully-qualified namespace and Topology along
	 *           with a relative path to a referenced DeployModelObject.
	 * @param proxify
	 *           True to return a proxy, false to return the real instance.
	 * @return A representation of the referenced object
	 */
	DeployModelObject resolve(String path, boolean proxify);

	/**
	 * Resolve the EObject in the Isolated Resource Set.
	 * 
	 * @param eObj
	 *           An eproxy
	 * @return The resolved object or null.
	 * 
	 */
	EObject resolve(EObject eObj);

	/**
	 * Return the cache service associated with this IScopeService.
	 * 
	 * @return The cache service associated with this IScopeService.
	 */
	IProxyCacheService getCacheService();

	/**
	 * 
	 * @param dmo
	 *           A DMO that may be a proxy to a referenced DMO type.
	 * @return The EMF URI fragment to reference the given DMO in an EMF-serialized HREF regardless
	 *         of whether the object is a proxy or a locally referenced object.
	 */
	String eGetURIFragment(EObject dmo);

	/**
	 * 
	 * @param uri
	 *           A URI referencing a DMO
	 * @return The proxy for the given URI or null if the URI cannot be resolved by the scope
	 *         service.
	 */
	EObject eGetFromURI(String uri);

	/**
	 * Return the associated Topology this IScopeService services requests from.
	 * 
	 * @return The associated Topology this IScopeService services requests from.
	 */
	Topology getManagingTopology();

	/**
	 * Release cached resources.
	 */
	void setContext(Resource newContext) throws EditModelException;

	/**
	 * A simple listener that is notified when an isolated Topology is reloaded.
	 * 
	 * @since 1.0
	 * 
	 */
	static interface Listener {

		/**
		 * 
		 * @param namespace
		 * @param pattern
		 */
		void onReload(String namespace, String pattern);

	}
}
