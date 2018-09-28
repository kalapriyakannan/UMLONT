/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;

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
 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory
 * @model kind="package"
 * @generated
 */
public interface DerbyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "derby"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/derby/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "derby"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DerbyPackage eINSTANCE = com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl <em>Database</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabase()
	 * @generated
	 */
	int DERBY_DATABASE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__ANNOTATIONS = DatabasePackage.DATABASE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__ARTIFACT_GROUP = DatabasePackage.DATABASE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__ARTIFACTS = DatabasePackage.DATABASE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__CONSTRAINT_GROUP = DatabasePackage.DATABASE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__CONSTRAINTS = DatabasePackage.DATABASE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DESCRIPTION = DatabasePackage.DATABASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DISPLAY_NAME = DatabasePackage.DATABASE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__MUTABLE = DatabasePackage.DATABASE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__NAME = DatabasePackage.DATABASE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__STEREOTYPES = DatabasePackage.DATABASE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__BUILD_VERSION = DatabasePackage.DATABASE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__LINK_TYPE = DatabasePackage.DATABASE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__ORIGIN = DatabasePackage.DATABASE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db Alias</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DB_ALIAS = DatabasePackage.DATABASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Db Drive</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DB_DRIVE = DatabasePackage.DATABASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DB_NAME = DatabasePackage.DATABASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Derby Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE__DERBY_VERSION = DatabasePackage.DATABASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_FEATURE_COUNT = DatabasePackage.DATABASE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseInstanceUnitImpl <em>Database Instance Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseInstanceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabaseInstanceUnit()
	 * @generated
	 */
	int DERBY_DATABASE_INSTANCE_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__ANNOTATIONS = DatabasePackage.DATABASE_INSTANCE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_INSTANCE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_INSTANCE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__ARTIFACT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__ARTIFACTS = DatabasePackage.DATABASE_INSTANCE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CONSTRAINT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CONSTRAINTS = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__DESCRIPTION = DatabasePackage.DATABASE_INSTANCE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__DISPLAY_NAME = DatabasePackage.DATABASE_INSTANCE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__MUTABLE = DatabasePackage.DATABASE_INSTANCE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__NAME = DatabasePackage.DATABASE_INSTANCE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CAPABILITY_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CAPABILITIES = DatabasePackage.DATABASE_INSTANCE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__REQUIREMENT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__REQUIREMENTS = DatabasePackage.DATABASE_INSTANCE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__UNIT_LINKS_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__UNIT_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CONSTRAINT_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__REALIZATION_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__STEREOTYPES = DatabasePackage.DATABASE_INSTANCE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__BUILD_VERSION = DatabasePackage.DATABASE_INSTANCE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CONCEPTUAL = DatabasePackage.DATABASE_INSTANCE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__CONFIGURATION_UNIT = DatabasePackage.DATABASE_INSTANCE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__GOAL_INSTALL_STATE = DatabasePackage.DATABASE_INSTANCE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__INIT_INSTALL_STATE = DatabasePackage.DATABASE_INSTANCE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__ORIGIN = DatabasePackage.DATABASE_INSTANCE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT__PUBLISH_INTENT = DatabasePackage.DATABASE_INSTANCE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Database Instance Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_INSTANCE_UNIT_FEATURE_COUNT = DatabasePackage.DATABASE_INSTANCE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseUnitImpl <em>Database Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseUnitImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabaseUnit()
	 * @generated
	 */
	int DERBY_DATABASE_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__ANNOTATIONS = DatabasePackage.DATABASE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__ARTIFACT_GROUP = DatabasePackage.DATABASE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__ARTIFACTS = DatabasePackage.DATABASE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CONSTRAINT_GROUP = DatabasePackage.DATABASE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CONSTRAINTS = DatabasePackage.DATABASE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__DESCRIPTION = DatabasePackage.DATABASE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__DISPLAY_NAME = DatabasePackage.DATABASE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__MUTABLE = DatabasePackage.DATABASE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__NAME = DatabasePackage.DATABASE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CAPABILITY_GROUP = DatabasePackage.DATABASE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CAPABILITIES = DatabasePackage.DATABASE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__REQUIREMENT_GROUP = DatabasePackage.DATABASE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__REQUIREMENTS = DatabasePackage.DATABASE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__UNIT_LINKS_GROUP = DatabasePackage.DATABASE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__UNIT_LINKS = DatabasePackage.DATABASE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CONSTRAINT_LINKS = DatabasePackage.DATABASE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__REALIZATION_LINKS = DatabasePackage.DATABASE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__STEREOTYPES = DatabasePackage.DATABASE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__BUILD_VERSION = DatabasePackage.DATABASE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CONCEPTUAL = DatabasePackage.DATABASE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__CONFIGURATION_UNIT = DatabasePackage.DATABASE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__GOAL_INSTALL_STATE = DatabasePackage.DATABASE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__INIT_INSTALL_STATE = DatabasePackage.DATABASE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__ORIGIN = DatabasePackage.DATABASE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT__PUBLISH_INTENT = DatabasePackage.DATABASE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Database Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DATABASE_UNIT_FEATURE_COUNT = DatabasePackage.DATABASE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDDLArtifactImpl <em>DDL Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDDLArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDDLArtifact()
	 * @generated
	 */
	int DERBY_DDL_ARTIFACT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__ANNOTATIONS = DatabasePackage.DDL_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__ATTRIBUTE_META_DATA = DatabasePackage.DDL_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__EXTENDED_ATTRIBUTES = DatabasePackage.DDL_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__ARTIFACT_GROUP = DatabasePackage.DDL_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__ARTIFACTS = DatabasePackage.DDL_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__CONSTRAINT_GROUP = DatabasePackage.DDL_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__CONSTRAINTS = DatabasePackage.DDL_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__DESCRIPTION = DatabasePackage.DDL_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__DISPLAY_NAME = DatabasePackage.DDL_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__MUTABLE = DatabasePackage.DDL_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__NAME = DatabasePackage.DDL_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT__FILE_UR_IS = DatabasePackage.DDL_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>DDL Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DDL_ARTIFACT_FEATURE_COUNT = DatabasePackage.DDL_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDeployRoot()
	 * @generated
	 */
	int DERBY_DEPLOY_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Artifact Derbyddl</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL = 3;

	/**
	 * The feature id for the '<em><b>Capability Derby Database</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE = 4;

	/**
	 * The feature id for the '<em><b>Capability Derby Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Unit Derby Database Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Unit Derby Database Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT = 7;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_DEPLOY_ROOT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyInstance()
	 * @generated
	 */
	int DERBY_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__ANNOTATIONS = DatabasePackage.DATABASE_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__ARTIFACT_GROUP = DatabasePackage.DATABASE_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__ARTIFACTS = DatabasePackage.DATABASE_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__CONSTRAINT_GROUP = DatabasePackage.DATABASE_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__CONSTRAINTS = DatabasePackage.DATABASE_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__DESCRIPTION = DatabasePackage.DATABASE_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__DISPLAY_NAME = DatabasePackage.DATABASE_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__MUTABLE = DatabasePackage.DATABASE_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__NAME = DatabasePackage.DATABASE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__STEREOTYPES = DatabasePackage.DATABASE_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__BUILD_VERSION = DatabasePackage.DATABASE_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__LINK_TYPE = DatabasePackage.DATABASE_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__ORIGIN = DatabasePackage.DATABASE_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__HOSTNAME = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__INSTANCE_NAME = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE__PORT = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERBY_INSTANCE_FEATURE_COUNT = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase
	 * @generated
	 */
	EClass getDerbyDatabase();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbAlias <em>Db Alias</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbAlias()
	 * @see #getDerbyDatabase()
	 * @generated
	 */
	EAttribute getDerbyDatabase_DbAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbDrive <em>Db Drive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Drive</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbDrive()
	 * @see #getDerbyDatabase()
	 * @generated
	 */
	EAttribute getDerbyDatabase_DbDrive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbName <em>Db Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbName()
	 * @see #getDerbyDatabase()
	 * @generated
	 */
	EAttribute getDerbyDatabase_DbName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDerbyVersion <em>Derby Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derby Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDerbyVersion()
	 * @see #getDerbyDatabase()
	 * @generated
	 */
	EAttribute getDerbyDatabase_DerbyVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit <em>Database Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit
	 * @generated
	 */
	EClass getDerbyDatabaseInstanceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit <em>Database Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit
	 * @generated
	 */
	EClass getDerbyDatabaseUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact <em>DDL Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DDL Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact
	 * @generated
	 */
	EClass getDerbyDDLArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot
	 * @generated
	 */
	EClass getDerbyDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getMixed()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EAttribute getDerbyDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXMLNSPrefixMap()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXSISchemaLocation()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getArtifactDerbyddl <em>Artifact Derbyddl</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact Derbyddl</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getArtifactDerbyddl()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_ArtifactDerbyddl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyDatabase <em>Capability Derby Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Derby Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyDatabase()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_CapabilityDerbyDatabase();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyInstance <em>Capability Derby Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Derby Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyInstance()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_CapabilityDerbyInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseInstanceUnit <em>Unit Derby Database Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Derby Database Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseInstanceUnit()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseUnit <em>Unit Derby Database Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Derby Database Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseUnit()
	 * @see #getDerbyDeployRoot()
	 * @generated
	 */
	EReference getDerbyDeployRoot_UnitDerbyDatabaseUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance
	 * @generated
	 */
	EClass getDerbyInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getHostname()
	 * @see #getDerbyInstance()
	 * @generated
	 */
	EAttribute getDerbyInstance_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getInstanceName <em>Instance Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getInstanceName()
	 * @see #getDerbyInstance()
	 * @generated
	 */
	EAttribute getDerbyInstance_InstanceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance#getPort()
	 * @see #getDerbyInstance()
	 * @generated
	 */
	EAttribute getDerbyInstance_Port();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DerbyFactory getDerbyFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabase()
		 * @generated
		 */
		EClass DERBY_DATABASE = eINSTANCE.getDerbyDatabase();

		/**
		 * The meta object literal for the '<em><b>Db Alias</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_DATABASE__DB_ALIAS = eINSTANCE.getDerbyDatabase_DbAlias();

		/**
		 * The meta object literal for the '<em><b>Db Drive</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_DATABASE__DB_DRIVE = eINSTANCE.getDerbyDatabase_DbDrive();

		/**
		 * The meta object literal for the '<em><b>Db Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_DATABASE__DB_NAME = eINSTANCE.getDerbyDatabase_DbName();

		/**
		 * The meta object literal for the '<em><b>Derby Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERBY_DATABASE__DERBY_VERSION = eINSTANCE.getDerbyDatabase_DerbyVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseInstanceUnitImpl <em>Database Instance Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseInstanceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabaseInstanceUnit()
		 * @generated
		 */
		EClass DERBY_DATABASE_INSTANCE_UNIT = eINSTANCE.getDerbyDatabaseInstanceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseUnitImpl <em>Database Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDatabaseUnitImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDatabaseUnit()
		 * @generated
		 */
		EClass DERBY_DATABASE_UNIT = eINSTANCE.getDerbyDatabaseUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDDLArtifactImpl <em>DDL Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDDLArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDDLArtifact()
		 * @generated
		 */
		EClass DERBY_DDL_ARTIFACT = eINSTANCE.getDerbyDDLArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyDeployRoot()
		 * @generated
		 */
		EClass DERBY_DEPLOY_ROOT = eINSTANCE.getDerbyDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_DEPLOY_ROOT__MIXED = eINSTANCE.getDerbyDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDerbyDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDerbyDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Artifact Derbyddl</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL = eINSTANCE.getDerbyDeployRoot_ArtifactDerbyddl();

		/**
		 * The meta object literal for the '<em><b>Capability Derby Database</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE = eINSTANCE.getDerbyDeployRoot_CapabilityDerbyDatabase();

		/**
		 * The meta object literal for the '<em><b>Capability Derby Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE = eINSTANCE.getDerbyDeployRoot_CapabilityDerbyInstance();

		/**
		 * The meta object literal for the '<em><b>Unit Derby Database Instance Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT = eINSTANCE.getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Derby Database Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT = eINSTANCE.getDerbyDeployRoot_UnitDerbyDatabaseUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyPackageImpl#getDerbyInstance()
		 * @generated
		 */
		EClass DERBY_INSTANCE = eINSTANCE.getDerbyInstance();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_INSTANCE__HOSTNAME = eINSTANCE.getDerbyInstance_Hostname();

		/**
		 * The meta object literal for the '<em><b>Instance Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERBY_INSTANCE__INSTANCE_NAME = eINSTANCE.getDerbyInstance_InstanceName();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DERBY_INSTANCE__PORT = eINSTANCE.getDerbyInstance_Port();

	}

} //DerbyPackage
