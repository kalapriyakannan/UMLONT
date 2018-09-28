/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationRootItemProvider.java,v 1.7 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.provider;


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

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationFactory;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot;

/**
 * This is the item provider adapter for a {@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualizationRootItemProvider
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
	public VirtualizationRootItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
			childrenFeatures.add(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT);
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
	 * This returns VirtualizationRoot.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VirtualizationRoot")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		return getString("_UI_VirtualizationRoot_type"); //$NON-NLS-1$
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

		switch (notification.getFeatureID(VirtualizationRoot.class)) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
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
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR,
				 VirtualizationFactory.eINSTANCE.createHypervisor()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR,
				 VirtualizationFactory.eINSTANCE.createVMwareHypervisor()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR,
				 VirtualizationFactory.eINSTANCE.createXenHypervisor()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVirtualDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualIDEDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualSCSIDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVirtualDiskSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF,
				 VirtualizationFactory.eINSTANCE.createVirtualEthernetNICDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualEthernetNICDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualEthernetNICDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE,
				 VirtualizationFactory.eINSTANCE.createVirtualImage()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImage()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE,
				 VirtualizationFactory.eINSTANCE.createXenVirtualImage()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION,
				 VirtualizationFactory.eINSTANCE.createVirtualImageCollection()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER,
				 VirtualizationFactory.eINSTANCE.createVirtualImageSnapshotContainer()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImageSnapshotContainer()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF,
				 VirtualizationFactory.eINSTANCE.createVirtualServerDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualServerDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVirtualServerSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX,
				 VirtualizationFactory.eINSTANCE.createVMwareESX()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR,
				 VirtualizationFactory.eINSTANCE.createVMwareHypervisor()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualIDEDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualSCSIDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualEthernetNICDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualIDEDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImage()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImageSnapshotContainer()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualSCSIDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerSnapshot()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR,
				 VirtualizationFactory.eINSTANCE.createXenHypervisor()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualDiskDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualEthernetNICDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE,
				 VirtualizationFactory.eINSTANCE.createXenVirtualImage()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF,
				 VirtualizationFactory.eINSTANCE.createXenVirtualServerDef()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualDiskDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualDiskDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualDiskSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualEthernetNICDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualEthernetNICDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualEthernetNICDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualImageCollectionUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualImageUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImageUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualImageUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVirtualServerSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareESXUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualDiskSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualEthernetNICDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualImageUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT,
				 VirtualizationFactory.eINSTANCE.createVMwareVirtualServerSnapshotUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualDiskDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualEthernetNICDefUnit()));

		newChildDescriptors.add
			(createChildParameter
				(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT,
				 VirtualizationFactory.eINSTANCE.createXenVirtualImageUnit()));
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

		boolean qualify =
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT ||
			childFeature == VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT;

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
