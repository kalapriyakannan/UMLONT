/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

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
 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatFactory
 * @model kind="package"
 * @generated
 */
public interface TomcatPackage extends EPackage {
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
	String eNAME = "tomcat"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/tomcat/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tomcat"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	TomcatPackage eINSTANCE = com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl <em>Tomcat50 Datasource</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcat50Datasource()
	 * @generated
	 */
	int TOMCAT50_DATASOURCE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__ANNOTATIONS = J2eePackage.J2EE_DATASOURCE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__ATTRIBUTE_META_DATA = J2eePackage.J2EE_DATASOURCE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__EXTENDED_ATTRIBUTES = J2eePackage.J2EE_DATASOURCE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__ARTIFACT_GROUP = J2eePackage.J2EE_DATASOURCE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__ARTIFACTS = J2eePackage.J2EE_DATASOURCE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__CONSTRAINT_GROUP = J2eePackage.J2EE_DATASOURCE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__CONSTRAINTS = J2eePackage.J2EE_DATASOURCE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__DESCRIPTION = J2eePackage.J2EE_DATASOURCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__DISPLAY_NAME = J2eePackage.J2EE_DATASOURCE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__MUTABLE = J2eePackage.J2EE_DATASOURCE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__NAME = J2eePackage.J2EE_DATASOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__STEREOTYPES = J2eePackage.J2EE_DATASOURCE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__BUILD_VERSION = J2eePackage.J2EE_DATASOURCE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__LINK_TYPE = J2eePackage.J2EE_DATASOURCE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__ORIGIN = J2eePackage.J2EE_DATASOURCE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Datasource Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__DATASOURCE_NAME = J2eePackage.J2EE_DATASOURCE__DATASOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__DB_NAME = J2eePackage.J2EE_DATASOURCE__DB_NAME;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__HOSTNAME = J2eePackage.J2EE_DATASOURCE__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__JNDI_NAME = J2eePackage.J2EE_DATASOURCE__JNDI_NAME;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__PASSWORD = J2eePackage.J2EE_DATASOURCE__PASSWORD;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__PORT = J2eePackage.J2EE_DATASOURCE__PORT;

	/**
	 * The feature id for the '<em><b>Used For Cmp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__USED_FOR_CMP = J2eePackage.J2EE_DATASOURCE__USED_FOR_CMP;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__USERNAME = J2eePackage.J2EE_DATASOURCE__USERNAME;

	/**
	 * The feature id for the '<em><b>Client Jar Location</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION = J2eePackage.J2EE_DATASOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Driver Class Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME = J2eePackage.J2EE_DATASOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__FACTORY = J2eePackage.J2EE_DATASOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE__URL = J2eePackage.J2EE_DATASOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tomcat50 Datasource</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT50_DATASOURCE_FEATURE_COUNT = J2eePackage.J2EE_DATASOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDatasourceUnitImpl <em>Datasource Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDatasourceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatDatasourceUnit()
	 * @generated
	 */
	int TOMCAT_DATASOURCE_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Datasource Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DATASOURCE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatDeployRoot()
	 * @generated
	 */
	int TOMCAT_DEPLOY_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Tomcat50datasource</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE = 3;

