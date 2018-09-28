/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Windows DB2 Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl#isDefaultInstance <em>Default Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl#getInstanceType <em>Instance Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowsDB2InstanceImpl extends DB2InstanceImpl implements WindowsDB2Instance {
	/**
	 * The default value of the '{@link #isDefaultInstance() <em>Default Instance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDefaultInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_INSTANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultInstance() <em>Default Instance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDefaultInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultInstance = DEFAULT_INSTANCE_EDEFAULT;

	/**
	 * This is true if the Default Instance attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultInstanceESet;

	/**
	 * The default value of the '{@link #getInstanceType() <em>Instance Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceType()
	 * @generated
	 * @ordered
	 */
	protected static final WindowsInstanceTypeType INSTANCE_TYPE_EDEFAULT = WindowsInstanceTypeType.CLIENT_LITERAL;

	/**
	 * The cached value of the '{@link #getInstanceType() <em>Instance Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstanceType()
	 * @generated
	 * @ordered
	 */
	protected WindowsInstanceTypeType instanceType = INSTANCE_TYPE_EDEFAULT;

	/**
	 * This is true if the Instance Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean instanceTypeESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowsDB2InstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.WINDOWS_DB2_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultInstance() {
		return defaultInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultInstance(boolean newDefaultInstance) {
		boolean oldDefaultInstance = defaultInstance;
		defaultInstance = newDefaultInstance;
		boolean oldDefaultInstanceESet = defaultInstanceESet;
		defaultInstanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE, oldDefaultInstance, defaultInstance, !oldDefaultInstanceESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultInstance() {
		boolean oldDefaultInstance = defaultInstance;
		boolean oldDefaultInstanceESet = defaultInstanceESet;
		defaultInstance = DEFAULT_INSTANCE_EDEFAULT;
		defaultInstanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE, oldDefaultInstance, DEFAULT_INSTANCE_EDEFAULT, oldDefaultInstanceESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultInstance() {
		return defaultInstanceESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsInstanceTypeType getInstanceType() {
		return instanceType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceType(WindowsInstanceTypeType newInstanceType) {
		WindowsInstanceTypeType oldInstanceType = instanceType;
		instanceType = newInstanceType == null ? INSTANCE_TYPE_EDEFAULT : newInstanceType;
		boolean oldInstanceTypeESet = instanceTypeESet;
		instanceTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE, oldInstanceType, instanceType, !oldInstanceTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInstanceType() {
		WindowsInstanceTypeType oldInstanceType = instanceType;
		boolean oldInstanceTypeESet = instanceTypeESet;
		instanceType = INSTANCE_TYPE_EDEFAULT;
		instanceTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE, oldInstanceType, INSTANCE_TYPE_EDEFAULT, oldInstanceTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInstanceType() {
		return instanceTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE:
				return isDefaultInstance() ? Boolean.TRUE : Boolean.FALSE;
			case Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE:
				return getInstanceType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE:
				setDefaultInstance(((Boolean)newValue).booleanValue());
				return;
			case Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE:
				setInstanceType((WindowsInstanceTypeType)newValue);
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
			case Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE:
				unsetDefaultInstance();
				return;
			case Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE:
				unsetInstanceType();
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
			case Db2Package.WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE:
				return isSetDefaultInstance();
			case Db2Package.WINDOWS_DB2_INSTANCE__INSTANCE_TYPE:
				return isSetInstanceType();
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
		result.append(" (defaultInstance: "); //$NON-NLS-1$
		if (defaultInstanceESet) result.append(defaultInstance); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", instanceType: "); //$NON-NLS-1$
		if (instanceTypeESet) result.append(instanceType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WindowsDB2InstanceImpl
