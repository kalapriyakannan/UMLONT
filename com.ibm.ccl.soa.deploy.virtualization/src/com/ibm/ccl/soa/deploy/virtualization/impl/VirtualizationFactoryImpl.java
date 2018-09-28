/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationFactoryImpl.java,v 1.9 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import com.ibm.ccl.soa.deploy.virtualization.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.virtualization.Hypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage;
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
import com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationFactory;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualizationFactoryImpl extends EFactoryImpl implements VirtualizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualizationFactory init() {
		try {
			VirtualizationFactory theVirtualizationFactory = (VirtualizationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/virtualization/1.0.0/"); //$NON-NLS-1$ 
			if (theVirtualizationFactory != null) {
				return theVirtualizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VirtualizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VirtualizationPackage.HYPERVISOR: return createHypervisor();
			case VirtualizationPackage.VIRTUAL_DISK_DEF: return createVirtualDiskDef();
			case VirtualizationPackage.VIRTUAL_DISK_DEF_UNIT: return createVirtualDiskDefUnit();
			case VirtualizationPackage.VIRTUAL_DISK_SNAPSHOT: return createVirtualDiskSnapshot();
			case VirtualizationPackage.VIRTUAL_DISK_SNAPSHOT_UNIT: return createVirtualDiskSnapshotUnit();
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF: return createVirtualEthernetNICDef();
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF_UNIT: return createVirtualEthernetNICDefUnit();
			case VirtualizationPackage.VIRTUAL_IMAGE: return createVirtualImage();
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION: return createVirtualImageCollection();
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION_UNIT: return createVirtualImageCollectionUnit();
			case VirtualizationPackage.VIRTUAL_IMAGE_SNAPSHOT_CONTAINER: return createVirtualImageSnapshotContainer();
			case VirtualizationPackage.VIRTUAL_IMAGE_UNIT: return createVirtualImageUnit();
			case VirtualizationPackage.VIRTUALIZATION_ROOT: return createVirtualizationRoot();
			case VirtualizationPackage.VIRTUAL_SERVER_DEF: return createVirtualServerDef();
			case VirtualizationPackage.VIRTUAL_SERVER_SNAPSHOT: return createVirtualServerSnapshot();
			case VirtualizationPackage.VIRTUAL_SERVER_SNAPSHOT_UNIT: return createVirtualServerSnapshotUnit();
			case VirtualizationPackage.VMWARE_ESX: return createVMwareESX();
			case VirtualizationPackage.VMWARE_ESX_UNIT: return createVMwareESXUnit();
			case VirtualizationPackage.VMWARE_HYPERVISOR: return createVMwareHypervisor();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF: return createVMwareVirtualDiskDef();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF_UNIT: return createVMwareVirtualDiskDefUnit();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT: return createVMwareVirtualDiskSnapshot();
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT: return createVMwareVirtualDiskSnapshotUnit();
			case VirtualizationPackage.VMWARE_VIRTUAL_ETHERNET_NIC_DEF: return createVMwareVirtualEthernetNICDef();
			case VirtualizationPackage.VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT: return createVMwareVirtualEthernetNICDefUnit();
			case VirtualizationPackage.VMWARE_VIRTUAL_IDE_DISK_DEF: return createVMwareVirtualIDEDiskDef();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE: return createVMwareVirtualImage();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER: return createVMwareVirtualImageSnapshotContainer();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_UNIT: return createVMwareVirtualImageUnit();
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF: return createVMwareVirtualSCSIDiskDef();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF: return createVMwareVirtualServerDef();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT: return createVMwareVirtualServerSnapshot();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT: return createVMwareVirtualServerSnapshotUnit();
			case VirtualizationPackage.XEN_HYPERVISOR: return createXenHypervisor();
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF: return createXenVirtualDiskDef();
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF_UNIT: return createXenVirtualDiskDefUnit();
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF: return createXenVirtualEthernetNICDef();
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT: return createXenVirtualEthernetNICDefUnit();
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE: return createXenVirtualImage();
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE_UNIT: return createXenVirtualImageUnit();
			case VirtualizationPackage.XEN_VIRTUAL_SERVER_DEF: return createXenVirtualServerDef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case VirtualizationPackage.DESIRED_SNAPSHOT_STATE_TYPE:
				return createDesiredSnapshotStateTypeFromString(eDataType, initialValue);
			case VirtualizationPackage.VIRTUAL_NETWORK_CONNECTION_TYPE:
				return createVirtualNetworkConnectionTypeFromString(eDataType, initialValue);
			case VirtualizationPackage.VMWARE_SCSI_CONTROLLER_TYPE:
				return createVMwareSCSIControllerTypeFromString(eDataType, initialValue);
			case VirtualizationPackage.DESIRED_SNAPSHOT_STATE_TYPE_OBJECT:
				return createDesiredSnapshotStateTypeObjectFromString(eDataType, initialValue);
			case VirtualizationPackage.VIRTUAL_NETWORK_CONNECTION_TYPE_OBJECT:
				return createVirtualNetworkConnectionTypeObjectFromString(eDataType, initialValue);
			case VirtualizationPackage.VMWARE_SCSI_CONTROLLER_TYPE_OBJECT:
				return createVMwareSCSIControllerTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case VirtualizationPackage.DESIRED_SNAPSHOT_STATE_TYPE:
				return convertDesiredSnapshotStateTypeToString(eDataType, instanceValue);
			case VirtualizationPackage.VIRTUAL_NETWORK_CONNECTION_TYPE:
				return convertVirtualNetworkConnectionTypeToString(eDataType, instanceValue);
			case VirtualizationPackage.VMWARE_SCSI_CONTROLLER_TYPE:
				return convertVMwareSCSIControllerTypeToString(eDataType, instanceValue);
			case VirtualizationPackage.DESIRED_SNAPSHOT_STATE_TYPE_OBJECT:
				return convertDesiredSnapshotStateTypeObjectToString(eDataType, instanceValue);
			case VirtualizationPackage.VIRTUAL_NETWORK_CONNECTION_TYPE_OBJECT:
				return convertVirtualNetworkConnectionTypeObjectToString(eDataType, instanceValue);
			case VirtualizationPackage.VMWARE_SCSI_CONTROLLER_TYPE_OBJECT:
				return convertVMwareSCSIControllerTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hypervisor createHypervisor() {
		HypervisorImpl hypervisor = new HypervisorImpl();
		return hypervisor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskDef createVirtualDiskDef() {
		VirtualDiskDefImpl virtualDiskDef = new VirtualDiskDefImpl();
		return virtualDiskDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskDefUnit createVirtualDiskDefUnit() {
		VirtualDiskDefUnitImpl virtualDiskDefUnit = new VirtualDiskDefUnitImpl();
		return virtualDiskDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskSnapshot createVirtualDiskSnapshot() {
		VirtualDiskSnapshotImpl virtualDiskSnapshot = new VirtualDiskSnapshotImpl();
		return virtualDiskSnapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDiskSnapshotUnit createVirtualDiskSnapshotUnit() {
		VirtualDiskSnapshotUnitImpl virtualDiskSnapshotUnit = new VirtualDiskSnapshotUnitImpl();
		return virtualDiskSnapshotUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualEthernetNICDef createVirtualEthernetNICDef() {
		VirtualEthernetNICDefImpl virtualEthernetNICDef = new VirtualEthernetNICDefImpl();
		return virtualEthernetNICDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualEthernetNICDefUnit createVirtualEthernetNICDefUnit() {
		VirtualEthernetNICDefUnitImpl virtualEthernetNICDefUnit = new VirtualEthernetNICDefUnitImpl();
		return virtualEthernetNICDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImage createVirtualImage() {
		VirtualImageImpl virtualImage = new VirtualImageImpl();
		return virtualImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageCollection createVirtualImageCollection() {
		VirtualImageCollectionImpl virtualImageCollection = new VirtualImageCollectionImpl();
		return virtualImageCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageCollectionUnit createVirtualImageCollectionUnit() {
		VirtualImageCollectionUnitImpl virtualImageCollectionUnit = new VirtualImageCollectionUnitImpl();
		return virtualImageCollectionUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageSnapshotContainer createVirtualImageSnapshotContainer() {
		VirtualImageSnapshotContainerImpl virtualImageSnapshotContainer = new VirtualImageSnapshotContainerImpl();
		return virtualImageSnapshotContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualImageUnit createVirtualImageUnit() {
		VirtualImageUnitImpl virtualImageUnit = new VirtualImageUnitImpl();
		return virtualImageUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationRoot createVirtualizationRoot() {
		VirtualizationRootImpl virtualizationRoot = new VirtualizationRootImpl();
		return virtualizationRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerDef createVirtualServerDef() {
		VirtualServerDefImpl virtualServerDef = new VirtualServerDefImpl();
		return virtualServerDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerSnapshot createVirtualServerSnapshot() {
		VirtualServerSnapshotImpl virtualServerSnapshot = new VirtualServerSnapshotImpl();
		return virtualServerSnapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualServerSnapshotUnit createVirtualServerSnapshotUnit() {
		VirtualServerSnapshotUnitImpl virtualServerSnapshotUnit = new VirtualServerSnapshotUnitImpl();
		return virtualServerSnapshotUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareESX createVMwareESX() {
		VMwareESXImpl vMwareESX = new VMwareESXImpl();
		return vMwareESX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareESXUnit createVMwareESXUnit() {
		VMwareESXUnitImpl vMwareESXUnit = new VMwareESXUnitImpl();
		return vMwareESXUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareHypervisor createVMwareHypervisor() {
		VMwareHypervisorImpl vMwareHypervisor = new VMwareHypervisorImpl();
		return vMwareHypervisor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskDef createVMwareVirtualDiskDef() {
		VMwareVirtualDiskDefImpl vMwareVirtualDiskDef = new VMwareVirtualDiskDefImpl();
		return vMwareVirtualDiskDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskDefUnit createVMwareVirtualDiskDefUnit() {
		VMwareVirtualDiskDefUnitImpl vMwareVirtualDiskDefUnit = new VMwareVirtualDiskDefUnitImpl();
		return vMwareVirtualDiskDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskSnapshot createVMwareVirtualDiskSnapshot() {
		VMwareVirtualDiskSnapshotImpl vMwareVirtualDiskSnapshot = new VMwareVirtualDiskSnapshotImpl();
		return vMwareVirtualDiskSnapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualDiskSnapshotUnit createVMwareVirtualDiskSnapshotUnit() {
		VMwareVirtualDiskSnapshotUnitImpl vMwareVirtualDiskSnapshotUnit = new VMwareVirtualDiskSnapshotUnitImpl();
		return vMwareVirtualDiskSnapshotUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualEthernetNICDef createVMwareVirtualEthernetNICDef() {
		VMwareVirtualEthernetNICDefImpl vMwareVirtualEthernetNICDef = new VMwareVirtualEthernetNICDefImpl();
		return vMwareVirtualEthernetNICDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualEthernetNICDefUnit createVMwareVirtualEthernetNICDefUnit() {
		VMwareVirtualEthernetNICDefUnitImpl vMwareVirtualEthernetNICDefUnit = new VMwareVirtualEthernetNICDefUnitImpl();
		return vMwareVirtualEthernetNICDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualIDEDiskDef createVMwareVirtualIDEDiskDef() {
		VMwareVirtualIDEDiskDefImpl vMwareVirtualIDEDiskDef = new VMwareVirtualIDEDiskDefImpl();
		return vMwareVirtualIDEDiskDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImage createVMwareVirtualImage() {
		VMwareVirtualImageImpl vMwareVirtualImage = new VMwareVirtualImageImpl();
		return vMwareVirtualImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImageSnapshotContainer createVMwareVirtualImageSnapshotContainer() {
		VMwareVirtualImageSnapshotContainerImpl vMwareVirtualImageSnapshotContainer = new VMwareVirtualImageSnapshotContainerImpl();
		return vMwareVirtualImageSnapshotContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualImageUnit createVMwareVirtualImageUnit() {
		VMwareVirtualImageUnitImpl vMwareVirtualImageUnit = new VMwareVirtualImageUnitImpl();
		return vMwareVirtualImageUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualSCSIDiskDef createVMwareVirtualSCSIDiskDef() {
		VMwareVirtualSCSIDiskDefImpl vMwareVirtualSCSIDiskDef = new VMwareVirtualSCSIDiskDefImpl();
		return vMwareVirtualSCSIDiskDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerDef createVMwareVirtualServerDef() {
		VMwareVirtualServerDefImpl vMwareVirtualServerDef = new VMwareVirtualServerDefImpl();
		return vMwareVirtualServerDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerSnapshot createVMwareVirtualServerSnapshot() {
		VMwareVirtualServerSnapshotImpl vMwareVirtualServerSnapshot = new VMwareVirtualServerSnapshotImpl();
		return vMwareVirtualServerSnapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareVirtualServerSnapshotUnit createVMwareVirtualServerSnapshotUnit() {
		VMwareVirtualServerSnapshotUnitImpl vMwareVirtualServerSnapshotUnit = new VMwareVirtualServerSnapshotUnitImpl();
		return vMwareVirtualServerSnapshotUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenHypervisor createXenHypervisor() {
		XenHypervisorImpl xenHypervisor = new XenHypervisorImpl();
		return xenHypervisor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualDiskDef createXenVirtualDiskDef() {
		XenVirtualDiskDefImpl xenVirtualDiskDef = new XenVirtualDiskDefImpl();
		return xenVirtualDiskDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualDiskDefUnit createXenVirtualDiskDefUnit() {
		XenVirtualDiskDefUnitImpl xenVirtualDiskDefUnit = new XenVirtualDiskDefUnitImpl();
		return xenVirtualDiskDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualEthernetNICDef createXenVirtualEthernetNICDef() {
		XenVirtualEthernetNICDefImpl xenVirtualEthernetNICDef = new XenVirtualEthernetNICDefImpl();
		return xenVirtualEthernetNICDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualEthernetNICDefUnit createXenVirtualEthernetNICDefUnit() {
		XenVirtualEthernetNICDefUnitImpl xenVirtualEthernetNICDefUnit = new XenVirtualEthernetNICDefUnitImpl();
		return xenVirtualEthernetNICDefUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualImage createXenVirtualImage() {
		XenVirtualImageImpl xenVirtualImage = new XenVirtualImageImpl();
		return xenVirtualImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualImageUnit createXenVirtualImageUnit() {
		XenVirtualImageUnitImpl xenVirtualImageUnit = new XenVirtualImageUnitImpl();
		return xenVirtualImageUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XenVirtualServerDef createXenVirtualServerDef() {
		XenVirtualServerDefImpl xenVirtualServerDef = new XenVirtualServerDefImpl();
		return xenVirtualServerDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredSnapshotStateType createDesiredSnapshotStateTypeFromString(EDataType eDataType, String initialValue) {
		DesiredSnapshotStateType result = DesiredSnapshotStateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDesiredSnapshotStateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualNetworkConnectionType createVirtualNetworkConnectionTypeFromString(EDataType eDataType, String initialValue) {
		VirtualNetworkConnectionType result = VirtualNetworkConnectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVirtualNetworkConnectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareSCSIControllerType createVMwareSCSIControllerTypeFromString(EDataType eDataType, String initialValue) {
		VMwareSCSIControllerType result = VMwareSCSIControllerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVMwareSCSIControllerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredSnapshotStateType createDesiredSnapshotStateTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDesiredSnapshotStateTypeFromString(VirtualizationPackage.Literals.DESIRED_SNAPSHOT_STATE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDesiredSnapshotStateTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDesiredSnapshotStateTypeToString(VirtualizationPackage.Literals.DESIRED_SNAPSHOT_STATE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualNetworkConnectionType createVirtualNetworkConnectionTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createVirtualNetworkConnectionTypeFromString(VirtualizationPackage.Literals.VIRTUAL_NETWORK_CONNECTION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVirtualNetworkConnectionTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVirtualNetworkConnectionTypeToString(VirtualizationPackage.Literals.VIRTUAL_NETWORK_CONNECTION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VMwareSCSIControllerType createVMwareSCSIControllerTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createVMwareSCSIControllerTypeFromString(VirtualizationPackage.Literals.VMWARE_SCSI_CONTROLLER_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVMwareSCSIControllerTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVMwareSCSIControllerTypeToString(VirtualizationPackage.Literals.VMWARE_SCSI_CONTROLLER_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationPackage getVirtualizationPackage() {
		return (VirtualizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static VirtualizationPackage getPackage() {
		return VirtualizationPackage.eINSTANCE;
	}

} //VirtualizationFactoryImpl
