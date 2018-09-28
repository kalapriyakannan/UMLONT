/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MQ Activation Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getClientIdentifier <em>Client Identifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSpecificationName <em>Specification Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSubscriptionName <em>Subscription Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification()
 * @model extendedMetaData="name='MQActivationSpecification' kind='elementOnly'"
 * @generated
 */
public interface MQActivationSpecification extends Capability {
	/**
	 * Returns the value of the '<em><b>Client Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Identifier</em>' attribute.
	 * @see #setClientIdentifier(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_ClientIdentifier()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='clientIdentifier'"
	 * @generated
	 */
	String getClientIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getClientIdentifier <em>Client Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Identifier</em>' attribute.
	 * @see #getClientIdentifier()
	 * @generated
	 */
	void setClientIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Name</em>' attribute.
	 * @see #setJndiName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Mesasage Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mesasage Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mesasage Selector</em>' attribute.
	 * @see #setMesasageSelector(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_MesasageSelector()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mesasageSelector'"
	 * @generated
	 */
	String getMesasageSelector();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mesasage Selector</em>' attribute.
	 * @see #getMesasageSelector()
	 * @generated
	 */
	void setMesasageSelector(String value);

	/**
	 * Returns the value of the '<em><b>Specification Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification Name</em>' attribute.
	 * @see #setSpecificationName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_SpecificationName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='specificationName'"
	 * @generated
	 */
	String getSpecificationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSpecificationName <em>Specification Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification Name</em>' attribute.
	 * @see #getSpecificationName()
	 * @generated
	 */
	void setSpecificationName(String value);

	/**
	 * Returns the value of the '<em><b>Subscription Durable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription Durable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscription Durable</em>' attribute.
	 * @see #isSetSubscriptionDurable()
	 * @see #unsetSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_SubscriptionDurable()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='subscriptionDurable'"
	 * @generated
	 */
	boolean isSubscriptionDurable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscription Durable</em>' attribute.
	 * @see #isSetSubscriptionDurable()
	 * @see #unsetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @generated
	 */
	void setSubscriptionDurable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @generated
	 */
	void unsetSubscriptionDurable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subscription Durable</em>' attribute is set.
	 * @see #unsetSubscriptionDurable()
	 * @see #isSubscriptionDurable()
	 * @see #setSubscriptionDurable(boolean)
	 * @generated
	 */
	boolean isSetSubscriptionDurable();

	/**
	 * Returns the value of the '<em><b>Subscription Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscription Name</em>' attribute.
	 * @see #setSubscriptionName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMQActivationSpecification_SubscriptionName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subscriptionName'"
	 * @generated
	 */
	String getSubscriptionName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSubscriptionName <em>Subscription Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscription Name</em>' attribute.
	 * @see #getSubscriptionName()
	 * @generated
	 */
	void setSubscriptionName(String value);

} // MQActivationSpecification
