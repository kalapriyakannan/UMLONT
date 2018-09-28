/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationAdapterFactory.java,v 1.9 2008/05/08 14:38:30 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage
 * @generated
 */
public class VirtualizationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VirtualizationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = VirtualizationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualizationSwitch modelSwitch =
		new VirtualizationSwitch() {
			public Object caseHypervisor(Hypervisor object) {
				return createHypervisorAdapter();
			}
			public Object caseVirtualDiskDef(VirtualDiskDef object) {
				return createVirtualDiskDefAdapter();
			}
			public Object caseVirtualDiskDefUnit(VirtualDiskDefUnit object) {
				return createVirtualDiskDefUnitAdapter();
			}
			public Object caseVirtualDiskSnapshot(VirtualDiskSnapshot object) {
				return createVirtualDiskSnapshotAdapter();
			}
			public Object caseVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit object) {
				return createVirtualDiskSnapshotUnitAdapter();
			}
			public Object caseVirtualEthernetNICDef(VirtualEthernetNICDef object) {
				return createVirtualEthernetNICDefAdapter();
			}
			public Object caseVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit object) {
				return createVirtualEthernetNICDefUnitAdapter();
			}
			public Object caseVirtualImage(VirtualImage object) {
				return createVirtualImageAdapter();
			}
			public Object caseVirtualImageCollection(VirtualImageCollection object) {
				return createVirtualImageCollectionAdapter();
			}
			public Object caseVirtualImageCollectionUnit(VirtualImageCollectionUnit object) {
				return createVirtualImageCollectionUnitAdapter();
			}
			public Object caseVirtualImageSnapshotContainer(VirtualImageSnapshotContainer object) {
				return createVirtualImageSnapshotContainerAdapter();
			}
			public Object caseVirtualImageUnit(VirtualImageUnit object) {
				return createVirtualImageUnitAdapter();
			}
			public Object caseVirtualizationRoot(VirtualizationRoot object) {
				return createVirtualizationRootAdapter();
			}
			public Object caseVirtualServerDef(VirtualServerDef object) {
				return createVirtualServerDefAdapter();
			}
			public Object caseVirtualServerSnapshot(VirtualServerSnapshot object) {
				return createVirtualServerSnapshotAdapter();
			}
			public Object caseVirtualServerSnapshotUnit(VirtualServerSnapshotUnit object) {
				return createVirtualServerSnapshotUnitAdapter();
			}
			public Object caseVMwareESX(VMwareESX object) {
				return createVMwareESXAdapter();
			}
			public Object caseVMwareESXUnit(VMwareESXUnit object) {
				return createVMwareESXUnitAdapter();
			}
			public Object caseVMwareHypervisor(VMwareHypervisor object) {
				return createVMwareHypervisorAdapter();
			}
			public Object caseVMwareVirtualDiskDef(VMwareVirtualDiskDef object) {
				return createVMwareVirtualDiskDefAdapter();
			}
			public Object caseVMwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit object) {
				return createVMwareVirtualDiskDefUnitAdapter();
			}
			public Object caseVMwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot object) {
				return createVMwareVirtualDiskSnapshotAdapter();
			}
			public Object caseVMwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit object) {
				return createVMwareVirtualDiskSnapshotUnitAdapter();
			}
			public Object caseVMwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef object) {
				return createVMwareVirtualEthernetNICDefAdapter();
			}
			public Object caseVMwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit object) {
				return createVMwareVirtualEthernetNICDefUnitAdapter();
			}
			public Object caseVMwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef object) {
				return createVMwareVirtualIDEDiskDefAdapter();
			}
			public Object caseVMwareVirtualImage(VMwareVirtualImage object) {
				return createVMwareVirtualImageAdapter();
			}
			public Object caseVMwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer object) {
				return createVMwareVirtualImageSnapshotContainerAdapter();
			}
			public Object caseVMwareVirtualImageUnit(VMwareVirtualImageUnit object) {
				return createVMwareVirtualImageUnitAdapter();
			}
			public Object caseVMwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef object) {
				return createVMwareVirtualSCSIDiskDefAdapter();
			}
			public Object caseVMwareVirtualServerDef(VMwareVirtualServerDef object) {
				return createVMwareVirtualServerDefAdapter();
			}
			public Object caseVMwareVirtualServerSnapshot(VMwareVirtualServerSnapshot object) {
				return createVMwareVirtualServerSnapshotAdapter();
			}
			public Object caseVMwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit object) {
				return createVMwareVirtualServerSnapshotUnitAdapter();
			}
			public Object caseXenHypervisor(XenHypervisor object) {
				return createXenHypervisorAdapter();
			}
			public Object caseXenVirtualDiskDef(XenVirtualDiskDef object) {
				return createXenVirtualDiskDefAdapter();
			}
			public Object caseXenVirtualDiskDefUnit(XenVirtualDiskDefUnit object) {
				return createXenVirtualDiskDefUnitAdapter();
			}
			public Object caseXenVirtualEthernetNICDef(XenVirtualEthernetNICDef object) {
				return createXenVirtualEthernetNICDefAdapter();
			}
			public Object caseXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit object) {
				return createXenVirtualEthernetNICDefUnitAdapter();
			}
			public Object caseXenVirtualImage(XenVirtualImage object) {
				return createXenVirtualImageAdapter();
			}
			public Object caseXenVirtualImageUnit(XenVirtualImageUnit object) {
				return createXenVirtualImageUnitAdapter();
			}
			public Object caseXenVirtualServerDef(XenVirtualServerDef object) {
				return createXenVirtualServerDefAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseOperatingSystem(OperatingSystem object) {
				return createOperatingSystemAdapter();
			}
			public Object caseOperatingSystemUnit(OperatingSystemUnit object) {
				return createOperatingSystemUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.Hypervisor <em>Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.Hypervisor
	 * @generated
	 */
	public Adapter createHypervisorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef <em>Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef
	 * @generated
	 */
	public Adapter createVirtualDiskDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit <em>Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit
	 * @generated
	 */
	public Adapter createVirtualDiskDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot <em>Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot
	 * @generated
	 */
	public Adapter createVirtualDiskSnapshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit <em>Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit
	 * @generated
	 */
	public Adapter createVirtualDiskSnapshotUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef <em>Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef
	 * @generated
	 */
	public Adapter createVirtualEthernetNICDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit <em>Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit
	 * @generated
	 */
	public Adapter createVirtualEthernetNICDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage <em>Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage
	 * @generated
	 */
	public Adapter createVirtualImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection <em>Virtual Image Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection
	 * @generated
	 */
	public Adapter createVirtualImageCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit <em>Virtual Image Collection Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit
	 * @generated
	 */
	public Adapter createVirtualImageCollectionUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer <em>Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer
	 * @generated
	 */
	public Adapter createVirtualImageSnapshotContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit <em>Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit
	 * @generated
	 */
	public Adapter createVirtualImageUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot
	 * @generated
	 */
	public Adapter createVirtualizationRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef <em>Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef
	 * @generated
	 */
	public Adapter createVirtualServerDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot <em>Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot
	 * @generated
	 */
	public Adapter createVirtualServerSnapshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit <em>Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit
	 * @generated
	 */
	public Adapter createVirtualServerSnapshotUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareESX <em>VMware ESX</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareESX
	 * @generated
	 */
	public Adapter createVMwareESXAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit <em>VMware ESX Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit
	 * @generated
	 */
	public Adapter createVMwareESXUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor <em>VMware Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor
	 * @generated
	 */
	public Adapter createVMwareHypervisorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef <em>VMware Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit <em>VMware Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot <em>VMware Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskSnapshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit <em>VMware Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit
	 * @generated
	 */
	public Adapter createVMwareVirtualDiskSnapshotUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef <em>VMware Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef
	 * @generated
	 */
	public Adapter createVMwareVirtualEthernetNICDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit <em>VMware Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit
	 * @generated
	 */
	public Adapter createVMwareVirtualEthernetNICDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef <em>VMware Virtual IDE Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef
	 * @generated
	 */
	public Adapter createVMwareVirtualIDEDiskDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage <em>VMware Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage
	 * @generated
	 */
	public Adapter createVMwareVirtualImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer <em>VMware Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer
	 * @generated
	 */
	public Adapter createVMwareVirtualImageSnapshotContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit <em>VMware Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit
	 * @generated
	 */
	public Adapter createVMwareVirtualImageUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef <em>VMware Virtual SCSI Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef
	 * @generated
	 */
	public Adapter createVMwareVirtualSCSIDiskDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef <em>VMware Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef
	 * @generated
	 */
	public Adapter createVMwareVirtualServerDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot <em>VMware Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot
	 * @generated
	 */
	public Adapter createVMwareVirtualServerSnapshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit <em>VMware Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit
	 * @generated
	 */
	public Adapter createVMwareVirtualServerSnapshotUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor <em>Xen Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenHypervisor
	 * @generated
	 */
	public Adapter createXenHypervisorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef <em>Xen Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef
	 * @generated
	 */
	public Adapter createXenVirtualDiskDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit <em>Xen Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit
	 * @generated
	 */
	public Adapter createXenVirtualDiskDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef <em>Xen Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef
	 * @generated
	 */
	public Adapter createXenVirtualEthernetNICDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit <em>Xen Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit
	 * @generated
	 */
	public Adapter createXenVirtualEthernetNICDefUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage <em>Xen Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage
	 * @generated
	 */
	public Adapter createXenVirtualImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit <em>Xen Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit
	 * @generated
	 */
	public Adapter createXenVirtualImageUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef <em>Xen Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef
	 * @generated
	 */
	public Adapter createXenVirtualServerDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem
	 * @generated
	 */
	public Adapter createOperatingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemUnit <em>Operating System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemUnit
	 * @generated
	 */
	public Adapter createOperatingSystemUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //VirtualizationAdapterFactory
