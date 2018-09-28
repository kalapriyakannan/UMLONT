/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>J2C Authentication Data Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl#getUserId <em>User Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class J2CAuthenticationDataEntryImpl extends CapabilityImpl implements
		J2CAuthenticationDataEntry {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected String alias = ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected J2CAuthenticationDataEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS, oldAlias, alias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS:
			return getAlias();
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD:
			return getPassword();
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID:
			return getUserId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS:
			setAlias((String) newValue);
			return;
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD:
			setPassword((String) newValue);
			return;
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID:
			setUserId((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS:
			setAlias(ALIAS_EDEFAULT);
			return;
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD:
			setPassword(PASSWORD_EDEFAULT);
			return;
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID:
			setUserId(USER_ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS:
			return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD:
			return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
		case J2eePackage.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID:
			return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (alias: "); //$NON-NLS-1$
		result.append(alias);
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", userId: "); //$NON-NLS-1$
		result.append(userId);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(J2eePackage.eINSTANCE
			.getJ2CAuthenticationDataEntry_Alias());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}

} //J2CAuthenticationDataEntryImpl
