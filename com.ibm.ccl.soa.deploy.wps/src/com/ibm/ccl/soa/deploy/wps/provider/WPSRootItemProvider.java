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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.ibm.ccl.soa.deploy.wps.WPSRoot;
import com.ibm.ccl.soa.deploy.wps.WpsFactory;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.wps.WPSRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WPSRootItemProvider
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
	public WPSRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BPE_CONTAINER);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SCA_RUNTIME);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SDO_RUNTIME);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_TASK_CONTAINER);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSESB);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSSIB);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_WPSESB_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_WPSSIB_UNIT);
			childrenFeatures.add(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT);
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
	 * This returns WPSRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/WPSRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_WPSRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(WPSRoot.class)) {
			case WpsPackage.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR:
			case WpsPackage.WPS_ROOT__CAPABILITY_BPE_CONTAINER:
			case WpsPackage.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER:
			case WpsPackage.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE:
			case WpsPackage.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE:
			case WpsPackage.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE:
			case WpsPackage.WPS_ROOT__CAPABILITY_SCA_RUNTIME:
			case WpsPackage.WPS_ROOT__CAPABILITY_SDO_RUNTIME:
			case WpsPackage.WPS_ROOT__CAPABILITY_TASK_CONTAINER:
			case WpsPackage.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE:
			case WpsPackage.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM:
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSESB:
			case WpsPackage.WPS_ROOT__CAPABILITY_WPSSIB:
			case WpsPackage.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_WPSESB_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_WPSSIB_UNIT:
			case WpsPackage.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT:
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
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR,
				 WpsFactory.eINSTANCE.createApplicationSchedular()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BPE_CONTAINER,
				 WpsFactory.eINSTANCE.createBPEContainer()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER,
				 WpsFactory.eINSTANCE.createBusinessRulesManager()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE,
				 WpsFactory.eINSTANCE.createCommonEventInfrastructure()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE,
				 WpsFactory.eINSTANCE.createExtendedMessagingService()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE,
				 WpsFactory.eINSTANCE.createManagingEventservice()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SCA_RUNTIME,
				 WpsFactory.eINSTANCE.createSCARuntime()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_SDO_RUNTIME,
				 WpsFactory.eINSTANCE.createSDORuntime()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_TASK_CONTAINER,
				 WpsFactory.eINSTANCE.createTaskContainer()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE,
				 WpsFactory.eINSTANCE.createWebSphereBusinessIntegrationAdaptersService()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM,
				 WpsFactory.eINSTANCE.createWpsBaseSystem()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSESB,
				 WpsFactory.eINSTANCE.createWPSESB()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__CAPABILITY_WPSSIB,
				 WpsFactory.eINSTANCE.createWPSSIB()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_BPE_CONTAINER_UNIT,
				 WpsFactory.eINSTANCE.createBPEContainerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT,
				 WpsFactory.eINSTANCE.createBusinessRulesManagerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_TASK_CONTAINER_UNIT,
				 WpsFactory.eINSTANCE.createTaskContainerUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT,
				 WpsFactory.eINSTANCE.createWpsBaseSystemUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT,
				 WpsFactory.eINSTANCE.createWPSCommonEventInfrastructureUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_WPSESB_UNIT,
				 WpsFactory.eINSTANCE.createWPSESBUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_WPSSIB_UNIT,
				 WpsFactory.eINSTANCE.createWPSSIBUnit()));

		newChildDescriptors.add
			(createChildParameter
				(WpsPackage.Literals.WPS_ROOT__UNIT_WPS_SYSTEM_UNIT,
				 WpsFactory.eINSTANCE.createWpsSystemUnit()));
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
