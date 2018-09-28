/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.provider;

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
import com.ibm.ccl.soa.deploy.core.provider.CapabilityItemProvider;
import com.ibm.ccl.soa.deploy.os.LinuxLocalService;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.os.LinuxLocalService}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class LinuxLocalServiceItemProvider extends CapabilityItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public LinuxLocalServiceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExecutablePathPropertyDescriptor(object);
			addServiceAccountPropertyDescriptor(object);
			addServiceDescriptionPropertyDescriptor(object);
			addServiceNamePropertyDescriptor(object);
			addServiceStatusPropertyDescriptor(object);
			addStartupRunLevelFivePropertyDescriptor(object);
			addStartupRunLevelFourPropertyDescriptor(object);
			addStartupRunLevelOnePropertyDescriptor(object);
			addStartupRunLevelSixPropertyDescriptor(object);
			addStartupRunLevelThreePropertyDescriptor(object);
			addStartupRunLevelTwoPropertyDescriptor(object);
			addStartupRunLevelZeroPropertyDescriptor(object);
			addStartupTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Executable Path feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExecutablePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_executablePath_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_executablePath_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Service Account feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addServiceAccountPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_serviceAccount_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_serviceAccount_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Service Description feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addServiceDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_serviceDescription_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_serviceDescription_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Service Name feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addServiceNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_serviceName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_serviceName_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__SERVICE_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Service Status feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addServiceStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_serviceStatus_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_serviceStatus_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__SERVICE_STATUS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Five feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelFivePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelFive_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelFive_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Four feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelFourPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelFour_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelFour_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level One feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelOnePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelOne_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelOne_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Six feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelSixPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelSix_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelSix_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Three feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelThreePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelThree_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelThree_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Two feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelTwoPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelTwo_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelTwo_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Run Level Zero feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupRunLevelZeroPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupRunLevelZero_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupRunLevelZero_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Startup Type feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStartupTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_LinuxLocalService_startupType_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_LinuxLocalService_startupType_feature", "_UI_LinuxLocalService_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.LINUX_LOCAL_SERVICE__STARTUP_TYPE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns LinuxLocalService.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/LinuxLocalService")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((LinuxLocalService) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_LinuxLocalService_type") : //$NON-NLS-1$
				getString("_UI_LinuxLocalService_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LinuxLocalService.class))
		{
		case OsPackage.LINUX_LOCAL_SERVICE__EXECUTABLE_PATH:
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT:
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION:
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_NAME:
		case OsPackage.LINUX_LOCAL_SERVICE__SERVICE_STATUS:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO:
		case OsPackage.LINUX_LOCAL_SERVICE__STARTUP_TYPE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
	 * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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

		if (childFeature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) childFeature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) childObject;
			childFeature = entry.getEStructuralFeature();
			childObject = entry.getValue();
		}

		boolean qualify = childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__ARTIFACTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE
				|| childFeature == CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS
				|| childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR;

		if (qualify) {
			return getString("_UI_CreateChild_text2", //$NON-NLS-1$
					new Object[] { getTypeText(childObject), getFeatureText(childFeature),
							getTypeText(owner) });
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
		if (feature instanceof EStructuralFeature
				&& FeatureMapUtil.isFeatureMap((EStructuralFeature) feature)) {
			FeatureMap.Entry entry = (FeatureMap.Entry) child;
			feature = entry.getEStructuralFeature();
			child = entry.getValue();
		}

		if (feature instanceof EReference && child instanceof EObject) {
			String name = "full/obj16/" + ((EObject) child).eClass().getName(); //$NON-NLS-1$

			try {
				return getResourceLocator().getImage(name);
			} catch (Exception e) {
				OsEditPlugin.INSTANCE.log(e);
			}
		}

		return super.getCreateChildImage(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return OsEditPlugin.INSTANCE;
	}

}
