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
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unix DB2 Admin Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl#getDasGID <em>Das GID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl#getDasGroupName <em>Das Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl#getDasUID <em>Das UID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl#getDasUserName <em>Das User Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl#getDasUserPassword <em>Das User Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnixDB2AdminServerImpl extends DB2AdminServerImpl implements UnixDB2AdminServer {
	/**
	 * The default value of the '{@link #getDasGID() <em>Das GID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasGID()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_GID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasGID() <em>Das GID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasGID()
	 * @generated
	 * @ordered
	 */
	protected String dasGID = DAS_GID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDasGroupName() <em>Das Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDasGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasGroupName() <em>Das Group Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasGroupName()
	 * @generated
	 * @ordered
	 */
	protected String dasGroupName = DAS_GROUP_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDasUID() <em>Das UID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasUID()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasUID() <em>Das UID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasUID()
	 * @generated
	 * @ordered
	 */
	protected String dasUID = DAS_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDasUserName() <em>Das User Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasUserName() <em>Das User Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasUserName()
	 * @generated
	 * @ordered
	 */
	protected String dasUserName = DAS_USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDasUserPassword() <em>Das User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDasUserPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_USER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasUserPassword() <em>Das User Password</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDasUserPassword()
	 * @generated
	 * @ordered
	 */
	protected String dasUserPassword = DAS_USER_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnixDB2AdminServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.UNIX_DB2_ADMIN_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasGID() {
		return dasGID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasGID(String newDasGID) {
		String oldDasGID = dasGID;
		dasGID = newDasGID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GID, oldDasGID, dasGID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasGroupName() {
		return dasGroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasGroupName(String newDasGroupName) {
		String oldDasGroupName = dasGroupName;
		dasGroupName = newDasGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME, oldDasGroupName, dasGroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasUID() {
		return dasUID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasUID(String newDasUID) {
		String oldDasUID = dasUID;
		dasUID = newDasUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_UID, oldDasUID, dasUID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasUserName() {
		return dasUserName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasUserName(String newDasUserName) {
		String oldDasUserName = dasUserName;
		dasUserName = newDasUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME, oldDasUserName, dasUserName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasUserPassword() {
		return dasUserPassword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasUserPassword(String newDasUserPassword) {
		String oldDasUserPassword = dasUserPassword;
		dasUserPassword = newDasUserPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD, oldDasUserPassword, dasUserPassword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GID:
				return getDasGID();
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME:
				return getDasGroupName();
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_UID:
				return getDasUID();
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME:
				return getDasUserName();
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD:
				return getDasUserPassword();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GID:
				setDasGID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME:
				setDasGroupName((String)newValue);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_UID:
				setDasUID((String)newValue);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME:
				setDasUserName((String)newValue);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD:
				setDasUserPassword((String)newValue);
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
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GID:
				setDasGID(DAS_GID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME:
				setDasGroupName(DAS_GROUP_NAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_UID:
				setDasUID(DAS_UID_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME:
				setDasUserName(DAS_USER_NAME_EDEFAULT);
				return;
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD:
				setDasUserPassword(DAS_USER_PASSWORD_EDEFAULT);
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
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GID:
				return DAS_GID_EDEFAULT == null ? dasGID != null : !DAS_GID_EDEFAULT.equals(dasGID);
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME:
				return DAS_GROUP_NAME_EDEFAULT == null ? dasGroupName != null : !DAS_GROUP_NAME_EDEFAULT.equals(dasGroupName);
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_UID:
				return DAS_UID_EDEFAULT == null ? dasUID != null : !DAS_UID_EDEFAULT.equals(dasUID);
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME:
				return DAS_USER_NAME_EDEFAULT == null ? dasUserName != null : !DAS_USER_NAME_EDEFAULT.equals(dasUserName);
			case Db2Package.UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD:
				return DAS_USER_PASSWORD_EDEFAULT == null ? dasUserPassword != null : !DAS_USER_PASSWORD_EDEFAULT.equals(dasUserPassword);
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
		result.append(" (dasGID: "); //$NON-NLS-1$
		result.append(dasGID);
		result.append(", dasGroupName: "); //$NON-NLS-1$
		result.append(dasGroupName);
		result.append(", dasUID: "); //$NON-NLS-1$
		result.append(dasUID);
		result.append(", dasUserName: "); //$NON-NLS-1$
		result.append(dasUserName);
		result.append(", dasUserPassword: "); //$NON-NLS-1$
		result.append(dasUserPassword);
		result.append(')');
		return result.toString();
	}

} //UnixDB2AdminServerImpl
