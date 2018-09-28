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

import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Was Admin Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleImpl#getUserFile <em>User File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IhsWasAdminModuleImpl extends IhsModuleImpl implements IhsWasAdminModule {
	/**
	 * The default value of the '{@link #getUserFile() <em>User File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserFile()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserFile() <em>User File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserFile()
	 * @generated
	 * @ordered
	 */
	protected String userFile = USER_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsWasAdminModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_WAS_ADMIN_MODULE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserFile() {
		return userFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserFile(String newUserFile) {
		String oldUserFile = userFile;
		userFile = newUserFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_WAS_ADMIN_MODULE__USER_FILE, oldUserFile, userFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_WAS_ADMIN_MODULE__USER_FILE:
				return getUserFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_WAS_ADMIN_MODULE__USER_FILE:
				setUserFile((String)newValue);
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
			case IhsPackage.IHS_WAS_ADMIN_MODULE__USER_FILE:
				setUserFile(USER_FILE_EDEFAULT);
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
			case IhsPackage.IHS_WAS_ADMIN_MODULE__USER_FILE:
				return USER_FILE_EDEFAULT == null ? userFile != null : !USER_FILE_EDEFAULT.equals(userFile);
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
		result.append(" (userFile: "); //$NON-NLS-1$
		result.append(userFile);
		result.append(')');
		return result.toString();
	}

} //IhsWasAdminModuleImpl
