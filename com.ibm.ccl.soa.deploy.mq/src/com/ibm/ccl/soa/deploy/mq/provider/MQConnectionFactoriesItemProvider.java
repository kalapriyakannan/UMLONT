/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.provider.CapabilityItemProvider;
import com.ibm.ccl.soa.deploy.mq.MQConnectionFactories;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MQConnectionFactoriesItemProvider
	extends CapabilityItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQConnectionFactoriesItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBrokerCCSubscriptionQueuePropertyDescriptor(object);
			addBrokerControlQueuePropertyDescriptor(object);
			addBrokerMessageSelectionPropertyDescriptor(object);
			addBrokerPublicationQueuePropertyDescriptor(object);
			addBrokerQueueManagerPropertyDescriptor(object);
			addBrokerSubscriptionQueuePropertyDescriptor(object);
			addBrokerVersionPropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addCCSIDPropertyDescriptor(object);
			addChannelPropertyDescriptor(object);
			addClientIdPropertyDescriptor(object);
			addComponentManagedAuthenticationAliasPropertyDescriptor(object);
			addContainerManagedAuthenticationAliasPropertyDescriptor(object);
			addDirectBrokerAuthorizationTypePropertyDescriptor(object);
			addEnableCloneSupportPropertyDescriptor(object);
			addEnableMessageRetentionPropertyDescriptor(object);
			addEnableMQConnectionPoolingPropertyDescriptor(object);
			addEnableMulticastTransportPropertyDescriptor(object);
			addEnableReturnMethodsDuringShutdownPropertyDescriptor(object);
			addEnableSparseBrokerSubscriptionsPropertyDescriptor(object);
			addHostPropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addLocalServerAddressPropertyDescriptor(object);
			addMappingConfigurationAliasPropertyDescriptor(object);
			addModelQueueDefinitionPropertyDescriptor(object);
			addName1PropertyDescriptor(object);
			addPersistentSubscriptionsStorePropertyDescriptor(object);
			addPollingIntervalPropertyDescriptor(object);
			addPortPropertyDescriptor(object);
			addProxyHostNamePropertyDescriptor(object);
			addProxyPortPropertyDescriptor(object);
			addPublishAndAcknowledgementIntervalPropertyDescriptor(object);
			addPublishAndSubscribeCleanupIntervalPropertyDescriptor(object);
			addPublishAndSubscribeCleanupLevelPropertyDescriptor(object);
			addPublishAndSubscribeStatusIntervalPropertyDescriptor(object);
			addQueueManagerPropertyDescriptor(object);
			addRescanIntervalPropertyDescriptor(object);
			addSSLCipherSuitePropertyDescriptor(object);
			addSSLCRLPropertyDescriptor(object);
			addSSLPeerNamePropertyDescriptor(object);
			addTemporaryQueuePrefixPropertyDescriptor(object);
			addTransportTypePropertyDescriptor(object);
			addXAEnabledPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Broker CC Subscription Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerCCSubscriptionQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerCCSubscriptionQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerCCSubscriptionQueue_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_CC_SUBSCRIPTION_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Control Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerControlQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerControlQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerControlQueue_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_CONTROL_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Message Selection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerMessageSelectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerMessageSelection_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerMessageSelection_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_MESSAGE_SELECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Publication Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerPublicationQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerPublicationQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerPublicationQueue_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_PUBLICATION_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Queue Manager feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerQueueManagerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerQueueManager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerQueueManager_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_QUEUE_MANAGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Subscription Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerSubscriptionQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerSubscriptionQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerSubscriptionQueue_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_SUBSCRIPTION_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_brokerVersion_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_brokerVersion_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__BROKER_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_category_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the CCSID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCCSIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_cCSID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_cCSID_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__CCSID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Channel feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChannelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_channel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_channel_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__CHANNEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_clientId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_clientId_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__CLIENT_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Component Managed Authentication Alias feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComponentManagedAuthenticationAliasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_componentManagedAuthenticationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_componentManagedAuthenticationAlias_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__COMPONENT_MANAGED_AUTHENTICATION_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Container Managed Authentication Alias feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerManagedAuthenticationAliasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_containerManagedAuthenticationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_containerManagedAuthenticationAlias_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__CONTAINER_MANAGED_AUTHENTICATION_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Direct Broker Authorization Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirectBrokerAuthorizationTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_directBrokerAuthorizationType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_directBrokerAuthorizationType_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__DIRECT_BROKER_AUTHORIZATION_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Clone Support feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableCloneSupportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableCloneSupport_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableCloneSupport_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_CLONE_SUPPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Message Retention feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableMessageRetentionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableMessageRetention_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableMessageRetention_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_MESSAGE_RETENTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable MQ Connection Pooling feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableMQConnectionPoolingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableMQConnectionPooling_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableMQConnectionPooling_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_MQ_CONNECTION_POOLING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Multicast Transport feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableMulticastTransportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableMulticastTransport_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableMulticastTransport_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_MULTICAST_TRANSPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Return Methods During Shutdown feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableReturnMethodsDuringShutdownPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableReturnMethodsDuringShutdown_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableReturnMethodsDuringShutdown_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_RETURN_METHODS_DURING_SHUTDOWN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Sparse Broker Subscriptions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableSparseBrokerSubscriptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_enableSparseBrokerSubscriptions_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_enableSparseBrokerSubscriptions_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__ENABLE_SPARSE_BROKER_SUBSCRIPTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Host feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_host_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_host_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__HOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Jndi Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJndiNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_jndiName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_jndiName_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__JNDI_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Local Server Address feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocalServerAddressPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_localServerAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_localServerAddress_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__LOCAL_SERVER_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mapping Configuration Alias feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMappingConfigurationAliasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_mappingConfigurationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_mappingConfigurationAlias_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__MAPPING_CONFIGURATION_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Model Queue Definition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModelQueueDefinitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_modelQueueDefinition_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_modelQueueDefinition_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__MODEL_QUEUE_DEFINITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addName1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_name1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_name1_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__NAME1,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Persistent Subscriptions Store feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPersistentSubscriptionsStorePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_persistentSubscriptionsStore_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_persistentSubscriptionsStore_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PERSISTENT_SUBSCRIPTIONS_STORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Polling Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPollingIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_pollingInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_pollingInterval_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__POLLING_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_port_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_port_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Proxy Host Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProxyHostNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_proxyHostName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_proxyHostName_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PROXY_HOST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Proxy Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProxyPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_proxyPort_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_proxyPort_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PROXY_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publish And Acknowledgement Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublishAndAcknowledgementIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_publishAndAcknowledgementInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_publishAndAcknowledgementInterval_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PUBLISH_AND_ACKNOWLEDGEMENT_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publish And Subscribe Cleanup Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublishAndSubscribeCleanupIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_publishAndSubscribeCleanupInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_publishAndSubscribeCleanupInterval_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publish And Subscribe Cleanup Level feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublishAndSubscribeCleanupLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_publishAndSubscribeCleanupLevel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_publishAndSubscribeCleanupLevel_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Publish And Subscribe Status Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPublishAndSubscribeStatusIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_publishAndSubscribeStatusInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_publishAndSubscribeStatusInterval_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queue Manager feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueueManagerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_queueManager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_queueManager_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__QUEUE_MANAGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rescan Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRescanIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_rescanInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_rescanInterval_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__RESCAN_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the SSL Cipher Suite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSSLCipherSuitePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_sSLCipherSuite_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_sSLCipherSuite_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__SSL_CIPHER_SUITE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the SSLCRL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSSLCRLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_sSLCRL_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_sSLCRL_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__SSLCRL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the SSL Peer Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSSLPeerNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_sSLPeerName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_sSLPeerName_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__SSL_PEER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temporary Queue Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemporaryQueuePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_temporaryQueuePrefix_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_temporaryQueuePrefix_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__TEMPORARY_QUEUE_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transport Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransportTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_transportType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_transportType_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__TRANSPORT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the XA Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addXAEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQConnectionFactories_xAEnabled_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQConnectionFactories_xAEnabled_feature", "_UI_MQConnectionFactories_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_CONNECTION_FACTORIES__XA_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns MQConnectionFactories.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MQConnectionFactories")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MQConnectionFactories)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MQConnectionFactories_type") : //$NON-NLS-1$
			getString("_UI_MQConnectionFactories_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MQConnectionFactories.class)) {
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_CC_SUBSCRIPTION_QUEUE:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_CONTROL_QUEUE:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_MESSAGE_SELECTION:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_PUBLICATION_QUEUE:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_QUEUE_MANAGER:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_SUBSCRIPTION_QUEUE:
			case MqPackage.MQ_CONNECTION_FACTORIES__BROKER_VERSION:
			case MqPackage.MQ_CONNECTION_FACTORIES__CATEGORY:
			case MqPackage.MQ_CONNECTION_FACTORIES__CCSID:
			case MqPackage.MQ_CONNECTION_FACTORIES__CHANNEL:
			case MqPackage.MQ_CONNECTION_FACTORIES__CLIENT_ID:
			case MqPackage.MQ_CONNECTION_FACTORIES__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
			case MqPackage.MQ_CONNECTION_FACTORIES__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
			case MqPackage.MQ_CONNECTION_FACTORIES__DIRECT_BROKER_AUTHORIZATION_TYPE:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_CLONE_SUPPORT:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_MESSAGE_RETENTION:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_MQ_CONNECTION_POOLING:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_MULTICAST_TRANSPORT:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_RETURN_METHODS_DURING_SHUTDOWN:
			case MqPackage.MQ_CONNECTION_FACTORIES__ENABLE_SPARSE_BROKER_SUBSCRIPTIONS:
			case MqPackage.MQ_CONNECTION_FACTORIES__HOST:
			case MqPackage.MQ_CONNECTION_FACTORIES__JNDI_NAME:
			case MqPackage.MQ_CONNECTION_FACTORIES__LOCAL_SERVER_ADDRESS:
			case MqPackage.MQ_CONNECTION_FACTORIES__MAPPING_CONFIGURATION_ALIAS:
			case MqPackage.MQ_CONNECTION_FACTORIES__MODEL_QUEUE_DEFINITION:
			case MqPackage.MQ_CONNECTION_FACTORIES__NAME1:
			case MqPackage.MQ_CONNECTION_FACTORIES__PERSISTENT_SUBSCRIPTIONS_STORE:
			case MqPackage.MQ_CONNECTION_FACTORIES__POLLING_INTERVAL:
			case MqPackage.MQ_CONNECTION_FACTORIES__PORT:
			case MqPackage.MQ_CONNECTION_FACTORIES__PROXY_HOST_NAME:
			case MqPackage.MQ_CONNECTION_FACTORIES__PROXY_PORT:
			case MqPackage.MQ_CONNECTION_FACTORIES__PUBLISH_AND_ACKNOWLEDGEMENT_INTERVAL:
			case MqPackage.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL:
			case MqPackage.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL:
			case MqPackage.MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL:
			case MqPackage.MQ_CONNECTION_FACTORIES__QUEUE_MANAGER:
			case MqPackage.MQ_CONNECTION_FACTORIES__RESCAN_INTERVAL:
			case MqPackage.MQ_CONNECTION_FACTORIES__SSL_CIPHER_SUITE:
			case MqPackage.MQ_CONNECTION_FACTORIES__SSLCRL:
			case MqPackage.MQ_CONNECTION_FACTORIES__SSL_PEER_NAME:
			case MqPackage.MQ_CONNECTION_FACTORIES__TEMPORARY_QUEUE_PREFIX:
			case MqPackage.MQ_CONNECTION_FACTORIES__TRANSPORT_TYPE:
			case MqPackage.MQ_CONNECTION_FACTORIES__XA_ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		Object childFeature = feature;
		Object childObject = child;

		if (childFeature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify =
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE ||
			childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return MqEditPlugin.INSTANCE;
	}

}
