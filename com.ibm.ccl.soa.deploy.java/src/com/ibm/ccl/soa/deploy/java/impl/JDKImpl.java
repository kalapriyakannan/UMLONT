/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.java.JDK;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JavaPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JDK</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JDKImpl#getJdkVersion <em>Jdk Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JDKImpl#getOtherValue <em>Other Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDKImpl extends CapabilityImpl implements JDK {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getJdkVersion() <em>Jdk Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdkVersion()
	 * @generated
	 * @ordered
	 */
	protected static final JREVersion JDK_VERSION_EDEFAULT = JREVersion._12_LITERAL;

	/**
	 * The cached value of the '{@link #getJdkVersion() <em>Jdk Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdkVersion()
	 * @generated
	 * @ordered
	 */
	protected JREVersion jdkVersion = JDK_VERSION_EDEFAULT;

	/**
	 * This is true if the Jdk Version attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jdkVersionESet;

	/**
	 * The default value of the '{@link #getOtherValue() <em>Other Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOtherValue()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherValue() <em>Other Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOtherValue()
	 * @generated
	 * @ordered
	 */
	protected String otherValue = OTHER_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JDKImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JDK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREVersion getJdkVersion() {
		return jdkVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJdkVersion(JREVersion newJdkVersion) {
		JREVersion oldJdkVersion = jdkVersion;
		jdkVersion = newJdkVersion == null ? JDK_VERSION_EDEFAULT : newJdkVersion;
		boolean oldJdkVersionESet = jdkVersionESet;
		jdkVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDK__JDK_VERSION, oldJdkVersion, jdkVersion, !oldJdkVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJdkVersion() {
		JREVersion oldJdkVersion = jdkVersion;
		boolean oldJdkVersionESet = jdkVersionESet;
		jdkVersion = JDK_VERSION_EDEFAULT;
		jdkVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JDK__JDK_VERSION, oldJdkVersion, JDK_VERSION_EDEFAULT, oldJdkVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJdkVersion() {
		return jdkVersionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOtherValue() {
		return otherValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherValue(String newOtherValue) {
		String oldOtherValue = otherValue;
		otherValue = newOtherValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDK__OTHER_VALUE, oldOtherValue, otherValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JDK__JDK_VERSION:
				return getJdkVersion();
			case JavaPackage.JDK__OTHER_VALUE:
				return getOtherValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.JDK__JDK_VERSION:
				setJdkVersion((JREVersion)newValue);
				return;
			case JavaPackage.JDK__OTHER_VALUE:
				setOtherValue((String)newValue);
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
			case JavaPackage.JDK__JDK_VERSION:
				unsetJdkVersion();
				return;
			case JavaPackage.JDK__OTHER_VALUE:
				setOtherValue(OTHER_VALUE_EDEFAULT);
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
			case JavaPackage.JDK__JDK_VERSION:
				return isSetJdkVersion();
			case JavaPackage.JDK__OTHER_VALUE:
				return OTHER_VALUE_EDEFAULT == null ? otherValue != null : !OTHER_VALUE_EDEFAULT.equals(otherValue);
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
		result.append(" (jdkVersion: "); //$NON-NLS-1$
		if (jdkVersionESet) result.append(jdkVersion); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", otherValue: "); //$NON-NLS-1$
		result.append(otherValue);
		result.append(')');
		return result.toString();
	}

} //JDKImpl
