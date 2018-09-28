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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.mq.MQRoot;
import com.ibm.ccl.soa.deploy.mq.MqFactory;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MQRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MQRootItemProvider
	extends ItemProviderAdapter
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
	public MQRootItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_LISTENER);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_LISTENER_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT);
			childrenFeatures.add(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MQRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MQRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_MQRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(MQRoot.class)) {
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_DESTINATION:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_LISTENER:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY:
			case MqPackage.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION:
			case MqPackage.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_LISTENER_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_QUEUE_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT:
			case MqPackage.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION,
				 MqFactory.eINSTANCE.createMQActivationSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM,
				 MqFactory.eINSTANCE.createMQBaseSystem()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES,
				 MqFactory.eINSTANCE.createMQConnectionFactories()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION,
				 MqFactory.eINSTANCE.createMQDestination()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION,
				 MqFactory.eINSTANCE.createMQQueueDestination()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_LISTENER,
				 MqFactory.eINSTANCE.createMQListener()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER,
				 MqFactory.eINSTANCE.createMQMessagingProvider()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT,
				 MqFactory.eINSTANCE.createMesseageListernerServicePort()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE,
				 MqFactory.eINSTANCE.createMQQueue()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL,
				 MqFactory.eINSTANCE.createMQQueueChannel()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY,
				 MqFactory.eINSTANCE.createMQQueueConnectionFactory()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION,
				 MqFactory.eINSTANCE.createMQQueueDestination()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER,
				 MqFactory.eINSTANCE.createMQQueueManager()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY,
				 MqFactory.eINSTANCE.createMQTopicConnectionFactory()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION,
				 MqFactory.eINSTANCE.createMQTopicDestination()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT,
				 MqFactory.eINSTANCE.createMQActivationSpecificationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT,
				 MqFactory.eINSTANCE.createMQBaseSystemUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT,
				 MqFactory.eINSTANCE.createMQConnectionFactoriesUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_LISTENER_UNIT,
				 MqFactory.eINSTANCE.createMQListenerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT,
				 MqFactory.eINSTANCE.createMQMessageListnerServicePortUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT,
				 MqFactory.eINSTANCE.createMQMessagingProviderUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT,
				 MqFactory.eINSTANCE.createMQQueueChannelUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT,
				 MqFactory.eINSTANCE.createMQQueueConnectionFactoryUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT,
				 MqFactory.eINSTANCE.createMQQueueDestinationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT,
				 MqFactory.eINSTANCE.createMQQueueManagerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_QUEUE_UNIT,
				 MqFactory.eINSTANCE.createMQQueueUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT,
				 MqFactory.eINSTANCE.createMQTopicConnectionFactoryUnit()));

		newChildDescriptors.add
			(createChildParameter
				(MqPackage.Literals.MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT,
				 MqFactory.eINSTANCE.createMQTopicDestinationUnit()));
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

		boolean qualify =
			childFeature == MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_DESTINATION ||
			childFeature == MqPackage.Literals.MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION;

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
