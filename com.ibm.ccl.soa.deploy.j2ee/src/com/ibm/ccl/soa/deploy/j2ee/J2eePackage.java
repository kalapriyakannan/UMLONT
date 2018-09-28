/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

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
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eeFactory
 * @model kind="package"
 * @generated
 */
public interface J2eePackage extends EPackage {
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
	String eNAME = "j2ee"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/j2ee/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "j2eeDeploy"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	J2eePackage eINSTANCE = com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.AppClientImpl <em>App Client</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.AppClientImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getAppClient()
	 * @generated
	 */
	int APP_CLIENT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>App Client</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEModuleCapabilityImpl <em>J2EE Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEModuleCapability()
	 * @generated
	 */
	int J2EE_MODULE_CAPABILITY = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ANNOTATIONS = CorePackage.BUNDLE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = CorePackage.BUNDLE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = CorePackage.BUNDLE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP = CorePackage.BUNDLE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ARTIFACTS = CorePackage.BUNDLE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP = CorePackage.BUNDLE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__CONSTRAINTS = CorePackage.BUNDLE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__DESCRIPTION = CorePackage.BUNDLE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__DISPLAY_NAME = CorePackage.BUNDLE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__MUTABLE = CorePackage.BUNDLE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__NAME = CorePackage.BUNDLE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__STEREOTYPES = CorePackage.BUNDLE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__BUILD_VERSION = CorePackage.BUNDLE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__LINK_TYPE = CorePackage.BUNDLE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ORIGIN = CorePackage.BUNDLE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__ID = CorePackage.BUNDLE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__VERSION = CorePackage.BUNDLE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY__MODULE_NAME = CorePackage.BUNDLE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>J2EE Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_MODULE_CAPABILITY_FEATURE_COUNT = CorePackage.BUNDLE_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.AppClientModuleImpl <em>App Client Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.AppClientModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getAppClientModule()
	 * @generated
	 */
	int APP_CLIENT_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The number of structural features of the '<em>App Client Module</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APP_CLIENT_MODULE_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EarModuleImpl <em>Ear Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EarModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEarModule()
	 * @generated
	 */
	int EAR_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Ear Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EARModuleCapabilityImpl <em>EAR Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EARModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEARModuleCapability()
	 * @generated
	 */
	int EAR_MODULE_CAPABILITY = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The number of structural features of the '<em>EAR Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EAR_MODULE_CAPABILITY_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBImpl <em>EJB</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJB()
	 * @generated
	 */
	int EJB = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB__INTERFACE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EJB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBContainerImpl <em>EJB Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBContainerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainer()
	 * @generated
	 */
	int EJB_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Container Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER__CONTAINER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EJB Container</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EjbModuleImpl <em>Ejb Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EjbModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEjbModule()
	 * @generated
	 */
	int EJB_MODULE = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Ejb Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBModuleCapabilityImpl <em>EJB Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBModuleCapability()
	 * @generated
	 */
	int EJB_MODULE_CAPABILITY = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The number of structural features of the '<em>EJB Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EJB_MODULE_CAPABILITY_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl <em>Enterprise Bean Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEnterpriseBeanService()
	 * @generated
	 */
	int ENTERPRISE_BEAN_SERVICE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__ANNOTATIONS = CorePackage.SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__ATTRIBUTE_META_DATA = CorePackage.SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__ARTIFACT_GROUP = CorePackage.SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__ARTIFACTS = CorePackage.SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__CONSTRAINT_GROUP = CorePackage.SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__CONSTRAINTS = CorePackage.SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__DESCRIPTION = CorePackage.SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__DISPLAY_NAME = CorePackage.SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__MUTABLE = CorePackage.SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__NAME = CorePackage.SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__STEREOTYPES = CorePackage.SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__BUILD_VERSION = CorePackage.SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__LINK_TYPE = CorePackage.SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__ORIGIN = CorePackage.SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__INTERFACE_GROUP = CorePackage.SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__INTERFACE = CorePackage.SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__PROTOCOL = CorePackage.SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__VERSION = CorePackage.SERVICE__VERSION;

	/**
	 * The feature id for the '<em><b>Home Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE = CorePackage.SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ejb Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__EJB_NAME = CorePackage.SERVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__JNDI_NAME = CorePackage.SERVICE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vicinity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE__VICINITY = CorePackage.SERVICE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enterprise Bean Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTERPRISE_BEAN_SERVICE_FEATURE_COUNT = CorePackage.SERVICE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EntityServiceImpl <em>Entity Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EntityServiceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEntityService()
	 * @generated
	 */
	int ENTITY_SERVICE = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__ANNOTATIONS = ENTERPRISE_BEAN_SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__ATTRIBUTE_META_DATA = ENTERPRISE_BEAN_SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__EXTENDED_ATTRIBUTES = ENTERPRISE_BEAN_SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__ARTIFACT_GROUP = ENTERPRISE_BEAN_SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__ARTIFACTS = ENTERPRISE_BEAN_SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__CONSTRAINT_GROUP = ENTERPRISE_BEAN_SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__CONSTRAINTS = ENTERPRISE_BEAN_SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__DESCRIPTION = ENTERPRISE_BEAN_SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__DISPLAY_NAME = ENTERPRISE_BEAN_SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__MUTABLE = ENTERPRISE_BEAN_SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__NAME = ENTERPRISE_BEAN_SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__STEREOTYPES = ENTERPRISE_BEAN_SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__BUILD_VERSION = ENTERPRISE_BEAN_SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__LINK_TYPE = ENTERPRISE_BEAN_SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__ORIGIN = ENTERPRISE_BEAN_SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__INTERFACE_GROUP = ENTERPRISE_BEAN_SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__INTERFACE = ENTERPRISE_BEAN_SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__PROTOCOL = ENTERPRISE_BEAN_SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__VERSION = ENTERPRISE_BEAN_SERVICE__VERSION;

