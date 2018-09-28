/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationRedundancyConstraintImpl.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Communication Redundancy Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationRedundancyConstraintImpl#getRedundancy <em>Redundancy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationRedundancyConstraintImpl extends CommunicationChildConstraintImpl
		implements CommunicationRedundancyConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected static final int REDUNDANCY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getRedundancy() <em>Redundancy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected int redundancy = REDUNDANCY_EDEFAULT;

	/**
	 * This is true if the Redundancy attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean redundancyESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationRedundancyConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.COMMUNICATION_REDUNDANCY_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getRedundancy() {
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(int newRedundancy) {
		int oldRedundancy = redundancy;
		redundancy = newRedundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY, oldRedundancy, redundancy, !oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRedundancy() {
		int oldRedundancy = redundancy;
		boolean oldRedundancyESet = redundancyESet;
		redundancy = REDUNDANCY_EDEFAULT;
		redundancyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY, oldRedundancy, REDUNDANCY_EDEFAULT, oldRedundancyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRedundancy() {
		return redundancyESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY:
				return new Integer(getRedundancy());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY:
				setRedundancy(((Integer)newValue).intValue());
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
			case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY:
				unsetRedundancy();
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
			case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY:
				return isSetRedundancy();
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
		result.append(" (redundancy: "); //$NON-NLS-1$
		if (redundancyESet) result.append(redundancy); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CommunicationRedundancyConstraintImpl
