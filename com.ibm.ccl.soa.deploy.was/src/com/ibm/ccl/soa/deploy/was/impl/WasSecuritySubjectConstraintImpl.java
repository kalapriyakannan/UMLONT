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

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Security Subject Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecuritySubjectConstraintImpl#getWasSecuritySubject <em>Was Security Subject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSecuritySubjectConstraintImpl extends WasJ2EEConstraintImpl implements
		WasSecuritySubjectConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getWasSecuritySubject() <em>Was Security Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWasSecuritySubject()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_SECURITY_SUBJECT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWasSecuritySubject() <em>Was Security Subject</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWasSecuritySubject()
	 * @generated
	 * @ordered
	 */
	protected String wasSecuritySubject = WAS_SECURITY_SUBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSecuritySubjectConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasSecuritySubject() {
		return wasSecuritySubject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasSecuritySubject(String newWasSecuritySubject) {
		String oldWasSecuritySubject = wasSecuritySubject;
		wasSecuritySubject = newWasSecuritySubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT, oldWasSecuritySubject, wasSecuritySubject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT:
				return getWasSecuritySubject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT:
				setWasSecuritySubject((String)newValue);
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
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT:
				setWasSecuritySubject(WAS_SECURITY_SUBJECT_EDEFAULT);
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
			case WasPackage.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT:
				return WAS_SECURITY_SUBJECT_EDEFAULT == null ? wasSecuritySubject != null : !WAS_SECURITY_SUBJECT_EDEFAULT.equals(wasSecuritySubject);
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
		result.append(" (wasSecuritySubject: "); //$NON-NLS-1$
		result.append(wasSecuritySubject);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	//private static final WasSecuritySubjectConstraintValidator validator = new WasSecuritySubjectConstraintValidator();
	/**
	 * @generated NOT
	 */
	// AT 5/31/07 don't need it anymore
	//public IStatus validate(DeployModelObject context, IProgressMonitor monitor) {
	//return validator.validate(this, context, monitor);
	//}
} //WasSecuritySubjectConstraintImpl
