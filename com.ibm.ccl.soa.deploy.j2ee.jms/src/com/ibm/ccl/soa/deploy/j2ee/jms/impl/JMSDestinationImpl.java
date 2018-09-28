/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Destination</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl#getDestinationName <em>Destination Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl#getJndiName <em>Jndi Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JMSDestinationImpl extends CapabilityImpl implements JMSDestination {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDestinationName() <em>Destination Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDestinationName()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestinationName() <em>Destination Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDestinationName()
	 * @generated
	 * @ordered
	 */
	protected String destinationName = DESTINATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JMSDestinationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JmsPackage.Literals.JMS_DESTINATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDestinationName(String newDestinationName) {
		String oldDestinationName = destinationName;
		destinationName = newDestinationName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_DESTINATION__DESTINATION_NAME, oldDestinationName, destinationName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_DESTINATION__JNDI_NAME, oldJndiName, jndiName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case JmsPackage.JMS_DESTINATION__DESTINATION_NAME:
			return getDestinationName();
		case JmsPackage.JMS_DESTINATION__JNDI_NAME:
			return getJndiName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case JmsPackage.JMS_DESTINATION__DESTINATION_NAME:
			setDestinationName((String) newValue);
			return;
		case JmsPackage.JMS_DESTINATION__JNDI_NAME:
			setJndiName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case JmsPackage.JMS_DESTINATION__DESTINATION_NAME:
			setDestinationName(DESTINATION_NAME_EDEFAULT);
			return;
		case JmsPackage.JMS_DESTINATION__JNDI_NAME:
			setJndiName(JNDI_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case JmsPackage.JMS_DESTINATION__DESTINATION_NAME:
			return DESTINATION_NAME_EDEFAULT == null ? destinationName != null
					: !DESTINATION_NAME_EDEFAULT.equals(destinationName);
		case JmsPackage.JMS_DESTINATION__JNDI_NAME:
			return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT
					.equals(jndiName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (destinationName: "); //$NON-NLS-1$
		result.append(destinationName);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections
			.singletonList(JmsPackage.Literals.JMS_DESTINATION__DESTINATION_NAME);

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //JMSDestinationImpl