	/**
	 * The feature id for the '<em><b>Capability Tomcat Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER = 4;

	/**
	 * The feature id for the '<em><b>Unit Tomcatdatasource</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE = 5;

	/**
	 * The feature id for the '<em><b>Unit Tomcat Web Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER = 6;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_DEPLOY_ROOT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatServerImpl
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatServer()
	 * @generated
	 */
	int TOMCAT_SERVER = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__ANNOTATIONS = J2eePackage.J2EE_SERVER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__ATTRIBUTE_META_DATA = J2eePackage.J2EE_SERVER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__EXTENDED_ATTRIBUTES = J2eePackage.J2EE_SERVER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__ARTIFACT_GROUP = J2eePackage.J2EE_SERVER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__ARTIFACTS = J2eePackage.J2EE_SERVER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__CONSTRAINT_GROUP = J2eePackage.J2EE_SERVER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__CONSTRAINTS = J2eePackage.J2EE_SERVER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__DESCRIPTION = J2eePackage.J2EE_SERVER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__DISPLAY_NAME = J2eePackage.J2EE_SERVER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__MUTABLE = J2eePackage.J2EE_SERVER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__NAME = J2eePackage.J2EE_SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__STEREOTYPES = J2eePackage.J2EE_SERVER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__BUILD_VERSION = J2eePackage.J2EE_SERVER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__LINK_TYPE = J2eePackage.J2EE_SERVER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__ORIGIN = J2eePackage.J2EE_SERVER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Tomcat Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER__TOMCAT_VERSION = J2eePackage.J2EE_SERVER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_SERVER_FEATURE_COUNT = J2eePackage.J2EE_SERVER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatWebServerUnitImpl <em>Web Server Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatWebServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatWebServerUnit()
	 * @generated
	 */
	int TOMCAT_WEB_SERVER_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__ANNOTATIONS = J2eePackage.J2EE_SERVER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__ATTRIBUTE_META_DATA = J2eePackage.J2EE_SERVER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__EXTENDED_ATTRIBUTES = J2eePackage.J2EE_SERVER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__ARTIFACT_GROUP = J2eePackage.J2EE_SERVER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__ARTIFACTS = J2eePackage.J2EE_SERVER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CONSTRAINT_GROUP = J2eePackage.J2EE_SERVER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CONSTRAINTS = J2eePackage.J2EE_SERVER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__DESCRIPTION = J2eePackage.J2EE_SERVER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__DISPLAY_NAME = J2eePackage.J2EE_SERVER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__MUTABLE = J2eePackage.J2EE_SERVER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__NAME = J2eePackage.J2EE_SERVER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CAPABILITY_GROUP = J2eePackage.J2EE_SERVER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CAPABILITIES = J2eePackage.J2EE_SERVER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__REQUIREMENT_GROUP = J2eePackage.J2EE_SERVER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__REQUIREMENTS = J2eePackage.J2EE_SERVER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__UNIT_LINKS_GROUP = J2eePackage.J2EE_SERVER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__UNIT_LINKS = J2eePackage.J2EE_SERVER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CONSTRAINT_LINKS = J2eePackage.J2EE_SERVER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__REALIZATION_LINKS = J2eePackage.J2EE_SERVER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__STEREOTYPES = J2eePackage.J2EE_SERVER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__BUILD_VERSION = J2eePackage.J2EE_SERVER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CONCEPTUAL = J2eePackage.J2EE_SERVER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__CONFIGURATION_UNIT = J2eePackage.J2EE_SERVER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__GOAL_INSTALL_STATE = J2eePackage.J2EE_SERVER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__INIT_INSTALL_STATE = J2eePackage.J2EE_SERVER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__ORIGIN = J2eePackage.J2EE_SERVER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT__PUBLISH_INTENT = J2eePackage.J2EE_SERVER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Web Server Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOMCAT_WEB_SERVER_UNIT_FEATURE_COUNT = J2eePackage.J2EE_SERVER_UNIT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource <em>Tomcat50 Datasource</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tomcat50 Datasource</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource
	 * @generated
	 */
	EClass getTomcat50Datasource();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getClientJarLocation <em>Client Jar Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Jar Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getClientJarLocation()
	 * @see #getTomcat50Datasource()
	 * @generated
	 */
	EAttribute getTomcat50Datasource_ClientJarLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getDriverClassName <em>Driver Class Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Class Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getDriverClassName()
	 * @see #getTomcat50Datasource()
	 * @generated
	 */
	EAttribute getTomcat50Datasource_DriverClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory <em>Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory()
	 * @see #getTomcat50Datasource()
	 * @generated
	 */
	EAttribute getTomcat50Datasource_Factory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getUrl()
	 * @see #getTomcat50Datasource()
	 * @generated
	 */
	EAttribute getTomcat50Datasource_Url();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit <em>Datasource Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Datasource Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit
	 * @generated
	 */
	EClass getTomcatDatasourceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot
	 * @generated
	 */
	EClass getTomcatDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getMixed()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EAttribute getTomcatDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXMLNSPrefixMap()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getXSISchemaLocation()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcat50datasource <em>Capability Tomcat50datasource</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Tomcat50datasource</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcat50datasource()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_CapabilityTomcat50datasource();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcatServer <em>Capability Tomcat Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Tomcat Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getCapabilityTomcatServer()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_CapabilityTomcatServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatdatasource <em>Unit Tomcatdatasource</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Tomcatdatasource</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatdatasource()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_UnitTomcatdatasource();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatWebServer <em>Unit Tomcat Web Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Tomcat Web Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot#getUnitTomcatWebServer()
	 * @see #getTomcatDeployRoot()
	 * @generated
	 */
	EReference getTomcatDeployRoot_UnitTomcatWebServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatServer <em>Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatServer
	 * @generated
	 */
	EClass getTomcatServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatServer#getTomcatVersion <em>Tomcat Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tomcat Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatServer#getTomcatVersion()
	 * @see #getTomcatServer()
	 * @generated
	 */
	EAttribute getTomcatServer_TomcatVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit <em>Web Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit
	 * @generated
	 */
	EClass getTomcatWebServerUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TomcatFactory getTomcatFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl <em>Tomcat50 Datasource</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcat50Datasource()
		 * @generated
		 */
		EClass TOMCAT50_DATASOURCE = eINSTANCE.getTomcat50Datasource();

