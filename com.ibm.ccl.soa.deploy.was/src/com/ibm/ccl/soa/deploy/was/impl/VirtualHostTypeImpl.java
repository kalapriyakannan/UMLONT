/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.HostNameAliasType;
import com.ibm.ccl.soa.deploy.was.VirtualHostType;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Virtual Host Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.VirtualHostTypeImpl#getHostNameAlias <em>Host Name Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.VirtualHostTypeImpl#getHostName <em>Host Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualHostTypeImpl extends CapabilityImpl implements VirtualHostType {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getHostNameAlias() <em>Host Name Alias</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHostNameAlias()
	 * @generated
	 * @ordered
	 */
	protected HostNameAliasType hostNameAlias;

	/**
	 * The default value of the '{@link #getHostName() <em>Host Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostName()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostName() <em>Host Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostName()
	 * @generated
	 * @ordered
	 */
	protected String hostName = HOST_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualHostTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.VIRTUAL_HOST_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HostNameAliasType getHostNameAlias() {
		return hostNameAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHostNameAlias(HostNameAliasType newHostNameAlias,
			NotificationChain msgs) {
		HostNameAliasType oldHostNameAlias = hostNameAlias;
		hostNameAlias = newHostNameAlias;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS, oldHostNameAlias, newHostNameAlias);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostNameAlias(HostNameAliasType newHostNameAlias) {
		if (newHostNameAlias != hostNameAlias) {
			NotificationChain msgs = null;
			if (hostNameAlias != null)
				msgs = ((InternalEObject)hostNameAlias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS, null, msgs);
			if (newHostNameAlias != null)
				msgs = ((InternalEObject)newHostNameAlias).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS, null, msgs);
			msgs = basicSetHostNameAlias(newHostNameAlias, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS, newHostNameAlias, newHostNameAlias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostName(String newHostName) {
		String oldHostName = hostName;
		hostName = newHostName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME, oldHostName, hostName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS:
				return basicSetHostNameAlias(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS:
				return getHostNameAlias();
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME:
				return getHostName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS:
				setHostNameAlias((HostNameAliasType)newValue);
				return;
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME:
				setHostName((String)newValue);
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
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS:
				setHostNameAlias((HostNameAliasType)null);
				return;
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME:
				setHostName(HOST_NAME_EDEFAULT);
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
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME_ALIAS:
				return hostNameAlias != null;
			case WasPackage.VIRTUAL_HOST_TYPE__HOST_NAME:
				return HOST_NAME_EDEFAULT == null ? hostName != null : !HOST_NAME_EDEFAULT.equals(hostName);
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
		result.append(" (hostName: "); //$NON-NLS-1$
		result.append(hostName);
		result.append(')');
		return result.toString();
	}

} //VirtualHostTypeImpl
