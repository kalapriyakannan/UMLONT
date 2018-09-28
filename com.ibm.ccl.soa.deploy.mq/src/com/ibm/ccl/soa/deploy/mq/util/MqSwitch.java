/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage
 * @generated
 */
public class MqSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MqPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MqSwitch() {
		if (modelPackage == null) {
			modelPackage = MqPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT: {
				MesseageListernerServicePort messeageListernerServicePort = (MesseageListernerServicePort)theEObject;
				Object result = caseMesseageListernerServicePort(messeageListernerServicePort);
				if (result == null) result = caseCapability(messeageListernerServicePort);
				if (result == null) result = caseDeployModelObject(messeageListernerServicePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_ACTIVATION_SPECIFICATION: {
				MQActivationSpecification mqActivationSpecification = (MQActivationSpecification)theEObject;
				Object result = caseMQActivationSpecification(mqActivationSpecification);
				if (result == null) result = caseCapability(mqActivationSpecification);
				if (result == null) result = caseDeployModelObject(mqActivationSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_ACTIVATION_SPECIFICATION_UNIT: {
				MQActivationSpecificationUnit mqActivationSpecificationUnit = (MQActivationSpecificationUnit)theEObject;
				Object result = caseMQActivationSpecificationUnit(mqActivationSpecificationUnit);
				if (result == null) result = caseUnit(mqActivationSpecificationUnit);
				if (result == null) result = caseDeployModelObject(mqActivationSpecificationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_BASE_SYSTEM: {
				MQBaseSystem mqBaseSystem = (MQBaseSystem)theEObject;
				Object result = caseMQBaseSystem(mqBaseSystem);
				if (result == null) result = caseCapability(mqBaseSystem);
				if (result == null) result = caseDeployModelObject(mqBaseSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_BASE_SYSTEM_UNIT: {
				MQBaseSystemUnit mqBaseSystemUnit = (MQBaseSystemUnit)theEObject;
				Object result = caseMQBaseSystemUnit(mqBaseSystemUnit);
				if (result == null) result = caseUnit(mqBaseSystemUnit);
				if (result == null) result = caseDeployModelObject(mqBaseSystemUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_CONNECTION_FACTORIES: {
				MQConnectionFactories mqConnectionFactories = (MQConnectionFactories)theEObject;
				Object result = caseMQConnectionFactories(mqConnectionFactories);
				if (result == null) result = caseCapability(mqConnectionFactories);
				if (result == null) result = caseDeployModelObject(mqConnectionFactories);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_CONNECTION_FACTORIES_UNIT: {
				MQConnectionFactoriesUnit mqConnectionFactoriesUnit = (MQConnectionFactoriesUnit)theEObject;
				Object result = caseMQConnectionFactoriesUnit(mqConnectionFactoriesUnit);
				if (result == null) result = caseUnit(mqConnectionFactoriesUnit);
				if (result == null) result = caseDeployModelObject(mqConnectionFactoriesUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_DESTINATION: {
				MQDestination mqDestination = (MQDestination)theEObject;
				Object result = caseMQDestination(mqDestination);
				if (result == null) result = caseCapability(mqDestination);
				if (result == null) result = caseDeployModelObject(mqDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_LISTENER: {
				MQListener mqListener = (MQListener)theEObject;
				Object result = caseMQListener(mqListener);
				if (result == null) result = caseCapability(mqListener);
				if (result == null) result = caseDeployModelObject(mqListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_LISTENER_UNIT: {
				MQListenerUnit mqListenerUnit = (MQListenerUnit)theEObject;
				Object result = caseMQListenerUnit(mqListenerUnit);
				if (result == null) result = caseUnit(mqListenerUnit);
				if (result == null) result = caseDeployModelObject(mqListenerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT: {
				MQMessageListnerServicePortUnit mqMessageListnerServicePortUnit = (MQMessageListnerServicePortUnit)theEObject;
				Object result = caseMQMessageListnerServicePortUnit(mqMessageListnerServicePortUnit);
				if (result == null) result = caseUnit(mqMessageListnerServicePortUnit);
				if (result == null) result = caseDeployModelObject(mqMessageListnerServicePortUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_MESSAGING_PROVIDER: {
				MQMessagingProvider mqMessagingProvider = (MQMessagingProvider)theEObject;
				Object result = caseMQMessagingProvider(mqMessagingProvider);
				if (result == null) result = caseCapability(mqMessagingProvider);
				if (result == null) result = caseDeployModelObject(mqMessagingProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_MESSAGING_PROVIDER_UNIT: {
				MQMessagingProviderUnit mqMessagingProviderUnit = (MQMessagingProviderUnit)theEObject;
				Object result = caseMQMessagingProviderUnit(mqMessagingProviderUnit);
				if (result == null) result = caseUnit(mqMessagingProviderUnit);
				if (result == null) result = caseDeployModelObject(mqMessagingProviderUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE: {
				MQQueue mqQueue = (MQQueue)theEObject;
				Object result = caseMQQueue(mqQueue);
				if (result == null) result = caseCapability(mqQueue);
				if (result == null) result = caseDeployModelObject(mqQueue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_CHANNEL: {
				MQQueueChannel mqQueueChannel = (MQQueueChannel)theEObject;
				Object result = caseMQQueueChannel(mqQueueChannel);
				if (result == null) result = caseCapability(mqQueueChannel);
				if (result == null) result = caseDeployModelObject(mqQueueChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_CHANNEL_UNIT: {
				MQQueueChannelUnit mqQueueChannelUnit = (MQQueueChannelUnit)theEObject;
				Object result = caseMQQueueChannelUnit(mqQueueChannelUnit);
				if (result == null) result = caseUnit(mqQueueChannelUnit);
				if (result == null) result = caseDeployModelObject(mqQueueChannelUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY: {
				MQQueueConnectionFactory mqQueueConnectionFactory = (MQQueueConnectionFactory)theEObject;
				Object result = caseMQQueueConnectionFactory(mqQueueConnectionFactory);
				if (result == null) result = caseCapability(mqQueueConnectionFactory);
				if (result == null) result = caseDeployModelObject(mqQueueConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY_UNIT: {
				MQQueueConnectionFactoryUnit mqQueueConnectionFactoryUnit = (MQQueueConnectionFactoryUnit)theEObject;
				Object result = caseMQQueueConnectionFactoryUnit(mqQueueConnectionFactoryUnit);
				if (result == null) result = caseUnit(mqQueueConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(mqQueueConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_DESTINATION: {
				MQQueueDestination mqQueueDestination = (MQQueueDestination)theEObject;
				Object result = caseMQQueueDestination(mqQueueDestination);
				if (result == null) result = caseMQDestination(mqQueueDestination);
				if (result == null) result = caseCapability(mqQueueDestination);
				if (result == null) result = caseDeployModelObject(mqQueueDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_DESTINATION_UNIT: {
				MQQueueDestinationUnit mqQueueDestinationUnit = (MQQueueDestinationUnit)theEObject;
				Object result = caseMQQueueDestinationUnit(mqQueueDestinationUnit);
				if (result == null) result = caseUnit(mqQueueDestinationUnit);
				if (result == null) result = caseDeployModelObject(mqQueueDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_MANAGER: {
				MQQueueManager mqQueueManager = (MQQueueManager)theEObject;
				Object result = caseMQQueueManager(mqQueueManager);
				if (result == null) result = caseCapability(mqQueueManager);
				if (result == null) result = caseDeployModelObject(mqQueueManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_MANAGER_UNIT: {
				MQQueueManagerUnit mqQueueManagerUnit = (MQQueueManagerUnit)theEObject;
				Object result = caseMQQueueManagerUnit(mqQueueManagerUnit);
				if (result == null) result = caseUnit(mqQueueManagerUnit);
				if (result == null) result = caseDeployModelObject(mqQueueManagerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_QUEUE_UNIT: {
				MQQueueUnit mqQueueUnit = (MQQueueUnit)theEObject;
				Object result = caseMQQueueUnit(mqQueueUnit);
				if (result == null) result = caseUnit(mqQueueUnit);
				if (result == null) result = caseDeployModelObject(mqQueueUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_ROOT: {
				MQRoot mqRoot = (MQRoot)theEObject;
				Object result = caseMQRoot(mqRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY: {
				MQTopicConnectionFactory mqTopicConnectionFactory = (MQTopicConnectionFactory)theEObject;
				Object result = caseMQTopicConnectionFactory(mqTopicConnectionFactory);
				if (result == null) result = caseCapability(mqTopicConnectionFactory);
				if (result == null) result = caseDeployModelObject(mqTopicConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_TOPIC_CONNECTION_FACTORY_UNIT: {
				MQTopicConnectionFactoryUnit mqTopicConnectionFactoryUnit = (MQTopicConnectionFactoryUnit)theEObject;
				Object result = caseMQTopicConnectionFactoryUnit(mqTopicConnectionFactoryUnit);
				if (result == null) result = caseUnit(mqTopicConnectionFactoryUnit);
				if (result == null) result = caseDeployModelObject(mqTopicConnectionFactoryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_TOPIC_DESTINATION: {
				MQTopicDestination mqTopicDestination = (MQTopicDestination)theEObject;
				Object result = caseMQTopicDestination(mqTopicDestination);
				if (result == null) result = caseCapability(mqTopicDestination);
				if (result == null) result = caseDeployModelObject(mqTopicDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MqPackage.MQ_TOPIC_DESTINATION_UNIT: {
				MQTopicDestinationUnit mqTopicDestinationUnit = (MQTopicDestinationUnit)theEObject;
				Object result = caseMQTopicDestinationUnit(mqTopicDestinationUnit);
				if (result == null) result = caseUnit(mqTopicDestinationUnit);
				if (result == null) result = caseDeployModelObject(mqTopicDestinationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Messeage Listerner Service Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Messeage Listerner Service Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMesseageListernerServicePort(MesseageListernerServicePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Activation Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Activation Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQActivationSpecification(MQActivationSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Activation Specification Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Activation Specification Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQActivationSpecificationUnit(MQActivationSpecificationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Base System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Base System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQBaseSystem(MQBaseSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Base System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Base System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQBaseSystemUnit(MQBaseSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Connection Factories</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Connection Factories</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQConnectionFactories(MQConnectionFactories object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Connection Factories Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Connection Factories Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQConnectionFactoriesUnit(MQConnectionFactoriesUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQDestination(MQDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQListener(MQListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Listener Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Listener Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQListenerUnit(MQListenerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Message Listner Service Port Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Message Listner Service Port Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Messaging Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Messaging Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQMessagingProvider(MQMessagingProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Messaging Provider Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Messaging Provider Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQMessagingProviderUnit(MQMessagingProviderUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueue(MQQueue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Channel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueChannel(MQQueueChannel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Channel Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Channel Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueChannelUnit(MQQueueChannelUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueConnectionFactory(MQQueueConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Connection Factory Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueDestination(MQQueueDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Destination Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueDestinationUnit(MQQueueDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueManager(MQQueueManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Manager Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Manager Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueManagerUnit(MQQueueManagerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Queue Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Queue Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQQueueUnit(MQQueueUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQRoot(MQRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Topic Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Topic Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQTopicConnectionFactory(MQTopicConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Topic Connection Factory Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Topic Connection Factory Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Topic Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Topic Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQTopicDestination(MQTopicDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MQ Topic Destination Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MQ Topic Destination Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMQTopicDestinationUnit(MQTopicDestinationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //MqSwitch
