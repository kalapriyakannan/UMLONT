/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

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
 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JmsFactory
 * @model kind="package"
 * @generated
 */
public interface JmsPackage extends EPackage {
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
	String eNAME = "jms"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/j2ee/jms/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jms"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	JmsPackage eINSTANCE = com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl <em>JMS Activation Specification</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSActivationSpecification()
	 * @generated
	 */
	int JMS_ACTIVATION_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Acknowledge Mode</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Client Identifier</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mesasage Selector</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Specification Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Subscription Durable</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Subscription Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>JMS Activation Specification</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationUnitImpl <em>JMS Activation Specification Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSActivationSpecificationUnit()
	 * @generated
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Activation Specification Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_ACTIVATION_SPECIFICATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryImpl <em>JMS Connection Factory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSConnectionFactory()
	 * @generated
	 */
	int JMS_CONNECTION_FACTORY = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__FACTORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JMS Connection Factory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryUnitImpl <em>JMS Connection Factory Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSConnectionFactoryUnit()
	 * @generated
	 */
	int JMS_CONNECTION_FACTORY_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Connection Factory Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_CONNECTION_FACTORY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl <em>JMS Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSDeployRoot()
	 * @generated
	 */
	int JMS_DEPLOY_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability JMS Activation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Capability JMS Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY = 4;

	/**
	 * The feature id for the '<em><b>Capability JMS Destination</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION = 5;

	/**
	 * The feature id for the '<em><b>Capability JMS Provider</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Capability JMS Queue Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY = 7;

	/**
	 * The feature id for the '<em><b>Capability JMS Queue Destination</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION = 8;

	/**
	 * The feature id for the '<em><b>Capability JMS Topic Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY = 9;

	/**
	 * The feature id for the '<em><b>Capability JMS Topic Destination</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION = 10;

	/**
	 * The feature id for the '<em><b>Unit JMS Activation Specification Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Unit JMS Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Unit JMS Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Unit JMS Queue Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Unit JMS Queue Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Unit JMS Topic Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT = 16;

	/**
	 * The feature id for the '<em><b>Unit JMS Topic Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT = 17;

	/**
	 * The number of structural features of the '<em>JMS Deploy Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DEPLOY_ROOT_FEATURE_COUNT = 18;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl <em>JMS Destination</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSDestination()
	 * @generated
	 */
	int JMS_DESTINATION = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__DESTINATION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JMS Destination</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_DESTINATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl <em>JMS Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSProvider()
	 * @generated
	 */
	int JMS_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__CLASS_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native Path</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__NATIVE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Context Factory</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__INITIAL_CONTEXT_FACTORY = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__PROVIDER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Provider URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__PROVIDER_URL = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Provider Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER__PROVIDER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>JMS Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderUnitImpl <em>JMS Provider Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSProviderUnit()
	 * @generated
	 */
	int JMS_PROVIDER_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Provider Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_PROVIDER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryImpl <em>JMS Queue Connection Factory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueConnectionFactory()
	 * @generated
	 */
	int JMS_QUEUE_CONNECTION_FACTORY = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__FACTORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JMS Queue Connection Factory</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryUnitImpl <em>JMS Queue Connection Factory Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueConnectionFactoryUnit()
	 * @generated
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Queue Connection Factory Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_CONNECTION_FACTORY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationImpl <em>JMS Queue Destination</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueDestination()
	 * @generated
	 */
	int JMS_QUEUE_DESTINATION = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__ANNOTATIONS = JMS_DESTINATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__ATTRIBUTE_META_DATA = JMS_DESTINATION__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__EXTENDED_ATTRIBUTES = JMS_DESTINATION__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__ARTIFACT_GROUP = JMS_DESTINATION__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__ARTIFACTS = JMS_DESTINATION__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__CONSTRAINT_GROUP = JMS_DESTINATION__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__CONSTRAINTS = JMS_DESTINATION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__DESCRIPTION = JMS_DESTINATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__DISPLAY_NAME = JMS_DESTINATION__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__MUTABLE = JMS_DESTINATION__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__NAME = JMS_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__STEREOTYPES = JMS_DESTINATION__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__BUILD_VERSION = JMS_DESTINATION__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__LINK_TYPE = JMS_DESTINATION__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__ORIGIN = JMS_DESTINATION__ORIGIN;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__DESTINATION_NAME = JMS_DESTINATION__DESTINATION_NAME;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION__JNDI_NAME = JMS_DESTINATION__JNDI_NAME;

