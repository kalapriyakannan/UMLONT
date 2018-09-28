/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server;

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
 * @see com.ibm.ccl.soa.deploy.server.ServerFactory
 * @model kind="package"
 * @generated
 */
public interface ServerPackage extends EPackage {
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
	String eNAME = "server"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/server/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "server"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ServerPackage eINSTANCE = com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerImpl
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServer()
	 * @generated
	 */
	int SERVER = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__AUTO_START = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cpu Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_ARCHITECTURE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cpu Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cpu Architecture Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_ARCHITECTURE_WIDTH = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cpu Cores Installed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_CORES_INSTALLED = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Cpu Dies Installed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_DIES_INSTALLED = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Cpu Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_MANUFACTURER = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Cpu Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_SPEED = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Cpu Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__CPU_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is VMI Dan LPAR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__IS_VMI_DAN_LPAR = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MANUFACTURER = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MEMORY_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__MODEL = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Primary MAC Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__PRIMARY_MAC_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Processing Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__PROCESSING_CAPACITY = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Processing Capacity Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__PROCESSING_CAPACITY_UNITS = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Rom Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__ROM_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SERIAL_NUMBER = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>System Board UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SYSTEM_BOARD_UUID = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>System Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__SYSTEM_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__VIRTUAL = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Vmid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER__VMID = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServerRoot()
	 * @generated
	 */
	int SERVER_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Server</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT__CAPABILITY_SERVER = 3;

	/**
	 * The feature id for the '<em><b>Unit Server Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT__UNIT_SERVER_UNIT = 4;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_ROOT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerUnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServerUnit()
	 * @generated
	 */
	int SERVER_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.server.ArchitectureWidthType <em>Architecture Width Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getArchitectureWidthType()
	 * @generated
	 */
	int ARCHITECTURE_WIDTH_TYPE = 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType <em>Processing Capacity Units Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getProcessingCapacityUnitsType()
	 * @generated
	 */
	int PROCESSING_CAPACITY_UNITS_TYPE = 4;

	/**
	 * The meta object id for the '<em>Architecture Width Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getArchitectureWidthTypeObject()
	 * @generated
	 */
	int ARCHITECTURE_WIDTH_TYPE_OBJECT = 5;

	/**
	 * The meta object id for the '<em>Processing Capacity Units Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getProcessingCapacityUnitsTypeObject()
	 * @generated
	 */
	int PROCESSING_CAPACITY_UNITS_TYPE_OBJECT = 6;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.server.Server <em>Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server
	 * @generated
	 */
	EClass getServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#isAutoStart <em>Auto Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Start</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#isAutoStart()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_AutoStart();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitecture <em>Cpu Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Architecture</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuArchitecture()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuArchitecture();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Architecture Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuArchitectureWidth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled <em>Cpu Cores Installed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Cores Installed</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuCoresInstalled();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCount <em>Cpu Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuCount()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled <em>Cpu Dies Installed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Dies Installed</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuDiesInstalled();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuManufacturer <em>Cpu Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Manufacturer</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuManufacturer()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuManufacturer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed <em>Cpu Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Speed</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuSpeed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuType <em>Cpu Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getCpuType()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_CpuType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is VMI Dan LPAR</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_IsVMIDanLPAR();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getManufacturer <em>Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manufacturer</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getManufacturer()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Manufacturer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getMemorySize()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_MemorySize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getModel()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Model();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getPrimaryMACAddress <em>Primary MAC Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary MAC Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getPrimaryMACAddress()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_PrimaryMACAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity <em>Processing Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Capacity</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_ProcessingCapacity();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits <em>Processing Capacity Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Capacity Units</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_ProcessingCapacityUnits();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getRomVersion <em>Rom Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rom Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getRomVersion()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_RomVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getSerialNumber <em>Serial Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serial Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getSerialNumber()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_SerialNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getSystemBoardUUID <em>System Board UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Board UUID</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getSystemBoardUUID()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_SystemBoardUUID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getSystemId <em>System Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getSystemId()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_SystemId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#isVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#isVirtual()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Virtual();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.server.Server#getVmid <em>Vmid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vmid</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.Server#getVmid()
	 * @see #getServer()
	 * @generated
	 */
	EAttribute getServer_Vmid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.server.ServerRoot <em>Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot
	 * @generated
	 */
	EClass getServerRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot#getMixed()
	 * @see #getServerRoot()
	 * @generated
	 */
	EAttribute getServerRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot#getXMLNSPrefixMap()
	 * @see #getServerRoot()
	 * @generated
	 */
	EReference getServerRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot#getXSISchemaLocation()
	 * @see #getServerRoot()
	 * @generated
	 */
	EReference getServerRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getCapabilityServer <em>Capability Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot#getCapabilityServer()
	 * @see #getServerRoot()
	 * @generated
	 */
	EReference getServerRoot_CapabilityServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.server.ServerRoot#getUnitServerUnit <em>Unit Server Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerRoot#getUnitServerUnit()
	 * @see #getServerRoot()
	 * @generated
	 */
	EReference getServerRoot_UnitServerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.server.ServerUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ServerUnit
	 * @generated
	 */
	EClass getServerUnit();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.server.ArchitectureWidthType <em>Architecture Width Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Architecture Width Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @generated
	 */
	EEnum getArchitectureWidthType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType <em>Processing Capacity Units Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Processing Capacity Units Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @generated
	 */
	EEnum getProcessingCapacityUnitsType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.server.ArchitectureWidthType <em>Architecture Width Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Architecture Width Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.server.ArchitectureWidthType"
	 *        extendedMetaData="name='ArchitectureWidthType:Object' baseType='ArchitectureWidthType'"
	 * @generated
	 */
	EDataType getArchitectureWidthTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType <em>Processing Capacity Units Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Processing Capacity Units Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType"
	 *        extendedMetaData="name='ProcessingCapacityUnitsType:Object' baseType='ProcessingCapacityUnitsType'"
	 * @generated
	 */
	EDataType getProcessingCapacityUnitsTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServerFactory getServerFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerImpl
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServer()
		 * @generated
		 */
		EClass SERVER = eINSTANCE.getServer();

