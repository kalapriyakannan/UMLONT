/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.mq.MQBaseSystem;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Base System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl#getInitialContextFactory <em>Initial Context Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl#getProviderURL <em>Provider URL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl#getProviderVersion <em>Provider Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQBaseSystemImpl extends CapabilityImpl implements MQBaseSystem {
	/**
	 * The default value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_CONTEXT_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialContextFactory() <em>Initial Context Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialContextFactory()
	 * @generated
	 * @ordered
	 */
	protected String initialContextFactory = INITIAL_CONTEXT_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderName() <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderName() <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderName()
	 * @generated
	 * @ordered
	 */
	protected String providerName = PROVIDER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderURL() <em>Provider URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderURL()
	 * @generated
	 * @ordered
	 */
	protected String providerURL = PROVIDER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderVersion() <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProviderVersion() <em>Provider Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderVersion()
	 * @generated
	 * @ordered
	 */
	protected String providerVersion = PROVIDER_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQBaseSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_BASE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialContextFactory() {
		return initialContextFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialContextFactory(String newInitialContextFactory) {
		String oldInitialContextFactory = initialContextFactory;
		initialContextFactory = newInitialContextFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY, oldInitialContextFactory, initialContextFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderName(String newProviderName) {
		String oldProviderName = providerName;
		providerName = newProviderName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_BASE_SYSTEM__PROVIDER_NAME, oldProviderName, providerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderURL() {
		return providerURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderURL(String newProviderURL) {
		String oldProviderURL = providerURL;
		providerURL = newProviderURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_BASE_SYSTEM__PROVIDER_URL, oldProviderURL, providerURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProviderVersion() {
		return providerVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProviderVersion(String newProviderVersion) {
		String oldProviderVersion = providerVersion;
		providerVersion = newProviderVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MQ_BASE_SYSTEM__PROVIDER_VERSION, oldProviderVersion, providerVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY:
				return getInitialContextFactory();
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_NAME:
				return getProviderName();
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_URL:
				return getProviderURL();
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_VERSION:
				return getProviderVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MqPackage.MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory((String)newValue);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_NAME:
				setProviderName((String)newValue);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_URL:
				setProviderURL((String)newValue);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_VERSION:
				setProviderVersion((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MqPackage.MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY:
				setInitialContextFactory(INITIAL_CONTEXT_FACTORY_EDEFAULT);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_NAME:
				setProviderName(PROVIDER_NAME_EDEFAULT);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_URL:
				setProviderURL(PROVIDER_URL_EDEFAULT);
				return;
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_VERSION:
				setProviderVersion(PROVIDER_VERSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MqPackage.MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY:
				return INITIAL_CONTEXT_FACTORY_EDEFAULT == null ? initialContextFactory != null : !INITIAL_CONTEXT_FACTORY_EDEFAULT.equals(initialContextFactory);
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_NAME:
				return PROVIDER_NAME_EDEFAULT == null ? providerName != null : !PROVIDER_NAME_EDEFAULT.equals(providerName);
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_URL:
				return PROVIDER_URL_EDEFAULT == null ? providerURL != null : !PROVIDER_URL_EDEFAULT.equals(providerURL);
			case MqPackage.MQ_BASE_SYSTEM__PROVIDER_VERSION:
				return PROVIDER_VERSION_EDEFAULT == null ? providerVersion != null : !PROVIDER_VERSION_EDEFAULT.equals(providerVersion);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initialContextFactory: "); //$NON-NLS-1$
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

} //MQBaseSystemImpl