	/**
	 * The number of structural features of the '<em>JMS Queue Destination</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_FEATURE_COUNT = JMS_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationUnitImpl <em>JMS Queue Destination Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueDestinationUnit()
	 * @generated
	 */
	int JMS_QUEUE_DESTINATION_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Queue Destination Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_QUEUE_DESTINATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl <em>JMS Topic Connection Factory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicConnectionFactory()
	 * @generated
	 */
	int JMS_TOPIC_CONNECTION_FACTORY = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JMS Topic Connection Factory</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryUnitImpl <em>JMS Topic Connection Factory Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicConnectionFactoryUnit()
	 * @generated
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Topic Connection Factory Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_CONNECTION_FACTORY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationImpl <em>JMS Topic Destination</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicDestination()
	 * @generated
	 */
	int JMS_TOPIC_DESTINATION = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__ANNOTATIONS = JMS_DESTINATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__ATTRIBUTE_META_DATA = JMS_DESTINATION__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__EXTENDED_ATTRIBUTES = JMS_DESTINATION__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__ARTIFACT_GROUP = JMS_DESTINATION__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__ARTIFACTS = JMS_DESTINATION__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__CONSTRAINT_GROUP = JMS_DESTINATION__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__CONSTRAINTS = JMS_DESTINATION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__DESCRIPTION = JMS_DESTINATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__DISPLAY_NAME = JMS_DESTINATION__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__MUTABLE = JMS_DESTINATION__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__NAME = JMS_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__STEREOTYPES = JMS_DESTINATION__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__BUILD_VERSION = JMS_DESTINATION__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__LINK_TYPE = JMS_DESTINATION__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__ORIGIN = JMS_DESTINATION__ORIGIN;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__DESTINATION_NAME = JMS_DESTINATION__DESTINATION_NAME;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION__JNDI_NAME = JMS_DESTINATION__JNDI_NAME;

	/**
	 * The number of structural features of the '<em>JMS Topic Destination</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_FEATURE_COUNT = JMS_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationUnitImpl <em>JMS Topic Destination Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicDestinationUnit()
	 * @generated
	 */
	int JMS_TOPIC_DESTINATION_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>JMS Topic Destination Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JMS_TOPIC_DESTINATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum <em>Acknowledge Mode Enum</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getAcknowledgeModeEnum()
	 * @generated
	 */
	int ACKNOWLEDGE_MODE_ENUM = 16;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum <em>Destination Type Enum</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getDestinationTypeEnum()
	 * @generated
	 */
	int DESTINATION_TYPE_ENUM = 17;

	/**
	 * The meta object id for the '<em>Acknowledge Mode Enum Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getAcknowledgeModeEnumObject()
	 * @generated
	 */
	int ACKNOWLEDGE_MODE_ENUM_OBJECT = 18;

