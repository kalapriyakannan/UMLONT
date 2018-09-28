/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerbyInstanceImpl extends DatabaseInstanceImpl implements DerbyInstance {
	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceName()
	 * @generated
	 * @ordered
	 */
	protected String instanceName = INSTANCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger port = PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DerbyInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DerbyPackage.Literals.DERBY_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_INSTANCE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceName() {
		return instanceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceName(String newInstanceName) {
		String oldInstanceName = instanceName;
		instanceName = newInstanceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_INSTANCE__INSTANCE_NAME, oldInstanceName, instanceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(BigInteger newPort) {
		BigInteger oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DerbyPackage.DERBY_INSTANCE__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DerbyPackage.DERBY_INSTANCE__HOSTNAME:
				return getHostname();
			case DerbyPackage.DERBY_INSTANCE__INSTANCE_NAME:
				return getInstanceName();
			case DerbyPackage.DERBY_INSTANCE__PORT:
				return getPort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DerbyPackage.DERBY_INSTANCE__HOSTNAME:
				setHostname((String)newValue);
				return;
			case DerbyPackage.DERBY_INSTANCE__INSTANCE_NAME:
				setInstanceName((String)newValue);
				return;
			case DerbyPackage.DERBY_INSTANCE__PORT:
				setPort((BigInteger)newValue);
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
			case DerbyPackage.DERBY_INSTANCE__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case DerbyPackage.DERBY_INSTANCE__INSTANCE_NAME:
				setInstanceName(INSTANCE_NAME_EDEFAULT);
				return;
			case DerbyPackage.DERBY_INSTANCE__PORT:
				setPort(PORT_EDEFAULT);
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
			case DerbyPackage.DERBY_INSTANCE__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case DerbyPackage.DERBY_INSTANCE__INSTANCE_NAME:
				return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals(instanceName);
			case DerbyPackage.DERBY_INSTANCE__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
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
		result.append(" (hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", instanceName: "); //$NON-NLS-1$
		result.append(instanceName);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(')');
		return result.toString();
	}

} //DerbyInstanceImpl
