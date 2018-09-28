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
import com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MesseageListernerServicePortItemProvider
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
	public MesseageListernerServicePortItemProvider(AdapterFactory adapterFactory) {
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

			addCFJNDINamePropertyDescriptor(object);
			addDestinationJNDINamePropertyDescriptor(object);
			addMaxRetriesPropertyDescriptor(object);
			addMaxSessionsPropertyDescriptor(object);
			addName1PropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the CFJNDI Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCFJNDINamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MesseageListernerServicePort_cFJNDIName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MesseageListernerServicePort_cFJNDIName_feature", "_UI_MesseageListernerServicePort_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Destination JNDI Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestinationJNDINamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MesseageListernerServicePort_destinationJNDIName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MesseageListernerServicePort_destinationJNDIName_feature", "_UI_MesseageListernerServicePort_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Retries feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxRetriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MesseageListernerServicePort_maxRetries_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MesseageListernerServicePort_maxRetries_feature", "_UI_MesseageListernerServicePort_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES,
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
				 getString("_UI_MesseageListernerServicePort_maxSessions_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MesseageListernerServicePort_maxSessions_feature", "_UI_MesseageListernerServicePort_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS,
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
				 getString("_UI_MesseageListernerServicePort_name1_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_MesseageListernerServicePort_name1_feature", "_UI_MesseageListernerServicePort_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns MesseageListernerServicePort.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MesseageListernerServicePort")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MesseageListernerServicePort)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MesseageListernerServicePort_type") : //$NON-NLS-1$
			getString("_UI_MesseageListernerServicePort_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(MesseageListernerServicePort.class)) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME:
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME:
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES:
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS:
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1:
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