		/**
		 * The meta object literal for the '<em><b>Client Jar Location</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION = eINSTANCE.getTomcat50Datasource_ClientJarLocation();

		/**
		 * The meta object literal for the '<em><b>Driver Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME = eINSTANCE.getTomcat50Datasource_DriverClassName();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TOMCAT50_DATASOURCE__FACTORY = eINSTANCE.getTomcat50Datasource_Factory();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TOMCAT50_DATASOURCE__URL = eINSTANCE.getTomcat50Datasource_Url();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDatasourceUnitImpl <em>Datasource Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDatasourceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatDatasourceUnit()
		 * @generated
		 */
		EClass TOMCAT_DATASOURCE_UNIT = eINSTANCE.getTomcatDatasourceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatDeployRoot()
		 * @generated
		 */
		EClass TOMCAT_DEPLOY_ROOT = eINSTANCE.getTomcatDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TOMCAT_DEPLOY_ROOT__MIXED = eINSTANCE.getTomcatDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getTomcatDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getTomcatDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Tomcat50datasource</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE = eINSTANCE.getTomcatDeployRoot_CapabilityTomcat50datasource();

		/**
		 * The meta object literal for the '<em><b>Capability Tomcat Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER = eINSTANCE.getTomcatDeployRoot_CapabilityTomcatServer();

		/**
		 * The meta object literal for the '<em><b>Unit Tomcatdatasource</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE = eINSTANCE.getTomcatDeployRoot_UnitTomcatdatasource();

		/**
		 * The meta object literal for the '<em><b>Unit Tomcat Web Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER = eINSTANCE.getTomcatDeployRoot_UnitTomcatWebServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatServerImpl
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatServer()
		 * @generated
		 */
		EClass TOMCAT_SERVER = eINSTANCE.getTomcatServer();

		/**
		 * The meta object literal for the '<em><b>Tomcat Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOMCAT_SERVER__TOMCAT_VERSION = eINSTANCE.getTomcatServer_TomcatVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatWebServerUnitImpl <em>Web Server Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatWebServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.tomcat.impl.TomcatPackageImpl#getTomcatWebServerUnit()
		 * @generated
		 */
		EClass TOMCAT_WEB_SERVER_UNIT = eINSTANCE.getTomcatWebServerUnit();

	}

} //TomcatPackage
