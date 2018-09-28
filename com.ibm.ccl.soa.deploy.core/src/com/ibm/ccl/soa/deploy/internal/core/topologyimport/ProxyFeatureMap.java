/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps a {@link FeatureMap} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyFeatureMap extends InterimProxyFeatureMapBase implements FeatureMap {

	/**
	 * Construct a proxifying wrapper over a {@link FeatureMap}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param featureMap
	 *           the wrapped feature map.
	 */
	public ProxyFeatureMap(IProxyCacheService cache, Import importDcl, FeatureMap featureMap) {
		super(cache, importDcl, featureMap);
	}

	/**
	 * @return the collection cast as an {@link FeatureMap}.
	 */
	protected final FeatureMap map() {
		return (FeatureMap) collection;
	}

	public boolean add(EStructuralFeature feature, Object value) {
		unsupported();
		return false;
	}

	public void add(int index, EStructuralFeature feature, Object value) {
		unsupported();
	}

	public boolean addAll(EStructuralFeature feature, Collection values) {
		unsupported();
		return false;
	}

	public boolean addAll(int index, EStructuralFeature feature, Collection values) {
		unsupported();
		return false;
	}

	public Object get(EStructuralFeature feature, boolean resolve) {
		return proxify(map().get(feature, resolve));
	}

	public EStructuralFeature getEStructuralFeature(int index) {
		return map().getEStructuralFeature(index);
	}

	public Object getValue(int index) {
		return proxify(map().getValue(index));
	}

	public boolean isSet(EStructuralFeature feature) {
		return map().isSet(feature);
	}

	public EList list(EStructuralFeature feature) {
		return new ProxyEList(cache, importDcl, map().list(feature));
	}

	public void set(EStructuralFeature feature, Object object) {
		unsupported();
	}

	public Object setValue(int index, Object value) {
		unsupported();
		return null;
	}

	public void unset(EStructuralFeature feature) {
		unsupported();
	}

	public ValueListIterator valueListIterator() {
		unsupported();
		return null;
	}

	public ValueListIterator valueListIterator(int index) {
		unsupported();
		return null;
	}
}
