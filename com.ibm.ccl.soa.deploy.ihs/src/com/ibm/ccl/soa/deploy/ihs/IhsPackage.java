/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs;

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
import com.ibm.ccl.soa.deploy.http.HttpPackage;

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
 * @see com.ibm.ccl.soa.deploy.ihs.IhsFactory
 * @model kind="package"
 * @generated
 */
public interface IhsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ihs"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/ihs/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ihs"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IhsPackage eINSTANCE = com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl <em>IHS Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSDeployRoot()
	 * @generated
	 */
	int IHS_DEPLOY_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Ihs Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Capability Ihs Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER = 4;

	/**
	 * The feature id for the '<em><b>Capability Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM = 5;

	/**
	 * The feature id for the '<em><b>Capability Ihs User</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER = 6;

	/**
	 * The feature id for the '<em><b>Capability Ihs User Repository</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY = 7;

	/**
	 * The feature id for the '<em><b>Capability Ihs Was Admin Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE = 8;

	/**
	 * The feature id for the '<em><b>Capability Ihs Was Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE = 9;

	/**
	 * The feature id for the '<em><b>Capability Linux Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM = 10;

	/**
	 * The feature id for the '<em><b>Capability Windows Ihs System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM = 11;

	/**
	 * The feature id for the '<em><b>Unit Ihs Server Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Unit Ihs System Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Unit Ihs User Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Unit Ihs Was Admin Module Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Unit Ihs Was Module Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT = 16;

	/**
	 * The number of structural features of the '<em>IHS Deploy Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_DEPLOY_ROOT_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsModule()
	 * @generated
	 */
	int IHS_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__LOCATION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE__MODULE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_MODULE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsServer()
	 * @generated
	 */
	int IHS_SERVER = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__ANNOTATIONS = HttpPackage.HTTP_SERVER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__ATTRIBUTE_META_DATA = HttpPackage.HTTP_SERVER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__EXTENDED_ATTRIBUTES = HttpPackage.HTTP_SERVER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__ARTIFACT_GROUP = HttpPackage.HTTP_SERVER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__ARTIFACTS = HttpPackage.HTTP_SERVER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__CONSTRAINT_GROUP = HttpPackage.HTTP_SERVER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__CONSTRAINTS = HttpPackage.HTTP_SERVER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__DESCRIPTION = HttpPackage.HTTP_SERVER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__DISPLAY_NAME = HttpPackage.HTTP_SERVER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__MUTABLE = HttpPackage.HTTP_SERVER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__NAME = HttpPackage.HTTP_SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__STEREOTYPES = HttpPackage.HTTP_SERVER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__BUILD_VERSION = HttpPackage.HTTP_SERVER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__LINK_TYPE = HttpPackage.HTTP_SERVER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__ORIGIN = HttpPackage.HTTP_SERVER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__CONFIG_FILE = HttpPackage.HTTP_SERVER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Secure</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER__SECURE = HttpPackage.HTTP_SERVER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_FEATURE_COUNT = HttpPackage.HTTP_SERVER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerUnitImpl <em>Server Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsServerUnit()
	 * @generated
	 */
	int IHS_SERVER_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__ANNOTATIONS = HttpPackage.HTTP_SERVER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__ATTRIBUTE_META_DATA = HttpPackage.HTTP_SERVER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__EXTENDED_ATTRIBUTES = HttpPackage.HTTP_SERVER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__ARTIFACT_GROUP = HttpPackage.HTTP_SERVER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__ARTIFACTS = HttpPackage.HTTP_SERVER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CONSTRAINT_GROUP = HttpPackage.HTTP_SERVER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CONSTRAINTS = HttpPackage.HTTP_SERVER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__DESCRIPTION = HttpPackage.HTTP_SERVER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__DISPLAY_NAME = HttpPackage.HTTP_SERVER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__MUTABLE = HttpPackage.HTTP_SERVER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__NAME = HttpPackage.HTTP_SERVER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CAPABILITY_GROUP = HttpPackage.HTTP_SERVER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CAPABILITIES = HttpPackage.HTTP_SERVER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__REQUIREMENT_GROUP = HttpPackage.HTTP_SERVER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__REQUIREMENTS = HttpPackage.HTTP_SERVER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__UNIT_LINKS_GROUP = HttpPackage.HTTP_SERVER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__UNIT_LINKS = HttpPackage.HTTP_SERVER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CONSTRAINT_LINKS = HttpPackage.HTTP_SERVER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__REALIZATION_LINKS = HttpPackage.HTTP_SERVER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__STEREOTYPES = HttpPackage.HTTP_SERVER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__BUILD_VERSION = HttpPackage.HTTP_SERVER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CONCEPTUAL = HttpPackage.HTTP_SERVER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__CONFIGURATION_UNIT = HttpPackage.HTTP_SERVER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__GOAL_INSTALL_STATE = HttpPackage.HTTP_SERVER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__INIT_INSTALL_STATE = HttpPackage.HTTP_SERVER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__ORIGIN = HttpPackage.HTTP_SERVER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT__PUBLISH_INTENT = HttpPackage.HTTP_SERVER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Server Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SERVER_UNIT_FEATURE_COUNT = HttpPackage.HTTP_SERVER_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsSystem()
	 * @generated
	 */
	int IHS_SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM__INSTALL_LOCATION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemUnitImpl <em>System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsSystemUnit()
	 * @generated
	 */
	int IHS_SYSTEM_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>System Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUser()
	 * @generated
	 */
	int IHS_USER = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER__ANNOTATIONS = HttpPackage.HTTP_USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__ATTRIBUTE_META_DATA = HttpPackage.HTTP_USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__EXTENDED_ATTRIBUTES = HttpPackage.HTTP_USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER__ARTIFACT_GROUP = HttpPackage.HTTP_USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER__ARTIFACTS = HttpPackage.HTTP_USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER__CONSTRAINT_GROUP = HttpPackage.HTTP_USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER__CONSTRAINTS = HttpPackage.HTTP_USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__DESCRIPTION = HttpPackage.HTTP_USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__DISPLAY_NAME = HttpPackage.HTTP_USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__MUTABLE = HttpPackage.HTTP_USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__NAME = HttpPackage.HTTP_USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__STEREOTYPES = HttpPackage.HTTP_USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__BUILD_VERSION = HttpPackage.HTTP_USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__LINK_TYPE = HttpPackage.HTTP_USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__ORIGIN = HttpPackage.HTTP_USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__USER_ID = HttpPackage.HTTP_USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER__USER_PASSWORD = HttpPackage.HTTP_USER__USER_PASSWORD;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_FEATURE_COUNT = HttpPackage.HTTP_USER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserRepositoryImpl <em>User Repository</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserRepositoryImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUserRepository()
	 * @generated
	 */
	int IHS_USER_REPOSITORY = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Password File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY__PASSWORD_FILE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Repository</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_REPOSITORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserUnitImpl <em>User Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUserUnit()
	 * @generated
	 */
	int IHS_USER_UNIT = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__ANNOTATIONS = HttpPackage.HTTP_USER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__ATTRIBUTE_META_DATA = HttpPackage.HTTP_USER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__EXTENDED_ATTRIBUTES = HttpPackage.HTTP_USER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__ARTIFACT_GROUP = HttpPackage.HTTP_USER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__ARTIFACTS = HttpPackage.HTTP_USER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CONSTRAINT_GROUP = HttpPackage.HTTP_USER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CONSTRAINTS = HttpPackage.HTTP_USER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__DESCRIPTION = HttpPackage.HTTP_USER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__DISPLAY_NAME = HttpPackage.HTTP_USER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__MUTABLE = HttpPackage.HTTP_USER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__NAME = HttpPackage.HTTP_USER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CAPABILITY_GROUP = HttpPackage.HTTP_USER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CAPABILITIES = HttpPackage.HTTP_USER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__REQUIREMENT_GROUP = HttpPackage.HTTP_USER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__REQUIREMENTS = HttpPackage.HTTP_USER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__UNIT_LINKS_GROUP = HttpPackage.HTTP_USER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__UNIT_LINKS = HttpPackage.HTTP_USER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CONSTRAINT_LINKS = HttpPackage.HTTP_USER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__REALIZATION_LINKS = HttpPackage.HTTP_USER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__STEREOTYPES = HttpPackage.HTTP_USER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__BUILD_VERSION = HttpPackage.HTTP_USER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CONCEPTUAL = HttpPackage.HTTP_USER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__CONFIGURATION_UNIT = HttpPackage.HTTP_USER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__GOAL_INSTALL_STATE = HttpPackage.HTTP_USER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__INIT_INSTALL_STATE = HttpPackage.HTTP_USER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__ORIGIN = HttpPackage.HTTP_USER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT__PUBLISH_INTENT = HttpPackage.HTTP_USER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>User Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_USER_UNIT_FEATURE_COUNT = HttpPackage.HTTP_USER_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleImpl <em>Was Admin Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasAdminModule()
	 * @generated
	 */
	int IHS_WAS_ADMIN_MODULE = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__ANNOTATIONS = IHS_MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__ATTRIBUTE_META_DATA = IHS_MODULE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__EXTENDED_ATTRIBUTES = IHS_MODULE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__ARTIFACT_GROUP = IHS_MODULE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__ARTIFACTS = IHS_MODULE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__CONSTRAINT_GROUP = IHS_MODULE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__CONSTRAINTS = IHS_MODULE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__DESCRIPTION = IHS_MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__DISPLAY_NAME = IHS_MODULE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__MUTABLE = IHS_MODULE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__NAME = IHS_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__STEREOTYPES = IHS_MODULE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__BUILD_VERSION = IHS_MODULE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__LINK_TYPE = IHS_MODULE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__ORIGIN = IHS_MODULE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__LOCATION = IHS_MODULE__LOCATION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__MODULE_NAME = IHS_MODULE__MODULE_NAME;

	/**
	 * The feature id for the '<em><b>User File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE__USER_FILE = IHS_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Was Admin Module</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_FEATURE_COUNT = IHS_MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleUnitImpl <em>Was Admin Module Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasAdminModuleUnit()
	 * @generated
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Was Admin Module Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_ADMIN_MODULE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleImpl <em>Was Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasModule()
	 * @generated
	 */
	int IHS_WAS_MODULE = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__ANNOTATIONS = IHS_MODULE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__ATTRIBUTE_META_DATA = IHS_MODULE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__EXTENDED_ATTRIBUTES = IHS_MODULE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__ARTIFACT_GROUP = IHS_MODULE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__ARTIFACTS = IHS_MODULE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__CONSTRAINT_GROUP = IHS_MODULE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__CONSTRAINTS = IHS_MODULE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__DESCRIPTION = IHS_MODULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__DISPLAY_NAME = IHS_MODULE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__MUTABLE = IHS_MODULE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__NAME = IHS_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__STEREOTYPES = IHS_MODULE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__BUILD_VERSION = IHS_MODULE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__LINK_TYPE = IHS_MODULE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__ORIGIN = IHS_MODULE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__LOCATION = IHS_MODULE__LOCATION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__MODULE_NAME = IHS_MODULE__MODULE_NAME;

	/**
	 * The feature id for the '<em><b>Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE__CONFIG_FILE = IHS_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Was Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_FEATURE_COUNT = IHS_MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleUnitImpl <em>Was Module Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasModuleUnit()
	 * @generated
	 */
	int IHS_WAS_MODULE_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Was Module Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IHS_WAS_MODULE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.LinuxIhsSystemImpl <em>Linux Ihs System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.LinuxIhsSystemImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getLinuxIhsSystem()
	 * @generated
	 */
	int LINUX_IHS_SYSTEM = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__ANNOTATIONS = IHS_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__ATTRIBUTE_META_DATA = IHS_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__EXTENDED_ATTRIBUTES = IHS_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__ARTIFACT_GROUP = IHS_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__ARTIFACTS = IHS_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__CONSTRAINT_GROUP = IHS_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__CONSTRAINTS = IHS_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__DESCRIPTION = IHS_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__DISPLAY_NAME = IHS_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__MUTABLE = IHS_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__NAME = IHS_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__STEREOTYPES = IHS_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__BUILD_VERSION = IHS_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__LINK_TYPE = IHS_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__ORIGIN = IHS_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM__INSTALL_LOCATION = IHS_SYSTEM__INSTALL_LOCATION;

	/**
	 * The number of structural features of the '<em>Linux Ihs System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_IHS_SYSTEM_FEATURE_COUNT = IHS_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.WindowsIhsSystemImpl <em>Windows Ihs System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.WindowsIhsSystemImpl
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getWindowsIhsSystem()
	 * @generated
	 */
	int WINDOWS_IHS_SYSTEM = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__ANNOTATIONS = IHS_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__ATTRIBUTE_META_DATA = IHS_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__EXTENDED_ATTRIBUTES = IHS_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__ARTIFACT_GROUP = IHS_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__ARTIFACTS = IHS_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__CONSTRAINT_GROUP = IHS_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__CONSTRAINTS = IHS_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__DESCRIPTION = IHS_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__DISPLAY_NAME = IHS_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__MUTABLE = IHS_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__NAME = IHS_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__STEREOTYPES = IHS_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__BUILD_VERSION = IHS_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__LINK_TYPE = IHS_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__ORIGIN = IHS_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM__INSTALL_LOCATION = IHS_SYSTEM__INSTALL_LOCATION;

	/**
	 * The number of structural features of the '<em>Windows Ihs System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_IHS_SYSTEM_FEATURE_COUNT = IHS_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames <em>IHS Server Port Names</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSServerPortNames()
	 * @generated
	 */
	int IHS_SERVER_PORT_NAMES = 15;

	/**
	 * The meta object id for the '<em>IHS Server Port Names Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
	 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSServerPortNamesObject()
	 * @generated
	 */
	int IHS_SERVER_PORT_NAMES_OBJECT = 16;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot <em>IHS Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>IHS Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot
	 * @generated
	 */
	EClass getIHSDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getMixed()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EAttribute getIHSDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXMLNSPrefixMap()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getXSISchemaLocation()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsModule <em>Capability Ihs Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsModule()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsServer <em>Capability Ihs Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsServer()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsSystem <em>Capability Ihs System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsSystem()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUser <em>Capability Ihs User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs User</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUser()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUserRepository <em>Capability Ihs User Repository</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs User Repository</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsUserRepository()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsUserRepository();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasAdminModule <em>Capability Ihs Was Admin Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs Was Admin Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasAdminModule()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsWasAdminModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasModule <em>Capability Ihs Was Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ihs Was Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityIhsWasModule()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityIhsWasModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityLinuxIhsSystem <em>Capability Linux Ihs System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Linux Ihs System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityLinuxIhsSystem()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityLinuxIhsSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityWindowsIhsSystem <em>Capability Windows Ihs System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Ihs System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getCapabilityWindowsIhsSystem()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_CapabilityWindowsIhsSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsServerUnit <em>Unit Ihs Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsServerUnit()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_UnitIhsServerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsSystemUnit <em>Unit Ihs System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsSystemUnit()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_UnitIhsSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsUserUnit <em>Unit Ihs User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsUserUnit()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_UnitIhsUserUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasAdminModuleUnit <em>Unit Ihs Was Admin Module Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs Was Admin Module Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasAdminModuleUnit()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_UnitIhsWasAdminModuleUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasModuleUnit <em>Unit Ihs Was Module Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ihs Was Module Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSDeployRoot#getUnitIhsWasModuleUnit()
	 * @see #getIHSDeployRoot()
	 * @generated
	 */
	EReference getIHSDeployRoot_UnitIhsWasModuleUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule <em>Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsModule
	 * @generated
	 */
	EClass getIhsModule();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsModule#getLocation()
	 * @see #getIhsModule()
	 * @generated
	 */
	EAttribute getIhsModule_Location();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsModule#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsModule#getModuleName()
	 * @see #getIhsModule()
	 * @generated
	 */
	EAttribute getIhsModule_ModuleName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer <em>Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServer
	 * @generated
	 */
	EClass getIhsServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#getConfigFile <em>Config File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config File</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServer#getConfigFile()
	 * @see #getIhsServer()
	 * @generated
	 */
	EAttribute getIhsServer_ConfigFile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure <em>Secure</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServer#isSecure()
	 * @see #getIhsServer()
	 * @generated
	 */
	EAttribute getIhsServer_Secure();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsServerUnit <em>Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsServerUnit
	 * @generated
	 */
	EClass getIhsServerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsSystem <em>System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsSystem
	 * @generated
	 */
	EClass getIhsSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsSystem#getInstallLocation <em>Install Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsSystem#getInstallLocation()
	 * @see #getIhsSystem()
	 * @generated
	 */
	EAttribute getIhsSystem_InstallLocation();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit <em>System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit
	 * @generated
	 */
	EClass getIhsSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUser <em>User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUser
	 * @generated
	 */
	EClass getIhsUser();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository <em>User Repository</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Repository</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUserRepository
	 * @generated
	 */
	EClass getIhsUserRepository();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserRepository#getPasswordFile <em>Password File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password File</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUserRepository#getPasswordFile()
	 * @see #getIhsUserRepository()
	 * @generated
	 */
	EAttribute getIhsUserRepository_PasswordFile();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsUserUnit <em>User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsUserUnit
	 * @generated
	 */
	EClass getIhsUserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule <em>Was Admin Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Admin Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule
	 * @generated
	 */
	EClass getIhsWasAdminModule();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule#getUserFile <em>User File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User File</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModule#getUserFile()
	 * @see #getIhsWasAdminModule()
	 * @generated
	 */
	EAttribute getIhsWasAdminModule_UserFile();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit <em>Was Admin Module Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Admin Module Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit
	 * @generated
	 */
	EClass getIhsWasAdminModuleUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule <em>Was Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasModule
	 * @generated
	 */
	EClass getIhsWasModule();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModule#getConfigFile <em>Config File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config File</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasModule#getConfigFile()
	 * @see #getIhsWasModule()
	 * @generated
	 */
	EAttribute getIhsWasModule_ConfigFile();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit <em>Was Module Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Was Module Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit
	 * @generated
	 */
	EClass getIhsWasModuleUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem <em>Linux Ihs System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Ihs System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.LinuxIhsSystem
	 * @generated
	 */
	EClass getLinuxIhsSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem <em>Windows Ihs System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Ihs System</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.WindowsIhsSystem
	 * @generated
	 */
	EClass getWindowsIhsSystem();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames <em>IHS Server Port Names</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>IHS Server Port Names</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
	 * @generated
	 */
	EEnum getIHSServerPortNames();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames <em>IHS Server Port Names Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IHS Server Port Names Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
	 * @model instanceClass="com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames"
	 *        extendedMetaData="name='IHSServerPortNames:Object' baseType='IHSServerPortNames'"
	 * @generated
	 */
	EDataType getIHSServerPortNamesObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IhsFactory getIhsFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl <em>IHS Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IHSDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSDeployRoot()
		 * @generated
		 */
		EClass IHS_DEPLOY_ROOT = eINSTANCE.getIHSDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_DEPLOY_ROOT__MIXED = eINSTANCE.getIHSDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getIHSDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getIHSDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_MODULE = eINSTANCE.getIHSDeployRoot_CapabilityIhsModule();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_SERVER = eINSTANCE.getIHSDeployRoot_CapabilityIhsServer();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_SYSTEM = eINSTANCE.getIHSDeployRoot_CapabilityIhsSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER = eINSTANCE.getIHSDeployRoot_CapabilityIhsUser();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs User Repository</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_USER_REPOSITORY = eINSTANCE.getIHSDeployRoot_CapabilityIhsUserRepository();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs Was Admin Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_ADMIN_MODULE = eINSTANCE.getIHSDeployRoot_CapabilityIhsWasAdminModule();

		/**
		 * The meta object literal for the '<em><b>Capability Ihs Was Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_IHS_WAS_MODULE = eINSTANCE.getIHSDeployRoot_CapabilityIhsWasModule();

		/**
		 * The meta object literal for the '<em><b>Capability Linux Ihs System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_LINUX_IHS_SYSTEM = eINSTANCE.getIHSDeployRoot_CapabilityLinuxIhsSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Ihs System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__CAPABILITY_WINDOWS_IHS_SYSTEM = eINSTANCE.getIHSDeployRoot_CapabilityWindowsIhsSystem();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs Server Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__UNIT_IHS_SERVER_UNIT = eINSTANCE.getIHSDeployRoot_UnitIhsServerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__UNIT_IHS_SYSTEM_UNIT = eINSTANCE.getIHSDeployRoot_UnitIhsSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs User Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__UNIT_IHS_USER_UNIT = eINSTANCE.getIHSDeployRoot_UnitIhsUserUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs Was Admin Module Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__UNIT_IHS_WAS_ADMIN_MODULE_UNIT = eINSTANCE.getIHSDeployRoot_UnitIhsWasAdminModuleUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ihs Was Module Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IHS_DEPLOY_ROOT__UNIT_IHS_WAS_MODULE_UNIT = eINSTANCE.getIHSDeployRoot_UnitIhsWasModuleUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsModuleImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsModule()
		 * @generated
		 */
		EClass IHS_MODULE = eINSTANCE.getIhsModule();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_MODULE__LOCATION = eINSTANCE.getIhsModule_Location();

		/**
		 * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_MODULE__MODULE_NAME = eINSTANCE.getIhsModule_ModuleName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsServerImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsServer()
		 * @generated
		 */
		EClass IHS_SERVER = eINSTANCE.getIhsServer();

		/**
		 * The meta object literal for the '<em><b>Config File</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_SERVER__CONFIG_FILE = eINSTANCE.getIhsServer_ConfigFile();

		/**
		 * The meta object literal for the '<em><b>Secure</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_SERVER__SECURE = eINSTANCE.getIhsServer_Secure();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsServerUnitImpl <em>Server Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsServerUnit()
		 * @generated
		 */
		EClass IHS_SERVER_UNIT = eINSTANCE.getIhsServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsSystem()
		 * @generated
		 */
		EClass IHS_SYSTEM = eINSTANCE.getIhsSystem();

		/**
		 * The meta object literal for the '<em><b>Install Location</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IHS_SYSTEM__INSTALL_LOCATION = eINSTANCE.getIhsSystem_InstallLocation();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemUnitImpl <em>System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsSystemUnit()
		 * @generated
		 */
		EClass IHS_SYSTEM_UNIT = eINSTANCE.getIhsSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUser()
		 * @generated
		 */
		EClass IHS_USER = eINSTANCE.getIhsUser();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserRepositoryImpl <em>User Repository</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserRepositoryImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUserRepository()
		 * @generated
		 */
		EClass IHS_USER_REPOSITORY = eINSTANCE.getIhsUserRepository();

		/**
		 * The meta object literal for the '<em><b>Password File</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IHS_USER_REPOSITORY__PASSWORD_FILE = eINSTANCE.getIhsUserRepository_PasswordFile();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsUserUnitImpl <em>User Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsUserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsUserUnit()
		 * @generated
		 */
		EClass IHS_USER_UNIT = eINSTANCE.getIhsUserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleImpl <em>Was Admin Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasAdminModule()
		 * @generated
		 */
		EClass IHS_WAS_ADMIN_MODULE = eINSTANCE.getIhsWasAdminModule();

		/**
		 * The meta object literal for the '<em><b>User File</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_WAS_ADMIN_MODULE__USER_FILE = eINSTANCE.getIhsWasAdminModule_UserFile();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleUnitImpl <em>Was Admin Module Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasAdminModuleUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasAdminModuleUnit()
		 * @generated
		 */
		EClass IHS_WAS_ADMIN_MODULE_UNIT = eINSTANCE.getIhsWasAdminModuleUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleImpl <em>Was Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasModule()
		 * @generated
		 */
		EClass IHS_WAS_MODULE = eINSTANCE.getIhsWasModule();

		/**
		 * The meta object literal for the '<em><b>Config File</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IHS_WAS_MODULE__CONFIG_FILE = eINSTANCE.getIhsWasModule_ConfigFile();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleUnitImpl <em>Was Module Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsWasModuleUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIhsWasModuleUnit()
		 * @generated
		 */
		EClass IHS_WAS_MODULE_UNIT = eINSTANCE.getIhsWasModuleUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.LinuxIhsSystemImpl <em>Linux Ihs System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.LinuxIhsSystemImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getLinuxIhsSystem()
		 * @generated
		 */
		EClass LINUX_IHS_SYSTEM = eINSTANCE.getLinuxIhsSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.impl.WindowsIhsSystemImpl <em>Windows Ihs System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.WindowsIhsSystemImpl
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getWindowsIhsSystem()
		 * @generated
		 */
		EClass WINDOWS_IHS_SYSTEM = eINSTANCE.getWindowsIhsSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames <em>IHS Server Port Names</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSServerPortNames()
		 * @generated
		 */
		EEnum IHS_SERVER_PORT_NAMES = eINSTANCE.getIHSServerPortNames();

		/**
		 * The meta object literal for the '<em>IHS Server Port Names Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.ihs.IHSServerPortNames
		 * @see com.ibm.ccl.soa.deploy.ihs.impl.IhsPackageImpl#getIHSServerPortNamesObject()
		 * @generated
		 */
		EDataType IHS_SERVER_PORT_NAMES_OBJECT = eINSTANCE.getIHSServerPortNamesObject();

	}

} //IhsPackage
