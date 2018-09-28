/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.wps.ApplicationSchedular;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Schedular</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl#getDataBaseName <em>Data Base Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl#getServerName <em>Server Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationSchedularImpl extends CapabilityImpl implements ApplicationSchedular {
	/**
	 * The default value of the '{@link #getDataBaseName() <em>Data Base Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataBaseName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_BASE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataBaseName() <em>Data Base Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataBaseName()
	 * @generated
	 * @ordered
	 */
	protected String dataBaseName = DATA_BASE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerName()
	 * @generated
	 * @ordered
	 */
	protected String serverName = SERVER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationSchedularImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.APPLICATION_SCHEDULAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataBaseName(String newDataBaseName) {
		String oldDataBaseName = dataBaseName;
		dataBaseName = newDataBaseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.APPLICATION_SCHEDULAR__DATA_BASE_NAME, oldDataBaseName, dataBaseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerName(String newServerName) {
		String oldServerName = serverName;
		serverName = newServerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.APPLICATION_SCHEDULAR__SERVER_NAME, oldServerName, serverName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.APPLICATION_SCHEDULAR__DATA_BASE_NAME:
				return getDataBaseName();
			case WpsPackage.APPLICATION_SCHEDULAR__SERVER_NAME:
				return getServerName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WpsPackage.APPLICATION_SCHEDULAR__DATA_BASE_NAME:
				setDataBaseName((String)newValue);
				return;
			case WpsPackage.APPLICATION_SCHEDULAR__SERVER_NAME:
				setServerName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case WpsPackage.APPLICATION_SCHEDULAR__DATA_BASE_NAME:
				setDataBaseName(DATA_BASE_NAME_EDEFAULT);
				return;
			case WpsPackage.APPLICATION_SCHEDULAR__SERVER_NAME:
				setServerName(SERVER_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WpsPackage.APPLICATION_SCHEDULAR__DATA_BASE_NAME:
				return DATA_BASE_NAME_EDEFAULT == null ? dataBaseName != null : !DATA_BASE_NAME_EDEFAULT.equals(dataBaseName);
			case WpsPackage.APPLICATION_SCHEDULAR__SERVER_NAME:
				return SERVER_NAME_EDEFAULT == null ? serverName != null : !SERVER_NAME_EDEFAULT.equals(serverName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dataBaseName: "); //$NON-NLS-1$
		result.append(dataBaseName);
		result.append(", serverName: "); //$NON-NLS-1$
		result.append(serverName);
		result.append(')');
		return result.toString();
	}

} //ApplicationSchedularImpl
