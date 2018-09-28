/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.mq.*;
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
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage
 * @generated
 */
public class MqAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MqPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MqAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MqPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MqSwitch modelSwitch =
		new MqSwitch() {
			public Object caseMesseageListernerServicePort(MesseageListernerServicePort object) {
				return createMesseageListernerServicePortAdapter();
			}
			public Object caseMQActivationSpecification(MQActivationSpecification object) {
				return createMQActivationSpecificationAdapter();
			}
			public Object caseMQActivationSpecificationUnit(MQActivationSpecificationUnit object) {
				return createMQActivationSpecificationUnitAdapter();
			}
			public Object caseMQBaseSystem(MQBaseSystem object) {
				return createMQBaseSystemAdapter();
			}
			public Object caseMQBaseSystemUnit(MQBaseSystemUnit object) {
				return createMQBaseSystemUnitAdapter();
			}
			public Object caseMQConnectionFactories(MQConnectionFactories object) {
				return createMQConnectionFactoriesAdapter();
			}
			public Object caseMQConnectionFactoriesUnit(MQConnectionFactoriesUnit object) {
				return createMQConnectionFactoriesUnitAdapter();
			}
			public Object caseMQDestination(MQDestination object) {
				return createMQDestinationAdapter();
			}
			public Object caseMQListener(MQListener object) {
				return createMQListenerAdapter();
			}
			public Object caseMQListenerUnit(MQListenerUnit object) {
				return createMQListenerUnitAdapter();
			}
			public Object caseMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit object) {
				return createMQMessageListnerServicePortUnitAdapter();
			}
			public Object caseMQMessagingProvider(MQMessagingProvider object) {
				return createMQMessagingProviderAdapter();
			}
			public Object caseMQMessagingProviderUnit(MQMessagingProviderUnit object) {
				return createMQMessagingProviderUnitAdapter();
			}
			public Object caseMQQueue(MQQueue object) {
				return createMQQueueAdapter();
			}
			public Object caseMQQueueChannel(MQQueueChannel object) {
				return createMQQueueChannelAdapter();
			}
			public Object caseMQQueueChannelUnit(MQQueueChannelUnit object) {
				return createMQQueueChannelUnitAdapter();
			}
			public Object caseMQQueueConnectionFactory(MQQueueConnectionFactory object) {
				return createMQQueueConnectionFactoryAdapter();
			}
			public Object caseMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit object) {
				return createMQQueueConnectionFactoryUnitAdapter();
			}
			public Object caseMQQueueDestination(MQQueueDestination object) {
				return createMQQueueDestinationAdapter();
			}
			public Object caseMQQueueDestinationUnit(MQQueueDestinationUnit object) {
				return createMQQueueDestinationUnitAdapter();
			}
			public Object caseMQQueueManager(MQQueueManager object) {
				return createMQQueueManagerAdapter();
			}
			public Object caseMQQueueManagerUnit(MQQueueManagerUnit object) {
				return createMQQueueManagerUnitAdapter();
			}
			public Object caseMQQueueUnit(MQQueueUnit object) {
				return createMQQueueUnitAdapter();
			}
			public Object caseMQRoot(MQRoot object) {
				return createMQRootAdapter();
			}
			public Object caseMQTopicConnectionFactory(MQTopicConnectionFactory object) {
				return createMQTopicConnectionFactoryAdapter();
			}
			public Object caseMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit object) {
				return createMQTopicConnectionFactoryUnitAdapter();
			}
			public Object caseMQTopicDestination(MQTopicDestination object) {
				return createMQTopicDestinationAdapter();
			}
			public Object caseMQTopicDestinationUnit(MQTopicDestinationUnit object) {
				return createMQTopicDestinationUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort <em>Messeage Listerner Service Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort
	 * @generated
	 */
	public Adapter createMesseageListernerServicePortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification <em>MQ Activation Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification
	 * @generated
	 */
	public Adapter createMQActivationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecificationUnit <em>MQ Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecificationUnit
	 * @generated
	 */
	public Adapter createMQActivationSpecificationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem <em>MQ Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem
	 * @generated
	 */
	public Adapter createMQBaseSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystemUnit <em>MQ Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystemUnit
	 * @generated
	 */
	public Adapter createMQBaseSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories <em>MQ Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories
	 * @generated
	 */
	public Adapter createMQConnectionFactoriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactoriesUnit <em>MQ Connection Factories Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactoriesUnit
	 * @generated
	 */
	public Adapter createMQConnectionFactoriesUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQDestination <em>MQ Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination
	 * @generated
	 */
	public Adapter createMQDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQListener <em>MQ Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQListener
	 * @generated
	 */
	public Adapter createMQListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQListenerUnit <em>MQ Listener Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQListenerUnit
	 * @generated
	 */
	public Adapter createMQListenerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit <em>MQ Message Listner Service Port Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit
	 * @generated
	 */
	public Adapter createMQMessageListnerServicePortUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider <em>MQ Messaging Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider
	 * @generated
	 */
	public Adapter createMQMessagingProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProviderUnit <em>MQ Messaging Provider Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProviderUnit
	 * @generated
	 */
	public Adapter createMQMessagingProviderUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueue <em>MQ Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue
	 * @generated
	 */
	public Adapter createMQQueueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannel <em>MQ Queue Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueChannel
	 * @generated
	 */
	public Adapter createMQQueueChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannelUnit <em>MQ Queue Channel Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueChannelUnit
	 * @generated
	 */
	public Adapter createMQQueueChannelUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory <em>MQ Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory
	 * @generated
	 */
	public Adapter createMQQueueConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit <em>MQ Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createMQQueueConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueDestination <em>MQ Queue Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueDestination
	 * @generated
	 */
	public Adapter createMQQueueDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit <em>MQ Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit
	 * @generated
	 */
	public Adapter createMQQueueDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager <em>MQ Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager
	 * @generated
	 */
	public Adapter createMQQueueManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManagerUnit <em>MQ Queue Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManagerUnit
	 * @generated
	 */
	public Adapter createMQQueueManagerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueUnit <em>MQ Queue Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueUnit
	 * @generated
	 */
	public Adapter createMQQueueUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQRoot <em>MQ Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot
	 * @generated
	 */
	public Adapter createMQRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory <em>MQ Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory
	 * @generated
	 */
	public Adapter createMQTopicConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactoryUnit <em>MQ Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactoryUnit
	 * @generated
	 */
	public Adapter createMQTopicConnectionFactoryUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination <em>MQ Topic Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination
	 * @generated
	 */
	public Adapter createMQTopicDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestinationUnit <em>MQ Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestinationUnit
	 * @generated
	 */
	public Adapter createMQTopicDestinationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MqAdapterFactory
