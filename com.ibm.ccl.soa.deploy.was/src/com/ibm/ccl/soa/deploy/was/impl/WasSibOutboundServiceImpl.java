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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibOutboundService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sib Outbound Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibOutboundServiceImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibOutboundServiceImpl#getWsdlLocation <em>Wsdl Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibOutboundServiceImpl#getWsdlServiceNamespace <em>Wsdl Service Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSibOutboundServiceImpl extends CapabilityImpl implements WasSibOutboundService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected String serviceName = SERVICE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlLocation() <em>Wsdl Location</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWsdlLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWsdlLocation() <em>Wsdl Location</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWsdlLocation()
	 * @generated
	 * @ordered
	 */
	protected String wsdlLocation = WSDL_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWsdlServiceNamespace() <em>Wsdl Service Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWsdlServiceNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_SERVICE_NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWsdlServiceNamespace() <em>Wsdl Service Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWsdlServiceNamespace()
	 * @generated
	 * @ordered
	 */
	protected String wsdlServiceNamespace = WSDL_SERVICE_NAMESPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSibOutboundServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SIB_OUTBOUND_SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		String oldServiceName = serviceName;
		serviceName = newServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlLocation() {
		return wsdlLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlLocation(String newWsdlLocation) {
		String oldWsdlLocation = wsdlLocation;
		wsdlLocation = newWsdlLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION, oldWsdlLocation, wsdlLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlServiceNamespace() {
		return wsdlServiceNamespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlServiceNamespace(String newWsdlServiceNamespace) {
		String oldWsdlServiceNamespace = wsdlServiceNamespace;
		wsdlServiceNamespace = newWsdlServiceNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE, oldWsdlServiceNamespace, wsdlServiceNamespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME:
				return getServiceName();
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION:
				return getWsdlLocation();
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE:
				return getWsdlServiceNamespace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME:
				setServiceName((String)newValue);
				return;
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION:
				setWsdlLocation((String)newValue);
				return;
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE:
				setWsdlServiceNamespace((String)newValue);
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
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME:
				setServiceName(SERVICE_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION:
				setWsdlLocation(WSDL_LOCATION_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE:
				setWsdlServiceNamespace(WSDL_SERVICE_NAMESPACE_EDEFAULT);
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
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__SERVICE_NAME:
				return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_LOCATION:
				return WSDL_LOCATION_EDEFAULT == null ? wsdlLocation != null : !WSDL_LOCATION_EDEFAULT.equals(wsdlLocation);
			case WasPackage.WAS_SIB_OUTBOUND_SERVICE__WSDL_SERVICE_NAMESPACE:
				return WSDL_SERVICE_NAMESPACE_EDEFAULT == null ? wsdlServiceNamespace != null : !WSDL_SERVICE_NAMESPACE_EDEFAULT.equals(wsdlServiceNamespace);
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
		result.append(" (serviceName: "); //$NON-NLS-1$
		result.append(serviceName);
		result.append(", wsdlLocation: "); //$NON-NLS-1$
		result.append(wsdlLocation);
		result.append(", wsdlServiceNamespace: "); //$NON-NLS-1$
		result.append(wsdlServiceNamespace);
		result.append(')');
		return result.toString();
	}

} //WasSibOutboundServiceImpl
