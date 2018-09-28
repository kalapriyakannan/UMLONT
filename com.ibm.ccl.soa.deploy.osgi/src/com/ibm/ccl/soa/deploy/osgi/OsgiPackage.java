/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import com.ibm.ccl.soa.deploy.core.CorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiFactory
 * @model kind="package"
 * @generated
 */
public interface OsgiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "osgi"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/zephyr/osgi/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "osgi"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OsgiPackage eINSTANCE = com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleCapabilityImpl <em>Bundle Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.BundleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getBundleCapability()
	 * @generated
	 */
	int BUNDLE_CAPABILITY = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__SYMBOLIC_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bundle Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl <em>Bundle Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getBundleComponent()
	 * @generated
	 */
	int BUNDLE_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ANNOTATIONS = CorePackage.SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ATTRIBUTE_META_DATA = CorePackage.SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__EXTENDED_ATTRIBUTES = CorePackage.SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ARTIFACT_GROUP = CorePackage.SOFTWARE_COMPONENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ARTIFACTS = CorePackage.SOFTWARE_COMPONENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CONSTRAINT_GROUP = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CONSTRAINTS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__DESCRIPTION = CorePackage.SOFTWARE_COMPONENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__DISPLAY_NAME = CorePackage.SOFTWARE_COMPONENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__MUTABLE = CorePackage.SOFTWARE_COMPONENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__NAME = CorePackage.SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CAPABILITY_GROUP = CorePackage.SOFTWARE_COMPONENT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CAPABILITIES = CorePackage.SOFTWARE_COMPONENT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__REQUIREMENT_GROUP = CorePackage.SOFTWARE_COMPONENT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__REQUIREMENTS = CorePackage.SOFTWARE_COMPONENT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__UNIT_LINKS_GROUP = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__UNIT_LINKS = CorePackage.SOFTWARE_COMPONENT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CONSTRAINT_LINKS = CorePackage.SOFTWARE_COMPONENT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__REALIZATION_LINKS = CorePackage.SOFTWARE_COMPONENT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__STEREOTYPES = CorePackage.SOFTWARE_COMPONENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__BUILD_VERSION = CorePackage.SOFTWARE_COMPONENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CONCEPTUAL = CorePackage.SOFTWARE_COMPONENT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__CONFIGURATION_UNIT = CorePackage.SOFTWARE_COMPONENT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__GOAL_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__INIT_INSTALL_STATE = CorePackage.SOFTWARE_COMPONENT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ORIGIN = CorePackage.SOFTWARE_COMPONENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__PUBLISH_INTENT = CorePackage.SOFTWARE_COMPONENT__PUBLISH_INTENT;

	/**
	 * The feature id for the '<em><b>Activator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ACTIVATOR = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Eclipse Lazy Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__ECLIPSE_LAZY_START = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Localization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__LOCALIZATION = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Manifest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__MANIFEST_VERSION = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__SINGLETON = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT__VENDOR = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Bundle Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_COMPONENT_FEATURE_COUNT = CorePackage.SOFTWARE_COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl <em>Exported Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getExportedPackage()
	 * @generated
	 */
	int EXPORTED_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Friend</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__FRIEND = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE__INTERNAL = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exported Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_PACKAGE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__SOURCE = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OUTPUT = CorePackage.UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl <em>OS Gi Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl
	 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getOSGiRoot()
	 * @generated
	 */
	int OS_GI_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Api Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__CAPABILITY_API_PACKAGE = 3;

	/**
	 * The feature id for the '<em><b>Capability Osgi Bundle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE = 4;

	/**
	 * The feature id for the '<em><b>Component Bundle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__COMPONENT_BUNDLE = 5;

	/**
	 * The feature id for the '<em><b>Unit Osgi Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT__UNIT_OSGI_LIBRARY = 6;

	/**
	 * The number of structural features of the '<em>OS Gi Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_ROOT_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.osgi.BundleCapability <em>Bundle Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleCapability
	 * @generated
	 */
	EClass getBundleCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleCapability#getSymbolicName <em>Symbolic Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbolic Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleCapability#getSymbolicName()
	 * @see #getBundleCapability()
	 * @generated
	 */
	EAttribute getBundleCapability_SymbolicName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent <em>Bundle Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent
	 * @generated
	 */
	EClass getBundleComponent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getActivator <em>Activator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activator</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#getActivator()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_Activator();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart <em>Eclipse Lazy Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eclipse Lazy Start</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_EclipseLazyStart();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getLocalization <em>Localization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Localization</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#getLocalization()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_Localization();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getManifestVersion <em>Manifest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manifest Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#getManifestVersion()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_ManifestVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_Singleton();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getVendor <em>Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vendor</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.BundleComponent#getVendor()
	 * @see #getBundleComponent()
	 * @generated
	 */
	EAttribute getBundleComponent_Vendor();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage <em>Exported Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exported Package</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.ExportedPackage
	 * @generated
	 */
	EClass getExportedPackage();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#getFriend <em>Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Friend</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.ExportedPackage#getFriend()
	 * @see #getExportedPackage()
	 * @generated
	 */
	EAttribute getExportedPackage_Friend();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal <em>Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal()
	 * @see #getExportedPackage()
	 * @generated
	 */
	EAttribute getExportedPackage_Internal();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.osgi.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.osgi.Library#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Source</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.Library#getSource()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Source();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.osgi.Library#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Output</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.Library#getOutput()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Output();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot <em>OS Gi Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OS Gi Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot
	 * @generated
	 */
	EClass getOSGiRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getMixed()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EAttribute getOSGiRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXMLNSPrefixMap()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXSISchemaLocation()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityApiPackage <em>Capability Api Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Api Package</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityApiPackage()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_CapabilityApiPackage();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityOsgiBundle <em>Capability Osgi Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Osgi Bundle</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityOsgiBundle()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_CapabilityOsgiBundle();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getComponentBundle <em>Component Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Bundle</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getComponentBundle()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_ComponentBundle();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getUnitOsgiLibrary <em>Unit Osgi Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Osgi Library</em>'.
	 * @see com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getUnitOsgiLibrary()
	 * @see #getOSGiRoot()
	 * @generated
	 */
	EReference getOSGiRoot_UnitOsgiLibrary();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OsgiFactory getOsgiFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleCapabilityImpl <em>Bundle Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.BundleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getBundleCapability()
		 * @generated
		 */
		EClass BUNDLE_CAPABILITY = eINSTANCE.getBundleCapability();

		/**
		 * The meta object literal for the '<em><b>Symbolic Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_CAPABILITY__SYMBOLIC_NAME = eINSTANCE.getBundleCapability_SymbolicName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl <em>Bundle Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getBundleComponent()
		 * @generated
		 */
		EClass BUNDLE_COMPONENT = eINSTANCE.getBundleComponent();

		/**
		 * The meta object literal for the '<em><b>Activator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__ACTIVATOR = eINSTANCE.getBundleComponent_Activator();

		/**
		 * The meta object literal for the '<em><b>Eclipse Lazy Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__ECLIPSE_LAZY_START = eINSTANCE.getBundleComponent_EclipseLazyStart();

		/**
		 * The meta object literal for the '<em><b>Localization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__LOCALIZATION = eINSTANCE.getBundleComponent_Localization();

		/**
		 * The meta object literal for the '<em><b>Manifest Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__MANIFEST_VERSION = eINSTANCE.getBundleComponent_ManifestVersion();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__SINGLETON = eINSTANCE.getBundleComponent_Singleton();

		/**
		 * The meta object literal for the '<em><b>Vendor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE_COMPONENT__VENDOR = eINSTANCE.getBundleComponent_Vendor();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl <em>Exported Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getExportedPackage()
		 * @generated
		 */
		EClass EXPORTED_PACKAGE = eINSTANCE.getExportedPackage();

		/**
		 * The meta object literal for the '<em><b>Friend</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORTED_PACKAGE__FRIEND = eINSTANCE.getExportedPackage_Friend();

		/**
		 * The meta object literal for the '<em><b>Internal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORTED_PACKAGE__INTERNAL = eINSTANCE.getExportedPackage_Internal();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__SOURCE = eINSTANCE.getLibrary_Source();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__OUTPUT = eINSTANCE.getLibrary_Output();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl <em>OS Gi Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl
		 * @see com.ibm.ccl.soa.deploy.osgi.impl.OsgiPackageImpl#getOSGiRoot()
		 * @generated
		 */
		EClass OS_GI_ROOT = eINSTANCE.getOSGiRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_GI_ROOT__MIXED = eINSTANCE.getOSGiRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getOSGiRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getOSGiRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Api Package</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__CAPABILITY_API_PACKAGE = eINSTANCE.getOSGiRoot_CapabilityApiPackage();

		/**
		 * The meta object literal for the '<em><b>Capability Osgi Bundle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE = eINSTANCE.getOSGiRoot_CapabilityOsgiBundle();

		/**
		 * The meta object literal for the '<em><b>Component Bundle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__COMPONENT_BUNDLE = eINSTANCE.getOSGiRoot_ComponentBundle();

		/**
		 * The meta object literal for the '<em><b>Unit Osgi Library</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OS_GI_ROOT__UNIT_OSGI_LIBRARY = eINSTANCE.getOSGiRoot_UnitOsgiLibrary();

	}

} //OsgiPackage
