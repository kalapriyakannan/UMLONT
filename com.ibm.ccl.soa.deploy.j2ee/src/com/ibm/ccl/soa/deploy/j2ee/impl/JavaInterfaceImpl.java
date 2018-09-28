/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.JavaInterfaceImpl#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaInterfaceImpl extends InterfaceImpl implements JavaInterface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getInterface() <em>Interface</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected String interface_ = INTERFACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.JAVA_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(String newInterface) {
		String oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.JAVA_INTERFACE__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.JAVA_INTERFACE__INTERFACE:
			return getInterface();
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
		case J2eePackage.JAVA_INTERFACE__INTERFACE:
			setInterface((String) newValue);
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
		case J2eePackage.JAVA_INTERFACE__INTERFACE:
			setInterface(INTERFACE_EDEFAULT);
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
		case J2eePackage.JAVA_INTERFACE__INTERFACE:
			return INTERFACE_EDEFAULT == null ? interface_ != null : !INTERFACE_EDEFAULT
					.equals(interface_);
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
		result.append(" (interface: "); //$NON-NLS-1$
		result.append(interface_);
		result.append(')');
		return result.toString();
	}

	public boolean isFastEquivalencyCheck(Interface anotherInterface) {
		if (anotherInterface != null && anotherInterface instanceof JavaInterface) {
			String qualifiedName = getInterface();
			String anotherQualifiedName = ((JavaInterface) anotherInterface).getInterface();
			if (qualifiedName == null && anotherQualifiedName == null) {
				return true;
			}
			if ((qualifiedName != null && anotherQualifiedName == null)
					|| (qualifiedName == null && anotherQualifiedName != null)) {
				return false;
			}
			return qualifiedName.equals(anotherQualifiedName);
		}
		return false;
	}

	public String getDisplayString() {
		return getInterface();
	}

} //JavaInterfaceImpl
