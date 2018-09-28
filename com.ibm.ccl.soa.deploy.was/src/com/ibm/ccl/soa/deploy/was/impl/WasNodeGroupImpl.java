/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeGroupImpl#isIsDefaultType <em>Is Default Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasNodeGroupImpl#getNodeGroupName <em>Node Group Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasNodeGroupImpl extends CapabilityImpl implements WasNodeGroup {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isIsDefaultType() <em>Is Default Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsDefaultType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFAULT_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefaultType() <em>Is Default Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsDefaultType()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefaultType = IS_DEFAULT_TYPE_EDEFAULT;

	/**
	 * This is true if the Is Default Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isDefaultTypeESet;

	/**
	 * The default value of the '{@link #getNodeGroupName() <em>Node Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeGroupName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_GROUP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeGroupName() <em>Node Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeGroupName()
	 * @generated
	 * @ordered
	 */
	protected String nodeGroupName = NODE_GROUP_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasNodeGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_NODE_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDefaultType() {
		return isDefaultType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDefaultType(boolean newIsDefaultType) {
		boolean oldIsDefaultType = isDefaultType;
		isDefaultType = newIsDefaultType;
		boolean oldIsDefaultTypeESet = isDefaultTypeESet;
		isDefaultTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE, oldIsDefaultType, isDefaultType, !oldIsDefaultTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsDefaultType() {
		boolean oldIsDefaultType = isDefaultType;
		boolean oldIsDefaultTypeESet = isDefaultTypeESet;
		isDefaultType = IS_DEFAULT_TYPE_EDEFAULT;
		isDefaultTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE, oldIsDefaultType, IS_DEFAULT_TYPE_EDEFAULT, oldIsDefaultTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsDefaultType() {
		return isDefaultTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeGroupName() {
		return nodeGroupName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeGroupName(String newNodeGroupName) {
		String oldNodeGroupName = nodeGroupName;
		nodeGroupName = newNodeGroupName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_NODE_GROUP__NODE_GROUP_NAME, oldNodeGroupName, nodeGroupName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE:
				return isIsDefaultType() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_NODE_GROUP__NODE_GROUP_NAME:
				return getNodeGroupName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE:
				setIsDefaultType(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_NODE_GROUP__NODE_GROUP_NAME:
				setNodeGroupName((String)newValue);
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
			case WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE:
				unsetIsDefaultType();
				return;
			case WasPackage.WAS_NODE_GROUP__NODE_GROUP_NAME:
				setNodeGroupName(NODE_GROUP_NAME_EDEFAULT);
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
			case WasPackage.WAS_NODE_GROUP__IS_DEFAULT_TYPE:
				return isSetIsDefaultType();
			case WasPackage.WAS_NODE_GROUP__NODE_GROUP_NAME:
				return NODE_GROUP_NAME_EDEFAULT == null ? nodeGroupName != null : !NODE_GROUP_NAME_EDEFAULT.equals(nodeGroupName);
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
		result.append(" (isDefaultType: "); //$NON-NLS-1$
		if (isDefaultTypeESet) result.append(isDefaultType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", nodeGroupName: "); //$NON-NLS-1$
		result.append(nodeGroupName);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(WasPackage.eINSTANCE
			.getWasNodeGroup_NodeGroupName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasNodeGroupImpl
