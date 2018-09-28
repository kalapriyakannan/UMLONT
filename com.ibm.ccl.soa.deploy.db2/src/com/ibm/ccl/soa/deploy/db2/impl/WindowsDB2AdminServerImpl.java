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
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows DB2 Admin Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2AdminServerImpl#getDasDomain <em>Das Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsDB2AdminServerImpl extends DB2AdminServerImpl implements WindowsDB2AdminServer {
	/**
	 * The default value of the '{@link #getDasDomain() <em>Das Domain</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasDomain()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_DOMAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasDomain() <em>Das Domain</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasDomain()
	 * @generated
	 * @ordered
	 */
	protected String dasDomain = DAS_DOMAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsDB2AdminServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.WINDOWS_DB2_ADMIN_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasDomain() {
		return dasDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasDomain(String newDasDomain) {
		String oldDasDomain = dasDomain;
		dasDomain = newDasDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN, oldDasDomain, dasDomain));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN:
				return getDasDomain();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN:
				setDasDomain((String)newValue);
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
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN:
				setDasDomain(DAS_DOMAIN_EDEFAULT);
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
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN:
				return DAS_DOMAIN_EDEFAULT == null ? dasDomain != null : !DAS_DOMAIN_EDEFAULT.equals(dasDomain);
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
		result.append(" (dasDomain: "); //$NON-NLS-1$
		result.append(dasDomain);
		result.append(')');
		return result.toString();
	}

} //WindowsDB2AdminServerImpl
