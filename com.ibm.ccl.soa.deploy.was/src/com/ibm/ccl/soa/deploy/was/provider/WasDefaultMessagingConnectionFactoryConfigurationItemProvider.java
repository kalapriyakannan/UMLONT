/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import com.ibm.ccl.soa.deploy.j2ee.jms.provider.JMSConnectionFactoryItemProvider;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * This is the item provider adapter for a
 * {@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingConnectionFactoryConfiguration} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class WasDefaultMessagingConnectionFactoryConfigurationItemProvider extends
		JMSConnectionFactoryItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public WasDefaultMessagingConnectionFactoryConfigurationItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCategoryPropertyDescriptor(object);
			addClientIdentifierPropertyDescriptor(object);
			addConnectionProximityPropertyDescriptor(object);
			addDurableSubscriptionHomePropertyDescriptor(object);
			addNonpersistentMessageReliabilityPropertyDescriptor(object);
			addPersistentMessageReliabilityPropertyDescriptor(object);
			addProviderEndpointsPropertyDescriptor(object);
			addReadAheadPropertyDescriptor(object);
			addShareDurableSubscriptionsPropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
			addTargetInboundTransportChainPropertyDescriptor(object);
			addTargetSignificancePropertyDescriptor(object);
			addTargetTypePropertyDescriptor(object);
			addTempQnamePrefixPropertyDescriptor(object);
			addTempTopicNamePrefixPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_category_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_clientIdentifier_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_clientIdentifier_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Proximity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionProximityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_connectionProximity_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_connectionProximity_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Durable Subscription Home feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDurableSubscriptionHomePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_durableSubscriptionHome_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_durableSubscriptionHome_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Nonpersistent Message Reliability feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNonpersistentMessageReliabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_nonpersistentMessageReliability_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_nonpersistentMessageReliability_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Persistent Message Reliability feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPersistentMessageReliabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_persistentMessageReliability_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_persistentMessageReliability_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider Endpoints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderEndpointsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_providerEndpoints_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_providerEndpoints_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Ahead feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addReadAheadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_readAhead_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_readAhead_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Share Durable Subscriptions feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addShareDurableSubscriptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_shareDurableSubscriptions_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_shareDurableSubscriptions_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_target_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_target_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Inbound Transport Chain feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetInboundTransportChainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetInboundTransportChain_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetInboundTransportChain_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Significance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetSignificancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetSignificance_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetSignificance_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Type feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addTargetTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetType_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_targetType_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temp Qname Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTempQnamePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_tempQnamePrefix_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_tempQnamePrefix_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temp Topic Name Prefix feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTempTopicNamePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_tempTopicNamePrefix_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_tempTopicNamePrefix_feature", "_UI_WasDefaultMessagingConnectionFactoryConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns WasDefaultMessagingConnectionFactoryConfiguration.gif. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/WasDefaultMessagingConnectionFactoryConfiguration")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WasDefaultMessagingConnectionFactoryConfiguration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_type") : //$NON-NLS-1$
			getString("_UI_WasDefaultMessagingConnectionFactoryConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WasDefaultMessagingConnectionFactoryConfiguration.class)) {
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CATEGORY:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CLIENT_IDENTIFIER:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__CONNECTION_PROXIMITY:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__DURABLE_SUBSCRIPTION_HOME:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__NONPERSISTENT_MESSAGE_RELIABILITY:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PERSISTENT_MESSAGE_RELIABILITY:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__PROVIDER_ENDPOINTS:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__READ_AHEAD:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__SHARE_DURABLE_SUBSCRIPTIONS:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_INBOUND_TRANSPORT_CHAIN:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_SIGNIFICANCE:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TARGET_TYPE:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_QNAME_PREFIX:
			case WasPackage.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION__TEMP_TOPIC_NAME_PREFIX:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * This returns the icon image for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getCreateChildImage(Object owner, Object feature, Object child,
			Collection selection) {
		if (feature instanceof EStructuralFeature && FeatureMapUtil.isFeatureMap((EStructuralFeature)feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry)child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();        
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject)child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			}
			catch (Exception e) {
				WasEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return WasEditPlugin.INSTANCE;
	}

}
