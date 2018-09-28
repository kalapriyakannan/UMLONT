/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high;

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
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highFactory
 * @model kind="package"
 * @generated
 */
public interface Db2highPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "db2high"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/Zephyr/db2high/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "db2high"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Db2highPackage eINSTANCE = com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl <em>DB2 Buffer Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2BufferPool()
	 * @generated
	 */
	int DB2_BUFFER_POOL = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Immediate Or Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__PAGE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL__SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>DB2 Buffer Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolUnitImpl <em>DB2 Buffer Pool Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2BufferPoolUnit()
	 * @generated
	 */
	int DB2_BUFFER_POOL_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Buffer Pool Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_BUFFER_POOL_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintImpl <em>DB2 Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Constraint()
	 * @generated
	 */
	int DB2_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT__VALUE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintUnitImpl <em>DB2 Constraint Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2ConstraintUnit()
	 * @generated
	 */
	int DB2_CONSTRAINT_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Constraint Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_CONSTRAINT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldImpl <em>DB2 Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Field()
	 * @generated
	 */
	int DB2_FIELD = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Null Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__NULL_ALLOWED = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>DB2 Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldUnitImpl <em>DB2 Field Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2FieldUnit()
	 * @generated
	 */
	int DB2_FIELD_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Field Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_FIELD_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl <em>DB2 High Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2HighRoot()
	 * @generated
	 */
	int DB2_HIGH_ROOT = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability DB2 Buffer Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL = 3;

	/**
	 * The feature id for the '<em><b>Capability DB2 Partition Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Capability DB2 Table Space</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE = 5;

	/**
	 * The feature id for the '<em><b>Capaility DB2 Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER = 6;

	/**
	 * The feature id for the '<em><b>Unit DB2 Buffer Pool Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Unit DB2 Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Unit DB2 Constraint Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Unit DB2 Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_FIELD = 10;

	/**
	 * The feature id for the '<em><b>Unit DB2 Field Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Unit DB2 Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_INDEX = 12;

	/**
	 * The feature id for the '<em><b>Unit DB2 Index Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Unit DB2 Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Unit DB2 Partition Group Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Unit DB2 Permission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_PERMISSION = 16;

	/**
	 * The feature id for the '<em><b>Unit DB2 Permission Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Unit DB2 Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_TABLE = 18;

	/**
	 * The feature id for the '<em><b>Unit DB2 Table Space Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Unit DB2 Table Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Unit DB2 User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_USER = 21;

	/**
	 * The feature id for the '<em><b>Unit DB2 User Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT = 22;

	/**
	 * The number of structural features of the '<em>DB2 High Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_HIGH_ROOT_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexImpl <em>DB2 Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Index()
	 * @generated
	 */
	int DB2_INDEX = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__FIELD = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexUnitImpl <em>DB2 Index Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2IndexUnit()
	 * @generated
	 */
	int DB2_INDEX_UNIT = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Index Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_INDEX_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl <em>DB2 Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Manager()
	 * @generated
	 */
	int DB2_MANAGER = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Agent Pool Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AGENT_POOL_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Agent Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AGENT_PRIORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Agent Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AGENT_STACK_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Application Support Layer Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Audit Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AUDIT_BUFFER_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Authentication Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AUTHENTICATION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Authentication Type For Incoming Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Bypass Federated Authentication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Cataloging Allowed Without Authority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Client IO Block Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CLIENT_IO_BLOCK_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Client Kerberos Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CLIENT_KERBEROS_PLUGIN = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Client Userid Password Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Communications Bandwidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__COMMUNICATIONS_BANDWIDTH = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Configuration File Release Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Connection Elapse Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CONNECTION_ELAPSE_TIME = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>CPU Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__CPU_SPEED = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Database System Monitor Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Default Charge Back Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Default Database Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DEFAULT_DATABASE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Default Database System Monitor Switches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Diagnostic Data Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Diagnostic Error Capture Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Directory Cache Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DIRECTORY_CACHE_SUPPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Discover Server Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DISCOVER_SERVER_INSTANCE = CorePackage.CAPABILITY_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Discovery Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__DISCOVERY_MODE = CorePackage.CAPABILITY_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Enable Pntrapartition Parallelism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM = CorePackage.CAPABILITY_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Federated Database System Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT = CorePackage.CAPABILITY_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Group Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__GROUP_PLUGIN = CorePackage.CAPABILITY_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Health Monitoring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__HEALTH_MONITORING = CorePackage.CAPABILITY_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Index Recreation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__INDEX_RECREATION_TIME = CorePackage.CAPABILITY_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Initial Number Of Agents In Pool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL = CorePackage.CAPABILITY_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Initial Number Of Fenced Processes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES = CorePackage.CAPABILITY_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Instance Impact Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__INSTANCE_IMPACT_POLICY = CorePackage.CAPABILITY_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Instance Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__INSTANCE_MEMORY = CorePackage.CAPABILITY_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Keep Fenced Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__KEEP_FENCED_PROCESS = CorePackage.CAPABILITY_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>List Of GSSAPI Plugins For Incoming Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Local GSSAPI Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__LOCAL_GSSAPI_PLUGIN = CorePackage.CAPABILITY_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Machine Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MACHINE_NODE_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Maximum Asynchronous TQs Per Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY = CorePackage.CAPABILITY_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Maximum Java Interpreter Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Client Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Concurrent Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Concurrently Active Databases</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES = CorePackage.CAPABILITY_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Coordinating Agents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 44;

	/**
	 * The feature id for the '<em><b>Maximum Number Of Fenced Processes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES = CorePackage.CAPABILITY_FEATURE_COUNT + 45;

	/**
	 * The feature id for the '<em><b>Maximum Query Degree Of Parallelism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM = CorePackage.CAPABILITY_FEATURE_COUNT + 46;

	/**
	 * The feature id for the '<em><b>Maximum Time Difference Among Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES = CorePackage.CAPABILITY_FEATURE_COUNT + 47;

	/**
	 * The feature id for the '<em><b>Node Connection Retries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__NODE_CONNECTION_RETRIES = CorePackage.CAPABILITY_FEATURE_COUNT + 48;

	/**
	 * The feature id for the '<em><b>Notify Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__NOTIFY_LEVEL = CorePackage.CAPABILITY_FEATURE_COUNT + 49;

	/**
	 * The feature id for the '<em><b>Number Of FCM Buffers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__NUMBER_OF_FCM_BUFFERS = CorePackage.CAPABILITY_FEATURE_COUNT + 50;

	/**
	 * The feature id for the '<em><b>Number Of FCM Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__NUMBER_OF_FCM_CHANNELS = CorePackage.CAPABILITY_FEATURE_COUNT + 51;

	/**
	 * The feature id for the '<em><b>Query Heap Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__QUERY_HEAP_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 52;

	/**
	 * The feature id for the '<em><b>Server Plugin Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SERVER_PLUGIN_MODE = CorePackage.CAPABILITY_FEATURE_COUNT + 53;

	/**
	 * The feature id for the '<em><b>Software Developers Kit For Java Installation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 54;

	/**
	 * The feature id for the '<em><b>Sort Heap Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SORT_HEAP_THRESHOLD = CorePackage.CAPABILITY_FEATURE_COUNT + 55;

	/**
	 * The feature id for the '<em><b>Start And Stop Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__START_AND_STOP_TIMEOUT = CorePackage.CAPABILITY_FEATURE_COUNT + 56;

	/**
	 * The feature id for the '<em><b>Sync Point Manager Log File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 57;

	/**
	 * The feature id for the '<em><b>Sync Point Manager Log File Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 58;

	/**
	 * The feature id for the '<em><b>Sync Point Manager Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYNC_POINT_MANAGER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 59;

	/**
	 * The feature id for the '<em><b>Sync Point Manager Resync Agent Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT = CorePackage.CAPABILITY_FEATURE_COUNT + 60;

	/**
	 * The feature id for the '<em><b>System Administration Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 61;

	/**
	 * The feature id for the '<em><b>System Control Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 62;

	/**
	 * The feature id for the '<em><b>System Maintenance Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 63;

	/**
	 * The feature id for the '<em><b>System Monitor Authority Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 64;

	/**
	 * The feature id for the '<em><b>TCPIP Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TCPIP_SERVICE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 65;

	/**
	 * The feature id for the '<em><b>Transaction Manager Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 66;

	/**
	 * The feature id for the '<em><b>Transaction Processor Monitor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 67;

	/**
	 * The feature id for the '<em><b>Transaction Resync Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL = CorePackage.CAPABILITY_FEATURE_COUNT + 68;

	/**
	 * The feature id for the '<em><b>Trust All Clients</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TRUST_ALL_CLIENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 69;

	/**
	 * The feature id for the '<em><b>Trusted Clients Authentication</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION = CorePackage.CAPABILITY_FEATURE_COUNT + 70;

	/**
	 * The feature id for the '<em><b>Userid Password Plug In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER__USERID_PASSWORD_PLUG_IN = CorePackage.CAPABILITY_FEATURE_COUNT + 71;

	/**
	 * The number of structural features of the '<em>DB2 Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 72;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerUnitImpl <em>DB2 Manager Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2ManagerUnit()
	 * @generated
	 */
	int DB2_MANAGER_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Manager Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_MANAGER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupImpl <em>DB2 Partition Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PartitionGroup()
	 * @generated
	 */
	int DB2_PARTITION_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DB2 Partition Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupUnitImpl <em>DB2 Partition Group Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PartitionGroupUnit()
	 * @generated
	 */
	int DB2_PARTITION_GROUP_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Partition Group Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PARTITION_GROUP_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionImpl <em>DB2 Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Permission()
	 * @generated
	 */
	int DB2_PERMISSION = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__OBJECT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionUnitImpl <em>DB2 Permission Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PermissionUnit()
	 * @generated
	 */
	int DB2_PERMISSION_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Permission Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_PERMISSION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl <em>DB2 Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Table()
	 * @generated
	 */
	int DB2_TABLE = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__ALIAS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Table Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__INDEX_TABLE_SPACE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partioning Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__PARTIONING_KEY = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Partioning Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE__PARTIONING_METHOD = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>DB2 Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl <em>DB2 Table Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableSpace()
	 * @generated
	 */
	int DB2_TABLE_SPACE = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Auto Resize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__AUTO_RESIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dropped Table Recovery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__EVENT_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__FILE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Increase Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__INCREASE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Managed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__MANAGED_BY = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__MAX_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__OVERHEAD = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__PAGE_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Prefetch Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__PREFETCH_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Transfer Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__TRANSFER_RATE = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>DB2 Table Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceUnitImpl <em>DB2 Table Space Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableSpaceUnit()
	 * @generated
	 */
	int DB2_TABLE_SPACE_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Table Space Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_SPACE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableUnitImpl <em>DB2 Table Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableUnit()
	 * @generated
	 */
	int DB2_TABLE_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 Table Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_TABLE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2UserImpl <em>DB2 User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2UserImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2User()
	 * @generated
	 */
	int DB2_USER = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER__PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DB2 User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2UserUnitImpl <em>DB2 User Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2UserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2UserUnit()
	 * @generated
	 */
	int DB2_USER_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>DB2 User Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB2_USER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool <em>DB2 Buffer Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Buffer Pool</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool
	 * @generated
	 */
	EClass getDB2BufferPool();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getImmediateOrDeferred <em>Immediate Or Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate Or Deferred</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getImmediateOrDeferred()
	 * @see #getDB2BufferPool()
	 * @generated
	 */
	EAttribute getDB2BufferPool_ImmediateOrDeferred();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getName1()
	 * @see #getDB2BufferPool()
	 * @generated
	 */
	EAttribute getDB2BufferPool_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getPageSize()
	 * @see #getDB2BufferPool()
	 * @generated
	 */
	EAttribute getDB2BufferPool_PageSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getSize()
	 * @see #getDB2BufferPool()
	 * @generated
	 */
	EAttribute getDB2BufferPool_Size();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit <em>DB2 Buffer Pool Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Buffer Pool Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit
	 * @generated
	 */
	EClass getDB2BufferPoolUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Constraint <em>DB2 Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Constraint
	 * @generated
	 */
	EClass getDB2Constraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Constraint#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Constraint#getName1()
	 * @see #getDB2Constraint()
	 * @generated
	 */
	EAttribute getDB2Constraint_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Constraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Constraint#getValue()
	 * @see #getDB2Constraint()
	 * @generated
	 */
	EAttribute getDB2Constraint_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit <em>DB2 Constraint Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Constraint Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit
	 * @generated
	 */
	EClass getDB2ConstraintUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Field <em>DB2 Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Field</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Field
	 * @generated
	 */
	EClass getDB2Field();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Field#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Field#getName1()
	 * @see #getDB2Field()
	 * @generated
	 */
	EAttribute getDB2Field_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Field#getNullAllowed <em>Null Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Allowed</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Field#getNullAllowed()
	 * @see #getDB2Field()
	 * @generated
	 */
	EAttribute getDB2Field_NullAllowed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Field#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Field#getType()
	 * @see #getDB2Field()
	 * @generated
	 */
	EAttribute getDB2Field_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit <em>DB2 Field Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Field Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit
	 * @generated
	 */
	EClass getDB2FieldUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot <em>DB2 High Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 High Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot
	 * @generated
	 */
	EClass getDB2HighRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getMixed()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EAttribute getDB2HighRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXMLNSPrefixMap()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXSISchemaLocation()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2BufferPool <em>Capability DB2 Buffer Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability DB2 Buffer Pool</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2BufferPool()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_CapabilityDB2BufferPool();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2PartitionGroup <em>Capability DB2 Partition Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability DB2 Partition Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2PartitionGroup()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_CapabilityDB2PartitionGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2TableSpace <em>Capability DB2 Table Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability DB2 Table Space</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2TableSpace()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_CapabilityDB2TableSpace();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapailityDB2Manager <em>Capaility DB2 Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capaility DB2 Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapailityDB2Manager()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_CapailityDB2Manager();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2BufferPoolUnit <em>Unit DB2 Buffer Pool Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Buffer Pool Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2BufferPoolUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2BufferPoolUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Constraint <em>Unit DB2 Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Constraint()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2Constraint();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ConstraintUnit <em>Unit DB2 Constraint Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Constraint Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ConstraintUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2ConstraintUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Field <em>Unit DB2 Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Field</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Field()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2Field();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2FieldUnit <em>Unit DB2 Field Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Field Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2FieldUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2FieldUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Index <em>Unit DB2 Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Index</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Index()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2Index();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2IndexUnit <em>Unit DB2 Index Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Index Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2IndexUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2IndexUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ManagerUnit <em>Unit DB2 Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ManagerUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2ManagerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PartitionGroupUnit <em>Unit DB2 Partition Group Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Partition Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PartitionGroupUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2PartitionGroupUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Permission <em>Unit DB2 Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Permission</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Permission()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2Permission();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PermissionUnit <em>Unit DB2 Permission Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Permission Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PermissionUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2PermissionUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Table <em>Unit DB2 Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Table</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Table()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2Table();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableSpaceUnit <em>Unit DB2 Table Space Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Table Space Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableSpaceUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2TableSpaceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableUnit <em>Unit DB2 Table Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 Table Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2TableUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2User <em>Unit DB2 User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 User</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2User()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2User();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2UserUnit <em>Unit DB2 User Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit DB2 User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2UserUnit()
	 * @see #getDB2HighRoot()
	 * @generated
	 */
	EReference getDB2HighRoot_UnitDB2UserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Index <em>DB2 Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Index</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Index
	 * @generated
	 */
	EClass getDB2Index();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Index#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Index#getField()
	 * @see #getDB2Index()
	 * @generated
	 */
	EAttribute getDB2Index_Field();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Index#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Index#getName1()
	 * @see #getDB2Index()
	 * @generated
	 */
	EAttribute getDB2Index_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit <em>DB2 Index Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Index Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit
	 * @generated
	 */
	EClass getDB2IndexUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager <em>DB2 Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager
	 * @generated
	 */
	EClass getDB2Manager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPoolSize <em>Agent Pool Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agent Pool Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPoolSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AgentPoolSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPriority <em>Agent Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agent Priority</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentPriority()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AgentPriority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentStackSize <em>Agent Stack Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agent Stack Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAgentStackSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AgentStackSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getApplicationSupportLayerHeapSize <em>Application Support Layer Heap Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Support Layer Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getApplicationSupportLayerHeapSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ApplicationSupportLayerHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuditBufferSize <em>Audit Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audit Buffer Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuditBufferSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AuditBufferSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationType <em>Authentication Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authentication Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationType()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AuthenticationType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationTypeForIncomingConnections <em>Authentication Type For Incoming Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authentication Type For Incoming Connections</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getAuthenticationTypeForIncomingConnections()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_AuthenticationTypeForIncomingConnections();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getBypassFederatedAuthentication <em>Bypass Federated Authentication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bypass Federated Authentication</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getBypassFederatedAuthentication()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_BypassFederatedAuthentication();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCatalogingAllowedWithoutAuthority <em>Cataloging Allowed Without Authority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cataloging Allowed Without Authority</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCatalogingAllowedWithoutAuthority()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_CatalogingAllowedWithoutAuthority();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientIOBlockSize <em>Client IO Block Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client IO Block Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientIOBlockSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ClientIOBlockSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientKerberosPlugin <em>Client Kerberos Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Kerberos Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientKerberosPlugin()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ClientKerberosPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientUseridPasswordPlugin <em>Client Userid Password Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Userid Password Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getClientUseridPasswordPlugin()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ClientUseridPasswordPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCommunicationsBandwidth <em>Communications Bandwidth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Communications Bandwidth</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCommunicationsBandwidth()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_CommunicationsBandwidth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConfigurationFileReleaseLevel <em>Configuration File Release Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration File Release Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConfigurationFileReleaseLevel()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ConfigurationFileReleaseLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConnectionElapseTime <em>Connection Elapse Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Elapse Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getConnectionElapseTime()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ConnectionElapseTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCPUSpeed <em>CPU Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CPU Speed</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getCPUSpeed()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_CPUSpeed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDatabaseSystemMonitorHeapSize <em>Database System Monitor Heap Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database System Monitor Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDatabaseSystemMonitorHeapSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DatabaseSystemMonitorHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultChargeBackAccount <em>Default Charge Back Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Charge Back Account</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultChargeBackAccount()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DefaultChargeBackAccount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabasePath <em>Default Database Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Database Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabasePath()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DefaultDatabasePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabaseSystemMonitorSwitches <em>Default Database System Monitor Switches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Database System Monitor Switches</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDefaultDatabaseSystemMonitorSwitches()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DefaultDatabaseSystemMonitorSwitches();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticDataDirectoryPath <em>Diagnostic Data Directory Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic Data Directory Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticDataDirectoryPath()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DiagnosticDataDirectoryPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticErrorCaptureLevel <em>Diagnostic Error Capture Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic Error Capture Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiagnosticErrorCaptureLevel()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DiagnosticErrorCaptureLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDirectoryCacheSupport <em>Directory Cache Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directory Cache Support</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDirectoryCacheSupport()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DirectoryCacheSupport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoverServerInstance <em>Discover Server Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discover Server Instance</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoverServerInstance()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DiscoverServerInstance();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoveryMode <em>Discovery Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discovery Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getDiscoveryMode()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_DiscoveryMode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getEnablePntrapartitionParallelism <em>Enable Pntrapartition Parallelism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Pntrapartition Parallelism</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getEnablePntrapartitionParallelism()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_EnablePntrapartitionParallelism();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getFederatedDatabaseSystemSupport <em>Federated Database System Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Federated Database System Support</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getFederatedDatabaseSystemSupport()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_FederatedDatabaseSystemSupport();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getGroupPlugin <em>Group Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getGroupPlugin()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_GroupPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getHealthMonitoring <em>Health Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Health Monitoring</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getHealthMonitoring()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_HealthMonitoring();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getIndexRecreationTime <em>Index Recreation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Recreation Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getIndexRecreationTime()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_IndexRecreationTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfAgentsInPool <em>Initial Number Of Agents In Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Number Of Agents In Pool</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfAgentsInPool()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_InitialNumberOfAgentsInPool();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfFencedProcesses <em>Initial Number Of Fenced Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Number Of Fenced Processes</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInitialNumberOfFencedProcesses()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_InitialNumberOfFencedProcesses();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceImpactPolicy <em>Instance Impact Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Impact Policy</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceImpactPolicy()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_InstanceImpactPolicy();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceMemory <em>Instance Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Memory</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getInstanceMemory()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_InstanceMemory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getKeepFencedProcess <em>Keep Fenced Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keep Fenced Process</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getKeepFencedProcess()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_KeepFencedProcess();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getListOfGSSAPIPluginsForIncomingConnections <em>List Of GSSAPI Plugins For Incoming Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List Of GSSAPI Plugins For Incoming Connections</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getListOfGSSAPIPluginsForIncomingConnections()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getLocalGSSAPIPlugin <em>Local GSSAPI Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local GSSAPI Plugin</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getLocalGSSAPIPlugin()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_LocalGSSAPIPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMachineNodeType <em>Machine Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Node Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMachineNodeType()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MachineNodeType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumAsynchronousTQsPerQuery <em>Maximum Asynchronous TQs Per Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Asynchronous TQs Per Query</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumAsynchronousTQsPerQuery()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumAsynchronousTQsPerQuery();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumJavaInterpreterHeapSize <em>Maximum Java Interpreter Heap Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Java Interpreter Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumJavaInterpreterHeapSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumJavaInterpreterHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfAgents <em>Maximum Number Of Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Agents</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfAgents()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfAgents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfClientConnections <em>Maximum Number Of Client Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Client Connections</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfClientConnections()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfClientConnections();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentAgents <em>Maximum Number Of Concurrent Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Concurrent Agents</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentAgents()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfConcurrentAgents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentlyActiveDatabases <em>Maximum Number Of Concurrently Active Databases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Concurrently Active Databases</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfConcurrentlyActiveDatabases()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfCoordinatingAgents <em>Maximum Number Of Coordinating Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Coordinating Agents</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfCoordinatingAgents()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfCoordinatingAgents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfFencedProcesses <em>Maximum Number Of Fenced Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Number Of Fenced Processes</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumNumberOfFencedProcesses()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumNumberOfFencedProcesses();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumQueryDegreeOfParallelism <em>Maximum Query Degree Of Parallelism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Query Degree Of Parallelism</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumQueryDegreeOfParallelism()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumQueryDegreeOfParallelism();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumTimeDifferenceAmongNodes <em>Maximum Time Difference Among Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Time Difference Among Nodes</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getMaximumTimeDifferenceAmongNodes()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_MaximumTimeDifferenceAmongNodes();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNodeConnectionRetries <em>Node Connection Retries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Connection Retries</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNodeConnectionRetries()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_NodeConnectionRetries();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNotifyLevel <em>Notify Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notify Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNotifyLevel()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_NotifyLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMBuffers <em>Number Of FCM Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of FCM Buffers</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMBuffers()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_NumberOfFCMBuffers();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMChannels <em>Number Of FCM Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of FCM Channels</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getNumberOfFCMChannels()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_NumberOfFCMChannels();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getQueryHeapSize <em>Query Heap Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Heap Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getQueryHeapSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_QueryHeapSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getServerPluginMode <em>Server Plugin Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Plugin Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getServerPluginMode()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_ServerPluginMode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSoftwareDevelopersKitForJavaInstallationPath <em>Software Developers Kit For Java Installation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Software Developers Kit For Java Installation Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSoftwareDevelopersKitForJavaInstallationPath()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSortHeapThreshold <em>Sort Heap Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sort Heap Threshold</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSortHeapThreshold()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SortHeapThreshold();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getStartAndStopTimeout <em>Start And Stop Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start And Stop Timeout</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getStartAndStopTimeout()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_StartAndStopTimeout();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFilePath <em>Sync Point Manager Log File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync Point Manager Log File Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFilePath()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SyncPointManagerLogFilePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFileSize <em>Sync Point Manager Log File Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync Point Manager Log File Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerLogFileSize()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SyncPointManagerLogFileSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerName <em>Sync Point Manager Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync Point Manager Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SyncPointManagerName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerResyncAgentLimit <em>Sync Point Manager Resync Agent Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync Point Manager Resync Agent Limit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSyncPointManagerResyncAgentLimit()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SyncPointManagerResyncAgentLimit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemAdministrationAuthorityGroupName <em>System Administration Authority Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Administration Authority Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemAdministrationAuthorityGroupName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SystemAdministrationAuthorityGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemControlAuthorityGroupName <em>System Control Authority Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Control Authority Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemControlAuthorityGroupName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SystemControlAuthorityGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMaintenanceAuthorityGroupName <em>System Maintenance Authority Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Maintenance Authority Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMaintenanceAuthorityGroupName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SystemMaintenanceAuthorityGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMonitorAuthorityGroupName <em>System Monitor Authority Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Monitor Authority Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getSystemMonitorAuthorityGroupName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_SystemMonitorAuthorityGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTCPIPServiceName <em>TCPIP Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCPIP Service Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTCPIPServiceName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TCPIPServiceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionManagerDatabaseName <em>Transaction Manager Database Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Manager Database Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionManagerDatabaseName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TransactionManagerDatabaseName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionProcessorMonitorName <em>Transaction Processor Monitor Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Processor Monitor Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionProcessorMonitorName()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TransactionProcessorMonitorName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionResyncInterval <em>Transaction Resync Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Resync Interval</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTransactionResyncInterval()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TransactionResyncInterval();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustAllClients <em>Trust All Clients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trust All Clients</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustAllClients()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TrustAllClients();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustedClientsAuthentication <em>Trusted Clients Authentication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trusted Clients Authentication</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getTrustedClientsAuthentication()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_TrustedClientsAuthentication();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager#getUseridPasswordPlugIn <em>Userid Password Plug In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Userid Password Plug In</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager#getUseridPasswordPlugIn()
	 * @see #getDB2Manager()
	 * @generated
	 */
	EAttribute getDB2Manager_UseridPasswordPlugIn();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit <em>DB2 Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit
	 * @generated
	 */
	EClass getDB2ManagerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup <em>DB2 Partition Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Partition Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup
	 * @generated
	 */
	EClass getDB2PartitionGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup#getName1()
	 * @see #getDB2PartitionGroup()
	 * @generated
	 */
	EAttribute getDB2PartitionGroup_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit <em>DB2 Partition Group Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Partition Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit
	 * @generated
	 */
	EClass getDB2PartitionGroupUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Permission <em>DB2 Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Permission</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Permission
	 * @generated
	 */
	EClass getDB2Permission();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Permission#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Permission#getObject()
	 * @see #getDB2Permission()
	 * @generated
	 */
	EAttribute getDB2Permission_Object();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Permission#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Permission#getType()
	 * @see #getDB2Permission()
	 * @generated
	 */
	EAttribute getDB2Permission_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit <em>DB2 Permission Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Permission Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit
	 * @generated
	 */
	EClass getDB2PermissionUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table <em>DB2 Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Table</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table
	 * @generated
	 */
	EClass getDB2Table();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table#getAlias()
	 * @see #getDB2Table()
	 * @generated
	 */
	EAttribute getDB2Table_Alias();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getIndexTableSpace <em>Index Table Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Table Space</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table#getIndexTableSpace()
	 * @see #getDB2Table()
	 * @generated
	 */
	EAttribute getDB2Table_IndexTableSpace();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table#getName1()
	 * @see #getDB2Table()
	 * @generated
	 */
	EAttribute getDB2Table_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningKey <em>Partioning Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partioning Key</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningKey()
	 * @see #getDB2Table()
	 * @generated
	 */
	EAttribute getDB2Table_PartioningKey();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningMethod <em>Partioning Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partioning Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningMethod()
	 * @see #getDB2Table()
	 * @generated
	 */
	EAttribute getDB2Table_PartioningMethod();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace <em>DB2 Table Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Table Space</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace
	 * @generated
	 */
	EClass getDB2TableSpace();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getAutoResize <em>Auto Resize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Resize</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getAutoResize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_AutoResize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getDroppedTableRecovery <em>Dropped Table Recovery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dropped Table Recovery</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getDroppedTableRecovery()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_DroppedTableRecovery();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getEventSize <em>Event Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getEventSize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_EventSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getFile()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_File();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getIncreaseSize <em>Increase Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Increase Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getIncreaseSize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_IncreaseSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getManagedBy <em>Managed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Managed By</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getManagedBy()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_ManagedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getMaxSize <em>Max Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getMaxSize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_MaxSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getName1()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getOverhead <em>Overhead</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overhead</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getOverhead()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_Overhead();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPageSize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_PageSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPrefetchSize <em>Prefetch Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefetch Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPrefetchSize()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_PrefetchSize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getTransferRate <em>Transfer Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transfer Rate</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getTransferRate()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_TransferRate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getType()
	 * @see #getDB2TableSpace()
	 * @generated
	 */
	EAttribute getDB2TableSpace_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit <em>DB2 Table Space Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Table Space Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit
	 * @generated
	 */
	EClass getDB2TableSpaceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableUnit <em>DB2 Table Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 Table Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableUnit
	 * @generated
	 */
	EClass getDB2TableUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2User <em>DB2 User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 User</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2User
	 * @generated
	 */
	EClass getDB2User();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2User#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2User#getName1()
	 * @see #getDB2User()
	 * @generated
	 */
	EAttribute getDB2User_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.db2high.DB2User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2User#getPassword()
	 * @see #getDB2User()
	 * @generated
	 */
	EAttribute getDB2User_Password();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.db2high.DB2UserUnit <em>DB2 User Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB2 User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2UserUnit
	 * @generated
	 */
	EClass getDB2UserUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Db2highFactory getDb2highFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl <em>DB2 Buffer Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2BufferPool()
		 * @generated
		 */
		EClass DB2_BUFFER_POOL = eINSTANCE.getDB2BufferPool();

		/**
		 * The meta object literal for the '<em><b>Immediate Or Deferred</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED = eINSTANCE.getDB2BufferPool_ImmediateOrDeferred();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_BUFFER_POOL__NAME1 = eINSTANCE.getDB2BufferPool_Name1();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_BUFFER_POOL__PAGE_SIZE = eINSTANCE.getDB2BufferPool_PageSize();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_BUFFER_POOL__SIZE = eINSTANCE.getDB2BufferPool_Size();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolUnitImpl <em>DB2 Buffer Pool Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2BufferPoolUnit()
		 * @generated
		 */
		EClass DB2_BUFFER_POOL_UNIT = eINSTANCE.getDB2BufferPoolUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintImpl <em>DB2 Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Constraint()
		 * @generated
		 */
		EClass DB2_CONSTRAINT = eINSTANCE.getDB2Constraint();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_CONSTRAINT__NAME1 = eINSTANCE.getDB2Constraint_Name1();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_CONSTRAINT__VALUE = eINSTANCE.getDB2Constraint_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintUnitImpl <em>DB2 Constraint Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ConstraintUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2ConstraintUnit()
		 * @generated
		 */
		EClass DB2_CONSTRAINT_UNIT = eINSTANCE.getDB2ConstraintUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldImpl <em>DB2 Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Field()
		 * @generated
		 */
		EClass DB2_FIELD = eINSTANCE.getDB2Field();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_FIELD__NAME1 = eINSTANCE.getDB2Field_Name1();

		/**
		 * The meta object literal for the '<em><b>Null Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_FIELD__NULL_ALLOWED = eINSTANCE.getDB2Field_NullAllowed();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_FIELD__TYPE = eINSTANCE.getDB2Field_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldUnitImpl <em>DB2 Field Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2FieldUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2FieldUnit()
		 * @generated
		 */
		EClass DB2_FIELD_UNIT = eINSTANCE.getDB2FieldUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl <em>DB2 High Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2HighRoot()
		 * @generated
		 */
		EClass DB2_HIGH_ROOT = eINSTANCE.getDB2HighRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_HIGH_ROOT__MIXED = eINSTANCE.getDB2HighRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDB2HighRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDB2HighRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability DB2 Buffer Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL = eINSTANCE.getDB2HighRoot_CapabilityDB2BufferPool();

		/**
		 * The meta object literal for the '<em><b>Capability DB2 Partition Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP = eINSTANCE.getDB2HighRoot_CapabilityDB2PartitionGroup();

		/**
		 * The meta object literal for the '<em><b>Capability DB2 Table Space</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE = eINSTANCE.getDB2HighRoot_CapabilityDB2TableSpace();

		/**
		 * The meta object literal for the '<em><b>Capaility DB2 Manager</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER = eINSTANCE.getDB2HighRoot_CapailityDB2Manager();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Buffer Pool Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2BufferPoolUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT = eINSTANCE.getDB2HighRoot_UnitDB2Constraint();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Constraint Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2ConstraintUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_FIELD = eINSTANCE.getDB2HighRoot_UnitDB2Field();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Field Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2FieldUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_INDEX = eINSTANCE.getDB2HighRoot_UnitDB2Index();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Index Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2IndexUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Manager Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2ManagerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Partition Group Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2PartitionGroupUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Permission</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_PERMISSION = eINSTANCE.getDB2HighRoot_UnitDB2Permission();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Permission Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2PermissionUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Table</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_TABLE = eINSTANCE.getDB2HighRoot_UnitDB2Table();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Table Space Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2TableSpaceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 Table Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2TableUnit();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_USER = eINSTANCE.getDB2HighRoot_UnitDB2User();

		/**
		 * The meta object literal for the '<em><b>Unit DB2 User Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT = eINSTANCE.getDB2HighRoot_UnitDB2UserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexImpl <em>DB2 Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Index()
		 * @generated
		 */
		EClass DB2_INDEX = eINSTANCE.getDB2Index();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_INDEX__FIELD = eINSTANCE.getDB2Index_Field();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_INDEX__NAME1 = eINSTANCE.getDB2Index_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexUnitImpl <em>DB2 Index Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2IndexUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2IndexUnit()
		 * @generated
		 */
		EClass DB2_INDEX_UNIT = eINSTANCE.getDB2IndexUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl <em>DB2 Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Manager()
		 * @generated
		 */
		EClass DB2_MANAGER = eINSTANCE.getDB2Manager();

		/**
		 * The meta object literal for the '<em><b>Agent Pool Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AGENT_POOL_SIZE = eINSTANCE.getDB2Manager_AgentPoolSize();

		/**
		 * The meta object literal for the '<em><b>Agent Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AGENT_PRIORITY = eINSTANCE.getDB2Manager_AgentPriority();

		/**
		 * The meta object literal for the '<em><b>Agent Stack Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AGENT_STACK_SIZE = eINSTANCE.getDB2Manager_AgentStackSize();

		/**
		 * The meta object literal for the '<em><b>Application Support Layer Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__APPLICATION_SUPPORT_LAYER_HEAP_SIZE = eINSTANCE.getDB2Manager_ApplicationSupportLayerHeapSize();

		/**
		 * The meta object literal for the '<em><b>Audit Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AUDIT_BUFFER_SIZE = eINSTANCE.getDB2Manager_AuditBufferSize();

		/**
		 * The meta object literal for the '<em><b>Authentication Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AUTHENTICATION_TYPE = eINSTANCE.getDB2Manager_AuthenticationType();

		/**
		 * The meta object literal for the '<em><b>Authentication Type For Incoming Connections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__AUTHENTICATION_TYPE_FOR_INCOMING_CONNECTIONS = eINSTANCE.getDB2Manager_AuthenticationTypeForIncomingConnections();

		/**
		 * The meta object literal for the '<em><b>Bypass Federated Authentication</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__BYPASS_FEDERATED_AUTHENTICATION = eINSTANCE.getDB2Manager_BypassFederatedAuthentication();

		/**
		 * The meta object literal for the '<em><b>Cataloging Allowed Without Authority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CATALOGING_ALLOWED_WITHOUT_AUTHORITY = eINSTANCE.getDB2Manager_CatalogingAllowedWithoutAuthority();

		/**
		 * The meta object literal for the '<em><b>Client IO Block Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CLIENT_IO_BLOCK_SIZE = eINSTANCE.getDB2Manager_ClientIOBlockSize();

		/**
		 * The meta object literal for the '<em><b>Client Kerberos Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CLIENT_KERBEROS_PLUGIN = eINSTANCE.getDB2Manager_ClientKerberosPlugin();

		/**
		 * The meta object literal for the '<em><b>Client Userid Password Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CLIENT_USERID_PASSWORD_PLUGIN = eINSTANCE.getDB2Manager_ClientUseridPasswordPlugin();

		/**
		 * The meta object literal for the '<em><b>Communications Bandwidth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__COMMUNICATIONS_BANDWIDTH = eINSTANCE.getDB2Manager_CommunicationsBandwidth();

		/**
		 * The meta object literal for the '<em><b>Configuration File Release Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CONFIGURATION_FILE_RELEASE_LEVEL = eINSTANCE.getDB2Manager_ConfigurationFileReleaseLevel();

		/**
		 * The meta object literal for the '<em><b>Connection Elapse Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CONNECTION_ELAPSE_TIME = eINSTANCE.getDB2Manager_ConnectionElapseTime();

		/**
		 * The meta object literal for the '<em><b>CPU Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__CPU_SPEED = eINSTANCE.getDB2Manager_CPUSpeed();

		/**
		 * The meta object literal for the '<em><b>Database System Monitor Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DATABASE_SYSTEM_MONITOR_HEAP_SIZE = eINSTANCE.getDB2Manager_DatabaseSystemMonitorHeapSize();

		/**
		 * The meta object literal for the '<em><b>Default Charge Back Account</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DEFAULT_CHARGE_BACK_ACCOUNT = eINSTANCE.getDB2Manager_DefaultChargeBackAccount();

		/**
		 * The meta object literal for the '<em><b>Default Database Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DEFAULT_DATABASE_PATH = eINSTANCE.getDB2Manager_DefaultDatabasePath();

		/**
		 * The meta object literal for the '<em><b>Default Database System Monitor Switches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DEFAULT_DATABASE_SYSTEM_MONITOR_SWITCHES = eINSTANCE.getDB2Manager_DefaultDatabaseSystemMonitorSwitches();

		/**
		 * The meta object literal for the '<em><b>Diagnostic Data Directory Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DIAGNOSTIC_DATA_DIRECTORY_PATH = eINSTANCE.getDB2Manager_DiagnosticDataDirectoryPath();

		/**
		 * The meta object literal for the '<em><b>Diagnostic Error Capture Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DIAGNOSTIC_ERROR_CAPTURE_LEVEL = eINSTANCE.getDB2Manager_DiagnosticErrorCaptureLevel();

		/**
		 * The meta object literal for the '<em><b>Directory Cache Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DIRECTORY_CACHE_SUPPORT = eINSTANCE.getDB2Manager_DirectoryCacheSupport();

		/**
		 * The meta object literal for the '<em><b>Discover Server Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DISCOVER_SERVER_INSTANCE = eINSTANCE.getDB2Manager_DiscoverServerInstance();

		/**
		 * The meta object literal for the '<em><b>Discovery Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__DISCOVERY_MODE = eINSTANCE.getDB2Manager_DiscoveryMode();

		/**
		 * The meta object literal for the '<em><b>Enable Pntrapartition Parallelism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__ENABLE_PNTRAPARTITION_PARALLELISM = eINSTANCE.getDB2Manager_EnablePntrapartitionParallelism();

		/**
		 * The meta object literal for the '<em><b>Federated Database System Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__FEDERATED_DATABASE_SYSTEM_SUPPORT = eINSTANCE.getDB2Manager_FederatedDatabaseSystemSupport();

		/**
		 * The meta object literal for the '<em><b>Group Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__GROUP_PLUGIN = eINSTANCE.getDB2Manager_GroupPlugin();

		/**
		 * The meta object literal for the '<em><b>Health Monitoring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__HEALTH_MONITORING = eINSTANCE.getDB2Manager_HealthMonitoring();

		/**
		 * The meta object literal for the '<em><b>Index Recreation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__INDEX_RECREATION_TIME = eINSTANCE.getDB2Manager_IndexRecreationTime();

		/**
		 * The meta object literal for the '<em><b>Initial Number Of Agents In Pool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__INITIAL_NUMBER_OF_AGENTS_IN_POOL = eINSTANCE.getDB2Manager_InitialNumberOfAgentsInPool();

		/**
		 * The meta object literal for the '<em><b>Initial Number Of Fenced Processes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__INITIAL_NUMBER_OF_FENCED_PROCESSES = eINSTANCE.getDB2Manager_InitialNumberOfFencedProcesses();

		/**
		 * The meta object literal for the '<em><b>Instance Impact Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__INSTANCE_IMPACT_POLICY = eINSTANCE.getDB2Manager_InstanceImpactPolicy();

		/**
		 * The meta object literal for the '<em><b>Instance Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__INSTANCE_MEMORY = eINSTANCE.getDB2Manager_InstanceMemory();

		/**
		 * The meta object literal for the '<em><b>Keep Fenced Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__KEEP_FENCED_PROCESS = eINSTANCE.getDB2Manager_KeepFencedProcess();

		/**
		 * The meta object literal for the '<em><b>List Of GSSAPI Plugins For Incoming Connections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__LIST_OF_GSSAPI_PLUGINS_FOR_INCOMING_CONNECTIONS = eINSTANCE.getDB2Manager_ListOfGSSAPIPluginsForIncomingConnections();

		/**
		 * The meta object literal for the '<em><b>Local GSSAPI Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__LOCAL_GSSAPI_PLUGIN = eINSTANCE.getDB2Manager_LocalGSSAPIPlugin();

		/**
		 * The meta object literal for the '<em><b>Machine Node Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MACHINE_NODE_TYPE = eINSTANCE.getDB2Manager_MachineNodeType();

		/**
		 * The meta object literal for the '<em><b>Maximum Asynchronous TQs Per Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_ASYNCHRONOUS_TQS_PER_QUERY = eINSTANCE.getDB2Manager_MaximumAsynchronousTQsPerQuery();

		/**
		 * The meta object literal for the '<em><b>Maximum Java Interpreter Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_JAVA_INTERPRETER_HEAP_SIZE = eINSTANCE.getDB2Manager_MaximumJavaInterpreterHeapSize();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Agents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_AGENTS = eINSTANCE.getDB2Manager_MaximumNumberOfAgents();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Client Connections</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_CLIENT_CONNECTIONS = eINSTANCE.getDB2Manager_MaximumNumberOfClientConnections();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Concurrent Agents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENT_AGENTS = eINSTANCE.getDB2Manager_MaximumNumberOfConcurrentAgents();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Concurrently Active Databases</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_CONCURRENTLY_ACTIVE_DATABASES = eINSTANCE.getDB2Manager_MaximumNumberOfConcurrentlyActiveDatabases();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Coordinating Agents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_COORDINATING_AGENTS = eINSTANCE.getDB2Manager_MaximumNumberOfCoordinatingAgents();

		/**
		 * The meta object literal for the '<em><b>Maximum Number Of Fenced Processes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_NUMBER_OF_FENCED_PROCESSES = eINSTANCE.getDB2Manager_MaximumNumberOfFencedProcesses();

		/**
		 * The meta object literal for the '<em><b>Maximum Query Degree Of Parallelism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_QUERY_DEGREE_OF_PARALLELISM = eINSTANCE.getDB2Manager_MaximumQueryDegreeOfParallelism();

		/**
		 * The meta object literal for the '<em><b>Maximum Time Difference Among Nodes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__MAXIMUM_TIME_DIFFERENCE_AMONG_NODES = eINSTANCE.getDB2Manager_MaximumTimeDifferenceAmongNodes();

		/**
		 * The meta object literal for the '<em><b>Node Connection Retries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__NODE_CONNECTION_RETRIES = eINSTANCE.getDB2Manager_NodeConnectionRetries();

		/**
		 * The meta object literal for the '<em><b>Notify Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__NOTIFY_LEVEL = eINSTANCE.getDB2Manager_NotifyLevel();

		/**
		 * The meta object literal for the '<em><b>Number Of FCM Buffers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__NUMBER_OF_FCM_BUFFERS = eINSTANCE.getDB2Manager_NumberOfFCMBuffers();

		/**
		 * The meta object literal for the '<em><b>Number Of FCM Channels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__NUMBER_OF_FCM_CHANNELS = eINSTANCE.getDB2Manager_NumberOfFCMChannels();

		/**
		 * The meta object literal for the '<em><b>Query Heap Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__QUERY_HEAP_SIZE = eINSTANCE.getDB2Manager_QueryHeapSize();

		/**
		 * The meta object literal for the '<em><b>Server Plugin Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SERVER_PLUGIN_MODE = eINSTANCE.getDB2Manager_ServerPluginMode();

		/**
		 * The meta object literal for the '<em><b>Software Developers Kit For Java Installation Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SOFTWARE_DEVELOPERS_KIT_FOR_JAVA_INSTALLATION_PATH = eINSTANCE.getDB2Manager_SoftwareDevelopersKitForJavaInstallationPath();

		/**
		 * The meta object literal for the '<em><b>Sort Heap Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SORT_HEAP_THRESHOLD = eINSTANCE.getDB2Manager_SortHeapThreshold();

		/**
		 * The meta object literal for the '<em><b>Start And Stop Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__START_AND_STOP_TIMEOUT = eINSTANCE.getDB2Manager_StartAndStopTimeout();

		/**
		 * The meta object literal for the '<em><b>Sync Point Manager Log File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_PATH = eINSTANCE.getDB2Manager_SyncPointManagerLogFilePath();

		/**
		 * The meta object literal for the '<em><b>Sync Point Manager Log File Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYNC_POINT_MANAGER_LOG_FILE_SIZE = eINSTANCE.getDB2Manager_SyncPointManagerLogFileSize();

		/**
		 * The meta object literal for the '<em><b>Sync Point Manager Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYNC_POINT_MANAGER_NAME = eINSTANCE.getDB2Manager_SyncPointManagerName();

		/**
		 * The meta object literal for the '<em><b>Sync Point Manager Resync Agent Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYNC_POINT_MANAGER_RESYNC_AGENT_LIMIT = eINSTANCE.getDB2Manager_SyncPointManagerResyncAgentLimit();

		/**
		 * The meta object literal for the '<em><b>System Administration Authority Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYSTEM_ADMINISTRATION_AUTHORITY_GROUP_NAME = eINSTANCE.getDB2Manager_SystemAdministrationAuthorityGroupName();

		/**
		 * The meta object literal for the '<em><b>System Control Authority Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYSTEM_CONTROL_AUTHORITY_GROUP_NAME = eINSTANCE.getDB2Manager_SystemControlAuthorityGroupName();

		/**
		 * The meta object literal for the '<em><b>System Maintenance Authority Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYSTEM_MAINTENANCE_AUTHORITY_GROUP_NAME = eINSTANCE.getDB2Manager_SystemMaintenanceAuthorityGroupName();

		/**
		 * The meta object literal for the '<em><b>System Monitor Authority Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__SYSTEM_MONITOR_AUTHORITY_GROUP_NAME = eINSTANCE.getDB2Manager_SystemMonitorAuthorityGroupName();

		/**
		 * The meta object literal for the '<em><b>TCPIP Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TCPIP_SERVICE_NAME = eINSTANCE.getDB2Manager_TCPIPServiceName();

		/**
		 * The meta object literal for the '<em><b>Transaction Manager Database Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TRANSACTION_MANAGER_DATABASE_NAME = eINSTANCE.getDB2Manager_TransactionManagerDatabaseName();

		/**
		 * The meta object literal for the '<em><b>Transaction Processor Monitor Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TRANSACTION_PROCESSOR_MONITOR_NAME = eINSTANCE.getDB2Manager_TransactionProcessorMonitorName();

		/**
		 * The meta object literal for the '<em><b>Transaction Resync Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TRANSACTION_RESYNC_INTERVAL = eINSTANCE.getDB2Manager_TransactionResyncInterval();

		/**
		 * The meta object literal for the '<em><b>Trust All Clients</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TRUST_ALL_CLIENTS = eINSTANCE.getDB2Manager_TrustAllClients();

		/**
		 * The meta object literal for the '<em><b>Trusted Clients Authentication</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__TRUSTED_CLIENTS_AUTHENTICATION = eINSTANCE.getDB2Manager_TrustedClientsAuthentication();

		/**
		 * The meta object literal for the '<em><b>Userid Password Plug In</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_MANAGER__USERID_PASSWORD_PLUG_IN = eINSTANCE.getDB2Manager_UseridPasswordPlugIn();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerUnitImpl <em>DB2 Manager Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2ManagerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2ManagerUnit()
		 * @generated
		 */
		EClass DB2_MANAGER_UNIT = eINSTANCE.getDB2ManagerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupImpl <em>DB2 Partition Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PartitionGroup()
		 * @generated
		 */
		EClass DB2_PARTITION_GROUP = eINSTANCE.getDB2PartitionGroup();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_PARTITION_GROUP__NAME1 = eINSTANCE.getDB2PartitionGroup_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupUnitImpl <em>DB2 Partition Group Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PartitionGroupUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PartitionGroupUnit()
		 * @generated
		 */
		EClass DB2_PARTITION_GROUP_UNIT = eINSTANCE.getDB2PartitionGroupUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionImpl <em>DB2 Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Permission()
		 * @generated
		 */
		EClass DB2_PERMISSION = eINSTANCE.getDB2Permission();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_PERMISSION__OBJECT = eINSTANCE.getDB2Permission_Object();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_PERMISSION__TYPE = eINSTANCE.getDB2Permission_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionUnitImpl <em>DB2 Permission Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2PermissionUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2PermissionUnit()
		 * @generated
		 */
		EClass DB2_PERMISSION_UNIT = eINSTANCE.getDB2PermissionUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl <em>DB2 Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2Table()
		 * @generated
		 */
		EClass DB2_TABLE = eINSTANCE.getDB2Table();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE__ALIAS = eINSTANCE.getDB2Table_Alias();

		/**
		 * The meta object literal for the '<em><b>Index Table Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE__INDEX_TABLE_SPACE = eINSTANCE.getDB2Table_IndexTableSpace();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE__NAME1 = eINSTANCE.getDB2Table_Name1();

		/**
		 * The meta object literal for the '<em><b>Partioning Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE__PARTIONING_KEY = eINSTANCE.getDB2Table_PartioningKey();

		/**
		 * The meta object literal for the '<em><b>Partioning Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE__PARTIONING_METHOD = eINSTANCE.getDB2Table_PartioningMethod();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl <em>DB2 Table Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableSpace()
		 * @generated
		 */
		EClass DB2_TABLE_SPACE = eINSTANCE.getDB2TableSpace();

		/**
		 * The meta object literal for the '<em><b>Auto Resize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__AUTO_RESIZE = eINSTANCE.getDB2TableSpace_AutoResize();

		/**
		 * The meta object literal for the '<em><b>Dropped Table Recovery</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY = eINSTANCE.getDB2TableSpace_DroppedTableRecovery();

		/**
		 * The meta object literal for the '<em><b>Event Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__EVENT_SIZE = eINSTANCE.getDB2TableSpace_EventSize();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__FILE = eINSTANCE.getDB2TableSpace_File();

		/**
		 * The meta object literal for the '<em><b>Increase Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__INCREASE_SIZE = eINSTANCE.getDB2TableSpace_IncreaseSize();

		/**
		 * The meta object literal for the '<em><b>Managed By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__MANAGED_BY = eINSTANCE.getDB2TableSpace_ManagedBy();

		/**
		 * The meta object literal for the '<em><b>Max Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__MAX_SIZE = eINSTANCE.getDB2TableSpace_MaxSize();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__NAME1 = eINSTANCE.getDB2TableSpace_Name1();

		/**
		 * The meta object literal for the '<em><b>Overhead</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__OVERHEAD = eINSTANCE.getDB2TableSpace_Overhead();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__PAGE_SIZE = eINSTANCE.getDB2TableSpace_PageSize();

		/**
		 * The meta object literal for the '<em><b>Prefetch Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__PREFETCH_SIZE = eINSTANCE.getDB2TableSpace_PrefetchSize();

		/**
		 * The meta object literal for the '<em><b>Transfer Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__TRANSFER_RATE = eINSTANCE.getDB2TableSpace_TransferRate();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_TABLE_SPACE__TYPE = eINSTANCE.getDB2TableSpace_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceUnitImpl <em>DB2 Table Space Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableSpaceUnit()
		 * @generated
		 */
		EClass DB2_TABLE_SPACE_UNIT = eINSTANCE.getDB2TableSpaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableUnitImpl <em>DB2 Table Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2TableUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2TableUnit()
		 * @generated
		 */
		EClass DB2_TABLE_UNIT = eINSTANCE.getDB2TableUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2UserImpl <em>DB2 User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2UserImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2User()
		 * @generated
		 */
		EClass DB2_USER = eINSTANCE.getDB2User();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_USER__NAME1 = eINSTANCE.getDB2User_Name1();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB2_USER__PASSWORD = eINSTANCE.getDB2User_Password();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2UserUnitImpl <em>DB2 User Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.DB2UserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.db2high.impl.Db2highPackageImpl#getDB2UserUnit()
		 * @generated
		 */
		EClass DB2_USER_UNIT = eINSTANCE.getDB2UserUnit();

	}

} //Db2highPackage
