/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

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
import com.ibm.ccl.soa.deploy.java.ClassAccessMode;
import com.ibm.ccl.soa.deploy.java.JDKUnit;
import com.ibm.ccl.soa.deploy.java.JREEdition;
import com.ibm.ccl.soa.deploy.java.JREUnit;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JVMConfig;
import com.ibm.ccl.soa.deploy.java.JavaDeployRoot;
import com.ibm.ccl.soa.deploy.java.JavaFactory;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class JavaPackageImpl extends EPackageImpl implements JavaPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jdbcProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jdbcProviderUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jdkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jdkUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jreEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jreUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmConfigEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classAccessModeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jdbcTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jreEditionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jreVersionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType classAccessModeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jdbcTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jreEditionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jreVersionObjectEDataType = null;

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
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaPackageImpl() {
		super(eNS_URI, JavaFactory.eINSTANCE);
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
	public static JavaPackage init() {
		if (isInited) return (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);

		// Obtain or create and register package
		JavaPackageImpl theJavaPackage = (JavaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new JavaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJavaPackage.createPackageContents();

		// Initialize created meta-data
		theJavaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaPackage.freeze();

		return theJavaPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaDeployRoot() {
		return javaDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaDeployRoot_Mixed() {
		return (EAttribute)javaDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_XMLNSPrefixMap() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_XSISchemaLocation() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_CapabilityJdbcProvider() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_CapabilityJdk() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_CapabilityJre() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_CapabilityJvmConfig() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_UnitJdbcProviderUnit() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_UnitJdk() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaDeployRoot_UnitJre() {
		return (EReference)javaDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJdbcProvider() {
		return jdbcProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJdbcProvider_Classpath() {
		return (EAttribute)jdbcProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJdbcProvider_ImplementationClassName() {
		return (EAttribute)jdbcProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJdbcProvider_Nativepath() {
		return (EAttribute)jdbcProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJdbcProvider_ProviderName() {
		return (EAttribute)jdbcProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJdbcProvider_ProviderType() {
		return (EAttribute)jdbcProviderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJdbcProviderUnit() {
		return jdbcProviderUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJDK() {
		return jdkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJDK_JdkVersion() {
		return (EAttribute)jdkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJDK_OtherValue() {
		return (EAttribute)jdkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJDKUnit() {
		return jdkUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJRE() {
		return jreEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJRE_JreEdition() {
		return (EAttribute)jreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJRE_JreVersion() {
		return (EAttribute)jreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJRE_OtherValue() {
		return (EAttribute)jreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJREUnit() {
		return jreUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJVMConfig() {
		return jvmConfigEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_BootClasspath() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_Classpath() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_DebugArgs() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_DisableJIT() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_ExecutableJarfileName() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_GenericJvmArguments() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_InitialHeapSize() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_InternalClassAccessMode() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_MaximumHeapSize() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_RunHProf() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_VerboseModeClass() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_VerboseModeGarbageCollection() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJVMConfig_VerboseModeJNI() {
		return (EAttribute)jvmConfigEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassAccessMode() {
		return classAccessModeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJdbcTypeType() {
		return jdbcTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJREEdition() {
		return jreEditionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJREVersion() {
		return jreVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClassAccessModeObject() {
		return classAccessModeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJdbcTypeTypeObject() {
		return jdbcTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJREEditionObject() {
		return jreEditionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJREVersionObject() {
		return jreVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactory getJavaFactory() {
		return (JavaFactory)getEFactoryInstance();
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
		javaDeployRootEClass = createEClass(JAVA_DEPLOY_ROOT);
		createEAttribute(javaDeployRootEClass, JAVA_DEPLOY_ROOT__MIXED);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__CAPABILITY_JDK);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__CAPABILITY_JRE);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__UNIT_JDK);
		createEReference(javaDeployRootEClass, JAVA_DEPLOY_ROOT__UNIT_JRE);

		jdbcProviderEClass = createEClass(JDBC_PROVIDER);
		createEAttribute(jdbcProviderEClass, JDBC_PROVIDER__CLASSPATH);
		createEAttribute(jdbcProviderEClass, JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME);
		createEAttribute(jdbcProviderEClass, JDBC_PROVIDER__NATIVEPATH);
		createEAttribute(jdbcProviderEClass, JDBC_PROVIDER__PROVIDER_NAME);
		createEAttribute(jdbcProviderEClass, JDBC_PROVIDER__PROVIDER_TYPE);

		jdbcProviderUnitEClass = createEClass(JDBC_PROVIDER_UNIT);

		jdkEClass = createEClass(JDK);
		createEAttribute(jdkEClass, JDK__JDK_VERSION);
		createEAttribute(jdkEClass, JDK__OTHER_VALUE);

		jdkUnitEClass = createEClass(JDK_UNIT);

		jreEClass = createEClass(JRE);
		createEAttribute(jreEClass, JRE__JRE_EDITION);
		createEAttribute(jreEClass, JRE__JRE_VERSION);
		createEAttribute(jreEClass, JRE__OTHER_VALUE);

		jreUnitEClass = createEClass(JRE_UNIT);

		jvmConfigEClass = createEClass(JVM_CONFIG);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__BOOT_CLASSPATH);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__CLASSPATH);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__DEBUG_ARGS);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__DISABLE_JIT);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__EXECUTABLE_JARFILE_NAME);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__GENERIC_JVM_ARGUMENTS);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__INITIAL_HEAP_SIZE);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__MAXIMUM_HEAP_SIZE);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__RUN_HPROF);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__VERBOSE_MODE_CLASS);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION);
		createEAttribute(jvmConfigEClass, JVM_CONFIG__VERBOSE_MODE_JNI);

		// Create enums
		classAccessModeEEnum = createEEnum(CLASS_ACCESS_MODE);
		jdbcTypeTypeEEnum = createEEnum(JDBC_TYPE_TYPE);
		jreEditionEEnum = createEEnum(JRE_EDITION);
		jreVersionEEnum = createEEnum(JRE_VERSION);

		// Create data types
		classAccessModeObjectEDataType = createEDataType(CLASS_ACCESS_MODE_OBJECT);
		jdbcTypeTypeObjectEDataType = createEDataType(JDBC_TYPE_TYPE_OBJECT);
		jreEditionObjectEDataType = createEDataType(JRE_EDITION_OBJECT);
		jreVersionObjectEDataType = createEDataType(JRE_VERSION_OBJECT);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		jdbcProviderEClass.getESuperTypes().add(theCorePackage.getCapability());
		jdbcProviderUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jdkEClass.getESuperTypes().add(theCorePackage.getCapability());
		jdkUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jreEClass.getESuperTypes().add(theCorePackage.getCapability());
		jreUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		jvmConfigEClass.getESuperTypes().add(theCorePackage.getCapability());

		// Initialize classes and features; add operations and parameters
		initEClass(javaDeployRootEClass, JavaDeployRoot.class, "JavaDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJavaDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_CapabilityJdbcProvider(), this.getJdbcProvider(), null, "capabilityJdbcProvider", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_CapabilityJdk(), this.getJDK(), null, "capabilityJdk", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_CapabilityJre(), this.getJRE(), null, "capabilityJre", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_CapabilityJvmConfig(), this.getJVMConfig(), null, "capabilityJvmConfig", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_UnitJdbcProviderUnit(), this.getJdbcProviderUnit(), null, "unitJdbcProviderUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_UnitJdk(), this.getJDKUnit(), null, "unitJdk", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getJavaDeployRoot_UnitJre(), this.getJREUnit(), null, "unitJre", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jdbcProviderEClass, JdbcProvider.class, "JdbcProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJdbcProvider_Classpath(), theXMLTypePackage.getString(), "classpath", null, 0, 1, JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJdbcProvider_ImplementationClassName(), theXMLTypePackage.getString(), "implementationClassName", null, 0, 1, JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJdbcProvider_Nativepath(), theXMLTypePackage.getString(), "nativepath", null, 0, 1, JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJdbcProvider_ProviderName(), theXMLTypePackage.getString(), "providerName", null, 1, 1, JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJdbcProvider_ProviderType(), theXMLTypePackage.getString(), "providerType", null, 0, 1, JdbcProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jdbcProviderUnitEClass, JdbcProviderUnit.class, "JdbcProviderUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jdkEClass, com.ibm.ccl.soa.deploy.java.JDK.class, "JDK", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJDK_JdkVersion(), this.getJREVersion(), "jdkVersion", "1.2", 1, 1, com.ibm.ccl.soa.deploy.java.JDK.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJDK_OtherValue(), theXMLTypePackage.getString(), "otherValue", null, 0, 1, com.ibm.ccl.soa.deploy.java.JDK.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jdkUnitEClass, JDKUnit.class, "JDKUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jreEClass, com.ibm.ccl.soa.deploy.java.JRE.class, "JRE", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJRE_JreEdition(), this.getJREEdition(), "jreEdition", "standard", 0, 1, com.ibm.ccl.soa.deploy.java.JRE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJRE_JreVersion(), this.getJREVersion(), "jreVersion", "1.2", 1, 1, com.ibm.ccl.soa.deploy.java.JRE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJRE_OtherValue(), theXMLTypePackage.getString(), "otherValue", null, 0, 1, com.ibm.ccl.soa.deploy.java.JRE.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(jreUnitEClass, JREUnit.class, "JREUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(jvmConfigEClass, JVMConfig.class, "JVMConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJVMConfig_BootClasspath(), theXMLTypePackage.getString(), "bootClasspath", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_Classpath(), theXMLTypePackage.getString(), "classpath", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_DebugArgs(), theXMLTypePackage.getString(), "debugArgs", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_DisableJIT(), theXMLTypePackage.getBoolean(), "disableJIT", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_ExecutableJarfileName(), theXMLTypePackage.getString(), "executableJarfileName", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_GenericJvmArguments(), theXMLTypePackage.getString(), "genericJvmArguments", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_InitialHeapSize(), theXMLTypePackage.getInt(), "initialHeapSize", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_InternalClassAccessMode(), this.getClassAccessMode(), "internalClassAccessMode", "Allow", 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getJVMConfig_MaximumHeapSize(), theXMLTypePackage.getInt(), "maximumHeapSize", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_RunHProf(), theXMLTypePackage.getString(), "runHProf", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_VerboseModeClass(), theXMLTypePackage.getBoolean(), "verboseModeClass", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_VerboseModeGarbageCollection(), theXMLTypePackage.getBoolean(), "verboseModeGarbageCollection", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getJVMConfig_VerboseModeJNI(), theXMLTypePackage.getBoolean(), "verboseModeJNI", null, 0, 1, JVMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(classAccessModeEEnum, ClassAccessMode.class, "ClassAccessMode"); //$NON-NLS-1$
		addEEnumLiteral(classAccessModeEEnum, ClassAccessMode.ALLOW_LITERAL);
		addEEnumLiteral(classAccessModeEEnum, ClassAccessMode.RESTRICT_LITERAL);

		initEEnum(jdbcTypeTypeEEnum, JdbcTypeType.class, "JdbcTypeType"); //$NON-NLS-1$
		addEEnumLiteral(jdbcTypeTypeEEnum, JdbcTypeType._1_LITERAL);
		addEEnumLiteral(jdbcTypeTypeEEnum, JdbcTypeType._2_LITERAL);
		addEEnumLiteral(jdbcTypeTypeEEnum, JdbcTypeType._3_LITERAL);
		addEEnumLiteral(jdbcTypeTypeEEnum, JdbcTypeType._4_LITERAL);

		initEEnum(jreEditionEEnum, JREEdition.class, "JREEdition"); //$NON-NLS-1$
		addEEnumLiteral(jreEditionEEnum, JREEdition.STANDARD_LITERAL);
		addEEnumLiteral(jreEditionEEnum, JREEdition.ENTERPRISE_LITERAL);
		addEEnumLiteral(jreEditionEEnum, JREEdition.MICRO_LITERAL);
		addEEnumLiteral(jreEditionEEnum, JREEdition.OTHER_LITERAL);

		initEEnum(jreVersionEEnum, JREVersion.class, "JREVersion"); //$NON-NLS-1$
		addEEnumLiteral(jreVersionEEnum, JREVersion._12_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._13_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._131_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._14_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._141_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._142_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._15_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion._50_LITERAL);
		addEEnumLiteral(jreVersionEEnum, JREVersion.OTHER_LITERAL);

		// Initialize data types
		initEDataType(classAccessModeObjectEDataType, ClassAccessMode.class, "ClassAccessModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jdbcTypeTypeObjectEDataType, JdbcTypeType.class, "JdbcTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jreEditionObjectEDataType, JREEdition.class, "JREEditionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(jreVersionObjectEDataType, JREVersion.class, "JREVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		  (classAccessModeEEnum, 
		   source, 
		   new String[] {
			 "name", "ClassAccessMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (classAccessModeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ClassAccessMode:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ClassAccessMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (javaDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_CapabilityJdbcProvider(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.jdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_CapabilityJdk(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.jdk", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_CapabilityJre(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.jre", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_CapabilityJvmConfig(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.jvmConfig", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_UnitJdbcProviderUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.jdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_UnitJdk(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.jdk", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJavaDeployRoot_UnitJre(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.jre", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdbcProviderEClass, 
		   source, 
		   new String[] {
			 "name", "JdbcProvider", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJdbcProvider_Classpath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classpath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJdbcProvider_ImplementationClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "implementationClassName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJdbcProvider_Nativepath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "nativepath" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJdbcProvider_ProviderName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJdbcProvider_ProviderType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "providerType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdbcProviderUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JdbcProviderUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (jdbcTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "JdbcTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });						
		addAnnotation
		  (jdbcTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JdbcTypeType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "JdbcTypeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdkEClass, 
		   source, 
		   new String[] {
			 "name", "JDK", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJDK_JdkVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jdkVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJDK_OtherValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "otherValue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jdkUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JDKUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreEClass, 
		   source, 
		   new String[] {
			 "name", "JRE", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJRE_JreEdition(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jreEdition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJRE_JreVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jreVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getJRE_OtherValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "otherValue" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreEditionEEnum, 
		   source, 
		   new String[] {
			 "name", "JREEdition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreEditionObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JREEdition:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "JREEdition" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreUnitEClass, 
		   source, 
		   new String[] {
			 "name", "JREUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreVersionEEnum, 
		   source, 
		   new String[] {
			 "name", "JREVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (jreVersionObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "JREVersion:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "JREVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (jvmConfigEClass, 
		   source, 
		   new String[] {
			 "name", "JVMConfig", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_BootClasspath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bootClasspath" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_Classpath(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "classpath" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_DebugArgs(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "debugArgs" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_DisableJIT(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "disableJIT" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_ExecutableJarfileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "executableJarfileName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_GenericJvmArguments(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "genericJvmArguments" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_InitialHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initialHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_InternalClassAccessMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "internalClassAccessMode" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_MaximumHeapSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "maximumHeapSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_RunHProf(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "runHProf" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_VerboseModeClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "verboseModeClass" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_VerboseModeGarbageCollection(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "verboseModeGarbageCollection" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getJVMConfig_VerboseModeJNI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "verboseModeJNI" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //JavaPackageImpl
