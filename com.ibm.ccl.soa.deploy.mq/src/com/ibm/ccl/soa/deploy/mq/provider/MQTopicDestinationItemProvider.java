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
import com.ibm.ccl.soa.deploy.mq.MQTopicDestination;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MQTopicDestinationItemProvider
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
	public MQTopicDestinationItemProvider(AdapterFactory adapterFactory) {
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

			addBaseTopicNamePropertyDescriptor(object);
			addBrokerCCDurableSubscriptionQueuePropertyDescriptor(object);
			addBrokerDurableSubscriptionQueuePropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addDecimalEncodingPropertyDescriptor(object);
			addDescription1PropertyDescriptor(object);
			addDestinationNamePropertyDescriptor(object);
			addEnableMulticastTransportPropertyDescriptor(object);
			addExpiryPropertyDescriptor(object);
			addFloatingPointEncodingPropertyDescriptor(object);
			addIntegerEncodingPropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addPersitencePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addSpecifiedExpiryPropertyDescriptor(object);
			addSpecifiedPriorityPropertyDescriptor(object);
			addTargetClientPropertyDescriptor(object);
			addUseNativeEncodingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Topic Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseTopicNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_baseTopicName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_baseTopicName_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker CC Durable Subscription Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerCCDurableSubscriptionQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_brokerCCDurableSubscriptionQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_brokerCCDurableSubscriptionQueue_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Broker Durable Subscription Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBrokerDurableSubscriptionQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_brokerDurableSubscriptionQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_brokerDurableSubscriptionQueue_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE,
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
				 getString("_UI_MQTopicDestination_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_category_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__CATEGORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Decimal Encoding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDecimalEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_decimalEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_decimalEncoding_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING,
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
				 getString("_UI_MQTopicDestination_description1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_description1_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__DESCRIPTION1,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Destination Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_destinationName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_destinationName_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__DESTINATION_NAME,
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
				 getString("_UI_MQTopicDestination_enableMulticastTransport_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_enableMulticastTransport_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expiry feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpiryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_expiry_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_expiry_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__EXPIRY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Floating Point Encoding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFloatingPointEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_floatingPointEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_floatingPointEncoding_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Integer Encoding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntegerEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_integerEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_integerEncoding_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__INTEGER_ENCODING,
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
				 getString("_UI_MQTopicDestination_jndiName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_jndiName_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__JNDI_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Persitence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPersitencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_persitence_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_persitence_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__PERSITENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_priority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_priority_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Specified Expiry feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecifiedExpiryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_specifiedExpiry_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_specifiedExpiry_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Specified Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecifiedPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_specifiedPriority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_specifiedPriority_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Client feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetClientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_targetClient_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_targetClient_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__TARGET_CLIENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Native Encoding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseNativeEncodingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQTopicDestination_useNativeEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQTopicDestination_useNativeEncoding_feature", "_UI_MQTopicDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns MQTopicDestination.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MQTopicDestination")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MQTopicDestination)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MQTopicDestination_type") : //$NON-NLS-1$
			getString("_UI_MQTopicDestination_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(MQTopicDestination.class)) {
			case MqPackage.MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME:
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE:
			case MqPackage.MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE:
			case MqPackage.MQ_TOPIC_DESTINATION__CATEGORY:
			case MqPackage.MQ_TOPIC_DESTINATION__DECIMAL_ENCODING:
			case MqPackage.MQ_TOPIC_DESTINATION__DESCRIPTION1:
			case MqPackage.MQ_TOPIC_DESTINATION__DESTINATION_NAME:
			case MqPackage.MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT:
			case MqPackage.MQ_TOPIC_DESTINATION__EXPIRY:
			case MqPackage.MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING:
			case MqPackage.MQ_TOPIC_DESTINATION__INTEGER_ENCODING:
			case MqPackage.MQ_TOPIC_DESTINATION__JNDI_NAME:
			case MqPackage.MQ_TOPIC_DESTINATION__PERSITENCE:
			case MqPackage.MQ_TOPIC_DESTINATION__PRIORITY:
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY:
			case MqPackage.MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY:
			case MqPackage.MQ_TOPIC_DESTINATION__TARGET_CLIENT:
			case MqPackage.MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING:
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
