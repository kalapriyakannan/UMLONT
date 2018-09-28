/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl#getImplementationClassName <em>Implementation Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl#getNativepath <em>Nativepath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl#getProviderType <em>Provider Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JdbcProviderImpl extends CapabilityImpl implements JdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected String classpath = CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected String implementationClassName = IMPLEMENTATION_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNativepath() <em>Nativepath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNativepath()
	 * @generated
	 * @ordered
	 */
	protected static final String NATIVEPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNativepath() <em>Nativepath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNativepath()
	 * @generated
	 * @ordered
	 */
	protected String nativepath = NATIVEPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderName() <em>Provider Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderName() <em>Provider Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderName()
	 * @generated
	 * @ordered
	 */
	protected String providerName = PROVIDER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderType() <em>Provider Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderType()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderType() <em>Provider Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderType()
	 * @generated
	 * @ordered
	 */
	protected String providerType = PROVIDER_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JdbcProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JDBC_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClasspath() {
		return classpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClasspath(String newClasspath) {
		String oldClasspath = classpath;
		classpath = newClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDBC_PROVIDER__CLASSPATH, oldClasspath, classpath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationClassName() {
		return implementationClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClassName(String newImplementationClassName) {
		String oldImplementationClassName = implementationClassName;
		implementationClassName = newImplementationClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME, oldImplementationClassName, implementationClassName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNativepath() {
		return nativepath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativepath(String newNativepath) {
		String oldNativepath = nativepath;
		nativepath = newNativepath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDBC_PROVIDER__NATIVEPATH, oldNativepath, nativepath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderName(String newProviderName) {
		String oldProviderName = providerName;
		providerName = newProviderName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDBC_PROVIDER__PROVIDER_NAME, oldProviderName, providerName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderType() {
		return providerType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderType(String newProviderType) {
		String oldProviderType = providerType;
		providerType = newProviderType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JDBC_PROVIDER__PROVIDER_TYPE, oldProviderType, providerType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JDBC_PROVIDER__CLASSPATH:
				return getClasspath();
			case JavaPackage.JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME:
				return getImplementationClassName();
			case JavaPackage.JDBC_PROVIDER__NATIVEPATH:
				return getNativepath();
			case JavaPackage.JDBC_PROVIDER__PROVIDER_NAME:
				return getProviderName();
			case JavaPackage.JDBC_PROVIDER__PROVIDER_TYPE:
				return getProviderType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.JDBC_PROVIDER__CLASSPATH:
				setClasspath((String)newValue);
				return;
			case JavaPackage.JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName((String)newValue);
				return;
			case JavaPackage.JDBC_PROVIDER__NATIVEPATH:
				setNativepath((String)newValue);
				return;
			case JavaPackage.JDBC_PROVIDER__PROVIDER_NAME:
				setProviderName((String)newValue);
				return;
			case JavaPackage.JDBC_PROVIDER__PROVIDER_TYPE:
				setProviderType((String)newValue);
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
			case JavaPackage.JDBC_PROVIDER__CLASSPATH:
				setClasspath(CLASSPATH_EDEFAULT);
				return;
			case JavaPackage.JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName(IMPLEMENTATION_CLASS_NAME_EDEFAULT);
				return;
			case JavaPackage.JDBC_PROVIDER__NATIVEPATH:
				setNativepath(NATIVEPATH_EDEFAULT);
				return;
			case JavaPackage.JDBC_PROVIDER__PROVIDER_NAME:
				setProviderName(PROVIDER_NAME_EDEFAULT);
				return;
			case JavaPackage.JDBC_PROVIDER__PROVIDER_TYPE:
				setProviderType(PROVIDER_TYPE_EDEFAULT);
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
			case JavaPackage.JDBC_PROVIDER__CLASSPATH:
				return CLASSPATH_EDEFAULT == null ? classpath != null : !CLASSPATH_EDEFAULT.equals(classpath);
			case JavaPackage.JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME:
				return IMPLEMENTATION_CLASS_NAME_EDEFAULT == null ? implementationClassName != null : !IMPLEMENTATION_CLASS_NAME_EDEFAULT.equals(implementationClassName);
			case JavaPackage.JDBC_PROVIDER__NATIVEPATH:
				return NATIVEPATH_EDEFAULT == null ? nativepath != null : !NATIVEPATH_EDEFAULT.equals(nativepath);
			case JavaPackage.JDBC_PROVIDER__PROVIDER_NAME:
				return PROVIDER_NAME_EDEFAULT == null ? providerName != null : !PROVIDER_NAME_EDEFAULT.equals(providerName);
			case JavaPackage.JDBC_PROVIDER__PROVIDER_TYPE:
				return PROVIDER_TYPE_EDEFAULT == null ? providerType != null : !PROVIDER_TYPE_EDEFAULT.equals(providerType);
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
		result.append(" (classpath: "); //$NON-NLS-1$
		result.append(classpath);
		result.append(", implementationClassName: "); //$NON-NLS-1$
		result.append(implementationClassName);
		result.append(", nativepath: "); //$NON-NLS-1$
		result.append(nativepath);
		result.append(", providerName: "); //$NON-NLS-1$
		result.append(providerName);
		result.append(", providerType: "); //$NON-NLS-1$
		result.append(providerType);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(JavaPackage.eINSTANCE
			.getJdbcProvider_ProviderName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //JdbcProviderImpl
