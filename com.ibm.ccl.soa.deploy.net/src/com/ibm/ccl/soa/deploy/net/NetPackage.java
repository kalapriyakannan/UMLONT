/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetPackage.java,v 1.8 2008/05/19 14:50:09 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

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
 * @see com.ibm.ccl.soa.deploy.net.NetFactory
 * @model kind="package"
 * @generated
 */
public interface NetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "net"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/net/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetPackage eINSTANCE = com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl <em>Ip Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIpInterface()
	 * @generated
	 */
	int IP_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__GATEWAY = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ip V4 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__IP_V4_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ip V6 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__IP_V6_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ipv6 Notation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__IPV6_NOTATION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>L2 Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__L2_INTERFACE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Netmask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__NETMASK = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Subnet Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE__SUBNET_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Ip Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceUnitImpl <em>Ip Interface Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.impl.IpInterfaceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIpInterfaceUnit()
	 * @generated
	 */
	int IP_INTERFACE_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Ip Interface Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IP_INTERFACE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl <em>L2 Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getL2Interface()
	 * @generated
	 */
	int L2_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Auto Negotiation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__AUTO_NEGOTIATION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Broadcast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__BROADCAST = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Duplex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__DUPLEX = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Encapsulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__ENCAPSULATION = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hw Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__HW_ADDRESS = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__INDEX = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>L2 Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__L2_INTERFACE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Loopback</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__LOOPBACK = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Mtu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__MTU = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__PRIVATE = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Promiscuous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__PROMISCUOUS = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE__SPEED = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>L2 Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceUnitImpl <em>L2 Interface Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.impl.L2InterfaceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getL2InterfaceUnit()
	 * @generated
	 */
	int L2_INTERFACE_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>L2 Interface Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_INTERFACE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetRootImpl
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getNetRoot()
	 * @generated
	 */
	int NET_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Ip Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__CAPABILITY_IP_INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>Capability L2 Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__CAPABILITY_L2_INTERFACE = 4;

	/**
	 * The feature id for the '<em><b>Unit Ip Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__UNIT_IP_INTERFACE_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Unit L2 Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT__UNIT_L2_INTERFACE_UNIT = 6;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_ROOT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.DuplexType <em>Duplex Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getDuplexType()
	 * @generated
	 */
	int DUPLEX_TYPE = 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType <em>IPv6 Address Notation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIPv6AddressNotationType()
	 * @generated
	 */
	int IPV6_ADDRESS_NOTATION_TYPE = 6;

	/**
	 * The meta object id for the '<em>Duplex Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getDuplexTypeObject()
	 * @generated
	 */
	int DUPLEX_TYPE_OBJECT = 7;

	/**
	 * The meta object id for the '<em>IPv6 Address Notation Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIPv6AddressNotationTypeObject()
	 * @generated
	 */
	int IPV6_ADDRESS_NOTATION_TYPE_OBJECT = 8;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.net.IpInterface <em>Ip Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ip Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface
	 * @generated
	 */
	EClass getIpInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getGateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gateway</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getGateway()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_Gateway();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV4Address <em>Ip V4 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip V4 Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getIpV4Address()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_IpV4Address();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV6Address <em>Ip V6 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip V6 Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getIpV6Address()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_IpV6Address();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType <em>Ipv6 Notation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ipv6 Notation Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_Ipv6NotationType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getL2InterfaceName <em>L2 Interface Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2 Interface Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getL2InterfaceName()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_L2InterfaceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getNetmask <em>Netmask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Netmask</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getNetmask()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_Netmask();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getSubnetAddress <em>Subnet Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subnet Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterface#getSubnetAddress()
	 * @see #getIpInterface()
	 * @generated
	 */
	EAttribute getIpInterface_SubnetAddress();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.net.IpInterfaceUnit <em>Ip Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ip Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IpInterfaceUnit
	 * @generated
	 */
	EClass getIpInterfaceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.net.L2Interface <em>L2 Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface
	 * @generated
	 */
	EClass getL2Interface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation <em>Auto Negotiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Negotiation</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_AutoNegotiation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast <em>Broadcast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Broadcast</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Broadcast();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex <em>Duplex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duplex</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Duplex();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getEncapsulation <em>Encapsulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encapsulation</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getEncapsulation()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Encapsulation();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getHwAddress <em>Hw Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hw Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getHwAddress()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_HwAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getIndex()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Index();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getL2InterfaceName <em>L2 Interface Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L2 Interface Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getL2InterfaceName()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_L2InterfaceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback <em>Loopback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loopback</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Loopback();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getMtu <em>Mtu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mtu</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getMtu()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Mtu();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Private();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous <em>Promiscuous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Promiscuous</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Promiscuous();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed()
	 * @see #getL2Interface()
	 * @generated
	 */
	EAttribute getL2Interface_Speed();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.net.L2InterfaceUnit <em>L2 Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.L2InterfaceUnit
	 * @generated
	 */
	EClass getL2InterfaceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.net.NetRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot
	 * @generated
	 */
	EClass getNetRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getMixed()
	 * @see #getNetRoot()
	 * @generated
	 */
	EAttribute getNetRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getXMLNSPrefixMap()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getXSISchemaLocation()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityIpInterface <em>Capability Ip Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ip Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityIpInterface()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_CapabilityIpInterface();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityL2Interface <em>Capability L2 Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability L2 Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityL2Interface()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_CapabilityL2Interface();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitIpInterfaceUnit <em>Unit Ip Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ip Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getUnitIpInterfaceUnit()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_UnitIpInterfaceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitL2InterfaceUnit <em>Unit L2 Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit L2 Interface Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.NetRoot#getUnitL2InterfaceUnit()
	 * @see #getNetRoot()
	 * @generated
	 */
	EReference getNetRoot_UnitL2InterfaceUnit();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.net.DuplexType <em>Duplex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Duplex Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @generated
	 */
	EEnum getDuplexType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType <em>IPv6 Address Notation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>IPv6 Address Notation Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @generated
	 */
	EEnum getIPv6AddressNotationType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.net.DuplexType <em>Duplex Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Duplex Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.net.DuplexType"
	 *        extendedMetaData="name='DuplexType:Object' baseType='DuplexType'"
	 * @generated
	 */
	EDataType getDuplexTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType <em>IPv6 Address Notation Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IPv6 Address Notation Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType"
	 *        extendedMetaData="name='IPv6AddressNotationType:Object' baseType='IPv6AddressNotationType'"
	 * @generated
	 */
	EDataType getIPv6AddressNotationTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NetFactory getNetFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl <em>Ip Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.impl.IpInterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIpInterface()
		 * @generated
		 */
		EClass IP_INTERFACE = eINSTANCE.getIpInterface();

		/**
		 * The meta object literal for the '<em><b>Gateway</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__GATEWAY = eINSTANCE.getIpInterface_Gateway();

		/**
		 * The meta object literal for the '<em><b>Ip V4 Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__IP_V4_ADDRESS = eINSTANCE.getIpInterface_IpV4Address();

		/**
		 * The meta object literal for the '<em><b>Ip V6 Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__IP_V6_ADDRESS = eINSTANCE.getIpInterface_IpV6Address();

		/**
		 * The meta object literal for the '<em><b>Ipv6 Notation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__IPV6_NOTATION_TYPE = eINSTANCE.getIpInterface_Ipv6NotationType();

		/**
		 * The meta object literal for the '<em><b>L2 Interface Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__L2_INTERFACE_NAME = eINSTANCE.getIpInterface_L2InterfaceName();

		/**
		 * The meta object literal for the '<em><b>Netmask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__NETMASK = eINSTANCE.getIpInterface_Netmask();

		/**
		 * The meta object literal for the '<em><b>Subnet Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IP_INTERFACE__SUBNET_ADDRESS = eINSTANCE.getIpInterface_SubnetAddress();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.impl.IpInterfaceUnitImpl <em>Ip Interface Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.impl.IpInterfaceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIpInterfaceUnit()
		 * @generated
		 */
		EClass IP_INTERFACE_UNIT = eINSTANCE.getIpInterfaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl <em>L2 Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getL2Interface()
		 * @generated
		 */
		EClass L2_INTERFACE = eINSTANCE.getL2Interface();

		/**
		 * The meta object literal for the '<em><b>Auto Negotiation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__AUTO_NEGOTIATION = eINSTANCE.getL2Interface_AutoNegotiation();

		/**
		 * The meta object literal for the '<em><b>Broadcast</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__BROADCAST = eINSTANCE.getL2Interface_Broadcast();

		/**
		 * The meta object literal for the '<em><b>Duplex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__DUPLEX = eINSTANCE.getL2Interface_Duplex();

		/**
		 * The meta object literal for the '<em><b>Encapsulation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__ENCAPSULATION = eINSTANCE.getL2Interface_Encapsulation();

		/**
		 * The meta object literal for the '<em><b>Hw Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__HW_ADDRESS = eINSTANCE.getL2Interface_HwAddress();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__INDEX = eINSTANCE.getL2Interface_Index();

		/**
		 * The meta object literal for the '<em><b>L2 Interface Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__L2_INTERFACE_NAME = eINSTANCE.getL2Interface_L2InterfaceName();

		/**
		 * The meta object literal for the '<em><b>Loopback</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__LOOPBACK = eINSTANCE.getL2Interface_Loopback();

		/**
		 * The meta object literal for the '<em><b>Mtu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__MTU = eINSTANCE.getL2Interface_Mtu();

		/**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__PRIVATE = eINSTANCE.getL2Interface_Private();

		/**
		 * The meta object literal for the '<em><b>Promiscuous</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__PROMISCUOUS = eINSTANCE.getL2Interface_Promiscuous();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2_INTERFACE__SPEED = eINSTANCE.getL2Interface_Speed();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceUnitImpl <em>L2 Interface Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.impl.L2InterfaceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getL2InterfaceUnit()
		 * @generated
		 */
		EClass L2_INTERFACE_UNIT = eINSTANCE.getL2InterfaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetRootImpl
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getNetRoot()
		 * @generated
		 */
		EClass NET_ROOT = eINSTANCE.getNetRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_ROOT__MIXED = eINSTANCE.getNetRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getNetRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getNetRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Ip Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__CAPABILITY_IP_INTERFACE = eINSTANCE.getNetRoot_CapabilityIpInterface();

		/**
		 * The meta object literal for the '<em><b>Capability L2 Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__CAPABILITY_L2_INTERFACE = eINSTANCE.getNetRoot_CapabilityL2Interface();

		/**
		 * The meta object literal for the '<em><b>Unit Ip Interface Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__UNIT_IP_INTERFACE_UNIT = eINSTANCE.getNetRoot_UnitIpInterfaceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit L2 Interface Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_ROOT__UNIT_L2_INTERFACE_UNIT = eINSTANCE.getNetRoot_UnitL2InterfaceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.DuplexType <em>Duplex Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.DuplexType
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getDuplexType()
		 * @generated
		 */
		EEnum DUPLEX_TYPE = eINSTANCE.getDuplexType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType <em>IPv6 Address Notation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIPv6AddressNotationType()
		 * @generated
		 */
		EEnum IPV6_ADDRESS_NOTATION_TYPE = eINSTANCE.getIPv6AddressNotationType();

		/**
		 * The meta object literal for the '<em>Duplex Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.DuplexType
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getDuplexTypeObject()
		 * @generated
		 */
		EDataType DUPLEX_TYPE_OBJECT = eINSTANCE.getDuplexTypeObject();

		/**
		 * The meta object literal for the '<em>IPv6 Address Notation Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
		 * @see com.ibm.ccl.soa.deploy.net.impl.NetPackageImpl#getIPv6AddressNotationTypeObject()
		 * @generated
		 */
		EDataType IPV6_ADDRESS_NOTATION_TYPE_OBJECT = eINSTANCE.getIPv6AddressNotationTypeObject();

	}

} //NetPackage
