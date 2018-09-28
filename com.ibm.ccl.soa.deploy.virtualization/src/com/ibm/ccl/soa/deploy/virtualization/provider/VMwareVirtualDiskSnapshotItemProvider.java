/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskSnapshotItemProvider.java,v 1.3 2008/04/29 23:03:56 esnible Exp $
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
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VMwareVirtualDiskSnapshotItemProvider
	extends VirtualDiskSnapshotItemProvider
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
	public VMwareVirtualDiskSnapshotItemProvider(AdapterFactory adapterFactory) {
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

			addDiskFileNamePropertyDescriptor(object);
			addDiskNumPropertyDescriptor(object);
			addSnapshotDiskFileNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Disk File Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiskFileNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VMwareVirtualDiskSnapshot_diskFileName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VMwareVirtualDiskSnapshot_diskFileName_feature", "_UI_VMwareVirtualDiskSnapshot_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Disk Num feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDiskNumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VMwareVirtualDiskSnapshot_diskNum_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VMwareVirtualDiskSnapshot_diskNum_feature", "_UI_VMwareVirtualDiskSnapshot_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snapshot Disk File Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSnapshotDiskFileNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VMwareVirtualDiskSnapshot_snapshotDiskFileName_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_VMwareVirtualDiskSnapshot_snapshotDiskFileName_feature", "_UI_VMwareVirtualDiskSnapshot_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 VirtualizationPackage.Literals.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns VMwareVirtualDiskSnapshot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/VMwareVirtualDiskSnapshot")); //$NON-NLS-1$
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((VMwareVirtualDiskSnapshot)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VMwareVirtualDiskSnapshot_type") : //$NON-NLS-1$
			getString("_UI_VMwareVirtualDiskSnapshot_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(VMwareVirtualDiskSnapshot.class)) {
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME:
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM:
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME:
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
