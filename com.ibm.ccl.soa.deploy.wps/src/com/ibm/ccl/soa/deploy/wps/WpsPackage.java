/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

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
 * @see com.ibm.ccl.soa.deploy.wps.WpsFactory
 * @model kind="package"
 * @generated
 */
public interface WpsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wps"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/Zephyr/wps/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wps"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WpsPackage eINSTANCE = com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl <em>Application Schedular</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getApplicationSchedular()
	 * @generated
	 */
	int APPLICATION_SCHEDULAR = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Data Base Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__DATA_BASE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR__SERVER_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application Schedular</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_SCHEDULAR_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl <em>BPE Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBPEContainer()
	 * @generated
	 */
	int BPE_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Administrator Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Source Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__DATA_SOURCE_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Source Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__DATA_SOURCE_USERNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enable Audit Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ENABLE_AUDIT_LOG = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enable CE Ilogging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__ENABLE_CE_ILOGGING = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>External Request Processing Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Hold Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__HOLD_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Implementation Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Install Business Process Choreographer Explorer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Internal Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__INTERNAL_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>JDBC Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JDBC_PROVIDER = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>JMSAPI Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMSAPI_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>JMSAPI User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMSAPI_USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>JMS Connection Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMS_CONNECTION_FACTORY = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>JMS Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMS_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>JMS Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMS_PROVIDER = CorePackage.CAPABILITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>JMS Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMS_RESOURCES = CorePackage.CAPABILITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>JMS User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__JMS_USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Retention Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__RETENTION_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>System Monitor Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING = CorePackage.CAPABILITY_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>BPE Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerUnitImpl <em>BPE Container Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.BPEContainerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBPEContainerUnit()
	 * @generated
	 */
	int BPE_CONTAINER_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>BPE Container Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPE_CONTAINER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerImpl <em>Business Rules Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBusinessRulesManager()
	 * @generated
	 */
	int BUSINESS_RULES_MANAGER = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Business Rules Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Business Rules Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerUnitImpl <em>Business Rules Manager Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBusinessRulesManagerUnit()
	 * @generated
	 */
	int BUSINESS_RULES_MANAGER_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Business Rules Manager Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULES_MANAGER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.CommonEventInfrastructureImpl <em>Common Event Infrastructure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.CommonEventInfrastructureImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getCommonEventInfrastructure()
	 * @generated
	 */
	int COMMON_EVENT_INFRASTRUCTURE = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Common Event Infrastructure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_EVENT_INFRASTRUCTURE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl <em>Extended Messaging Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getExtendedMessagingService()
	 * @generated
	 */
	int EXTENDED_MESSAGING_SERVICE = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Input Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__INPUT_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extended Messaging Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_MESSAGING_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ManagingEventserviceImpl <em>Managing Eventservice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.ManagingEventserviceImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getManagingEventservice()
	 * @generated
	 */
	int MANAGING_EVENTSERVICE = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Events Infrastructure Emitter Factory JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Managing Eventservice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGING_EVENTSERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.SCARuntimeImpl <em>SCA Runtime</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.SCARuntimeImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getSCARuntime()
	 * @generated
	 */
	int SCA_RUNTIME = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Installation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME__INSTALLATION_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCA Runtime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCA_RUNTIME_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.SDORuntimeImpl <em>SDO Runtime</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.SDORuntimeImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getSDORuntime()
	 * @generated
	 */
	int SDO_RUNTIME = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Installation Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME__INSTALLATION_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SDO Runtime</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDO_RUNTIME_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl <em>Task Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getTaskContainer()
	 * @generated
	 */
	int TASK_CONTAINER = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Administrator Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__CLASSPATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enable Audit Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ENABLE_AUDIT_LOG = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enable CE Ilogging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ENABLE_CE_ILOGGING = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Escalationpassword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__ESCALATIONPASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hold Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__HOLD_QUEUE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>JMS Connection Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__JMS_CONNECTION_FACTORY = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>JMS Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__JMS_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>JMS Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__JMS_PROVIDER = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>JMS Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__JMS_RESOURCES = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>JMS User ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__JMS_USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Mail Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__MAIL_SESSION = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Queue Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__QUEUE_MANAGER = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>System Monitor Security Role Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Task Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerUnitImpl <em>Task Container Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.TaskContainerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getTaskContainerUnit()
	 * @generated
	 */
	int TASK_CONTAINER_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Task Container Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_CONTAINER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl <em>Web Sphere Business Integration Adapters Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Input Queue JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Queue JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Web Sphere Business Integration Adapters Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl <em>Base System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsBaseSystem()
	 * @generated
	 */
	int WPS_BASE_SYSTEM = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Install Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__INSTALL_LOCATION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Profile Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__PROFILE_DIR = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM__VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Base System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemUnitImpl <em>Base System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsBaseSystemUnit()
	 * @generated
	 */
	int WPS_BASE_SYSTEM_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Base System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_BASE_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSCommonEventInfrastructureUnitImpl <em>WPS Common Event Infrastructure Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSCommonEventInfrastructureUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSCommonEventInfrastructureUnit()
	 * @generated
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>WPS Common Event Infrastructure Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSESBImpl <em>WPSESB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSESBImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSESB()
	 * @generated
	 */
	int WPSESB = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WPSESB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSESBUnitImpl <em>WPSESB Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSESBUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSESBUnit()
	 * @generated
	 */
	int WPSESB_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>WPSESB Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSESB_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl <em>WPS Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSRoot()
	 * @generated
	 */
	int WPS_ROOT = 18;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Application Schedular</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR = 3;

	/**
	 * The feature id for the '<em><b>Capability BPE Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_BPE_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Capability Business Rules Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER = 5;

	/**
	 * The feature id for the '<em><b>Capability Common Event Infrastructure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE = 6;

	/**
	 * The feature id for the '<em><b>Capability Extended Messaging Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE = 7;

	/**
	 * The feature id for the '<em><b>Capability Managing Event Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE = 8;

	/**
	 * The feature id for the '<em><b>Capability SCA Runtime</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_SCA_RUNTIME = 9;

	/**
	 * The feature id for the '<em><b>Capability SDO Runtime</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_SDO_RUNTIME = 10;

	/**
	 * The feature id for the '<em><b>Capability Task Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_TASK_CONTAINER = 11;

	/**
	 * The feature id for the '<em><b>Capability Web Sphere Business Integration Adapters Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Capability Wps Base System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM = 13;

	/**
	 * The feature id for the '<em><b>Capability WPSESB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_WPSESB = 14;

	/**
	 * The feature id for the '<em><b>Capability WPSSIB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__CAPABILITY_WPSSIB = 15;

	/**
	 * The feature id for the '<em><b>Unit BPE Container Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_BPE_CONTAINER_UNIT = 16;

	/**
	 * The feature id for the '<em><b>Unit Business Rules Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Unit Task Container Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_TASK_CONTAINER_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Unit Wps Base System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Unit WPS Common Event Infrastructure Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Unit WPSESB Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_WPSESB_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Unit WPSSIB Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_WPSSIB_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Unit Wps System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT__UNIT_WPS_SYSTEM_UNIT = 23;

	/**
	 * The number of structural features of the '<em>WPS Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_ROOT_FEATURE_COUNT = 24;


	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSSIBImpl <em>WPSSIB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSSIBImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSSIB()
	 * @generated
	 */
	int WPSSIB = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB__NAME1 = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>WPSSIB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSSIBUnitImpl <em>WPSSIB Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSSIBUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSSIBUnit()
	 * @generated
	 */
	int WPSSIB_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>WPSSIB Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPSSIB_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsSystemUnitImpl <em>System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsSystemUnit()
	 * @generated
	 */
	int WPS_SYSTEM_UNIT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WPS_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular <em>Application Schedular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Schedular</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ApplicationSchedular
	 * @generated
	 */
	EClass getApplicationSchedular();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getDataBaseName <em>Data Base Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Base Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getDataBaseName()
	 * @see #getApplicationSchedular()
	 * @generated
	 */
	EAttribute getApplicationSchedular_DataBaseName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getServerName <em>Server Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ApplicationSchedular#getServerName()
	 * @see #getApplicationSchedular()
	 * @generated
	 */
	EAttribute getApplicationSchedular_ServerName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer <em>BPE Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPE Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer
	 * @generated
	 */
	EClass getBPEContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Administrator Security Role Mapping</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getAdministratorSecurityRoleMapping()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_AdministratorSecurityRoleMapping();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getClasspath()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_Classpath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourcePassword <em>Data Source Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourcePassword()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_DataSourcePassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourceUsername <em>Data Source Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source Username</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getDataSourceUsername()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_DataSourceUsername();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableAuditLog <em>Enable Audit Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Audit Log</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableAuditLog()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_EnableAuditLog();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable CE Ilogging</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getEnableCEIlogging()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_EnableCEIlogging();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getExternalRequestProcessingQueue <em>External Request Processing Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Request Processing Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getExternalRequestProcessingQueue()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_ExternalRequestProcessingQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getHoldQueue <em>Hold Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hold Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getHoldQueue()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_HoldQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getImplementationClassName <em>Implementation Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getImplementationClassName()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_ImplementationClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInstallBusinessProcessChoreographerExplorer <em>Install Business Process Choreographer Explorer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Business Process Choreographer Explorer</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getInstallBusinessProcessChoreographerExplorer()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_InstallBusinessProcessChoreographerExplorer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getInternalQueue <em>Internal Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getInternalQueue()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_InternalQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJDBCProvider <em>JDBC Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JDBC Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJDBCProvider()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JDBCProvider();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIPassword <em>JMSAPI Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMSAPI Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIPassword()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSAPIPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIUserID <em>JMSAPI User ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMSAPI User ID</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSAPIUserID()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSAPIUserID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSConnectionFactory()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSPassword <em>JMS Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSPassword()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSProvider <em>JMS Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSProvider()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSProvider();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSResources <em>JMS Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Resources</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSResources()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSResources();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSUserID <em>JMS User ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS User ID</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getJMSUserID()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_JMSUserID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getQueueManager <em>Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getQueueManager()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_QueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getRetentionQueue <em>Retention Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retention Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getRetentionQueue()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_RetentionQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BPEContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Monitor Security Role Mapping</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainer#getSystemMonitorSecurityRoleMapping()
	 * @see #getBPEContainer()
	 * @generated
	 */
	EAttribute getBPEContainer_SystemMonitorSecurityRoleMapping();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.BPEContainerUnit <em>BPE Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPE Container Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BPEContainerUnit
	 * @generated
	 */
	EClass getBPEContainerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManager <em>Business Rules Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Rules Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BusinessRulesManager
	 * @generated
	 */
	EClass getBusinessRulesManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManager#getBusinessRulesManager <em>Business Rules Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Business Rules Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BusinessRulesManager#getBusinessRulesManager()
	 * @see #getBusinessRulesManager()
	 * @generated
	 */
	EAttribute getBusinessRulesManager_BusinessRulesManager();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManagerUnit <em>Business Rules Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Rules Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.BusinessRulesManagerUnit
	 * @generated
	 */
	EClass getBusinessRulesManagerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure <em>Common Event Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Event Infrastructure</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure
	 * @generated
	 */
	EClass getCommonEventInfrastructure();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.CommonEventInfrastructure#getName1()
	 * @see #getCommonEventInfrastructure()
	 * @generated
	 */
	EAttribute getCommonEventInfrastructure_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService <em>Extended Messaging Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Messaging Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService
	 * @generated
	 */
	EClass getExtendedMessagingService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getInputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getInputPort()
	 * @see #getExtendedMessagingService()
	 * @generated
	 */
	EAttribute getExtendedMessagingService_InputPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getOutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getOutputPort()
	 * @see #getExtendedMessagingService()
	 * @generated
	 */
	EAttribute getExtendedMessagingService_OutputPort();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.ManagingEventservice <em>Managing Eventservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managing Eventservice</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ManagingEventservice
	 * @generated
	 */
	EClass getManagingEventservice();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.ManagingEventservice#getEventsInfrastructureEmitterFactoryJNDIName <em>Events Infrastructure Emitter Factory JNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Events Infrastructure Emitter Factory JNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.ManagingEventservice#getEventsInfrastructureEmitterFactoryJNDIName()
	 * @see #getManagingEventservice()
	 * @generated
	 */
	EAttribute getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.SCARuntime <em>SCA Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCA Runtime</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.SCARuntime
	 * @generated
	 */
	EClass getSCARuntime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.SCARuntime#getInstallationPath <em>Installation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installation Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.SCARuntime#getInstallationPath()
	 * @see #getSCARuntime()
	 * @generated
	 */
	EAttribute getSCARuntime_InstallationPath();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.SDORuntime <em>SDO Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDO Runtime</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.SDORuntime
	 * @generated
	 */
	EClass getSDORuntime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.SDORuntime#getInstallationPath <em>Installation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Installation Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.SDORuntime#getInstallationPath()
	 * @see #getSDORuntime()
	 * @generated
	 */
	EAttribute getSDORuntime_InstallationPath();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer <em>Task Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer
	 * @generated
	 */
	EClass getTaskContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getAdministratorSecurityRoleMapping <em>Administrator Security Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Administrator Security Role Mapping</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getAdministratorSecurityRoleMapping()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_AdministratorSecurityRoleMapping();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getClasspath()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_Classpath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableAuditLog <em>Enable Audit Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Audit Log</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableAuditLog()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_EnableAuditLog();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableCEIlogging <em>Enable CE Ilogging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable CE Ilogging</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getEnableCEIlogging()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_EnableCEIlogging();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getEscalationpassword <em>Escalationpassword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escalationpassword</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getEscalationpassword()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_Escalationpassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getHoldQueue <em>Hold Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hold Queue</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getHoldQueue()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_HoldQueue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSConnectionFactory <em>JMS Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Connection Factory</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSConnectionFactory()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_JMSConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSPassword <em>JMS Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSPassword()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_JMSPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSProvider <em>JMS Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Provider</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSProvider()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_JMSProvider();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSResources <em>JMS Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS Resources</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSResources()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_JMSResources();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSUserID <em>JMS User ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JMS User ID</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getJMSUserID()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_JMSUserID();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getMailSession <em>Mail Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail Session</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getMailSession()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_MailSession();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getQueueManager <em>Queue Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getQueueManager()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_QueueManager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.TaskContainer#getSystemMonitorSecurityRoleMapping <em>System Monitor Security Role Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Monitor Security Role Mapping</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainer#getSystemMonitorSecurityRoleMapping()
	 * @see #getTaskContainer()
	 * @generated
	 */
	EAttribute getTaskContainer_SystemMonitorSecurityRoleMapping();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.TaskContainerUnit <em>Task Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Container Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.TaskContainerUnit
	 * @generated
	 */
	EClass getTaskContainerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService <em>Web Sphere Business Integration Adapters Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Sphere Business Integration Adapters Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService
	 * @generated
	 */
	EClass getWebSphereBusinessIntegrationAdaptersService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getInputQueueJNDIName <em>Input Queue JNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Queue JNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getInputQueueJNDIName()
	 * @see #getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	EAttribute getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getJNDIName <em>JNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>JNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getJNDIName()
	 * @see #getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	EAttribute getWebSphereBusinessIntegrationAdaptersService_JNDIName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getName1()
	 * @see #getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	EAttribute getWebSphereBusinessIntegrationAdaptersService_Name1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getOutputQueueJNDIName <em>Output Queue JNDI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Queue JNDI Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getOutputQueueJNDIName()
	 * @see #getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	EAttribute getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getTimeout()
	 * @see #getWebSphereBusinessIntegrationAdaptersService()
	 * @generated
	 */
	EAttribute getWebSphereBusinessIntegrationAdaptersService_Timeout();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem <em>Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base System</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystem
	 * @generated
	 */
	EClass getWpsBaseSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getInstallLocation <em>Install Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getInstallLocation()
	 * @see #getWpsBaseSystem()
	 * @generated
	 */
	EAttribute getWpsBaseSystem_InstallLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getProfileDir <em>Profile Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Dir</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getProfileDir()
	 * @see #getWpsBaseSystem()
	 * @generated
	 */
	EAttribute getWpsBaseSystem_ProfileDir();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystem#getVersion()
	 * @see #getWpsBaseSystem()
	 * @generated
	 */
	EAttribute getWpsBaseSystem_Version();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit <em>Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsBaseSystemUnit
	 * @generated
	 */
	EClass getWpsBaseSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSCommonEventInfrastructureUnit <em>WPS Common Event Infrastructure Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPS Common Event Infrastructure Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSCommonEventInfrastructureUnit
	 * @generated
	 */
	EClass getWPSCommonEventInfrastructureUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSESB <em>WPSESB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPSESB</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSESB
	 * @generated
	 */
	EClass getWPSESB();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WPSESB#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSESB#getName1()
	 * @see #getWPSESB()
	 * @generated
	 */
	EAttribute getWPSESB_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSESBUnit <em>WPSESB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPSESB Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSESBUnit
	 * @generated
	 */
	EClass getWPSESBUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot <em>WPS Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPS Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot
	 * @generated
	 */
	EClass getWPSRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getMixed()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EAttribute getWPSRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getXMLNSPrefixMap()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getXSISchemaLocation()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityApplicationSchedular <em>Capability Application Schedular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Application Schedular</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityApplicationSchedular()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityApplicationSchedular();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBPEContainer <em>Capability BPE Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability BPE Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBPEContainer()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityBPEContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBusinessRulesManager <em>Capability Business Rules Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Business Rules Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityBusinessRulesManager()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityBusinessRulesManager();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityCommonEventInfrastructure <em>Capability Common Event Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Common Event Infrastructure</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityCommonEventInfrastructure()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityCommonEventInfrastructure();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityExtendedMessagingService <em>Capability Extended Messaging Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Extended Messaging Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityExtendedMessagingService()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityExtendedMessagingService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityManagingEventService <em>Capability Managing Event Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Managing Event Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityManagingEventService()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityManagingEventService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySCARuntime <em>Capability SCA Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SCA Runtime</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySCARuntime()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilitySCARuntime();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySDORuntime <em>Capability SDO Runtime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SDO Runtime</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilitySDORuntime()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilitySDORuntime();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityTaskContainer <em>Capability Task Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Task Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityTaskContainer()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityTaskContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWebSphereBusinessIntegrationAdaptersService <em>Capability Web Sphere Business Integration Adapters Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Web Sphere Business Integration Adapters Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWebSphereBusinessIntegrationAdaptersService()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWpsBaseSystem <em>Capability Wps Base System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Wps Base System</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWpsBaseSystem()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityWpsBaseSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSESB <em>Capability WPSESB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability WPSESB</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSESB()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityWPSESB();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSSIB <em>Capability WPSSIB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability WPSSIB</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getCapabilityWPSSIB()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_CapabilityWPSSIB();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBPEContainerUnit <em>Unit BPE Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit BPE Container Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBPEContainerUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitBPEContainerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBusinessRulesManagerUnit <em>Unit Business Rules Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Business Rules Manager Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitBusinessRulesManagerUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitBusinessRulesManagerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitTaskContainerUnit <em>Unit Task Container Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Task Container Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitTaskContainerUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitTaskContainerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsBaseSystemUnit <em>Unit Wps Base System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Wps Base System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsBaseSystemUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitWpsBaseSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSCommonEventInfrastructureUnit <em>Unit WPS Common Event Infrastructure Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit WPS Common Event Infrastructure Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSCommonEventInfrastructureUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitWPSCommonEventInfrastructureUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSESBUnit <em>Unit WPSESB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit WPSESB Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSESBUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitWPSESBUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSSIBUnit <em>Unit WPSSIB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit WPSSIB Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWPSSIBUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitWPSSIBUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsSystemUnit <em>Unit Wps System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Wps System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSRoot#getUnitWpsSystemUnit()
	 * @see #getWPSRoot()
	 * @generated
	 */
	EReference getWPSRoot_UnitWpsSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSSIB <em>WPSSIB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPSSIB</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSSIB
	 * @generated
	 */
	EClass getWPSSIB();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.wps.WPSSIB#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSSIB#getName1()
	 * @see #getWPSSIB()
	 * @generated
	 */
	EAttribute getWPSSIB_Name1();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WPSSIBUnit <em>WPSSIB Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WPSSIB Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WPSSIBUnit
	 * @generated
	 */
	EClass getWPSSIBUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.wps.WpsSystemUnit <em>System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.wps.WpsSystemUnit
	 * @generated
	 */
	EClass getWpsSystemUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WpsFactory getWpsFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl <em>Application Schedular</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.ApplicationSchedularImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getApplicationSchedular()
		 * @generated
		 */
		EClass APPLICATION_SCHEDULAR = eINSTANCE.getApplicationSchedular();

		/**
		 * The meta object literal for the '<em><b>Data Base Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_SCHEDULAR__DATA_BASE_NAME = eINSTANCE.getApplicationSchedular_DataBaseName();

		/**
		 * The meta object literal for the '<em><b>Server Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_SCHEDULAR__SERVER_NAME = eINSTANCE.getApplicationSchedular_ServerName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl <em>BPE Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.BPEContainerImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBPEContainer()
		 * @generated
		 */
		EClass BPE_CONTAINER = eINSTANCE.getBPEContainer();

		/**
		 * The meta object literal for the '<em><b>Administrator Security Role Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING = eINSTANCE.getBPEContainer_AdministratorSecurityRoleMapping();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__CLASSPATH = eINSTANCE.getBPEContainer_Classpath();

		/**
		 * The meta object literal for the '<em><b>Data Source Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__DATA_SOURCE_PASSWORD = eINSTANCE.getBPEContainer_DataSourcePassword();

		/**
		 * The meta object literal for the '<em><b>Data Source Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__DATA_SOURCE_USERNAME = eINSTANCE.getBPEContainer_DataSourceUsername();

		/**
		 * The meta object literal for the '<em><b>Enable Audit Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__ENABLE_AUDIT_LOG = eINSTANCE.getBPEContainer_EnableAuditLog();

		/**
		 * The meta object literal for the '<em><b>Enable CE Ilogging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__ENABLE_CE_ILOGGING = eINSTANCE.getBPEContainer_EnableCEIlogging();

		/**
		 * The meta object literal for the '<em><b>External Request Processing Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__EXTERNAL_REQUEST_PROCESSING_QUEUE = eINSTANCE.getBPEContainer_ExternalRequestProcessingQueue();

		/**
		 * The meta object literal for the '<em><b>Hold Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__HOLD_QUEUE = eINSTANCE.getBPEContainer_HoldQueue();

		/**
		 * The meta object literal for the '<em><b>Implementation Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__IMPLEMENTATION_CLASS_NAME = eINSTANCE.getBPEContainer_ImplementationClassName();

		/**
		 * The meta object literal for the '<em><b>Install Business Process Choreographer Explorer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__INSTALL_BUSINESS_PROCESS_CHOREOGRAPHER_EXPLORER = eINSTANCE.getBPEContainer_InstallBusinessProcessChoreographerExplorer();

		/**
		 * The meta object literal for the '<em><b>Internal Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__INTERNAL_QUEUE = eINSTANCE.getBPEContainer_InternalQueue();

		/**
		 * The meta object literal for the '<em><b>JDBC Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JDBC_PROVIDER = eINSTANCE.getBPEContainer_JDBCProvider();

		/**
		 * The meta object literal for the '<em><b>JMSAPI Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMSAPI_PASSWORD = eINSTANCE.getBPEContainer_JMSAPIPassword();

		/**
		 * The meta object literal for the '<em><b>JMSAPI User ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMSAPI_USER_ID = eINSTANCE.getBPEContainer_JMSAPIUserID();

		/**
		 * The meta object literal for the '<em><b>JMS Connection Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMS_CONNECTION_FACTORY = eINSTANCE.getBPEContainer_JMSConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>JMS Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMS_PASSWORD = eINSTANCE.getBPEContainer_JMSPassword();

		/**
		 * The meta object literal for the '<em><b>JMS Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMS_PROVIDER = eINSTANCE.getBPEContainer_JMSProvider();

		/**
		 * The meta object literal for the '<em><b>JMS Resources</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMS_RESOURCES = eINSTANCE.getBPEContainer_JMSResources();

		/**
		 * The meta object literal for the '<em><b>JMS User ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__JMS_USER_ID = eINSTANCE.getBPEContainer_JMSUserID();

		/**
		 * The meta object literal for the '<em><b>Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__QUEUE_MANAGER = eINSTANCE.getBPEContainer_QueueManager();

		/**
		 * The meta object literal for the '<em><b>Retention Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__RETENTION_QUEUE = eINSTANCE.getBPEContainer_RetentionQueue();

		/**
		 * The meta object literal for the '<em><b>System Monitor Security Role Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPE_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING = eINSTANCE.getBPEContainer_SystemMonitorSecurityRoleMapping();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BPEContainerUnitImpl <em>BPE Container Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.BPEContainerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBPEContainerUnit()
		 * @generated
		 */
		EClass BPE_CONTAINER_UNIT = eINSTANCE.getBPEContainerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerImpl <em>Business Rules Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBusinessRulesManager()
		 * @generated
		 */
		EClass BUSINESS_RULES_MANAGER = eINSTANCE.getBusinessRulesManager();

		/**
		 * The meta object literal for the '<em><b>Business Rules Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_RULES_MANAGER__BUSINESS_RULES_MANAGER = eINSTANCE.getBusinessRulesManager_BusinessRulesManager();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerUnitImpl <em>Business Rules Manager Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.BusinessRulesManagerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getBusinessRulesManagerUnit()
		 * @generated
		 */
		EClass BUSINESS_RULES_MANAGER_UNIT = eINSTANCE.getBusinessRulesManagerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.CommonEventInfrastructureImpl <em>Common Event Infrastructure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.CommonEventInfrastructureImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getCommonEventInfrastructure()
		 * @generated
		 */
		EClass COMMON_EVENT_INFRASTRUCTURE = eINSTANCE.getCommonEventInfrastructure();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMON_EVENT_INFRASTRUCTURE__NAME1 = eINSTANCE.getCommonEventInfrastructure_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl <em>Extended Messaging Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getExtendedMessagingService()
		 * @generated
		 */
		EClass EXTENDED_MESSAGING_SERVICE = eINSTANCE.getExtendedMessagingService();

		/**
		 * The meta object literal for the '<em><b>Input Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_MESSAGING_SERVICE__INPUT_PORT = eINSTANCE.getExtendedMessagingService_InputPort();

		/**
		 * The meta object literal for the '<em><b>Output Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT = eINSTANCE.getExtendedMessagingService_OutputPort();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.ManagingEventserviceImpl <em>Managing Eventservice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.ManagingEventserviceImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getManagingEventservice()
		 * @generated
		 */
		EClass MANAGING_EVENTSERVICE = eINSTANCE.getManagingEventservice();

		/**
		 * The meta object literal for the '<em><b>Events Infrastructure Emitter Factory JNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME = eINSTANCE.getManagingEventservice_EventsInfrastructureEmitterFactoryJNDIName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.SCARuntimeImpl <em>SCA Runtime</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.SCARuntimeImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getSCARuntime()
		 * @generated
		 */
		EClass SCA_RUNTIME = eINSTANCE.getSCARuntime();

		/**
		 * The meta object literal for the '<em><b>Installation Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCA_RUNTIME__INSTALLATION_PATH = eINSTANCE.getSCARuntime_InstallationPath();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.SDORuntimeImpl <em>SDO Runtime</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.SDORuntimeImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getSDORuntime()
		 * @generated
		 */
		EClass SDO_RUNTIME = eINSTANCE.getSDORuntime();

		/**
		 * The meta object literal for the '<em><b>Installation Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SDO_RUNTIME__INSTALLATION_PATH = eINSTANCE.getSDORuntime_InstallationPath();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl <em>Task Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.TaskContainerImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getTaskContainer()
		 * @generated
		 */
		EClass TASK_CONTAINER = eINSTANCE.getTaskContainer();

		/**
		 * The meta object literal for the '<em><b>Administrator Security Role Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__ADMINISTRATOR_SECURITY_ROLE_MAPPING = eINSTANCE.getTaskContainer_AdministratorSecurityRoleMapping();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__CLASSPATH = eINSTANCE.getTaskContainer_Classpath();

		/**
		 * The meta object literal for the '<em><b>Enable Audit Log</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__ENABLE_AUDIT_LOG = eINSTANCE.getTaskContainer_EnableAuditLog();

		/**
		 * The meta object literal for the '<em><b>Enable CE Ilogging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__ENABLE_CE_ILOGGING = eINSTANCE.getTaskContainer_EnableCEIlogging();

		/**
		 * The meta object literal for the '<em><b>Escalationpassword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__ESCALATIONPASSWORD = eINSTANCE.getTaskContainer_Escalationpassword();

		/**
		 * The meta object literal for the '<em><b>Hold Queue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__HOLD_QUEUE = eINSTANCE.getTaskContainer_HoldQueue();

		/**
		 * The meta object literal for the '<em><b>JMS Connection Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__JMS_CONNECTION_FACTORY = eINSTANCE.getTaskContainer_JMSConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>JMS Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__JMS_PASSWORD = eINSTANCE.getTaskContainer_JMSPassword();

		/**
		 * The meta object literal for the '<em><b>JMS Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__JMS_PROVIDER = eINSTANCE.getTaskContainer_JMSProvider();

		/**
		 * The meta object literal for the '<em><b>JMS Resources</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__JMS_RESOURCES = eINSTANCE.getTaskContainer_JMSResources();

		/**
		 * The meta object literal for the '<em><b>JMS User ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__JMS_USER_ID = eINSTANCE.getTaskContainer_JMSUserID();

		/**
		 * The meta object literal for the '<em><b>Mail Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__MAIL_SESSION = eINSTANCE.getTaskContainer_MailSession();

		/**
		 * The meta object literal for the '<em><b>Queue Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__QUEUE_MANAGER = eINSTANCE.getTaskContainer_QueueManager();

		/**
		 * The meta object literal for the '<em><b>System Monitor Security Role Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_CONTAINER__SYSTEM_MONITOR_SECURITY_ROLE_MAPPING = eINSTANCE.getTaskContainer_SystemMonitorSecurityRoleMapping();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.TaskContainerUnitImpl <em>Task Container Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.TaskContainerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getTaskContainerUnit()
		 * @generated
		 */
		EClass TASK_CONTAINER_UNIT = eINSTANCE.getTaskContainerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl <em>Web Sphere Business Integration Adapters Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WebSphereBusinessIntegrationAdaptersServiceImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWebSphereBusinessIntegrationAdaptersService()
		 * @generated
		 */
		EClass WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService();

		/**
		 * The meta object literal for the '<em><b>Input Queue JNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__INPUT_QUEUE_JNDI_NAME = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName();

		/**
		 * The meta object literal for the '<em><b>JNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__JNDI_NAME = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService_JNDIName();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__NAME1 = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService_Name1();

		/**
		 * The meta object literal for the '<em><b>Output Queue JNDI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__OUTPUT_QUEUE_JNDI_NAME = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE__TIMEOUT = eINSTANCE.getWebSphereBusinessIntegrationAdaptersService_Timeout();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl <em>Base System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsBaseSystem()
		 * @generated
		 */
		EClass WPS_BASE_SYSTEM = eINSTANCE.getWpsBaseSystem();

		/**
		 * The meta object literal for the '<em><b>Install Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPS_BASE_SYSTEM__INSTALL_LOCATION = eINSTANCE.getWpsBaseSystem_InstallLocation();

		/**
		 * The meta object literal for the '<em><b>Profile Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPS_BASE_SYSTEM__PROFILE_DIR = eINSTANCE.getWpsBaseSystem_ProfileDir();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPS_BASE_SYSTEM__VERSION = eINSTANCE.getWpsBaseSystem_Version();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemUnitImpl <em>Base System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsBaseSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsBaseSystemUnit()
		 * @generated
		 */
		EClass WPS_BASE_SYSTEM_UNIT = eINSTANCE.getWpsBaseSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSCommonEventInfrastructureUnitImpl <em>WPS Common Event Infrastructure Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSCommonEventInfrastructureUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSCommonEventInfrastructureUnit()
		 * @generated
		 */
		EClass WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT = eINSTANCE.getWPSCommonEventInfrastructureUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSESBImpl <em>WPSESB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSESBImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSESB()
		 * @generated
		 */
		EClass WPSESB = eINSTANCE.getWPSESB();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPSESB__NAME1 = eINSTANCE.getWPSESB_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSESBUnitImpl <em>WPSESB Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSESBUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSESBUnit()
		 * @generated
		 */
		EClass WPSESB_UNIT = eINSTANCE.getWPSESBUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl <em>WPS Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSRootImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSRoot()
		 * @generated
		 */
		EClass WPS_ROOT = eINSTANCE.getWPSRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPS_ROOT__MIXED = eINSTANCE.getWPSRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getWPSRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getWPSRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Application Schedular</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_APPLICATION_SCHEDULAR = eINSTANCE.getWPSRoot_CapabilityApplicationSchedular();

		/**
		 * The meta object literal for the '<em><b>Capability BPE Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_BPE_CONTAINER = eINSTANCE.getWPSRoot_CapabilityBPEContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Business Rules Manager</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_BUSINESS_RULES_MANAGER = eINSTANCE.getWPSRoot_CapabilityBusinessRulesManager();

		/**
		 * The meta object literal for the '<em><b>Capability Common Event Infrastructure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_COMMON_EVENT_INFRASTRUCTURE = eINSTANCE.getWPSRoot_CapabilityCommonEventInfrastructure();

		/**
		 * The meta object literal for the '<em><b>Capability Extended Messaging Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_EXTENDED_MESSAGING_SERVICE = eINSTANCE.getWPSRoot_CapabilityExtendedMessagingService();

		/**
		 * The meta object literal for the '<em><b>Capability Managing Event Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_MANAGING_EVENT_SERVICE = eINSTANCE.getWPSRoot_CapabilityManagingEventService();

		/**
		 * The meta object literal for the '<em><b>Capability SCA Runtime</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_SCA_RUNTIME = eINSTANCE.getWPSRoot_CapabilitySCARuntime();

		/**
		 * The meta object literal for the '<em><b>Capability SDO Runtime</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_SDO_RUNTIME = eINSTANCE.getWPSRoot_CapabilitySDORuntime();

		/**
		 * The meta object literal for the '<em><b>Capability Task Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_TASK_CONTAINER = eINSTANCE.getWPSRoot_CapabilityTaskContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Web Sphere Business Integration Adapters Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_WEB_SPHERE_BUSINESS_INTEGRATION_ADAPTERS_SERVICE = eINSTANCE.getWPSRoot_CapabilityWebSphereBusinessIntegrationAdaptersService();

		/**
		 * The meta object literal for the '<em><b>Capability Wps Base System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_WPS_BASE_SYSTEM = eINSTANCE.getWPSRoot_CapabilityWpsBaseSystem();

		/**
		 * The meta object literal for the '<em><b>Capability WPSESB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_WPSESB = eINSTANCE.getWPSRoot_CapabilityWPSESB();

		/**
		 * The meta object literal for the '<em><b>Capability WPSSIB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__CAPABILITY_WPSSIB = eINSTANCE.getWPSRoot_CapabilityWPSSIB();

		/**
		 * The meta object literal for the '<em><b>Unit BPE Container Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_BPE_CONTAINER_UNIT = eINSTANCE.getWPSRoot_UnitBPEContainerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Business Rules Manager Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_BUSINESS_RULES_MANAGER_UNIT = eINSTANCE.getWPSRoot_UnitBusinessRulesManagerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Task Container Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_TASK_CONTAINER_UNIT = eINSTANCE.getWPSRoot_UnitTaskContainerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Wps Base System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_WPS_BASE_SYSTEM_UNIT = eINSTANCE.getWPSRoot_UnitWpsBaseSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit WPS Common Event Infrastructure Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_WPS_COMMON_EVENT_INFRASTRUCTURE_UNIT = eINSTANCE.getWPSRoot_UnitWPSCommonEventInfrastructureUnit();

		/**
		 * The meta object literal for the '<em><b>Unit WPSESB Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_WPSESB_UNIT = eINSTANCE.getWPSRoot_UnitWPSESBUnit();

		/**
		 * The meta object literal for the '<em><b>Unit WPSSIB Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_WPSSIB_UNIT = eINSTANCE.getWPSRoot_UnitWPSSIBUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Wps System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WPS_ROOT__UNIT_WPS_SYSTEM_UNIT = eINSTANCE.getWPSRoot_UnitWpsSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSSIBImpl <em>WPSSIB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSSIBImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSSIB()
		 * @generated
		 */
		EClass WPSSIB = eINSTANCE.getWPSSIB();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WPSSIB__NAME1 = eINSTANCE.getWPSSIB_Name1();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WPSSIBUnitImpl <em>WPSSIB Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WPSSIBUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWPSSIBUnit()
		 * @generated
		 */
		EClass WPSSIB_UNIT = eINSTANCE.getWPSSIBUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.wps.impl.WpsSystemUnitImpl <em>System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.wps.impl.WpsPackageImpl#getWpsSystemUnit()
		 * @generated
		 */
		EClass WPS_SYSTEM_UNIT = eINSTANCE.getWpsSystemUnit();

	}

} //WpsPackage
