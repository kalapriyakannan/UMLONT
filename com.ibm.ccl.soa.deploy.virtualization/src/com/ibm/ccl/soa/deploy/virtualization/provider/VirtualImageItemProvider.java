/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageItemProvider.java,v 1.6 2008/04/29 23:03:56 esnible Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.provider;


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
import com.ibm.ccl.soa.deploy.virtualization.VirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualImageItemProvider
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
	public VirtualImageItemProvider(AdapterFactory adapterFactory) {
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

			addCreatedWithVMToolPropertyDescriptor(object);
			addDateCreatedPropertyDescriptor(object);
			addDateLastModifiedPropertyDescriptor(object);
			addNotesPropertyDescriptor(object);
			addOwnerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Created With VM Tool feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreatedWithVMToolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualImage_createdWithVMTool_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VirtualImage_createdWithVMTool_feature", "_UI_VirtualImage_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date Created feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateCreatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualImage_dateCreated_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VirtualImage_dateCreated_feature", "_UI_VirtualImage_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VIRTUAL_IMAGE__DATE_CREATED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date Last Modified feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDateLastModifiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualImage_dateLastModified_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VirtualImage_dateLastModified_feature", "_UI_VirtualImage_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VIRTUAL_IMAGE__DATE_LAST_MODIFIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Notes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualImage_notes_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VirtualImage_notes_feature", "_UI_VirtualImage_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VIRTUAL_IMAGE__NOTES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owner feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualImage_owner_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VirtualImage_owner_feature", "_UI_VirtualImage_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VIRTUAL_IMAGE__OWNER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns VirtualImage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/VirtualImage")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((VirtualImage)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VirtualImage_type") : //$NON-NLS-1$
			getString("_UI_VirtualImage_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(VirtualImage.class)) {
			case VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL:
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED:
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED:
			case VirtualizationPackage.VIRTUAL_IMAGE__NOTES:
			case VirtualizationPackage.VIRTUAL_IMAGE__OWNER:
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
		return VirtualizationEditPlugin.INSTANCE;
	}

}
