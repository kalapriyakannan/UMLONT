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

import com.ibm.ccl.soa.deploy.os.AIXLocalGroup;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>AIX Local Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl#getGroupDescription <em>Group Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl#getGroupSid <em>Group Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AIXLocalGroupImpl extends UserGroupImpl implements AIXLocalGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getGroupDescription() <em>Group Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGroupDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupDescription() <em>Group Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGroupDescription()
	 * @generated
	 * @ordered
	 */
	protected String groupDescription = GROUP_DESCRIPTION_EDEFAULT;

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
	protected AIXLocalGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.AIX_LOCAL_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupDescription() {
		return groupDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupDescription(String newGroupDescription) {
		String oldGroupDescription = groupDescription;
		groupDescription = newGroupDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.AIX_LOCAL_GROUP__GROUP_DESCRIPTION, oldGroupDescription, groupDescription));
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
					OsPackage.AIX_LOCAL_GROUP__GROUP_SID, oldGroupSid, groupSid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.AIX_LOCAL_GROUP__GROUP_DESCRIPTION:
			return getGroupDescription();
		case OsPackage.AIX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.AIX_LOCAL_GROUP__GROUP_DESCRIPTION:
			setGroupDescription((String) newValue);
			return;
		case OsPackage.AIX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.AIX_LOCAL_GROUP__GROUP_DESCRIPTION:
			setGroupDescription(GROUP_DESCRIPTION_EDEFAULT);
			return;
		case OsPackage.AIX_LOCAL_GROUP__GROUP_SID:
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
		case OsPackage.AIX_LOCAL_GROUP__GROUP_DESCRIPTION:
			return GROUP_DESCRIPTION_EDEFAULT == null ? groupDescription != null
					: !GROUP_DESCRIPTION_EDEFAULT.equals(groupDescription);
		case OsPackage.AIX_LOCAL_GROUP__GROUP_SID:
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
		result.append(" (groupDescription: "); //$NON-NLS-1$
		result.append(groupDescription);
		result.append(", groupSid: "); //$NON-NLS-1$
		result.append(groupSid);
		result.append(')');
		return result.toString();
	}

} //AIXLocalGroupImpl
