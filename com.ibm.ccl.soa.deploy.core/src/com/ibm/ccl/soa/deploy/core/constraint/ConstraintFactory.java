/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage
 * @generated
 */
public interface ConstraintFactory extends EFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ConstraintFactory eINSTANCE = com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>And Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>And Constraint</em>'.
	 * @generated
	 */
	AndConstraint createAndConstraint();

	/**
	 * Returns a new object of class '<em>Application Communication Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Application Communication Constraint</em>'.
	 * @generated
	 */
	ApplicationCommunicationConstraint createApplicationCommunicationConstraint();

	/**
	 * Returns a new object of class '<em>Application Communication Protocol Constraint</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Application Communication Protocol Constraint</em>'.
	 * @generated
	 */
	ApplicationCommunicationProtocolConstraint createApplicationCommunicationProtocolConstraint();

	/**
	 * Returns a new object of class '<em>Attribute Capacity Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Capacity Constraint</em>'.
	 * @generated
	 */
	AttributeCapacityConstraint createAttributeCapacityConstraint();

	/**
	 * Returns a new object of class '<em>Attribute Defined Constraint</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Defined Constraint</em>'.
	 * @generated
	 */
	AttributeDefinedConstraint createAttributeDefinedConstraint();

	/**
	 * Returns a new object of class '<em>Attribute Propagation Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Propagation Constraint</em>'.
	 * @generated
	 */
	AttributePropagationConstraint createAttributePropagationConstraint();

	/**
	 * Returns a new object of class '<em>Base Communication Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Base Communication Constraint</em>'.
	 * @generated
	 */
	BaseCommunicationConstraint createBaseCommunicationConstraint();

	/**
	 * Returns a new object of class '<em>Capacity Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Capacity Constraint</em>'.
	 * @generated
	 */
	CapacityConstraint createCapacityConstraint();

	/**
	 * Returns a new object of class '<em>Collocation Constraint</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collocation Constraint</em>'.
	 * @generated
	 */
	CollocationConstraint createCollocationConstraint();

	/**
	 * Returns a new object of class '<em>Communication Bandwidth Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Bandwidth Constraint</em>'.
	 * @generated
	 */
	CommunicationBandwidthConstraint createCommunicationBandwidthConstraint();

	/**
	 * Returns a new object of class '<em>Communication Cost Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Cost Constraint</em>'.
	 * @generated
	 */
	CommunicationCostConstraint createCommunicationCostConstraint();

	/**
	 * Returns a new object of class '<em>Communication Port Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Port Constraint</em>'.
	 * @generated
	 */
	CommunicationPortConstraint createCommunicationPortConstraint();

	/**
	 * Returns a new object of class '<em>Communication Redundancy Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Redundancy Constraint</em>'.
	 * @generated
	 */
	CommunicationRedundancyConstraint createCommunicationRedundancyConstraint();

	/**
	 * Returns a new object of class '<em>Communication Type Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Communication Type Constraint</em>'.
	 * @generated
	 */
	CommunicationTypeConstraint createCommunicationTypeConstraint();

	/**
	 * Returns a new object of class '<em>Root</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	ConstraintRoot createConstraintRoot();

	/**
	 * Returns a new object of class '<em>Deferred Hosting Constraint</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Deferred Hosting Constraint</em>'.
	 * @generated
	 */
	DeferredHostingConstraint createDeferredHostingConstraint();

	/**
	 * Returns a new object of class '<em>Enumeration Constraint</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enumeration Constraint</em>'.
	 * @generated
	 */
	EnumerationConstraint createEnumerationConstraint();

	/**
	 * Returns a new object of class '<em>Equals Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Equals Constraint</em>'.
	 * @generated
	 */
	EqualsConstraint createEqualsConstraint();

	/**
	 * Returns a new object of class '<em>Exclusion Constraint</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Exclusion Constraint</em>'.
	 * @generated
	 */
	ExclusionConstraint createExclusionConstraint();

	/**
	 * Returns a new object of class '<em>Group Cardinality Constraint</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Group Cardinality Constraint</em>'.
	 * @generated
	 */
	GroupCardinalityConstraint createGroupCardinalityConstraint();

	/**
	 * Returns a new object of class '<em>Member Cardinality Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Member Cardinality Constraint</em>'.
	 * @generated
	 */
	MemberCardinalityConstraint createMemberCardinalityConstraint();

	/**
	 * Returns a new object of class '<em>Network Communication Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Network Communication Constraint</em>'.
	 * @generated
	 */
	NetworkCommunicationConstraint createNetworkCommunicationConstraint();

	/**
	 * Returns a new object of class '<em>Not Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Not Constraint</em>'.
	 * @generated
	 */
	NotConstraint createNotConstraint();

	/**
	 * Returns a new object of class '<em>Or Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Or Constraint</em>'.
	 * @generated
	 */
	OrConstraint createOrConstraint();

	/**
	 * Returns a new object of class '<em>Palette Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Palette Constraint</em>'.
	 * @generated
	 */
	PaletteConstraint createPaletteConstraint();

	/**
	 * Returns a new object of class '<em>Product Identifier Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Product Identifier Constraint</em>'.
	 * @generated
	 */
	ProductIdentifierConstraint createProductIdentifierConstraint();

	/**
	 * Returns a new object of class '<em>Range Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Range Constraint</em>'.
	 * @generated
	 */
	RangeConstraint createRangeConstraint();

	/**
	 * Returns a new object of class '<em>Realization Constraint</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Realization Constraint</em>'.
	 * @generated
	 */
	RealizationConstraint createRealizationConstraint();

	/**
	 * Returns a new object of class '<em>Single Value</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Single Value</em>'.
	 * @generated
	 */
	SingleValue createSingleValue();

	/**
	 * Returns a new object of class '<em>Stereotype Constraint</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotype Constraint</em>'.
	 * @generated
	 */
	StereotypeConstraint createStereotypeConstraint();

	/**
	 * Returns a new object of class '<em>Synchronous Communication Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Synchronous Communication Constraint</em>'.
	 * @generated
	 */
	SynchronousCommunicationConstraint createSynchronousCommunicationConstraint();

	/**
	 * Returns a new object of class '<em>Transmission Delay Constraint</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Transmission Delay Constraint</em>'.
	 * @generated
	 */
	TransmissionDelayConstraint createTransmissionDelayConstraint();

	/**
	 * Returns a new object of class '<em>Type Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Type Constraint</em>'.
	 * @generated
	 */
	TypeConstraint createTypeConstraint();

	/**
	 * Returns a new object of class '<em>Version Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Version Constraint</em>'.
	 * @generated
	 */
	VersionConstraint createVersionConstraint();

	/**
	 * Returns a new object of class '<em>Xor Constraint</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Xor Constraint</em>'.
	 * @generated
	 */
	XorConstraint createXorConstraint();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConstraintPackage getConstraintPackage();

} //ConstraintFactory
