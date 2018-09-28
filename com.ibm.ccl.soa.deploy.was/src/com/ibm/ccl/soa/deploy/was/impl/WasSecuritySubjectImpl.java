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

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Security Subject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecuritySubjectImpl#getAccessId <em>Access Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSecuritySubjectImpl#getSubjectName <em>Subject Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSecuritySubjectImpl extends CapabilityImpl implements WasSecuritySubject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAccessId() <em>Access Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAccessId()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCESS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessId() <em>Access Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAccessId()
	 * @generated
	 * @ordered
	 */
	protected String accessId = ACCESS_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubjectName() <em>Subject Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubjectName() <em>Subject Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubjectName()
	 * @generated
	 * @ordered
	 */
	protected String subjectName = SUBJECT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSecuritySubjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SECURITY_SUBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccessId() {
		return accessId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessId(String newAccessId) {
		String oldAccessId = accessId;
		accessId = newAccessId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY_SUBJECT__ACCESS_ID, oldAccessId, accessId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubjectName(String newSubjectName) {
		String oldSubjectName = subjectName;
		subjectName = newSubjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SECURITY_SUBJECT__SUBJECT_NAME, oldSubjectName, subjectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY_SUBJECT__ACCESS_ID:
				return getAccessId();
			case WasPackage.WAS_SECURITY_SUBJECT__SUBJECT_NAME:
				return getSubjectName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SECURITY_SUBJECT__ACCESS_ID:
				setAccessId((String)newValue);
				return;
			case WasPackage.WAS_SECURITY_SUBJECT__SUBJECT_NAME:
				setSubjectName((String)newValue);
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
			case WasPackage.WAS_SECURITY_SUBJECT__ACCESS_ID:
				setAccessId(ACCESS_ID_EDEFAULT);
				return;
			case WasPackage.WAS_SECURITY_SUBJECT__SUBJECT_NAME:
				setSubjectName(SUBJECT_NAME_EDEFAULT);
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
			case WasPackage.WAS_SECURITY_SUBJECT__ACCESS_ID:
				return ACCESS_ID_EDEFAULT == null ? accessId != null : !ACCESS_ID_EDEFAULT.equals(accessId);
			case WasPackage.WAS_SECURITY_SUBJECT__SUBJECT_NAME:
				return SUBJECT_NAME_EDEFAULT == null ? subjectName != null : !SUBJECT_NAME_EDEFAULT.equals(subjectName);
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
		result.append(" (accessId: "); //$NON-NLS-1$
		result.append(accessId);
		result.append(", subjectName: "); //$NON-NLS-1$
		result.append(subjectName);
		result.append(')');
		return result.toString();
	}

} //WasSecuritySubjectImpl
