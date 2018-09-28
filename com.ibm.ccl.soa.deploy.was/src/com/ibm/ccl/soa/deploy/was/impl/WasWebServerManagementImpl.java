/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasWebServerManagement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web Server Management</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#isAutoConfigPropagation <em>Auto Config Propagation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#getHost <em>Host</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebServerManagementImpl#isUseSecureProtocol <em>Use Secure Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasWebServerManagementImpl extends CapabilityImpl implements WasWebServerManagement {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isAutoConfigPropagation() <em>Auto Config Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoConfigPropagation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_CONFIG_PROPAGATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoConfigPropagation() <em>Auto Config Propagation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoConfigPropagation()
	 * @generated
	 * @ordered
	 */
	protected boolean autoConfigPropagation = AUTO_CONFIG_PROPAGATION_EDEFAULT;

	/**
	 * This is true if the Auto Config Propagation attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoConfigPropagationESet;

	/**
	 * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected static final String HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected String host = HOST_EDEFAULT;

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
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isUseSecureProtocol() <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseSecureProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_SECURE_PROTOCOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseSecureProtocol() <em>Use Secure Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isUseSecureProtocol()
	 * @generated
	 * @ordered
	 */
	protected boolean useSecureProtocol = USE_SECURE_PROTOCOL_EDEFAULT;

	/**
	 * This is true if the Use Secure Protocol attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean useSecureProtocolESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasWebServerManagementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_WEB_SERVER_MANAGEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoConfigPropagation() {
		return autoConfigPropagation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoConfigPropagation(boolean newAutoConfigPropagation) {
		boolean oldAutoConfigPropagation = autoConfigPropagation;
		autoConfigPropagation = newAutoConfigPropagation;
		boolean oldAutoConfigPropagationESet = autoConfigPropagationESet;
		autoConfigPropagationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION, oldAutoConfigPropagation, autoConfigPropagation, !oldAutoConfigPropagationESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoConfigPropagation() {
		boolean oldAutoConfigPropagation = autoConfigPropagation;
		boolean oldAutoConfigPropagationESet = autoConfigPropagationESet;
		autoConfigPropagation = AUTO_CONFIG_PROPAGATION_EDEFAULT;
		autoConfigPropagationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION, oldAutoConfigPropagation, AUTO_CONFIG_PROPAGATION_EDEFAULT, oldAutoConfigPropagationESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoConfigPropagation() {
		return autoConfigPropagationESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(String newHost) {
		String oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__HOST, oldHost, host));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__PASSWORD, oldPassword, password));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseSecureProtocol() {
		return useSecureProtocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseSecureProtocol(boolean newUseSecureProtocol) {
		boolean oldUseSecureProtocol = useSecureProtocol;
		useSecureProtocol = newUseSecureProtocol;
		boolean oldUseSecureProtocolESet = useSecureProtocolESet;
		useSecureProtocolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL, oldUseSecureProtocol, useSecureProtocol, !oldUseSecureProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUseSecureProtocol() {
		boolean oldUseSecureProtocol = useSecureProtocol;
		boolean oldUseSecureProtocolESet = useSecureProtocolESet;
		useSecureProtocol = USE_SECURE_PROTOCOL_EDEFAULT;
		useSecureProtocolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL, oldUseSecureProtocol, USE_SECURE_PROTOCOL_EDEFAULT, oldUseSecureProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUseSecureProtocol() {
		return useSecureProtocolESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION:
				return isAutoConfigPropagation() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__HOST:
				return getHost();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PASSWORD:
				return getPassword();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PORT:
				return getPort();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USER_ID:
				return getUserId();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL:
				return isUseSecureProtocol() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION:
				setAutoConfigPropagation(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__HOST:
				setHost((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PASSWORD:
				setPassword((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PORT:
				setPort((BigInteger)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USER_ID:
				setUserId((String)newValue);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL:
				setUseSecureProtocol(((Boolean)newValue).booleanValue());
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
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION:
				unsetAutoConfigPropagation();
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__HOST:
				setHost(HOST_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL:
				unsetUseSecureProtocol();
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
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__AUTO_CONFIG_PROPAGATION:
				return isSetAutoConfigPropagation();
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__HOST:
				return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case WasPackage.WAS_WEB_SERVER_MANAGEMENT__USE_SECURE_PROTOCOL:
				return isSetUseSecureProtocol();
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
		result.append(" (autoConfigPropagation: "); //$NON-NLS-1$
		if (autoConfigPropagationESet) result.append(autoConfigPropagation); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", host: "); //$NON-NLS-1$
		result.append(host);
		result.append(", password: "); //$NON-NLS-1$
		result.append(password);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", userId: "); //$NON-NLS-1$
		result.append(userId);
		result.append(", useSecureProtocol: "); //$NON-NLS-1$
		if (useSecureProtocolESet) result.append(useSecureProtocol); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasWebServerManagementImpl
