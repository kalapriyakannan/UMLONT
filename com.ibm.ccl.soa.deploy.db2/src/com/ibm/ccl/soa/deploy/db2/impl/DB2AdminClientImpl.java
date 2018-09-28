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

import com.ibm.ccl.soa.deploy.db2.DB2AdminClient;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Admin Client</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientImpl#getDb2ProductLang <em>Db2 Product Lang</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2AdminClientImpl extends DB2ClientImpl implements DB2AdminClient {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2AdminClientImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_ADMIN_CLIENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG, oldDb2ProductLang, db2ProductLang));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG:
				return getDb2ProductLang();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG:
				setDb2ProductLang((String)newValue);
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
			case Db2Package.DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG:
				setDb2ProductLang(DB2_PRODUCT_LANG_EDEFAULT);
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
			case Db2Package.DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG:
				return DB2_PRODUCT_LANG_EDEFAULT == null ? db2ProductLang != null : !DB2_PRODUCT_LANG_EDEFAULT.equals(db2ProductLang);
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
		result.append(')');
		return result.toString();
	}

} //DB2AdminClientImpl
