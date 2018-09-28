/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl#getInterfaceGroup <em>Interface Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends CapabilityImpl implements Service {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInterfaceGroup() <em>Interface Group</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInterfaceGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap interfaceGroup;

	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected String protocol = PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getInterfaceGroup() {
		if (interfaceGroup == null) {
			interfaceGroup = new BasicFeatureMap(this, CorePackage.SERVICE__INTERFACE_GROUP);
		}
		return interfaceGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface() {
		return (Interface)getInterfaceGroup().get(CorePackage.Literals.SERVICE__INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getInterfaceGroup()).basicAdd(CorePackage.Literals.SERVICE__INTERFACE, newInterface, msgs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Service#setInterface(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public void setInterface(Interface newInterface) {
		EStructuralFeature subfeature = FeatureAdapter.getFeature(newInterface,
				CorePackage.Literals.SERVICE__INTERFACE);
		Assert.isNotNull(subfeature);
		((FeatureMap.Internal) getInterfaceGroup()).set(subfeature, newInterface);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceGen(Interface newInterface) {
		((FeatureMap.Internal)getInterfaceGroup()).set(CorePackage.Literals.SERVICE__INTERFACE, newInterface);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(String newProtocol) {
		String oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SERVICE__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SERVICE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SERVICE__INTERFACE_GROUP:
				return ((InternalEList)getInterfaceGroup()).basicRemove(otherEnd, msgs);
			case CorePackage.SERVICE__INTERFACE:
				return basicSetInterface(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.SERVICE__INTERFACE_GROUP:
				if (coreType) return getInterfaceGroup();
				return ((FeatureMap.Internal)getInterfaceGroup()).getWrapper();
			case CorePackage.SERVICE__INTERFACE:
				return getInterface();
			case CorePackage.SERVICE__PROTOCOL:
				return getProtocol();
			case CorePackage.SERVICE__VERSION:
				return getVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.SERVICE__INTERFACE_GROUP:
				((FeatureMap.Internal)getInterfaceGroup()).set(newValue);
				return;
			case CorePackage.SERVICE__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case CorePackage.SERVICE__PROTOCOL:
				setProtocol((String)newValue);
				return;
			case CorePackage.SERVICE__VERSION:
				setVersion((String)newValue);
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
			case CorePackage.SERVICE__INTERFACE_GROUP:
				getInterfaceGroup().clear();
				return;
			case CorePackage.SERVICE__INTERFACE:
				setInterface((Interface)null);
				return;
			case CorePackage.SERVICE__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case CorePackage.SERVICE__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case CorePackage.SERVICE__INTERFACE_GROUP:
				return interfaceGroup != null && !interfaceGroup.isEmpty();
			case CorePackage.SERVICE__INTERFACE:
				return getInterface() != null;
			case CorePackage.SERVICE__PROTOCOL:
				return PROTOCOL_EDEFAULT == null ? protocol != null : !PROTOCOL_EDEFAULT.equals(protocol);
			case CorePackage.SERVICE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(" (interfaceGroup: "); //$NON-NLS-1$
		result.append(interfaceGroup);
		result.append(", protocol: "); //$NON-NLS-1$
		result.append(protocol);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl
