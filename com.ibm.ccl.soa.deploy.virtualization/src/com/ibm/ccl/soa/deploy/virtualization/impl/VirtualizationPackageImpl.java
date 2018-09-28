/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationPackageImpl.java,v 1.12 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType;
import com.ibm.ccl.soa.deploy.virtualization.Hypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VMwareESX;
import com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualizationPackageImpl extends EPackageImpl implements VirtualizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hypervisorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualDiskDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualDiskDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualDiskSnapshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualDiskSnapshotUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualEthernetNICDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualEthernetNICDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualImageCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualImageCollectionUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualImageSnapshotContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualImageUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualizationRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualServerDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualServerSnapshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualServerSnapshotUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareESXEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareESXUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareHypervisorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualDiskDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualDiskDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualDiskSnapshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualDiskSnapshotUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualEthernetNICDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualEthernetNICDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualIDEDiskDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualImageSnapshotContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualImageUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualSCSIDiskDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualServerDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualServerSnapshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vMwareVirtualServerSnapshotUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenHypervisorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualDiskDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualDiskDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualEthernetNICDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualEthernetNICDefUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualImageUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xenVirtualServerDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum desiredSnapshotStateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum virtualNetworkConnectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vMwareSCSIControllerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType desiredSnapshotStateTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType virtualNetworkConnectionTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType vMwareSCSIControllerTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VirtualizationPackageImpl() {
		super(eNS_URI, VirtualizationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VirtualizationPackage init() {
		if (isInited) return (VirtualizationPackage)EPackage.Registry.INSTANCE.getEPackage(VirtualizationPackage.eNS_URI);

		// Obtain or create and register package
		VirtualizationPackageImpl theVirtualizationPackage = (VirtualizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof VirtualizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new VirtualizationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		NetPackage.eINSTANCE.eClass();
		OsPackage.eINSTANCE.eClass();
		ServerPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVirtualizationPackage.createPackageContents();

		// Initialize created meta-data
		theVirtualizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVirtualizationPackage.freeze();

		return theVirtualizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHypervisor() {
		return hypervisorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualDiskDef() {
		return virtualDiskDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualDiskDefUnit() {
		return virtualDiskDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualDiskSnapshot() {
		return virtualDiskSnapshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualDiskSnapshotUnit() {
		return virtualDiskSnapshotUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualEthernetNICDef() {
		return virtualEthernetNICDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualEthernetNICDef_MacAddress() {
		return (EAttribute)virtualEthernetNICDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualEthernetNICDef_VirtualConnectionType() {
		return (EAttribute)virtualEthernetNICDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualEthernetNICDefUnit() {
		return virtualEthernetNICDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualImage() {
		return virtualImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImage_CreatedWithVMTool() {
		return (EAttribute)virtualImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImage_DateCreated() {
		return (EAttribute)virtualImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImage_DateLastModified() {
		return (EAttribute)virtualImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImage_Notes() {
		return (EAttribute)virtualImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImage_Owner() {
		return (EAttribute)virtualImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualImageCollection() {
		return virtualImageCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualImageCollection_CollectionId() {
		return (EAttribute)virtualImageCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualImageCollectionUnit() {
		return virtualImageCollectionUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualImageSnapshotContainer() {
		return virtualImageSnapshotContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualImageUnit() {
		return virtualImageUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualizationRoot() {
		return virtualizationRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualizationRoot_Mixed() {
		return (EAttribute)virtualizationRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_XMLNSPrefixMap() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_XSISchemaLocation() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityHypervisor() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualDiskDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualDiskSnapshot() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualEthernetNICDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualImage() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualImageCollection() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualServerDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVirtualServerSnapshot() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareESX() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareHypervisor() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualDiskDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualImage() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualServerDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityXenHypervisor() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityXenVirtualDiskDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityXenVirtualImage() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_CapabilityXenVirtualServerDef() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualDiskDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualDiskSnapshotUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualEthernetNICDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualImageCollectionUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualImageUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVirtualServerSnapshotUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareESXUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareVirtualImageUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitXenVirtualDiskDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVirtualizationRoot_UnitXenVirtualImageUnit() {
		return (EReference)virtualizationRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualServerDef() {
		return virtualServerDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualServerDef_MemorySize() {
		return (EAttribute)virtualServerDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualServerDef_Vcpus() {
		return (EAttribute)virtualServerDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualServerDef_VirtualHWFamily() {
		return (EAttribute)virtualServerDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualServerSnapshot() {
		return virtualServerSnapshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualServerSnapshotUnit() {
		return virtualServerSnapshotUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareESX() {
		return vMwareESXEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareESXUnit() {
		return vMwareESXUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareHypervisor() {
		return vMwareHypervisorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareHypervisor_VmwareProduct() {
		return (EAttribute)vMwareHypervisorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareHypervisor_VmwareVersion() {
		return (EAttribute)vMwareHypervisorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualDiskDef() {
		return vMwareVirtualDiskDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_Autodetect() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_DeviceType() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_DiskMode() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_FileName() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_Present() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskDef_StartConnected() {
		return (EAttribute)vMwareVirtualDiskDefEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualDiskDefUnit() {
		return vMwareVirtualDiskDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualDiskSnapshot() {
		return vMwareVirtualDiskSnapshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskSnapshot_DiskFileName() {
		return (EAttribute)vMwareVirtualDiskSnapshotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskSnapshot_DiskNum() {
		return (EAttribute)vMwareVirtualDiskSnapshotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualDiskSnapshot_SnapshotDiskFileName() {
		return (EAttribute)vMwareVirtualDiskSnapshotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualDiskSnapshotUnit() {
		return vMwareVirtualDiskSnapshotUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualEthernetNICDef() {
		return vMwareVirtualEthernetNICDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualEthernetNICDefUnit() {
		return vMwareVirtualEthernetNICDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualIDEDiskDef() {
		return vMwareVirtualIDEDiskDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualImage() {
		return vMwareVirtualImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualImage_ConfigVersion() {
		return (EAttribute)vMwareVirtualImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualImage_VmxFile() {
		return (EAttribute)vMwareVirtualImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualImageSnapshotContainer() {
		return vMwareVirtualImageSnapshotContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid() {
		return (EAttribute)vMwareVirtualImageSnapshotContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualImageSnapshotContainer_LastSnapshotUid() {
		return (EAttribute)vMwareVirtualImageSnapshotContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualImageSnapshotContainer_NumSnapshots() {
		return (EAttribute)vMwareVirtualImageSnapshotContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualImageUnit() {
		return vMwareVirtualImageUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualSCSIDiskDef() {
		return vMwareVirtualSCSIDiskDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualSCSIDiskDef_ControllerNumber() {
		return (EAttribute)vMwareVirtualSCSIDiskDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualSCSIDiskDef_ControllerType() {
		return (EAttribute)vMwareVirtualSCSIDiskDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualSCSIDiskDef_DeviceNumber() {
		return (EAttribute)vMwareVirtualSCSIDiskDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualServerDef() {
		return vMwareVirtualServerDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerDef_GuestOS() {
		return (EAttribute)vMwareVirtualServerDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerDef_VirtualHWVersion() {
		return (EAttribute)vMwareVirtualServerDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualServerSnapshot() {
		return vMwareVirtualServerSnapshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_CreateTimeHigh() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_CreateTimeLow() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_Current() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_DesiredSnapshotState() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_Filename() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_NumDisks() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_ParentSnapshotUid() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_SnapshotType() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVMwareVirtualServerSnapshot_Uid() {
		return (EAttribute)vMwareVirtualServerSnapshotEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVMwareVirtualServerSnapshotUnit() {
		return vMwareVirtualServerSnapshotUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenHypervisor() {
		return xenHypervisorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenHypervisor_XenVersion() {
		return (EAttribute)xenHypervisorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualDiskDef() {
		return xenVirtualDiskDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualDiskDef_BackendDev() {
		return (EAttribute)xenVirtualDiskDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualDiskDef_FrontendDev() {
		return (EAttribute)xenVirtualDiskDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualDiskDef_Mode() {
		return (EAttribute)xenVirtualDiskDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualDiskDefUnit() {
		return xenVirtualDiskDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualEthernetNICDef() {
		return xenVirtualEthernetNICDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualEthernetNICDef_NetworkBridge() {
		return (EAttribute)xenVirtualEthernetNICDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualEthernetNICDefUnit() {
		return xenVirtualEthernetNICDefUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualImage() {
		return xenVirtualImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualImage_DomainConfigFile() {
		return (EAttribute)xenVirtualImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXenVirtualImage_DomainName() {
		return (EAttribute)xenVirtualImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualImageUnit() {
		return xenVirtualImageUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXenVirtualServerDef() {
		return xenVirtualServerDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDesiredSnapshotStateType() {
		return desiredSnapshotStateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVirtualNetworkConnectionType() {
		return virtualNetworkConnectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVMwareSCSIControllerType() {
		return vMwareSCSIControllerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDesiredSnapshotStateTypeObject() {
		return desiredSnapshotStateTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVirtualNetworkConnectionTypeObject() {
		return virtualNetworkConnectionTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVMwareSCSIControllerTypeObject() {
		return vMwareSCSIControllerTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualizationFactory getVirtualizationFactory() {
		return (VirtualizationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		hypervisorEClass = createEClass(HYPERVISOR);

		virtualDiskDefEClass = createEClass(VIRTUAL_DISK_DEF);

		virtualDiskDefUnitEClass = createEClass(VIRTUAL_DISK_DEF_UNIT);

		virtualDiskSnapshotEClass = createEClass(VIRTUAL_DISK_SNAPSHOT);

		virtualDiskSnapshotUnitEClass = createEClass(VIRTUAL_DISK_SNAPSHOT_UNIT);

		virtualEthernetNICDefEClass = createEClass(VIRTUAL_ETHERNET_NIC_DEF);
		createEAttribute(virtualEthernetNICDefEClass, VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS);
		createEAttribute(virtualEthernetNICDefEClass, VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE);

		virtualEthernetNICDefUnitEClass = createEClass(VIRTUAL_ETHERNET_NIC_DEF_UNIT);

		virtualImageEClass = createEClass(VIRTUAL_IMAGE);
		createEAttribute(virtualImageEClass, VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL);
		createEAttribute(virtualImageEClass, VIRTUAL_IMAGE__DATE_CREATED);
		createEAttribute(virtualImageEClass, VIRTUAL_IMAGE__DATE_LAST_MODIFIED);
		createEAttribute(virtualImageEClass, VIRTUAL_IMAGE__NOTES);
		createEAttribute(virtualImageEClass, VIRTUAL_IMAGE__OWNER);

		virtualImageCollectionEClass = createEClass(VIRTUAL_IMAGE_COLLECTION);
		createEAttribute(virtualImageCollectionEClass, VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID);

		virtualImageCollectionUnitEClass = createEClass(VIRTUAL_IMAGE_COLLECTION_UNIT);

		virtualImageSnapshotContainerEClass = createEClass(VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);

		virtualImageUnitEClass = createEClass(VIRTUAL_IMAGE_UNIT);

		virtualizationRootEClass = createEClass(VIRTUALIZATION_ROOT);
		createEAttribute(virtualizationRootEClass, VIRTUALIZATION_ROOT__MIXED);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT);
		createEReference(virtualizationRootEClass, VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT);

		virtualServerDefEClass = createEClass(VIRTUAL_SERVER_DEF);
		createEAttribute(virtualServerDefEClass, VIRTUAL_SERVER_DEF__MEMORY_SIZE);
		createEAttribute(virtualServerDefEClass, VIRTUAL_SERVER_DEF__VCPUS);
		createEAttribute(virtualServerDefEClass, VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY);

		virtualServerSnapshotEClass = createEClass(VIRTUAL_SERVER_SNAPSHOT);

		virtualServerSnapshotUnitEClass = createEClass(VIRTUAL_SERVER_SNAPSHOT_UNIT);

		vMwareESXEClass = createEClass(VMWARE_ESX);

		vMwareESXUnitEClass = createEClass(VMWARE_ESX_UNIT);

		vMwareHypervisorEClass = createEClass(VMWARE_HYPERVISOR);
		createEAttribute(vMwareHypervisorEClass, VMWARE_HYPERVISOR__VMWARE_PRODUCT);
		createEAttribute(vMwareHypervisorEClass, VMWARE_HYPERVISOR__VMWARE_VERSION);

		vMwareVirtualDiskDefEClass = createEClass(VMWARE_VIRTUAL_DISK_DEF);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__AUTODETECT);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__DISK_MODE);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__FILE_NAME);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__PRESENT);
		createEAttribute(vMwareVirtualDiskDefEClass, VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED);

		vMwareVirtualDiskDefUnitEClass = createEClass(VMWARE_VIRTUAL_DISK_DEF_UNIT);

		vMwareVirtualDiskSnapshotEClass = createEClass(VMWARE_VIRTUAL_DISK_SNAPSHOT);
		createEAttribute(vMwareVirtualDiskSnapshotEClass, VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME);
		createEAttribute(vMwareVirtualDiskSnapshotEClass, VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM);
		createEAttribute(vMwareVirtualDiskSnapshotEClass, VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME);

		vMwareVirtualDiskSnapshotUnitEClass = createEClass(VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT);

		vMwareVirtualEthernetNICDefEClass = createEClass(VMWARE_VIRTUAL_ETHERNET_NIC_DEF);

		vMwareVirtualEthernetNICDefUnitEClass = createEClass(VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT);

		vMwareVirtualIDEDiskDefEClass = createEClass(VMWARE_VIRTUAL_IDE_DISK_DEF);

		vMwareVirtualImageEClass = createEClass(VMWARE_VIRTUAL_IMAGE);
		createEAttribute(vMwareVirtualImageEClass, VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION);
		createEAttribute(vMwareVirtualImageEClass, VMWARE_VIRTUAL_IMAGE__VMX_FILE);

		vMwareVirtualImageSnapshotContainerEClass = createEClass(VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER);
		createEAttribute(vMwareVirtualImageSnapshotContainerEClass, VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID);
		createEAttribute(vMwareVirtualImageSnapshotContainerEClass, VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID);
		createEAttribute(vMwareVirtualImageSnapshotContainerEClass, VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS);

		vMwareVirtualImageUnitEClass = createEClass(VMWARE_VIRTUAL_IMAGE_UNIT);

		vMwareVirtualSCSIDiskDefEClass = createEClass(VMWARE_VIRTUAL_SCSI_DISK_DEF);
		createEAttribute(vMwareVirtualSCSIDiskDefEClass, VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER);
		createEAttribute(vMwareVirtualSCSIDiskDefEClass, VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE);
		createEAttribute(vMwareVirtualSCSIDiskDefEClass, VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER);

		vMwareVirtualServerDefEClass = createEClass(VMWARE_VIRTUAL_SERVER_DEF);
		createEAttribute(vMwareVirtualServerDefEClass, VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS);
		createEAttribute(vMwareVirtualServerDefEClass, VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION);

		vMwareVirtualServerSnapshotEClass = createEClass(VMWARE_VIRTUAL_SERVER_SNAPSHOT);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE);
		createEAttribute(vMwareVirtualServerSnapshotEClass, VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID);

		vMwareVirtualServerSnapshotUnitEClass = createEClass(VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT);

		xenHypervisorEClass = createEClass(XEN_HYPERVISOR);
		createEAttribute(xenHypervisorEClass, XEN_HYPERVISOR__XEN_VERSION);

		xenVirtualDiskDefEClass = createEClass(XEN_VIRTUAL_DISK_DEF);
		createEAttribute(xenVirtualDiskDefEClass, XEN_VIRTUAL_DISK_DEF__BACKEND_DEV);
		createEAttribute(xenVirtualDiskDefEClass, XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV);
		createEAttribute(xenVirtualDiskDefEClass, XEN_VIRTUAL_DISK_DEF__MODE);

		xenVirtualDiskDefUnitEClass = createEClass(XEN_VIRTUAL_DISK_DEF_UNIT);

		xenVirtualEthernetNICDefEClass = createEClass(XEN_VIRTUAL_ETHERNET_NIC_DEF);
		createEAttribute(xenVirtualEthernetNICDefEClass, XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE);

		xenVirtualEthernetNICDefUnitEClass = createEClass(XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT);

		xenVirtualImageEClass = createEClass(XEN_VIRTUAL_IMAGE);
		createEAttribute(xenVirtualImageEClass, XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE);
		createEAttribute(xenVirtualImageEClass, XEN_VIRTUAL_IMAGE__DOMAIN_NAME);

		xenVirtualImageUnitEClass = createEClass(XEN_VIRTUAL_IMAGE_UNIT);

		xenVirtualServerDefEClass = createEClass(XEN_VIRTUAL_SERVER_DEF);

		// Create enums
		desiredSnapshotStateTypeEEnum = createEEnum(DESIRED_SNAPSHOT_STATE_TYPE);
		virtualNetworkConnectionTypeEEnum = createEEnum(VIRTUAL_NETWORK_CONNECTION_TYPE);
		vMwareSCSIControllerTypeEEnum = createEEnum(VMWARE_SCSI_CONTROLLER_TYPE);

		// Create data types
		desiredSnapshotStateTypeObjectEDataType = createEDataType(DESIRED_SNAPSHOT_STATE_TYPE_OBJECT);
		virtualNetworkConnectionTypeObjectEDataType = createEDataType(VIRTUAL_NETWORK_CONNECTION_TYPE_OBJECT);
		vMwareSCSIControllerTypeObjectEDataType = createEDataType(VMWARE_SCSI_CONTROLLER_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		OsPackage theOsPackage = (OsPackage)EPackage.Registry.INSTANCE.getEPackage(OsPackage.eNS_URI);

		// Add supertypes to classes
		hypervisorEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualDiskDefEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualDiskDefUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		virtualDiskSnapshotEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualDiskSnapshotUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		virtualEthernetNICDefEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualEthernetNICDefUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		virtualImageEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualImageCollectionEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualImageCollectionUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		virtualImageSnapshotContainerEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualImageUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		virtualServerDefEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualServerSnapshotEClass.getESuperTypes().add(theCorePackage.getCapability());
		virtualServerSnapshotUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		vMwareESXEClass.getESuperTypes().add(theOsPackage.getOperatingSystem());
		vMwareESXUnitEClass.getESuperTypes().add(theOsPackage.getOperatingSystemUnit());
		vMwareHypervisorEClass.getESuperTypes().add(this.getHypervisor());
		vMwareVirtualDiskDefEClass.getESuperTypes().add(this.getVirtualDiskDef());
		vMwareVirtualDiskDefUnitEClass.getESuperTypes().add(this.getVirtualDiskDefUnit());
		vMwareVirtualDiskSnapshotEClass.getESuperTypes().add(this.getVirtualDiskSnapshot());
		vMwareVirtualDiskSnapshotUnitEClass.getESuperTypes().add(this.getVirtualDiskSnapshotUnit());
		vMwareVirtualEthernetNICDefEClass.getESuperTypes().add(this.getVirtualEthernetNICDef());
		vMwareVirtualEthernetNICDefUnitEClass.getESuperTypes().add(this.getVirtualEthernetNICDefUnit());
		vMwareVirtualIDEDiskDefEClass.getESuperTypes().add(this.getVMwareVirtualDiskDef());
		vMwareVirtualImageEClass.getESuperTypes().add(this.getVirtualImage());
		vMwareVirtualImageSnapshotContainerEClass.getESuperTypes().add(this.getVirtualImageSnapshotContainer());
		vMwareVirtualImageUnitEClass.getESuperTypes().add(this.getVirtualImageUnit());
		vMwareVirtualSCSIDiskDefEClass.getESuperTypes().add(this.getVMwareVirtualDiskDef());
		vMwareVirtualServerDefEClass.getESuperTypes().add(this.getVirtualServerDef());
		vMwareVirtualServerSnapshotEClass.getESuperTypes().add(this.getVirtualServerSnapshot());
		vMwareVirtualServerSnapshotUnitEClass.getESuperTypes().add(this.getVirtualServerSnapshotUnit());
		xenHypervisorEClass.getESuperTypes().add(this.getHypervisor());
		xenVirtualDiskDefEClass.getESuperTypes().add(this.getVirtualDiskDef());
		xenVirtualDiskDefUnitEClass.getESuperTypes().add(this.getVirtualDiskDefUnit());
		xenVirtualEthernetNICDefEClass.getESuperTypes().add(this.getVirtualEthernetNICDef());
		xenVirtualEthernetNICDefUnitEClass.getESuperTypes().add(this.getVirtualEthernetNICDefUnit());
		xenVirtualImageEClass.getESuperTypes().add(this.getVirtualImage());
		xenVirtualImageUnitEClass.getESuperTypes().add(this.getVirtualImageUnit());
		xenVirtualServerDefEClass.getESuperTypes().add(this.getVirtualServerDef());

		// Initialize classes and features; add operations and parameters
		initEClass(hypervisorEClass, Hypervisor.class, "Hypervisor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualDiskDefEClass, VirtualDiskDef.class, "VirtualDiskDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualDiskDefUnitEClass, VirtualDiskDefUnit.class, "VirtualDiskDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualDiskSnapshotEClass, VirtualDiskSnapshot.class, "VirtualDiskSnapshot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualDiskSnapshotUnitEClass, VirtualDiskSnapshotUnit.class, "VirtualDiskSnapshotUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualEthernetNICDefEClass, VirtualEthernetNICDef.class, "VirtualEthernetNICDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVirtualEthernetNICDef_MacAddress(), theXMLTypePackage.getString(), "macAddress", null, 0, 1, VirtualEthernetNICDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualEthernetNICDef_VirtualConnectionType(), this.getVirtualNetworkConnectionType(), "virtualConnectionType", "bridged", 0, 1, VirtualEthernetNICDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(virtualEthernetNICDefUnitEClass, VirtualEthernetNICDefUnit.class, "VirtualEthernetNICDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualImageEClass, VirtualImage.class, "VirtualImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVirtualImage_CreatedWithVMTool(), theXMLTypePackage.getString(), "createdWithVMTool", null, 0, 1, VirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualImage_DateCreated(), theXMLTypePackage.getString(), "dateCreated", null, 0, 1, VirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualImage_DateLastModified(), theXMLTypePackage.getString(), "dateLastModified", null, 0, 1, VirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualImage_Notes(), theXMLTypePackage.getString(), "notes", null, 0, 1, VirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualImage_Owner(), theXMLTypePackage.getString(), "owner", null, 0, 1, VirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(virtualImageCollectionEClass, VirtualImageCollection.class, "VirtualImageCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVirtualImageCollection_CollectionId(), theXMLTypePackage.getString(), "collectionId", null, 0, 1, VirtualImageCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(virtualImageCollectionUnitEClass, VirtualImageCollectionUnit.class, "VirtualImageCollectionUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualImageSnapshotContainerEClass, VirtualImageSnapshotContainer.class, "VirtualImageSnapshotContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualImageUnitEClass, VirtualImageUnit.class, "VirtualImageUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualizationRootEClass, VirtualizationRoot.class, "VirtualizationRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVirtualizationRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityHypervisor(), this.getHypervisor(), null, "capabilityHypervisor", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualDiskDef(), this.getVirtualDiskDef(), null, "capabilityVirtualDiskDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualDiskSnapshot(), this.getVirtualDiskSnapshot(), null, "capabilityVirtualDiskSnapshot", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualEthernetNICDef(), this.getVirtualEthernetNICDef(), null, "capabilityVirtualEthernetNICDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualImage(), this.getVirtualImage(), null, "capabilityVirtualImage", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualImageCollection(), this.getVirtualImageCollection(), null, "capabilityVirtualImageCollection", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer(), this.getVirtualImageSnapshotContainer(), null, "capabilityVirtualImageSnapshotContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualServerDef(), this.getVirtualServerDef(), null, "capabilityVirtualServerDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVirtualServerSnapshot(), this.getVirtualServerSnapshot(), null, "capabilityVirtualServerSnapshot", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareESX(), this.getVMwareESX(), null, "capabilityVmwareESX", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareHypervisor(), this.getVMwareHypervisor(), null, "capabilityVmwareHypervisor", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualDiskDef(), this.getVMwareVirtualDiskDef(), null, "capabilityVmwareVirtualDiskDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot(), this.getVMwareVirtualDiskSnapshot(), null, "capabilityVmwareVirtualDiskSnapshot", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef(), this.getVMwareVirtualEthernetNICDef(), null, "capabilityVmwareVirtualEthernetNICDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef(), this.getVMwareVirtualIDEDiskDef(), null, "capabilityVmwareVirtualIDEDiskDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualImage(), this.getVMwareVirtualImage(), null, "capabilityVmwareVirtualImage", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer(), this.getVMwareVirtualImageSnapshotContainer(), null, "capabilityVmwareVirtualImageSnapshotContainer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef(), this.getVMwareVirtualSCSIDiskDef(), null, "capabilityVmwareVirtualSCSIDiskDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualServerDef(), this.getVMwareVirtualServerDef(), null, "capabilityVmwareVirtualServerDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot(), this.getVMwareVirtualServerSnapshot(), null, "capabilityVmwareVirtualServerSnapshot", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityXenHypervisor(), this.getXenHypervisor(), null, "capabilityXenHypervisor", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityXenVirtualDiskDef(), this.getXenVirtualDiskDef(), null, "capabilityXenVirtualDiskDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef(), this.getXenVirtualEthernetNICDef(), null, "capabilityXenVirtualEthernetNICDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityXenVirtualImage(), this.getXenVirtualImage(), null, "capabilityXenVirtualImage", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_CapabilityXenVirtualServerDef(), this.getXenVirtualServerDef(), null, "capabilityXenVirtualServerDef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualDiskDefUnit(), this.getVirtualDiskDefUnit(), null, "unitVirtualDiskDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualDiskSnapshotUnit(), this.getVirtualDiskSnapshotUnit(), null, "unitVirtualDiskSnapshotUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualEthernetNICDefUnit(), this.getVirtualEthernetNICDefUnit(), null, "unitVirtualEthernetNICDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualImageCollectionUnit(), this.getVirtualImageCollectionUnit(), null, "unitVirtualImageCollectionUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualImageUnit(), this.getVirtualImageUnit(), null, "unitVirtualImageUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVirtualServerSnapshotUnit(), this.getVirtualServerSnapshotUnit(), null, "unitVirtualServerSnapshotUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareESXUnit(), this.getVMwareESXUnit(), null, "unitVmwareESXUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit(), this.getVMwareVirtualDiskDefUnit(), null, "unitVmwareVirtualDiskDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit(), this.getVMwareVirtualDiskSnapshotUnit(), null, "unitVmwareVirtualDiskSnapshotUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit(), this.getVMwareVirtualEthernetNICDefUnit(), null, "unitVmwareVirtualEthernetNICDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareVirtualImageUnit(), this.getVMwareVirtualImageUnit(), null, "unitVmwareVirtualImageUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit(), this.getVMwareVirtualServerSnapshotUnit(), null, "unitVmwareVirtualServerSnapshotUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitXenVirtualDiskDefUnit(), this.getXenVirtualDiskDefUnit(), null, "unitXenVirtualDiskDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit(), this.getXenVirtualEthernetNICDefUnit(), null, "unitXenVirtualEthernetNICDefUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVirtualizationRoot_UnitXenVirtualImageUnit(), this.getXenVirtualImageUnit(), null, "unitXenVirtualImageUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(virtualServerDefEClass, VirtualServerDef.class, "VirtualServerDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVirtualServerDef_MemorySize(), theXMLTypePackage.getUnsignedLong(), "memorySize", null, 0, 1, VirtualServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualServerDef_Vcpus(), theXMLTypePackage.getUnsignedLong(), "vcpus", null, 0, 1, VirtualServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVirtualServerDef_VirtualHWFamily(), theXMLTypePackage.getString(), "virtualHWFamily", null, 0, 1, VirtualServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(virtualServerSnapshotEClass, VirtualServerSnapshot.class, "VirtualServerSnapshot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(virtualServerSnapshotUnitEClass, VirtualServerSnapshotUnit.class, "VirtualServerSnapshotUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareESXEClass, VMwareESX.class, "VMwareESX", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareESXUnitEClass, VMwareESXUnit.class, "VMwareESXUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareHypervisorEClass, VMwareHypervisor.class, "VMwareHypervisor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareHypervisor_VmwareProduct(), theXMLTypePackage.getString(), "vmwareProduct", null, 0, 1, VMwareHypervisor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareHypervisor_VmwareVersion(), theXMLTypePackage.getString(), "vmwareVersion", null, 0, 1, VMwareHypervisor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualDiskDefEClass, VMwareVirtualDiskDef.class, "VMwareVirtualDiskDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_Autodetect(), theXMLTypePackage.getBoolean(), "autodetect", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_DeviceType(), theXMLTypePackage.getString(), "deviceType", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_DiskMode(), theXMLTypePackage.getString(), "diskMode", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_FileName(), theXMLTypePackage.getString(), "fileName", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_Present(), theXMLTypePackage.getBoolean(), "present", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskDef_StartConnected(), theXMLTypePackage.getBoolean(), "startConnected", null, 0, 1, VMwareVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualDiskDefUnitEClass, VMwareVirtualDiskDefUnit.class, "VMwareVirtualDiskDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualDiskSnapshotEClass, VMwareVirtualDiskSnapshot.class, "VMwareVirtualDiskSnapshot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskSnapshot_DiskFileName(), theXMLTypePackage.getString(), "diskFileName", null, 0, 1, VMwareVirtualDiskSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskSnapshot_DiskNum(), theXMLTypePackage.getInt(), "diskNum", null, 0, 1, VMwareVirtualDiskSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualDiskSnapshot_SnapshotDiskFileName(), theXMLTypePackage.getString(), "snapshotDiskFileName", null, 0, 1, VMwareVirtualDiskSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualDiskSnapshotUnitEClass, VMwareVirtualDiskSnapshotUnit.class, "VMwareVirtualDiskSnapshotUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualEthernetNICDefEClass, VMwareVirtualEthernetNICDef.class, "VMwareVirtualEthernetNICDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualEthernetNICDefUnitEClass, VMwareVirtualEthernetNICDefUnit.class, "VMwareVirtualEthernetNICDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualIDEDiskDefEClass, VMwareVirtualIDEDiskDef.class, "VMwareVirtualIDEDiskDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualImageEClass, VMwareVirtualImage.class, "VMwareVirtualImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualImage_ConfigVersion(), theXMLTypePackage.getString(), "configVersion", null, 0, 1, VMwareVirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualImage_VmxFile(), theXMLTypePackage.getString(), "vmxFile", null, 0, 1, VMwareVirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualImageSnapshotContainerEClass, VMwareVirtualImageSnapshotContainer.class, "VMwareVirtualImageSnapshotContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid(), theXMLTypePackage.getString(), "currentSnapshotUid", null, 0, 1, VMwareVirtualImageSnapshotContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualImageSnapshotContainer_LastSnapshotUid(), theXMLTypePackage.getString(), "lastSnapshotUid", null, 0, 1, VMwareVirtualImageSnapshotContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualImageSnapshotContainer_NumSnapshots(), theXMLTypePackage.getInt(), "numSnapshots", null, 0, 1, VMwareVirtualImageSnapshotContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualImageUnitEClass, VMwareVirtualImageUnit.class, "VMwareVirtualImageUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(vMwareVirtualSCSIDiskDefEClass, VMwareVirtualSCSIDiskDef.class, "VMwareVirtualSCSIDiskDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualSCSIDiskDef_ControllerNumber(), theXMLTypePackage.getInt(), "controllerNumber", null, 0, 1, VMwareVirtualSCSIDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualSCSIDiskDef_ControllerType(), this.getVMwareSCSIControllerType(), "controllerType", "buslogic", 0, 1, VMwareVirtualSCSIDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getVMwareVirtualSCSIDiskDef_DeviceNumber(), theXMLTypePackage.getInt(), "deviceNumber", null, 0, 1, VMwareVirtualSCSIDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualServerDefEClass, VMwareVirtualServerDef.class, "VMwareVirtualServerDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerDef_GuestOS(), theXMLTypePackage.getString(), "guestOS", null, 0, 1, VMwareVirtualServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerDef_VirtualHWVersion(), theXMLTypePackage.getString(), "virtualHWVersion", null, 0, 1, VMwareVirtualServerDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualServerSnapshotEClass, VMwareVirtualServerSnapshot.class, "VMwareVirtualServerSnapshot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_CreateTimeHigh(), theXMLTypePackage.getLong(), "createTimeHigh", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_CreateTimeLow(), theXMLTypePackage.getLong(), "createTimeLow", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_Current(), theXMLTypePackage.getBoolean(), "current", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_DesiredSnapshotState(), this.getDesiredSnapshotStateType(), "desiredSnapshotState", "unknown", 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getVMwareVirtualServerSnapshot_Filename(), theXMLTypePackage.getString(), "filename", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_NumDisks(), theXMLTypePackage.getInt(), "numDisks", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_ParentSnapshotUid(), theXMLTypePackage.getString(), "parentSnapshotUid", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_SnapshotType(), theXMLTypePackage.getString(), "snapshotType", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVMwareVirtualServerSnapshot_Uid(), theXMLTypePackage.getString(), "uid", null, 0, 1, VMwareVirtualServerSnapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(vMwareVirtualServerSnapshotUnitEClass, VMwareVirtualServerSnapshotUnit.class, "VMwareVirtualServerSnapshotUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(xenHypervisorEClass, XenHypervisor.class, "XenHypervisor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getXenHypervisor_XenVersion(), theXMLTypePackage.getString(), "xenVersion", null, 0, 1, XenHypervisor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(xenVirtualDiskDefEClass, XenVirtualDiskDef.class, "XenVirtualDiskDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getXenVirtualDiskDef_BackendDev(), theXMLTypePackage.getString(), "backendDev", null, 0, 1, XenVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getXenVirtualDiskDef_FrontendDev(), theXMLTypePackage.getString(), "frontendDev", null, 0, 1, XenVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getXenVirtualDiskDef_Mode(), theXMLTypePackage.getString(), "mode", null, 0, 1, XenVirtualDiskDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(xenVirtualDiskDefUnitEClass, XenVirtualDiskDefUnit.class, "XenVirtualDiskDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(xenVirtualEthernetNICDefEClass, XenVirtualEthernetNICDef.class, "XenVirtualEthernetNICDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getXenVirtualEthernetNICDef_NetworkBridge(), theXMLTypePackage.getString(), "networkBridge", null, 0, 1, XenVirtualEthernetNICDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(xenVirtualEthernetNICDefUnitEClass, XenVirtualEthernetNICDefUnit.class, "XenVirtualEthernetNICDefUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(xenVirtualImageEClass, XenVirtualImage.class, "XenVirtualImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getXenVirtualImage_DomainConfigFile(), theXMLTypePackage.getString(), "domainConfigFile", null, 0, 1, XenVirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getXenVirtualImage_DomainName(), theXMLTypePackage.getString(), "domainName", null, 0, 1, XenVirtualImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(xenVirtualImageUnitEClass, XenVirtualImageUnit.class, "XenVirtualImageUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(xenVirtualServerDefEClass, XenVirtualServerDef.class, "XenVirtualServerDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(desiredSnapshotStateTypeEEnum, DesiredSnapshotStateType.class, "DesiredSnapshotStateType"); //$NON-NLS-1$
		addEEnumLiteral(desiredSnapshotStateTypeEEnum, DesiredSnapshotStateType.UNKNOWN_LITERAL);
		addEEnumLiteral(desiredSnapshotStateTypeEEnum, DesiredSnapshotStateType.ACTIVE_LITERAL);
		addEEnumLiteral(desiredSnapshotStateTypeEEnum, DesiredSnapshotStateType.REVERT_LITERAL);

		initEEnum(virtualNetworkConnectionTypeEEnum, VirtualNetworkConnectionType.class, "VirtualNetworkConnectionType"); //$NON-NLS-1$
		addEEnumLiteral(virtualNetworkConnectionTypeEEnum, VirtualNetworkConnectionType.BRIDGED_LITERAL);
		addEEnumLiteral(virtualNetworkConnectionTypeEEnum, VirtualNetworkConnectionType.NAT_LITERAL);
		addEEnumLiteral(virtualNetworkConnectionTypeEEnum, VirtualNetworkConnectionType.HOST_ONLY_LITERAL);
		addEEnumLiteral(virtualNetworkConnectionTypeEEnum, VirtualNetworkConnectionType.CUSTOM_LITERAL);

		initEEnum(vMwareSCSIControllerTypeEEnum, VMwareSCSIControllerType.class, "VMwareSCSIControllerType"); //$NON-NLS-1$
		addEEnumLiteral(vMwareSCSIControllerTypeEEnum, VMwareSCSIControllerType.BUSLOGIC_LITERAL);
		addEEnumLiteral(vMwareSCSIControllerTypeEEnum, VMwareSCSIControllerType.LSILOGIC_LITERAL);

		// Initialize data types
		initEDataType(desiredSnapshotStateTypeObjectEDataType, DesiredSnapshotStateType.class, "DesiredSnapshotStateTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(virtualNetworkConnectionTypeObjectEDataType, VirtualNetworkConnectionType.class, "VirtualNetworkConnectionTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(vMwareSCSIControllerTypeObjectEDataType, VMwareSCSIControllerType.class, "VMwareSCSIControllerTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (desiredSnapshotStateTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DesiredSnapshotStateType" //$NON-NLS-1$ //$NON-NLS-2$
		   });					
		addAnnotation
		  (desiredSnapshotStateTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DesiredSnapshotStateType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DesiredSnapshotStateType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (hypervisorEClass, 
		   source, 
		   new String[] {
			 "name", "Hypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualDiskDefEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualDiskDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualDiskSnapshotEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualDiskSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualDiskSnapshotUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualDiskSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualEthernetNICDefEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualEthernetNICDef_MacAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "macAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualEthernetNICDef_VirtualConnectionType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "virtualConnectionType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualEthernetNICDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualImageEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualImage_CreatedWithVMTool(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "createdWithVMTool" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualImage_DateCreated(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dateCreated" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualImage_DateLastModified(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dateLastModified" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualImage_Notes(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "notes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualImage_Owner(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "owner" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualImageCollectionEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualImageCollection", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualImageCollection_CollectionId(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "collectionId" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualImageCollectionUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualImageCollectionUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualImageSnapshotContainerEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualImageSnapshotContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualImageUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (virtualizationRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityHypervisor(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.hypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualDiskDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualDiskSnapshot(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualDiskSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualEthernetNICDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualImage(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualImageCollection(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualImageCollection", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualImageSnapshotContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualServerDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVirtualServerSnapshot(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.virtualServerSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareESX(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareESX", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareHypervisor(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareHypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualDiskDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualDiskSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualIDEDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualImage(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualImageSnapshotContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualSCSIDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualServerDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.vmwareVirtualServerSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityXenHypervisor(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.xenHypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityXenVirtualDiskDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.xenVirtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.xenVirtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityXenVirtualImage(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.xenVirtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_CapabilityXenVirtualServerDef(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.xenVirtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualDiskDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualDiskSnapshotUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualDiskSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualEthernetNICDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualImageCollectionUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualImageCollectionUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualImageUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVirtualServerSnapshotUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.virtualServerSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareESXUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareESXUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareVirtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareVirtualDiskSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareVirtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareVirtualImageUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareVirtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.vmwareVirtualServerSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitXenVirtualDiskDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.xenVirtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.xenVirtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVirtualizationRoot_UnitXenVirtualImageUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.xenVirtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (virtualNetworkConnectionTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "VirtualNetworkConnectionType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (virtualNetworkConnectionTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "VirtualNetworkConnectionType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "VirtualNetworkConnectionType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualServerDefEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualServerDef_MemorySize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "memorySize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualServerDef_Vcpus(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "vcpus" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVirtualServerDef_VirtualHWFamily(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "virtualHWFamily" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualServerSnapshotEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualServerSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (virtualServerSnapshotUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VirtualServerSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareESXEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareESX", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareESXUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareESXUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareHypervisorEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareHypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareHypervisor_VmwareProduct(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "vmwareProduct" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareHypervisor_VmwareVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "vmwareVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (vMwareSCSIControllerTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "VMwareSCSIControllerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (vMwareSCSIControllerTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "VMwareSCSIControllerType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "VMwareSCSIControllerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualDiskDefEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getVMwareVirtualDiskDef_Autodetect(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autodetect" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskDef_DeviceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deviceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskDef_DiskMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "diskMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskDef_FileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fileName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskDef_Present(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "present" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskDef_StartConnected(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "startConnected" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualDiskDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualDiskSnapshotEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualDiskSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskSnapshot_DiskFileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "diskFileName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskSnapshot_DiskNum(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "diskNum" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualDiskSnapshot_SnapshotDiskFileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "snapshotDiskFileName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualDiskSnapshotUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualDiskSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualEthernetNICDefEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualEthernetNICDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualIDEDiskDefEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualIDEDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualImageEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualImage_ConfigVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualImage_VmxFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "vmxFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualImageSnapshotContainerEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualImageSnapshotContainer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "currentSnapshotUid" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualImageSnapshotContainer_LastSnapshotUid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "lastSnapshotUid" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualImageSnapshotContainer_NumSnapshots(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "numSnapshots" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualImageUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualSCSIDiskDefEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualSCSIDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualSCSIDiskDef_ControllerNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "controllerNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualSCSIDiskDef_ControllerType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "controllerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualSCSIDiskDef_DeviceNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deviceNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualServerDefEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerDef_GuestOS(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "guestOS" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerDef_VirtualHWVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "virtualHWVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualServerSnapshotEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualServerSnapshot", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_CreateTimeHigh(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "createTimeHigh" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_CreateTimeLow(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "createTimeLow" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_Current(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "current" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_DesiredSnapshotState(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "desiredSnapshotState" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_Filename(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "filename" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_NumDisks(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "numDisks" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_ParentSnapshotUid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "parentSnapshotUid" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_SnapshotType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "snapshotType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getVMwareVirtualServerSnapshot_Uid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "uid" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (vMwareVirtualServerSnapshotUnitEClass, 
		   source, 
		   new String[] {
			 "name", "VMwareVirtualServerSnapshotUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenHypervisorEClass, 
		   source, 
		   new String[] {
			 "name", "XenHypervisor", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenHypervisor_XenVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xenVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualDiskDefEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualDiskDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualDiskDef_BackendDev(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "backendDev" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualDiskDef_FrontendDev(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "frontendDev" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualDiskDef_Mode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mode" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualDiskDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualDiskDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualEthernetNICDefEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualEthernetNICDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualEthernetNICDef_NetworkBridge(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "networkBridge" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualEthernetNICDefUnitEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualEthernetNICDefUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualImageEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualImage", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualImage_DomainConfigFile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "domainConfigFile" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getXenVirtualImage_DomainName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "domainName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualImageUnitEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualImageUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (xenVirtualServerDefEClass, 
		   source, 
		   new String[] {
			 "name", "XenVirtualServerDef", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //VirtualizationPackageImpl
