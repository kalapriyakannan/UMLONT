/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.ibm.ccl.soa.deploy.database.DatabaseFactory
 * @model kind="package"
 * @generated
 */
public interface DatabasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "database"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/database/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "database"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DatabasePackage eINSTANCE = com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl <em>Database</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabase()
	 * @generated
	 */
	int DATABASE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseComponentImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseComponent()
	 * @generated
	 */
	int DATABASE_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_COMPONENT_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseDefinitionImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseDefinition()
	 * @generated
	 */
	int DATABASE_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__ANNOTATIONS = CorePackage.SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__ATTRIBUTE_META_DATA = CorePackage.SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__EXTENDED_ATTRIBUTES = CorePackage.SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__ARTIFACT_GROUP = CorePackage.SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__ARTIFACTS = CorePackage.SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__CONSTRAINT_GROUP = CorePackage.SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__CONSTRAINTS = CorePackage.SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__DESCRIPTION = CorePackage.SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__DISPLAY_NAME = CorePackage.SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__MUTABLE = CorePackage.SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__NAME = CorePackage.SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__STEREOTYPES = CorePackage.SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__BUILD_VERSION = CorePackage.SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__LINK_TYPE = CorePackage.SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__ORIGIN = CorePackage.SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__INTERFACE_GROUP = CorePackage.SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__INTERFACE = CorePackage.SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__PROTOCOL = CorePackage.SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION__VERSION = CorePackage.SERVICE__VERSION;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEFINITION_FEATURE_COUNT = CorePackage.SERVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseDeployRoot()
	 * @generated
	 */
	int DATABASE_DEPLOY_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Artifact Ddl</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__ARTIFACT_DDL = 3;

	/**
	 * The feature id for the '<em><b>Artifact Dml</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__ARTIFACT_DML = 4;

	/**
	 * The feature id for the '<em><b>Capability Database</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE = 5;

	/**
	 * The feature id for the '<em><b>Capability Database Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Capability Sql User</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER = 7;

	/**
	 * The feature id for the '<em><b>Component Database</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE = 8;

	/**
	 * The feature id for the '<em><b>Interface Ddl</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__INTERFACE_DDL = 9;

	/**
	 * The feature id for the '<em><b>Service Database Definition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION = 10;

	/**
	 * The feature id for the '<em><b>Unit Database Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Unit Database Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Unit SQL Module</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE = 13;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_DEPLOY_ROOT_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseInstance()
	 * @generated
	 */
	int DATABASE_INSTANCE = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceUnitImpl <em>Instance Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseInstanceUnit()
	 * @generated
	 */
	int DATABASE_INSTANCE_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Instance Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_INSTANCE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseUnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseUnitImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseUnit()
	 * @generated
	 */
	int DATABASE_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DDLArtifactImpl <em>DDL Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DDLArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDDLArtifact()
	 * @generated
	 */
	int DDL_ARTIFACT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__ANNOTATIONS = CorePackage.FILE_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__ATTRIBUTE_META_DATA = CorePackage.FILE_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__EXTENDED_ATTRIBUTES = CorePackage.FILE_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__ARTIFACT_GROUP = CorePackage.FILE_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__ARTIFACTS = CorePackage.FILE_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__CONSTRAINT_GROUP = CorePackage.FILE_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__CONSTRAINTS = CorePackage.FILE_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__DESCRIPTION = CorePackage.FILE_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__DISPLAY_NAME = CorePackage.FILE_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__MUTABLE = CorePackage.FILE_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__NAME = CorePackage.FILE_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT__FILE_UR_IS = CorePackage.FILE_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>DDL Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_ARTIFACT_FEATURE_COUNT = CorePackage.FILE_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DDLInterfaceImpl <em>DDL Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DDLInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDDLInterface()
	 * @generated
	 */
	int DDL_INTERFACE = 8;

	/**
	 * The feature id for the '<em><b>Schema Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DDL_INTERFACE__SCHEMA_URI = CorePackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DDL Interface</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DDL_INTERFACE_FEATURE_COUNT = CorePackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.DMLArtifactImpl <em>DML Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.DMLArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDMLArtifact()
	 * @generated
	 */
	int DML_ARTIFACT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__ANNOTATIONS = CorePackage.FILE_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__ATTRIBUTE_META_DATA = CorePackage.FILE_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__EXTENDED_ATTRIBUTES = CorePackage.FILE_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__ARTIFACT_GROUP = CorePackage.FILE_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__ARTIFACTS = CorePackage.FILE_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__CONSTRAINT_GROUP = CorePackage.FILE_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__CONSTRAINTS = CorePackage.FILE_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__DESCRIPTION = CorePackage.FILE_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__DISPLAY_NAME = CorePackage.FILE_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__MUTABLE = CorePackage.FILE_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__NAME = CorePackage.FILE_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT__FILE_UR_IS = CorePackage.FILE_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>DML Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DML_ARTIFACT_FEATURE_COUNT = CorePackage.FILE_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.SQLModuleImpl <em>SQL Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.SQLModuleImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getSQLModule()
	 * @generated
	 */
	int SQL_MODULE = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SQL Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_MODULE_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.database.impl.SQLUserImpl <em>SQL User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.database.impl.SQLUserImpl
	 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getSQLUser()
	 * @generated
	 */
	int SQL_USER = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_USER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_USER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_USER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_USER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SQL_USER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER__USER_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SQL User</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_USER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.Database <em>Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.Database
	 * @generated
	 */
	EClass getDatabase();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseComponent <em>Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseComponent
	 * @generated
	 */
	EClass getDatabaseComponent();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDefinition
	 * @generated
	 */
	EClass getDatabaseDefinition();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot
	 * @generated
	 */
	EClass getDatabaseDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getMixed()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EAttribute getDatabaseDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXMLNSPrefixMap()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getXSISchemaLocation()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDdl <em>Artifact Ddl</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact Ddl</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDdl()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_ArtifactDdl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDml <em>Artifact Dml</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact Dml</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getArtifactDml()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_ArtifactDml();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabase <em>Capability Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabase()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_CapabilityDatabase();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabaseInstance <em>Capability Database Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Database Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilityDatabaseInstance()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_CapabilityDatabaseInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getComponentDatabase <em>Component Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getComponentDatabase()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_ComponentDatabase();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getInterfaceDdl <em>Interface Ddl</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Ddl</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getInterfaceDdl()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_InterfaceDdl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getServiceDatabaseDefinition <em>Service Database Definition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Database Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getServiceDatabaseDefinition()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_ServiceDatabaseDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilitySqlUser <em>Capability Sql User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Sql User</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getCapabilitySqlUser()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_CapabilitySqlUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseInstanceUnit <em>Unit Database Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Database Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseInstanceUnit()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_UnitDatabaseInstanceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseUnit <em>Unit Database Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Database Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitDatabaseUnit()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_UnitDatabaseUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitSQLModule <em>Unit SQL Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SQL Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseDeployRoot#getUnitSQLModule()
	 * @see #getDatabaseDeployRoot()
	 * @generated
	 */
	EReference getDatabaseDeployRoot_UnitSQLModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseInstance
	 * @generated
	 */
	EClass getDatabaseInstance();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit <em>Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit
	 * @generated
	 */
	EClass getDatabaseInstanceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DatabaseUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DatabaseUnit
	 * @generated
	 */
	EClass getDatabaseUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DDLArtifact <em>DDL Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DDL Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DDLArtifact
	 * @generated
	 */
	EClass getDDLArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DDLInterface <em>DDL Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DDL Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DDLInterface
	 * @generated
	 */
	EClass getDDLInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.database.DDLInterface#getSchemaUri <em>Schema Uri</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Uri</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DDLInterface#getSchemaUri()
	 * @see #getDDLInterface()
	 * @generated
	 */
	EAttribute getDDLInterface_SchemaUri();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.DMLArtifact <em>DML Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DML Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.DMLArtifact
	 * @generated
	 */
	EClass getDMLArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.SQLModule <em>SQL Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SQL Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.SQLModule
	 * @generated
	 */
	EClass getSQLModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.database.SQLUser <em>SQL User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SQL User</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.SQLUser
	 * @generated
	 */
	EClass getSQLUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.database.SQLUser#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.SQLUser#getUserId()
	 * @see #getSQLUser()
	 * @generated
	 */
	EAttribute getSQLUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.database.SQLUser#getUserPassword <em>User Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.database.SQLUser#getUserPassword()
	 * @see #getSQLUser()
	 * @generated
	 */
	EAttribute getSQLUser_UserPassword();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatabaseFactory getDatabaseFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabase()
		 * @generated
		 */
		EClass DATABASE = eINSTANCE.getDatabase();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseComponentImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseComponent()
		 * @generated
		 */
		EClass DATABASE_COMPONENT = eINSTANCE.getDatabaseComponent();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseDefinitionImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseDefinition()
		 * @generated
		 */
		EClass DATABASE_DEFINITION = eINSTANCE.getDatabaseDefinition();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseDeployRoot()
		 * @generated
		 */
		EClass DATABASE_DEPLOY_ROOT = eINSTANCE.getDatabaseDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATABASE_DEPLOY_ROOT__MIXED = eINSTANCE.getDatabaseDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDatabaseDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDatabaseDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Artifact Ddl</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__ARTIFACT_DDL = eINSTANCE.getDatabaseDeployRoot_ArtifactDdl();

		/**
		 * The meta object literal for the '<em><b>Artifact Dml</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__ARTIFACT_DML = eINSTANCE.getDatabaseDeployRoot_ArtifactDml();

		/**
		 * The meta object literal for the '<em><b>Capability Database</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE = eINSTANCE.getDatabaseDeployRoot_CapabilityDatabase();

		/**
		 * The meta object literal for the '<em><b>Capability Database Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__CAPABILITY_DATABASE_INSTANCE = eINSTANCE.getDatabaseDeployRoot_CapabilityDatabaseInstance();

		/**
		 * The meta object literal for the '<em><b>Component Database</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__COMPONENT_DATABASE = eINSTANCE.getDatabaseDeployRoot_ComponentDatabase();

		/**
		 * The meta object literal for the '<em><b>Interface Ddl</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__INTERFACE_DDL = eINSTANCE.getDatabaseDeployRoot_InterfaceDdl();

		/**
		 * The meta object literal for the '<em><b>Service Database Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__SERVICE_DATABASE_DEFINITION = eINSTANCE.getDatabaseDeployRoot_ServiceDatabaseDefinition();

		/**
		 * The meta object literal for the '<em><b>Capability Sql User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__CAPABILITY_SQL_USER = eINSTANCE.getDatabaseDeployRoot_CapabilitySqlUser();

		/**
		 * The meta object literal for the '<em><b>Unit Database Instance Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__UNIT_DATABASE_INSTANCE_UNIT = eINSTANCE.getDatabaseDeployRoot_UnitDatabaseInstanceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Database Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__UNIT_DATABASE_UNIT = eINSTANCE.getDatabaseDeployRoot_UnitDatabaseUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SQL Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_DEPLOY_ROOT__UNIT_SQL_MODULE = eINSTANCE.getDatabaseDeployRoot_UnitSQLModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseInstance()
		 * @generated
		 */
		EClass DATABASE_INSTANCE = eINSTANCE.getDatabaseInstance();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceUnitImpl <em>Instance Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseInstanceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseInstanceUnit()
		 * @generated
		 */
		EClass DATABASE_INSTANCE_UNIT = eINSTANCE.getDatabaseInstanceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DatabaseUnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabaseUnitImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDatabaseUnit()
		 * @generated
		 */
		EClass DATABASE_UNIT = eINSTANCE.getDatabaseUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DDLArtifactImpl <em>DDL Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DDLArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDDLArtifact()
		 * @generated
		 */
		EClass DDL_ARTIFACT = eINSTANCE.getDDLArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DDLInterfaceImpl <em>DDL Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DDLInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDDLInterface()
		 * @generated
		 */
		EClass DDL_INTERFACE = eINSTANCE.getDDLInterface();

		/**
		 * The meta object literal for the '<em><b>Schema Uri</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DDL_INTERFACE__SCHEMA_URI = eINSTANCE.getDDLInterface_SchemaUri();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.DMLArtifactImpl <em>DML Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.DMLArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getDMLArtifact()
		 * @generated
		 */
		EClass DML_ARTIFACT = eINSTANCE.getDMLArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.SQLModuleImpl <em>SQL Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.SQLModuleImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getSQLModule()
		 * @generated
		 */
		EClass SQL_MODULE = eINSTANCE.getSQLModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.database.impl.SQLUserImpl <em>SQL User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.database.impl.SQLUserImpl
		 * @see com.ibm.ccl.soa.deploy.database.impl.DatabasePackageImpl#getSQLUser()
		 * @generated
		 */
		EClass SQL_USER = eINSTANCE.getSQLUser();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SQL_USER__USER_ID = eINSTANCE.getSQLUser_UserId();

		/**
		 * The meta object literal for the '<em><b>User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_USER__USER_PASSWORD = eINSTANCE.getSQLUser_UserPassword();

	}

} //DatabasePackage
