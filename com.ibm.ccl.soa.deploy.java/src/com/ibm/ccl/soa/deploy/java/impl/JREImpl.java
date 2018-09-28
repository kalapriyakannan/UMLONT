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
import com.ibm.ccl.soa.deploy.java.JRE;
import com.ibm.ccl.soa.deploy.java.JREEdition;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JavaPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JRE</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JREImpl#getJreEdition <em>Jre Edition</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JREImpl#getJreVersion <em>Jre Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JREImpl#getOtherValue <em>Other Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JREImpl extends CapabilityImpl implements JRE {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getJreEdition() <em>Jre Edition</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJreEdition()
	 * @generated
	 * @ordered
	 */
	protected static final JREEdition JRE_EDITION_EDEFAULT = JREEdition.STANDARD_LITERAL;

	/**
	 * The cached value of the '{@link #getJreEdition() <em>Jre Edition</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJreEdition()
	 * @generated
	 * @ordered
	 */
	protected JREEdition jreEdition = JRE_EDITION_EDEFAULT;

	/**
	 * This is true if the Jre Edition attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jreEditionESet;

	/**
	 * The default value of the '{@link #getJreVersion() <em>Jre Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJreVersion()
	 * @generated
	 * @ordered
	 */
	protected static final JREVersion JRE_VERSION_EDEFAULT = JREVersion._12_LITERAL;

	/**
	 * The cached value of the '{@link #getJreVersion() <em>Jre Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJreVersion()
	 * @generated
	 * @ordered
	 */
	protected JREVersion jreVersion = JRE_VERSION_EDEFAULT;

	/**
	 * This is true if the Jre Version attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jreVersionESet;

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
	protected JREImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JRE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREEdition getJreEdition() {
		return jreEdition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJreEdition(JREEdition newJreEdition) {
		JREEdition oldJreEdition = jreEdition;
		jreEdition = newJreEdition == null ? JRE_EDITION_EDEFAULT : newJreEdition;
		boolean oldJreEditionESet = jreEditionESet;
		jreEditionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JRE__JRE_EDITION, oldJreEdition, jreEdition, !oldJreEditionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJreEdition() {
		JREEdition oldJreEdition = jreEdition;
		boolean oldJreEditionESet = jreEditionESet;
		jreEdition = JRE_EDITION_EDEFAULT;
		jreEditionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JRE__JRE_EDITION, oldJreEdition, JRE_EDITION_EDEFAULT, oldJreEditionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJreEdition() {
		return jreEditionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREVersion getJreVersion() {
		return jreVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJreVersion(JREVersion newJreVersion) {
		JREVersion oldJreVersion = jreVersion;
		jreVersion = newJreVersion == null ? JRE_VERSION_EDEFAULT : newJreVersion;
		boolean oldJreVersionESet = jreVersionESet;
		jreVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JRE__JRE_VERSION, oldJreVersion, jreVersion, !oldJreVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJreVersion() {
		JREVersion oldJreVersion = jreVersion;
		boolean oldJreVersionESet = jreVersionESet;
		jreVersion = JRE_VERSION_EDEFAULT;
		jreVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JRE__JRE_VERSION, oldJreVersion, JRE_VERSION_EDEFAULT, oldJreVersionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJreVersion() {
		return jreVersionESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JRE__OTHER_VALUE, oldOtherValue, otherValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JRE__JRE_EDITION:
				return getJreEdition();
			case JavaPackage.JRE__JRE_VERSION:
				return getJreVersion();
			case JavaPackage.JRE__OTHER_VALUE:
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
			case JavaPackage.JRE__JRE_EDITION:
				setJreEdition((JREEdition)newValue);
				return;
			case JavaPackage.JRE__JRE_VERSION:
				setJreVersion((JREVersion)newValue);
				return;
			case JavaPackage.JRE__OTHER_VALUE:
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
			case JavaPackage.JRE__JRE_EDITION:
				unsetJreEdition();
				return;
			case JavaPackage.JRE__JRE_VERSION:
				unsetJreVersion();
				return;
			case JavaPackage.JRE__OTHER_VALUE:
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
			case JavaPackage.JRE__JRE_EDITION:
				return isSetJreEdition();
			case JavaPackage.JRE__JRE_VERSION:
				return isSetJreVersion();
			case JavaPackage.JRE__OTHER_VALUE:
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
		result.append(" (jreEdition: "); //$NON-NLS-1$
		if (jreEditionESet) result.append(jreEdition); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", jreVersion: "); //$NON-NLS-1$
		if (jreVersionESet) result.append(jreVersion); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", otherValue: "); //$NON-NLS-1$
		result.append(otherValue);
		result.append(')');
		return result.toString();
	}

} //JREImpl
