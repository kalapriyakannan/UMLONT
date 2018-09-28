/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import com.ibm.ccl.soa.deploy.mq.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.mq.MQActivationSpecification;
import com.ibm.ccl.soa.deploy.mq.MQActivationSpecificationUnit;
import com.ibm.ccl.soa.deploy.mq.MQBaseSystem;
import com.ibm.ccl.soa.deploy.mq.MQBaseSystemUnit;
import com.ibm.ccl.soa.deploy.mq.MQConnectionFactories;
import com.ibm.ccl.soa.deploy.mq.MQConnectionFactoriesUnit;
import com.ibm.ccl.soa.deploy.mq.MQDestination;
import com.ibm.ccl.soa.deploy.mq.MQListener;
import com.ibm.ccl.soa.deploy.mq.MQListenerUnit;
import com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit;
import com.ibm.ccl.soa.deploy.mq.MQMessagingProvider;
import com.ibm.ccl.soa.deploy.mq.MQMessagingProviderUnit;
import com.ibm.ccl.soa.deploy.mq.MQQueue;
import com.ibm.ccl.soa.deploy.mq.MQQueueChannel;
import com.ibm.ccl.soa.deploy.mq.MQQueueChannelUnit;
import com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.mq.MQQueueDestination;
import com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit;
import com.ibm.ccl.soa.deploy.mq.MQQueueManager;
import com.ibm.ccl.soa.deploy.mq.MQQueueManagerUnit;
import com.ibm.ccl.soa.deploy.mq.MQQueueUnit;
import com.ibm.ccl.soa.deploy.mq.MQRoot;
import com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory;
import com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactoryUnit;
import com.ibm.ccl.soa.deploy.mq.MQTopicDestination;
import com.ibm.ccl.soa.deploy.mq.MQTopicDestinationUnit;
import com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort;
import com.ibm.ccl.soa.deploy.mq.MqFactory;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MqFactoryImpl extends EFactoryImpl implements MqFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MqFactory init() {
		try {
			MqFactory theMqFactory = (MqFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/mq/1.0.0/"); //$NON-NLS-1$ 
			if (theMqFactory != null) {
				return theMqFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MqFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MqFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT: return createMesseageListernerServicePort();
			case MqPackage.MQ_ACTIVATION_SPECIFICATION: return createMQActivationSpecification();
			case MqPackage.MQ_ACTIVATION_SPECIFICATION_UNIT: return createMQActivationSpecificationUnit();
			case MqPackage.MQ_BASE_SYSTEM: return createMQBaseSystem();
			case MqPackage.MQ_BASE_SYSTEM_UNIT: return createMQBaseSystemUnit();
			case MqPackage.MQ_CONNECTION_FACTORIES: return createMQConnectionFactories();
			case MqPackage.MQ_CONNECTION_FACTORIES_UNIT: return createMQConnectionFactoriesUnit();
			case MqPackage.MQ_DESTINATION: return createMQDestination();
			case MqPackage.MQ_LISTENER: return createMQListener();
			case MqPackage.MQ_LISTENER_UNIT: return createMQListenerUnit();
			case MqPackage.MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT: return createMQMessageListnerServicePortUnit();
			case MqPackage.MQ_MESSAGING_PROVIDER: return createMQMessagingProvider();
			case MqPackage.MQ_MESSAGING_PROVIDER_UNIT: return createMQMessagingProviderUnit();
			case MqPackage.MQ_QUEUE: return createMQQueue();
			case MqPackage.MQ_QUEUE_CHANNEL: return createMQQueueChannel();
			case MqPackage.MQ_QUEUE_CHANNEL_UNIT: return createMQQueueChannelUnit();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY: return createMQQueueConnectionFactory();
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY_UNIT: return createMQQueueConnectionFactoryUnit();
			case MqPackage.MQ_QUEUE_DESTINATION: return createMQQueueDestination();
			case MqPackage.MQ_QUEUE_DESTINATION_UNIT: return createMQQueueDestinationUnit();
			case MqPackage.MQ_QUEUE_MANAGER: return createMQQueueManager();
			case MqPackage.MQ_QUEUE_MANAGER_UNIT: return createMQQueueManagerUnit();
			case MqPackage.MQ_QUEUE_UNIT: return createMQQueueUnit();
			case MqPackage.MQ_ROOT: return createMQRoot();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY: return createMQTopicConnectionFactory();
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY_UNIT: return createMQTopicConnectionFactoryUnit();
			case MqPackage.MQ_TOPIC_DESTINATION: return createMQTopicDestination();
			case MqPackage.MQ_TOPIC_DESTINATION_UNIT: return createMQTopicDestinationUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MesseageListernerServicePort createMesseageListernerServicePort() {
		MesseageListernerServicePortImpl messeageListernerServicePort = new MesseageListernerServicePortImpl();
		return messeageListernerServicePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQActivationSpecification createMQActivationSpecification() {
		MQActivationSpecificationImpl mqActivationSpecification = new MQActivationSpecificationImpl();
		return mqActivationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQActivationSpecificationUnit createMQActivationSpecificationUnit() {
		MQActivationSpecificationUnitImpl mqActivationSpecificationUnit = new MQActivationSpecificationUnitImpl();
		return mqActivationSpecificationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQBaseSystem createMQBaseSystem() {
		MQBaseSystemImpl mqBaseSystem = new MQBaseSystemImpl();
		return mqBaseSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQBaseSystemUnit createMQBaseSystemUnit() {
		MQBaseSystemUnitImpl mqBaseSystemUnit = new MQBaseSystemUnitImpl();
		return mqBaseSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQConnectionFactories createMQConnectionFactories() {
		MQConnectionFactoriesImpl mqConnectionFactories = new MQConnectionFactoriesImpl();
		return mqConnectionFactories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQConnectionFactoriesUnit createMQConnectionFactoriesUnit() {
		MQConnectionFactoriesUnitImpl mqConnectionFactoriesUnit = new MQConnectionFactoriesUnitImpl();
		return mqConnectionFactoriesUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQDestination createMQDestination() {
		MQDestinationImpl mqDestination = new MQDestinationImpl();
		return mqDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQListener createMQListener() {
		MQListenerImpl mqListener = new MQListenerImpl();
		return mqListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQListenerUnit createMQListenerUnit() {
		MQListenerUnitImpl mqListenerUnit = new MQListenerUnitImpl();
		return mqListenerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessageListnerServicePortUnit createMQMessageListnerServicePortUnit() {
		MQMessageListnerServicePortUnitImpl mqMessageListnerServicePortUnit = new MQMessageListnerServicePortUnitImpl();
		return mqMessageListnerServicePortUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessagingProvider createMQMessagingProvider() {
		MQMessagingProviderImpl mqMessagingProvider = new MQMessagingProviderImpl();
		return mqMessagingProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessagingProviderUnit createMQMessagingProviderUnit() {
		MQMessagingProviderUnitImpl mqMessagingProviderUnit = new MQMessagingProviderUnitImpl();
		return mqMessagingProviderUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueue createMQQueue() {
		MQQueueImpl mqQueue = new MQQueueImpl();
		return mqQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueChannel createMQQueueChannel() {
		MQQueueChannelImpl mqQueueChannel = new MQQueueChannelImpl();
		return mqQueueChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueChannelUnit createMQQueueChannelUnit() {
		MQQueueChannelUnitImpl mqQueueChannelUnit = new MQQueueChannelUnitImpl();
		return mqQueueChannelUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueConnectionFactory createMQQueueConnectionFactory() {
		MQQueueConnectionFactoryImpl mqQueueConnectionFactory = new MQQueueConnectionFactoryImpl();
		return mqQueueConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueConnectionFactoryUnit createMQQueueConnectionFactoryUnit() {
		MQQueueConnectionFactoryUnitImpl mqQueueConnectionFactoryUnit = new MQQueueConnectionFactoryUnitImpl();
		return mqQueueConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueDestination createMQQueueDestination() {
		MQQueueDestinationImpl mqQueueDestination = new MQQueueDestinationImpl();
		return mqQueueDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueDestinationUnit createMQQueueDestinationUnit() {
		MQQueueDestinationUnitImpl mqQueueDestinationUnit = new MQQueueDestinationUnitImpl();
		return mqQueueDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueManager createMQQueueManager() {
		MQQueueManagerImpl mqQueueManager = new MQQueueManagerImpl();
		return mqQueueManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueManagerUnit createMQQueueManagerUnit() {
		MQQueueManagerUnitImpl mqQueueManagerUnit = new MQQueueManagerUnitImpl();
		return mqQueueManagerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueUnit createMQQueueUnit() {
		MQQueueUnitImpl mqQueueUnit = new MQQueueUnitImpl();
		return mqQueueUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQRoot createMQRoot() {
		MQRootImpl mqRoot = new MQRootImpl();
		return mqRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicConnectionFactory createMQTopicConnectionFactory() {
		MQTopicConnectionFactoryImpl mqTopicConnectionFactory = new MQTopicConnectionFactoryImpl();
		return mqTopicConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicConnectionFactoryUnit createMQTopicConnectionFactoryUnit() {
		MQTopicConnectionFactoryUnitImpl mqTopicConnectionFactoryUnit = new MQTopicConnectionFactoryUnitImpl();
		return mqTopicConnectionFactoryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicDestination createMQTopicDestination() {
		MQTopicDestinationImpl mqTopicDestination = new MQTopicDestinationImpl();
		return mqTopicDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicDestinationUnit createMQTopicDestinationUnit() {
		MQTopicDestinationUnitImpl mqTopicDestinationUnit = new MQTopicDestinationUnitImpl();
		return mqTopicDestinationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MqPackage getMqPackage() {
		return (MqPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static MqPackage getPackage() {
		return MqPackage.eINSTANCE;
	}

} //MqFactoryImpl
