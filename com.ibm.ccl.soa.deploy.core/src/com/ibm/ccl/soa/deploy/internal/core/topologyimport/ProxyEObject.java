/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Import;

/**
 * Wraps a {@link EObject} to proxify its results.
 * 
 * @see ProxyCacheService#proxify(Object, Import)
 */
public class ProxyEObject extends ProxyWrapper implements EObject {

	/** The wrapped EObject. */
	protected final EObject entry;

	/** Notifier. */
	protected final BasicNotifierImpl notifier = new BasicNotifierImpl();

	/**
	 * Construct a proxifying wrapper over a {@link EObject}.
	 * 
	 * @param cache
	 *           the proxy cache.
	 * @param importDcl
	 *           the import declaration.
	 * @param object
	 *           the wrapped EMF object.
	 */
	public ProxyEObject(ProxyCacheService cache, Import importDcl, EObject object) {
		super(cache, importDcl);
		this.entry = object;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyWrapper#getProxyWrapperSourceObject()
	 */
	public Object getProxyWrapperSourceObject() {
		return entry;
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	public TreeIterator eAllContents() {
		return new ProxyTreeIterator(cache, importDcl, entry.eAllContents());
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eClass()
	 */
	public EClass eClass() {
		return entry.eClass();
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eContainer()
	 */
	public EObject eContainer() {
		return (EObject) proxify(entry.eContainer());
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	public EStructuralFeature eContainingFeature() {
		return entry.eContainingFeature();
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eContainmentFeature()
	 */
	public EReference eContainmentFeature() {
		return entry.eContainmentFeature();
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	public EList eContents() {
		return new ProxyEList(cache, importDcl, entry.eContents());
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	public EList eCrossReferences() {
		return new ProxyEList(cache, importDcl, entry.eCrossReferences());
	}

	/*
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public Object eGet(EStructuralFeature feature) {
		return proxify(entry.eGet(feature));
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature, boolean)
	 */
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return proxify(entry.eGet(feature, resolve));
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	public boolean eIsProxy() {
		return entry.eIsProxy();
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public boolean eIsSet(EStructuralFeature feature) {
		return entry.eIsSet(feature);
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	public Resource eResource() {
		return (Resource) proxify(entry.eResource());
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature,
	 *      java.lang.Object)
	 */
	public void eSet(EStructuralFeature feature, Object newValue) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void eUnset(EStructuralFeature feature) {
		unsupported();
	}

	/*
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	public EList eAdapters() {
		return notifier.eAdapters();
	}

	/*
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	public boolean eDeliver() {
		return notifier.eDeliver();
	}

	/*
	 * @see org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	public void eNotify(Notification notification) {
		notifier.eNotify(notification);
	}

	/*
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	public void eSetDeliver(boolean deliver) {
		notifier.eSetDeliver(deliver);
	}

}
