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
import com.ibm.ccl.soa.deploy.mq.MQDestination;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MQDestination} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MQDestinationItemProvider
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
	public MQDestinationItemProvider(AdapterFactory adapterFactory) {
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

			addBaseQueueManagerNamePropertyDescriptor(object);
			addBaseQueueNamePropertyDescriptor(object);
			addCategoryPropertyDescriptor(object);
			addCCSIDPropertyDescriptor(object);
			addDecimalEncodingPropertyDescriptor(object);
			addDescription1PropertyDescriptor(object);
			addDestinationNamePropertyDescriptor(object);
			addExpiryPropertyDescriptor(object);
			addFloatingPointEncodingPropertyDescriptor(object);
			addIntegerEncodingPropertyDescriptor(object);
			addJndiNamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addPersitencePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addQueueManagerHostPropertyDescriptor(object);
			addQueueManagerPortPropertyDescriptor(object);
			addServerConnectionChannelNamePropertyDescriptor(object);
			addSpecifiedExpiryPropertyDescriptor(object);
			addSpecifiedPriorityPropertyDescriptor(object);
			addTargetClientPropertyDescriptor(object);
			addUseNativeEncodingPropertyDescriptor(object);
			addUserIDPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Queue Manager Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseQueueManagerNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_baseQueueManagerName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_baseQueueManagerName_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Base Queue Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBaseQueueNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_baseQueueName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_baseQueueName_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__BASE_QUEUE_NAME,
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
				 getString("_UI_MQDestination_category_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_category_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__CATEGORY,
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
				 getString("_UI_MQDestination_cCSID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_cCSID_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__CCSID,
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
				 getString("_UI_MQDestination_decimalEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_decimalEncoding_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__DECIMAL_ENCODING,
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
				 getString("_UI_MQDestination_description1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_description1_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__DESCRIPTION1,
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
				 getString("_UI_MQDestination_destinationName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_destinationName_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__DESTINATION_NAME,
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
				 getString("_UI_MQDestination_expiry_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_expiry_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__EXPIRY,
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
				 getString("_UI_MQDestination_floatingPointEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_floatingPointEncoding_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__FLOATING_POINT_ENCODING,
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
				 getString("_UI_MQDestination_integerEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_integerEncoding_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__INTEGER_ENCODING,
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
				 getString("_UI_MQDestination_jndiName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_jndiName_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__JNDI_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_password_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_password_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__PASSWORD,
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
				 getString("_UI_MQDestination_persitence_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_persitence_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__PERSITENCE,
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
				 getString("_UI_MQDestination_priority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_priority_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queue Manager Host feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueueManagerHostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_queueManagerHost_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_queueManagerHost_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__QUEUE_MANAGER_HOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queue Manager Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueueManagerPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_queueManagerPort_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_queueManagerPort_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__QUEUE_MANAGER_PORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Server Connection Channel Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addServerConnectionChannelNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_serverConnectionChannelName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_serverConnectionChannelName_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME,
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
				 getString("_UI_MQDestination_specifiedExpiry_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_specifiedExpiry_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__SPECIFIED_EXPIRY,
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
				 getString("_UI_MQDestination_specifiedPriority_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_specifiedPriority_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__SPECIFIED_PRIORITY,
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
				 getString("_UI_MQDestination_targetClient_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_targetClient_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__TARGET_CLIENT,
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
				 getString("_UI_MQDestination_useNativeEncoding_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_useNativeEncoding_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__USE_NATIVE_ENCODING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MQDestination_userID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MQDestination_userID_feature", "_UI_MQDestination_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MQ_DESTINATION__USER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns MQDestination.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MQDestination")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MQDestination)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MQDestination_type") : //$NON-NLS-1$
			getString("_UI_MQDestination_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(MQDestination.class)) {
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME:
			case MqPackage.MQ_DESTINATION__BASE_QUEUE_NAME:
			case MqPackage.MQ_DESTINATION__CATEGORY:
			case MqPackage.MQ_DESTINATION__CCSID:
			case MqPackage.MQ_DESTINATION__DECIMAL_ENCODING:
			case MqPackage.MQ_DESTINATION__DESCRIPTION1:
			case MqPackage.MQ_DESTINATION__DESTINATION_NAME:
			case MqPackage.MQ_DESTINATION__EXPIRY:
			case MqPackage.MQ_DESTINATION__FLOATING_POINT_ENCODING:
			case MqPackage.MQ_DESTINATION__INTEGER_ENCODING:
			case MqPackage.MQ_DESTINATION__JNDI_NAME:
			case MqPackage.MQ_DESTINATION__PASSWORD:
			case MqPackage.MQ_DESTINATION__PERSITENCE:
			case MqPackage.MQ_DESTINATION__PRIORITY:
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_HOST:
			case MqPackage.MQ_DESTINATION__QUEUE_MANAGER_PORT:
			case MqPackage.MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME:
			case MqPackage.MQ_DESTINATION__SPECIFIED_EXPIRY:
			case MqPackage.MQ_DESTINATION__SPECIFIED_PRIORITY:
			case MqPackage.MQ_DESTINATION__TARGET_CLIENT:
			case MqPackage.MQ_DESTINATION__USE_NATIVE_ENCODING:
			case MqPackage.MQ_DESTINATION__USER_ID:
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
