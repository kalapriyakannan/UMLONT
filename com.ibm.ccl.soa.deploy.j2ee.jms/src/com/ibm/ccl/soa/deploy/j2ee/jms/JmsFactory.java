/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage
 * @generated
 */
public interface JmsFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	JmsFactory eINSTANCE = com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>JMS Activation Specification</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Activation Specification</em>'.
	 * @generated
	 */
	JMSActivationSpecification createJMSActivationSpecification();

	/**
	 * Returns a new object of class '<em>JMS Activation Specification Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JMS Activation Specification Unit</em>'.
	 * @generated
	 */
	JMSActivationSpecificationUnit createJMSActivationSpecificationUnit();

	/**
	 * Returns a new object of class '<em>JMS Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Connection Factory</em>'.
	 * @generated
	 */
	JMSConnectionFactory createJMSConnectionFactory();

	/**
	 * Returns a new object of class '<em>JMS Connection Factory Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Connection Factory Unit</em>'.
	 * @generated
	 */
	JMSConnectionFactoryUnit createJMSConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>JMS Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JMS Deploy Root</em>'.
	 * @generated
	 */
	JMSDeployRoot createJMSDeployRoot();

	/**
	 * Returns a new object of class '<em>JMS Destination</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JMS Destination</em>'.
	 * @generated
	 */
	JMSDestination createJMSDestination();

	/**
	 * Returns a new object of class '<em>JMS Provider</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JMS Provider</em>'.
	 * @generated
	 */
	JMSProvider createJMSProvider();

	/**
	 * Returns a new object of class '<em>JMS Provider Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>JMS Provider Unit</em>'.
	 * @generated
	 */
	JMSProviderUnit createJMSProviderUnit();

	/**
	 * Returns a new object of class '<em>JMS Queue Connection Factory</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Queue Connection Factory</em>'.
	 * @generated
	 */
	JMSQueueConnectionFactory createJMSQueueConnectionFactory();

	/**
	 * Returns a new object of class '<em>JMS Queue Connection Factory Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JMS Queue Connection Factory Unit</em>'.
	 * @generated
	 */
	JMSQueueConnectionFactoryUnit createJMSQueueConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>JMS Queue Destination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Queue Destination</em>'.
	 * @generated
	 */
	JMSQueueDestination createJMSQueueDestination();

	/**
	 * Returns a new object of class '<em>JMS Queue Destination Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Queue Destination Unit</em>'.
	 * @generated
	 */
	JMSQueueDestinationUnit createJMSQueueDestinationUnit();

	/**
	 * Returns a new object of class '<em>JMS Topic Connection Factory</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Topic Connection Factory</em>'.
	 * @generated
	 */
	JMSTopicConnectionFactory createJMSTopicConnectionFactory();

	/**
	 * Returns a new object of class '<em>JMS Topic Connection Factory Unit</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JMS Topic Connection Factory Unit</em>'.
	 * @generated
	 */
	JMSTopicConnectionFactoryUnit createJMSTopicConnectionFactoryUnit();

	/**
	 * Returns a new object of class '<em>JMS Topic Destination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Topic Destination</em>'.
	 * @generated
	 */
	JMSTopicDestination createJMSTopicDestination();

	/**
	 * Returns a new object of class '<em>JMS Topic Destination Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>JMS Topic Destination Unit</em>'.
	 * @generated
	 */
	JMSTopicDestinationUnit createJMSTopicDestinationUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JmsPackage getJmsPackage();

} //JmsFactory
