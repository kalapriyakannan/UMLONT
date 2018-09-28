/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MqPackageImpl extends EPackageImpl implements MqPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messeageListernerServicePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqActivationSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqActivationSpecificationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqBaseSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqBaseSystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqConnectionFactoriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqConnectionFactoriesUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqDestinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqListenerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqMessageListnerServicePortUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqMessagingProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqMessagingProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueChannelUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueDestinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueDestinationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueManagerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqQueueUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqTopicConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqTopicConnectionFactoryUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqTopicDestinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mqTopicDestinationUnitEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MqPackageImpl() {
		super(eNS_URI, MqFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MqPackage init() {
		if (isInited) return (MqPackage)EPackage.Registry.INSTANCE.getEPackage(MqPackage.eNS_URI);

		// Obtain or create and register package
		MqPackageImpl theMqPackage = (MqPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MqPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MqPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMqPackage.createPackageContents();

		// Initialize created meta-data
		theMqPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMqPackage.freeze();

		return theMqPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMesseageListernerServicePort() {
		return messeageListernerServicePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMesseageListernerServicePort_CFJNDIName() {
		return (EAttribute)messeageListernerServicePortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMesseageListernerServicePort_DestinationJNDIName() {
		return (EAttribute)messeageListernerServicePortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMesseageListernerServicePort_MaxRetries() {
		return (EAttribute)messeageListernerServicePortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMesseageListernerServicePort_MaxSessions() {
		return (EAttribute)messeageListernerServicePortEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMesseageListernerServicePort_Name1() {
		return (EAttribute)messeageListernerServicePortEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQActivationSpecification() {
		return mqActivationSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_ClientIdentifier() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_JndiName() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_MesasageSelector() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_SpecificationName() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_SubscriptionDurable() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQActivationSpecification_SubscriptionName() {
		return (EAttribute)mqActivationSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQActivationSpecificationUnit() {
		return mqActivationSpecificationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQBaseSystem() {
		return mqBaseSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQBaseSystem_InitialContextFactory() {
		return (EAttribute)mqBaseSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQBaseSystem_ProviderName() {
		return (EAttribute)mqBaseSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQBaseSystem_ProviderURL() {
		return (EAttribute)mqBaseSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQBaseSystem_ProviderVersion() {
		return (EAttribute)mqBaseSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQBaseSystemUnit() {
		return mqBaseSystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQConnectionFactories() {
		return mqConnectionFactoriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerCCSubscriptionQueue() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerControlQueue() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerMessageSelection() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerPublicationQueue() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerQueueManager() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerSubscriptionQueue() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_BrokerVersion() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_Category() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_CCSID() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_Channel() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ClientId() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ComponentManagedAuthenticationAlias() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ContainerManagedAuthenticationAlias() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_DirectBrokerAuthorizationType() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableCloneSupport() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableMessageRetention() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableMQConnectionPooling() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableMulticastTransport() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableReturnMethodsDuringShutdown() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_EnableSparseBrokerSubscriptions() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_Host() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_JndiName() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_LocalServerAddress() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_MappingConfigurationAlias() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ModelQueueDefinition() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_Name1() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PersistentSubscriptionsStore() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PollingInterval() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_Port() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ProxyHostName() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_ProxyPort() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PublishAndAcknowledgementInterval() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PublishAndSubscribeCleanupInterval() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PublishAndSubscribeCleanupLevel() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_PublishAndSubscribeStatusInterval() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_QueueManager() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_RescanInterval() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_SSLCipherSuite() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_SSLCRL() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_SSLPeerName() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_TemporaryQueuePrefix() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_TransportType() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQConnectionFactories_XAEnabled() {
		return (EAttribute)mqConnectionFactoriesEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQConnectionFactoriesUnit() {
		return mqConnectionFactoriesUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQDestination() {
		return mqDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_BaseQueueManagerName() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_BaseQueueName() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Category() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_CCSID() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_DecimalEncoding() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Description1() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_DestinationName() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Expiry() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_FloatingPointEncoding() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_IntegerEncoding() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_JndiName() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Password() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Persitence() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_Priority() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_QueueManagerHost() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_QueueManagerPort() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_ServerConnectionChannelName() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_SpecifiedExpiry() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_SpecifiedPriority() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_TargetClient() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_UseNativeEncoding() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQDestination_UserID() {
		return (EAttribute)mqDestinationEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQListener() {
		return mqListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQListener_Port() {
		return (EAttribute)mqListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQListenerUnit() {
		return mqListenerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQMessageListnerServicePortUnit() {
		return mqMessageListnerServicePortUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQMessagingProvider() {
		return mqMessagingProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQMessagingProvider_ClassPath() {
		return (EAttribute)mqMessagingProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQMessagingProvider_Description1() {
		return (EAttribute)mqMessagingProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQMessagingProvider_Name1() {
		return (EAttribute)mqMessagingProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQMessagingProvider_NativePath() {
		return (EAttribute)mqMessagingProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQMessagingProviderUnit() {
		return mqMessagingProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueue() {
		return mqQueueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_BackoutRequeueQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_BackoutThreshold() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_BaseQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_BaseQueueName() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_CLWLQueuePriority() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_CLWLQueueRank() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_CLWLUQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_CouplingFacilityName() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DefaultBindType() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DefaultInputOpenOption() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DefaultPriority() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DefinitionType() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Description1() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DistributionList() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_DistributionLists() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_GetMessages() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_HardenGetBackout() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_InitiationQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_MaxMessageLength() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_MaxQueueDepth() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_MessageDeliverySequence() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_NotSharedInCluster() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_NPMClass() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Persistence() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_ProcessName() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_PutMessage() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_PutMessages() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QSGDisposition() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueAccounting() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueDepthHighEvents() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueDepthHighLimit() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueDepthLowEvents() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueDepthLowLimit() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueDepthMaxEvents() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueMonitoring() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueName() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueServiceInterval() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueServiceIntervalEvents() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_QueueType() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_RemoteQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_RemoteQueueManager() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_RetentionInterval() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Scope() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Shareability() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_SharedInAListOfClusters() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_SharedInCluster() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatAlterationDate() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatAlterationTime() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatCreationDate() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatCreationTime() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatCurrentQueueDepth() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatOpenInputCount() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatOpenOutputCount() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatQueueMonitoring() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StatQueueStatistics() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_StorageClassName() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TransmissionQueue() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TriggerControl() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TriggerData() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TriggerDepth() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TriggerMessagePriority() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_TriggerType() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Usage() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueue_Usage1() {
		return (EAttribute)mqQueueEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueChannel() {
		return mqQueueChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueChannel_ChannelName() {
		return (EAttribute)mqQueueChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueChannelUnit() {
		return mqQueueChannelUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueConnectionFactory() {
		return mqQueueConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Category() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_CCSID() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Channel() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_ClientId() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Description1() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_EnableConnectionPoling() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_EnableMessageRetention() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_FactoryName() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Host() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_JndiName() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_LocalServerAddress() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_MappingconfigurationAlias() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_MaxConnections() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_MaxSessions() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_MinConnections() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_MinSessions() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_ModelQueueDefinition() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_PollingInterval() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Port() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_Queuemanager() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_RescanInterval() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_SSLCipherSuit() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_SSLCRL() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_SSLPeerName() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_TemporaryQueuePrefix() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_TransportType() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueConnectionFactory_XAEnabled() {
		return (EAttribute)mqQueueConnectionFactoryEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueConnectionFactoryUnit() {
		return mqQueueConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueDestination() {
		return mqQueueDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueDestinationUnit() {
		return mqQueueDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueManager() {
		return mqQueueManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AccountingConnectionOverride() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AccountingInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ActivityRecording() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AdoptNewMCA() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AdoptNewMCACheck() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AdoptNewMCAType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_AuthorityEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_Automatic() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BridgeEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerMessageRetryCount() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerOpenCacheExpiry() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerOpenCacheSize() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerPublicBatchInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerPublishBatchSize() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_BrokerStreamsPerProcess() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelAutoDefinition() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelAutoDefinitionEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelInitiatorAdapters() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelInitiatorControl() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelInitiatorDispatchers() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelInitiatorTraceAutoStart() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelInitiatorTraceTableSize() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelMonitoring() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ChannelStatistics() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CheckpointActiveCount() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CheckpointMessageSize() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CheckpointRestartCount() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterSenderMonitoring() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterSenderStatistics() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterWorkLoadData() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterWorkLoadExit() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterWorkLoadLength() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ClusterWorkloadUseQ() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CodedCharSetId() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CommandEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CommandLevel() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CommandScope() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_CommandServerControl() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ConfigurationEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_Confirm() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_DeadLetterQueue() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_DefaultBindType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_DefaultTransmissionQueue() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_Description1() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_DNSGroup() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_DNSWLM() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ErrorLogSize() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ExcludedMessages() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ExitsDefaultPath() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ExpiryInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_IGQPutAuthority() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_IGQUserId() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_InhibitEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_InstallableServiceName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_IntraGroupQueuing() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_IPAddressVersion() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ListenerTimer() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LocalEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogBufferPages() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogFilePages() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogPath() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogPrimaryFiles() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogSecondaryFiles() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LogWriteIntegrity() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LU62ARMSuffix() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LU62Channels() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LUGroupName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LULibrary1() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LULibrary2() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LULocalLU() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LUName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_LUTPName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaxActiveChannels() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaxChannels() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaximumCurrentChannels() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaximumHandles() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaximumMessageLength() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaximumTCPChannels() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaximumUncommittedMessages() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MaxInitiators() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MQIAccounting() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MQIBindType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_MQIStatistics() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosAdaptorNumber() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosLibrary1() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosLocalName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosNumberOfCommands() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosNumberOfNames() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_NetBiosNumberOfSessions() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_OutboundPortMax() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_OutboundPortMin() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_PerformanceEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_PipeLineLength() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_Platform() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_QueueAccounting() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_QueueManagerName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_QueueManagerStatus() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(98);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_QueueMonitoring() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(99);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_QueueStatistics() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(100);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ReceiveTimeout() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(101);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ReceiveTimeoutMin() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(102);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ReceiveTimeoutType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(103);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_RemoteEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(104);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_RepositoryName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(105);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_RepositoryNameList() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(106);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_RoutingExitConnectType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(107);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_RoutingExitPath() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(108);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SecurityPolicy() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(109);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_ServiceEntryPoints() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(110);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SharedQQmgrName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(111);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SPXBoardNumber() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(112);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SPXKeepAlive() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(113);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SPXLibrary1() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(114);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SPXLibrary2() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(115);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SPXSocket() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(116);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLCRLNameList() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(117);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLCrytoHardware() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(118);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(119);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLFips() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(120);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLKeyRepository() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(121);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLKeyResetCount() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(122);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SSLTasks() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(123);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_StartStopEvent() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(124);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_StatisticsInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(125);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SuppresedMessages() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(126);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_SuppressedMessageInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(127);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPKeepAlive() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(128);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPLibrary1() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(129);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPLibrary2() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(130);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPListenerBacklog() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(131);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPName() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(132);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPPort() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(133);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TCPStackType() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(134);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TraceRouteRecording() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(135);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_TriggerInterval() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(136);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQQueueManager_WhatIf() {
		return (EAttribute)mqQueueManagerEClass.getEStructuralFeatures().get(137);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueManagerUnit() {
		return mqQueueManagerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQQueueUnit() {
		return mqQueueUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQRoot() {
		return mqRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQRoot_Mixed() {
		return (EAttribute)mqRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_XMLNSPrefixMap() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_XSISchemaLocation() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQActivationSpecification() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQBaseSystem() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQConnectionFactories() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQDestination() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQListener() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQMessagingProvider() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQMesseageListernerServicePort() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQQueue() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQQueueChannel() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQQueueConnectionFactory() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQQueueDestination() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQQueueManager() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQTopicConnectionFactory() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_CapabilityMQTopicDestination() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQActivationSpecificationUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQBaseSystemUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQConnectionFactoriesUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQListenerUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQMessageListnerServicePortUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQMessagingProviderUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQQueueChannelUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQQueueConnectionFactoryUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQQueueDestinationUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQQueueManagerUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQQueueUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQTopicConnectionFactoryUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMQRoot_UnitMQTopicDestinationUnit() {
		return (EReference)mqRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQTopicConnectionFactory() {
		return mqTopicConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerCCSubscriptionQueue() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerControlQueue() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerMessageSelection() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerPublicationQueue() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerQueueManager() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerSubscriptionQueue() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_BrokerVersion() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_Category() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_CCSIDId() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_Channel() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ClientId() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_Description1() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_DirectBrokerAuthorization() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_EnableCloneSupport() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_EnableMQConnectionPooling() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_EnableMulticastTransport() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_FactoryName() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_Host() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_JndiName() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_LocalServerAddress() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_MappingConfigurationAlias() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ModelQueueDefinition() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PersistentSubscriptionStore() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PollingInterval() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_Port() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ProxyHostName() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_ProxyPort() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PublishAndAcknowledgeLevel() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_QueueManager() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_RescanInterval() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_SSLCipherSuite() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_SSLCRL() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_SSLPeerName() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_TransportType() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicConnectionFactory_XAEnabled() {
		return (EAttribute)mqTopicConnectionFactoryEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQTopicConnectionFactoryUnit() {
		return mqTopicConnectionFactoryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQTopicDestination() {
		return mqTopicDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_BaseTopicName() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_BrokerCCDurableSubscriptionQueue() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_BrokerDurableSubscriptionQueue() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_Category() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_DecimalEncoding() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_Description1() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_DestinationName() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_EnableMulticastTransport() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_Expiry() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_FloatingPointEncoding() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_IntegerEncoding() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_JndiName() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_Persitence() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_Priority() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_SpecifiedExpiry() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_SpecifiedPriority() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_TargetClient() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMQTopicDestination_UseNativeEncoding() {
		return (EAttribute)mqTopicDestinationEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMQTopicDestinationUnit() {
		return mqTopicDestinationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MqFactory getMqFactory() {
		return (MqFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		messeageListernerServicePortEClass = createEClass(MESSEAGE_LISTERNER_SERVICE_PORT);
		createEAttribute(messeageListernerServicePortEClass, MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME);
		createEAttribute(messeageListernerServicePortEClass, MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME);
		createEAttribute(messeageListernerServicePortEClass, MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES);
		createEAttribute(messeageListernerServicePortEClass, MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS);
		createEAttribute(messeageListernerServicePortEClass, MESSEAGE_LISTERNER_SERVICE_PORT__NAME1);

		mqActivationSpecificationEClass = createEClass(MQ_ACTIVATION_SPECIFICATION);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__JNDI_NAME);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE);
		createEAttribute(mqActivationSpecificationEClass, MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME);

		mqActivationSpecificationUnitEClass = createEClass(MQ_ACTIVATION_SPECIFICATION_UNIT);

		mqBaseSystemEClass = createEClass(MQ_BASE_SYSTEM);
		createEAttribute(mqBaseSystemEClass, MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY);
		createEAttribute(mqBaseSystemEClass, MQ_BASE_SYSTEM__PROVIDER_NAME);
		createEAttribute(mqBaseSystemEClass, MQ_BASE_SYSTEM__PROVIDER_URL);
		createEAttribute(mqBaseSystemEClass, MQ_BASE_SYSTEM__PROVIDER_VERSION);

		mqBaseSystemUnitEClass = createEClass(MQ_BASE_SYSTEM_UNIT);

		mqConnectionFactoriesEClass = createEClass(MQ_CONNECTION_FACTORIES);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_CC_SUBSCRIPTION_QUEUE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_CONTROL_QUEUE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_MESSAGE_SELECTION);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_PUBLICATION_QUEUE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_QUEUE_MANAGER);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_SUBSCRIPTION_QUEUE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__BROKER_VERSION);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__CATEGORY);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__CCSID);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__CHANNEL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__CLIENT_ID);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__COMPONENT_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__CONTAINER_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__DIRECT_BROKER_AUTHORIZATION_TYPE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_CLONE_SUPPORT);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_MESSAGE_RETENTION);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_MQ_CONNECTION_POOLING);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_MULTICAST_TRANSPORT);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_RETURN_METHODS_DURING_SHUTDOWN);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__ENABLE_SPARSE_BROKER_SUBSCRIPTIONS);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__HOST);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__JNDI_NAME);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__LOCAL_SERVER_ADDRESS);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__MAPPING_CONFIGURATION_ALIAS);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__MODEL_QUEUE_DEFINITION);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__NAME1);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PERSISTENT_SUBSCRIPTIONS_STORE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__POLLING_INTERVAL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PORT);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PROXY_HOST_NAME);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PROXY_PORT);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PUBLISH_AND_ACKNOWLEDGEMENT_INTERVAL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__QUEUE_MANAGER);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__RESCAN_INTERVAL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__SSL_CIPHER_SUITE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__SSLCRL);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__SSL_PEER_NAME);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__TEMPORARY_QUEUE_PREFIX);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__TRANSPORT_TYPE);
		createEAttribute(mqConnectionFactoriesEClass, MQ_CONNECTION_FACTORIES__XA_ENABLED);

		mqConnectionFactoriesUnitEClass = createEClass(MQ_CONNECTION_FACTORIES_UNIT);

		mqDestinationEClass = createEClass(MQ_DESTINATION);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__BASE_QUEUE_NAME);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__CATEGORY);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__CCSID);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__DECIMAL_ENCODING);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__DESCRIPTION1);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__DESTINATION_NAME);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__EXPIRY);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__FLOATING_POINT_ENCODING);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__INTEGER_ENCODING);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__JNDI_NAME);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__PASSWORD);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__PERSITENCE);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__PRIORITY);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__QUEUE_MANAGER_HOST);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__QUEUE_MANAGER_PORT);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__SPECIFIED_EXPIRY);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__SPECIFIED_PRIORITY);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__TARGET_CLIENT);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__USE_NATIVE_ENCODING);
		createEAttribute(mqDestinationEClass, MQ_DESTINATION__USER_ID);

		mqListenerEClass = createEClass(MQ_LISTENER);
		createEAttribute(mqListenerEClass, MQ_LISTENER__PORT);

		mqListenerUnitEClass = createEClass(MQ_LISTENER_UNIT);

		mqMessageListnerServicePortUnitEClass = createEClass(MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT);

		mqMessagingProviderEClass = createEClass(MQ_MESSAGING_PROVIDER);
		createEAttribute(mqMessagingProviderEClass, MQ_MESSAGING_PROVIDER__CLASS_PATH);
		createEAttribute(mqMessagingProviderEClass, MQ_MESSAGING_PROVIDER__DESCRIPTION1);
		createEAttribute(mqMessagingProviderEClass, MQ_MESSAGING_PROVIDER__NAME1);
		createEAttribute(mqMessagingProviderEClass, MQ_MESSAGING_PROVIDER__NATIVE_PATH);

		mqMessagingProviderUnitEClass = createEClass(MQ_MESSAGING_PROVIDER_UNIT);

		mqQueueEClass = createEClass(MQ_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__BACKOUT_REQUEUE_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__BACKOUT_THRESHOLD);
		createEAttribute(mqQueueEClass, MQ_QUEUE__BASE_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__BASE_QUEUE_NAME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__CLWL_QUEUE_PRIORITY);
		createEAttribute(mqQueueEClass, MQ_QUEUE__CLWL_QUEUE_RANK);
		createEAttribute(mqQueueEClass, MQ_QUEUE__CLWLU_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__COUPLING_FACILITY_NAME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DEFAULT_BIND_TYPE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DEFAULT_PRIORITY);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DEFINITION_TYPE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DESCRIPTION1);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DISTRIBUTION_LIST);
		createEAttribute(mqQueueEClass, MQ_QUEUE__DISTRIBUTION_LISTS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__GET_MESSAGES);
		createEAttribute(mqQueueEClass, MQ_QUEUE__HARDEN_GET_BACKOUT);
		createEAttribute(mqQueueEClass, MQ_QUEUE__INITIATION_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__MAX_MESSAGE_LENGTH);
		createEAttribute(mqQueueEClass, MQ_QUEUE__MAX_QUEUE_DEPTH);
		createEAttribute(mqQueueEClass, MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__NOT_SHARED_IN_CLUSTER);
		createEAttribute(mqQueueEClass, MQ_QUEUE__NPM_CLASS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__PERSISTENCE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__PROCESS_NAME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__PUT_MESSAGE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__PUT_MESSAGES);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QSG_DISPOSITION);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_ACCOUNTING);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_MONITORING);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_NAME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_SERVICE_INTERVAL);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__QUEUE_TYPE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__REMOTE_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__REMOTE_QUEUE_MANAGER);
		createEAttribute(mqQueueEClass, MQ_QUEUE__RETENTION_INTERVAL);
		createEAttribute(mqQueueEClass, MQ_QUEUE__SCOPE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__SHAREABILITY);
		createEAttribute(mqQueueEClass, MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__SHARED_IN_CLUSTER);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_ALTERATION_DATE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_ALTERATION_TIME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_CREATION_DATE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_CREATION_TIME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_OPEN_INPUT_COUNT);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_QUEUE_MONITORING);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STAT_QUEUE_STATISTICS);
		createEAttribute(mqQueueEClass, MQ_QUEUE__STORAGE_CLASS_NAME);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRANSMISSION_QUEUE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRIGGER_CONTROL);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRIGGER_DATA);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRIGGER_DEPTH);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY);
		createEAttribute(mqQueueEClass, MQ_QUEUE__TRIGGER_TYPE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__USAGE);
		createEAttribute(mqQueueEClass, MQ_QUEUE__USAGE1);

		mqQueueChannelEClass = createEClass(MQ_QUEUE_CHANNEL);
		createEAttribute(mqQueueChannelEClass, MQ_QUEUE_CHANNEL__CHANNEL_NAME);

		mqQueueChannelUnitEClass = createEClass(MQ_QUEUE_CHANNEL_UNIT);

		mqQueueConnectionFactoryEClass = createEClass(MQ_QUEUE_CONNECTION_FACTORY);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__CATEGORY);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__CCSID);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__CHANNEL);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__HOST);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__PORT);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__SSLCRL);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE);
		createEAttribute(mqQueueConnectionFactoryEClass, MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED);

		mqQueueConnectionFactoryUnitEClass = createEClass(MQ_QUEUE_CONNECTION_FACTORY_UNIT);

		mqQueueDestinationEClass = createEClass(MQ_QUEUE_DESTINATION);

		mqQueueDestinationUnitEClass = createEClass(MQ_QUEUE_DESTINATION_UNIT);

		mqQueueManagerEClass = createEClass(MQ_QUEUE_MANAGER);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ACTIVITY_RECORDING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ADOPT_NEW_MCA);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__AUTHORITY_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__AUTOMATIC);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BRIDGE_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_MONITORING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHANNEL_STATISTICS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__COMMAND_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__COMMAND_LEVEL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__COMMAND_SCOPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CONFIGURATION_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__CONFIRM);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DESCRIPTION1);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DNS_GROUP);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__DNSWLM);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ERROR_LOG_SIZE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__EXPIRY_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__IGQ_USER_ID);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__INHIBIT_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LISTENER_TIMER);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOCAL_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_FILE_PAGES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_PATH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU62ARM_SUFFIX);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU62_CHANNELS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU_GROUP_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU_LIBRARY1);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU_LIBRARY2);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU_LOCAL_LU);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LU_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__LUTP_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAX_CHANNELS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAXIMUM_HANDLES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MAX_INITIATORS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MQI_ACCOUNTING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MQI_BIND_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__MQI_STATISTICS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__PERFORMANCE_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__PLATFORM);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__QUEUE_MONITORING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__QUEUE_STATISTICS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__REMOTE_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__REPOSITORY_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SECURITY_POLICY);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SPX_LIBRARY1);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SPX_LIBRARY2);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SPX_SOCKET);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_FIPS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SSL_TASKS);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__START_STOP_EVENT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__STATISTICS_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_LIBRARY1);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_LIBRARY2);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_NAME);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_PORT);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TCP_STACK_TYPE);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__TRIGGER_INTERVAL);
		createEAttribute(mqQueueManagerEClass, MQ_QUEUE_MANAGER__WHAT_IF);

		mqQueueManagerUnitEClass = createEClass(MQ_QUEUE_MANAGER_UNIT);

		mqQueueUnitEClass = createEClass(MQ_QUEUE_UNIT);

		mqRootEClass = createEClass(MQ_ROOT);
		createEAttribute(mqRootEClass, MQ_ROOT__MIXED);
		createEReference(mqRootEClass, MQ_ROOT__XMLNS_PREFIX_MAP);
		createEReference(mqRootEClass, MQ_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_DESTINATION);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_LISTENER);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_QUEUE);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY);
		createEReference(mqRootEClass, MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_LISTENER_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_QUEUE_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT);
		createEReference(mqRootEClass, MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT);

		mqTopicConnectionFactoryEClass = createEClass(MQ_TOPIC_CONNECTION_FACTORY);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__CATEGORY);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__CHANNEL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__HOST);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PORT);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__SSLCRL);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE);
		createEAttribute(mqTopicConnectionFactoryEClass, MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED);

		mqTopicConnectionFactoryUnitEClass = createEClass(MQ_TOPIC_CONNECTION_FACTORY_UNIT);

		mqTopicDestinationEClass = createEClass(MQ_TOPIC_DESTINATION);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__CATEGORY);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__DECIMAL_ENCODING);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__DESCRIPTION1);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__DESTINATION_NAME);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__EXPIRY);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__INTEGER_ENCODING);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__JNDI_NAME);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__PERSITENCE);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__PRIORITY);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__TARGET_CLIENT);
		createEAttribute(mqTopicDestinationEClass, MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING);

		mqTopicDestinationUnitEClass = createEClass(MQ_TOPIC_DESTINATION_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		messeageListernerServicePortEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqActivationSpecificationEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqActivationSpecificationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqBaseSystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqBaseSystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqConnectionFactoriesEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqConnectionFactoriesUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqDestinationEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqListenerEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqListenerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqMessageListnerServicePortUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqMessagingProviderEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqMessagingProviderUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqQueueEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqQueueChannelEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqQueueChannelUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqQueueConnectionFactoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqQueueConnectionFactoryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqQueueDestinationEClass.getESuperTypes().add(this.getMQDestination());
		mqQueueDestinationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqQueueManagerEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqQueueManagerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqQueueUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqTopicConnectionFactoryEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqTopicConnectionFactoryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		mqTopicDestinationEClass.getESuperTypes().add(theCorePackage.getCapability());
		mqTopicDestinationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(messeageListernerServicePortEClass, MesseageListernerServicePort.class, "MesseageListernerServicePort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMesseageListernerServicePort_CFJNDIName(), theXMLTypePackage.getString(), "cFJNDIName", null, 0, 1, MesseageListernerServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMesseageListernerServicePort_DestinationJNDIName(), theXMLTypePackage.getString(), "destinationJNDIName", null, 0, 1, MesseageListernerServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMesseageListernerServicePort_MaxRetries(), theXMLTypePackage.getString(), "maxRetries", null, 0, 1, MesseageListernerServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMesseageListernerServicePort_MaxSessions(), theXMLTypePackage.getString(), "maxSessions", null, 0, 1, MesseageListernerServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMesseageListernerServicePort_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, MesseageListernerServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqActivationSpecificationEClass, MQActivationSpecification.class, "MQActivationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_ClientIdentifier(), theXMLTypePackage.getString(), "clientIdentifier", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_MesasageSelector(), theXMLTypePackage.getString(), "mesasageSelector", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_SpecificationName(), theXMLTypePackage.getString(), "specificationName", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_SubscriptionDurable(), theXMLTypePackage.getBoolean(), "subscriptionDurable", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQActivationSpecification_SubscriptionName(), theXMLTypePackage.getString(), "subscriptionName", null, 0, 1, MQActivationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqActivationSpecificationUnitEClass, MQActivationSpecificationUnit.class, "MQActivationSpecificationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqBaseSystemEClass, MQBaseSystem.class, "MQBaseSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQBaseSystem_InitialContextFactory(), theXMLTypePackage.getString(), "initialContextFactory", null, 0, 1, MQBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQBaseSystem_ProviderName(), theXMLTypePackage.getString(), "providerName", null, 0, 1, MQBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQBaseSystem_ProviderURL(), theXMLTypePackage.getAnyURI(), "providerURL", null, 0, 1, MQBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQBaseSystem_ProviderVersion(), theCorePackage.getVersionString(), "providerVersion", null, 0, 1, MQBaseSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqBaseSystemUnitEClass, MQBaseSystemUnit.class, "MQBaseSystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqConnectionFactoriesEClass, MQConnectionFactories.class, "MQConnectionFactories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerCCSubscriptionQueue(), theXMLTypePackage.getString(), "brokerCCSubscriptionQueue", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerControlQueue(), theXMLTypePackage.getString(), "brokerControlQueue", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerMessageSelection(), theXMLTypePackage.getString(), "brokerMessageSelection", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerPublicationQueue(), theXMLTypePackage.getString(), "brokerPublicationQueue", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerQueueManager(), theXMLTypePackage.getString(), "brokerQueueManager", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerSubscriptionQueue(), theXMLTypePackage.getString(), "brokerSubscriptionQueue", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_BrokerVersion(), theXMLTypePackage.getString(), "brokerVersion", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_CCSID(), theXMLTypePackage.getString(), "cCSID", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_Channel(), theXMLTypePackage.getString(), "channel", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ClientId(), theXMLTypePackage.getString(), "clientId", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ComponentManagedAuthenticationAlias(), theXMLTypePackage.getString(), "componentManagedAuthenticationAlias", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ContainerManagedAuthenticationAlias(), theXMLTypePackage.getString(), "containerManagedAuthenticationAlias", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_DirectBrokerAuthorizationType(), theXMLTypePackage.getString(), "directBrokerAuthorizationType", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableCloneSupport(), theXMLTypePackage.getString(), "enableCloneSupport", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableMessageRetention(), theXMLTypePackage.getString(), "enableMessageRetention", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableMQConnectionPooling(), theXMLTypePackage.getString(), "enableMQConnectionPooling", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableMulticastTransport(), theXMLTypePackage.getString(), "enableMulticastTransport", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableReturnMethodsDuringShutdown(), theXMLTypePackage.getString(), "enableReturnMethodsDuringShutdown", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_EnableSparseBrokerSubscriptions(), theXMLTypePackage.getString(), "enableSparseBrokerSubscriptions", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_Host(), theXMLTypePackage.getString(), "host", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_LocalServerAddress(), theXMLTypePackage.getString(), "localServerAddress", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_MappingConfigurationAlias(), theXMLTypePackage.getString(), "mappingConfigurationAlias", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ModelQueueDefinition(), theXMLTypePackage.getString(), "modelQueueDefinition", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PersistentSubscriptionsStore(), theXMLTypePackage.getString(), "persistentSubscriptionsStore", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PollingInterval(), theXMLTypePackage.getString(), "pollingInterval", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_Port(), theXMLTypePackage.getString(), "port", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ProxyHostName(), theXMLTypePackage.getString(), "proxyHostName", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_ProxyPort(), theXMLTypePackage.getString(), "proxyPort", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PublishAndAcknowledgementInterval(), theXMLTypePackage.getString(), "publishAndAcknowledgementInterval", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PublishAndSubscribeCleanupInterval(), theXMLTypePackage.getString(), "publishAndSubscribeCleanupInterval", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PublishAndSubscribeCleanupLevel(), theXMLTypePackage.getString(), "publishAndSubscribeCleanupLevel", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_PublishAndSubscribeStatusInterval(), theXMLTypePackage.getString(), "publishAndSubscribeStatusInterval", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_QueueManager(), theXMLTypePackage.getString(), "queueManager", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_RescanInterval(), theXMLTypePackage.getString(), "rescanInterval", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_SSLCipherSuite(), theXMLTypePackage.getString(), "sSLCipherSuite", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_SSLCRL(), theXMLTypePackage.getString(), "sSLCRL", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_SSLPeerName(), theXMLTypePackage.getString(), "sSLPeerName", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_TemporaryQueuePrefix(), theXMLTypePackage.getString(), "temporaryQueuePrefix", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_TransportType(), theXMLTypePackage.getString(), "transportType", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQConnectionFactories_XAEnabled(), theXMLTypePackage.getString(), "xAEnabled", null, 0, 1, MQConnectionFactories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqConnectionFactoriesUnitEClass, MQConnectionFactoriesUnit.class, "MQConnectionFactoriesUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqDestinationEClass, MQDestination.class, "MQDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQDestination_BaseQueueManagerName(), theXMLTypePackage.getString(), "baseQueueManagerName", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_BaseQueueName(), theXMLTypePackage.getString(), "baseQueueName", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_CCSID(), theXMLTypePackage.getString(), "cCSID", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_DecimalEncoding(), theXMLTypePackage.getString(), "decimalEncoding", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_DestinationName(), theXMLTypePackage.getString(), "destinationName", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Expiry(), theXMLTypePackage.getString(), "expiry", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_FloatingPointEncoding(), theXMLTypePackage.getString(), "floatingPointEncoding", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_IntegerEncoding(), theXMLTypePackage.getString(), "integerEncoding", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Persitence(), theXMLTypePackage.getString(), "persitence", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_Priority(), theXMLTypePackage.getString(), "priority", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_QueueManagerHost(), theXMLTypePackage.getString(), "queueManagerHost", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_QueueManagerPort(), theXMLTypePackage.getString(), "queueManagerPort", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_ServerConnectionChannelName(), theXMLTypePackage.getString(), "serverConnectionChannelName", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_SpecifiedExpiry(), theXMLTypePackage.getString(), "specifiedExpiry", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_SpecifiedPriority(), theXMLTypePackage.getString(), "specifiedPriority", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_TargetClient(), theXMLTypePackage.getString(), "targetClient", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_UseNativeEncoding(), theXMLTypePackage.getString(), "useNativeEncoding", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQDestination_UserID(), theXMLTypePackage.getString(), "userID", null, 0, 1, MQDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqListenerEClass, MQListener.class, "MQListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQListener_Port(), theXMLTypePackage.getString(), "port", null, 0, 1, MQListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqListenerUnitEClass, MQListenerUnit.class, "MQListenerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqMessageListnerServicePortUnitEClass, MQMessageListnerServicePortUnit.class, "MQMessageListnerServicePortUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqMessagingProviderEClass, MQMessagingProvider.class, "MQMessagingProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQMessagingProvider_ClassPath(), theXMLTypePackage.getString(), "classPath", null, 0, 1, MQMessagingProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQMessagingProvider_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQMessagingProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQMessagingProvider_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, MQMessagingProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQMessagingProvider_NativePath(), theXMLTypePackage.getString(), "nativePath", null, 0, 1, MQMessagingProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqMessagingProviderUnitEClass, MQMessagingProviderUnit.class, "MQMessagingProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueEClass, MQQueue.class, "MQQueue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQQueue_BackoutRequeueQueue(), theXMLTypePackage.getString(), "backoutRequeueQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_BackoutThreshold(), theXMLTypePackage.getString(), "backoutThreshold", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_BaseQueue(), theXMLTypePackage.getString(), "baseQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_BaseQueueName(), theXMLTypePackage.getString(), "baseQueueName", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_CLWLQueuePriority(), theXMLTypePackage.getString(), "cLWLQueuePriority", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_CLWLQueueRank(), theXMLTypePackage.getString(), "cLWLQueueRank", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_CLWLUQueue(), theXMLTypePackage.getString(), "cLWLUQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_CouplingFacilityName(), theXMLTypePackage.getString(), "couplingFacilityName", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DefaultBindType(), theXMLTypePackage.getString(), "defaultBindType", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DefaultInputOpenOption(), theXMLTypePackage.getString(), "defaultInputOpenOption", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DefaultPriority(), theXMLTypePackage.getString(), "defaultPriority", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DefinitionType(), theXMLTypePackage.getString(), "definitionType", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DistributionList(), theXMLTypePackage.getString(), "distributionList", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_DistributionLists(), theXMLTypePackage.getString(), "distributionLists", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_GetMessages(), theXMLTypePackage.getString(), "getMessages", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_HardenGetBackout(), theXMLTypePackage.getString(), "hardenGetBackout", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_InitiationQueue(), theXMLTypePackage.getString(), "initiationQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_MaxMessageLength(), theXMLTypePackage.getString(), "maxMessageLength", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_MaxQueueDepth(), theXMLTypePackage.getString(), "maxQueueDepth", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_MessageDeliverySequence(), theXMLTypePackage.getString(), "messageDeliverySequence", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_NotSharedInCluster(), theXMLTypePackage.getString(), "notSharedInCluster", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_NPMClass(), theXMLTypePackage.getString(), "nPMClass", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Persistence(), theXMLTypePackage.getString(), "persistence", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_ProcessName(), theXMLTypePackage.getString(), "processName", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_PutMessage(), theXMLTypePackage.getString(), "putMessage", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_PutMessages(), theXMLTypePackage.getString(), "putMessages", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QSGDisposition(), theXMLTypePackage.getString(), "qSGDisposition", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueAccounting(), theXMLTypePackage.getString(), "queueAccounting", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueDepthHighEvents(), theXMLTypePackage.getString(), "queueDepthHighEvents", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueDepthHighLimit(), theXMLTypePackage.getString(), "queueDepthHighLimit", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueDepthLowEvents(), theXMLTypePackage.getString(), "queueDepthLowEvents", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueDepthLowLimit(), theXMLTypePackage.getString(), "queueDepthLowLimit", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueDepthMaxEvents(), theXMLTypePackage.getString(), "queueDepthMaxEvents", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueMonitoring(), theXMLTypePackage.getString(), "queueMonitoring", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueName(), theXMLTypePackage.getString(), "queueName", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueServiceInterval(), theXMLTypePackage.getString(), "queueServiceInterval", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueServiceIntervalEvents(), theXMLTypePackage.getString(), "queueServiceIntervalEvents", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_QueueType(), theXMLTypePackage.getString(), "queueType", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_RemoteQueue(), theXMLTypePackage.getString(), "remoteQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_RemoteQueueManager(), theXMLTypePackage.getString(), "remoteQueueManager", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_RetentionInterval(), theXMLTypePackage.getString(), "retentionInterval", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Scope(), theXMLTypePackage.getString(), "scope", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Shareability(), theXMLTypePackage.getString(), "shareability", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_SharedInAListOfClusters(), theXMLTypePackage.getString(), "sharedInAListOfClusters", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_SharedInCluster(), theXMLTypePackage.getString(), "sharedInCluster", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatAlterationDate(), theXMLTypePackage.getString(), "statAlterationDate", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatAlterationTime(), theXMLTypePackage.getString(), "statAlterationTime", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatCreationDate(), theXMLTypePackage.getString(), "statCreationDate", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatCreationTime(), theXMLTypePackage.getString(), "statCreationTime", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatCurrentQueueDepth(), theXMLTypePackage.getString(), "statCurrentQueueDepth", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatOpenInputCount(), theXMLTypePackage.getString(), "statOpenInputCount", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatOpenOutputCount(), theXMLTypePackage.getString(), "statOpenOutputCount", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatQueueMonitoring(), theXMLTypePackage.getString(), "statQueueMonitoring", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StatQueueStatistics(), theXMLTypePackage.getString(), "statQueueStatistics", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_StorageClassName(), theXMLTypePackage.getString(), "storageClassName", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TransmissionQueue(), theXMLTypePackage.getString(), "transmissionQueue", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TriggerControl(), theXMLTypePackage.getString(), "triggerControl", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TriggerData(), theXMLTypePackage.getString(), "triggerData", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TriggerDepth(), theXMLTypePackage.getString(), "triggerDepth", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TriggerMessagePriority(), theXMLTypePackage.getString(), "triggerMessagePriority", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_TriggerType(), theXMLTypePackage.getString(), "triggerType", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Usage(), theXMLTypePackage.getString(), "usage", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueue_Usage1(), theXMLTypePackage.getString(), "usage1", null, 0, 1, MQQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqQueueChannelEClass, MQQueueChannel.class, "MQQueueChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQQueueChannel_ChannelName(), theXMLTypePackage.getString(), "channelName", null, 0, 1, MQQueueChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqQueueChannelUnitEClass, MQQueueChannelUnit.class, "MQQueueChannelUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueConnectionFactoryEClass, MQQueueConnectionFactory.class, "MQQueueConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_CCSID(), theXMLTypePackage.getString(), "cCSID", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Channel(), theXMLTypePackage.getString(), "channel", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_ClientId(), theXMLTypePackage.getString(), "clientId", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias(), theXMLTypePackage.getString(), "componentManagedAuthenticationAlias", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias(), theXMLTypePackage.getString(), "containerManagedAuthenticationAlias", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_EnableConnectionPoling(), theXMLTypePackage.getString(), "enableConnectionPoling", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_EnableMessageRetention(), theXMLTypePackage.getString(), "enableMessageRetention", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown(), theXMLTypePackage.getString(), "enableReturnMethodDuringShutdown", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_FactoryName(), theXMLTypePackage.getString(), "factoryName", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Host(), theXMLTypePackage.getString(), "host", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_LocalServerAddress(), theXMLTypePackage.getString(), "localServerAddress", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_MappingconfigurationAlias(), theXMLTypePackage.getString(), "mappingconfigurationAlias", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_MaxConnections(), theXMLTypePackage.getString(), "maxConnections", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_MaxSessions(), theXMLTypePackage.getString(), "maxSessions", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_MinConnections(), theXMLTypePackage.getString(), "minConnections", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_MinSessions(), theXMLTypePackage.getString(), "minSessions", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_ModelQueueDefinition(), theXMLTypePackage.getString(), "modelQueueDefinition", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_PollingInterval(), theXMLTypePackage.getString(), "pollingInterval", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Port(), theXMLTypePackage.getString(), "port", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_Queuemanager(), theXMLTypePackage.getString(), "queuemanager", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_RescanInterval(), theXMLTypePackage.getString(), "rescanInterval", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_SSLCipherSuit(), theXMLTypePackage.getString(), "sSLCipherSuit", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_SSLCRL(), theXMLTypePackage.getString(), "sSLCRL", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_SSLPeerName(), theXMLTypePackage.getString(), "sSLPeerName", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_TemporaryQueuePrefix(), theXMLTypePackage.getString(), "temporaryQueuePrefix", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_TransportType(), theXMLTypePackage.getString(), "transportType", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueConnectionFactory_XAEnabled(), theXMLTypePackage.getString(), "xAEnabled", null, 0, 1, MQQueueConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqQueueConnectionFactoryUnitEClass, MQQueueConnectionFactoryUnit.class, "MQQueueConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueDestinationEClass, MQQueueDestination.class, "MQQueueDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueDestinationUnitEClass, MQQueueDestinationUnit.class, "MQQueueDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueManagerEClass, MQQueueManager.class, "MQQueueManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AccountingConnectionOverride(), theXMLTypePackage.getString(), "accountingConnectionOverride", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AccountingInterval(), theXMLTypePackage.getString(), "accountingInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ActivityRecording(), theXMLTypePackage.getString(), "activityRecording", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AdoptNewMCA(), theXMLTypePackage.getString(), "adoptNewMCA", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AdoptNewMCACheck(), theXMLTypePackage.getString(), "adoptNewMCACheck", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AdoptNewMCAType(), theXMLTypePackage.getString(), "adoptNewMCAType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_AuthorityEvent(), theXMLTypePackage.getString(), "authorityEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_Automatic(), theXMLTypePackage.getString(), "automatic", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BridgeEvent(), theXMLTypePackage.getString(), "bridgeEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerMessageRetryCount(), theXMLTypePackage.getString(), "brokerMessageRetryCount", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerOpenCacheExpiry(), theXMLTypePackage.getString(), "brokerOpenCacheExpiry", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerOpenCacheSize(), theXMLTypePackage.getString(), "brokerOpenCacheSize", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerPublicBatchInterval(), theXMLTypePackage.getString(), "brokerPublicBatchInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerPublishBatchSize(), theXMLTypePackage.getString(), "brokerPublishBatchSize", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_BrokerStreamsPerProcess(), theXMLTypePackage.getString(), "brokerStreamsPerProcess", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelAutoDefinition(), theXMLTypePackage.getString(), "channelAutoDefinition", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelAutoDefinitionEvent(), theXMLTypePackage.getString(), "channelAutoDefinitionEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelEvent(), theXMLTypePackage.getString(), "channelEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelInitiatorAdapters(), theXMLTypePackage.getString(), "channelInitiatorAdapters", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelInitiatorControl(), theXMLTypePackage.getString(), "channelInitiatorControl", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelInitiatorDispatchers(), theXMLTypePackage.getString(), "channelInitiatorDispatchers", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelInitiatorTraceAutoStart(), theXMLTypePackage.getString(), "channelInitiatorTraceAutoStart", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelInitiatorTraceTableSize(), theXMLTypePackage.getString(), "channelInitiatorTraceTableSize", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelMonitoring(), theXMLTypePackage.getString(), "channelMonitoring", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ChannelStatistics(), theXMLTypePackage.getString(), "channelStatistics", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CheckpointActiveCount(), theXMLTypePackage.getString(), "checkpointActiveCount", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CheckpointMessageSize(), theXMLTypePackage.getString(), "checkpointMessageSize", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CheckpointRestartCount(), theXMLTypePackage.getString(), "checkpointRestartCount", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterSenderMonitoring(), theXMLTypePackage.getString(), "clusterSenderMonitoring", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterSenderStatistics(), theXMLTypePackage.getString(), "clusterSenderStatistics", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterWorkLoadData(), theXMLTypePackage.getString(), "clusterWorkLoadData", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterWorkLoadExit(), theXMLTypePackage.getString(), "clusterWorkLoadExit", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterWorkLoadLength(), theXMLTypePackage.getString(), "clusterWorkLoadLength", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ClusterWorkloadUseQ(), theXMLTypePackage.getString(), "clusterWorkloadUseQ", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CodedCharSetId(), theXMLTypePackage.getString(), "codedCharSetId", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CommandEvent(), theXMLTypePackage.getString(), "commandEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CommandLevel(), theXMLTypePackage.getString(), "commandLevel", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CommandScope(), theXMLTypePackage.getString(), "commandScope", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_CommandServerControl(), theXMLTypePackage.getString(), "commandServerControl", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ConfigurationEvent(), theXMLTypePackage.getString(), "configurationEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_Confirm(), theXMLTypePackage.getString(), "confirm", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_DeadLetterQueue(), theXMLTypePackage.getString(), "deadLetterQueue", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_DefaultBindType(), theXMLTypePackage.getString(), "defaultBindType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_DefaultTransmissionQueue(), theXMLTypePackage.getString(), "defaultTransmissionQueue", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_DNSGroup(), theXMLTypePackage.getString(), "dNSGroup", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_DNSWLM(), theXMLTypePackage.getString(), "dNSWLM", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ErrorLogSize(), theXMLTypePackage.getString(), "errorLogSize", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ExcludedMessages(), theXMLTypePackage.getString(), "excludedMessages", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ExitsDefaultPath(), theXMLTypePackage.getString(), "exitsDefaultPath", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ExpiryInterval(), theXMLTypePackage.getString(), "expiryInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_IGQPutAuthority(), theXMLTypePackage.getString(), "iGQPutAuthority", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_IGQUserId(), theXMLTypePackage.getString(), "iGQUserId", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_InhibitEvent(), theXMLTypePackage.getString(), "inhibitEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_InstallableServiceName(), theXMLTypePackage.getString(), "installableServiceName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_IntraGroupQueuing(), theXMLTypePackage.getString(), "intraGroupQueuing", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_IPAddressVersion(), theXMLTypePackage.getString(), "iPAddressVersion", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ListenerTimer(), theXMLTypePackage.getString(), "listenerTimer", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LocalEvent(), theXMLTypePackage.getString(), "localEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogBufferPages(), theXMLTypePackage.getString(), "logBufferPages", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogFilePages(), theXMLTypePackage.getString(), "logFilePages", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogPath(), theXMLTypePackage.getString(), "logPath", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogPrimaryFiles(), theXMLTypePackage.getString(), "logPrimaryFiles", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogSecondaryFiles(), theXMLTypePackage.getString(), "logSecondaryFiles", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogType(), theXMLTypePackage.getString(), "logType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LogWriteIntegrity(), theXMLTypePackage.getString(), "logWriteIntegrity", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LU62ARMSuffix(), theXMLTypePackage.getString(), "lU62ARMSuffix", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LU62Channels(), theXMLTypePackage.getString(), "lU62Channels", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LUGroupName(), theXMLTypePackage.getString(), "lUGroupName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LULibrary1(), theXMLTypePackage.getString(), "lULibrary1", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LULibrary2(), theXMLTypePackage.getString(), "lULibrary2", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LULocalLU(), theXMLTypePackage.getString(), "lULocalLU", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LUName(), theXMLTypePackage.getString(), "lUName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_LUTPName(), theXMLTypePackage.getString(), "lUTPName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaxActiveChannels(), theXMLTypePackage.getString(), "maxActiveChannels", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaxChannels(), theXMLTypePackage.getString(), "maxChannels", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaximumCurrentChannels(), theXMLTypePackage.getString(), "maximumCurrentChannels", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaximumHandles(), theXMLTypePackage.getString(), "maximumHandles", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaximumMessageLength(), theXMLTypePackage.getString(), "maximumMessageLength", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaximumTCPChannels(), theXMLTypePackage.getString(), "maximumTCPChannels", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaximumUncommittedMessages(), theXMLTypePackage.getString(), "maximumUncommittedMessages", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MaxInitiators(), theXMLTypePackage.getString(), "maxInitiators", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MQIAccounting(), theXMLTypePackage.getString(), "mQIAccounting", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MQIBindType(), theXMLTypePackage.getString(), "mQIBindType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_MQIStatistics(), theXMLTypePackage.getString(), "mQIStatistics", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosAdaptorNumber(), theXMLTypePackage.getString(), "netBiosAdaptorNumber", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosLibrary1(), theXMLTypePackage.getString(), "netBiosLibrary1", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosLocalName(), theXMLTypePackage.getString(), "netBiosLocalName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosNumberOfCommands(), theXMLTypePackage.getString(), "netBiosNumberOfCommands", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosNumberOfNames(), theXMLTypePackage.getString(), "netBiosNumberOfNames", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_NetBiosNumberOfSessions(), theXMLTypePackage.getString(), "netBiosNumberOfSessions", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_OutboundPortMax(), theXMLTypePackage.getString(), "outboundPortMax", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_OutboundPortMin(), theXMLTypePackage.getString(), "outboundPortMin", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_PerformanceEvent(), theXMLTypePackage.getString(), "performanceEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_PipeLineLength(), theXMLTypePackage.getString(), "pipeLineLength", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_Platform(), theXMLTypePackage.getString(), "platform", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_QueueAccounting(), theXMLTypePackage.getString(), "queueAccounting", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_QueueManagerName(), theXMLTypePackage.getString(), "queueManagerName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_QueueManagerStatus(), theXMLTypePackage.getString(), "queueManagerStatus", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_QueueMonitoring(), theXMLTypePackage.getString(), "queueMonitoring", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_QueueStatistics(), theXMLTypePackage.getString(), "queueStatistics", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ReceiveTimeout(), theXMLTypePackage.getString(), "receiveTimeout", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ReceiveTimeoutMin(), theXMLTypePackage.getString(), "receiveTimeoutMin", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ReceiveTimeoutType(), theXMLTypePackage.getString(), "receiveTimeoutType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_RemoteEvent(), theXMLTypePackage.getString(), "remoteEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_RepositoryName(), theXMLTypePackage.getString(), "repositoryName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_RepositoryNameList(), theXMLTypePackage.getString(), "repositoryNameList", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_RoutingExitConnectType(), theXMLTypePackage.getString(), "routingExitConnectType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_RoutingExitPath(), theXMLTypePackage.getString(), "routingExitPath", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SecurityPolicy(), theXMLTypePackage.getString(), "securityPolicy", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_ServiceEntryPoints(), theXMLTypePackage.getString(), "serviceEntryPoints", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SharedQQmgrName(), theXMLTypePackage.getString(), "sharedQQmgrName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SPXBoardNumber(), theXMLTypePackage.getString(), "sPXBoardNumber", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SPXKeepAlive(), theXMLTypePackage.getString(), "sPXKeepAlive", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SPXLibrary1(), theXMLTypePackage.getString(), "sPXLibrary1", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SPXLibrary2(), theXMLTypePackage.getString(), "sPXLibrary2", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SPXSocket(), theXMLTypePackage.getString(), "sPXSocket", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLCRLNameList(), theXMLTypePackage.getString(), "sSLCRLNameList", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLCrytoHardware(), theXMLTypePackage.getString(), "sSLCrytoHardware", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLEvent(), theXMLTypePackage.getString(), "sSLEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLFips(), theXMLTypePackage.getString(), "sSLFips", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLKeyRepository(), theXMLTypePackage.getString(), "sSLKeyRepository", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLKeyResetCount(), theXMLTypePackage.getString(), "sSLKeyResetCount", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SSLTasks(), theXMLTypePackage.getString(), "sSLTasks", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_StartStopEvent(), theXMLTypePackage.getString(), "startStopEvent", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_StatisticsInterval(), theXMLTypePackage.getString(), "statisticsInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SuppresedMessages(), theXMLTypePackage.getString(), "suppresedMessages", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_SuppressedMessageInterval(), theXMLTypePackage.getString(), "suppressedMessageInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPKeepAlive(), theXMLTypePackage.getString(), "tCPKeepAlive", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPLibrary1(), theXMLTypePackage.getString(), "tCPLibrary1", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPLibrary2(), theXMLTypePackage.getString(), "tCPLibrary2", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPListenerBacklog(), theXMLTypePackage.getString(), "tCPListenerBacklog", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPName(), theXMLTypePackage.getString(), "tCPName", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPPort(), theXMLTypePackage.getString(), "tCPPort", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TCPStackType(), theXMLTypePackage.getString(), "tCPStackType", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TraceRouteRecording(), theXMLTypePackage.getString(), "traceRouteRecording", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_TriggerInterval(), theXMLTypePackage.getString(), "triggerInterval", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQQueueManager_WhatIf(), theXMLTypePackage.getString(), "whatIf", null, 0, 1, MQQueueManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqQueueManagerUnitEClass, MQQueueManagerUnit.class, "MQQueueManagerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqQueueUnitEClass, MQQueueUnit.class, "MQQueueUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqRootEClass, MQRoot.class, "MQRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQActivationSpecification(), this.getMQActivationSpecification(), null, "capabilityMQActivationSpecification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQBaseSystem(), this.getMQBaseSystem(), null, "capabilityMQBaseSystem", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQConnectionFactories(), this.getMQConnectionFactories(), null, "capabilityMQConnectionFactories", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQDestination(), this.getMQDestination(), null, "capabilityMQDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQListener(), this.getMQListener(), null, "capabilityMQListener", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQMessagingProvider(), this.getMQMessagingProvider(), null, "capabilityMQMessagingProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQMesseageListernerServicePort(), this.getMesseageListernerServicePort(), null, "capabilityMQMesseageListernerServicePort", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQQueue(), this.getMQQueue(), null, "capabilityMQQueue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQQueueChannel(), this.getMQQueueChannel(), null, "capabilityMQQueueChannel", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQQueueConnectionFactory(), this.getMQQueueConnectionFactory(), null, "capabilityMQQueueConnectionFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQQueueDestination(), this.getMQQueueDestination(), null, "capabilityMQQueueDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQQueueManager(), this.getMQQueueManager(), null, "capabilityMQQueueManager", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQTopicConnectionFactory(), this.getMQTopicConnectionFactory(), null, "capabilityMQTopicConnectionFactory", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_CapabilityMQTopicDestination(), this.getMQTopicDestination(), null, "capabilityMQTopicDestination", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQActivationSpecificationUnit(), this.getMQActivationSpecificationUnit(), null, "unitMQActivationSpecificationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQBaseSystemUnit(), this.getMQBaseSystemUnit(), null, "unitMQBaseSystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQConnectionFactoriesUnit(), this.getMQConnectionFactoriesUnit(), null, "unitMQConnectionFactoriesUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQListenerUnit(), this.getMQListenerUnit(), null, "unitMQListenerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQMessageListnerServicePortUnit(), this.getMQMessageListnerServicePortUnit(), null, "unitMQMessageListnerServicePortUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQMessagingProviderUnit(), this.getMQMessagingProviderUnit(), null, "unitMQMessagingProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQQueueChannelUnit(), this.getMQQueueChannelUnit(), null, "unitMQQueueChannelUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQQueueConnectionFactoryUnit(), this.getMQQueueConnectionFactoryUnit(), null, "unitMQQueueConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQQueueDestinationUnit(), this.getMQQueueDestinationUnit(), null, "unitMQQueueDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQQueueManagerUnit(), this.getMQQueueManagerUnit(), null, "unitMQQueueManagerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQQueueUnit(), this.getMQQueueUnit(), null, "unitMQQueueUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQTopicConnectionFactoryUnit(), this.getMQTopicConnectionFactoryUnit(), null, "unitMQTopicConnectionFactoryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMQRoot_UnitMQTopicDestinationUnit(), this.getMQTopicDestinationUnit(), null, "unitMQTopicDestinationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqTopicConnectionFactoryEClass, MQTopicConnectionFactory.class, "MQTopicConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerCCSubscriptionQueue(), theXMLTypePackage.getString(), "brokerCCSubscriptionQueue", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerControlQueue(), theXMLTypePackage.getString(), "brokerControlQueue", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerMessageSelection(), theXMLTypePackage.getString(), "brokerMessageSelection", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerPublicationQueue(), theXMLTypePackage.getString(), "brokerPublicationQueue", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerQueueManager(), theXMLTypePackage.getString(), "brokerQueueManager", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerSubscriptionQueue(), theXMLTypePackage.getString(), "brokerSubscriptionQueue", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_BrokerVersion(), theXMLTypePackage.getString(), "brokerVersion", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_CCSIDId(), theXMLTypePackage.getString(), "cCSIDId", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_Channel(), theXMLTypePackage.getString(), "channel", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ClientId(), theXMLTypePackage.getString(), "clientId", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias(), theXMLTypePackage.getString(), "componentManagedAuthenticationAlias", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias(), theXMLTypePackage.getString(), "containerManagedAuthenticationAlias", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_DirectBrokerAuthorization(), theXMLTypePackage.getString(), "directBrokerAuthorization", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_EnableCloneSupport(), theXMLTypePackage.getString(), "enableCloneSupport", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_EnableMQConnectionPooling(), theXMLTypePackage.getString(), "enableMQConnectionPooling", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_EnableMulticastTransport(), theXMLTypePackage.getString(), "enableMulticastTransport", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown(), theXMLTypePackage.getString(), "enableReturnMethodsDuringShutdown", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_FactoryName(), theXMLTypePackage.getString(), "factoryName", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_Host(), theXMLTypePackage.getString(), "host", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_LocalServerAddress(), theXMLTypePackage.getString(), "localServerAddress", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_MappingConfigurationAlias(), theXMLTypePackage.getString(), "mappingConfigurationAlias", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ModelQueueDefinition(), theXMLTypePackage.getString(), "modelQueueDefinition", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PersistentSubscriptionStore(), theXMLTypePackage.getString(), "persistentSubscriptionStore", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PollingInterval(), theXMLTypePackage.getString(), "pollingInterval", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_Port(), theXMLTypePackage.getString(), "port", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ProxyHostName(), theXMLTypePackage.getString(), "proxyHostName", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_ProxyPort(), theXMLTypePackage.getString(), "proxyPort", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PublishAndAcknowledgeLevel(), theXMLTypePackage.getString(), "publishAndAcknowledgeLevel", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval(), theXMLTypePackage.getString(), "publishAndSubscribeCleanupInterval", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel(), theXMLTypePackage.getString(), "publishAndSubscribeCleanupLevel", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval(), theXMLTypePackage.getString(), "publishAndSubscribeStatusInterval", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_QueueManager(), theXMLTypePackage.getString(), "queueManager", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_RescanInterval(), theXMLTypePackage.getString(), "rescanInterval", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_SSLCipherSuite(), theXMLTypePackage.getString(), "sSLCipherSuite", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_SSLCRL(), theXMLTypePackage.getString(), "sSLCRL", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_SSLPeerName(), theXMLTypePackage.getString(), "sSLPeerName", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_TransportType(), theXMLTypePackage.getString(), "transportType", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicConnectionFactory_XAEnabled(), theXMLTypePackage.getString(), "xAEnabled", null, 0, 1, MQTopicConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqTopicConnectionFactoryUnitEClass, MQTopicConnectionFactoryUnit.class, "MQTopicConnectionFactoryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mqTopicDestinationEClass, MQTopicDestination.class, "MQTopicDestination", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_BaseTopicName(), theXMLTypePackage.getString(), "baseTopicName", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_BrokerCCDurableSubscriptionQueue(), theXMLTypePackage.getString(), "brokerCCDurableSubscriptionQueue", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_BrokerDurableSubscriptionQueue(), theXMLTypePackage.getString(), "brokerDurableSubscriptionQueue", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_DecimalEncoding(), theXMLTypePackage.getString(), "decimalEncoding", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_DestinationName(), theXMLTypePackage.getString(), "destinationName", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_EnableMulticastTransport(), theXMLTypePackage.getString(), "enableMulticastTransport", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_Expiry(), theXMLTypePackage.getString(), "expiry", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_FloatingPointEncoding(), theXMLTypePackage.getString(), "floatingPointEncoding", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_IntegerEncoding(), theXMLTypePackage.getString(), "integerEncoding", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_JndiName(), theXMLTypePackage.getString(), "jndiName", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_Persitence(), theXMLTypePackage.getString(), "persitence", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_Priority(), theXMLTypePackage.getString(), "priority", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_SpecifiedExpiry(), theXMLTypePackage.getString(), "specifiedExpiry", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_SpecifiedPriority(), theXMLTypePackage.getString(), "specifiedPriority", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_TargetClient(), theXMLTypePackage.getString(), "targetClient", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMQTopicDestination_UseNativeEncoding(), theXMLTypePackage.getString(), "useNativeEncoding", null, 0, 1, MQTopicDestination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mqTopicDestinationUnitEClass, MQTopicDestinationUnit.class, "MQTopicDestinationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (messeageListernerServicePortEClass, 
		   source, 
		   new String[] {
			 "name", "MesseageListernerServicePort", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMesseageListernerServicePort_CFJNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CFJNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMesseageListernerServicePort_DestinationJNDIName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DestinationJNDIName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMesseageListernerServicePort_MaxRetries(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxRetries" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMesseageListernerServicePort_MaxSessions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxSessions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMesseageListernerServicePort_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqActivationSpecificationEClass, 
		   source, 
		   new String[] {
			 "name", "MQActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_ClientIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "clientIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_MesasageSelector(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mesasageSelector" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_SpecificationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "specificationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_SubscriptionDurable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subscriptionDurable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQActivationSpecification_SubscriptionName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subscriptionName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqActivationSpecificationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqBaseSystemEClass, 
		   source, 
		   new String[] {
			 "name", "MQBaseSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQBaseSystem_InitialContextFactory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initialContextFactory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQBaseSystem_ProviderName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQBaseSystem_ProviderURL(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerURL" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQBaseSystem_ProviderVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqBaseSystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQBaseSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqConnectionFactoriesEClass, 
		   source, 
		   new String[] {
			 "name", "MQConnectionFactories", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerCCSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerCCSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerControlQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerControlQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerMessageSelection(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerMessageSelection" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerPublicationQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerPublicationQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerQueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerQueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_BrokerVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_CCSID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CCSID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_Channel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Channel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ClientId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ComponentManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ComponentManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ContainerManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ContainerManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_DirectBrokerAuthorizationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DirectBrokerAuthorizationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableCloneSupport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableCloneSupport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableMessageRetention(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMessageRetention" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableMQConnectionPooling(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMQConnectionPooling" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableMulticastTransport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMulticastTransport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableReturnMethodsDuringShutdown(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableReturnMethodsDuringShutdown" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_EnableSparseBrokerSubscriptions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableSparseBrokerSubscriptions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_Host(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Host" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_LocalServerAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LocalServerAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_MappingConfigurationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MappingConfigurationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ModelQueueDefinition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ModelQueueDefinition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PersistentSubscriptionsStore(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PersistentSubscriptionsStore" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PollingInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PollingInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ProxyHostName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProxyHostName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_ProxyPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProxyPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PublishAndAcknowledgementInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndAcknowledgementInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PublishAndSubscribeCleanupInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeCleanupInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PublishAndSubscribeCleanupLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeCleanupLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_PublishAndSubscribeStatusInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeStatusInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_QueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_RescanInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RescanInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_SSLCipherSuite(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCipherSuite" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_SSLCRL(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCRL" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_SSLPeerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLPeerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_TemporaryQueuePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TemporaryQueuePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_TransportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransportType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQConnectionFactories_XAEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "XAEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqConnectionFactoriesUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQConnectionFactoriesUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "MQDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_BaseQueueManagerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BaseQueueManagerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_BaseQueueName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BaseQueueName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_CCSID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CCSID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_DecimalEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DecimalEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_DestinationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Expiry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Expiry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_FloatingPointEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "FloatingPointEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_IntegerEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IntegerEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Password" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Persitence(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Persitence" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_Priority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Priority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_QueueManagerHost(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManagerHost" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_QueueManagerPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManagerPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_ServerConnectionChannelName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ServerConnectionChannelName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_SpecifiedExpiry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SpecifiedExpiry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_SpecifiedPriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SpecifiedPriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_TargetClient(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TargetClient" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_UseNativeEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UseNativeEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQDestination_UserID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UserID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqListenerEClass, 
		   source, 
		   new String[] {
			 "name", "MQListener", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQListener_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqListenerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQListenerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqMessageListnerServicePortUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQMessageListnerServicePortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqMessagingProviderEClass, 
		   source, 
		   new String[] {
			 "name", "MQMessagingProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQMessagingProvider_ClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQMessagingProvider_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQMessagingProvider_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQMessagingProvider_NativePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nativePath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqMessagingProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQMessagingProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueue", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_BackoutRequeueQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BackoutRequeueQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_BackoutThreshold(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BackoutThreshold" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_BaseQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BaseQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_BaseQueueName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BaseQueueName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_CLWLQueuePriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CLWLQueuePriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_CLWLQueueRank(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CLWLQueueRank" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_CLWLUQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CLWLUQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_CouplingFacilityName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CouplingFacilityName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DefaultBindType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultBindType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DefaultInputOpenOption(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultInputOpenOption" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DefaultPriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultPriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DefinitionType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefinitionType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DistributionList(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DistributionList" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_DistributionLists(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DistributionLists" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_GetMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "GetMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_HardenGetBackout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "HardenGetBackout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_InitiationQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InitiationQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_MaxMessageLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxMessageLength" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_MaxQueueDepth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxQueueDepth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_MessageDeliverySequence(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MessageDeliverySequence" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_NotSharedInCluster(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NotSharedInCluster" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_NPMClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NPMClass" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Persistence(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Persistence" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_ProcessName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProcessName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_PutMessage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PutMessage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_PutMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PutMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QSGDisposition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QSGDisposition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueAccounting(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueAccounting" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueDepthHighEvents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueDepthHighEvents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueDepthHighLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueDepthHighLimit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueDepthLowEvents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueDepthLowEvents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueDepthLowLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueDepthLowLimit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueDepthMaxEvents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueDepthMaxEvents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueServiceInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueServiceInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueServiceIntervalEvents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueServiceIntervalEvents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_QueueType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_RemoteQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RemoteQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_RemoteQueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RemoteQueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_RetentionInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RetentionInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Scope(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Scope" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Shareability(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Shareability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_SharedInAListOfClusters(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SharedInAListOfClusters" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_SharedInCluster(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SharedInCluster" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatAlterationDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatAlterationDate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatAlterationTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatAlterationTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatCreationDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatCreationDate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatCreationTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatCreationTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatCurrentQueueDepth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatCurrentQueueDepth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatOpenInputCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatOpenInputCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatOpenOutputCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatOpenOutputCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatQueueMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatQueueMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StatQueueStatistics(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatQueueStatistics" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_StorageClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StorageClassName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TransmissionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransmissionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TriggerControl(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerControl" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TriggerData(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerData" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TriggerDepth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerDepth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TriggerMessagePriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerMessagePriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_TriggerType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Usage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "usage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueue_Usage1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Usage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueChannelEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueChannel", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueChannel_ChannelName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "channelName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueChannelUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueChannelUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueConnectionFactoryEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_CCSID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CCSID" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Channel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Channel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_ClientId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ComponentManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ContainerManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_EnableConnectionPoling(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableConnectionPoling" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_EnableMessageRetention(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMessageRetention" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableReturnMethodDuringShutdown" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_FactoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Host(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Host" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_LocalServerAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LocalServerAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_MappingconfigurationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MappingconfigurationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_MaxConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_MaxSessions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxSessions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_MinConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MinConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_MinSessions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MinSessions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_ModelQueueDefinition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ModelQueueDefinition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_PollingInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PollingInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_Queuemanager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Queuemanager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_RescanInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RescanInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_SSLCipherSuit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCipherSuit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_SSLCRL(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCRL" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_SSLPeerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLPeerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_TemporaryQueuePrefix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TemporaryQueuePrefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_TransportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransportType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueConnectionFactory_XAEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "XAEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueManagerEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AccountingConnectionOverride(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AccountingConnectionOverride" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AccountingInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AccountingInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ActivityRecording(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ActivityRecording" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AdoptNewMCA(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AdoptNewMCA" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AdoptNewMCACheck(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AdoptNewMCACheck" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AdoptNewMCAType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AdoptNewMCAType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_AuthorityEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AuthorityEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_Automatic(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Automatic" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BridgeEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BridgeEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerMessageRetryCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerMessageRetryCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerOpenCacheExpiry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerOpenCacheExpiry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerOpenCacheSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerOpenCacheSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerPublicBatchInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerPublicBatchInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerPublishBatchSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerPublishBatchSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_BrokerStreamsPerProcess(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerStreamsPerProcess" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelAutoDefinition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelAutoDefinition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelAutoDefinitionEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelAutoDefinitionEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelInitiatorAdapters(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelInitiatorAdapters" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelInitiatorControl(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelInitiatorControl" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelInitiatorDispatchers(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelInitiatorDispatchers" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelInitiatorTraceAutoStart(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelInitiatorTraceAutoStart" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelInitiatorTraceTableSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelInitiatorTraceTableSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ChannelStatistics(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ChannelStatistics" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CheckpointActiveCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CheckpointActiveCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CheckpointMessageSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CheckpointMessageSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CheckpointRestartCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CheckpointRestartCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterSenderMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterSenderMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterSenderStatistics(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterSenderStatistics" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterWorkLoadData(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterWorkLoadData" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterWorkLoadExit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterWorkLoadExit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterWorkLoadLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterWorkLoadLength" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ClusterWorkloadUseQ(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClusterWorkloadUseQ" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CodedCharSetId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CodedCharSetId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CommandEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CommandEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CommandLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CommandLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CommandScope(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CommandScope" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_CommandServerControl(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CommandServerControl" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ConfigurationEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ConfigurationEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_Confirm(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Confirm" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_DeadLetterQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DeadLetterQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_DefaultBindType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultBindType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_DefaultTransmissionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultTransmissionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_DNSGroup(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DNSGroup" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_DNSWLM(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DNSWLM" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ErrorLogSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ErrorLogSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ExcludedMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ExcludedMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ExitsDefaultPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ExitsDefaultPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ExpiryInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ExpiryInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_IGQPutAuthority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IGQPutAuthority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_IGQUserId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IGQUserId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_InhibitEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InhibitEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_InstallableServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstallableServiceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_IntraGroupQueuing(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IntraGroupQueuing" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_IPAddressVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IPAddressVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ListenerTimer(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ListenerTimer" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LocalEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LocalEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogBufferPages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogBufferPages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogFilePages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogFilePages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogPrimaryFiles(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogPrimaryFiles" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogSecondaryFiles(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogSecondaryFiles" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LogWriteIntegrity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LogWriteIntegrity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LU62ARMSuffix(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LU62ARMSuffix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LU62Channels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LU62Channels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LUGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LUGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LULibrary1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LULibrary1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LULibrary2(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LULibrary2" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LULocalLU(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LULocalLU" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LUName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LUName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_LUTPName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LUTPName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaxActiveChannels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxActiveChannels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaxChannels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxChannels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaximumCurrentChannels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumCurrentChannels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaximumHandles(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumHandles" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaximumMessageLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumMessageLength" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaximumTCPChannels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumTCPChannels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaximumUncommittedMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumUncommittedMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MaxInitiators(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxInitiators" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MQIAccounting(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MQIAccounting" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MQIBindType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MQIBindType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_MQIStatistics(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MQIStatistics" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosAdaptorNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosAdaptorNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosLibrary1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosLibrary1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosLocalName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosLocalName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosNumberOfCommands(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosNumberOfCommands" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosNumberOfNames(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosNumberOfNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_NetBiosNumberOfSessions(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NetBiosNumberOfSessions" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_OutboundPortMax(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "OutboundPortMax" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_OutboundPortMin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "OutboundPortMin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_PerformanceEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PerformanceEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_PipeLineLength(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PipeLineLength" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_Platform(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Platform" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_QueueAccounting(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueAccounting" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_QueueManagerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManagerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_QueueManagerStatus(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManagerStatus" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_QueueMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_QueueStatistics(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueStatistics" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ReceiveTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ReceiveTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ReceiveTimeoutMin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ReceiveTimeoutMin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ReceiveTimeoutType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ReceiveTimeoutType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_RemoteEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RemoteEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_RepositoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RepositoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_RepositoryNameList(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RepositoryNameList" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_RoutingExitConnectType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RoutingExitConnectType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_RoutingExitPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RoutingExitPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SecurityPolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SecurityPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_ServiceEntryPoints(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ServiceEntryPoints" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SharedQQmgrName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sharedQQmgrName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SPXBoardNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SPXBoardNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SPXKeepAlive(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SPXKeepAlive" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SPXLibrary1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SPXLibrary1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SPXLibrary2(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SPXLibrary2" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SPXSocket(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SPXSocket" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLCRLNameList(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCRLNameList" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLCrytoHardware(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCrytoHardware" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLFips(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLFips" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLKeyRepository(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLKeyRepository" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLKeyResetCount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLKeyResetCount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SSLTasks(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLTasks" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_StartStopEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StartStopEvent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_StatisticsInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StatisticsInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SuppresedMessages(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SuppresedMessages" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_SuppressedMessageInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SuppressedMessageInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPKeepAlive(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPKeepAlive" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPLibrary1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPLibrary1" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPLibrary2(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPLibrary2" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPListenerBacklog(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPListenerBacklog" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TCPStackType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPStackType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TraceRouteRecording(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TraceRouteRecording" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_TriggerInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TriggerInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQQueueManager_WhatIf(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "WhatIf" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueManagerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqQueueUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQQueueUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQActivationSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQActivationSpecification", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQBaseSystem(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQBaseSystem", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQConnectionFactories(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQConnectionFactories", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQListener(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQListener", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQMessagingProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQMessagingProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQMesseageListernerServicePort(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQMesseageListernerServicePort", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQQueue(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQQueue", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQQueueChannel(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQQueueChannel", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQQueueConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQQueueConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQQueueDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQQueueDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQQueueManager(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQQueueManager", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQTopicConnectionFactory(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQTopicConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_CapabilityMQTopicDestination(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.MQTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQActivationSpecificationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQActivationSpecificationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQBaseSystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQBaseSystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQConnectionFactoriesUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQConnectionFactoriesUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQListenerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQListenerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQMessageListnerServicePortUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQMessageListnerServicePortUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQMessagingProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQMessagingProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQQueueChannelUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQQueueChannelUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQQueueConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQQueueConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQQueueDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQQueueDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQQueueManagerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQQueueManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQQueueUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQQueueUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQTopicConnectionFactoryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQRoot_UnitMQTopicDestinationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.MQTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqTopicConnectionFactoryEClass, 
		   source, 
		   new String[] {
			 "name", "MQTopicConnectionFactory", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerCCSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerCCSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerControlQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerControlQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerMessageSelection(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerMessageSelection" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerPublicationQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerPublicationQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerQueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerQueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_BrokerVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_CCSIDId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CCSIDId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_Channel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Channel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ClientId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientId" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ComponentManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ContainerManagedAuthenticationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_DirectBrokerAuthorization(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DirectBrokerAuthorization" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_EnableCloneSupport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableCloneSupport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_EnableMQConnectionPooling(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMQConnectionPooling" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_EnableMulticastTransport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMulticastTransport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableReturnMethodsDuringShutdown" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_FactoryName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "factoryName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_Host(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Host" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_LocalServerAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LocalServerAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_MappingConfigurationAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MappingConfigurationAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ModelQueueDefinition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ModelQueueDefinition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PersistentSubscriptionStore(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PersistentSubscriptionStore" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PollingInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PollingInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ProxyHostName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProxyHostName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_ProxyPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ProxyPort" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PublishAndAcknowledgeLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndAcknowledgeLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeCleanupInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeCleanupLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PublishAndSubscribeStatusInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_QueueManager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueueManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_RescanInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "RescanInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_SSLCipherSuite(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCipherSuite" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_SSLCRL(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLCRL" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_SSLPeerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SSLPeerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_TransportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransportType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicConnectionFactory_XAEnabled(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "XAEnabled" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqTopicConnectionFactoryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQTopicConnectionFactoryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqTopicDestinationEClass, 
		   source, 
		   new String[] {
			 "name", "MQTopicDestination", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_BaseTopicName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BaseTopicName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_BrokerCCDurableSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerCCDurableSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_BrokerDurableSubscriptionQueue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BrokerDurableSubscriptionQueue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_Category(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Category" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_DecimalEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DecimalEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_DestinationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_EnableMulticastTransport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnableMulticastTransport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_Expiry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Expiry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_FloatingPointEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "FloatingPointEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_IntegerEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IntegerEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_JndiName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jndiName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_Persitence(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Persitence" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_Priority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Priority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_SpecifiedExpiry(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SpecifiedExpiry" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_SpecifiedPriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SpecifiedPriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_TargetClient(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TargetClient" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getMQTopicDestination_UseNativeEncoding(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UseNativeEncoding" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (mqTopicDestinationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "MQTopicDestinationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //MqPackageImpl
