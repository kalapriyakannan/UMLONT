/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl#getDmoPath <em>Dmo Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingEntryImpl extends EObjectImpl implements BindingEntry {
	/**
	 * The default value of the '{@link #getDmoPath() <em>Dmo Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DMO_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDmoPath() <em>Dmo Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDmoPath()
	 * @generated
	 * @ordered
	 */
	protected String dmoPath = DMO_PATH_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LocationPackage.Literals.BINDING_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDmoPath() {
		return dmoPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDmoPath(String newDmoPath) {
		String oldDmoPath = dmoPath;
		dmoPath = newDmoPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.BINDING_ENTRY__DMO_PATH, oldDmoPath, dmoPath));
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
			eNotify(new ENotificationImpl(this, Notification.SET, LocationPackage.BINDING_ENTRY__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.BINDING_ENTRY__DMO_PATH:
				return getDmoPath();
			case LocationPackage.BINDING_ENTRY__LOCATION:
				return getLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LocationPackage.BINDING_ENTRY__DMO_PATH:
				setDmoPath((String)newValue);
				return;
			case LocationPackage.BINDING_ENTRY__LOCATION:
				setLocation((String)newValue);
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
			case LocationPackage.BINDING_ENTRY__DMO_PATH:
				setDmoPath(DMO_PATH_EDEFAULT);
				return;
			case LocationPackage.BINDING_ENTRY__LOCATION:
				setLocation(LOCATION_EDEFAULT);
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
			case LocationPackage.BINDING_ENTRY__DMO_PATH:
				return DMO_PATH_EDEFAULT == null ? dmoPath != null : !DMO_PATH_EDEFAULT.equals(dmoPath);
			case LocationPackage.BINDING_ENTRY__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(" (dmoPath: "); //$NON-NLS-1$
		result.append(dmoPath);
		result.append(", location: "); //$NON-NLS-1$
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //BindingEntryImpl
