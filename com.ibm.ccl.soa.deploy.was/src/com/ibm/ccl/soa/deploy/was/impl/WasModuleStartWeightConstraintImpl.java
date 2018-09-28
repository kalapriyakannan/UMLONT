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

import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Start Weight Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasModuleStartWeightConstraintImpl#getStartingWeight <em>Starting Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasModuleStartWeightConstraintImpl extends WasJ2EEConstraintImpl implements WasModuleStartWeightConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getStartingWeight() <em>Starting Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int STARTING_WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartingWeight() <em>Starting Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingWeight()
	 * @generated
	 * @ordered
	 */
	protected int startingWeight = STARTING_WEIGHT_EDEFAULT;

	/**
	 * This is true if the Starting Weight attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startingWeightESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WasModuleStartWeightConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartingWeight() {
		return startingWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingWeight(int newStartingWeight) {
		int oldStartingWeight = startingWeight;
		startingWeight = newStartingWeight;
		boolean oldStartingWeightESet = startingWeightESet;
		startingWeightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT, oldStartingWeight, startingWeight, !oldStartingWeightESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartingWeight() {
		int oldStartingWeight = startingWeight;
		boolean oldStartingWeightESet = startingWeightESet;
		startingWeight = STARTING_WEIGHT_EDEFAULT;
		startingWeightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT, oldStartingWeight, STARTING_WEIGHT_EDEFAULT, oldStartingWeightESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartingWeight() {
		return startingWeightESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT:
				return new Integer(getStartingWeight());
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
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT:
				setStartingWeight(((Integer)newValue).intValue());
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
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT:
				unsetStartingWeight();
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
			case WasPackage.WAS_MODULE_START_WEIGHT_CONSTRAINT__STARTING_WEIGHT:
				return isSetStartingWeight();
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
		result.append(" (startingWeight: "); //$NON-NLS-1$
		if (startingWeightESet) result.append(startingWeight); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasModuleStartWeightConstraintImpl
