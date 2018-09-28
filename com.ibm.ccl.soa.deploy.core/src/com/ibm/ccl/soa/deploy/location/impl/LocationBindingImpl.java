/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl#getBindingEntry <em>Binding Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl#getTopology <em>Topology</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationBindingImpl extends EObjectImpl implements LocationBinding {
	/**
	 * The cached value of the '{@link #getBindingEntry() <em>Binding Entry</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBindingEntry()
	 * @generated
	 * @ordered
	 */
	protected EList bindingEntry;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTopology() <em>Topology</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTopology()
	 * @generated
	 * @ordered
	 */
	protected static final String TOPOLOGY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTopology() <em>Topology</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTopology()
	 * @generated
	 * @ordered
	 */
	protected String topology = TOPOLOGY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LocationPackage.Literals.LOCATION_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getBindingEntry() {
		if (bindingEntry == null) {
			bindingEntry = new EObjectContainmentEList(BindingEntry.class, this, LocationPackage.LOCATION_BINDING__BINDING_ENTRY);
		}
		return bindingEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_BINDING__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_BINDING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopology() {
		return topology;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopology(String newTopology) {
		String oldTopology = topology;
		topology = newTopology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.LOCATION_BINDING__TOPOLOGY, oldTopology, topology));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING__BINDING_ENTRY:
				return ((InternalEList)getBindingEntry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING__BINDING_ENTRY:
				return getBindingEntry();
			case LocationPackage.LOCATION_BINDING__CONTEXT:
				return getContext();
			case LocationPackage.LOCATION_BINDING__NAME:
				return getName();
			case LocationPackage.LOCATION_BINDING__TOPOLOGY:
				return getTopology();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING__BINDING_ENTRY:
				getBindingEntry().clear();
				getBindingEntry().addAll((Collection)newValue);
				return;
			case LocationPackage.LOCATION_BINDING__CONTEXT:
				setContext((String)newValue);
				return;
			case LocationPackage.LOCATION_BINDING__NAME:
				setName((String)newValue);
				return;
			case LocationPackage.LOCATION_BINDING__TOPOLOGY:
				setTopology((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING__BINDING_ENTRY:
				getBindingEntry().clear();
				return;
			case LocationPackage.LOCATION_BINDING__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case LocationPackage.LOCATION_BINDING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case LocationPackage.LOCATION_BINDING__TOPOLOGY:
				setTopology(TOPOLOGY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING__BINDING_ENTRY:
				return bindingEntry != null && !bindingEntry.isEmpty();
			case LocationPackage.LOCATION_BINDING__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
			case LocationPackage.LOCATION_BINDING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case LocationPackage.LOCATION_BINDING__TOPOLOGY:
				return TOPOLOGY_EDEFAULT == null ? topology != null : !TOPOLOGY_EDEFAULT.equals(topology);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (context: "); //$NON-NLS-1$
		result.append(context);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", topology: "); //$NON-NLS-1$
		result.append(topology);
		result.append(')');
		return result.toString();
	}

} //LocationBindingImpl
