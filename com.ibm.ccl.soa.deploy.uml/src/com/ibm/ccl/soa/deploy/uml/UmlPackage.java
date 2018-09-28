/**
 * <copyright> </copyright>
 * 
 * $Id: UmlPackage.java,v 1.13 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * The Topology Definition Model (TDM) defines a core set of concepts to describe Enterprise
 * Architectures from the Software Applications down to the hardware requirements. The model is
 * inherently extensible, allowing technology specific domains to define their own types. At a high
 * level, the model is orgainzed into {@link Topology topologies}, which contain {@link Unit}s. A
 * Unit contain {@link Capability capabilities}, {@Requirement requirements}, and four types of
 * links ({@link DependencyLink  dependency links}, {@link HostingLink  hosting links},
 * {@link ConstraintLink  constraint links}, {@link MemberLink  member links}. In addition, the
 * model defines the notion of {@link Constraint constraints} which can be added to Units or
 * Contraint Links in order to describe requirements on target application or environment.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.uml.UmlFactory
 * @model kind="package"
 * @generated
 */
public interface UmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uml"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/uml/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uml"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	UmlPackage eINSTANCE = com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementCapabilityImpl <em>UML Element Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLElementCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLElementCapability()
	 * @generated
	 */
	int UML_ELEMENT_CAPABILITY = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ANNOTATIONS = CorePackage.BUNDLE_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ATTRIBUTE_META_DATA = CorePackage.BUNDLE_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__EXTENDED_ATTRIBUTES = CorePackage.BUNDLE_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ARTIFACT_GROUP = CorePackage.BUNDLE_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ARTIFACTS = CorePackage.BUNDLE_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__CONSTRAINT_GROUP = CorePackage.BUNDLE_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__CONSTRAINTS = CorePackage.BUNDLE_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__DESCRIPTION = CorePackage.BUNDLE_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__DISPLAY_NAME = CorePackage.BUNDLE_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__MUTABLE = CorePackage.BUNDLE_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__NAME = CorePackage.BUNDLE_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__STEREOTYPES = CorePackage.BUNDLE_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__BUILD_VERSION = CorePackage.BUNDLE_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__LINK_TYPE = CorePackage.BUNDLE_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ORIGIN = CorePackage.BUNDLE_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__ID = CorePackage.BUNDLE_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__VERSION = CorePackage.BUNDLE_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Uml Visibility Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND = CorePackage.BUNDLE_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UML Element Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_CAPABILITY_FEATURE_COUNT = CorePackage.BUNDLE_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLActorImpl <em>UML Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLActorImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLActor()
	 * @generated
	 */
	int UML_ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ANNOTATIONS = UML_ELEMENT_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ATTRIBUTE_META_DATA = UML_ELEMENT_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__EXTENDED_ATTRIBUTES = UML_ELEMENT_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ARTIFACT_GROUP = UML_ELEMENT_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ARTIFACTS = UML_ELEMENT_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__CONSTRAINT_GROUP = UML_ELEMENT_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__CONSTRAINTS = UML_ELEMENT_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__DESCRIPTION = UML_ELEMENT_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__DISPLAY_NAME = UML_ELEMENT_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__MUTABLE = UML_ELEMENT_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__NAME = UML_ELEMENT_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__STEREOTYPES = UML_ELEMENT_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__BUILD_VERSION = UML_ELEMENT_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__LINK_TYPE = UML_ELEMENT_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ORIGIN = UML_ELEMENT_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ID = UML_ELEMENT_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__VERSION = UML_ELEMENT_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Uml Visibility Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__UML_VISIBILITY_KIND = UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__ABSTRACT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR__LEAF = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_FEATURE_COUNT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLActorUnitImpl <em>UML Actor Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLActorUnitImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLActorUnit()
	 * @generated
	 */
	int UML_ACTOR_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__ANNOTATIONS = CorePackage.BASE_COMPONENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__ATTRIBUTE_META_DATA = CorePackage.BASE_COMPONENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__EXTENDED_ATTRIBUTES = CorePackage.BASE_COMPONENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__ARTIFACT_GROUP = CorePackage.BASE_COMPONENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__ARTIFACTS = CorePackage.BASE_COMPONENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CONSTRAINT_GROUP = CorePackage.BASE_COMPONENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CONSTRAINTS = CorePackage.BASE_COMPONENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__DESCRIPTION = CorePackage.BASE_COMPONENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__DISPLAY_NAME = CorePackage.BASE_COMPONENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__MUTABLE = CorePackage.BASE_COMPONENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__NAME = CorePackage.BASE_COMPONENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CAPABILITY_GROUP = CorePackage.BASE_COMPONENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CAPABILITIES = CorePackage.BASE_COMPONENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__REQUIREMENT_GROUP = CorePackage.BASE_COMPONENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__REQUIREMENTS = CorePackage.BASE_COMPONENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__UNIT_LINKS_GROUP = CorePackage.BASE_COMPONENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__UNIT_LINKS = CorePackage.BASE_COMPONENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CONSTRAINT_LINKS = CorePackage.BASE_COMPONENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__REALIZATION_LINKS = CorePackage.BASE_COMPONENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__STEREOTYPES = CorePackage.BASE_COMPONENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__BUILD_VERSION = CorePackage.BASE_COMPONENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CONCEPTUAL = CorePackage.BASE_COMPONENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__CONFIGURATION_UNIT = CorePackage.BASE_COMPONENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__GOAL_INSTALL_STATE = CorePackage.BASE_COMPONENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__INIT_INSTALL_STATE = CorePackage.BASE_COMPONENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__ORIGIN = CorePackage.BASE_COMPONENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT__PUBLISH_INTENT = CorePackage.BASE_COMPONENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>UML Actor Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ACTOR_UNIT_FEATURE_COUNT = CorePackage.BASE_COMPONENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLComponentImpl <em>UML Component</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLComponentImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLComponent()
	 * @generated
	 */
	int UML_COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ANNOTATIONS = UML_ELEMENT_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ATTRIBUTE_META_DATA = UML_ELEMENT_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__EXTENDED_ATTRIBUTES = UML_ELEMENT_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ARTIFACT_GROUP = UML_ELEMENT_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ARTIFACTS = UML_ELEMENT_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__CONSTRAINT_GROUP = UML_ELEMENT_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__CONSTRAINTS = UML_ELEMENT_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__DESCRIPTION = UML_ELEMENT_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__DISPLAY_NAME = UML_ELEMENT_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__MUTABLE = UML_ELEMENT_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__NAME = UML_ELEMENT_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__STEREOTYPES = UML_ELEMENT_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__BUILD_VERSION = UML_ELEMENT_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__LINK_TYPE = UML_ELEMENT_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ORIGIN = UML_ELEMENT_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ID = UML_ELEMENT_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__VERSION = UML_ELEMENT_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Uml Visibility Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__UML_VISIBILITY_KIND = UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__ABSTRACT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT__LEAF = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Component</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_COMPONENT_FEATURE_COUNT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl <em>UML Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLDeployRoot()
	 * @generated
	 */
	int UML_DEPLOY_ROOT = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Artifact Uml Element</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Capability Uml Actor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR = 4;

	/**
	 * The feature id for the '<em><b>Capability Uml Component</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT = 5;

	/**
	 * The feature id for the '<em><b>Capability Uml Interface</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Capability Uml Package Cap</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP = 7;

	/**
	 * The feature id for the '<em><b>Constraint Uml Interaction</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION = 8;

	/**
	 * The feature id for the '<em><b>Unit Uml Actor Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Unit Uml Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Unit Uml Package Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT = 11;

	/**
	 * The number of structural features of the '<em>UML Deploy Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_DEPLOY_ROOT_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl <em>UML Element Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLElementArtifact()
	 * @generated
	 */
	int UML_ELEMENT_ARTIFACT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__ANNOTATIONS = CorePackage.ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__ATTRIBUTE_META_DATA = CorePackage.ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__EXTENDED_ATTRIBUTES = CorePackage.ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__ARTIFACT_GROUP = CorePackage.ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__ARTIFACTS = CorePackage.ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__CONSTRAINT_GROUP = CorePackage.ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__CONSTRAINTS = CorePackage.ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__DESCRIPTION = CorePackage.ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__DISPLAY_NAME = CorePackage.ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__MUTABLE = CorePackage.ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__NAME = CorePackage.ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__QUALIFIED_NAME = CorePackage.ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT__RESOURCE_URI = CorePackage.ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Element Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_ELEMENT_ARTIFACT_FEATURE_COUNT = CorePackage.ARTIFACT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl <em>UML Interaction Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInteractionConstraint()
	 * @generated
	 */
	int UML_INTERACTION_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Interaction QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT__RESOURCE_URI = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Interaction Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERACTION_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceImpl <em>UML Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInterface()
	 * @generated
	 */
	int UML_INTERFACE = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ANNOTATIONS = UML_ELEMENT_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ATTRIBUTE_META_DATA = UML_ELEMENT_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__EXTENDED_ATTRIBUTES = UML_ELEMENT_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ARTIFACT_GROUP = UML_ELEMENT_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ARTIFACTS = UML_ELEMENT_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__CONSTRAINT_GROUP = UML_ELEMENT_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__CONSTRAINTS = UML_ELEMENT_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__DESCRIPTION = UML_ELEMENT_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__DISPLAY_NAME = UML_ELEMENT_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__MUTABLE = UML_ELEMENT_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__NAME = UML_ELEMENT_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__STEREOTYPES = UML_ELEMENT_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__BUILD_VERSION = UML_ELEMENT_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__LINK_TYPE = UML_ELEMENT_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ORIGIN = UML_ELEMENT_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ID = UML_ELEMENT_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__VERSION = UML_ELEMENT_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Uml Visibility Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__UML_VISIBILITY_KIND = UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__ABSTRACT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE__LEAF = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Interface</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_FEATURE_COUNT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceUnitImpl <em>UML Interface Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInterfaceUnit()
	 * @generated
	 */
	int UML_INTERFACE_UNIT = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>UML Interface Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_INTERFACE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLPackageCapImpl <em>UML Package Cap</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLPackageCapImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLPackageCap()
	 * @generated
	 */
	int UML_PACKAGE_CAP = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ANNOTATIONS = UML_ELEMENT_CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ATTRIBUTE_META_DATA = UML_ELEMENT_CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__EXTENDED_ATTRIBUTES = UML_ELEMENT_CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ARTIFACT_GROUP = UML_ELEMENT_CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ARTIFACTS = UML_ELEMENT_CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__CONSTRAINT_GROUP = UML_ELEMENT_CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__CONSTRAINTS = UML_ELEMENT_CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__DESCRIPTION = UML_ELEMENT_CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__DISPLAY_NAME = UML_ELEMENT_CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__MUTABLE = UML_ELEMENT_CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__NAME = UML_ELEMENT_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__STEREOTYPES = UML_ELEMENT_CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__BUILD_VERSION = UML_ELEMENT_CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__LINK_TYPE = UML_ELEMENT_CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ORIGIN = UML_ELEMENT_CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__ID = UML_ELEMENT_CAPABILITY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__VERSION = UML_ELEMENT_CAPABILITY__VERSION;

	/**
	 * The feature id for the '<em><b>Uml Visibility Kind</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__UML_VISIBILITY_KIND = UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND;

	/**
	 * The feature id for the '<em><b>Canonical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP__CANONICAL = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UML Package Cap</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_CAP_FEATURE_COUNT = UML_ELEMENT_CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLPackageUnitImpl <em>UML Package Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLPackageUnitImpl
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLPackageUnit()
	 * @generated
	 */
	int UML_PACKAGE_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>UML Package Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_PACKAGE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind <em>UML Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLVisibilityKind()
	 * @generated
	 */
	int UML_VISIBILITY_KIND = 11;

	/**
	 * The meta object id for the '<em>UML Visibility Kind Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLVisibilityKindObject()
	 * @generated
	 */
	int UML_VISIBILITY_KIND_OBJECT = 12;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLActor <em>UML Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Actor</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActor
	 * @generated
	 */
	EClass getUMLActor();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract()
	 * @see #getUMLActor()
	 * @generated
	 */
	EAttribute getUMLActor_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf()
	 * @see #getUMLActor()
	 * @generated
	 */
	EAttribute getUMLActor_Leaf();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLActorUnit <em>UML Actor Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Actor Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActorUnit
	 * @generated
	 */
	EClass getUMLActorUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLComponent <em>UML Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLComponent
	 * @generated
	 */
	EClass getUMLComponent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLComponent#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLComponent#isAbstract()
	 * @see #getUMLComponent()
	 * @generated
	 */
	EAttribute getUMLComponent_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLComponent#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLComponent#isLeaf()
	 * @see #getUMLComponent()
	 * @generated
	 */
	EAttribute getUMLComponent_Leaf();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot <em>UML Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot
	 * @generated
	 */
	EClass getUMLDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getMixed()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EAttribute getUMLDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXMLNSPrefixMap()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXSISchemaLocation()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getArtifactUmlElement <em>Artifact Uml Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact Uml Element</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getArtifactUmlElement()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_ArtifactUmlElement();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlActor <em>Capability Uml Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Uml Actor</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlActor()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_CapabilityUmlActor();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlComponent <em>Capability Uml Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Uml Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlComponent()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_CapabilityUmlComponent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlInterface <em>Capability Uml Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Uml Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlInterface()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_CapabilityUmlInterface();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlPackageCap <em>Capability Uml Package Cap</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Uml Package Cap</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlPackageCap()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_CapabilityUmlPackageCap();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getConstraintUmlInteraction <em>Constraint Uml Interaction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Uml Interaction</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getConstraintUmlInteraction()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_ConstraintUmlInteraction();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlActorUnit <em>Unit Uml Actor Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Uml Actor Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlActorUnit()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_UnitUmlActorUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlInterfaceUnit <em>Unit Uml Interface Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Uml Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlInterfaceUnit()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_UnitUmlInterfaceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlPackageUnit <em>Unit Uml Package Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Uml Package Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlPackageUnit()
	 * @see #getUMLDeployRoot()
	 * @generated
	 */
	EReference getUMLDeployRoot_UnitUmlPackageUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact <em>UML Element Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Element Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementArtifact
	 * @generated
	 */
	EClass getUMLElementArtifact();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getQualifiedName()
	 * @see #getUMLElementArtifact()
	 * @generated
	 */
	EAttribute getUMLElementArtifact_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getResourceURI <em>Resource URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getResourceURI()
	 * @see #getUMLElementArtifact()
	 * @generated
	 */
	EAttribute getUMLElementArtifact_ResourceURI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability <em>UML Element Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Element Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementCapability
	 * @generated
	 */
	EClass getUMLElementCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind <em>Uml Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uml Visibility Kind</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind()
	 * @see #getUMLElementCapability()
	 * @generated
	 */
	EAttribute getUMLElementCapability_UmlVisibilityKind();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint <em>UML Interaction Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Interaction Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint
	 * @generated
	 */
	EClass getUMLInteractionConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getInteractionQName <em>Interaction QName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interaction QName</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getInteractionQName()
	 * @see #getUMLInteractionConstraint()
	 * @generated
	 */
	EAttribute getUMLInteractionConstraint_InteractionQName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getResourceURI <em>Resource URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getResourceURI()
	 * @see #getUMLInteractionConstraint()
	 * @generated
	 */
	EAttribute getUMLInteractionConstraint_ResourceURI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLInterface <em>UML Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterface
	 * @generated
	 */
	EClass getUMLInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLInterface#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterface#isAbstract()
	 * @see #getUMLInterface()
	 * @generated
	 */
	EAttribute getUMLInterface_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLInterface#isLeaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Leaf</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterface#isLeaf()
	 * @see #getUMLInterface()
	 * @generated
	 */
	EAttribute getUMLInterface_Leaf();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit <em>UML Interface Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit
	 * @generated
	 */
	EClass getUMLInterfaceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap <em>UML Package Cap</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Package Cap</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLPackageCap
	 * @generated
	 */
	EClass getUMLPackageCap();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical <em>Canonical</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Canonical</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical()
	 * @see #getUMLPackageCap()
	 * @generated
	 */
	EAttribute getUMLPackageCap_Canonical();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageUnit <em>UML Package Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Package Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLPackageUnit
	 * @generated
	 */
	EClass getUMLPackageUnit();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind <em>UML Visibility Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>UML Visibility Kind</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @generated
	 */
	EEnum getUMLVisibilityKind();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind <em>UML Visibility Kind Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UML Visibility Kind Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @model instanceClass="com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind"
	 *        extendedMetaData="name='UMLVisibilityKind:Object' baseType='UMLVisibilityKind'"
	 * @generated
	 */
	EDataType getUMLVisibilityKindObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlFactory getUmlFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLActorImpl <em>UML Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLActorImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLActor()
		 * @generated
		 */
		EClass UML_ACTOR = eINSTANCE.getUMLActor();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_ACTOR__ABSTRACT = eINSTANCE.getUMLActor_Abstract();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_ACTOR__LEAF = eINSTANCE.getUMLActor_Leaf();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLActorUnitImpl <em>UML Actor Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLActorUnitImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLActorUnit()
		 * @generated
		 */
		EClass UML_ACTOR_UNIT = eINSTANCE.getUMLActorUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLComponentImpl <em>UML Component</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLComponentImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLComponent()
		 * @generated
		 */
		EClass UML_COMPONENT = eINSTANCE.getUMLComponent();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_COMPONENT__ABSTRACT = eINSTANCE.getUMLComponent_Abstract();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_COMPONENT__LEAF = eINSTANCE.getUMLComponent_Leaf();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl <em>UML Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLDeployRoot()
		 * @generated
		 */
		EClass UML_DEPLOY_ROOT = eINSTANCE.getUMLDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_DEPLOY_ROOT__MIXED = eINSTANCE.getUMLDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getUMLDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getUMLDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Artifact Uml Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT = eINSTANCE.getUMLDeployRoot_ArtifactUmlElement();

		/**
		 * The meta object literal for the '<em><b>Capability Uml Actor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR = eINSTANCE.getUMLDeployRoot_CapabilityUmlActor();

		/**
		 * The meta object literal for the '<em><b>Capability Uml Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT = eINSTANCE.getUMLDeployRoot_CapabilityUmlComponent();

		/**
		 * The meta object literal for the '<em><b>Capability Uml Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE = eINSTANCE.getUMLDeployRoot_CapabilityUmlInterface();

		/**
		 * The meta object literal for the '<em><b>Capability Uml Package Cap</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP = eINSTANCE.getUMLDeployRoot_CapabilityUmlPackageCap();

		/**
		 * The meta object literal for the '<em><b>Constraint Uml Interaction</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION = eINSTANCE.getUMLDeployRoot_ConstraintUmlInteraction();

		/**
		 * The meta object literal for the '<em><b>Unit Uml Actor Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT = eINSTANCE.getUMLDeployRoot_UnitUmlActorUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Uml Interface Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT = eINSTANCE.getUMLDeployRoot_UnitUmlInterfaceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Uml Package Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT = eINSTANCE.getUMLDeployRoot_UnitUmlPackageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl <em>UML Element Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLElementArtifact()
		 * @generated
		 */
		EClass UML_ELEMENT_ARTIFACT = eINSTANCE.getUMLElementArtifact();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_ELEMENT_ARTIFACT__QUALIFIED_NAME = eINSTANCE.getUMLElementArtifact_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Resource URI</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_ELEMENT_ARTIFACT__RESOURCE_URI = eINSTANCE.getUMLElementArtifact_ResourceURI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementCapabilityImpl <em>UML Element Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLElementCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLElementCapability()
		 * @generated
		 */
		EClass UML_ELEMENT_CAPABILITY = eINSTANCE.getUMLElementCapability();

		/**
		 * The meta object literal for the '<em><b>Uml Visibility Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_ELEMENT_CAPABILITY__UML_VISIBILITY_KIND = eINSTANCE.getUMLElementCapability_UmlVisibilityKind();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl <em>UML Interaction Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInteractionConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInteractionConstraint()
		 * @generated
		 */
		EClass UML_INTERACTION_CONSTRAINT = eINSTANCE.getUMLInteractionConstraint();

		/**
		 * The meta object literal for the '<em><b>Interaction QName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_INTERACTION_CONSTRAINT__INTERACTION_QNAME = eINSTANCE.getUMLInteractionConstraint_InteractionQName();

		/**
		 * The meta object literal for the '<em><b>Resource URI</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_INTERACTION_CONSTRAINT__RESOURCE_URI = eINSTANCE.getUMLInteractionConstraint_ResourceURI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceImpl <em>UML Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInterface()
		 * @generated
		 */
		EClass UML_INTERFACE = eINSTANCE.getUMLInterface();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_INTERFACE__ABSTRACT = eINSTANCE.getUMLInterface_Abstract();

		/**
		 * The meta object literal for the '<em><b>Leaf</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_INTERFACE__LEAF = eINSTANCE.getUMLInterface_Leaf();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceUnitImpl <em>UML Interface Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLInterfaceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLInterfaceUnit()
		 * @generated
		 */
		EClass UML_INTERFACE_UNIT = eINSTANCE.getUMLInterfaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLPackageCapImpl <em>UML Package Cap</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLPackageCapImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLPackageCap()
		 * @generated
		 */
		EClass UML_PACKAGE_CAP = eINSTANCE.getUMLPackageCap();

		/**
		 * The meta object literal for the '<em><b>Canonical</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_PACKAGE_CAP__CANONICAL = eINSTANCE.getUMLPackageCap_Canonical();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.impl.UMLPackageUnitImpl <em>UML Package Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UMLPackageUnitImpl
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLPackageUnit()
		 * @generated
		 */
		EClass UML_PACKAGE_UNIT = eINSTANCE.getUMLPackageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind <em>UML Visibility Kind</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLVisibilityKind()
		 * @generated
		 */
		EEnum UML_VISIBILITY_KIND = eINSTANCE.getUMLVisibilityKind();

		/**
		 * The meta object literal for the '<em>UML Visibility Kind Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
		 * @see com.ibm.ccl.soa.deploy.uml.impl.UmlPackageImpl#getUMLVisibilityKindObject()
		 * @generated
		 */
		EDataType UML_VISIBILITY_KIND_OBJECT = eINSTANCE.getUMLVisibilityKindObject();

	}

} //UmlPackage
