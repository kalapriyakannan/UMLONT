/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.EndPointListenerNameEnum;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Endpoint Listener Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasEndpointListenerConfigurationImpl#getEndpointListenerName <em>Endpoint Listener Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasEndpointListenerConfigurationImpl#getUrlRoot <em>Url Root</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasEndpointListenerConfigurationImpl#getWsdlUrlRoot <em>Wsdl Url Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasEndpointListenerConfigurationImpl extends CapabilityImpl implements
		WasEndpointListenerConfiguration {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getEndpointListenerName() <em>Endpoint Listener Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEndpointListenerName()
	 * @generated
	 * @ordered
	 */
	protected static final EndPointListenerNameEnum ENDPOINT_LISTENER_NAME_EDEFAULT = EndPointListenerNameEnum.SOAPHTTP_CHANNEL1_LITERAL;

	/**
	 * The cached value of the '{@link #getEndpointListenerName() <em>Endpoint Listener Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEndpointListenerName()
	 * @generated
	 * @ordered
	 */
	protected EndPointListenerNameEnum endpointListenerName = ENDPOINT_LISTENER_NAME_EDEFAULT;

	/**
	 * This is true if the Endpoint Listener Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean endpointListenerNameESet;

	/**
	 * The default value of the '{@link #getUrlRoot() <em>Url Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUrlRoot()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_ROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrlRoot() <em>Url Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUrlRoot()
	 * @generated
	 * @ordered
	 */
	protected String urlRoot = URL_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlUrlRoot() <em>Wsdl Url Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWsdlUrlRoot()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_URL_ROOT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWsdlUrlRoot() <em>Wsdl Url Root</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWsdlUrlRoot()
	 * @generated
	 * @ordered
	 */
	protected String wsdlUrlRoot = WSDL_URL_ROOT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasEndpointListenerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_ENDPOINT_LISTENER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointListenerNameEnum getEndpointListenerName() {
		return endpointListenerName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointListenerName(EndPointListenerNameEnum newEndpointListenerName) {
		EndPointListenerNameEnum oldEndpointListenerName = endpointListenerName;
		endpointListenerName = newEndpointListenerName == null ? ENDPOINT_LISTENER_NAME_EDEFAULT : newEndpointListenerName;
		boolean oldEndpointListenerNameESet = endpointListenerNameESet;
		endpointListenerNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME, oldEndpointListenerName, endpointListenerName, !oldEndpointListenerNameESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEndpointListenerName() {
		EndPointListenerNameEnum oldEndpointListenerName = endpointListenerName;
		boolean oldEndpointListenerNameESet = endpointListenerNameESet;
		endpointListenerName = ENDPOINT_LISTENER_NAME_EDEFAULT;
		endpointListenerNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME, oldEndpointListenerName, ENDPOINT_LISTENER_NAME_EDEFAULT, oldEndpointListenerNameESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEndpointListenerName() {
		return endpointListenerNameESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrlRoot() {
		return urlRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlRoot(String newUrlRoot) {
		String oldUrlRoot = urlRoot;
		urlRoot = newUrlRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT, oldUrlRoot, urlRoot));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlUrlRoot() {
		return wsdlUrlRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlUrlRoot(String newWsdlUrlRoot) {
		String oldWsdlUrlRoot = wsdlUrlRoot;
		wsdlUrlRoot = newWsdlUrlRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT, oldWsdlUrlRoot, wsdlUrlRoot));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME:
				return getEndpointListenerName();
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT:
				return getUrlRoot();
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT:
				return getWsdlUrlRoot();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME:
				setEndpointListenerName((EndPointListenerNameEnum)newValue);
				return;
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT:
				setUrlRoot((String)newValue);
				return;
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT:
				setWsdlUrlRoot((String)newValue);
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
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME:
				unsetEndpointListenerName();
				return;
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT:
				setUrlRoot(URL_ROOT_EDEFAULT);
				return;
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT:
				setWsdlUrlRoot(WSDL_URL_ROOT_EDEFAULT);
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
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__ENDPOINT_LISTENER_NAME:
				return isSetEndpointListenerName();
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__URL_ROOT:
				return URL_ROOT_EDEFAULT == null ? urlRoot != null : !URL_ROOT_EDEFAULT.equals(urlRoot);
			case WasPackage.WAS_ENDPOINT_LISTENER_CONFIGURATION__WSDL_URL_ROOT:
				return WSDL_URL_ROOT_EDEFAULT == null ? wsdlUrlRoot != null : !WSDL_URL_ROOT_EDEFAULT.equals(wsdlUrlRoot);
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
		result.append(" (endpointListenerName: "); //$NON-NLS-1$
		if (endpointListenerNameESet) result.append(endpointListenerName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", urlRoot: "); //$NON-NLS-1$
		result.append(urlRoot);
		result.append(", wsdlUrlRoot: "); //$NON-NLS-1$
		result.append(wsdlUrlRoot);
		result.append(')');
		return result.toString();
	}

} //WasEndpointListenerConfigurationImpl
