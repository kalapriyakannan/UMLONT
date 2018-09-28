/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.http.impl.HttpServerImpl;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl#getConfigFile <em>Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl#isSecure <em>Secure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IhsServerImpl extends HttpServerImpl implements IhsServer {
	/**
	 * The default value of the '{@link #getConfigFile() <em>Config File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigFile() <em>Config File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected String configFile = CONFIG_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSecure() <em>Secure</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSecure()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSecure() <em>Secure</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isSecure()
	 * @generated
	 * @ordered
	 */
	protected boolean secure = SECURE_EDEFAULT;

	/**
	 * This is true if the Secure attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean secureESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_SERVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigFile(String newConfigFile) {
		String oldConfigFile = configFile;
		configFile = newConfigFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_SERVER__CONFIG_FILE, oldConfigFile, configFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecure(boolean newSecure) {
		boolean oldSecure = secure;
		secure = newSecure;
		boolean oldSecureESet = secureESet;
		secureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_SERVER__SECURE, oldSecure, secure, !oldSecureESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSecure() {
		boolean oldSecure = secure;
		boolean oldSecureESet = secureESet;
		secure = SECURE_EDEFAULT;
		secureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, IhsPackage.IHS_SERVER__SECURE, oldSecure, SECURE_EDEFAULT, oldSecureESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSecure() {
		return secureESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_SERVER__CONFIG_FILE:
				return getConfigFile();
			case IhsPackage.IHS_SERVER__SECURE:
				return isSecure() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_SERVER__CONFIG_FILE:
				setConfigFile((String)newValue);
				return;
			case IhsPackage.IHS_SERVER__SECURE:
				setSecure(((Boolean)newValue).booleanValue());
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
			case IhsPackage.IHS_SERVER__CONFIG_FILE:
				setConfigFile(CONFIG_FILE_EDEFAULT);
				return;
			case IhsPackage.IHS_SERVER__SECURE:
				unsetSecure();
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
			case IhsPackage.IHS_SERVER__CONFIG_FILE:
				return CONFIG_FILE_EDEFAULT == null ? configFile != null : !CONFIG_FILE_EDEFAULT.equals(configFile);
			case IhsPackage.IHS_SERVER__SECURE:
				return isSetSecure();
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
		result.append(" (configFile: "); //$NON-NLS-1$
		result.append(configFile);
		result.append(", secure: "); //$NON-NLS-1$
		if (secureESet) result.append(secure); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //IhsServerImpl
