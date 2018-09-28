/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl;

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
 * @see com.ibm.ccl.soa.deploy.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
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
	String eNAME = "core"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "core"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.AnnotationImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANY = 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__DETAILS = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CONTEXT = 2;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl <em>Attribute Meta Data</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAttributeMetaData()
	 * @generated
	 */
	int ATTRIBUTE_META_DATA = 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl <em>Deploy Core Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployCoreRoot()
	 * @generated
	 */
	int DEPLOY_CORE_ROOT = 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.UnitLinkImpl <em>Unit Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.UnitLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getUnitLink()
	 * @generated
	 */
	int UNIT_LINK = 39;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl <em>Deploy Model Object</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployModelObject()
	 * @generated
	 */
	int DEPLOY_MODEL_OBJECT = 15;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute. <!-- begin-user-doc -->
	 * 
	 * @see Literals#DEPLOY_MODEL_OBJECT__STATUS <!-- end-user-doc -->
	 */
	int DEPLOY_MODEL_OBJECT__STATUS = -1;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute. <!-- begin-user-doc -->
	 * 
	 * @see Literals#DEPLOY_MODEL_OBJECT__VISIBILITY <!-- end-user-doc -->
	 */
	int DEPLOY_MODEL_OBJECT__VISIBILITY = -2;

	/**
	 * The feature id for the '<em><b>ExportedProperties</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * 
	 * @see Literals#DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES <!-- end-user-doc -->
	 */
	int DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES = -3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__ANNOTATIONS = 0;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA = 1;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES = 2;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__ARTIFACTS = 4;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__CONSTRAINTS = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__DISPLAY_NAME = 8;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__MUTABLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT__NAME = 10;

	/**
	 * The number of structural features of the '<em>Deploy Model Object</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ArtifactImpl <em>Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getArtifact()
	 * @generated
	 */
	int ARTIFACT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The number of structural features of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__ATTRIBUTE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Encrypted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__ENCRYPTED = 2;

	/**
	 * The feature id for the '<em><b>Encryption Required</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__LABEL = 4;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__MUTABLE = 5;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__OPTIONAL = 6;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA__PARAMETER = 7;

	/**
	 * The number of structural features of the '<em>Attribute Meta Data</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_META_DATA_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl <em>Augmentation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAugmentation()
	 * @generated
	 */
	int AUGMENTATION = 3;

	/**
	 * The feature id for the '<em><b>Additions</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUGMENTATION__ADDITIONS = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUGMENTATION__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Select</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUGMENTATION__SELECT = 2;

	/**
	 * The number of structural features of the '<em>Augmentation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AUGMENTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl <em>Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapability()
	 * @generated
	 */
	int CAPABILITY = 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl <em>Bundle Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getBundleCapability()
	 * @generated
	 */
	int BUNDLE_CAPABILITY = 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl <em>Communication Capability</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCommunicationCapability()
	 * @generated
	 */
	int COMMUNICATION_CAPABILITY = 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.HostingLinkImpl <em>Hosting Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.HostingLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getHostingLink()
	 * @generated
	 */
	int HOSTING_LINK = 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.RequirementImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 31;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl <em>Requirement Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpression()
	 * @generated
	 */
	int REQUIREMENT_EXPRESSION = 32;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.StringToStringEntryImpl <em>String To String Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.StringToStringEntryImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getStringToStringEntry()
	 * @generated
	 */
	int STRING_TO_STRING_ENTRY = 36;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl <em>Topology</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.TopologyImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getTopology()
	 * @generated
	 */
	int TOPOLOGY = 37;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage <em>Requirement Expression Usage</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpressionUsage()
	 * @generated
	 */
	int REQUIREMENT_EXPRESSION_USAGE = 43;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes <em>Requirement Link Types</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementLinkTypes()
	 * @generated
	 */
	int REQUIREMENT_LINK_TYPES = 44;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.RequirementUsage <em>Requirement Usage</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementUsage()
	 * @generated
	 */
	int REQUIREMENT_USAGE = 45;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 46;

	/**
	 * The meta object id for the '<em>Capability Link Types Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapabilityLinkTypesObject()
	 * @generated
	 */
	int CAPABILITY_LINK_TYPES_OBJECT = 47;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.UnitImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 38;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.DependencyLinkImpl <em>Dependency Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.DependencyLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDependencyLink()
	 * @generated
	 */
	int DEPENDENCY_LINK = 12;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl <em>Deploy Model Object Set</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployModelObjectSet()
	 * @generated
	 */
	int DEPLOY_MODEL_OBJECT_SET = 16;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl <em>Extended Attribute</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExtendedAttribute()
	 * @generated
	 */
	int EXTENDED_ATTRIBUTE = 20;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl <em>File Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getFileArtifact()
	 * @generated
	 */
	int FILE_ARTIFACT = 21;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ImportImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 23;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 26;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.MemberLinkImpl <em>Member Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.MemberLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getMemberLink()
	 * @generated
	 */
	int MEMBER_LINK = 27;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 30;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ServiceImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 33;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__CAPABILITY_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__CAPABILITIES = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__REQUIREMENT_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__REQUIREMENTS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__UNIT_LINKS_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__UNIT_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CONSTRAINT_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__REALIZATION_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__STEREOTYPES = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__BUILD_VERSION = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__CONCEPTUAL = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__CONFIGURATION_UNIT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__GOAL_INSTALL_STATE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__INIT_INSTALL_STATE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ORIGIN = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__PUBLISH_INTENT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.BaseComponentUnitImpl <em>Base Component Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.BaseComponentUnitImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getBaseComponentUnit()
	 * @generated
	 */
	int BASE_COMPONENT_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__ANNOTATIONS = UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__ATTRIBUTE_META_DATA = UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__EXTENDED_ATTRIBUTES = UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__ARTIFACT_GROUP = UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__ARTIFACTS = UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CONSTRAINT_GROUP = UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CONSTRAINTS = UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__DESCRIPTION = UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__DISPLAY_NAME = UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__MUTABLE = UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__NAME = UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CAPABILITY_GROUP = UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CAPABILITIES = UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__REQUIREMENT_GROUP = UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__REQUIREMENTS = UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__UNIT_LINKS_GROUP = UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__UNIT_LINKS = UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CONSTRAINT_LINKS = UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__REALIZATION_LINKS = UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__STEREOTYPES = UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__BUILD_VERSION = UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CONCEPTUAL = UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__CONFIGURATION_UNIT = UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__GOAL_INSTALL_STATE = UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__INIT_INSTALL_STATE = UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__ORIGIN = UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT__PUBLISH_INTENT = UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Base Component Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_COMPONENT_UNIT_FEATURE_COUNT = UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__STEREOTYPES = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__BUILD_VERSION = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__LINK_TYPE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__ORIGIN = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Capability</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ANNOTATIONS = CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ATTRIBUTE_META_DATA = CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__EXTENDED_ATTRIBUTES = CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ARTIFACT_GROUP = CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ARTIFACTS = CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__CONSTRAINT_GROUP = CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__CONSTRAINTS = CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__DESCRIPTION = CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__DISPLAY_NAME = CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__MUTABLE = CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__NAME = CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__STEREOTYPES = CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__BUILD_VERSION = CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__LINK_TYPE = CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ORIGIN = CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__ID = CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY__VERSION = CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bundle Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_CAPABILITY_FEATURE_COUNT = CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__ANNOTATIONS = CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__ATTRIBUTE_META_DATA = CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__EXTENDED_ATTRIBUTES = CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__ARTIFACT_GROUP = CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__ARTIFACTS = CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__CONSTRAINT_GROUP = CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__CONSTRAINTS = CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__DESCRIPTION = CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__DISPLAY_NAME = CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__MUTABLE = CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__NAME = CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__STEREOTYPES = CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__BUILD_VERSION = CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__LINK_TYPE = CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__ORIGIN = CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Application Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL = CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY__PORT = CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communication Capability</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CAPABILITY_FEATURE_COUNT = CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConceptualNodeImpl <em>Conceptual Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ConceptualNodeImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConceptualNode()
	 * @generated
	 */
	int CONCEPTUAL_NODE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__ANNOTATIONS = UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__ATTRIBUTE_META_DATA = UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__EXTENDED_ATTRIBUTES = UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__ARTIFACT_GROUP = UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__ARTIFACTS = UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CONSTRAINT_GROUP = UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CONSTRAINTS = UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__DESCRIPTION = UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__DISPLAY_NAME = UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__MUTABLE = UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__NAME = UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CAPABILITY_GROUP = UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CAPABILITIES = UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__REQUIREMENT_GROUP = UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__REQUIREMENTS = UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__UNIT_LINKS_GROUP = UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__UNIT_LINKS = UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CONSTRAINT_LINKS = UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__REALIZATION_LINKS = UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__STEREOTYPES = UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__BUILD_VERSION = UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CONCEPTUAL = UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__CONFIGURATION_UNIT = UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__GOAL_INSTALL_STATE = UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__INIT_INSTALL_STATE = UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__ORIGIN = UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE__PUBLISH_INTENT = UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Conceptual Node</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONCEPTUAL_NODE_FEATURE_COUNT = UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConfigurationContractImpl <em>Configuration Contract</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ConfigurationContractImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConfigurationContract()
	 * @generated
	 */
	int CONFIGURATION_CONTRACT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The number of structural features of the '<em>Configuration Contract</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_CONTRACT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl <em>Deploy Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployLink()
	 * @generated
	 */
	int DEPLOY_LINK = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__SOURCE_URI = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK__TARGET_URI = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deploy Link</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_LINK_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConstraintLinkImpl <em>Constraint Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ConstraintLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConstraintLink()
	 * @generated
	 */
	int CONSTRAINT_LINK = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__ANNOTATIONS = DEPLOY_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__ATTRIBUTE_META_DATA = DEPLOY_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__EXTENDED_ATTRIBUTES = DEPLOY_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__ARTIFACT_GROUP = DEPLOY_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__ARTIFACTS = DEPLOY_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__CONSTRAINT_GROUP = DEPLOY_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__CONSTRAINTS = DEPLOY_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__DESCRIPTION = DEPLOY_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__DISPLAY_NAME = DEPLOY_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__MUTABLE = DEPLOY_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__NAME = DEPLOY_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__SOURCE_URI = DEPLOY_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK__TARGET_URI = DEPLOY_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Constraint Link</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_LINK_FEATURE_COUNT = DEPLOY_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__ANNOTATIONS = DEPLOY_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__ATTRIBUTE_META_DATA = DEPLOY_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__EXTENDED_ATTRIBUTES = DEPLOY_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__ARTIFACT_GROUP = DEPLOY_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__ARTIFACTS = DEPLOY_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__CONSTRAINT_GROUP = DEPLOY_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__CONSTRAINTS = DEPLOY_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__DESCRIPTION = DEPLOY_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__DISPLAY_NAME = DEPLOY_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__MUTABLE = DEPLOY_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__NAME = DEPLOY_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__SOURCE_URI = DEPLOY_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__TARGET_URI = DEPLOY_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Dependency Link</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK_FEATURE_COUNT = DEPLOY_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Artifact</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__ARTIFACT = 4;

	/**
	 * The feature id for the '<em><b>Artifact File</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__ARTIFACT_FILE = 5;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__BASE_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__UNIT = 7;

	/**
	 * The feature id for the '<em><b>Capability</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CAPABILITY = 8;

	/**
	 * The feature id for the '<em><b>Capability Bundle</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE = 9;

	/**
	 * The feature id for the '<em><b>Capability Communication</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION = 10;

	/**
	 * The feature id for the '<em><b>Config Topology</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY = 11;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Contract Explicit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT = 13;

	/**
	 * The feature id for the '<em><b>Contract Topology</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY = 14;

	/**
	 * The feature id for the '<em><b>Deploy Model Object</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT = 15;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__IMPORT = 16;

	/**
	 * The feature id for the '<em><b>Instantiation</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__INSTANTIATION = 17;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__INTERFACE = 18;

	/**
	 * The feature id for the '<em><b>Link Constraint</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_CONSTRAINT = 19;

	/**
	 * The feature id for the '<em><b>Link Dependency</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_DEPENDENCY = 20;

	/**
	 * The feature id for the '<em><b>Link Deploy</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_DEPLOY = 21;

	/**
	 * The feature id for the '<em><b>Link Hosting</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_HOSTING = 22;

	/**
	 * The feature id for the '<em><b>Link Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_UNIT = 23;

	/**
	 * The feature id for the '<em><b>Link Member</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_MEMBER = 24;

	/**
	 * The feature id for the '<em><b>Link Realization</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__LINK_REALIZATION = 25;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__PROPERTY = 26;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__REFERENCE = 27;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__REQUIREMENT = 28;

	/**
	 * The feature id for the '<em><b>Req Expr</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__REQ_EXPR = 29;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__SERVICE = 30;

	/**
	 * The feature id for the '<em><b>Software Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT = 31;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__STEREOTYPE = 32;

	/**
	 * The feature id for the '<em><b>Topology</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__TOPOLOGY = 33;

	/**
	 * The feature id for the '<em><b>Unit Conceptual Node</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE = 34;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT__VISIBILITY = 35;

	/**
	 * The number of structural features of the '<em>Deploy Core Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_CORE_ROOT_FEATURE_COUNT = 36;

	/**
	 * The feature id for the '<em><b>Deploy Model Object Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Deploy Model Object</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Deploy Model Object Set</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOY_MODEL_OBJECT_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl <em>Explicit Contract</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExplicitContract()
	 * @generated
	 */
	int EXPLICIT_CONTRACT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__ANNOTATIONS = CONFIGURATION_CONTRACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__ATTRIBUTE_META_DATA = CONFIGURATION_CONTRACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__EXTENDED_ATTRIBUTES = CONFIGURATION_CONTRACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__ARTIFACT_GROUP = CONFIGURATION_CONTRACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__ARTIFACTS = CONFIGURATION_CONTRACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__CONSTRAINT_GROUP = CONFIGURATION_CONTRACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__CONSTRAINTS = CONFIGURATION_CONTRACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__DESCRIPTION = CONFIGURATION_CONTRACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__DISPLAY_NAME = CONFIGURATION_CONTRACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__MUTABLE = CONFIGURATION_CONTRACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__NAME = CONFIGURATION_CONTRACT__NAME;

	/**
	 * The feature id for the '<em><b>Exported Units</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__EXPORTED_UNITS = CONFIGURATION_CONTRACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__PROPERTIES = CONFIGURATION_CONTRACT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Conceptual Policy</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY = CONFIGURATION_CONTRACT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Policy</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT__DEFAULT_POLICY = CONFIGURATION_CONTRACT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Explicit Contract</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPLICIT_CONTRACT_FEATURE_COUNT = CONFIGURATION_CONTRACT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl <em>Exported</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ExportedImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExported()
	 * @generated
	 */
	int EXPORTED = 18;

	/**
	 * The feature id for the '<em><b>Configurable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__CONFIGURABLE = 0;

	/**
	 * The feature id for the '<em><b>Linkable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__LINKABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__NAME = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED__PATH = 3;

	/**
	 * The number of structural features of the '<em>Exported</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl <em>Exported Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExportedUnit()
	 * @generated
	 */
	int EXPORTED_UNIT = 19;

	/**
	 * The feature id for the '<em><b>Configurable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__CONFIGURABLE = EXPORTED__CONFIGURABLE;

	/**
	 * The feature id for the '<em><b>Linkable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__LINKABLE = EXPORTED__LINKABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__NAME = EXPORTED__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__PATH = EXPORTED__PATH;

	/**
	 * The feature id for the '<em><b>Exported Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__EXPORTED_CAPABILITIES = EXPORTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exported Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__EXPORTED_REQUIREMENTS = EXPORTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exported Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__EXPORTED_PROPERTIES = EXPORTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__CONSTRAINT_GROUP = EXPORTED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Augmented Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT__AUGMENTED_CONSTRAINTS = EXPORTED_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Exported Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPORTED_UNIT_FEATURE_COUNT = EXPORTED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ATTRIBUTE__DATA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ATTRIBUTE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Extended Attribute</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__ANNOTATIONS = ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__ATTRIBUTE_META_DATA = ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__EXTENDED_ATTRIBUTES = ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__ARTIFACT_GROUP = ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__ARTIFACTS = ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__CONSTRAINT_GROUP = ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__CONSTRAINTS = ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__DESCRIPTION = ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__DISPLAY_NAME = ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__MUTABLE = ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__NAME = ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT__FILE_UR_IS = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ARTIFACT_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__ANNOTATIONS = DEPLOY_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__ATTRIBUTE_META_DATA = DEPLOY_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__EXTENDED_ATTRIBUTES = DEPLOY_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__ARTIFACT_GROUP = DEPLOY_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__ARTIFACTS = DEPLOY_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__CONSTRAINT_GROUP = DEPLOY_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__CONSTRAINTS = DEPLOY_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__DESCRIPTION = DEPLOY_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__DISPLAY_NAME = DEPLOY_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__MUTABLE = DEPLOY_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__NAME = DEPLOY_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__SOURCE_URI = DEPLOY_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK__TARGET_URI = DEPLOY_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Unit Link</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_LINK_FEATURE_COUNT = DEPLOY_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__ANNOTATIONS = UNIT_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__ATTRIBUTE_META_DATA = UNIT_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__EXTENDED_ATTRIBUTES = UNIT_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__ARTIFACT_GROUP = UNIT_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__ARTIFACTS = UNIT_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__CONSTRAINT_GROUP = UNIT_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__CONSTRAINTS = UNIT_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__DESCRIPTION = UNIT_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__DISPLAY_NAME = UNIT_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__MUTABLE = UNIT_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__NAME = UNIT_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__SOURCE_URI = UNIT_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK__TARGET_URI = UNIT_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Hosting Link</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HOSTING_LINK_FEATURE_COUNT = UNIT_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPORT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Instance Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__INSTANCE_CONFIGURATION = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAMESPACE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PATTERN = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reexported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__REEXPORTED = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl <em>Instance Configuration</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstanceConfiguration()
	 * @generated
	 */
	int INSTANCE_CONFIGURATION = 24;

	/**
	 * The feature id for the '<em><b>PublicUnits</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	int INSTANCE_CONFIGURATION__PUBLIC_UNITS = -1;

	/**
	 * The feature id for the '<em><b>PublicEditableUnits</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	int INSTANCE_CONFIGURATION__PUBLIC_EDITABLE_UNITS = -2;

	/**
	 * The feature id for the '<em><b>GlobalProperties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	int INSTANCE_CONFIGURATION__GLOBAL_PROPERTIES = -3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Instantiations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__INSTANTIATIONS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION__IMPORTED = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Configuration</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATION_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl <em>Instantiation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstantiation()
	 * @generated
	 */
	int INSTANTIATION = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Configured Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONFIGURED_CAPABILITY_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configured Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONFIGURED_CAPABILITIES = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Configured Requirements Group</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Configured Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONFIGURED_REQUIREMENTS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Configured Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__CONFIGURED_PROPERTIES = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Augmentation Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__AUGMENTATION_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Augmentations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__AUGMENTATIONS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Referenced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION__REFERENCED = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Instantiation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__ANNOTATIONS = UNIT_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__ATTRIBUTE_META_DATA = UNIT_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__EXTENDED_ATTRIBUTES = UNIT_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__ARTIFACT_GROUP = UNIT_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__ARTIFACTS = UNIT_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__CONSTRAINT_GROUP = UNIT_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__CONSTRAINTS = UNIT_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__DESCRIPTION = UNIT_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__DISPLAY_NAME = UNIT_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__MUTABLE = UNIT_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__NAME = UNIT_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__SOURCE_URI = UNIT_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK__TARGET_URI = UNIT_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Member Link</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_LINK_FEATURE_COUNT = UNIT_LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.PropertyImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 28;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Select</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SELECT = 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.RealizationLinkImpl <em>Realization Link</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.RealizationLinkImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRealizationLink()
	 * @generated
	 */
	int REALIZATION_LINK = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__ANNOTATIONS = DEPLOY_LINK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__ATTRIBUTE_META_DATA = DEPLOY_LINK__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__EXTENDED_ATTRIBUTES = DEPLOY_LINK__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__ARTIFACT_GROUP = DEPLOY_LINK__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__ARTIFACTS = DEPLOY_LINK__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__CONSTRAINT_GROUP = DEPLOY_LINK__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__CONSTRAINTS = DEPLOY_LINK__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__DESCRIPTION = DEPLOY_LINK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__DISPLAY_NAME = DEPLOY_LINK__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__MUTABLE = DEPLOY_LINK__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__NAME = DEPLOY_LINK__NAME;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__SOURCE_URI = DEPLOY_LINK__SOURCE_URI;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK__TARGET_URI = DEPLOY_LINK__TARGET_URI;

	/**
	 * The number of structural features of the '<em>Realization Link</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_LINK_FEATURE_COUNT = DEPLOY_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Dependency Link Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DEPENDENCY_LINK_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__LINK = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dmo Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DMO_TYPE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__EXTENDS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__LINK_TYPE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Use</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__USE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ANNOTATIONS = REQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ATTRIBUTE_META_DATA = REQUIREMENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__EXTENDED_ATTRIBUTES = REQUIREMENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ARTIFACT_GROUP = REQUIREMENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ARTIFACTS = REQUIREMENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONSTRAINT_GROUP = REQUIREMENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONSTRAINTS = REQUIREMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DISPLAY_NAME = REQUIREMENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MUTABLE = REQUIREMENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Dependency Link Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DEPENDENCY_LINK_GROUP = REQUIREMENT__DEPENDENCY_LINK_GROUP;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LINK = REQUIREMENT__LINK;

	/**
	 * The feature id for the '<em><b>Dmo Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DMO_TYPE = REQUIREMENT__DMO_TYPE;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__EXTENDS = REQUIREMENT__EXTENDS;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LINK_TYPE = REQUIREMENT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Use</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__USE = REQUIREMENT__USE;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__INTERFACE_GROUP = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__INTERFACE = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__RANGE = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__ANNOTATIONS = CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__ATTRIBUTE_META_DATA = CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__EXTENDED_ATTRIBUTES = CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__ARTIFACT_GROUP = CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__ARTIFACTS = CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__CONSTRAINT_GROUP = CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__CONSTRAINTS = CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__DESCRIPTION = CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__DISPLAY_NAME = CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__MUTABLE = CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interpreter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__INTERPRETER = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Use</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__USE = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION__VALUE = CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Requirement Expression</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_EXPRESSION_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__ANNOTATIONS = CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ATTRIBUTE_META_DATA = CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__EXTENDED_ATTRIBUTES = CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__ARTIFACT_GROUP = CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__ARTIFACTS = CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONSTRAINT_GROUP = CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONSTRAINTS = CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DISPLAY_NAME = CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__MUTABLE = CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__STEREOTYPES = CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BUILD_VERSION = CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LINK_TYPE = CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ORIGIN = CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Interface Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__INTERFACE_GROUP = CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__INTERFACE = CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROTOCOL = CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__VERSION = CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getSoftwareComponent()
	 * @generated
	 */
	int SOFTWARE_COMPONENT = 34;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ANNOTATIONS = BASE_COMPONENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ATTRIBUTE_META_DATA = BASE_COMPONENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__EXTENDED_ATTRIBUTES = BASE_COMPONENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ARTIFACT_GROUP = BASE_COMPONENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ARTIFACTS = BASE_COMPONENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONSTRAINT_GROUP = BASE_COMPONENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONSTRAINTS = BASE_COMPONENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__DESCRIPTION = BASE_COMPONENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__DISPLAY_NAME = BASE_COMPONENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__MUTABLE = BASE_COMPONENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__NAME = BASE_COMPONENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CAPABILITY_GROUP = BASE_COMPONENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CAPABILITIES = BASE_COMPONENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__REQUIREMENT_GROUP = BASE_COMPONENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__REQUIREMENTS = BASE_COMPONENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__UNIT_LINKS_GROUP = BASE_COMPONENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__UNIT_LINKS = BASE_COMPONENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONSTRAINT_LINKS = BASE_COMPONENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__REALIZATION_LINKS = BASE_COMPONENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__STEREOTYPES = BASE_COMPONENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__BUILD_VERSION = BASE_COMPONENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONCEPTUAL = BASE_COMPONENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONFIGURATION_UNIT = BASE_COMPONENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__GOAL_INSTALL_STATE = BASE_COMPONENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__INIT_INSTALL_STATE = BASE_COMPONENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ORIGIN = BASE_COMPONENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__PUBLISH_INTENT = BASE_COMPONENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Software Component</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT_FEATURE_COUNT = BASE_COMPONENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.impl.StereotypeImpl <em>Stereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.impl.StereotypeImpl
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getStereotype()
	 * @generated
	 */
	int STEREOTYPE = 35;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__KEYWORD = 0;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__PROFILE = 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__REQUIRED = 2;

	/**
	 * The number of structural features of the '<em>Stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To String Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__ANNOTATIONS = DEPLOY_MODEL_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>GlobalProperties</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	int TOPOLOGY__GLOBAL_PROPERTIES = -1;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__ATTRIBUTE_META_DATA = DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__EXTENDED_ATTRIBUTES = DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__ARTIFACT_GROUP = DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__ARTIFACTS = DEPLOY_MODEL_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__CONSTRAINT_GROUP = DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__CONSTRAINTS = DEPLOY_MODEL_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DESCRIPTION = DEPLOY_MODEL_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DISPLAY_NAME = DEPLOY_MODEL_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__MUTABLE = DEPLOY_MODEL_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__NAME = DEPLOY_MODEL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Unit Group</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__UNIT_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__UNITS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__UNIT_LINKS_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__UNIT_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__CONSTRAINT_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Dependency Link Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DEPENDENCY_LINK_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dependency Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DEPENDENCY_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__REALIZATION_LINKS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__IMPORTS = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Configuration Contract Group</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__CONFIGURATION_CONTRACT_GROUP = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Configuration Contract</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__CONFIGURATION_CONTRACT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Decorator Semantic</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__DECORATOR_SEMANTIC = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Mutability Configurable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__MUTABILITY_CONFIGURABLE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY__NAMESPACE = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Topology</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPOLOGY_FEATURE_COUNT = DEPLOY_MODEL_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes <em>Capability Link Types</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapabilityLinkTypes()
	 * @generated
	 */
	int CAPABILITY_LINK_TYPES = 40;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.InstallState <em>Install State</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstallState()
	 * @generated
	 */
	int INSTALL_STATE = 41;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.PublishIntent <em>Publish Intent</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPublishIntent()
	 * @generated
	 */
	int PUBLISH_INTENT = 42;

	/**
	 * The meta object id for the '<em>Generic Version String</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see java.lang.String
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getGenericVersionString()
	 * @generated
	 */
	int GENERIC_VERSION_STRING = 48;

	/**
	 * The meta object id for the '<em>Install State Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstallStateObject()
	 * @generated
	 */
	int INSTALL_STATE_OBJECT = 49;

	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 50;

	/**
	 * The meta object id for the '<em>Port Type</em>' data type.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see java.math.BigInteger
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPortType()
	 * @generated
	 */
	int PORT_TYPE = 51;

	/**
	 * The meta object id for the '<em>Publish Intent Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPublishIntentObject()
	 * @generated
	 */
	int PUBLISH_INTENT_OBJECT = 52;

	/**
	 * The meta object id for the '<em>Requirement Expression Usage Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpressionUsageObject()
	 * @generated
	 */
	int REQUIREMENT_EXPRESSION_USAGE_OBJECT = 53;

	/**
	 * The meta object id for the '<em>Requirement Link Types Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementLinkTypesObject()
	 * @generated
	 */
	int REQUIREMENT_LINK_TYPES_OBJECT = 54;

	/**
	 * The meta object id for the '<em>Requirement Usage Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementUsageObject()
	 * @generated
	 */
	int REQUIREMENT_USAGE_OBJECT = 55;

	/**
	 * The meta object id for the '<em>Service Range</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getServiceRange()
	 * @generated
	 */
	int SERVICE_RANGE = 56;

	/**
	 * The meta object id for the '<em>Service Version</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getServiceVersion()
	 * @generated
	 */
	int SERVICE_VERSION = 57;

	/**
	 * The meta object id for the '<em>Version Range</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVersionRange()
	 * @generated
	 */
	int VERSION_RANGE = 58;

	/**
	 * The meta object id for the '<em>Version String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVersionString()
	 * @generated
	 */
	int VERSION_STRING = 59;

	/**
	 * The meta object id for the '<em>Visibility Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVisibilityObject()
	 * @generated
	 */
	int VISIBILITY_OBJECT = 60;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Annotation#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Annotation#getAny()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Any();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.core.Annotation#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Details</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Annotation#getDetails()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Details();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Annotation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Annotation#getContext()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Context();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Artifact
	 * @generated
	 */
	EClass getArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData <em>Attribute Meta Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Meta Data</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData
	 * @generated
	 */
	EClass getAttributeMetaData();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#getAttributeName()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_AttributeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#getDescription()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted <em>Encrypted</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encrypted</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Encrypted();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired <em>Encryption Required</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encryption Required</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_EncryptionRequired();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#getLabel()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Label();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable <em>Mutable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutable</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Mutable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Optional();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter()
	 * @see #getAttributeMetaData()
	 * @generated
	 */
	EAttribute getAttributeMetaData_Parameter();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Augmentation <em>Augmentation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Augmentation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Augmentation
	 * @generated
	 */
	EClass getAugmentation();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Augmentation#getAdditions <em>Additions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Additions</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Augmentation#getAdditions()
	 * @see #getAugmentation()
	 * @generated
	 */
	EAttribute getAugmentation_Additions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Augmentation#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Augmentation#getFeature()
	 * @see #getAugmentation()
	 * @generated
	 */
	EAttribute getAugmentation_Feature();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Augmentation#getSelect <em>Select</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Augmentation#getSelect()
	 * @see #getAugmentation()
	 * @generated
	 */
	EAttribute getAugmentation_Select();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.BaseComponentUnit <em>Base Component Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Component Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.BaseComponentUnit
	 * @generated
	 */
	EClass getBaseComponentUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.BundleCapability <em>Bundle Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.BundleCapability
	 * @generated
	 */
	EClass getBundleCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.BundleCapability#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.BundleCapability#getId()
	 * @see #getBundleCapability()
	 * @generated
	 */
	EAttribute getBundleCapability_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.BundleCapability#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.BundleCapability#getVersion()
	 * @see #getBundleCapability()
	 * @generated
	 */
	EAttribute getBundleCapability_Version();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	EClass getCapability();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Capability#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Capability#getStereotypes()
	 * @see #getCapability()
	 * @generated
	 */
	EReference getCapability_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Capability#getBuildVersion <em>Build Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Capability#getBuildVersion()
	 * @see #getCapability()
	 * @generated
	 */
	EAttribute getCapability_BuildVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Capability#getLinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Capability#getLinkType()
	 * @see #getCapability()
	 * @generated
	 */
	EAttribute getCapability_LinkType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Capability#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Capability#getOrigin()
	 * @see #getCapability()
	 * @generated
	 */
	EAttribute getCapability_Origin();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability <em>Communication Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.CommunicationCapability
	 * @generated
	 */
	EClass getCommunicationCapability();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getApplicationLayerProtocol <em>Application Layer Protocol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Layer Protocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.CommunicationCapability#getApplicationLayerProtocol()
	 * @see #getCommunicationCapability()
	 * @generated
	 */
	EAttribute getCommunicationCapability_ApplicationLayerProtocol();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.CommunicationCapability#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.CommunicationCapability#getPort()
	 * @see #getCommunicationCapability()
	 * @generated
	 */
	EAttribute getCommunicationCapability_Port();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ConceptualNode <em>Conceptual Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conceptual Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ConceptualNode
	 * @generated
	 */
	EClass getConceptualNode();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ConfigurationContract <em>Configuration Contract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Contract</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ConfigurationContract
	 * @generated
	 */
	EClass getConfigurationContract();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ConstraintLink <em>Constraint Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ConstraintLink
	 * @generated
	 */
	EClass getConstraintLink();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.DependencyLink <em>Dependency Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DependencyLink
	 * @generated
	 */
	EClass getDependencyLink();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot <em>Deploy Core Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Core Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot
	 * @generated
	 */
	EClass getDeployCoreRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getMixed()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EAttribute getDeployCoreRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXMLNSPrefixMap()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXSISchemaLocation()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getAnnotation()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Annotation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifact()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Artifact();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifactFile <em>Artifact File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Artifact File</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifactFile()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_ArtifactFile();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getBaseComponent <em>Base Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getBaseComponent()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_BaseComponent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapability()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Capability();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityBundle <em>Capability Bundle</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Bundle</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityBundle()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_CapabilityBundle();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityCommunication <em>Capability Communication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Communication</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityCommunication()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_CapabilityCommunication();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getDeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deploy Model Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getDeployModelObject()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_DeployModelObject();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Import</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getImport()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Import();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInstantiation <em>Instantiation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instantiation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInstantiation()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Instantiation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInterface()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Interface();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkConstraint <em>Link Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkConstraint()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDependency <em>Link Dependency</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Dependency</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDependency()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkDependency();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDeploy <em>Link Deploy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Deploy</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDeploy()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkDeploy();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkHosting <em>Link Hosting</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Hosting</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkHosting()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkHosting();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkUnit <em>Link Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkUnit()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkMember <em>Link Member</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Member</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkMember()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkMember();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkRealization <em>Link Realization</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link Realization</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkRealization()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_LinkRealization();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getProperty()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Property();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReference()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReqExpr <em>Req Expr</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Req Expr</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReqExpr()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_ReqExpr();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getService <em>Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getService()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Service();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getSoftwareComponent <em>Software Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Software Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getSoftwareComponent()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_SoftwareComponent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotype</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getStereotype()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Stereotype();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getRequirement()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Requirement();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getTopology <em>Topology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Topology</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getTopology()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Topology();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnitConceptualNode <em>Unit Conceptual Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Conceptual Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnitConceptualNode()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_UnitConceptualNode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getVisibility()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EAttribute getDeployCoreRoot_Visibility();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.DeployLink <em>Deploy Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployLink
	 * @generated
	 */
	EClass getDeployLink();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployLink#getSourceURI <em>Source URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployLink#getSourceURI()
	 * @see #getDeployLink()
	 * @generated
	 */
	EAttribute getDeployLink_SourceURI();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployLink#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployLink#getTargetURI()
	 * @see #getDeployLink()
	 * @generated
	 */
	EAttribute getDeployLink_TargetURI();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnit()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Unit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConfigTopology <em>Config Topology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config Topology</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConfigTopology()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_ConfigTopology();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConstraint()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_Constraint();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractExplicit <em>Contract Explicit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contract Explicit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractExplicit()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_ContractExplicit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractTopology <em>Contract Topology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contract Topology</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractTopology()
	 * @see #getDeployCoreRoot()
	 * @generated
	 */
	EReference getDeployCoreRoot_ContractTopology();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Model Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	EClass getDeployModelObject();

	/**
	 * Returns the meta object for the attribute '<em>Visibility</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see ConfigurationContract#export(DeployModelObject, boolean)
	 * @see Agreement#isPublic(DeployModelObject)
	 * @see Agreement#isPublicEditable(DeployModelObject)
	 * @see #getDeployModelObject()
	 */
	EAttribute getDeployModelObject_Visibility();

	/**
	 * Returns the meta object for the containment reference list '<em>ExportedProperties</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>ExportedProperties</em>'.
	 * @see ConfigurationContract#export(DeployModelObject, org.eclipse.emf.ecore.EStructuralFeature)
	 * @see ConfigurationContract#export(DeployModelObject, String)
	 * @see Agreement#isPublicEditable(DeployModelObject, String)
	 * @see #getDeployModelObject()
	 */
	EAttribute getDeployModelObject_ExportedProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getAnnotations()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EReference getDeployModelObject_Annotations();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getAttributeMetaData <em>Attribute Meta Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Meta Data</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getAttributeMetaData()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EReference getDeployModelObject_AttributeMetaData();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getExtendedAttributes <em>Extended Attributes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extended Attributes</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getExtendedAttributes()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EReference getDeployModelObject_ExtendedAttributes();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Artifact Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Artifact Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_ArtifactGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Artifacts</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Artifacts</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EReference getDeployModelObject_Artifacts();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Constraint Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Constraint Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_ConstraintGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Constraints</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EReference getDeployModelObject_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getDescription()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getDisplayName()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_DisplayName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable <em>Mutable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutable</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#isMutable()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_Mutable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject#getName()
	 * @see #getDeployModelObject()
	 * @generated
	 */
	EAttribute getDeployModelObject_Name();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObjectSet <em>Deploy Model Object Set</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Model Object Set</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObjectSet
	 * @generated
	 */
	EClass getDeployModelObjectSet();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObjectGroup <em>Deploy Model Object Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Deploy Model Object Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObjectGroup()
	 * @see #getDeployModelObjectSet()
	 * @generated
	 */
	EAttribute getDeployModelObjectSet_DeployModelObjectGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deploy Model Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObject()
	 * @see #getDeployModelObjectSet()
	 * @generated
	 */
	EReference getDeployModelObjectSet_DeployModelObject();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract <em>Explicit Contract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Explicit Contract</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExplicitContract
	 * @generated
	 */
	EClass getExplicitContract();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getExportedUnits <em>Exported Units</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Units</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExplicitContract#getExportedUnits()
	 * @see #getExplicitContract()
	 * @generated
	 */
	EReference getExplicitContract_ExportedUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExplicitContract#getProperties()
	 * @see #getExplicitContract()
	 * @generated
	 */
	EReference getExplicitContract_Properties();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Conceptual Policy</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultConceptualPolicy()
	 * @see #getExplicitContract()
	 * @generated
	 */
	EAttribute getExplicitContract_DefaultConceptualPolicy();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy <em>Default Policy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Policy</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExplicitContract#getDefaultPolicy()
	 * @see #getExplicitContract()
	 * @generated
	 */
	EAttribute getExplicitContract_DefaultPolicy();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Exported <em>Exported</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exported</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Exported
	 * @generated
	 */
	EClass getExported();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Exported#isConfigurable <em>Configurable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configurable</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Exported#isConfigurable()
	 * @see #getExported()
	 * @generated
	 */
	EAttribute getExported_Configurable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Exported#isLinkable <em>Linkable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linkable</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Exported#isLinkable()
	 * @see #getExported()
	 * @generated
	 */
	EAttribute getExported_Linkable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Exported#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Exported#getName()
	 * @see #getExported()
	 * @generated
	 */
	EAttribute getExported_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Exported#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Exported#getPath()
	 * @see #getExported()
	 * @generated
	 */
	EAttribute getExported_Path();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit <em>Exported Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exported Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit
	 * @generated
	 */
	EClass getExportedUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedCapabilities <em>Exported Capabilities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Capabilities</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedCapabilities()
	 * @see #getExportedUnit()
	 * @generated
	 */
	EReference getExportedUnit_ExportedCapabilities();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedRequirements <em>Exported Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Requirements</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedRequirements()
	 * @see #getExportedUnit()
	 * @generated
	 */
	EReference getExportedUnit_ExportedRequirements();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedProperties <em>Exported Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Properties</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit#getExportedProperties()
	 * @see #getExportedUnit()
	 * @generated
	 */
	EReference getExportedUnit_ExportedProperties();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getConstraintGroup <em>Constraint Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Constraint Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit#getConstraintGroup()
	 * @see #getExportedUnit()
	 * @generated
	 */
	EAttribute getExportedUnit_ConstraintGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.ExportedUnit#getAugmentedConstraints <em>Augmented Constraints</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Augmented Constraints</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExportedUnit#getAugmentedConstraints()
	 * @see #getExportedUnit()
	 * @generated
	 */
	EReference getExportedUnit_AugmentedConstraints();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute <em>Extended Attribute</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Attribute</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute
	 * @generated
	 */
	EClass getExtendedAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute <em>Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute
	 * @see #getExtendedAttribute()
	 * @generated
	 */
	EReference getExtendedAttribute_Data();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getName()
	 * @see #getExtendedAttribute()
	 * @generated
	 */
	EAttribute getExtendedAttribute_Name();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.FileArtifact <em>File Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.FileArtifact
	 * @generated
	 */
	EClass getFileArtifact();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.FileArtifact#getFileURIs <em>File UR Is</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>File UR Is</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.FileArtifact#getFileURIs()
	 * @see #getFileArtifact()
	 * @generated
	 */
	EAttribute getFileArtifact_FileURIs();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.HostingLink <em>Hosting Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hosting Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.HostingLink
	 * @generated
	 */
	EClass getHostingLink();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Import <em>Import</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration <em>Instance Configuration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance Configuration</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_InstanceConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Import#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Import#getNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Import#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Import#getPattern()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Import#isReexported <em>Reexported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reexported</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Import#isReexported()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Reexported();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.InstanceConfiguration <em>Instance Configuration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Configuration</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.InstanceConfiguration
	 * @generated
	 */
	EClass getInstanceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Agreement#getPublicUnits() <em>PublicUnits</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>PublicUnits</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Agreement#getPublicUnits()
	 * @see #getInstanceConfiguration()
	 */
	EAttribute getInstanceConfiguration_PublicUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Agreement#getPublicEditableUnits() <em>PublicEditableUnits</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>PublicEditableUnits</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Agreement#getPublicEditableUnits()
	 * @see #getInstanceConfiguration()
	 */
	EAttribute getInstanceConfiguration_PublicEditableUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Agreement#getGlobalProperties() <em>GlobalProperties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>GlobalProperties</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Agreement#getGlobalProperties()
	 * @see #getInstanceConfiguration()
	 */
	EAttribute getInstanceConfiguration_GlobalProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getInstantiations <em>Instantiations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instantiations</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getInstantiations()
	 * @see #getInstanceConfiguration()
	 * @generated
	 */
	EReference getInstanceConfiguration_Instantiations();

	/**
	 * Returns the meta object for the container reference '{@link com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getImported <em>Imported</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Imported</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getImported()
	 * @see #getInstanceConfiguration()
	 * @generated
	 */
	EReference getInstanceConfiguration_Imported();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Instantiation <em>Instantiation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation
	 * @generated
	 */
	EClass getInstantiation();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Instantiation <em>Configured Capability Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Configured Capability Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation
	 * @see #getInstantiation()
	 * @generated
	 */
	EAttribute getInstantiation_ConfiguredCapabilityGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Instantiation <em>Configured Capabilities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configured Capabilities</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation
	 * @see #getInstantiation()
	 * @generated
	 */
	EReference getInstantiation_ConfiguredCapabilities();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Instantiation <em>Configured Requirements Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Configured Requirements Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation
	 * @see #getInstantiation()
	 * @generated
	 */
	EAttribute getInstantiation_ConfiguredRequirementsGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Instantiation <em>Configured Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configured Requirements</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation
	 * @see #getInstantiation()
	 * @generated
	 */
	EReference getInstantiation_ConfiguredRequirements();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Instantiation#getConfiguredProperties <em>Configured Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configured Properties</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation#getConfiguredProperties()
	 * @see #getInstantiation()
	 * @generated
	 */
	EReference getInstantiation_ConfiguredProperties();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentationGroup <em>Augmentation Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Augmentation Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentationGroup()
	 * @see #getInstantiation()
	 * @generated
	 */
	EAttribute getInstantiation_AugmentationGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentations <em>Augmentations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Augmentations</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentations()
	 * @see #getInstantiation()
	 * @generated
	 */
	EReference getInstantiation_Augmentations();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Instantiation#getReferenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referenced</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Instantiation#getReferenced()
	 * @see #getInstantiation()
	 * @generated
	 */
	EAttribute getInstantiation_Referenced();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.MemberLink <em>Member Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.MemberLink
	 * @generated
	 */
	EClass getMemberLink();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Property <em>Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Property#getSelect <em>Select</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Property#getSelect()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Select();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.RealizationLink <em>Realization Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realization Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RealizationLink
	 * @generated
	 */
	EClass getRealizationLink();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Reference <em>Interface Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Interface Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Reference
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_InterfaceGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.Reference <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Reference
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Interface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Reference#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Reference#getRange()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Range();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Requirement <em>Dependency Link Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dependency Link Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_DependencyLinkGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.Requirement <em>Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Link();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Requirement <em>Dmo Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dmo Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_DmoType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Requirement#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement#getExtends()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Extends();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Requirement#getLinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement#getLinkType()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_LinkType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Requirement#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Requirement#getUse()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Use();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression <em>Requirement Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Expression</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression
	 * @generated
	 */
	EClass getRequirementExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression#getAttributeName()
	 * @see #getRequirementExpression()
	 * @generated
	 */
	EAttribute getRequirementExpression_AttributeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getInterpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpreter</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression#getInterpreter()
	 * @see #getRequirementExpression()
	 * @generated
	 */
	EAttribute getRequirementExpression_Interpreter();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse()
	 * @see #getRequirementExpression()
	 * @generated
	 */
	EAttribute getRequirementExpression_Use();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpression#getValue()
	 * @see #getRequirementExpression()
	 * @generated
	 */
	EAttribute getRequirementExpression_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Service <em>Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Service <em>Interface Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Interface Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Service
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_InterfaceGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.Service <em>Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Service
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Interface();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Service#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Service#getProtocol()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Protocol();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Service#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Service#getVersion()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Version();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.SoftwareComponent <em>Software Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Component</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.SoftwareComponent
	 * @generated
	 */
	EClass getSoftwareComponent();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Stereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Stereotype
	 * @generated
	 */
	EClass getStereotype();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Stereotype#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Stereotype#getKeyword()
	 * @see #getStereotype()
	 * @generated
	 */
	EAttribute getStereotype_Keyword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Stereotype#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Stereotype#getProfile()
	 * @see #getStereotype()
	 * @generated
	 */
	EAttribute getStereotype_Profile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Stereotype#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Stereotype#isRequired()
	 * @see #getStereotype()
	 * @generated
	 */
	EAttribute getStereotype_Required();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To String Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        keyExtendedMetaData="kind='attribute' name='key'"
	 *        valueDataType="org.eclipse.emf.ecore.xml.type.String"
	 *        valueExtendedMetaData="kind='attribute' name='value'"
	 *        extendedMetaData="name='StringToStringEntry' kind='empty'"
	 * @generated
	 */
	EClass getStringToStringEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringEntry()
	 * @generated
	 */
	EAttribute getStringToStringEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringEntry()
	 * @generated
	 */
	EAttribute getStringToStringEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Topology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topology</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @generated
	 */
	EClass getTopology();

	/**
	 * Returns the meta object for the containment reference list '<em>GlobalProperties</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>GlobalProperties</em>'.
	 * @see Agreement#getGlobalProperties()
	 * @see Agreement#getProperty(String)
	 * @see ConfigurationContract#exportProperty(String)
	 * @see ConfigurationContract#unexportProperty(String)
	 */
	EAttribute getTopology_GlobalProperties();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Unit Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unit Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_UnitGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Units</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_Units();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Unit Links Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unit Links Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_UnitLinksGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Unit Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_UnitLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Constraint Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_ConstraintLinks();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Dependency Link Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dependency Link Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_DependencyLinkGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Dependency Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependency Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_DependencyLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology <em>Realization Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realization Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_RealizationLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Topology#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getImports()
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_Imports();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContractGroup <em>Configuration Contract Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Configuration Contract Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContractGroup()
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_ConfigurationContractGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContract <em>Configuration Contract</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration Contract</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContract()
	 * @see #getTopology()
	 * @generated
	 */
	EReference getTopology_ConfigurationContract();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Topology#getDecoratorSemantic <em>Decorator Semantic</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decorator Semantic</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getDecoratorSemantic()
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_DecoratorSemantic();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable <em>Mutability Configurable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutability Configurable</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable()
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_MutabilityConfigurable();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Topology#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getNamespace()
	 * @see #getTopology()
	 * @generated
	 */
	EAttribute getTopology_Namespace();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Capability Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Capability Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_CapabilityGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Capabilities</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Capabilities</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Capabilities();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Requirement Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Requirement Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_RequirementGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Requirements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Requirements();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit Links Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unit Links Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_UnitLinksGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_UnitLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Constraint Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_ConstraintLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Realization Links</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realization Links</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_RealizationLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.Unit#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getStereotypes()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Stereotypes();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#getBuildVersion <em>Build Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getBuildVersion()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_BuildVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#isConceptual <em>Conceptual</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conceptual</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#isConceptual()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Conceptual();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit <em>Configuration Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_ConfigurationUnit();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState <em>Goal Install State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goal Install State</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_GoalInstallState();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState <em>Init Install State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Install State</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_InitInstallState();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getOrigin()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Origin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent <em>Publish Intent</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publish Intent</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_PublishIntent();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.UnitLink <em>Unit Link</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Link</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.UnitLink
	 * @generated
	 */
	EClass getUnitLink();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes <em>Capability Link Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Capability Link Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @generated
	 */
	EEnum getCapabilityLinkTypes();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.InstallState <em>Install State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Install State</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @generated
	 */
	EEnum getInstallState();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.PublishIntent <em>Publish Intent</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Publish Intent</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @generated
	 */
	EEnum getPublishIntent();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage <em>Requirement Expression Usage</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Requirement Expression Usage</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @generated
	 */
	EEnum getRequirementExpressionUsage();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes <em>Requirement Link Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Requirement Link Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @generated
	 */
	EEnum getRequirementLinkTypes();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.RequirementUsage <em>Requirement Usage</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Requirement Usage</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @generated
	 */
	EEnum getRequirementUsage();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes <em>Capability Link Types Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Capability Link Types Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes"
	 *        extendedMetaData="name='CapabilityLinkTypes:Object' baseType='CapabilityLinkTypes'"
	 * @generated
	 */
	EDataType getCapabilityLinkTypesObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Generic Version String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Generic Version String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='GenericVersionString' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='200' pattern='([0-9a-zA-Z]+(([\\+_%20\\-]*)+[0-9a-zA-Z]+)*)+(\\.([0-9a-zA-Z]+(([\\+_%20\\-]*)+[0-9a-zA-Z]+)*)){0,99}'"
	 * @generated
	 */
	EDataType getGenericVersionString();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.InstallState <em>Install State Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Install State Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.InstallState"
	 *        extendedMetaData="name='InstallState:Object' baseType='InstallState'"
	 * @generated
	 */
	EDataType getInstallStateObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>IStatus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IStatus</em>'.
	 * @see org.eclipse.core.runtime.IStatus
	 * @model instanceClass="org.eclipse.core.runtime.IStatus"
	 *        extendedMetaData="name='IStatus'"
	 * @generated
	 */
	EDataType getIStatus();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>Port Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Port Type</em>'.
	 * @see java.math.BigInteger
	 * @model instanceClass="java.math.BigInteger"
	 *        extendedMetaData="name='PortType' baseType='http://www.eclipse.org/emf/2003/XMLType#integer' minInclusive='1' maxInclusive='65535'"
	 * @generated
	 */
	EDataType getPortType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.PublishIntent <em>Publish Intent Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Publish Intent Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.PublishIntent"
	 *        extendedMetaData="name='PublishIntent:Object' baseType='PublishIntent'"
	 * @generated
	 */
	EDataType getPublishIntentObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage <em>Requirement Expression Usage Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Requirement Expression Usage Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage"
	 *        extendedMetaData="name='RequirementExpressionUsage:Object' baseType='RequirementExpressionUsage'"
	 * @generated
	 */
	EDataType getRequirementExpressionUsageObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes <em>Requirement Link Types Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Requirement Link Types Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.RequirementLinkTypes"
	 *        extendedMetaData="name='RequirementLinkTypes:Object' baseType='RequirementLinkTypes'"
	 * @generated
	 */
	EDataType getRequirementLinkTypesObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.RequirementUsage <em>Requirement Usage Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Requirement Usage Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.RequirementUsage"
	 *        extendedMetaData="name='RequirementUsage:Object' baseType='RequirementUsage'"
	 * @generated
	 */
	EDataType getRequirementUsageObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Service Range</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Service Range</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ServiceRange' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[%20]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]'"
	 * @generated
	 */
	EDataType getServiceRange();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Service Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Service Version</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ServiceVersion' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}'"
	 * @generated
	 */
	EDataType getServiceVersion();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Version Range</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Version Range</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='VersionRange' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[%20]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]'"
	 * @generated
	 */
	EDataType getVersionRange();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Version String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Version String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='VersionString' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='([0-9]{1,9})(\\.[0-9]{1,9}){0,3}'"
	 * @generated
	 */
	EDataType getVersionString();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.Visibility <em>Visibility Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Visibility Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.Visibility"
	 *        extendedMetaData="name='Visibility:Object' baseType='Visibility'"
	 * @generated
	 */
	EDataType getVisibilityObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.AnnotationImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANNOTATION__ANY = eINSTANCE.getAnnotation_Any();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION__DETAILS = eINSTANCE.getAnnotation_Details();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANNOTATION__CONTEXT = eINSTANCE.getAnnotation_Context();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ArtifactImpl <em>Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getArtifact()
		 * @generated
		 */
		EClass ARTIFACT = eINSTANCE.getArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl <em>Attribute Meta Data</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAttributeMetaData()
		 * @generated
		 */
		EClass ATTRIBUTE_META_DATA = eINSTANCE.getAttributeMetaData();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__ATTRIBUTE_NAME = eINSTANCE.getAttributeMetaData_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__DESCRIPTION = eINSTANCE.getAttributeMetaData_Description();

		/**
		 * The meta object literal for the '<em><b>Encrypted</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__ENCRYPTED = eINSTANCE.getAttributeMetaData_Encrypted();

		/**
		 * The meta object literal for the '<em><b>Encryption Required</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED = eINSTANCE.getAttributeMetaData_EncryptionRequired();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__LABEL = eINSTANCE.getAttributeMetaData_Label();

		/**
		 * The meta object literal for the '<em><b>Mutable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__MUTABLE = eINSTANCE.getAttributeMetaData_Mutable();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__OPTIONAL = eINSTANCE.getAttributeMetaData_Optional();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_META_DATA__PARAMETER = eINSTANCE.getAttributeMetaData_Parameter();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl <em>Augmentation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getAugmentation()
		 * @generated
		 */
		EClass AUGMENTATION = eINSTANCE.getAugmentation();

		/**
		 * The meta object literal for the '<em><b>Additions</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUGMENTATION__ADDITIONS = eINSTANCE.getAugmentation_Additions();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AUGMENTATION__FEATURE = eINSTANCE.getAugmentation_Feature();

		/**
		 * The meta object literal for the '<em><b>Select</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AUGMENTATION__SELECT = eINSTANCE.getAugmentation_Select();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.BaseComponentUnitImpl <em>Base Component Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.BaseComponentUnitImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getBaseComponentUnit()
		 * @generated
		 */
		EClass BASE_COMPONENT_UNIT = eINSTANCE.getBaseComponentUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl <em>Bundle Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.BundleCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getBundleCapability()
		 * @generated
		 */
		EClass BUNDLE_CAPABILITY = eINSTANCE.getBundleCapability();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_CAPABILITY__ID = eINSTANCE.getBundleCapability_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_CAPABILITY__VERSION = eINSTANCE.getBundleCapability_Version();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl <em>Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapability()
		 * @generated
		 */
		EClass CAPABILITY = eINSTANCE.getCapability();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPABILITY__STEREOTYPES = eINSTANCE.getCapability_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Build Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPABILITY__BUILD_VERSION = eINSTANCE.getCapability_BuildVersion();

		/**
		 * The meta object literal for the '<em><b>Link Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAPABILITY__LINK_TYPE = eINSTANCE.getCapability_LinkType();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAPABILITY__ORIGIN = eINSTANCE.getCapability_Origin();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl <em>Communication Capability</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCommunicationCapability()
		 * @generated
		 */
		EClass COMMUNICATION_CAPABILITY = eINSTANCE.getCommunicationCapability();

		/**
		 * The meta object literal for the '<em><b>Application Layer Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL = eINSTANCE.getCommunicationCapability_ApplicationLayerProtocol();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_CAPABILITY__PORT = eINSTANCE.getCommunicationCapability_Port();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConceptualNodeImpl <em>Conceptual Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ConceptualNodeImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConceptualNode()
		 * @generated
		 */
		EClass CONCEPTUAL_NODE = eINSTANCE.getConceptualNode();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConfigurationContractImpl <em>Configuration Contract</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ConfigurationContractImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConfigurationContract()
		 * @generated
		 */
		EClass CONFIGURATION_CONTRACT = eINSTANCE.getConfigurationContract();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ConstraintLinkImpl <em>Constraint Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ConstraintLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getConstraintLink()
		 * @generated
		 */
		EClass CONSTRAINT_LINK = eINSTANCE.getConstraintLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.DependencyLinkImpl <em>Dependency Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.DependencyLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDependencyLink()
		 * @generated
		 */
		EClass DEPENDENCY_LINK = eINSTANCE.getDependencyLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl <em>Deploy Core Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployCoreRoot()
		 * @generated
		 */
		EClass DEPLOY_CORE_ROOT = eINSTANCE.getDeployCoreRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_CORE_ROOT__MIXED = eINSTANCE.getDeployCoreRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDeployCoreRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDeployCoreRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__ANNOTATION = eINSTANCE.getDeployCoreRoot_Annotation();

		/**
		 * The meta object literal for the '<em><b>Artifact</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__ARTIFACT = eINSTANCE.getDeployCoreRoot_Artifact();

		/**
		 * The meta object literal for the '<em><b>Artifact File</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__ARTIFACT_FILE = eINSTANCE.getDeployCoreRoot_ArtifactFile();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__BASE_COMPONENT = eINSTANCE.getDeployCoreRoot_BaseComponent();

		/**
		 * The meta object literal for the '<em><b>Capability</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CAPABILITY = eINSTANCE.getDeployCoreRoot_Capability();

		/**
		 * The meta object literal for the '<em><b>Capability Bundle</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE = eINSTANCE.getDeployCoreRoot_CapabilityBundle();

		/**
		 * The meta object literal for the '<em><b>Capability Communication</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION = eINSTANCE.getDeployCoreRoot_CapabilityCommunication();

		/**
		 * The meta object literal for the '<em><b>Deploy Model Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT = eINSTANCE.getDeployCoreRoot_DeployModelObject();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__IMPORT = eINSTANCE.getDeployCoreRoot_Import();

		/**
		 * The meta object literal for the '<em><b>Instantiation</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__INSTANTIATION = eINSTANCE.getDeployCoreRoot_Instantiation();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__INTERFACE = eINSTANCE.getDeployCoreRoot_Interface();

		/**
		 * The meta object literal for the '<em><b>Link Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_CONSTRAINT = eINSTANCE.getDeployCoreRoot_LinkConstraint();

		/**
		 * The meta object literal for the '<em><b>Link Dependency</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_DEPENDENCY = eINSTANCE.getDeployCoreRoot_LinkDependency();

		/**
		 * The meta object literal for the '<em><b>Link Deploy</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_DEPLOY = eINSTANCE.getDeployCoreRoot_LinkDeploy();

		/**
		 * The meta object literal for the '<em><b>Link Hosting</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_HOSTING = eINSTANCE.getDeployCoreRoot_LinkHosting();

		/**
		 * The meta object literal for the '<em><b>Link Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_UNIT = eINSTANCE.getDeployCoreRoot_LinkUnit();

		/**
		 * The meta object literal for the '<em><b>Link Member</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_MEMBER = eINSTANCE.getDeployCoreRoot_LinkMember();

		/**
		 * The meta object literal for the '<em><b>Link Realization</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__LINK_REALIZATION = eINSTANCE.getDeployCoreRoot_LinkRealization();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__PROPERTY = eINSTANCE.getDeployCoreRoot_Property();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__REFERENCE = eINSTANCE.getDeployCoreRoot_Reference();

		/**
		 * The meta object literal for the '<em><b>Req Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__REQ_EXPR = eINSTANCE.getDeployCoreRoot_ReqExpr();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__SERVICE = eINSTANCE.getDeployCoreRoot_Service();

		/**
		 * The meta object literal for the '<em><b>Software Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT = eINSTANCE.getDeployCoreRoot_SoftwareComponent();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__STEREOTYPE = eINSTANCE.getDeployCoreRoot_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__REQUIREMENT = eINSTANCE.getDeployCoreRoot_Requirement();

		/**
		 * The meta object literal for the '<em><b>Topology</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__TOPOLOGY = eINSTANCE.getDeployCoreRoot_Topology();

		/**
		 * The meta object literal for the '<em><b>Unit Conceptual Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE = eINSTANCE.getDeployCoreRoot_UnitConceptualNode();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_CORE_ROOT__VISIBILITY = eINSTANCE.getDeployCoreRoot_Visibility();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl <em>Deploy Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployLink()
		 * @generated
		 */
		EClass DEPLOY_LINK = eINSTANCE.getDeployLink();

		/**
		 * The meta object literal for the '<em><b>Source URI</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_LINK__SOURCE_URI = eINSTANCE.getDeployLink_SourceURI();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_LINK__TARGET_URI = eINSTANCE.getDeployLink_TargetURI();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__UNIT = eINSTANCE.getDeployCoreRoot_Unit();

		/**
		 * The meta object literal for the '<em><b>Config Topology</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY = eINSTANCE.getDeployCoreRoot_ConfigTopology();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CONSTRAINT = eINSTANCE.getDeployCoreRoot_Constraint();

		/**
		 * The meta object literal for the '<em><b>Contract Explicit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT = eINSTANCE.getDeployCoreRoot_ContractExplicit();

		/**
		 * The meta object literal for the '<em><b>Contract Topology</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY = eINSTANCE.getDeployCoreRoot_ContractTopology();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl <em>Deploy Model Object</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployModelObject()
		 * @generated
		 */
		EClass DEPLOY_MODEL_OBJECT = eINSTANCE.getDeployModelObject();

		/**
		 * The attribute for the non-EMF '<em><b>Status</b></em>' attribute.
		 * 
		 * @see DeployModelObject#getStatus()
		 * @see DeployModelObject#addStatus()
		 * @see DeployModelObject#clearStatus()
		 */
		EAttribute DEPLOY_MODEL_OBJECT__STATUS = ((CorePackageImpl) eINSTANCE)
				.createDeployModelObject_Status();

		/**
		 * The attribute for the non-EMF '<em><b>Visibility</b></em>' attribute.
		 * 
		 * @see ConfigurationContract#export(DeployModelObject, boolean)
		 * @see Agreement#isPublic(DeployModelObject)
		 * @see Agreement#isPublicEditable(DeployModelObject)
		 */
		EAttribute DEPLOY_MODEL_OBJECT__VISIBILITY = ((CorePackageImpl) eINSTANCE)
				.createDeployModelObject_Visibility();

		/**
		 * The attribute for the non-EMF '<em><b>ExportedProperties</b></em>' attribute.
		 * 
		 * @see ConfigurationContract#export(DeployModelObject,
		 *      org.eclipse.emf.ecore.EStructuralFeature)
		 * @see ConfigurationContract#export(DeployModelObject, String)
		 * @see Agreement#isPublicEditable(DeployModelObject, String)
		 */
		EAttribute DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES = ((CorePackageImpl) eINSTANCE)
				.createDeployModelObject_ExportedProperties();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT__ANNOTATIONS = eINSTANCE.getDeployModelObject_Annotations();

		/**
		 * The meta object literal for the '<em><b>Attribute Meta Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA = eINSTANCE.getDeployModelObject_AttributeMetaData();

		/**
		 * The meta object literal for the '<em><b>Extended Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES = eINSTANCE.getDeployModelObject_ExtendedAttributes();

		/**
		 * The meta object literal for the '<em><b>Artifact Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP = eINSTANCE.getDeployModelObject_ArtifactGroup();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT__ARTIFACTS = eINSTANCE.getDeployModelObject_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Constraint Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP = eINSTANCE.getDeployModelObject_ConstraintGroup();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT__CONSTRAINTS = eINSTANCE.getDeployModelObject_Constraints();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__DESCRIPTION = eINSTANCE.getDeployModelObject_Description();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__DISPLAY_NAME = eINSTANCE.getDeployModelObject_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Mutable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__MUTABLE = eINSTANCE.getDeployModelObject_Mutable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT__NAME = eINSTANCE.getDeployModelObject_Name();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl <em>Deploy Model Object Set</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getDeployModelObjectSet()
		 * @generated
		 */
		EClass DEPLOY_MODEL_OBJECT_SET = eINSTANCE.getDeployModelObjectSet();

		/**
		 * The meta object literal for the '<em><b>Deploy Model Object Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP = eINSTANCE.getDeployModelObjectSet_DeployModelObjectGroup();

		/**
		 * The meta object literal for the '<em><b>Deploy Model Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT = eINSTANCE.getDeployModelObjectSet_DeployModelObject();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl <em>Explicit Contract</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExplicitContract()
		 * @generated
		 */
		EClass EXPLICIT_CONTRACT = eINSTANCE.getExplicitContract();

		/**
		 * The meta object literal for the '<em><b>Exported Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPLICIT_CONTRACT__EXPORTED_UNITS = eINSTANCE.getExplicitContract_ExportedUnits();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPLICIT_CONTRACT__PROPERTIES = eINSTANCE.getExplicitContract_Properties();

		/**
		 * The meta object literal for the '<em><b>Default Conceptual Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY = eINSTANCE.getExplicitContract_DefaultConceptualPolicy();

		/**
		 * The meta object literal for the '<em><b>Default Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPLICIT_CONTRACT__DEFAULT_POLICY = eINSTANCE.getExplicitContract_DefaultPolicy();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl <em>Exported</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ExportedImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExported()
		 * @generated
		 */
		EClass EXPORTED = eINSTANCE.getExported();

		/**
		 * The meta object literal for the '<em><b>Configurable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXPORTED__CONFIGURABLE = eINSTANCE.getExported_Configurable();

		/**
		 * The meta object literal for the '<em><b>Linkable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXPORTED__LINKABLE = eINSTANCE.getExported_Linkable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXPORTED__NAME = eINSTANCE.getExported_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXPORTED__PATH = eINSTANCE.getExported_Path();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl <em>Exported Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExportedUnit()
		 * @generated
		 */
		EClass EXPORTED_UNIT = eINSTANCE.getExportedUnit();

		/**
		 * The meta object literal for the '<em><b>Exported Capabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_UNIT__EXPORTED_CAPABILITIES = eINSTANCE.getExportedUnit_ExportedCapabilities();

		/**
		 * The meta object literal for the '<em><b>Exported Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_UNIT__EXPORTED_REQUIREMENTS = eINSTANCE.getExportedUnit_ExportedRequirements();

		/**
		 * The meta object literal for the '<em><b>Exported Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_UNIT__EXPORTED_PROPERTIES = eINSTANCE.getExportedUnit_ExportedProperties();

		/**
		 * The meta object literal for the '<em><b>Constraint Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORTED_UNIT__CONSTRAINT_GROUP = eINSTANCE.getExportedUnit_ConstraintGroup();

		/**
		 * The meta object literal for the '<em><b>Augmented Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPORTED_UNIT__AUGMENTED_CONSTRAINTS = eINSTANCE.getExportedUnit_AugmentedConstraints();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl <em>Extended Attribute</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getExtendedAttribute()
		 * @generated
		 */
		EClass EXTENDED_ATTRIBUTE = eINSTANCE.getExtendedAttribute();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_ATTRIBUTE__DATA = eINSTANCE.getExtendedAttribute_Data();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENDED_ATTRIBUTE__NAME = eINSTANCE.getExtendedAttribute_Name();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl <em>File Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getFileArtifact()
		 * @generated
		 */
		EClass FILE_ARTIFACT = eINSTANCE.getFileArtifact();

		/**
		 * The meta object literal for the '<em><b>File UR Is</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ARTIFACT__FILE_UR_IS = eINSTANCE.getFileArtifact_FileURIs();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.HostingLinkImpl <em>Hosting Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.HostingLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getHostingLink()
		 * @generated
		 */
		EClass HOSTING_LINK = eINSTANCE.getHostingLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ImportImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Instance Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__INSTANCE_CONFIGURATION = eINSTANCE.getImport_InstanceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMPORT__NAMESPACE = eINSTANCE.getImport_Namespace();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMPORT__PATTERN = eINSTANCE.getImport_Pattern();

		/**
		 * The meta object literal for the '<em><b>Reexported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__REEXPORTED = eINSTANCE.getImport_Reexported();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl <em>Instance Configuration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstanceConfiguration()
		 * @generated
		 */
		EClass INSTANCE_CONFIGURATION = eINSTANCE.getInstanceConfiguration();

		/**
		 * The meta object literal for the '<em><b>PublicUnits</b></em>' containment reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 */
		EAttribute INSTANCE_CONFIGURATION__PUBLIC_UNITS = ((CorePackageImpl) eINSTANCE)
				.createInstanceConfiguration_PublicUnits();

		/**
		 * The meta object literal for the '<em><b>PublicEditableUnits</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 */
		EAttribute INSTANCE_CONFIGURATION__PUBLIC_EDITABLE_UNITS = ((CorePackageImpl) eINSTANCE)
				.createInstanceConfiguration_PublicEditableUnits();

		/**
		 * The meta object literal for the '<em><b>GlobalProperties</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 */
		EAttribute INSTANCE_CONFIGURATION__GLOBAL_PROPERTIES = ((CorePackageImpl) eINSTANCE)
				.createInstanceConfiguration_GlobalProperties();

		/**
		 * The meta object literal for the '<em><b>Instantiations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_CONFIGURATION__INSTANTIATIONS = eINSTANCE.getInstanceConfiguration_Instantiations();

		/**
		 * The meta object literal for the '<em><b>Imported</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_CONFIGURATION__IMPORTED = eINSTANCE.getInstanceConfiguration_Imported();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl <em>Instantiation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstantiation()
		 * @generated
		 */
		EClass INSTANTIATION = eINSTANCE.getInstantiation();

		/**
		 * The meta object literal for the '<em><b>Configured Capability Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANTIATION__CONFIGURED_CAPABILITY_GROUP = eINSTANCE.getInstantiation_ConfiguredCapabilityGroup();

		/**
		 * The meta object literal for the '<em><b>Configured Capabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION__CONFIGURED_CAPABILITIES = eINSTANCE.getInstantiation_ConfiguredCapabilities();

		/**
		 * The meta object literal for the '<em><b>Configured Requirements Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP = eINSTANCE.getInstantiation_ConfiguredRequirementsGroup();

		/**
		 * The meta object literal for the '<em><b>Configured Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION__CONFIGURED_REQUIREMENTS = eINSTANCE.getInstantiation_ConfiguredRequirements();

		/**
		 * The meta object literal for the '<em><b>Configured Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION__CONFIGURED_PROPERTIES = eINSTANCE.getInstantiation_ConfiguredProperties();

		/**
		 * The meta object literal for the '<em><b>Augmentation Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANTIATION__AUGMENTATION_GROUP = eINSTANCE.getInstantiation_AugmentationGroup();

		/**
		 * The meta object literal for the '<em><b>Augmentations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION__AUGMENTATIONS = eINSTANCE.getInstantiation_Augmentations();

		/**
		 * The meta object literal for the '<em><b>Referenced</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute INSTANTIATION__REFERENCED = eINSTANCE.getInstantiation_Referenced();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.InterfaceImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.MemberLinkImpl <em>Member Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.MemberLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getMemberLink()
		 * @generated
		 */
		EClass MEMBER_LINK = eINSTANCE.getMemberLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.PropertyImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Select</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__SELECT = eINSTANCE.getProperty_Select();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.RealizationLinkImpl <em>Realization Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.RealizationLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRealizationLink()
		 * @generated
		 */
		EClass REALIZATION_LINK = eINSTANCE.getRealizationLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ReferenceImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Interface Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__INTERFACE_GROUP = eINSTANCE.getReference_InterfaceGroup();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__INTERFACE = eINSTANCE.getReference_Interface();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE__RANGE = eINSTANCE.getReference_Range();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.RequirementImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Dependency Link Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__DEPENDENCY_LINK_GROUP = eINSTANCE.getRequirement_DependencyLinkGroup();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__LINK = eINSTANCE.getRequirement_Link();

		/**
		 * The meta object literal for the '<em><b>Dmo Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__DMO_TYPE = eINSTANCE.getRequirement_DmoType();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__EXTENDS = eINSTANCE.getRequirement_Extends();

		/**
		 * The meta object literal for the '<em><b>Link Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__LINK_TYPE = eINSTANCE.getRequirement_LinkType();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__USE = eINSTANCE.getRequirement_Use();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl <em>Requirement Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.RequirementExpressionImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpression()
		 * @generated
		 */
		EClass REQUIREMENT_EXPRESSION = eINSTANCE.getRequirementExpression();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME = eINSTANCE.getRequirementExpression_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Interpreter</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_EXPRESSION__INTERPRETER = eINSTANCE.getRequirementExpression_Interpreter();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_EXPRESSION__USE = eINSTANCE.getRequirementExpression_Use();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_EXPRESSION__VALUE = eINSTANCE.getRequirementExpression_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.ServiceImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Interface Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__INTERFACE_GROUP = eINSTANCE.getService_InterfaceGroup();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__INTERFACE = eINSTANCE.getService_Interface();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVICE__PROTOCOL = eINSTANCE.getService_Protocol();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVICE__VERSION = eINSTANCE.getService_Version();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getSoftwareComponent()
		 * @generated
		 */
		EClass SOFTWARE_COMPONENT = eINSTANCE.getSoftwareComponent();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.StereotypeImpl <em>Stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.StereotypeImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getStereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getStereotype();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE__KEYWORD = eINSTANCE.getStereotype_Keyword();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE__PROFILE = eINSTANCE.getStereotype_Profile();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE__REQUIRED = eINSTANCE.getStereotype_Required();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.StringToStringEntryImpl <em>String To String Entry</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.StringToStringEntryImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getStringToStringEntry()
		 * @generated
		 */
		EClass STRING_TO_STRING_ENTRY = eINSTANCE.getStringToStringEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_STRING_ENTRY__KEY = eINSTANCE.getStringToStringEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_STRING_ENTRY__VALUE = eINSTANCE.getStringToStringEntry_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl <em>Topology</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.TopologyImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getTopology()
		 * @generated
		 */
		EClass TOPOLOGY = eINSTANCE.getTopology();

		/**
		 * The attribute for the non-EMF '<em><b>GlobalProperties</b></em>' attribute.
		 * 
		 * @see ConfigurationContract#exportProperty(String)
		 * @see ConfigurationContract#unexportProperty(String)
		 * @see Agreement#getGlobalProperties()
		 */
		EAttribute TOPOLOGY__GLOBAL_PROPERTIES = ((CorePackageImpl) eINSTANCE)
				.createTopology_GlobalProperties();

		/**
		 * The meta object literal for the '<em><b>Unit Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__UNIT_GROUP = eINSTANCE.getTopology_UnitGroup();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__UNITS = eINSTANCE.getTopology_Units();

		/**
		 * The meta object literal for the '<em><b>Unit Links Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__UNIT_LINKS_GROUP = eINSTANCE.getTopology_UnitLinksGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__UNIT_LINKS = eINSTANCE.getTopology_UnitLinks();

		/**
		 * The meta object literal for the '<em><b>Constraint Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__CONSTRAINT_LINKS = eINSTANCE.getTopology_ConstraintLinks();

		/**
		 * The meta object literal for the '<em><b>Dependency Link Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__DEPENDENCY_LINK_GROUP = eINSTANCE.getTopology_DependencyLinkGroup();

		/**
		 * The meta object literal for the '<em><b>Dependency Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__DEPENDENCY_LINKS = eINSTANCE.getTopology_DependencyLinks();

		/**
		 * The meta object literal for the '<em><b>Realization Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__REALIZATION_LINKS = eINSTANCE.getTopology_RealizationLinks();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__IMPORTS = eINSTANCE.getTopology_Imports();

		/**
		 * The meta object literal for the '<em><b>Configuration Contract Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__CONFIGURATION_CONTRACT_GROUP = eINSTANCE.getTopology_ConfigurationContractGroup();

		/**
		 * The meta object literal for the '<em><b>Configuration Contract</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPOLOGY__CONFIGURATION_CONTRACT = eINSTANCE.getTopology_ConfigurationContract();

		/**
		 * The meta object literal for the '<em><b>Decorator Semantic</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__DECORATOR_SEMANTIC = eINSTANCE.getTopology_DecoratorSemantic();

		/**
		 * The meta object literal for the '<em><b>Mutability Configurable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPOLOGY__MUTABILITY_CONFIGURABLE = eINSTANCE.getTopology_MutabilityConfigurable();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TOPOLOGY__NAMESPACE = eINSTANCE.getTopology_Namespace();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.UnitImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Capability Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CAPABILITY_GROUP = eINSTANCE.getUnit_CapabilityGroup();

		/**
		 * The meta object literal for the '<em><b>Capabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__CAPABILITIES = eINSTANCE.getUnit_Capabilities();

		/**
		 * The meta object literal for the '<em><b>Requirement Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__REQUIREMENT_GROUP = eINSTANCE.getUnit_RequirementGroup();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__REQUIREMENTS = eINSTANCE.getUnit_Requirements();

		/**
		 * The meta object literal for the '<em><b>Unit Links Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__UNIT_LINKS_GROUP = eINSTANCE.getUnit_UnitLinksGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__UNIT_LINKS = eINSTANCE.getUnit_UnitLinks();

		/**
		 * The meta object literal for the '<em><b>Constraint Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__CONSTRAINT_LINKS = eINSTANCE.getUnit_ConstraintLinks();

		/**
		 * The meta object literal for the '<em><b>Realization Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__REALIZATION_LINKS = eINSTANCE.getUnit_RealizationLinks();

		/**
		 * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__STEREOTYPES = eINSTANCE.getUnit_Stereotypes();

		/**
		 * The meta object literal for the '<em><b>Build Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__BUILD_VERSION = eINSTANCE.getUnit_BuildVersion();

		/**
		 * The meta object literal for the '<em><b>Conceptual</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIT__CONCEPTUAL = eINSTANCE.getUnit_Conceptual();

		/**
		 * The meta object literal for the '<em><b>Configuration Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__CONFIGURATION_UNIT = eINSTANCE.getUnit_ConfigurationUnit();

		/**
		 * The meta object literal for the '<em><b>Goal Install State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__GOAL_INSTALL_STATE = eINSTANCE.getUnit_GoalInstallState();

		/**
		 * The meta object literal for the '<em><b>Init Install State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__INIT_INSTALL_STATE = eINSTANCE.getUnit_InitInstallState();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNIT__ORIGIN = eINSTANCE.getUnit_Origin();

		/**
		 * The meta object literal for the '<em><b>Publish Intent</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__PUBLISH_INTENT = eINSTANCE.getUnit_PublishIntent();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.impl.UnitLinkImpl <em>Unit Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.impl.UnitLinkImpl
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getUnitLink()
		 * @generated
		 */
		EClass UNIT_LINK = eINSTANCE.getUnitLink();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes <em>Capability Link Types</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapabilityLinkTypes()
		 * @generated
		 */
		EEnum CAPABILITY_LINK_TYPES = eINSTANCE.getCapabilityLinkTypes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.InstallState <em>Install State</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.InstallState
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstallState()
		 * @generated
		 */
		EEnum INSTALL_STATE = eINSTANCE.getInstallState();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.PublishIntent <em>Publish Intent</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPublishIntent()
		 * @generated
		 */
		EEnum PUBLISH_INTENT = eINSTANCE.getPublishIntent();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage <em>Requirement Expression Usage</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpressionUsage()
		 * @generated
		 */
		EEnum REQUIREMENT_EXPRESSION_USAGE = eINSTANCE.getRequirementExpressionUsage();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes <em>Requirement Link Types</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementLinkTypes()
		 * @generated
		 */
		EEnum REQUIREMENT_LINK_TYPES = eINSTANCE.getRequirementLinkTypes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.RequirementUsage <em>Requirement Usage</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementUsage()
		 * @generated
		 */
		EEnum REQUIREMENT_USAGE = eINSTANCE.getRequirementUsage();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.Visibility
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

		/**
		 * The meta object literal for the '<em>Capability Link Types Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getCapabilityLinkTypesObject()
		 * @generated
		 */
		EDataType CAPABILITY_LINK_TYPES_OBJECT = eINSTANCE.getCapabilityLinkTypesObject();

		/**
		 * The meta object literal for the '<em>Generic Version String</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.lang.String
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getGenericVersionString()
		 * @generated
		 */
		EDataType GENERIC_VERSION_STRING = eINSTANCE.getGenericVersionString();

		/**
		 * The meta object literal for the '<em>Install State Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.InstallState
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getInstallStateObject()
		 * @generated
		 */
		EDataType INSTALL_STATE_OBJECT = eINSTANCE.getInstallStateObject();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>Port Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPortType()
		 * @generated
		 */
		EDataType PORT_TYPE = eINSTANCE.getPortType();

		/**
		 * The meta object literal for the '<em>Publish Intent Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getPublishIntentObject()
		 * @generated
		 */
		EDataType PUBLISH_INTENT_OBJECT = eINSTANCE.getPublishIntentObject();

		/**
		 * The meta object literal for the '<em>Requirement Expression Usage Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementExpressionUsageObject()
		 * @generated
		 */
		EDataType REQUIREMENT_EXPRESSION_USAGE_OBJECT = eINSTANCE.getRequirementExpressionUsageObject();

		/**
		 * The meta object literal for the '<em>Requirement Link Types Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementLinkTypesObject()
		 * @generated
		 */
		EDataType REQUIREMENT_LINK_TYPES_OBJECT = eINSTANCE.getRequirementLinkTypesObject();

		/**
		 * The meta object literal for the '<em>Requirement Usage Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getRequirementUsageObject()
		 * @generated
		 */
		EDataType REQUIREMENT_USAGE_OBJECT = eINSTANCE.getRequirementUsageObject();

		/**
		 * The meta object literal for the '<em>Service Range</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getServiceRange()
		 * @generated
		 */
		EDataType SERVICE_RANGE = eINSTANCE.getServiceRange();

		/**
		 * The meta object literal for the '<em>Service Version</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.lang.String
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getServiceVersion()
		 * @generated
		 */
		EDataType SERVICE_VERSION = eINSTANCE.getServiceVersion();

		/**
		 * The meta object literal for the '<em>Version Range</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVersionRange()
		 * @generated
		 */
		EDataType VERSION_RANGE = eINSTANCE.getVersionRange();

		/**
		 * The meta object literal for the '<em>Version String</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.lang.String
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVersionString()
		 * @generated
		 */
		EDataType VERSION_STRING = eINSTANCE.getVersionString();

		/**
		 * The meta object literal for the '<em>Visibility Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.Visibility
		 * @see com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl#getVisibilityObject()
		 * @generated
		 */
		EDataType VISIBILITY_OBJECT = eINSTANCE.getVisibilityObject();

	}

} //CorePackage