		/**
		 * The meta object literal for the '<em><b>Auto Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__AUTO_START = eINSTANCE.getServer_AutoStart();

		/**
		 * The meta object literal for the '<em><b>Cpu Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_ARCHITECTURE = eINSTANCE.getServer_CpuArchitecture();

		/**
		 * The meta object literal for the '<em><b>Cpu Architecture Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_ARCHITECTURE_WIDTH = eINSTANCE.getServer_CpuArchitectureWidth();

		/**
		 * The meta object literal for the '<em><b>Cpu Cores Installed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_CORES_INSTALLED = eINSTANCE.getServer_CpuCoresInstalled();

		/**
		 * The meta object literal for the '<em><b>Cpu Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_COUNT = eINSTANCE.getServer_CpuCount();

		/**
		 * The meta object literal for the '<em><b>Cpu Dies Installed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_DIES_INSTALLED = eINSTANCE.getServer_CpuDiesInstalled();

		/**
		 * The meta object literal for the '<em><b>Cpu Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_MANUFACTURER = eINSTANCE.getServer_CpuManufacturer();

		/**
		 * The meta object literal for the '<em><b>Cpu Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_SPEED = eINSTANCE.getServer_CpuSpeed();

		/**
		 * The meta object literal for the '<em><b>Cpu Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__CPU_TYPE = eINSTANCE.getServer_CpuType();

		/**
		 * The meta object literal for the '<em><b>Is VMI Dan LPAR</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__IS_VMI_DAN_LPAR = eINSTANCE.getServer_IsVMIDanLPAR();

		/**
		 * The meta object literal for the '<em><b>Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__MANUFACTURER = eINSTANCE.getServer_Manufacturer();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVER__MEMORY_SIZE = eINSTANCE.getServer_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__MODEL = eINSTANCE.getServer_Model();

		/**
		 * The meta object literal for the '<em><b>Primary MAC Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__PRIMARY_MAC_ADDRESS = eINSTANCE.getServer_PrimaryMACAddress();

		/**
		 * The meta object literal for the '<em><b>Processing Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__PROCESSING_CAPACITY = eINSTANCE.getServer_ProcessingCapacity();

		/**
		 * The meta object literal for the '<em><b>Processing Capacity Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__PROCESSING_CAPACITY_UNITS = eINSTANCE.getServer_ProcessingCapacityUnits();

		/**
		 * The meta object literal for the '<em><b>Rom Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__ROM_VERSION = eINSTANCE.getServer_RomVersion();

		/**
		 * The meta object literal for the '<em><b>Serial Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__SERIAL_NUMBER = eINSTANCE.getServer_SerialNumber();

		/**
		 * The meta object literal for the '<em><b>System Board UUID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__SYSTEM_BOARD_UUID = eINSTANCE.getServer_SystemBoardUUID();

		/**
		 * The meta object literal for the '<em><b>System Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__SYSTEM_ID = eINSTANCE.getServer_SystemId();

		/**
		 * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__VIRTUAL = eINSTANCE.getServer_Virtual();

		/**
		 * The meta object literal for the '<em><b>Vmid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER__VMID = eINSTANCE.getServer_Vmid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServerRoot()
		 * @generated
		 */
		EClass SERVER_ROOT = eINSTANCE.getServerRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVER_ROOT__MIXED = eINSTANCE.getServerRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getServerRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getServerRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_ROOT__CAPABILITY_SERVER = eINSTANCE.getServerRoot_CapabilityServer();

		/**
		 * The meta object literal for the '<em><b>Unit Server Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_ROOT__UNIT_SERVER_UNIT = eINSTANCE.getServerRoot_UnitServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.server.impl.ServerUnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getServerUnit()
		 * @generated
		 */
		EClass SERVER_UNIT = eINSTANCE.getServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.server.ArchitectureWidthType <em>Architecture Width Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getArchitectureWidthType()
		 * @generated
		 */
		EEnum ARCHITECTURE_WIDTH_TYPE = eINSTANCE.getArchitectureWidthType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType <em>Processing Capacity Units Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getProcessingCapacityUnitsType()
		 * @generated
		 */
		EEnum PROCESSING_CAPACITY_UNITS_TYPE = eINSTANCE.getProcessingCapacityUnitsType();

		/**
		 * The meta object literal for the '<em>Architecture Width Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getArchitectureWidthTypeObject()
		 * @generated
		 */
		EDataType ARCHITECTURE_WIDTH_TYPE_OBJECT = eINSTANCE.getArchitectureWidthTypeObject();

		/**
		 * The meta object literal for the '<em>Processing Capacity Units Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
		 * @see com.ibm.ccl.soa.deploy.server.impl.ServerPackageImpl#getProcessingCapacityUnitsTypeObject()
		 * @generated
		 */
		EDataType PROCESSING_CAPACITY_UNITS_TYPE_OBJECT = eINSTANCE
				.getProcessingCapacityUnitsTypeObject();

	}

} //ServerPackage