	/**
	 * The feature id for the '<em><b>Home Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__HOME_INTERFACE = ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE;

	/**
	 * The feature id for the '<em><b>Ejb Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__EJB_NAME = ENTERPRISE_BEAN_SERVICE__EJB_NAME;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__JNDI_NAME = ENTERPRISE_BEAN_SERVICE__JNDI_NAME;

	/**
	 * The feature id for the '<em><b>Vicinity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__VICINITY = ENTERPRISE_BEAN_SERVICE__VICINITY;

	/**
	 * The feature id for the '<em><b>Managed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE__MANAGED = ENTERPRISE_BEAN_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_SERVICE_FEATURE_COUNT = ENTERPRISE_BEAN_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.GenericWebServerImpl <em>Generic Web Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.GenericWebServerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getGenericWebServer()
	 * @generated
	 */
	int GENERIC_WEB_SERVER = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Generic Web Server</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_WEB_SERVER_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.GenericJ2eeServerImpl <em>Generic J2ee Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.GenericJ2eeServerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getGenericJ2eeServer()
	 * @generated
	 */
	int GENERIC_J2EE_SERVER = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__ANNOTATIONS = GENERIC_WEB_SERVER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__ATTRIBUTE_META_DATA = GENERIC_WEB_SERVER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__EXTENDED_ATTRIBUTES = GENERIC_WEB_SERVER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__ARTIFACT_GROUP = GENERIC_WEB_SERVER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__ARTIFACTS = GENERIC_WEB_SERVER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CONSTRAINT_GROUP = GENERIC_WEB_SERVER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CONSTRAINTS = GENERIC_WEB_SERVER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__DESCRIPTION = GENERIC_WEB_SERVER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__DISPLAY_NAME = GENERIC_WEB_SERVER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__MUTABLE = GENERIC_WEB_SERVER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__NAME = GENERIC_WEB_SERVER__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CAPABILITY_GROUP = GENERIC_WEB_SERVER__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CAPABILITIES = GENERIC_WEB_SERVER__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__REQUIREMENT_GROUP = GENERIC_WEB_SERVER__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__REQUIREMENTS = GENERIC_WEB_SERVER__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__UNIT_LINKS_GROUP = GENERIC_WEB_SERVER__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__UNIT_LINKS = GENERIC_WEB_SERVER__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CONSTRAINT_LINKS = GENERIC_WEB_SERVER__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__REALIZATION_LINKS = GENERIC_WEB_SERVER__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__STEREOTYPES = GENERIC_WEB_SERVER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__BUILD_VERSION = GENERIC_WEB_SERVER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CONCEPTUAL = GENERIC_WEB_SERVER__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__CONFIGURATION_UNIT = GENERIC_WEB_SERVER__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__GOAL_INSTALL_STATE = GENERIC_WEB_SERVER__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__INIT_INSTALL_STATE = GENERIC_WEB_SERVER__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__ORIGIN = GENERIC_WEB_SERVER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER__PUBLISH_INTENT = GENERIC_WEB_SERVER__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Generic J2ee Server</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_J2EE_SERVER_FEATURE_COUNT = GENERIC_WEB_SERVER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl <em>J2C Authentication Data Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2CAuthenticationDataEntry()
	 * @generated
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY__USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>J2C Authentication Data Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_DATA_ENTRY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationUnitImpl <em>J2C Authentication Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2CAuthenticationUnit()
	 * @generated
	 */
	int J2C_AUTHENTICATION_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>J2C Authentication Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2C_AUTHENTICATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEContainerImpl <em>J2EE Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEContainerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainer()
	 * @generated
	 */
	int J2EE_CONTAINER = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Container Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER__CONTAINER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>J2EE Container</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl <em>J2EE Datasource</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEDatasource()
	 * @generated
	 */
	int J2EE_DATASOURCE = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Datasource Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__DATASOURCE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__DB_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__HOSTNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Used For Cmp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__USED_FOR_CMP = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE__USERNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>J2EE Datasource</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DATASOURCE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl <em>J2EE Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEDeployRoot()
	 * @generated
	 */
	int J2EE_DEPLOY_ROOT = 16;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability App Client Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Capability Ear Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Capability Ejb</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_EJB = 5;

	/**
	 * The feature id for the '<em><b>Capability Ejb Container</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Capability Ejb Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE = 7;

	/**
	 * The feature id for the '<em><b>Capability J2ee Container</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER = 8;

	/**
	 * The feature id for the '<em><b>Capability J2ee Datasource</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE = 9;

	/**
	 * The feature id for the '<em><b>Capability J2ee Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE = 10;

	/**
	 * The feature id for the '<em><b>Capability J2ee Resource Environment Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT = 11;

	/**
	 * The feature id for the '<em><b>Capability J2ee Resource Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT = 12;

	/**
	 * The feature id for the '<em><b>Capability J2ee Security Role</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE = 13;

	/**
	 * The feature id for the '<em><b>Capability J2ee Server</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER = 14;

	/**
	 * The feature id for the '<em><b>Capability Jar Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE = 15;

	/**
	 * The feature id for the '<em><b>Capability Jca Container</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER = 16;

	/**
	 * The feature id for the '<em><b>Capability Jca Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE = 17;

	/**
	 * The feature id for the '<em><b>Capability Jsp Container</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER = 18;

	/**
	 * The feature id for the '<em><b>Capability Servlet Container</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER = 19;

	/**
	 * The feature id for the '<em><b>Capability Web Module</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE = 20;

	/**
	 * The feature id for the '<em><b>Component Ear</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__COMPONENT_EAR = 21;

	/**
	 * The feature id for the '<em><b>Component Ejb</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__COMPONENT_EJB = 22;

	/**
	 * The feature id for the '<em><b>Component Jar</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__COMPONENT_JAR = 23;

	/**
	 * The feature id for the '<em><b>Component Web</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__COMPONENT_WEB = 24;

	/**
	 * The feature id for the '<em><b>Interface Java</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__INTERFACE_JAVA = 25;

	/**
	 * The feature id for the '<em><b>Interface Url</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__INTERFACE_URL = 26;

	/**
	 * The feature id for the '<em><b>Interface Wsdl</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__INTERFACE_WSDL = 27;

	/**
	 * The feature id for the '<em><b>Service Entity</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__SERVICE_ENTITY = 28;

	/**
	 * The feature id for the '<em><b>Service Servlet</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__SERVICE_SERVLET = 29;

	/**
	 * The feature id for the '<em><b>Service Session</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__SERVICE_SESSION = 30;

	/**
	 * The feature id for the '<em><b>Service Ws</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__SERVICE_WS = 31;

	/**
	 * The feature id for the '<em><b>Unit App Client</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT = 32;

	/**
	 * The feature id for the '<em><b>Unit J2ee Server</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER = 33;

	/**
	 * The feature id for the '<em><b>Unit J2ee Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT = 34;

	/**
	 * The feature id for the '<em><b>Unit Jca Module</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE = 35;

	/**
	 * The feature id for the '<em><b>Unit Web Server</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER = 36;

	/**
	 * The number of structural features of the '<em>J2EE Deploy Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_DEPLOY_ROOT_FEATURE_COUNT = 37;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl <em>J2EE Resource Environment Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEResourceEnvironmentRequirement()
	 * @generated
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>J2EE Resource Environment Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceRequirementImpl <em>J2EE Resource Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceRequirementImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEResourceRequirement()
	 * @generated
	 */
	int J2EE_RESOURCE_REQUIREMENT = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>J2EE Resource Requirement</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_RESOURCE_REQUIREMENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EESecurityRoleImpl <em>J2EE Security Role</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EESecurityRoleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EESecurityRole()
	 * @generated
	 */
	int J2EE_SECURITY_ROLE = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE__ROLE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>J2EE Security Role</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SECURITY_ROLE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerImpl <em>J2EE Server</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEServer()
	 * @generated
	 */
	int J2EE_SERVER = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>J2EE Server</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl <em>J2EE Server Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEServerUnit()
	 * @generated
	 */
	int J2EE_SERVER_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>J2EE Server Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int J2EE_SERVER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleImpl <em>Jar Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJarModule()
	 * @generated
	 */
	int JAR_MODULE = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Jar Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleCapabilityImpl <em>Jar Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJarModuleCapability()
	 * @generated
	 */
	int JAR_MODULE_CAPABILITY = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The number of structural features of the '<em>Jar Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAR_MODULE_CAPABILITY_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JavaInterfaceImpl <em>Java Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JavaInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJavaInterface()
	 * @generated
	 */
	int JAVA_INTERFACE = 25;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INTERFACE__INTERFACE = CorePackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Interface</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_INTERFACE_FEATURE_COUNT = CorePackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAContainerImpl <em>JCA Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAContainerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainer()
	 * @generated
	 */
	int JCA_CONTAINER = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Container Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER__CONTAINER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JCA Container</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleImpl <em>JCA Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAModule()
	 * @generated
	 */
	int JCA_MODULE = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JCA Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleCapabilityImpl <em>JCA Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAModuleCapability()
	 * @generated
	 */
	int JCA_MODULE_CAPABILITY = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The number of structural features of the '<em>JCA Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JCA_MODULE_CAPABILITY_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JSPContainerImpl <em>JSP Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JSPContainerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainer()
	 * @generated
	 */
	int JSP_CONTAINER = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Container Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER__CONTAINER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JSP Container</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JSP_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.ServletContainerImpl <em>Servlet Container</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.ServletContainerImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainer()
	 * @generated
	 */
	int SERVLET_CONTAINER = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Container Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER__CONTAINER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Servlet Container</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVLET_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.SessionServiceImpl <em>Session Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.SessionServiceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getSessionService()
	 * @generated
	 */
	int SESSION_SERVICE = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__ANNOTATIONS = ENTERPRISE_BEAN_SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__ATTRIBUTE_META_DATA = ENTERPRISE_BEAN_SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__EXTENDED_ATTRIBUTES = ENTERPRISE_BEAN_SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__ARTIFACT_GROUP = ENTERPRISE_BEAN_SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__ARTIFACTS = ENTERPRISE_BEAN_SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__CONSTRAINT_GROUP = ENTERPRISE_BEAN_SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__CONSTRAINTS = ENTERPRISE_BEAN_SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__DESCRIPTION = ENTERPRISE_BEAN_SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__DISPLAY_NAME = ENTERPRISE_BEAN_SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__MUTABLE = ENTERPRISE_BEAN_SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__NAME = ENTERPRISE_BEAN_SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__STEREOTYPES = ENTERPRISE_BEAN_SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__BUILD_VERSION = ENTERPRISE_BEAN_SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__LINK_TYPE = ENTERPRISE_BEAN_SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__ORIGIN = ENTERPRISE_BEAN_SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__INTERFACE_GROUP = ENTERPRISE_BEAN_SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__INTERFACE = ENTERPRISE_BEAN_SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__PROTOCOL = ENTERPRISE_BEAN_SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__VERSION = ENTERPRISE_BEAN_SERVICE__VERSION;

