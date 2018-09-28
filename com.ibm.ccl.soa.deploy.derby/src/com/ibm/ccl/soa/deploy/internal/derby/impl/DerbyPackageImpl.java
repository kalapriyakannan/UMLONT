/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class DerbyPackageImpl extends EPackageImpl implements DerbyPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyDatabaseEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyDatabaseInstanceUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyDatabaseUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyDDLArtifactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derbyInstanceEClass = null;

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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DerbyPackageImpl() {
		super(eNS_URI, DerbyFactory.eINSTANCE);
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
	public static DerbyPackage init() {
		if (isInited) return (DerbyPackage)EPackage.Registry.INSTANCE.getEPackage(DerbyPackage.eNS_URI);

		// Obtain or create and register package
		DerbyPackageImpl theDerbyPackage = (DerbyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DerbyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DerbyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DatabasePackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDerbyPackage.createPackageContents();

		// Initialize created meta-data
		theDerbyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDerbyPackage.freeze();

		return theDerbyPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyDatabase() {
		return derbyDatabaseEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyDatabase_DbAlias() {
		return (EAttribute)derbyDatabaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyDatabase_DbDrive() {
		return (EAttribute)derbyDatabaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyDatabase_DbName() {
		return (EAttribute)derbyDatabaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyDatabase_DerbyVersion() {
		return (EAttribute)derbyDatabaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyDatabaseInstanceUnit() {
		return derbyDatabaseInstanceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyDatabaseUnit() {
		return derbyDatabaseUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyDDLArtifact() {
		return derbyDDLArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyDeployRoot() {
		return derbyDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyDeployRoot_Mixed() {
		return (EAttribute)derbyDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_XMLNSPrefixMap() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_XSISchemaLocation() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_ArtifactDerbyddl() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_CapabilityDerbyDatabase() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_CapabilityDerbyInstance() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerbyDeployRoot_UnitDerbyDatabaseUnit() {
		return (EReference)derbyDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerbyInstance() {
		return derbyInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyInstance_Hostname() {
		return (EAttribute)derbyInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyInstance_InstanceName() {
		return (EAttribute)derbyInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDerbyInstance_Port() {
		return (EAttribute)derbyInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyFactory getDerbyFactory() {
		return (DerbyFactory)getEFactoryInstance();
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
		derbyDatabaseEClass = createEClass(DERBY_DATABASE);
		createEAttribute(derbyDatabaseEClass, DERBY_DATABASE__DB_ALIAS);
		createEAttribute(derbyDatabaseEClass, DERBY_DATABASE__DB_DRIVE);
		createEAttribute(derbyDatabaseEClass, DERBY_DATABASE__DB_NAME);
		createEAttribute(derbyDatabaseEClass, DERBY_DATABASE__DERBY_VERSION);

		derbyDatabaseInstanceUnitEClass = createEClass(DERBY_DATABASE_INSTANCE_UNIT);

		derbyDatabaseUnitEClass = createEClass(DERBY_DATABASE_UNIT);

		derbyDDLArtifactEClass = createEClass(DERBY_DDL_ARTIFACT);

		derbyDeployRootEClass = createEClass(DERBY_DEPLOY_ROOT);
		createEAttribute(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__MIXED);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT);
		createEReference(derbyDeployRootEClass, DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT);

		derbyInstanceEClass = createEClass(DERBY_INSTANCE);
		createEAttribute(derbyInstanceEClass, DERBY_INSTANCE__HOSTNAME);
		createEAttribute(derbyInstanceEClass, DERBY_INSTANCE__INSTANCE_NAME);
		createEAttribute(derbyInstanceEClass, DERBY_INSTANCE__PORT);
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
		DatabasePackage theDatabasePackage = (DatabasePackage)EPackage.Registry.INSTANCE.getEPackage(DatabasePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		derbyDatabaseEClass.getESuperTypes().add(theDatabasePackage.getDatabase());
		derbyDatabaseInstanceUnitEClass.getESuperTypes().add(theDatabasePackage.getDatabaseInstanceUnit());
		derbyDatabaseUnitEClass.getESuperTypes().add(theDatabasePackage.getDatabaseUnit());
		derbyDDLArtifactEClass.getESuperTypes().add(theDatabasePackage.getDDLArtifact());
		derbyInstanceEClass.getESuperTypes().add(theDatabasePackage.getDatabaseInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(derbyDatabaseEClass, DerbyDatabase.class, "DerbyDatabase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDerbyDatabase_DbAlias(), theXMLTypePackage.getString(), "dbAlias", null, 0, 1, DerbyDatabase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDerbyDatabase_DbDrive(), theXMLTypePackage.getString(), "dbDrive", null, 0, 1, DerbyDatabase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDerbyDatabase_DbName(), theXMLTypePackage.getString(), "dbName", null, 0, 1, DerbyDatabase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDerbyDatabase_DerbyVersion(), theXMLTypePackage.getString(), "derbyVersion", null, 0, 1, DerbyDatabase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(derbyDatabaseInstanceUnitEClass, DerbyDatabaseInstanceUnit.class, "DerbyDatabaseInstanceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(derbyDatabaseUnitEClass, DerbyDatabaseUnit.class, "DerbyDatabaseUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(derbyDDLArtifactEClass, DerbyDDLArtifact.class, "DerbyDDLArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(derbyDeployRootEClass, DerbyDeployRoot.class, "DerbyDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDerbyDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_ArtifactDerbyddl(), this.getDerbyDDLArtifact(), null, "artifactDerbyddl", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_CapabilityDerbyDatabase(), this.getDerbyDatabase(), null, "capabilityDerbyDatabase", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_CapabilityDerbyInstance(), this.getDerbyInstance(), null, "capabilityDerbyInstance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit(), this.getDerbyDatabaseInstanceUnit(), null, "unitDerbyDatabaseInstanceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerbyDeployRoot_UnitDerbyDatabaseUnit(), this.getDerbyDatabaseUnit(), null, "unitDerbyDatabaseUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(derbyInstanceEClass, DerbyInstance.class, "DerbyInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDerbyInstance_Hostname(), theXMLTypePackage.getString(), "hostname", null, 0, 1, DerbyInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDerbyInstance_InstanceName(), theXMLTypePackage.getString(), "instanceName", null, 0, 1, DerbyInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDerbyInstance_Port(), theXMLTypePackage.getInteger(), "port", null, 0, 1, DerbyInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

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
		  (derbyDatabaseEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyDatabase", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDatabase_DbAlias(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbAlias" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDatabase_DbDrive(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbDrive" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDatabase_DbName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dbName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDatabase_DerbyVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "derbyVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyDatabaseInstanceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyDatabaseInstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyDatabaseUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyDatabaseUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyDDLArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyDDLArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_ArtifactDerbyddl(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact.derbyddl", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_CapabilityDerbyDatabase(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.derbyDatabase", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_CapabilityDerbyInstance(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.derbyInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.derbyDatabaseInstanceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyDeployRoot_UnitDerbyDatabaseUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.derbyDatabaseUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (derbyInstanceEClass, 
		   source, 
		   new String[] {
			 "name", "DerbyInstance", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyInstance_Hostname(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "hostname" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyInstance_InstanceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instanceName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDerbyInstance_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //DerbyPackageImpl
