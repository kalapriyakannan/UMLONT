/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl#isAutoStart <em>Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2InstanceImpl extends DB2BaseInstanceImpl implements DB2Instance {
	/**
	 * The default value of the '{@link #isAutoStart() <em>Auto Start</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAutoStart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_START_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoStart() <em>Auto Start</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAutoStart()
	 * @generated
	 * @ordered
	 */
	protected boolean autoStart = AUTO_START_EDEFAULT;

	/**
	 * This is true if the Auto Start attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoStartESet;

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
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

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
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2InstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoStart() {
		return autoStart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoStart(boolean newAutoStart) {
		boolean oldAutoStart = autoStart;
		autoStart = newAutoStart;
		boolean oldAutoStartESet = autoStartESet;
		autoStartESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_INSTANCE__AUTO_START, oldAutoStart, autoStart, !oldAutoStartESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoStart() {
		boolean oldAutoStart = autoStart;
		boolean oldAutoStartESet = autoStartESet;
		autoStart = AUTO_START_EDEFAULT;
		autoStartESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.DB2_INSTANCE__AUTO_START, oldAutoStart, AUTO_START_EDEFAULT, oldAutoStartESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoStart() {
		return autoStartESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_INSTANCE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_INSTANCE__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_INSTANCE__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_INSTANCE__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_INSTANCE__AUTO_START:
				return isAutoStart() ? Boolean.TRUE : Boolean.FALSE;
			case Db2Package.DB2_INSTANCE__HOSTNAME:
				return getHostname();
			case Db2Package.DB2_INSTANCE__PASSWORD:
				return getPassword();
			case Db2Package.DB2_INSTANCE__PORT:
				return getPort();
			case Db2Package.DB2_INSTANCE__USERNAME:
				return getUsername();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_INSTANCE__AUTO_START:
				setAutoStart(((Boolean)newValue).booleanValue());
				return;
			case Db2Package.DB2_INSTANCE__HOSTNAME:
				setHostname((String)newValue);
				return;
			case Db2Package.DB2_INSTANCE__PASSWORD:
				setPassword((String)newValue);
				return;
			case Db2Package.DB2_INSTANCE__PORT:
				setPort((BigInteger)newValue);
				return;
			case Db2Package.DB2_INSTANCE__USERNAME:
				setUsername((String)newValue);
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
			case Db2Package.DB2_INSTANCE__AUTO_START:
				unsetAutoStart();
				return;
			case Db2Package.DB2_INSTANCE__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case Db2Package.DB2_INSTANCE__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case Db2Package.DB2_INSTANCE__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case Db2Package.DB2_INSTANCE__USERNAME:
				setUsername(USERNAME_EDEFAULT);
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
			case Db2Package.DB2_INSTANCE__AUTO_START:
				return isSetAutoStart();
			case Db2Package.DB2_INSTANCE__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case Db2Package.DB2_INSTANCE__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case Db2Package.DB2_INSTANCE__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case Db2Package.DB2_INSTANCE__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
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
		result.append(" (autoStart: "); //$NON-NLS-1$
		if (autoStartESet) result.append(autoStart); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", username: "); //$NON-NLS-1$
		result.append(username);
		result.append(')');
		return result.toString();
	}

} //DB2InstanceImpl
