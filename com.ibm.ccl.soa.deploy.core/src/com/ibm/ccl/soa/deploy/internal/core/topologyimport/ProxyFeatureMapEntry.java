/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.FeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Import;

/**
 * Wraps a {@link FeatureMapEntry} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyFeatureMapEntry extends ProxyEObject implements FeatureMapEntry {

	/**
	 * Construct a proxifying wrapper over a {@link FeatureMap}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param entry
	 *           the wrapped feature map entry;
	 */
	public ProxyFeatureMapEntry(ProxyCacheService cache, Import importDcl, FeatureMapEntry entry) {
		super(cache, importDcl, entry);
	}

	/**
	 * @return the EObject cast as a feature map.
	 */
	protected FeatureMapEntry entry() {
		return (FeatureMapEntry) entry;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyWrapper#getProxyWrapperSourceObject()
	 */
	public Object getProxyWrapperSourceObject() {
		return entry();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#getDataValue()
	 */
	public String getDataValue() {
		return entry().getDataValue();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#getFeature()
	 */
	public EStructuralFeature getFeature() {
		return entry().getFeature();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#getFeatureName()
	 */
	public String getFeatureName() {
		return entry().getFeatureName();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#getReferenceValue()
	 */
	public EObject getReferenceValue() {
		return (EObject) proxify(entry().getReferenceValue());
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#getValue()
	 */
	public Object getValue() {
		return proxify(entry().getValue());
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#isSetFeature()
	 */
	public boolean isSetFeature() {
		return entry().isSetFeature();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#isSetFeatureName()
	 */
	public boolean isSetFeatureName() {
		return entry().isSetFeatureName();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#setDataValue(java.lang.String)
	 */
	public void setDataValue(String value) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#setFeature(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void setFeature(EStructuralFeature value) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#setFeatureName(java.lang.String)
	 */
	public void setFeatureName(String value) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#setReferenceValue(org.eclipse.emf.ecore.EObject)
	 */
	public void setReferenceValue(EObject value) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#unsetFeature()
	 */
	public void unsetFeature() {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.change.FeatureMapEntry#unsetFeatureName()
	 */
	public void unsetFeatureName() {
		unsupported();
	}
}
