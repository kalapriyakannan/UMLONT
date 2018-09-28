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

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.ihs.IhsModule;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Module</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl#getModuleName <em>Module Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IhsModuleImpl extends CapabilityImpl implements IhsModule {
	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getModuleName() <em>Module Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModuleName() <em>Module Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModuleName()
	 * @generated
	 * @ordered
	 */
	protected String moduleName = MODULE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_MODULE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_MODULE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModuleName(String newModuleName) {
		String oldModuleName = moduleName;
		moduleName = newModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IhsPackage.IHS_MODULE__MODULE_NAME, oldModuleName, moduleName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IhsPackage.IHS_MODULE__LOCATION:
				return getLocation();
			case IhsPackage.IHS_MODULE__MODULE_NAME:
				return getModuleName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IhsPackage.IHS_MODULE__LOCATION:
				setLocation((String)newValue);
				return;
			case IhsPackage.IHS_MODULE__MODULE_NAME:
				setModuleName((String)newValue);
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
			case IhsPackage.IHS_MODULE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case IhsPackage.IHS_MODULE__MODULE_NAME:
				setModuleName(MODULE_NAME_EDEFAULT);
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
			case IhsPackage.IHS_MODULE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case IhsPackage.IHS_MODULE__MODULE_NAME:
				return MODULE_NAME_EDEFAULT == null ? moduleName != null : !MODULE_NAME_EDEFAULT.equals(moduleName);
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
		result.append(" (location: "); //$NON-NLS-1$
		result.append(location);
		result.append(", moduleName: "); //$NON-NLS-1$
		result.append(moduleName);
		result.append(')');
		return result.toString();
	}

} //IhsModuleImpl
