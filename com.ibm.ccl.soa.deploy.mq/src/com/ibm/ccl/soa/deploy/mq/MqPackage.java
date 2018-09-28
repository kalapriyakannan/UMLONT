/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 		    The Topology Definition Model (TDM) defines a core set of concepts to describe
 * 		    Enterprise Architectures from the Software Applications down to the hardware 
 * 		    requirements. The model is inherently extensible, allowing technology specific
 * 		    domains to define their own types. At a high level, the model is orgainzed into
 * 		    {@link Topology topologies}, which contain {@link Unit}s. A Unit contain 
 * 		    {@link Capability capabilities}, {@Requirement requirements}, and four types 
 * 		    of links ({@link DependencyLink  dependency links}, {@link HostingLink  hosting links},
 * 		    {@link ConstraintLink  constraint links}, {@link MemberLink  member links}. In 
 * 		    addition, the model defines the notion of {@link Constraint constraints} which 
 * 		    can be added to Units or Contraint Links in order to describe requirements on 
 * 		    target application or environment. 
 * 		
 * 
 * 				An object that can be part of a deployable module.  See {@link FileArtifact}.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.mq.MqFactory
 * @model kind="package"
 * @generated
 */
public interface MqPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mq"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/Zephyr/mq/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mq"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MqPackage eINSTANCE = com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl <em>Messeage Listerner Service Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMesseageListernerServicePort()
	 * @generated
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>CFJNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Retries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Messeage Listerner Service Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSEAGE_LISTERNER_SERVICE_PORT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationImpl <em>MQ Activation Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQActivationSpecification()
	 * @generated
	 */
	int MQ_ACTIVATION_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Client Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mesasage Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specification Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Subscription Durable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Subscription Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>MQ Activation Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationUnitImpl <em>MQ Activation Specification Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQActivationSpecificationUnit()
	 * @generated
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Activation Specification Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ACTIVATION_SPECIFICATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl <em>MQ Base System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQBaseSystem()
	 * @generated
	 */
	int MQ_BASE_SYSTEM = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Initial Context Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__PROVIDER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provider URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__PROVIDER_URL = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provider Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM__PROVIDER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>MQ Base System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemUnitImpl <em>MQ Base System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQBaseSystemUnit()
	 * @generated
	 */
	int MQ_BASE_SYSTEM_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Base System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_BASE_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesImpl <em>MQ Connection Factories</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQConnectionFactories()
	 * @generated
	 */
	int MQ_CONNECTION_FACTORIES = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Broker CC Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_CC_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Broker Control Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_CONTROL_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Broker Message Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_MESSAGE_SELECTION = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Broker Publication Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_PUBLICATION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Broker Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Broker Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Broker Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__BROKER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CATEGORY = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>CCSID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CCSID = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CHANNEL = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CLIENT_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Component Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Container Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Direct Broker Authorization Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__DIRECT_BROKER_AUTHORIZATION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Enable Clone Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_CLONE_SUPPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Enable Message Retention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_MESSAGE_RETENTION = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Enable MQ Connection Pooling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_MQ_CONNECTION_POOLING = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Enable Multicast Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_MULTICAST_TRANSPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Enable Return Methods During Shutdown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_RETURN_METHODS_DURING_SHUTDOWN = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Enable Sparse Broker Subscriptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__ENABLE_SPARSE_BROKER_SUBSCRIPTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__HOST = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Local Server Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__LOCAL_SERVER_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Mapping Configuration Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__MAPPING_CONFIGURATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Model Queue Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__MODEL_QUEUE_DEFINITION = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Persistent Subscriptions Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PERSISTENT_SUBSCRIPTIONS_STORE = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Polling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__POLLING_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Proxy Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PROXY_HOST_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Proxy Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PROXY_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Publish And Acknowledgement Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PUBLISH_AND_ACKNOWLEDGEMENT_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Cleanup Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Cleanup Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Status Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Rescan Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__RESCAN_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>SSL Cipher Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__SSL_CIPHER_SUITE = CorePackage.CAPABILITY_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>SSLCRL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__SSLCRL = CorePackage.CAPABILITY_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>SSL Peer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__SSL_PEER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Temporary Queue Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__TEMPORARY_QUEUE_PREFIX = CorePackage.CAPABILITY_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Transport Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__TRANSPORT_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>XA Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES__XA_ENABLED = CorePackage.CAPABILITY_FEATURE_COUNT + 42;

	/**
	 * The number of structural features of the '<em>MQ Connection Factories</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 43;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesUnitImpl <em>MQ Connection Factories Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQConnectionFactoriesUnit()
	 * @generated
	 */
	int MQ_CONNECTION_FACTORIES_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Connection Factories Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_CONNECTION_FACTORIES_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl <em>MQ Destination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQDestination()
	 * @generated
	 */
	int MQ_DESTINATION = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Base Queue Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__BASE_QUEUE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__CATEGORY = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>CCSID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__CCSID = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Decimal Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__DECIMAL_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__DESTINATION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__EXPIRY = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Floating Point Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__FLOATING_POINT_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Integer Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__INTEGER_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Persitence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__PERSITENCE = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Queue Manager Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__QUEUE_MANAGER_HOST = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Queue Manager Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__QUEUE_MANAGER_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Server Connection Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Specified Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__SPECIFIED_EXPIRY = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Specified Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__SPECIFIED_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Target Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__TARGET_CLIENT = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Use Native Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__USE_NATIVE_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION__USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>MQ Destination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_DESTINATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQListenerImpl <em>MQ Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQListenerImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQListener()
	 * @generated
	 */
	int MQ_LISTENER = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MQ Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQListenerUnitImpl <em>MQ Listener Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQListenerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQListenerUnit()
	 * @generated
	 */
	int MQ_LISTENER_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Listener Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_LISTENER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessageListnerServicePortUnitImpl <em>MQ Message Listner Service Port Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessageListnerServicePortUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessageListnerServicePortUnit()
	 * @generated
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Message Listner Service Port Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl <em>MQ Messaging Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessagingProvider()
	 * @generated
	 */
	int MQ_MESSAGING_PROVIDER = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__CLASS_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Native Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER__NATIVE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>MQ Messaging Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderUnitImpl <em>MQ Messaging Provider Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessagingProviderUnit()
	 * @generated
	 */
	int MQ_MESSAGING_PROVIDER_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Messaging Provider Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_MESSAGING_PROVIDER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl <em>MQ Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueue()
	 * @generated
	 */
	int MQ_QUEUE = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Backout Requeue Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__BACKOUT_REQUEUE_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Backout Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__BACKOUT_THRESHOLD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__BASE_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__BASE_QUEUE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>CLWL Queue Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__CLWL_QUEUE_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>CLWL Queue Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__CLWL_QUEUE_RANK = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>CLWLU Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__CLWLU_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Coupling Facility Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__COUPLING_FACILITY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Default Bind Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DEFAULT_BIND_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Default Input Open Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Default Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DEFAULT_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Definition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DEFINITION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Distribution List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DISTRIBUTION_LIST = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Distribution Lists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__DISTRIBUTION_LISTS = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Get Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__GET_MESSAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Harden Get Backout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__HARDEN_GET_BACKOUT = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Initiation Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__INITIATION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Max Message Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__MAX_MESSAGE_LENGTH = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Max Queue Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__MAX_QUEUE_DEPTH = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Message Delivery Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Not Shared In Cluster</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__NOT_SHARED_IN_CLUSTER = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>NPM Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__NPM_CLASS = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__PERSISTENCE = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Process Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__PROCESS_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Put Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__PUT_MESSAGE = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Put Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__PUT_MESSAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>QSG Disposition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QSG_DISPOSITION = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Queue Accounting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_ACCOUNTING = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Queue Depth High Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Queue Depth High Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Queue Depth Low Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Queue Depth Low Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT = CorePackage.CAPABILITY_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Queue Depth Max Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Queue Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Queue Service Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_SERVICE_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Queue Service Interval Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Queue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__QUEUE_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Remote Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__REMOTE_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Remote Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__REMOTE_QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Retention Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__RETENTION_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__SCOPE = CorePackage.CAPABILITY_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>Shareability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__SHAREABILITY = CorePackage.CAPABILITY_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Shared In AList Of Clusters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS = CorePackage.CAPABILITY_FEATURE_COUNT + 44;

	/**
	 * The feature id for the '<em><b>Shared In Cluster</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__SHARED_IN_CLUSTER = CorePackage.CAPABILITY_FEATURE_COUNT + 45;

	/**
	 * The feature id for the '<em><b>Stat Alteration Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_ALTERATION_DATE = CorePackage.CAPABILITY_FEATURE_COUNT + 46;

	/**
	 * The feature id for the '<em><b>Stat Alteration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_ALTERATION_TIME = CorePackage.CAPABILITY_FEATURE_COUNT + 47;

	/**
	 * The feature id for the '<em><b>Stat Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_CREATION_DATE = CorePackage.CAPABILITY_FEATURE_COUNT + 48;

	/**
	 * The feature id for the '<em><b>Stat Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_CREATION_TIME = CorePackage.CAPABILITY_FEATURE_COUNT + 49;

	/**
	 * The feature id for the '<em><b>Stat Current Queue Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH = CorePackage.CAPABILITY_FEATURE_COUNT + 50;

	/**
	 * The feature id for the '<em><b>Stat Open Input Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_OPEN_INPUT_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 51;

	/**
	 * The feature id for the '<em><b>Stat Open Output Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 52;

	/**
	 * The feature id for the '<em><b>Stat Queue Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_QUEUE_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 53;

	/**
	 * The feature id for the '<em><b>Stat Queue Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STAT_QUEUE_STATISTICS = CorePackage.CAPABILITY_FEATURE_COUNT + 54;

	/**
	 * The feature id for the '<em><b>Storage Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__STORAGE_CLASS_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 55;

	/**
	 * The feature id for the '<em><b>Transmission Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRANSMISSION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 56;

	/**
	 * The feature id for the '<em><b>Trigger Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRIGGER_CONTROL = CorePackage.CAPABILITY_FEATURE_COUNT + 57;

	/**
	 * The feature id for the '<em><b>Trigger Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRIGGER_DATA = CorePackage.CAPABILITY_FEATURE_COUNT + 58;

	/**
	 * The feature id for the '<em><b>Trigger Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRIGGER_DEPTH = CorePackage.CAPABILITY_FEATURE_COUNT + 59;

	/**
	 * The feature id for the '<em><b>Trigger Message Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 60;

	/**
	 * The feature id for the '<em><b>Trigger Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__TRIGGER_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 61;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__USAGE = CorePackage.CAPABILITY_FEATURE_COUNT + 62;

	/**
	 * The feature id for the '<em><b>Usage1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE__USAGE1 = CorePackage.CAPABILITY_FEATURE_COUNT + 63;

	/**
	 * The number of structural features of the '<em>MQ Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 64;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelImpl <em>MQ Queue Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueChannel()
	 * @generated
	 */
	int MQ_QUEUE_CHANNEL = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL__CHANNEL_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MQ Queue Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelUnitImpl <em>MQ Queue Channel Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueChannelUnit()
	 * @generated
	 */
	int MQ_QUEUE_CHANNEL_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Queue Channel Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CHANNEL_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl <em>MQ Queue Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueConnectionFactory()
	 * @generated
	 */
	int MQ_QUEUE_CONNECTION_FACTORY = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CATEGORY = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>CCSID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CCSID = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CHANNEL = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Component Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Container Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Enable Connection Poling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Enable Message Retention</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Enable Return Method During Shutdown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__HOST = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Local Server Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Mappingconfiguration Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Max Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Max Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Min Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Min Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Model Queue Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Polling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Queuemanager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Rescan Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>SSL Cipher Suit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>SSLCRL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__SSLCRL = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>SSL Peer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Temporary Queue Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Transport Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>XA Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The number of structural features of the '<em>MQ Queue Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryUnitImpl <em>MQ Queue Connection Factory Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueConnectionFactoryUnit()
	 * @generated
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Queue Connection Factory Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_CONNECTION_FACTORY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationImpl <em>MQ Queue Destination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueDestination()
	 * @generated
	 */
	int MQ_QUEUE_DESTINATION = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__ANNOTATIONS = MQ_DESTINATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__ATTRIBUTE_META_DATA = MQ_DESTINATION__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__EXTENDED_ATTRIBUTES = MQ_DESTINATION__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__ARTIFACT_GROUP = MQ_DESTINATION__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__ARTIFACTS = MQ_DESTINATION__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__CONSTRAINT_GROUP = MQ_DESTINATION__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__CONSTRAINTS = MQ_DESTINATION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__DESCRIPTION = MQ_DESTINATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__DISPLAY_NAME = MQ_DESTINATION__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__MUTABLE = MQ_DESTINATION__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__NAME = MQ_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__STEREOTYPES = MQ_DESTINATION__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__BUILD_VERSION = MQ_DESTINATION__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__LINK_TYPE = MQ_DESTINATION__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__ORIGIN = MQ_DESTINATION__ORIGIN;

	/**
	 * The feature id for the '<em><b>Base Queue Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__BASE_QUEUE_MANAGER_NAME = MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME;

	/**
	 * The feature id for the '<em><b>Base Queue Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__BASE_QUEUE_NAME = MQ_DESTINATION__BASE_QUEUE_NAME;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__CATEGORY = MQ_DESTINATION__CATEGORY;

	/**
	 * The feature id for the '<em><b>CCSID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__CCSID = MQ_DESTINATION__CCSID;

	/**
	 * The feature id for the '<em><b>Decimal Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__DECIMAL_ENCODING = MQ_DESTINATION__DECIMAL_ENCODING;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__DESCRIPTION1 = MQ_DESTINATION__DESCRIPTION1;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__DESTINATION_NAME = MQ_DESTINATION__DESTINATION_NAME;

	/**
	 * The feature id for the '<em><b>Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__EXPIRY = MQ_DESTINATION__EXPIRY;

	/**
	 * The feature id for the '<em><b>Floating Point Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__FLOATING_POINT_ENCODING = MQ_DESTINATION__FLOATING_POINT_ENCODING;

	/**
	 * The feature id for the '<em><b>Integer Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__INTEGER_ENCODING = MQ_DESTINATION__INTEGER_ENCODING;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__JNDI_NAME = MQ_DESTINATION__JNDI_NAME;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__PASSWORD = MQ_DESTINATION__PASSWORD;

	/**
	 * The feature id for the '<em><b>Persitence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__PERSITENCE = MQ_DESTINATION__PERSITENCE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__PRIORITY = MQ_DESTINATION__PRIORITY;

	/**
	 * The feature id for the '<em><b>Queue Manager Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__QUEUE_MANAGER_HOST = MQ_DESTINATION__QUEUE_MANAGER_HOST;

	/**
	 * The feature id for the '<em><b>Queue Manager Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__QUEUE_MANAGER_PORT = MQ_DESTINATION__QUEUE_MANAGER_PORT;

	/**
	 * The feature id for the '<em><b>Server Connection Channel Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME = MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME;

	/**
	 * The feature id for the '<em><b>Specified Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__SPECIFIED_EXPIRY = MQ_DESTINATION__SPECIFIED_EXPIRY;

	/**
	 * The feature id for the '<em><b>Specified Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__SPECIFIED_PRIORITY = MQ_DESTINATION__SPECIFIED_PRIORITY;

	/**
	 * The feature id for the '<em><b>Target Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__TARGET_CLIENT = MQ_DESTINATION__TARGET_CLIENT;

	/**
	 * The feature id for the '<em><b>Use Native Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__USE_NATIVE_ENCODING = MQ_DESTINATION__USE_NATIVE_ENCODING;

	/**
	 * The feature id for the '<em><b>User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION__USER_ID = MQ_DESTINATION__USER_ID;

	/**
	 * The number of structural features of the '<em>MQ Queue Destination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_FEATURE_COUNT = MQ_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationUnitImpl <em>MQ Queue Destination Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueDestinationUnit()
	 * @generated
	 */
	int MQ_QUEUE_DESTINATION_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Queue Destination Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_DESTINATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl <em>MQ Queue Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueManager()
	 * @generated
	 */
	int MQ_QUEUE_MANAGER = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Accounting Connection Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Accounting Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Activity Recording</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ACTIVITY_RECORDING = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Adopt New MCA</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ADOPT_NEW_MCA = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Adopt New MCA Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Adopt New MCA Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Authority Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__AUTHORITY_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Automatic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__AUTOMATIC = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Bridge Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BRIDGE_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Broker Message Retry Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Broker Open Cache Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Broker Open Cache Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Broker Public Batch Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Broker Publish Batch Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Broker Streams Per Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Channel Auto Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Channel Auto Definition Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Channel Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Channel Initiator Adapters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Channel Initiator Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Channel Initiator Dispatchers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Channel Initiator Trace Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Channel Initiator Trace Table Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Channel Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Channel Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHANNEL_STATISTICS = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Checkpoint Active Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Checkpoint Message Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Checkpoint Restart Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Cluster Sender Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Cluster Sender Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Cluster Work Load Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Cluster Work Load Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT = CorePackage.CAPABILITY_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Cluster Work Load Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH = CorePackage.CAPABILITY_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Cluster Workload Use Q</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q = CorePackage.CAPABILITY_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Coded Char Set Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Command Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__COMMAND_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Command Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__COMMAND_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Command Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__COMMAND_SCOPE = CorePackage.CAPABILITY_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Command Server Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL = CorePackage.CAPABILITY_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Configuration Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CONFIGURATION_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Confirm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__CONFIRM = CorePackage.CAPABILITY_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Dead Letter Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Default Bind Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>Default Transmission Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 44;

	/**
	 * The feature id for the '<em><b>DNS Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DNS_GROUP = CorePackage.CAPABILITY_FEATURE_COUNT + 45;

	/**
	 * The feature id for the '<em><b>DNSWLM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__DNSWLM = CorePackage.CAPABILITY_FEATURE_COUNT + 46;

	/**
	 * The feature id for the '<em><b>Error Log Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ERROR_LOG_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 47;

	/**
	 * The feature id for the '<em><b>Excluded Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 48;

	/**
	 * The feature id for the '<em><b>Exits Default Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 49;

	/**
	 * The feature id for the '<em><b>Expiry Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__EXPIRY_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 50;

	/**
	 * The feature id for the '<em><b>IGQ Put Authority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 51;

	/**
	 * The feature id for the '<em><b>IGQ User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__IGQ_USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 52;

	/**
	 * The feature id for the '<em><b>Inhibit Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__INHIBIT_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 53;

	/**
	 * The feature id for the '<em><b>Installable Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 54;

	/**
	 * The feature id for the '<em><b>Intra Group Queuing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING = CorePackage.CAPABILITY_FEATURE_COUNT + 55;

	/**
	 * The feature id for the '<em><b>IP Address Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 56;

	/**
	 * The feature id for the '<em><b>Listener Timer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LISTENER_TIMER = CorePackage.CAPABILITY_FEATURE_COUNT + 57;

	/**
	 * The feature id for the '<em><b>Local Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOCAL_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 58;

	/**
	 * The feature id for the '<em><b>Log Buffer Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 59;

	/**
	 * The feature id for the '<em><b>Log File Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_FILE_PAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 60;

	/**
	 * The feature id for the '<em><b>Log Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 61;

	/**
	 * The feature id for the '<em><b>Log Primary Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES = CorePackage.CAPABILITY_FEATURE_COUNT + 62;

	/**
	 * The feature id for the '<em><b>Log Secondary Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES = CorePackage.CAPABILITY_FEATURE_COUNT + 63;

	/**
	 * The feature id for the '<em><b>Log Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 64;

	/**
	 * The feature id for the '<em><b>Log Write Integrity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY = CorePackage.CAPABILITY_FEATURE_COUNT + 65;

	/**
	 * The feature id for the '<em><b>LU62ARM Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU62ARM_SUFFIX = CorePackage.CAPABILITY_FEATURE_COUNT + 66;

	/**
	 * The feature id for the '<em><b>LU62 Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU62_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 67;

	/**
	 * The feature id for the '<em><b>LU Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU_GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 68;

	/**
	 * The feature id for the '<em><b>LU Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU_LIBRARY1 = CorePackage.CAPABILITY_FEATURE_COUNT + 69;

	/**
	 * The feature id for the '<em><b>LU Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU_LIBRARY2 = CorePackage.CAPABILITY_FEATURE_COUNT + 70;

	/**
	 * The feature id for the '<em><b>LU Local LU</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU_LOCAL_LU = CorePackage.CAPABILITY_FEATURE_COUNT + 71;

	/**
	 * The feature id for the '<em><b>LU Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LU_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 72;

	/**
	 * The feature id for the '<em><b>LUTP Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__LUTP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 73;

	/**
	 * The feature id for the '<em><b>Max Active Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 74;

	/**
	 * The feature id for the '<em><b>Max Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAX_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 75;

	/**
	 * The feature id for the '<em><b>Maximum Current Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 76;

	/**
	 * The feature id for the '<em><b>Maximum Handles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAXIMUM_HANDLES = CorePackage.CAPABILITY_FEATURE_COUNT + 77;

	/**
	 * The feature id for the '<em><b>Maximum Message Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH = CorePackage.CAPABILITY_FEATURE_COUNT + 78;

	/**
	 * The feature id for the '<em><b>Maximum TCP Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 79;

	/**
	 * The feature id for the '<em><b>Maximum Uncommitted Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 80;

	/**
	 * The feature id for the '<em><b>Max Initiators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MAX_INITIATORS = CorePackage.CAPABILITY_FEATURE_COUNT + 81;

	/**
	 * The feature id for the '<em><b>MQI Accounting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MQI_ACCOUNTING = CorePackage.CAPABILITY_FEATURE_COUNT + 82;

	/**
	 * The feature id for the '<em><b>MQI Bind Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MQI_BIND_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 83;

	/**
	 * The feature id for the '<em><b>MQI Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__MQI_STATISTICS = CorePackage.CAPABILITY_FEATURE_COUNT + 84;

	/**
	 * The feature id for the '<em><b>Net Bios Adaptor Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER = CorePackage.CAPABILITY_FEATURE_COUNT + 85;

	/**
	 * The feature id for the '<em><b>Net Bios Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1 = CorePackage.CAPABILITY_FEATURE_COUNT + 86;

	/**
	 * The feature id for the '<em><b>Net Bios Local Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 87;

	/**
	 * The feature id for the '<em><b>Net Bios Number Of Commands</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS = CorePackage.CAPABILITY_FEATURE_COUNT + 88;

	/**
	 * The feature id for the '<em><b>Net Bios Number Of Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES = CorePackage.CAPABILITY_FEATURE_COUNT + 89;

	/**
	 * The feature id for the '<em><b>Net Bios Number Of Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 90;

	/**
	 * The feature id for the '<em><b>Outbound Port Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX = CorePackage.CAPABILITY_FEATURE_COUNT + 91;

	/**
	 * The feature id for the '<em><b>Outbound Port Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN = CorePackage.CAPABILITY_FEATURE_COUNT + 92;

	/**
	 * The feature id for the '<em><b>Performance Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__PERFORMANCE_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 93;

	/**
	 * The feature id for the '<em><b>Pipe Line Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH = CorePackage.CAPABILITY_FEATURE_COUNT + 94;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__PLATFORM = CorePackage.CAPABILITY_FEATURE_COUNT + 95;

	/**
	 * The feature id for the '<em><b>Queue Accounting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING = CorePackage.CAPABILITY_FEATURE_COUNT + 96;

	/**
	 * The feature id for the '<em><b>Queue Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 97;

	/**
	 * The feature id for the '<em><b>Queue Manager Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS = CorePackage.CAPABILITY_FEATURE_COUNT + 98;

	/**
	 * The feature id for the '<em><b>Queue Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__QUEUE_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 99;

	/**
	 * The feature id for the '<em><b>Queue Statistics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__QUEUE_STATISTICS = CorePackage.CAPABILITY_FEATURE_COUNT + 100;

	/**
	 * The feature id for the '<em><b>Receive Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT = CorePackage.CAPABILITY_FEATURE_COUNT + 101;

	/**
	 * The feature id for the '<em><b>Receive Timeout Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN = CorePackage.CAPABILITY_FEATURE_COUNT + 102;

	/**
	 * The feature id for the '<em><b>Receive Timeout Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 103;

	/**
	 * The feature id for the '<em><b>Remote Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__REMOTE_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 104;

	/**
	 * The feature id for the '<em><b>Repository Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__REPOSITORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 105;

	/**
	 * The feature id for the '<em><b>Repository Name List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST = CorePackage.CAPABILITY_FEATURE_COUNT + 106;

	/**
	 * The feature id for the '<em><b>Routing Exit Connect Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 107;

	/**
	 * The feature id for the '<em><b>Routing Exit Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 108;

	/**
	 * The feature id for the '<em><b>Security Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SECURITY_POLICY = CorePackage.CAPABILITY_FEATURE_COUNT + 109;

	/**
	 * The feature id for the '<em><b>Service Entry Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS = CorePackage.CAPABILITY_FEATURE_COUNT + 110;

	/**
	 * The feature id for the '<em><b>Shared QQmgr Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 111;

	/**
	 * The feature id for the '<em><b>SPX Board Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER = CorePackage.CAPABILITY_FEATURE_COUNT + 112;

	/**
	 * The feature id for the '<em><b>SPX Keep Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE = CorePackage.CAPABILITY_FEATURE_COUNT + 113;

	/**
	 * The feature id for the '<em><b>SPX Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SPX_LIBRARY1 = CorePackage.CAPABILITY_FEATURE_COUNT + 114;

	/**
	 * The feature id for the '<em><b>SPX Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SPX_LIBRARY2 = CorePackage.CAPABILITY_FEATURE_COUNT + 115;

	/**
	 * The feature id for the '<em><b>SPX Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SPX_SOCKET = CorePackage.CAPABILITY_FEATURE_COUNT + 116;

	/**
	 * The feature id for the '<em><b>SSLCRL Name List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST = CorePackage.CAPABILITY_FEATURE_COUNT + 117;

	/**
	 * The feature id for the '<em><b>SSL Cryto Hardware</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE = CorePackage.CAPABILITY_FEATURE_COUNT + 118;

	/**
	 * The feature id for the '<em><b>SSL Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 119;

	/**
	 * The feature id for the '<em><b>SSL Fips</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_FIPS = CorePackage.CAPABILITY_FEATURE_COUNT + 120;

	/**
	 * The feature id for the '<em><b>SSL Key Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY = CorePackage.CAPABILITY_FEATURE_COUNT + 121;

	/**
	 * The feature id for the '<em><b>SSL Key Reset Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 122;

	/**
	 * The feature id for the '<em><b>SSL Tasks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SSL_TASKS = CorePackage.CAPABILITY_FEATURE_COUNT + 123;

	/**
	 * The feature id for the '<em><b>Start Stop Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__START_STOP_EVENT = CorePackage.CAPABILITY_FEATURE_COUNT + 124;

	/**
	 * The feature id for the '<em><b>Statistics Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__STATISTICS_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 125;

	/**
	 * The feature id for the '<em><b>Suppresed Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES = CorePackage.CAPABILITY_FEATURE_COUNT + 126;

	/**
	 * The feature id for the '<em><b>Suppressed Message Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 127;

	/**
	 * The feature id for the '<em><b>TCP Keep Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE = CorePackage.CAPABILITY_FEATURE_COUNT + 128;

	/**
	 * The feature id for the '<em><b>TCP Library1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_LIBRARY1 = CorePackage.CAPABILITY_FEATURE_COUNT + 129;

	/**
	 * The feature id for the '<em><b>TCP Library2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_LIBRARY2 = CorePackage.CAPABILITY_FEATURE_COUNT + 130;

	/**
	 * The feature id for the '<em><b>TCP Listener Backlog</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG = CorePackage.CAPABILITY_FEATURE_COUNT + 131;

	/**
	 * The feature id for the '<em><b>TCP Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 132;

	/**
	 * The feature id for the '<em><b>TCP Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 133;

	/**
	 * The feature id for the '<em><b>TCP Stack Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TCP_STACK_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 134;

	/**
	 * The feature id for the '<em><b>Trace Route Recording</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING = CorePackage.CAPABILITY_FEATURE_COUNT + 135;

	/**
	 * The feature id for the '<em><b>Trigger Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__TRIGGER_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 136;

	/**
	 * The feature id for the '<em><b>What If</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER__WHAT_IF = CorePackage.CAPABILITY_FEATURE_COUNT + 137;

	/**
	 * The number of structural features of the '<em>MQ Queue Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 138;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerUnitImpl <em>MQ Queue Manager Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueManagerUnit()
	 * @generated
	 */
	int MQ_QUEUE_MANAGER_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Queue Manager Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_MANAGER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueUnitImpl <em>MQ Queue Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueUnit()
	 * @generated
	 */
	int MQ_QUEUE_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Queue Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_QUEUE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl <em>MQ Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQRoot()
	 * @generated
	 */
	int MQ_ROOT = 23;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability MQ Activation Specification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Capability MQ Base System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM = 4;

	/**
	 * The feature id for the '<em><b>Capability MQ Connection Factories</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES = 5;

	/**
	 * The feature id for the '<em><b>Capability MQ Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_DESTINATION = 6;

	/**
	 * The feature id for the '<em><b>Capability MQ Listener</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_LISTENER = 7;

	/**
	 * The feature id for the '<em><b>Capability MQ Messaging Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER = 8;

	/**
	 * The feature id for the '<em><b>Capability MQ Messeage Listerner Service Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT = 9;

	/**
	 * The feature id for the '<em><b>Capability MQ Queue</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_QUEUE = 10;

	/**
	 * The feature id for the '<em><b>Capability MQ Queue Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL = 11;

	/**
	 * The feature id for the '<em><b>Capability MQ Queue Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY = 12;

	/**
	 * The feature id for the '<em><b>Capability MQ Queue Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION = 13;

	/**
	 * The feature id for the '<em><b>Capability MQ Queue Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER = 14;

	/**
	 * The feature id for the '<em><b>Capability MQ Topic Connection Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY = 15;

	/**
	 * The feature id for the '<em><b>Capability MQ Topic Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION = 16;

	/**
	 * The feature id for the '<em><b>Unit MQ Activation Specification Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Unit MQ Base System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Unit MQ Connection Factories Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Unit MQ Listener Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_LISTENER_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Unit MQ Message Listner Service Port Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Unit MQ Messaging Provider Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Unit MQ Queue Channel Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Unit MQ Queue Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT = 24;

	/**
	 * The feature id for the '<em><b>Unit MQ Queue Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Unit MQ Queue Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT = 26;

	/**
	 * The feature id for the '<em><b>Unit MQ Queue Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_QUEUE_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Unit MQ Topic Connection Factory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT = 28;

	/**
	 * The feature id for the '<em><b>Unit MQ Topic Destination Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT = 29;

	/**
	 * The number of structural features of the '<em>MQ Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_ROOT_FEATURE_COUNT = 30;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl <em>MQ Topic Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicConnectionFactory()
	 * @generated
	 */
	int MQ_TOPIC_CONNECTION_FACTORY = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Broker CC Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Broker Control Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Broker Message Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Broker Publication Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Broker Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Broker Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Broker Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CATEGORY = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>CCSID Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CHANNEL = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Component Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Container Managed Authentication Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Direct Broker Authorization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Enable Clone Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Enable MQ Connection Pooling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Enable Multicast Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Enable Return Methods During Shutdown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Factory Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__HOST = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Local Server Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Mapping Configuration Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Model Queue Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Persistent Subscription Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Polling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Proxy Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Proxy Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Publish And Acknowledge Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Cleanup Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Cleanup Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Publish And Subscribe Status Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Rescan Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>SSL Cipher Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE = CorePackage.CAPABILITY_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>SSLCRL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__SSLCRL = CorePackage.CAPABILITY_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>SSL Peer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Transport Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>XA Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED = CorePackage.CAPABILITY_FEATURE_COUNT + 40;

	/**
	 * The number of structural features of the '<em>MQ Topic Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 41;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryUnitImpl <em>MQ Topic Connection Factory Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicConnectionFactoryUnit()
	 * @generated
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Topic Connection Factory Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_CONNECTION_FACTORY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl <em>MQ Topic Destination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicDestination()
	 * @generated
	 */
	int MQ_TOPIC_DESTINATION = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Base Topic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Broker CC Durable Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Broker Durable Subscription Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__CATEGORY = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Decimal Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__DECIMAL_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__DESCRIPTION1 = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__DESTINATION_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Enable Multicast Transport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__EXPIRY = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Floating Point Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Integer Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__INTEGER_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Persitence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__PERSITENCE = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Specified Expiry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Specified Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Target Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__TARGET_CLIENT = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Use Native Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>MQ Topic Destination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationUnitImpl <em>MQ Topic Destination Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicDestinationUnit()
	 * @generated
	 */
	int MQ_TOPIC_DESTINATION_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>MQ Topic Destination Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MQ_TOPIC_DESTINATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort <em>Messeage Listerner Service Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Messeage Listerner Service Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort
	 * @generated
	 */
	EClass getMesseageListernerServicePort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getCFJNDIName <em>CFJNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CFJNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getCFJNDIName()
	 * @see #getMesseageListernerServicePort()
	 * @generated
	 */
	EAttribute getMesseageListernerServicePort_CFJNDIName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getDestinationJNDIName <em>Destination JNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination JNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getDestinationJNDIName()
	 * @see #getMesseageListernerServicePort()
	 * @generated
	 */
	EAttribute getMesseageListernerServicePort_DestinationJNDIName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxRetries <em>Max Retries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Retries</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxRetries()
	 * @see #getMesseageListernerServicePort()
	 * @generated
	 */
	EAttribute getMesseageListernerServicePort_MaxRetries();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxSessions <em>Max Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Sessions</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxSessions()
	 * @see #getMesseageListernerServicePort()
	 * @generated
	 */
	EAttribute getMesseageListernerServicePort_MaxSessions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getName1()
	 * @see #getMesseageListernerServicePort()
	 * @generated
	 */
	EAttribute getMesseageListernerServicePort_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification <em>MQ Activation Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Activation Specification</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification
	 * @generated
	 */
	EClass getMQActivationSpecification();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getClientIdentifier <em>Client Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getClientIdentifier()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_ClientIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getJndiName()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getMesasageSelector <em>Mesasage Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mesasage Selector</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getMesasageSelector()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_MesasageSelector();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSpecificationName <em>Specification Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSpecificationName()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_SpecificationName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable <em>Subscription Durable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subscription Durable</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#isSubscriptionDurable()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_SubscriptionDurable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSubscriptionName <em>Subscription Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subscription Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecification#getSubscriptionName()
	 * @see #getMQActivationSpecification()
	 * @generated
	 */
	EAttribute getMQActivationSpecification_SubscriptionName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQActivationSpecificationUnit <em>MQ Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Activation Specification Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQActivationSpecificationUnit
	 * @generated
	 */
	EClass getMQActivationSpecificationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem <em>MQ Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Base System</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem
	 * @generated
	 */
	EClass getMQBaseSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getInitialContextFactory <em>Initial Context Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Context Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getInitialContextFactory()
	 * @see #getMQBaseSystem()
	 * @generated
	 */
	EAttribute getMQBaseSystem_InitialContextFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderName()
	 * @see #getMQBaseSystem()
	 * @generated
	 */
	EAttribute getMQBaseSystem_ProviderName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderURL <em>Provider URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider URL</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderURL()
	 * @see #getMQBaseSystem()
	 * @generated
	 */
	EAttribute getMQBaseSystem_ProviderURL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderVersion <em>Provider Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystem#getProviderVersion()
	 * @see #getMQBaseSystem()
	 * @generated
	 */
	EAttribute getMQBaseSystem_ProviderVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQBaseSystemUnit <em>MQ Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Base System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQBaseSystemUnit
	 * @generated
	 */
	EClass getMQBaseSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories <em>MQ Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Connection Factories</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories
	 * @generated
	 */
	EClass getMQConnectionFactories();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerCCSubscriptionQueue <em>Broker CC Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker CC Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerCCSubscriptionQueue()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerCCSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerControlQueue <em>Broker Control Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Control Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerControlQueue()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerControlQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerMessageSelection <em>Broker Message Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Message Selection</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerMessageSelection()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerMessageSelection();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerPublicationQueue <em>Broker Publication Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Publication Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerPublicationQueue()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerPublicationQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerQueueManager <em>Broker Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerQueueManager()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerQueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerSubscriptionQueue <em>Broker Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerSubscriptionQueue()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerVersion <em>Broker Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getBrokerVersion()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_BrokerVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getCategory()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_Category();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getCCSID <em>CCSID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CCSID</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getCCSID()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_CCSID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getChannel()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_Channel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getClientId <em>Client Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getClientId()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ClientId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getComponentManagedAuthenticationAlias()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ComponentManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getContainerManagedAuthenticationAlias()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ContainerManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getDirectBrokerAuthorizationType <em>Direct Broker Authorization Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Broker Authorization Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getDirectBrokerAuthorizationType()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_DirectBrokerAuthorizationType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableCloneSupport <em>Enable Clone Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Clone Support</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableCloneSupport()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableCloneSupport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMessageRetention <em>Enable Message Retention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Message Retention</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMessageRetention()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableMessageRetention();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMQConnectionPooling <em>Enable MQ Connection Pooling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable MQ Connection Pooling</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMQConnectionPooling()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableMQConnectionPooling();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMulticastTransport <em>Enable Multicast Transport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Multicast Transport</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableMulticastTransport()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableMulticastTransport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableReturnMethodsDuringShutdown <em>Enable Return Methods During Shutdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Return Methods During Shutdown</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableReturnMethodsDuringShutdown()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableReturnMethodsDuringShutdown();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableSparseBrokerSubscriptions <em>Enable Sparse Broker Subscriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Sparse Broker Subscriptions</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getEnableSparseBrokerSubscriptions()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_EnableSparseBrokerSubscriptions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getHost()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_Host();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getJndiName()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getLocalServerAddress <em>Local Server Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Server Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getLocalServerAddress()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_LocalServerAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getMappingConfigurationAlias <em>Mapping Configuration Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Configuration Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getMappingConfigurationAlias()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_MappingConfigurationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getModelQueueDefinition <em>Model Queue Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Queue Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getModelQueueDefinition()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ModelQueueDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getName1()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPersistentSubscriptionsStore <em>Persistent Subscriptions Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Subscriptions Store</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPersistentSubscriptionsStore()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PersistentSubscriptionsStore();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPollingInterval <em>Polling Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polling Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPollingInterval()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PollingInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPort()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getProxyHostName <em>Proxy Host Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Host Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getProxyHostName()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ProxyHostName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getProxyPort <em>Proxy Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getProxyPort()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_ProxyPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndAcknowledgementInterval <em>Publish And Acknowledgement Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Acknowledgement Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndAcknowledgementInterval()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PublishAndAcknowledgementInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeCleanupInterval <em>Publish And Subscribe Cleanup Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Cleanup Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeCleanupInterval()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PublishAndSubscribeCleanupInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeCleanupLevel <em>Publish And Subscribe Cleanup Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Cleanup Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeCleanupLevel()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PublishAndSubscribeCleanupLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeStatusInterval <em>Publish And Subscribe Status Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Status Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getPublishAndSubscribeStatusInterval()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_PublishAndSubscribeStatusInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getQueueManager <em>Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getQueueManager()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_QueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getRescanInterval <em>Rescan Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rescan Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getRescanInterval()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_RescanInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLCipherSuite <em>SSL Cipher Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Cipher Suite</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLCipherSuite()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_SSLCipherSuite();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLCRL <em>SSLCRL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSLCRL</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLCRL()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_SSLCRL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLPeerName <em>SSL Peer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Peer Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getSSLPeerName()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_SSLPeerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getTemporaryQueuePrefix <em>Temporary Queue Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temporary Queue Prefix</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getTemporaryQueuePrefix()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_TemporaryQueuePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getTransportType <em>Transport Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transport Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getTransportType()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_TransportType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getXAEnabled <em>XA Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XA Enabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactories#getXAEnabled()
	 * @see #getMQConnectionFactories()
	 * @generated
	 */
	EAttribute getMQConnectionFactories_XAEnabled();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQConnectionFactoriesUnit <em>MQ Connection Factories Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Connection Factories Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQConnectionFactoriesUnit
	 * @generated
	 */
	EClass getMQConnectionFactoriesUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQDestination <em>MQ Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination
	 * @generated
	 */
	EClass getMQDestination();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueManagerName <em>Base Queue Manager Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Queue Manager Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueManagerName()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_BaseQueueManagerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueName <em>Base Queue Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Queue Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getBaseQueueName()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_BaseQueueName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getCategory()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Category();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getCCSID <em>CCSID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CCSID</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getCCSID()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_CCSID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDecimalEncoding <em>Decimal Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decimal Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getDecimalEncoding()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_DecimalEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getDescription1()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getDestinationName <em>Destination Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getDestinationName()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_DestinationName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getExpiry <em>Expiry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiry</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getExpiry()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Expiry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Floating Point Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getFloatingPointEncoding()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_FloatingPointEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getIntegerEncoding <em>Integer Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getIntegerEncoding()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_IntegerEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getJndiName()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getPassword()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPersitence <em>Persitence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persitence</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getPersitence()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Persitence();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getPriority()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerHost <em>Queue Manager Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager Host</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerHost()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_QueueManagerHost();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerPort <em>Queue Manager Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getQueueManagerPort()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_QueueManagerPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getServerConnectionChannelName <em>Server Connection Channel Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Connection Channel Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getServerConnectionChannelName()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_ServerConnectionChannelName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedExpiry <em>Specified Expiry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specified Expiry</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedExpiry()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_SpecifiedExpiry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedPriority <em>Specified Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specified Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getSpecifiedPriority()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_SpecifiedPriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getTargetClient <em>Target Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getTargetClient()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_TargetClient();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUseNativeEncoding <em>Use Native Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Native Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getUseNativeEncoding()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_UseNativeEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQDestination#getUserID <em>User ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User ID</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQDestination#getUserID()
	 * @see #getMQDestination()
	 * @generated
	 */
	EAttribute getMQDestination_UserID();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQListener <em>MQ Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Listener</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQListener
	 * @generated
	 */
	EClass getMQListener();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQListener#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQListener#getPort()
	 * @see #getMQListener()
	 * @generated
	 */
	EAttribute getMQListener_Port();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQListenerUnit <em>MQ Listener Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Listener Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQListenerUnit
	 * @generated
	 */
	EClass getMQListenerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit <em>MQ Message Listner Service Port Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Message Listner Service Port Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessageListnerServicePortUnit
	 * @generated
	 */
	EClass getMQMessageListnerServicePortUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider <em>MQ Messaging Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Messaging Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider
	 * @generated
	 */
	EClass getMQMessagingProvider();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getClassPath <em>Class Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getClassPath()
	 * @see #getMQMessagingProvider()
	 * @generated
	 */
	EAttribute getMQMessagingProvider_ClassPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getDescription1()
	 * @see #getMQMessagingProvider()
	 * @generated
	 */
	EAttribute getMQMessagingProvider_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getName1()
	 * @see #getMQMessagingProvider()
	 * @generated
	 */
	EAttribute getMQMessagingProvider_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getNativePath <em>Native Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProvider#getNativePath()
	 * @see #getMQMessagingProvider()
	 * @generated
	 */
	EAttribute getMQMessagingProvider_NativePath();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQMessagingProviderUnit <em>MQ Messaging Provider Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Messaging Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQMessagingProviderUnit
	 * @generated
	 */
	EClass getMQMessagingProviderUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueue <em>MQ Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue
	 * @generated
	 */
	EClass getMQQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutRequeueQueue <em>Backout Requeue Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backout Requeue Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutRequeueQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_BackoutRequeueQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutThreshold <em>Backout Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backout Threshold</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getBackoutThreshold()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_BackoutThreshold();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueue <em>Base Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_BaseQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueueName <em>Base Queue Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Queue Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getBaseQueueName()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_BaseQueueName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueuePriority <em>CLWL Queue Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CLWL Queue Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueuePriority()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_CLWLQueuePriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueueRank <em>CLWL Queue Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CLWL Queue Rank</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLQueueRank()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_CLWLQueueRank();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLUQueue <em>CLWLU Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CLWLU Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getCLWLUQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_CLWLUQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getCouplingFacilityName <em>Coupling Facility Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coupling Facility Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getCouplingFacilityName()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_CouplingFacilityName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultBindType <em>Default Bind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Bind Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultBindType()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DefaultBindType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultInputOpenOption <em>Default Input Open Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Input Open Option</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultInputOpenOption()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DefaultInputOpenOption();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultPriority <em>Default Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDefaultPriority()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DefaultPriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDefinitionType <em>Definition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDefinitionType()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DefinitionType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDescription1()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionList <em>Distribution List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distribution List</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionList()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DistributionList();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionLists <em>Distribution Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distribution Lists</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getDistributionLists()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_DistributionLists();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getGetMessages <em>Get Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Get Messages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getGetMessages()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_GetMessages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getHardenGetBackout <em>Harden Get Backout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Harden Get Backout</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getHardenGetBackout()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_HardenGetBackout();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getInitiationQueue <em>Initiation Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initiation Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getInitiationQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_InitiationQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxMessageLength <em>Max Message Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Message Length</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxMessageLength()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_MaxMessageLength();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxQueueDepth <em>Max Queue Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Queue Depth</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getMaxQueueDepth()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_MaxQueueDepth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getMessageDeliverySequence <em>Message Delivery Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Delivery Sequence</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getMessageDeliverySequence()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_MessageDeliverySequence();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNotSharedInCluster <em>Not Shared In Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Shared In Cluster</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getNotSharedInCluster()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_NotSharedInCluster();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getNPMClass <em>NPM Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NPM Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getNPMClass()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_NPMClass();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPersistence <em>Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistence</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getPersistence()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Persistence();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getProcessName <em>Process Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getProcessName()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_ProcessName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessage <em>Put Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Put Message</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessage()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_PutMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessages <em>Put Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Put Messages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getPutMessages()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_PutMessages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQSGDisposition <em>QSG Disposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>QSG Disposition</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQSGDisposition()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QSGDisposition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueAccounting <em>Queue Accounting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Accounting</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueAccounting()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueAccounting();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighEvents <em>Queue Depth High Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Depth High Events</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighEvents()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueDepthHighEvents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighLimit <em>Queue Depth High Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Depth High Limit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthHighLimit()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueDepthHighLimit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowEvents <em>Queue Depth Low Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Depth Low Events</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowEvents()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueDepthLowEvents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowLimit <em>Queue Depth Low Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Depth Low Limit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthLowLimit()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueDepthLowLimit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthMaxEvents <em>Queue Depth Max Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Depth Max Events</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueDepthMaxEvents()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueDepthMaxEvents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueMonitoring <em>Queue Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueMonitoring()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueName <em>Queue Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueName()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceInterval <em>Queue Service Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Service Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceInterval()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueServiceInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceIntervalEvents <em>Queue Service Interval Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Service Interval Events</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueServiceIntervalEvents()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueServiceIntervalEvents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueType <em>Queue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getQueueType()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_QueueType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueue <em>Remote Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_RemoteQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueueManager <em>Remote Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getRemoteQueueManager()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_RemoteQueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getRetentionInterval <em>Retention Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retention Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getRetentionInterval()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_RetentionInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getScope()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Scope();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getShareability <em>Shareability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shareability</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getShareability()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Shareability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInAListOfClusters <em>Shared In AList Of Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared In AList Of Clusters</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInAListOfClusters()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_SharedInAListOfClusters();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInCluster <em>Shared In Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared In Cluster</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getSharedInCluster()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_SharedInCluster();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationDate <em>Stat Alteration Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Alteration Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationDate()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatAlterationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationTime <em>Stat Alteration Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Alteration Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatAlterationTime()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatAlterationTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationDate <em>Stat Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Creation Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationDate()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatCreationDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationTime <em>Stat Creation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Creation Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCreationTime()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatCreationTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCurrentQueueDepth <em>Stat Current Queue Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Current Queue Depth</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatCurrentQueueDepth()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatCurrentQueueDepth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenInputCount <em>Stat Open Input Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Open Input Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenInputCount()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatOpenInputCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenOutputCount <em>Stat Open Output Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Open Output Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatOpenOutputCount()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatOpenOutputCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueMonitoring <em>Stat Queue Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Queue Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueMonitoring()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatQueueMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueStatistics <em>Stat Queue Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stat Queue Statistics</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStatQueueStatistics()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StatQueueStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getStorageClassName <em>Storage Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Storage Class Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getStorageClassName()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_StorageClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTransmissionQueue <em>Transmission Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transmission Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTransmissionQueue()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TransmissionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerControl <em>Trigger Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Control</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerControl()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TriggerControl();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerData <em>Trigger Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Data</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerData()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TriggerData();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerDepth <em>Trigger Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Depth</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerDepth()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TriggerDepth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerMessagePriority <em>Trigger Message Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Message Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerMessagePriority()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TriggerMessagePriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerType <em>Trigger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getTriggerType()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_TriggerType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Usage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage1 <em>Usage1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueue#getUsage1()
	 * @see #getMQQueue()
	 * @generated
	 */
	EAttribute getMQQueue_Usage1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannel <em>MQ Queue Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Channel</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueChannel
	 * @generated
	 */
	EClass getMQQueueChannel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannel#getChannelName <em>Channel Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueChannel#getChannelName()
	 * @see #getMQQueueChannel()
	 * @generated
	 */
	EAttribute getMQQueueChannel_ChannelName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueChannelUnit <em>MQ Queue Channel Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Channel Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueChannelUnit
	 * @generated
	 */
	EClass getMQQueueChannelUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory <em>MQ Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory
	 * @generated
	 */
	EClass getMQQueueConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCategory()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Category();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCCSID <em>CCSID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CCSID</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getCCSID()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_CCSID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getChannel()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Channel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getClientId <em>Client Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getClientId()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_ClientId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getComponentManagedAuthenticationAlias()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getContainerManagedAuthenticationAlias()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getDescription1()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableConnectionPoling <em>Enable Connection Poling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Connection Poling</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableConnectionPoling()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_EnableConnectionPoling();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableMessageRetention <em>Enable Message Retention</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Message Retention</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableMessageRetention()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_EnableMessageRetention();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableReturnMethodDuringShutdown <em>Enable Return Method During Shutdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Return Method During Shutdown</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getEnableReturnMethodDuringShutdown()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getFactoryName <em>Factory Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getFactoryName()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_FactoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getHost()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Host();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getJndiName()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Server Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getLocalServerAddress()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_LocalServerAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMappingconfigurationAlias <em>Mappingconfiguration Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mappingconfiguration Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMappingconfigurationAlias()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_MappingconfigurationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxConnections <em>Max Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Connections</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxConnections()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_MaxConnections();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxSessions <em>Max Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Sessions</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMaxSessions()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_MaxSessions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinConnections <em>Min Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Connections</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinConnections()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_MinConnections();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinSessions <em>Min Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Sessions</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getMinSessions()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_MinSessions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Queue Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getModelQueueDefinition()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_ModelQueueDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPollingInterval <em>Polling Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polling Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPollingInterval()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_PollingInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getPort()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getQueuemanager <em>Queuemanager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queuemanager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getQueuemanager()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_Queuemanager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getRescanInterval <em>Rescan Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rescan Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getRescanInterval()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_RescanInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCipherSuit <em>SSL Cipher Suit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Cipher Suit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCipherSuit()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_SSLCipherSuit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCRL <em>SSLCRL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSLCRL</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLCRL()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_SSLCRL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Peer Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getSSLPeerName()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_SSLPeerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTemporaryQueuePrefix <em>Temporary Queue Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temporary Queue Prefix</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTemporaryQueuePrefix()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_TemporaryQueuePrefix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTransportType <em>Transport Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transport Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getTransportType()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_TransportType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getXAEnabled <em>XA Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XA Enabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactory#getXAEnabled()
	 * @see #getMQQueueConnectionFactory()
	 * @generated
	 */
	EAttribute getMQQueueConnectionFactory_XAEnabled();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit <em>MQ Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueConnectionFactoryUnit
	 * @generated
	 */
	EClass getMQQueueConnectionFactoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueDestination <em>MQ Queue Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueDestination
	 * @generated
	 */
	EClass getMQQueueDestination();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit <em>MQ Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueDestinationUnit
	 * @generated
	 */
	EClass getMQQueueDestinationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager <em>MQ Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager
	 * @generated
	 */
	EClass getMQQueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingConnectionOverride <em>Accounting Connection Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accounting Connection Override</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingConnectionOverride()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AccountingConnectionOverride();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingInterval <em>Accounting Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accounting Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAccountingInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AccountingInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getActivityRecording <em>Activity Recording</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activity Recording</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getActivityRecording()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ActivityRecording();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCA <em>Adopt New MCA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adopt New MCA</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCA()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AdoptNewMCA();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCACheck <em>Adopt New MCA Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adopt New MCA Check</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCACheck()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AdoptNewMCACheck();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCAType <em>Adopt New MCA Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adopt New MCA Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAdoptNewMCAType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AdoptNewMCAType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAuthorityEvent <em>Authority Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authority Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAuthorityEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_AuthorityEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAutomatic <em>Automatic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Automatic</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getAutomatic()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_Automatic();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBridgeEvent <em>Bridge Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bridge Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBridgeEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BridgeEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerMessageRetryCount <em>Broker Message Retry Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Message Retry Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerMessageRetryCount()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerMessageRetryCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheExpiry <em>Broker Open Cache Expiry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Open Cache Expiry</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheExpiry()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerOpenCacheExpiry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheSize <em>Broker Open Cache Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Open Cache Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerOpenCacheSize()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerOpenCacheSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublicBatchInterval <em>Broker Public Batch Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Public Batch Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublicBatchInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerPublicBatchInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublishBatchSize <em>Broker Publish Batch Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Publish Batch Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerPublishBatchSize()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerPublishBatchSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerStreamsPerProcess <em>Broker Streams Per Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Streams Per Process</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getBrokerStreamsPerProcess()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_BrokerStreamsPerProcess();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinition <em>Channel Auto Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Auto Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinition()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelAutoDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinitionEvent <em>Channel Auto Definition Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Auto Definition Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelAutoDefinitionEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelAutoDefinitionEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelEvent <em>Channel Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorAdapters <em>Channel Initiator Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Initiator Adapters</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorAdapters()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelInitiatorAdapters();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorControl <em>Channel Initiator Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Initiator Control</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorControl()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelInitiatorControl();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorDispatchers <em>Channel Initiator Dispatchers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Initiator Dispatchers</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorDispatchers()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelInitiatorDispatchers();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceAutoStart <em>Channel Initiator Trace Auto Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Initiator Trace Auto Start</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceAutoStart()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelInitiatorTraceAutoStart();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceTableSize <em>Channel Initiator Trace Table Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Initiator Trace Table Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelInitiatorTraceTableSize()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelInitiatorTraceTableSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelMonitoring <em>Channel Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelMonitoring()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelStatistics <em>Channel Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel Statistics</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getChannelStatistics()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ChannelStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointActiveCount <em>Checkpoint Active Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkpoint Active Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointActiveCount()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CheckpointActiveCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointMessageSize <em>Checkpoint Message Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkpoint Message Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointMessageSize()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CheckpointMessageSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointRestartCount <em>Checkpoint Restart Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkpoint Restart Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCheckpointRestartCount()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CheckpointRestartCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderMonitoring <em>Cluster Sender Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Sender Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderMonitoring()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterSenderMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderStatistics <em>Cluster Sender Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Sender Statistics</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterSenderStatistics()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterSenderStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadData <em>Cluster Work Load Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Work Load Data</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadData()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterWorkLoadData();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadExit <em>Cluster Work Load Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Work Load Exit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadExit()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterWorkLoadExit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadLength <em>Cluster Work Load Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Work Load Length</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkLoadLength()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterWorkLoadLength();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkloadUseQ <em>Cluster Workload Use Q</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cluster Workload Use Q</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getClusterWorkloadUseQ()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ClusterWorkloadUseQ();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCodedCharSetId <em>Coded Char Set Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coded Char Set Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCodedCharSetId()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CodedCharSetId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandEvent <em>Command Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CommandEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandLevel <em>Command Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandLevel()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CommandLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandScope <em>Command Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Scope</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandScope()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CommandScope();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandServerControl <em>Command Server Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Server Control</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getCommandServerControl()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_CommandServerControl();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfigurationEvent <em>Configuration Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfigurationEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ConfigurationEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfirm <em>Confirm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confirm</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getConfirm()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_Confirm();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDeadLetterQueue <em>Dead Letter Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dead Letter Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDeadLetterQueue()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_DeadLetterQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultBindType <em>Default Bind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Bind Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultBindType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_DefaultBindType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultTransmissionQueue <em>Default Transmission Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Transmission Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDefaultTransmissionQueue()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_DefaultTransmissionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDescription1()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSGroup <em>DNS Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DNS Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSGroup()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_DNSGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSWLM <em>DNSWLM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>DNSWLM</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getDNSWLM()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_DNSWLM();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getErrorLogSize <em>Error Log Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Log Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getErrorLogSize()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ErrorLogSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExcludedMessages <em>Excluded Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Excluded Messages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExcludedMessages()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ExcludedMessages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExitsDefaultPath <em>Exits Default Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exits Default Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExitsDefaultPath()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ExitsDefaultPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExpiryInterval <em>Expiry Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiry Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getExpiryInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ExpiryInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQPutAuthority <em>IGQ Put Authority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IGQ Put Authority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQPutAuthority()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_IGQPutAuthority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQUserId <em>IGQ User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IGQ User Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIGQUserId()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_IGQUserId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInhibitEvent <em>Inhibit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inhibit Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInhibitEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_InhibitEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInstallableServiceName <em>Installable Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installable Service Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getInstallableServiceName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_InstallableServiceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIntraGroupQueuing <em>Intra Group Queuing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intra Group Queuing</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIntraGroupQueuing()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_IntraGroupQueuing();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIPAddressVersion <em>IP Address Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IP Address Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getIPAddressVersion()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_IPAddressVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getListenerTimer <em>Listener Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Listener Timer</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getListenerTimer()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ListenerTimer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLocalEvent <em>Local Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLocalEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LocalEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogBufferPages <em>Log Buffer Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Buffer Pages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogBufferPages()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogBufferPages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogFilePages <em>Log File Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log File Pages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogFilePages()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogFilePages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPath <em>Log Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPath()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPrimaryFiles <em>Log Primary Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Primary Files</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogPrimaryFiles()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogPrimaryFiles();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogSecondaryFiles <em>Log Secondary Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Secondary Files</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogSecondaryFiles()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogSecondaryFiles();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogType <em>Log Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogWriteIntegrity <em>Log Write Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Write Integrity</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLogWriteIntegrity()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LogWriteIntegrity();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62ARMSuffix <em>LU62ARM Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU62ARM Suffix</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62ARMSuffix()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LU62ARMSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62Channels <em>LU62 Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU62 Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLU62Channels()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LU62Channels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUGroupName <em>LU Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUGroupName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LUGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary1 <em>LU Library1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU Library1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary1()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LULibrary1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary2 <em>LU Library2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU Library2</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULibrary2()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LULibrary2();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULocalLU <em>LU Local LU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU Local LU</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLULocalLU()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LULocalLU();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUName <em>LU Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LU Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LUName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUTPName <em>LUTP Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>LUTP Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getLUTPName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_LUTPName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxActiveChannels <em>Max Active Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Active Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxActiveChannels()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaxActiveChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxChannels <em>Max Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxChannels()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaxChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumCurrentChannels <em>Maximum Current Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Current Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumCurrentChannels()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaximumCurrentChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumHandles <em>Maximum Handles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Handles</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumHandles()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaximumHandles();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumMessageLength <em>Maximum Message Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Message Length</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumMessageLength()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaximumMessageLength();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumTCPChannels <em>Maximum TCP Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum TCP Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumTCPChannels()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaximumTCPChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumUncommittedMessages <em>Maximum Uncommitted Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Uncommitted Messages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaximumUncommittedMessages()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaximumUncommittedMessages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxInitiators <em>Max Initiators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Initiators</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMaxInitiators()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MaxInitiators();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIAccounting <em>MQI Accounting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MQI Accounting</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIAccounting()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MQIAccounting();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIBindType <em>MQI Bind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MQI Bind Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIBindType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MQIBindType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIStatistics <em>MQI Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MQI Statistics</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getMQIStatistics()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_MQIStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosAdaptorNumber <em>Net Bios Adaptor Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Adaptor Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosAdaptorNumber()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosAdaptorNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLibrary1 <em>Net Bios Library1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Library1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLibrary1()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosLibrary1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLocalName <em>Net Bios Local Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Local Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosLocalName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosLocalName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfCommands <em>Net Bios Number Of Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Number Of Commands</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfCommands()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosNumberOfCommands();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfNames <em>Net Bios Number Of Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Number Of Names</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfNames()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosNumberOfNames();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfSessions <em>Net Bios Number Of Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Net Bios Number Of Sessions</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getNetBiosNumberOfSessions()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_NetBiosNumberOfSessions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMax <em>Outbound Port Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outbound Port Max</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMax()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_OutboundPortMax();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMin <em>Outbound Port Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outbound Port Min</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getOutboundPortMin()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_OutboundPortMin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPerformanceEvent <em>Performance Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Performance Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPerformanceEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_PerformanceEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPipeLineLength <em>Pipe Line Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pipe Line Length</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPipeLineLength()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_PipeLineLength();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getPlatform()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_Platform();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueAccounting <em>Queue Accounting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Accounting</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueAccounting()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_QueueAccounting();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerName <em>Queue Manager Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_QueueManagerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerStatus <em>Queue Manager Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager Status</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueManagerStatus()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_QueueManagerStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueMonitoring <em>Queue Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueMonitoring()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_QueueMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueStatistics <em>Queue Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Statistics</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getQueueStatistics()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_QueueStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeout <em>Receive Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receive Timeout</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeout()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ReceiveTimeout();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutMin <em>Receive Timeout Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receive Timeout Min</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutMin()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ReceiveTimeoutMin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutType <em>Receive Timeout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receive Timeout Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getReceiveTimeoutType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ReceiveTimeoutType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRemoteEvent <em>Remote Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRemoteEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_RemoteEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryName <em>Repository Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_RepositoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryNameList <em>Repository Name List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Name List</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRepositoryNameList()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_RepositoryNameList();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitConnectType <em>Routing Exit Connect Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Routing Exit Connect Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitConnectType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_RoutingExitConnectType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitPath <em>Routing Exit Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Routing Exit Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getRoutingExitPath()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_RoutingExitPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSecurityPolicy <em>Security Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Security Policy</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSecurityPolicy()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SecurityPolicy();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getServiceEntryPoints <em>Service Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Entry Points</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getServiceEntryPoints()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_ServiceEntryPoints();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSharedQQmgrName <em>Shared QQmgr Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared QQmgr Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSharedQQmgrName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SharedQQmgrName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXBoardNumber <em>SPX Board Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SPX Board Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXBoardNumber()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SPXBoardNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXKeepAlive <em>SPX Keep Alive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SPX Keep Alive</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXKeepAlive()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SPXKeepAlive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary1 <em>SPX Library1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SPX Library1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary1()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SPXLibrary1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary2 <em>SPX Library2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SPX Library2</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXLibrary2()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SPXLibrary2();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXSocket <em>SPX Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SPX Socket</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSPXSocket()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SPXSocket();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCRLNameList <em>SSLCRL Name List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSLCRL Name List</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCRLNameList()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLCRLNameList();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCrytoHardware <em>SSL Cryto Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Cryto Hardware</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLCrytoHardware()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLCrytoHardware();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLEvent <em>SSL Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLFips <em>SSL Fips</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Fips</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLFips()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLFips();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyRepository <em>SSL Key Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Key Repository</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyRepository()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLKeyRepository();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyResetCount <em>SSL Key Reset Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Key Reset Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLKeyResetCount()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLKeyResetCount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLTasks <em>SSL Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Tasks</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSSLTasks()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SSLTasks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStartStopEvent <em>Start Stop Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Stop Event</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStartStopEvent()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_StartStopEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStatisticsInterval <em>Statistics Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Statistics Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getStatisticsInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_StatisticsInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppresedMessages <em>Suppresed Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suppresed Messages</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppresedMessages()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SuppresedMessages();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppressedMessageInterval <em>Suppressed Message Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suppressed Message Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getSuppressedMessageInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_SuppressedMessageInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPKeepAlive <em>TCP Keep Alive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Keep Alive</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPKeepAlive()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPKeepAlive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary1 <em>TCP Library1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Library1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary1()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPLibrary1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary2 <em>TCP Library2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Library2</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPLibrary2()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPLibrary2();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPListenerBacklog <em>TCP Listener Backlog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Listener Backlog</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPListenerBacklog()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPListenerBacklog();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPName <em>TCP Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPName()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPPort <em>TCP Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPPort()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPStackType <em>TCP Stack Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCP Stack Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTCPStackType()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TCPStackType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTraceRouteRecording <em>Trace Route Recording</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Route Recording</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTraceRouteRecording()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TraceRouteRecording();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTriggerInterval <em>Trigger Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getTriggerInterval()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_TriggerInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManager#getWhatIf <em>What If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>What If</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManager#getWhatIf()
	 * @see #getMQQueueManager()
	 * @generated
	 */
	EAttribute getMQQueueManager_WhatIf();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueManagerUnit <em>MQ Queue Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueManagerUnit
	 * @generated
	 */
	EClass getMQQueueManagerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQQueueUnit <em>MQ Queue Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Queue Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQQueueUnit
	 * @generated
	 */
	EClass getMQQueueUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQRoot <em>MQ Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot
	 * @generated
	 */
	EClass getMQRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getMixed()
	 * @see #getMQRoot()
	 * @generated
	 */
	EAttribute getMQRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getXMLNSPrefixMap()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getXSISchemaLocation()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQActivationSpecification <em>Capability MQ Activation Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Activation Specification</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQActivationSpecification()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQActivationSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQBaseSystem <em>Capability MQ Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Base System</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQBaseSystem()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQBaseSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQConnectionFactories <em>Capability MQ Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Connection Factories</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQConnectionFactories()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQConnectionFactories();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQDestination <em>Capability MQ Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQDestination()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQListener <em>Capability MQ Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Listener</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQListener()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQListener();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMessagingProvider <em>Capability MQ Messaging Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Messaging Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMessagingProvider()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQMessagingProvider();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMesseageListernerServicePort <em>Capability MQ Messeage Listerner Service Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Messeage Listerner Service Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQMesseageListernerServicePort()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQMesseageListernerServicePort();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueue <em>Capability MQ Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueue()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQQueue();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueChannel <em>Capability MQ Queue Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Queue Channel</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueChannel()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQQueueChannel();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueConnectionFactory <em>Capability MQ Queue Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Queue Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueConnectionFactory()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQQueueConnectionFactory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueDestination <em>Capability MQ Queue Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Queue Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueDestination()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQQueueDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueManager <em>Capability MQ Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQQueueManager()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQQueueManager();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicConnectionFactory <em>Capability MQ Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Topic Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicConnectionFactory()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQTopicConnectionFactory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicDestination <em>Capability MQ Topic Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability MQ Topic Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getCapabilityMQTopicDestination()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_CapabilityMQTopicDestination();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQActivationSpecificationUnit <em>Unit MQ Activation Specification Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Activation Specification Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQActivationSpecificationUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQActivationSpecificationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQBaseSystemUnit <em>Unit MQ Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Base System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQBaseSystemUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQBaseSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQConnectionFactoriesUnit <em>Unit MQ Connection Factories Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Connection Factories Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQConnectionFactoriesUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQConnectionFactoriesUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQListenerUnit <em>Unit MQ Listener Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Listener Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQListenerUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQListenerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessageListnerServicePortUnit <em>Unit MQ Message Listner Service Port Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Message Listner Service Port Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessageListnerServicePortUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQMessageListnerServicePortUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessagingProviderUnit <em>Unit MQ Messaging Provider Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Messaging Provider Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQMessagingProviderUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQMessagingProviderUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueChannelUnit <em>Unit MQ Queue Channel Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Queue Channel Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueChannelUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQQueueChannelUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueConnectionFactoryUnit <em>Unit MQ Queue Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Queue Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueConnectionFactoryUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQQueueConnectionFactoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueDestinationUnit <em>Unit MQ Queue Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Queue Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueDestinationUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQQueueDestinationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueManagerUnit <em>Unit MQ Queue Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Queue Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueManagerUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQQueueManagerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueUnit <em>Unit MQ Queue Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Queue Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQQueueUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQQueueUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicConnectionFactoryUnit <em>Unit MQ Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Topic Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicConnectionFactoryUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQTopicConnectionFactoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicDestinationUnit <em>Unit MQ Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit MQ Topic Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQRoot#getUnitMQTopicDestinationUnit()
	 * @see #getMQRoot()
	 * @generated
	 */
	EReference getMQRoot_UnitMQTopicDestinationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory <em>MQ Topic Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Topic Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory
	 * @generated
	 */
	EClass getMQTopicConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerCCSubscriptionQueue <em>Broker CC Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker CC Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerCCSubscriptionQueue()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerCCSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerControlQueue <em>Broker Control Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Control Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerControlQueue()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerControlQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerMessageSelection <em>Broker Message Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Message Selection</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerMessageSelection()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerMessageSelection();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerPublicationQueue <em>Broker Publication Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Publication Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerPublicationQueue()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerPublicationQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerQueueManager <em>Broker Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerQueueManager()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerQueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerSubscriptionQueue <em>Broker Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerSubscriptionQueue()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerVersion <em>Broker Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getBrokerVersion()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_BrokerVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCategory()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_Category();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCCSIDId <em>CCSID Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CCSID Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getCCSIDId()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_CCSIDId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Channel</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getChannel()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_Channel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getClientId <em>Client Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getClientId()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ClientId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getComponentManagedAuthenticationAlias <em>Component Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getComponentManagedAuthenticationAlias()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getContainerManagedAuthenticationAlias <em>Container Managed Authentication Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container Managed Authentication Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getContainerManagedAuthenticationAlias()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDescription1()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDirectBrokerAuthorization <em>Direct Broker Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Broker Authorization</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getDirectBrokerAuthorization()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_DirectBrokerAuthorization();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableCloneSupport <em>Enable Clone Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Clone Support</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableCloneSupport()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_EnableCloneSupport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMQConnectionPooling <em>Enable MQ Connection Pooling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable MQ Connection Pooling</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMQConnectionPooling()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_EnableMQConnectionPooling();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMulticastTransport <em>Enable Multicast Transport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Multicast Transport</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableMulticastTransport()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_EnableMulticastTransport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableReturnMethodsDuringShutdown <em>Enable Return Methods During Shutdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Return Methods During Shutdown</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getEnableReturnMethodsDuringShutdown()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getFactoryName <em>Factory Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getFactoryName()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_FactoryName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getHost()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_Host();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getJndiName()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getLocalServerAddress <em>Local Server Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Server Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getLocalServerAddress()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_LocalServerAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getMappingConfigurationAlias <em>Mapping Configuration Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapping Configuration Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getMappingConfigurationAlias()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_MappingConfigurationAlias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getModelQueueDefinition <em>Model Queue Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Queue Definition</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getModelQueueDefinition()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ModelQueueDefinition();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPersistentSubscriptionStore <em>Persistent Subscription Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Subscription Store</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPersistentSubscriptionStore()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PersistentSubscriptionStore();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPollingInterval <em>Polling Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polling Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPollingInterval()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PollingInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPort()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyHostName <em>Proxy Host Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Host Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyHostName()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ProxyHostName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyPort <em>Proxy Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getProxyPort()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_ProxyPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndAcknowledgeLevel <em>Publish And Acknowledge Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Acknowledge Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndAcknowledgeLevel()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PublishAndAcknowledgeLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupInterval <em>Publish And Subscribe Cleanup Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Cleanup Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupInterval()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupLevel <em>Publish And Subscribe Cleanup Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Cleanup Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeCleanupLevel()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeStatusInterval <em>Publish And Subscribe Status Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish And Subscribe Status Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getPublishAndSubscribeStatusInterval()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getQueueManager <em>Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getQueueManager()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_QueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getRescanInterval <em>Rescan Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rescan Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getRescanInterval()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_RescanInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCipherSuite <em>SSL Cipher Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Cipher Suite</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCipherSuite()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_SSLCipherSuite();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCRL <em>SSLCRL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSLCRL</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLCRL()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_SSLCRL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLPeerName <em>SSL Peer Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSL Peer Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getSSLPeerName()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_SSLPeerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getTransportType <em>Transport Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transport Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getTransportType()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_TransportType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getXAEnabled <em>XA Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XA Enabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactory#getXAEnabled()
	 * @see #getMQTopicConnectionFactory()
	 * @generated
	 */
	EAttribute getMQTopicConnectionFactory_XAEnabled();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactoryUnit <em>MQ Topic Connection Factory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Topic Connection Factory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicConnectionFactoryUnit
	 * @generated
	 */
	EClass getMQTopicConnectionFactoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination <em>MQ Topic Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Topic Destination</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination
	 * @generated
	 */
	EClass getMQTopicDestination();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBaseTopicName <em>Base Topic Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Topic Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBaseTopicName()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_BaseTopicName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerCCDurableSubscriptionQueue <em>Broker CC Durable Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker CC Durable Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerCCDurableSubscriptionQueue()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_BrokerCCDurableSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerDurableSubscriptionQueue <em>Broker Durable Subscription Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broker Durable Subscription Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getBrokerDurableSubscriptionQueue()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_BrokerDurableSubscriptionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getCategory()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_Category();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDecimalEncoding <em>Decimal Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decimal Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDecimalEncoding()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_DecimalEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDescription1()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDestinationName <em>Destination Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getDestinationName()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_DestinationName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getEnableMulticastTransport <em>Enable Multicast Transport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Multicast Transport</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getEnableMulticastTransport()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_EnableMulticastTransport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getExpiry <em>Expiry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiry</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getExpiry()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_Expiry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getFloatingPointEncoding <em>Floating Point Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Floating Point Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getFloatingPointEncoding()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_FloatingPointEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getIntegerEncoding <em>Integer Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getIntegerEncoding()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_IntegerEncoding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getJndiName <em>Jndi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jndi Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getJndiName()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_JndiName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPersitence <em>Persitence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persitence</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPersitence()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_Persitence();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getPriority()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedExpiry <em>Specified Expiry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specified Expiry</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedExpiry()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_SpecifiedExpiry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedPriority <em>Specified Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specified Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getSpecifiedPriority()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_SpecifiedPriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getTargetClient <em>Target Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getTargetClient()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_TargetClient();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getUseNativeEncoding <em>Use Native Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Native Encoding</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestination#getUseNativeEncoding()
	 * @see #getMQTopicDestination()
	 * @generated
	 */
	EAttribute getMQTopicDestination_UseNativeEncoding();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.mq.MQTopicDestinationUnit <em>MQ Topic Destination Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MQ Topic Destination Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.mq.MQTopicDestinationUnit
	 * @generated
	 */
	EClass getMQTopicDestinationUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MqFactory getMqFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl <em>Messeage Listerner Service Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMesseageListernerServicePort()
		 * @generated
		 */
		EClass MESSEAGE_LISTERNER_SERVICE_PORT = eINSTANCE.getMesseageListernerServicePort();

		/**
		 * The meta object literal for the '<em><b>CFJNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME = eINSTANCE.getMesseageListernerServicePort_CFJNDIName();

		/**
		 * The meta object literal for the '<em><b>Destination JNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME = eINSTANCE.getMesseageListernerServicePort_DestinationJNDIName();

		/**
		 * The meta object literal for the '<em><b>Max Retries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES = eINSTANCE.getMesseageListernerServicePort_MaxRetries();

		/**
		 * The meta object literal for the '<em><b>Max Sessions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS = eINSTANCE.getMesseageListernerServicePort_MaxSessions();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSEAGE_LISTERNER_SERVICE_PORT__NAME1 = eINSTANCE.getMesseageListernerServicePort_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationImpl <em>MQ Activation Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQActivationSpecification()
		 * @generated
		 */
		EClass MQ_ACTIVATION_SPECIFICATION = eINSTANCE.getMQActivationSpecification();

		/**
		 * The meta object literal for the '<em><b>Client Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER = eINSTANCE.getMQActivationSpecification_ClientIdentifier();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__JNDI_NAME = eINSTANCE.getMQActivationSpecification_JndiName();

		/**
		 * The meta object literal for the '<em><b>Mesasage Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR = eINSTANCE.getMQActivationSpecification_MesasageSelector();

		/**
		 * The meta object literal for the '<em><b>Specification Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME = eINSTANCE.getMQActivationSpecification_SpecificationName();

		/**
		 * The meta object literal for the '<em><b>Subscription Durable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE = eINSTANCE.getMQActivationSpecification_SubscriptionDurable();

		/**
		 * The meta object literal for the '<em><b>Subscription Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME = eINSTANCE.getMQActivationSpecification_SubscriptionName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationUnitImpl <em>MQ Activation Specification Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQActivationSpecificationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQActivationSpecificationUnit()
		 * @generated
		 */
		EClass MQ_ACTIVATION_SPECIFICATION_UNIT = eINSTANCE.getMQActivationSpecificationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl <em>MQ Base System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQBaseSystem()
		 * @generated
		 */
		EClass MQ_BASE_SYSTEM = eINSTANCE.getMQBaseSystem();

		/**
		 * The meta object literal for the '<em><b>Initial Context Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_BASE_SYSTEM__INITIAL_CONTEXT_FACTORY = eINSTANCE.getMQBaseSystem_InitialContextFactory();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_BASE_SYSTEM__PROVIDER_NAME = eINSTANCE.getMQBaseSystem_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Provider URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_BASE_SYSTEM__PROVIDER_URL = eINSTANCE.getMQBaseSystem_ProviderURL();

		/**
		 * The meta object literal for the '<em><b>Provider Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_BASE_SYSTEM__PROVIDER_VERSION = eINSTANCE.getMQBaseSystem_ProviderVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemUnitImpl <em>MQ Base System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQBaseSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQBaseSystemUnit()
		 * @generated
		 */
		EClass MQ_BASE_SYSTEM_UNIT = eINSTANCE.getMQBaseSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesImpl <em>MQ Connection Factories</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQConnectionFactories()
		 * @generated
		 */
		EClass MQ_CONNECTION_FACTORIES = eINSTANCE.getMQConnectionFactories();

		/**
		 * The meta object literal for the '<em><b>Broker CC Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_CC_SUBSCRIPTION_QUEUE = eINSTANCE.getMQConnectionFactories_BrokerCCSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Control Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_CONTROL_QUEUE = eINSTANCE.getMQConnectionFactories_BrokerControlQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Message Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_MESSAGE_SELECTION = eINSTANCE.getMQConnectionFactories_BrokerMessageSelection();

		/**
		 * The meta object literal for the '<em><b>Broker Publication Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_PUBLICATION_QUEUE = eINSTANCE.getMQConnectionFactories_BrokerPublicationQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_QUEUE_MANAGER = eINSTANCE.getMQConnectionFactories_BrokerQueueManager();

		/**
		 * The meta object literal for the '<em><b>Broker Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_SUBSCRIPTION_QUEUE = eINSTANCE.getMQConnectionFactories_BrokerSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__BROKER_VERSION = eINSTANCE.getMQConnectionFactories_BrokerVersion();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__CATEGORY = eINSTANCE.getMQConnectionFactories_Category();

		/**
		 * The meta object literal for the '<em><b>CCSID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__CCSID = eINSTANCE.getMQConnectionFactories_CCSID();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__CHANNEL = eINSTANCE.getMQConnectionFactories_Channel();

		/**
		 * The meta object literal for the '<em><b>Client Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__CLIENT_ID = eINSTANCE.getMQConnectionFactories_ClientId();

		/**
		 * The meta object literal for the '<em><b>Component Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQConnectionFactories_ComponentManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Container Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQConnectionFactories_ContainerManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Direct Broker Authorization Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__DIRECT_BROKER_AUTHORIZATION_TYPE = eINSTANCE.getMQConnectionFactories_DirectBrokerAuthorizationType();

		/**
		 * The meta object literal for the '<em><b>Enable Clone Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_CLONE_SUPPORT = eINSTANCE.getMQConnectionFactories_EnableCloneSupport();

		/**
		 * The meta object literal for the '<em><b>Enable Message Retention</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_MESSAGE_RETENTION = eINSTANCE.getMQConnectionFactories_EnableMessageRetention();

		/**
		 * The meta object literal for the '<em><b>Enable MQ Connection Pooling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_MQ_CONNECTION_POOLING = eINSTANCE.getMQConnectionFactories_EnableMQConnectionPooling();

		/**
		 * The meta object literal for the '<em><b>Enable Multicast Transport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_MULTICAST_TRANSPORT = eINSTANCE.getMQConnectionFactories_EnableMulticastTransport();

		/**
		 * The meta object literal for the '<em><b>Enable Return Methods During Shutdown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_RETURN_METHODS_DURING_SHUTDOWN = eINSTANCE.getMQConnectionFactories_EnableReturnMethodsDuringShutdown();

		/**
		 * The meta object literal for the '<em><b>Enable Sparse Broker Subscriptions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__ENABLE_SPARSE_BROKER_SUBSCRIPTIONS = eINSTANCE.getMQConnectionFactories_EnableSparseBrokerSubscriptions();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__HOST = eINSTANCE.getMQConnectionFactories_Host();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__JNDI_NAME = eINSTANCE.getMQConnectionFactories_JndiName();

		/**
		 * The meta object literal for the '<em><b>Local Server Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__LOCAL_SERVER_ADDRESS = eINSTANCE.getMQConnectionFactories_LocalServerAddress();

		/**
		 * The meta object literal for the '<em><b>Mapping Configuration Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__MAPPING_CONFIGURATION_ALIAS = eINSTANCE.getMQConnectionFactories_MappingConfigurationAlias();

		/**
		 * The meta object literal for the '<em><b>Model Queue Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__MODEL_QUEUE_DEFINITION = eINSTANCE.getMQConnectionFactories_ModelQueueDefinition();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__NAME1 = eINSTANCE.getMQConnectionFactories_Name1();

		/**
		 * The meta object literal for the '<em><b>Persistent Subscriptions Store</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PERSISTENT_SUBSCRIPTIONS_STORE = eINSTANCE.getMQConnectionFactories_PersistentSubscriptionsStore();

		/**
		 * The meta object literal for the '<em><b>Polling Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__POLLING_INTERVAL = eINSTANCE.getMQConnectionFactories_PollingInterval();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PORT = eINSTANCE.getMQConnectionFactories_Port();

		/**
		 * The meta object literal for the '<em><b>Proxy Host Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PROXY_HOST_NAME = eINSTANCE.getMQConnectionFactories_ProxyHostName();

		/**
		 * The meta object literal for the '<em><b>Proxy Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PROXY_PORT = eINSTANCE.getMQConnectionFactories_ProxyPort();

		/**
		 * The meta object literal for the '<em><b>Publish And Acknowledgement Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PUBLISH_AND_ACKNOWLEDGEMENT_INTERVAL = eINSTANCE.getMQConnectionFactories_PublishAndAcknowledgementInterval();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Cleanup Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL = eINSTANCE.getMQConnectionFactories_PublishAndSubscribeCleanupInterval();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Cleanup Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL = eINSTANCE.getMQConnectionFactories_PublishAndSubscribeCleanupLevel();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Status Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL = eINSTANCE.getMQConnectionFactories_PublishAndSubscribeStatusInterval();

		/**
		 * The meta object literal for the '<em><b>Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__QUEUE_MANAGER = eINSTANCE.getMQConnectionFactories_QueueManager();

		/**
		 * The meta object literal for the '<em><b>Rescan Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__RESCAN_INTERVAL = eINSTANCE.getMQConnectionFactories_RescanInterval();

		/**
		 * The meta object literal for the '<em><b>SSL Cipher Suite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__SSL_CIPHER_SUITE = eINSTANCE.getMQConnectionFactories_SSLCipherSuite();

		/**
		 * The meta object literal for the '<em><b>SSLCRL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__SSLCRL = eINSTANCE.getMQConnectionFactories_SSLCRL();

		/**
		 * The meta object literal for the '<em><b>SSL Peer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__SSL_PEER_NAME = eINSTANCE.getMQConnectionFactories_SSLPeerName();

		/**
		 * The meta object literal for the '<em><b>Temporary Queue Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__TEMPORARY_QUEUE_PREFIX = eINSTANCE.getMQConnectionFactories_TemporaryQueuePrefix();

		/**
		 * The meta object literal for the '<em><b>Transport Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__TRANSPORT_TYPE = eINSTANCE.getMQConnectionFactories_TransportType();

		/**
		 * The meta object literal for the '<em><b>XA Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_CONNECTION_FACTORIES__XA_ENABLED = eINSTANCE.getMQConnectionFactories_XAEnabled();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesUnitImpl <em>MQ Connection Factories Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQConnectionFactoriesUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQConnectionFactoriesUnit()
		 * @generated
		 */
		EClass MQ_CONNECTION_FACTORIES_UNIT = eINSTANCE.getMQConnectionFactoriesUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl <em>MQ Destination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQDestination()
		 * @generated
		 */
		EClass MQ_DESTINATION = eINSTANCE.getMQDestination();

		/**
		 * The meta object literal for the '<em><b>Base Queue Manager Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__BASE_QUEUE_MANAGER_NAME = eINSTANCE.getMQDestination_BaseQueueManagerName();

		/**
		 * The meta object literal for the '<em><b>Base Queue Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__BASE_QUEUE_NAME = eINSTANCE.getMQDestination_BaseQueueName();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__CATEGORY = eINSTANCE.getMQDestination_Category();

		/**
		 * The meta object literal for the '<em><b>CCSID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__CCSID = eINSTANCE.getMQDestination_CCSID();

		/**
		 * The meta object literal for the '<em><b>Decimal Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__DECIMAL_ENCODING = eINSTANCE.getMQDestination_DecimalEncoding();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__DESCRIPTION1 = eINSTANCE.getMQDestination_Description1();

		/**
		 * The meta object literal for the '<em><b>Destination Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__DESTINATION_NAME = eINSTANCE.getMQDestination_DestinationName();

		/**
		 * The meta object literal for the '<em><b>Expiry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__EXPIRY = eINSTANCE.getMQDestination_Expiry();

		/**
		 * The meta object literal for the '<em><b>Floating Point Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__FLOATING_POINT_ENCODING = eINSTANCE.getMQDestination_FloatingPointEncoding();

		/**
		 * The meta object literal for the '<em><b>Integer Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__INTEGER_ENCODING = eINSTANCE.getMQDestination_IntegerEncoding();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__JNDI_NAME = eINSTANCE.getMQDestination_JndiName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__PASSWORD = eINSTANCE.getMQDestination_Password();

		/**
		 * The meta object literal for the '<em><b>Persitence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__PERSITENCE = eINSTANCE.getMQDestination_Persitence();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__PRIORITY = eINSTANCE.getMQDestination_Priority();

		/**
		 * The meta object literal for the '<em><b>Queue Manager Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__QUEUE_MANAGER_HOST = eINSTANCE.getMQDestination_QueueManagerHost();

		/**
		 * The meta object literal for the '<em><b>Queue Manager Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__QUEUE_MANAGER_PORT = eINSTANCE.getMQDestination_QueueManagerPort();

		/**
		 * The meta object literal for the '<em><b>Server Connection Channel Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__SERVER_CONNECTION_CHANNEL_NAME = eINSTANCE.getMQDestination_ServerConnectionChannelName();

		/**
		 * The meta object literal for the '<em><b>Specified Expiry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__SPECIFIED_EXPIRY = eINSTANCE.getMQDestination_SpecifiedExpiry();

		/**
		 * The meta object literal for the '<em><b>Specified Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__SPECIFIED_PRIORITY = eINSTANCE.getMQDestination_SpecifiedPriority();

		/**
		 * The meta object literal for the '<em><b>Target Client</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__TARGET_CLIENT = eINSTANCE.getMQDestination_TargetClient();

		/**
		 * The meta object literal for the '<em><b>Use Native Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__USE_NATIVE_ENCODING = eINSTANCE.getMQDestination_UseNativeEncoding();

		/**
		 * The meta object literal for the '<em><b>User ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_DESTINATION__USER_ID = eINSTANCE.getMQDestination_UserID();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQListenerImpl <em>MQ Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQListenerImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQListener()
		 * @generated
		 */
		EClass MQ_LISTENER = eINSTANCE.getMQListener();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_LISTENER__PORT = eINSTANCE.getMQListener_Port();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQListenerUnitImpl <em>MQ Listener Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQListenerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQListenerUnit()
		 * @generated
		 */
		EClass MQ_LISTENER_UNIT = eINSTANCE.getMQListenerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessageListnerServicePortUnitImpl <em>MQ Message Listner Service Port Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessageListnerServicePortUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessageListnerServicePortUnit()
		 * @generated
		 */
		EClass MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT = eINSTANCE.getMQMessageListnerServicePortUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl <em>MQ Messaging Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessagingProvider()
		 * @generated
		 */
		EClass MQ_MESSAGING_PROVIDER = eINSTANCE.getMQMessagingProvider();

		/**
		 * The meta object literal for the '<em><b>Class Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_MESSAGING_PROVIDER__CLASS_PATH = eINSTANCE.getMQMessagingProvider_ClassPath();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_MESSAGING_PROVIDER__DESCRIPTION1 = eINSTANCE.getMQMessagingProvider_Description1();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_MESSAGING_PROVIDER__NAME1 = eINSTANCE.getMQMessagingProvider_Name1();

		/**
		 * The meta object literal for the '<em><b>Native Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_MESSAGING_PROVIDER__NATIVE_PATH = eINSTANCE.getMQMessagingProvider_NativePath();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderUnitImpl <em>MQ Messaging Provider Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQMessagingProviderUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQMessagingProviderUnit()
		 * @generated
		 */
		EClass MQ_MESSAGING_PROVIDER_UNIT = eINSTANCE.getMQMessagingProviderUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl <em>MQ Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueue()
		 * @generated
		 */
		EClass MQ_QUEUE = eINSTANCE.getMQQueue();

		/**
		 * The meta object literal for the '<em><b>Backout Requeue Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__BACKOUT_REQUEUE_QUEUE = eINSTANCE.getMQQueue_BackoutRequeueQueue();

		/**
		 * The meta object literal for the '<em><b>Backout Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__BACKOUT_THRESHOLD = eINSTANCE.getMQQueue_BackoutThreshold();

		/**
		 * The meta object literal for the '<em><b>Base Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__BASE_QUEUE = eINSTANCE.getMQQueue_BaseQueue();

		/**
		 * The meta object literal for the '<em><b>Base Queue Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__BASE_QUEUE_NAME = eINSTANCE.getMQQueue_BaseQueueName();

		/**
		 * The meta object literal for the '<em><b>CLWL Queue Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__CLWL_QUEUE_PRIORITY = eINSTANCE.getMQQueue_CLWLQueuePriority();

		/**
		 * The meta object literal for the '<em><b>CLWL Queue Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__CLWL_QUEUE_RANK = eINSTANCE.getMQQueue_CLWLQueueRank();

		/**
		 * The meta object literal for the '<em><b>CLWLU Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__CLWLU_QUEUE = eINSTANCE.getMQQueue_CLWLUQueue();

		/**
		 * The meta object literal for the '<em><b>Coupling Facility Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__COUPLING_FACILITY_NAME = eINSTANCE.getMQQueue_CouplingFacilityName();

		/**
		 * The meta object literal for the '<em><b>Default Bind Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DEFAULT_BIND_TYPE = eINSTANCE.getMQQueue_DefaultBindType();

		/**
		 * The meta object literal for the '<em><b>Default Input Open Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DEFAULT_INPUT_OPEN_OPTION = eINSTANCE.getMQQueue_DefaultInputOpenOption();

		/**
		 * The meta object literal for the '<em><b>Default Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DEFAULT_PRIORITY = eINSTANCE.getMQQueue_DefaultPriority();

		/**
		 * The meta object literal for the '<em><b>Definition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DEFINITION_TYPE = eINSTANCE.getMQQueue_DefinitionType();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DESCRIPTION1 = eINSTANCE.getMQQueue_Description1();

		/**
		 * The meta object literal for the '<em><b>Distribution List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DISTRIBUTION_LIST = eINSTANCE.getMQQueue_DistributionList();

		/**
		 * The meta object literal for the '<em><b>Distribution Lists</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__DISTRIBUTION_LISTS = eINSTANCE.getMQQueue_DistributionLists();

		/**
		 * The meta object literal for the '<em><b>Get Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__GET_MESSAGES = eINSTANCE.getMQQueue_GetMessages();

		/**
		 * The meta object literal for the '<em><b>Harden Get Backout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__HARDEN_GET_BACKOUT = eINSTANCE.getMQQueue_HardenGetBackout();

		/**
		 * The meta object literal for the '<em><b>Initiation Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__INITIATION_QUEUE = eINSTANCE.getMQQueue_InitiationQueue();

		/**
		 * The meta object literal for the '<em><b>Max Message Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__MAX_MESSAGE_LENGTH = eINSTANCE.getMQQueue_MaxMessageLength();

		/**
		 * The meta object literal for the '<em><b>Max Queue Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__MAX_QUEUE_DEPTH = eINSTANCE.getMQQueue_MaxQueueDepth();

		/**
		 * The meta object literal for the '<em><b>Message Delivery Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__MESSAGE_DELIVERY_SEQUENCE = eINSTANCE.getMQQueue_MessageDeliverySequence();

		/**
		 * The meta object literal for the '<em><b>Not Shared In Cluster</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__NOT_SHARED_IN_CLUSTER = eINSTANCE.getMQQueue_NotSharedInCluster();

		/**
		 * The meta object literal for the '<em><b>NPM Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__NPM_CLASS = eINSTANCE.getMQQueue_NPMClass();

		/**
		 * The meta object literal for the '<em><b>Persistence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__PERSISTENCE = eINSTANCE.getMQQueue_Persistence();

		/**
		 * The meta object literal for the '<em><b>Process Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__PROCESS_NAME = eINSTANCE.getMQQueue_ProcessName();

		/**
		 * The meta object literal for the '<em><b>Put Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__PUT_MESSAGE = eINSTANCE.getMQQueue_PutMessage();

		/**
		 * The meta object literal for the '<em><b>Put Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__PUT_MESSAGES = eINSTANCE.getMQQueue_PutMessages();

		/**
		 * The meta object literal for the '<em><b>QSG Disposition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QSG_DISPOSITION = eINSTANCE.getMQQueue_QSGDisposition();

		/**
		 * The meta object literal for the '<em><b>Queue Accounting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_ACCOUNTING = eINSTANCE.getMQQueue_QueueAccounting();

		/**
		 * The meta object literal for the '<em><b>Queue Depth High Events</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_DEPTH_HIGH_EVENTS = eINSTANCE.getMQQueue_QueueDepthHighEvents();

		/**
		 * The meta object literal for the '<em><b>Queue Depth High Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_DEPTH_HIGH_LIMIT = eINSTANCE.getMQQueue_QueueDepthHighLimit();

		/**
		 * The meta object literal for the '<em><b>Queue Depth Low Events</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_DEPTH_LOW_EVENTS = eINSTANCE.getMQQueue_QueueDepthLowEvents();

		/**
		 * The meta object literal for the '<em><b>Queue Depth Low Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_DEPTH_LOW_LIMIT = eINSTANCE.getMQQueue_QueueDepthLowLimit();

		/**
		 * The meta object literal for the '<em><b>Queue Depth Max Events</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_DEPTH_MAX_EVENTS = eINSTANCE.getMQQueue_QueueDepthMaxEvents();

		/**
		 * The meta object literal for the '<em><b>Queue Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_MONITORING = eINSTANCE.getMQQueue_QueueMonitoring();

		/**
		 * The meta object literal for the '<em><b>Queue Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_NAME = eINSTANCE.getMQQueue_QueueName();

		/**
		 * The meta object literal for the '<em><b>Queue Service Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_SERVICE_INTERVAL = eINSTANCE.getMQQueue_QueueServiceInterval();

		/**
		 * The meta object literal for the '<em><b>Queue Service Interval Events</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_SERVICE_INTERVAL_EVENTS = eINSTANCE.getMQQueue_QueueServiceIntervalEvents();

		/**
		 * The meta object literal for the '<em><b>Queue Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__QUEUE_TYPE = eINSTANCE.getMQQueue_QueueType();

		/**
		 * The meta object literal for the '<em><b>Remote Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__REMOTE_QUEUE = eINSTANCE.getMQQueue_RemoteQueue();

		/**
		 * The meta object literal for the '<em><b>Remote Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__REMOTE_QUEUE_MANAGER = eINSTANCE.getMQQueue_RemoteQueueManager();

		/**
		 * The meta object literal for the '<em><b>Retention Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__RETENTION_INTERVAL = eINSTANCE.getMQQueue_RetentionInterval();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__SCOPE = eINSTANCE.getMQQueue_Scope();

		/**
		 * The meta object literal for the '<em><b>Shareability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__SHAREABILITY = eINSTANCE.getMQQueue_Shareability();

		/**
		 * The meta object literal for the '<em><b>Shared In AList Of Clusters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__SHARED_IN_ALIST_OF_CLUSTERS = eINSTANCE.getMQQueue_SharedInAListOfClusters();

		/**
		 * The meta object literal for the '<em><b>Shared In Cluster</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__SHARED_IN_CLUSTER = eINSTANCE.getMQQueue_SharedInCluster();

		/**
		 * The meta object literal for the '<em><b>Stat Alteration Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_ALTERATION_DATE = eINSTANCE.getMQQueue_StatAlterationDate();

		/**
		 * The meta object literal for the '<em><b>Stat Alteration Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_ALTERATION_TIME = eINSTANCE.getMQQueue_StatAlterationTime();

		/**
		 * The meta object literal for the '<em><b>Stat Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_CREATION_DATE = eINSTANCE.getMQQueue_StatCreationDate();

		/**
		 * The meta object literal for the '<em><b>Stat Creation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_CREATION_TIME = eINSTANCE.getMQQueue_StatCreationTime();

		/**
		 * The meta object literal for the '<em><b>Stat Current Queue Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_CURRENT_QUEUE_DEPTH = eINSTANCE.getMQQueue_StatCurrentQueueDepth();

		/**
		 * The meta object literal for the '<em><b>Stat Open Input Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_OPEN_INPUT_COUNT = eINSTANCE.getMQQueue_StatOpenInputCount();

		/**
		 * The meta object literal for the '<em><b>Stat Open Output Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_OPEN_OUTPUT_COUNT = eINSTANCE.getMQQueue_StatOpenOutputCount();

		/**
		 * The meta object literal for the '<em><b>Stat Queue Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_QUEUE_MONITORING = eINSTANCE.getMQQueue_StatQueueMonitoring();

		/**
		 * The meta object literal for the '<em><b>Stat Queue Statistics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STAT_QUEUE_STATISTICS = eINSTANCE.getMQQueue_StatQueueStatistics();

		/**
		 * The meta object literal for the '<em><b>Storage Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__STORAGE_CLASS_NAME = eINSTANCE.getMQQueue_StorageClassName();

		/**
		 * The meta object literal for the '<em><b>Transmission Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRANSMISSION_QUEUE = eINSTANCE.getMQQueue_TransmissionQueue();

		/**
		 * The meta object literal for the '<em><b>Trigger Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRIGGER_CONTROL = eINSTANCE.getMQQueue_TriggerControl();

		/**
		 * The meta object literal for the '<em><b>Trigger Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRIGGER_DATA = eINSTANCE.getMQQueue_TriggerData();

		/**
		 * The meta object literal for the '<em><b>Trigger Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRIGGER_DEPTH = eINSTANCE.getMQQueue_TriggerDepth();

		/**
		 * The meta object literal for the '<em><b>Trigger Message Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRIGGER_MESSAGE_PRIORITY = eINSTANCE.getMQQueue_TriggerMessagePriority();

		/**
		 * The meta object literal for the '<em><b>Trigger Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__TRIGGER_TYPE = eINSTANCE.getMQQueue_TriggerType();

		/**
		 * The meta object literal for the '<em><b>Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__USAGE = eINSTANCE.getMQQueue_Usage();

		/**
		 * The meta object literal for the '<em><b>Usage1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE__USAGE1 = eINSTANCE.getMQQueue_Usage1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelImpl <em>MQ Queue Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueChannel()
		 * @generated
		 */
		EClass MQ_QUEUE_CHANNEL = eINSTANCE.getMQQueueChannel();

		/**
		 * The meta object literal for the '<em><b>Channel Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CHANNEL__CHANNEL_NAME = eINSTANCE.getMQQueueChannel_ChannelName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelUnitImpl <em>MQ Queue Channel Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueChannelUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueChannelUnit()
		 * @generated
		 */
		EClass MQ_QUEUE_CHANNEL_UNIT = eINSTANCE.getMQQueueChannelUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl <em>MQ Queue Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueConnectionFactory()
		 * @generated
		 */
		EClass MQ_QUEUE_CONNECTION_FACTORY = eINSTANCE.getMQQueueConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__CATEGORY = eINSTANCE.getMQQueueConnectionFactory_Category();

		/**
		 * The meta object literal for the '<em><b>CCSID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__CCSID = eINSTANCE.getMQQueueConnectionFactory_CCSID();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__CHANNEL = eINSTANCE.getMQQueueConnectionFactory_Channel();

		/**
		 * The meta object literal for the '<em><b>Client Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__CLIENT_ID = eINSTANCE.getMQQueueConnectionFactory_ClientId();

		/**
		 * The meta object literal for the '<em><b>Component Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQQueueConnectionFactory_ComponentManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Container Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQQueueConnectionFactory_ContainerManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__DESCRIPTION1 = eINSTANCE.getMQQueueConnectionFactory_Description1();

		/**
		 * The meta object literal for the '<em><b>Enable Connection Poling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__ENABLE_CONNECTION_POLING = eINSTANCE.getMQQueueConnectionFactory_EnableConnectionPoling();

		/**
		 * The meta object literal for the '<em><b>Enable Message Retention</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__ENABLE_MESSAGE_RETENTION = eINSTANCE.getMQQueueConnectionFactory_EnableMessageRetention();

		/**
		 * The meta object literal for the '<em><b>Enable Return Method During Shutdown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__ENABLE_RETURN_METHOD_DURING_SHUTDOWN = eINSTANCE.getMQQueueConnectionFactory_EnableReturnMethodDuringShutdown();

		/**
		 * The meta object literal for the '<em><b>Factory Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__FACTORY_NAME = eINSTANCE.getMQQueueConnectionFactory_FactoryName();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__HOST = eINSTANCE.getMQQueueConnectionFactory_Host();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__JNDI_NAME = eINSTANCE.getMQQueueConnectionFactory_JndiName();

		/**
		 * The meta object literal for the '<em><b>Local Server Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS = eINSTANCE.getMQQueueConnectionFactory_LocalServerAddress();

		/**
		 * The meta object literal for the '<em><b>Mappingconfiguration Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MAPPINGCONFIGURATION_ALIAS = eINSTANCE.getMQQueueConnectionFactory_MappingconfigurationAlias();

		/**
		 * The meta object literal for the '<em><b>Max Connections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MAX_CONNECTIONS = eINSTANCE.getMQQueueConnectionFactory_MaxConnections();

		/**
		 * The meta object literal for the '<em><b>Max Sessions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MAX_SESSIONS = eINSTANCE.getMQQueueConnectionFactory_MaxSessions();

		/**
		 * The meta object literal for the '<em><b>Min Connections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MIN_CONNECTIONS = eINSTANCE.getMQQueueConnectionFactory_MinConnections();

		/**
		 * The meta object literal for the '<em><b>Min Sessions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MIN_SESSIONS = eINSTANCE.getMQQueueConnectionFactory_MinSessions();

		/**
		 * The meta object literal for the '<em><b>Model Queue Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION = eINSTANCE.getMQQueueConnectionFactory_ModelQueueDefinition();

		/**
		 * The meta object literal for the '<em><b>Polling Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__POLLING_INTERVAL = eINSTANCE.getMQQueueConnectionFactory_PollingInterval();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__PORT = eINSTANCE.getMQQueueConnectionFactory_Port();

		/**
		 * The meta object literal for the '<em><b>Queuemanager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__QUEUEMANAGER = eINSTANCE.getMQQueueConnectionFactory_Queuemanager();

		/**
		 * The meta object literal for the '<em><b>Rescan Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__RESCAN_INTERVAL = eINSTANCE.getMQQueueConnectionFactory_RescanInterval();

		/**
		 * The meta object literal for the '<em><b>SSL Cipher Suit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__SSL_CIPHER_SUIT = eINSTANCE.getMQQueueConnectionFactory_SSLCipherSuit();

		/**
		 * The meta object literal for the '<em><b>SSLCRL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__SSLCRL = eINSTANCE.getMQQueueConnectionFactory_SSLCRL();

		/**
		 * The meta object literal for the '<em><b>SSL Peer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__SSL_PEER_NAME = eINSTANCE.getMQQueueConnectionFactory_SSLPeerName();

		/**
		 * The meta object literal for the '<em><b>Temporary Queue Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__TEMPORARY_QUEUE_PREFIX = eINSTANCE.getMQQueueConnectionFactory_TemporaryQueuePrefix();

		/**
		 * The meta object literal for the '<em><b>Transport Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__TRANSPORT_TYPE = eINSTANCE.getMQQueueConnectionFactory_TransportType();

		/**
		 * The meta object literal for the '<em><b>XA Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_CONNECTION_FACTORY__XA_ENABLED = eINSTANCE.getMQQueueConnectionFactory_XAEnabled();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryUnitImpl <em>MQ Queue Connection Factory Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueConnectionFactoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueConnectionFactoryUnit()
		 * @generated
		 */
		EClass MQ_QUEUE_CONNECTION_FACTORY_UNIT = eINSTANCE.getMQQueueConnectionFactoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationImpl <em>MQ Queue Destination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueDestination()
		 * @generated
		 */
		EClass MQ_QUEUE_DESTINATION = eINSTANCE.getMQQueueDestination();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationUnitImpl <em>MQ Queue Destination Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueDestinationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueDestinationUnit()
		 * @generated
		 */
		EClass MQ_QUEUE_DESTINATION_UNIT = eINSTANCE.getMQQueueDestinationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl <em>MQ Queue Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueManager()
		 * @generated
		 */
		EClass MQ_QUEUE_MANAGER = eINSTANCE.getMQQueueManager();

		/**
		 * The meta object literal for the '<em><b>Accounting Connection Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ACCOUNTING_CONNECTION_OVERRIDE = eINSTANCE.getMQQueueManager_AccountingConnectionOverride();

		/**
		 * The meta object literal for the '<em><b>Accounting Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ACCOUNTING_INTERVAL = eINSTANCE.getMQQueueManager_AccountingInterval();

		/**
		 * The meta object literal for the '<em><b>Activity Recording</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ACTIVITY_RECORDING = eINSTANCE.getMQQueueManager_ActivityRecording();

		/**
		 * The meta object literal for the '<em><b>Adopt New MCA</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ADOPT_NEW_MCA = eINSTANCE.getMQQueueManager_AdoptNewMCA();

		/**
		 * The meta object literal for the '<em><b>Adopt New MCA Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_CHECK = eINSTANCE.getMQQueueManager_AdoptNewMCACheck();

		/**
		 * The meta object literal for the '<em><b>Adopt New MCA Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ADOPT_NEW_MCA_TYPE = eINSTANCE.getMQQueueManager_AdoptNewMCAType();

		/**
		 * The meta object literal for the '<em><b>Authority Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__AUTHORITY_EVENT = eINSTANCE.getMQQueueManager_AuthorityEvent();

		/**
		 * The meta object literal for the '<em><b>Automatic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__AUTOMATIC = eINSTANCE.getMQQueueManager_Automatic();

		/**
		 * The meta object literal for the '<em><b>Bridge Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BRIDGE_EVENT = eINSTANCE.getMQQueueManager_BridgeEvent();

		/**
		 * The meta object literal for the '<em><b>Broker Message Retry Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_MESSAGE_RETRY_COUNT = eINSTANCE.getMQQueueManager_BrokerMessageRetryCount();

		/**
		 * The meta object literal for the '<em><b>Broker Open Cache Expiry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_EXPIRY = eINSTANCE.getMQQueueManager_BrokerOpenCacheExpiry();

		/**
		 * The meta object literal for the '<em><b>Broker Open Cache Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_OPEN_CACHE_SIZE = eINSTANCE.getMQQueueManager_BrokerOpenCacheSize();

		/**
		 * The meta object literal for the '<em><b>Broker Public Batch Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_PUBLIC_BATCH_INTERVAL = eINSTANCE.getMQQueueManager_BrokerPublicBatchInterval();

		/**
		 * The meta object literal for the '<em><b>Broker Publish Batch Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_PUBLISH_BATCH_SIZE = eINSTANCE.getMQQueueManager_BrokerPublishBatchSize();

		/**
		 * The meta object literal for the '<em><b>Broker Streams Per Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__BROKER_STREAMS_PER_PROCESS = eINSTANCE.getMQQueueManager_BrokerStreamsPerProcess();

		/**
		 * The meta object literal for the '<em><b>Channel Auto Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION = eINSTANCE.getMQQueueManager_ChannelAutoDefinition();

		/**
		 * The meta object literal for the '<em><b>Channel Auto Definition Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_AUTO_DEFINITION_EVENT = eINSTANCE.getMQQueueManager_ChannelAutoDefinitionEvent();

		/**
		 * The meta object literal for the '<em><b>Channel Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_EVENT = eINSTANCE.getMQQueueManager_ChannelEvent();

		/**
		 * The meta object literal for the '<em><b>Channel Initiator Adapters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_ADAPTERS = eINSTANCE.getMQQueueManager_ChannelInitiatorAdapters();

		/**
		 * The meta object literal for the '<em><b>Channel Initiator Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_CONTROL = eINSTANCE.getMQQueueManager_ChannelInitiatorControl();

		/**
		 * The meta object literal for the '<em><b>Channel Initiator Dispatchers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_DISPATCHERS = eINSTANCE.getMQQueueManager_ChannelInitiatorDispatchers();

		/**
		 * The meta object literal for the '<em><b>Channel Initiator Trace Auto Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_AUTO_START = eINSTANCE.getMQQueueManager_ChannelInitiatorTraceAutoStart();

		/**
		 * The meta object literal for the '<em><b>Channel Initiator Trace Table Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_INITIATOR_TRACE_TABLE_SIZE = eINSTANCE.getMQQueueManager_ChannelInitiatorTraceTableSize();

		/**
		 * The meta object literal for the '<em><b>Channel Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_MONITORING = eINSTANCE.getMQQueueManager_ChannelMonitoring();

		/**
		 * The meta object literal for the '<em><b>Channel Statistics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHANNEL_STATISTICS = eINSTANCE.getMQQueueManager_ChannelStatistics();

		/**
		 * The meta object literal for the '<em><b>Checkpoint Active Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHECKPOINT_ACTIVE_COUNT = eINSTANCE.getMQQueueManager_CheckpointActiveCount();

		/**
		 * The meta object literal for the '<em><b>Checkpoint Message Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHECKPOINT_MESSAGE_SIZE = eINSTANCE.getMQQueueManager_CheckpointMessageSize();

		/**
		 * The meta object literal for the '<em><b>Checkpoint Restart Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CHECKPOINT_RESTART_COUNT = eINSTANCE.getMQQueueManager_CheckpointRestartCount();

		/**
		 * The meta object literal for the '<em><b>Cluster Sender Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_SENDER_MONITORING = eINSTANCE.getMQQueueManager_ClusterSenderMonitoring();

		/**
		 * The meta object literal for the '<em><b>Cluster Sender Statistics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_SENDER_STATISTICS = eINSTANCE.getMQQueueManager_ClusterSenderStatistics();

		/**
		 * The meta object literal for the '<em><b>Cluster Work Load Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_DATA = eINSTANCE.getMQQueueManager_ClusterWorkLoadData();

		/**
		 * The meta object literal for the '<em><b>Cluster Work Load Exit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_EXIT = eINSTANCE.getMQQueueManager_ClusterWorkLoadExit();

		/**
		 * The meta object literal for the '<em><b>Cluster Work Load Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_WORK_LOAD_LENGTH = eINSTANCE.getMQQueueManager_ClusterWorkLoadLength();

		/**
		 * The meta object literal for the '<em><b>Cluster Workload Use Q</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CLUSTER_WORKLOAD_USE_Q = eINSTANCE.getMQQueueManager_ClusterWorkloadUseQ();

		/**
		 * The meta object literal for the '<em><b>Coded Char Set Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CODED_CHAR_SET_ID = eINSTANCE.getMQQueueManager_CodedCharSetId();

		/**
		 * The meta object literal for the '<em><b>Command Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__COMMAND_EVENT = eINSTANCE.getMQQueueManager_CommandEvent();

		/**
		 * The meta object literal for the '<em><b>Command Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__COMMAND_LEVEL = eINSTANCE.getMQQueueManager_CommandLevel();

		/**
		 * The meta object literal for the '<em><b>Command Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__COMMAND_SCOPE = eINSTANCE.getMQQueueManager_CommandScope();

		/**
		 * The meta object literal for the '<em><b>Command Server Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__COMMAND_SERVER_CONTROL = eINSTANCE.getMQQueueManager_CommandServerControl();

		/**
		 * The meta object literal for the '<em><b>Configuration Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CONFIGURATION_EVENT = eINSTANCE.getMQQueueManager_ConfigurationEvent();

		/**
		 * The meta object literal for the '<em><b>Confirm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__CONFIRM = eINSTANCE.getMQQueueManager_Confirm();

		/**
		 * The meta object literal for the '<em><b>Dead Letter Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DEAD_LETTER_QUEUE = eINSTANCE.getMQQueueManager_DeadLetterQueue();

		/**
		 * The meta object literal for the '<em><b>Default Bind Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DEFAULT_BIND_TYPE = eINSTANCE.getMQQueueManager_DefaultBindType();

		/**
		 * The meta object literal for the '<em><b>Default Transmission Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DEFAULT_TRANSMISSION_QUEUE = eINSTANCE.getMQQueueManager_DefaultTransmissionQueue();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DESCRIPTION1 = eINSTANCE.getMQQueueManager_Description1();

		/**
		 * The meta object literal for the '<em><b>DNS Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DNS_GROUP = eINSTANCE.getMQQueueManager_DNSGroup();

		/**
		 * The meta object literal for the '<em><b>DNSWLM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__DNSWLM = eINSTANCE.getMQQueueManager_DNSWLM();

		/**
		 * The meta object literal for the '<em><b>Error Log Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ERROR_LOG_SIZE = eINSTANCE.getMQQueueManager_ErrorLogSize();

		/**
		 * The meta object literal for the '<em><b>Excluded Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__EXCLUDED_MESSAGES = eINSTANCE.getMQQueueManager_ExcludedMessages();

		/**
		 * The meta object literal for the '<em><b>Exits Default Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__EXITS_DEFAULT_PATH = eINSTANCE.getMQQueueManager_ExitsDefaultPath();

		/**
		 * The meta object literal for the '<em><b>Expiry Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__EXPIRY_INTERVAL = eINSTANCE.getMQQueueManager_ExpiryInterval();

		/**
		 * The meta object literal for the '<em><b>IGQ Put Authority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__IGQ_PUT_AUTHORITY = eINSTANCE.getMQQueueManager_IGQPutAuthority();

		/**
		 * The meta object literal for the '<em><b>IGQ User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__IGQ_USER_ID = eINSTANCE.getMQQueueManager_IGQUserId();

		/**
		 * The meta object literal for the '<em><b>Inhibit Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__INHIBIT_EVENT = eINSTANCE.getMQQueueManager_InhibitEvent();

		/**
		 * The meta object literal for the '<em><b>Installable Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__INSTALLABLE_SERVICE_NAME = eINSTANCE.getMQQueueManager_InstallableServiceName();

		/**
		 * The meta object literal for the '<em><b>Intra Group Queuing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__INTRA_GROUP_QUEUING = eINSTANCE.getMQQueueManager_IntraGroupQueuing();

		/**
		 * The meta object literal for the '<em><b>IP Address Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__IP_ADDRESS_VERSION = eINSTANCE.getMQQueueManager_IPAddressVersion();

		/**
		 * The meta object literal for the '<em><b>Listener Timer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LISTENER_TIMER = eINSTANCE.getMQQueueManager_ListenerTimer();

		/**
		 * The meta object literal for the '<em><b>Local Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOCAL_EVENT = eINSTANCE.getMQQueueManager_LocalEvent();

		/**
		 * The meta object literal for the '<em><b>Log Buffer Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_BUFFER_PAGES = eINSTANCE.getMQQueueManager_LogBufferPages();

		/**
		 * The meta object literal for the '<em><b>Log File Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_FILE_PAGES = eINSTANCE.getMQQueueManager_LogFilePages();

		/**
		 * The meta object literal for the '<em><b>Log Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_PATH = eINSTANCE.getMQQueueManager_LogPath();

		/**
		 * The meta object literal for the '<em><b>Log Primary Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_PRIMARY_FILES = eINSTANCE.getMQQueueManager_LogPrimaryFiles();

		/**
		 * The meta object literal for the '<em><b>Log Secondary Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_SECONDARY_FILES = eINSTANCE.getMQQueueManager_LogSecondaryFiles();

		/**
		 * The meta object literal for the '<em><b>Log Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_TYPE = eINSTANCE.getMQQueueManager_LogType();

		/**
		 * The meta object literal for the '<em><b>Log Write Integrity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LOG_WRITE_INTEGRITY = eINSTANCE.getMQQueueManager_LogWriteIntegrity();

		/**
		 * The meta object literal for the '<em><b>LU62ARM Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU62ARM_SUFFIX = eINSTANCE.getMQQueueManager_LU62ARMSuffix();

		/**
		 * The meta object literal for the '<em><b>LU62 Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU62_CHANNELS = eINSTANCE.getMQQueueManager_LU62Channels();

		/**
		 * The meta object literal for the '<em><b>LU Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU_GROUP_NAME = eINSTANCE.getMQQueueManager_LUGroupName();

		/**
		 * The meta object literal for the '<em><b>LU Library1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU_LIBRARY1 = eINSTANCE.getMQQueueManager_LULibrary1();

		/**
		 * The meta object literal for the '<em><b>LU Library2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU_LIBRARY2 = eINSTANCE.getMQQueueManager_LULibrary2();

		/**
		 * The meta object literal for the '<em><b>LU Local LU</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU_LOCAL_LU = eINSTANCE.getMQQueueManager_LULocalLU();

		/**
		 * The meta object literal for the '<em><b>LU Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LU_NAME = eINSTANCE.getMQQueueManager_LUName();

		/**
		 * The meta object literal for the '<em><b>LUTP Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__LUTP_NAME = eINSTANCE.getMQQueueManager_LUTPName();

		/**
		 * The meta object literal for the '<em><b>Max Active Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAX_ACTIVE_CHANNELS = eINSTANCE.getMQQueueManager_MaxActiveChannels();

		/**
		 * The meta object literal for the '<em><b>Max Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAX_CHANNELS = eINSTANCE.getMQQueueManager_MaxChannels();

		/**
		 * The meta object literal for the '<em><b>Maximum Current Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAXIMUM_CURRENT_CHANNELS = eINSTANCE.getMQQueueManager_MaximumCurrentChannels();

		/**
		 * The meta object literal for the '<em><b>Maximum Handles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAXIMUM_HANDLES = eINSTANCE.getMQQueueManager_MaximumHandles();

		/**
		 * The meta object literal for the '<em><b>Maximum Message Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAXIMUM_MESSAGE_LENGTH = eINSTANCE.getMQQueueManager_MaximumMessageLength();

		/**
		 * The meta object literal for the '<em><b>Maximum TCP Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAXIMUM_TCP_CHANNELS = eINSTANCE.getMQQueueManager_MaximumTCPChannels();

		/**
		 * The meta object literal for the '<em><b>Maximum Uncommitted Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAXIMUM_UNCOMMITTED_MESSAGES = eINSTANCE.getMQQueueManager_MaximumUncommittedMessages();

		/**
		 * The meta object literal for the '<em><b>Max Initiators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MAX_INITIATORS = eINSTANCE.getMQQueueManager_MaxInitiators();

		/**
		 * The meta object literal for the '<em><b>MQI Accounting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MQI_ACCOUNTING = eINSTANCE.getMQQueueManager_MQIAccounting();

		/**
		 * The meta object literal for the '<em><b>MQI Bind Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MQI_BIND_TYPE = eINSTANCE.getMQQueueManager_MQIBindType();

		/**
		 * The meta object literal for the '<em><b>MQI Statistics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__MQI_STATISTICS = eINSTANCE.getMQQueueManager_MQIStatistics();

		/**
		 * The meta object literal for the '<em><b>Net Bios Adaptor Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_ADAPTOR_NUMBER = eINSTANCE.getMQQueueManager_NetBiosAdaptorNumber();

		/**
		 * The meta object literal for the '<em><b>Net Bios Library1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_LIBRARY1 = eINSTANCE.getMQQueueManager_NetBiosLibrary1();

		/**
		 * The meta object literal for the '<em><b>Net Bios Local Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_LOCAL_NAME = eINSTANCE.getMQQueueManager_NetBiosLocalName();

		/**
		 * The meta object literal for the '<em><b>Net Bios Number Of Commands</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_COMMANDS = eINSTANCE.getMQQueueManager_NetBiosNumberOfCommands();

		/**
		 * The meta object literal for the '<em><b>Net Bios Number Of Names</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_NAMES = eINSTANCE.getMQQueueManager_NetBiosNumberOfNames();

		/**
		 * The meta object literal for the '<em><b>Net Bios Number Of Sessions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__NET_BIOS_NUMBER_OF_SESSIONS = eINSTANCE.getMQQueueManager_NetBiosNumberOfSessions();

		/**
		 * The meta object literal for the '<em><b>Outbound Port Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__OUTBOUND_PORT_MAX = eINSTANCE.getMQQueueManager_OutboundPortMax();

		/**
		 * The meta object literal for the '<em><b>Outbound Port Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__OUTBOUND_PORT_MIN = eINSTANCE.getMQQueueManager_OutboundPortMin();

		/**
		 * The meta object literal for the '<em><b>Performance Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__PERFORMANCE_EVENT = eINSTANCE.getMQQueueManager_PerformanceEvent();

		/**
		 * The meta object literal for the '<em><b>Pipe Line Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__PIPE_LINE_LENGTH = eINSTANCE.getMQQueueManager_PipeLineLength();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__PLATFORM = eINSTANCE.getMQQueueManager_Platform();

		/**
		 * The meta object literal for the '<em><b>Queue Accounting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__QUEUE_ACCOUNTING = eINSTANCE.getMQQueueManager_QueueAccounting();

		/**
		 * The meta object literal for the '<em><b>Queue Manager Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__QUEUE_MANAGER_NAME = eINSTANCE.getMQQueueManager_QueueManagerName();

		/**
		 * The meta object literal for the '<em><b>Queue Manager Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__QUEUE_MANAGER_STATUS = eINSTANCE.getMQQueueManager_QueueManagerStatus();

		/**
		 * The meta object literal for the '<em><b>Queue Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__QUEUE_MONITORING = eINSTANCE.getMQQueueManager_QueueMonitoring();

		/**
		 * The meta object literal for the '<em><b>Queue Statistics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__QUEUE_STATISTICS = eINSTANCE.getMQQueueManager_QueueStatistics();

		/**
		 * The meta object literal for the '<em><b>Receive Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT = eINSTANCE.getMQQueueManager_ReceiveTimeout();

		/**
		 * The meta object literal for the '<em><b>Receive Timeout Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_MIN = eINSTANCE.getMQQueueManager_ReceiveTimeoutMin();

		/**
		 * The meta object literal for the '<em><b>Receive Timeout Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__RECEIVE_TIMEOUT_TYPE = eINSTANCE.getMQQueueManager_ReceiveTimeoutType();

		/**
		 * The meta object literal for the '<em><b>Remote Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__REMOTE_EVENT = eINSTANCE.getMQQueueManager_RemoteEvent();

		/**
		 * The meta object literal for the '<em><b>Repository Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__REPOSITORY_NAME = eINSTANCE.getMQQueueManager_RepositoryName();

		/**
		 * The meta object literal for the '<em><b>Repository Name List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__REPOSITORY_NAME_LIST = eINSTANCE.getMQQueueManager_RepositoryNameList();

		/**
		 * The meta object literal for the '<em><b>Routing Exit Connect Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ROUTING_EXIT_CONNECT_TYPE = eINSTANCE.getMQQueueManager_RoutingExitConnectType();

		/**
		 * The meta object literal for the '<em><b>Routing Exit Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__ROUTING_EXIT_PATH = eINSTANCE.getMQQueueManager_RoutingExitPath();

		/**
		 * The meta object literal for the '<em><b>Security Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SECURITY_POLICY = eINSTANCE.getMQQueueManager_SecurityPolicy();

		/**
		 * The meta object literal for the '<em><b>Service Entry Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SERVICE_ENTRY_POINTS = eINSTANCE.getMQQueueManager_ServiceEntryPoints();

		/**
		 * The meta object literal for the '<em><b>Shared QQmgr Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SHARED_QQMGR_NAME = eINSTANCE.getMQQueueManager_SharedQQmgrName();

		/**
		 * The meta object literal for the '<em><b>SPX Board Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SPX_BOARD_NUMBER = eINSTANCE.getMQQueueManager_SPXBoardNumber();

		/**
		 * The meta object literal for the '<em><b>SPX Keep Alive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SPX_KEEP_ALIVE = eINSTANCE.getMQQueueManager_SPXKeepAlive();

		/**
		 * The meta object literal for the '<em><b>SPX Library1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SPX_LIBRARY1 = eINSTANCE.getMQQueueManager_SPXLibrary1();

		/**
		 * The meta object literal for the '<em><b>SPX Library2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SPX_LIBRARY2 = eINSTANCE.getMQQueueManager_SPXLibrary2();

		/**
		 * The meta object literal for the '<em><b>SPX Socket</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SPX_SOCKET = eINSTANCE.getMQQueueManager_SPXSocket();

		/**
		 * The meta object literal for the '<em><b>SSLCRL Name List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSLCRL_NAME_LIST = eINSTANCE.getMQQueueManager_SSLCRLNameList();

		/**
		 * The meta object literal for the '<em><b>SSL Cryto Hardware</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_CRYTO_HARDWARE = eINSTANCE.getMQQueueManager_SSLCrytoHardware();

		/**
		 * The meta object literal for the '<em><b>SSL Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_EVENT = eINSTANCE.getMQQueueManager_SSLEvent();

		/**
		 * The meta object literal for the '<em><b>SSL Fips</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_FIPS = eINSTANCE.getMQQueueManager_SSLFips();

		/**
		 * The meta object literal for the '<em><b>SSL Key Repository</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_KEY_REPOSITORY = eINSTANCE.getMQQueueManager_SSLKeyRepository();

		/**
		 * The meta object literal for the '<em><b>SSL Key Reset Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_KEY_RESET_COUNT = eINSTANCE.getMQQueueManager_SSLKeyResetCount();

		/**
		 * The meta object literal for the '<em><b>SSL Tasks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SSL_TASKS = eINSTANCE.getMQQueueManager_SSLTasks();

		/**
		 * The meta object literal for the '<em><b>Start Stop Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__START_STOP_EVENT = eINSTANCE.getMQQueueManager_StartStopEvent();

		/**
		 * The meta object literal for the '<em><b>Statistics Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__STATISTICS_INTERVAL = eINSTANCE.getMQQueueManager_StatisticsInterval();

		/**
		 * The meta object literal for the '<em><b>Suppresed Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SUPPRESED_MESSAGES = eINSTANCE.getMQQueueManager_SuppresedMessages();

		/**
		 * The meta object literal for the '<em><b>Suppressed Message Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__SUPPRESSED_MESSAGE_INTERVAL = eINSTANCE.getMQQueueManager_SuppressedMessageInterval();

		/**
		 * The meta object literal for the '<em><b>TCP Keep Alive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_KEEP_ALIVE = eINSTANCE.getMQQueueManager_TCPKeepAlive();

		/**
		 * The meta object literal for the '<em><b>TCP Library1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_LIBRARY1 = eINSTANCE.getMQQueueManager_TCPLibrary1();

		/**
		 * The meta object literal for the '<em><b>TCP Library2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_LIBRARY2 = eINSTANCE.getMQQueueManager_TCPLibrary2();

		/**
		 * The meta object literal for the '<em><b>TCP Listener Backlog</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_LISTENER_BACKLOG = eINSTANCE.getMQQueueManager_TCPListenerBacklog();

		/**
		 * The meta object literal for the '<em><b>TCP Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_NAME = eINSTANCE.getMQQueueManager_TCPName();

		/**
		 * The meta object literal for the '<em><b>TCP Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_PORT = eINSTANCE.getMQQueueManager_TCPPort();

		/**
		 * The meta object literal for the '<em><b>TCP Stack Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TCP_STACK_TYPE = eINSTANCE.getMQQueueManager_TCPStackType();

		/**
		 * The meta object literal for the '<em><b>Trace Route Recording</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TRACE_ROUTE_RECORDING = eINSTANCE.getMQQueueManager_TraceRouteRecording();

		/**
		 * The meta object literal for the '<em><b>Trigger Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__TRIGGER_INTERVAL = eINSTANCE.getMQQueueManager_TriggerInterval();

		/**
		 * The meta object literal for the '<em><b>What If</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_QUEUE_MANAGER__WHAT_IF = eINSTANCE.getMQQueueManager_WhatIf();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerUnitImpl <em>MQ Queue Manager Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueManagerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueManagerUnit()
		 * @generated
		 */
		EClass MQ_QUEUE_MANAGER_UNIT = eINSTANCE.getMQQueueManagerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQQueueUnitImpl <em>MQ Queue Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQQueueUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQQueueUnit()
		 * @generated
		 */
		EClass MQ_QUEUE_UNIT = eINSTANCE.getMQQueueUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl <em>MQ Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQRootImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQRoot()
		 * @generated
		 */
		EClass MQ_ROOT = eINSTANCE.getMQRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_ROOT__MIXED = eINSTANCE.getMQRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getMQRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getMQRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Activation Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_ACTIVATION_SPECIFICATION = eINSTANCE.getMQRoot_CapabilityMQActivationSpecification();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Base System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_BASE_SYSTEM = eINSTANCE.getMQRoot_CapabilityMQBaseSystem();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Connection Factories</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_CONNECTION_FACTORIES = eINSTANCE.getMQRoot_CapabilityMQConnectionFactories();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_DESTINATION = eINSTANCE.getMQRoot_CapabilityMQDestination();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Listener</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_LISTENER = eINSTANCE.getMQRoot_CapabilityMQListener();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Messaging Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_MESSAGING_PROVIDER = eINSTANCE.getMQRoot_CapabilityMQMessagingProvider();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Messeage Listerner Service Port</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_MESSEAGE_LISTERNER_SERVICE_PORT = eINSTANCE.getMQRoot_CapabilityMQMesseageListernerServicePort();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Queue</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_QUEUE = eINSTANCE.getMQRoot_CapabilityMQQueue();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Queue Channel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_QUEUE_CHANNEL = eINSTANCE.getMQRoot_CapabilityMQQueueChannel();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Queue Connection Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_QUEUE_CONNECTION_FACTORY = eINSTANCE.getMQRoot_CapabilityMQQueueConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Queue Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_QUEUE_DESTINATION = eINSTANCE.getMQRoot_CapabilityMQQueueDestination();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Queue Manager</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_QUEUE_MANAGER = eINSTANCE.getMQRoot_CapabilityMQQueueManager();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Topic Connection Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_TOPIC_CONNECTION_FACTORY = eINSTANCE.getMQRoot_CapabilityMQTopicConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Capability MQ Topic Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__CAPABILITY_MQ_TOPIC_DESTINATION = eINSTANCE.getMQRoot_CapabilityMQTopicDestination();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Activation Specification Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_ACTIVATION_SPECIFICATION_UNIT = eINSTANCE.getMQRoot_UnitMQActivationSpecificationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Base System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_BASE_SYSTEM_UNIT = eINSTANCE.getMQRoot_UnitMQBaseSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Connection Factories Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_CONNECTION_FACTORIES_UNIT = eINSTANCE.getMQRoot_UnitMQConnectionFactoriesUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Listener Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_LISTENER_UNIT = eINSTANCE.getMQRoot_UnitMQListenerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Message Listner Service Port Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_MESSAGE_LISTNER_SERVICE_PORT_UNIT = eINSTANCE.getMQRoot_UnitMQMessageListnerServicePortUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Messaging Provider Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_MESSAGING_PROVIDER_UNIT = eINSTANCE.getMQRoot_UnitMQMessagingProviderUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Queue Channel Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_QUEUE_CHANNEL_UNIT = eINSTANCE.getMQRoot_UnitMQQueueChannelUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Queue Connection Factory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_QUEUE_CONNECTION_FACTORY_UNIT = eINSTANCE.getMQRoot_UnitMQQueueConnectionFactoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Queue Destination Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_QUEUE_DESTINATION_UNIT = eINSTANCE.getMQRoot_UnitMQQueueDestinationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Queue Manager Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_QUEUE_MANAGER_UNIT = eINSTANCE.getMQRoot_UnitMQQueueManagerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Queue Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_QUEUE_UNIT = eINSTANCE.getMQRoot_UnitMQQueueUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Topic Connection Factory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_TOPIC_CONNECTION_FACTORY_UNIT = eINSTANCE.getMQRoot_UnitMQTopicConnectionFactoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit MQ Topic Destination Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MQ_ROOT__UNIT_MQ_TOPIC_DESTINATION_UNIT = eINSTANCE.getMQRoot_UnitMQTopicDestinationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl <em>MQ Topic Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicConnectionFactory()
		 * @generated
		 */
		EClass MQ_TOPIC_CONNECTION_FACTORY = eINSTANCE.getMQTopicConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Broker CC Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_CC_SUBSCRIPTION_QUEUE = eINSTANCE.getMQTopicConnectionFactory_BrokerCCSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Control Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_CONTROL_QUEUE = eINSTANCE.getMQTopicConnectionFactory_BrokerControlQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Message Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_MESSAGE_SELECTION = eINSTANCE.getMQTopicConnectionFactory_BrokerMessageSelection();

		/**
		 * The meta object literal for the '<em><b>Broker Publication Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_PUBLICATION_QUEUE = eINSTANCE.getMQTopicConnectionFactory_BrokerPublicationQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_QUEUE_MANAGER = eINSTANCE.getMQTopicConnectionFactory_BrokerQueueManager();

		/**
		 * The meta object literal for the '<em><b>Broker Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_SUBSCRIPTION_QUEUE = eINSTANCE.getMQTopicConnectionFactory_BrokerSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__BROKER_VERSION = eINSTANCE.getMQTopicConnectionFactory_BrokerVersion();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__CATEGORY = eINSTANCE.getMQTopicConnectionFactory_Category();

		/**
		 * The meta object literal for the '<em><b>CCSID Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__CCSID_ID = eINSTANCE.getMQTopicConnectionFactory_CCSIDId();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__CHANNEL = eINSTANCE.getMQTopicConnectionFactory_Channel();

		/**
		 * The meta object literal for the '<em><b>Client Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__CLIENT_ID = eINSTANCE.getMQTopicConnectionFactory_ClientId();

		/**
		 * The meta object literal for the '<em><b>Component Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__COMPONENT_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQTopicConnectionFactory_ComponentManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Container Managed Authentication Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__CONTAINER_MANAGED_AUTHENTICATION_ALIAS = eINSTANCE.getMQTopicConnectionFactory_ContainerManagedAuthenticationAlias();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__DESCRIPTION1 = eINSTANCE.getMQTopicConnectionFactory_Description1();

		/**
		 * The meta object literal for the '<em><b>Direct Broker Authorization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__DIRECT_BROKER_AUTHORIZATION = eINSTANCE.getMQTopicConnectionFactory_DirectBrokerAuthorization();

		/**
		 * The meta object literal for the '<em><b>Enable Clone Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__ENABLE_CLONE_SUPPORT = eINSTANCE.getMQTopicConnectionFactory_EnableCloneSupport();

		/**
		 * The meta object literal for the '<em><b>Enable MQ Connection Pooling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MQ_CONNECTION_POOLING = eINSTANCE.getMQTopicConnectionFactory_EnableMQConnectionPooling();

		/**
		 * The meta object literal for the '<em><b>Enable Multicast Transport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__ENABLE_MULTICAST_TRANSPORT = eINSTANCE.getMQTopicConnectionFactory_EnableMulticastTransport();

		/**
		 * The meta object literal for the '<em><b>Enable Return Methods During Shutdown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__ENABLE_RETURN_METHODS_DURING_SHUTDOWN = eINSTANCE.getMQTopicConnectionFactory_EnableReturnMethodsDuringShutdown();

		/**
		 * The meta object literal for the '<em><b>Factory Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__FACTORY_NAME = eINSTANCE.getMQTopicConnectionFactory_FactoryName();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__HOST = eINSTANCE.getMQTopicConnectionFactory_Host();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__JNDI_NAME = eINSTANCE.getMQTopicConnectionFactory_JndiName();

		/**
		 * The meta object literal for the '<em><b>Local Server Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__LOCAL_SERVER_ADDRESS = eINSTANCE.getMQTopicConnectionFactory_LocalServerAddress();

		/**
		 * The meta object literal for the '<em><b>Mapping Configuration Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__MAPPING_CONFIGURATION_ALIAS = eINSTANCE.getMQTopicConnectionFactory_MappingConfigurationAlias();

		/**
		 * The meta object literal for the '<em><b>Model Queue Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__MODEL_QUEUE_DEFINITION = eINSTANCE.getMQTopicConnectionFactory_ModelQueueDefinition();

		/**
		 * The meta object literal for the '<em><b>Persistent Subscription Store</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PERSISTENT_SUBSCRIPTION_STORE = eINSTANCE.getMQTopicConnectionFactory_PersistentSubscriptionStore();

		/**
		 * The meta object literal for the '<em><b>Polling Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__POLLING_INTERVAL = eINSTANCE.getMQTopicConnectionFactory_PollingInterval();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PORT = eINSTANCE.getMQTopicConnectionFactory_Port();

		/**
		 * The meta object literal for the '<em><b>Proxy Host Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PROXY_HOST_NAME = eINSTANCE.getMQTopicConnectionFactory_ProxyHostName();

		/**
		 * The meta object literal for the '<em><b>Proxy Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PROXY_PORT = eINSTANCE.getMQTopicConnectionFactory_ProxyPort();

		/**
		 * The meta object literal for the '<em><b>Publish And Acknowledge Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_ACKNOWLEDGE_LEVEL = eINSTANCE.getMQTopicConnectionFactory_PublishAndAcknowledgeLevel();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Cleanup Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_INTERVAL = eINSTANCE.getMQTopicConnectionFactory_PublishAndSubscribeCleanupInterval();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Cleanup Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_CLEANUP_LEVEL = eINSTANCE.getMQTopicConnectionFactory_PublishAndSubscribeCleanupLevel();

		/**
		 * The meta object literal for the '<em><b>Publish And Subscribe Status Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__PUBLISH_AND_SUBSCRIBE_STATUS_INTERVAL = eINSTANCE.getMQTopicConnectionFactory_PublishAndSubscribeStatusInterval();

		/**
		 * The meta object literal for the '<em><b>Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__QUEUE_MANAGER = eINSTANCE.getMQTopicConnectionFactory_QueueManager();

		/**
		 * The meta object literal for the '<em><b>Rescan Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__RESCAN_INTERVAL = eINSTANCE.getMQTopicConnectionFactory_RescanInterval();

		/**
		 * The meta object literal for the '<em><b>SSL Cipher Suite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__SSL_CIPHER_SUITE = eINSTANCE.getMQTopicConnectionFactory_SSLCipherSuite();

		/**
		 * The meta object literal for the '<em><b>SSLCRL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__SSLCRL = eINSTANCE.getMQTopicConnectionFactory_SSLCRL();

		/**
		 * The meta object literal for the '<em><b>SSL Peer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__SSL_PEER_NAME = eINSTANCE.getMQTopicConnectionFactory_SSLPeerName();

		/**
		 * The meta object literal for the '<em><b>Transport Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__TRANSPORT_TYPE = eINSTANCE.getMQTopicConnectionFactory_TransportType();

		/**
		 * The meta object literal for the '<em><b>XA Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_CONNECTION_FACTORY__XA_ENABLED = eINSTANCE.getMQTopicConnectionFactory_XAEnabled();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryUnitImpl <em>MQ Topic Connection Factory Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicConnectionFactoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicConnectionFactoryUnit()
		 * @generated
		 */
		EClass MQ_TOPIC_CONNECTION_FACTORY_UNIT = eINSTANCE.getMQTopicConnectionFactoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl <em>MQ Topic Destination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicDestination()
		 * @generated
		 */
		EClass MQ_TOPIC_DESTINATION = eINSTANCE.getMQTopicDestination();

		/**
		 * The meta object literal for the '<em><b>Base Topic Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__BASE_TOPIC_NAME = eINSTANCE.getMQTopicDestination_BaseTopicName();

		/**
		 * The meta object literal for the '<em><b>Broker CC Durable Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__BROKER_CC_DURABLE_SUBSCRIPTION_QUEUE = eINSTANCE.getMQTopicDestination_BrokerCCDurableSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Broker Durable Subscription Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__BROKER_DURABLE_SUBSCRIPTION_QUEUE = eINSTANCE.getMQTopicDestination_BrokerDurableSubscriptionQueue();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__CATEGORY = eINSTANCE.getMQTopicDestination_Category();

		/**
		 * The meta object literal for the '<em><b>Decimal Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__DECIMAL_ENCODING = eINSTANCE.getMQTopicDestination_DecimalEncoding();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__DESCRIPTION1 = eINSTANCE.getMQTopicDestination_Description1();

		/**
		 * The meta object literal for the '<em><b>Destination Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__DESTINATION_NAME = eINSTANCE.getMQTopicDestination_DestinationName();

		/**
		 * The meta object literal for the '<em><b>Enable Multicast Transport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__ENABLE_MULTICAST_TRANSPORT = eINSTANCE.getMQTopicDestination_EnableMulticastTransport();

		/**
		 * The meta object literal for the '<em><b>Expiry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__EXPIRY = eINSTANCE.getMQTopicDestination_Expiry();

		/**
		 * The meta object literal for the '<em><b>Floating Point Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__FLOATING_POINT_ENCODING = eINSTANCE.getMQTopicDestination_FloatingPointEncoding();

		/**
		 * The meta object literal for the '<em><b>Integer Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__INTEGER_ENCODING = eINSTANCE.getMQTopicDestination_IntegerEncoding();

		/**
		 * The meta object literal for the '<em><b>Jndi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__JNDI_NAME = eINSTANCE.getMQTopicDestination_JndiName();

		/**
		 * The meta object literal for the '<em><b>Persitence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__PERSITENCE = eINSTANCE.getMQTopicDestination_Persitence();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__PRIORITY = eINSTANCE.getMQTopicDestination_Priority();

		/**
		 * The meta object literal for the '<em><b>Specified Expiry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__SPECIFIED_EXPIRY = eINSTANCE.getMQTopicDestination_SpecifiedExpiry();

		/**
		 * The meta object literal for the '<em><b>Specified Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__SPECIFIED_PRIORITY = eINSTANCE.getMQTopicDestination_SpecifiedPriority();

		/**
		 * The meta object literal for the '<em><b>Target Client</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__TARGET_CLIENT = eINSTANCE.getMQTopicDestination_TargetClient();

		/**
		 * The meta object literal for the '<em><b>Use Native Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MQ_TOPIC_DESTINATION__USE_NATIVE_ENCODING = eINSTANCE.getMQTopicDestination_UseNativeEncoding();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationUnitImpl <em>MQ Topic Destination Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MQTopicDestinationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.mq.impl.MqPackageImpl#getMQTopicDestinationUnit()
		 * @generated
		 */
		EClass MQ_TOPIC_DESTINATION_UNIT = eINSTANCE.getMQTopicDestinationUnit();

	}

} //MqPackage
