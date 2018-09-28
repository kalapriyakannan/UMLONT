/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerImpl;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatServerImpl#getTomcatVersion <em>Tomcat Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TomcatServerImpl extends J2EEServerImpl implements TomcatServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getTomcatVersion() <em>Tomcat Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTomcatVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String TOMCAT_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTomcatVersion() <em>Tomcat Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTomcatVersion()
	 * @generated
	 * @ordered
	 */
	protected String tomcatVersion = TOMCAT_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TomcatServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TomcatPackage.Literals.TOMCAT_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTomcatVersion() {
		return tomcatVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTomcatVersion(String newTomcatVersion) {
		String oldTomcatVersion = tomcatVersion;
		tomcatVersion = newTomcatVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TomcatPackage.TOMCAT_SERVER__TOMCAT_VERSION, oldTomcatVersion, tomcatVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TomcatPackage.TOMCAT_SERVER__TOMCAT_VERSION:
				return getTomcatVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TomcatPackage.TOMCAT_SERVER__TOMCAT_VERSION:
				setTomcatVersion((String)newValue);
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
			case TomcatPackage.TOMCAT_SERVER__TOMCAT_VERSION:
				setTomcatVersion(TOMCAT_VERSION_EDEFAULT);
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
			case TomcatPackage.TOMCAT_SERVER__TOMCAT_VERSION:
				return TOMCAT_VERSION_EDEFAULT == null ? tomcatVersion != null : !TOMCAT_VERSION_EDEFAULT.equals(tomcatVersion);
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
		result.append(" (tomcatVersion: "); //$NON-NLS-1$
		result.append(tomcatVersion);
		result.append(')');
		return result.toString();
	}

} //TomcatServerImpl