	/**
	 * The meta object id for the '<em>Destination Type Enum Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getDestinationTypeEnumObject()
	 * @generated
	 */
	int DESTINATION_TYPE_ENUM_OBJECT = 19;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification <em>JMS Activation Specification</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Activation Specification</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification
	 * @generated
	 */
	EClass getJMSActivationSpecification();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode <em>Acknowledge Mode</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acknowledge Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getAcknowledgeMode()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_AcknowledgeMode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getClientIdentifier <em>Client Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getClientIdentifier()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_ClientIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getJndiName()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mesasage Selector</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getMesasageSelector()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_MesasageSelector();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSpecificationName <em>Specification Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSpecificationName()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_SpecificationName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subscription Durable</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#isSubscriptionDurable()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_SubscriptionDurable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSubscriptionName <em>Subscription Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subscription Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification#getSubscriptionName()
	 * @see #getJMSActivationSpecification()
	 * @generated
	 */
	EAttribute getJMSActivationSpecification_SubscriptionName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit <em>JMS Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Activation Specification Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecificationUnit
	 * @generated
	 */
	EClass getJMSActivationSpecificationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory <em>JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory
	 * @generated
	 */
	EClass getJMSConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory#getFactoryName <em>Factory Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory#getFactoryName()
	 * @see #getJMSConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSConnectionFactory_FactoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactory#getJndiName()
	 * @see #getJMSConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSConnectionFactory_JndiName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit <em>JMS Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSConnectionFactoryUnit
	 * @generated
	 */
	EClass getJMSConnectionFactoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot <em>JMS Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot
	 * @generated
	 */
	EClass getJMSDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getMixed()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EAttribute getJMSDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXMLNSPrefixMap()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getXSISchemaLocation()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSActivationSpecification <em>Capability JMS Activation Specification</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Activation Specification</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSActivationSpecification()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSActivationSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSConnectionFactory <em>Capability JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSConnectionFactory()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSConnectionFactory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSDestination <em>Capability JMS Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSDestination()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSProvider <em>Capability JMS Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSProvider()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSProvider();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueConnectionFactory <em>Capability JMS Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Queue Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueConnectionFactory()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSQueueConnectionFactory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueDestination <em>Capability JMS Queue Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Queue Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSQueueDestination()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSQueueDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicConnectionFactory <em>Capability JMS Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Topic Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicConnectionFactory()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSTopicConnectionFactory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicDestination <em>Capability JMS Topic Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability JMS Topic Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getCapabilityJMSTopicDestination()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_CapabilityJMSTopicDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSActivationSpecificationUnit <em>Unit JMS Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Activation Specification Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSActivationSpecificationUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSActivationSpecificationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSConnectionFactoryUnit <em>Unit JMS Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSConnectionFactoryUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSConnectionFactoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSProviderUnit <em>Unit JMS Provider Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSProviderUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSProviderUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueConnectionFactoryUnit <em>Unit JMS Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Queue Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueConnectionFactoryUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueDestinationUnit <em>Unit JMS Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Queue Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSQueueDestinationUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSQueueDestinationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicConnectionFactoryUnit <em>Unit JMS Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Topic Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicConnectionFactoryUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicDestinationUnit <em>Unit JMS Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit JMS Topic Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDeployRoot#getUnitJMSTopicDestinationUnit()
	 * @see #getJMSDeployRoot()
	 * @generated
	 */
	EReference getJMSDeployRoot_UnitJMSTopicDestinationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination <em>JMS Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination
	 * @generated
	 */
	EClass getJMSDestination();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination#getDestinationName <em>Destination Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination#getDestinationName()
	 * @see #getJMSDestination()
	 * @generated
	 */
	EAttribute getJMSDestination_DestinationName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSDestination#getJndiName()
	 * @see #getJMSDestination()
	 * @generated
	 */
	EAttribute getJMSDestination_JndiName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider <em>JMS Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider
	 * @generated
	 */
	EClass getJMSProvider();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getClassPath <em>Class Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Class Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getClassPath()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_ClassPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getInitialContextFactory <em>Initial Context Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Context Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getInitialContextFactory()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_InitialContextFactory();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getNativePath <em>Native Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Native Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getNativePath()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_NativePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderName()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_ProviderName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderURL <em>Provider URL</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider URL</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderURL()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_ProviderURL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderVersion <em>Provider Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProvider#getProviderVersion()
	 * @see #getJMSProvider()
	 * @generated
	 */
	EAttribute getJMSProvider_ProviderVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit <em>JMS Provider Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSProviderUnit
	 * @generated
	 */
	EClass getJMSProviderUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory <em>JMS Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Queue Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory
	 * @generated
	 */
	EClass getJMSQueueConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory#getFactoryName <em>Factory Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory#getFactoryName()
	 * @see #getJMSQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSQueueConnectionFactory_FactoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactory#getJndiName()
	 * @see #getJMSQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSQueueConnectionFactory_JndiName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit <em>JMS Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Queue Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueConnectionFactoryUnit
	 * @generated
	 */
	EClass getJMSQueueConnectionFactoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination <em>JMS Queue Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Queue Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestination
	 * @generated
	 */
	EClass getJMSQueueDestination();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit <em>JMS Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Queue Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSQueueDestinationUnit
	 * @generated
	 */
	EClass getJMSQueueDestinationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory <em>JMS Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Topic Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory
	 * @generated
	 */
	EClass getJMSTopicConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory#getFactoryName <em>Factory Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory#getFactoryName()
	 * @see #getJMSTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSTopicConnectionFactory_FactoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactory#getJndiName()
	 * @see #getJMSTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getJMSTopicConnectionFactory_JndiName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit <em>JMS Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Topic Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicConnectionFactoryUnit
	 * @generated
	 */
	EClass getJMSTopicConnectionFactoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination <em>JMS Topic Destination</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Topic Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestination
	 * @generated
	 */
	EClass getJMSTopicDestination();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit <em>JMS Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMS Topic Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.JMSTopicDestinationUnit
	 * @generated
	 */
	EClass getJMSTopicDestinationUnit();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum <em>Acknowledge Mode Enum</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Acknowledge Mode Enum</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @generated
	 */
	EEnum getAcknowledgeModeEnum();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum <em>Destination Type Enum</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Destination Type Enum</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
	 * @generated
	 */
	EEnum getDestinationTypeEnum();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum <em>Acknowledge Mode Enum Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Acknowledge Mode Enum Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum"
	 *        extendedMetaData="name='AcknowledgeModeEnum:Object' baseType='AcknowledgeModeEnum'"
	 * @generated
	 */
	EDataType getAcknowledgeModeEnumObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum <em>Destination Type Enum Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Destination Type Enum Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
	 * @model instanceClass="com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum"
	 *        extendedMetaData="name='DestinationTypeEnum:Object' baseType='DestinationTypeEnum'"
	 * @generated
	 */
	EDataType getDestinationTypeEnumObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JmsFactory getJmsFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl <em>JMS Activation Specification</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSActivationSpecification()
		 * @generated
		 */
		EClass JMS_ACTIVATION_SPECIFICATION = eINSTANCE.getJMSActivationSpecification();

