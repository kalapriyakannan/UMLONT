/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows Local Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl#getDescription1 <em>Description1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl#getGroupSid <em>Group Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsLocalGroupImpl extends UserGroupImpl implements WindowsLocalGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDescription1() <em>Description1</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription1() <em>Description1</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription1()
	 * @generated
	 * @ordered
	 */
	protected String description1 = DESCRIPTION1_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupSid() <em>Group Sid</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupSid()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_SID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupSid() <em>Group Sid</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGroupSid()
	 * @generated
	 * @ordered
	 */
	protected String groupSid = GROUP_SID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsLocalGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.WINDOWS_LOCAL_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription1() {
		return description1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription1(String newDescription1) {
		String oldDescription1 = description1;
		description1 = newDescription1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_GROUP__DESCRIPTION1, oldDescription1, description1));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupSid() {
		return groupSid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupSid(String newGroupSid) {
		String oldGroupSid = groupSid;
		groupSid = newGroupSid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.WINDOWS_LOCAL_GROUP__GROUP_SID, oldGroupSid, groupSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_GROUP__DESCRIPTION1:
			return getDescription1();
		case OsPackage.WINDOWS_LOCAL_GROUP__GROUP_SID:
			return getGroupSid();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_GROUP__DESCRIPTION1:
			setDescription1((String) newValue);
			return;
		case OsPackage.WINDOWS_LOCAL_GROUP__GROUP_SID:
			setGroupSid((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_GROUP__DESCRIPTION1:
			setDescription1(DESCRIPTION1_EDEFAULT);
			return;
		case OsPackage.WINDOWS_LOCAL_GROUP__GROUP_SID:
			setGroupSid(GROUP_SID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.WINDOWS_LOCAL_GROUP__DESCRIPTION1:
			return DESCRIPTION1_EDEFAULT == null ? description1 != null : !DESCRIPTION1_EDEFAULT
					.equals(description1);
		case OsPackage.WINDOWS_LOCAL_GROUP__GROUP_SID:
			return GROUP_SID_EDEFAULT == null ? groupSid != null : !GROUP_SID_EDEFAULT
					.equals(groupSid);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description1: "); //$NON-NLS-1$
		result.append(description1);
		result.append(", groupSid: "); //$NON-NLS-1$
		result.append(groupSid);
		result.append(')');
		return result.toString();
	}

} //WindowsLocalGroupImpl