	/**
	 * The feature id for the '<em><b>Home Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__HOME_INTERFACE = ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE;

	/**
	 * The feature id for the '<em><b>Ejb Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__EJB_NAME = ENTERPRISE_BEAN_SERVICE__EJB_NAME;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__JNDI_NAME = ENTERPRISE_BEAN_SERVICE__JNDI_NAME;

	/**
	 * The feature id for the '<em><b>Vicinity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE__VICINITY = ENTERPRISE_BEAN_SERVICE__VICINITY;

	/**
	 * The number of structural features of the '<em>Session Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_SERVICE_FEATURE_COUNT = ENTERPRISE_BEAN_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.URLInterfaceImpl <em>URL Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.URLInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getURLInterface()
	 * @generated
	 */
	int URL_INTERFACE = 32;

	/**
	 * The feature id for the '<em><b>Param Name</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_INTERFACE__PARAM_NAME = CorePackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>URL Interface</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_INTERFACE_FEATURE_COUNT = CorePackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.URLServiceImpl <em>URL Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.URLServiceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getURLService()
	 * @generated
	 */
	int URL_SERVICE = 33;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__ANNOTATIONS = CorePackage.SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__ATTRIBUTE_META_DATA = CorePackage.SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__ARTIFACT_GROUP = CorePackage.SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__ARTIFACTS = CorePackage.SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__CONSTRAINT_GROUP = CorePackage.SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__CONSTRAINTS = CorePackage.SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__DESCRIPTION = CorePackage.SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__DISPLAY_NAME = CorePackage.SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__MUTABLE = CorePackage.SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__NAME = CorePackage.SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__STEREOTYPES = CorePackage.SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__BUILD_VERSION = CorePackage.SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__LINK_TYPE = CorePackage.SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__ORIGIN = CorePackage.SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__INTERFACE_GROUP = CorePackage.SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__INTERFACE = CorePackage.SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__PROTOCOL = CorePackage.SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__VERSION = CorePackage.SERVICE__VERSION;

	/**
	 * The feature id for the '<em><b>Url Pattern</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE__URL_PATTERN = CorePackage.SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>URL Service</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_SERVICE_FEATURE_COUNT = CorePackage.SERVICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleImpl <em>Web Module</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebModule()
	 * @generated
	 */
	int WEB_MODULE = 34;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Web Module</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleCapabilityImpl <em>Web Module Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebModuleCapability()
	 * @generated
	 */
	int WEB_MODULE_CAPABILITY = 35;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ANNOTATIONS = J2EE_MODULE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ATTRIBUTE_META_DATA = J2EE_MODULE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES = J2EE_MODULE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ARTIFACT_GROUP = J2EE_MODULE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ARTIFACTS = J2EE_MODULE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__CONSTRAINT_GROUP = J2EE_MODULE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__CONSTRAINTS = J2EE_MODULE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__DESCRIPTION = J2EE_MODULE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__DISPLAY_NAME = J2EE_MODULE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__MUTABLE = J2EE_MODULE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__NAME = J2EE_MODULE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__STEREOTYPES = J2EE_MODULE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__BUILD_VERSION = J2EE_MODULE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__LINK_TYPE = J2EE_MODULE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ORIGIN = J2EE_MODULE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__ID = J2EE_MODULE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__VERSION = J2EE_MODULE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__MODULE_NAME = J2EE_MODULE_CAPABILITY__MODULE_NAME;

	/**
	 * The feature id for the '<em><b>Context Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY__CONTEXT_ROOT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Web Module Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_CAPABILITY_FEATURE_COUNT = J2EE_MODULE_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl <em>Web Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebService()
	 * @generated
	 */
	int WEB_SERVICE = 36;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ANNOTATIONS = CorePackage.SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ATTRIBUTE_META_DATA = CorePackage.SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ARTIFACT_GROUP = CorePackage.SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ARTIFACTS = CorePackage.SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__CONSTRAINT_GROUP = CorePackage.SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__CONSTRAINTS = CorePackage.SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__DESCRIPTION = CorePackage.SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__DISPLAY_NAME = CorePackage.SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__MUTABLE = CorePackage.SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__NAME = CorePackage.SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__STEREOTYPES = CorePackage.SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__BUILD_VERSION = CorePackage.SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__LINK_TYPE = CorePackage.SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ORIGIN = CorePackage.SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__INTERFACE_GROUP = CorePackage.SERVICE__INTERFACE_GROUP;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__INTERFACE = CorePackage.SERVICE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__PROTOCOL = CorePackage.SERVICE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__VERSION = CorePackage.SERVICE__VERSION;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE__ENDPOINT = CorePackage.SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Web Service</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SERVICE_FEATURE_COUNT = CorePackage.SERVICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WSDLInterfaceImpl <em>WSDL Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WSDLInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWSDLInterface()
	 * @generated
	 */
	int WSDL_INTERFACE = 37;

