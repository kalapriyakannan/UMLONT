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
import com.ibm.ccl.soa.deploy.wps.WpsBaseSystem;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl#getInstallLocation <em>Install Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl#getProfileDir <em>Profile Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WpsBaseSystemImpl extends CapabilityImpl implements WpsBaseSystem {
	/**
	 * The default value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallLocation() <em>Install Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallLocation()
	 * @generated
	 * @ordered
	 */
	protected String installLocation = INSTALL_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileDir() <em>Profile Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileDir()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileDir() <em>Profile Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileDir()
	 * @generated
	 * @ordered
	 */
	protected String profileDir = PROFILE_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WpsBaseSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.WPS_BASE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallLocation() {
		return installLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallLocation(String newInstallLocation) {
		String oldInstallLocation = installLocation;
		installLocation = newInstallLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WPS_BASE_SYSTEM__INSTALL_LOCATION, oldInstallLocation, installLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileDir() {
		return profileDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileDir(String newProfileDir) {
		String oldProfileDir = profileDir;
		profileDir = newProfileDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WPS_BASE_SYSTEM__PROFILE_DIR, oldProfileDir, profileDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WPS_BASE_SYSTEM__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.WPS_BASE_SYSTEM__INSTALL_LOCATION:
				return getInstallLocation();
			case WpsPackage.WPS_BASE_SYSTEM__PROFILE_DIR:
				return getProfileDir();
			case WpsPackage.WPS_BASE_SYSTEM__VERSION:
				return getVersion();
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
			case WpsPackage.WPS_BASE_SYSTEM__INSTALL_LOCATION:
				setInstallLocation((String)newValue);
				return;
			case WpsPackage.WPS_BASE_SYSTEM__PROFILE_DIR:
				setProfileDir((String)newValue);
				return;
			case WpsPackage.WPS_BASE_SYSTEM__VERSION:
				setVersion((String)newValue);
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
			case WpsPackage.WPS_BASE_SYSTEM__INSTALL_LOCATION:
				setInstallLocation(INSTALL_LOCATION_EDEFAULT);
				return;
			case WpsPackage.WPS_BASE_SYSTEM__PROFILE_DIR:
				setProfileDir(PROFILE_DIR_EDEFAULT);
				return;
			case WpsPackage.WPS_BASE_SYSTEM__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case WpsPackage.WPS_BASE_SYSTEM__INSTALL_LOCATION:
				return INSTALL_LOCATION_EDEFAULT == null ? installLocation != null : !INSTALL_LOCATION_EDEFAULT.equals(installLocation);
			case WpsPackage.WPS_BASE_SYSTEM__PROFILE_DIR:
				return PROFILE_DIR_EDEFAULT == null ? profileDir != null : !PROFILE_DIR_EDEFAULT.equals(profileDir);
			case WpsPackage.WPS_BASE_SYSTEM__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(" (installLocation: "); //$NON-NLS-1$
		result.append(installLocation);
		result.append(", profileDir: "); //$NON-NLS-1$
		result.append(profileDir);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //WpsBaseSystemImpl
