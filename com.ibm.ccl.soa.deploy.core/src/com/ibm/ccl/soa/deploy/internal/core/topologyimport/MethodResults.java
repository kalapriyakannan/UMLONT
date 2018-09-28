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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Provides cached results for proxied method invocations.
 * 
 */
public class MethodResults {

	private final DeployModelObject source;
	private Map<String, Object> results;

	/* package */MethodResults(DeployModelObject dmo) {
		source = dmo;
	}

	public Object retrieve(String feature) {
		if (results != null && results.containsKey(feature)) {
			return results.get(feature);
		}
		return IProxyCacheService.NO_RESULT;
	}

	public void clear(String feature) {
		if (results != null) {
			results.remove(feature);
		}
	}

	public void store(String feature, Object result) {
		if (results == null) {
			results = new HashMap<String, Object>();
		}
		Object current = results.get(feature);
		if (current != null && current instanceof Adapter) {
			((Adapter) current).getTarget().eAdapters().remove(current);
		}
		results.put(feature, result);
	}

	public Iterator iterator() {
		return results.values().iterator();
	}
}
