/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.provider;


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
import com.ibm.ccl.soa.deploy.wps.TaskContainer;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.wps.TaskContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskContainerItemProvider
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
	public TaskContainerItemProvider(AdapterFactory adapterFactory) {
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

			addAdministratorSecurityRoleMappingPropertyDescriptor(object);
			addClasspathPropertyDescriptor(object);
			addEnableAuditLogPropertyDescriptor(object);
			addEnableCEIloggingPropertyDescriptor(object);
			addEscalationpasswordPropertyDescriptor(object);
			addHoldQueuePropertyDescriptor(object);
			addJMSConnectionFactoryPropertyDescriptor(object);
			addJMSPasswordPropertyDescriptor(object);
			addJMSProviderPropertyDescriptor(object);
			addJMSResourcesPropertyDescriptor(object);
			addJMSUserIDPropertyDescriptor(object);
			addMailSessionPropertyDescriptor(object);
			addQueueManagerPropertyDescriptor(object);
			addSystemMonitorSecurityRoleMappingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Administrator Security Role Mapping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdministratorSecurityRoleMappingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_administratorSecurityRoleMapping_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_administratorSecurityRoleMapping_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Classpath feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClasspathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_classpath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_classpath_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__CLASSPATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable Audit Log feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableAuditLogPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_enableAuditLog_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_enableAuditLog_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__ENABLE_AUDIT_LOG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enable CE Ilogging feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnableCEIloggingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_enableCEIlogging_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_enableCEIlogging_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__ENABLE_CE_ILOGGING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Escalationpassword feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEscalationpasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_escalationpassword_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_escalationpassword_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__ESCALATIONPASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hold Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHoldQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_holdQueue_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_holdQueue_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__HOLD_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the JMS Connection Factory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJMSConnectionFactoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_jMSConnectionFactory_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_jMSConnectionFactory_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__JMS_CONNECTION_FACTORY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the JMS Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJMSPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_jMSPassword_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_jMSPassword_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__JMS_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the JMS Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJMSProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_jMSProvider_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_jMSProvider_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__JMS_PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the JMS Resources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJMSResourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_jMSResources_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_jMSResources_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__JMS_RESOURCES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the JMS User ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJMSUserIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_jMSUserID_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_jMSUserID_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__JMS_USER_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mail Session feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMailSessionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_mailSession_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_mailSession_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__MAIL_SESSION,
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
				 getString("_UI_TaskContainer_queueManager_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_queueManager_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__QUEUE_MANAGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System Monitor Security Role Mapping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemMonitorSecurityRoleMappingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TaskContainer_systemMonitorSecurityRoleMapping_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TaskContainer_systemMonitorSecurityRoleMapping_feature", "_UI_TaskContainer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 WpsPackage.Literals.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns TaskContainer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TaskContainer")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((TaskContainer)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TaskContainer_type") : //$NON-NLS-1$
			getString("_UI_TaskContainer_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(TaskContainer.class)) {
			case WpsPackage.TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING:
			case WpsPackage.TASK_CONTAINER__CLASSPATH:
			case WpsPackage.TASK_CONTAINER__ENABLE_AUDIT_LOG:
			case WpsPackage.TASK_CONTAINER__ENABLE_CE_ILOGGING:
			case WpsPackage.TASK_CONTAINER__ESCALATIONPASSWORD:
			case WpsPackage.TASK_CONTAINER__HOLD_QUEUE:
			case WpsPackage.TASK_CONTAINER__JMS_CONNECTION_FACTORY:
			case WpsPackage.TASK_CONTAINER__JMS_PASSWORD:
			case WpsPackage.TASK_CONTAINER__JMS_PROVIDER:
			case WpsPackage.TASK_CONTAINER__JMS_RESOURCES:
			case WpsPackage.TASK_CONTAINER__JMS_USER_ID:
			case WpsPackage.TASK_CONTAINER__MAIL_SESSION:
			case WpsPackage.TASK_CONTAINER__QUEUE_MANAGER:
			case WpsPackage.TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING:
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
		return WpsEditPlugin.INSTANCE;
	}

}