	/**
	 * The feature id for the '<em><b>Type Uri</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WSDL_INTERFACE__TYPE_URI = CorePackage.INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WSDL Interface</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WSDL_INTERFACE_FEATURE_COUNT = CorePackage.INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion <em>EJB Container Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainerVersion()
	 * @generated
	 */
	int EJB_CONTAINER_VERSION = 38;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion <em>J2EE Container Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainerVersion()
	 * @generated
	 */
	int J2EE_CONTAINER_VERSION = 39;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion <em>JCA Container Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainerVersion()
	 * @generated
	 */
	int JCA_CONTAINER_VERSION = 40;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion <em>JSP Container Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainerVersion()
	 * @generated
	 */
	int JSP_CONTAINER_VERSION = 41;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion <em>Servlet Container Version</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainerVersion()
	 * @generated
	 */
	int SERVLET_CONTAINER_VERSION = 42;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.Vicinity <em>Vicinity</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getVicinity()
	 * @generated
	 */
	int VICINITY = 43;

	/**
	 * The meta object id for the '<em>EJB Container Version Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainerVersionObject()
	 * @generated
	 */
	int EJB_CONTAINER_VERSION_OBJECT = 44;

	/**
	 * The meta object id for the '<em>J2EE Container Version Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainerVersionObject()
	 * @generated
	 */
	int J2EE_CONTAINER_VERSION_OBJECT = 45;

	/**
	 * The meta object id for the '<em>JCA Container Version Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainerVersionObject()
	 * @generated
	 */
	int JCA_CONTAINER_VERSION_OBJECT = 46;

	/**
	 * The meta object id for the '<em>JSP Container Version Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainerVersionObject()
	 * @generated
	 */
	int JSP_CONTAINER_VERSION_OBJECT = 47;

	/**
	 * The meta object id for the '<em>Servlet Container Version Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainerVersionObject()
	 * @generated
	 */
	int SERVLET_CONTAINER_VERSION_OBJECT = 48;

