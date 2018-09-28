/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The core model for SOA Deploy. A {@link Topology} contains {@link Unit}s. Units contain
 * {@Capability}s, {@Requirement}s, and {@UnitLink}s. Extension domains are encouraged to extend
 * Unit and Capability but not Topology, Requirement, or UnitLink.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "java"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/java/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javaDeploy"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	JavaPackage eINSTANCE = com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJavaDeployRoot()
	 * @generated
	 */
	int JAVA_DEPLOY_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Jdbc Provider</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>Capability Jdk</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__CAPABILITY_JDK = 4;

	/**
	 * The feature id for the '<em><b>Capability Jre</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__CAPABILITY_JRE = 5;

	/**
	 * The feature id for the '<em><b>Capability Jvm Config</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG = 6;

	/**
	 * The feature id for the '<em><b>Unit Jdbc Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Unit Jdk</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__UNIT_JDK = 8;

	/**
	 * The feature id for the '<em><b>Unit Jre</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT__UNIT_JRE = 9;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_DEPLOY_ROOT_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl <em>Jdbc Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcProvider()
	 * @generated
	 */
	int JDBC_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Class Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nativepath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__NATIVEPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__PROVIDER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Provider Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER__PROVIDER_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Jdbc Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderUnitImpl <em>Jdbc Provider Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JdbcProviderUnitImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcProviderUnit()
	 * @generated
	 */
	int JDBC_PROVIDER_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Jdbc Provider Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDBC_PROVIDER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JDKImpl <em>JDK</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JDKImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJDK()
	 * @generated
	 */
	int JDK = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Jdk Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__JDK_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Other Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK__OTHER_VALUE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JDKUnitImpl <em>JDK Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JDKUnitImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJDKUnit()
	 * @generated
	 */
	int JDK_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JDK Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDK_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JREImpl <em>JRE</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JREImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJRE()
	 * @generated
	 */
	int JRE = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Jre Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__JRE_EDITION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jre Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__JRE_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE__OTHER_VALUE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>JRE</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JREUnitImpl <em>JRE Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JREUnitImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREUnit()
	 * @generated
	 */
	int JRE_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JRE Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl <em>JVM Config</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJVMConfig()
	 * @generated
	 */
	int JVM_CONFIG = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Boot Classpath</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__BOOT_CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Debug Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__DEBUG_ARGS = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Disable JIT</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__DISABLE_JIT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Executable Jarfile Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__EXECUTABLE_JARFILE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Generic Jvm Arguments</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__GENERIC_JVM_ARGUMENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Initial Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__INITIAL_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Internal Class Access Mode</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Maximum Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__MAXIMUM_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Run HProf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__RUN_HPROF = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Verbose Mode Class</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__VERBOSE_MODE_CLASS = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Verbose Mode Garbage Collection</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Verbose Mode JNI</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG__VERBOSE_MODE_JNI = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>JVM Config</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVM_CONFIG_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.ClassAccessMode <em>Class Access Mode</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getClassAccessMode()
	 * @generated
	 */
	int CLASS_ACCESS_MODE = 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.JdbcTypeType <em>Jdbc Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcTypeType()
	 * @generated
	 */
	int JDBC_TYPE_TYPE = 9;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.JREEdition <em>JRE Edition</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREEdition()
	 * @generated
	 */
	int JRE_EDITION = 10;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.java.JREVersion <em>JRE Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREVersion()
	 * @generated
	 */
	int JRE_VERSION = 11;

	/**
	 * The meta object id for the '<em>Class Access Mode Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getClassAccessModeObject()
	 * @generated
	 */
	int CLASS_ACCESS_MODE_OBJECT = 12;

	/**
	 * The meta object id for the '<em>Jdbc Type Type Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcTypeTypeObject()
	 * @generated
	 */
	int JDBC_TYPE_TYPE_OBJECT = 13;

	/**
	 * The meta object id for the '<em>JRE Edition Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREEditionObject()
	 * @generated
	 */
	int JRE_EDITION_OBJECT = 14;

	/**
	 * The meta object id for the '<em>JRE Version Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREVersionObject()
	 * @generated
	 */
	int JRE_VERSION_OBJECT = 15;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot
	 * @generated
	 */
	EClass getJavaDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getMixed()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EAttribute getJavaDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXMLNSPrefixMap()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getXSISchemaLocation()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdbcProvider <em>Capability Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jdbc Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdbcProvider()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_CapabilityJdbcProvider();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdk <em>Capability Jdk</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jdk</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJdk()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_CapabilityJdk();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJre <em>Capability Jre</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jre</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJre()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_CapabilityJre();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJvmConfig <em>Capability Jvm Config</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jvm Config</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getCapabilityJvmConfig()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_CapabilityJvmConfig();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdbcProviderUnit <em>Unit Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Jdbc Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdbcProviderUnit()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_UnitJdbcProviderUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdk <em>Unit Jdk</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Jdk</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJdk()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_UnitJdk();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJre <em>Unit Jre</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Jre</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JavaDeployRoot#getUnitJre()
	 * @see #getJavaDeployRoot()
	 * @generated
	 */
	EReference getJavaDeployRoot_UnitJre();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider <em>Jdbc Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jdbc Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider
	 * @generated
	 */
	EClass getJdbcProvider();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider#getClasspath()
	 * @see #getJdbcProvider()
	 * @generated
	 */
	EAttribute getJdbcProvider_Classpath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getImplementationClassName <em>Implementation Class Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider#getImplementationClassName()
	 * @see #getJdbcProvider()
	 * @generated
	 */
	EAttribute getJdbcProvider_ImplementationClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getNativepath <em>Nativepath</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nativepath</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider#getNativepath()
	 * @see #getJdbcProvider()
	 * @generated
	 */
	EAttribute getJdbcProvider_Nativepath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderName()
	 * @see #getJdbcProvider()
	 * @generated
	 */
	EAttribute getJdbcProvider_ProviderName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderType <em>Provider Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProvider#getProviderType()
	 * @see #getJdbcProvider()
	 * @generated
	 */
	EAttribute getJdbcProvider_ProviderType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JdbcProviderUnit <em>Jdbc Provider Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jdbc Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcProviderUnit
	 * @generated
	 */
	EClass getJdbcProviderUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JDK <em>JDK</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDK</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JDK
	 * @generated
	 */
	EClass getJDK();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion <em>Jdk Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdk Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JDK#getJdkVersion()
	 * @see #getJDK()
	 * @generated
	 */
	EAttribute getJDK_JdkVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JDK#getOtherValue <em>Other Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JDK#getOtherValue()
	 * @see #getJDK()
	 * @generated
	 */
	EAttribute getJDK_OtherValue();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JDKUnit <em>JDK Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDK Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JDKUnit
	 * @generated
	 */
	EClass getJDKUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JRE <em>JRE</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JRE</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JRE
	 * @generated
	 */
	EClass getJRE();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreEdition <em>Jre Edition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jre Edition</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JRE#getJreEdition()
	 * @see #getJRE()
	 * @generated
	 */
	EAttribute getJRE_JreEdition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JRE#getJreVersion <em>Jre Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jre Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JRE#getJreVersion()
	 * @see #getJRE()
	 * @generated
	 */
	EAttribute getJRE_JreVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JRE#getOtherValue <em>Other Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JRE#getOtherValue()
	 * @see #getJRE()
	 * @generated
	 */
	EAttribute getJRE_OtherValue();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JREUnit <em>JRE Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JRE Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JREUnit
	 * @generated
	 */
	EClass getJREUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.java.JVMConfig <em>JVM Config</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JVM Config</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig
	 * @generated
	 */
	EClass getJVMConfig();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getBootClasspath <em>Boot Classpath</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boot Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getBootClasspath()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_BootClasspath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getClasspath()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_Classpath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getDebugArgs <em>Debug Args</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug Args</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getDebugArgs()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_DebugArgs();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT <em>Disable JIT</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disable JIT</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_DisableJIT();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getExecutableJarfileName <em>Executable Jarfile Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable Jarfile Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getExecutableJarfileName()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_ExecutableJarfileName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getGenericJvmArguments <em>Generic Jvm Arguments</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generic Jvm Arguments</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getGenericJvmArguments()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_GenericJvmArguments();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize <em>Initial Heap Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_InitialHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode <em>Internal Class Access Mode</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Class Access Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_InternalClassAccessMode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize <em>Maximum Heap Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_MaximumHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getRunHProf <em>Run HProf</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run HProf</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#getRunHProf()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_RunHProf();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass <em>Verbose Mode Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verbose Mode Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_VerboseModeClass();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verbose Mode Garbage Collection</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_VerboseModeGarbageCollection();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI <em>Verbose Mode JNI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verbose Mode JNI</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI()
	 * @see #getJVMConfig()
	 * @generated
	 */
	EAttribute getJVMConfig_VerboseModeJNI();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.java.ClassAccessMode <em>Class Access Mode</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Class Access Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @generated
	 */
	EEnum getClassAccessMode();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.java.JdbcTypeType <em>Jdbc Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Jdbc Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @generated
	 */
	EEnum getJdbcTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.java.JREEdition <em>JRE Edition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>JRE Edition</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @generated
	 */
	EEnum getJREEdition();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.java.JREVersion <em>JRE Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>JRE Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @generated
	 */
	EEnum getJREVersion();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.java.ClassAccessMode <em>Class Access Mode Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Class Access Mode Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @model instanceClass="com.ibm.ccl.soa.deploy.java.ClassAccessMode"
	 *        extendedMetaData="name='ClassAccessMode:Object' baseType='ClassAccessMode'"
	 * @generated
	 */
	EDataType getClassAccessModeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.java.JdbcTypeType <em>Jdbc Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Jdbc Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.java.JdbcTypeType"
	 *        extendedMetaData="name='JdbcTypeType:Object' baseType='JdbcTypeType'"
	 * @generated
	 */
	EDataType getJdbcTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.java.JREEdition <em>JRE Edition Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JRE Edition Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JREEdition
	 * @model instanceClass="com.ibm.ccl.soa.deploy.java.JREEdition"
	 *        extendedMetaData="name='JREEdition:Object' baseType='JREEdition'"
	 * @generated
	 */
	EDataType getJREEditionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.java.JREVersion <em>JRE Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JRE Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.java.JREVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.java.JREVersion"
	 *        extendedMetaData="name='JREVersion:Object' baseType='JREVersion'"
	 * @generated
	 */
	EDataType getJREVersionObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaFactory getJavaFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJavaDeployRoot()
		 * @generated
		 */
		EClass JAVA_DEPLOY_ROOT = eINSTANCE.getJavaDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JAVA_DEPLOY_ROOT__MIXED = eINSTANCE.getJavaDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getJavaDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getJavaDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Jdbc Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER = eINSTANCE.getJavaDeployRoot_CapabilityJdbcProvider();

		/**
		 * The meta object literal for the '<em><b>Capability Jdk</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__CAPABILITY_JDK = eINSTANCE.getJavaDeployRoot_CapabilityJdk();

		/**
		 * The meta object literal for the '<em><b>Capability Jre</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__CAPABILITY_JRE = eINSTANCE.getJavaDeployRoot_CapabilityJre();

		/**
		 * The meta object literal for the '<em><b>Capability Jvm Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG = eINSTANCE.getJavaDeployRoot_CapabilityJvmConfig();

		/**
		 * The meta object literal for the '<em><b>Unit Jdbc Provider Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT = eINSTANCE.getJavaDeployRoot_UnitJdbcProviderUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Jdk</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__UNIT_JDK = eINSTANCE.getJavaDeployRoot_UnitJdk();

		/**
		 * The meta object literal for the '<em><b>Unit Jre</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_DEPLOY_ROOT__UNIT_JRE = eINSTANCE.getJavaDeployRoot_UnitJre();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl <em>Jdbc Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcProvider()
		 * @generated
		 */
		EClass JDBC_PROVIDER = eINSTANCE.getJdbcProvider();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JDBC_PROVIDER__CLASSPATH = eINSTANCE.getJdbcProvider_Classpath();

		/**
		 * The meta object literal for the '<em><b>Implementation Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDBC_PROVIDER__IMPLEMENTATION_CLASS_NAME = eINSTANCE.getJdbcProvider_ImplementationClassName();

		/**
		 * The meta object literal for the '<em><b>Nativepath</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JDBC_PROVIDER__NATIVEPATH = eINSTANCE.getJdbcProvider_Nativepath();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDBC_PROVIDER__PROVIDER_NAME = eINSTANCE.getJdbcProvider_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Provider Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDBC_PROVIDER__PROVIDER_TYPE = eINSTANCE.getJdbcProvider_ProviderType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JdbcProviderUnitImpl <em>Jdbc Provider Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JdbcProviderUnitImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcProviderUnit()
		 * @generated
		 */
		EClass JDBC_PROVIDER_UNIT = eINSTANCE.getJdbcProviderUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JDKImpl <em>JDK</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JDKImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJDK()
		 * @generated
		 */
		EClass JDK = eINSTANCE.getJDK();

		/**
		 * The meta object literal for the '<em><b>Jdk Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JDK__JDK_VERSION = eINSTANCE.getJDK_JdkVersion();

		/**
		 * The meta object literal for the '<em><b>Other Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JDK__OTHER_VALUE = eINSTANCE.getJDK_OtherValue();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JDKUnitImpl <em>JDK Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JDKUnitImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJDKUnit()
		 * @generated
		 */
		EClass JDK_UNIT = eINSTANCE.getJDKUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JREImpl <em>JRE</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JREImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJRE()
		 * @generated
		 */
		EClass JRE = eINSTANCE.getJRE();

		/**
		 * The meta object literal for the '<em><b>Jre Edition</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JRE__JRE_EDITION = eINSTANCE.getJRE_JreEdition();

		/**
		 * The meta object literal for the '<em><b>Jre Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JRE__JRE_VERSION = eINSTANCE.getJRE_JreVersion();

		/**
		 * The meta object literal for the '<em><b>Other Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JRE__OTHER_VALUE = eINSTANCE.getJRE_OtherValue();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JREUnitImpl <em>JRE Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JREUnitImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREUnit()
		 * @generated
		 */
		EClass JRE_UNIT = eINSTANCE.getJREUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl <em>JVM Config</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJVMConfig()
		 * @generated
		 */
		EClass JVM_CONFIG = eINSTANCE.getJVMConfig();

		/**
		 * The meta object literal for the '<em><b>Boot Classpath</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__BOOT_CLASSPATH = eINSTANCE.getJVMConfig_BootClasspath();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JVM_CONFIG__CLASSPATH = eINSTANCE.getJVMConfig_Classpath();

		/**
		 * The meta object literal for the '<em><b>Debug Args</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JVM_CONFIG__DEBUG_ARGS = eINSTANCE.getJVMConfig_DebugArgs();

		/**
		 * The meta object literal for the '<em><b>Disable JIT</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JVM_CONFIG__DISABLE_JIT = eINSTANCE.getJVMConfig_DisableJIT();

		/**
		 * The meta object literal for the '<em><b>Executable Jarfile Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__EXECUTABLE_JARFILE_NAME = eINSTANCE.getJVMConfig_ExecutableJarfileName();

		/**
		 * The meta object literal for the '<em><b>Generic Jvm Arguments</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__GENERIC_JVM_ARGUMENTS = eINSTANCE.getJVMConfig_GenericJvmArguments();

		/**
		 * The meta object literal for the '<em><b>Initial Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__INITIAL_HEAP_SIZE = eINSTANCE.getJVMConfig_InitialHeapSize();

		/**
		 * The meta object literal for the '<em><b>Internal Class Access Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE = eINSTANCE.getJVMConfig_InternalClassAccessMode();

		/**
		 * The meta object literal for the '<em><b>Maximum Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__MAXIMUM_HEAP_SIZE = eINSTANCE.getJVMConfig_MaximumHeapSize();

		/**
		 * The meta object literal for the '<em><b>Run HProf</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JVM_CONFIG__RUN_HPROF = eINSTANCE.getJVMConfig_RunHProf();

		/**
		 * The meta object literal for the '<em><b>Verbose Mode Class</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__VERBOSE_MODE_CLASS = eINSTANCE.getJVMConfig_VerboseModeClass();

		/**
		 * The meta object literal for the '<em><b>Verbose Mode Garbage Collection</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION = eINSTANCE.getJVMConfig_VerboseModeGarbageCollection();

		/**
		 * The meta object literal for the '<em><b>Verbose Mode JNI</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVM_CONFIG__VERBOSE_MODE_JNI = eINSTANCE.getJVMConfig_VerboseModeJNI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.ClassAccessMode <em>Class Access Mode</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getClassAccessMode()
		 * @generated
		 */
		EEnum CLASS_ACCESS_MODE = eINSTANCE.getClassAccessMode();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.JdbcTypeType <em>Jdbc Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcTypeType()
		 * @generated
		 */
		EEnum JDBC_TYPE_TYPE = eINSTANCE.getJdbcTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.JREEdition <em>JRE Edition</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.JREEdition
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREEdition()
		 * @generated
		 */
		EEnum JRE_EDITION = eINSTANCE.getJREEdition();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.java.JREVersion <em>JRE Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.java.JREVersion
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREVersion()
		 * @generated
		 */
		EEnum JRE_VERSION = eINSTANCE.getJREVersion();

		/**
		 * The meta object literal for the '<em>Class Access Mode Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getClassAccessModeObject()
		 * @generated
		 */
		EDataType CLASS_ACCESS_MODE_OBJECT = eINSTANCE.getClassAccessModeObject();

		/**
		 * The meta object literal for the '<em>Jdbc Type Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.java.JdbcTypeType
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJdbcTypeTypeObject()
		 * @generated
		 */
		EDataType JDBC_TYPE_TYPE_OBJECT = eINSTANCE.getJdbcTypeTypeObject();

		/**
		 * The meta object literal for the '<em>JRE Edition Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.java.JREEdition
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREEditionObject()
		 * @generated
		 */
		EDataType JRE_EDITION_OBJECT = eINSTANCE.getJREEditionObject();

		/**
		 * The meta object literal for the '<em>JRE Version Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.java.JREVersion
		 * @see com.ibm.ccl.soa.deploy.java.impl.JavaPackageImpl#getJREVersionObject()
		 * @generated
		 */
		EDataType JRE_VERSION_OBJECT = eINSTANCE.getJREVersionObject();

	}

} //JavaPackage
