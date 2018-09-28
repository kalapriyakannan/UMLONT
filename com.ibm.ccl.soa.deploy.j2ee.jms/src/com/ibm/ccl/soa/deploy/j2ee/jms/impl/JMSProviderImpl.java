/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getNativePath <em>Native Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl#getProviderVersion <em>Provider Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JMSProviderImpl extends CapabilityImpl implements JMSProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getClassPath() <em>Class Path</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassPath()
	 * @generated
	 * @ordered
	 */
	protected EList classPath;

	/**
	 * The cached value of the '{@link #getNativePath() <em>Native Path</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNativePath()
	 * @generated
	 * @ordered
	 */
	protected EList nativePath;

	/**
	 * The default value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_CONTEXT_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected String initialContextFactory = INITIAL_CONTEXT_FACTORY_EDEFAULT;

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
	 * The default value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected String providerURL = PROVIDER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderVersion() <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProviderVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderVersion() <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProviderVersion()
	 * @generated
	 * @ordered
	 */
	protected String providerVersion = PROVIDER_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JMSProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JmsPackage.Literals.JMS_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getClassPath() {
		if (classPath == null) {
			classPath = new EDataTypeEList(String.class, this, JmsPackage.JMS_PROVIDER__CLASS_PATH);
		}
		return classPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialContextFactory() {
		return initialContextFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialContextFactory(String newInitialContextFactory) {
		String oldInitialContextFactory = initialContextFactory;
		initialContextFactory = newInitialContextFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmsPackage.JMS_PROVIDER__INITIAL_CONTEXT_FACTORY, oldInitialContextFactory, initialContextFactory));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getNativePath() {
		if (nativePath == null) {
			nativePath = new EDataTypeEList(String.class, this, JmsPackage.JMS_PROVIDER__NATIVE_PATH);
		}
		return nativePath;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JmsPackage.JMS_PROVIDER__PROVIDER_NAME, oldProviderName, providerName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderURL() {
		return providerURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderURL(String newProviderURL) {
		String oldProviderURL = providerURL;
		providerURL = newProviderURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmsPackage.JMS_PROVIDER__PROVIDER_URL, oldProviderURL, providerURL));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderVersion() {
		return providerVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderVersion(String newProviderVersion) {
		String oldProviderVersion = providerVersion;
		providerVersion = newProviderVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JmsPackage.JMS_PROVIDER__PROVIDER_VERSION, oldProviderVersion, providerVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JmsPackage.JMS_PROVIDER__CLASS_PATH:
				return getClassPath();
			case JmsPackage.JMS_PROVIDER__NATIVE_PATH:
				return getNativePath();
			case JmsPackage.JMS_PROVIDER__INITIAL_CONTEXT_FACTORY:
				return getInitialContextFactory();
			case JmsPackage.JMS_PROVIDER__PROVIDER_NAME:
				return getProviderName();
			case JmsPackage.JMS_PROVIDER__PROVIDER_URL:
				return getProviderURL();
			case JmsPackage.JMS_PROVIDER__PROVIDER_VERSION:
				return getProviderVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JmsPackage.JMS_PROVIDER__CLASS_PATH:
				getClassPath().clear();
				getClassPath().addAll((Collection)newValue);
				return;
			case JmsPackage.JMS_PROVIDER__NATIVE_PATH:
				getNativePath().clear();
				getNativePath().addAll((Collection)newValue);
				return;
			case JmsPackage.JMS_PROVIDER__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory((String)newValue);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_NAME:
				setProviderName((String)newValue);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_URL:
				setProviderURL((String)newValue);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_VERSION:
				setProviderVersion((String)newValue);
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
			case JmsPackage.JMS_PROVIDER__CLASS_PATH:
				getClassPath().clear();
				return;
			case JmsPackage.JMS_PROVIDER__NATIVE_PATH:
				getNativePath().clear();
				return;
			case JmsPackage.JMS_PROVIDER__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory(INITIAL_CONTEXT_FACTORY_EDEFAULT);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_NAME:
				setProviderName(PROVIDER_NAME_EDEFAULT);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_URL:
				setProviderURL(PROVIDER_URL_EDEFAULT);
				return;
			case JmsPackage.JMS_PROVIDER__PROVIDER_VERSION:
				setProviderVersion(PROVIDER_VERSION_EDEFAULT);
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
			case JmsPackage.JMS_PROVIDER__CLASS_PATH:
				return classPath != null && !classPath.isEmpty();
			case JmsPackage.JMS_PROVIDER__NATIVE_PATH:
				return nativePath != null && !nativePath.isEmpty();
			case JmsPackage.JMS_PROVIDER__INITIAL_CONTEXT_FACTORY:
				return INITIAL_CONTEXT_FACTORY_EDEFAULT == null ? initialContextFactory != null : !INITIAL_CONTEXT_FACTORY_EDEFAULT.equals(initialContextFactory);
			case JmsPackage.JMS_PROVIDER__PROVIDER_NAME:
				return PROVIDER_NAME_EDEFAULT == null ? providerName != null : !PROVIDER_NAME_EDEFAULT.equals(providerName);
			case JmsPackage.JMS_PROVIDER__PROVIDER_URL:
				return PROVIDER_URL_EDEFAULT == null ? providerURL != null : !PROVIDER_URL_EDEFAULT.equals(providerURL);
			case JmsPackage.JMS_PROVIDER__PROVIDER_VERSION:
				return PROVIDER_VERSION_EDEFAULT == null ? providerVersion != null : !PROVIDER_VERSION_EDEFAULT.equals(providerVersion);
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
		result.append(" (classPath: "); //$NON-NLS-1$
		result.append(classPath);
		result.append(", nativePath: "); //$NON-NLS-1$
		result.append(nativePath);
		result.append(", initialContextFactory: "); //$NON-NLS-1$
		result.append(initialContextFactory);
		result.append(", providerName: "); //$NON-NLS-1$
		result.append(providerName);
		result.append(", providerURL: "); //$NON-NLS-1$
		result.append(providerURL);
		result.append(", providerVersion: "); //$NON-NLS-1$
		result.append(providerVersion);
		result.append(')');
		return result.toString();
	}

} //JMSProviderImpl
