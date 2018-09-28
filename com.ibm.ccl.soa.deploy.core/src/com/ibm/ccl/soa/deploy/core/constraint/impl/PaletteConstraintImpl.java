/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: PaletteConstraintImpl.java,v 1.2 2008/04/23 19:19:59 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint;

import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Palette Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.PaletteConstraintImpl#getResourceTypeId <em>Resource Type Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaletteConstraintImpl extends ConstraintImpl implements PaletteConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getResourceTypeId() <em>Resource Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_TYPE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getResourceTypeId() <em>Resource Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceTypeId()
	 * @generated
	 * @ordered
	 */
	protected String resourceTypeId = RESOURCE_TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PaletteConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.PALETTE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceTypeId() {
		return resourceTypeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceTypeId(String newResourceTypeId) {
		String oldResourceTypeId = resourceTypeId;
		resourceTypeId = newResourceTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.PALETTE_CONSTRAINT__RESOURCE_TYPE_ID, oldResourceTypeId, resourceTypeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.PALETTE_CONSTRAINT__RESOURCE_TYPE_ID:
				return getResourceTypeId();
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
			case ConstraintPackage.PALETTE_CONSTRAINT__RESOURCE_TYPE_ID:
				setResourceTypeId((String)newValue);
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
			case ConstraintPackage.PALETTE_CONSTRAINT__RESOURCE_TYPE_ID:
				setResourceTypeId(RESOURCE_TYPE_ID_EDEFAULT);
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
			case ConstraintPackage.PALETTE_CONSTRAINT__RESOURCE_TYPE_ID:
				return RESOURCE_TYPE_ID_EDEFAULT == null ? resourceTypeId != null : !RESOURCE_TYPE_ID_EDEFAULT.equals(resourceTypeId);
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
		result.append(" (resourceTypeId: "); //$NON-NLS-1$
		result.append(resourceTypeId);
		result.append(')');
		return result.toString();
	}

} //PaletteConstraintImpl
