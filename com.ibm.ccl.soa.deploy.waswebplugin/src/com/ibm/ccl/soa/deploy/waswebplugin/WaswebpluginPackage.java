/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin;

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
 * @see com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginFactory
 * @model kind="package"
 * @generated
 */
public interface WaswebpluginPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "waswebplugin"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/waswebplugin/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "waswebplugin"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WaswebpluginPackage eINSTANCE = com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginImpl <em>Ihs Was Plugin</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginImpl
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getIhsWasPlugin()
	 * @generated
	 */
	int IHS_WAS_PLUGIN = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN__INSTALL_LOCATION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ihs Was Plugin</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginUnitImpl <em>Ihs Was Plugin Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginUnitImpl
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getIhsWasPluginUnit()
	 * @generated
	 */
	int IHS_WAS_PLUGIN_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Ihs Was Plugin Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_PLUGIN_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl <em>Was Web Plugin Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getWasWebPluginDeployRoot()
	 * @generated
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Ihs Was Plugin</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN = 3;

	/**
	 * The feature id for the '<em><b>Constraint Was Web Server To Ihs Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Unit Ihs Was Plugin Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT = 5;

	/**
	 * The number of structural features of the '<em>Was Web Plugin Deploy Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_PLUGIN_DEPLOY_ROOT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebServerToIhsConstraintImpl <em>Was Web Server To Ihs Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebServerToIhsConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getWasWebServerToIhsConstraint()
	 * @generated
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Was Web Server To Ihs Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAS_WEB_SERVER_TO_IHS_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin <em>Ihs Was Plugin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ihs Was Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin
	 * @generated
	 */
	EClass getIhsWasPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin#getInstallLocation <em>Install Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin#getInstallLocation()
	 * @see #getIhsWasPlugin()
	 * @generated
	 */
	EAttribute getIhsWasPlugin_InstallLocation();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit <em>Ihs Was Plugin Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ihs Was Plugin Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit
	 * @generated
	 */
	EClass getIhsWasPluginUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot <em>Was Web Plugin Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Web Plugin Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot
	 * @generated
	 */
	EClass getWasWebPluginDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getMixed()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EAttribute getWasWebPluginDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXMLNSPrefixMap()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EReference getWasWebPluginDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getXSISchemaLocation()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EReference getWasWebPluginDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getCapabilityIhsWasPlugin <em>Capability Ihs Was Plugin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs Was Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getCapabilityIhsWasPlugin()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EReference getWasWebPluginDeployRoot_CapabilityIhsWasPlugin();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getConstraintWasWebServerToIhsConstraint <em>Constraint Was Web Server To Ihs Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Was Web Server To Ihs Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getConstraintWasWebServerToIhsConstraint()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EReference getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getUnitIhsWasPluginUnit <em>Unit Ihs Was Plugin Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs Was Plugin Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot#getUnitIhsWasPluginUnit()
	 * @see #getWasWebPluginDeployRoot()
	 * @generated
	 */
	EReference getWasWebPluginDeployRoot_UnitIhsWasPluginUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint <em>Was Web Server To Ihs Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Web Server To Ihs Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint
	 * @generated
	 */
	EClass getWasWebServerToIhsConstraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WaswebpluginFactory getWaswebpluginFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginImpl <em>Ihs Was Plugin</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginImpl
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getIhsWasPlugin()
		 * @generated
		 */
		EClass IHS_WAS_PLUGIN = eINSTANCE.getIhsWasPlugin();

		/**
		 * The meta object literal for the '<em><b>Install Location</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IHS_WAS_PLUGIN__INSTALL_LOCATION = eINSTANCE.getIhsWasPlugin_InstallLocation();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginUnitImpl <em>Ihs Was Plugin Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.IhsWasPluginUnitImpl
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getIhsWasPluginUnit()
		 * @generated
		 */
		EClass IHS_WAS_PLUGIN_UNIT = eINSTANCE.getIhsWasPluginUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl <em>Was Web Plugin Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getWasWebPluginDeployRoot()
		 * @generated
		 */
		EClass WAS_WEB_PLUGIN_DEPLOY_ROOT = eINSTANCE.getWasWebPluginDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED = eINSTANCE.getWasWebPluginDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getWasWebPluginDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getWasWebPluginDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs Was Plugin</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN = eINSTANCE.getWasWebPluginDeployRoot_CapabilityIhsWasPlugin();

		/**
		 * The meta object literal for the '<em><b>Constraint Was Web Server To Ihs Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT = eINSTANCE.getWasWebPluginDeployRoot_ConstraintWasWebServerToIhsConstraint();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs Was Plugin Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT = eINSTANCE.getWasWebPluginDeployRoot_UnitIhsWasPluginUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebServerToIhsConstraintImpl <em>Was Web Server To Ihs Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebServerToIhsConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.waswebplugin.impl.WaswebpluginPackageImpl#getWasWebServerToIhsConstraint()
		 * @generated
		 */
		EClass WAS_WEB_SERVER_TO_IHS_CONSTRAINT = eINSTANCE.getWasWebServerToIhsConstraint();

	}

} //WaswebpluginPackage