	/**
	 * The meta object id for the '<em>Vicinity Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getVicinityObject()
	 * @generated
	 */
	int VICINITY_OBJECT = 49;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.AppClient <em>App Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.AppClient
	 * @generated
	 */
	EClass getAppClient();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.AppClientModule <em>App Client Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Client Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.AppClientModule
	 * @generated
	 */
	EClass getAppClientModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EarModule <em>Ear Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ear Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EarModule
	 * @generated
	 */
	EClass getEarModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability <em>EAR Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAR Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability
	 * @generated
	 */
	EClass getEARModuleCapability();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EJB <em>EJB</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EJB</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJB
	 * @generated
	 */
	EClass getEJB();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EJB#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJB#getInterface()
	 * @see #getEJB()
	 * @generated
	 */
	EAttribute getEJB_Interface();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainer <em>EJB Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EJB Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainer
	 * @generated
	 */
	EClass getEJBContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainer#getContainerVersion <em>Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainer#getContainerVersion()
	 * @see #getEJBContainer()
	 * @generated
	 */
	EAttribute getEJBContainer_ContainerVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EjbModule <em>Ejb Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ejb Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EjbModule
	 * @generated
	 */
	EClass getEjbModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EJBModuleCapability <em>EJB Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>EJB Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBModuleCapability
	 * @generated
	 */
	EClass getEJBModuleCapability();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService <em>Enterprise Bean Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enterprise Bean Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService
	 * @generated
	 */
	EClass getEnterpriseBeanService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getHomeInterface <em>Home Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Home Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getHomeInterface()
	 * @see #getEnterpriseBeanService()
	 * @generated
	 */
	EReference getEnterpriseBeanService_HomeInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getEjbName <em>Ejb Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ejb Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getEjbName()
	 * @see #getEnterpriseBeanService()
	 * @generated
	 */
	EAttribute getEnterpriseBeanService_EjbName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getJndiName()
	 * @see #getEnterpriseBeanService()
	 * @generated
	 */
	EAttribute getEnterpriseBeanService_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity <em>Vicinity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vicinity</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity()
	 * @see #getEnterpriseBeanService()
	 * @generated
	 */
	EAttribute getEnterpriseBeanService_Vicinity();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.EntityService <em>Entity Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EntityService
	 * @generated
	 */
	EClass getEntityService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged <em>Managed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Managed</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged()
	 * @see #getEntityService()
	 * @generated
	 */
	EAttribute getEntityService_Managed();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer <em>Generic J2ee Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic J2ee Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.GenericJ2eeServer
	 * @generated
	 */
	EClass getGenericJ2eeServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.GenericWebServer <em>Generic Web Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Web Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.GenericWebServer
	 * @generated
	 */
	EClass getGenericWebServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry <em>J2C Authentication Data Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2C Authentication Data Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry
	 * @generated
	 */
	EClass getJ2CAuthenticationDataEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getAlias()
	 * @see #getJ2CAuthenticationDataEntry()
	 * @generated
	 */
	EAttribute getJ2CAuthenticationDataEntry_Alias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getPassword()
	 * @see #getJ2CAuthenticationDataEntry()
	 * @generated
	 */
	EAttribute getJ2CAuthenticationDataEntry_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry#getUserId()
	 * @see #getJ2CAuthenticationDataEntry()
	 * @generated
	 */
	EAttribute getJ2CAuthenticationDataEntry_UserId();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit <em>J2C Authentication Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2C Authentication Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit
	 * @generated
	 */
	EClass getJ2CAuthenticationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainer <em>J2EE Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainer
	 * @generated
	 */
	EClass getJ2EEContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainer#getContainerVersion <em>Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainer#getContainerVersion()
	 * @see #getJ2EEContainer()
	 * @generated
	 */
	EAttribute getJ2EEContainer_ContainerVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource <em>J2EE Datasource</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Datasource</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource
	 * @generated
	 */
	EClass getJ2EEDatasource();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDatasourceName <em>Datasource Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datasource Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDatasourceName()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_DatasourceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDbName <em>Db Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getDbName()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_DbName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getHostname()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getJndiName()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPassword()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getPort()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp <em>Used For Cmp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used For Cmp</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#isUsedForCmp()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_UsedForCmp();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource#getUsername()
	 * @see #getJ2EEDatasource()
	 * @generated
	 */
	EAttribute getJ2EEDatasource_Username();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot <em>J2EE Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot
	 * @generated
	 */
	EClass getJ2EEDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getMixed()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EAttribute getJ2EEDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXMLNSPrefixMap()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getXSISchemaLocation()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityAppClientModule <em>Capability App Client Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability App Client Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityAppClientModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityAppClientModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEarModule <em>Capability Ear Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ear Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEarModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityEarModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjb <em>Capability Ejb</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ejb</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjb()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityEjb();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbContainer <em>Capability Ejb Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ejb Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbContainer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityEjbContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbModule <em>Capability Ejb Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ejb Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityEjbModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityEjbModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeContainer <em>Capability J2ee Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeContainer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeDatasource <em>Capability J2ee Datasource</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Datasource</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeDatasource()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeDatasource();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeModule <em>Capability J2ee Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceEnvironmentRequirement <em>Capability J2ee Resource Environment Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Resource Environment Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceEnvironmentRequirement()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceRequirement <em>Capability J2ee Resource Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Resource Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeResourceRequirement()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeSecurityRole <em>Capability J2ee Security Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Security Role</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeSecurityRole()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeSecurityRole();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeServer <em>Capability J2ee Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability J2ee Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJ2eeServer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJ2eeServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJarModule <em>Capability Jar Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jar Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJarModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJarModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaContainer <em>Capability Jca Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jca Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaContainer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJcaContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaModule <em>Capability Jca Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jca Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJcaModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJcaModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJspContainer <em>Capability Jsp Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Jsp Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityJspContainer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityJspContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityServletContainer <em>Capability Servlet Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Servlet Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityServletContainer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityServletContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityWebModule <em>Capability Web Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Web Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getCapabilityWebModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_CapabilityWebModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEar <em>Component Ear</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Ear</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEar()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ComponentEar();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEjb <em>Component Ejb</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Ejb</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentEjb()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ComponentEjb();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentJar <em>Component Jar</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Jar</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentJar()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ComponentJar();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentWeb <em>Component Web</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Web</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getComponentWeb()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ComponentWeb();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceJava <em>Interface Java</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Java</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceJava()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_InterfaceJava();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceUrl <em>Interface Url</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Url</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceUrl()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_InterfaceUrl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceWsdl <em>Interface Wsdl</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Wsdl</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getInterfaceWsdl()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_InterfaceWsdl();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceEntity <em>Service Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Entity</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceEntity()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ServiceEntity();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceServlet <em>Service Servlet</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Servlet</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceServlet()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ServiceServlet();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceSession <em>Service Session</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Session</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceSession()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ServiceSession();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceWs <em>Service Ws</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Ws</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getServiceWs()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_ServiceWs();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitAppClient <em>Unit App Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit App Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitAppClient()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_UnitAppClient();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServer <em>Unit J2ee Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit J2ee Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_UnitJ2eeServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServerUnit <em>Unit J2ee Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit J2ee Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJ2eeServerUnit()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_UnitJ2eeServerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJcaModule <em>Unit Jca Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Jca Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitJcaModule()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_UnitJcaModule();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitWebServer <em>Unit Web Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Web Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEDeployRoot#getUnitWebServer()
	 * @see #getJ2EEDeployRoot()
	 * @generated
	 */
	EReference getJ2EEDeployRoot_UnitWebServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability <em>J2EE Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability
	 * @generated
	 */
	EClass getJ2EEModuleCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEModuleCapability#getModuleName()
	 * @see #getJ2EEModuleCapability()
	 * @generated
	 */
	EAttribute getJ2EEModuleCapability_ModuleName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement <em>J2EE Resource Environment Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Resource Environment Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement
	 * @generated
	 */
	EClass getJ2EEResourceEnvironmentRequirement();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement#getJndiName()
	 * @see #getJ2EEResourceEnvironmentRequirement()
	 * @generated
	 */
	EAttribute getJ2EEResourceEnvironmentRequirement_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceEnvironmentRequirement#getType()
	 * @see #getJ2EEResourceEnvironmentRequirement()
	 * @generated
	 */
	EAttribute getJ2EEResourceEnvironmentRequirement_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement <em>J2EE Resource Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Resource Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement
	 * @generated
	 */
	EClass getJ2EEResourceRequirement();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement#getJndiName()
	 * @see #getJ2EEResourceRequirement()
	 * @generated
	 */
	EAttribute getJ2EEResourceRequirement_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEResourceRequirement#getType()
	 * @see #getJ2EEResourceRequirement()
	 * @generated
	 */
	EAttribute getJ2EEResourceRequirement_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole <em>J2EE Security Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Security Role</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole
	 * @generated
	 */
	EClass getJ2EESecurityRole();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole#getRole()
	 * @see #getJ2EESecurityRole()
	 * @generated
	 */
	EAttribute getJ2EESecurityRole_Role();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEServer <em>J2EE Server</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEServer
	 * @generated
	 */
	EClass getJ2EEServer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit <em>J2EE Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>J2EE Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEServerUnit
	 * @generated
	 */
	EClass getJ2EEServerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JarModule <em>Jar Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jar Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JarModule
	 * @generated
	 */
	EClass getJarModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JarModuleCapability <em>Jar Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jar Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JarModuleCapability
	 * @generated
	 */
	EClass getJarModuleCapability();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JavaInterface <em>Java Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JavaInterface
	 * @generated
	 */
	EClass getJavaInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.JavaInterface#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JavaInterface#getInterface()
	 * @see #getJavaInterface()
	 * @generated
	 */
	EAttribute getJavaInterface_Interface();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer <em>JCA Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JCA Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainer
	 * @generated
	 */
	EClass getJCAContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion <em>Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainer#getContainerVersion()
	 * @see #getJCAContainer()
	 * @generated
	 */
	EAttribute getJCAContainer_ContainerVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JCAModule <em>JCA Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JCA Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAModule
	 * @generated
	 */
	EClass getJCAModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JCAModuleCapability <em>JCA Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JCA Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAModuleCapability
	 * @generated
	 */
	EClass getJCAModuleCapability();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainer <em>JSP Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JSP Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainer
	 * @generated
	 */
	EClass getJSPContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainer#getContainerVersion <em>Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainer#getContainerVersion()
	 * @see #getJSPContainer()
	 * @generated
	 */
	EAttribute getJSPContainer_ContainerVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainer <em>Servlet Container</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servlet Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainer
	 * @generated
	 */
	EClass getServletContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainer#getContainerVersion <em>Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainer#getContainerVersion()
	 * @see #getServletContainer()
	 * @generated
	 */
	EAttribute getServletContainer_ContainerVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.SessionService <em>Session Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.SessionService
	 * @generated
	 */
	EClass getSessionService();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.URLInterface <em>URL Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.URLInterface
	 * @generated
	 */
	EClass getURLInterface();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.URLInterface#getParamName <em>Param Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Param Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.URLInterface#getParamName()
	 * @see #getURLInterface()
	 * @generated
	 */
	EAttribute getURLInterface_ParamName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.URLService <em>URL Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.URLService
	 * @generated
	 */
	EClass getURLService();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.URLService#getUrlPattern <em>Url Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Url Pattern</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.URLService#getUrlPattern()
	 * @see #getURLService()
	 * @generated
	 */
	EAttribute getURLService_UrlPattern();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.WebModule <em>Web Module</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Module</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WebModule
	 * @generated
	 */
	EClass getWebModule();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability <em>Web Module Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Module Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability
	 * @generated
	 */
	EClass getWebModuleCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability#getContextRoot <em>Context Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WebModuleCapability#getContextRoot()
	 * @see #getWebModuleCapability()
	 * @generated
	 */
	EAttribute getWebModuleCapability_ContextRoot();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.WebService <em>Web Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WebService
	 * @generated
	 */
	EClass getWebService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.WebService#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endpoint</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WebService#getEndpoint()
	 * @see #getWebService()
	 * @generated
	 */
	EAttribute getWebService_Endpoint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.WSDLInterface <em>WSDL Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>WSDL Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WSDLInterface
	 * @generated
	 */
	EClass getWSDLInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.WSDLInterface#getTypeUri <em>Type Uri</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Uri</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.WSDLInterface#getTypeUri()
	 * @see #getWSDLInterface()
	 * @generated
	 */
	EAttribute getWSDLInterface_TypeUri();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion <em>EJB Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EJB Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
	 * @generated
	 */
	EEnum getEJBContainerVersion();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion <em>J2EE Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>J2EE Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
	 * @generated
	 */
	EEnum getJ2EEContainerVersion();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion <em>JCA Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>JCA Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @generated
	 */
	EEnum getJCAContainerVersion();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion <em>JSP Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>JSP Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
	 * @generated
	 */
	EEnum getJSPContainerVersion();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion <em>Servlet Container Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Servlet Container Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
	 * @generated
	 */
	EEnum getServletContainerVersion();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.Vicinity <em>Vicinity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Vicinity</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @generated
	 */
	EEnum getVicinity();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion <em>EJB Container Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EJB Container Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion"
	 *        extendedMetaData="name='EJBContainerVersion:Object' baseType='EJBContainerVersion'"
	 * @generated
	 */
	EDataType getEJBContainerVersionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion <em>J2EE Container Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>J2EE Container Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion"
	 *        extendedMetaData="name='J2EEContainerVersion:Object' baseType='J2EEContainerVersion'"
	 * @generated
	 */
	EDataType getJ2EEContainerVersionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion <em>JCA Container Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JCA Container Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion"
	 *        extendedMetaData="name='JCAContainerVersion:Object' baseType='JCAContainerVersion'"
	 * @generated
	 */
	EDataType getJCAContainerVersionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion <em>JSP Container Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JSP Container Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion"
	 *        extendedMetaData="name='JSPContainerVersion:Object' baseType='JSPContainerVersion'"
	 * @generated
	 */
	EDataType getJSPContainerVersionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion <em>Servlet Container Version Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Servlet Container Version Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion"
	 *        extendedMetaData="name='ServletContainerVersion:Object' baseType='ServletContainerVersion'"
	 * @generated
	 */
	EDataType getServletContainerVersionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.Vicinity <em>Vicinity Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Vicinity Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.Vicinity"
	 *        extendedMetaData="name='Vicinity:Object' baseType='Vicinity'"
	 * @generated
	 */
	EDataType getVicinityObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	J2eeFactory getJ2eeFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.AppClientImpl <em>App Client</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.AppClientImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getAppClient()
		 * @generated
		 */
		EClass APP_CLIENT = eINSTANCE.getAppClient();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.AppClientModuleImpl <em>App Client Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.AppClientModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getAppClientModule()
		 * @generated
		 */
		EClass APP_CLIENT_MODULE = eINSTANCE.getAppClientModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EarModuleImpl <em>Ear Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EarModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEarModule()
		 * @generated
		 */
		EClass EAR_MODULE = eINSTANCE.getEarModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EARModuleCapabilityImpl <em>EAR Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EARModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEARModuleCapability()
		 * @generated
		 */
		EClass EAR_MODULE_CAPABILITY = eINSTANCE.getEARModuleCapability();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBImpl <em>EJB</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJB()
		 * @generated
		 */
		EClass EJB = eINSTANCE.getEJB();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EJB__INTERFACE = eINSTANCE.getEJB_Interface();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBContainerImpl <em>EJB Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBContainerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainer()
		 * @generated
		 */
		EClass EJB_CONTAINER = eINSTANCE.getEJBContainer();

