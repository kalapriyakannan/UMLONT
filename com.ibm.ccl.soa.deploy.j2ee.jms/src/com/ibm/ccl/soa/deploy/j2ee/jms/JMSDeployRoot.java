/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JMS Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSActivationSpecification <em>Capability JMS Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSConnectionFactory <em>Capability JMS Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSDestination <em>Capability JMS Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSProvider <em>Capability JMS Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueConnectionFactory <em>Capability JMS Queue Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueDestination <em>Capability JMS Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicConnectionFactory <em>Capability JMS Topic Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicDestination <em>Capability JMS Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSActivationSpecificationUnit <em>Unit JMS Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSConnectionFactoryUnit <em>Unit JMS Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSProviderUnit <em>Unit JMS Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueConnectionFactoryUnit <em>Unit JMS Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueDestinationUnit <em>Unit JMS Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicConnectionFactoryUnit <em>Unit JMS Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicDestinationUnit <em>Unit JMS Topic Destination Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface JMSDeployRoot extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability JMS Activation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Activation Specification</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Activation Specification</em>' containment reference.
	 * @see #setCapabilityJMSActivationSpecification(JMSActivationSpecification)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSActivationSpecification()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSActivationSpecification' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSActivationSpecification getCapabilityJMSActivationSpecification();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSActivationSpecification <em>Capability JMS Activation Specification</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Activation Specification</em>' containment reference.
	 * @see #getCapabilityJMSActivationSpecification()
	 * @generated
	 */
	void setCapabilityJMSActivationSpecification(JMSActivationSpecification value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Connection Factory</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Connection Factory</em>' containment reference.
	 * @see #setCapabilityJMSConnectionFactory(JMSConnectionFactory)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSConnectionFactory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSConnectionFactory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSConnectionFactory getCapabilityJMSConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSConnectionFactory <em>Capability JMS Connection Factory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Connection Factory</em>' containment reference.
	 * @see #getCapabilityJMSConnectionFactory()
	 * @generated
	 */
	void setCapabilityJMSConnectionFactory(JMSConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Destination</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Destination</em>' containment reference.
	 * @see #setCapabilityJMSDestination(JMSDestination)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSDestination getCapabilityJMSDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSDestination <em>Capability JMS Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Destination</em>' containment reference.
	 * @see #getCapabilityJMSDestination()
	 * @generated
	 */
	void setCapabilityJMSDestination(JMSDestination value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Provider</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Provider</em>' containment reference.
	 * @see #setCapabilityJMSProvider(JMSProvider)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSProvider()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSProvider' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSProvider getCapabilityJMSProvider();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSProvider <em>Capability JMS Provider</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Provider</em>' containment reference.
	 * @see #getCapabilityJMSProvider()
	 * @generated
	 */
	void setCapabilityJMSProvider(JMSProvider value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Queue Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Queue Connection Factory</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Queue Connection Factory</em>' containment reference.
	 * @see #setCapabilityJMSQueueConnectionFactory(JMSQueueConnectionFactory)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSQueueConnectionFactory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSQueueConnectionFactory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSQueueConnectionFactory getCapabilityJMSQueueConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueConnectionFactory <em>Capability JMS Queue Connection Factory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Queue Connection Factory</em>' containment reference.
	 * @see #getCapabilityJMSQueueConnectionFactory()
	 * @generated
	 */
	void setCapabilityJMSQueueConnectionFactory(JMSQueueConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Queue Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Queue Destination</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Queue Destination</em>' containment reference.
	 * @see #setCapabilityJMSQueueDestination(JMSQueueDestination)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSQueueDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSQueueDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSQueueDestination getCapabilityJMSQueueDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueDestination <em>Capability JMS Queue Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Queue Destination</em>' containment reference.
	 * @see #getCapabilityJMSQueueDestination()
	 * @generated
	 */
	void setCapabilityJMSQueueDestination(JMSQueueDestination value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Topic Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Topic Connection Factory</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Topic Connection Factory</em>' containment reference.
	 * @see #setCapabilityJMSTopicConnectionFactory(JMSTopicConnectionFactory)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSTopicConnectionFactory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSTopicConnectionFactory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSTopicConnectionFactory getCapabilityJMSTopicConnectionFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicConnectionFactory <em>Capability JMS Topic Connection Factory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Topic Connection Factory</em>' containment reference.
	 * @see #getCapabilityJMSTopicConnectionFactory()
	 * @generated
	 */
	void setCapabilityJMSTopicConnectionFactory(JMSTopicConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Capability JMS Topic Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability JMS Topic Destination</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability JMS Topic Destination</em>' containment reference.
	 * @see #setCapabilityJMSTopicDestination(JMSTopicDestination)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_CapabilityJMSTopicDestination()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.JMSTopicDestination' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	JMSTopicDestination getCapabilityJMSTopicDestination();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicDestination <em>Capability JMS Topic Destination</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability JMS Topic Destination</em>' containment reference.
	 * @see #getCapabilityJMSTopicDestination()
	 * @generated
	 */
	void setCapabilityJMSTopicDestination(JMSTopicDestination value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Activation Specification Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Activation Specification Unit</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Activation Specification Unit</em>' containment reference.
	 * @see #setUnitJMSActivationSpecificationUnit(JMSActivationSpecificationUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSActivationSpecificationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSActivationSpecificationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSActivationSpecificationUnit getUnitJMSActivationSpecificationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSActivationSpecificationUnit <em>Unit JMS Activation Specification Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Activation Specification Unit</em>' containment reference.
	 * @see #getUnitJMSActivationSpecificationUnit()
	 * @generated
	 */
	void setUnitJMSActivationSpecificationUnit(JMSActivationSpecificationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Connection Factory Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Connection Factory Unit</em>' containment reference.
	 * @see #setUnitJMSConnectionFactoryUnit(JMSConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSConnectionFactoryUnit getUnitJMSConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSConnectionFactoryUnit <em>Unit JMS Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Connection Factory Unit</em>' containment reference.
	 * @see #getUnitJMSConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitJMSConnectionFactoryUnit(JMSConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Provider Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Provider Unit</em>' containment reference.
	 * @see #setUnitJMSProviderUnit(JMSProviderUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSProviderUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSProviderUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSProviderUnit getUnitJMSProviderUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSProviderUnit <em>Unit JMS Provider Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Provider Unit</em>' containment reference.
	 * @see #getUnitJMSProviderUnit()
	 * @generated
	 */
	void setUnitJMSProviderUnit(JMSProviderUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Queue Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Queue Connection Factory Unit</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Queue Connection Factory Unit</em>' containment reference.
	 * @see #setUnitJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSQueueConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSQueueConnectionFactoryUnit getUnitJMSQueueConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueConnectionFactoryUnit <em>Unit JMS Queue Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Queue Connection Factory Unit</em>' containment reference.
	 * @see #getUnitJMSQueueConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitJMSQueueConnectionFactoryUnit(JMSQueueConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Queue Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Queue Destination Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Queue Destination Unit</em>' containment reference.
	 * @see #setUnitJMSQueueDestinationUnit(JMSQueueDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSQueueDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSQueueDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSQueueDestinationUnit getUnitJMSQueueDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueDestinationUnit <em>Unit JMS Queue Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Queue Destination Unit</em>' containment reference.
	 * @see #getUnitJMSQueueDestinationUnit()
	 * @generated
	 */
	void setUnitJMSQueueDestinationUnit(JMSQueueDestinationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Topic Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Topic Connection Factory Unit</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Topic Connection Factory Unit</em>' containment reference.
	 * @see #setUnitJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSTopicConnectionFactoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSTopicConnectionFactoryUnit getUnitJMSTopicConnectionFactoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicConnectionFactoryUnit <em>Unit JMS Topic Connection Factory Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Topic Connection Factory Unit</em>' containment reference.
	 * @see #getUnitJMSTopicConnectionFactoryUnit()
	 * @generated
	 */
	void setUnitJMSTopicConnectionFactoryUnit(JMSTopicConnectionFactoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit JMS Topic Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit JMS Topic Destination Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit JMS Topic Destination Unit</em>' containment reference.
	 * @see #setUnitJMSTopicDestinationUnit(JMSTopicDestinationUnit)
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage#getJMSDeployRoot_UnitJMSTopicDestinationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.JMSTopicDestinationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	JMSTopicDestinationUnit getUnitJMSTopicDestinationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicDestinationUnit <em>Unit JMS Topic Destination Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit JMS Topic Destination Unit</em>' containment reference.
	 * @see #getUnitJMSTopicDestinationUnit()
	 * @generated
	 */
	void setUnitJMSTopicDestinationUnit(JMSTopicDestinationUnit value);

} // JMSDeployRoot
