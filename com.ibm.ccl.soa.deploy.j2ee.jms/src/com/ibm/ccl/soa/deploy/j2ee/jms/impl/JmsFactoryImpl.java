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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum;
import com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsFactory;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class JmsFactoryImpl extends EFactoryImpl implements JmsFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JmsFactory init() {
		try {
			JmsFactory theJmsFactory = (JmsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/j2ee/jms/1.0.0/"); //$NON-NLS-1$ 
			if (theJmsFactory != null) {
				return theJmsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JmsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JmsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JmsPackage.JMS_ACTIVATION_SPECIFICATION: return createJMSActivationSpecification();
			case JmsPackage.JMS_ACTIVATION_SPECIFICATION_UNIT: return createJMSActivationSpecificationUnit();
			case JmsPackage.JMS_CONNECTION_FACTORY: return createJMSConnectionFactory();
			case JmsPackage.JMS_CONNECTION_FACTORY_UNIT: return createJMSConnectionFactoryUnit();
			case JmsPackage.JMS_DEPLOY_ROOT: return createJMSDeployRoot();
			case JmsPackage.JMS_DESTINATION: return createJMSDestination();
			case JmsPackage.JMS_PROVIDER: return createJMSProvider();
			case JmsPackage.JMS_PROVIDER_UNIT: return createJMSProviderUnit();
			case JmsPackage.JMS_QUEUE_CONNECTION_FACTORY: return createJMSQueueConnectionFactory();
			case JmsPackage.JMS_QUEUE_CONNECTION_FACTORY_UNIT: return createJMSQueueConnectionFactoryUnit();
			case JmsPackage.JMS_QUEUE_DESTINATION: return createJMSQueueDestination();
			case JmsPackage.JMS_QUEUE_DESTINATION_UNIT: return createJMSQueueDestinationUnit();
			case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY: return createJMSTopicConnectionFactory();
			case JmsPackage.JMS_TOPIC_CONNECTION_FACTORY_UNIT: return createJMSTopicConnectionFactoryUnit();
			case JmsPackage.JMS_TOPIC_DESTINATION: return createJMSTopicDestination();
			case JmsPackage.JMS_TOPIC_DESTINATION_UNIT: return createJMSTopicDestinationUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JmsPackage.ACKNOWLEDGE_MODE_ENUM:
				return createAcknowledgeModeEnumFromString(eDataType, initialValue);
			case JmsPackage.DESTINATION_TYPE_ENUM:
				return createDestinationTypeEnumFromString(eDataType, initialValue);
			case JmsPackage.ACKNOWLEDGE_MODE_ENUM_OBJECT:
				return createAcknowledgeModeEnumObjectFromString(eDataType, initialValue);
			case JmsPackage.DESTINATION_TYPE_ENUM_OBJECT:
				return createDestinationTypeEnumObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JmsPackage.ACKNOWLEDGE_MODE_ENUM:
				return convertAcknowledgeModeEnumToString(eDataType, instanceValue);
			case JmsPackage.DESTINATION_TYPE_ENUM:
				return convertDestinationTypeEnumToString(eDataType, instanceValue);
			case JmsPackage.ACKNOWLEDGE_MODE_ENUM_OBJECT:
				return convertAcknowledgeModeEnumObjectToString(eDataType, instanceValue);
			case JmsPackage.DESTINATION_TYPE_ENUM_OBJECT:
				return convertDestinationTypeEnumObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSActivationSpecification createJMSActivationSpecification() {
		JMSActivationSpecificationImpl jmsActivationSpecification = new JMSActivationSpecificationImpl();
		return jmsActivationSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSActivationSpecificationUnit createJMSActivationSpecificationUnit() {
		JMSActivationSpecificationUnitImpl jmsActivationSpecificationUnit = new JMSActivationSpecificationUnitImpl();
		return jmsActivationSpecificationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactory createJMSConnectionFactory() {
		JMSConnectionFactoryImpl jmsConnectionFactory = new JMSConnectionFactoryImpl();
		return jmsConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactoryUnit createJMSConnectionFactoryUnit() {
		JMSConnectionFactoryUnitImpl jmsConnectionFactoryUnit = new JMSConnectionFactoryUnitImpl();
		return jmsConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSDeployRoot createJMSDeployRoot() {
		JMSDeployRootImpl jmsDeployRoot = new JMSDeployRootImpl();
		return jmsDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSDestination createJMSDestination() {
		JMSDestinationImpl jmsDestination = new JMSDestinationImpl();
		return jmsDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSProvider createJMSProvider() {
		JMSProviderImpl jmsProvider = new JMSProviderImpl();
		return jmsProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSProviderUnit createJMSProviderUnit() {
		JMSProviderUnitImpl jmsProviderUnit = new JMSProviderUnitImpl();
		return jmsProviderUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueConnectionFactory createJMSQueueConnectionFactory() {
		JMSQueueConnectionFactoryImpl jmsQueueConnectionFactory = new JMSQueueConnectionFactoryImpl();
		return jmsQueueConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueConnectionFactoryUnit createJMSQueueConnectionFactoryUnit() {
		JMSQueueConnectionFactoryUnitImpl jmsQueueConnectionFactoryUnit = new JMSQueueConnectionFactoryUnitImpl();
		return jmsQueueConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueDestination createJMSQueueDestination() {
		JMSQueueDestinationImpl jmsQueueDestination = new JMSQueueDestinationImpl();
		return jmsQueueDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSQueueDestinationUnit createJMSQueueDestinationUnit() {
		JMSQueueDestinationUnitImpl jmsQueueDestinationUnit = new JMSQueueDestinationUnitImpl();
		return jmsQueueDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicConnectionFactory createJMSTopicConnectionFactory() {
		JMSTopicConnectionFactoryImpl jmsTopicConnectionFactory = new JMSTopicConnectionFactoryImpl();
		return jmsTopicConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicConnectionFactoryUnit createJMSTopicConnectionFactoryUnit() {
		JMSTopicConnectionFactoryUnitImpl jmsTopicConnectionFactoryUnit = new JMSTopicConnectionFactoryUnitImpl();
		return jmsTopicConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicDestination createJMSTopicDestination() {
		JMSTopicDestinationImpl jmsTopicDestination = new JMSTopicDestinationImpl();
		return jmsTopicDestination;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JMSTopicDestinationUnit createJMSTopicDestinationUnit() {
		JMSTopicDestinationUnitImpl jmsTopicDestinationUnit = new JMSTopicDestinationUnitImpl();
		return jmsTopicDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AcknowledgeModeEnum createAcknowledgeModeEnumFromString(EDataType eDataType,
			String initialValue) {
		AcknowledgeModeEnum result = AcknowledgeModeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAcknowledgeModeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DestinationTypeEnum createDestinationTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		DestinationTypeEnum result = DestinationTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDestinationTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AcknowledgeModeEnum createAcknowledgeModeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createAcknowledgeModeEnumFromString(JmsPackage.Literals.ACKNOWLEDGE_MODE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAcknowledgeModeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAcknowledgeModeEnumToString(JmsPackage.Literals.ACKNOWLEDGE_MODE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DestinationTypeEnum createDestinationTypeEnumObjectFromString(EDataType eDataType,
			String initialValue) {
		return createDestinationTypeEnumFromString(JmsPackage.Literals.DESTINATION_TYPE_ENUM, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDestinationTypeEnumObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDestinationTypeEnumToString(JmsPackage.Literals.DESTINATION_TYPE_ENUM, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JmsPackage getJmsPackage() {
		return (JmsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static JmsPackage getPackage() {
		return JmsPackage.eINSTANCE;
	}

} //JmsFactoryImpl