		/**
		 * The meta object literal for the '<em><b>Container Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EJB_CONTAINER__CONTAINER_VERSION = eINSTANCE.getEJBContainer_ContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EjbModuleImpl <em>Ejb Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EjbModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEjbModule()
		 * @generated
		 */
		EClass EJB_MODULE = eINSTANCE.getEjbModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EJBModuleCapabilityImpl <em>EJB Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EJBModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBModuleCapability()
		 * @generated
		 */
		EClass EJB_MODULE_CAPABILITY = eINSTANCE.getEJBModuleCapability();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl <em>Enterprise Bean Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEnterpriseBeanService()
		 * @generated
		 */
		EClass ENTERPRISE_BEAN_SERVICE = eINSTANCE.getEnterpriseBeanService();

		/**
		 * The meta object literal for the '<em><b>Home Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE = eINSTANCE
				.getEnterpriseBeanService_HomeInterface();

		/**
		 * The meta object literal for the '<em><b>Ejb Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTERPRISE_BEAN_SERVICE__EJB_NAME = eINSTANCE.getEnterpriseBeanService_EjbName();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTERPRISE_BEAN_SERVICE__JNDI_NAME = eINSTANCE.getEnterpriseBeanService_JndiName();

		/**
		 * The meta object literal for the '<em><b>Vicinity</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTERPRISE_BEAN_SERVICE__VICINITY = eINSTANCE.getEnterpriseBeanService_Vicinity();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.EntityServiceImpl <em>Entity Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.EntityServiceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEntityService()
		 * @generated
		 */
		EClass ENTITY_SERVICE = eINSTANCE.getEntityService();

		/**
		 * The meta object literal for the '<em><b>Managed</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTITY_SERVICE__MANAGED = eINSTANCE.getEntityService_Managed();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.GenericJ2eeServerImpl <em>Generic J2ee Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.GenericJ2eeServerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getGenericJ2eeServer()
		 * @generated
		 */
		EClass GENERIC_J2EE_SERVER = eINSTANCE.getGenericJ2eeServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.GenericWebServerImpl <em>Generic Web Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.GenericWebServerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getGenericWebServer()
		 * @generated
		 */
		EClass GENERIC_WEB_SERVER = eINSTANCE.getGenericWebServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl <em>J2C Authentication Data Entry</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationDataEntryImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2CAuthenticationDataEntry()
		 * @generated
		 */
		EClass J2C_AUTHENTICATION_DATA_ENTRY = eINSTANCE.getJ2CAuthenticationDataEntry();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2C_AUTHENTICATION_DATA_ENTRY__ALIAS = eINSTANCE
				.getJ2CAuthenticationDataEntry_Alias();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD = eINSTANCE
				.getJ2CAuthenticationDataEntry_Password();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2C_AUTHENTICATION_DATA_ENTRY__USER_ID = eINSTANCE
				.getJ2CAuthenticationDataEntry_UserId();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationUnitImpl <em>J2C Authentication Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2CAuthenticationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2CAuthenticationUnit()
		 * @generated
		 */
		EClass J2C_AUTHENTICATION_UNIT = eINSTANCE.getJ2CAuthenticationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEContainerImpl <em>J2EE Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEContainerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainer()
		 * @generated
		 */
		EClass J2EE_CONTAINER = eINSTANCE.getJ2EEContainer();

		/**
		 * The meta object literal for the '<em><b>Container Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute J2EE_CONTAINER__CONTAINER_VERSION = eINSTANCE.getJ2EEContainer_ContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl <em>J2EE Datasource</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEDatasource()
		 * @generated
		 */
		EClass J2EE_DATASOURCE = eINSTANCE.getJ2EEDatasource();

