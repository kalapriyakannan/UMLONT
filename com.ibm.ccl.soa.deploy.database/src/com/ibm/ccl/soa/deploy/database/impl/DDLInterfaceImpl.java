/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.database.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DDL Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.database.impl.DDLInterfaceImpl#getSchemaUri <em>Schema Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DDLInterfaceImpl extends InterfaceImpl implements DDLInterface {
	/**
	 * The default value of the '{@link #getSchemaUri() <em>Schema Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSchemaUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchemaUri() <em>Schema Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSchemaUri()
	 * @generated
	 * @ordered
	 */
	protected String schemaUri = SCHEMA_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DDLInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.DDL_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchemaUri() {
		return schemaUri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaUri(String newSchemaUri) {
		String oldSchemaUri = schemaUri;
		schemaUri = newSchemaUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatabasePackage.DDL_INTERFACE__SCHEMA_URI, oldSchemaUri, schemaUri));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatabasePackage.DDL_INTERFACE__SCHEMA_URI:
				return getSchemaUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatabasePackage.DDL_INTERFACE__SCHEMA_URI:
				setSchemaUri((String)newValue);
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
			case DatabasePackage.DDL_INTERFACE__SCHEMA_URI:
				setSchemaUri(SCHEMA_URI_EDEFAULT);
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
			case DatabasePackage.DDL_INTERFACE__SCHEMA_URI:
				return SCHEMA_URI_EDEFAULT == null ? schemaUri != null : !SCHEMA_URI_EDEFAULT.equals(schemaUri);
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
		result.append(" (schemaUri: "); //$NON-NLS-1$
		result.append(schemaUri);
		result.append(')');
		return result.toString();
	}

	public boolean isFastEquivalencyCheck(Interface anotherInterface) {
		if (anotherInterface != null && anotherInterface instanceof DDLInterface) {
			String schemaUri = getSchemaUri();
			String anotherSchemaUri = ((DDLInterface) anotherInterface).getSchemaUri();
			schemaUri = schemaUri == null || schemaUri.length() == 0 ? null : schemaUri;
			anotherSchemaUri = anotherSchemaUri == null || anotherSchemaUri.length() == 0 ? null
					: anotherSchemaUri;
			if (schemaUri == null && anotherSchemaUri == null) {
				return true;
			}
			if (schemaUri != null && anotherSchemaUri == null || schemaUri == null
					&& anotherSchemaUri != null) {
				return false;
			}
			return schemaUri.equals(anotherSchemaUri);
		}
		return false;
	}

	public String getDisplayString() {
		return getSchemaUri();
	}

} //DDLInterfaceImpl
