/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca;

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
 * @see com.ibm.ccl.soa.deploy.sca.ScaFactory
 * @model kind="package"
 * @generated
 */
public interface ScaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sca"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/Zephyr/sca/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tds"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaPackage eINSTANCE = com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationImpl <em>Generic SCA Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getGenericSCAImplementation()
	 * @generated
	 */
	int GENERIC_SCA_IMPLEMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Generic SCA Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationUnitImpl <em>Generic SCA Implementation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getGenericSCAImplementationUnit()
	 * @generated
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Generic SCA Implementation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_SCA_IMPLEMENTATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCABindingImpl <em>SCA Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCABindingImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCABinding()
	 * @generated
	 */
	int SCA_BINDING = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING__URI = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SCA Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCABindingUnitImpl <em>SCA Binding Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCABindingUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCABindingUnit()
	 * @generated
	 */
	int SCA_BINDING_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Binding Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_BINDING_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAComponentImpl <em>SCA Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAComponentImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAComponent()
	 * @generated
	 */
	int SCA_COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Autowire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__AUTOWIRE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SCA Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAComponentUnitImpl <em>SCA Component Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAComponentUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAComponentUnit()
	 * @generated
	 */
	int SCA_COMPONENT_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Component Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_COMPONENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELImpl <em>SCA Implementation BPEL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationBPEL()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_BPEL = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__CLASS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCA Implementation BPEL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELUnitImpl <em>SCA Implementation BPEL Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationBPELUnit()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Implementation BPEL Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_BPEL_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeImpl <em>SCA Implementation Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationComposite()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_COMPOSITE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SCA Implementation Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeUnitImpl <em>SCA Implementation Composite Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCompositeUnit()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Implementation Composite Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_COMPOSITE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusImpl <em>SCA Implementation Cplusplus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCplusplus()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__CLASS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCA Implementation Cplusplus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusUnitImpl <em>SCA Implementation Cplusplus Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCplusplusUnit()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Implementation Cplusplus Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_CPLUSPLUS_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl <em>SCA Implementation Java</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationJava()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_JAVA = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__CLASS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCA Implementation Java</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaUnitImpl <em>SCA Implementation Java Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationJavaUnit()
	 * @generated
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Implementation Java Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_IMPLEMENTATION_JAVA_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl <em>SCA Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAInterface()
	 * @generated
	 */
	int SCA_INTERFACE = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Call Back Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__CALL_BACK_INTERFACE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conversational</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__CONVERSATIONAL = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__INTERFACE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SCA Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceUnitImpl <em>SCA Interface Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAInterfaceUnit()
	 * @generated
	 */
	int SCA_INTERFACE_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Interface Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_INTERFACE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl <em>SCA Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAOperation()
	 * @generated
	 */
	int SCA_OPERATION = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__POLICY_SETS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION__REQUIRES = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCA Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationUnitImpl <em>SCA Operation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAOperationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAOperationUnit()
	 * @generated
	 */
	int SCA_OPERATION_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Operation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_OPERATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentImpl <em>SCA Policy Intent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicyIntent()
	 * @generated
	 */
	int SCA_POLICY_INTENT = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCA Policy Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentUnitImpl <em>SCA Policy Intent Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicyIntentUnit()
	 * @generated
	 */
	int SCA_POLICY_INTENT_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Policy Intent Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_INTENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetImpl <em>SCA Policy Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicySet()
	 * @generated
	 */
	int SCA_POLICY_SET = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCA Policy Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetUnitImpl <em>SCA Policy Set Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicySetUnit()
	 * @generated
	 */
	int SCA_POLICY_SET_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Policy Set Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_POLICY_SET_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl <em>SCA Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAProperty()
	 * @generated
	 */
	int SCA_PROPERTY = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__ELEMENT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__MANY = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Must Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__MUST_SUPPLY = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY__VALUE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SCA Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyUnitImpl <em>SCA Property Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPropertyUnit()
	 * @generated
	 */
	int SCA_PROPERTY_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Property Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl <em>Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getScaPropertyValue()
	 * @generated
	 */
	int SCA_PROPERTY_VALUE = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__ELEMENT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__FILE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__MANY = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Must Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__MUST_SUPPLY = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__SOURCE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyValueUnitImpl <em>SCA Property Value Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyValueUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPropertyValueUnit()
	 * @generated
	 */
	int SCA_PROPERTY_VALUE_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT__NAME1 = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCA Property Value Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_PROPERTY_VALUE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl <em>SCA Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAReference()
	 * @generated
	 */
	int SCA_REFERENCE = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Autowire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__AUTOWIRE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__MULTIPLICITY = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wired By Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE__WIRED_BY_IMPL = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SCA Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceUnitImpl <em>SCA Reference Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAReferenceUnit()
	 * @generated
	 */
	int SCA_REFERENCE_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Reference Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_REFERENCE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl <em>SCA Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCARoot()
	 * @generated
	 */
	int SCA_ROOT = 28;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Generic SCA Implementation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION = 3;

	/**
	 * The feature id for the '<em><b>Capability SCA Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_BINDING = 4;

	/**
	 * The feature id for the '<em><b>Capability Sca Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_COMPONENT = 5;

	/**
	 * The feature id for the '<em><b>Capability SCA Implementation BPEL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL = 6;

	/**
	 * The feature id for the '<em><b>Capability SCA Implementation Composite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE = 7;

	/**
	 * The feature id for the '<em><b>Capability SCA Implementation Cplusplus</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS = 8;

	/**
	 * The feature id for the '<em><b>Capability SCA Implementation Java</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA = 9;

	/**
	 * The feature id for the '<em><b>Capability SCA Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_INTERFACE = 10;

	/**
	 * The feature id for the '<em><b>Capability SCA Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Capability SCA Policy Intent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT = 12;

	/**
	 * The feature id for the '<em><b>Capability SCA Policy Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_POLICY_SET = 13;

	/**
	 * The feature id for the '<em><b>Capability Sca Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_PROPERTY = 14;

	/**
	 * The feature id for the '<em><b>Capability Sca Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Capability SCA Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_REFERENCE = 16;

	/**
	 * The feature id for the '<em><b>Capability Sca Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__CAPABILITY_SCA_SERVICE = 17;

	/**
	 * The feature id for the '<em><b>Unit Genericsca Implementation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Unit SCA Binding Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_BINDING_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Unit Sca Component Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_COMPONENT_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Unit SCA Implementation BPEL Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Unit SCA Implementation Composite Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Unit SCA Implementation Cplusplus Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Unit SCA Implementation Java Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT = 24;

	/**
	 * The feature id for the '<em><b>Unit SCA Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_INTERFACE_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Unit SCA Operation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_OPERATION_UNIT = 26;

	/**
	 * The feature id for the '<em><b>Unit SCA Policy Intent Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Unit SCA Policy Set Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT = 28;

	/**
	 * The feature id for the '<em><b>Unit Sca Property Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_PROPERTY_UNIT = 29;

	/**
	 * The feature id for the '<em><b>Unit Sca Property Value Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT = 30;

	/**
	 * The feature id for the '<em><b>Unit SCA Reference Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_REFERENCE_UNIT = 31;

	/**
	 * The feature id for the '<em><b>Unit Sca Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT__UNIT_SCA_SERVICE_UNIT = 32;

	/**
	 * The number of structural features of the '<em>SCA Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_ROOT_FEATURE_COUNT = 33;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAServiceImpl <em>SCA Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAServiceImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAService()
	 * @generated
	 */
	int SCA_SERVICE = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCA Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAServiceUnitImpl <em>SCA Service Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAServiceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAServiceUnit()
	 * @generated
	 */
	int SCA_SERVICE_UNIT = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SCA Service Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_SERVICE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation <em>Generic SCA Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic SCA Implementation</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation
	 * @generated
	 */
	EClass getGenericSCAImplementation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getName1()
	 * @see #getGenericSCAImplementation()
	 * @generated
	 */
	EAttribute getGenericSCAImplementation_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getPolicySets()
	 * @see #getGenericSCAImplementation()
	 * @generated
	 */
	EAttribute getGenericSCAImplementation_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getRequires()
	 * @see #getGenericSCAImplementation()
	 * @generated
	 */
	EAttribute getGenericSCAImplementation_Requires();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getType()
	 * @see #getGenericSCAImplementation()
	 * @generated
	 */
	EAttribute getGenericSCAImplementation_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit <em>Generic SCA Implementation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic SCA Implementation Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit
	 * @generated
	 */
	EClass getGenericSCAImplementationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCABinding <em>SCA Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Binding</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABinding
	 * @generated
	 */
	EClass getSCABinding();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCABinding#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABinding#getName1()
	 * @see #getSCABinding()
	 * @generated
	 */
	EAttribute getSCABinding_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCABinding#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABinding#getURI()
	 * @see #getSCABinding()
	 * @generated
	 */
	EAttribute getSCABinding_URI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCABindingUnit <em>SCA Binding Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Binding Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABindingUnit
	 * @generated
	 */
	EClass getSCABindingUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent <em>SCA Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponent
	 * @generated
	 */
	EClass getSCAComponent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getAutowire <em>Autowire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autowire</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponent#getAutowire()
	 * @see #getSCAComponent()
	 * @generated
	 */
	EAttribute getSCAComponent_Autowire();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponent#getName1()
	 * @see #getSCAComponent()
	 * @generated
	 */
	EAttribute getSCAComponent_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAComponentUnit <em>SCA Component Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Component Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponentUnit
	 * @generated
	 */
	EClass getSCAComponentUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL <em>SCA Implementation BPEL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation BPEL</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL
	 * @generated
	 */
	EClass getSCAImplementationBPEL();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getClass_()
	 * @see #getSCAImplementationBPEL()
	 * @generated
	 */
	EAttribute getSCAImplementationBPEL_Class();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getPolicySets()
	 * @see #getSCAImplementationBPEL()
	 * @generated
	 */
	EAttribute getSCAImplementationBPEL_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL#getRequires()
	 * @see #getSCAImplementationBPEL()
	 * @generated
	 */
	EAttribute getSCAImplementationBPEL_Requires();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit <em>SCA Implementation BPEL Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation BPEL Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit
	 * @generated
	 */
	EClass getSCAImplementationBPELUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite <em>SCA Implementation Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Composite</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite
	 * @generated
	 */
	EClass getSCAImplementationComposite();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getName1()
	 * @see #getSCAImplementationComposite()
	 * @generated
	 */
	EAttribute getSCAImplementationComposite_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getPolicySets()
	 * @see #getSCAImplementationComposite()
	 * @generated
	 */
	EAttribute getSCAImplementationComposite_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getRequires()
	 * @see #getSCAImplementationComposite()
	 * @generated
	 */
	EAttribute getSCAImplementationComposite_Requires();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite#getType()
	 * @see #getSCAImplementationComposite()
	 * @generated
	 */
	EAttribute getSCAImplementationComposite_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit <em>SCA Implementation Composite Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Composite Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit
	 * @generated
	 */
	EClass getSCAImplementationCompositeUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus <em>SCA Implementation Cplusplus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Cplusplus</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus
	 * @generated
	 */
	EClass getSCAImplementationCplusplus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getClass_()
	 * @see #getSCAImplementationCplusplus()
	 * @generated
	 */
	EAttribute getSCAImplementationCplusplus_Class();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getPolicySets()
	 * @see #getSCAImplementationCplusplus()
	 * @generated
	 */
	EAttribute getSCAImplementationCplusplus_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getRequires()
	 * @see #getSCAImplementationCplusplus()
	 * @generated
	 */
	EAttribute getSCAImplementationCplusplus_Requires();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit <em>SCA Implementation Cplusplus Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Cplusplus Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit
	 * @generated
	 */
	EClass getSCAImplementationCplusplusUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJava <em>SCA Implementation Java</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Java</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJava
	 * @generated
	 */
	EClass getSCAImplementationJava();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getClass_()
	 * @see #getSCAImplementationJava()
	 * @generated
	 */
	EAttribute getSCAImplementationJava_Class();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getPolicySets()
	 * @see #getSCAImplementationJava()
	 * @generated
	 */
	EAttribute getSCAImplementationJava_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJava#getRequires()
	 * @see #getSCAImplementationJava()
	 * @generated
	 */
	EAttribute getSCAImplementationJava_Requires();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit <em>SCA Implementation Java Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Implementation Java Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit
	 * @generated
	 */
	EClass getSCAImplementationJavaUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface <em>SCA Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface
	 * @generated
	 */
	EClass getSCAInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getCallBackInterface <em>Call Back Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Call Back Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface#getCallBackInterface()
	 * @see #getSCAInterface()
	 * @generated
	 */
	EAttribute getSCAInterface_CallBackInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getConversational <em>Conversational</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conversational</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface#getConversational()
	 * @see #getSCAInterface()
	 * @generated
	 */
	EAttribute getSCAInterface_Conversational();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface#getInterface()
	 * @see #getSCAInterface()
	 * @generated
	 */
	EAttribute getSCAInterface_Interface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface#getName1()
	 * @see #getSCAInterface()
	 * @generated
	 */
	EAttribute getSCAInterface_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit <em>SCA Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit
	 * @generated
	 */
	EClass getSCAInterfaceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAOperation <em>SCA Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Operation</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperation
	 * @generated
	 */
	EClass getSCAOperation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAOperation#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperation#getName1()
	 * @see #getSCAOperation()
	 * @generated
	 */
	EAttribute getSCAOperation_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAOperation#getPolicySets <em>Policy Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Sets</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperation#getPolicySets()
	 * @see #getSCAOperation()
	 * @generated
	 */
	EAttribute getSCAOperation_PolicySets();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAOperation#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperation#getRequires()
	 * @see #getSCAOperation()
	 * @generated
	 */
	EAttribute getSCAOperation_Requires();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAOperationUnit <em>SCA Operation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Operation Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperationUnit
	 * @generated
	 */
	EClass getSCAOperationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent <em>SCA Policy Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Policy Intent</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent
	 * @generated
	 */
	EClass getSCAPolicyIntent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent#getName1()
	 * @see #getSCAPolicyIntent()
	 * @generated
	 */
	EAttribute getSCAPolicyIntent_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit <em>SCA Policy Intent Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Policy Intent Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit
	 * @generated
	 */
	EClass getSCAPolicyIntentUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicySet <em>SCA Policy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Policy Set</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicySet
	 * @generated
	 */
	EClass getSCAPolicySet();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicySet#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicySet#getName1()
	 * @see #getSCAPolicySet()
	 * @generated
	 */
	EAttribute getSCAPolicySet_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit <em>SCA Policy Set Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Policy Set Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit
	 * @generated
	 */
	EClass getSCAPolicySetUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty <em>SCA Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Property</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty
	 * @generated
	 */
	EClass getSCAProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty#getElement()
	 * @see #getSCAProperty()
	 * @generated
	 */
	EAttribute getSCAProperty_Element();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty#getMany()
	 * @see #getSCAProperty()
	 * @generated
	 */
	EAttribute getSCAProperty_Many();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMustSupply <em>Must Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Supply</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty#getMustSupply()
	 * @see #getSCAProperty()
	 * @generated
	 */
	EAttribute getSCAProperty_MustSupply();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty#getName1()
	 * @see #getSCAProperty()
	 * @generated
	 */
	EAttribute getSCAProperty_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty#getValue()
	 * @see #getSCAProperty()
	 * @generated
	 */
	EAttribute getSCAProperty_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit <em>SCA Property Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Property Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit
	 * @generated
	 */
	EClass getSCAPropertyUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue
	 * @generated
	 */
	EClass getScaPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getElement()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_Element();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getFile()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_File();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMany()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_Many();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMustSupply <em>Must Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Supply</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMustSupply()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_MustSupply();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getName1()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getSource()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_Source();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getType()
	 * @see #getScaPropertyValue()
	 * @generated
	 */
	EAttribute getScaPropertyValue_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit <em>SCA Property Value Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Property Value Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit
	 * @generated
	 */
	EClass getSCAPropertyValueUnit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit#getName1()
	 * @see #getSCAPropertyValueUnit()
	 * @generated
	 */
	EAttribute getSCAPropertyValueUnit_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAReference <em>SCA Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Reference</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference
	 * @generated
	 */
	EClass getSCAReference();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAReference#getAutowire <em>Autowire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autowire</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference#getAutowire()
	 * @see #getSCAReference()
	 * @generated
	 */
	EAttribute getSCAReference_Autowire();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAReference#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference#getMultiplicity()
	 * @see #getSCAReference()
	 * @generated
	 */
	EAttribute getSCAReference_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAReference#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference#getName1()
	 * @see #getSCAReference()
	 * @generated
	 */
	EAttribute getSCAReference_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAReference#getWiredByImpl <em>Wired By Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wired By Impl</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference#getWiredByImpl()
	 * @see #getSCAReference()
	 * @generated
	 */
	EAttribute getSCAReference_WiredByImpl();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit <em>SCA Reference Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Reference Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit
	 * @generated
	 */
	EClass getSCAReferenceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCARoot <em>SCA Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot
	 * @generated
	 */
	EClass getSCARoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getMixed()
	 * @see #getSCARoot()
	 * @generated
	 */
	EAttribute getSCARoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getXMLNSPrefixMap()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getXSISchemaLocation()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityGenericSCAImplementation <em>Capability Generic SCA Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Generic SCA Implementation</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityGenericSCAImplementation()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilityGenericSCAImplementation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCABinding <em>Capability SCA Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Binding</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCABinding()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCABinding();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaComponent <em>Capability Sca Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Sca Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaComponent()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilityScaComponent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationBPEL <em>Capability SCA Implementation BPEL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Implementation BPEL</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationBPEL()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAImplementationBPEL();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationComposite <em>Capability SCA Implementation Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Implementation Composite</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationComposite()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAImplementationComposite();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationCplusplus <em>Capability SCA Implementation Cplusplus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Implementation Cplusplus</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationCplusplus()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAImplementationCplusplus();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationJava <em>Capability SCA Implementation Java</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Implementation Java</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationJava()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAImplementationJava();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAInterface <em>Capability SCA Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAInterface()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAInterface();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAOperation <em>Capability SCA Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Operation</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAOperation()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAOperation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicyIntent <em>Capability SCA Policy Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Policy Intent</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicyIntent()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAPolicyIntent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicySet <em>Capability SCA Policy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Policy Set</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicySet()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAPolicySet();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaProperty <em>Capability Sca Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Sca Property</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaProperty()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilityScaProperty();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaPropertyValue <em>Capability Sca Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Sca Property Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaPropertyValue()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilityScaPropertyValue();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAReference <em>Capability SCA Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Reference</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAReference()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilitySCAReference();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaService <em>Capability Sca Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Sca Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaService()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_CapabilityScaService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitGenericscaImplementationUnit <em>Unit Genericsca Implementation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Genericsca Implementation Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitGenericscaImplementationUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitGenericscaImplementationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCABindingUnit <em>Unit SCA Binding Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Binding Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCABindingUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCABindingUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaComponentUnit <em>Unit Sca Component Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Sca Component Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaComponentUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitScaComponentUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationBPELUnit <em>Unit SCA Implementation BPEL Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Implementation BPEL Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationBPELUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAImplementationBPELUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCompositeUnit <em>Unit SCA Implementation Composite Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Implementation Composite Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCompositeUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAImplementationCompositeUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCplusplusUnit <em>Unit SCA Implementation Cplusplus Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Implementation Cplusplus Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCplusplusUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAImplementationCplusplusUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationJavaUnit <em>Unit SCA Implementation Java Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Implementation Java Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationJavaUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAImplementationJavaUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAInterfaceUnit <em>Unit SCA Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAInterfaceUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAInterfaceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAOperationUnit <em>Unit SCA Operation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Operation Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAOperationUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAOperationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicyIntentUnit <em>Unit SCA Policy Intent Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Policy Intent Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicyIntentUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAPolicyIntentUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicySetUnit <em>Unit SCA Policy Set Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Policy Set Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicySetUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAPolicySetUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyUnit <em>Unit Sca Property Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Sca Property Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitScaPropertyUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyValueUnit <em>Unit Sca Property Value Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Sca Property Value Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyValueUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitScaPropertyValueUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAReferenceUnit <em>Unit SCA Reference Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SCA Reference Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAReferenceUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitSCAReferenceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaServiceUnit <em>Unit Sca Service Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Sca Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaServiceUnit()
	 * @see #getSCARoot()
	 * @generated
	 */
	EReference getSCARoot_UnitScaServiceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAService <em>SCA Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAService
	 * @generated
	 */
	EClass getSCAService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.sca.SCAService#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAService#getName1()
	 * @see #getSCAService()
	 * @generated
	 */
	EAttribute getSCAService_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.sca.SCAServiceUnit <em>SCA Service Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAServiceUnit
	 * @generated
	 */
	EClass getSCAServiceUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScaFactory getScaFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationImpl <em>Generic SCA Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getGenericSCAImplementation()
		 * @generated
		 */
		EClass GENERIC_SCA_IMPLEMENTATION = eINSTANCE.getGenericSCAImplementation();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_SCA_IMPLEMENTATION__NAME1 = eINSTANCE.getGenericSCAImplementation_Name1();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_SCA_IMPLEMENTATION__POLICY_SETS = eINSTANCE.getGenericSCAImplementation_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_SCA_IMPLEMENTATION__REQUIRES = eINSTANCE.getGenericSCAImplementation_Requires();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_SCA_IMPLEMENTATION__TYPE = eINSTANCE.getGenericSCAImplementation_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationUnitImpl <em>Generic SCA Implementation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.GenericSCAImplementationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getGenericSCAImplementationUnit()
		 * @generated
		 */
		EClass GENERIC_SCA_IMPLEMENTATION_UNIT = eINSTANCE.getGenericSCAImplementationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCABindingImpl <em>SCA Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCABindingImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCABinding()
		 * @generated
		 */
		EClass SCA_BINDING = eINSTANCE.getSCABinding();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_BINDING__NAME1 = eINSTANCE.getSCABinding_Name1();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_BINDING__URI = eINSTANCE.getSCABinding_URI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCABindingUnitImpl <em>SCA Binding Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCABindingUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCABindingUnit()
		 * @generated
		 */
		EClass SCA_BINDING_UNIT = eINSTANCE.getSCABindingUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAComponentImpl <em>SCA Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAComponentImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAComponent()
		 * @generated
		 */
		EClass SCA_COMPONENT = eINSTANCE.getSCAComponent();

		/**
		 * The meta object literal for the '<em><b>Autowire</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_COMPONENT__AUTOWIRE = eINSTANCE.getSCAComponent_Autowire();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_COMPONENT__NAME1 = eINSTANCE.getSCAComponent_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAComponentUnitImpl <em>SCA Component Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAComponentUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAComponentUnit()
		 * @generated
		 */
		EClass SCA_COMPONENT_UNIT = eINSTANCE.getSCAComponentUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELImpl <em>SCA Implementation BPEL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationBPEL()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_BPEL = eINSTANCE.getSCAImplementationBPEL();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_BPEL__CLASS = eINSTANCE.getSCAImplementationBPEL_Class();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_BPEL__POLICY_SETS = eINSTANCE.getSCAImplementationBPEL_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_BPEL__REQUIRES = eINSTANCE.getSCAImplementationBPEL_Requires();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELUnitImpl <em>SCA Implementation BPEL Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationBPELUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationBPELUnit()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_BPEL_UNIT = eINSTANCE.getSCAImplementationBPELUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeImpl <em>SCA Implementation Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationComposite()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_COMPOSITE = eINSTANCE.getSCAImplementationComposite();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_COMPOSITE__NAME1 = eINSTANCE.getSCAImplementationComposite_Name1();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_COMPOSITE__POLICY_SETS = eINSTANCE.getSCAImplementationComposite_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_COMPOSITE__REQUIRES = eINSTANCE.getSCAImplementationComposite_Requires();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_COMPOSITE__TYPE = eINSTANCE.getSCAImplementationComposite_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeUnitImpl <em>SCA Implementation Composite Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCompositeUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCompositeUnit()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_COMPOSITE_UNIT = eINSTANCE.getSCAImplementationCompositeUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusImpl <em>SCA Implementation Cplusplus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCplusplus()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_CPLUSPLUS = eINSTANCE.getSCAImplementationCplusplus();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_CPLUSPLUS__CLASS = eINSTANCE.getSCAImplementationCplusplus_Class();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_CPLUSPLUS__POLICY_SETS = eINSTANCE.getSCAImplementationCplusplus_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_CPLUSPLUS__REQUIRES = eINSTANCE.getSCAImplementationCplusplus_Requires();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusUnitImpl <em>SCA Implementation Cplusplus Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationCplusplusUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationCplusplusUnit()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_CPLUSPLUS_UNIT = eINSTANCE.getSCAImplementationCplusplusUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl <em>SCA Implementation Java</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationJava()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_JAVA = eINSTANCE.getSCAImplementationJava();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_JAVA__CLASS = eINSTANCE.getSCAImplementationJava_Class();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_JAVA__POLICY_SETS = eINSTANCE.getSCAImplementationJava_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_IMPLEMENTATION_JAVA__REQUIRES = eINSTANCE.getSCAImplementationJava_Requires();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaUnitImpl <em>SCA Implementation Java Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAImplementationJavaUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAImplementationJavaUnit()
		 * @generated
		 */
		EClass SCA_IMPLEMENTATION_JAVA_UNIT = eINSTANCE.getSCAImplementationJavaUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl <em>SCA Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAInterface()
		 * @generated
		 */
		EClass SCA_INTERFACE = eINSTANCE.getSCAInterface();

		/**
		 * The meta object literal for the '<em><b>Call Back Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_INTERFACE__CALL_BACK_INTERFACE = eINSTANCE.getSCAInterface_CallBackInterface();

		/**
		 * The meta object literal for the '<em><b>Conversational</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_INTERFACE__CONVERSATIONAL = eINSTANCE.getSCAInterface_Conversational();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_INTERFACE__INTERFACE = eINSTANCE.getSCAInterface_Interface();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_INTERFACE__NAME1 = eINSTANCE.getSCAInterface_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceUnitImpl <em>SCA Interface Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAInterfaceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAInterfaceUnit()
		 * @generated
		 */
		EClass SCA_INTERFACE_UNIT = eINSTANCE.getSCAInterfaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl <em>SCA Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAOperationImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAOperation()
		 * @generated
		 */
		EClass SCA_OPERATION = eINSTANCE.getSCAOperation();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_OPERATION__NAME1 = eINSTANCE.getSCAOperation_Name1();

		/**
		 * The meta object literal for the '<em><b>Policy Sets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_OPERATION__POLICY_SETS = eINSTANCE.getSCAOperation_PolicySets();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_OPERATION__REQUIRES = eINSTANCE.getSCAOperation_Requires();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAOperationUnitImpl <em>SCA Operation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAOperationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAOperationUnit()
		 * @generated
		 */
		EClass SCA_OPERATION_UNIT = eINSTANCE.getSCAOperationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentImpl <em>SCA Policy Intent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicyIntent()
		 * @generated
		 */
		EClass SCA_POLICY_INTENT = eINSTANCE.getSCAPolicyIntent();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_POLICY_INTENT__NAME1 = eINSTANCE.getSCAPolicyIntent_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentUnitImpl <em>SCA Policy Intent Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicyIntentUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicyIntentUnit()
		 * @generated
		 */
		EClass SCA_POLICY_INTENT_UNIT = eINSTANCE.getSCAPolicyIntentUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetImpl <em>SCA Policy Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicySet()
		 * @generated
		 */
		EClass SCA_POLICY_SET = eINSTANCE.getSCAPolicySet();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_POLICY_SET__NAME1 = eINSTANCE.getSCAPolicySet_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetUnitImpl <em>SCA Policy Set Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPolicySetUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPolicySetUnit()
		 * @generated
		 */
		EClass SCA_POLICY_SET_UNIT = eINSTANCE.getSCAPolicySetUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl <em>SCA Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAProperty()
		 * @generated
		 */
		EClass SCA_PROPERTY = eINSTANCE.getSCAProperty();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY__ELEMENT = eINSTANCE.getSCAProperty_Element();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY__MANY = eINSTANCE.getSCAProperty_Many();

		/**
		 * The meta object literal for the '<em><b>Must Supply</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY__MUST_SUPPLY = eINSTANCE.getSCAProperty_MustSupply();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY__NAME1 = eINSTANCE.getSCAProperty_Name1();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY__VALUE = eINSTANCE.getSCAProperty_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyUnitImpl <em>SCA Property Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPropertyUnit()
		 * @generated
		 */
		EClass SCA_PROPERTY_UNIT = eINSTANCE.getSCAPropertyUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl <em>Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getScaPropertyValue()
		 * @generated
		 */
		EClass SCA_PROPERTY_VALUE = eINSTANCE.getScaPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__ELEMENT = eINSTANCE.getScaPropertyValue_Element();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__FILE = eINSTANCE.getScaPropertyValue_File();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__MANY = eINSTANCE.getScaPropertyValue_Many();

		/**
		 * The meta object literal for the '<em><b>Must Supply</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__MUST_SUPPLY = eINSTANCE.getScaPropertyValue_MustSupply();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__NAME1 = eINSTANCE.getScaPropertyValue_Name1();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__SOURCE = eINSTANCE.getScaPropertyValue_Source();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE__TYPE = eINSTANCE.getScaPropertyValue_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyValueUnitImpl <em>SCA Property Value Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAPropertyValueUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAPropertyValueUnit()
		 * @generated
		 */
		EClass SCA_PROPERTY_VALUE_UNIT = eINSTANCE.getSCAPropertyValueUnit();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_PROPERTY_VALUE_UNIT__NAME1 = eINSTANCE.getSCAPropertyValueUnit_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl <em>SCA Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAReference()
		 * @generated
		 */
		EClass SCA_REFERENCE = eINSTANCE.getSCAReference();

		/**
		 * The meta object literal for the '<em><b>Autowire</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_REFERENCE__AUTOWIRE = eINSTANCE.getSCAReference_Autowire();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_REFERENCE__MULTIPLICITY = eINSTANCE.getSCAReference_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_REFERENCE__NAME1 = eINSTANCE.getSCAReference_Name1();

		/**
		 * The meta object literal for the '<em><b>Wired By Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_REFERENCE__WIRED_BY_IMPL = eINSTANCE.getSCAReference_WiredByImpl();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceUnitImpl <em>SCA Reference Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAReferenceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAReferenceUnit()
		 * @generated
		 */
		EClass SCA_REFERENCE_UNIT = eINSTANCE.getSCAReferenceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl <em>SCA Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCARoot()
		 * @generated
		 */
		EClass SCA_ROOT = eINSTANCE.getSCARoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_ROOT__MIXED = eINSTANCE.getSCARoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getSCARoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getSCARoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Generic SCA Implementation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION = eINSTANCE.getSCARoot_CapabilityGenericSCAImplementation();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_BINDING = eINSTANCE.getSCARoot_CapabilitySCABinding();

		/**
		 * The meta object literal for the '<em><b>Capability Sca Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_COMPONENT = eINSTANCE.getSCARoot_CapabilityScaComponent();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Implementation BPEL</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL = eINSTANCE.getSCARoot_CapabilitySCAImplementationBPEL();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Implementation Composite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE = eINSTANCE.getSCARoot_CapabilitySCAImplementationComposite();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Implementation Cplusplus</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS = eINSTANCE.getSCARoot_CapabilitySCAImplementationCplusplus();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Implementation Java</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA = eINSTANCE.getSCARoot_CapabilitySCAImplementationJava();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_INTERFACE = eINSTANCE.getSCARoot_CapabilitySCAInterface();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_OPERATION = eINSTANCE.getSCARoot_CapabilitySCAOperation();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Policy Intent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT = eINSTANCE.getSCARoot_CapabilitySCAPolicyIntent();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Policy Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_POLICY_SET = eINSTANCE.getSCARoot_CapabilitySCAPolicySet();

		/**
		 * The meta object literal for the '<em><b>Capability Sca Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_PROPERTY = eINSTANCE.getSCARoot_CapabilityScaProperty();

		/**
		 * The meta object literal for the '<em><b>Capability Sca Property Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE = eINSTANCE.getSCARoot_CapabilityScaPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_REFERENCE = eINSTANCE.getSCARoot_CapabilitySCAReference();

		/**
		 * The meta object literal for the '<em><b>Capability Sca Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__CAPABILITY_SCA_SERVICE = eINSTANCE.getSCARoot_CapabilityScaService();

		/**
		 * The meta object literal for the '<em><b>Unit Genericsca Implementation Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT = eINSTANCE.getSCARoot_UnitGenericscaImplementationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Binding Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_BINDING_UNIT = eINSTANCE.getSCARoot_UnitSCABindingUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Sca Component Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_COMPONENT_UNIT = eINSTANCE.getSCARoot_UnitScaComponentUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Implementation BPEL Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT = eINSTANCE.getSCARoot_UnitSCAImplementationBPELUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Implementation Composite Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT = eINSTANCE.getSCARoot_UnitSCAImplementationCompositeUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Implementation Cplusplus Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT = eINSTANCE.getSCARoot_UnitSCAImplementationCplusplusUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Implementation Java Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT = eINSTANCE.getSCARoot_UnitSCAImplementationJavaUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Interface Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_INTERFACE_UNIT = eINSTANCE.getSCARoot_UnitSCAInterfaceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Operation Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_OPERATION_UNIT = eINSTANCE.getSCARoot_UnitSCAOperationUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Policy Intent Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT = eINSTANCE.getSCARoot_UnitSCAPolicyIntentUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Policy Set Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT = eINSTANCE.getSCARoot_UnitSCAPolicySetUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Sca Property Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_PROPERTY_UNIT = eINSTANCE.getSCARoot_UnitScaPropertyUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Sca Property Value Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT = eINSTANCE.getSCARoot_UnitScaPropertyValueUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SCA Reference Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_REFERENCE_UNIT = eINSTANCE.getSCARoot_UnitSCAReferenceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Sca Service Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCA_ROOT__UNIT_SCA_SERVICE_UNIT = eINSTANCE.getSCARoot_UnitScaServiceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAServiceImpl <em>SCA Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAServiceImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAService()
		 * @generated
		 */
		EClass SCA_SERVICE = eINSTANCE.getSCAService();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_SERVICE__NAME1 = eINSTANCE.getSCAService_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.sca.impl.SCAServiceUnitImpl <em>SCA Service Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.sca.impl.SCAServiceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.sca.impl.ScaPackageImpl#getSCAServiceUnit()
		 * @generated
		 */
		EClass SCA_SERVICE_UNIT = eINSTANCE.getSCAServiceUnit();

	}

} //ScaPackage
