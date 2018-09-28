/**
 * <copyright> </copyright>
 * 
 * $Id: SoftwareInstallItemProvider.java,v 1.4 2008/04/29 23:03:47 esnible Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.provider;

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
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;

/**
 * This is the item provider adapter for a
 * {@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class SoftwareInstallItemProvider extends CapabilityItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public SoftwareInstallItemProvider(AdapterFactory adapterFactory) {
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

			addExecutableNamePropertyDescriptor(object);
			addInstallDatePropertyDescriptor(object);
			addInstalledLocationPropertyDescriptor(object);
			addProductIdPropertyDescriptor(object);
			addProductNamePropertyDescriptor(object);
			addPublisherPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Executable Name feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExecutableNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_executableName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_executableName_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__EXECUTABLE_NAME, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Install Date feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInstallDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_installDate_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_installDate_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__INSTALL_DATE, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Installed Location feature. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addInstalledLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_installedLocation_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_installedLocation_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__INSTALLED_LOCATION, true,
						false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Product Id feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProductIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_productId_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_productId_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__PRODUCT_ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Product Name feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProductNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_productName_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_productName_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__PRODUCT_NAME, true, false,
						false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Publisher feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPublisherPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SoftwareInstall_publisher_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_SoftwareInstall_publisher_feature", "_UI_SoftwareInstall_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						GenericsoftwarePackage.Literals.SOFTWARE_INSTALL__PUBLISHER, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns SoftwareInstall.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/SoftwareInstall")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((SoftwareInstall) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SoftwareInstall_type") : //$NON-NLS-1$
				getString("_UI_SoftwareInstall_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(SoftwareInstall.class))
		{
		case GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME:
		case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE:
		case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION:
		case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID:
		case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME:
		case GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER:
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
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return GenericsoftwareEditPlugin.INSTANCE;
	}

}
