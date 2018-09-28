/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.db2high.DB2BufferPool;
import com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Constraint;
import com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Field;
import com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2HighRoot;
import com.ibm.ccl.soa.deploy.db2high.DB2Index;
import com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Manager;
import com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup;
import com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Permission;
import com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Table;
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpace;
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2TableUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2User;
import com.ibm.ccl.soa.deploy.db2high.DB2UserUnit;
import com.ibm.ccl.soa.deploy.db2high.Db2highFactory;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Db2highPackageImpl extends EPackageImpl implements Db2highPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2BufferPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2BufferPoolUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ConstraintUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2FieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2FieldUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2HighRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2IndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2IndexUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ManagerUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2PartitionGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2PartitionGroupUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2PermissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2PermissionUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2TableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2TableSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2TableSpaceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2TableUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2UserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2UserUnitEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Db2highPackageImpl() {
		super(eNS_URI, Db2highFactory.eINSTANCE);
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
	public static Db2highPackage init() {
		if (isInited) return (Db2highPackage)EPackage.Registry.INSTANCE.getEPackage(Db2highPackage.eNS_URI);

		// Obtain or create and register package
		Db2highPackageImpl theDb2highPackage = (Db2highPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Db2highPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Db2highPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDb2highPackage.createPackageContents();

		// Initialize created meta-data
		theDb2highPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDb2highPackage.freeze();

		return theDb2highPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2BufferPool() {
		return db2BufferPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BufferPool_ImmediateOrDeferred() {
		return (EAttribute)db2BufferPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BufferPool_Name1() {
		return (EAttribute)db2BufferPoolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BufferPool_PageSize() {
		return (EAttribute)db2BufferPoolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BufferPool_Size() {
		return (EAttribute)db2BufferPoolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2BufferPoolUnit() {
		return db2BufferPoolUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Constraint() {
		return db2ConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Constraint_Name1() {
		return (EAttribute)db2ConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Constraint_Value() {
		return (EAttribute)db2ConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2ConstraintUnit() {
		return db2ConstraintUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Field() {
		return db2FieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Field_Name1() {
		return (EAttribute)db2FieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Field_NullAllowed() {
		return (EAttribute)db2FieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Field_Type() {
		return (EAttribute)db2FieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2FieldUnit() {
		return db2FieldUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2HighRoot() {
		return db2HighRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2HighRoot_Mixed() {
		return (EAttribute)db2HighRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_XMLNSPrefixMap() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_XSISchemaLocation() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_CapabilityDB2BufferPool() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_CapabilityDB2PartitionGroup() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_CapabilityDB2TableSpace() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_CapailityDB2Manager() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2BufferPoolUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2Constraint() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2ConstraintUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2Field() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2FieldUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2Index() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2IndexUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2ManagerUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2PartitionGroupUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2Permission() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2PermissionUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2Table() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2TableSpaceUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2TableUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2User() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDB2HighRoot_UnitDB2UserUnit() {
		return (EReference)db2HighRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Index() {
		return db2IndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Index_Field() {
		return (EAttribute)db2IndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Index_Name1() {
		return (EAttribute)db2IndexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2IndexUnit() {
		return db2IndexUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Manager() {
		return db2ManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AgentPoolSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AgentPriority() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AgentStackSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ApplicationSupportLayerHeapSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AuditBufferSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AuthenticationType() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_AuthenticationTypeForIncomingConnections() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_BypassFederatedAuthentication() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_CatalogingAllowedWithoutAuthority() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ClientIOBlockSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ClientKerberosPlugin() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ClientUseridPasswordPlugin() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_CommunicationsBandwidth() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ConfigurationFileReleaseLevel() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ConnectionElapseTime() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_CPUSpeed() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DatabaseSystemMonitorHeapSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DefaultChargeBackAccount() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DefaultDatabasePath() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DefaultDatabaseSystemMonitorSwitches() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DiagnosticDataDirectoryPath() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DiagnosticErrorCaptureLevel() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DirectoryCacheSupport() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DiscoverServerInstance() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_DiscoveryMode() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_EnablePntrapartitionParallelism() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_FederatedDatabaseSystemSupport() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_GroupPlugin() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_HealthMonitoring() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_IndexRecreationTime() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_InitialNumberOfAgentsInPool() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_InitialNumberOfFencedProcesses() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_InstanceImpactPolicy() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_InstanceMemory() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_KeepFencedProcess() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_LocalGSSAPIPlugin() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MachineNodeType() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumAsynchronousTQsPerQuery() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumJavaInterpreterHeapSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfAgents() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfClientConnections() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfConcurrentAgents() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfCoordinatingAgents() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumNumberOfFencedProcesses() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumQueryDegreeOfParallelism() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_MaximumTimeDifferenceAmongNodes() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_NodeConnectionRetries() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_NotifyLevel() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_NumberOfFCMBuffers() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_NumberOfFCMChannels() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_QueryHeapSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_ServerPluginMode() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SortHeapThreshold() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_StartAndStopTimeout() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SyncPointManagerLogFilePath() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SyncPointManagerLogFileSize() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SyncPointManagerName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SyncPointManagerResyncAgentLimit() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SystemAdministrationAuthorityGroupName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SystemControlAuthorityGroupName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SystemMaintenanceAuthorityGroupName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_SystemMonitorAuthorityGroupName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TCPIPServiceName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TransactionManagerDatabaseName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TransactionProcessorMonitorName() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TransactionResyncInterval() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TrustAllClients() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_TrustedClientsAuthentication() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Manager_UseridPasswordPlugIn() {
		return (EAttribute)db2ManagerEClass.getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2ManagerUnit() {
		return db2ManagerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2PartitionGroup() {
		return db2PartitionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2PartitionGroup_Name1() {
		return (EAttribute)db2PartitionGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2PartitionGroupUnit() {
		return db2PartitionGroupUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Permission() {
		return db2PermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Permission_Object() {
		return (EAttribute)db2PermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Permission_Type() {
		return (EAttribute)db2PermissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2PermissionUnit() {
		return db2PermissionUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Table() {
		return db2TableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Table_Alias() {
		return (EAttribute)db2TableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Table_IndexTableSpace() {
		return (EAttribute)db2TableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Table_Name1() {
		return (EAttribute)db2TableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Table_PartioningKey() {
		return (EAttribute)db2TableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Table_PartioningMethod() {
		return (EAttribute)db2TableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2TableSpace() {
		return db2TableSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_AutoResize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_DroppedTableRecovery() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_EventSize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_File() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_IncreaseSize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_ManagedBy() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_MaxSize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_Name1() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_Overhead() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_PageSize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_PrefetchSize() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_TransferRate() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2TableSpace_Type() {
		return (EAttribute)db2TableSpaceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2TableSpaceUnit() {
		return db2TableSpaceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2TableUnit() {
		return db2TableUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2User() {
		return db2UserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2User_Name1() {
		return (EAttribute)db2UserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2User_Password() {
		return (EAttribute)db2UserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2UserUnit() {
		return db2UserUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Db2highFactory getDb2highFactory() {
		return (Db2highFactory)getEFactoryInstance();
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
		db2BufferPoolEClass = createEClass(DB2_BUFFER_POOL);
		createEAttribute(db2BufferPoolEClass, DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED);
		createEAttribute(db2BufferPoolEClass, DB2_BUFFER_POOL__NAME1);
		createEAttribute(db2BufferPoolEClass, DB2_BUFFER_POOL__PAGE_SIZE);
		createEAttribute(db2BufferPoolEClass, DB2_BUFFER_POOL__SIZE);

		db2BufferPoolUnitEClass = createEClass(DB2_BUFFER_POOL_UNIT);

		db2ConstraintEClass = createEClass(DB2_CONSTRAINT);
		createEAttribute(db2ConstraintEClass, DB2_CONSTRAINT__NAME1);
		createEAttribute(db2ConstraintEClass, DB2_CONSTRAINT__VALUE);

		db2ConstraintUnitEClass = createEClass(DB2_CONSTRAINT_UNIT);

		db2FieldEClass = createEClass(DB2_FIELD);
		createEAttribute(db2FieldEClass, DB2_FIELD__NAME1);
		createEAttribute(db2FieldEClass, DB2_FIELD__NULL_ALLOWED);
		createEAttribute(db2FieldEClass, DB2_FIELD__TYPE);

		db2FieldUnitEClass = createEClass(DB2_FIELD_UNIT);

		db2HighRootEClass = createEClass(DB2_HIGH_ROOT);
		createEAttribute(db2HighRootEClass, DB2_HIGH_ROOT__MIXED);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__XMLNS_PREFIX_MAP);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_FIELD);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_INDEX);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_PERMISSION);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_TABLE);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_USER);
		createEReference(db2HighRootEClass, DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT);

		db2IndexEClass = createEClass(DB2_INDEX);
		createEAttribute(db2IndexEClass, DB2_INDEX__FIELD);
		createEAttribute(db2IndexEClass, DB2_INDEX__NAME1);

		db2IndexUnitEClass = createEClass(DB2_INDEX_UNIT);

		db2ManagerEClass = createEClass(DB2_MANAGER);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AGENT_POOL_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AGENT_PRIORITY);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AGENT_STACK_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AUDIT_BUFFER_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AUTHENTICATION_TYPE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CLIENT_IO_BLOCK_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CLIENT_KERBEROS_PLUGIN);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__COMMUNICATIONS_BANDWIDTH);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CONNECTION_ELAPSE_TIME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__CPU_SPEED);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DEFAULT_DATABASE_PATH);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DIRECTORY_CACHE_SUPPORT);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DISCOVER_SERVER_INSTANCE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__DISCOVERY_MODE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__GROUP_PLUGIN);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__HEALTH_MONITORING);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__INDEX_RECREATION_TIME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__INSTANCE_IMPACT_POLICY);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__INSTANCE_MEMORY);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__KEEP_FENCED_PROCESS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__LOCAL_GSSAPI_PLUGIN);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MACHINE_NODE_TYPE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__NODE_CONNECTION_RETRIES);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__NOTIFY_LEVEL);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__NUMBER_OF_FCM_BUFFERS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__NUMBER_OF_FCM_CHANNELS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__QUERY_HEAP_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SERVER_PLUGIN_MODE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SORT_HEAP_THRESHOLD);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__START_AND_STOP_TIMEOUT);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYNC_POINT_MANAGER_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TCPIP_SERVICE_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TRUST_ALL_CLIENTS);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION);
		createEAttribute(db2ManagerEClass, DB2_MANAGER__USERID_PASSWORD_PLUG_IN);

		db2ManagerUnitEClass = createEClass(DB2_MANAGER_UNIT);

		db2PartitionGroupEClass = createEClass(DB2_PARTITION_GROUP);
		createEAttribute(db2PartitionGroupEClass, DB2_PARTITION_GROUP__NAME1);

		db2PartitionGroupUnitEClass = createEClass(DB2_PARTITION_GROUP_UNIT);

		db2PermissionEClass = createEClass(DB2_PERMISSION);
		createEAttribute(db2PermissionEClass, DB2_PERMISSION__OBJECT);
		createEAttribute(db2PermissionEClass, DB2_PERMISSION__TYPE);

		db2PermissionUnitEClass = createEClass(DB2_PERMISSION_UNIT);

		db2TableEClass = createEClass(DB2_TABLE);
		createEAttribute(db2TableEClass, DB2_TABLE__ALIAS);
		createEAttribute(db2TableEClass, DB2_TABLE__INDEX_TABLE_SPACE);
		createEAttribute(db2TableEClass, DB2_TABLE__NAME1);
		createEAttribute(db2TableEClass, DB2_TABLE__PARTIONING_KEY);
		createEAttribute(db2TableEClass, DB2_TABLE__PARTIONING_METHOD);

		db2TableSpaceEClass = createEClass(DB2_TABLE_SPACE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__AUTO_RESIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__EVENT_SIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__FILE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__INCREASE_SIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__MANAGED_BY);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__MAX_SIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__NAME1);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__OVERHEAD);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__PAGE_SIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__PREFETCH_SIZE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__TRANSFER_RATE);
		createEAttribute(db2TableSpaceEClass, DB2_TABLE_SPACE__TYPE);

		db2TableSpaceUnitEClass = createEClass(DB2_TABLE_SPACE_UNIT);

		db2TableUnitEClass = createEClass(DB2_TABLE_UNIT);

		db2UserEClass = createEClass(DB2_USER);
		createEAttribute(db2UserEClass, DB2_USER__NAME1);
		createEAttribute(db2UserEClass, DB2_USER__PASSWORD);

		db2UserUnitEClass = createEClass(DB2_USER_UNIT);
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

		// Add supertypes to classes
		db2BufferPoolEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2BufferPoolUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2ConstraintEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2ConstraintUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2FieldEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2FieldUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2IndexEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2IndexUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2ManagerEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2ManagerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2PartitionGroupEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2PartitionGroupUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2PermissionEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2PermissionUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2TableEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2TableSpaceEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2TableSpaceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2TableUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2UserEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2UserUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(db2BufferPoolEClass, DB2BufferPool.class, "DB2BufferPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2BufferPool_ImmediateOrDeferred(), theXMLTypePackage.getString(), "immediateOrDeferred", null, 0, 1, DB2BufferPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2BufferPool_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2BufferPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2BufferPool_PageSize(), theXMLTypePackage.getString(), "pageSize", null, 0, 1, DB2BufferPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2BufferPool_Size(), theXMLTypePackage.getString(), "size", null, 0, 1, DB2BufferPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2BufferPoolUnitEClass, DB2BufferPoolUnit.class, "DB2BufferPoolUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2ConstraintEClass, DB2Constraint.class, "DB2Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Constraint_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Constraint_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, DB2Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2ConstraintUnitEClass, DB2ConstraintUnit.class, "DB2ConstraintUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2FieldEClass, DB2Field.class, "DB2Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Field_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Field_NullAllowed(), theXMLTypePackage.getString(), "nullAllowed", null, 0, 1, DB2Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Field_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, DB2Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2FieldUnitEClass, DB2FieldUnit.class, "DB2FieldUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2HighRootEClass, DB2HighRoot.class, "DB2HighRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2HighRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_CapabilityDB2BufferPool(), this.getDB2BufferPool(), null, "capabilityDB2BufferPool", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_CapabilityDB2PartitionGroup(), this.getDB2PartitionGroup(), null, "capabilityDB2PartitionGroup", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_CapabilityDB2TableSpace(), this.getDB2TableSpace(), null, "capabilityDB2TableSpace", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_CapailityDB2Manager(), this.getDB2Manager(), null, "capailityDB2Manager", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2BufferPoolUnit(), this.getDB2BufferPoolUnit(), null, "unitDB2BufferPoolUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2Constraint(), this.getDB2Constraint(), null, "unitDB2Constraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2ConstraintUnit(), this.getDB2ConstraintUnit(), null, "unitDB2ConstraintUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2Field(), this.getDB2Field(), null, "unitDB2Field", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2FieldUnit(), this.getDB2FieldUnit(), null, "unitDB2FieldUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2Index(), this.getDB2Index(), null, "unitDB2Index", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2IndexUnit(), this.getDB2IndexUnit(), null, "unitDB2IndexUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2ManagerUnit(), this.getDB2ManagerUnit(), null, "unitDB2ManagerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2PartitionGroupUnit(), this.getDB2PartitionGroupUnit(), null, "unitDB2PartitionGroupUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2Permission(), this.getDB2Permission(), null, "unitDB2Permission", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2PermissionUnit(), this.getDB2PermissionUnit(), null, "unitDB2PermissionUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2Table(), this.getDB2Table(), null, "unitDB2Table", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2TableSpaceUnit(), this.getDB2TableSpaceUnit(), null, "unitDB2TableSpaceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2TableUnit(), this.getDB2TableUnit(), null, "unitDB2TableUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2User(), this.getDB2User(), null, "unitDB2User", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDB2HighRoot_UnitDB2UserUnit(), this.getDB2UserUnit(), null, "unitDB2UserUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2IndexEClass, DB2Index.class, "DB2Index", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Index_Field(), theXMLTypePackage.getString(), "field", null, 0, 1, DB2Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Index_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2IndexUnitEClass, DB2IndexUnit.class, "DB2IndexUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2ManagerEClass, DB2Manager.class, "DB2Manager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AgentPoolSize(), theXMLTypePackage.getString(), "agentPoolSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AgentPriority(), theXMLTypePackage.getString(), "agentPriority", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AgentStackSize(), theXMLTypePackage.getString(), "agentStackSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ApplicationSupportLayerHeapSize(), theXMLTypePackage.getString(), "applicationSupportLayerHeapSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AuditBufferSize(), theXMLTypePackage.getString(), "auditBufferSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AuthenticationType(), theXMLTypePackage.getString(), "authenticationType", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_AuthenticationTypeForIncomingConnections(), theXMLTypePackage.getString(), "authenticationTypeForIncomingConnections", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_BypassFederatedAuthentication(), theXMLTypePackage.getString(), "bypassFederatedAuthentication", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_CatalogingAllowedWithoutAuthority(), theXMLTypePackage.getString(), "catalogingAllowedWithoutAuthority", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ClientIOBlockSize(), theXMLTypePackage.getString(), "clientIOBlockSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ClientKerberosPlugin(), theXMLTypePackage.getString(), "clientKerberosPlugin", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ClientUseridPasswordPlugin(), theXMLTypePackage.getString(), "clientUseridPasswordPlugin", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_CommunicationsBandwidth(), theXMLTypePackage.getString(), "communicationsBandwidth", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ConfigurationFileReleaseLevel(), theXMLTypePackage.getString(), "configurationFileReleaseLevel", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ConnectionElapseTime(), theXMLTypePackage.getString(), "connectionElapseTime", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_CPUSpeed(), theXMLTypePackage.getString(), "cPUSpeed", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DatabaseSystemMonitorHeapSize(), theXMLTypePackage.getString(), "databaseSystemMonitorHeapSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DefaultChargeBackAccount(), theXMLTypePackage.getString(), "defaultChargeBackAccount", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DefaultDatabasePath(), theXMLTypePackage.getString(), "defaultDatabasePath", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DefaultDatabaseSystemMonitorSwitches(), theXMLTypePackage.getString(), "defaultDatabaseSystemMonitorSwitches", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DiagnosticDataDirectoryPath(), theXMLTypePackage.getString(), "diagnosticDataDirectoryPath", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DiagnosticErrorCaptureLevel(), theXMLTypePackage.getString(), "diagnosticErrorCaptureLevel", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DirectoryCacheSupport(), theXMLTypePackage.getString(), "directoryCacheSupport", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DiscoverServerInstance(), theXMLTypePackage.getString(), "discoverServerInstance", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_DiscoveryMode(), theXMLTypePackage.getString(), "discoveryMode", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_EnablePntrapartitionParallelism(), theXMLTypePackage.getString(), "enablePntrapartitionParallelism", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_FederatedDatabaseSystemSupport(), theXMLTypePackage.getString(), "federatedDatabaseSystemSupport", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_GroupPlugin(), theXMLTypePackage.getString(), "groupPlugin", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_HealthMonitoring(), theXMLTypePackage.getString(), "healthMonitoring", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_IndexRecreationTime(), theXMLTypePackage.getString(), "indexRecreationTime", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_InitialNumberOfAgentsInPool(), theXMLTypePackage.getString(), "initialNumberOfAgentsInPool", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_InitialNumberOfFencedProcesses(), theXMLTypePackage.getString(), "initialNumberOfFencedProcesses", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_InstanceImpactPolicy(), theXMLTypePackage.getString(), "instanceImpactPolicy", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_InstanceMemory(), theXMLTypePackage.getString(), "instanceMemory", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_KeepFencedProcess(), theXMLTypePackage.getString(), "keepFencedProcess", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections(), theXMLTypePackage.getString(), "listOfGSSAPIPluginsForIncomingConnections", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_LocalGSSAPIPlugin(), theXMLTypePackage.getString(), "localGSSAPIPlugin", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MachineNodeType(), theXMLTypePackage.getString(), "machineNodeType", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumAsynchronousTQsPerQuery(), theXMLTypePackage.getString(), "maximumAsynchronousTQsPerQuery", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumJavaInterpreterHeapSize(), theXMLTypePackage.getString(), "maximumJavaInterpreterHeapSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfAgents(), theXMLTypePackage.getString(), "maximumNumberOfAgents", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfClientConnections(), theXMLTypePackage.getString(), "maximumNumberOfClientConnections", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfConcurrentAgents(), theXMLTypePackage.getString(), "maximumNumberOfConcurrentAgents", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases(), theXMLTypePackage.getString(), "maximumNumberOfConcurrentlyActiveDatabases", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfCoordinatingAgents(), theXMLTypePackage.getString(), "maximumNumberOfCoordinatingAgents", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumNumberOfFencedProcesses(), theXMLTypePackage.getString(), "maximumNumberOfFencedProcesses", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumQueryDegreeOfParallelism(), theXMLTypePackage.getString(), "maximumQueryDegreeOfParallelism", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_MaximumTimeDifferenceAmongNodes(), theXMLTypePackage.getString(), "maximumTimeDifferenceAmongNodes", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_NodeConnectionRetries(), theXMLTypePackage.getString(), "nodeConnectionRetries", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_NotifyLevel(), theXMLTypePackage.getString(), "notifyLevel", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_NumberOfFCMBuffers(), theXMLTypePackage.getString(), "numberOfFCMBuffers", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_NumberOfFCMChannels(), theXMLTypePackage.getString(), "numberOfFCMChannels", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_QueryHeapSize(), theXMLTypePackage.getString(), "queryHeapSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_ServerPluginMode(), theXMLTypePackage.getString(), "serverPluginMode", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath(), theXMLTypePackage.getString(), "softwareDevelopersKitForJavaInstallationPath", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SortHeapThreshold(), theXMLTypePackage.getString(), "sortHeapThreshold", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_StartAndStopTimeout(), theXMLTypePackage.getString(), "startAndStopTimeout", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SyncPointManagerLogFilePath(), theXMLTypePackage.getString(), "syncPointManagerLogFilePath", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SyncPointManagerLogFileSize(), theXMLTypePackage.getString(), "syncPointManagerLogFileSize", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SyncPointManagerName(), theXMLTypePackage.getString(), "syncPointManagerName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SyncPointManagerResyncAgentLimit(), theXMLTypePackage.getString(), "syncPointManagerResyncAgentLimit", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SystemAdministrationAuthorityGroupName(), theXMLTypePackage.getString(), "systemAdministrationAuthorityGroupName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SystemControlAuthorityGroupName(), theXMLTypePackage.getString(), "systemControlAuthorityGroupName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SystemMaintenanceAuthorityGroupName(), theXMLTypePackage.getString(), "systemMaintenanceAuthorityGroupName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_SystemMonitorAuthorityGroupName(), theXMLTypePackage.getString(), "systemMonitorAuthorityGroupName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TCPIPServiceName(), theXMLTypePackage.getString(), "tCPIPServiceName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TransactionManagerDatabaseName(), theXMLTypePackage.getString(), "transactionManagerDatabaseName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TransactionProcessorMonitorName(), theXMLTypePackage.getString(), "transactionProcessorMonitorName", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TransactionResyncInterval(), theXMLTypePackage.getString(), "transactionResyncInterval", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TrustAllClients(), theXMLTypePackage.getString(), "trustAllClients", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_TrustedClientsAuthentication(), theXMLTypePackage.getString(), "trustedClientsAuthentication", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Manager_UseridPasswordPlugIn(), theXMLTypePackage.getString(), "useridPasswordPlugIn", null, 0, 1, DB2Manager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2ManagerUnitEClass, DB2ManagerUnit.class, "DB2ManagerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2PartitionGroupEClass, DB2PartitionGroup.class, "DB2PartitionGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2PartitionGroup_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2PartitionGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2PartitionGroupUnitEClass, DB2PartitionGroupUnit.class, "DB2PartitionGroupUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2PermissionEClass, DB2Permission.class, "DB2Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Permission_Object(), theXMLTypePackage.getString(), "object", null, 0, 1, DB2Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Permission_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, DB2Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2PermissionUnitEClass, DB2PermissionUnit.class, "DB2PermissionUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2TableEClass, DB2Table.class, "DB2Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Table_Alias(), theXMLTypePackage.getString(), "alias", null, 0, 1, DB2Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Table_IndexTableSpace(), theXMLTypePackage.getString(), "indexTableSpace", null, 0, 1, DB2Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Table_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Table_PartioningKey(), theXMLTypePackage.getString(), "partioningKey", null, 0, 1, DB2Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Table_PartioningMethod(), theXMLTypePackage.getString(), "partioningMethod", null, 0, 1, DB2Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2TableSpaceEClass, DB2TableSpace.class, "DB2TableSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_AutoResize(), theXMLTypePackage.getString(), "autoResize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_DroppedTableRecovery(), theXMLTypePackage.getString(), "droppedTableRecovery", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_EventSize(), theXMLTypePackage.getString(), "eventSize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_File(), theXMLTypePackage.getString(), "file", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_IncreaseSize(), theXMLTypePackage.getString(), "increaseSize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_ManagedBy(), theXMLTypePackage.getString(), "managedBy", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_MaxSize(), theXMLTypePackage.getString(), "maxSize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_Overhead(), theXMLTypePackage.getString(), "overhead", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_PageSize(), theXMLTypePackage.getString(), "pageSize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_PrefetchSize(), theXMLTypePackage.getString(), "prefetchSize", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_TransferRate(), theXMLTypePackage.getString(), "transferRate", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2TableSpace_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, DB2TableSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2TableSpaceUnitEClass, DB2TableSpaceUnit.class, "DB2TableSpaceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2TableUnitEClass, DB2TableUnit.class, "DB2TableUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2UserEClass, DB2User.class, "DB2User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2User_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, DB2User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2User_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, DB2User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2UserUnitEClass, DB2UserUnit.class, "DB2UserUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (db2BufferPoolEClass, 
		   source, 
		   new String[] {
			 "name", "DB2BufferPool", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2BufferPool_ImmediateOrDeferred(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ImmediateOrDeferred" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2BufferPool_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2BufferPool_PageSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PageSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2BufferPool_Size(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Size" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2BufferPoolUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2BufferPoolUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Constraint_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Constraint_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Value" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ConstraintUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2ConstraintUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2FieldEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Field", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Field_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Field_NullAllowed(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NullAllowed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Field_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2FieldUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2FieldUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2HighRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_CapabilityDB2BufferPool(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.DB2BufferPool", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_CapabilityDB2PartitionGroup(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.DB2PartitionGroup", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_CapabilityDB2TableSpace(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.DB2TableSpace", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_CapailityDB2Manager(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capaility.DB2Manager", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2BufferPoolUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2BufferPoolUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2Constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2ConstraintUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2ConstraintUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2Field(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2Field", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2FieldUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2FieldUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2Index(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2Index", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2IndexUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2IndexUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2ManagerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2ManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2PartitionGroupUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2PartitionGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2Permission(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2Permission", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2PermissionUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2PermissionUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2Table(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2Table", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2TableSpaceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2TableSpaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2TableUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2TableUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2User(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2User", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2HighRoot_UnitDB2UserUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.DB2UserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2IndexEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Index", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Index_Field(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Field" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Index_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2IndexUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2IndexUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ManagerEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Manager", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AgentPoolSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AgentPoolSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AgentPriority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AgentPriority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AgentStackSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AgentStackSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ApplicationSupportLayerHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ApplicationSupportLayerHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AuditBufferSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AuditBufferSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AuthenticationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AuthenticationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_AuthenticationTypeForIncomingConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AuthenticationTypeForIncomingConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_BypassFederatedAuthentication(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "BypassFederatedAuthentication" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_CatalogingAllowedWithoutAuthority(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CatalogingAllowedWithoutAuthority" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ClientIOBlockSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientIOBlockSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ClientKerberosPlugin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientKerberosPlugin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ClientUseridPasswordPlugin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ClientUseridPasswordPlugin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_CommunicationsBandwidth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CommunicationsBandwidth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ConfigurationFileReleaseLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ConfigurationFileReleaseLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ConnectionElapseTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ConnectionElapseTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_CPUSpeed(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CPUSpeed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DatabaseSystemMonitorHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DatabaseSystemMonitorHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DefaultChargeBackAccount(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultChargeBackAccount" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DefaultDatabasePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultDatabasePath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DefaultDatabaseSystemMonitorSwitches(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DefaultDatabaseSystemMonitorSwitches" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DiagnosticDataDirectoryPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DiagnosticDataDirectoryPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DiagnosticErrorCaptureLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DiagnosticErrorCaptureLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DirectoryCacheSupport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DirectoryCacheSupport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DiscoverServerInstance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DiscoverServerInstance" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_DiscoveryMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DiscoveryMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_EnablePntrapartitionParallelism(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EnablePntrapartitionParallelism" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_FederatedDatabaseSystemSupport(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "FederatedDatabaseSystemSupport" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_GroupPlugin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "GroupPlugin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_HealthMonitoring(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "HealthMonitoring" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_IndexRecreationTime(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IndexRecreationTime" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_InitialNumberOfAgentsInPool(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InitialNumberOfAgentsInPool" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_InitialNumberOfFencedProcesses(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InitialNumberOfFencedProcesses" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_InstanceImpactPolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstanceImpactPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_InstanceMemory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "InstanceMemory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_KeepFencedProcess(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "KeepFencedProcess" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ListOfGSSAPIPluginsForIncomingConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_LocalGSSAPIPlugin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "LocalGSSAPIPlugin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MachineNodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MachineNodeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumAsynchronousTQsPerQuery(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumAsynchronousTQsPerQuery" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumJavaInterpreterHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumJavaInterpreterHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfAgents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfAgents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfClientConnections(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfClientConnections" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfConcurrentAgents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfConcurrentAgents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfConcurrentlyActiveDatabases" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfCoordinatingAgents(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfCoordinatingAgents" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumNumberOfFencedProcesses(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumNumberOfFencedProcesses" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumQueryDegreeOfParallelism(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumQueryDegreeOfParallelism" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_MaximumTimeDifferenceAmongNodes(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaximumTimeDifferenceAmongNodes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_NodeConnectionRetries(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NodeConnectionRetries" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_NotifyLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NotifyLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_NumberOfFCMBuffers(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NumberOfFCMBuffers" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_NumberOfFCMChannels(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "NumberOfFCMChannels" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_QueryHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "QueryHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_ServerPluginMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ServerPluginMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SoftwareDevelopersKitForJavaInstallationPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SortHeapThreshold(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SortHeapThreshold" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_StartAndStopTimeout(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "StartAndStopTimeout" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SyncPointManagerLogFilePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SyncPointManagerLogFilePath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SyncPointManagerLogFileSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SyncPointManagerLogFileSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SyncPointManagerName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SyncPointManagerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SyncPointManagerResyncAgentLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SyncPointManagerResyncAgentLimit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SystemAdministrationAuthorityGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemAdministrationAuthorityGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SystemControlAuthorityGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemControlAuthorityGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SystemMaintenanceAuthorityGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemMaintenanceAuthorityGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_SystemMonitorAuthorityGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "SystemMonitorAuthorityGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TCPIPServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TCPIPServiceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TransactionManagerDatabaseName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransactionManagerDatabaseName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TransactionProcessorMonitorName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransactionProcessorMonitorName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TransactionResyncInterval(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransactionResyncInterval" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TrustAllClients(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TrustAllClients" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_TrustedClientsAuthentication(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TrustedClientsAuthentication" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Manager_UseridPasswordPlugIn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UseridPasswordPlugIn" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ManagerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2ManagerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2PartitionGroupEClass, 
		   source, 
		   new String[] {
			 "name", "DB2PartitionGroup", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2PartitionGroup_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2PartitionGroupUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2PartitionGroupUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2PermissionEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Permission", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Permission_Object(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Object" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Permission_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2PermissionUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2PermissionUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2TableEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Table", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Table_Alias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Alias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Table_IndexTableSpace(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IndexTableSpace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Table_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Table_PartioningKey(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PartioningKey" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Table_PartioningMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PartioningMethod" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2TableSpaceEClass, 
		   source, 
		   new String[] {
			 "name", "DB2TableSpace", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_AutoResize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "AutoResize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_DroppedTableRecovery(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "DroppedTableRecovery" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_EventSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "EventSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_File(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "File" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_IncreaseSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "IncreaseSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_ManagedBy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ManagedBy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_MaxSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MaxSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_Overhead(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Overhead" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_PageSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PageSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_PrefetchSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PrefetchSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_TransferRate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "TransferRate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2TableSpace_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2TableSpaceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2TableSpaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2TableUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2TableUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2UserEClass, 
		   source, 
		   new String[] {
			 "name", "DB2User", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2User_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2User_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2UserUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2UserUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //Db2highPackageImpl
