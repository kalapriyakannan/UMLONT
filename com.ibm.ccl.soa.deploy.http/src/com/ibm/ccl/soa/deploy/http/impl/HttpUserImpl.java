/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.HttpUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>User</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HttpUserImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HttpUserImpl#getUserPassword <em>User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HttpUserImpl extends CapabilityImpl implements HttpUser {
	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserPassword() <em>User Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserPassword() <em>User Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserPassword()
	 * @generated
	 * @ordered
	 */
	protected String userPassword = USER_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HttpUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return HttpPackage.Literals.HTTP_USER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HttpPackage.HTTP_USER__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserPassword(String newUserPassword) {
		String oldUserPassword = userPassword;
		userPassword = newUserPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HttpPackage.HTTP_USER__USER_PASSWORD, oldUserPassword, userPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HttpPackage.HTTP_USER__USER_ID:
				return getUserId();
			case HttpPackage.HTTP_USER__USER_PASSWORD:
				return getUserPassword();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HttpPackage.HTTP_USER__USER_ID:
				setUserId((String)newValue);
				return;
			case HttpPackage.HTTP_USER__USER_PASSWORD:
				setUserPassword((String)newValue);
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
			case HttpPackage.HTTP_USER__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case HttpPackage.HTTP_USER__USER_PASSWORD:
				setUserPassword(USER_PASSWORD_EDEFAULT);
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
			case HttpPackage.HTTP_USER__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case HttpPackage.HTTP_USER__USER_PASSWORD:
				return USER_PASSWORD_EDEFAULT == null ? userPassword != null : !USER_PASSWORD_EDEFAULT.equals(userPassword);
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
		result.append(" (userId: "); //$NON-NLS-1$
		result.append(userId);
		result.append(", userPassword: "); //$NON-NLS-1$
		result.append(userPassword);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _title_keys = Collections.singletonList(HttpPackage.eINSTANCE
			.getHttpUser_UserId());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys() @generated NOT
	 */
	public List titleKeys() {
		return _title_keys;
	}
} //HttpUserImpl
