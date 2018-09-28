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

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Client</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl#getDb2ClientVersion <em>Db2 Client Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl#getInstallDir <em>Install Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2ClientImpl extends CapabilityImpl implements DB2Client {
	/**
	 * The default value of the '{@link #getDb2ClientVersion() <em>Db2 Client Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2ClientVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String DB2_CLIENT_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDb2ClientVersion() <em>Db2 Client Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2ClientVersion()
	 * @generated
	 * @ordered
	 */
	protected String db2ClientVersion = DB2_CLIENT_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallDir() <em>Install Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallDir()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallDir() <em>Install Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallDir()
	 * @generated
	 * @ordered
	 */
	protected String installDir = INSTALL_DIR_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2ClientImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_CLIENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDb2ClientVersion() {
		return db2ClientVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDb2ClientVersion(String newDb2ClientVersion) {
		String oldDb2ClientVersion = db2ClientVersion;
		db2ClientVersion = newDb2ClientVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CLIENT__DB2_CLIENT_VERSION, oldDb2ClientVersion, db2ClientVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallDir() {
		return installDir;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallDir(String newInstallDir) {
		String oldInstallDir = installDir;
		installDir = newInstallDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CLIENT__INSTALL_DIR, oldInstallDir, installDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_CLIENT__DB2_CLIENT_VERSION:
				return getDb2ClientVersion();
			case Db2Package.DB2_CLIENT__INSTALL_DIR:
				return getInstallDir();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_CLIENT__DB2_CLIENT_VERSION:
				setDb2ClientVersion((String)newValue);
				return;
			case Db2Package.DB2_CLIENT__INSTALL_DIR:
				setInstallDir((String)newValue);
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
			case Db2Package.DB2_CLIENT__DB2_CLIENT_VERSION:
				setDb2ClientVersion(DB2_CLIENT_VERSION_EDEFAULT);
				return;
			case Db2Package.DB2_CLIENT__INSTALL_DIR:
				setInstallDir(INSTALL_DIR_EDEFAULT);
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
			case Db2Package.DB2_CLIENT__DB2_CLIENT_VERSION:
				return DB2_CLIENT_VERSION_EDEFAULT == null ? db2ClientVersion != null : !DB2_CLIENT_VERSION_EDEFAULT.equals(db2ClientVersion);
			case Db2Package.DB2_CLIENT__INSTALL_DIR:
				return INSTALL_DIR_EDEFAULT == null ? installDir != null : !INSTALL_DIR_EDEFAULT.equals(installDir);
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
		result.append(" (db2ClientVersion: "); //$NON-NLS-1$
		result.append(db2ClientVersion);
		result.append(", installDir: "); //$NON-NLS-1$
		result.append(installDir);
		result.append(')');
		return result.toString();
	}

} //DB2ClientImpl
