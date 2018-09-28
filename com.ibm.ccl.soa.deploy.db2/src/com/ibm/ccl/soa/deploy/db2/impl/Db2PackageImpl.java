/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

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
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClient;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseInstance;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2DeployRoot;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.PageSizeType;
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2System;
import com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2System;
import com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WordWidthType;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class Db2PackageImpl extends EPackageImpl implements Db2Package {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AdminClientEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AdminClientUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AdminServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AdminServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AppDevelClientEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2AppDevelClientUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2BaseClientUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2BaseInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2CatalogedNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2CatalogUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ClientEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ClientInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2ClientInstanceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2DatabaseEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2DatabaseUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2DDLArtifactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2DeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2InstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2InstanceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2JdbcDriverEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2NodeCatalogUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2RuntimeClientUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2SystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass db2SystemUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixDB2AdminServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixDB2ClientInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixDB2InstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unixDB2SystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsDB2AdminServerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsDB2ClientInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsDB2InstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowsDB2SystemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum authenticationTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum db2InstancePortNamesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pageSizeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unixInstanceTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowsInstanceTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum wordWidthTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType authenticationTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType db2InstancePortNamesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType pageSizeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unixInstanceTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType windowsInstanceTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType wordWidthTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Db2PackageImpl() {
		super(eNS_URI, Db2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Db2Package init() {
		if (isInited) return (Db2Package)EPackage.Registry.INSTANCE.getEPackage(Db2Package.eNS_URI);

		// Obtain or create and register package
		Db2PackageImpl theDb2Package = (Db2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Db2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Db2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DatabasePackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		JavaPackage.eINSTANCE.eClass();
		OsPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDb2Package.createPackageContents();

		// Initialize created meta-data
		theDb2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDb2Package.freeze();

		return theDb2Package;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AdminClient() {
		return db2AdminClientEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2AdminClient_Db2ProductLang() {
		return (EAttribute)db2AdminClientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AdminClientUnit() {
		return db2AdminClientUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AdminServer() {
		return db2AdminServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AdminServerUnit() {
		return db2AdminServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AppDevelClient() {
		return db2AppDevelClientEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2AppDevelClient_Db2ProductLang() {
		return (EAttribute)db2AppDevelClientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2AppDevelClientUnit() {
		return db2AppDevelClientUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2BaseClientUnit() {
		return db2BaseClientUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2BaseInstance() {
		return db2BaseInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BaseInstance_Db2InstanceName() {
		return (EAttribute)db2BaseInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2BaseInstance_Db2Version() {
		return (EAttribute)db2BaseInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2CatalogedNode() {
		return db2CatalogedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2CatalogedNode_DasLevel() {
		return (EAttribute)db2CatalogedNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2CatalogedNode_Hostname() {
		return (EAttribute)db2CatalogedNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2CatalogedNode_NodeName() {
		return (EAttribute)db2CatalogedNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2CatalogedNode_NodeType() {
		return (EAttribute)db2CatalogedNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2CatalogedNode_Port() {
		return (EAttribute)db2CatalogedNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2CatalogUnit() {
		return db2CatalogUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Client() {
		return db2ClientEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Client_Db2ClientVersion() {
		return (EAttribute)db2ClientEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Client_InstallDir() {
		return (EAttribute)db2ClientEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2ClientInstance() {
		return db2ClientInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2ClientInstanceUnit() {
		return db2ClientInstanceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Database() {
		return db2DatabaseEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_CatalogSp() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_CodeSet() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_CreatePath() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_Db2Version() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_DbAlias() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_DbDrive() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_DbName() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_DftExtentSize() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_PageSize() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_TempSp() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_Territory() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Database_UserSp() {
		return (EAttribute)db2DatabaseEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2DatabaseUnit() {
		return db2DatabaseUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2DDLArtifact() {
		return db2DDLArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDb2DeployRoot() {
		return db2DeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDb2DeployRoot_Mixed() {
		return (EAttribute)db2DeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_XMLNSPrefixMap() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_XSISchemaLocation() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2AdminClient() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2AdminServer() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2AppDevelClient() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2BaseInstance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2CatalogedNode() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2Client() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2ClientInstance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2Database() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2Instance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2JdbcDriver() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityDb2System() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityUnixDb2AdminServer() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityUnixDb2ClientInstance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityUnixDb2Instance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityUnixDb2System() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityWindowsDb2AdminServer() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityWindowsDb2ClientInstance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityWindowsDb2Instance() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_CapabilityWindowsDb2System() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2AdminClientUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2AdminServerUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2AppDevelClientUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2BaseClientUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2CatalogUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2ClientInstanceUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2DatabaseUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2ddl() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2InstanceUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2NodeCatalogUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2RuntimeClientUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDb2DeployRoot_UnitDb2SystemUnit() {
		return (EReference)db2DeployRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2Instance() {
		return db2InstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Instance_AutoStart() {
		return (EAttribute)db2InstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Instance_Hostname() {
		return (EAttribute)db2InstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Instance_Password() {
		return (EAttribute)db2InstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Instance_Port() {
		return (EAttribute)db2InstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2Instance_Username() {
		return (EAttribute)db2InstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2InstanceUnit() {
		return db2InstanceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2JdbcDriver() {
		return db2JdbcDriverEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcDriver_Classname() {
		return (EAttribute)db2JdbcDriverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcDriver_Classpath() {
		return (EAttribute)db2JdbcDriverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcDriver_DriverPath() {
		return (EAttribute)db2JdbcDriverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2JdbcDriver_JdbcType() {
		return (EAttribute)db2JdbcDriverEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2NodeCatalogUnit() {
		return db2NodeCatalogUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2RuntimeClientUnit() {
		return db2RuntimeClientUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2System() {
		return db2SystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2System_Db2ProductLang() {
		return (EAttribute)db2SystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2System_Db2Version() {
		return (EAttribute)db2SystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDB2System_InstallDir() {
		return (EAttribute)db2SystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDB2SystemUnit() {
		return db2SystemUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixDB2AdminServer() {
		return unixDB2AdminServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2AdminServer_DasGID() {
		return (EAttribute)unixDB2AdminServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2AdminServer_DasGroupName() {
		return (EAttribute)unixDB2AdminServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2AdminServer_DasUID() {
		return (EAttribute)unixDB2AdminServerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2AdminServer_DasUserName() {
		return (EAttribute)unixDB2AdminServerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2AdminServer_DasUserPassword() {
		return (EAttribute)unixDB2AdminServerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixDB2ClientInstance() {
		return unixDB2ClientInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_AuthenticationType() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_FencedGID() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_FencedGroupName() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_FencedUID() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_FencedUserName() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_FencedUserPassword() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_GID() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_GroupName() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_InstanceType() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_Password() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_UID() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_Username() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2ClientInstance_WordWidth() {
		return (EAttribute)unixDB2ClientInstanceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixDB2Instance() {
		return unixDB2InstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_AuthenticationType() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_FencedGID() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_FencedGroupName() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_FencedUID() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_FencedUserName() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_FencedUserPassword() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_GID() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_GroupName() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_InstanceType() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_UID() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnixDB2Instance_WordWidth() {
		return (EAttribute)unixDB2InstanceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnixDB2System() {
		return unixDB2SystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsDB2AdminServer() {
		return windowsDB2AdminServerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2AdminServer_DasDomain() {
		return (EAttribute)windowsDB2AdminServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsDB2ClientInstance() {
		return windowsDB2ClientInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2ClientInstance_DefaultInstance() {
		return (EAttribute)windowsDB2ClientInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2ClientInstance_InstanceType() {
		return (EAttribute)windowsDB2ClientInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsDB2Instance() {
		return windowsDB2InstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2Instance_DefaultInstance() {
		return (EAttribute)windowsDB2InstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2Instance_InstanceType() {
		return (EAttribute)windowsDB2InstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindowsDB2System() {
		return windowsDB2SystemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2System_AdminGroupName() {
		return (EAttribute)windowsDB2SystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2System_ExtendedSecurity() {
		return (EAttribute)windowsDB2SystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindowsDB2System_UserGroupName() {
		return (EAttribute)windowsDB2SystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAuthenticationTypeType() {
		return authenticationTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDB2InstancePortNames() {
		return db2InstancePortNamesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPageSizeType() {
		return pageSizeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnixInstanceTypeType() {
		return unixInstanceTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWindowsInstanceTypeType() {
		return windowsInstanceTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getWordWidthType() {
		return wordWidthTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAuthenticationTypeTypeObject() {
		return authenticationTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDB2InstancePortNamesObject() {
		return db2InstancePortNamesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPageSizeTypeObject() {
		return pageSizeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUnixInstanceTypeTypeObject() {
		return unixInstanceTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWindowsInstanceTypeTypeObject() {
		return windowsInstanceTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getWordWidthTypeObject() {
		return wordWidthTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2Factory getDb2Factory() {
		return (Db2Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		db2AdminClientEClass = createEClass(DB2_ADMIN_CLIENT);
		createEAttribute(db2AdminClientEClass, DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG);

		db2AdminClientUnitEClass = createEClass(DB2_ADMIN_CLIENT_UNIT);

		db2AdminServerEClass = createEClass(DB2_ADMIN_SERVER);

		db2AdminServerUnitEClass = createEClass(DB2_ADMIN_SERVER_UNIT);

		db2AppDevelClientEClass = createEClass(DB2_APP_DEVEL_CLIENT);
		createEAttribute(db2AppDevelClientEClass, DB2_APP_DEVEL_CLIENT__DB2_PRODUCT_LANG);

		db2AppDevelClientUnitEClass = createEClass(DB2_APP_DEVEL_CLIENT_UNIT);

		db2BaseClientUnitEClass = createEClass(DB2_BASE_CLIENT_UNIT);

		db2BaseInstanceEClass = createEClass(DB2_BASE_INSTANCE);
		createEAttribute(db2BaseInstanceEClass, DB2_BASE_INSTANCE__DB2_INSTANCE_NAME);
		createEAttribute(db2BaseInstanceEClass, DB2_BASE_INSTANCE__DB2_VERSION);

		db2CatalogedNodeEClass = createEClass(DB2_CATALOGED_NODE);
		createEAttribute(db2CatalogedNodeEClass, DB2_CATALOGED_NODE__DAS_LEVEL);
		createEAttribute(db2CatalogedNodeEClass, DB2_CATALOGED_NODE__HOSTNAME);
		createEAttribute(db2CatalogedNodeEClass, DB2_CATALOGED_NODE__NODE_NAME);
		createEAttribute(db2CatalogedNodeEClass, DB2_CATALOGED_NODE__NODE_TYPE);
		createEAttribute(db2CatalogedNodeEClass, DB2_CATALOGED_NODE__PORT);

		db2CatalogUnitEClass = createEClass(DB2_CATALOG_UNIT);

		db2ClientEClass = createEClass(DB2_CLIENT);
		createEAttribute(db2ClientEClass, DB2_CLIENT__DB2_CLIENT_VERSION);
		createEAttribute(db2ClientEClass, DB2_CLIENT__INSTALL_DIR);

		db2ClientInstanceEClass = createEClass(DB2_CLIENT_INSTANCE);

		db2ClientInstanceUnitEClass = createEClass(DB2_CLIENT_INSTANCE_UNIT);

		db2DatabaseEClass = createEClass(DB2_DATABASE);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__CATALOG_SP);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__CODE_SET);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__CREATE_PATH);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__DB2_VERSION);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__DB_ALIAS);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__DB_DRIVE);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__DB_NAME);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__DFT_EXTENT_SIZE);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__PAGE_SIZE);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__TEMP_SP);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__TERRITORY);
		createEAttribute(db2DatabaseEClass, DB2_DATABASE__USER_SP);

		db2DatabaseUnitEClass = createEClass(DB2_DATABASE_UNIT);

		db2DDLArtifactEClass = createEClass(DB2DDL_ARTIFACT);

		db2DeployRootEClass = createEClass(DB2_DEPLOY_ROOT);
		createEAttribute(db2DeployRootEClass, DB2_DEPLOY_ROOT__MIXED);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2DDL);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT);
		createEReference(db2DeployRootEClass, DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT);

		db2InstanceEClass = createEClass(DB2_INSTANCE);
		createEAttribute(db2InstanceEClass, DB2_INSTANCE__AUTO_START);
		createEAttribute(db2InstanceEClass, DB2_INSTANCE__HOSTNAME);
		createEAttribute(db2InstanceEClass, DB2_INSTANCE__PASSWORD);
		createEAttribute(db2InstanceEClass, DB2_INSTANCE__PORT);
		createEAttribute(db2InstanceEClass, DB2_INSTANCE__USERNAME);

		db2InstanceUnitEClass = createEClass(DB2_INSTANCE_UNIT);

		db2JdbcDriverEClass = createEClass(DB2_JDBC_DRIVER);
		createEAttribute(db2JdbcDriverEClass, DB2_JDBC_DRIVER__CLASSNAME);
		createEAttribute(db2JdbcDriverEClass, DB2_JDBC_DRIVER__CLASSPATH);
		createEAttribute(db2JdbcDriverEClass, DB2_JDBC_DRIVER__DRIVER_PATH);
		createEAttribute(db2JdbcDriverEClass, DB2_JDBC_DRIVER__JDBC_TYPE);

		db2NodeCatalogUnitEClass = createEClass(DB2_NODE_CATALOG_UNIT);

		db2RuntimeClientUnitEClass = createEClass(DB2_RUNTIME_CLIENT_UNIT);

		db2SystemEClass = createEClass(DB2_SYSTEM);
		createEAttribute(db2SystemEClass, DB2_SYSTEM__DB2_PRODUCT_LANG);
		createEAttribute(db2SystemEClass, DB2_SYSTEM__DB2_VERSION);
		createEAttribute(db2SystemEClass, DB2_SYSTEM__INSTALL_DIR);

		db2SystemUnitEClass = createEClass(DB2_SYSTEM_UNIT);

		unixDB2AdminServerEClass = createEClass(UNIX_DB2_ADMIN_SERVER);
		createEAttribute(unixDB2AdminServerEClass, UNIX_DB2_ADMIN_SERVER__DAS_GID);
		createEAttribute(unixDB2AdminServerEClass, UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME);
		createEAttribute(unixDB2AdminServerEClass, UNIX_DB2_ADMIN_SERVER__DAS_UID);
		createEAttribute(unixDB2AdminServerEClass, UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME);
		createEAttribute(unixDB2AdminServerEClass, UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD);

		unixDB2ClientInstanceEClass = createEClass(UNIX_DB2_CLIENT_INSTANCE);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__FENCED_GID);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__FENCED_UID);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__GID);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__PASSWORD);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__UID);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__USERNAME);
		createEAttribute(unixDB2ClientInstanceEClass, UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH);

		unixDB2InstanceEClass = createEClass(UNIX_DB2_INSTANCE);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__AUTHENTICATION_TYPE);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__FENCED_GID);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__FENCED_GROUP_NAME);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__FENCED_UID);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__FENCED_USER_NAME);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__FENCED_USER_PASSWORD);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__GID);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__GROUP_NAME);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__INSTANCE_TYPE);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__UID);
		createEAttribute(unixDB2InstanceEClass, UNIX_DB2_INSTANCE__WORD_WIDTH);

		unixDB2SystemEClass = createEClass(UNIX_DB2_SYSTEM);

		windowsDB2AdminServerEClass = createEClass(WINDOWS_DB2_ADMIN_SERVER);
		createEAttribute(windowsDB2AdminServerEClass, WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN);

		windowsDB2ClientInstanceEClass = createEClass(WINDOWS_DB2_CLIENT_INSTANCE);
		createEAttribute(windowsDB2ClientInstanceEClass, WINDOWS_DB2_CLIENT_INSTANCE__DEFAULT_INSTANCE);
		createEAttribute(windowsDB2ClientInstanceEClass, WINDOWS_DB2_CLIENT_INSTANCE__INSTANCE_TYPE);

		windowsDB2InstanceEClass = createEClass(WINDOWS_DB2_INSTANCE);
		createEAttribute(windowsDB2InstanceEClass, WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE);
		createEAttribute(windowsDB2InstanceEClass, WINDOWS_DB2_INSTANCE__INSTANCE_TYPE);

		windowsDB2SystemEClass = createEClass(WINDOWS_DB2_SYSTEM);
		createEAttribute(windowsDB2SystemEClass, WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME);
		createEAttribute(windowsDB2SystemEClass, WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY);
		createEAttribute(windowsDB2SystemEClass, WINDOWS_DB2_SYSTEM__USER_GROUP_NAME);

		// Create enums
		authenticationTypeTypeEEnum = createEEnum(AUTHENTICATION_TYPE_TYPE);
		db2InstancePortNamesEEnum = createEEnum(DB2_INSTANCE_PORT_NAMES);
		pageSizeTypeEEnum = createEEnum(PAGE_SIZE_TYPE);
		unixInstanceTypeTypeEEnum = createEEnum(UNIX_INSTANCE_TYPE_TYPE);
		windowsInstanceTypeTypeEEnum = createEEnum(WINDOWS_INSTANCE_TYPE_TYPE);
		wordWidthTypeEEnum = createEEnum(WORD_WIDTH_TYPE);

		// Create data types
		authenticationTypeTypeObjectEDataType = createEDataType(AUTHENTICATION_TYPE_TYPE_OBJECT);
		db2InstancePortNamesObjectEDataType = createEDataType(DB2_INSTANCE_PORT_NAMES_OBJECT);
		pageSizeTypeObjectEDataType = createEDataType(PAGE_SIZE_TYPE_OBJECT);
		unixInstanceTypeTypeObjectEDataType = createEDataType(UNIX_INSTANCE_TYPE_TYPE_OBJECT);
		windowsInstanceTypeTypeObjectEDataType = createEDataType(WINDOWS_INSTANCE_TYPE_TYPE_OBJECT);
		wordWidthTypeObjectEDataType = createEDataType(WORD_WIDTH_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		DatabasePackage theDatabasePackage = (DatabasePackage)EPackage.Registry.INSTANCE.getEPackage(DatabasePackage.eNS_URI);
		OsPackage theOsPackage = (OsPackage)EPackage.Registry.INSTANCE.getEPackage(OsPackage.eNS_URI);
		JavaPackage theJavaPackage = (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);

		// Add supertypes to classes
		db2AdminClientEClass.getESuperTypes().add(this.getDB2Client());
		db2AdminClientUnitEClass.getESuperTypes().add(this.getDB2BaseClientUnit());
		db2AdminServerEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2AdminServerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2AppDevelClientEClass.getESuperTypes().add(this.getDB2Client());
		db2AppDevelClientUnitEClass.getESuperTypes().add(this.getDB2BaseClientUnit());
		db2BaseClientUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2BaseInstanceEClass.getESuperTypes().add(theDatabasePackage.getDatabaseInstance());
		db2CatalogedNodeEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2CatalogUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2ClientEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2ClientInstanceEClass.getESuperTypes().add(this.getDB2BaseInstance());
		db2ClientInstanceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2DatabaseEClass.getESuperTypes().add(theDatabasePackage.getDatabase());
		db2DatabaseUnitEClass.getESuperTypes().add(theDatabasePackage.getDatabaseUnit());
		db2DDLArtifactEClass.getESuperTypes().add(theDatabasePackage.getDDLArtifact());
		db2InstanceEClass.getESuperTypes().add(this.getDB2BaseInstance());
		db2InstanceUnitEClass.getESuperTypes().add(theDatabasePackage.getDatabaseInstanceUnit());
		db2JdbcDriverEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2NodeCatalogUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		db2RuntimeClientUnitEClass.getESuperTypes().add(this.getDB2BaseClientUnit());
		db2SystemEClass.getESuperTypes().add(theCorePackage.getCapability());
		db2SystemUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		unixDB2AdminServerEClass.getESuperTypes().add(this.getDB2AdminServer());
		unixDB2ClientInstanceEClass.getESuperTypes().add(this.getDB2ClientInstance());
		unixDB2InstanceEClass.getESuperTypes().add(this.getDB2Instance());
		unixDB2SystemEClass.getESuperTypes().add(this.getDB2System());
		windowsDB2AdminServerEClass.getESuperTypes().add(this.getDB2AdminServer());
		windowsDB2ClientInstanceEClass.getESuperTypes().add(this.getDB2ClientInstance());
		windowsDB2InstanceEClass.getESuperTypes().add(this.getDB2Instance());
		windowsDB2SystemEClass.getESuperTypes().add(this.getDB2System());

		// Initialize classes and features; add operations and parameters
		initEClass(db2AdminClientEClass, DB2AdminClient.class, "DB2AdminClient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2AdminClient_Db2ProductLang(), theXMLTypePackage.getString(), "db2ProductLang", null, 0, 1, DB2AdminClient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2AdminClientUnitEClass, DB2AdminClientUnit.class, "DB2AdminClientUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2AdminServerEClass, DB2AdminServer.class, "DB2AdminServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2AdminServerUnitEClass, DB2AdminServerUnit.class, "DB2AdminServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2AppDevelClientEClass, DB2AppDevelClient.class, "DB2AppDevelClient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2AppDevelClient_Db2ProductLang(), theXMLTypePackage.getString(), "db2ProductLang", null, 0, 1, DB2AppDevelClient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2AppDevelClientUnitEClass, DB2AppDevelClientUnit.class, "DB2AppDevelClientUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2BaseClientUnitEClass, DB2BaseClientUnit.class, "DB2BaseClientUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2BaseInstanceEClass, DB2BaseInstance.class, "DB2BaseInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2BaseInstance_Db2InstanceName(), theXMLTypePackage.getString(), "db2InstanceName", null, 0, 1, DB2BaseInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2BaseInstance_Db2Version(), theCorePackage.getVersionString(), "db2Version", null, 0, 1, DB2BaseInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2CatalogedNodeEClass, DB2CatalogedNode.class, "DB2CatalogedNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2CatalogedNode_DasLevel(), theXMLTypePackage.getString(), "dasLevel", null, 0, 1, DB2CatalogedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2CatalogedNode_Hostname(), theXMLTypePackage.getString(), "hostname", null, 0, 1, DB2CatalogedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2CatalogedNode_NodeName(), theXMLTypePackage.getString(), "nodeName", null, 0, 1, DB2CatalogedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2CatalogedNode_NodeType(), theXMLTypePackage.getString(), "nodeType", null, 0, 1, DB2CatalogedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2CatalogedNode_Port(), theXMLTypePackage.getInteger(), "port", null, 0, 1, DB2CatalogedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2CatalogUnitEClass, DB2CatalogUnit.class, "DB2CatalogUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2ClientEClass, DB2Client.class, "DB2Client", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Client_Db2ClientVersion(), theCorePackage.getVersionString(), "db2ClientVersion", null, 0, 1, DB2Client.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Client_InstallDir(), theXMLTypePackage.getString(), "installDir", null, 0, 1, DB2Client.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2ClientInstanceEClass, DB2ClientInstance.class, "DB2ClientInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2ClientInstanceUnitEClass, DB2ClientInstanceUnit.class, "DB2ClientInstanceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2DatabaseEClass, DB2Database.class, "DB2Database", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Database_CatalogSp(), theXMLTypePackage.getString(), "catalogSp", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_CodeSet(), theXMLTypePackage.getString(), "codeSet", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_CreatePath(), theXMLTypePackage.getString(), "createPath", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_Db2Version(), theCorePackage.getVersionString(), "db2Version", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_DbAlias(), theXMLTypePackage.getString(), "dbAlias", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_DbDrive(), theXMLTypePackage.getString(), "dbDrive", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_DbName(), theXMLTypePackage.getString(), "dbName", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_DftExtentSize(), theXMLTypePackage.getInteger(), "dftExtentSize", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_PageSize(), this.getPageSizeType(), "pageSize", "4096", 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDB2Database_TempSp(), theXMLTypePackage.getString(), "tempSp", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_Territory(), theXMLTypePackage.getString(), "territory", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Database_UserSp(), theXMLTypePackage.getString(), "userSp", null, 0, 1, DB2Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2DatabaseUnitEClass, DB2DatabaseUnit.class, "DB2DatabaseUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2DDLArtifactEClass, DB2DDLArtifact.class, "DB2DDLArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2DeployRootEClass, Db2DeployRoot.class, "Db2DeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDb2DeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2AdminClient(), this.getDB2AdminClient(), null, "capabilityDb2AdminClient", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2AdminServer(), this.getDB2AdminServer(), null, "capabilityDb2AdminServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2AppDevelClient(), this.getDB2AppDevelClient(), null, "capabilityDb2AppDevelClient", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2BaseInstance(), this.getDB2BaseInstance(), null, "capabilityDb2BaseInstance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2CatalogedNode(), this.getDB2CatalogedNode(), null, "capabilityDb2CatalogedNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2Client(), this.getDB2Client(), null, "capabilityDb2Client", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2ClientInstance(), this.getDB2ClientInstance(), null, "capabilityDb2ClientInstance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2Database(), this.getDB2Database(), null, "capabilityDb2Database", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2Instance(), this.getDB2Instance(), null, "capabilityDb2Instance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2JdbcDriver(), this.getDB2JdbcDriver(), null, "capabilityDb2JdbcDriver", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityDb2System(), this.getDB2System(), null, "capabilityDb2System", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityUnixDb2AdminServer(), this.getUnixDB2AdminServer(), null, "capabilityUnixDb2AdminServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityUnixDb2ClientInstance(), this.getUnixDB2ClientInstance(), null, "capabilityUnixDb2ClientInstance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityUnixDb2Instance(), this.getUnixDB2Instance(), null, "capabilityUnixDb2Instance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityUnixDb2System(), this.getUnixDB2System(), null, "capabilityUnixDb2System", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityWindowsDb2AdminServer(), this.getWindowsDB2AdminServer(), null, "capabilityWindowsDb2AdminServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityWindowsDb2ClientInstance(), this.getWindowsDB2ClientInstance(), null, "capabilityWindowsDb2ClientInstance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityWindowsDb2Instance(), this.getWindowsDB2Instance(), null, "capabilityWindowsDb2Instance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_CapabilityWindowsDb2System(), this.getWindowsDB2System(), null, "capabilityWindowsDb2System", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2AdminClientUnit(), this.getDB2AdminClientUnit(), null, "unitDb2AdminClientUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2AdminServerUnit(), this.getDB2AdminServerUnit(), null, "unitDb2AdminServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2AppDevelClientUnit(), this.getDB2AppDevelClientUnit(), null, "unitDb2AppDevelClientUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2BaseClientUnit(), this.getDB2BaseClientUnit(), null, "unitDb2BaseClientUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2CatalogUnit(), this.getDB2CatalogUnit(), null, "unitDb2CatalogUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2ClientInstanceUnit(), this.getDB2ClientInstanceUnit(), null, "unitDb2ClientInstanceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2DatabaseUnit(), this.getDB2DatabaseUnit(), null, "unitDb2DatabaseUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2ddl(), this.getDB2DDLArtifact(), null, "unitDb2ddl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2InstanceUnit(), this.getDB2InstanceUnit(), null, "unitDb2InstanceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2NodeCatalogUnit(), this.getDB2NodeCatalogUnit(), null, "unitDb2NodeCatalogUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2RuntimeClientUnit(), this.getDB2RuntimeClientUnit(), null, "unitDb2RuntimeClientUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDb2DeployRoot_UnitDb2SystemUnit(), this.getDB2SystemUnit(), null, "unitDb2SystemUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2InstanceEClass, DB2Instance.class, "DB2Instance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2Instance_AutoStart(), theXMLTypePackage.getBoolean(), "autoStart", null, 0, 1, DB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Instance_Hostname(), theXMLTypePackage.getString(), "hostname", null, 0, 1, DB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Instance_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, DB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Instance_Port(), theOsPackage.getTCPPortType(), "port", null, 0, 1, DB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2Instance_Username(), theXMLTypePackage.getString(), "username", null, 0, 1, DB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2InstanceUnitEClass, DB2InstanceUnit.class, "DB2InstanceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2JdbcDriverEClass, DB2JdbcDriver.class, "DB2JdbcDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2JdbcDriver_Classname(), theXMLTypePackage.getString(), "classname", null, 0, 1, DB2JdbcDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2JdbcDriver_Classpath(), theXMLTypePackage.getString(), "classpath", null, 0, 1, DB2JdbcDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2JdbcDriver_DriverPath(), theXMLTypePackage.getString(), "driverPath", null, 0, 1, DB2JdbcDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2JdbcDriver_JdbcType(), theJavaPackage.getJdbcTypeType(), "jdbcType", "1", 0, 1, DB2JdbcDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(db2NodeCatalogUnitEClass, DB2NodeCatalogUnit.class, "DB2NodeCatalogUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2RuntimeClientUnitEClass, DB2RuntimeClientUnit.class, "DB2RuntimeClientUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(db2SystemEClass, DB2System.class, "DB2System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDB2System_Db2ProductLang(), theXMLTypePackage.getString(), "db2ProductLang", null, 0, 1, DB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2System_Db2Version(), theCorePackage.getVersionString(), "db2Version", null, 0, 1, DB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDB2System_InstallDir(), theXMLTypePackage.getString(), "installDir", null, 0, 1, DB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(db2SystemUnitEClass, DB2SystemUnit.class, "DB2SystemUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(unixDB2AdminServerEClass, UnixDB2AdminServer.class, "UnixDB2AdminServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUnixDB2AdminServer_DasGID(), theXMLTypePackage.getString(), "dasGID", null, 0, 1, UnixDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2AdminServer_DasGroupName(), theXMLTypePackage.getString(), "dasGroupName", null, 0, 1, UnixDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2AdminServer_DasUID(), theXMLTypePackage.getString(), "dasUID", null, 0, 1, UnixDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2AdminServer_DasUserName(), theXMLTypePackage.getString(), "dasUserName", null, 0, 1, UnixDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2AdminServer_DasUserPassword(), theXMLTypePackage.getString(), "dasUserPassword", null, 0, 1, UnixDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unixDB2ClientInstanceEClass, UnixDB2ClientInstance.class, "UnixDB2ClientInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_AuthenticationType(), this.getAuthenticationTypeType(), "authenticationType", "SERVER", 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnixDB2ClientInstance_FencedGID(), theXMLTypePackage.getString(), "fencedGID", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_FencedGroupName(), theXMLTypePackage.getString(), "fencedGroupName", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_FencedUID(), theXMLTypePackage.getString(), "fencedUID", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_FencedUserName(), theXMLTypePackage.getString(), "fencedUserName", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_FencedUserPassword(), theXMLTypePackage.getString(), "fencedUserPassword", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_GID(), theXMLTypePackage.getString(), "gID", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_GroupName(), theXMLTypePackage.getString(), "groupName", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_InstanceType(), this.getUnixInstanceTypeType(), "instanceType", "Client", 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnixDB2ClientInstance_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_UID(), theXMLTypePackage.getString(), "uID", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_Username(), theXMLTypePackage.getString(), "username", null, 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2ClientInstance_WordWidth(), this.getWordWidthType(), "wordWidth", "31", 0, 1, UnixDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(unixDB2InstanceEClass, UnixDB2Instance.class, "UnixDB2Instance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_AuthenticationType(), this.getAuthenticationTypeType(), "authenticationType", "SERVER", 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnixDB2Instance_FencedGID(), theXMLTypePackage.getString(), "fencedGID", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_FencedGroupName(), theXMLTypePackage.getString(), "fencedGroupName", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_FencedUID(), theXMLTypePackage.getString(), "fencedUID", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_FencedUserName(), theXMLTypePackage.getString(), "fencedUserName", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_FencedUserPassword(), theXMLTypePackage.getString(), "fencedUserPassword", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_GID(), theXMLTypePackage.getString(), "gID", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_GroupName(), theXMLTypePackage.getString(), "groupName", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_InstanceType(), this.getUnixInstanceTypeType(), "instanceType", "Client", 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnixDB2Instance_UID(), theXMLTypePackage.getString(), "uID", null, 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnixDB2Instance_WordWidth(), this.getWordWidthType(), "wordWidth", "31", 0, 1, UnixDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(unixDB2SystemEClass, UnixDB2System.class, "UnixDB2System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(windowsDB2AdminServerEClass, WindowsDB2AdminServer.class, "WindowsDB2AdminServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWindowsDB2AdminServer_DasDomain(), theXMLTypePackage.getString(), "dasDomain", null, 0, 1, WindowsDB2AdminServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(windowsDB2ClientInstanceEClass, WindowsDB2ClientInstance.class, "WindowsDB2ClientInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWindowsDB2ClientInstance_DefaultInstance(), theXMLTypePackage.getBoolean(), "defaultInstance", null, 0, 1, WindowsDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWindowsDB2ClientInstance_InstanceType(), this.getWindowsInstanceTypeType(), "instanceType", "Client", 0, 1, WindowsDB2ClientInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(windowsDB2InstanceEClass, WindowsDB2Instance.class, "WindowsDB2Instance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWindowsDB2Instance_DefaultInstance(), theXMLTypePackage.getBoolean(), "defaultInstance", null, 0, 1, WindowsDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWindowsDB2Instance_InstanceType(), this.getWindowsInstanceTypeType(), "instanceType", "Client", 0, 1, WindowsDB2Instance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(windowsDB2SystemEClass, WindowsDB2System.class, "WindowsDB2System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getWindowsDB2System_AdminGroupName(), theXMLTypePackage.getString(), "adminGroupName", null, 0, 1, WindowsDB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWindowsDB2System_ExtendedSecurity(), theXMLTypePackage.getBoolean(), "extendedSecurity", null, 0, 1, WindowsDB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getWindowsDB2System_UserGroupName(), theXMLTypePackage.getString(), "userGroupName", null, 0, 1, WindowsDB2System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(authenticationTypeTypeEEnum, AuthenticationTypeType.class, "AuthenticationTypeType"); //$NON-NLS-1$
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.SERVER_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.CLIENT_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.SERVERENCRYPT_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.DATAENCRYPT_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.DATAENCRYPTCMP_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.KERBEROS_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.KRBSERVERENCRYPT_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.GSSPLUGIN_LITERAL);
		addEEnumLiteral(authenticationTypeTypeEEnum, AuthenticationTypeType.GSSSERVERENCRYPT_LITERAL);

		initEEnum(db2InstancePortNamesEEnum, DB2InstancePortNames.class, "DB2InstancePortNames"); //$NON-NLS-1$
		addEEnumLiteral(db2InstancePortNamesEEnum, DB2InstancePortNames.INSTANCE_CONNECTION_PORT_LITERAL);
		addEEnumLiteral(db2InstancePortNamesEEnum, DB2InstancePortNames.INSTANCE_INTERRUPT_PORT_LITERAL);
		addEEnumLiteral(db2InstancePortNamesEEnum, DB2InstancePortNames.INSTANCE_FCM_PORT_LITERAL);

		initEEnum(pageSizeTypeEEnum, PageSizeType.class, "PageSizeType"); //$NON-NLS-1$
		addEEnumLiteral(pageSizeTypeEEnum, PageSizeType._4096_LITERAL);
		addEEnumLiteral(pageSizeTypeEEnum, PageSizeType._8192_LITERAL);
		addEEnumLiteral(pageSizeTypeEEnum, PageSizeType._16384_LITERAL);
		addEEnumLiteral(pageSizeTypeEEnum, PageSizeType._32768_LITERAL);

		initEEnum(unixInstanceTypeTypeEEnum, UnixInstanceTypeType.class, "UnixInstanceTypeType"); //$NON-NLS-1$
		addEEnumLiteral(unixInstanceTypeTypeEEnum, UnixInstanceTypeType.CLIENT_LITERAL);
		addEEnumLiteral(unixInstanceTypeTypeEEnum, UnixInstanceTypeType.ESE_LITERAL);
		addEEnumLiteral(unixInstanceTypeTypeEEnum, UnixInstanceTypeType.WSE_LITERAL);

		initEEnum(windowsInstanceTypeTypeEEnum, WindowsInstanceTypeType.class, "WindowsInstanceTypeType"); //$NON-NLS-1$
		addEEnumLiteral(windowsInstanceTypeTypeEEnum, WindowsInstanceTypeType.CLIENT_LITERAL);
		addEEnumLiteral(windowsInstanceTypeTypeEEnum, WindowsInstanceTypeType.STANDALONE_LITERAL);
		addEEnumLiteral(windowsInstanceTypeTypeEEnum, WindowsInstanceTypeType.ESE_LITERAL);
		addEEnumLiteral(windowsInstanceTypeTypeEEnum, WindowsInstanceTypeType.WSE_LITERAL);

		initEEnum(wordWidthTypeEEnum, WordWidthType.class, "WordWidthType"); //$NON-NLS-1$
		addEEnumLiteral(wordWidthTypeEEnum, WordWidthType._31_LITERAL);
		addEEnumLiteral(wordWidthTypeEEnum, WordWidthType._32_LITERAL);
		addEEnumLiteral(wordWidthTypeEEnum, WordWidthType._64_LITERAL);

		// Initialize data types
		initEDataType(authenticationTypeTypeObjectEDataType, AuthenticationTypeType.class, "AuthenticationTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(db2InstancePortNamesObjectEDataType, DB2InstancePortNames.class, "DB2InstancePortNamesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(pageSizeTypeObjectEDataType, PageSizeType.class, "PageSizeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(unixInstanceTypeTypeObjectEDataType, UnixInstanceTypeType.class, "UnixInstanceTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(windowsInstanceTypeTypeObjectEDataType, WindowsInstanceTypeType.class, "WindowsInstanceTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(wordWidthTypeObjectEDataType, WordWidthType.class, "WordWidthTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$				
		addAnnotation
		  (authenticationTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "AuthenticationTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (authenticationTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "AuthenticationTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "AuthenticationTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AdminClientEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AdminClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2AdminClient_Db2ProductLang(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2ProductLang" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AdminClientUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AdminClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AdminServerEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AdminServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AdminServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AppDevelClientEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AppDevelClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2AppDevelClient_Db2ProductLang(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2ProductLang" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2AppDevelClientUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2AppDevelClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2BaseClientUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2BaseClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2BaseInstanceEClass, 
		   source, 
		   new String[] {
			 "name", "DB2BaseInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2BaseInstance_Db2InstanceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2InstanceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2BaseInstance_Db2Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2Version" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2CatalogedNodeEClass, 
		   source, 
		   new String[] {
			 "name", "DB2CatalogedNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2CatalogedNode_DasLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasLevel" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2CatalogedNode_Hostname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2CatalogedNode_NodeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nodeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2CatalogedNode_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nodeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2CatalogedNode_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (db2CatalogUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2CatalogUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ClientEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Client", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Client_Db2ClientVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2ClientVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Client_InstallDir(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installDir" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2ClientInstanceEClass, 
		   source, 
		   new String[] {
			 "name", "DB2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (db2ClientInstanceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2ClientInstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DatabaseEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Database", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_CatalogSp(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "catalogSp" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_CodeSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "codeSet" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_CreatePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "createPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_Db2Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2Version" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_DbAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_DbDrive(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbDrive" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_DbName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2Database_DftExtentSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dftExtentSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_PageSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "pageSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_TempSp(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "tempSp" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_Territory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "territory" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Database_UserSp(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userSp" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DatabaseUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2DatabaseUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DDLArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "DB2DDLArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2DeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2AdminClient(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2AdminClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2AdminServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2AppDevelClient(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2AppDevelClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2BaseInstance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2BaseInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2CatalogedNode(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2CatalogedNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2Client(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2Client", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2ClientInstance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2Database(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2Database", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2Instance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2JdbcDriver(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2JdbcDriver", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityDb2System(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.db2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityUnixDb2AdminServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.unixDb2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityUnixDb2ClientInstance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.unixDb2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityUnixDb2Instance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.unixDb2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityUnixDb2System(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.unixDb2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityWindowsDb2AdminServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.windowsDb2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityWindowsDb2ClientInstance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.windowsDb2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityWindowsDb2Instance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.windowsDb2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_CapabilityWindowsDb2System(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.windowsDb2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2AdminClientUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2AdminClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2AdminServerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2AdminServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2AppDevelClientUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2AppDevelClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2BaseClientUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2BaseClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2CatalogUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2CatalogUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2ClientInstanceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2ClientInstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2DatabaseUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2DatabaseUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2ddl(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2ddl", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2InstanceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2InstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2NodeCatalogUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2NodeCatalogUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2RuntimeClientUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2RuntimeClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDb2DeployRoot_UnitDb2SystemUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.db2SystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2InstanceEClass, 
		   source, 
		   new String[] {
			 "name", "DB2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Instance_AutoStart(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "autoStart" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Instance_Hostname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Instance_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Instance_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2Instance_Username(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "username" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2InstancePortNamesEEnum, 
		   source, 
		   new String[] {
			 "name", "DB2InstancePortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2InstancePortNamesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DB2InstancePortNames:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DB2InstancePortNames" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2InstanceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2InstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2JdbcDriverEClass, 
		   source, 
		   new String[] {
			 "name", "DB2JdbcDriver", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2JdbcDriver_Classname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classname" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2JdbcDriver_Classpath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classpath" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2JdbcDriver_DriverPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "driverPath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDB2JdbcDriver_JdbcType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jdbcType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (db2NodeCatalogUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2NodeCatalogUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (db2RuntimeClientUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2RuntimeClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2SystemEClass, 
		   source, 
		   new String[] {
			 "name", "DB2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2System_Db2ProductLang(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2ProductLang" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2System_Db2Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "db2Version" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDB2System_InstallDir(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "installDir" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (db2SystemUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DB2SystemUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (pageSizeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "PageSizeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (pageSizeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "PageSizeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "PageSizeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (unixDB2AdminServerEClass, 
		   source, 
		   new String[] {
			 "name", "UnixDB2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2AdminServer_DasGID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasGID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2AdminServer_DasGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2AdminServer_DasUID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasUID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2AdminServer_DasUserName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasUserName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2AdminServer_DasUserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasUserPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (unixDB2ClientInstanceEClass, 
		   source, 
		   new String[] {
			 "name", "UnixDB2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnixDB2ClientInstance_AuthenticationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "authenticationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_FencedGID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedGID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_FencedGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_FencedUID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_FencedUserName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUserName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_FencedUserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUserPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_GID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "GID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_GroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "groupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnixDB2ClientInstance_InstanceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instanceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "password" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_UID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_Username(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "username" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2ClientInstance_WordWidth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wordWidth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (unixDB2InstanceEClass, 
		   source, 
		   new String[] {
			 "name", "UnixDB2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnixDB2Instance_AuthenticationType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "authenticationType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_FencedGID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedGID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_FencedGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_FencedUID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_FencedUserName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUserName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_FencedUserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fencedUserPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_GID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "GID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_GroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "groupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnixDB2Instance_InstanceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instanceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_UID(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "UID" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnixDB2Instance_WordWidth(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "wordWidth" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (unixDB2SystemEClass, 
		   source, 
		   new String[] {
			 "name", "UnixDB2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (unixInstanceTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "UnixInstanceTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (unixInstanceTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "UnixInstanceTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "UnixInstanceTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (windowsDB2AdminServerEClass, 
		   source, 
		   new String[] {
			 "name", "WindowsDB2AdminServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2AdminServer_DasDomain(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dasDomain" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (windowsDB2ClientInstanceEClass, 
		   source, 
		   new String[] {
			 "name", "WindowsDB2ClientInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2ClientInstance_DefaultInstance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "defaultInstance" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWindowsDB2ClientInstance_InstanceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instanceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (windowsDB2InstanceEClass, 
		   source, 
		   new String[] {
			 "name", "WindowsDB2Instance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2Instance_DefaultInstance(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "defaultInstance" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getWindowsDB2Instance_InstanceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instanceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (windowsDB2SystemEClass, 
		   source, 
		   new String[] {
			 "name", "WindowsDB2System", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2System_AdminGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "adminGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2System_ExtendedSecurity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "extendedSecurity" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getWindowsDB2System_UserGroupName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userGroupName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (windowsInstanceTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "WindowsInstanceTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (windowsInstanceTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WindowsInstanceTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WindowsInstanceTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (wordWidthTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "WordWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (wordWidthTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "WordWidthType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "WordWidthType" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //Db2PackageImpl