		/**
		 * The meta object literal for the '<em><b>Datasource Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__DATASOURCE_NAME = eINSTANCE.getJ2EEDatasource_DatasourceName();

		/**
		 * The meta object literal for the '<em><b>Db Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__DB_NAME = eINSTANCE.getJ2EEDatasource_DbName();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__HOSTNAME = eINSTANCE.getJ2EEDatasource_Hostname();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__JNDI_NAME = eINSTANCE.getJ2EEDatasource_JndiName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__PASSWORD = eINSTANCE.getJ2EEDatasource_Password();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__PORT = eINSTANCE.getJ2EEDatasource_Port();

		/**
		 * The meta object literal for the '<em><b>Used For Cmp</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__USED_FOR_CMP = eINSTANCE.getJ2EEDatasource_UsedForCmp();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DATASOURCE__USERNAME = eINSTANCE.getJ2EEDatasource_Username();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl <em>J2EE Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEDeployRoot()
		 * @generated
		 */
		EClass J2EE_DEPLOY_ROOT = eINSTANCE.getJ2EEDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_DEPLOY_ROOT__MIXED = eINSTANCE.getJ2EEDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getJ2EEDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE
				.getJ2EEDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability App Client Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_APP_CLIENT_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityAppClientModule();

		/**
		 * The meta object literal for the '<em><b>Capability Ear Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_EAR_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityEarModule();

		/**
		 * The meta object literal for the '<em><b>Capability Ejb</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_EJB = eINSTANCE.getJ2EEDeployRoot_CapabilityEjb();

		/**
		 * The meta object literal for the '<em><b>Capability Ejb Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_EJB_CONTAINER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityEjbContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Ejb Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_EJB_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityEjbModule();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_CONTAINER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeContainer();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Datasource</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_DATASOURCE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeDatasource();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeModule();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Resource Environment Requirement</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeResourceEnvironmentRequirement();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Resource Requirement</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_RESOURCE_REQUIREMENT = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeResourceRequirement();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Security Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SECURITY_ROLE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeSecurityRole();

		/**
		 * The meta object literal for the '<em><b>Capability J2ee Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_J2EE_SERVER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJ2eeServer();

		/**
		 * The meta object literal for the '<em><b>Capability Jar Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_JAR_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJarModule();

		/**
		 * The meta object literal for the '<em><b>Capability Jca Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_JCA_CONTAINER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJcaContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Jca Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_JCA_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJcaModule();

		/**
		 * The meta object literal for the '<em><b>Capability Jsp Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_JSP_CONTAINER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityJspContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Servlet Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_SERVLET_CONTAINER = eINSTANCE
				.getJ2EEDeployRoot_CapabilityServletContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Web Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__CAPABILITY_WEB_MODULE = eINSTANCE
				.getJ2EEDeployRoot_CapabilityWebModule();

		/**
		 * The meta object literal for the '<em><b>Component Ear</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__COMPONENT_EAR = eINSTANCE.getJ2EEDeployRoot_ComponentEar();

		/**
		 * The meta object literal for the '<em><b>Component Ejb</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__COMPONENT_EJB = eINSTANCE.getJ2EEDeployRoot_ComponentEjb();

		/**
		 * The meta object literal for the '<em><b>Component Jar</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__COMPONENT_JAR = eINSTANCE.getJ2EEDeployRoot_ComponentJar();

		/**
		 * The meta object literal for the '<em><b>Component Web</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__COMPONENT_WEB = eINSTANCE.getJ2EEDeployRoot_ComponentWeb();

		/**
		 * The meta object literal for the '<em><b>Interface Java</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__INTERFACE_JAVA = eINSTANCE.getJ2EEDeployRoot_InterfaceJava();

		/**
		 * The meta object literal for the '<em><b>Interface Url</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__INTERFACE_URL = eINSTANCE.getJ2EEDeployRoot_InterfaceUrl();

		/**
		 * The meta object literal for the '<em><b>Interface Wsdl</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__INTERFACE_WSDL = eINSTANCE.getJ2EEDeployRoot_InterfaceWsdl();

		/**
		 * The meta object literal for the '<em><b>Service Entity</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__SERVICE_ENTITY = eINSTANCE.getJ2EEDeployRoot_ServiceEntity();

		/**
		 * The meta object literal for the '<em><b>Service Servlet</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__SERVICE_SERVLET = eINSTANCE.getJ2EEDeployRoot_ServiceServlet();

		/**
		 * The meta object literal for the '<em><b>Service Session</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__SERVICE_SESSION = eINSTANCE.getJ2EEDeployRoot_ServiceSession();

		/**
		 * The meta object literal for the '<em><b>Service Ws</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__SERVICE_WS = eINSTANCE.getJ2EEDeployRoot_ServiceWs();

		/**
		 * The meta object literal for the '<em><b>Unit App Client</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__UNIT_APP_CLIENT = eINSTANCE.getJ2EEDeployRoot_UnitAppClient();

		/**
		 * The meta object literal for the '<em><b>Unit J2ee Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER = eINSTANCE.getJ2EEDeployRoot_UnitJ2eeServer();

		/**
		 * The meta object literal for the '<em><b>Unit J2ee Server Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__UNIT_J2EE_SERVER_UNIT = eINSTANCE
				.getJ2EEDeployRoot_UnitJ2eeServerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Jca Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__UNIT_JCA_MODULE = eINSTANCE.getJ2EEDeployRoot_UnitJcaModule();

		/**
		 * The meta object literal for the '<em><b>Unit Web Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference J2EE_DEPLOY_ROOT__UNIT_WEB_SERVER = eINSTANCE.getJ2EEDeployRoot_UnitWebServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEModuleCapabilityImpl <em>J2EE Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEModuleCapability()
		 * @generated
		 */
		EClass J2EE_MODULE_CAPABILITY = eINSTANCE.getJ2EEModuleCapability();

		/**
		 * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_MODULE_CAPABILITY__MODULE_NAME = eINSTANCE
				.getJ2EEModuleCapability_ModuleName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl <em>J2EE Resource Environment Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceEnvironmentRequirementImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEResourceEnvironmentRequirement()
		 * @generated
		 */
		EClass J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT = eINSTANCE
				.getJ2EEResourceEnvironmentRequirement();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__JNDI_NAME = eINSTANCE
				.getJ2EEResourceEnvironmentRequirement_JndiName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT__TYPE = eINSTANCE
				.getJ2EEResourceEnvironmentRequirement_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceRequirementImpl <em>J2EE Resource Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEResourceRequirementImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEResourceRequirement()
		 * @generated
		 */
		EClass J2EE_RESOURCE_REQUIREMENT = eINSTANCE.getJ2EEResourceRequirement();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_RESOURCE_REQUIREMENT__JNDI_NAME = eINSTANCE
				.getJ2EEResourceRequirement_JndiName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_RESOURCE_REQUIREMENT__TYPE = eINSTANCE.getJ2EEResourceRequirement_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EESecurityRoleImpl <em>J2EE Security Role</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EESecurityRoleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EESecurityRole()
		 * @generated
		 */
		EClass J2EE_SECURITY_ROLE = eINSTANCE.getJ2EESecurityRole();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute J2EE_SECURITY_ROLE__ROLE = eINSTANCE.getJ2EESecurityRole_Role();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerImpl <em>J2EE Server</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEServer()
		 * @generated
		 */
		EClass J2EE_SERVER = eINSTANCE.getJ2EEServer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl <em>J2EE Server Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2EEServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEServerUnit()
		 * @generated
		 */
		EClass J2EE_SERVER_UNIT = eINSTANCE.getJ2EEServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleImpl <em>Jar Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJarModule()
		 * @generated
		 */
		EClass JAR_MODULE = eINSTANCE.getJarModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleCapabilityImpl <em>Jar Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JarModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJarModuleCapability()
		 * @generated
		 */
		EClass JAR_MODULE_CAPABILITY = eINSTANCE.getJarModuleCapability();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JavaInterfaceImpl <em>Java Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JavaInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJavaInterface()
		 * @generated
		 */
		EClass JAVA_INTERFACE = eINSTANCE.getJavaInterface();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JAVA_INTERFACE__INTERFACE = eINSTANCE.getJavaInterface_Interface();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAContainerImpl <em>JCA Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAContainerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainer()
		 * @generated
		 */
		EClass JCA_CONTAINER = eINSTANCE.getJCAContainer();

