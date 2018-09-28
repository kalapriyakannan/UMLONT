/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationRootImpl.java,v 1.7 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.virtualization.Hypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareESX;
import com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot;
import com.ibm.ccl.soa.deploy.virtualization.XenHypervisor;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityHypervisor <em>Capability Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualDiskDef <em>Capability Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualDiskSnapshot <em>Capability Virtual Disk Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualEthernetNICDef <em>Capability Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualImage <em>Capability Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualImageCollection <em>Capability Virtual Image Collection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualImageSnapshotContainer <em>Capability Virtual Image Snapshot Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualServerDef <em>Capability Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVirtualServerSnapshot <em>Capability Virtual Server Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareESX <em>Capability Vmware ESX</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareHypervisor <em>Capability Vmware Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualDiskDef <em>Capability Vmware Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualDiskSnapshot <em>Capability Vmware Virtual Disk Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualEthernetNICDef <em>Capability Vmware Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualIDEDiskDef <em>Capability Vmware Virtual IDE Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualImage <em>Capability Vmware Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualImageSnapshotContainer <em>Capability Vmware Virtual Image Snapshot Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualSCSIDiskDef <em>Capability Vmware Virtual SCSI Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualServerDef <em>Capability Vmware Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityVmwareVirtualServerSnapshot <em>Capability Vmware Virtual Server Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityXenHypervisor <em>Capability Xen Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityXenVirtualDiskDef <em>Capability Xen Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityXenVirtualEthernetNICDef <em>Capability Xen Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityXenVirtualImage <em>Capability Xen Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getCapabilityXenVirtualServerDef <em>Capability Xen Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualDiskDefUnit <em>Unit Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualDiskSnapshotUnit <em>Unit Virtual Disk Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualEthernetNICDefUnit <em>Unit Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualImageCollectionUnit <em>Unit Virtual Image Collection Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualImageUnit <em>Unit Virtual Image Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVirtualServerSnapshotUnit <em>Unit Virtual Server Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareESXUnit <em>Unit Vmware ESX Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareVirtualDiskDefUnit <em>Unit Vmware Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareVirtualDiskSnapshotUnit <em>Unit Vmware Virtual Disk Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareVirtualEthernetNICDefUnit <em>Unit Vmware Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareVirtualImageUnit <em>Unit Vmware Virtual Image Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitVmwareVirtualServerSnapshotUnit <em>Unit Vmware Virtual Server Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitXenVirtualDiskDefUnit <em>Unit Xen Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitXenVirtualEthernetNICDefUnit <em>Unit Xen Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl#getUnitXenVirtualImageUnit <em>Unit Xen Virtual Image Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualizationRootImpl extends EObjectImpl implements VirtualizationRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualizationRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VIRTUALIZATION_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hypervisor getCapabilityHypervisor() {
		return (Hypervisor)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityHypervisor(Hypervisor newCapabilityHypervisor, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR, newCapabilityHypervisor, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityHypervisor(Hypervisor newCapabilityHypervisor) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR, newCapabilityHypervisor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskDef getCapabilityVirtualDiskDef() {
		return (VirtualDiskDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualDiskDef(VirtualDiskDef newCapabilityVirtualDiskDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF, newCapabilityVirtualDiskDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualDiskDef(VirtualDiskDef newCapabilityVirtualDiskDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF, newCapabilityVirtualDiskDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskSnapshot getCapabilityVirtualDiskSnapshot() {
		return (VirtualDiskSnapshot)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualDiskSnapshot(VirtualDiskSnapshot newCapabilityVirtualDiskSnapshot, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT, newCapabilityVirtualDiskSnapshot, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualDiskSnapshot(VirtualDiskSnapshot newCapabilityVirtualDiskSnapshot) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT, newCapabilityVirtualDiskSnapshot);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualEthernetNICDef getCapabilityVirtualEthernetNICDef() {
		return (VirtualEthernetNICDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualEthernetNICDef(VirtualEthernetNICDef newCapabilityVirtualEthernetNICDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityVirtualEthernetNICDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualEthernetNICDef(VirtualEthernetNICDef newCapabilityVirtualEthernetNICDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityVirtualEthernetNICDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImage getCapabilityVirtualImage() {
		return (VirtualImage)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualImage(VirtualImage newCapabilityVirtualImage, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE, newCapabilityVirtualImage, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualImage(VirtualImage newCapabilityVirtualImage) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE, newCapabilityVirtualImage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageCollection getCapabilityVirtualImageCollection() {
		return (VirtualImageCollection)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualImageCollection(VirtualImageCollection newCapabilityVirtualImageCollection, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION, newCapabilityVirtualImageCollection, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualImageCollection(VirtualImageCollection newCapabilityVirtualImageCollection) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION, newCapabilityVirtualImageCollection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageSnapshotContainer getCapabilityVirtualImageSnapshotContainer() {
		return (VirtualImageSnapshotContainer)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualImageSnapshotContainer(VirtualImageSnapshotContainer newCapabilityVirtualImageSnapshotContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, newCapabilityVirtualImageSnapshotContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualImageSnapshotContainer(VirtualImageSnapshotContainer newCapabilityVirtualImageSnapshotContainer) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, newCapabilityVirtualImageSnapshotContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerDef getCapabilityVirtualServerDef() {
		return (VirtualServerDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualServerDef(VirtualServerDef newCapabilityVirtualServerDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF, newCapabilityVirtualServerDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualServerDef(VirtualServerDef newCapabilityVirtualServerDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF, newCapabilityVirtualServerDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerSnapshot getCapabilityVirtualServerSnapshot() {
		return (VirtualServerSnapshot)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVirtualServerSnapshot(VirtualServerSnapshot newCapabilityVirtualServerSnapshot, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT, newCapabilityVirtualServerSnapshot, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVirtualServerSnapshot(VirtualServerSnapshot newCapabilityVirtualServerSnapshot) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT, newCapabilityVirtualServerSnapshot);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareESX getCapabilityVmwareESX() {
		return (VMwareESX)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareESX(VMwareESX newCapabilityVmwareESX, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX, newCapabilityVmwareESX, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareESX(VMwareESX newCapabilityVmwareESX) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX, newCapabilityVmwareESX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareHypervisor getCapabilityVmwareHypervisor() {
		return (VMwareHypervisor)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareHypervisor(VMwareHypervisor newCapabilityVmwareHypervisor, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR, newCapabilityVmwareHypervisor, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareHypervisor(VMwareHypervisor newCapabilityVmwareHypervisor) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR, newCapabilityVmwareHypervisor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskDef getCapabilityVmwareVirtualDiskDef() {
		return (VMwareVirtualDiskDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualDiskDef(VMwareVirtualDiskDef newCapabilityVmwareVirtualDiskDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF, newCapabilityVmwareVirtualDiskDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualDiskDef(VMwareVirtualDiskDef newCapabilityVmwareVirtualDiskDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF, newCapabilityVmwareVirtualDiskDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskSnapshot getCapabilityVmwareVirtualDiskSnapshot() {
		return (VMwareVirtualDiskSnapshot)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot newCapabilityVmwareVirtualDiskSnapshot, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT, newCapabilityVmwareVirtualDiskSnapshot, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot newCapabilityVmwareVirtualDiskSnapshot) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT, newCapabilityVmwareVirtualDiskSnapshot);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualEthernetNICDef getCapabilityVmwareVirtualEthernetNICDef() {
		return (VMwareVirtualEthernetNICDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef newCapabilityVmwareVirtualEthernetNICDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityVmwareVirtualEthernetNICDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef newCapabilityVmwareVirtualEthernetNICDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityVmwareVirtualEthernetNICDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualIDEDiskDef getCapabilityVmwareVirtualIDEDiskDef() {
		return (VMwareVirtualIDEDiskDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef newCapabilityVmwareVirtualIDEDiskDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF, newCapabilityVmwareVirtualIDEDiskDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef newCapabilityVmwareVirtualIDEDiskDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF, newCapabilityVmwareVirtualIDEDiskDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImage getCapabilityVmwareVirtualImage() {
		return (VMwareVirtualImage)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualImage(VMwareVirtualImage newCapabilityVmwareVirtualImage, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE, newCapabilityVmwareVirtualImage, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualImage(VMwareVirtualImage newCapabilityVmwareVirtualImage) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE, newCapabilityVmwareVirtualImage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImageSnapshotContainer getCapabilityVmwareVirtualImageSnapshotContainer() {
		return (VMwareVirtualImageSnapshotContainer)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer newCapabilityVmwareVirtualImageSnapshotContainer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, newCapabilityVmwareVirtualImageSnapshotContainer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer newCapabilityVmwareVirtualImageSnapshotContainer) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER, newCapabilityVmwareVirtualImageSnapshotContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualSCSIDiskDef getCapabilityVmwareVirtualSCSIDiskDef() {
		return (VMwareVirtualSCSIDiskDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef newCapabilityVmwareVirtualSCSIDiskDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF, newCapabilityVmwareVirtualSCSIDiskDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef newCapabilityVmwareVirtualSCSIDiskDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF, newCapabilityVmwareVirtualSCSIDiskDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerDef getCapabilityVmwareVirtualServerDef() {
		return (VMwareVirtualServerDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualServerDef(VMwareVirtualServerDef newCapabilityVmwareVirtualServerDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF, newCapabilityVmwareVirtualServerDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualServerDef(VMwareVirtualServerDef newCapabilityVmwareVirtualServerDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF, newCapabilityVmwareVirtualServerDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerSnapshot getCapabilityVmwareVirtualServerSnapshot() {
		return (VMwareVirtualServerSnapshot)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVmwareVirtualServerSnapshot(VMwareVirtualServerSnapshot newCapabilityVmwareVirtualServerSnapshot, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT, newCapabilityVmwareVirtualServerSnapshot, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVmwareVirtualServerSnapshot(VMwareVirtualServerSnapshot newCapabilityVmwareVirtualServerSnapshot) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT, newCapabilityVmwareVirtualServerSnapshot);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenHypervisor getCapabilityXenHypervisor() {
		return (XenHypervisor)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityXenHypervisor(XenHypervisor newCapabilityXenHypervisor, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR, newCapabilityXenHypervisor, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityXenHypervisor(XenHypervisor newCapabilityXenHypervisor) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR, newCapabilityXenHypervisor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualDiskDef getCapabilityXenVirtualDiskDef() {
		return (XenVirtualDiskDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityXenVirtualDiskDef(XenVirtualDiskDef newCapabilityXenVirtualDiskDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF, newCapabilityXenVirtualDiskDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityXenVirtualDiskDef(XenVirtualDiskDef newCapabilityXenVirtualDiskDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF, newCapabilityXenVirtualDiskDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualEthernetNICDef getCapabilityXenVirtualEthernetNICDef() {
		return (XenVirtualEthernetNICDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityXenVirtualEthernetNICDef(XenVirtualEthernetNICDef newCapabilityXenVirtualEthernetNICDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityXenVirtualEthernetNICDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityXenVirtualEthernetNICDef(XenVirtualEthernetNICDef newCapabilityXenVirtualEthernetNICDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF, newCapabilityXenVirtualEthernetNICDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualImage getCapabilityXenVirtualImage() {
		return (XenVirtualImage)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityXenVirtualImage(XenVirtualImage newCapabilityXenVirtualImage, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE, newCapabilityXenVirtualImage, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityXenVirtualImage(XenVirtualImage newCapabilityXenVirtualImage) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE, newCapabilityXenVirtualImage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualServerDef getCapabilityXenVirtualServerDef() {
		return (XenVirtualServerDef)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityXenVirtualServerDef(XenVirtualServerDef newCapabilityXenVirtualServerDef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF, newCapabilityXenVirtualServerDef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityXenVirtualServerDef(XenVirtualServerDef newCapabilityXenVirtualServerDef) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF, newCapabilityXenVirtualServerDef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskDefUnit getUnitVirtualDiskDefUnit() {
		return (VirtualDiskDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualDiskDefUnit(VirtualDiskDefUnit newUnitVirtualDiskDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT, newUnitVirtualDiskDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualDiskDefUnit(VirtualDiskDefUnit newUnitVirtualDiskDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT, newUnitVirtualDiskDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskSnapshotUnit getUnitVirtualDiskSnapshotUnit() {
		return (VirtualDiskSnapshotUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit newUnitVirtualDiskSnapshotUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT, newUnitVirtualDiskSnapshotUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit newUnitVirtualDiskSnapshotUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT, newUnitVirtualDiskSnapshotUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualEthernetNICDefUnit getUnitVirtualEthernetNICDefUnit() {
		return (VirtualEthernetNICDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit newUnitVirtualEthernetNICDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitVirtualEthernetNICDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit newUnitVirtualEthernetNICDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitVirtualEthernetNICDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageCollectionUnit getUnitVirtualImageCollectionUnit() {
		return (VirtualImageCollectionUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualImageCollectionUnit(VirtualImageCollectionUnit newUnitVirtualImageCollectionUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT, newUnitVirtualImageCollectionUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualImageCollectionUnit(VirtualImageCollectionUnit newUnitVirtualImageCollectionUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT, newUnitVirtualImageCollectionUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageUnit getUnitVirtualImageUnit() {
		return (VirtualImageUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualImageUnit(VirtualImageUnit newUnitVirtualImageUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT, newUnitVirtualImageUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualImageUnit(VirtualImageUnit newUnitVirtualImageUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT, newUnitVirtualImageUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerSnapshotUnit getUnitVirtualServerSnapshotUnit() {
		return (VirtualServerSnapshotUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVirtualServerSnapshotUnit(VirtualServerSnapshotUnit newUnitVirtualServerSnapshotUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT, newUnitVirtualServerSnapshotUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVirtualServerSnapshotUnit(VirtualServerSnapshotUnit newUnitVirtualServerSnapshotUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT, newUnitVirtualServerSnapshotUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareESXUnit getUnitVmwareESXUnit() {
		return (VMwareESXUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareESXUnit(VMwareESXUnit newUnitVmwareESXUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT, newUnitVmwareESXUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareESXUnit(VMwareESXUnit newUnitVmwareESXUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT, newUnitVmwareESXUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskDefUnit getUnitVmwareVirtualDiskDefUnit() {
		return (VMwareVirtualDiskDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit newUnitVmwareVirtualDiskDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT, newUnitVmwareVirtualDiskDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit newUnitVmwareVirtualDiskDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT, newUnitVmwareVirtualDiskDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskSnapshotUnit getUnitVmwareVirtualDiskSnapshotUnit() {
		return (VMwareVirtualDiskSnapshotUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit newUnitVmwareVirtualDiskSnapshotUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT, newUnitVmwareVirtualDiskSnapshotUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit newUnitVmwareVirtualDiskSnapshotUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT, newUnitVmwareVirtualDiskSnapshotUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualEthernetNICDefUnit getUnitVmwareVirtualEthernetNICDefUnit() {
		return (VMwareVirtualEthernetNICDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit newUnitVmwareVirtualEthernetNICDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitVmwareVirtualEthernetNICDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit newUnitVmwareVirtualEthernetNICDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitVmwareVirtualEthernetNICDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImageUnit getUnitVmwareVirtualImageUnit() {
		return (VMwareVirtualImageUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareVirtualImageUnit(VMwareVirtualImageUnit newUnitVmwareVirtualImageUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT, newUnitVmwareVirtualImageUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareVirtualImageUnit(VMwareVirtualImageUnit newUnitVmwareVirtualImageUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT, newUnitVmwareVirtualImageUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerSnapshotUnit getUnitVmwareVirtualServerSnapshotUnit() {
		return (VMwareVirtualServerSnapshotUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitVmwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit newUnitVmwareVirtualServerSnapshotUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT, newUnitVmwareVirtualServerSnapshotUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitVmwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit newUnitVmwareVirtualServerSnapshotUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT, newUnitVmwareVirtualServerSnapshotUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualDiskDefUnit getUnitXenVirtualDiskDefUnit() {
		return (XenVirtualDiskDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitXenVirtualDiskDefUnit(XenVirtualDiskDefUnit newUnitXenVirtualDiskDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT, newUnitXenVirtualDiskDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitXenVirtualDiskDefUnit(XenVirtualDiskDefUnit newUnitXenVirtualDiskDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT, newUnitXenVirtualDiskDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualEthernetNICDefUnit getUnitXenVirtualEthernetNICDefUnit() {
		return (XenVirtualEthernetNICDefUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit newUnitXenVirtualEthernetNICDefUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitXenVirtualEthernetNICDefUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit newUnitXenVirtualEthernetNICDefUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT, newUnitXenVirtualEthernetNICDefUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualImageUnit getUnitXenVirtualImageUnit() {
		return (XenVirtualImageUnit)getMixed().get(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitXenVirtualImageUnit(XenVirtualImageUnit newUnitXenVirtualImageUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT, newUnitXenVirtualImageUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitXenVirtualImageUnit(XenVirtualImageUnit newUnitXenVirtualImageUnit) {
		((FeatureMap.Internal)getMixed()).set(VirtualizationPackage.Literals.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT, newUnitXenVirtualImageUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
				return basicSetCapabilityHypervisor(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
				return basicSetCapabilityVirtualDiskDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
				return basicSetCapabilityVirtualDiskSnapshot(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
				return basicSetCapabilityVirtualEthernetNICDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
				return basicSetCapabilityVirtualImage(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
				return basicSetCapabilityVirtualImageCollection(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return basicSetCapabilityVirtualImageSnapshotContainer(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
				return basicSetCapabilityVirtualServerDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
				return basicSetCapabilityVirtualServerSnapshot(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
				return basicSetCapabilityVmwareESX(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
				return basicSetCapabilityVmwareHypervisor(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
				return basicSetCapabilityVmwareVirtualDiskDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
				return basicSetCapabilityVmwareVirtualDiskSnapshot(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
				return basicSetCapabilityVmwareVirtualEthernetNICDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
				return basicSetCapabilityVmwareVirtualIDEDiskDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
				return basicSetCapabilityVmwareVirtualImage(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return basicSetCapabilityVmwareVirtualImageSnapshotContainer(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
				return basicSetCapabilityVmwareVirtualSCSIDiskDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
				return basicSetCapabilityVmwareVirtualServerDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
				return basicSetCapabilityVmwareVirtualServerSnapshot(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
				return basicSetCapabilityXenHypervisor(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
				return basicSetCapabilityXenVirtualDiskDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
				return basicSetCapabilityXenVirtualEthernetNICDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
				return basicSetCapabilityXenVirtualImage(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
				return basicSetCapabilityXenVirtualServerDef(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
				return basicSetUnitVirtualDiskDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return basicSetUnitVirtualDiskSnapshotUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return basicSetUnitVirtualEthernetNICDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
				return basicSetUnitVirtualImageCollectionUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
				return basicSetUnitVirtualImageUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return basicSetUnitVirtualServerSnapshotUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
				return basicSetUnitVmwareESXUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
				return basicSetUnitVmwareVirtualDiskDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return basicSetUnitVmwareVirtualDiskSnapshotUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return basicSetUnitVmwareVirtualEthernetNICDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
				return basicSetUnitVmwareVirtualImageUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return basicSetUnitVmwareVirtualServerSnapshotUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
				return basicSetUnitXenVirtualDiskDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return basicSetUnitXenVirtualEthernetNICDefUnit(null, msgs);
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
				return basicSetUnitXenVirtualImageUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
				return getCapabilityHypervisor();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
				return getCapabilityVirtualDiskDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
				return getCapabilityVirtualDiskSnapshot();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityVirtualEthernetNICDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
				return getCapabilityVirtualImage();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
				return getCapabilityVirtualImageCollection();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return getCapabilityVirtualImageSnapshotContainer();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
				return getCapabilityVirtualServerDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
				return getCapabilityVirtualServerSnapshot();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
				return getCapabilityVmwareESX();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
				return getCapabilityVmwareHypervisor();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
				return getCapabilityVmwareVirtualDiskDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
				return getCapabilityVmwareVirtualDiskSnapshot();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityVmwareVirtualEthernetNICDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
				return getCapabilityVmwareVirtualIDEDiskDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
				return getCapabilityVmwareVirtualImage();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return getCapabilityVmwareVirtualImageSnapshotContainer();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
				return getCapabilityVmwareVirtualSCSIDiskDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
				return getCapabilityVmwareVirtualServerDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
				return getCapabilityVmwareVirtualServerSnapshot();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
				return getCapabilityXenHypervisor();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
				return getCapabilityXenVirtualDiskDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityXenVirtualEthernetNICDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
				return getCapabilityXenVirtualImage();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
				return getCapabilityXenVirtualServerDef();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
				return getUnitVirtualDiskDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return getUnitVirtualDiskSnapshotUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitVirtualEthernetNICDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
				return getUnitVirtualImageCollectionUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
				return getUnitVirtualImageUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return getUnitVirtualServerSnapshotUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
				return getUnitVmwareESXUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
				return getUnitVmwareVirtualDiskDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return getUnitVmwareVirtualDiskSnapshotUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitVmwareVirtualEthernetNICDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
				return getUnitVmwareVirtualImageUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return getUnitVmwareVirtualServerSnapshotUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
				return getUnitXenVirtualDiskDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitXenVirtualEthernetNICDefUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
				return getUnitXenVirtualImageUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
				setCapabilityHypervisor((Hypervisor)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
				setCapabilityVirtualDiskDef((VirtualDiskDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
				setCapabilityVirtualDiskSnapshot((VirtualDiskSnapshot)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityVirtualEthernetNICDef((VirtualEthernetNICDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
				setCapabilityVirtualImage((VirtualImage)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
				setCapabilityVirtualImageCollection((VirtualImageCollection)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				setCapabilityVirtualImageSnapshotContainer((VirtualImageSnapshotContainer)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
				setCapabilityVirtualServerDef((VirtualServerDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
				setCapabilityVirtualServerSnapshot((VirtualServerSnapshot)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
				setCapabilityVmwareESX((VMwareESX)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
				setCapabilityVmwareHypervisor((VMwareHypervisor)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
				setCapabilityVmwareVirtualDiskDef((VMwareVirtualDiskDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
				setCapabilityVmwareVirtualDiskSnapshot((VMwareVirtualDiskSnapshot)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityVmwareVirtualEthernetNICDef((VMwareVirtualEthernetNICDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
				setCapabilityVmwareVirtualIDEDiskDef((VMwareVirtualIDEDiskDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
				setCapabilityVmwareVirtualImage((VMwareVirtualImage)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				setCapabilityVmwareVirtualImageSnapshotContainer((VMwareVirtualImageSnapshotContainer)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
				setCapabilityVmwareVirtualSCSIDiskDef((VMwareVirtualSCSIDiskDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
				setCapabilityVmwareVirtualServerDef((VMwareVirtualServerDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
				setCapabilityVmwareVirtualServerSnapshot((VMwareVirtualServerSnapshot)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
				setCapabilityXenHypervisor((XenHypervisor)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
				setCapabilityXenVirtualDiskDef((XenVirtualDiskDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityXenVirtualEthernetNICDef((XenVirtualEthernetNICDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
				setCapabilityXenVirtualImage((XenVirtualImage)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
				setCapabilityXenVirtualServerDef((XenVirtualServerDef)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
				setUnitVirtualDiskDefUnit((VirtualDiskDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
				setUnitVirtualDiskSnapshotUnit((VirtualDiskSnapshotUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitVirtualEthernetNICDefUnit((VirtualEthernetNICDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
				setUnitVirtualImageCollectionUnit((VirtualImageCollectionUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
				setUnitVirtualImageUnit((VirtualImageUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				setUnitVirtualServerSnapshotUnit((VirtualServerSnapshotUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
				setUnitVmwareESXUnit((VMwareESXUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
				setUnitVmwareVirtualDiskDefUnit((VMwareVirtualDiskDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
				setUnitVmwareVirtualDiskSnapshotUnit((VMwareVirtualDiskSnapshotUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitVmwareVirtualEthernetNICDefUnit((VMwareVirtualEthernetNICDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
				setUnitVmwareVirtualImageUnit((VMwareVirtualImageUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				setUnitVmwareVirtualServerSnapshotUnit((VMwareVirtualServerSnapshotUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
				setUnitXenVirtualDiskDefUnit((XenVirtualDiskDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitXenVirtualEthernetNICDefUnit((XenVirtualEthernetNICDefUnit)newValue);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
				setUnitXenVirtualImageUnit((XenVirtualImageUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED:
				getMixed().clear();
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
				setCapabilityHypervisor((Hypervisor)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
				setCapabilityVirtualDiskDef((VirtualDiskDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
				setCapabilityVirtualDiskSnapshot((VirtualDiskSnapshot)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityVirtualEthernetNICDef((VirtualEthernetNICDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
				setCapabilityVirtualImage((VirtualImage)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
				setCapabilityVirtualImageCollection((VirtualImageCollection)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				setCapabilityVirtualImageSnapshotContainer((VirtualImageSnapshotContainer)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
				setCapabilityVirtualServerDef((VirtualServerDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
				setCapabilityVirtualServerSnapshot((VirtualServerSnapshot)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
				setCapabilityVmwareESX((VMwareESX)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
				setCapabilityVmwareHypervisor((VMwareHypervisor)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
				setCapabilityVmwareVirtualDiskDef((VMwareVirtualDiskDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
				setCapabilityVmwareVirtualDiskSnapshot((VMwareVirtualDiskSnapshot)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityVmwareVirtualEthernetNICDef((VMwareVirtualEthernetNICDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
				setCapabilityVmwareVirtualIDEDiskDef((VMwareVirtualIDEDiskDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
				setCapabilityVmwareVirtualImage((VMwareVirtualImage)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				setCapabilityVmwareVirtualImageSnapshotContainer((VMwareVirtualImageSnapshotContainer)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
				setCapabilityVmwareVirtualSCSIDiskDef((VMwareVirtualSCSIDiskDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
				setCapabilityVmwareVirtualServerDef((VMwareVirtualServerDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
				setCapabilityVmwareVirtualServerSnapshot((VMwareVirtualServerSnapshot)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
				setCapabilityXenHypervisor((XenHypervisor)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
				setCapabilityXenVirtualDiskDef((XenVirtualDiskDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
				setCapabilityXenVirtualEthernetNICDef((XenVirtualEthernetNICDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
				setCapabilityXenVirtualImage((XenVirtualImage)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
				setCapabilityXenVirtualServerDef((XenVirtualServerDef)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
				setUnitVirtualDiskDefUnit((VirtualDiskDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
				setUnitVirtualDiskSnapshotUnit((VirtualDiskSnapshotUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitVirtualEthernetNICDefUnit((VirtualEthernetNICDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
				setUnitVirtualImageCollectionUnit((VirtualImageCollectionUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
				setUnitVirtualImageUnit((VirtualImageUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				setUnitVirtualServerSnapshotUnit((VirtualServerSnapshotUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
				setUnitVmwareESXUnit((VMwareESXUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
				setUnitVmwareVirtualDiskDefUnit((VMwareVirtualDiskDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
				setUnitVmwareVirtualDiskSnapshotUnit((VMwareVirtualDiskSnapshotUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitVmwareVirtualEthernetNICDefUnit((VMwareVirtualEthernetNICDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
				setUnitVmwareVirtualImageUnit((VMwareVirtualImageUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				setUnitVmwareVirtualServerSnapshotUnit((VMwareVirtualServerSnapshotUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
				setUnitXenVirtualDiskDefUnit((XenVirtualDiskDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				setUnitXenVirtualEthernetNICDefUnit((XenVirtualEthernetNICDefUnit)null);
				return;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
				setUnitXenVirtualImageUnit((XenVirtualImageUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUALIZATION_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR:
				return getCapabilityHypervisor() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF:
				return getCapabilityVirtualDiskDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT:
				return getCapabilityVirtualDiskSnapshot() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityVirtualEthernetNICDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE:
				return getCapabilityVirtualImage() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION:
				return getCapabilityVirtualImageCollection() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return getCapabilityVirtualImageSnapshotContainer() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF:
				return getCapabilityVirtualServerDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT:
				return getCapabilityVirtualServerSnapshot() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX:
				return getCapabilityVmwareESX() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR:
				return getCapabilityVmwareHypervisor() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF:
				return getCapabilityVmwareVirtualDiskDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT:
				return getCapabilityVmwareVirtualDiskSnapshot() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityVmwareVirtualEthernetNICDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF:
				return getCapabilityVmwareVirtualIDEDiskDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE:
				return getCapabilityVmwareVirtualImage() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER:
				return getCapabilityVmwareVirtualImageSnapshotContainer() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF:
				return getCapabilityVmwareVirtualSCSIDiskDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF:
				return getCapabilityVmwareVirtualServerDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT:
				return getCapabilityVmwareVirtualServerSnapshot() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR:
				return getCapabilityXenHypervisor() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF:
				return getCapabilityXenVirtualDiskDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF:
				return getCapabilityXenVirtualEthernetNICDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE:
				return getCapabilityXenVirtualImage() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF:
				return getCapabilityXenVirtualServerDef() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT:
				return getUnitVirtualDiskDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return getUnitVirtualDiskSnapshotUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitVirtualEthernetNICDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT:
				return getUnitVirtualImageCollectionUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT:
				return getUnitVirtualImageUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return getUnitVirtualServerSnapshotUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT:
				return getUnitVmwareESXUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT:
				return getUnitVmwareVirtualDiskDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT:
				return getUnitVmwareVirtualDiskSnapshotUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitVmwareVirtualEthernetNICDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT:
				return getUnitVmwareVirtualImageUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT:
				return getUnitVmwareVirtualServerSnapshotUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT:
				return getUnitXenVirtualDiskDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT:
				return getUnitXenVirtualEthernetNICDefUnit() != null;
			case VirtualizationPackage.VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT:
				return getUnitXenVirtualImageUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //VirtualizationRootImpl
