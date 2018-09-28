/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

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
 * @see com.ibm.ccl.soa.deploy.db2.Db2Factory
 * @model kind="package"
 * @generated
 */
public interface Db2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "db2"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/db2/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "db2Deploy"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	Db2Package eINSTANCE = com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl <em>DB2 Base Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2BaseInstance()
	 * @generated
	 */
	int DB2_BASE_INSTANCE = 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientImpl <em>DB2 Admin Client</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminClient()
	 * @generated
	 */
	int DB2_ADMIN_CLIENT = 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientUnitImpl <em>DB2 Admin Client Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminClientUnit()
	 * @generated
	 */
	int DB2_ADMIN_CLIENT_UNIT = 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerImpl <em>DB2 Admin Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminServer()
	 * @generated
	 */
	int DB2_ADMIN_SERVER = 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerUnitImpl <em>DB2 Admin Server Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminServerUnit()
	 * @generated
	 */
	int DB2_ADMIN_SERVER_UNIT = 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientImpl <em>DB2 App Devel Client</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AppDevelClient()
	 * @generated
	 */
	int DB2_APP_DEVEL_CLIENT = 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientUnitImpl <em>DB2 App Devel Client Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AppDevelClientUnit()
	 * @generated
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT = 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl <em>DB2 Cataloged Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2CatalogedNode()
	 * @generated
	 */
	int DB2_CATALOGED_NODE = 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogUnitImpl <em>DB2 Catalog Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2CatalogUnit()
	 * @generated
	 */
	int DB2_CATALOG_UNIT = 9;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl <em>DB2 Client</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Client()
	 * @generated
	 */
	int DB2_CLIENT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Client Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__DB2_CLIENT_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT__INSTALL_DIR = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 Client</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__ANNOTATIONS = DB2_CLIENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__ATTRIBUTE_META_DATA = DB2_CLIENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__EXTENDED_ATTRIBUTES = DB2_CLIENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__ARTIFACT_GROUP = DB2_CLIENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__ARTIFACTS = DB2_CLIENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__CONSTRAINT_GROUP = DB2_CLIENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__CONSTRAINTS = DB2_CLIENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__DESCRIPTION = DB2_CLIENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__DISPLAY_NAME = DB2_CLIENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__MUTABLE = DB2_CLIENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__NAME = DB2_CLIENT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__STEREOTYPES = DB2_CLIENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__BUILD_VERSION = DB2_CLIENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__LINK_TYPE = DB2_CLIENT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__ORIGIN = DB2_CLIENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Client Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__DB2_CLIENT_VERSION = DB2_CLIENT__DB2_CLIENT_VERSION;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__INSTALL_DIR = DB2_CLIENT__INSTALL_DIR;

	/**
	 * The feature id for the '<em><b>Db2 Product Lang</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG = DB2_CLIENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DB2 Admin Client</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_FEATURE_COUNT = DB2_CLIENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseClientUnitImpl <em>DB2 Base Client Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2BaseClientUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2BaseClientUnit()
	 * @generated
	 */
	int DB2_BASE_CLIENT_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;
	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */

	int DB2_BASE_CLIENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Base Client Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_CLIENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__ANNOTATIONS = DB2_BASE_CLIENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__ATTRIBUTE_META_DATA = DB2_BASE_CLIENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__EXTENDED_ATTRIBUTES = DB2_BASE_CLIENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__ARTIFACT_GROUP = DB2_BASE_CLIENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__ARTIFACTS = DB2_BASE_CLIENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CONSTRAINT_GROUP = DB2_BASE_CLIENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CONSTRAINTS = DB2_BASE_CLIENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__DESCRIPTION = DB2_BASE_CLIENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__DISPLAY_NAME = DB2_BASE_CLIENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__MUTABLE = DB2_BASE_CLIENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__NAME = DB2_BASE_CLIENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CAPABILITY_GROUP = DB2_BASE_CLIENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CAPABILITIES = DB2_BASE_CLIENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__REQUIREMENT_GROUP = DB2_BASE_CLIENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__REQUIREMENTS = DB2_BASE_CLIENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__UNIT_LINKS_GROUP = DB2_BASE_CLIENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__UNIT_LINKS = DB2_BASE_CLIENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CONSTRAINT_LINKS = DB2_BASE_CLIENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__REALIZATION_LINKS = DB2_BASE_CLIENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__STEREOTYPES = DB2_BASE_CLIENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__BUILD_VERSION = DB2_BASE_CLIENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CONCEPTUAL = DB2_BASE_CLIENT_UNIT__CONCEPTUAL;
	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__CONFIGURATION_UNIT = DB2_BASE_CLIENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__GOAL_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__INIT_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__ORIGIN = DB2_BASE_CLIENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT__PUBLISH_INTENT = DB2_BASE_CLIENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Admin Client Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_CLIENT_UNIT_FEATURE_COUNT = DB2_BASE_CLIENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>DB2 Admin Server</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Admin Server Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_ADMIN_SERVER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__ANNOTATIONS = DB2_CLIENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__ATTRIBUTE_META_DATA = DB2_CLIENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__EXTENDED_ATTRIBUTES = DB2_CLIENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__ARTIFACT_GROUP = DB2_CLIENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__ARTIFACTS = DB2_CLIENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__CONSTRAINT_GROUP = DB2_CLIENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__CONSTRAINTS = DB2_CLIENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__DESCRIPTION = DB2_CLIENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__DISPLAY_NAME = DB2_CLIENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__MUTABLE = DB2_CLIENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__NAME = DB2_CLIENT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__STEREOTYPES = DB2_CLIENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__BUILD_VERSION = DB2_CLIENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__LINK_TYPE = DB2_CLIENT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__ORIGIN = DB2_CLIENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Client Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__DB2_CLIENT_VERSION = DB2_CLIENT__DB2_CLIENT_VERSION;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__INSTALL_DIR = DB2_CLIENT__INSTALL_DIR;

	/**
	 * The feature id for the '<em><b>Db2 Product Lang</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT__DB2_PRODUCT_LANG = DB2_CLIENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DB2 App Devel Client</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_FEATURE_COUNT = DB2_CLIENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__ANNOTATIONS = DB2_BASE_CLIENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__ATTRIBUTE_META_DATA = DB2_BASE_CLIENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__EXTENDED_ATTRIBUTES = DB2_BASE_CLIENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__ARTIFACT_GROUP = DB2_BASE_CLIENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__ARTIFACTS = DB2_BASE_CLIENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CONSTRAINT_GROUP = DB2_BASE_CLIENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CONSTRAINTS = DB2_BASE_CLIENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__DESCRIPTION = DB2_BASE_CLIENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__DISPLAY_NAME = DB2_BASE_CLIENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__MUTABLE = DB2_BASE_CLIENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__NAME = DB2_BASE_CLIENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CAPABILITY_GROUP = DB2_BASE_CLIENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CAPABILITIES = DB2_BASE_CLIENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__REQUIREMENT_GROUP = DB2_BASE_CLIENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__REQUIREMENTS = DB2_BASE_CLIENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__UNIT_LINKS_GROUP = DB2_BASE_CLIENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__UNIT_LINKS = DB2_BASE_CLIENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CONSTRAINT_LINKS = DB2_BASE_CLIENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__REALIZATION_LINKS = DB2_BASE_CLIENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__STEREOTYPES = DB2_BASE_CLIENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__BUILD_VERSION = DB2_BASE_CLIENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CONCEPTUAL = DB2_BASE_CLIENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__CONFIGURATION_UNIT = DB2_BASE_CLIENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__GOAL_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__INIT_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__ORIGIN = DB2_BASE_CLIENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT__PUBLISH_INTENT = DB2_BASE_CLIENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 App Devel Client Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_APP_DEVEL_CLIENT_UNIT_FEATURE_COUNT = DB2_BASE_CLIENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__ANNOTATIONS = DatabasePackage.DATABASE_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__ARTIFACT_GROUP = DatabasePackage.DATABASE_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__ARTIFACTS = DatabasePackage.DATABASE_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__CONSTRAINT_GROUP = DatabasePackage.DATABASE_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__CONSTRAINTS = DatabasePackage.DATABASE_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__DESCRIPTION = DatabasePackage.DATABASE_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__DISPLAY_NAME = DatabasePackage.DATABASE_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__MUTABLE = DatabasePackage.DATABASE_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__NAME = DatabasePackage.DATABASE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__STEREOTYPES = DatabasePackage.DATABASE_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__BUILD_VERSION = DatabasePackage.DATABASE_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__LINK_TYPE = DatabasePackage.DATABASE_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__ORIGIN = DatabasePackage.DATABASE_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__DB2_INSTANCE_NAME = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE__DB2_VERSION = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 Base Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_BASE_INSTANCE_FEATURE_COUNT = DatabasePackage.DATABASE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Das Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__DAS_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__HOSTNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__NODE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__NODE_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>DB2 Cataloged Node</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOGED_NODE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Catalog Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CATALOG_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceImpl <em>DB2 Client Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2ClientInstance()
	 * @generated
	 */
	int DB2_CLIENT_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__ANNOTATIONS = DB2_BASE_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__ATTRIBUTE_META_DATA = DB2_BASE_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__EXTENDED_ATTRIBUTES = DB2_BASE_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__ARTIFACT_GROUP = DB2_BASE_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__ARTIFACTS = DB2_BASE_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__CONSTRAINT_GROUP = DB2_BASE_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__CONSTRAINTS = DB2_BASE_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__DESCRIPTION = DB2_BASE_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__DISPLAY_NAME = DB2_BASE_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__MUTABLE = DB2_BASE_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__NAME = DB2_BASE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__STEREOTYPES = DB2_BASE_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__BUILD_VERSION = DB2_BASE_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__LINK_TYPE = DB2_BASE_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__ORIGIN = DB2_BASE_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__DB2_INSTANCE_NAME = DB2_BASE_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE__DB2_VERSION = DB2_BASE_INSTANCE__DB2_VERSION;

	/**
	 * The number of structural features of the '<em>DB2 Client Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_FEATURE_COUNT = DB2_BASE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceUnitImpl <em>DB2 Client Instance Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2ClientInstanceUnit()
	 * @generated
	 */
	int DB2_CLIENT_INSTANCE_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Client Instance Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_CLIENT_INSTANCE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl <em>DB2 Database</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Database()
	 * @generated
	 */
	int DB2_DATABASE = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__ANNOTATIONS = DatabasePackage.DATABASE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__ARTIFACT_GROUP = DatabasePackage.DATABASE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__ARTIFACTS = DatabasePackage.DATABASE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__CONSTRAINT_GROUP = DatabasePackage.DATABASE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__CONSTRAINTS = DatabasePackage.DATABASE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DESCRIPTION = DatabasePackage.DATABASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DISPLAY_NAME = DatabasePackage.DATABASE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__MUTABLE = DatabasePackage.DATABASE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__NAME = DatabasePackage.DATABASE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__STEREOTYPES = DatabasePackage.DATABASE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__BUILD_VERSION = DatabasePackage.DATABASE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__LINK_TYPE = DatabasePackage.DATABASE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__ORIGIN = DatabasePackage.DATABASE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Catalog Sp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__CATALOG_SP = DatabasePackage.DATABASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code Set</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__CODE_SET = DatabasePackage.DATABASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Create Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__CREATE_PATH = DatabasePackage.DATABASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DB2_VERSION = DatabasePackage.DATABASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Db Alias</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DB_ALIAS = DatabasePackage.DATABASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Db Drive</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DB_DRIVE = DatabasePackage.DATABASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DB_NAME = DatabasePackage.DATABASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Dft Extent Size</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__DFT_EXTENT_SIZE = DatabasePackage.DATABASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__PAGE_SIZE = DatabasePackage.DATABASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Temp Sp</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__TEMP_SP = DatabasePackage.DATABASE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Territory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__TERRITORY = DatabasePackage.DATABASE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>User Sp</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE__USER_SP = DatabasePackage.DATABASE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>DB2 Database</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_FEATURE_COUNT = DatabasePackage.DATABASE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseUnitImpl <em>DB2 Database Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2DatabaseUnit()
	 * @generated
	 */
	int DB2_DATABASE_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__ANNOTATIONS = DatabasePackage.DATABASE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__ARTIFACT_GROUP = DatabasePackage.DATABASE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__ARTIFACTS = DatabasePackage.DATABASE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CONSTRAINT_GROUP = DatabasePackage.DATABASE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CONSTRAINTS = DatabasePackage.DATABASE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__DESCRIPTION = DatabasePackage.DATABASE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__DISPLAY_NAME = DatabasePackage.DATABASE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__MUTABLE = DatabasePackage.DATABASE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__NAME = DatabasePackage.DATABASE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CAPABILITY_GROUP = DatabasePackage.DATABASE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CAPABILITIES = DatabasePackage.DATABASE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__REQUIREMENT_GROUP = DatabasePackage.DATABASE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__REQUIREMENTS = DatabasePackage.DATABASE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__UNIT_LINKS_GROUP = DatabasePackage.DATABASE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__UNIT_LINKS = DatabasePackage.DATABASE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CONSTRAINT_LINKS = DatabasePackage.DATABASE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__REALIZATION_LINKS = DatabasePackage.DATABASE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__STEREOTYPES = DatabasePackage.DATABASE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__BUILD_VERSION = DatabasePackage.DATABASE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CONCEPTUAL = DatabasePackage.DATABASE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__CONFIGURATION_UNIT = DatabasePackage.DATABASE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__GOAL_INSTALL_STATE = DatabasePackage.DATABASE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__INIT_INSTALL_STATE = DatabasePackage.DATABASE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__ORIGIN = DatabasePackage.DATABASE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT__PUBLISH_INTENT = DatabasePackage.DATABASE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Database Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DATABASE_UNIT_FEATURE_COUNT = DatabasePackage.DATABASE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DDLArtifactImpl <em>DB2DDL Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DDLArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2DDLArtifact()
	 * @generated
	 */
	int DB2DDL_ARTIFACT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__ANNOTATIONS = DatabasePackage.DDL_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__ATTRIBUTE_META_DATA = DatabasePackage.DDL_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__EXTENDED_ATTRIBUTES = DatabasePackage.DDL_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__ARTIFACT_GROUP = DatabasePackage.DDL_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__ARTIFACTS = DatabasePackage.DDL_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__CONSTRAINT_GROUP = DatabasePackage.DDL_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__CONSTRAINTS = DatabasePackage.DDL_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__DESCRIPTION = DatabasePackage.DDL_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__DISPLAY_NAME = DatabasePackage.DDL_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__MUTABLE = DatabasePackage.DDL_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__NAME = DatabasePackage.DDL_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT__FILE_UR_IS = DatabasePackage.DDL_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>DB2DDL Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2DDL_ARTIFACT_FEATURE_COUNT = DatabasePackage.DDL_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDb2DeployRoot()
	 * @generated
	 */
	int DB2_DEPLOY_ROOT = 16;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Db2 Admin Client</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT = 3;

	/**
	 * The feature id for the '<em><b>Capability Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER = 4;

	/**
	 * The feature id for the '<em><b>Capability Db2 App Devel Client</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT = 5;

	/**
	 * The feature id for the '<em><b>Capability Db2 Base Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Capability Db2 Cataloged Node</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE = 7;

	/**
	 * The feature id for the '<em><b>Capability Db2 Client</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT = 8;

	/**
	 * The feature id for the '<em><b>Capability Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Capability Db2 Database</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE = 10;

	/**
	 * The feature id for the '<em><b>Capability Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Capability Db2 Jdbc Driver</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER = 12;

	/**
	 * The feature id for the '<em><b>Capability Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM = 13;

	/**
	 * The feature id for the '<em><b>Capability Unix Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER = 14;

	/**
	 * The feature id for the '<em><b>Capability Unix Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE = 15;

	/**
	 * The feature id for the '<em><b>Capability Unix Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE = 16;

	/**
	 * The feature id for the '<em><b>Capability Unix Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM = 17;

	/**
	 * The feature id for the '<em><b>Capability Windows Db2 Admin Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER = 18;

	/**
	 * The feature id for the '<em><b>Capability Windows Db2 Client Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE = 19;

	/**
	 * The feature id for the '<em><b>Capability Windows Db2 Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE = 20;

	/**
	 * The feature id for the '<em><b>Capability Windows Db2 System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM = 21;

	/**
	 * The feature id for the '<em><b>Unit Db2 Admin Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Unit Db2 Admin Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Unit Db2 App Devel Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT = 24;

	/**
	 * The feature id for the '<em><b>Unit Db2 Base Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Unit Db2 Catalog Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT = 26;

	/**
	 * The feature id for the '<em><b>Unit Db2 Client Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Unit Db2 Database Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT = 28;

	/**
	 * The feature id for the '<em><b>Unit Db2ddl</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2DDL = 29;

	/**
	 * The feature id for the '<em><b>Unit Db2 Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT = 30;

	/**
	 * The feature id for the '<em><b>Unit Db2 Node Catalog Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT = 31;

	/**
	 * The feature id for the '<em><b>Unit Db2 Runtime Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT = 32;

	/**
	 * The feature id for the '<em><b>Unit Db2 System Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT = 33;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_DEPLOY_ROOT_FEATURE_COUNT = 34;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl <em>DB2 Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Instance()
	 * @generated
	 */
	int DB2_INSTANCE = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__ANNOTATIONS = DB2_BASE_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__ATTRIBUTE_META_DATA = DB2_BASE_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__EXTENDED_ATTRIBUTES = DB2_BASE_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__ARTIFACT_GROUP = DB2_BASE_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__ARTIFACTS = DB2_BASE_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__CONSTRAINT_GROUP = DB2_BASE_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__CONSTRAINTS = DB2_BASE_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__DESCRIPTION = DB2_BASE_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__DISPLAY_NAME = DB2_BASE_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__MUTABLE = DB2_BASE_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__NAME = DB2_BASE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__STEREOTYPES = DB2_BASE_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__BUILD_VERSION = DB2_BASE_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__LINK_TYPE = DB2_BASE_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__ORIGIN = DB2_BASE_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__DB2_INSTANCE_NAME = DB2_BASE_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__DB2_VERSION = DB2_BASE_INSTANCE__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__AUTO_START = DB2_BASE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__HOSTNAME = DB2_BASE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__PASSWORD = DB2_BASE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__PORT = DB2_BASE_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE__USERNAME = DB2_BASE_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>DB2 Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_FEATURE_COUNT = DB2_BASE_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceUnitImpl <em>DB2 Instance Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstanceUnit()
	 * @generated
	 */
	int DB2_INSTANCE_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__ANNOTATIONS = DatabasePackage.DATABASE_INSTANCE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__ATTRIBUTE_META_DATA = DatabasePackage.DATABASE_INSTANCE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__EXTENDED_ATTRIBUTES = DatabasePackage.DATABASE_INSTANCE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__ARTIFACT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__ARTIFACTS = DatabasePackage.DATABASE_INSTANCE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CONSTRAINT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CONSTRAINTS = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__DESCRIPTION = DatabasePackage.DATABASE_INSTANCE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__DISPLAY_NAME = DatabasePackage.DATABASE_INSTANCE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__MUTABLE = DatabasePackage.DATABASE_INSTANCE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__NAME = DatabasePackage.DATABASE_INSTANCE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CAPABILITY_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CAPABILITIES = DatabasePackage.DATABASE_INSTANCE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__REQUIREMENT_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__REQUIREMENTS = DatabasePackage.DATABASE_INSTANCE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__UNIT_LINKS_GROUP = DatabasePackage.DATABASE_INSTANCE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__UNIT_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CONSTRAINT_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__REALIZATION_LINKS = DatabasePackage.DATABASE_INSTANCE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__STEREOTYPES = DatabasePackage.DATABASE_INSTANCE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__BUILD_VERSION = DatabasePackage.DATABASE_INSTANCE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CONCEPTUAL = DatabasePackage.DATABASE_INSTANCE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__CONFIGURATION_UNIT = DatabasePackage.DATABASE_INSTANCE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__GOAL_INSTALL_STATE = DatabasePackage.DATABASE_INSTANCE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__INIT_INSTALL_STATE = DatabasePackage.DATABASE_INSTANCE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__ORIGIN = DatabasePackage.DATABASE_INSTANCE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT__PUBLISH_INTENT = DatabasePackage.DATABASE_INSTANCE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Instance Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_INSTANCE_UNIT_FEATURE_COUNT = DatabasePackage.DATABASE_INSTANCE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl <em>DB2 Jdbc Driver</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2JdbcDriver()
	 * @generated
	 */
	int DB2_JDBC_DRIVER = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__CLASSNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Driver Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__DRIVER_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Jdbc Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER__JDBC_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>DB2 Jdbc Driver</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_JDBC_DRIVER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2NodeCatalogUnitImpl <em>DB2 Node Catalog Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2NodeCatalogUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2NodeCatalogUnit()
	 * @generated
	 */
	int DB2_NODE_CATALOG_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Node Catalog Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_NODE_CATALOG_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2RuntimeClientUnitImpl <em>DB2 Runtime Client Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2RuntimeClientUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2RuntimeClientUnit()
	 * @generated
	 */
	int DB2_RUNTIME_CLIENT_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__ANNOTATIONS = DB2_BASE_CLIENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__ATTRIBUTE_META_DATA = DB2_BASE_CLIENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__EXTENDED_ATTRIBUTES = DB2_BASE_CLIENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__ARTIFACT_GROUP = DB2_BASE_CLIENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__ARTIFACTS = DB2_BASE_CLIENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CONSTRAINT_GROUP = DB2_BASE_CLIENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CONSTRAINTS = DB2_BASE_CLIENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__DESCRIPTION = DB2_BASE_CLIENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__DISPLAY_NAME = DB2_BASE_CLIENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__MUTABLE = DB2_BASE_CLIENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__NAME = DB2_BASE_CLIENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CAPABILITY_GROUP = DB2_BASE_CLIENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CAPABILITIES = DB2_BASE_CLIENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__REQUIREMENT_GROUP = DB2_BASE_CLIENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__REQUIREMENTS = DB2_BASE_CLIENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__UNIT_LINKS_GROUP = DB2_BASE_CLIENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__UNIT_LINKS = DB2_BASE_CLIENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CONSTRAINT_LINKS = DB2_BASE_CLIENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__REALIZATION_LINKS = DB2_BASE_CLIENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__STEREOTYPES = DB2_BASE_CLIENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__BUILD_VERSION = DB2_BASE_CLIENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CONCEPTUAL = DB2_BASE_CLIENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__CONFIGURATION_UNIT = DB2_BASE_CLIENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__GOAL_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__INIT_INSTALL_STATE = DB2_BASE_CLIENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__ORIGIN = DB2_BASE_CLIENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT__PUBLISH_INTENT = DB2_BASE_CLIENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Runtime Client Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_RUNTIME_CLIENT_UNIT_FEATURE_COUNT = DB2_BASE_CLIENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl <em>DB2 System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2System()
	 * @generated
	 */
	int DB2_SYSTEM = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Product Lang</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__DB2_PRODUCT_LANG = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__DB2_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM__INSTALL_DIR = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DB2 System</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemUnitImpl <em>DB2 System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2SystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2SystemUnit()
	 * @generated
	 */
	int DB2_SYSTEM_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 System Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DB2_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl <em>Unix DB2 Admin Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2AdminServer()
	 * @generated
	 */
	int UNIX_DB2_ADMIN_SERVER = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__ANNOTATIONS = DB2_ADMIN_SERVER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__ATTRIBUTE_META_DATA = DB2_ADMIN_SERVER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__EXTENDED_ATTRIBUTES = DB2_ADMIN_SERVER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__ARTIFACT_GROUP = DB2_ADMIN_SERVER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__ARTIFACTS = DB2_ADMIN_SERVER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__CONSTRAINT_GROUP = DB2_ADMIN_SERVER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__CONSTRAINTS = DB2_ADMIN_SERVER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DESCRIPTION = DB2_ADMIN_SERVER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DISPLAY_NAME = DB2_ADMIN_SERVER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__MUTABLE = DB2_ADMIN_SERVER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__NAME = DB2_ADMIN_SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__STEREOTYPES = DB2_ADMIN_SERVER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__BUILD_VERSION = DB2_ADMIN_SERVER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__LINK_TYPE = DB2_ADMIN_SERVER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__ORIGIN = DB2_ADMIN_SERVER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Das GID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DAS_GID = DB2_ADMIN_SERVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Das Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME = DB2_ADMIN_SERVER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Das UID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DAS_UID = DB2_ADMIN_SERVER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Das User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME = DB2_ADMIN_SERVER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Das User Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD = DB2_ADMIN_SERVER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Unix DB2 Admin Server</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_ADMIN_SERVER_FEATURE_COUNT = DB2_ADMIN_SERVER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl <em>Unix DB2 Client Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2ClientInstance()
	 * @generated
	 */
	int UNIX_DB2_CLIENT_INSTANCE = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__ANNOTATIONS = DB2_CLIENT_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__ATTRIBUTE_META_DATA = DB2_CLIENT_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__EXTENDED_ATTRIBUTES = DB2_CLIENT_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__ARTIFACT_GROUP = DB2_CLIENT_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__ARTIFACTS = DB2_CLIENT_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__CONSTRAINT_GROUP = DB2_CLIENT_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__CONSTRAINTS = DB2_CLIENT_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__DESCRIPTION = DB2_CLIENT_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__DISPLAY_NAME = DB2_CLIENT_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__MUTABLE = DB2_CLIENT_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__NAME = DB2_CLIENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__STEREOTYPES = DB2_CLIENT_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__BUILD_VERSION = DB2_CLIENT_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__LINK_TYPE = DB2_CLIENT_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__ORIGIN = DB2_CLIENT_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__DB2_INSTANCE_NAME = DB2_CLIENT_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__DB2_VERSION = DB2_CLIENT_INSTANCE__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Authentication Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fenced GID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__FENCED_GID = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fenced Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fenced UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__FENCED_UID = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fenced User Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fenced User Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>GID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__GID = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Instance Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__PASSWORD = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__UID = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__USERNAME = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Word Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Unix DB2 Client Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_CLIENT_INSTANCE_FEATURE_COUNT = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2InstanceImpl <em>Unix DB2 Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2InstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2Instance()
	 * @generated
	 */
	int UNIX_DB2_INSTANCE = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__ANNOTATIONS = DB2_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__ATTRIBUTE_META_DATA = DB2_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__EXTENDED_ATTRIBUTES = DB2_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__ARTIFACT_GROUP = DB2_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__ARTIFACTS = DB2_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__CONSTRAINT_GROUP = DB2_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__CONSTRAINTS = DB2_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__DESCRIPTION = DB2_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__DISPLAY_NAME = DB2_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__MUTABLE = DB2_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__NAME = DB2_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__STEREOTYPES = DB2_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__BUILD_VERSION = DB2_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__LINK_TYPE = DB2_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__ORIGIN = DB2_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__DB2_INSTANCE_NAME = DB2_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__DB2_VERSION = DB2_INSTANCE__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__AUTO_START = DB2_INSTANCE__AUTO_START;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__HOSTNAME = DB2_INSTANCE__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__PASSWORD = DB2_INSTANCE__PASSWORD;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__PORT = DB2_INSTANCE__PORT;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__USERNAME = DB2_INSTANCE__USERNAME;

	/**
	 * The feature id for the '<em><b>Authentication Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__AUTHENTICATION_TYPE = DB2_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fenced GID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__FENCED_GID = DB2_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fenced Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__FENCED_GROUP_NAME = DB2_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fenced UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__FENCED_UID = DB2_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fenced User Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__FENCED_USER_NAME = DB2_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fenced User Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__FENCED_USER_PASSWORD = DB2_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>GID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__GID = DB2_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__GROUP_NAME = DB2_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Instance Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__INSTANCE_TYPE = DB2_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__UID = DB2_INSTANCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Word Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE__WORD_WIDTH = DB2_INSTANCE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Unix DB2 Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_INSTANCE_FEATURE_COUNT = DB2_INSTANCE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2SystemImpl <em>Unix DB2 System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2SystemImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2System()
	 * @generated
	 */
	int UNIX_DB2_SYSTEM = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__ANNOTATIONS = DB2_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__ATTRIBUTE_META_DATA = DB2_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__EXTENDED_ATTRIBUTES = DB2_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__ARTIFACT_GROUP = DB2_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__ARTIFACTS = DB2_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__CONSTRAINT_GROUP = DB2_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__CONSTRAINTS = DB2_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__DESCRIPTION = DB2_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__DISPLAY_NAME = DB2_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__MUTABLE = DB2_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__NAME = DB2_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__STEREOTYPES = DB2_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__BUILD_VERSION = DB2_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__LINK_TYPE = DB2_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__ORIGIN = DB2_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Product Lang</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__DB2_PRODUCT_LANG = DB2_SYSTEM__DB2_PRODUCT_LANG;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__DB2_VERSION = DB2_SYSTEM__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM__INSTALL_DIR = DB2_SYSTEM__INSTALL_DIR;

	/**
	 * The number of structural features of the '<em>Unix DB2 System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DB2_SYSTEM_FEATURE_COUNT = DB2_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2AdminServerImpl <em>Windows DB2 Admin Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2AdminServerImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2AdminServer()
	 * @generated
	 */
	int WINDOWS_DB2_ADMIN_SERVER = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__ANNOTATIONS = DB2_ADMIN_SERVER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__ATTRIBUTE_META_DATA = DB2_ADMIN_SERVER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__EXTENDED_ATTRIBUTES = DB2_ADMIN_SERVER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__ARTIFACT_GROUP = DB2_ADMIN_SERVER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__ARTIFACTS = DB2_ADMIN_SERVER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__CONSTRAINT_GROUP = DB2_ADMIN_SERVER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__CONSTRAINTS = DB2_ADMIN_SERVER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__DESCRIPTION = DB2_ADMIN_SERVER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__DISPLAY_NAME = DB2_ADMIN_SERVER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__MUTABLE = DB2_ADMIN_SERVER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__NAME = DB2_ADMIN_SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__STEREOTYPES = DB2_ADMIN_SERVER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__BUILD_VERSION = DB2_ADMIN_SERVER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__LINK_TYPE = DB2_ADMIN_SERVER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__ORIGIN = DB2_ADMIN_SERVER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Das Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN = DB2_ADMIN_SERVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Windows DB2 Admin Server</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_ADMIN_SERVER_FEATURE_COUNT = DB2_ADMIN_SERVER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2ClientInstanceImpl <em>Windows DB2 Client Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2ClientInstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2ClientInstance()
	 * @generated
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__ANNOTATIONS = DB2_CLIENT_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__ATTRIBUTE_META_DATA = DB2_CLIENT_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__EXTENDED_ATTRIBUTES = DB2_CLIENT_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__ARTIFACT_GROUP = DB2_CLIENT_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__ARTIFACTS = DB2_CLIENT_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__CONSTRAINT_GROUP = DB2_CLIENT_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__CONSTRAINTS = DB2_CLIENT_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__DESCRIPTION = DB2_CLIENT_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__DISPLAY_NAME = DB2_CLIENT_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__MUTABLE = DB2_CLIENT_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__NAME = DB2_CLIENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__STEREOTYPES = DB2_CLIENT_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__BUILD_VERSION = DB2_CLIENT_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__LINK_TYPE = DB2_CLIENT_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__ORIGIN = DB2_CLIENT_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__DB2_INSTANCE_NAME = DB2_CLIENT_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__DB2_VERSION = DB2_CLIENT_INSTANCE__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Default Instance</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__DEFAULT_INSTANCE = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE__INSTANCE_TYPE = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Windows DB2 Client Instance</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_CLIENT_INSTANCE_FEATURE_COUNT = DB2_CLIENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl <em>Windows DB2 Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2Instance()
	 * @generated
	 */
	int WINDOWS_DB2_INSTANCE = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__ANNOTATIONS = DB2_INSTANCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__ATTRIBUTE_META_DATA = DB2_INSTANCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__EXTENDED_ATTRIBUTES = DB2_INSTANCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__ARTIFACT_GROUP = DB2_INSTANCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__ARTIFACTS = DB2_INSTANCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__CONSTRAINT_GROUP = DB2_INSTANCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__CONSTRAINTS = DB2_INSTANCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__DESCRIPTION = DB2_INSTANCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__DISPLAY_NAME = DB2_INSTANCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__MUTABLE = DB2_INSTANCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__NAME = DB2_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__STEREOTYPES = DB2_INSTANCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__BUILD_VERSION = DB2_INSTANCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__LINK_TYPE = DB2_INSTANCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__ORIGIN = DB2_INSTANCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__DB2_INSTANCE_NAME = DB2_INSTANCE__DB2_INSTANCE_NAME;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__DB2_VERSION = DB2_INSTANCE__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__AUTO_START = DB2_INSTANCE__AUTO_START;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__HOSTNAME = DB2_INSTANCE__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__PASSWORD = DB2_INSTANCE__PASSWORD;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__PORT = DB2_INSTANCE__PORT;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__USERNAME = DB2_INSTANCE__USERNAME;

	/**
	 * The feature id for the '<em><b>Default Instance</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE = DB2_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE__INSTANCE_TYPE = DB2_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Windows DB2 Instance</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_INSTANCE_FEATURE_COUNT = DB2_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl <em>Windows DB2 System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2System()
	 * @generated
	 */
	int WINDOWS_DB2_SYSTEM = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ANNOTATIONS = DB2_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ATTRIBUTE_META_DATA = DB2_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__EXTENDED_ATTRIBUTES = DB2_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ARTIFACT_GROUP = DB2_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ARTIFACTS = DB2_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__CONSTRAINT_GROUP = DB2_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__CONSTRAINTS = DB2_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__DESCRIPTION = DB2_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__DISPLAY_NAME = DB2_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__MUTABLE = DB2_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__NAME = DB2_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__STEREOTYPES = DB2_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__BUILD_VERSION = DB2_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__LINK_TYPE = DB2_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ORIGIN = DB2_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Db2 Product Lang</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__DB2_PRODUCT_LANG = DB2_SYSTEM__DB2_PRODUCT_LANG;

	/**
	 * The feature id for the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__DB2_VERSION = DB2_SYSTEM__DB2_VERSION;

	/**
	 * The feature id for the '<em><b>Install Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__INSTALL_DIR = DB2_SYSTEM__INSTALL_DIR;

	/**
	 * The feature id for the '<em><b>Admin Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME = DB2_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Security</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY = DB2_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>User Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM__USER_GROUP_NAME = DB2_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Windows DB2 System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DB2_SYSTEM_FEATURE_COUNT = DB2_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType <em>Authentication Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getAuthenticationTypeType()
	 * @generated
	 */
	int AUTHENTICATION_TYPE_TYPE = 32;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames <em>DB2 Instance Port Names</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstancePortNames()
	 * @generated
	 */
	int DB2_INSTANCE_PORT_NAMES = 33;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.PageSizeType <em>Page Size Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getPageSizeType()
	 * @generated
	 */
	int PAGE_SIZE_TYPE = 34;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType <em>Unix Instance Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixInstanceTypeType()
	 * @generated
	 */
	int UNIX_INSTANCE_TYPE_TYPE = 35;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType <em>Windows Instance Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsInstanceTypeType()
	 * @generated
	 */
	int WINDOWS_INSTANCE_TYPE_TYPE = 36;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2.WordWidthType <em>Word Width Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWordWidthType()
	 * @generated
	 */
	int WORD_WIDTH_TYPE = 37;

	/**
	 * The meta object id for the '<em>Authentication Type Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getAuthenticationTypeTypeObject()
	 * @generated
	 */
	int AUTHENTICATION_TYPE_TYPE_OBJECT = 38;

	/**
	 * The meta object id for the '<em>DB2 Instance Port Names Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstancePortNamesObject()
	 * @generated
	 */
	int DB2_INSTANCE_PORT_NAMES_OBJECT = 39;

	/**
	 * The meta object id for the '<em>Page Size Type Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getPageSizeTypeObject()
	 * @generated
	 */
	int PAGE_SIZE_TYPE_OBJECT = 40;

	/**
	 * The meta object id for the '<em>Unix Instance Type Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixInstanceTypeTypeObject()
	 * @generated
	 */
	int UNIX_INSTANCE_TYPE_TYPE_OBJECT = 41;

	/**
	 * The meta object id for the '<em>Windows Instance Type Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsInstanceTypeTypeObject()
	 * @generated
	 */
	int WINDOWS_INSTANCE_TYPE_TYPE_OBJECT = 42;

	/**
	 * The meta object id for the '<em>Word Width Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWordWidthTypeObject()
	 * @generated
	 */
	int WORD_WIDTH_TYPE_OBJECT = 43;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminClient <em>DB2 Admin Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Admin Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminClient
	 * @generated
	 */
	EClass getDB2AdminClient();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminClient#getDb2ProductLang <em>Db2 Product Lang</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Product Lang</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminClient#getDb2ProductLang()
	 * @see #getDB2AdminClient()
	 * @generated
	 */
	EAttribute getDB2AdminClient_Db2ProductLang();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit <em>DB2 Admin Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Admin Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit
	 * @generated
	 */
	EClass getDB2AdminClientUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminServer <em>DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminServer
	 * @generated
	 */
	EClass getDB2AdminServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit <em>DB2 Admin Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Admin Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit
	 * @generated
	 */
	EClass getDB2AdminServerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient <em>DB2 App Devel Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 App Devel Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient
	 * @generated
	 */
	EClass getDB2AppDevelClient();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient#getDb2ProductLang <em>Db2 Product Lang</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Product Lang</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient#getDb2ProductLang()
	 * @see #getDB2AppDevelClient()
	 * @generated
	 */
	EAttribute getDB2AppDevelClient_Db2ProductLang();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit <em>DB2 App Devel Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 App Devel Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit
	 * @generated
	 */
	EClass getDB2AppDevelClientUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit <em>DB2 Base Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Base Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit
	 * @generated
	 */
	EClass getDB2BaseClientUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance <em>DB2 Base Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Base Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseInstance
	 * @generated
	 */
	EClass getDB2BaseInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2InstanceName <em>Db2 Instance Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Instance Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2InstanceName()
	 * @see #getDB2BaseInstance()
	 * @generated
	 */
	EAttribute getDB2BaseInstance_Db2InstanceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2Version <em>Db2 Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2BaseInstance#getDb2Version()
	 * @see #getDB2BaseInstance()
	 * @generated
	 */
	EAttribute getDB2BaseInstance_Db2Version();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode <em>DB2 Cataloged Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Cataloged Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode
	 * @generated
	 */
	EClass getDB2CatalogedNode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getDasLevel <em>Das Level</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getDasLevel()
	 * @see #getDB2CatalogedNode()
	 * @generated
	 */
	EAttribute getDB2CatalogedNode_DasLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getHostname()
	 * @see #getDB2CatalogedNode()
	 * @generated
	 */
	EAttribute getDB2CatalogedNode_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeName <em>Node Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeName()
	 * @see #getDB2CatalogedNode()
	 * @generated
	 */
	EAttribute getDB2CatalogedNode_NodeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getNodeType()
	 * @see #getDB2CatalogedNode()
	 * @generated
	 */
	EAttribute getDB2CatalogedNode_NodeType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode#getPort()
	 * @see #getDB2CatalogedNode()
	 * @generated
	 */
	EAttribute getDB2CatalogedNode_Port();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit <em>DB2 Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Catalog Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit
	 * @generated
	 */
	EClass getDB2CatalogUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2Client <em>DB2 Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Client
	 * @generated
	 */
	EClass getDB2Client();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getDb2ClientVersion <em>Db2 Client Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Client Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Client#getDb2ClientVersion()
	 * @see #getDB2Client()
	 * @generated
	 */
	EAttribute getDB2Client_Db2ClientVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Client#getInstallDir <em>Install Dir</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Dir</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Client#getInstallDir()
	 * @see #getDB2Client()
	 * @generated
	 */
	EAttribute getDB2Client_InstallDir();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2ClientInstance <em>DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2ClientInstance
	 * @generated
	 */
	EClass getDB2ClientInstance();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit <em>DB2 Client Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Client Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit
	 * @generated
	 */
	EClass getDB2ClientInstanceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2Database <em>DB2 Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database
	 * @generated
	 */
	EClass getDB2Database();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCatalogSp <em>Catalog Sp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Catalog Sp</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getCatalogSp()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_CatalogSp();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCodeSet <em>Code Set</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code Set</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getCodeSet()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_CodeSet();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCreatePath <em>Create Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getCreatePath()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_CreatePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDb2Version <em>Db2 Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getDb2Version()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_Db2Version();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbAlias <em>Db Alias</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getDbAlias()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_DbAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbDrive <em>Db Drive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Drive</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getDbDrive()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_DbDrive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbName <em>Db Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getDbName()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_DbName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDftExtentSize <em>Dft Extent Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dft Extent Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getDftExtentSize()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_DftExtentSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_PageSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTempSp <em>Temp Sp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temp Sp</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getTempSp()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_TempSp();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTerritory <em>Territory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Territory</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getTerritory()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_Territory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getUserSp <em>User Sp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Sp</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Database#getUserSp()
	 * @see #getDB2Database()
	 * @generated
	 */
	EAttribute getDB2Database_UserSp();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit <em>DB2 Database Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Database Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit
	 * @generated
	 */
	EClass getDB2DatabaseUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact <em>DB2DDL Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2DDL Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact
	 * @generated
	 */
	EClass getDB2DDLArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot
	 * @generated
	 */
	EClass getDb2DeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getMixed()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EAttribute getDb2DeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXMLNSPrefixMap()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getXSISchemaLocation()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminClient <em>Capability Db2 Admin Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Admin Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminClient()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2AdminClient();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminServer <em>Capability Db2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AdminServer()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2AdminServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AppDevelClient <em>Capability Db2 App Devel Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 App Devel Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2AppDevelClient()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2AppDevelClient();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2BaseInstance <em>Capability Db2 Base Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Base Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2BaseInstance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2BaseInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2CatalogedNode <em>Capability Db2 Cataloged Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Cataloged Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2CatalogedNode()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2CatalogedNode();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Client <em>Capability Db2 Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Client()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2Client();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2ClientInstance <em>Capability Db2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2ClientInstance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2ClientInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Database <em>Capability Db2 Database</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Database</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Database()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2Database();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Instance <em>Capability Db2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2Instance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2Instance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2JdbcDriver <em>Capability Db2 Jdbc Driver</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 Jdbc Driver</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2JdbcDriver()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2JdbcDriver();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2System <em>Capability Db2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Db2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityDb2System()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityDb2System();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2AdminServer <em>Capability Unix Db2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix Db2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2AdminServer()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityUnixDb2AdminServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2ClientInstance <em>Capability Unix Db2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix Db2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2ClientInstance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityUnixDb2ClientInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2Instance <em>Capability Unix Db2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix Db2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2Instance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityUnixDb2Instance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2System <em>Capability Unix Db2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix Db2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityUnixDb2System()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityUnixDb2System();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2AdminServer <em>Capability Windows Db2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Db2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2AdminServer()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityWindowsDb2AdminServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2ClientInstance <em>Capability Windows Db2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Db2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2ClientInstance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityWindowsDb2ClientInstance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2Instance <em>Capability Windows Db2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Db2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2Instance()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityWindowsDb2Instance();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2System <em>Capability Windows Db2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Db2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getCapabilityWindowsDb2System()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_CapabilityWindowsDb2System();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminClientUnit <em>Unit Db2 Admin Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Admin Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminClientUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2AdminClientUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminServerUnit <em>Unit Db2 Admin Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Admin Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AdminServerUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2AdminServerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AppDevelClientUnit <em>Unit Db2 App Devel Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 App Devel Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2AppDevelClientUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2AppDevelClientUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2BaseClientUnit <em>Unit Db2 Base Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Base Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2BaseClientUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2BaseClientUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2CatalogUnit <em>Unit Db2 Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Catalog Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2CatalogUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2CatalogUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ClientInstanceUnit <em>Unit Db2 Client Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Client Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ClientInstanceUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2ClientInstanceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2DatabaseUnit <em>Unit Db2 Database Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Database Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2DatabaseUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2DatabaseUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ddl <em>Unit Db2ddl</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2ddl</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2ddl()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2ddl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2InstanceUnit <em>Unit Db2 Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2InstanceUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2InstanceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2NodeCatalogUnit <em>Unit Db2 Node Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Node Catalog Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2NodeCatalogUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2NodeCatalogUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2RuntimeClientUnit <em>Unit Db2 Runtime Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 Runtime Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2RuntimeClientUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2RuntimeClientUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2SystemUnit <em>Unit Db2 System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Db2 System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.Db2DeployRoot#getUnitDb2SystemUnit()
	 * @see #getDb2DeployRoot()
	 * @generated
	 */
	EReference getDb2DeployRoot_UnitDb2SystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance <em>DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance
	 * @generated
	 */
	EClass getDB2Instance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart <em>Auto Start</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Start</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance#isAutoStart()
	 * @see #getDB2Instance()
	 * @generated
	 */
	EAttribute getDB2Instance_AutoStart();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance#getHostname()
	 * @see #getDB2Instance()
	 * @generated
	 */
	EAttribute getDB2Instance_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance#getPassword()
	 * @see #getDB2Instance()
	 * @generated
	 */
	EAttribute getDB2Instance_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance#getPort()
	 * @see #getDB2Instance()
	 * @generated
	 */
	EAttribute getDB2Instance_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2Instance#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2Instance#getUsername()
	 * @see #getDB2Instance()
	 * @generated
	 */
	EAttribute getDB2Instance_Username();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit <em>DB2 Instance Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Instance Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit
	 * @generated
	 */
	EClass getDB2InstanceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver <em>DB2 Jdbc Driver</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Jdbc Driver</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver
	 * @generated
	 */
	EClass getDB2JdbcDriver();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClassname()
	 * @see #getDB2JdbcDriver()
	 * @generated
	 */
	EAttribute getDB2JdbcDriver_Classname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getClasspath()
	 * @see #getDB2JdbcDriver()
	 * @generated
	 */
	EAttribute getDB2JdbcDriver_Classpath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getDriverPath <em>Driver Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getDriverPath()
	 * @see #getDB2JdbcDriver()
	 * @generated
	 */
	EAttribute getDB2JdbcDriver_DriverPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType <em>Jdbc Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jdbc Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver#getJdbcType()
	 * @see #getDB2JdbcDriver()
	 * @generated
	 */
	EAttribute getDB2JdbcDriver_JdbcType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit <em>DB2 Node Catalog Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Node Catalog Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit
	 * @generated
	 */
	EClass getDB2NodeCatalogUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit <em>DB2 Runtime Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Runtime Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit
	 * @generated
	 */
	EClass getDB2RuntimeClientUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2System <em>DB2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2System
	 * @generated
	 */
	EClass getDB2System();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2ProductLang <em>Db2 Product Lang</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Product Lang</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2System#getDb2ProductLang()
	 * @see #getDB2System()
	 * @generated
	 */
	EAttribute getDB2System_Db2ProductLang();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getDb2Version <em>Db2 Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db2 Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2System#getDb2Version()
	 * @see #getDB2System()
	 * @generated
	 */
	EAttribute getDB2System_Db2Version();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.DB2System#getInstallDir <em>Install Dir</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Dir</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2System#getInstallDir()
	 * @see #getDB2System()
	 * @generated
	 */
	EAttribute getDB2System_InstallDir();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.DB2SystemUnit <em>DB2 System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2SystemUnit
	 * @generated
	 */
	EClass getDB2SystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer <em>Unix DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix DB2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer
	 * @generated
	 */
	EClass getUnixDB2AdminServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGID <em>Das GID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das GID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGID()
	 * @see #getUnixDB2AdminServer()
	 * @generated
	 */
	EAttribute getUnixDB2AdminServer_DasGID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGroupName <em>Das Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasGroupName()
	 * @see #getUnixDB2AdminServer()
	 * @generated
	 */
	EAttribute getUnixDB2AdminServer_DasGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUID <em>Das UID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das UID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUID()
	 * @see #getUnixDB2AdminServer()
	 * @generated
	 */
	EAttribute getUnixDB2AdminServer_DasUID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserName <em>Das User Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das User Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserName()
	 * @see #getUnixDB2AdminServer()
	 * @generated
	 */
	EAttribute getUnixDB2AdminServer_DasUserName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserPassword <em>Das User Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer#getDasUserPassword()
	 * @see #getUnixDB2AdminServer()
	 * @generated
	 */
	EAttribute getUnixDB2AdminServer_DasUserPassword();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance <em>Unix DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix DB2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance
	 * @generated
	 */
	EClass getUnixDB2ClientInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType <em>Authentication Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authentication Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getAuthenticationType()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_AuthenticationType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGID <em>Fenced GID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced GID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGID()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_FencedGID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGroupName <em>Fenced Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedGroupName()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_FencedGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUID <em>Fenced UID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced UID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUID()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_FencedUID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserName <em>Fenced User Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced User Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserName()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_FencedUserName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserPassword <em>Fenced User Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getFencedUserPassword()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_FencedUserPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGID <em>GID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>GID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGID()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_GID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGroupName <em>Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getGroupName()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_GroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getInstanceType()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_InstanceType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getPassword()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUID()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_UID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getUsername()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_Username();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth <em>Word Width</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance#getWordWidth()
	 * @see #getUnixDB2ClientInstance()
	 * @generated
	 */
	EAttribute getUnixDB2ClientInstance_WordWidth();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance <em>Unix DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix DB2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance
	 * @generated
	 */
	EClass getUnixDB2Instance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getAuthenticationType <em>Authentication Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authentication Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getAuthenticationType()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_AuthenticationType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedGID <em>Fenced GID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced GID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedGID()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_FencedGID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedGroupName <em>Fenced Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedGroupName()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_FencedGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUID <em>Fenced UID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced UID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUID()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_FencedUID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUserName <em>Fenced User Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced User Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUserName()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_FencedUserName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUserPassword <em>Fenced User Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fenced User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getFencedUserPassword()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_FencedUserPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getGID <em>GID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>GID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getGID()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_GID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getGroupName <em>Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getGroupName()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_GroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getInstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getInstanceType()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_InstanceType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getUID()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_UID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getWordWidth <em>Word Width</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2Instance#getWordWidth()
	 * @see #getUnixDB2Instance()
	 * @generated
	 */
	EAttribute getUnixDB2Instance_WordWidth();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.UnixDB2System <em>Unix DB2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix DB2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixDB2System
	 * @generated
	 */
	EClass getUnixDB2System();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer <em>Windows DB2 Admin Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows DB2 Admin Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer
	 * @generated
	 */
	EClass getWindowsDB2AdminServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer#getDasDomain <em>Das Domain</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Das Domain</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer#getDasDomain()
	 * @see #getWindowsDB2AdminServer()
	 * @generated
	 */
	EAttribute getWindowsDB2AdminServer_DasDomain();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance <em>Windows DB2 Client Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows DB2 Client Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance
	 * @generated
	 */
	EClass getWindowsDB2ClientInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance <em>Default Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#isDefaultInstance()
	 * @see #getWindowsDB2ClientInstance()
	 * @generated
	 */
	EAttribute getWindowsDB2ClientInstance_DefaultInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance#getInstanceType()
	 * @see #getWindowsDB2ClientInstance()
	 * @generated
	 */
	EAttribute getWindowsDB2ClientInstance_InstanceType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance <em>Windows DB2 Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows DB2 Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance
	 * @generated
	 */
	EClass getWindowsDB2Instance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance#isDefaultInstance <em>Default Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance#isDefaultInstance()
	 * @see #getWindowsDB2Instance()
	 * @generated
	 */
	EAttribute getWindowsDB2Instance_DefaultInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance#getInstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance#getInstanceType()
	 * @see #getWindowsDB2Instance()
	 * @generated
	 */
	EAttribute getWindowsDB2Instance_InstanceType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System <em>Windows DB2 System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows DB2 System</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2System
	 * @generated
	 */
	EClass getWindowsDB2System();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getAdminGroupName <em>Admin Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Admin Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getAdminGroupName()
	 * @see #getWindowsDB2System()
	 * @generated
	 */
	EAttribute getWindowsDB2System_AdminGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity <em>Extended Security</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Security</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity()
	 * @see #getWindowsDB2System()
	 * @generated
	 */
	EAttribute getWindowsDB2System_ExtendedSecurity();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getUserGroupName <em>User Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getUserGroupName()
	 * @see #getWindowsDB2System()
	 * @generated
	 */
	EAttribute getWindowsDB2System_UserGroupName();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType <em>Authentication Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Authentication Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @generated
	 */
	EEnum getAuthenticationTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames <em>DB2 Instance Port Names</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>DB2 Instance Port Names</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
	 * @generated
	 */
	EEnum getDB2InstancePortNames();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.PageSizeType <em>Page Size Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Page Size Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @generated
	 */
	EEnum getPageSizeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType <em>Unix Instance Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unix Instance Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @generated
	 */
	EEnum getUnixInstanceTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType <em>Windows Instance Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Instance Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @generated
	 */
	EEnum getWindowsInstanceTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.db2.WordWidthType <em>Word Width Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Word Width Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @generated
	 */
	EEnum getWordWidthType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType <em>Authentication Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Authentication Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType"
	 *        extendedMetaData="name='AuthenticationTypeType:Object' baseType='AuthenticationTypeType'"
	 * @generated
	 */
	EDataType getAuthenticationTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames <em>DB2 Instance Port Names Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DB2 Instance Port Names Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames"
	 *        extendedMetaData="name='DB2InstancePortNames:Object' baseType='DB2InstancePortNames'"
	 * @generated
	 */
	EDataType getDB2InstancePortNamesObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.PageSizeType <em>Page Size Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Page Size Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.PageSizeType"
	 *        extendedMetaData="name='PageSizeType:Object' baseType='PageSizeType'"
	 * @generated
	 */
	EDataType getPageSizeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType <em>Unix Instance Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unix Instance Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType"
	 *        extendedMetaData="name='UnixInstanceTypeType:Object' baseType='UnixInstanceTypeType'"
	 * @generated
	 */
	EDataType getUnixInstanceTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType <em>Windows Instance Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Instance Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType"
	 *        extendedMetaData="name='WindowsInstanceTypeType:Object' baseType='WindowsInstanceTypeType'"
	 * @generated
	 */
	EDataType getWindowsInstanceTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.db2.WordWidthType <em>Word Width Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Word Width Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.db2.WordWidthType"
	 *        extendedMetaData="name='WordWidthType:Object' baseType='WordWidthType'"
	 * @generated
	 */
	EDataType getWordWidthTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Db2Factory getDb2Factory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientImpl <em>DB2 Admin Client</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminClient()
		 * @generated
		 */
		EClass DB2_ADMIN_CLIENT = eINSTANCE.getDB2AdminClient();

		/**
		 * The meta object literal for the '<em><b>Db2 Product Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_ADMIN_CLIENT__DB2_PRODUCT_LANG = eINSTANCE.getDB2AdminClient_Db2ProductLang();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientUnitImpl <em>DB2 Admin Client Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminClientUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminClientUnit()
		 * @generated
		 */
		EClass DB2_ADMIN_CLIENT_UNIT = eINSTANCE.getDB2AdminClientUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerImpl <em>DB2 Admin Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminServer()
		 * @generated
		 */
		EClass DB2_ADMIN_SERVER = eINSTANCE.getDB2AdminServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerUnitImpl <em>DB2 Admin Server Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AdminServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AdminServerUnit()
		 * @generated
		 */
		EClass DB2_ADMIN_SERVER_UNIT = eINSTANCE.getDB2AdminServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientImpl <em>DB2 App Devel Client</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AppDevelClient()
		 * @generated
		 */
		EClass DB2_APP_DEVEL_CLIENT = eINSTANCE.getDB2AppDevelClient();

		/**
		 * The meta object literal for the '<em><b>Db2 Product Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_APP_DEVEL_CLIENT__DB2_PRODUCT_LANG = eINSTANCE.getDB2AppDevelClient_Db2ProductLang();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientUnitImpl <em>DB2 App Devel Client Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2AppDevelClientUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2AppDevelClientUnit()
		 * @generated
		 */
		EClass DB2_APP_DEVEL_CLIENT_UNIT = eINSTANCE.getDB2AppDevelClientUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseClientUnitImpl <em>DB2 Base Client Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2BaseClientUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2BaseClientUnit()
		 * @generated
		 */
		EClass DB2_BASE_CLIENT_UNIT = eINSTANCE.getDB2BaseClientUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl <em>DB2 Base Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2BaseInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2BaseInstance()
		 * @generated
		 */
		EClass DB2_BASE_INSTANCE = eINSTANCE.getDB2BaseInstance();

		/**
		 * The meta object literal for the '<em><b>Db2 Instance Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_BASE_INSTANCE__DB2_INSTANCE_NAME = eINSTANCE.getDB2BaseInstance_Db2InstanceName();

		/**
		 * The meta object literal for the '<em><b>Db2 Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_BASE_INSTANCE__DB2_VERSION = eINSTANCE.getDB2BaseInstance_Db2Version();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl <em>DB2 Cataloged Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2CatalogedNode()
		 * @generated
		 */
		EClass DB2_CATALOGED_NODE = eINSTANCE.getDB2CatalogedNode();

		/**
		 * The meta object literal for the '<em><b>Das Level</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CATALOGED_NODE__DAS_LEVEL = eINSTANCE.getDB2CatalogedNode_DasLevel();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CATALOGED_NODE__HOSTNAME = eINSTANCE.getDB2CatalogedNode_Hostname();

		/**
		 * The meta object literal for the '<em><b>Node Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CATALOGED_NODE__NODE_NAME = eINSTANCE.getDB2CatalogedNode_NodeName();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CATALOGED_NODE__NODE_TYPE = eINSTANCE.getDB2CatalogedNode_NodeType();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CATALOGED_NODE__PORT = eINSTANCE.getDB2CatalogedNode_Port();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogUnitImpl <em>DB2 Catalog Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2CatalogUnit()
		 * @generated
		 */
		EClass DB2_CATALOG_UNIT = eINSTANCE.getDB2CatalogUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl <em>DB2 Client</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Client()
		 * @generated
		 */
		EClass DB2_CLIENT = eINSTANCE.getDB2Client();

		/**
		 * The meta object literal for the '<em><b>Db2 Client Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_CLIENT__DB2_CLIENT_VERSION = eINSTANCE.getDB2Client_Db2ClientVersion();

		/**
		 * The meta object literal for the '<em><b>Install Dir</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_CLIENT__INSTALL_DIR = eINSTANCE.getDB2Client_InstallDir();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceImpl <em>DB2 Client Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2ClientInstance()
		 * @generated
		 */
		EClass DB2_CLIENT_INSTANCE = eINSTANCE.getDB2ClientInstance();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceUnitImpl <em>DB2 Client Instance Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2ClientInstanceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2ClientInstanceUnit()
		 * @generated
		 */
		EClass DB2_CLIENT_INSTANCE_UNIT = eINSTANCE.getDB2ClientInstanceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl <em>DB2 Database</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Database()
		 * @generated
		 */
		EClass DB2_DATABASE = eINSTANCE.getDB2Database();

		/**
		 * The meta object literal for the '<em><b>Catalog Sp</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__CATALOG_SP = eINSTANCE.getDB2Database_CatalogSp();

		/**
		 * The meta object literal for the '<em><b>Code Set</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__CODE_SET = eINSTANCE.getDB2Database_CodeSet();

		/**
		 * The meta object literal for the '<em><b>Create Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__CREATE_PATH = eINSTANCE.getDB2Database_CreatePath();

		/**
		 * The meta object literal for the '<em><b>Db2 Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__DB2_VERSION = eINSTANCE.getDB2Database_Db2Version();

		/**
		 * The meta object literal for the '<em><b>Db Alias</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__DB_ALIAS = eINSTANCE.getDB2Database_DbAlias();

		/**
		 * The meta object literal for the '<em><b>Db Drive</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__DB_DRIVE = eINSTANCE.getDB2Database_DbDrive();

		/**
		 * The meta object literal for the '<em><b>Db Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__DB_NAME = eINSTANCE.getDB2Database_DbName();

		/**
		 * The meta object literal for the '<em><b>Dft Extent Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_DATABASE__DFT_EXTENT_SIZE = eINSTANCE.getDB2Database_DftExtentSize();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__PAGE_SIZE = eINSTANCE.getDB2Database_PageSize();

		/**
		 * The meta object literal for the '<em><b>Temp Sp</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__TEMP_SP = eINSTANCE.getDB2Database_TempSp();

		/**
		 * The meta object literal for the '<em><b>Territory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__TERRITORY = eINSTANCE.getDB2Database_Territory();

		/**
		 * The meta object literal for the '<em><b>User Sp</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DATABASE__USER_SP = eINSTANCE.getDB2Database_UserSp();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseUnitImpl <em>DB2 Database Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2DatabaseUnit()
		 * @generated
		 */
		EClass DB2_DATABASE_UNIT = eINSTANCE.getDB2DatabaseUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DDLArtifactImpl <em>DB2DDL Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2DDLArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2DDLArtifact()
		 * @generated
		 */
		EClass DB2DDL_ARTIFACT = eINSTANCE.getDB2DDLArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2DeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDb2DeployRoot()
		 * @generated
		 */
		EClass DB2_DEPLOY_ROOT = eINSTANCE.getDb2DeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_DEPLOY_ROOT__MIXED = eINSTANCE.getDb2DeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDb2DeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDb2DeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Admin Client</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_CLIENT = eINSTANCE.getDb2DeployRoot_CapabilityDb2AdminClient();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Admin Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_ADMIN_SERVER = eINSTANCE.getDb2DeployRoot_CapabilityDb2AdminServer();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 App Devel Client</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_APP_DEVEL_CLIENT = eINSTANCE.getDb2DeployRoot_CapabilityDb2AppDevelClient();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Base Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_BASE_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityDb2BaseInstance();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Cataloged Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_CATALOGED_NODE = eINSTANCE.getDb2DeployRoot_CapabilityDb2CatalogedNode();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Client</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT = eINSTANCE.getDb2DeployRoot_CapabilityDb2Client();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Client Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_CLIENT_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityDb2ClientInstance();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Database</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_DATABASE = eINSTANCE.getDb2DeployRoot_CapabilityDb2Database();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityDb2Instance();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 Jdbc Driver</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_JDBC_DRIVER = eINSTANCE.getDb2DeployRoot_CapabilityDb2JdbcDriver();

		/**
		 * The meta object literal for the '<em><b>Capability Db2 System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_DB2_SYSTEM = eINSTANCE.getDb2DeployRoot_CapabilityDb2System();

		/**
		 * The meta object literal for the '<em><b>Capability Unix Db2 Admin Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_ADMIN_SERVER = eINSTANCE.getDb2DeployRoot_CapabilityUnixDb2AdminServer();

		/**
		 * The meta object literal for the '<em><b>Capability Unix Db2 Client Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_CLIENT_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityUnixDb2ClientInstance();

		/**
		 * The meta object literal for the '<em><b>Capability Unix Db2 Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityUnixDb2Instance();

		/**
		 * The meta object literal for the '<em><b>Capability Unix Db2 System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_UNIX_DB2_SYSTEM = eINSTANCE.getDb2DeployRoot_CapabilityUnixDb2System();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Db2 Admin Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_ADMIN_SERVER = eINSTANCE.getDb2DeployRoot_CapabilityWindowsDb2AdminServer();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Db2 Client Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_CLIENT_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityWindowsDb2ClientInstance();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Db2 Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_INSTANCE = eINSTANCE.getDb2DeployRoot_CapabilityWindowsDb2Instance();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Db2 System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__CAPABILITY_WINDOWS_DB2_SYSTEM = eINSTANCE.getDb2DeployRoot_CapabilityWindowsDb2System();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Admin Client Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_CLIENT_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2AdminClientUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Admin Server Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_ADMIN_SERVER_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2AdminServerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 App Devel Client Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_APP_DEVEL_CLIENT_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2AppDevelClientUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Base Client Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_BASE_CLIENT_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2BaseClientUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Catalog Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_CATALOG_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2CatalogUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Client Instance Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_CLIENT_INSTANCE_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2ClientInstanceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Database Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_DATABASE_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2DatabaseUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2ddl</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2DDL = eINSTANCE.getDb2DeployRoot_UnitDb2ddl();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Instance Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_INSTANCE_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2InstanceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Node Catalog Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_NODE_CATALOG_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2NodeCatalogUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 Runtime Client Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_RUNTIME_CLIENT_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2RuntimeClientUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Db2 System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_DEPLOY_ROOT__UNIT_DB2_SYSTEM_UNIT = eINSTANCE.getDb2DeployRoot_UnitDb2SystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl <em>DB2 Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2Instance()
		 * @generated
		 */
		EClass DB2_INSTANCE = eINSTANCE.getDB2Instance();

		/**
		 * The meta object literal for the '<em><b>Auto Start</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_INSTANCE__AUTO_START = eINSTANCE.getDB2Instance_AutoStart();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_INSTANCE__HOSTNAME = eINSTANCE.getDB2Instance_Hostname();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_INSTANCE__PASSWORD = eINSTANCE.getDB2Instance_Password();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_INSTANCE__PORT = eINSTANCE.getDB2Instance_Port();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_INSTANCE__USERNAME = eINSTANCE.getDB2Instance_Username();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceUnitImpl <em>DB2 Instance Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2InstanceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstanceUnit()
		 * @generated
		 */
		EClass DB2_INSTANCE_UNIT = eINSTANCE.getDB2InstanceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl <em>DB2 Jdbc Driver</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2JdbcDriver()
		 * @generated
		 */
		EClass DB2_JDBC_DRIVER = eINSTANCE.getDB2JdbcDriver();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_JDBC_DRIVER__CLASSNAME = eINSTANCE.getDB2JdbcDriver_Classname();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_JDBC_DRIVER__CLASSPATH = eINSTANCE.getDB2JdbcDriver_Classpath();

		/**
		 * The meta object literal for the '<em><b>Driver Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_JDBC_DRIVER__DRIVER_PATH = eINSTANCE.getDB2JdbcDriver_DriverPath();

		/**
		 * The meta object literal for the '<em><b>Jdbc Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_JDBC_DRIVER__JDBC_TYPE = eINSTANCE.getDB2JdbcDriver_JdbcType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2NodeCatalogUnitImpl <em>DB2 Node Catalog Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2NodeCatalogUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2NodeCatalogUnit()
		 * @generated
		 */
		EClass DB2_NODE_CATALOG_UNIT = eINSTANCE.getDB2NodeCatalogUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2RuntimeClientUnitImpl <em>DB2 Runtime Client Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2RuntimeClientUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2RuntimeClientUnit()
		 * @generated
		 */
		EClass DB2_RUNTIME_CLIENT_UNIT = eINSTANCE.getDB2RuntimeClientUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl <em>DB2 System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2SystemImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2System()
		 * @generated
		 */
		EClass DB2_SYSTEM = eINSTANCE.getDB2System();

		/**
		 * The meta object literal for the '<em><b>Db2 Product Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_SYSTEM__DB2_PRODUCT_LANG = eINSTANCE.getDB2System_Db2ProductLang();

		/**
		 * The meta object literal for the '<em><b>Db2 Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_SYSTEM__DB2_VERSION = eINSTANCE.getDB2System_Db2Version();

		/**
		 * The meta object literal for the '<em><b>Install Dir</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DB2_SYSTEM__INSTALL_DIR = eINSTANCE.getDB2System_InstallDir();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.DB2SystemUnitImpl <em>DB2 System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.DB2SystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2SystemUnit()
		 * @generated
		 */
		EClass DB2_SYSTEM_UNIT = eINSTANCE.getDB2SystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl <em>Unix DB2 Admin Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2AdminServerImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2AdminServer()
		 * @generated
		 */
		EClass UNIX_DB2_ADMIN_SERVER = eINSTANCE.getUnixDB2AdminServer();

		/**
		 * The meta object literal for the '<em><b>Das GID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_ADMIN_SERVER__DAS_GID = eINSTANCE.getUnixDB2AdminServer_DasGID();

		/**
		 * The meta object literal for the '<em><b>Das Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_ADMIN_SERVER__DAS_GROUP_NAME = eINSTANCE.getUnixDB2AdminServer_DasGroupName();

		/**
		 * The meta object literal for the '<em><b>Das UID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_ADMIN_SERVER__DAS_UID = eINSTANCE.getUnixDB2AdminServer_DasUID();

		/**
		 * The meta object literal for the '<em><b>Das User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_ADMIN_SERVER__DAS_USER_NAME = eINSTANCE.getUnixDB2AdminServer_DasUserName();

		/**
		 * The meta object literal for the '<em><b>Das User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_ADMIN_SERVER__DAS_USER_PASSWORD = eINSTANCE.getUnixDB2AdminServer_DasUserPassword();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl <em>Unix DB2 Client Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2ClientInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2ClientInstance()
		 * @generated
		 */
		EClass UNIX_DB2_CLIENT_INSTANCE = eINSTANCE.getUnixDB2ClientInstance();

		/**
		 * The meta object literal for the '<em><b>Authentication Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__AUTHENTICATION_TYPE = eINSTANCE.getUnixDB2ClientInstance_AuthenticationType();

		/**
		 * The meta object literal for the '<em><b>Fenced GID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__FENCED_GID = eINSTANCE.getUnixDB2ClientInstance_FencedGID();

		/**
		 * The meta object literal for the '<em><b>Fenced Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__FENCED_GROUP_NAME = eINSTANCE.getUnixDB2ClientInstance_FencedGroupName();

		/**
		 * The meta object literal for the '<em><b>Fenced UID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__FENCED_UID = eINSTANCE.getUnixDB2ClientInstance_FencedUID();

		/**
		 * The meta object literal for the '<em><b>Fenced User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_NAME = eINSTANCE.getUnixDB2ClientInstance_FencedUserName();

		/**
		 * The meta object literal for the '<em><b>Fenced User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__FENCED_USER_PASSWORD = eINSTANCE.getUnixDB2ClientInstance_FencedUserPassword();

		/**
		 * The meta object literal for the '<em><b>GID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__GID = eINSTANCE.getUnixDB2ClientInstance_GID();

		/**
		 * The meta object literal for the '<em><b>Group Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__GROUP_NAME = eINSTANCE.getUnixDB2ClientInstance_GroupName();

		/**
		 * The meta object literal for the '<em><b>Instance Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__INSTANCE_TYPE = eINSTANCE.getUnixDB2ClientInstance_InstanceType();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__PASSWORD = eINSTANCE.getUnixDB2ClientInstance_Password();

		/**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__UID = eINSTANCE.getUnixDB2ClientInstance_UID();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__USERNAME = eINSTANCE.getUnixDB2ClientInstance_Username();

		/**
		 * The meta object literal for the '<em><b>Word Width</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_CLIENT_INSTANCE__WORD_WIDTH = eINSTANCE.getUnixDB2ClientInstance_WordWidth();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2InstanceImpl <em>Unix DB2 Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2InstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2Instance()
		 * @generated
		 */
		EClass UNIX_DB2_INSTANCE = eINSTANCE.getUnixDB2Instance();

		/**
		 * The meta object literal for the '<em><b>Authentication Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__AUTHENTICATION_TYPE = eINSTANCE.getUnixDB2Instance_AuthenticationType();

		/**
		 * The meta object literal for the '<em><b>Fenced GID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__FENCED_GID = eINSTANCE.getUnixDB2Instance_FencedGID();

		/**
		 * The meta object literal for the '<em><b>Fenced Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__FENCED_GROUP_NAME = eINSTANCE.getUnixDB2Instance_FencedGroupName();

		/**
		 * The meta object literal for the '<em><b>Fenced UID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__FENCED_UID = eINSTANCE.getUnixDB2Instance_FencedUID();

		/**
		 * The meta object literal for the '<em><b>Fenced User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__FENCED_USER_NAME = eINSTANCE.getUnixDB2Instance_FencedUserName();

		/**
		 * The meta object literal for the '<em><b>Fenced User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__FENCED_USER_PASSWORD = eINSTANCE.getUnixDB2Instance_FencedUserPassword();

		/**
		 * The meta object literal for the '<em><b>GID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__GID = eINSTANCE.getUnixDB2Instance_GID();

		/**
		 * The meta object literal for the '<em><b>Group Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__GROUP_NAME = eINSTANCE.getUnixDB2Instance_GroupName();

		/**
		 * The meta object literal for the '<em><b>Instance Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__INSTANCE_TYPE = eINSTANCE.getUnixDB2Instance_InstanceType();

		/**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__UID = eINSTANCE.getUnixDB2Instance_UID();

		/**
		 * The meta object literal for the '<em><b>Word Width</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIX_DB2_INSTANCE__WORD_WIDTH = eINSTANCE.getUnixDB2Instance_WordWidth();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.UnixDB2SystemImpl <em>Unix DB2 System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.UnixDB2SystemImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixDB2System()
		 * @generated
		 */
		EClass UNIX_DB2_SYSTEM = eINSTANCE.getUnixDB2System();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2AdminServerImpl <em>Windows DB2 Admin Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2AdminServerImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2AdminServer()
		 * @generated
		 */
		EClass WINDOWS_DB2_ADMIN_SERVER = eINSTANCE.getWindowsDB2AdminServer();

		/**
		 * The meta object literal for the '<em><b>Das Domain</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_DB2_ADMIN_SERVER__DAS_DOMAIN = eINSTANCE.getWindowsDB2AdminServer_DasDomain();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2ClientInstanceImpl <em>Windows DB2 Client Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2ClientInstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2ClientInstance()
		 * @generated
		 */
		EClass WINDOWS_DB2_CLIENT_INSTANCE = eINSTANCE.getWindowsDB2ClientInstance();

		/**
		 * The meta object literal for the '<em><b>Default Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_CLIENT_INSTANCE__DEFAULT_INSTANCE = eINSTANCE.getWindowsDB2ClientInstance_DefaultInstance();

		/**
		 * The meta object literal for the '<em><b>Instance Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_CLIENT_INSTANCE__INSTANCE_TYPE = eINSTANCE.getWindowsDB2ClientInstance_InstanceType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl <em>Windows DB2 Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2InstanceImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2Instance()
		 * @generated
		 */
		EClass WINDOWS_DB2_INSTANCE = eINSTANCE.getWindowsDB2Instance();

		/**
		 * The meta object literal for the '<em><b>Default Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_INSTANCE__DEFAULT_INSTANCE = eINSTANCE.getWindowsDB2Instance_DefaultInstance();

		/**
		 * The meta object literal for the '<em><b>Instance Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_INSTANCE__INSTANCE_TYPE = eINSTANCE.getWindowsDB2Instance_InstanceType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl <em>Windows DB2 System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.impl.WindowsDB2SystemImpl
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsDB2System()
		 * @generated
		 */
		EClass WINDOWS_DB2_SYSTEM = eINSTANCE.getWindowsDB2System();

		/**
		 * The meta object literal for the '<em><b>Admin Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_SYSTEM__ADMIN_GROUP_NAME = eINSTANCE.getWindowsDB2System_AdminGroupName();

		/**
		 * The meta object literal for the '<em><b>Extended Security</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_SYSTEM__EXTENDED_SECURITY = eINSTANCE.getWindowsDB2System_ExtendedSecurity();

		/**
		 * The meta object literal for the '<em><b>User Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_DB2_SYSTEM__USER_GROUP_NAME = eINSTANCE.getWindowsDB2System_UserGroupName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType <em>Authentication Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getAuthenticationTypeType()
		 * @generated
		 */
		EEnum AUTHENTICATION_TYPE_TYPE = eINSTANCE.getAuthenticationTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames <em>DB2 Instance Port Names</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstancePortNames()
		 * @generated
		 */
		EEnum DB2_INSTANCE_PORT_NAMES = eINSTANCE.getDB2InstancePortNames();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.PageSizeType <em>Page Size Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getPageSizeType()
		 * @generated
		 */
		EEnum PAGE_SIZE_TYPE = eINSTANCE.getPageSizeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType <em>Unix Instance Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixInstanceTypeType()
		 * @generated
		 */
		EEnum UNIX_INSTANCE_TYPE_TYPE = eINSTANCE.getUnixInstanceTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType <em>Windows Instance Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsInstanceTypeType()
		 * @generated
		 */
		EEnum WINDOWS_INSTANCE_TYPE_TYPE = eINSTANCE.getWindowsInstanceTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2.WordWidthType <em>Word Width Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWordWidthType()
		 * @generated
		 */
		EEnum WORD_WIDTH_TYPE = eINSTANCE.getWordWidthType();

		/**
		 * The meta object literal for the '<em>Authentication Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getAuthenticationTypeTypeObject()
		 * @generated
		 */
		EDataType AUTHENTICATION_TYPE_TYPE_OBJECT = eINSTANCE.getAuthenticationTypeTypeObject();

		/**
		 * The meta object literal for the '<em>DB2 Instance Port Names Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getDB2InstancePortNamesObject()
		 * @generated
		 */
		EDataType DB2_INSTANCE_PORT_NAMES_OBJECT = eINSTANCE.getDB2InstancePortNamesObject();

		/**
		 * The meta object literal for the '<em>Page Size Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getPageSizeTypeObject()
		 * @generated
		 */
		EDataType PAGE_SIZE_TYPE_OBJECT = eINSTANCE.getPageSizeTypeObject();

		/**
		 * The meta object literal for the '<em>Unix Instance Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getUnixInstanceTypeTypeObject()
		 * @generated
		 */
		EDataType UNIX_INSTANCE_TYPE_TYPE_OBJECT = eINSTANCE.getUnixInstanceTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Windows Instance Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWindowsInstanceTypeTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_INSTANCE_TYPE_TYPE_OBJECT = eINSTANCE.getWindowsInstanceTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Word Width Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.db2.WordWidthType
		 * @see com.ibm.ccl.soa.deploy.db2.impl.Db2PackageImpl#getWordWidthTypeObject()
		 * @generated
		 */
		EDataType WORD_WIDTH_TYPE_OBJECT = eINSTANCE.getWordWidthTypeObject();

	}

} //Db2Package
