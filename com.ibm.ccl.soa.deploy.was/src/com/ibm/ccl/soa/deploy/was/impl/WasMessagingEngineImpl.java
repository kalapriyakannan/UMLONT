/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: WasMessagingEngineImpl.java,v 1.2 2008/05/28 17:39:39 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasMessagingEngine;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Messaging Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasMessagingEngineImpl#getEngineName <em>Engine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasMessagingEngineImpl extends CapabilityImpl implements WasMessagingEngine {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getEngineName() <em>Engine Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEngineName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENGINE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEngineName() <em>Engine Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEngineName()
	 * @generated
	 * @ordered
	 */
	protected String engineName = ENGINE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasMessagingEngineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_MESSAGING_ENGINE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getEngineName() {
		return engineName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEngineName(String newEngineName) {
		String oldEngineName = engineName;
		engineName = newEngineName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_MESSAGING_ENGINE__ENGINE_NAME, oldEngineName, engineName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_MESSAGING_ENGINE__ENGINE_NAME:
				return getEngineName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_MESSAGING_ENGINE__ENGINE_NAME:
				setEngineName((String)newValue);
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
			case WasPackage.WAS_MESSAGING_ENGINE__ENGINE_NAME:
				setEngineName(ENGINE_NAME_EDEFAULT);
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
			case WasPackage.WAS_MESSAGING_ENGINE__ENGINE_NAME:
				return ENGINE_NAME_EDEFAULT == null ? engineName != null : !ENGINE_NAME_EDEFAULT.equals(engineName);
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
		result.append(" (engineName: "); //$NON-NLS-1$
		result.append(engineName);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections
			.singletonList(WasPackage.Literals.WAS_MESSAGING_ENGINE__ENGINE_NAME);

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //WasMessagingEngineImpl
