/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationPackage.java,v 1.14 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

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
import com.ibm.ccl.soa.deploy.os.OsPackage;
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
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationFactory
 * @model kind="package"
 * @generated
 */
public interface VirtualizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "virtualization"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/virtualization/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "virtualization"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VirtualizationPackage eINSTANCE = com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.HypervisorImpl <em>Hypervisor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.HypervisorImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getHypervisor()
	 * @generated
	 */
	int HYPERVISOR = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Hypervisor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HYPERVISOR_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefImpl <em>Virtual Disk Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskDef()
	 * @generated
	 */
	int VIRTUAL_DISK_DEF = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Virtual Disk Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefUnitImpl <em>Virtual Disk Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskDefUnit()
	 * @generated
	 */
	int VIRTUAL_DISK_DEF_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Disk Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_DEF_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotImpl <em>Virtual Disk Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskSnapshot()
	 * @generated
	 */
	int VIRTUAL_DISK_SNAPSHOT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Virtual Disk Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotUnitImpl <em>Virtual Disk Snapshot Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskSnapshotUnit()
	 * @generated
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Disk Snapshot Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_DISK_SNAPSHOT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl <em>Virtual Ethernet NIC Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualEthernetNICDef()
	 * @generated
	 */
	int VIRTUAL_ETHERNET_NIC_DEF = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Mac Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Virtual Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Virtual Ethernet NIC Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefUnitImpl <em>Virtual Ethernet NIC Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualEthernetNICDefUnit()
	 * @generated
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Ethernet NIC Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_ETHERNET_NIC_DEF_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl <em>Virtual Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImage()
	 * @generated
	 */
	int VIRTUAL_IMAGE = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Created With VM Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__DATE_CREATED = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Date Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__DATE_LAST_MODIFIED = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__NOTES = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE__OWNER = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Virtual Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionImpl <em>Virtual Image Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageCollection()
	 * @generated
	 */
	int VIRTUAL_IMAGE_COLLECTION = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Collection Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Image Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionUnitImpl <em>Virtual Image Collection Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageCollectionUnit()
	 * @generated
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Image Collection Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_COLLECTION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageSnapshotContainerImpl <em>Virtual Image Snapshot Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageSnapshotContainerImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageSnapshotContainer()
	 * @generated
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Virtual Image Snapshot Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageUnitImpl <em>Virtual Image Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageUnit()
	 * @generated
	 */
	int VIRTUAL_IMAGE_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Image Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_IMAGE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualizationRoot()
	 * @generated
	 */
	int VIRTUALIZATION_ROOT = 12;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR = 3;

	/**
	 * The feature id for the '<em><b>Capability Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF = 4;

	/**
	 * The feature id for the '<em><b>Capability Virtual Disk Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT = 5;

	/**
	 * The feature id for the '<em><b>Capability Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF = 6;

	/**
	 * The feature id for the '<em><b>Capability Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE = 7;

	/**
	 * The feature id for the '<em><b>Capability Virtual Image Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION = 8;

	/**
	 * The feature id for the '<em><b>Capability Virtual Image Snapshot Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Capability Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF = 10;

	/**
	 * The feature id for the '<em><b>Capability Virtual Server Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT = 11;

	/**
	 * The feature id for the '<em><b>Capability Vmware ESX</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX = 12;

	/**
	 * The feature id for the '<em><b>Capability Vmware Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR = 13;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF = 14;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Disk Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT = 15;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF = 16;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual IDE Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF = 17;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE = 18;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Image Snapshot Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = 19;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual SCSI Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF = 20;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF = 21;

	/**
	 * The feature id for the '<em><b>Capability Vmware Virtual Server Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT = 22;

	/**
	 * The feature id for the '<em><b>Capability Xen Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR = 23;

	/**
	 * The feature id for the '<em><b>Capability Xen Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF = 24;

	/**
	 * The feature id for the '<em><b>Capability Xen Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF = 25;

	/**
	 * The feature id for the '<em><b>Capability Xen Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE = 26;

	/**
	 * The feature id for the '<em><b>Capability Xen Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF = 27;

	/**
	 * The feature id for the '<em><b>Unit Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT = 28;

	/**
	 * The feature id for the '<em><b>Unit Virtual Disk Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT = 29;

	/**
	 * The feature id for the '<em><b>Unit Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT = 30;

	/**
	 * The feature id for the '<em><b>Unit Virtual Image Collection Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT = 31;

	/**
	 * The feature id for the '<em><b>Unit Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT = 32;

	/**
	 * The feature id for the '<em><b>Unit Virtual Server Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT = 33;

	/**
	 * The feature id for the '<em><b>Unit Vmware ESX Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT = 34;

	/**
	 * The feature id for the '<em><b>Unit Vmware Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT = 35;

	/**
	 * The feature id for the '<em><b>Unit Vmware Virtual Disk Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT = 36;

	/**
	 * The feature id for the '<em><b>Unit Vmware Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT = 37;

	/**
	 * The feature id for the '<em><b>Unit Vmware Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT = 38;

	/**
	 * The feature id for the '<em><b>Unit Vmware Virtual Server Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT = 39;

	/**
	 * The feature id for the '<em><b>Unit Xen Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT = 40;

	/**
	 * The feature id for the '<em><b>Unit Xen Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT = 41;

	/**
	 * The feature id for the '<em><b>Unit Xen Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT = 42;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUALIZATION_ROOT_FEATURE_COUNT = 43;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl <em>Virtual Server Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerDef()
	 * @generated
	 */
	int VIRTUAL_SERVER_DEF = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__MEMORY_SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vcpus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__VCPUS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Virtual HW Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Virtual Server Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_DEF_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotImpl <em>Virtual Server Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerSnapshot()
	 * @generated
	 */
	int VIRTUAL_SERVER_SNAPSHOT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Virtual Server Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotUnitImpl <em>Virtual Server Snapshot Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerSnapshotUnit()
	 * @generated
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Virtual Server Snapshot Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_SERVER_SNAPSHOT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXImpl <em>VMware ESX</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareESX()
	 * @generated
	 */
	int VMWARE_ESX = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__ANNOTATIONS = OsPackage.OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__ATTRIBUTE_META_DATA = OsPackage.OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__EXTENDED_ATTRIBUTES = OsPackage.OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__ARTIFACT_GROUP = OsPackage.OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__ARTIFACTS = OsPackage.OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__CONSTRAINT_GROUP = OsPackage.OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__CONSTRAINTS = OsPackage.OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__DESCRIPTION = OsPackage.OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__DISPLAY_NAME = OsPackage.OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__MUTABLE = OsPackage.OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__NAME = OsPackage.OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__STEREOTYPES = OsPackage.OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__BUILD_VERSION = OsPackage.OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__LINK_TYPE = OsPackage.OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__ORIGIN = OsPackage.OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__FQDN = OsPackage.OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__HOSTNAME = OsPackage.OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__KERNEL_ARCHITECTURE = OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__KERNEL_VERSION = OsPackage.OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__KERNEL_WIDTH = OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__LOCALE = OsPackage.OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__MANUFACTURER = OsPackage.OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__OS_DISTRIBUTION = OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__OS_SERVICEPACK = OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__OS_TYPE = OsPackage.OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__OS_VERSION = OsPackage.OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX__TIME_ZONE = OsPackage.OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The number of structural features of the '<em>VMware ESX</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_FEATURE_COUNT = OsPackage.OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXUnitImpl <em>VMware ESX Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareESXUnit()
	 * @generated
	 */
	int VMWARE_ESX_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__ANNOTATIONS = OsPackage.OPERATING_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__ATTRIBUTE_META_DATA = OsPackage.OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__EXTENDED_ATTRIBUTES = OsPackage.OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__ARTIFACT_GROUP = OsPackage.OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__ARTIFACTS = OsPackage.OPERATING_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CONSTRAINT_GROUP = OsPackage.OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CONSTRAINTS = OsPackage.OPERATING_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__DESCRIPTION = OsPackage.OPERATING_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__DISPLAY_NAME = OsPackage.OPERATING_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__MUTABLE = OsPackage.OPERATING_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__NAME = OsPackage.OPERATING_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CAPABILITY_GROUP = OsPackage.OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CAPABILITIES = OsPackage.OPERATING_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__REQUIREMENT_GROUP = OsPackage.OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__REQUIREMENTS = OsPackage.OPERATING_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__UNIT_LINKS_GROUP = OsPackage.OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__UNIT_LINKS = OsPackage.OPERATING_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CONSTRAINT_LINKS = OsPackage.OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__REALIZATION_LINKS = OsPackage.OPERATING_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__STEREOTYPES = OsPackage.OPERATING_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__BUILD_VERSION = OsPackage.OPERATING_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CONCEPTUAL = OsPackage.OPERATING_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__CONFIGURATION_UNIT = OsPackage.OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__GOAL_INSTALL_STATE = OsPackage.OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__INIT_INSTALL_STATE = OsPackage.OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__ORIGIN = OsPackage.OPERATING_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT__PUBLISH_INTENT = OsPackage.OPERATING_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware ESX Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_ESX_UNIT_FEATURE_COUNT = OsPackage.OPERATING_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl <em>VMware Hypervisor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareHypervisor()
	 * @generated
	 */
	int VMWARE_HYPERVISOR = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__ANNOTATIONS = HYPERVISOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__ATTRIBUTE_META_DATA = HYPERVISOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__EXTENDED_ATTRIBUTES = HYPERVISOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__ARTIFACT_GROUP = HYPERVISOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__ARTIFACTS = HYPERVISOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__CONSTRAINT_GROUP = HYPERVISOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__CONSTRAINTS = HYPERVISOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__DESCRIPTION = HYPERVISOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__DISPLAY_NAME = HYPERVISOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__MUTABLE = HYPERVISOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__NAME = HYPERVISOR__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__STEREOTYPES = HYPERVISOR__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__BUILD_VERSION = HYPERVISOR__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__LINK_TYPE = HYPERVISOR__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__ORIGIN = HYPERVISOR__ORIGIN;

	/**
	 * The feature id for the '<em><b>Vmware Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__VMWARE_PRODUCT = HYPERVISOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vmware Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR__VMWARE_VERSION = HYPERVISOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VMware Hypervisor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_HYPERVISOR_FEATURE_COUNT = HYPERVISOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl <em>VMware Virtual Disk Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskDef()
	 * @generated
	 */
	int VMWARE_VIRTUAL_DISK_DEF = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__ANNOTATIONS = VIRTUAL_DISK_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA = VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__ARTIFACT_GROUP = VIRTUAL_DISK_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__ARTIFACTS = VIRTUAL_DISK_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__CONSTRAINT_GROUP = VIRTUAL_DISK_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__CONSTRAINTS = VIRTUAL_DISK_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__DESCRIPTION = VIRTUAL_DISK_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__DISPLAY_NAME = VIRTUAL_DISK_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__MUTABLE = VIRTUAL_DISK_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__NAME = VIRTUAL_DISK_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__STEREOTYPES = VIRTUAL_DISK_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__BUILD_VERSION = VIRTUAL_DISK_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__LINK_TYPE = VIRTUAL_DISK_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__ORIGIN = VIRTUAL_DISK_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Autodetect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__AUTODETECT = VIRTUAL_DISK_DEF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE = VIRTUAL_DISK_DEF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Disk Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__DISK_MODE = VIRTUAL_DISK_DEF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__FILE_NAME = VIRTUAL_DISK_DEF_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__PRESENT = VIRTUAL_DISK_DEF_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start Connected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED = VIRTUAL_DISK_DEF_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>VMware Virtual Disk Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT = VIRTUAL_DISK_DEF_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefUnitImpl <em>VMware Virtual Disk Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskDefUnit()
	 * @generated
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__ANNOTATIONS = VIRTUAL_DISK_DEF_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_DISK_DEF_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_DEF_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__ARTIFACT_GROUP = VIRTUAL_DISK_DEF_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__ARTIFACTS = VIRTUAL_DISK_DEF_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_GROUP = VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CONSTRAINTS = VIRTUAL_DISK_DEF_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__DESCRIPTION = VIRTUAL_DISK_DEF_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__DISPLAY_NAME = VIRTUAL_DISK_DEF_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__MUTABLE = VIRTUAL_DISK_DEF_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__NAME = VIRTUAL_DISK_DEF_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CAPABILITY_GROUP = VIRTUAL_DISK_DEF_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CAPABILITIES = VIRTUAL_DISK_DEF_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__REQUIREMENT_GROUP = VIRTUAL_DISK_DEF_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__REQUIREMENTS = VIRTUAL_DISK_DEF_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS_GROUP = VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS = VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_LINKS = VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__REALIZATION_LINKS = VIRTUAL_DISK_DEF_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__STEREOTYPES = VIRTUAL_DISK_DEF_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__BUILD_VERSION = VIRTUAL_DISK_DEF_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CONCEPTUAL = VIRTUAL_DISK_DEF_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__CONFIGURATION_UNIT = VIRTUAL_DISK_DEF_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__GOAL_INSTALL_STATE = VIRTUAL_DISK_DEF_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__INIT_INSTALL_STATE = VIRTUAL_DISK_DEF_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__ORIGIN = VIRTUAL_DISK_DEF_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT__PUBLISH_INTENT = VIRTUAL_DISK_DEF_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware Virtual Disk Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_DEF_UNIT_FEATURE_COUNT = VIRTUAL_DISK_DEF_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl <em>VMware Virtual Disk Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskSnapshot()
	 * @generated
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__ANNOTATIONS = VIRTUAL_DISK_SNAPSHOT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__ATTRIBUTE_META_DATA = VIRTUAL_DISK_SNAPSHOT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_SNAPSHOT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__ARTIFACT_GROUP = VIRTUAL_DISK_SNAPSHOT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__ARTIFACTS = VIRTUAL_DISK_SNAPSHOT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__CONSTRAINT_GROUP = VIRTUAL_DISK_SNAPSHOT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__CONSTRAINTS = VIRTUAL_DISK_SNAPSHOT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__DESCRIPTION = VIRTUAL_DISK_SNAPSHOT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__DISPLAY_NAME = VIRTUAL_DISK_SNAPSHOT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__MUTABLE = VIRTUAL_DISK_SNAPSHOT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__NAME = VIRTUAL_DISK_SNAPSHOT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__STEREOTYPES = VIRTUAL_DISK_SNAPSHOT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__BUILD_VERSION = VIRTUAL_DISK_SNAPSHOT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__LINK_TYPE = VIRTUAL_DISK_SNAPSHOT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__ORIGIN = VIRTUAL_DISK_SNAPSHOT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Disk File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME = VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Disk Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM = VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Snapshot Disk File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME = VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VMware Virtual Disk Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT = VIRTUAL_DISK_SNAPSHOT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotUnitImpl <em>VMware Virtual Disk Snapshot Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskSnapshotUnit()
	 * @generated
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__ANNOTATIONS = VIRTUAL_DISK_SNAPSHOT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_DISK_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACT_GROUP = VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACTS = VIRTUAL_DISK_SNAPSHOT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_GROUP = VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINTS = VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__DESCRIPTION = VIRTUAL_DISK_SNAPSHOT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__DISPLAY_NAME = VIRTUAL_DISK_SNAPSHOT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__MUTABLE = VIRTUAL_DISK_SNAPSHOT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__NAME = VIRTUAL_DISK_SNAPSHOT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITY_GROUP = VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITIES = VIRTUAL_DISK_SNAPSHOT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENT_GROUP = VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENTS = VIRTUAL_DISK_SNAPSHOT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS_GROUP = VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS = VIRTUAL_DISK_SNAPSHOT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_LINKS = VIRTUAL_DISK_SNAPSHOT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__REALIZATION_LINKS = VIRTUAL_DISK_SNAPSHOT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__STEREOTYPES = VIRTUAL_DISK_SNAPSHOT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__BUILD_VERSION = VIRTUAL_DISK_SNAPSHOT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CONCEPTUAL = VIRTUAL_DISK_SNAPSHOT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__CONFIGURATION_UNIT = VIRTUAL_DISK_SNAPSHOT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__GOAL_INSTALL_STATE = VIRTUAL_DISK_SNAPSHOT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__INIT_INSTALL_STATE = VIRTUAL_DISK_SNAPSHOT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__ORIGIN = VIRTUAL_DISK_SNAPSHOT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT__PUBLISH_INTENT = VIRTUAL_DISK_SNAPSHOT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware Virtual Disk Snapshot Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT_FEATURE_COUNT = VIRTUAL_DISK_SNAPSHOT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefImpl <em>VMware Virtual Ethernet NIC Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualEthernetNICDef()
	 * @generated
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__ANNOTATIONS = VIRTUAL_ETHERNET_NIC_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__ATTRIBUTE_META_DATA = VIRTUAL_ETHERNET_NIC_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_ETHERNET_NIC_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__ARTIFACT_GROUP = VIRTUAL_ETHERNET_NIC_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__ARTIFACTS = VIRTUAL_ETHERNET_NIC_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINT_GROUP = VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINTS = VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__DESCRIPTION = VIRTUAL_ETHERNET_NIC_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__DISPLAY_NAME = VIRTUAL_ETHERNET_NIC_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__MUTABLE = VIRTUAL_ETHERNET_NIC_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__NAME = VIRTUAL_ETHERNET_NIC_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__STEREOTYPES = VIRTUAL_ETHERNET_NIC_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__BUILD_VERSION = VIRTUAL_ETHERNET_NIC_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__LINK_TYPE = VIRTUAL_ETHERNET_NIC_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__ORIGIN = VIRTUAL_ETHERNET_NIC_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Mac Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS = VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS;

	/**
	 * The feature id for the '<em><b>Virtual Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE = VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE;

	/**
	 * The number of structural features of the '<em>VMware Virtual Ethernet NIC Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT = VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefUnitImpl <em>VMware Virtual Ethernet NIC Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualEthernetNICDefUnit()
	 * @generated
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ANNOTATIONS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__DESCRIPTION = VIRTUAL_ETHERNET_NIC_DEF_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__DISPLAY_NAME = VIRTUAL_ETHERNET_NIC_DEF_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__MUTABLE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__NAME = VIRTUAL_ETHERNET_NIC_DEF_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITY_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITIES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REALIZATION_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__STEREOTYPES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__BUILD_VERSION = VIRTUAL_ETHERNET_NIC_DEF_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONCEPTUAL = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONFIGURATION_UNIT = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__GOAL_INSTALL_STATE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__INIT_INSTALL_STATE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ORIGIN = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT__PUBLISH_INTENT = VIRTUAL_ETHERNET_NIC_DEF_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware Virtual Ethernet NIC Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT_FEATURE_COUNT = VIRTUAL_ETHERNET_NIC_DEF_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualIDEDiskDefImpl <em>VMware Virtual IDE Disk Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualIDEDiskDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualIDEDiskDef()
	 * @generated
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__ANNOTATIONS = VMWARE_VIRTUAL_DISK_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__ATTRIBUTE_META_DATA = VMWARE_VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__EXTENDED_ATTRIBUTES = VMWARE_VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__ARTIFACT_GROUP = VMWARE_VIRTUAL_DISK_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__ARTIFACTS = VMWARE_VIRTUAL_DISK_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__CONSTRAINT_GROUP = VMWARE_VIRTUAL_DISK_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__CONSTRAINTS = VMWARE_VIRTUAL_DISK_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__DESCRIPTION = VMWARE_VIRTUAL_DISK_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__DISPLAY_NAME = VMWARE_VIRTUAL_DISK_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__MUTABLE = VMWARE_VIRTUAL_DISK_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__NAME = VMWARE_VIRTUAL_DISK_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__STEREOTYPES = VMWARE_VIRTUAL_DISK_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__BUILD_VERSION = VMWARE_VIRTUAL_DISK_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__LINK_TYPE = VMWARE_VIRTUAL_DISK_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__ORIGIN = VMWARE_VIRTUAL_DISK_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Autodetect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__AUTODETECT = VMWARE_VIRTUAL_DISK_DEF__AUTODETECT;

	/**
	 * The feature id for the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__DEVICE_TYPE = VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Disk Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__DISK_MODE = VMWARE_VIRTUAL_DISK_DEF__DISK_MODE;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__FILE_NAME = VMWARE_VIRTUAL_DISK_DEF__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__PRESENT = VMWARE_VIRTUAL_DISK_DEF__PRESENT;

	/**
	 * The feature id for the '<em><b>Start Connected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF__START_CONNECTED = VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED;

	/**
	 * The number of structural features of the '<em>VMware Virtual IDE Disk Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IDE_DISK_DEF_FEATURE_COUNT = VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl <em>VMware Virtual Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImage()
	 * @generated
	 */
	int VMWARE_VIRTUAL_IMAGE = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__ANNOTATIONS = VIRTUAL_IMAGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__ATTRIBUTE_META_DATA = VIRTUAL_IMAGE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__EXTENDED_ATTRIBUTES = VIRTUAL_IMAGE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__ARTIFACT_GROUP = VIRTUAL_IMAGE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__ARTIFACTS = VIRTUAL_IMAGE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__CONSTRAINT_GROUP = VIRTUAL_IMAGE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__CONSTRAINTS = VIRTUAL_IMAGE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__DESCRIPTION = VIRTUAL_IMAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__DISPLAY_NAME = VIRTUAL_IMAGE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__MUTABLE = VIRTUAL_IMAGE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__NAME = VIRTUAL_IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__STEREOTYPES = VIRTUAL_IMAGE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__BUILD_VERSION = VIRTUAL_IMAGE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__LINK_TYPE = VIRTUAL_IMAGE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__ORIGIN = VIRTUAL_IMAGE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Created With VM Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL = VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL;

	/**
	 * The feature id for the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__DATE_CREATED = VIRTUAL_IMAGE__DATE_CREATED;

	/**
	 * The feature id for the '<em><b>Date Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__DATE_LAST_MODIFIED = VIRTUAL_IMAGE__DATE_LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__NOTES = VIRTUAL_IMAGE__NOTES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__OWNER = VIRTUAL_IMAGE__OWNER;

	/**
	 * The feature id for the '<em><b>Config Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION = VIRTUAL_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vmx File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE__VMX_FILE = VIRTUAL_IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VMware Virtual Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_FEATURE_COUNT = VIRTUAL_IMAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl <em>VMware Virtual Image Snapshot Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImageSnapshotContainer()
	 * @generated
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ANNOTATIONS = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ATTRIBUTE_META_DATA = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__EXTENDED_ATTRIBUTES = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACT_GROUP = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACTS = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINT_GROUP = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINTS = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DESCRIPTION = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DISPLAY_NAME = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__MUTABLE = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NAME = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__STEREOTYPES = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__BUILD_VERSION = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LINK_TYPE = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ORIGIN = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__ORIGIN;

	/**
	 * The feature id for the '<em><b>Current Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Num Snapshots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VMware Virtual Image Snapshot Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT = VIRTUAL_IMAGE_SNAPSHOT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageUnitImpl <em>VMware Virtual Image Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImageUnit()
	 * @generated
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__ANNOTATIONS = VIRTUAL_IMAGE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_IMAGE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_IMAGE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__ARTIFACT_GROUP = VIRTUAL_IMAGE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__ARTIFACTS = VIRTUAL_IMAGE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CONSTRAINT_GROUP = VIRTUAL_IMAGE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CONSTRAINTS = VIRTUAL_IMAGE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__DESCRIPTION = VIRTUAL_IMAGE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__DISPLAY_NAME = VIRTUAL_IMAGE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__MUTABLE = VIRTUAL_IMAGE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__NAME = VIRTUAL_IMAGE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CAPABILITY_GROUP = VIRTUAL_IMAGE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CAPABILITIES = VIRTUAL_IMAGE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__REQUIREMENT_GROUP = VIRTUAL_IMAGE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__REQUIREMENTS = VIRTUAL_IMAGE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__UNIT_LINKS_GROUP = VIRTUAL_IMAGE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__UNIT_LINKS = VIRTUAL_IMAGE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CONSTRAINT_LINKS = VIRTUAL_IMAGE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__REALIZATION_LINKS = VIRTUAL_IMAGE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__STEREOTYPES = VIRTUAL_IMAGE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__BUILD_VERSION = VIRTUAL_IMAGE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CONCEPTUAL = VIRTUAL_IMAGE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__CONFIGURATION_UNIT = VIRTUAL_IMAGE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__GOAL_INSTALL_STATE = VIRTUAL_IMAGE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__INIT_INSTALL_STATE = VIRTUAL_IMAGE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__ORIGIN = VIRTUAL_IMAGE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT__PUBLISH_INTENT = VIRTUAL_IMAGE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware Virtual Image Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_IMAGE_UNIT_FEATURE_COUNT = VIRTUAL_IMAGE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl <em>VMware Virtual SCSI Disk Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualSCSIDiskDef()
	 * @generated
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__ANNOTATIONS = VMWARE_VIRTUAL_DISK_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__ATTRIBUTE_META_DATA = VMWARE_VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__EXTENDED_ATTRIBUTES = VMWARE_VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__ARTIFACT_GROUP = VMWARE_VIRTUAL_DISK_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__ARTIFACTS = VMWARE_VIRTUAL_DISK_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__CONSTRAINT_GROUP = VMWARE_VIRTUAL_DISK_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__CONSTRAINTS = VMWARE_VIRTUAL_DISK_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__DESCRIPTION = VMWARE_VIRTUAL_DISK_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__DISPLAY_NAME = VMWARE_VIRTUAL_DISK_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__MUTABLE = VMWARE_VIRTUAL_DISK_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__NAME = VMWARE_VIRTUAL_DISK_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__STEREOTYPES = VMWARE_VIRTUAL_DISK_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__BUILD_VERSION = VMWARE_VIRTUAL_DISK_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__LINK_TYPE = VMWARE_VIRTUAL_DISK_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__ORIGIN = VMWARE_VIRTUAL_DISK_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Autodetect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__AUTODETECT = VMWARE_VIRTUAL_DISK_DEF__AUTODETECT;

	/**
	 * The feature id for the '<em><b>Device Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_TYPE = VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE;

	/**
	 * The feature id for the '<em><b>Disk Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__DISK_MODE = VMWARE_VIRTUAL_DISK_DEF__DISK_MODE;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__FILE_NAME = VMWARE_VIRTUAL_DISK_DEF__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Present</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__PRESENT = VMWARE_VIRTUAL_DISK_DEF__PRESENT;

	/**
	 * The feature id for the '<em><b>Start Connected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__START_CONNECTED = VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED;

	/**
	 * The feature id for the '<em><b>Controller Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER = VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Controller Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE = VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Device Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER = VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VMware Virtual SCSI Disk Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SCSI_DISK_DEF_FEATURE_COUNT = VMWARE_VIRTUAL_DISK_DEF_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl <em>VMware Virtual Server Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerDef()
	 * @generated
	 */
	int VMWARE_VIRTUAL_SERVER_DEF = 30;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__ANNOTATIONS = VIRTUAL_SERVER_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__ATTRIBUTE_META_DATA = VIRTUAL_SERVER_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_SERVER_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__ARTIFACT_GROUP = VIRTUAL_SERVER_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__ARTIFACTS = VIRTUAL_SERVER_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__CONSTRAINT_GROUP = VIRTUAL_SERVER_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__CONSTRAINTS = VIRTUAL_SERVER_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__DESCRIPTION = VIRTUAL_SERVER_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__DISPLAY_NAME = VIRTUAL_SERVER_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__MUTABLE = VIRTUAL_SERVER_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__NAME = VIRTUAL_SERVER_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__STEREOTYPES = VIRTUAL_SERVER_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__BUILD_VERSION = VIRTUAL_SERVER_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__LINK_TYPE = VIRTUAL_SERVER_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__ORIGIN = VIRTUAL_SERVER_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__MEMORY_SIZE = VIRTUAL_SERVER_DEF__MEMORY_SIZE;

	/**
	 * The feature id for the '<em><b>Vcpus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__VCPUS = VIRTUAL_SERVER_DEF__VCPUS;

	/**
	 * The feature id for the '<em><b>Virtual HW Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY = VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY;

	/**
	 * The feature id for the '<em><b>Guest OS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS = VIRTUAL_SERVER_DEF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Virtual HW Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION = VIRTUAL_SERVER_DEF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VMware Virtual Server Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_DEF_FEATURE_COUNT = VIRTUAL_SERVER_DEF_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl <em>VMware Virtual Server Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__ANNOTATIONS = VIRTUAL_SERVER_SNAPSHOT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__ATTRIBUTE_META_DATA = VIRTUAL_SERVER_SNAPSHOT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__EXTENDED_ATTRIBUTES = VIRTUAL_SERVER_SNAPSHOT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__ARTIFACT_GROUP = VIRTUAL_SERVER_SNAPSHOT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__ARTIFACTS = VIRTUAL_SERVER_SNAPSHOT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__CONSTRAINT_GROUP = VIRTUAL_SERVER_SNAPSHOT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__CONSTRAINTS = VIRTUAL_SERVER_SNAPSHOT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESCRIPTION = VIRTUAL_SERVER_SNAPSHOT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__DISPLAY_NAME = VIRTUAL_SERVER_SNAPSHOT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__MUTABLE = VIRTUAL_SERVER_SNAPSHOT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__NAME = VIRTUAL_SERVER_SNAPSHOT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__STEREOTYPES = VIRTUAL_SERVER_SNAPSHOT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__BUILD_VERSION = VIRTUAL_SERVER_SNAPSHOT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__LINK_TYPE = VIRTUAL_SERVER_SNAPSHOT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__ORIGIN = VIRTUAL_SERVER_SNAPSHOT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Create Time High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Create Time Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Desired Snapshot State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Num Disks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Snapshot Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>VMware Virtual Server Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT = VIRTUAL_SERVER_SNAPSHOT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotUnitImpl <em>VMware Virtual Server Snapshot Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerSnapshotUnit()
	 * @generated
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT = 32;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__ANNOTATIONS = VIRTUAL_SERVER_SNAPSHOT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_SERVER_SNAPSHOT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_SERVER_SNAPSHOT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACT_GROUP = VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACTS = VIRTUAL_SERVER_SNAPSHOT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_GROUP = VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINTS = VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__DESCRIPTION = VIRTUAL_SERVER_SNAPSHOT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__DISPLAY_NAME = VIRTUAL_SERVER_SNAPSHOT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__MUTABLE = VIRTUAL_SERVER_SNAPSHOT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__NAME = VIRTUAL_SERVER_SNAPSHOT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITY_GROUP = VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITIES = VIRTUAL_SERVER_SNAPSHOT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENT_GROUP = VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENTS = VIRTUAL_SERVER_SNAPSHOT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS_GROUP = VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS = VIRTUAL_SERVER_SNAPSHOT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_LINKS = VIRTUAL_SERVER_SNAPSHOT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__REALIZATION_LINKS = VIRTUAL_SERVER_SNAPSHOT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__STEREOTYPES = VIRTUAL_SERVER_SNAPSHOT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__BUILD_VERSION = VIRTUAL_SERVER_SNAPSHOT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CONCEPTUAL = VIRTUAL_SERVER_SNAPSHOT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__CONFIGURATION_UNIT = VIRTUAL_SERVER_SNAPSHOT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__GOAL_INSTALL_STATE = VIRTUAL_SERVER_SNAPSHOT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__INIT_INSTALL_STATE = VIRTUAL_SERVER_SNAPSHOT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__ORIGIN = VIRTUAL_SERVER_SNAPSHOT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT__PUBLISH_INTENT = VIRTUAL_SERVER_SNAPSHOT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>VMware Virtual Server Snapshot Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT_FEATURE_COUNT = VIRTUAL_SERVER_SNAPSHOT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenHypervisorImpl <em>Xen Hypervisor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenHypervisorImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenHypervisor()
	 * @generated
	 */
	int XEN_HYPERVISOR = 33;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__ANNOTATIONS = HYPERVISOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__ATTRIBUTE_META_DATA = HYPERVISOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__EXTENDED_ATTRIBUTES = HYPERVISOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__ARTIFACT_GROUP = HYPERVISOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__ARTIFACTS = HYPERVISOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__CONSTRAINT_GROUP = HYPERVISOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__CONSTRAINTS = HYPERVISOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__DESCRIPTION = HYPERVISOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__DISPLAY_NAME = HYPERVISOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__MUTABLE = HYPERVISOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__NAME = HYPERVISOR__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__STEREOTYPES = HYPERVISOR__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__BUILD_VERSION = HYPERVISOR__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__LINK_TYPE = HYPERVISOR__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__ORIGIN = HYPERVISOR__ORIGIN;

	/**
	 * The feature id for the '<em><b>Xen Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR__XEN_VERSION = HYPERVISOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xen Hypervisor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_HYPERVISOR_FEATURE_COUNT = HYPERVISOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl <em>Xen Virtual Disk Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualDiskDef()
	 * @generated
	 */
	int XEN_VIRTUAL_DISK_DEF = 34;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__ANNOTATIONS = VIRTUAL_DISK_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA = VIRTUAL_DISK_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__ARTIFACT_GROUP = VIRTUAL_DISK_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__ARTIFACTS = VIRTUAL_DISK_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__CONSTRAINT_GROUP = VIRTUAL_DISK_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__CONSTRAINTS = VIRTUAL_DISK_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__DESCRIPTION = VIRTUAL_DISK_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__DISPLAY_NAME = VIRTUAL_DISK_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__MUTABLE = VIRTUAL_DISK_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__NAME = VIRTUAL_DISK_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__STEREOTYPES = VIRTUAL_DISK_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__BUILD_VERSION = VIRTUAL_DISK_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__LINK_TYPE = VIRTUAL_DISK_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__ORIGIN = VIRTUAL_DISK_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Backend Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__BACKEND_DEV = VIRTUAL_DISK_DEF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frontend Dev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV = VIRTUAL_DISK_DEF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF__MODE = VIRTUAL_DISK_DEF_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Xen Virtual Disk Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_FEATURE_COUNT = VIRTUAL_DISK_DEF_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefUnitImpl <em>Xen Virtual Disk Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualDiskDefUnit()
	 * @generated
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT = 35;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__ANNOTATIONS = VIRTUAL_DISK_DEF_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_DISK_DEF_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_DISK_DEF_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__ARTIFACT_GROUP = VIRTUAL_DISK_DEF_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__ARTIFACTS = VIRTUAL_DISK_DEF_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_GROUP = VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CONSTRAINTS = VIRTUAL_DISK_DEF_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__DESCRIPTION = VIRTUAL_DISK_DEF_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__DISPLAY_NAME = VIRTUAL_DISK_DEF_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__MUTABLE = VIRTUAL_DISK_DEF_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__NAME = VIRTUAL_DISK_DEF_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CAPABILITY_GROUP = VIRTUAL_DISK_DEF_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CAPABILITIES = VIRTUAL_DISK_DEF_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__REQUIREMENT_GROUP = VIRTUAL_DISK_DEF_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__REQUIREMENTS = VIRTUAL_DISK_DEF_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS_GROUP = VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS = VIRTUAL_DISK_DEF_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_LINKS = VIRTUAL_DISK_DEF_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__REALIZATION_LINKS = VIRTUAL_DISK_DEF_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__STEREOTYPES = VIRTUAL_DISK_DEF_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__BUILD_VERSION = VIRTUAL_DISK_DEF_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CONCEPTUAL = VIRTUAL_DISK_DEF_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__CONFIGURATION_UNIT = VIRTUAL_DISK_DEF_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__GOAL_INSTALL_STATE = VIRTUAL_DISK_DEF_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__INIT_INSTALL_STATE = VIRTUAL_DISK_DEF_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__ORIGIN = VIRTUAL_DISK_DEF_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT__PUBLISH_INTENT = VIRTUAL_DISK_DEF_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Xen Virtual Disk Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_DISK_DEF_UNIT_FEATURE_COUNT = VIRTUAL_DISK_DEF_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefImpl <em>Xen Virtual Ethernet NIC Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualEthernetNICDef()
	 * @generated
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF = 36;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__ANNOTATIONS = VIRTUAL_ETHERNET_NIC_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__ATTRIBUTE_META_DATA = VIRTUAL_ETHERNET_NIC_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_ETHERNET_NIC_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__ARTIFACT_GROUP = VIRTUAL_ETHERNET_NIC_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__ARTIFACTS = VIRTUAL_ETHERNET_NIC_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINT_GROUP = VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINTS = VIRTUAL_ETHERNET_NIC_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__DESCRIPTION = VIRTUAL_ETHERNET_NIC_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__DISPLAY_NAME = VIRTUAL_ETHERNET_NIC_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__MUTABLE = VIRTUAL_ETHERNET_NIC_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__NAME = VIRTUAL_ETHERNET_NIC_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__STEREOTYPES = VIRTUAL_ETHERNET_NIC_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__BUILD_VERSION = VIRTUAL_ETHERNET_NIC_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__LINK_TYPE = VIRTUAL_ETHERNET_NIC_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__ORIGIN = VIRTUAL_ETHERNET_NIC_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Mac Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS = VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS;

	/**
	 * The feature id for the '<em><b>Virtual Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE = VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE;

	/**
	 * The feature id for the '<em><b>Network Bridge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE = VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xen Virtual Ethernet NIC Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT = VIRTUAL_ETHERNET_NIC_DEF_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefUnitImpl <em>Xen Virtual Ethernet NIC Def Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualEthernetNICDefUnit()
	 * @generated
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT = 37;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ANNOTATIONS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__DESCRIPTION = VIRTUAL_ETHERNET_NIC_DEF_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__DISPLAY_NAME = VIRTUAL_ETHERNET_NIC_DEF_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__MUTABLE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__NAME = VIRTUAL_ETHERNET_NIC_DEF_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITY_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITIES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENT_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENTS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS_GROUP = VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__REALIZATION_LINKS = VIRTUAL_ETHERNET_NIC_DEF_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__STEREOTYPES = VIRTUAL_ETHERNET_NIC_DEF_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__BUILD_VERSION = VIRTUAL_ETHERNET_NIC_DEF_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONCEPTUAL = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONFIGURATION_UNIT = VIRTUAL_ETHERNET_NIC_DEF_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__GOAL_INSTALL_STATE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__INIT_INSTALL_STATE = VIRTUAL_ETHERNET_NIC_DEF_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__ORIGIN = VIRTUAL_ETHERNET_NIC_DEF_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT__PUBLISH_INTENT = VIRTUAL_ETHERNET_NIC_DEF_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Xen Virtual Ethernet NIC Def Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT_FEATURE_COUNT = VIRTUAL_ETHERNET_NIC_DEF_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl <em>Xen Virtual Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualImage()
	 * @generated
	 */
	int XEN_VIRTUAL_IMAGE = 38;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__ANNOTATIONS = VIRTUAL_IMAGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__ATTRIBUTE_META_DATA = VIRTUAL_IMAGE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__EXTENDED_ATTRIBUTES = VIRTUAL_IMAGE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__ARTIFACT_GROUP = VIRTUAL_IMAGE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__ARTIFACTS = VIRTUAL_IMAGE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__CONSTRAINT_GROUP = VIRTUAL_IMAGE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__CONSTRAINTS = VIRTUAL_IMAGE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DESCRIPTION = VIRTUAL_IMAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DISPLAY_NAME = VIRTUAL_IMAGE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__MUTABLE = VIRTUAL_IMAGE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__NAME = VIRTUAL_IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__STEREOTYPES = VIRTUAL_IMAGE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__BUILD_VERSION = VIRTUAL_IMAGE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__LINK_TYPE = VIRTUAL_IMAGE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__ORIGIN = VIRTUAL_IMAGE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Created With VM Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL = VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL;

	/**
	 * The feature id for the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DATE_CREATED = VIRTUAL_IMAGE__DATE_CREATED;

	/**
	 * The feature id for the '<em><b>Date Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DATE_LAST_MODIFIED = VIRTUAL_IMAGE__DATE_LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__NOTES = VIRTUAL_IMAGE__NOTES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__OWNER = VIRTUAL_IMAGE__OWNER;

	/**
	 * The feature id for the '<em><b>Domain Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE = VIRTUAL_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE__DOMAIN_NAME = VIRTUAL_IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xen Virtual Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_FEATURE_COUNT = VIRTUAL_IMAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageUnitImpl <em>Xen Virtual Image Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageUnitImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualImageUnit()
	 * @generated
	 */
	int XEN_VIRTUAL_IMAGE_UNIT = 39;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__ANNOTATIONS = VIRTUAL_IMAGE_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__ATTRIBUTE_META_DATA = VIRTUAL_IMAGE_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__EXTENDED_ATTRIBUTES = VIRTUAL_IMAGE_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__ARTIFACT_GROUP = VIRTUAL_IMAGE_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__ARTIFACTS = VIRTUAL_IMAGE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CONSTRAINT_GROUP = VIRTUAL_IMAGE_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CONSTRAINTS = VIRTUAL_IMAGE_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__DESCRIPTION = VIRTUAL_IMAGE_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__DISPLAY_NAME = VIRTUAL_IMAGE_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__MUTABLE = VIRTUAL_IMAGE_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__NAME = VIRTUAL_IMAGE_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CAPABILITY_GROUP = VIRTUAL_IMAGE_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CAPABILITIES = VIRTUAL_IMAGE_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__REQUIREMENT_GROUP = VIRTUAL_IMAGE_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__REQUIREMENTS = VIRTUAL_IMAGE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__UNIT_LINKS_GROUP = VIRTUAL_IMAGE_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__UNIT_LINKS = VIRTUAL_IMAGE_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CONSTRAINT_LINKS = VIRTUAL_IMAGE_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__REALIZATION_LINKS = VIRTUAL_IMAGE_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__STEREOTYPES = VIRTUAL_IMAGE_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__BUILD_VERSION = VIRTUAL_IMAGE_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CONCEPTUAL = VIRTUAL_IMAGE_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__CONFIGURATION_UNIT = VIRTUAL_IMAGE_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__GOAL_INSTALL_STATE = VIRTUAL_IMAGE_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__INIT_INSTALL_STATE = VIRTUAL_IMAGE_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__ORIGIN = VIRTUAL_IMAGE_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT__PUBLISH_INTENT = VIRTUAL_IMAGE_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Xen Virtual Image Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_IMAGE_UNIT_FEATURE_COUNT = VIRTUAL_IMAGE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualServerDefImpl <em>Xen Virtual Server Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualServerDefImpl
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualServerDef()
	 * @generated
	 */
	int XEN_VIRTUAL_SERVER_DEF = 40;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__ANNOTATIONS = VIRTUAL_SERVER_DEF__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__ATTRIBUTE_META_DATA = VIRTUAL_SERVER_DEF__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__EXTENDED_ATTRIBUTES = VIRTUAL_SERVER_DEF__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__ARTIFACT_GROUP = VIRTUAL_SERVER_DEF__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__ARTIFACTS = VIRTUAL_SERVER_DEF__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__CONSTRAINT_GROUP = VIRTUAL_SERVER_DEF__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__CONSTRAINTS = VIRTUAL_SERVER_DEF__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__DESCRIPTION = VIRTUAL_SERVER_DEF__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__DISPLAY_NAME = VIRTUAL_SERVER_DEF__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__MUTABLE = VIRTUAL_SERVER_DEF__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__NAME = VIRTUAL_SERVER_DEF__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__STEREOTYPES = VIRTUAL_SERVER_DEF__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__BUILD_VERSION = VIRTUAL_SERVER_DEF__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__LINK_TYPE = VIRTUAL_SERVER_DEF__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__ORIGIN = VIRTUAL_SERVER_DEF__ORIGIN;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__MEMORY_SIZE = VIRTUAL_SERVER_DEF__MEMORY_SIZE;

	/**
	 * The feature id for the '<em><b>Vcpus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__VCPUS = VIRTUAL_SERVER_DEF__VCPUS;

	/**
	 * The feature id for the '<em><b>Virtual HW Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY = VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY;

	/**
	 * The number of structural features of the '<em>Xen Virtual Server Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEN_VIRTUAL_SERVER_DEF_FEATURE_COUNT = VIRTUAL_SERVER_DEF_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType <em>Desired Snapshot State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getDesiredSnapshotStateType()
	 * @generated
	 */
	int DESIRED_SNAPSHOT_STATE_TYPE = 41;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType <em>Virtual Network Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualNetworkConnectionType()
	 * @generated
	 */
	int VIRTUAL_NETWORK_CONNECTION_TYPE = 42;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType <em>VMware SCSI Controller Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareSCSIControllerType()
	 * @generated
	 */
	int VMWARE_SCSI_CONTROLLER_TYPE = 43;

	/**
	 * The meta object id for the '<em>Desired Snapshot State Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getDesiredSnapshotStateTypeObject()
	 * @generated
	 */
	int DESIRED_SNAPSHOT_STATE_TYPE_OBJECT = 44;

	/**
	 * The meta object id for the '<em>Virtual Network Connection Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualNetworkConnectionTypeObject()
	 * @generated
	 */
	int VIRTUAL_NETWORK_CONNECTION_TYPE_OBJECT = 45;

	/**
	 * The meta object id for the '<em>VMware SCSI Controller Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareSCSIControllerTypeObject()
	 * @generated
	 */
	int VMWARE_SCSI_CONTROLLER_TYPE_OBJECT = 46;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.Hypervisor <em>Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.Hypervisor
	 * @generated
	 */
	EClass getHypervisor();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef <em>Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDef
	 * @generated
	 */
	EClass getVirtualDiskDef();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit <em>Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskDefUnit
	 * @generated
	 */
	EClass getVirtualDiskDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot <em>Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Disk Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshot
	 * @generated
	 */
	EClass getVirtualDiskSnapshot();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit <em>Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Disk Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualDiskSnapshotUnit
	 * @generated
	 */
	EClass getVirtualDiskSnapshotUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef <em>Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef
	 * @generated
	 */
	EClass getVirtualEthernetNICDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getMacAddress <em>Mac Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mac Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getMacAddress()
	 * @see #getVirtualEthernetNICDef()
	 * @generated
	 */
	EAttribute getVirtualEthernetNICDef_MacAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType <em>Virtual Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual Connection Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType()
	 * @see #getVirtualEthernetNICDef()
	 * @generated
	 */
	EAttribute getVirtualEthernetNICDef_VirtualConnectionType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit <em>Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDefUnit
	 * @generated
	 */
	EClass getVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage <em>Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage
	 * @generated
	 */
	EClass getVirtualImage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getCreatedWithVMTool <em>Created With VM Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created With VM Tool</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getCreatedWithVMTool()
	 * @see #getVirtualImage()
	 * @generated
	 */
	EAttribute getVirtualImage_CreatedWithVMTool();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateCreated <em>Date Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Created</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateCreated()
	 * @see #getVirtualImage()
	 * @generated
	 */
	EAttribute getVirtualImage_DateCreated();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateLastModified <em>Date Last Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Last Modified</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateLastModified()
	 * @see #getVirtualImage()
	 * @generated
	 */
	EAttribute getVirtualImage_DateLastModified();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notes</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getNotes()
	 * @see #getVirtualImage()
	 * @generated
	 */
	EAttribute getVirtualImage_Notes();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getOwner()
	 * @see #getVirtualImage()
	 * @generated
	 */
	EAttribute getVirtualImage_Owner();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection <em>Virtual Image Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Image Collection</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection
	 * @generated
	 */
	EClass getVirtualImageCollection();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection#getCollectionId <em>Collection Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection#getCollectionId()
	 * @see #getVirtualImageCollection()
	 * @generated
	 */
	EAttribute getVirtualImageCollection_CollectionId();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit <em>Virtual Image Collection Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Image Collection Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollectionUnit
	 * @generated
	 */
	EClass getVirtualImageCollectionUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer <em>Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Image Snapshot Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageSnapshotContainer
	 * @generated
	 */
	EClass getVirtualImageSnapshotContainer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit <em>Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualImageUnit
	 * @generated
	 */
	EClass getVirtualImageUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot
	 * @generated
	 */
	EClass getVirtualizationRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getMixed()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EAttribute getVirtualizationRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXMLNSPrefixMap()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXSISchemaLocation()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityHypervisor <em>Capability Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityHypervisor()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityHypervisor();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskDef <em>Capability Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualDiskDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskSnapshot <em>Capability Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Disk Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskSnapshot()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualDiskSnapshot();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualEthernetNICDef <em>Capability Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualEthernetNICDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualEthernetNICDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImage <em>Capability Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImage()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualImage();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageCollection <em>Capability Virtual Image Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Image Collection</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageCollection()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualImageCollection();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageSnapshotContainer <em>Capability Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Image Snapshot Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageSnapshotContainer()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerDef <em>Capability Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualServerDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerSnapshot <em>Capability Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Virtual Server Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerSnapshot()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVirtualServerSnapshot();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareESX <em>Capability Vmware ESX</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware ESX</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareESX()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareESX();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareHypervisor <em>Capability Vmware Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareHypervisor()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareHypervisor();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskDef <em>Capability Vmware Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualDiskDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskSnapshot <em>Capability Vmware Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Disk Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskSnapshot()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualEthernetNICDef <em>Capability Vmware Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualEthernetNICDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualIDEDiskDef <em>Capability Vmware Virtual IDE Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual IDE Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualIDEDiskDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImage <em>Capability Vmware Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImage()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualImage();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImageSnapshotContainer <em>Capability Vmware Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Image Snapshot Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImageSnapshotContainer()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualSCSIDiskDef <em>Capability Vmware Virtual SCSI Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual SCSI Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualSCSIDiskDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerDef <em>Capability Vmware Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualServerDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerSnapshot <em>Capability Vmware Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Vmware Virtual Server Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerSnapshot()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenHypervisor <em>Capability Xen Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Xen Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenHypervisor()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityXenHypervisor();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualDiskDef <em>Capability Xen Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Xen Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualDiskDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityXenVirtualDiskDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualEthernetNICDef <em>Capability Xen Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Xen Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualEthernetNICDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualImage <em>Capability Xen Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Xen Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualImage()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityXenVirtualImage();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualServerDef <em>Capability Xen Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Xen Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualServerDef()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_CapabilityXenVirtualServerDef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskDefUnit <em>Unit Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualDiskDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskSnapshotUnit <em>Unit Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Disk Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskSnapshotUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualDiskSnapshotUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualEthernetNICDefUnit <em>Unit Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualEthernetNICDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageCollectionUnit <em>Unit Virtual Image Collection Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Image Collection Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageCollectionUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualImageCollectionUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageUnit <em>Unit Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualImageUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualServerSnapshotUnit <em>Unit Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Virtual Server Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualServerSnapshotUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVirtualServerSnapshotUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareESXUnit <em>Unit Vmware ESX Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware ESX Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareESXUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareESXUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskDefUnit <em>Unit Vmware Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskSnapshotUnit <em>Unit Vmware Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware Virtual Disk Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskSnapshotUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualEthernetNICDefUnit <em>Unit Vmware Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualEthernetNICDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualImageUnit <em>Unit Vmware Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualImageUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareVirtualImageUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualServerSnapshotUnit <em>Unit Vmware Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Vmware Virtual Server Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualServerSnapshotUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualDiskDefUnit <em>Unit Xen Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Xen Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualDiskDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitXenVirtualDiskDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualEthernetNICDefUnit <em>Unit Xen Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Xen Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualEthernetNICDefUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualImageUnit <em>Unit Xen Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Xen Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualImageUnit()
	 * @see #getVirtualizationRoot()
	 * @generated
	 */
	EReference getVirtualizationRoot_UnitXenVirtualImageUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef <em>Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef
	 * @generated
	 */
	EClass getVirtualServerDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getMemorySize()
	 * @see #getVirtualServerDef()
	 * @generated
	 */
	EAttribute getVirtualServerDef_MemorySize();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVcpus <em>Vcpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vcpus</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVcpus()
	 * @see #getVirtualServerDef()
	 * @generated
	 */
	EAttribute getVirtualServerDef_Vcpus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVirtualHWFamily <em>Virtual HW Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual HW Family</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef#getVirtualHWFamily()
	 * @see #getVirtualServerDef()
	 * @generated
	 */
	EAttribute getVirtualServerDef_VirtualHWFamily();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot <em>Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Server Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot
	 * @generated
	 */
	EClass getVirtualServerSnapshot();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit <em>Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Server Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshotUnit
	 * @generated
	 */
	EClass getVirtualServerSnapshotUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareESX <em>VMware ESX</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware ESX</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareESX
	 * @generated
	 */
	EClass getVMwareESX();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit <em>VMware ESX Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware ESX Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit
	 * @generated
	 */
	EClass getVMwareESXUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor <em>VMware Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor
	 * @generated
	 */
	EClass getVMwareHypervisor();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareProduct <em>Vmware Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vmware Product</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareProduct()
	 * @see #getVMwareHypervisor()
	 * @generated
	 */
	EAttribute getVMwareHypervisor_VmwareProduct();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareVersion <em>Vmware Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vmware Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor#getVmwareVersion()
	 * @see #getVMwareHypervisor()
	 * @generated
	 */
	EAttribute getVMwareHypervisor_VmwareVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef <em>VMware Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef
	 * @generated
	 */
	EClass getVMwareVirtualDiskDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect <em>Autodetect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autodetect</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isAutodetect()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_Autodetect();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDeviceType()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_DeviceType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDiskMode <em>Disk Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disk Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getDiskMode()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_DiskMode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#getFileName()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_FileName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent <em>Present</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Present</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isPresent()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_Present();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected <em>Start Connected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Connected</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDef#isStartConnected()
	 * @see #getVMwareVirtualDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskDef_StartConnected();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit <em>VMware Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskDefUnit
	 * @generated
	 */
	EClass getVMwareVirtualDiskDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot <em>VMware Virtual Disk Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Disk Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot
	 * @generated
	 */
	EClass getVMwareVirtualDiskSnapshot();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskFileName <em>Disk File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disk File Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskFileName()
	 * @see #getVMwareVirtualDiskSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskSnapshot_DiskFileName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum <em>Disk Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disk Num</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum()
	 * @see #getVMwareVirtualDiskSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskSnapshot_DiskNum();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getSnapshotDiskFileName <em>Snapshot Disk File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot Disk File Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getSnapshotDiskFileName()
	 * @see #getVMwareVirtualDiskSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualDiskSnapshot_SnapshotDiskFileName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit <em>VMware Virtual Disk Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Disk Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshotUnit
	 * @generated
	 */
	EClass getVMwareVirtualDiskSnapshotUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef <em>VMware Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDef
	 * @generated
	 */
	EClass getVMwareVirtualEthernetNICDef();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit <em>VMware Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualEthernetNICDefUnit
	 * @generated
	 */
	EClass getVMwareVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef <em>VMware Virtual IDE Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual IDE Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualIDEDiskDef
	 * @generated
	 */
	EClass getVMwareVirtualIDEDiskDef();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage <em>VMware Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage
	 * @generated
	 */
	EClass getVMwareVirtualImage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getConfigVersion <em>Config Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getConfigVersion()
	 * @see #getVMwareVirtualImage()
	 * @generated
	 */
	EAttribute getVMwareVirtualImage_ConfigVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getVmxFile <em>Vmx File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vmx File</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getVmxFile()
	 * @see #getVMwareVirtualImage()
	 * @generated
	 */
	EAttribute getVMwareVirtualImage_VmxFile();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer <em>VMware Virtual Image Snapshot Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Image Snapshot Container</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer
	 * @generated
	 */
	EClass getVMwareVirtualImageSnapshotContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getCurrentSnapshotUid <em>Current Snapshot Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Snapshot Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getCurrentSnapshotUid()
	 * @see #getVMwareVirtualImageSnapshotContainer()
	 * @generated
	 */
	EAttribute getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getLastSnapshotUid <em>Last Snapshot Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Snapshot Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getLastSnapshotUid()
	 * @see #getVMwareVirtualImageSnapshotContainer()
	 * @generated
	 */
	EAttribute getVMwareVirtualImageSnapshotContainer_LastSnapshotUid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots <em>Num Snapshots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Snapshots</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots()
	 * @see #getVMwareVirtualImageSnapshotContainer()
	 * @generated
	 */
	EAttribute getVMwareVirtualImageSnapshotContainer_NumSnapshots();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit <em>VMware Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit
	 * @generated
	 */
	EClass getVMwareVirtualImageUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef <em>VMware Virtual SCSI Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual SCSI Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef
	 * @generated
	 */
	EClass getVMwareVirtualSCSIDiskDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber <em>Controller Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Controller Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerNumber()
	 * @see #getVMwareVirtualSCSIDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualSCSIDiskDef_ControllerNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType <em>Controller Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Controller Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getControllerType()
	 * @see #getVMwareVirtualSCSIDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualSCSIDiskDef_ControllerType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber <em>Device Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Device Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualSCSIDiskDef#getDeviceNumber()
	 * @see #getVMwareVirtualSCSIDiskDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualSCSIDiskDef_DeviceNumber();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef <em>VMware Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef
	 * @generated
	 */
	EClass getVMwareVirtualServerDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getGuestOS <em>Guest OS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guest OS</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getGuestOS()
	 * @see #getVMwareVirtualServerDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerDef_GuestOS();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getVirtualHWVersion <em>Virtual HW Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual HW Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerDef#getVirtualHWVersion()
	 * @see #getVMwareVirtualServerDef()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerDef_VirtualHWVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot <em>VMware Virtual Server Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Server Snapshot</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot
	 * @generated
	 */
	EClass getVMwareVirtualServerSnapshot();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh <em>Create Time High</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Time High</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_CreateTimeHigh();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow <em>Create Time Low</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Time Low</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_CreateTimeLow();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent <em>Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_Current();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState <em>Desired Snapshot State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desired Snapshot State</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_DesiredSnapshotState();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getFilename()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_Filename();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks <em>Num Disks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Disks</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_NumDisks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getParentSnapshotUid <em>Parent Snapshot Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Snapshot Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getParentSnapshotUid()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_ParentSnapshotUid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getSnapshotType <em>Snapshot Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getSnapshotType()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_SnapshotType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getUid()
	 * @see #getVMwareVirtualServerSnapshot()
	 * @generated
	 */
	EAttribute getVMwareVirtualServerSnapshot_Uid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit <em>VMware Virtual Server Snapshot Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VMware Virtual Server Snapshot Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshotUnit
	 * @generated
	 */
	EClass getVMwareVirtualServerSnapshotUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor <em>Xen Hypervisor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Hypervisor</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenHypervisor
	 * @generated
	 */
	EClass getXenHypervisor();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenHypervisor#getXenVersion <em>Xen Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xen Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenHypervisor#getXenVersion()
	 * @see #getXenHypervisor()
	 * @generated
	 */
	EAttribute getXenHypervisor_XenVersion();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef <em>Xen Virtual Disk Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Disk Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef
	 * @generated
	 */
	EClass getXenVirtualDiskDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getBackendDev <em>Backend Dev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backend Dev</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getBackendDev()
	 * @see #getXenVirtualDiskDef()
	 * @generated
	 */
	EAttribute getXenVirtualDiskDef_BackendDev();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getFrontendDev <em>Frontend Dev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frontend Dev</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getFrontendDev()
	 * @see #getXenVirtualDiskDef()
	 * @generated
	 */
	EAttribute getXenVirtualDiskDef_FrontendDev();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDef#getMode()
	 * @see #getXenVirtualDiskDef()
	 * @generated
	 */
	EAttribute getXenVirtualDiskDef_Mode();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit <em>Xen Virtual Disk Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Disk Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualDiskDefUnit
	 * @generated
	 */
	EClass getXenVirtualDiskDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef <em>Xen Virtual Ethernet NIC Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Ethernet NIC Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef
	 * @generated
	 */
	EClass getXenVirtualEthernetNICDef();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef#getNetworkBridge <em>Network Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Network Bridge</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef#getNetworkBridge()
	 * @see #getXenVirtualEthernetNICDef()
	 * @generated
	 */
	EAttribute getXenVirtualEthernetNICDef_NetworkBridge();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit <em>Xen Virtual Ethernet NIC Def Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Ethernet NIC Def Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDefUnit
	 * @generated
	 */
	EClass getXenVirtualEthernetNICDefUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage <em>Xen Virtual Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Image</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage
	 * @generated
	 */
	EClass getXenVirtualImage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainConfigFile <em>Domain Config File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Config File</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainConfigFile()
	 * @see #getXenVirtualImage()
	 * @generated
	 */
	EAttribute getXenVirtualImage_DomainConfigFile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainName <em>Domain Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainName()
	 * @see #getXenVirtualImage()
	 * @generated
	 */
	EAttribute getXenVirtualImage_DomainName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit <em>Xen Virtual Image Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Image Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit
	 * @generated
	 */
	EClass getXenVirtualImageUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef <em>Xen Virtual Server Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xen Virtual Server Def</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.XenVirtualServerDef
	 * @generated
	 */
	EClass getXenVirtualServerDef();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType <em>Desired Snapshot State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Desired Snapshot State Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @generated
	 */
	EEnum getDesiredSnapshotStateType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType <em>Virtual Network Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Virtual Network Connection Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @generated
	 */
	EEnum getVirtualNetworkConnectionType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType <em>VMware SCSI Controller Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>VMware SCSI Controller Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @generated
	 */
	EEnum getVMwareSCSIControllerType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType <em>Desired Snapshot State Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Desired Snapshot State Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType"
	 *        extendedMetaData="name='DesiredSnapshotStateType:Object' baseType='DesiredSnapshotStateType'"
	 * @generated
	 */
	EDataType getDesiredSnapshotStateTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType <em>Virtual Network Connection Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Virtual Network Connection Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType"
	 *        extendedMetaData="name='VirtualNetworkConnectionType:Object' baseType='VirtualNetworkConnectionType'"
	 * @generated
	 */
	EDataType getVirtualNetworkConnectionTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType <em>VMware SCSI Controller Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>VMware SCSI Controller Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType"
	 *        extendedMetaData="name='VMwareSCSIControllerType:Object' baseType='VMwareSCSIControllerType'"
	 * @generated
	 */
	EDataType getVMwareSCSIControllerTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VirtualizationFactory getVirtualizationFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.HypervisorImpl <em>Hypervisor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.HypervisorImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getHypervisor()
		 * @generated
		 */
		EClass HYPERVISOR = eINSTANCE.getHypervisor();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefImpl <em>Virtual Disk Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskDef()
		 * @generated
		 */
		EClass VIRTUAL_DISK_DEF = eINSTANCE.getVirtualDiskDef();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefUnitImpl <em>Virtual Disk Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskDefUnit()
		 * @generated
		 */
		EClass VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotImpl <em>Virtual Disk Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskSnapshot()
		 * @generated
		 */
		EClass VIRTUAL_DISK_SNAPSHOT = eINSTANCE.getVirtualDiskSnapshot();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotUnitImpl <em>Virtual Disk Snapshot Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualDiskSnapshotUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualDiskSnapshotUnit()
		 * @generated
		 */
		EClass VIRTUAL_DISK_SNAPSHOT_UNIT = eINSTANCE.getVirtualDiskSnapshotUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl <em>Virtual Ethernet NIC Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualEthernetNICDef()
		 * @generated
		 */
		EClass VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '<em><b>Mac Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_ETHERNET_NIC_DEF__MAC_ADDRESS = eINSTANCE.getVirtualEthernetNICDef_MacAddress();

		/**
		 * The meta object literal for the '<em><b>Virtual Connection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_ETHERNET_NIC_DEF__VIRTUAL_CONNECTION_TYPE = eINSTANCE.getVirtualEthernetNICDef_VirtualConnectionType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefUnitImpl <em>Virtual Ethernet NIC Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualEthernetNICDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualEthernetNICDefUnit()
		 * @generated
		 */
		EClass VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl <em>Virtual Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImage()
		 * @generated
		 */
		EClass VIRTUAL_IMAGE = eINSTANCE.getVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Created With VM Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL = eINSTANCE.getVirtualImage_CreatedWithVMTool();

		/**
		 * The meta object literal for the '<em><b>Date Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE__DATE_CREATED = eINSTANCE.getVirtualImage_DateCreated();

		/**
		 * The meta object literal for the '<em><b>Date Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE__DATE_LAST_MODIFIED = eINSTANCE.getVirtualImage_DateLastModified();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE__NOTES = eINSTANCE.getVirtualImage_Notes();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE__OWNER = eINSTANCE.getVirtualImage_Owner();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionImpl <em>Virtual Image Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageCollection()
		 * @generated
		 */
		EClass VIRTUAL_IMAGE_COLLECTION = eINSTANCE.getVirtualImageCollection();

		/**
		 * The meta object literal for the '<em><b>Collection Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_IMAGE_COLLECTION__COLLECTION_ID = eINSTANCE.getVirtualImageCollection_CollectionId();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionUnitImpl <em>Virtual Image Collection Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageCollectionUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageCollectionUnit()
		 * @generated
		 */
		EClass VIRTUAL_IMAGE_COLLECTION_UNIT = eINSTANCE.getVirtualImageCollectionUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageSnapshotContainerImpl <em>Virtual Image Snapshot Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageSnapshotContainerImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageSnapshotContainer()
		 * @generated
		 */
		EClass VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = eINSTANCE.getVirtualImageSnapshotContainer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageUnitImpl <em>Virtual Image Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualImageUnit()
		 * @generated
		 */
		EClass VIRTUAL_IMAGE_UNIT = eINSTANCE.getVirtualImageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationRootImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualizationRoot()
		 * @generated
		 */
		EClass VIRTUALIZATION_ROOT = eINSTANCE.getVirtualizationRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUALIZATION_ROOT__MIXED = eINSTANCE.getVirtualizationRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getVirtualizationRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getVirtualizationRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Hypervisor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_HYPERVISOR = eINSTANCE.getVirtualizationRoot_CapabilityHypervisor();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Disk Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVirtualDiskDef();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Disk Snapshot</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_DISK_SNAPSHOT = eINSTANCE.getVirtualizationRoot_CapabilityVirtualDiskSnapshot();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Ethernet NIC Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE = eINSTANCE.getVirtualizationRoot_CapabilityVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Image Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_COLLECTION = eINSTANCE.getVirtualizationRoot_CapabilityVirtualImageCollection();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Image Snapshot Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = eINSTANCE.getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Server Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVirtualServerDef();

		/**
		 * The meta object literal for the '<em><b>Capability Virtual Server Snapshot</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VIRTUAL_SERVER_SNAPSHOT = eINSTANCE.getVirtualizationRoot_CapabilityVirtualServerSnapshot();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware ESX</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_ESX = eINSTANCE.getVirtualizationRoot_CapabilityVmwareESX();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Hypervisor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_HYPERVISOR = eINSTANCE.getVirtualizationRoot_CapabilityVmwareHypervisor();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Disk Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualDiskDef();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Disk Snapshot</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_DISK_SNAPSHOT = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Ethernet NIC Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual IDE Disk Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IDE_DISK_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Image Snapshot Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual SCSI Disk Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SCSI_DISK_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Server Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_DEF = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualServerDef();

		/**
		 * The meta object literal for the '<em><b>Capability Vmware Virtual Server Snapshot</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_VMWARE_VIRTUAL_SERVER_SNAPSHOT = eINSTANCE.getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot();

		/**
		 * The meta object literal for the '<em><b>Capability Xen Hypervisor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_XEN_HYPERVISOR = eINSTANCE.getVirtualizationRoot_CapabilityXenHypervisor();

		/**
		 * The meta object literal for the '<em><b>Capability Xen Virtual Disk Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_DISK_DEF = eINSTANCE.getVirtualizationRoot_CapabilityXenVirtualDiskDef();

		/**
		 * The meta object literal for the '<em><b>Capability Xen Virtual Ethernet NIC Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '<em><b>Capability Xen Virtual Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_IMAGE = eINSTANCE.getVirtualizationRoot_CapabilityXenVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Capability Xen Virtual Server Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__CAPABILITY_XEN_VIRTUAL_SERVER_DEF = eINSTANCE.getVirtualizationRoot_CapabilityXenVirtualServerDef();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Disk Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Disk Snapshot Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_DISK_SNAPSHOT_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualDiskSnapshotUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Ethernet NIC Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Image Collection Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_COLLECTION_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualImageCollectionUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Image Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_IMAGE_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualImageUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Virtual Server Snapshot Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VIRTUAL_SERVER_SNAPSHOT_UNIT = eINSTANCE.getVirtualizationRoot_UnitVirtualServerSnapshotUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware ESX Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_ESX_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareESXUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware Virtual Disk Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware Virtual Disk Snapshot Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware Virtual Ethernet NIC Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware Virtual Image Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_IMAGE_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareVirtualImageUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Vmware Virtual Server Snapshot Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT = eINSTANCE.getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Xen Virtual Disk Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitXenVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Xen Virtual Ethernet NIC Def Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Xen Virtual Image Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUALIZATION_ROOT__UNIT_XEN_VIRTUAL_IMAGE_UNIT = eINSTANCE.getVirtualizationRoot_UnitXenVirtualImageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl <em>Virtual Server Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerDef()
		 * @generated
		 */
		EClass VIRTUAL_SERVER_DEF = eINSTANCE.getVirtualServerDef();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_SERVER_DEF__MEMORY_SIZE = eINSTANCE.getVirtualServerDef_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Vcpus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_SERVER_DEF__VCPUS = eINSTANCE.getVirtualServerDef_Vcpus();

		/**
		 * The meta object literal for the '<em><b>Virtual HW Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY = eINSTANCE.getVirtualServerDef_VirtualHWFamily();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotImpl <em>Virtual Server Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerSnapshot()
		 * @generated
		 */
		EClass VIRTUAL_SERVER_SNAPSHOT = eINSTANCE.getVirtualServerSnapshot();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotUnitImpl <em>Virtual Server Snapshot Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerSnapshotUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualServerSnapshotUnit()
		 * @generated
		 */
		EClass VIRTUAL_SERVER_SNAPSHOT_UNIT = eINSTANCE.getVirtualServerSnapshotUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXImpl <em>VMware ESX</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareESX()
		 * @generated
		 */
		EClass VMWARE_ESX = eINSTANCE.getVMwareESX();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXUnitImpl <em>VMware ESX Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareESXUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareESXUnit()
		 * @generated
		 */
		EClass VMWARE_ESX_UNIT = eINSTANCE.getVMwareESXUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl <em>VMware Hypervisor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareHypervisor()
		 * @generated
		 */
		EClass VMWARE_HYPERVISOR = eINSTANCE.getVMwareHypervisor();

		/**
		 * The meta object literal for the '<em><b>Vmware Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_HYPERVISOR__VMWARE_PRODUCT = eINSTANCE.getVMwareHypervisor_VmwareProduct();

		/**
		 * The meta object literal for the '<em><b>Vmware Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_HYPERVISOR__VMWARE_VERSION = eINSTANCE.getVMwareHypervisor_VmwareVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl <em>VMware Virtual Disk Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskDef()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_DISK_DEF = eINSTANCE.getVMwareVirtualDiskDef();

		/**
		 * The meta object literal for the '<em><b>Autodetect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__AUTODETECT = eINSTANCE.getVMwareVirtualDiskDef_Autodetect();

		/**
		 * The meta object literal for the '<em><b>Device Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__DEVICE_TYPE = eINSTANCE.getVMwareVirtualDiskDef_DeviceType();

		/**
		 * The meta object literal for the '<em><b>Disk Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__DISK_MODE = eINSTANCE.getVMwareVirtualDiskDef_DiskMode();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__FILE_NAME = eINSTANCE.getVMwareVirtualDiskDef_FileName();

		/**
		 * The meta object literal for the '<em><b>Present</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__PRESENT = eINSTANCE.getVMwareVirtualDiskDef_Present();

		/**
		 * The meta object literal for the '<em><b>Start Connected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_DEF__START_CONNECTED = eINSTANCE.getVMwareVirtualDiskDef_StartConnected();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefUnitImpl <em>VMware Virtual Disk Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskDefUnit()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getVMwareVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl <em>VMware Virtual Disk Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskSnapshot()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_DISK_SNAPSHOT = eINSTANCE.getVMwareVirtualDiskSnapshot();

		/**
		 * The meta object literal for the '<em><b>Disk File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_FILE_NAME = eINSTANCE.getVMwareVirtualDiskSnapshot_DiskFileName();

		/**
		 * The meta object literal for the '<em><b>Disk Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_SNAPSHOT__DISK_NUM = eINSTANCE.getVMwareVirtualDiskSnapshot_DiskNum();

		/**
		 * The meta object literal for the '<em><b>Snapshot Disk File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_DISK_SNAPSHOT__SNAPSHOT_DISK_FILE_NAME = eINSTANCE.getVMwareVirtualDiskSnapshot_SnapshotDiskFileName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotUnitImpl <em>VMware Virtual Disk Snapshot Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualDiskSnapshotUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualDiskSnapshotUnit()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT = eINSTANCE.getVMwareVirtualDiskSnapshotUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefImpl <em>VMware Virtual Ethernet NIC Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualEthernetNICDef()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getVMwareVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefUnitImpl <em>VMware Virtual Ethernet NIC Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualEthernetNICDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualEthernetNICDefUnit()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getVMwareVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualIDEDiskDefImpl <em>VMware Virtual IDE Disk Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualIDEDiskDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualIDEDiskDef()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_IDE_DISK_DEF = eINSTANCE.getVMwareVirtualIDEDiskDef();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl <em>VMware Virtual Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImage()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_IMAGE = eINSTANCE.getVMwareVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Config Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION = eINSTANCE.getVMwareVirtualImage_ConfigVersion();

		/**
		 * The meta object literal for the '<em><b>Vmx File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_IMAGE__VMX_FILE = eINSTANCE.getVMwareVirtualImage_VmxFile();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl <em>VMware Virtual Image Snapshot Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageSnapshotContainerImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImageSnapshotContainer()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER = eINSTANCE.getVMwareVirtualImageSnapshotContainer();

		/**
		 * The meta object literal for the '<em><b>Current Snapshot Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__CURRENT_SNAPSHOT_UID = eINSTANCE.getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid();

		/**
		 * The meta object literal for the '<em><b>Last Snapshot Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__LAST_SNAPSHOT_UID = eINSTANCE.getVMwareVirtualImageSnapshotContainer_LastSnapshotUid();

		/**
		 * The meta object literal for the '<em><b>Num Snapshots</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_IMAGE_SNAPSHOT_CONTAINER__NUM_SNAPSHOTS = eINSTANCE.getVMwareVirtualImageSnapshotContainer_NumSnapshots();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageUnitImpl <em>VMware Virtual Image Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualImageUnit()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_IMAGE_UNIT = eINSTANCE.getVMwareVirtualImageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl <em>VMware Virtual SCSI Disk Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualSCSIDiskDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualSCSIDiskDef()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_SCSI_DISK_DEF = eINSTANCE.getVMwareVirtualSCSIDiskDef();

		/**
		 * The meta object literal for the '<em><b>Controller Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_NUMBER = eINSTANCE.getVMwareVirtualSCSIDiskDef_ControllerNumber();

		/**
		 * The meta object literal for the '<em><b>Controller Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SCSI_DISK_DEF__CONTROLLER_TYPE = eINSTANCE.getVMwareVirtualSCSIDiskDef_ControllerType();

		/**
		 * The meta object literal for the '<em><b>Device Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SCSI_DISK_DEF__DEVICE_NUMBER = eINSTANCE.getVMwareVirtualSCSIDiskDef_DeviceNumber();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl <em>VMware Virtual Server Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerDef()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_SERVER_DEF = eINSTANCE.getVMwareVirtualServerDef();

		/**
		 * The meta object literal for the '<em><b>Guest OS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_DEF__GUEST_OS = eINSTANCE.getVMwareVirtualServerDef_GuestOS();

		/**
		 * The meta object literal for the '<em><b>Virtual HW Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_DEF__VIRTUAL_HW_VERSION = eINSTANCE.getVMwareVirtualServerDef_VirtualHWVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl <em>VMware Virtual Server Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerSnapshot()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_SERVER_SNAPSHOT = eINSTANCE.getVMwareVirtualServerSnapshot();

		/**
		 * The meta object literal for the '<em><b>Create Time High</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH = eINSTANCE.getVMwareVirtualServerSnapshot_CreateTimeHigh();

		/**
		 * The meta object literal for the '<em><b>Create Time Low</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW = eINSTANCE.getVMwareVirtualServerSnapshot_CreateTimeLow();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT = eINSTANCE.getVMwareVirtualServerSnapshot_Current();

		/**
		 * The meta object literal for the '<em><b>Desired Snapshot State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE = eINSTANCE.getVMwareVirtualServerSnapshot_DesiredSnapshotState();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME = eINSTANCE.getVMwareVirtualServerSnapshot_Filename();

		/**
		 * The meta object literal for the '<em><b>Num Disks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS = eINSTANCE.getVMwareVirtualServerSnapshot_NumDisks();

		/**
		 * The meta object literal for the '<em><b>Parent Snapshot Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID = eINSTANCE.getVMwareVirtualServerSnapshot_ParentSnapshotUid();

		/**
		 * The meta object literal for the '<em><b>Snapshot Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE = eINSTANCE.getVMwareVirtualServerSnapshot_SnapshotType();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID = eINSTANCE.getVMwareVirtualServerSnapshot_Uid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotUnitImpl <em>VMware Virtual Server Snapshot Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareVirtualServerSnapshotUnit()
		 * @generated
		 */
		EClass VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT = eINSTANCE.getVMwareVirtualServerSnapshotUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenHypervisorImpl <em>Xen Hypervisor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenHypervisorImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenHypervisor()
		 * @generated
		 */
		EClass XEN_HYPERVISOR = eINSTANCE.getXenHypervisor();

		/**
		 * The meta object literal for the '<em><b>Xen Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_HYPERVISOR__XEN_VERSION = eINSTANCE.getXenHypervisor_XenVersion();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl <em>Xen Virtual Disk Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualDiskDef()
		 * @generated
		 */
		EClass XEN_VIRTUAL_DISK_DEF = eINSTANCE.getXenVirtualDiskDef();

		/**
		 * The meta object literal for the '<em><b>Backend Dev</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_DISK_DEF__BACKEND_DEV = eINSTANCE.getXenVirtualDiskDef_BackendDev();

		/**
		 * The meta object literal for the '<em><b>Frontend Dev</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_DISK_DEF__FRONTEND_DEV = eINSTANCE.getXenVirtualDiskDef_FrontendDev();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_DISK_DEF__MODE = eINSTANCE.getXenVirtualDiskDef_Mode();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefUnitImpl <em>Xen Virtual Disk Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualDiskDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualDiskDefUnit()
		 * @generated
		 */
		EClass XEN_VIRTUAL_DISK_DEF_UNIT = eINSTANCE.getXenVirtualDiskDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefImpl <em>Xen Virtual Ethernet NIC Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualEthernetNICDef()
		 * @generated
		 */
		EClass XEN_VIRTUAL_ETHERNET_NIC_DEF = eINSTANCE.getXenVirtualEthernetNICDef();

		/**
		 * The meta object literal for the '<em><b>Network Bridge</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_ETHERNET_NIC_DEF__NETWORK_BRIDGE = eINSTANCE.getXenVirtualEthernetNICDef_NetworkBridge();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefUnitImpl <em>Xen Virtual Ethernet NIC Def Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualEthernetNICDefUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualEthernetNICDefUnit()
		 * @generated
		 */
		EClass XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT = eINSTANCE.getXenVirtualEthernetNICDefUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl <em>Xen Virtual Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualImage()
		 * @generated
		 */
		EClass XEN_VIRTUAL_IMAGE = eINSTANCE.getXenVirtualImage();

		/**
		 * The meta object literal for the '<em><b>Domain Config File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE = eINSTANCE.getXenVirtualImage_DomainConfigFile();

		/**
		 * The meta object literal for the '<em><b>Domain Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XEN_VIRTUAL_IMAGE__DOMAIN_NAME = eINSTANCE.getXenVirtualImage_DomainName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageUnitImpl <em>Xen Virtual Image Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageUnitImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualImageUnit()
		 * @generated
		 */
		EClass XEN_VIRTUAL_IMAGE_UNIT = eINSTANCE.getXenVirtualImageUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualServerDefImpl <em>Xen Virtual Server Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualServerDefImpl
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getXenVirtualServerDef()
		 * @generated
		 */
		EClass XEN_VIRTUAL_SERVER_DEF = eINSTANCE.getXenVirtualServerDef();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType <em>Desired Snapshot State Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getDesiredSnapshotStateType()
		 * @generated
		 */
		EEnum DESIRED_SNAPSHOT_STATE_TYPE = eINSTANCE.getDesiredSnapshotStateType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType <em>Virtual Network Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualNetworkConnectionType()
		 * @generated
		 */
		EEnum VIRTUAL_NETWORK_CONNECTION_TYPE = eINSTANCE.getVirtualNetworkConnectionType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType <em>VMware SCSI Controller Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareSCSIControllerType()
		 * @generated
		 */
		EEnum VMWARE_SCSI_CONTROLLER_TYPE = eINSTANCE.getVMwareSCSIControllerType();

		/**
		 * The meta object literal for the '<em>Desired Snapshot State Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getDesiredSnapshotStateTypeObject()
		 * @generated
		 */
		EDataType DESIRED_SNAPSHOT_STATE_TYPE_OBJECT = eINSTANCE.getDesiredSnapshotStateTypeObject();

		/**
		 * The meta object literal for the '<em>Virtual Network Connection Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVirtualNetworkConnectionTypeObject()
		 * @generated
		 */
		EDataType VIRTUAL_NETWORK_CONNECTION_TYPE_OBJECT = eINSTANCE.getVirtualNetworkConnectionTypeObject();

		/**
		 * The meta object literal for the '<em>VMware SCSI Controller Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.virtualization.VMwareSCSIControllerType
		 * @see com.ibm.ccl.soa.deploy.virtualization.impl.VirtualizationPackageImpl#getVMwareSCSIControllerTypeObject()
		 * @generated
		 */
		EDataType VMWARE_SCSI_CONTROLLER_TYPE_OBJECT = eINSTANCE.getVMwareSCSIControllerTypeObject();

	}

} //VirtualizationPackage
