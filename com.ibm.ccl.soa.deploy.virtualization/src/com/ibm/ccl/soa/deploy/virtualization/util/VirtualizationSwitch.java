/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationSwitch.java,v 1.8 2008/05/08 14:38:30 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.virtualization.*;
import com.ibm.ccl.soa.deploy.virtualization.Hypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage
 * @generated
 */
public class VirtualizationSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VirtualizationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationSwitch() {
		if (modelPackage == null) {
			modelPackage = VirtualizationPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case VirtualizationPackage.HYPERVISOR: {
				Hypervisor hypervisor = (Hypervisor)theEObject;
				Object result = caseHypervisor(hypervisor);
				if (result == null) result = caseCapability(hypervisor);
				if (result == null) result = caseDeployModelObject(hypervisor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_DISK_DEF: {
				VirtualDiskDef virtualDiskDef = (VirtualDiskDef)theEObject;
				Object result = caseVirtualDiskDef(virtualDiskDef);
				if (result == null) result = caseCapability(virtualDiskDef);
				if (result == null) result = caseDeployModelObject(virtualDiskDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_DISK_DEF_UNIT: {
				VirtualDiskDefUnit virtualDiskDefUnit = (VirtualDiskDefUnit)theEObject;
				Object result = caseVirtualDiskDefUnit(virtualDiskDefUnit);
				if (result == null) result = caseUnit(virtualDiskDefUnit);
				if (result == null) result = caseDeployModelObject(virtualDiskDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_DISK_SNAPSHOT: {
				VirtualDiskSnapshot virtualDiskSnapshot = (VirtualDiskSnapshot)theEObject;
				Object result = caseVirtualDiskSnapshot(virtualDiskSnapshot);
				if (result == null) result = caseCapability(virtualDiskSnapshot);
				if (result == null) result = caseDeployModelObject(virtualDiskSnapshot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_DISK_SNAPSHOT_UNIT: {
				VirtualDiskSnapshotUnit virtualDiskSnapshotUnit = (VirtualDiskSnapshotUnit)theEObject;
				Object result = caseVirtualDiskSnapshotUnit(virtualDiskSnapshotUnit);
				if (result == null) result = caseUnit(virtualDiskSnapshotUnit);
				if (result == null) result = caseDeployModelObject(virtualDiskSnapshotUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF: {
				VirtualEthernetNICDef virtualEthernetNICDef = (VirtualEthernetNICDef)theEObject;
				Object result = caseVirtualEthernetNICDef(virtualEthernetNICDef);
				if (result == null) result = caseCapability(virtualEthernetNICDef);
				if (result == null) result = caseDeployModelObject(virtualEthernetNICDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_ETHERNET_NIC_DEF_UNIT: {
				VirtualEthernetNICDefUnit virtualEthernetNICDefUnit = (VirtualEthernetNICDefUnit)theEObject;
				Object result = caseVirtualEthernetNICDefUnit(virtualEthernetNICDefUnit);
				if (result == null) result = caseUnit(virtualEthernetNICDefUnit);
				if (result == null) result = caseDeployModelObject(virtualEthernetNICDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_IMAGE: {
				VirtualImage virtualImage = (VirtualImage)theEObject;
				Object result = caseVirtualImage(virtualImage);
				if (result == null) result = caseCapability(virtualImage);
				if (result == null) result = caseDeployModelObject(virtualImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION: {
				VirtualImageCollection virtualImageCollection = (VirtualImageCollection)theEObject;
				Object result = caseVirtualImageCollection(virtualImageCollection);
				if (result == null) result = caseCapability(virtualImageCollection);
				if (result == null) result = caseDeployModelObject(virtualImageCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_IMAGE_COLLECTION_UNIT: {
				VirtualImageCollectionUnit virtualImageCollectionUnit = (VirtualImageCollectionUnit)theEObject;
				Object result = caseVirtualImageCollectionUnit(virtualImageCollectionUnit);
				if (result == null) result = caseUnit(virtualImageCollectionUnit);
				if (result == null) result = caseDeployModelObject(virtualImageCollectionUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_IMAGE_SNAPSHOT_CONTAINER: {
				VirtualImageSnapshotContainer virtualImageSnapshotContainer = (VirtualImageSnapshotContainer)theEObject;
				Object result = caseVirtualImageSnapshotContainer(virtualImageSnapshotContainer);
				if (result == null) result = caseCapability(virtualImageSnapshotContainer);
				if (result == null) result = caseDeployModelObject(virtualImageSnapshotContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_IMAGE_UNIT: {
				VirtualImageUnit virtualImageUnit = (VirtualImageUnit)theEObject;
				Object result = caseVirtualImageUnit(virtualImageUnit);
				if (result == null) result = caseUnit(virtualImageUnit);
				if (result == null) result = caseDeployModelObject(virtualImageUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUALIZATION_ROOT: {
				VirtualizationRoot virtualizationRoot = (VirtualizationRoot)theEObject;
				Object result = caseVirtualizationRoot(virtualizationRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_SERVER_DEF: {
				VirtualServerDef virtualServerDef = (VirtualServerDef)theEObject;
				Object result = caseVirtualServerDef(virtualServerDef);
				if (result == null) result = caseCapability(virtualServerDef);
				if (result == null) result = caseDeployModelObject(virtualServerDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_SERVER_SNAPSHOT: {
				VirtualServerSnapshot virtualServerSnapshot = (VirtualServerSnapshot)theEObject;
				Object result = caseVirtualServerSnapshot(virtualServerSnapshot);
				if (result == null) result = caseCapability(virtualServerSnapshot);
				if (result == null) result = caseDeployModelObject(virtualServerSnapshot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VIRTUAL_SERVER_SNAPSHOT_UNIT: {
				VirtualServerSnapshotUnit virtualServerSnapshotUnit = (VirtualServerSnapshotUnit)theEObject;
				Object result = caseVirtualServerSnapshotUnit(virtualServerSnapshotUnit);
				if (result == null) result = caseUnit(virtualServerSnapshotUnit);
				if (result == null) result = caseDeployModelObject(virtualServerSnapshotUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_ESX: {
				VMwareESX vMwareESX = (VMwareESX)theEObject;
				Object result = caseVMwareESX(vMwareESX);
				if (result == null) result = caseOperatingSystem(vMwareESX);
				if (result == null) result = caseCapability(vMwareESX);
				if (result == null) result = caseDeployModelObject(vMwareESX);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_ESX_UNIT: {
				VMwareESXUnit vMwareESXUnit = (VMwareESXUnit)theEObject;
				Object result = caseVMwareESXUnit(vMwareESXUnit);
				if (result == null) result = caseOperatingSystemUnit(vMwareESXUnit);
				if (result == null) result = caseUnit(vMwareESXUnit);
				if (result == null) result = caseDeployModelObject(vMwareESXUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_HYPERVISOR: {
				VMwareHypervisor vMwareHypervisor = (VMwareHypervisor)theEObject;
				Object result = caseVMwareHypervisor(vMwareHypervisor);
				if (result == null) result = caseHypervisor(vMwareHypervisor);
				if (result == null) result = caseCapability(vMwareHypervisor);
				if (result == null) result = caseDeployModelObject(vMwareHypervisor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF: {
				VMwareVirtualDiskDef vMwareVirtualDiskDef = (VMwareVirtualDiskDef)theEObject;
				Object result = caseVMwareVirtualDiskDef(vMwareVirtualDiskDef);
				if (result == null) result = caseVirtualDiskDef(vMwareVirtualDiskDef);
				if (result == null) result = caseCapability(vMwareVirtualDiskDef);
				if (result == null) result = caseDeployModelObject(vMwareVirtualDiskDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_DEF_UNIT: {
				VMwareVirtualDiskDefUnit vMwareVirtualDiskDefUnit = (VMwareVirtualDiskDefUnit)theEObject;
				Object result = caseVMwareVirtualDiskDefUnit(vMwareVirtualDiskDefUnit);
				if (result == null) result = caseVirtualDiskDefUnit(vMwareVirtualDiskDefUnit);
				if (result == null) result = caseUnit(vMwareVirtualDiskDefUnit);
				if (result == null) result = caseDeployModelObject(vMwareVirtualDiskDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT: {
				VMwareVirtualDiskSnapshot vMwareVirtualDiskSnapshot = (VMwareVirtualDiskSnapshot)theEObject;
				Object result = caseVMwareVirtualDiskSnapshot(vMwareVirtualDiskSnapshot);
				if (result == null) result = caseVirtualDiskSnapshot(vMwareVirtualDiskSnapshot);
				if (result == null) result = caseCapability(vMwareVirtualDiskSnapshot);
				if (result == null) result = caseDeployModelObject(vMwareVirtualDiskSnapshot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT: {
				VMwareVirtualDiskSnapshotUnit vMwareVirtualDiskSnapshotUnit = (VMwareVirtualDiskSnapshotUnit)theEObject;
				Object result = caseVMwareVirtualDiskSnapshotUnit(vMwareVirtualDiskSnapshotUnit);
				if (result == null) result = caseVirtualDiskSnapshotUnit(vMwareVirtualDiskSnapshotUnit);
				if (result == null) result = caseUnit(vMwareVirtualDiskSnapshotUnit);
				if (result == null) result = caseDeployModelObject(vMwareVirtualDiskSnapshotUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_ETHERNET_NIC_DEF: {
				VMwareVirtualEthernetNICDef vMwareVirtualEthernetNICDef = (VMwareVirtualEthernetNICDef)theEObject;
				Object result = caseVMwareVirtualEthernetNICDef(vMwareVirtualEthernetNICDef);
				if (result == null) result = caseVirtualEthernetNICDef(vMwareVirtualEthernetNICDef);
				if (result == null) result = caseCapability(vMwareVirtualEthernetNICDef);
				if (result == null) result = caseDeployModelObject(vMwareVirtualEthernetNICDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT: {
				VMwareVirtualEthernetNICDefUnit vMwareVirtualEthernetNICDefUnit = (VMwareVirtualEthernetNICDefUnit)theEObject;
				Object result = caseVMwareVirtualEthernetNICDefUnit(vMwareVirtualEthernetNICDefUnit);
				if (result == null) result = caseVirtualEthernetNICDefUnit(vMwareVirtualEthernetNICDefUnit);
				if (result == null) result = caseUnit(vMwareVirtualEthernetNICDefUnit);
				if (result == null) result = caseDeployModelObject(vMwareVirtualEthernetNICDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_IDE_DISK_DEF: {
				VMwareVirtualIDEDiskDef vMwareVirtualIDEDiskDef = (VMwareVirtualIDEDiskDef)theEObject;
				Object result = caseVMwareVirtualIDEDiskDef(vMwareVirtualIDEDiskDef);
				if (result == null) result = caseVMwareVirtualDiskDef(vMwareVirtualIDEDiskDef);
				if (result == null) result = caseVirtualDiskDef(vMwareVirtualIDEDiskDef);
				if (result == null) result = caseCapability(vMwareVirtualIDEDiskDef);
				if (result == null) result = caseDeployModelObject(vMwareVirtualIDEDiskDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE: {
				VMwareVirtualImage vMwareVirtualImage = (VMwareVirtualImage)theEObject;
				Object result = caseVMwareVirtualImage(vMwareVirtualImage);
				if (result == null) result = caseVirtualImage(vMwareVirtualImage);
				if (result == null) result = caseCapability(vMwareVirtualImage);
				if (result == null) result = caseDeployModelObject(vMwareVirtualImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER: {
				VMwareVirtualImageSnapshotContainer vMwareVirtualImageSnapshotContainer = (VMwareVirtualImageSnapshotContainer)theEObject;
				Object result = caseVMwareVirtualImageSnapshotContainer(vMwareVirtualImageSnapshotContainer);
				if (result == null) result = caseVirtualImageSnapshotContainer(vMwareVirtualImageSnapshotContainer);
				if (result == null) result = caseCapability(vMwareVirtualImageSnapshotContainer);
				if (result == null) result = caseDeployModelObject(vMwareVirtualImageSnapshotContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE_UNIT: {
				VMwareVirtualImageUnit vMwareVirtualImageUnit = (VMwareVirtualImageUnit)theEObject;
				Object result = caseVMwareVirtualImageUnit(vMwareVirtualImageUnit);
				if (result == null) result = caseVirtualImageUnit(vMwareVirtualImageUnit);
				if (result == null) result = caseUnit(vMwareVirtualImageUnit);
				if (result == null) result = caseDeployModelObject(vMwareVirtualImageUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_SCSI_DISK_DEF: {
				VMwareVirtualSCSIDiskDef vMwareVirtualSCSIDiskDef = (VMwareVirtualSCSIDiskDef)theEObject;
				Object result = caseVMwareVirtualSCSIDiskDef(vMwareVirtualSCSIDiskDef);
				if (result == null) result = caseVMwareVirtualDiskDef(vMwareVirtualSCSIDiskDef);
				if (result == null) result = caseVirtualDiskDef(vMwareVirtualSCSIDiskDef);
				if (result == null) result = caseCapability(vMwareVirtualSCSIDiskDef);
				if (result == null) result = caseDeployModelObject(vMwareVirtualSCSIDiskDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_DEF: {
				VMwareVirtualServerDef vMwareVirtualServerDef = (VMwareVirtualServerDef)theEObject;
				Object result = caseVMwareVirtualServerDef(vMwareVirtualServerDef);
				if (result == null) result = caseVirtualServerDef(vMwareVirtualServerDef);
				if (result == null) result = caseCapability(vMwareVirtualServerDef);
				if (result == null) result = caseDeployModelObject(vMwareVirtualServerDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT: {
				VMwareVirtualServerSnapshot vMwareVirtualServerSnapshot = (VMwareVirtualServerSnapshot)theEObject;
				Object result = caseVMwareVirtualServerSnapshot(vMwareVirtualServerSnapshot);
				if (result == null) result = caseVirtualServerSnapshot(vMwareVirtualServerSnapshot);
				if (result == null) result = caseCapability(vMwareVirtualServerSnapshot);
				if (result == null) result = caseDeployModelObject(vMwareVirtualServerSnapshot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT: {
				VMwareVirtualServerSnapshotUnit vMwareVirtualServerSnapshotUnit = (VMwareVirtualServerSnapshotUnit)theEObject;
				Object result = caseVMwareVirtualServerSnapshotUnit(vMwareVirtualServerSnapshotUnit);
				if (result == null) result = caseVirtualServerSnapshotUnit(vMwareVirtualServerSnapshotUnit);
				if (result == null) result = caseUnit(vMwareVirtualServerSnapshotUnit);
				if (result == null) result = caseDeployModelObject(vMwareVirtualServerSnapshotUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_HYPERVISOR: {
				XenHypervisor xenHypervisor = (XenHypervisor)theEObject;
				Object result = caseXenHypervisor(xenHypervisor);
				if (result == null) result = caseHypervisor(xenHypervisor);
				if (result == null) result = caseCapability(xenHypervisor);
				if (result == null) result = caseDeployModelObject(xenHypervisor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF: {
				XenVirtualDiskDef xenVirtualDiskDef = (XenVirtualDiskDef)theEObject;
				Object result = caseXenVirtualDiskDef(xenVirtualDiskDef);
				if (result == null) result = caseVirtualDiskDef(xenVirtualDiskDef);
				if (result == null) result = caseCapability(xenVirtualDiskDef);
				if (result == null) result = caseDeployModelObject(xenVirtualDiskDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_DISK_DEF_UNIT: {
				XenVirtualDiskDefUnit xenVirtualDiskDefUnit = (XenVirtualDiskDefUnit)theEObject;
				Object result = caseXenVirtualDiskDefUnit(xenVirtualDiskDefUnit);
				if (result == null) result = caseVirtualDiskDefUnit(xenVirtualDiskDefUnit);
				if (result == null) result = caseUnit(xenVirtualDiskDefUnit);
				if (result == null) result = caseDeployModelObject(xenVirtualDiskDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF: {
				XenVirtualEthernetNICDef xenVirtualEthernetNICDef = (XenVirtualEthernetNICDef)theEObject;
				Object result = caseXenVirtualEthernetNICDef(xenVirtualEthernetNICDef);
				if (result == null) result = caseVirtualEthernetNICDef(xenVirtualEthernetNICDef);
				if (result == null) result = caseCapability(xenVirtualEthernetNICDef);
				if (result == null) result = caseDeployModelObject(xenVirtualEthernetNICDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT: {
				XenVirtualEthernetNICDefUnit xenVirtualEthernetNICDefUnit = (XenVirtualEthernetNICDefUnit)theEObject;
				Object result = caseXenVirtualEthernetNICDefUnit(xenVirtualEthernetNICDefUnit);
				if (result == null) result = caseVirtualEthernetNICDefUnit(xenVirtualEthernetNICDefUnit);
				if (result == null) result = caseUnit(xenVirtualEthernetNICDefUnit);
				if (result == null) result = caseDeployModelObject(xenVirtualEthernetNICDefUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE: {
				XenVirtualImage xenVirtualImage = (XenVirtualImage)theEObject;
				Object result = caseXenVirtualImage(xenVirtualImage);
				if (result == null) result = caseVirtualImage(xenVirtualImage);
				if (result == null) result = caseCapability(xenVirtualImage);
				if (result == null) result = caseDeployModelObject(xenVirtualImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE_UNIT: {
				XenVirtualImageUnit xenVirtualImageUnit = (XenVirtualImageUnit)theEObject;
				Object result = caseXenVirtualImageUnit(xenVirtualImageUnit);
				if (result == null) result = caseVirtualImageUnit(xenVirtualImageUnit);
				if (result == null) result = caseUnit(xenVirtualImageUnit);
				if (result == null) result = caseDeployModelObject(xenVirtualImageUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VirtualizationPackage.XEN_VIRTUAL_SERVER_DEF: {
				XenVirtualServerDef xenVirtualServerDef = (XenVirtualServerDef)theEObject;
				Object result = caseXenVirtualServerDef(xenVirtualServerDef);
				if (result == null) result = caseVirtualServerDef(xenVirtualServerDef);
				if (result == null) result = caseCapability(xenVirtualServerDef);
				if (result == null) result = caseDeployModelObject(xenVirtualServerDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hypervisor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHypervisor(Hypervisor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Disk Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualDiskDef(VirtualDiskDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Disk Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualDiskDefUnit(VirtualDiskDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Disk Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Disk Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualDiskSnapshot(VirtualDiskSnapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Disk Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Disk Snapshot Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Ethernet NIC Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualEthernetNICDef(VirtualEthernetNICDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Ethernet NIC Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualImage(VirtualImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Image Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Image Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualImageCollection(VirtualImageCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Image Collection Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Image Collection Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualImageCollectionUnit(VirtualImageCollectionUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Image Snapshot Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Image Snapshot Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualImageSnapshotContainer(VirtualImageSnapshotContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Image Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualImageUnit(VirtualImageUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualizationRoot(VirtualizationRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Server Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualServerDef(VirtualServerDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Server Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Server Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualServerSnapshot(VirtualServerSnapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Server Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Server Snapshot Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVirtualServerSnapshotUnit(VirtualServerSnapshotUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware ESX</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware ESX</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareESX(VMwareESX object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware ESX Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware ESX Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareESXUnit(VMwareESXUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Hypervisor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareHypervisor(VMwareHypervisor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Disk Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualDiskDef(VMwareVirtualDiskDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Disk Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Disk Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Disk Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Disk Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Disk Snapshot Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Ethernet NIC Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Ethernet NIC Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual IDE Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual IDE Disk Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualImage(VMwareVirtualImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Image Snapshot Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Image Snapshot Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Image Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualImageUnit(VMwareVirtualImageUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual SCSI Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual SCSI Disk Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Server Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualServerDef(VMwareVirtualServerDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Server Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Server Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualServerSnapshot(VMwareVirtualServerSnapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VMware Virtual Server Snapshot Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VMware Virtual Server Snapshot Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVMwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Hypervisor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Hypervisor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenHypervisor(XenHypervisor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Disk Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Disk Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualDiskDef(XenVirtualDiskDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Disk Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Disk Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualDiskDefUnit(XenVirtualDiskDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Ethernet NIC Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Ethernet NIC Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualEthernetNICDef(XenVirtualEthernetNICDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Ethernet NIC Def Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Ethernet NIC Def Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualImage(XenVirtualImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Image Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Image Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualImageUnit(XenVirtualImageUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xen Virtual Server Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xen Virtual Server Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXenVirtualServerDef(XenVirtualServerDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operating System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operating System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatingSystem(OperatingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operating System Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operating System Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperatingSystemUnit(OperatingSystemUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //VirtualizationSwitch
