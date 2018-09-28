/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JMS Activation Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode <em>Acknowledge Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getClientIdentifier <em>Client Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSpecificationName <em>Specification Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSubscriptionName <em>Subscription Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification()
 * @model extendedMetaData="name='JMSActivationSpecification' kind='elementOnly'"
 * @generated
 */
public interface JMSActivationSpecification extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Acknowledge Mode</b></em>' attribute.
	 * The default value is <code>"Auto-acknowledge"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acknowledge Mode</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acknowledge Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @see #isSetAcknowledgeMode()
	 * @see #unsetAcknowledgeMode()
	 * @see #setAcknowledgeMode(AcknowledgeModeEnum)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_AcknowledgeMode()
	 * @model default="Auto-acknowledge" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='acknowledgeMode'"
	 * @generated
	 */
	AcknowledgeModeEnum getAcknowledgeMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode <em>Acknowledge Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acknowledge Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @see #isSetAcknowledgeMode()
	 * @see #unsetAcknowledgeMode()
	 * @see #getAcknowledgeMode()
	 * @generated
	 */
	void setAcknowledgeMode(AcknowledgeModeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode <em>Acknowledge Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetAcknowledgeMode()
	 * @see #getAcknowledgeMode()
	 * @see #setAcknowledgeMode(AcknowledgeModeEnum)
	 * @generated
	 */
	void unsetAcknowledgeMode();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode <em>Acknowledge Mode</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Acknowledge Mode</em>' attribute is set.
	 * @see #unsetAcknowledgeMode()
	 * @see #getAcknowledgeMode()
	 * @see #setAcknowledgeMode(AcknowledgeModeEnum)
	 * @generated
	 */
	boolean isSetAcknowledgeMode();

	/**
	 * Returns the value of the '<em><b>Client Identifier</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Identifier</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Client Identifier</em>' attribute.
	 * @see #setClientIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_ClientIdentifier()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='clientIdentifier'"
	 * @generated
	 */
	String getClientIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getClientIdentifier <em>Client Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Identifier</em>' attribute.
	 * @see #getClientIdentifier()
	 * @generated
	 */
	void setClientIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Name</em>' attribute.
	 * @see #setJndiName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Mesasage Selector</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesasage Selector</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mesasage Selector</em>' attribute.
	 * @see #setMesasageSelector(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_MesasageSelector()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mesasageSelector'"
	 * @generated
	 */
	String getMesasageSelector();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesasage Selector</em>' attribute.
	 * @see #getMesasageSelector()
	 * @generated
	 */
	void setMesasageSelector(String value);

	/**
	 * Returns the value of the '<em><b>Specification Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Specification Name</em>' attribute.
	 * @see #setSpecificationName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_SpecificationName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='specificationName'"
	 * @generated
	 */
	String getSpecificationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSpecificationName <em>Specification Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Name</em>' attribute.
	 * @see #getSpecificationName()
	 * @generated
	 */
	void setSpecificationName(String value);

	/**
	 * Returns the value of the '<em><b>Subscription Durable</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription Durable</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subscription Durable</em>' attribute.
	 * @see #isSetSubscriptionDurable()
	 * @see #unsetSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_SubscriptionDurable()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='subscriptionDurable'"
	 * @generated
	 */
	boolean isSubscriptionDurable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscription Durable</em>' attribute.
	 * @see #isSetSubscriptionDurable()
	 * @see #unsetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @generated
	 */
	void setSubscriptionDurable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @generated
	 */
	void unsetSubscriptionDurable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subscription Durable</em>' attribute is set.
	 * @see #unsetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @generated
	 */
	boolean isSetSubscriptionDurable();

	/**
	 * Returns the value of the '<em><b>Subscription Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subscription Name</em>' attribute.
	 * @see #setSubscriptionName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSActivationSpecification_SubscriptionName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subscriptionName'"
	 * @generated
	 */
	String getSubscriptionName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSubscriptionName <em>Subscription Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscription Name</em>' attribute.
	 * @see #getSubscriptionName()
	 * @generated
	 */
	void setSubscriptionName(String value);

} // JMSActivationSpecification
