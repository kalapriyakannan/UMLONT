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
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Redhat Linux Local Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalGroupImpl#getGroupSid <em>Group Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedhatLinuxLocalGroupImpl extends LinuxLocalGroupImpl implements RedhatLinuxLocalGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	protected RedhatLinuxLocalGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.REDHAT_LINUX_LOCAL_GROUP;
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
					OsPackage.REDHAT_LINUX_LOCAL_GROUP__GROUP_SID, oldGroupSid, groupSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.REDHAT_LINUX_LOCAL_GROUP__GROUP_SID:
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
		result.append(" (groupSid: "); //$NON-NLS-1$
		result.append(groupSid);
		result.append(')');
		return result.toString();
	}

} //RedhatLinuxLocalGroupImpl
