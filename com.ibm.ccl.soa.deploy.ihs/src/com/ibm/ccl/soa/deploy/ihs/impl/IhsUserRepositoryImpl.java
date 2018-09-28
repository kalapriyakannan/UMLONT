/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsUserRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>User Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserRepositoryImpl#getPasswordFile <em>Password File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IhsUserRepositoryImpl extends CapabilityImpl implements IhsUserRepository {
	/**
	 * The default value of the '{@link #getPasswordFile() <em>Password File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPasswordFile()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswordFile() <em>Password File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPasswordFile()
	 * @generated
	 * @ordered
	 */
	protected String passwordFile = PASSWORD_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsUserRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_USER_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswordFile() {
		return passwordFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordFile(String newPasswordFile) {
		String oldPasswordFile = passwordFile;
		passwordFile = newPasswordFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_USER_REPOSITORY__PASSWORD_FILE, oldPasswordFile, passwordFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_USER_REPOSITORY__PASSWORD_FILE:
				return getPasswordFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_USER_REPOSITORY__PASSWORD_FILE:
				setPasswordFile((String)newValue);
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
			case IhsPackage.IHS_USER_REPOSITORY__PASSWORD_FILE:
				setPasswordFile(PASSWORD_FILE_EDEFAULT);
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
			case IhsPackage.IHS_USER_REPOSITORY__PASSWORD_FILE:
				return PASSWORD_FILE_EDEFAULT == null ? passwordFile != null : !PASSWORD_FILE_EDEFAULT.equals(passwordFile);
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
		result.append(" (passwordFile: "); //$NON-NLS-1$
		result.append(passwordFile);
		result.append(')');
		return result.toString();
	}

} //IhsUserRepositoryImpl