		/**
		 * The meta object literal for the '<em><b>Acknowledge Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE = eINSTANCE.getJMSActivationSpecification_AcknowledgeMode();

		/**
		 * The meta object literal for the '<em><b>Client Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER = eINSTANCE.getJMSActivationSpecification_ClientIdentifier();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__JNDI_NAME = eINSTANCE.getJMSActivationSpecification_JndiName();

		/**
		 * The meta object literal for the '<em><b>Mesasage Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR = eINSTANCE.getJMSActivationSpecification_MesasageSelector();

		/**
		 * The meta object literal for the '<em><b>Specification Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME = eINSTANCE.getJMSActivationSpecification_SpecificationName();

		/**
		 * The meta object literal for the '<em><b>Subscription Durable</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE = eINSTANCE.getJMSActivationSpecification_SubscriptionDurable();

		/**
		 * The meta object literal for the '<em><b>Subscription Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME = eINSTANCE.getJMSActivationSpecification_SubscriptionName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationUnitImpl <em>JMS Activation Specification Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSActivationSpecificationUnit()
		 * @generated
		 */
		EClass JMS_ACTIVATION_SPECIFICATION_UNIT = eINSTANCE.getJMSActivationSpecificationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryImpl <em>JMS Connection Factory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSConnectionFactory()
		 * @generated
		 */
		EClass JMS_CONNECTION_FACTORY = eINSTANCE.getJMSConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Factory Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_CONNECTION_FACTORY__FACTORY_NAME = eINSTANCE.getJMSConnectionFactory_FactoryName();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_CONNECTION_FACTORY__JNDI_NAME = eINSTANCE.getJMSConnectionFactory_JndiName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryUnitImpl <em>JMS Connection Factory Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSConnectionFactoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSConnectionFactoryUnit()
		 * @generated
		 */
		EClass JMS_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSConnectionFactoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl <em>JMS Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSDeployRoot()
		 * @generated
		 */
		EClass JMS_DEPLOY_ROOT = eINSTANCE.getJMSDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_DEPLOY_ROOT__MIXED = eINSTANCE.getJMSDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getJMSDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getJMSDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Activation Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_ACTIVATION_SPECIFICATION = eINSTANCE.getJMSDeployRoot_CapabilityJMSActivationSpecification();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Connection Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_CONNECTION_FACTORY = eINSTANCE.getJMSDeployRoot_CapabilityJMSConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_DESTINATION = eINSTANCE.getJMSDeployRoot_CapabilityJMSDestination();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_PROVIDER = eINSTANCE.getJMSDeployRoot_CapabilityJMSProvider();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Queue Connection Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_CONNECTION_FACTORY = eINSTANCE.getJMSDeployRoot_CapabilityJMSQueueConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Queue Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_QUEUE_DESTINATION = eINSTANCE.getJMSDeployRoot_CapabilityJMSQueueDestination();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Topic Connection Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_CONNECTION_FACTORY = eINSTANCE.getJMSDeployRoot_CapabilityJMSTopicConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Capability JMS Topic Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__CAPABILITY_JMS_TOPIC_DESTINATION = eINSTANCE.getJMSDeployRoot_CapabilityJMSTopicDestination();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Activation Specification Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_ACTIVATION_SPECIFICATION_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSActivationSpecificationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Connection Factory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSConnectionFactoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Provider Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_PROVIDER_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSProviderUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Queue Connection Factory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSQueueConnectionFactoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Queue Destination Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_QUEUE_DESTINATION_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSQueueDestinationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Topic Connection Factory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSTopicConnectionFactoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit JMS Topic Destination Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMS_DEPLOY_ROOT__UNIT_JMS_TOPIC_DESTINATION_UNIT = eINSTANCE.getJMSDeployRoot_UnitJMSTopicDestinationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl <em>JMS Destination</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSDestination()
		 * @generated
		 */
		EClass JMS_DESTINATION = eINSTANCE.getJMSDestination();

