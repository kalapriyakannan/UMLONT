/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl;
import com.ibm.ccl.soa.deploy.db2.DB2BaseInstance;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Base Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl#getDb2InstanceName <em>Db2 Instance Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl#getDb2Version <em>Db2 Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2BaseInstanceImpl extends DatabaseInstanceImpl implements DB2BaseInstance {
	/**
	 * The default value of the '{@link #getDb2InstanceName() <em>Db2 Instance Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2InstanceName()
	 * @generated
	 * @ordered
	 */
	protected static final String DB2_INSTANCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDb2InstanceName() <em>Db2 Instance Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDb2InstanceName()
	 * @generated
	 * @ordered
	 */
	protected String db2InstanceName = DB2_INSTANCE_NAME_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2BaseInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_BASE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDb2InstanceName() {
		return db2InstanceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDb2InstanceName(String newDb2InstanceName) {
		String oldDb2InstanceName = db2InstanceName;
		db2InstanceName = newDb2InstanceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME, oldDb2InstanceName, db2InstanceName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_BASE_INSTANCE__DB2_VERSION, oldDb2Version, db2Version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME:
				return getDb2InstanceName();
			case Db2Package.DB2_BASE_INSTANCE__DB2_VERSION:
				return getDb2Version();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME:
				setDb2InstanceName((String)newValue);
				return;
			case Db2Package.DB2_BASE_INSTANCE__DB2_VERSION:
				setDb2Version((String)newValue);
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
			case Db2Package.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME:
				setDb2InstanceName(DB2_INSTANCE_NAME_EDEFAULT);
				return;
			case Db2Package.DB2_BASE_INSTANCE__DB2_VERSION:
				setDb2Version(DB2_VERSION_EDEFAULT);
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
			case Db2Package.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME:
				return DB2_INSTANCE_NAME_EDEFAULT == null ? db2InstanceName != null : !DB2_INSTANCE_NAME_EDEFAULT.equals(db2InstanceName);
			case Db2Package.DB2_BASE_INSTANCE__DB2_VERSION:
				return DB2_VERSION_EDEFAULT == null ? db2Version != null : !DB2_VERSION_EDEFAULT.equals(db2Version);
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
		result.append(" (db2InstanceName: "); //$NON-NLS-1$
		result.append(db2InstanceName);
		result.append(", db2Version: "); //$NON-NLS-1$
		result.append(db2Version);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections.singletonList(Db2Package.eINSTANCE
			.getDB2BaseInstance_Db2InstanceName());

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //DB2BaseInstanceImpl
