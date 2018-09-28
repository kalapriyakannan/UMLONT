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
import com.ibm.ccl.soa.deploy.wps.SCARuntime;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Runtime</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.SCARuntimeImpl#getInstallationPath <em>Installation Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCARuntimeImpl extends CapabilityImpl implements SCARuntime {
	/**
	 * The default value of the '{@link #getInstallationPath() <em>Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallationPath()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALLATION_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallationPath() <em>Installation Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallationPath()
	 * @generated
	 * @ordered
	 */
	protected String installationPath = INSTALLATION_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCARuntimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.SCA_RUNTIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallationPath() {
		return installationPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallationPath(String newInstallationPath) {
		String oldInstallationPath = installationPath;
		installationPath = newInstallationPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.SCA_RUNTIME__INSTALLATION_PATH, oldInstallationPath, installationPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.SCA_RUNTIME__INSTALLATION_PATH:
				return getInstallationPath();
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
			case WpsPackage.SCA_RUNTIME__INSTALLATION_PATH:
				setInstallationPath((String)newValue);
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
			case WpsPackage.SCA_RUNTIME__INSTALLATION_PATH:
				setInstallationPath(INSTALLATION_PATH_EDEFAULT);
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
			case WpsPackage.SCA_RUNTIME__INSTALLATION_PATH:
				return INSTALLATION_PATH_EDEFAULT == null ? installationPath != null : !INSTALLATION_PATH_EDEFAULT.equals(installationPath);
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
		result.append(" (installationPath: "); //$NON-NLS-1$
		result.append(installationPath);
		result.append(')');
		return result.toString();
	}

} //SCARuntimeImpl