		/**
		 * The meta object literal for the '<em><b>Container Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JCA_CONTAINER__CONTAINER_VERSION = eINSTANCE.getJCAContainer_ContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleImpl <em>JCA Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAModule()
		 * @generated
		 */
		EClass JCA_MODULE = eINSTANCE.getJCAModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleCapabilityImpl <em>JCA Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JCAModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAModuleCapability()
		 * @generated
		 */
		EClass JCA_MODULE_CAPABILITY = eINSTANCE.getJCAModuleCapability();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.JSPContainerImpl <em>JSP Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.JSPContainerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainer()
		 * @generated
		 */
		EClass JSP_CONTAINER = eINSTANCE.getJSPContainer();

		/**
		 * The meta object literal for the '<em><b>Container Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JSP_CONTAINER__CONTAINER_VERSION = eINSTANCE.getJSPContainer_ContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.ServletContainerImpl <em>Servlet Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.ServletContainerImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainer()
		 * @generated
		 */
		EClass SERVLET_CONTAINER = eINSTANCE.getServletContainer();

		/**
		 * The meta object literal for the '<em><b>Container Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVLET_CONTAINER__CONTAINER_VERSION = eINSTANCE
				.getServletContainer_ContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.SessionServiceImpl <em>Session Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.SessionServiceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getSessionService()
		 * @generated
		 */
		EClass SESSION_SERVICE = eINSTANCE.getSessionService();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.URLInterfaceImpl <em>URL Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.URLInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getURLInterface()
		 * @generated
		 */
		EClass URL_INTERFACE = eINSTANCE.getURLInterface();

		/**
		 * The meta object literal for the '<em><b>Param Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_INTERFACE__PARAM_NAME = eINSTANCE.getURLInterface_ParamName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.URLServiceImpl <em>URL Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.URLServiceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getURLService()
		 * @generated
		 */
		EClass URL_SERVICE = eINSTANCE.getURLService();

		/**
		 * The meta object literal for the '<em><b>Url Pattern</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_SERVICE__URL_PATTERN = eINSTANCE.getURLService_UrlPattern();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleImpl <em>Web Module</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebModule()
		 * @generated
		 */
		EClass WEB_MODULE = eINSTANCE.getWebModule();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleCapabilityImpl <em>Web Module Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebModuleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebModuleCapability()
		 * @generated
		 */
		EClass WEB_MODULE_CAPABILITY = eINSTANCE.getWebModuleCapability();

		/**
		 * The meta object literal for the '<em><b>Context Root</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WEB_MODULE_CAPABILITY__CONTEXT_ROOT = eINSTANCE
				.getWebModuleCapability_ContextRoot();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl <em>Web Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WebServiceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWebService()
		 * @generated
		 */
		EClass WEB_SERVICE = eINSTANCE.getWebService();

		/**
		 * The meta object literal for the '<em><b>Endpoint</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WEB_SERVICE__ENDPOINT = eINSTANCE.getWebService_Endpoint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.impl.WSDLInterfaceImpl <em>WSDL Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.WSDLInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getWSDLInterface()
		 * @generated
		 */
		EClass WSDL_INTERFACE = eINSTANCE.getWSDLInterface();

		/**
		 * The meta object literal for the '<em><b>Type Uri</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WSDL_INTERFACE__TYPE_URI = eINSTANCE.getWSDLInterface_TypeUri();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion <em>EJB Container Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainerVersion()
		 * @generated
		 */
		EEnum EJB_CONTAINER_VERSION = eINSTANCE.getEJBContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion <em>J2EE Container Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainerVersion()
		 * @generated
		 */
		EEnum J2EE_CONTAINER_VERSION = eINSTANCE.getJ2EEContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion <em>JCA Container Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainerVersion()
		 * @generated
		 */
		EEnum JCA_CONTAINER_VERSION = eINSTANCE.getJCAContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion <em>JSP Container Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainerVersion()
		 * @generated
		 */
		EEnum JSP_CONTAINER_VERSION = eINSTANCE.getJSPContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion <em>Servlet Container Version</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainerVersion()
		 * @generated
		 */
		EEnum SERVLET_CONTAINER_VERSION = eINSTANCE.getServletContainerVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.Vicinity <em>Vicinity</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getVicinity()
		 * @generated
		 */
		EEnum VICINITY = eINSTANCE.getVicinity();

		/**
		 * The meta object literal for the '<em>EJB Container Version Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getEJBContainerVersionObject()
		 * @generated
		 */
		EDataType EJB_CONTAINER_VERSION_OBJECT = eINSTANCE.getEJBContainerVersionObject();

		/**
		 * The meta object literal for the '<em>J2EE Container Version Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJ2EEContainerVersionObject()
		 * @generated
		 */
		EDataType J2EE_CONTAINER_VERSION_OBJECT = eINSTANCE.getJ2EEContainerVersionObject();

		/**
		 * The meta object literal for the '<em>JCA Container Version Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJCAContainerVersionObject()
		 * @generated
		 */
		EDataType JCA_CONTAINER_VERSION_OBJECT = eINSTANCE.getJCAContainerVersionObject();

		/**
		 * The meta object literal for the '<em>JSP Container Version Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getJSPContainerVersionObject()
		 * @generated
		 */
		EDataType JSP_CONTAINER_VERSION_OBJECT = eINSTANCE.getJSPContainerVersionObject();

		/**
		 * The meta object literal for the '<em>Servlet Container Version Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getServletContainerVersionObject()
		 * @generated
		 */
		EDataType SERVLET_CONTAINER_VERSION_OBJECT = eINSTANCE.getServletContainerVersionObject();

		/**
		 * The meta object literal for the '<em>Vicinity Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
		 * @see com.ibm.ccl.soa.deploy.j2ee.impl.J2eePackageImpl#getVicinityObject()
		 * @generated
		 */
		EDataType VICINITY_OBJECT = eINSTANCE.getVicinityObject();

	}

} //J2eePackage
