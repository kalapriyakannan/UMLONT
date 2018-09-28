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

import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModule;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Was Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleImpl#getConfigFile <em>Config File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IhsWasModuleImpl extends IhsModuleImpl implements IhsWasModule {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsWasModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_WAS_MODULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_WAS_MODULE__CONFIG_FILE, oldConfigFile, configFile));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_WAS_MODULE__CONFIG_FILE:
				return getConfigFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_WAS_MODULE__CONFIG_FILE:
				setConfigFile((String)newValue);
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
			case IhsPackage.IHS_WAS_MODULE__CONFIG_FILE:
				setConfigFile(CONFIG_FILE_EDEFAULT);
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
			case IhsPackage.IHS_WAS_MODULE__CONFIG_FILE:
				return CONFIG_FILE_EDEFAULT == null ? configFile != null : !CONFIG_FILE_EDEFAULT.equals(configFile);
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
		result.append(')');
		return result.toString();
	}

} //IhsWasModuleImpl
