/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationPortConstraintImpl.java,v 1.3 2008/04/20 23:12:16 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Communication Port Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl#isIsTarget <em>Is Target</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationPortConstraintImpl extends CommunicationChildConstraintImpl implements
		CommunicationPortConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isIsTarget() <em>Is Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTarget()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TARGET_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsTarget() <em>Is Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTarget()
	 * @generated
	 * @ordered
	 */
	protected boolean isTarget = IS_TARGET_EDEFAULT;

	/**
	 * This is true if the Is Target attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isTargetESet;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

	/**
	 * This is true if the Port attribute has been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean portESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationPortConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.COMMUNICATION_PORT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTarget() {
		return isTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTarget(boolean newIsTarget) {
		boolean oldIsTarget = isTarget;
		isTarget = newIsTarget;
		boolean oldIsTargetESet = isTargetESet;
		isTargetESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET, oldIsTarget, isTarget, !oldIsTargetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsTarget() {
		boolean oldIsTarget = isTarget;
		boolean oldIsTargetESet = isTargetESet;
		isTarget = IS_TARGET_EDEFAULT;
		isTargetESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET, oldIsTarget, IS_TARGET_EDEFAULT, oldIsTargetESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsTarget() {
		return isTargetESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		boolean oldPortESet = portESet;
		portESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT, oldPort, port, !oldPortESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPort() {
		int oldPort = port;
		boolean oldPortESet = portESet;
		port = PORT_EDEFAULT;
		portESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT, oldPort, PORT_EDEFAULT, oldPortESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPort() {
		return portESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET:
				return isIsTarget() ? Boolean.TRUE : Boolean.FALSE;
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT:
				return new Integer(getPort());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET:
				setIsTarget(((Boolean)newValue).booleanValue());
				return;
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT:
				setPort(((Integer)newValue).intValue());
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
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET:
				unsetIsTarget();
				return;
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT:
				unsetPort();
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
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__IS_TARGET:
				return isSetIsTarget();
			case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT__PORT:
				return isSetPort();
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
		result.append(" (isTarget: "); //$NON-NLS-1$
		if (isTargetESet) result.append(isTarget); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", port: "); //$NON-NLS-1$
		if (portESet) result.append(port); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CommunicationPortConstraintImpl
