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
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>WSDL Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.WSDLInterfaceImpl#getTypeUri <em>Type Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSDLInterfaceImpl extends InterfaceImpl implements WSDLInterface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getTypeUri() <em>Type Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypeUri()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_URI_EDEFAULT = null;

	private static final char TYPE_URI_SEPARATOR = '#';

	/**
	 * The cached value of the '{@link #getTypeUri() <em>Type Uri</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypeUri()
	 * @generated
	 * @ordered
	 */
	protected String typeUri = TYPE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WSDLInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.WSDL_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeUri() {
		return typeUri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeUri(String newTypeUri) {
		String oldTypeUri = typeUri;
		typeUri = newTypeUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.WSDL_INTERFACE__TYPE_URI, oldTypeUri, typeUri));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.WSDL_INTERFACE__TYPE_URI:
			return getTypeUri();
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
		case J2eePackage.WSDL_INTERFACE__TYPE_URI:
			setTypeUri((String) newValue);
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
		case J2eePackage.WSDL_INTERFACE__TYPE_URI:
			setTypeUri(TYPE_URI_EDEFAULT);
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
		case J2eePackage.WSDL_INTERFACE__TYPE_URI:
			return TYPE_URI_EDEFAULT == null ? typeUri != null : !TYPE_URI_EDEFAULT.equals(typeUri);
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
		result.append(" (typeUri: "); //$NON-NLS-1$
		result.append(typeUri);
		result.append(')');
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Interface#isFastEquivalencyCheck(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public boolean isFastEquivalencyCheck(Interface anotherInterface) {
		if (anotherInterface != null && anotherInterface instanceof WSDLInterface) {
			String typeUri = getTypeUri();
			String anotherTypeUri = ((WSDLInterface) anotherInterface).getTypeUri();
			if (typeUri == null && anotherTypeUri == null) {
				return true;
			}
			if ((typeUri != null && anotherTypeUri == null)
					|| (typeUri == null && anotherTypeUri != null)) {
				return false;
			}
			if (typeUri.equals(anotherTypeUri)) {
				//Exact match is good enough for me.
				return true;
			}
			//Check that the type names are the same.
			int typeIndex = typeUri.indexOf(TYPE_URI_SEPARATOR);
			int anotherTypeIndex = anotherTypeUri.indexOf(TYPE_URI_SEPARATOR);
			if (typeIndex > 0 && anotherTypeIndex > 0) {
				String type = typeUri.substring(typeIndex);
				String anotherType = anotherTypeUri.substring(anotherTypeIndex);
				return type.equals(anotherType);
			}
		}
		return false;
	}

	public String getDisplayString() {
		if (eIsProxy())
			return super.toString();

		return getTypeUri();
	}

} //WSDLInterfaceImpl
