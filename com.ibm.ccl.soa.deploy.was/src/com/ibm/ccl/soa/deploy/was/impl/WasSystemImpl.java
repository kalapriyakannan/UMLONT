/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>System</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSystemImpl#getInstallerDir <em>Installer Dir</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSystemImpl#getWasEdition <em>Was Edition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSystemImpl#getWasHome <em>Was Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSystemImpl#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSystemImpl extends CapabilityImpl implements WasSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getInstallerDir() <em>Installer Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallerDir()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALLER_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallerDir() <em>Installer Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstallerDir()
	 * @generated
	 * @ordered
	 */
	protected String installerDir = INSTALLER_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getWasEdition() <em>Was Edition</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasEdition()
	 * @generated
	 * @ordered
	 */
	protected static final WasEditionEnum WAS_EDITION_EDEFAULT = WasEditionEnum.BASE_LITERAL;

	/**
	 * The cached value of the '{@link #getWasEdition() <em>Was Edition</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasEdition()
	 * @generated
	 * @ordered
	 */
	protected WasEditionEnum wasEdition = WAS_EDITION_EDEFAULT;

	/**
	 * This is true if the Was Edition attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean wasEditionESet;

	/**
	 * The default value of the '{@link #getWasHome() <em>Was Home</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasHome()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_HOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasHome() <em>Was Home</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasHome()
	 * @generated
	 * @ordered
	 */
	protected String wasHome = WAS_HOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasVersion = WAS_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallerDir() {
		return installerDir;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallerDir(String newInstallerDir) {
		String oldInstallerDir = installerDir;
		installerDir = newInstallerDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SYSTEM__INSTALLER_DIR, oldInstallerDir, installerDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasEditionEnum getWasEdition() {
		return wasEdition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasEdition(WasEditionEnum newWasEdition) {
		WasEditionEnum oldWasEdition = wasEdition;
		wasEdition = newWasEdition == null ? WAS_EDITION_EDEFAULT : newWasEdition;
		boolean oldWasEditionESet = wasEditionESet;
		wasEditionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SYSTEM__WAS_EDITION, oldWasEdition, wasEdition, !oldWasEditionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWasEdition() {
		WasEditionEnum oldWasEdition = wasEdition;
		boolean oldWasEditionESet = wasEditionESet;
		wasEdition = WAS_EDITION_EDEFAULT;
		wasEditionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SYSTEM__WAS_EDITION, oldWasEdition, WAS_EDITION_EDEFAULT, oldWasEditionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWasEdition() {
		return wasEditionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasHome() {
		return wasHome;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasHome(String newWasHome) {
		String oldWasHome = wasHome;
		wasHome = newWasHome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SYSTEM__WAS_HOME, oldWasHome, wasHome));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasVersion() {
		return wasVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasVersion(String newWasVersion) {
		String oldWasVersion = wasVersion;
		wasVersion = newWasVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SYSTEM__WAS_VERSION, oldWasVersion, wasVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SYSTEM__INSTALLER_DIR:
				return getInstallerDir();
			case WasPackage.WAS_SYSTEM__WAS_EDITION:
				return getWasEdition();
			case WasPackage.WAS_SYSTEM__WAS_HOME:
				return getWasHome();
			case WasPackage.WAS_SYSTEM__WAS_VERSION:
				return getWasVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SYSTEM__INSTALLER_DIR:
				setInstallerDir((String)newValue);
				return;
			case WasPackage.WAS_SYSTEM__WAS_EDITION:
				setWasEdition((WasEditionEnum)newValue);
				return;
			case WasPackage.WAS_SYSTEM__WAS_HOME:
				setWasHome((String)newValue);
				return;
			case WasPackage.WAS_SYSTEM__WAS_VERSION:
				setWasVersion((String)newValue);
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
			case WasPackage.WAS_SYSTEM__INSTALLER_DIR:
				setInstallerDir(INSTALLER_DIR_EDEFAULT);
				return;
			case WasPackage.WAS_SYSTEM__WAS_EDITION:
				unsetWasEdition();
				return;
			case WasPackage.WAS_SYSTEM__WAS_HOME:
				setWasHome(WAS_HOME_EDEFAULT);
				return;
			case WasPackage.WAS_SYSTEM__WAS_VERSION:
				setWasVersion(WAS_VERSION_EDEFAULT);
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
			case WasPackage.WAS_SYSTEM__INSTALLER_DIR:
				return INSTALLER_DIR_EDEFAULT == null ? installerDir != null : !INSTALLER_DIR_EDEFAULT.equals(installerDir);
			case WasPackage.WAS_SYSTEM__WAS_EDITION:
				return isSetWasEdition();
			case WasPackage.WAS_SYSTEM__WAS_HOME:
				return WAS_HOME_EDEFAULT == null ? wasHome != null : !WAS_HOME_EDEFAULT.equals(wasHome);
			case WasPackage.WAS_SYSTEM__WAS_VERSION:
				return WAS_VERSION_EDEFAULT == null ? wasVersion != null : !WAS_VERSION_EDEFAULT.equals(wasVersion);
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
		result.append(" (installerDir: "); //$NON-NLS-1$
		result.append(installerDir);
		result.append(", wasEdition: "); //$NON-NLS-1$
		if (wasEditionESet) result.append(wasEdition); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", wasHome: "); //$NON-NLS-1$
		result.append(wasHome);
		result.append(", wasVersion: "); //$NON-NLS-1$
		result.append(wasVersion);
		result.append(')');
		return result.toString();
	}

} //WasSystemImpl
