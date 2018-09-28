/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.provider;

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
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class WindowsOperatingSystemItemProvider extends OperatingSystemItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
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
	public WindowsOperatingSystemItemProvider(AdapterFactory adapterFactory) {
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

			addCompanyPropertyDescriptor(object);
			addDomainAdminPropertyDescriptor(object);
			addDomainNamePropertyDescriptor(object);
			addDomainPasswordPropertyDescriptor(object);
			addEncryptionLevelPropertyDescriptor(object);
			addInstallDatePropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addLanguageGroupPropertyDescriptor(object);
			addLastBootUpTimePropertyDescriptor(object);
			addMachineObjectOUPropertyDescriptor(object);
			addNumberOfLicensedUsersPropertyDescriptor(object);
			addOwnerPropertyDescriptor(object);
			addProductKeyPropertyDescriptor(object);
			addProductTypePropertyDescriptor(object);
			addSystemDrivePropertyDescriptor(object);
			addWindowsDirectoryPropertyDescriptor(object);
			addWorkgroupNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Company feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addCompanyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_company_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_company_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__COMPANY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Domain Admin feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDomainAdminPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_domainAdmin_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_domainAdmin_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Domain Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDomainNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_domainName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_domainName_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Domain Password feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addDomainPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_domainPassword_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_domainPassword_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Encryption Level feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addEncryptionLevelPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_encryptionLevel_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_encryptionLevel_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Install Date feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addInstallDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_installDate_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_installDate_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_language_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_language_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__LANGUAGE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Language Group feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addLanguageGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_languageGroup_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_languageGroup_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Last Boot Up Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastBootUpTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_lastBootUpTime_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_lastBootUpTime_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Machine Object OU feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMachineObjectOUPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_machineObjectOU_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_machineObjectOU_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Number Of Licensed Users feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberOfLicensedUsersPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_numberOfLicensedUsers_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_numberOfLicensedUsers_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS, true,
						false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Owner feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addOwnerPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_owner_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_owner_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__OWNER, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Product Key feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addProductKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_productKey_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_productKey_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Product Type feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addProductTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_productType_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_productType_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the System Drive feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSystemDrivePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_systemDrive_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_systemDrive_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Windows Directory feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWindowsDirectoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_windowsDirectory_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_windowsDirectory_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Workgroup Name feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addWorkgroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_WindowsOperatingSystem_workgroupName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_WindowsOperatingSystem_workgroupName_feature", "_UI_WindowsOperatingSystem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						OsPackage.Literals.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns WindowsOperatingSystem.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator()
				.getImage("full/obj16/WindowsOperatingSystem")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((WindowsOperatingSystem) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_WindowsOperatingSystem_type") : //$NON-NLS-1$
				getString("_UI_WindowsOperatingSystem_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(WindowsOperatingSystem.class))
		{
		case OsPackage.WINDOWS_OPERATING_SYSTEM__COMPANY:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__INSTALL_DATE:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__OWNER:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY:
		case OsPackage.WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
					true));
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return OsEditPlugin.INSTANCE;
	}

}
