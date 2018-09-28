/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;

/**
 * Stores instances of proxies related to one particular Topology.
 * 
 * @since 1.0
 * 
 */
public interface IProxyCacheService {

	/**
	 * Returned by methods which cache proxied method results.
	 */
	Object NO_RESULT = new Object();

	/**
	 * Locate the proxy for the given object if already created; otherwise generate the Proxy and
	 * return it and populate with values from the given configuration.
	 * 
	 * @param dmo
	 *           The dmo to be proxied; referenced by the given import.
	 * @param imported
	 *           The import that referenced the given dmo
	 * @return The proxy for the given dmo populated with values from the given configuration.
	 */
	DeployModelObject findProxy(DeployModelObject dmo, Import imported);

	/**
	 * Turn the result of a method call into a proxy or list of proxies.
	 * <p>
	 * Uses generic knowledge of containers to proxy their values. In particular, supports:
	 * <ul>
	 * <li>{@link DeployModelObject}
	 * <li>{@link List}
	 * <li>{@link EList}
	 * <ul>
	 * </ul>
	 * <li>{@link Object}[]
	 * <li>{@link Iterator}
	 * <ul>
	 * <li>{@link ListIterator}
	 * <li>{@link TreeIterator}
	 * </ul>
	 * </ul>
	 * 
	 * @param result
	 *           the result of a method operation.
	 * @param imported
	 *           the topology import context.
	 * @return the proxified result (if applicable).
	 * 
	 * @see #findProxy(DeployModelObject, Import)
	 */
	Object proxify(Object result, Import imported);

	/**
	 * Dispose of the service and any resources that might be held.
	 * 
	 */
	void dispose();

	/**
	 * Retrieve the result for the feature if already stored; otherwise return ;
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * @param feature
	 *           The feature of the dmo being queried for cached results.
	 * 
	 * @return The proxy for the given dmo object populated
	 */
	public Object retrieveResult(DeployModelObject dmo, String feature);

	/**
	 * Retrieve the result for the feature if already stored; otherwise return ;
	 * 
	 * @param dmo
	 *           An object contained in another Topology.
	 * @param feature
	 *           The feature of the dmo being queried for cached results.
	 * @param result
	 *           The result of the method invocation.
	 * 
	 */
	public void storeResult(DeployModelObject dmo, String feature, Object result);

}
