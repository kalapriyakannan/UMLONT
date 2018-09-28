/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl#getDbAlias <em>Db Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl#getDbDrive <em>Db Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl#getDerbyVersion <em>Derby Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerbyDatabaseImpl extends DatabaseImpl implements DerbyDatabase {
	/**
	 * The default value of the '{@link #getDbAlias() <em>Db Alias</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbAlias() <em>Db Alias</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbAlias()
	 * @generated
	 * @ordered
	 */
	protected String dbAlias = DB_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbDrive() <em>Db Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbDrive()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_DRIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbDrive() <em>Db Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbDrive()
	 * @generated
	 * @ordered
	 */
	protected String dbDrive = DB_DRIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected String dbName = DB_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDerbyVersion() <em>Derby Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDerbyVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String DERBY_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDerbyVersion() <em>Derby Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDerbyVersion()
	 * @generated
	 * @ordered
	 */
	protected String derbyVersion = DERBY_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DerbyDatabaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DerbyPackage.Literals.DERBY_DATABASE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbAlias() {
		return dbAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbAlias(String newDbAlias) {
		String oldDbAlias = dbAlias;
		dbAlias = newDbAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_DATABASE__DB_ALIAS, oldDbAlias, dbAlias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbDrive() {
		return dbDrive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbDrive(String newDbDrive) {
		String oldDbDrive = dbDrive;
		dbDrive = newDbDrive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_DATABASE__DB_DRIVE, oldDbDrive, dbDrive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbName(String newDbName) {
		String oldDbName = dbName;
		dbName = newDbName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_DATABASE__DB_NAME, oldDbName, dbName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDerbyVersion() {
		return derbyVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerbyVersion(String newDerbyVersion) {
		String oldDerbyVersion = derbyVersion;
		derbyVersion = newDerbyVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_DATABASE__DERBY_VERSION, oldDerbyVersion, derbyVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DerbyPackage.DERBY_DATABASE__DB_ALIAS:
				return getDbAlias();
			case DerbyPackage.DERBY_DATABASE__DB_DRIVE:
				return getDbDrive();
			case DerbyPackage.DERBY_DATABASE__DB_NAME:
				return getDbName();
			case DerbyPackage.DERBY_DATABASE__DERBY_VERSION:
				return getDerbyVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DerbyPackage.DERBY_DATABASE__DB_ALIAS:
				setDbAlias((String)newValue);
				return;
			case DerbyPackage.DERBY_DATABASE__DB_DRIVE:
				setDbDrive((String)newValue);
				return;
			case DerbyPackage.DERBY_DATABASE__DB_NAME:
				setDbName((String)newValue);
				return;
			case DerbyPackage.DERBY_DATABASE__DERBY_VERSION:
				setDerbyVersion((String)newValue);
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
			case DerbyPackage.DERBY_DATABASE__DB_ALIAS:
				setDbAlias(DB_ALIAS_EDEFAULT);
				return;
			case DerbyPackage.DERBY_DATABASE__DB_DRIVE:
				setDbDrive(DB_DRIVE_EDEFAULT);
				return;
			case DerbyPackage.DERBY_DATABASE__DB_NAME:
				setDbName(DB_NAME_EDEFAULT);
				return;
			case DerbyPackage.DERBY_DATABASE__DERBY_VERSION:
				setDerbyVersion(DERBY_VERSION_EDEFAULT);
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
			case DerbyPackage.DERBY_DATABASE__DB_ALIAS:
				return DB_ALIAS_EDEFAULT == null ? dbAlias != null : !DB_ALIAS_EDEFAULT.equals(dbAlias);
			case DerbyPackage.DERBY_DATABASE__DB_DRIVE:
				return DB_DRIVE_EDEFAULT == null ? dbDrive != null : !DB_DRIVE_EDEFAULT.equals(dbDrive);
			case DerbyPackage.DERBY_DATABASE__DB_NAME:
				return DB_NAME_EDEFAULT == null ? dbName != null : !DB_NAME_EDEFAULT.equals(dbName);
			case DerbyPackage.DERBY_DATABASE__DERBY_VERSION:
				return DERBY_VERSION_EDEFAULT == null ? derbyVersion != null : !DERBY_VERSION_EDEFAULT.equals(derbyVersion);
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
		result.append(" (dbAlias: "); //$NON-NLS-1$
		result.append(dbAlias);
		result.append(", dbDrive: "); //$NON-NLS-1$
		result.append(dbDrive);
		result.append(", dbName: "); //$NON-NLS-1$
		result.append(dbName);
		result.append(", derbyVersion: "); //$NON-NLS-1$
		result.append(derbyVersion);
		result.append(')');
		return result.toString();
	}

} //DerbyDatabaseImpl
