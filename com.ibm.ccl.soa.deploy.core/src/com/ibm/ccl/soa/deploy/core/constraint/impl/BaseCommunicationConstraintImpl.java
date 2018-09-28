/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: BaseCommunicationConstraintImpl.java,v 1.3 2008/04/20 23:12:16 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Communication Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.BaseCommunicationConstraintImpl#isRespectLinkDirection <em>Respect Link Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseCommunicationConstraintImpl extends ConstraintImpl implements BaseCommunicationConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isRespectLinkDirection() <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRespectLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESPECT_LINK_DIRECTION_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isRespectLinkDirection() <em>Respect Link Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRespectLinkDirection()
	 * @generated
	 * @ordered
	 */
	protected boolean respectLinkDirection = RESPECT_LINK_DIRECTION_EDEFAULT;
	/**
	 * This is true if the Respect Link Direction attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean respectLinkDirectionESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseCommunicationConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.BASE_COMMUNICATION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRespectLinkDirection() {
		return respectLinkDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRespectLinkDirection(boolean newRespectLinkDirection) {
		boolean oldRespectLinkDirection = respectLinkDirection;
		respectLinkDirection = newRespectLinkDirection;
		boolean oldRespectLinkDirectionESet = respectLinkDirectionESet;
		respectLinkDirectionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION, oldRespectLinkDirection, respectLinkDirection, !oldRespectLinkDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRespectLinkDirection() {
		boolean oldRespectLinkDirection = respectLinkDirection;
		boolean oldRespectLinkDirectionESet = respectLinkDirectionESet;
		respectLinkDirection = RESPECT_LINK_DIRECTION_EDEFAULT;
		respectLinkDirectionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION, oldRespectLinkDirection, RESPECT_LINK_DIRECTION_EDEFAULT, oldRespectLinkDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRespectLinkDirection() {
		return respectLinkDirectionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				return isRespectLinkDirection() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				setRespectLinkDirection(((Boolean)newValue).booleanValue());
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
			case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				unsetRespectLinkDirection();
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
			case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION:
				return isSetRespectLinkDirection();
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
		result.append(" (respectLinkDirection: "); //$NON-NLS-1$
		if (respectLinkDirectionESet) result.append(respectLinkDirection); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //BaseCommunicationConstraintImpl
