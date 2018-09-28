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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * Wraps a {@link EList} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyEList extends ProxyList implements EList, EStructuralFeature.Setting {

	/**
	 * Construct a proxifying wrapper over a {@link List}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param list
	 *           the wrapped elist.
	 */
	public ProxyEList(IProxyCacheService cache, Import importDcl, EList list) {
		super(cache, importDcl, list);
	}

	/**
	 * @return the collection cast as an {@link EList}.
	 */
	protected final EList elist() {
		return (EList) collection;
	}

	/*
	 * @see org.eclipse.emf.common.util.EList#move(int, java.lang.Object)
	 */
	public void move(int newPosition, Object object) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.common.util.EList#move(int, int)
	 */
	public Object move(int newPosition, int oldPosition) {
		unsupported();
		return null;
	}

	public boolean isSet() {
		return !isEmpty();
	}

	public void set(Object newValue) {
		clear();
		addAll((List) newValue);

	}

	public void unset() {
		clear();
	}

	public Object get(boolean resolve) {
		return this;
	}

	public EObject getEObject() {
		EList elist = elist();
		if (elist instanceof EStructuralFeature.Setting) {
			return (EObject) proxify(((EStructuralFeature.Setting) elist).getEObject());
		}
		throw new IllegalStateException(
				"Delegate list does not implement EStructuralFeature.Setting!"); //$NON-NLS-1$
	}

	public EStructuralFeature getEStructuralFeature() {

		EList elist = elist();
		if (elist instanceof EStructuralFeature.Setting) {
			return ((EStructuralFeature.Setting) elist).getEStructuralFeature();
		}
		throw new IllegalStateException(
				"Delegate list does not implement EStructuralFeature.Setting!"); //$NON-NLS-1$
	}
}
