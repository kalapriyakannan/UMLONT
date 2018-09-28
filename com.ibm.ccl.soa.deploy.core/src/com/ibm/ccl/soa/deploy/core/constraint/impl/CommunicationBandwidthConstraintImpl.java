/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationBandwidthConstraintImpl.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Communication Bandwidth Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationBandwidthConstraintImpl#getBandwidth <em>Bandwidth</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationBandwidthConstraintImpl extends CommunicationChildConstraintImpl
		implements CommunicationBandwidthConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBandwidth() <em>Bandwidth</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBandwidth()
	 * @generated
	 * @ordered
	 */
	protected static final int BANDWIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBandwidth() <em>Bandwidth</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBandwidth()
	 * @generated
	 * @ordered
	 */
	protected int bandwidth = BANDWIDTH_EDEFAULT;

	/**
	 * This is true if the Bandwidth attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean bandwidthESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationBandwidthConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.COMMUNICATION_BANDWIDTH_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getBandwidth() {
		return bandwidth;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBandwidth(int newBandwidth) {
		int oldBandwidth = bandwidth;
		bandwidth = newBandwidth;
		boolean oldBandwidthESet = bandwidthESet;
		bandwidthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH, oldBandwidth, bandwidth, !oldBandwidthESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBandwidth() {
		int oldBandwidth = bandwidth;
		boolean oldBandwidthESet = bandwidthESet;
		bandwidth = BANDWIDTH_EDEFAULT;
		bandwidthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH, oldBandwidth, BANDWIDTH_EDEFAULT, oldBandwidthESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBandwidth() {
		return bandwidthESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH:
				return new Integer(getBandwidth());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH:
				setBandwidth(((Integer)newValue).intValue());
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
			case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH:
				unsetBandwidth();
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
			case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH:
				return isSetBandwidth();
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
		result.append(" (bandwidth: "); //$NON-NLS-1$
		if (bandwidthESet) result.append(bandwidth); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CommunicationBandwidthConstraintImpl