		/**
		 * The meta object literal for the '<em><b>Destination Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_DESTINATION__DESTINATION_NAME = eINSTANCE.getJMSDestination_DestinationName();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_DESTINATION__JNDI_NAME = eINSTANCE.getJMSDestination_JndiName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl <em>JMS Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSProvider()
		 * @generated
		 */
		EClass JMS_PROVIDER = eINSTANCE.getJMSProvider();

		/**
		 * The meta object literal for the '<em><b>Class Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_PROVIDER__CLASS_PATH = eINSTANCE.getJMSProvider_ClassPath();

		/**
		 * The meta object literal for the '<em><b>Initial Context Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_PROVIDER__INITIAL_CONTEXT_FACTORY = eINSTANCE.getJMSProvider_InitialContextFactory();

		/**
		 * The meta object literal for the '<em><b>Native Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_PROVIDER__NATIVE_PATH = eINSTANCE.getJMSProvider_NativePath();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_PROVIDER__PROVIDER_NAME = eINSTANCE.getJMSProvider_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Provider URL</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_PROVIDER__PROVIDER_URL = eINSTANCE.getJMSProvider_ProviderURL();

		/**
		 * The meta object literal for the '<em><b>Provider Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMS_PROVIDER__PROVIDER_VERSION = eINSTANCE.getJMSProvider_ProviderVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderUnitImpl <em>JMS Provider Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSProviderUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSProviderUnit()
		 * @generated
		 */
		EClass JMS_PROVIDER_UNIT = eINSTANCE.getJMSProviderUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryImpl <em>JMS Queue Connection Factory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueConnectionFactory()
		 * @generated
		 */
		EClass JMS_QUEUE_CONNECTION_FACTORY = eINSTANCE.getJMSQueueConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Factory Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_QUEUE_CONNECTION_FACTORY__FACTORY_NAME = eINSTANCE.getJMSQueueConnectionFactory_FactoryName();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_QUEUE_CONNECTION_FACTORY__JNDI_NAME = eINSTANCE.getJMSQueueConnectionFactory_JndiName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryUnitImpl <em>JMS Queue Connection Factory Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueConnectionFactoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueConnectionFactoryUnit()
		 * @generated
		 */
		EClass JMS_QUEUE_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSQueueConnectionFactoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationImpl <em>JMS Queue Destination</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueDestination()
		 * @generated
		 */
		EClass JMS_QUEUE_DESTINATION = eINSTANCE.getJMSQueueDestination();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationUnitImpl <em>JMS Queue Destination Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSQueueDestinationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSQueueDestinationUnit()
		 * @generated
		 */
		EClass JMS_QUEUE_DESTINATION_UNIT = eINSTANCE.getJMSQueueDestinationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl <em>JMS Topic Connection Factory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicConnectionFactory()
		 * @generated
		 */
		EClass JMS_TOPIC_CONNECTION_FACTORY = eINSTANCE.getJMSTopicConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Factory Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_TOPIC_CONNECTION_FACTORY__FACTORY_NAME = eINSTANCE.getJMSTopicConnectionFactory_FactoryName();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME = eINSTANCE.getJMSTopicConnectionFactory_JndiName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryUnitImpl <em>JMS Topic Connection Factory Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicConnectionFactoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicConnectionFactoryUnit()
		 * @generated
		 */
		EClass JMS_TOPIC_CONNECTION_FACTORY_UNIT = eINSTANCE.getJMSTopicConnectionFactoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationImpl <em>JMS Topic Destination</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicDestination()
		 * @generated
		 */
		EClass JMS_TOPIC_DESTINATION = eINSTANCE.getJMSTopicDestination();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationUnitImpl <em>JMS Topic Destination Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getJMSTopicDestinationUnit()
		 * @generated
		 */
		EClass JMS_TOPIC_DESTINATION_UNIT = eINSTANCE.getJMSTopicDestinationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum <em>Acknowledge Mode Enum</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getAcknowledgeModeEnum()
		 * @generated
		 */
		EEnum ACKNOWLEDGE_MODE_ENUM = eINSTANCE.getAcknowledgeModeEnum();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum <em>Destination Type Enum</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getDestinationTypeEnum()
		 * @generated
		 */
		EEnum DESTINATION_TYPE_ENUM = eINSTANCE.getDestinationTypeEnum();

		/**
		 * The meta object literal for the '<em>Acknowledge Mode Enum Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getAcknowledgeModeEnumObject()
		 * @generated
		 */
		EDataType ACKNOWLEDGE_MODE_ENUM_OBJECT = eINSTANCE.getAcknowledgeModeEnumObject();

		/**
		 * The meta object literal for the '<em>Destination Type Enum Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.DestinationTypeEnum
		 * @see com.ibm.ccl.soa.deploy.j2ee.jms.impl.JmsPackageImpl#getDestinationTypeEnumObject()
		 * @generated
		 */
		EDataType DESTINATION_TYPE_ENUM_OBJECT = eINSTANCE.getDestinationTypeEnumObject();

	}

} //JmsPackage
