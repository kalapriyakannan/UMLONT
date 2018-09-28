/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Sphere Business Integration Adapters Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl#getInputQueueJNDIName <em>Input Queue JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl#getJNDIName <em>JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl#getOutputQueueJNDIName <em>Output Queue JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebSphereBusinessIntegrationAdaptersServiceImpl extends CapabilityImpl implements WebSphereBusinessIntegrationAdaptersService {
	/**
	 * The default value of the '{@link #getInputQueueJNDIName() <em>Input Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputQueueJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_QUEUE_JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputQueueJNDIName() <em>Input Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputQueueJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String inputQueueJNDIName = INPUT_QUEUE_JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJNDIName() <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJNDIName() <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String jNDIName = JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputQueueJNDIName() <em>Output Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputQueueJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_QUEUE_JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputQueueJNDIName() <em>Output Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputQueueJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String outputQueueJNDIName = OUTPUT_QUEUE_JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected String timeout = TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WebSphereBusinessIntegrationAdaptersServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputQueueJNDIName() {
		return inputQueueJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputQueueJNDIName(String newInputQueueJNDIName) {
		String oldInputQueueJNDIName = inputQueueJNDIName;
		inputQueueJNDIName = newInputQueueJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME, oldInputQueueJNDIName, inputQueueJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJNDIName() {
		return jNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJNDIName(String newJNDIName) {
		String oldJNDIName = jNDIName;
		jNDIName = newJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME, oldJNDIName, jNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputQueueJNDIName() {
		return outputQueueJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputQueueJNDIName(String newOutputQueueJNDIName) {
		String oldOutputQueueJNDIName = outputQueueJNDIName;
		outputQueueJNDIName = newOutputQueueJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME, oldOutputQueueJNDIName, outputQueueJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(String newTimeout) {
		String oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME:
				return getInputQueueJNDIName();
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME:
				return getJNDIName();
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1:
				return getName1();
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME:
				return getOutputQueueJNDIName();
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT:
				return getTimeout();
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
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME:
				setInputQueueJNDIName((String)newValue);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME:
				setJNDIName((String)newValue);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1:
				setName1((String)newValue);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME:
				setOutputQueueJNDIName((String)newValue);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT:
				setTimeout((String)newValue);
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
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME:
				setInputQueueJNDIName(INPUT_QUEUE_JNDI_NAME_EDEFAULT);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME:
				setJNDIName(JNDI_NAME_EDEFAULT);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME:
				setOutputQueueJNDIName(OUTPUT_QUEUE_JNDI_NAME_EDEFAULT);
				return;
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
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
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME:
				return INPUT_QUEUE_JNDI_NAME_EDEFAULT == null ? inputQueueJNDIName != null : !INPUT_QUEUE_JNDI_NAME_EDEFAULT.equals(inputQueueJNDIName);
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME:
				return JNDI_NAME_EDEFAULT == null ? jNDIName != null : !JNDI_NAME_EDEFAULT.equals(jNDIName);
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME:
				return OUTPUT_QUEUE_JNDI_NAME_EDEFAULT == null ? outputQueueJNDIName != null : !OUTPUT_QUEUE_JNDI_NAME_EDEFAULT.equals(outputQueueJNDIName);
			case WpsPackage.WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
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
		result.append(" (inputQueueJNDIName: "); //$NON-NLS-1$
		result.append(inputQueueJNDIName);
		result.append(", jNDIName: "); //$NON-NLS-1$
		result.append(jNDIName);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", outputQueueJNDIName: "); //$NON-NLS-1$
		result.append(outputQueueJNDIName);
		result.append(", timeout: "); //$NON-NLS-1$
		result.append(timeout);
		result.append(')');
		return result.toString();
	}

} //WebSphereBusinessIntegrationAdaptersServiceImpl
