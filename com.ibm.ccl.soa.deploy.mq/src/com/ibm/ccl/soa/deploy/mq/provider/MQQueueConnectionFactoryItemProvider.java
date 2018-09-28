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
import com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MQQueueConnectionFactoryItemProvider
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
	public MQQueueConnectionFactoryItemProvider(AdapterFactory adapterFactory) {
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

			addCategoryPropertyDescriptor(object);
			addCCSIDPropertyDescriptor(object);
			addChannelPropertyDescriptor(object);
			addClientIdPropertyDescriptor(object);
			addComponentManagedAuthenticationAliasPropertyDescriptor(object);
			addContainerManagedAuthenticationAliasPropertyDescriptor(object);
			addDescription1PropertyDescriptor(object);
			addEnableConnectionPolingPropertyDescriptor(object);
			addEnableMessageRetentionPropertyDescriptor(object);
			addEnableReturnMethodDuringShutdownPropertyDescriptor(object);
			addFactoryNamePropertyDescriptor(object);
			addHostPropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addLocalServerAddressPropertyDescriptor(object);
			addMappingconfigurationAliasPropertyDescriptor(object);
			addMaxConnectionsPropertyDescriptor(object);
			addMaxSessionsPropertyDescriptor(object);
			addMinConnectionsPropertyDescriptor(object);
			addMinSessionsPropertyDescriptor(object);
			addModelQueueDefinitionPropertyDescriptor(object);
			addPollingIntervalPropertyDescriptor(object);
			addPortPropertyDescriptor(object);
			addQueuemanagerPropertyDescriptor(object);
			addRescanIntervalPropertyDescriptor(object);
			addSSLCipherSuitPropertyDescriptor(object);
			addSSLCRLPropertyDescriptor(object);
			addSSLPeerNamePropertyDescriptor(object);
			addTemporaryQueuePrefixPropertyDescriptor(object);
			addTransportTypePropertyDescriptor(object);
			addXAEnabledPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_MQQueueConnectionFactory_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_category_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY,
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
				 getString("_UI_MQQueueConnectionFactory_cCSID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_cCSID_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__CCSID,
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
				 getString("_UI_MQQueueConnectionFactory_channel_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_channel_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL,
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
				 getString("_UI_MQQueueConnectionFactory_clientId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_clientId_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID,
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
				 getString("_UI_MQQueueConnectionFactory_componentManagedAuthenticationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_componentManagedAuthenticationAlias_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS,
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
				 getString("_UI_MQQueueConnectionFactory_containerManagedAuthenticationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_containerManagedAuthenticationAlias_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescription1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_description1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_description1_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Connection Poling feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableConnectionPolingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_enableConnectionPoling_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_enableConnectionPoling_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING,
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
				 getString("_UI_MQQueueConnectionFactory_enableMessageRetention_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_enableMessageRetention_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Return Method During Shutdown feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableReturnMethodDuringShutdownPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_enableReturnMethodDuringShutdown_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_enableReturnMethodDuringShutdown_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Factory Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFactoryNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_factoryName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_factoryName_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME,
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
				 getString("_UI_MQQueueConnectionFactory_host_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_host_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__HOST,
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
				 getString("_UI_MQQueueConnectionFactory_jndiName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_jndiName_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME,
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
				 getString("_UI_MQQueueConnectionFactory_localServerAddress_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_localServerAddress_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mappingconfiguration Alias feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMappingconfigurationAliasPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_mappingconfigurationAlias_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_mappingconfigurationAlias_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_maxConnections_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_maxConnections_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Sessions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxSessionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_maxSessions_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_maxSessions_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_minConnections_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_minConnections_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Sessions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinSessionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_minSessions_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_minSessions_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS,
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
				 getString("_UI_MQQueueConnectionFactory_modelQueueDefinition_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_modelQueueDefinition_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION,
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
				 getString("_UI_MQQueueConnectionFactory_pollingInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_pollingInterval_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL,
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
				 getString("_UI_MQQueueConnectionFactory_port_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_port_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queuemanager feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueuemanagerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_queuemanager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_queuemanager_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER,
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
				 getString("_UI_MQQueueConnectionFactory_rescanInterval_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_rescanInterval_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the SSL Cipher Suit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSSLCipherSuitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQQueueConnectionFactory_sSLCipherSuit_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_sSLCipherSuit_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT,
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
				 getString("_UI_MQQueueConnectionFactory_sSLCRL_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_sSLCRL_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL,
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
				 getString("_UI_MQQueueConnectionFactory_sSLPeerName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_sSLPeerName_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME,
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
				 getString("_UI_MQQueueConnectionFactory_temporaryQueuePrefix_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_temporaryQueuePrefix_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX,
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
				 getString("_UI_MQQueueConnectionFactory_transportType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_transportType_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE,
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
				 getString("_UI_MQQueueConnectionFactory_xAEnabled_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQQueueConnectionFactory_xAEnabled_feature", "_UI_MQQueueConnectionFactory_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns MQQueueConnectionFactory.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MQQueueConnectionFactory")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MQQueueConnectionFactory)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MQQueueConnectionFactory_type") : //$NON-NLS-1$
			getString("_UI_MQQueueConnectionFactory_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(MQQueueConnectionFactory.class)) {
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CATEGORY:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CCSID:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CHANNEL:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__HOST:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__PORT:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSLCRL:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE:
			case MqPackage.MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED:
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
