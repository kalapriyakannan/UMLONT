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
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Topic Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl#getFactoryName <em>Factory Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl#getJndiName <em>Jndi Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JMSTopicConnectionFactoryImpl extends CapabilityImpl implements
		JMSTopicConnectionFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getFactoryName() <em>Factory Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryName() <em>Factory Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactoryName()
	 * @generated
	 * @ordered
	 */
	protected String factoryName = FACTORY_NAME_EDEFAULT;

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
	protected JMSTopicConnectionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFactoryName(String newFactoryName) {
		String oldFactoryName = factoryName;
		factoryName = newFactoryName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME, oldFactoryName, factoryName));
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
					JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME, oldJndiName, jndiName));
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
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
			return getFactoryName();
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
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
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
			setFactoryName((String) newValue);
			return;
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
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
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
			setFactoryName(FACTORY_NAME_EDEFAULT);
			return;
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
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
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME:
			return FACTORY_NAME_EDEFAULT == null ? factoryName != null : !FACTORY_NAME_EDEFAULT
					.equals(factoryName);
		case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME:
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
		result.append(" (factoryName: "); //$NON-NLS-1$
		result.append(factoryName);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections
			.singletonList(JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME);

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //JMSTopicConnectionFactoryImpl
