/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.provider;


import com.ibm.ccl.soa.deploy.osgi.OSGiRoot;
import com.ibm.ccl.soa.deploy.osgi.OsgiFactory;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

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

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OSGiRootItemProvider
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
	public OSGiRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE);
			childrenFeatures.add(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE);
			childrenFeatures.add(OsgiPackage.Literals.OS_GI_ROOT__COMPONENT_BUNDLE);
			childrenFeatures.add(OsgiPackage.Literals.OS_GI_ROOT__UNIT_OSGI_LIBRARY);
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
	 * This returns OSGiRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OSGiRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_OSGiRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(OSGiRoot.class)) {
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
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
				(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE,
				 OsgiFactory.eINSTANCE.createExportedPackage()));

		newChildDescriptors.add
			(createChildParameter
				(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE,
				 OsgiFactory.eINSTANCE.createBundleCapability()));

		newChildDescriptors.add
			(createChildParameter
				(OsgiPackage.Literals.OS_GI_ROOT__COMPONENT_BUNDLE,
				 OsgiFactory.eINSTANCE.createBundleComponent()));

		newChildDescriptors.add
			(createChildParameter
				(OsgiPackage.Literals.OS_GI_ROOT__UNIT_OSGI_LIBRARY,
				 OsgiFactory.eINSTANCE.createLibrary()));
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
