/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: RemoteFileSystemImpl.java,v 1.1 2007/12/19 23:37:06 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RemoteFileSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remote File System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl#getExportName <em>Export Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl#getServerName <em>Server Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RemoteFileSystemImpl extends FileSystemImpl implements RemoteFileSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getExportName() <em>Export Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPORT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExportName() <em>Export Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExportName()
	 * @generated
	 * @ordered
	 */
	protected String exportName = EXPORT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected String serverName = SERVER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoteFileSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.REMOTE_FILE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExportName() {
		return exportName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExportName(String newExportName) {
		String oldExportName = exportName;
		exportName = newExportName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REMOTE_FILE_SYSTEM__EXPORT_NAME, oldExportName, exportName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerName(String newServerName) {
		String oldServerName = serverName;
		serverName = newServerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.REMOTE_FILE_SYSTEM__SERVER_NAME, oldServerName, serverName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.REMOTE_FILE_SYSTEM__EXPORT_NAME:
			return getExportName();
		case OsPackage.REMOTE_FILE_SYSTEM__SERVER_NAME:
			return getServerName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.REMOTE_FILE_SYSTEM__EXPORT_NAME:
			setExportName((String) newValue);
			return;
		case OsPackage.REMOTE_FILE_SYSTEM__SERVER_NAME:
			setServerName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.REMOTE_FILE_SYSTEM__EXPORT_NAME:
			setExportName(EXPORT_NAME_EDEFAULT);
			return;
		case OsPackage.REMOTE_FILE_SYSTEM__SERVER_NAME:
			setServerName(SERVER_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.REMOTE_FILE_SYSTEM__EXPORT_NAME:
			return EXPORT_NAME_EDEFAULT == null ? exportName != null : !EXPORT_NAME_EDEFAULT
					.equals(exportName);
		case OsPackage.REMOTE_FILE_SYSTEM__SERVER_NAME:
			return SERVER_NAME_EDEFAULT == null ? serverName != null : !SERVER_NAME_EDEFAULT
					.equals(serverName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exportName: "); //$NON-NLS-1$
		result.append(exportName);
		result.append(", serverName: "); //$NON-NLS-1$
		result.append(serverName);
		result.append(')');
		return result.toString();
	}

} //RemoteFileSystemImpl
