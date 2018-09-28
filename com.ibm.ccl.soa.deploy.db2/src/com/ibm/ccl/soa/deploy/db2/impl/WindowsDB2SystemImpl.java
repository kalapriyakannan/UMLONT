/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2System;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows DB2 System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl#getAdminGroupName <em>Admin Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl#isExtendedSecurity <em>Extended Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl#getUserGroupName <em>User Group Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsDB2SystemImpl extends DB2SystemImpl implements WindowsDB2System {
	/**
	 * The default value of the '{@link #getAdminGroupName() <em>Admin Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdminGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String ADMIN_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdminGroupName() <em>Admin Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdminGroupName()
	 * @generated
	 * @ordered
	 */
	protected String adminGroupName = ADMIN_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtendedSecurity() <em>Extended Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isExtendedSecurity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDED_SECURITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendedSecurity() <em>Extended Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isExtendedSecurity()
	 * @generated
	 * @ordered
	 */
	protected boolean extendedSecurity = EXTENDED_SECURITY_EDEFAULT;

	/**
	 * This is true if the Extended Security attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean extendedSecurityESet;

	/**
	 * The default value of the '{@link #getUserGroupName() <em>User Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserGroupName() <em>User Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUserGroupName()
	 * @generated
	 * @ordered
	 */
	protected String userGroupName = USER_GROUP_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsDB2SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.WINDOWS_DB2_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdminGroupName() {
		return adminGroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdminGroupName(String newAdminGroupName) {
		String oldAdminGroupName = adminGroupName;
		adminGroupName = newAdminGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME, oldAdminGroupName, adminGroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendedSecurity() {
		return extendedSecurity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedSecurity(boolean newExtendedSecurity) {
		boolean oldExtendedSecurity = extendedSecurity;
		extendedSecurity = newExtendedSecurity;
		boolean oldExtendedSecurityESet = extendedSecurityESet;
		extendedSecurityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY, oldExtendedSecurity, extendedSecurity, !oldExtendedSecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExtendedSecurity() {
		boolean oldExtendedSecurity = extendedSecurity;
		boolean oldExtendedSecurityESet = extendedSecurityESet;
		extendedSecurity = EXTENDED_SECURITY_EDEFAULT;
		extendedSecurityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY, oldExtendedSecurity, EXTENDED_SECURITY_EDEFAULT, oldExtendedSecurityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExtendedSecurity() {
		return extendedSecurityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserGroupName() {
		return userGroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserGroupName(String newUserGroupName) {
		String oldUserGroupName = userGroupName;
		userGroupName = newUserGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_SYSTEM__USER_GROUP_NAME, oldUserGroupName, userGroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME:
				return getAdminGroupName();
			case Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY:
				return isExtendedSecurity() ? Boolean.TRUE : Boolean.FALSE;
			case Db2Package.WINDOWS_DB2_SYSTEM__USER_GROUP_NAME:
				return getUserGroupName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME:
				setAdminGroupName((String)newValue);
				return;
			case Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY:
				setExtendedSecurity(((Boolean)newValue).booleanValue());
				return;
			case Db2Package.WINDOWS_DB2_SYSTEM__USER_GROUP_NAME:
				setUserGroupName((String)newValue);
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
			case Db2Package.WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME:
				setAdminGroupName(ADMIN_GROUP_NAME_EDEFAULT);
				return;
			case Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY:
				unsetExtendedSecurity();
				return;
			case Db2Package.WINDOWS_DB2_SYSTEM__USER_GROUP_NAME:
				setUserGroupName(USER_GROUP_NAME_EDEFAULT);
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
			case Db2Package.WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME:
				return ADMIN_GROUP_NAME_EDEFAULT == null ? adminGroupName != null : !ADMIN_GROUP_NAME_EDEFAULT.equals(adminGroupName);
			case Db2Package.WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY:
				return isSetExtendedSecurity();
			case Db2Package.WINDOWS_DB2_SYSTEM__USER_GROUP_NAME:
				return USER_GROUP_NAME_EDEFAULT == null ? userGroupName != null : !USER_GROUP_NAME_EDEFAULT.equals(userGroupName);
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
		result.append(" (adminGroupName: "); //$NON-NLS-1$
		result.append(adminGroupName);
		result.append(", extendedSecurity: "); //$NON-NLS-1$
		if (extendedSecurityESet) result.append(extendedSecurity); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", userGroupName: "); //$NON-NLS-1$
		result.append(userGroupName);
		result.append(')');
		return result.toString();
	}

} //WindowsDB2SystemImpl
