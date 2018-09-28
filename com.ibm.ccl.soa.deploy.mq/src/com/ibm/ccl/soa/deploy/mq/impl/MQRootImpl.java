/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

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
 * An implementation of the model object '<em><b>MQ Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQActivationSpecification <em>Capability MQ Activation Specification</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQBaseSystem <em>Capability MQ Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQConnectionFactories <em>Capability MQ Connection Factories</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQDestination <em>Capability MQ Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQListener <em>Capability MQ Listener</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQMessagingProvider <em>Capability MQ Messaging Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQMesseageListernerServicePort <em>Capability MQ Messeage Listerner Service Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQQueue <em>Capability MQ Queue</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQQueueChannel <em>Capability MQ Queue Channel</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQQueueConnectionFactory <em>Capability MQ Queue Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQQueueDestination <em>Capability MQ Queue Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQQueueManager <em>Capability MQ Queue Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQTopicConnectionFactory <em>Capability MQ Topic Connection Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getCapabilityMQTopicDestination <em>Capability MQ Topic Destination</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQActivationSpecificationUnit <em>Unit MQ Activation Specification Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQBaseSystemUnit <em>Unit MQ Base System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQConnectionFactoriesUnit <em>Unit MQ Connection Factories Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQListenerUnit <em>Unit MQ Listener Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQMessageListnerServicePortUnit <em>Unit MQ Message Listner Service Port Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQMessagingProviderUnit <em>Unit MQ Messaging Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQQueueChannelUnit <em>Unit MQ Queue Channel Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQQueueConnectionFactoryUnit <em>Unit MQ Queue Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQQueueDestinationUnit <em>Unit MQ Queue Destination Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQQueueManagerUnit <em>Unit MQ Queue Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQQueueUnit <em>Unit MQ Queue Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQTopicConnectionFactoryUnit <em>Unit MQ Topic Connection Factory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl#getUnitMQTopicDestinationUnit <em>Unit MQ Topic Destination Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQRootImpl extends EObjectImpl implements MQRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MQRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MQ_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, MqPackage.MQ_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQActivationSpecification getCapabilityMQActivationSpecification() {
		return (MQActivationSpecification)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQActivationSpecification(MQActivationSpecification newCapabilityMQActivationSpecification, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION, newCapabilityMQActivationSpecification, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQActivationSpecification(MQActivationSpecification newCapabilityMQActivationSpecification) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION, newCapabilityMQActivationSpecification);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQBaseSystem getCapabilityMQBaseSystem() {
		return (MQBaseSystem)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQBaseSystem(MQBaseSystem newCapabilityMQBaseSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM, newCapabilityMQBaseSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQBaseSystem(MQBaseSystem newCapabilityMQBaseSystem) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM, newCapabilityMQBaseSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQConnectionFactories getCapabilityMQConnectionFactories() {
		return (MQConnectionFactories)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQConnectionFactories(MQConnectionFactories newCapabilityMQConnectionFactories, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES, newCapabilityMQConnectionFactories, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQConnectionFactories(MQConnectionFactories newCapabilityMQConnectionFactories) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES, newCapabilityMQConnectionFactories);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQDestination getCapabilityMQDestination() {
		return (MQDestination)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQDestination(MQDestination newCapabilityMQDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION, newCapabilityMQDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQDestination(MQDestination newCapabilityMQDestination) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION, newCapabilityMQDestination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQListener getCapabilityMQListener() {
		return (MQListener)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_LISTENER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQListener(MQListener newCapabilityMQListener, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_LISTENER, newCapabilityMQListener, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQListener(MQListener newCapabilityMQListener) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_LISTENER, newCapabilityMQListener);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessagingProvider getCapabilityMQMessagingProvider() {
		return (MQMessagingProvider)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQMessagingProvider(MQMessagingProvider newCapabilityMQMessagingProvider, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER, newCapabilityMQMessagingProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQMessagingProvider(MQMessagingProvider newCapabilityMQMessagingProvider) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER, newCapabilityMQMessagingProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MesseageListernerServicePort getCapabilityMQMesseageListernerServicePort() {
		return (MesseageListernerServicePort)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQMesseageListernerServicePort(MesseageListernerServicePort newCapabilityMQMesseageListernerServicePort, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT, newCapabilityMQMesseageListernerServicePort, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQMesseageListernerServicePort(MesseageListernerServicePort newCapabilityMQMesseageListernerServicePort) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT, newCapabilityMQMesseageListernerServicePort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueue getCapabilityMQQueue() {
		return (MQQueue)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQQueue(MQQueue newCapabilityMQQueue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE, newCapabilityMQQueue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQQueue(MQQueue newCapabilityMQQueue) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE, newCapabilityMQQueue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueChannel getCapabilityMQQueueChannel() {
		return (MQQueueChannel)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQQueueChannel(MQQueueChannel newCapabilityMQQueueChannel, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL, newCapabilityMQQueueChannel, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQQueueChannel(MQQueueChannel newCapabilityMQQueueChannel) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL, newCapabilityMQQueueChannel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueConnectionFactory getCapabilityMQQueueConnectionFactory() {
		return (MQQueueConnectionFactory)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQQueueConnectionFactory(MQQueueConnectionFactory newCapabilityMQQueueConnectionFactory, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY, newCapabilityMQQueueConnectionFactory, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQQueueConnectionFactory(MQQueueConnectionFactory newCapabilityMQQueueConnectionFactory) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY, newCapabilityMQQueueConnectionFactory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueDestination getCapabilityMQQueueDestination() {
		return (MQQueueDestination)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQQueueDestination(MQQueueDestination newCapabilityMQQueueDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION, newCapabilityMQQueueDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQQueueDestination(MQQueueDestination newCapabilityMQQueueDestination) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION, newCapabilityMQQueueDestination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueManager getCapabilityMQQueueManager() {
		return (MQQueueManager)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQQueueManager(MQQueueManager newCapabilityMQQueueManager, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER, newCapabilityMQQueueManager, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQQueueManager(MQQueueManager newCapabilityMQQueueManager) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER, newCapabilityMQQueueManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicConnectionFactory getCapabilityMQTopicConnectionFactory() {
		return (MQTopicConnectionFactory)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQTopicConnectionFactory(MQTopicConnectionFactory newCapabilityMQTopicConnectionFactory, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY, newCapabilityMQTopicConnectionFactory, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQTopicConnectionFactory(MQTopicConnectionFactory newCapabilityMQTopicConnectionFactory) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY, newCapabilityMQTopicConnectionFactory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicDestination getCapabilityMQTopicDestination() {
		return (MQTopicDestination)getMixed().get(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityMQTopicDestination(MQTopicDestination newCapabilityMQTopicDestination, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION, newCapabilityMQTopicDestination, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityMQTopicDestination(MQTopicDestination newCapabilityMQTopicDestination) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION, newCapabilityMQTopicDestination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQActivationSpecificationUnit getUnitMQActivationSpecificationUnit() {
		return (MQActivationSpecificationUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQActivationSpecificationUnit(MQActivationSpecificationUnit newUnitMQActivationSpecificationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT, newUnitMQActivationSpecificationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQActivationSpecificationUnit(MQActivationSpecificationUnit newUnitMQActivationSpecificationUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT, newUnitMQActivationSpecificationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQBaseSystemUnit getUnitMQBaseSystemUnit() {
		return (MQBaseSystemUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQBaseSystemUnit(MQBaseSystemUnit newUnitMQBaseSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT, newUnitMQBaseSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQBaseSystemUnit(MQBaseSystemUnit newUnitMQBaseSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT, newUnitMQBaseSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQConnectionFactoriesUnit getUnitMQConnectionFactoriesUnit() {
		return (MQConnectionFactoriesUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQConnectionFactoriesUnit(MQConnectionFactoriesUnit newUnitMQConnectionFactoriesUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT, newUnitMQConnectionFactoriesUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQConnectionFactoriesUnit(MQConnectionFactoriesUnit newUnitMQConnectionFactoriesUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT, newUnitMQConnectionFactoriesUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQListenerUnit getUnitMQListenerUnit() {
		return (MQListenerUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_LISTENER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQListenerUnit(MQListenerUnit newUnitMQListenerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_LISTENER_UNIT, newUnitMQListenerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQListenerUnit(MQListenerUnit newUnitMQListenerUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_LISTENER_UNIT, newUnitMQListenerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessageListnerServicePortUnit getUnitMQMessageListnerServicePortUnit() {
		return (MQMessageListnerServicePortUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit newUnitMQMessageListnerServicePortUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT, newUnitMQMessageListnerServicePortUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQMessageListnerServicePortUnit(MQMessageListnerServicePortUnit newUnitMQMessageListnerServicePortUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT, newUnitMQMessageListnerServicePortUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQMessagingProviderUnit getUnitMQMessagingProviderUnit() {
		return (MQMessagingProviderUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQMessagingProviderUnit(MQMessagingProviderUnit newUnitMQMessagingProviderUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT, newUnitMQMessagingProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQMessagingProviderUnit(MQMessagingProviderUnit newUnitMQMessagingProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT, newUnitMQMessagingProviderUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueChannelUnit getUnitMQQueueChannelUnit() {
		return (MQQueueChannelUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQQueueChannelUnit(MQQueueChannelUnit newUnitMQQueueChannelUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT, newUnitMQQueueChannelUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQQueueChannelUnit(MQQueueChannelUnit newUnitMQQueueChannelUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT, newUnitMQQueueChannelUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueConnectionFactoryUnit getUnitMQQueueConnectionFactoryUnit() {
		return (MQQueueConnectionFactoryUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit newUnitMQQueueConnectionFactoryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT, newUnitMQQueueConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQQueueConnectionFactoryUnit(MQQueueConnectionFactoryUnit newUnitMQQueueConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT, newUnitMQQueueConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueDestinationUnit getUnitMQQueueDestinationUnit() {
		return (MQQueueDestinationUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQQueueDestinationUnit(MQQueueDestinationUnit newUnitMQQueueDestinationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT, newUnitMQQueueDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQQueueDestinationUnit(MQQueueDestinationUnit newUnitMQQueueDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT, newUnitMQQueueDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueManagerUnit getUnitMQQueueManagerUnit() {
		return (MQQueueManagerUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQQueueManagerUnit(MQQueueManagerUnit newUnitMQQueueManagerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT, newUnitMQQueueManagerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQQueueManagerUnit(MQQueueManagerUnit newUnitMQQueueManagerUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT, newUnitMQQueueManagerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQQueueUnit getUnitMQQueueUnit() {
		return (MQQueueUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQQueueUnit(MQQueueUnit newUnitMQQueueUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_UNIT, newUnitMQQueueUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQQueueUnit(MQQueueUnit newUnitMQQueueUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_UNIT, newUnitMQQueueUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicConnectionFactoryUnit getUnitMQTopicConnectionFactoryUnit() {
		return (MQTopicConnectionFactoryUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit newUnitMQTopicConnectionFactoryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT, newUnitMQTopicConnectionFactoryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQTopicConnectionFactoryUnit(MQTopicConnectionFactoryUnit newUnitMQTopicConnectionFactoryUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT, newUnitMQTopicConnectionFactoryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTopicDestinationUnit getUnitMQTopicDestinationUnit() {
		return (MQTopicDestinationUnit)getMixed().get(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitMQTopicDestinationUnit(MQTopicDestinationUnit newUnitMQTopicDestinationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT, newUnitMQTopicDestinationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitMQTopicDestinationUnit(MQTopicDestinationUnit newUnitMQTopicDestinationUnit) {
		((FeatureMap.Internal)getMixed()).set(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT, newUnitMQTopicDestinationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MqPackage.MQ_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
				return basicSetCapabilityMQActivationSpecification(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
				return basicSetCapabilityMQBaseSystem(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
				return basicSetCapabilityMQConnectionFactories(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
				return basicSetCapabilityMQDestination(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
				return basicSetCapabilityMQListener(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
				return basicSetCapabilityMQMessagingProvider(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
				return basicSetCapabilityMQMesseageListernerServicePort(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
				return basicSetCapabilityMQQueue(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
				return basicSetCapabilityMQQueueChannel(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
				return basicSetCapabilityMQQueueConnectionFactory(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
				return basicSetCapabilityMQQueueDestination(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
				return basicSetCapabilityMQQueueManager(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
				return basicSetCapabilityMQTopicConnectionFactory(null, msgs);
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
				return basicSetCapabilityMQTopicDestination(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
				return basicSetUnitMQActivationSpecificationUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
				return basicSetUnitMQBaseSystemUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
				return basicSetUnitMQConnectionFactoriesUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
				return basicSetUnitMQListenerUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
				return basicSetUnitMQMessageListnerServicePortUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
				return basicSetUnitMQMessagingProviderUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
				return basicSetUnitMQQueueChannelUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
				return basicSetUnitMQQueueConnectionFactoryUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
				return basicSetUnitMQQueueDestinationUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
				return basicSetUnitMQQueueManagerUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
				return basicSetUnitMQQueueUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
				return basicSetUnitMQTopicConnectionFactoryUnit(null, msgs);
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				return basicSetUnitMQTopicDestinationUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MQ_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
				return getCapabilityMQActivationSpecification();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
				return getCapabilityMQBaseSystem();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
				return getCapabilityMQConnectionFactories();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
				return getCapabilityMQDestination();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
				return getCapabilityMQListener();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
				return getCapabilityMQMessagingProvider();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
				return getCapabilityMQMesseageListernerServicePort();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
				return getCapabilityMQQueue();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
				return getCapabilityMQQueueChannel();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
				return getCapabilityMQQueueConnectionFactory();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
				return getCapabilityMQQueueDestination();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
				return getCapabilityMQQueueManager();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
				return getCapabilityMQTopicConnectionFactory();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
				return getCapabilityMQTopicDestination();
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitMQActivationSpecificationUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
				return getUnitMQBaseSystemUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
				return getUnitMQConnectionFactoriesUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
				return getUnitMQListenerUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
				return getUnitMQMessageListnerServicePortUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
				return getUnitMQMessagingProviderUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
				return getUnitMQQueueChannelUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitMQQueueConnectionFactoryUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
				return getUnitMQQueueDestinationUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
				return getUnitMQQueueManagerUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
				return getUnitMQQueueUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitMQTopicConnectionFactoryUnit();
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				return getUnitMQTopicDestinationUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MqPackage.MQ_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
				setCapabilityMQActivationSpecification((MQActivationSpecification)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
				setCapabilityMQBaseSystem((MQBaseSystem)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
				setCapabilityMQConnectionFactories((MQConnectionFactories)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
				setCapabilityMQDestination((MQDestination)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
				setCapabilityMQListener((MQListener)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
				setCapabilityMQMessagingProvider((MQMessagingProvider)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
				setCapabilityMQMesseageListernerServicePort((MesseageListernerServicePort)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
				setCapabilityMQQueue((MQQueue)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
				setCapabilityMQQueueChannel((MQQueueChannel)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
				setCapabilityMQQueueConnectionFactory((MQQueueConnectionFactory)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
				setCapabilityMQQueueDestination((MQQueueDestination)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
				setCapabilityMQQueueManager((MQQueueManager)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
				setCapabilityMQTopicConnectionFactory((MQTopicConnectionFactory)newValue);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
				setCapabilityMQTopicDestination((MQTopicDestination)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
				setUnitMQActivationSpecificationUnit((MQActivationSpecificationUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
				setUnitMQBaseSystemUnit((MQBaseSystemUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
				setUnitMQConnectionFactoriesUnit((MQConnectionFactoriesUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
				setUnitMQListenerUnit((MQListenerUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
				setUnitMQMessageListnerServicePortUnit((MQMessageListnerServicePortUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
				setUnitMQMessagingProviderUnit((MQMessagingProviderUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
				setUnitMQQueueChannelUnit((MQQueueChannelUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitMQQueueConnectionFactoryUnit((MQQueueConnectionFactoryUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
				setUnitMQQueueDestinationUnit((MQQueueDestinationUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
				setUnitMQQueueManagerUnit((MQQueueManagerUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
				setUnitMQQueueUnit((MQQueueUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitMQTopicConnectionFactoryUnit((MQTopicConnectionFactoryUnit)newValue);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				setUnitMQTopicDestinationUnit((MQTopicDestinationUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MqPackage.MQ_ROOT__MIXED:
				getMixed().clear();
				return;
			case MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
				setCapabilityMQActivationSpecification((MQActivationSpecification)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
				setCapabilityMQBaseSystem((MQBaseSystem)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
				setCapabilityMQConnectionFactories((MQConnectionFactories)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
				setCapabilityMQDestination((MQDestination)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
				setCapabilityMQListener((MQListener)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
				setCapabilityMQMessagingProvider((MQMessagingProvider)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
				setCapabilityMQMesseageListernerServicePort((MesseageListernerServicePort)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
				setCapabilityMQQueue((MQQueue)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
				setCapabilityMQQueueChannel((MQQueueChannel)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
				setCapabilityMQQueueConnectionFactory((MQQueueConnectionFactory)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
				setCapabilityMQQueueDestination((MQQueueDestination)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
				setCapabilityMQQueueManager((MQQueueManager)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
				setCapabilityMQTopicConnectionFactory((MQTopicConnectionFactory)null);
				return;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
				setCapabilityMQTopicDestination((MQTopicDestination)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
				setUnitMQActivationSpecificationUnit((MQActivationSpecificationUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
				setUnitMQBaseSystemUnit((MQBaseSystemUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
				setUnitMQConnectionFactoriesUnit((MQConnectionFactoriesUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
				setUnitMQListenerUnit((MQListenerUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
				setUnitMQMessageListnerServicePortUnit((MQMessageListnerServicePortUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
				setUnitMQMessagingProviderUnit((MQMessagingProviderUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
				setUnitMQQueueChannelUnit((MQQueueChannelUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
				setUnitMQQueueConnectionFactoryUnit((MQQueueConnectionFactoryUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
				setUnitMQQueueDestinationUnit((MQQueueDestinationUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
				setUnitMQQueueManagerUnit((MQQueueManagerUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
				setUnitMQQueueUnit((MQQueueUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
				setUnitMQTopicConnectionFactoryUnit((MQTopicConnectionFactoryUnit)null);
				return;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				setUnitMQTopicDestinationUnit((MQTopicDestinationUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MqPackage.MQ_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case MqPackage.MQ_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case MqPackage.MQ_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
				return getCapabilityMQActivationSpecification() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
				return getCapabilityMQBaseSystem() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
				return getCapabilityMQConnectionFactories() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
				return getCapabilityMQDestination() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
				return getCapabilityMQListener() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
				return getCapabilityMQMessagingProvider() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
				return getCapabilityMQMesseageListernerServicePort() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
				return getCapabilityMQQueue() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
				return getCapabilityMQQueueChannel() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
				return getCapabilityMQQueueConnectionFactory() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
				return getCapabilityMQQueueDestination() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
				return getCapabilityMQQueueManager() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
				return getCapabilityMQTopicConnectionFactory() != null;
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
				return getCapabilityMQTopicDestination() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
				return getUnitMQActivationSpecificationUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
				return getUnitMQBaseSystemUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
				return getUnitMQConnectionFactoriesUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
				return getUnitMQListenerUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
				return getUnitMQMessageListnerServicePortUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
				return getUnitMQMessagingProviderUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
				return getUnitMQQueueChannelUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
				return getUnitMQQueueConnectionFactoryUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
				return getUnitMQQueueDestinationUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
				return getUnitMQQueueManagerUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
				return getUnitMQQueueUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
				return getUnitMQTopicConnectionFactoryUnit() != null;
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				return getUnitMQTopicDestinationUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //MQRootImpl
