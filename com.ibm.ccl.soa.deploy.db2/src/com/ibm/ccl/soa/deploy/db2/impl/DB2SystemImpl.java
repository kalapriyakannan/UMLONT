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
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl#getDb2ProductLang <em>Db2 Product Lang</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl#getDb2Version <em>Db2 Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl#getInstallDir <em>Install Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2SystemImpl extends CapabilityImpl implements DB2System {
	/**
	 * The default value of the '{@link #getDb2ProductLang() <em>Db2 Product Lang</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2ProductLang()
	 * @generated
	 * @ordered
	 */
	protected static final String DB2_PRODUCT_LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDb2ProductLang() <em>Db2 Product Lang</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2ProductLang()
	 * @generated
	 * @ordered
	 */
	protected String db2ProductLang = DB2_PRODUCT_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getDb2Version() <em>Db2 Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDb2Version()
	 * @generated
	 * @ordered
	 */
	protected static final String DB2_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDb2Version() <em>Db2 Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDb2Version()
	 * @generated
	 * @ordered
	 */
	protected String db2Version = DB2_VERSION_EDEFAULT;

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
	protected DB2SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDb2ProductLang() {
		return db2ProductLang;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDb2ProductLang(String newDb2ProductLang) {
		String oldDb2ProductLang = db2ProductLang;
		db2ProductLang = newDb2ProductLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_SYSTEM__DB2_PRODUCT_LANG, oldDb2ProductLang, db2ProductLang));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDb2Version() {
		return db2Version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDb2Version(String newDb2Version) {
		String oldDb2Version = db2Version;
		db2Version = newDb2Version;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_SYSTEM__DB2_VERSION, oldDb2Version, db2Version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_SYSTEM__INSTALL_DIR, oldInstallDir, installDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_SYSTEM__DB2_PRODUCT_LANG:
				return getDb2ProductLang();
			case Db2Package.DB2_SYSTEM__DB2_VERSION:
				return getDb2Version();
			case Db2Package.DB2_SYSTEM__INSTALL_DIR:
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
			case Db2Package.DB2_SYSTEM__DB2_PRODUCT_LANG:
				setDb2ProductLang((String)newValue);
				return;
			case Db2Package.DB2_SYSTEM__DB2_VERSION:
				setDb2Version((String)newValue);
				return;
			case Db2Package.DB2_SYSTEM__INSTALL_DIR:
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
			case Db2Package.DB2_SYSTEM__DB2_PRODUCT_LANG:
				setDb2ProductLang(DB2_PRODUCT_LANG_EDEFAULT);
				return;
			case Db2Package.DB2_SYSTEM__DB2_VERSION:
				setDb2Version(DB2_VERSION_EDEFAULT);
				return;
			case Db2Package.DB2_SYSTEM__INSTALL_DIR:
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
			case Db2Package.DB2_SYSTEM__DB2_PRODUCT_LANG:
				return DB2_PRODUCT_LANG_EDEFAULT == null ? db2ProductLang != null : !DB2_PRODUCT_LANG_EDEFAULT.equals(db2ProductLang);
			case Db2Package.DB2_SYSTEM__DB2_VERSION:
				return DB2_VERSION_EDEFAULT == null ? db2Version != null : !DB2_VERSION_EDEFAULT.equals(db2Version);
			case Db2Package.DB2_SYSTEM__INSTALL_DIR:
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
		result.append(" (db2ProductLang: "); //$NON-NLS-1$
		result.append(db2ProductLang);
		result.append(", db2Version: "); //$NON-NLS-1$
		result.append(db2Version);
		result.append(", installDir: "); //$NON-NLS-1$
		result.append(installDir);
		result.append(')');
		return result.toString();
	}

} //DB2SystemImpl
