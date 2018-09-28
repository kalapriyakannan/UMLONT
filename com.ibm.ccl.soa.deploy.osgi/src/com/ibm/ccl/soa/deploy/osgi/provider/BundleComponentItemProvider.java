/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.provider;


import com.ibm.ccl.soa.deploy.core.CorePackage;

import com.ibm.ccl.soa.deploy.core.provider.SoftwareComponentItemProvider;

import com.ibm.ccl.soa.deploy.osgi.BundleComponent;
import com.ibm.ccl.soa.deploy.osgi.OsgiFactory;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

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

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.osgi.BundleComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BundleComponentItemProvider
	extends SoftwareComponentItemProvider
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
	public BundleComponentItemProvider(AdapterFactory adapterFactory) {
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

			addActivatorPropertyDescriptor(object);
			addEclipseLazyStartPropertyDescriptor(object);
			addLocalizationPropertyDescriptor(object);
			addManifestVersionPropertyDescriptor(object);
			addSingletonPropertyDescriptor(object);
			addVendorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Activator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_activator_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_activator_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__ACTIVATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Eclipse Lazy Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEclipseLazyStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_eclipseLazyStart_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_eclipseLazyStart_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__ECLIPSE_LAZY_START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Localization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocalizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_localization_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_localization_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__LOCALIZATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Manifest Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addManifestVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_manifestVersion_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_manifestVersion_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__MANIFEST_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Singleton feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSingletonPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_singleton_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_singleton_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__SINGLETON,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vendor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVendorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BundleComponent_vendor_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_BundleComponent_vendor_feature", "_UI_BundleComponent_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 OsgiPackage.Literals.BUNDLE_COMPONENT__VENDOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns BundleComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BundleComponent")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((BundleComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BundleComponent_type") : //$NON-NLS-1$
			getString("_UI_BundleComponent_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(BundleComponent.class)) {
			case OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR:
			case OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START:
			case OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION:
			case OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION:
			case OsgiPackage.BUNDLE_COMPONENT__SINGLETON:
			case OsgiPackage.BUNDLE_COMPONENT__VENDOR:
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

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.UNIT__CAPABILITIES,
					 OsgiFactory.eINSTANCE.createBundleCapability())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(CorePackage.Literals.UNIT__CAPABILITIES,
					 OsgiFactory.eINSTANCE.createExportedPackage())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE,
					 OsgiFactory.eINSTANCE.createExportedPackage())));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.UNIT__CAPABILITY_GROUP,
				 FeatureMapUtil.createEntry
					(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE,
					 OsgiFactory.eINSTANCE.createBundleCapability())));
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
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR ||
			childFeature == CorePackage.Literals.UNIT__CAPABILITIES ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE ||
			childFeature == CorePackage.Literals.UNIT__REQUIREMENTS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE ||
			childFeature == CorePackage.Literals.UNIT__UNIT_LINKS ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING ||
			childFeature == CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER;

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
		return OsgiDomainEditPlugin.INSTANCE;
	}

}
