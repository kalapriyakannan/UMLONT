/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = com.ibm.ccl.soa.deploy.core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Attribute Meta Data</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Attribute Meta Data</em>'.
	 * @generated
	 */
	AttributeMetaData createAttributeMetaData();

	/**
	 * Returns a new object of class '<em>Augmentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Augmentation</em>'.
	 * @generated
	 */
	Augmentation createAugmentation();

	/**
	 * Returns a new object of class '<em>Base Component Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Component Unit</em>'.
	 * @generated
	 */
	BaseComponentUnit createBaseComponentUnit();

	/**
	 * Returns a new object of class '<em>Bundle Capability</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Bundle Capability</em>'.
	 * @generated
	 */
	BundleCapability createBundleCapability();

	/**
	 * Returns a new object of class '<em>Capability</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Capability</em>'.
	 * @generated
	 */
	Capability createCapability();

	/**
	 * Returns a new object of class '<em>Communication Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Capability</em>'.
	 * @generated
	 */
	CommunicationCapability createCommunicationCapability();

	/**
	 * Returns a new object of class '<em>Conceptual Node</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Conceptual Node</em>'.
	 * @generated
	 */
	ConceptualNode createConceptualNode();

	/**
	 * Returns a new object of class '<em>Constraint Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Link</em>'.
	 * @generated
	 */
	ConstraintLink createConstraintLink();

	/**
	 * Returns a new object of class '<em>Dependency Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Dependency Link</em>'.
	 * @generated
	 */
	DependencyLink createDependencyLink();

	/**
	 * Returns a new object of class '<em>Deploy Core Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Core Root</em>'.
	 * @generated
	 */
	DeployCoreRoot createDeployCoreRoot();

	/**
	 * Returns a new object of class '<em>Deploy Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Link</em>'.
	 * @generated
	 */
	DeployLink createDeployLink();

	/**
	 * Returns a new object of class '<em>Deploy Model Object Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deploy Model Object Set</em>'.
	 * @generated
	 */
	DeployModelObjectSet createDeployModelObjectSet();

	/**
	 * Returns a new object of class '<em>Explicit Contract</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Explicit Contract</em>'.
	 * @generated
	 */
	ExplicitContract createExplicitContract();

	/**
	 * Returns a new object of class '<em>Exported</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Exported</em>'.
	 * @generated
	 */
	Exported createExported();

	/**
	 * Returns a new object of class '<em>Exported Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Exported Unit</em>'.
	 * @generated
	 */
	ExportedUnit createExportedUnit();

	/**
	 * Returns a new object of class '<em>Extended Attribute</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Extended Attribute</em>'.
	 * @generated
	 */
	ExtendedAttribute createExtendedAttribute();

	/**
	 * Returns a new object of class '<em>File Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>File Artifact</em>'.
	 * @generated
	 */
	FileArtifact createFileArtifact();

	/**
	 * Returns a new object of class '<em>Hosting Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Hosting Link</em>'.
	 * @generated
	 */
	HostingLink createHostingLink();

	/**
	 * Returns a new object of class '<em>Import</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Instance Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Configuration</em>'.
	 * @generated
	 */
	InstanceConfiguration createInstanceConfiguration();

	/**
	 * Returns a new object of class '<em>Instantiation</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Instantiation</em>'.
	 * @generated
	 */
	Instantiation createInstantiation();

	/**
	 * Returns a new object of class '<em>Member Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Member Link</em>'.
	 * @generated
	 */
	MemberLink createMemberLink();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Realization Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Realization Link</em>'.
	 * @generated
	 */
	RealizationLink createRealizationLink();

	/**
	 * Returns a new object of class '<em>Reference</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	Reference createReference();

	/**
	 * Returns a new object of class '<em>Requirement</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Requirement</em>'.
	 * @generated
	 */
	Requirement createRequirement();

	/**
	 * Returns a new object of class '<em>Requirement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Expression</em>'.
	 * @generated
	 */
	RequirementExpression createRequirementExpression();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Software Component</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Software Component</em>'.
	 * @generated
	 */
	SoftwareComponent createSoftwareComponent();

	/**
	 * Returns a new object of class '<em>Stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype</em>'.
	 * @generated
	 */
	Stereotype createStereotype();

	/**
	 * Returns a new object of class '<em>Topology</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Topology</em>'.
	 * @generated
	 */
	Topology createTopology();

	/**
	 * Returns a new object of class '<em>Unit</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Unit</em>'.
	 * @generated
	 */
	Unit createUnit();

	/**
	 * Returns a new object of class '<em>Unit Link</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Unit Link</em>'.
	 * @generated
	 */
	UnitLink createUnitLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

} //CoreFactory
