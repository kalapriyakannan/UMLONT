/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationFactory.java,v 1.7 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage
 * @generated
 */
public interface VirtualizationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VirtualizationFactory eINSTANCE = com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hypervisor</em>'.
	 * @generated
	 */
	Hypervisor createHypervisor();

	/**
	 * Returns a new object of class '<em>Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Disk Def</em>'.
	 * @generated
	 */
	VirtualDiskDef createVirtualDiskDef();

	/**
	 * Returns a new object of class '<em>Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Disk Def Unit</em>'.
	 * @generated
	 */
	VirtualDiskDefUnit createVirtualDiskDefUnit();

	/**
	 * Returns a new object of class '<em>Virtual Disk Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Disk Snapshot</em>'.
	 * @generated
	 */
	VirtualDiskSnapshot createVirtualDiskSnapshot();

	/**
	 * Returns a new object of class '<em>Virtual Disk Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Disk Snapshot Unit</em>'.
	 * @generated
	 */
	VirtualDiskSnapshotUnit createVirtualDiskSnapshotUnit();

	/**
	 * Returns a new object of class '<em>Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Ethernet NIC Def</em>'.
	 * @generated
	 */
	VirtualEthernetNICDef createVirtualEthernetNICDef();

	/**
	 * Returns a new object of class '<em>Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Ethernet NIC Def Unit</em>'.
	 * @generated
	 */
	VirtualEthernetNICDefUnit createVirtualEthernetNICDefUnit();

	/**
	 * Returns a new object of class '<em>Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Image</em>'.
	 * @generated
	 */
	VirtualImage createVirtualImage();

	/**
	 * Returns a new object of class '<em>Virtual Image Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Image Collection</em>'.
	 * @generated
	 */
	VirtualImageCollection createVirtualImageCollection();

	/**
	 * Returns a new object of class '<em>Virtual Image Collection Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Image Collection Unit</em>'.
	 * @generated
	 */
	VirtualImageCollectionUnit createVirtualImageCollectionUnit();

	/**
	 * Returns a new object of class '<em>Virtual Image Snapshot Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Image Snapshot Container</em>'.
	 * @generated
	 */
	VirtualImageSnapshotContainer createVirtualImageSnapshotContainer();

	/**
	 * Returns a new object of class '<em>Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Image Unit</em>'.
	 * @generated
	 */
	VirtualImageUnit createVirtualImageUnit();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	VirtualizationRoot createVirtualizationRoot();

	/**
	 * Returns a new object of class '<em>Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Server Def</em>'.
	 * @generated
	 */
	VirtualServerDef createVirtualServerDef();

	/**
	 * Returns a new object of class '<em>Virtual Server Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Server Snapshot</em>'.
	 * @generated
	 */
	VirtualServerSnapshot createVirtualServerSnapshot();

	/**
	 * Returns a new object of class '<em>Virtual Server Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Server Snapshot Unit</em>'.
	 * @generated
	 */
	VirtualServerSnapshotUnit createVirtualServerSnapshotUnit();

	/**
	 * Returns a new object of class '<em>VMware ESX</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware ESX</em>'.
	 * @generated
	 */
	VMwareESX createVMwareESX();

	/**
	 * Returns a new object of class '<em>VMware ESX Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware ESX Unit</em>'.
	 * @generated
	 */
	VMwareESXUnit createVMwareESXUnit();

	/**
	 * Returns a new object of class '<em>VMware Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Hypervisor</em>'.
	 * @generated
	 */
	VMwareHypervisor createVMwareHypervisor();

	/**
	 * Returns a new object of class '<em>VMware Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Disk Def</em>'.
	 * @generated
	 */
	VMwareVirtualDiskDef createVMwareVirtualDiskDef();

	/**
	 * Returns a new object of class '<em>VMware Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Disk Def Unit</em>'.
	 * @generated
	 */
	VMwareVirtualDiskDefUnit createVMwareVirtualDiskDefUnit();

	/**
	 * Returns a new object of class '<em>VMware Virtual Disk Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Disk Snapshot</em>'.
	 * @generated
	 */
	VMwareVirtualDiskSnapshot createVMwareVirtualDiskSnapshot();

	/**
	 * Returns a new object of class '<em>VMware Virtual Disk Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Disk Snapshot Unit</em>'.
	 * @generated
	 */
	VMwareVirtualDiskSnapshotUnit createVMwareVirtualDiskSnapshotUnit();

	/**
	 * Returns a new object of class '<em>VMware Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Ethernet NIC Def</em>'.
	 * @generated
	 */
	VMwareVirtualEthernetNICDef createVMwareVirtualEthernetNICDef();

	/**
	 * Returns a new object of class '<em>VMware Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Ethernet NIC Def Unit</em>'.
	 * @generated
	 */
	VMwareVirtualEthernetNICDefUnit createVMwareVirtualEthernetNICDefUnit();

	/**
	 * Returns a new object of class '<em>VMware Virtual IDE Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual IDE Disk Def</em>'.
	 * @generated
	 */
	VMwareVirtualIDEDiskDef createVMwareVirtualIDEDiskDef();

	/**
	 * Returns a new object of class '<em>VMware Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Image</em>'.
	 * @generated
	 */
	VMwareVirtualImage createVMwareVirtualImage();

	/**
	 * Returns a new object of class '<em>VMware Virtual Image Snapshot Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Image Snapshot Container</em>'.
	 * @generated
	 */
	VMwareVirtualImageSnapshotContainer createVMwareVirtualImageSnapshotContainer();

	/**
	 * Returns a new object of class '<em>VMware Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Image Unit</em>'.
	 * @generated
	 */
	VMwareVirtualImageUnit createVMwareVirtualImageUnit();

	/**
	 * Returns a new object of class '<em>VMware Virtual SCSI Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual SCSI Disk Def</em>'.
	 * @generated
	 */
	VMwareVirtualSCSIDiskDef createVMwareVirtualSCSIDiskDef();

	/**
	 * Returns a new object of class '<em>VMware Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Server Def</em>'.
	 * @generated
	 */
	VMwareVirtualServerDef createVMwareVirtualServerDef();

	/**
	 * Returns a new object of class '<em>VMware Virtual Server Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Server Snapshot</em>'.
	 * @generated
	 */
	VMwareVirtualServerSnapshot createVMwareVirtualServerSnapshot();

	/**
	 * Returns a new object of class '<em>VMware Virtual Server Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VMware Virtual Server Snapshot Unit</em>'.
	 * @generated
	 */
	VMwareVirtualServerSnapshotUnit createVMwareVirtualServerSnapshotUnit();

	/**
	 * Returns a new object of class '<em>Xen Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Hypervisor</em>'.
	 * @generated
	 */
	XenHypervisor createXenHypervisor();

	/**
	 * Returns a new object of class '<em>Xen Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Disk Def</em>'.
	 * @generated
	 */
	XenVirtualDiskDef createXenVirtualDiskDef();

	/**
	 * Returns a new object of class '<em>Xen Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Disk Def Unit</em>'.
	 * @generated
	 */
	XenVirtualDiskDefUnit createXenVirtualDiskDefUnit();

	/**
	 * Returns a new object of class '<em>Xen Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Ethernet NIC Def</em>'.
	 * @generated
	 */
	XenVirtualEthernetNICDef createXenVirtualEthernetNICDef();

	/**
	 * Returns a new object of class '<em>Xen Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Ethernet NIC Def Unit</em>'.
	 * @generated
	 */
	XenVirtualEthernetNICDefUnit createXenVirtualEthernetNICDefUnit();

	/**
	 * Returns a new object of class '<em>Xen Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Image</em>'.
	 * @generated
	 */
	XenVirtualImage createXenVirtualImage();

	/**
	 * Returns a new object of class '<em>Xen Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Image Unit</em>'.
	 * @generated
	 */
	XenVirtualImageUnit createXenVirtualImageUnit();

	/**
	 * Returns a new object of class '<em>Xen Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xen Virtual Server Def</em>'.
	 * @generated
	 */
	XenVirtualServerDef createXenVirtualServerDef();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VirtualizationPackage getVirtualizationPackage();

} //VirtualizationFactory
