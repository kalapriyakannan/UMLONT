/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: SynchronousCommunicationConstraintImpl.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronous Communication Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SynchronousCommunicationConstraintImpl#isSynchronous <em>Synchronous</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronousCommunicationConstraintImpl extends ConstraintImpl implements SynchronousCommunicationConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isSynchronous() <em>Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronous()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNCHRONOUS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSynchronous() <em>Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronous()
	 * @generated
	 * @ordered
	 */
	protected boolean synchronous = SYNCHRONOUS_EDEFAULT;

	/**
	 * This is true if the Synchronous attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean synchronousESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronousCommunicationConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.SYNCHRONOUS_COMMUNICATION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSynchronous() {
		return synchronous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronous(boolean newSynchronous) {
		boolean oldSynchronous = synchronous;
		synchronous = newSynchronous;
		boolean oldSynchronousESet = synchronousESet;
		synchronousESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS, oldSynchronous, synchronous, !oldSynchronousESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSynchronous() {
		boolean oldSynchronous = synchronous;
		boolean oldSynchronousESet = synchronousESet;
		synchronous = SYNCHRONOUS_EDEFAULT;
		synchronousESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS, oldSynchronous, SYNCHRONOUS_EDEFAULT, oldSynchronousESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSynchronous() {
		return synchronousESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS:
				return isSynchronous() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS:
				setSynchronous(((Boolean)newValue).booleanValue());
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
			case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS:
				unsetSynchronous();
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
			case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS:
				return isSetSynchronous();
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
		result.append(" (synchronous: "); //$NON-NLS-1$
		if (synchronousESet) result.append(synchronous); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //SynchronousCommunicationConstraintImpl
